package com.doublechaintech.retailscm.meta;

import com.terapico.meta.MetaProvider;
import com.terapico.meta.EntityMeta;
import org.springframework.beans.factory.InitializingBean;

public class MetaRegistry implements InitializingBean {
  @Override
  public void afterPropertiesSet() throws Exception {
    registerRetailStoreCountryCenter();
    registerCatalog();
    registerLevelOneCategory();
    registerLevelTwoCategory();
    registerLevelThreeCategory();
    registerProduct();
    registerSku();
    registerRetailStoreProvinceCenter();
    registerProvinceCenterDepartment();
    registerProvinceCenterEmployee();
    registerRetailStoreCityServiceCenter();
    registerCityPartner();
    registerPotentialCustomer();
    registerPotentialCustomerContactPerson();
    registerPotentialCustomerContact();
    registerCityEvent();
    registerEventAttendance();
    registerRetailStore();
    registerRetailStoreCreation();
    registerRetailStoreInvestmentInvitation();
    registerRetailStoreFranchising();
    registerRetailStoreDecoration();
    registerRetailStoreOpening();
    registerRetailStoreClosing();
    registerRetailStoreMember();
    registerConsumerOrder();
    registerConsumerOrderLineItem();
    registerConsumerOrderShippingGroup();
    registerConsumerOrderPaymentGroup();
    registerConsumerOrderPriceAdjustment();
    registerRetailStoreMemberCoupon();
    registerMemberWishlist();
    registerMemberRewardPoint();
    registerMemberRewardPointRedemption();
    registerMemberWishlistProduct();
    registerRetailStoreMemberAddress();
    registerRetailStoreMemberGiftCard();
    registerRetailStoreMemberGiftCardConsumeRecord();
    registerGoodsSupplier();
    registerSupplierProduct();
    registerProductSupplyDuration();
    registerSupplyOrder();
    registerSupplyOrderLineItem();
    registerSupplyOrderShippingGroup();
    registerSupplyOrderPaymentGroup();
    registerRetailStoreOrder();
    registerRetailStoreOrderLineItem();
    registerRetailStoreOrderShippingGroup();
    registerRetailStoreOrderPaymentGroup();
    registerWarehouse();
    registerStorageSpace();
    registerSmartPallet();
    registerGoodsShelf();
    registerGoodsShelfStockCount();
    registerStockCountIssueTrack();
    registerGoodsAllocation();
    registerGoods();
    registerGoodsMovement();
    registerSupplierSpace();
    registerReceivingSpace();
    registerShippingSpace();
    registerDamageSpace();
    registerWarehouseAsset();
    registerTransportFleet();
    registerTransportTruck();
    registerTruckDriver();
    registerTransportTask();
    registerTransportTaskTrack();
    registerAccountSet();
    registerAccountingSubject();
    registerAccountingPeriod();
    registerAccountingDocumentType();
    registerAccountingDocument();
    registerOriginalVoucher();
    registerAccountingDocumentLine();
    registerLevelOneDepartment();
    registerLevelTwoDepartment();
    registerLevelThreeDepartment();
    registerSkillType();
    registerResponsibilityType();
    registerTerminationReason();
    registerTerminationType();
    registerOccupationType();
    registerLeaveType();
    registerSalaryGrade();
    registerInterviewType();
    registerTrainingCourseType();
    registerPublicHoliday();
    registerTermination();
    registerView();
    registerEmployee();
    registerInstructor();
    registerCompanyTraining();
    registerScoring();
    registerEmployeeCompanyTraining();
    registerEmployeeSkill();
    registerEmployeePerformance();
    registerEmployeeWorkExperience();
    registerEmployeeLeave();
    registerEmployeeInterview();
    registerEmployeeAttendance();
    registerEmployeeQualifier();
    registerEmployeeEducation();
    registerEmployeeAward();
    registerEmployeeSalarySheet();
    registerPayingOff();
    registerMobileApp();
    registerPage();
    registerPageType();
    registerSlide();
    registerUiAction();
    registerSection();
    registerUserDomain();
    registerUserAllowList();
    registerSecUser();
    registerUserApp();
    registerQuickLink();
    registerListAccess();
    registerLoginHistory();
    registerCandidateContainer();
    registerCandidateElement();
    registerWechatWorkappIdentity();
    registerWechatMiniappIdentity();
    registerKeyPairIdentity();
    registerPublicKeyType();
    registerTreeNode();
  }

  public void registerRetailStoreCountryCenter() {
    EntityMeta retailStoreCountryCenter =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter")
            .with("features", "root,visible_all");
    retailStoreCountryCenter.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreCountryCenter
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    retailStoreCountryCenter
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreCountryCenter
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreCountryCenter
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreCountryCenter
        .property("serviceNumber")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreCountryCenter
        .property("serviceNumber")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreCountryCenter
        .property("founded")
        .with("java_type", "java.util.Date")
        .with("parent", "date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    retailStoreCountryCenter
        .property("founded")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreCountryCenter
        .property("webSite")
        .with("parent", "string")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreCountryCenter
        .property("webSite")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreCountryCenter
        .property("address")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreCountryCenter
        .property("address")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreCountryCenter
        .property("operatedBy")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreCountryCenter
        .property("operatedBy")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreCountryCenter
        .property("legalRepresentative")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreCountryCenter
        .property("legalRepresentative")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreCountryCenter
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreCountryCenter
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreCountryCenter
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    retailStoreCountryCenter
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerCatalog() {
    EntityMeta catalog =
        MetaProvider.entity("com.doublechaintech.retailscm.catalog.Catalog")
            .with("features", "root,visible_all")
            .with("vg4owner", "产品管理");
    catalog.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    catalog
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    catalog
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    catalog
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    catalog
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    catalog.property("owner").with("features", "root,visible_all");

    catalog
        .property("owner")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    catalog
        .property("owner")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    catalog
        .property("subCount")
        .with("parent", "number")
        .with("editor", "numbereditor")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,int");

    catalog
        .property("subCount")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,INT,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    catalog
        .property("amount")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    catalog
        .property("amount")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    catalog
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    catalog
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerLevelOneCategory() {
    EntityMeta levelOneCategory =
        MetaProvider.entity("com.doublechaintech.retailscm.levelonecategory.LevelOneCategory")
            .with("features", "root,visible_all");
    levelOneCategory.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelOneCategory
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    levelOneCategory
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelOneCategory
        .property("catalog")
        .with("features", "root,visible_all")
        .with("vg4owner", "产品管理");

    levelOneCategory
        .property("catalog")
        .with("parentType", "com.doublechaintech.retailscm.catalog.Catalog");

    levelOneCategory
        .property("catalog")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelOneCategory
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    levelOneCategory
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelOneCategory
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    levelOneCategory
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerLevelTwoCategory() {
    EntityMeta levelTwoCategory =
        MetaProvider.entity("com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory")
            .with("features", "root,visible_all");
    levelTwoCategory.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelTwoCategory
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    levelTwoCategory
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelTwoCategory.property("parentCategory").with("features", "root,visible_all");

    levelTwoCategory
        .property("parentCategory")
        .with("parentType", "com.doublechaintech.retailscm.levelonecategory.LevelOneCategory");

    levelTwoCategory
        .property("parentCategory")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelTwoCategory
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    levelTwoCategory
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelTwoCategory
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    levelTwoCategory
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerLevelThreeCategory() {
    EntityMeta levelThreeCategory =
        MetaProvider.entity("com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory")
            .with("features", "root,visible_all");
    levelThreeCategory.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelThreeCategory
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    levelThreeCategory
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelThreeCategory.property("parentCategory").with("features", "root,visible_all");

    levelThreeCategory
        .property("parentCategory")
        .with("parentType", "com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory");

    levelThreeCategory
        .property("parentCategory")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelThreeCategory
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    levelThreeCategory
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelThreeCategory
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    levelThreeCategory
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerProduct() {
    EntityMeta product =
        MetaProvider.entity("com.doublechaintech.retailscm.product.Product")
            .with("features", "root,visible_all");
    product.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    product
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    product
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    product
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    product
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    product.property("parentCategory").with("features", "root,visible_all");

    product
        .property("parentCategory")
        .with("parentType", "com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory");

    product
        .property("parentCategory")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    product
        .property("origin")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    product
        .property("origin")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    product
        .property("remark")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    product
        .property("remark")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    product
        .property("brand")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    product
        .property("brand")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    product
        .property("picture")
        .with("parent", "string")
        .with("editor", "imageeditor")
        .with("features", "root,visible_all,string,attachment,image")
        .with("searcheditor", "defaulteditor");

    product
        .property("picture")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,ATTACHMENT,DELETE,EXCEL_VIEW,IMAGE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    product
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    product
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    product
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    product
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerSku() {
    EntityMeta sku =
        MetaProvider.entity("com.doublechaintech.retailscm.sku.Sku")
            .with("features", "root,visible_all");
    sku.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    sku.property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    sku.property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    sku.property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    sku.property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    sku.property("size")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    sku.property("size")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    sku.property("product").with("features", "root,visible_all");

    sku.property("product").with("parentType", "com.doublechaintech.retailscm.product.Product");

    sku.property("product")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    sku.property("barcode")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    sku.property("barcode")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    sku.property("packageType")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    sku.property("packageType")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    sku.property("netContent")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    sku.property("netContent")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    sku.property("price")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    sku.property("price")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    sku.property("picture")
        .with("parent", "string")
        .with("editor", "imageeditor")
        .with("features", "root,visible_all,string,attachment,image")
        .with("searcheditor", "defaulteditor");

    sku.property("picture")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,ATTACHMENT,DELETE,EXCEL_VIEW,IMAGE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    sku.property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    sku.property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerRetailStoreProvinceCenter() {
    EntityMeta retailStoreProvinceCenter =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter")
            .with("vg4country", "组织机构")
            .with("features", "root,visible_all");
    retailStoreProvinceCenter.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreProvinceCenter
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    retailStoreProvinceCenter
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreProvinceCenter
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreProvinceCenter
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreProvinceCenter
        .property("founded")
        .with("java_type", "java.util.Date")
        .with("parent", "date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    retailStoreProvinceCenter
        .property("founded")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreProvinceCenter.property("country").with("features", "root,visible_all");

    retailStoreProvinceCenter
        .property("country")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    retailStoreProvinceCenter
        .property("country")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreProvinceCenter
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    retailStoreProvinceCenter
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreProvinceCenter
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    retailStoreProvinceCenter
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerProvinceCenterDepartment() {
    EntityMeta provinceCenterDepartment =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment")
            .with("features", "setting");
    provinceCenterDepartment.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    provinceCenterDepartment
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    provinceCenterDepartment
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    provinceCenterDepartment
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    provinceCenterDepartment
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    provinceCenterDepartment
        .property("founded")
        .with("java_type", "java.util.Date")
        .with("parent", "date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    provinceCenterDepartment
        .property("founded")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    provinceCenterDepartment
        .property("provinceCenter")
        .with("vg4country", "组织机构")
        .with("features", "root,visible_all");

    provinceCenterDepartment
        .property("provinceCenter")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter");

    provinceCenterDepartment
        .property("provinceCenter")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    provinceCenterDepartment
        .property("manager")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    provinceCenterDepartment
        .property("manager")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    provinceCenterDepartment
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    provinceCenterDepartment
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerProvinceCenterEmployee() {
    EntityMeta provinceCenterEmployee =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee")
            .with("features", "root,visible_all");
    provinceCenterEmployee.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    provinceCenterEmployee
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    provinceCenterEmployee
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    provinceCenterEmployee
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    provinceCenterEmployee
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    provinceCenterEmployee
        .property("mobile")
        .with("parent", "string")
        .with("features", "root,visible_all,string,mobile")
        .with("editor", "defaulteditor")
        .with("searcheditor", "defaulteditor");

    provinceCenterEmployee
        .property("mobile")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MOBILE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    provinceCenterEmployee
        .property("email")
        .with("parent", "string")
        .with("editor", "emaileditor")
        .with("features", "root,visible_all,string,email")
        .with("searcheditor", "defaulteditor");

    provinceCenterEmployee
        .property("email")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EMAIL,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    provinceCenterEmployee
        .property("founded")
        .with("java_type", "java.util.Date")
        .with("parent", "date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    provinceCenterEmployee
        .property("founded")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    provinceCenterEmployee.property("department").with("features", "setting");

    provinceCenterEmployee
        .property("department")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment");

    provinceCenterEmployee
        .property("department")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    provinceCenterEmployee
        .property("provinceCenter")
        .with("vg4country", "组织机构")
        .with("features", "root,visible_all");

    provinceCenterEmployee
        .property("provinceCenter")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter");

    provinceCenterEmployee
        .property("provinceCenter")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    provinceCenterEmployee
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    provinceCenterEmployee
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerRetailStoreCityServiceCenter() {
    EntityMeta retailStoreCityServiceCenter =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter")
            .with("features", "root,visible_all");
    retailStoreCityServiceCenter.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreCityServiceCenter
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    retailStoreCityServiceCenter
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreCityServiceCenter
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreCityServiceCenter
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreCityServiceCenter
        .property("founded")
        .with("java_type", "java.util.Date")
        .with("parent", "date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    retailStoreCityServiceCenter
        .property("founded")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreCityServiceCenter
        .property("belongsTo")
        .with("vg4country", "组织机构")
        .with("features", "root,visible_all");

    retailStoreCityServiceCenter
        .property("belongsTo")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter");

    retailStoreCityServiceCenter
        .property("belongsTo")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreCityServiceCenter
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    retailStoreCityServiceCenter
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreCityServiceCenter
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    retailStoreCityServiceCenter
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerCityPartner() {
    EntityMeta cityPartner =
        MetaProvider.entity("com.doublechaintech.retailscm.citypartner.CityPartner")
            .with("features", "root,visible_all");
    cityPartner.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    cityPartner
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    cityPartner
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    cityPartner
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    cityPartner
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    cityPartner
        .property("mobile")
        .with("parent", "string")
        .with("features", "root,visible_all,string,mobile")
        .with("editor", "defaulteditor")
        .with("searcheditor", "defaulteditor");

    cityPartner
        .property("mobile")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MOBILE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    cityPartner.property("cityServiceCenter").with("features", "root,visible_all");

    cityPartner
        .property("cityServiceCenter")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter");

    cityPartner
        .property("cityServiceCenter")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    cityPartner
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    cityPartner
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    cityPartner
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    cityPartner
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    cityPartner
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    cityPartner
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerPotentialCustomer() {
    EntityMeta potentialCustomer =
        MetaProvider.entity("com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer")
            .with("features", "root,visible_all");
    potentialCustomer.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomer
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    potentialCustomer
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomer
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    potentialCustomer
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomer
        .property("mobile")
        .with("parent", "string")
        .with("features", "root,visible_all,string,mobile")
        .with("editor", "defaulteditor")
        .with("searcheditor", "defaulteditor");

    potentialCustomer
        .property("mobile")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MOBILE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomer.property("cityServiceCenter").with("features", "root,visible_all");

    potentialCustomer
        .property("cityServiceCenter")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter");

    potentialCustomer
        .property("cityServiceCenter")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomer.property("cityPartner").with("features", "root,visible_all");

    potentialCustomer
        .property("cityPartner")
        .with("parentType", "com.doublechaintech.retailscm.citypartner.CityPartner");

    potentialCustomer
        .property("cityPartner")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomer
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    potentialCustomer
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomer
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    potentialCustomer
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomer
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    potentialCustomer
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerPotentialCustomerContactPerson() {
    EntityMeta potentialCustomerContactPerson =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson")
            .with("features", "root,visible_all");
    potentialCustomerContactPerson.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomerContactPerson
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    potentialCustomerContactPerson
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomerContactPerson
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    potentialCustomerContactPerson
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomerContactPerson
        .property("mobile")
        .with("parent", "string")
        .with("features", "root,visible_all,string,mobile")
        .with("editor", "defaulteditor")
        .with("searcheditor", "defaulteditor");

    potentialCustomerContactPerson
        .property("mobile")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MOBILE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomerContactPerson
        .property("potentialCustomer")
        .with("features", "root,visible_all");

    potentialCustomerContactPerson
        .property("potentialCustomer")
        .with("parentType", "com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer");

    potentialCustomerContactPerson
        .property("potentialCustomer")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomerContactPerson
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    potentialCustomerContactPerson
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomerContactPerson
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    potentialCustomerContactPerson
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerPotentialCustomerContact() {
    EntityMeta potentialCustomerContact =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact")
            .with("features", "root,visible_all");
    potentialCustomerContact.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomerContact
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    potentialCustomerContact
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomerContact
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    potentialCustomerContact
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomerContact
        .property("contactDate")
        .with("java_type", "java.util.Date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    potentialCustomerContact
        .property("contactDate")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomerContact
        .property("contactMethod")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    potentialCustomerContact
        .property("contactMethod")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomerContact.property("potentialCustomer").with("features", "root,visible_all");

    potentialCustomerContact
        .property("potentialCustomer")
        .with("parentType", "com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer");

    potentialCustomerContact
        .property("potentialCustomer")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomerContact.property("cityPartner").with("features", "root,visible_all");

    potentialCustomerContact
        .property("cityPartner")
        .with("parentType", "com.doublechaintech.retailscm.citypartner.CityPartner");

    potentialCustomerContact
        .property("cityPartner")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomerContact.property("contactTo").with("features", "root,visible_all");

    potentialCustomerContact
        .property("contactTo")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson");

    potentialCustomerContact
        .property("contactTo")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomerContact
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    potentialCustomerContact
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomerContact
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    potentialCustomerContact
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    potentialCustomerContact
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    potentialCustomerContact
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerCityEvent() {
    EntityMeta cityEvent =
        MetaProvider.entity("com.doublechaintech.retailscm.cityevent.CityEvent")
            .with("features", "root,visible_all");
    cityEvent.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    cityEvent
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    cityEvent
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    cityEvent
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    cityEvent
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    cityEvent
        .property("mobile")
        .with("parent", "string")
        .with("features", "root,visible_all,string,mobile")
        .with("editor", "defaulteditor")
        .with("searcheditor", "defaulteditor");

    cityEvent
        .property("mobile")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MOBILE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    cityEvent.property("cityServiceCenter").with("features", "root,visible_all");

    cityEvent
        .property("cityServiceCenter")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter");

    cityEvent
        .property("cityServiceCenter")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    cityEvent
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    cityEvent
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    cityEvent
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    cityEvent
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    cityEvent
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    cityEvent
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerEventAttendance() {
    EntityMeta eventAttendance =
        MetaProvider.entity("com.doublechaintech.retailscm.eventattendance.EventAttendance")
            .with("features", "root,visible_all");
    eventAttendance.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    eventAttendance
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    eventAttendance
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    eventAttendance
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    eventAttendance
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    eventAttendance.property("potentialCustomer").with("features", "root,visible_all");

    eventAttendance
        .property("potentialCustomer")
        .with("parentType", "com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer");

    eventAttendance
        .property("potentialCustomer")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    eventAttendance.property("cityEvent").with("features", "root,visible_all");

    eventAttendance
        .property("cityEvent")
        .with("parentType", "com.doublechaintech.retailscm.cityevent.CityEvent");

    eventAttendance
        .property("cityEvent")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    eventAttendance
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    eventAttendance
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    eventAttendance
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    eventAttendance
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerRetailStore() {
    EntityMeta retailStore =
        MetaProvider.entity("com.doublechaintech.retailscm.retailstore.RetailStore")
            .with("vg4retail_store_country_center", "加盟管理")
            .with("features", "root,visible_all");
    retailStore.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStore
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    retailStore
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStore
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStore
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStore
        .property("telephone")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStore
        .property("telephone")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStore
        .property("owner")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStore
        .property("owner")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStore.property("retailStoreCountryCenter").with("features", "root,visible_all");

    retailStore
        .property("retailStoreCountryCenter")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    retailStore
        .property("retailStoreCountryCenter")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStore.property("cityServiceCenter").with("features", "root,visible_all");

    retailStore
        .property("cityServiceCenter")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter");

    retailStore
        .property("cityServiceCenter")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStore.property("creation").with("features", "root,visible_all");

    retailStore
        .property("creation")
        .with(
            "parentType", "com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation");

    retailStore
        .property("creation")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStore.property("investmentInvitation").with("features", "root,visible_all");

    retailStore
        .property("investmentInvitation")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation");

    retailStore
        .property("investmentInvitation")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStore.property("franchising").with("features", "root,visible_all");

    retailStore
        .property("franchising")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising");

    retailStore
        .property("franchising")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStore.property("decoration").with("features", "root,visible_all");

    retailStore
        .property("decoration")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration");

    retailStore
        .property("decoration")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStore.property("opening").with("features", "root,visible_all");

    retailStore
        .property("opening")
        .with("parentType", "com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening");

    retailStore
        .property("opening")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStore.property("closing").with("features", "root,visible_all");

    retailStore
        .property("closing")
        .with("parentType", "com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing");

    retailStore
        .property("closing")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStore
        .property("founded")
        .with("java_type", "java.util.Date")
        .with("parent", "date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    retailStore
        .property("founded")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStore
        .property("latitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    retailStore
        .property("latitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStore
        .property("longitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    retailStore
        .property("longitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStore
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStore
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStore
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    retailStore
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStore
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    retailStore
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerRetailStoreCreation() {
    EntityMeta retailStoreCreation =
        MetaProvider.entity("com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation")
            .with("features", "root,visible_all");
    retailStoreCreation.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreCreation
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    retailStoreCreation
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreCreation
        .property("comment")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreCreation
        .property("comment")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreCreation
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    retailStoreCreation
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerRetailStoreInvestmentInvitation() {
    EntityMeta retailStoreInvestmentInvitation =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation")
            .with("features", "root,visible_all");
    retailStoreInvestmentInvitation.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreInvestmentInvitation
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    retailStoreInvestmentInvitation
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreInvestmentInvitation
        .property("comment")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreInvestmentInvitation
        .property("comment")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreInvestmentInvitation
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    retailStoreInvestmentInvitation
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerRetailStoreFranchising() {
    EntityMeta retailStoreFranchising =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising")
            .with("features", "root,visible_all");
    retailStoreFranchising.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreFranchising
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    retailStoreFranchising
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreFranchising
        .property("comment")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreFranchising
        .property("comment")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreFranchising
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    retailStoreFranchising
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerRetailStoreDecoration() {
    EntityMeta retailStoreDecoration =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration")
            .with("features", "root,visible_all");
    retailStoreDecoration.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreDecoration
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    retailStoreDecoration
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreDecoration
        .property("comment")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreDecoration
        .property("comment")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreDecoration
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    retailStoreDecoration
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerRetailStoreOpening() {
    EntityMeta retailStoreOpening =
        MetaProvider.entity("com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening")
            .with("features", "root,visible_all");
    retailStoreOpening.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOpening
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    retailStoreOpening
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOpening
        .property("comment")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreOpening
        .property("comment")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOpening
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    retailStoreOpening
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerRetailStoreClosing() {
    EntityMeta retailStoreClosing =
        MetaProvider.entity("com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing")
            .with("features", "root,visible_all");
    retailStoreClosing.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreClosing
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    retailStoreClosing
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreClosing
        .property("comment")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreClosing
        .property("comment")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreClosing
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    retailStoreClosing
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerRetailStoreMember() {
    EntityMeta retailStoreMember =
        MetaProvider.entity("com.doublechaintech.retailscm.retailstoremember.RetailStoreMember")
            .with("features", "root,visible_all")
            .with("vg4owner", "会员管理");
    retailStoreMember.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMember
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    retailStoreMember
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMember
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreMember
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMember
        .property("mobilePhone")
        .with("parent", "string")
        .with("features", "root,visible_all,string,mobile")
        .with("editor", "defaulteditor")
        .with("searcheditor", "defaulteditor");

    retailStoreMember
        .property("mobilePhone")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MOBILE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMember.property("owner").with("features", "root,visible_all");

    retailStoreMember
        .property("owner")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    retailStoreMember
        .property("owner")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMember
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    retailStoreMember
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerConsumerOrder() {
    EntityMeta consumerOrder =
        MetaProvider.entity("com.doublechaintech.retailscm.consumerorder.ConsumerOrder")
            .with("features", "root,visible_all");
    consumerOrder.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrder
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    consumerOrder
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrder
        .property("title")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    consumerOrder
        .property("title")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrder
        .property("consumer")
        .with("features", "root,visible_all")
        .with("vg4owner", "会员管理");

    consumerOrder
        .property("consumer")
        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");

    consumerOrder
        .property("consumer")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrder
        .property("store")
        .with("vg4retail_store_country_center", "加盟管理")
        .with("features", "root,visible_all");

    consumerOrder
        .property("store")
        .with("parentType", "com.doublechaintech.retailscm.retailstore.RetailStore");

    consumerOrder
        .property("store")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrder
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    consumerOrder
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrder
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    consumerOrder
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerConsumerOrderLineItem() {
    EntityMeta consumerOrderLineItem =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItem")
            .with("features", "root,visible_all");
    consumerOrderLineItem.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderLineItem
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    consumerOrderLineItem
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderLineItem.property("bizOrder").with("features", "root,visible_all");

    consumerOrderLineItem
        .property("bizOrder")
        .with("parentType", "com.doublechaintech.retailscm.consumerorder.ConsumerOrder");

    consumerOrderLineItem
        .property("bizOrder")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderLineItem
        .property("skuId")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    consumerOrderLineItem
        .property("skuId")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderLineItem
        .property("skuName")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    consumerOrderLineItem
        .property("skuName")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderLineItem
        .property("price")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    consumerOrderLineItem
        .property("price")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderLineItem
        .property("quantity")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    consumerOrderLineItem
        .property("quantity")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderLineItem
        .property("amount")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    consumerOrderLineItem
        .property("amount")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderLineItem
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    consumerOrderLineItem
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderLineItem
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    consumerOrderLineItem
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerConsumerOrderShippingGroup() {
    EntityMeta consumerOrderShippingGroup =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup")
            .with("features", "root,visible_all");
    consumerOrderShippingGroup.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderShippingGroup
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    consumerOrderShippingGroup
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderShippingGroup
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    consumerOrderShippingGroup
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderShippingGroup.property("bizOrder").with("features", "root,visible_all");

    consumerOrderShippingGroup
        .property("bizOrder")
        .with("parentType", "com.doublechaintech.retailscm.consumerorder.ConsumerOrder");

    consumerOrderShippingGroup
        .property("bizOrder")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderShippingGroup
        .property("amount")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    consumerOrderShippingGroup
        .property("amount")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderShippingGroup
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    consumerOrderShippingGroup
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerConsumerOrderPaymentGroup() {
    EntityMeta consumerOrderPaymentGroup =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup")
            .with("features", "root,visible_all");
    consumerOrderPaymentGroup.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderPaymentGroup
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    consumerOrderPaymentGroup
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderPaymentGroup
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    consumerOrderPaymentGroup
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderPaymentGroup.property("bizOrder").with("features", "root,visible_all");

    consumerOrderPaymentGroup
        .property("bizOrder")
        .with("parentType", "com.doublechaintech.retailscm.consumerorder.ConsumerOrder");

    consumerOrderPaymentGroup
        .property("bizOrder")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderPaymentGroup
        .property("cardNumber")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    consumerOrderPaymentGroup
        .property("cardNumber")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderPaymentGroup
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    consumerOrderPaymentGroup
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerConsumerOrderPriceAdjustment() {
    EntityMeta consumerOrderPriceAdjustment =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment")
            .with("features", "root,visible_all");
    consumerOrderPriceAdjustment.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderPriceAdjustment
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    consumerOrderPriceAdjustment
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderPriceAdjustment
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    consumerOrderPriceAdjustment
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderPriceAdjustment.property("bizOrder").with("features", "root,visible_all");

    consumerOrderPriceAdjustment
        .property("bizOrder")
        .with("parentType", "com.doublechaintech.retailscm.consumerorder.ConsumerOrder");

    consumerOrderPriceAdjustment
        .property("bizOrder")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderPriceAdjustment
        .property("amount")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    consumerOrderPriceAdjustment
        .property("amount")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderPriceAdjustment
        .property("provider")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    consumerOrderPriceAdjustment
        .property("provider")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    consumerOrderPriceAdjustment
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    consumerOrderPriceAdjustment
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerRetailStoreMemberCoupon() {
    EntityMeta retailStoreMemberCoupon =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon")
            .with("features", "root,visible_all");
    retailStoreMemberCoupon.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberCoupon
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    retailStoreMemberCoupon
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberCoupon
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreMemberCoupon
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberCoupon
        .property("owner")
        .with("features", "root,visible_all")
        .with("vg4owner", "会员管理");

    retailStoreMemberCoupon
        .property("owner")
        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");

    retailStoreMemberCoupon
        .property("owner")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberCoupon
        .property("number")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreMemberCoupon
        .property("number")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberCoupon
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    retailStoreMemberCoupon
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberCoupon
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    retailStoreMemberCoupon
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerMemberWishlist() {
    EntityMeta memberWishlist =
        MetaProvider.entity("com.doublechaintech.retailscm.memberwishlist.MemberWishlist")
            .with("features", "root,visible_all");
    memberWishlist.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    memberWishlist
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    memberWishlist
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    memberWishlist
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    memberWishlist
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    memberWishlist.property("owner").with("features", "root,visible_all").with("vg4owner", "会员管理");

    memberWishlist
        .property("owner")
        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");

    memberWishlist
        .property("owner")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    memberWishlist
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    memberWishlist
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerMemberRewardPoint() {
    EntityMeta memberRewardPoint =
        MetaProvider.entity("com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPoint")
            .with("features", "root,visible_all");
    memberRewardPoint.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    memberRewardPoint
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    memberRewardPoint
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    memberRewardPoint
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    memberRewardPoint
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    memberRewardPoint
        .property("point")
        .with("parent", "number")
        .with("editor", "numbereditor")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,int");

    memberRewardPoint
        .property("point")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,INT,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    memberRewardPoint
        .property("owner")
        .with("features", "root,visible_all")
        .with("vg4owner", "会员管理");

    memberRewardPoint
        .property("owner")
        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");

    memberRewardPoint
        .property("owner")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    memberRewardPoint
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    memberRewardPoint
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerMemberRewardPointRedemption() {
    EntityMeta memberRewardPointRedemption =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemption")
            .with("features", "root,visible_all");
    memberRewardPointRedemption.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    memberRewardPointRedemption
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    memberRewardPointRedemption
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    memberRewardPointRedemption
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    memberRewardPointRedemption
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    memberRewardPointRedemption
        .property("point")
        .with("parent", "number")
        .with("editor", "numbereditor")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,int");

    memberRewardPointRedemption
        .property("point")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,INT,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    memberRewardPointRedemption
        .property("owner")
        .with("features", "root,visible_all")
        .with("vg4owner", "会员管理");

    memberRewardPointRedemption
        .property("owner")
        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");

    memberRewardPointRedemption
        .property("owner")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    memberRewardPointRedemption
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    memberRewardPointRedemption
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerMemberWishlistProduct() {
    EntityMeta memberWishlistProduct =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProduct")
            .with("features", "root,visible_all");
    memberWishlistProduct.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    memberWishlistProduct
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    memberWishlistProduct
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    memberWishlistProduct
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    memberWishlistProduct
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    memberWishlistProduct.property("owner").with("features", "root,visible_all");

    memberWishlistProduct
        .property("owner")
        .with("parentType", "com.doublechaintech.retailscm.memberwishlist.MemberWishlist");

    memberWishlistProduct
        .property("owner")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    memberWishlistProduct
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    memberWishlistProduct
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerRetailStoreMemberAddress() {
    EntityMeta retailStoreMemberAddress =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddress")
            .with("features", "root,visible_all");
    retailStoreMemberAddress.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberAddress
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    retailStoreMemberAddress
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberAddress
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreMemberAddress
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberAddress
        .property("owner")
        .with("features", "root,visible_all")
        .with("vg4owner", "会员管理");

    retailStoreMemberAddress
        .property("owner")
        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");

    retailStoreMemberAddress
        .property("owner")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberAddress
        .property("mobilePhone")
        .with("parent", "string")
        .with("features", "root,visible_all,string,mobile")
        .with("editor", "defaulteditor")
        .with("searcheditor", "defaulteditor");

    retailStoreMemberAddress
        .property("mobilePhone")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MOBILE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberAddress
        .property("address")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreMemberAddress
        .property("address")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberAddress
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    retailStoreMemberAddress
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerRetailStoreMemberGiftCard() {
    EntityMeta retailStoreMemberGiftCard =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard")
            .with("features", "root,visible_all");
    retailStoreMemberGiftCard.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberGiftCard
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    retailStoreMemberGiftCard
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberGiftCard
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreMemberGiftCard
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberGiftCard
        .property("owner")
        .with("features", "root,visible_all")
        .with("vg4owner", "会员管理");

    retailStoreMemberGiftCard
        .property("owner")
        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");

    retailStoreMemberGiftCard
        .property("owner")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberGiftCard
        .property("number")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreMemberGiftCard
        .property("number")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberGiftCard
        .property("remain")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    retailStoreMemberGiftCard
        .property("remain")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberGiftCard
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    retailStoreMemberGiftCard
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerRetailStoreMemberGiftCardConsumeRecord() {
    EntityMeta retailStoreMemberGiftCardConsumeRecord =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord")
            .with("features", "root,visible_all");
    retailStoreMemberGiftCardConsumeRecord.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberGiftCardConsumeRecord
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    retailStoreMemberGiftCardConsumeRecord
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberGiftCardConsumeRecord
        .property("occureTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    retailStoreMemberGiftCardConsumeRecord
        .property("occureTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberGiftCardConsumeRecord.property("owner").with("features", "root,visible_all");

    retailStoreMemberGiftCardConsumeRecord
        .property("owner")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard");

    retailStoreMemberGiftCardConsumeRecord
        .property("owner")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberGiftCardConsumeRecord
        .property("bizOrder")
        .with("features", "root,visible_all");

    retailStoreMemberGiftCardConsumeRecord
        .property("bizOrder")
        .with("parentType", "com.doublechaintech.retailscm.consumerorder.ConsumerOrder");

    retailStoreMemberGiftCardConsumeRecord
        .property("bizOrder")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberGiftCardConsumeRecord
        .property("number")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreMemberGiftCardConsumeRecord
        .property("number")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberGiftCardConsumeRecord
        .property("amount")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    retailStoreMemberGiftCardConsumeRecord
        .property("amount")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreMemberGiftCardConsumeRecord
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    retailStoreMemberGiftCardConsumeRecord
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerGoodsSupplier() {
    EntityMeta goodsSupplier =
        MetaProvider.entity("com.doublechaintech.retailscm.goodssupplier.GoodsSupplier")
            .with("features", "root,visible_all")
            .with("vg4belong_to", "供应管理");
    goodsSupplier.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsSupplier
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    goodsSupplier
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsSupplier
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    goodsSupplier
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsSupplier
        .property("supplyProduct")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    goodsSupplier
        .property("supplyProduct")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsSupplier.property("belongTo").with("features", "root,visible_all");

    goodsSupplier
        .property("belongTo")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    goodsSupplier
        .property("belongTo")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsSupplier
        .property("contactNumber")
        .with("parent", "string")
        .with("features", "root,visible_all,string,mobile")
        .with("editor", "defaulteditor")
        .with("searcheditor", "defaulteditor");

    goodsSupplier
        .property("contactNumber")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MOBILE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsSupplier
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    goodsSupplier
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsSupplier
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    goodsSupplier
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsSupplier
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    goodsSupplier
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerSupplierProduct() {
    EntityMeta supplierProduct =
        MetaProvider.entity("com.doublechaintech.retailscm.supplierproduct.SupplierProduct")
            .with("features", "root,visible_all");
    supplierProduct.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplierProduct
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    supplierProduct
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplierProduct
        .property("productName")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    supplierProduct
        .property("productName")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplierProduct
        .property("productDescription")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    supplierProduct
        .property("productDescription")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplierProduct
        .property("productUnit")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    supplierProduct
        .property("productUnit")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplierProduct
        .property("supplier")
        .with("features", "root,visible_all")
        .with("vg4belong_to", "供应管理");

    supplierProduct
        .property("supplier")
        .with("parentType", "com.doublechaintech.retailscm.goodssupplier.GoodsSupplier");

    supplierProduct
        .property("supplier")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplierProduct
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    supplierProduct
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerProductSupplyDuration() {
    EntityMeta productSupplyDuration =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDuration")
            .with("features", "root,visible_all");
    productSupplyDuration.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    productSupplyDuration
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    productSupplyDuration
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    productSupplyDuration
        .property("quantity")
        .with("parent", "number")
        .with("editor", "numbereditor")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,int");

    productSupplyDuration
        .property("quantity")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,INT,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    productSupplyDuration
        .property("duration")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    productSupplyDuration
        .property("duration")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    productSupplyDuration
        .property("price")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    productSupplyDuration
        .property("price")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    productSupplyDuration.property("product").with("features", "root,visible_all");

    productSupplyDuration
        .property("product")
        .with("parentType", "com.doublechaintech.retailscm.supplierproduct.SupplierProduct");

    productSupplyDuration
        .property("product")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    productSupplyDuration
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    productSupplyDuration
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerSupplyOrder() {
    EntityMeta supplyOrder =
        MetaProvider.entity("com.doublechaintech.retailscm.supplyorder.SupplyOrder")
            .with("vg4buyer", "供应管理")
            .with("features", "root,visible_all");
    supplyOrder.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrder
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    supplyOrder
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrder.property("buyer").with("features", "root,visible_all");

    supplyOrder
        .property("buyer")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    supplyOrder
        .property("buyer")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrder
        .property("seller")
        .with("features", "root,visible_all")
        .with("vg4belong_to", "供应管理");

    supplyOrder
        .property("seller")
        .with("parentType", "com.doublechaintech.retailscm.goodssupplier.GoodsSupplier");

    supplyOrder
        .property("seller")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrder
        .property("title")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "标题");

    supplyOrder
        .property("title")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrder
        .property("contract")
        .with("parent", "string")
        .with("editor", "documentditor")
        .with("features", "root,visible_all,string,attachment")
        .with("searcheditor", "defaulteditor");

    supplyOrder
        .property("contract")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,ATTACHMENT,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrder
        .property("totalAmount")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    supplyOrder
        .property("totalAmount")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrder
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    supplyOrder
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrder
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    supplyOrder
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerSupplyOrderLineItem() {
    EntityMeta supplyOrderLineItem =
        MetaProvider.entity("com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItem")
            .with("features", "root,visible_all");
    supplyOrderLineItem.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrderLineItem
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    supplyOrderLineItem
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrderLineItem
        .property("bizOrder")
        .with("vg4buyer", "供应管理")
        .with("features", "root,visible_all");

    supplyOrderLineItem
        .property("bizOrder")
        .with("parentType", "com.doublechaintech.retailscm.supplyorder.SupplyOrder");

    supplyOrderLineItem
        .property("bizOrder")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrderLineItem
        .property("skuId")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    supplyOrderLineItem
        .property("skuId")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrderLineItem
        .property("skuName")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    supplyOrderLineItem
        .property("skuName")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrderLineItem
        .property("amount")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    supplyOrderLineItem
        .property("amount")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrderLineItem
        .property("quantity")
        .with("parent", "number")
        .with("editor", "numbereditor")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,int");

    supplyOrderLineItem
        .property("quantity")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,INT,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrderLineItem
        .property("unitOfMeasurement")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    supplyOrderLineItem
        .property("unitOfMeasurement")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrderLineItem
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    supplyOrderLineItem
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerSupplyOrderShippingGroup() {
    EntityMeta supplyOrderShippingGroup =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup")
            .with("features", "root,visible_all");
    supplyOrderShippingGroup.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrderShippingGroup
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    supplyOrderShippingGroup
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrderShippingGroup
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    supplyOrderShippingGroup
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrderShippingGroup
        .property("bizOrder")
        .with("vg4buyer", "供应管理")
        .with("features", "root,visible_all");

    supplyOrderShippingGroup
        .property("bizOrder")
        .with("parentType", "com.doublechaintech.retailscm.supplyorder.SupplyOrder");

    supplyOrderShippingGroup
        .property("bizOrder")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrderShippingGroup
        .property("amount")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    supplyOrderShippingGroup
        .property("amount")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrderShippingGroup
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    supplyOrderShippingGroup
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerSupplyOrderPaymentGroup() {
    EntityMeta supplyOrderPaymentGroup =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup")
            .with("features", "root,visible_all");
    supplyOrderPaymentGroup.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrderPaymentGroup
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    supplyOrderPaymentGroup
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrderPaymentGroup
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    supplyOrderPaymentGroup
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrderPaymentGroup
        .property("bizOrder")
        .with("vg4buyer", "供应管理")
        .with("features", "root,visible_all");

    supplyOrderPaymentGroup
        .property("bizOrder")
        .with("parentType", "com.doublechaintech.retailscm.supplyorder.SupplyOrder");

    supplyOrderPaymentGroup
        .property("bizOrder")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrderPaymentGroup
        .property("cardNumber")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    supplyOrderPaymentGroup
        .property("cardNumber")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplyOrderPaymentGroup
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    supplyOrderPaymentGroup
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerRetailStoreOrder() {
    EntityMeta retailStoreOrder =
        MetaProvider.entity("com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder")
            .with("features", "root,visible_all")
            .with("vg4seller", "销售管理");
    retailStoreOrder.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrder
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    retailStoreOrder
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrder
        .property("buyer")
        .with("vg4retail_store_country_center", "加盟管理")
        .with("features", "root,visible_all");

    retailStoreOrder
        .property("buyer")
        .with("parentType", "com.doublechaintech.retailscm.retailstore.RetailStore");

    retailStoreOrder
        .property("buyer")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrder.property("seller").with("features", "root,visible_all");

    retailStoreOrder
        .property("seller")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    retailStoreOrder
        .property("seller")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrder
        .property("title")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreOrder
        .property("title")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrder
        .property("totalAmount")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    retailStoreOrder
        .property("totalAmount")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrder
        .property("contract")
        .with("parent", "string")
        .with("editor", "documentditor")
        .with("features", "root,visible_all,string,attachment")
        .with("searcheditor", "defaulteditor");

    retailStoreOrder
        .property("contract")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,ATTACHMENT,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrder
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    retailStoreOrder
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrder
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    retailStoreOrder
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerRetailStoreOrderLineItem() {
    EntityMeta retailStoreOrderLineItem =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem")
            .with("features", "root,visible_all");
    retailStoreOrderLineItem.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrderLineItem
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    retailStoreOrderLineItem
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrderLineItem
        .property("bizOrder")
        .with("features", "root,visible_all")
        .with("vg4seller", "销售管理");

    retailStoreOrderLineItem
        .property("bizOrder")
        .with("parentType", "com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder");

    retailStoreOrderLineItem
        .property("bizOrder")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrderLineItem
        .property("skuId")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreOrderLineItem
        .property("skuId")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrderLineItem
        .property("skuName")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreOrderLineItem
        .property("skuName")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrderLineItem
        .property("amount")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    retailStoreOrderLineItem
        .property("amount")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrderLineItem
        .property("quantity")
        .with("parent", "number")
        .with("editor", "numbereditor")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,int");

    retailStoreOrderLineItem
        .property("quantity")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,INT,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrderLineItem
        .property("unitOfMeasurement")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreOrderLineItem
        .property("unitOfMeasurement")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrderLineItem
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    retailStoreOrderLineItem
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerRetailStoreOrderShippingGroup() {
    EntityMeta retailStoreOrderShippingGroup =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup")
            .with("features", "root,visible_all");
    retailStoreOrderShippingGroup.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrderShippingGroup
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    retailStoreOrderShippingGroup
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrderShippingGroup
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreOrderShippingGroup
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrderShippingGroup
        .property("bizOrder")
        .with("features", "root,visible_all")
        .with("vg4seller", "销售管理");

    retailStoreOrderShippingGroup
        .property("bizOrder")
        .with("parentType", "com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder");

    retailStoreOrderShippingGroup
        .property("bizOrder")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrderShippingGroup
        .property("amount")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    retailStoreOrderShippingGroup
        .property("amount")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrderShippingGroup
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    retailStoreOrderShippingGroup
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerRetailStoreOrderPaymentGroup() {
    EntityMeta retailStoreOrderPaymentGroup =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup")
            .with("features", "root,visible_all");
    retailStoreOrderPaymentGroup.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrderPaymentGroup
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    retailStoreOrderPaymentGroup
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrderPaymentGroup
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreOrderPaymentGroup
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrderPaymentGroup
        .property("bizOrder")
        .with("features", "root,visible_all")
        .with("vg4seller", "销售管理");

    retailStoreOrderPaymentGroup
        .property("bizOrder")
        .with("parentType", "com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder");

    retailStoreOrderPaymentGroup
        .property("bizOrder")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrderPaymentGroup
        .property("cardNumber")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    retailStoreOrderPaymentGroup
        .property("cardNumber")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    retailStoreOrderPaymentGroup
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    retailStoreOrderPaymentGroup
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerWarehouse() {
    EntityMeta warehouse =
        MetaProvider.entity("com.doublechaintech.retailscm.warehouse.Warehouse")
            .with("features", "root,visible_all")
            .with("vg4owner", "仓配运一体化");
    warehouse.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    warehouse
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    warehouse
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    warehouse
        .property("location")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    warehouse
        .property("location")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    warehouse
        .property("contactNumber")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    warehouse
        .property("contactNumber")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    warehouse
        .property("totalArea")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    warehouse
        .property("totalArea")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    warehouse.property("owner").with("features", "root,visible_all");

    warehouse
        .property("owner")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    warehouse
        .property("owner")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    warehouse
        .property("latitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    warehouse
        .property("latitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    warehouse
        .property("longitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    warehouse
        .property("longitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    warehouse
        .property("contract")
        .with("parent", "string")
        .with("editor", "documentditor")
        .with("features", "root,visible_all,string,attachment")
        .with("searcheditor", "defaulteditor");

    warehouse
        .property("contract")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,ATTACHMENT,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    warehouse
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    warehouse
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    warehouse
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    warehouse
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerStorageSpace() {
    EntityMeta storageSpace =
        MetaProvider.entity("com.doublechaintech.retailscm.storagespace.StorageSpace")
            .with("features", "root,visible_all");
    storageSpace.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    storageSpace
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    storageSpace
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    storageSpace
        .property("location")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    storageSpace
        .property("location")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    storageSpace
        .property("contactNumber")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    storageSpace
        .property("contactNumber")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    storageSpace
        .property("totalArea")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    storageSpace
        .property("totalArea")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    storageSpace
        .property("warehouse")
        .with("features", "root,visible_all")
        .with("vg4owner", "仓配运一体化");

    storageSpace
        .property("warehouse")
        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");

    storageSpace
        .property("warehouse")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    storageSpace
        .property("latitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    storageSpace
        .property("latitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    storageSpace
        .property("longitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    storageSpace
        .property("longitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    storageSpace
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    storageSpace
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    storageSpace
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    storageSpace
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerSmartPallet() {
    EntityMeta smartPallet =
        MetaProvider.entity("com.doublechaintech.retailscm.smartpallet.SmartPallet")
            .with("features", "root,visible_all");
    smartPallet.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    smartPallet
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    smartPallet
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    smartPallet
        .property("location")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    smartPallet
        .property("location")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    smartPallet
        .property("contactNumber")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    smartPallet
        .property("contactNumber")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    smartPallet
        .property("totalArea")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    smartPallet
        .property("totalArea")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    smartPallet
        .property("latitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    smartPallet
        .property("latitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    smartPallet
        .property("longitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    smartPallet
        .property("longitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    smartPallet
        .property("warehouse")
        .with("features", "root,visible_all")
        .with("vg4owner", "仓配运一体化");

    smartPallet
        .property("warehouse")
        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");

    smartPallet
        .property("warehouse")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    smartPallet
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    smartPallet
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    smartPallet
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    smartPallet
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerGoodsShelf() {
    EntityMeta goodsShelf =
        MetaProvider.entity("com.doublechaintech.retailscm.goodsshelf.GoodsShelf")
            .with("features", "root,visible_all");
    goodsShelf.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsShelf
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    goodsShelf
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsShelf
        .property("location")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    goodsShelf
        .property("location")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsShelf.property("storageSpace").with("features", "root,visible_all");

    goodsShelf
        .property("storageSpace")
        .with("parentType", "com.doublechaintech.retailscm.storagespace.StorageSpace");

    goodsShelf
        .property("storageSpace")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsShelf.property("supplierSpace").with("features", "root,visible_all");

    goodsShelf
        .property("supplierSpace")
        .with("parentType", "com.doublechaintech.retailscm.supplierspace.SupplierSpace");

    goodsShelf
        .property("supplierSpace")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsShelf.property("damageSpace").with("features", "root,visible_all");

    goodsShelf
        .property("damageSpace")
        .with("parentType", "com.doublechaintech.retailscm.damagespace.DamageSpace");

    goodsShelf
        .property("damageSpace")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsShelf
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    goodsShelf
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsShelf
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    goodsShelf
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerGoodsShelfStockCount() {
    EntityMeta goodsShelfStockCount =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount")
            .with("features", "root,visible_all");
    goodsShelfStockCount.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsShelfStockCount
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    goodsShelfStockCount
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsShelfStockCount
        .property("title")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    goodsShelfStockCount
        .property("title")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsShelfStockCount
        .property("countTime")
        .with("java_type", "java.util.Date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    goodsShelfStockCount
        .property("countTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsShelfStockCount
        .property("summary")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    goodsShelfStockCount
        .property("summary")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsShelfStockCount.property("shelf").with("features", "root,visible_all");

    goodsShelfStockCount
        .property("shelf")
        .with("parentType", "com.doublechaintech.retailscm.goodsshelf.GoodsShelf");

    goodsShelfStockCount
        .property("shelf")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsShelfStockCount
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    goodsShelfStockCount
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerStockCountIssueTrack() {
    EntityMeta stockCountIssueTrack =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrack")
            .with("features", "root,visible_all");
    stockCountIssueTrack.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    stockCountIssueTrack
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    stockCountIssueTrack
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    stockCountIssueTrack
        .property("title")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    stockCountIssueTrack
        .property("title")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    stockCountIssueTrack
        .property("countTime")
        .with("java_type", "java.util.Date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    stockCountIssueTrack
        .property("countTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    stockCountIssueTrack
        .property("summary")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    stockCountIssueTrack
        .property("summary")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    stockCountIssueTrack.property("stockCount").with("features", "root,visible_all");

    stockCountIssueTrack
        .property("stockCount")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount");

    stockCountIssueTrack
        .property("stockCount")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    stockCountIssueTrack
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    stockCountIssueTrack
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerGoodsAllocation() {
    EntityMeta goodsAllocation =
        MetaProvider.entity("com.doublechaintech.retailscm.goodsallocation.GoodsAllocation")
            .with("features", "root,visible_all");
    goodsAllocation.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsAllocation
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    goodsAllocation
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsAllocation
        .property("location")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    goodsAllocation
        .property("location")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsAllocation
        .property("latitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    goodsAllocation
        .property("latitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsAllocation
        .property("longitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    goodsAllocation
        .property("longitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsAllocation.property("goodsShelf").with("features", "root,visible_all");

    goodsAllocation
        .property("goodsShelf")
        .with("parentType", "com.doublechaintech.retailscm.goodsshelf.GoodsShelf");

    goodsAllocation
        .property("goodsShelf")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsAllocation
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    goodsAllocation
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerGoods() {
    EntityMeta goods =
        MetaProvider.entity("com.doublechaintech.retailscm.goods.Goods")
            .with("features", "root,visible_all");
    goods.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goods
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    goods
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goods
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    goods
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goods
        .property("rfid")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    goods
        .property("rfid")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goods
        .property("uom")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    goods
        .property("uom")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goods
        .property("maxPackage")
        .with("parent", "number")
        .with("editor", "numbereditor")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,int");

    goods
        .property("maxPackage")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,INT,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goods
        .property("expireTime")
        .with("java_type", "java.util.Date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    goods
        .property("expireTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goods.property("sku").with("features", "root,visible_all");

    goods.property("sku").with("parentType", "com.doublechaintech.retailscm.sku.Sku");

    goods
        .property("sku")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goods.property("receivingSpace").with("features", "root,visible_all");

    goods
        .property("receivingSpace")
        .with("parentType", "com.doublechaintech.retailscm.receivingspace.ReceivingSpace");

    goods
        .property("receivingSpace")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goods.property("goodsAllocation").with("features", "root,visible_all");

    goods
        .property("goodsAllocation")
        .with("parentType", "com.doublechaintech.retailscm.goodsallocation.GoodsAllocation");

    goods
        .property("goodsAllocation")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goods.property("smartPallet").with("features", "root,visible_all");

    goods
        .property("smartPallet")
        .with("parentType", "com.doublechaintech.retailscm.smartpallet.SmartPallet");

    goods
        .property("smartPallet")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goods.property("shippingSpace").with("features", "root,visible_all");

    goods
        .property("shippingSpace")
        .with("parentType", "com.doublechaintech.retailscm.shippingspace.ShippingSpace");

    goods
        .property("shippingSpace")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goods.property("transportTask").with("features", "root,visible_all");

    goods
        .property("transportTask")
        .with("parentType", "com.doublechaintech.retailscm.transporttask.TransportTask");

    goods
        .property("transportTask")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goods
        .property("retailStore")
        .with("vg4retail_store_country_center", "加盟管理")
        .with("features", "root,visible_all");

    goods
        .property("retailStore")
        .with("parentType", "com.doublechaintech.retailscm.retailstore.RetailStore");

    goods
        .property("retailStore")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goods.property("bizOrder").with("vg4buyer", "供应管理").with("features", "root,visible_all");

    goods
        .property("bizOrder")
        .with("parentType", "com.doublechaintech.retailscm.supplyorder.SupplyOrder");

    goods
        .property("bizOrder")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goods
        .property("retailStoreOrder")
        .with("features", "root,visible_all")
        .with("vg4seller", "销售管理");

    goods
        .property("retailStoreOrder")
        .with("parentType", "com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder");

    goods
        .property("retailStoreOrder")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goods
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    goods
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerGoodsMovement() {
    EntityMeta goodsMovement =
        MetaProvider.entity("com.doublechaintech.retailscm.goodsmovement.GoodsMovement")
            .with("features", "root,visible_all");
    goodsMovement.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsMovement
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    goodsMovement
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsMovement
        .property("moveTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("searcheditor", "daterangepicker");

    goodsMovement
        .property("moveTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsMovement
        .property("facility")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    goodsMovement
        .property("facility")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsMovement
        .property("facilityId")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    goodsMovement
        .property("facilityId")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsMovement
        .property("fromIp")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    goodsMovement
        .property("fromIp")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsMovement
        .property("userAgent")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    goodsMovement
        .property("userAgent")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsMovement
        .property("sessionId")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    goodsMovement
        .property("sessionId")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsMovement
        .property("latitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    goodsMovement
        .property("latitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsMovement
        .property("longitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    goodsMovement
        .property("longitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsMovement.property("goods").with("features", "root,visible_all");

    goodsMovement.property("goods").with("parentType", "com.doublechaintech.retailscm.goods.Goods");

    goodsMovement
        .property("goods")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    goodsMovement
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    goodsMovement
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerSupplierSpace() {
    EntityMeta supplierSpace =
        MetaProvider.entity("com.doublechaintech.retailscm.supplierspace.SupplierSpace")
            .with("features", "root,visible_all");
    supplierSpace.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplierSpace
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    supplierSpace
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplierSpace
        .property("location")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    supplierSpace
        .property("location")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplierSpace
        .property("contactNumber")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    supplierSpace
        .property("contactNumber")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplierSpace
        .property("totalArea")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    supplierSpace
        .property("totalArea")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplierSpace
        .property("warehouse")
        .with("features", "root,visible_all")
        .with("vg4owner", "仓配运一体化");

    supplierSpace
        .property("warehouse")
        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");

    supplierSpace
        .property("warehouse")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplierSpace
        .property("latitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    supplierSpace
        .property("latitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplierSpace
        .property("longitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    supplierSpace
        .property("longitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplierSpace
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    supplierSpace
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    supplierSpace
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    supplierSpace
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerReceivingSpace() {
    EntityMeta receivingSpace =
        MetaProvider.entity("com.doublechaintech.retailscm.receivingspace.ReceivingSpace")
            .with("features", "root,visible_all");
    receivingSpace.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    receivingSpace
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    receivingSpace
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    receivingSpace
        .property("location")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    receivingSpace
        .property("location")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    receivingSpace
        .property("contactNumber")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    receivingSpace
        .property("contactNumber")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    receivingSpace
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    receivingSpace
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    receivingSpace
        .property("totalArea")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    receivingSpace
        .property("totalArea")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    receivingSpace
        .property("warehouse")
        .with("features", "root,visible_all")
        .with("vg4owner", "仓配运一体化");

    receivingSpace
        .property("warehouse")
        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");

    receivingSpace
        .property("warehouse")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    receivingSpace
        .property("latitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    receivingSpace
        .property("latitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    receivingSpace
        .property("longitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    receivingSpace
        .property("longitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    receivingSpace
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    receivingSpace
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    receivingSpace
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    receivingSpace
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerShippingSpace() {
    EntityMeta shippingSpace =
        MetaProvider.entity("com.doublechaintech.retailscm.shippingspace.ShippingSpace")
            .with("features", "root,visible_all");
    shippingSpace.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    shippingSpace
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    shippingSpace
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    shippingSpace
        .property("location")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    shippingSpace
        .property("location")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    shippingSpace
        .property("contactNumber")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    shippingSpace
        .property("contactNumber")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    shippingSpace
        .property("totalArea")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    shippingSpace
        .property("totalArea")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    shippingSpace
        .property("warehouse")
        .with("features", "root,visible_all")
        .with("vg4owner", "仓配运一体化");

    shippingSpace
        .property("warehouse")
        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");

    shippingSpace
        .property("warehouse")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    shippingSpace
        .property("latitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    shippingSpace
        .property("latitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    shippingSpace
        .property("longitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    shippingSpace
        .property("longitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    shippingSpace
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    shippingSpace
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    shippingSpace
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    shippingSpace
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    shippingSpace
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    shippingSpace
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerDamageSpace() {
    EntityMeta damageSpace =
        MetaProvider.entity("com.doublechaintech.retailscm.damagespace.DamageSpace")
            .with("features", "root,visible_all");
    damageSpace.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    damageSpace
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    damageSpace
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    damageSpace
        .property("location")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    damageSpace
        .property("location")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    damageSpace
        .property("contactNumber")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    damageSpace
        .property("contactNumber")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    damageSpace
        .property("totalArea")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    damageSpace
        .property("totalArea")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    damageSpace
        .property("latitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    damageSpace
        .property("latitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    damageSpace
        .property("longitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    damageSpace
        .property("longitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    damageSpace
        .property("warehouse")
        .with("features", "root,visible_all")
        .with("vg4owner", "仓配运一体化");

    damageSpace
        .property("warehouse")
        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");

    damageSpace
        .property("warehouse")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    damageSpace
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    damageSpace
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    damageSpace
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    damageSpace
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerWarehouseAsset() {
    EntityMeta warehouseAsset =
        MetaProvider.entity("com.doublechaintech.retailscm.warehouseasset.WarehouseAsset")
            .with("features", "root,visible_all");
    warehouseAsset.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    warehouseAsset
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    warehouseAsset
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    warehouseAsset
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    warehouseAsset
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    warehouseAsset
        .property("position")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    warehouseAsset
        .property("position")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    warehouseAsset
        .property("owner")
        .with("features", "root,visible_all")
        .with("vg4owner", "仓配运一体化");

    warehouseAsset
        .property("owner")
        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");

    warehouseAsset
        .property("owner")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    warehouseAsset
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    warehouseAsset
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    warehouseAsset
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    warehouseAsset
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerTransportFleet() {
    EntityMeta transportFleet =
        MetaProvider.entity("com.doublechaintech.retailscm.transportfleet.TransportFleet")
            .with("features", "root,visible_all")
            .with("vg4owner", "仓配运一体化");
    transportFleet.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportFleet
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    transportFleet
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportFleet
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    transportFleet
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportFleet
        .property("contactNumber")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    transportFleet
        .property("contactNumber")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportFleet.property("owner").with("features", "root,visible_all");

    transportFleet
        .property("owner")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    transportFleet
        .property("owner")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportFleet
        .property("contract")
        .with("parent", "string")
        .with("editor", "documentditor")
        .with("features", "root,visible_all,string,attachment")
        .with("searcheditor", "defaulteditor");

    transportFleet
        .property("contract")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,ATTACHMENT,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportFleet
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    transportFleet
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportFleet
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    transportFleet
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerTransportTruck() {
    EntityMeta transportTruck =
        MetaProvider.entity("com.doublechaintech.retailscm.transporttruck.TransportTruck")
            .with("features", "root,visible_all");
    transportTruck.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTruck
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    transportTruck
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTruck
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    transportTruck
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTruck
        .property("plateNumber")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    transportTruck
        .property("plateNumber")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTruck
        .property("contactNumber")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    transportTruck
        .property("contactNumber")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTruck
        .property("vehicleLicenseNumber")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    transportTruck
        .property("vehicleLicenseNumber")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTruck
        .property("engineNumber")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    transportTruck
        .property("engineNumber")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTruck
        .property("makeDate")
        .with("java_type", "java.util.Date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    transportTruck
        .property("makeDate")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTruck
        .property("mileage")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    transportTruck
        .property("mileage")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTruck
        .property("bodyColor")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    transportTruck
        .property("bodyColor")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTruck
        .property("owner")
        .with("features", "root,visible_all")
        .with("vg4owner", "仓配运一体化");

    transportTruck
        .property("owner")
        .with("parentType", "com.doublechaintech.retailscm.transportfleet.TransportFleet");

    transportTruck
        .property("owner")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTruck
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    transportTruck
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerTruckDriver() {
    EntityMeta truckDriver =
        MetaProvider.entity("com.doublechaintech.retailscm.truckdriver.TruckDriver")
            .with("features", "root,visible_all");
    truckDriver.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    truckDriver
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    truckDriver
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    truckDriver
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    truckDriver
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    truckDriver
        .property("driverLicenseNumber")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    truckDriver
        .property("driverLicenseNumber")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    truckDriver
        .property("contactNumber")
        .with("parent", "string")
        .with("features", "root,visible_all,string,mobile")
        .with("editor", "defaulteditor")
        .with("searcheditor", "defaulteditor");

    truckDriver
        .property("contactNumber")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MOBILE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    truckDriver
        .property("belongsTo")
        .with("features", "root,visible_all")
        .with("vg4owner", "仓配运一体化");

    truckDriver
        .property("belongsTo")
        .with("parentType", "com.doublechaintech.retailscm.transportfleet.TransportFleet");

    truckDriver
        .property("belongsTo")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    truckDriver
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    truckDriver
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerTransportTask() {
    EntityMeta transportTask =
        MetaProvider.entity("com.doublechaintech.retailscm.transporttask.TransportTask")
            .with("features", "root,visible_all");
    transportTask.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTask
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    transportTask
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTask
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    transportTask
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTask
        .property("start")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    transportTask
        .property("start")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTask
        .property("beginTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    transportTask
        .property("beginTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTask
        .property("end")
        .with("vg4retail_store_country_center", "加盟管理")
        .with("features", "root,visible_all");

    transportTask
        .property("end")
        .with("parentType", "com.doublechaintech.retailscm.retailstore.RetailStore");

    transportTask
        .property("end")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTask.property("driver").with("features", "root,visible_all");

    transportTask
        .property("driver")
        .with("parentType", "com.doublechaintech.retailscm.truckdriver.TruckDriver");

    transportTask
        .property("driver")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTask.property("truck").with("features", "root,visible_all");

    transportTask
        .property("truck")
        .with("parentType", "com.doublechaintech.retailscm.transporttruck.TransportTruck");

    transportTask
        .property("truck")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTask
        .property("belongsTo")
        .with("features", "root,visible_all")
        .with("vg4owner", "仓配运一体化");

    transportTask
        .property("belongsTo")
        .with("parentType", "com.doublechaintech.retailscm.transportfleet.TransportFleet");

    transportTask
        .property("belongsTo")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTask
        .property("latitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    transportTask
        .property("latitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTask
        .property("longitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    transportTask
        .property("longitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTask
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    transportTask
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerTransportTaskTrack() {
    EntityMeta transportTaskTrack =
        MetaProvider.entity("com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrack")
            .with("features", "root,visible_all");
    transportTaskTrack.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTaskTrack
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    transportTaskTrack
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTaskTrack
        .property("trackTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    transportTaskTrack
        .property("trackTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTaskTrack
        .property("latitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    transportTaskTrack
        .property("latitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTaskTrack
        .property("longitude")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,double")
        .with("editor", "booleaneditor");

    transportTaskTrack
        .property("longitude")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,DOUBLE,EXCEL_VIEW,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTaskTrack.property("movement").with("features", "root,visible_all");

    transportTaskTrack
        .property("movement")
        .with("parentType", "com.doublechaintech.retailscm.transporttask.TransportTask");

    transportTaskTrack
        .property("movement")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    transportTaskTrack
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    transportTaskTrack
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerAccountSet() {
    EntityMeta accountSet =
        MetaProvider.entity("com.doublechaintech.retailscm.accountset.AccountSet")
            .with("vg4country_center", "财务管理")
            .with("features", "root,visible_all");
    accountSet.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountSet
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    accountSet
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountSet
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    accountSet
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountSet
        .property("yearSet")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    accountSet
        .property("yearSet")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountSet
        .property("effectiveDate")
        .with("java_type", "java.util.Date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    accountSet
        .property("effectiveDate")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountSet
        .property("accountingSystem")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    accountSet
        .property("accountingSystem")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountSet
        .property("domesticCurrencyCode")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    accountSet
        .property("domesticCurrencyCode")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountSet
        .property("domesticCurrencyName")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    accountSet
        .property("domesticCurrencyName")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountSet
        .property("openingBank")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    accountSet
        .property("openingBank")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountSet
        .property("accountNumber")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    accountSet
        .property("accountNumber")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountSet.property("countryCenter").with("features", "root,visible_all");

    accountSet
        .property("countryCenter")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    accountSet
        .property("countryCenter")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountSet
        .property("retailStore")
        .with("vg4retail_store_country_center", "加盟管理")
        .with("features", "root,visible_all");

    accountSet
        .property("retailStore")
        .with("parentType", "com.doublechaintech.retailscm.retailstore.RetailStore");

    accountSet
        .property("retailStore")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountSet
        .property("goodsSupplier")
        .with("features", "root,visible_all")
        .with("vg4belong_to", "供应管理");

    accountSet
        .property("goodsSupplier")
        .with("parentType", "com.doublechaintech.retailscm.goodssupplier.GoodsSupplier");

    accountSet
        .property("goodsSupplier")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountSet
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    accountSet
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountSet
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    accountSet
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerAccountingSubject() {
    EntityMeta accountingSubject =
        MetaProvider.entity("com.doublechaintech.retailscm.accountingsubject.AccountingSubject")
            .with("features", "root,visible_all");
    accountingSubject.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingSubject
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    accountingSubject
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingSubject
        .property("accountingSubjectCode")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    accountingSubject
        .property("accountingSubjectCode")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingSubject
        .property("accountingSubjectName")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    accountingSubject
        .property("accountingSubjectName")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingSubject
        .property("accountingSubjectClassCode")
        .with("parent", "number")
        .with("editor", "numbereditor")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,int");

    accountingSubject
        .property("accountingSubjectClassCode")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,INT,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingSubject
        .property("accountingSubjectClassName")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    accountingSubject
        .property("accountingSubjectClassName")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingSubject
        .property("accountSet")
        .with("vg4country_center", "财务管理")
        .with("features", "root,visible_all");

    accountingSubject
        .property("accountSet")
        .with("parentType", "com.doublechaintech.retailscm.accountset.AccountSet");

    accountingSubject
        .property("accountSet")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingSubject
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    accountingSubject
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerAccountingPeriod() {
    EntityMeta accountingPeriod =
        MetaProvider.entity("com.doublechaintech.retailscm.accountingperiod.AccountingPeriod")
            .with("features", "root,visible_all");
    accountingPeriod.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingPeriod
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    accountingPeriod
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingPeriod
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    accountingPeriod
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingPeriod
        .property("startDate")
        .with("java_type", "java.util.Date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    accountingPeriod
        .property("startDate")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingPeriod
        .property("endDate")
        .with("java_type", "java.util.Date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    accountingPeriod
        .property("endDate")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingPeriod
        .property("accountSet")
        .with("vg4country_center", "财务管理")
        .with("features", "root,visible_all");

    accountingPeriod
        .property("accountSet")
        .with("parentType", "com.doublechaintech.retailscm.accountset.AccountSet");

    accountingPeriod
        .property("accountSet")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingPeriod
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    accountingPeriod
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerAccountingDocumentType() {
    EntityMeta accountingDocumentType =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType")
            .with("features", "root,visible_all");
    accountingDocumentType.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingDocumentType
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    accountingDocumentType
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingDocumentType
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    accountingDocumentType
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingDocumentType
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    accountingDocumentType
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingDocumentType
        .property("accountingPeriod")
        .with("vg4country_center", "财务管理")
        .with("features", "root,visible_all");

    accountingDocumentType
        .property("accountingPeriod")
        .with("parentType", "com.doublechaintech.retailscm.accountset.AccountSet");

    accountingDocumentType
        .property("accountingPeriod")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingDocumentType
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    accountingDocumentType
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerAccountingDocument() {
    EntityMeta accountingDocument =
        MetaProvider.entity("com.doublechaintech.retailscm.accountingdocument.AccountingDocument")
            .with("features", "root,visible_all");
    accountingDocument.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingDocument
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    accountingDocument
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingDocument
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    accountingDocument
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingDocument
        .property("accountingDocumentDate")
        .with("java_type", "java.util.Date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    accountingDocument
        .property("accountingDocumentDate")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingDocument.property("accountingPeriod").with("features", "root,visible_all");

    accountingDocument
        .property("accountingPeriod")
        .with("parentType", "com.doublechaintech.retailscm.accountingperiod.AccountingPeriod");

    accountingDocument
        .property("accountingPeriod")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingDocument.property("documentType").with("features", "root,visible_all");

    accountingDocument
        .property("documentType")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType");

    accountingDocument
        .property("documentType")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingDocument
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    accountingDocument
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerOriginalVoucher() {
    EntityMeta originalVoucher =
        MetaProvider.entity("com.doublechaintech.retailscm.originalvoucher.OriginalVoucher")
            .with("features", "root,visible_all");
    originalVoucher.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    originalVoucher
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    originalVoucher
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    originalVoucher
        .property("title")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    originalVoucher
        .property("title")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    originalVoucher
        .property("madeBy")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    originalVoucher
        .property("madeBy")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    originalVoucher
        .property("receivedBy")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    originalVoucher
        .property("receivedBy")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    originalVoucher
        .property("voucherType")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    originalVoucher
        .property("voucherType")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    originalVoucher
        .property("voucherImage")
        .with("parent", "string")
        .with("editor", "imageeditor")
        .with("features", "root,visible_all,string,attachment,image")
        .with("searcheditor", "defaulteditor");

    originalVoucher
        .property("voucherImage")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,ATTACHMENT,DELETE,EXCEL_VIEW,IMAGE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    originalVoucher.property("belongsTo").with("features", "root,visible_all");

    originalVoucher
        .property("belongsTo")
        .with("parentType", "com.doublechaintech.retailscm.accountingdocument.AccountingDocument");

    originalVoucher
        .property("belongsTo")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    originalVoucher
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    originalVoucher
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerAccountingDocumentLine() {
    EntityMeta accountingDocumentLine =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine")
            .with("features", "root,visible_all");
    accountingDocumentLine.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingDocumentLine
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    accountingDocumentLine
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingDocumentLine
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    accountingDocumentLine
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingDocumentLine
        .property("code")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    accountingDocumentLine
        .property("code")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingDocumentLine
        .property("direct")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    accountingDocumentLine
        .property("direct")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingDocumentLine
        .property("amount")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    accountingDocumentLine
        .property("amount")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingDocumentLine.property("belongsTo").with("features", "root,visible_all");

    accountingDocumentLine
        .property("belongsTo")
        .with("parentType", "com.doublechaintech.retailscm.accountingdocument.AccountingDocument");

    accountingDocumentLine
        .property("belongsTo")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingDocumentLine.property("accountingSubject").with("features", "root,visible_all");

    accountingDocumentLine
        .property("accountingSubject")
        .with("parentType", "com.doublechaintech.retailscm.accountingsubject.AccountingSubject");

    accountingDocumentLine
        .property("accountingSubject")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    accountingDocumentLine
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    accountingDocumentLine
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerLevelOneDepartment() {
    EntityMeta levelOneDepartment =
        MetaProvider.entity("com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment")
            .with("features", "root,visible_all")
            .with("vg4belongs_to", "组织机构");
    levelOneDepartment.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelOneDepartment
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    levelOneDepartment
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelOneDepartment.property("belongsTo").with("features", "root,visible_all");

    levelOneDepartment
        .property("belongsTo")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    levelOneDepartment
        .property("belongsTo")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelOneDepartment
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    levelOneDepartment
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelOneDepartment
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    levelOneDepartment
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelOneDepartment
        .property("manager")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    levelOneDepartment
        .property("manager")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelOneDepartment
        .property("founded")
        .with("java_type", "java.util.Date")
        .with("parent", "date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    levelOneDepartment
        .property("founded")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelOneDepartment
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    levelOneDepartment
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerLevelTwoDepartment() {
    EntityMeta levelTwoDepartment =
        MetaProvider.entity("com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment")
            .with("features", "root,visible_all");
    levelTwoDepartment.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelTwoDepartment
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    levelTwoDepartment
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelTwoDepartment
        .property("belongsTo")
        .with("features", "root,visible_all")
        .with("vg4belongs_to", "组织机构");

    levelTwoDepartment
        .property("belongsTo")
        .with("parentType", "com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment");

    levelTwoDepartment
        .property("belongsTo")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelTwoDepartment
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    levelTwoDepartment
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelTwoDepartment
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    levelTwoDepartment
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelTwoDepartment
        .property("founded")
        .with("java_type", "java.util.Date")
        .with("parent", "date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    levelTwoDepartment
        .property("founded")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelTwoDepartment
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    levelTwoDepartment
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerLevelThreeDepartment() {
    EntityMeta levelThreeDepartment =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment")
            .with("features", "root,visible_all");
    levelThreeDepartment.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelThreeDepartment
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    levelThreeDepartment
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelThreeDepartment.property("belongsTo").with("features", "root,visible_all");

    levelThreeDepartment
        .property("belongsTo")
        .with("parentType", "com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment");

    levelThreeDepartment
        .property("belongsTo")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelThreeDepartment
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    levelThreeDepartment
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelThreeDepartment
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    levelThreeDepartment
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelThreeDepartment
        .property("founded")
        .with("java_type", "java.util.Date")
        .with("parent", "date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    levelThreeDepartment
        .property("founded")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    levelThreeDepartment
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    levelThreeDepartment
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerSkillType() {
    EntityMeta skillType =
        MetaProvider.entity("com.doublechaintech.retailscm.skilltype.SkillType")
            .with("features", "setting")
            .with("vg4company", "人力资源");
    skillType.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    skillType
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    skillType
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    skillType
        .property("code")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    skillType
        .property("code")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    skillType.property("company").with("features", "root,visible_all");

    skillType
        .property("company")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    skillType
        .property("company")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    skillType
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    skillType
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    skillType
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    skillType
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerResponsibilityType() {
    EntityMeta responsibilityType =
        MetaProvider.entity("com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType")
            .with("features", "setting")
            .with("vg4company", "人力资源");
    responsibilityType.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    responsibilityType
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    responsibilityType
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    responsibilityType
        .property("code")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    responsibilityType
        .property("code")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    responsibilityType.property("company").with("features", "root,visible_all");

    responsibilityType
        .property("company")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    responsibilityType
        .property("company")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    responsibilityType
        .property("baseDescription")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    responsibilityType
        .property("baseDescription")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    responsibilityType
        .property("detailDescription")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    responsibilityType
        .property("detailDescription")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    responsibilityType
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    responsibilityType
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerTerminationReason() {
    EntityMeta terminationReason =
        MetaProvider.entity("com.doublechaintech.retailscm.terminationreason.TerminationReason")
            .with("features", "setting")
            .with("vg4company", "人力资源");
    terminationReason.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    terminationReason
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    terminationReason
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    terminationReason
        .property("code")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    terminationReason
        .property("code")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    terminationReason.property("company").with("features", "root,visible_all");

    terminationReason
        .property("company")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    terminationReason
        .property("company")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    terminationReason
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    terminationReason
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    terminationReason
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    terminationReason
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerTerminationType() {
    EntityMeta terminationType =
        MetaProvider.entity("com.doublechaintech.retailscm.terminationtype.TerminationType")
            .with("features", "setting")
            .with("vg4company", "人力资源");
    terminationType.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    terminationType
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    terminationType
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    terminationType
        .property("code")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    terminationType
        .property("code")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    terminationType.property("company").with("features", "root,visible_all");

    terminationType
        .property("company")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    terminationType
        .property("company")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    terminationType
        .property("baseDescription")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    terminationType
        .property("baseDescription")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    terminationType
        .property("detailDescription")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    terminationType
        .property("detailDescription")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    terminationType
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    terminationType
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerOccupationType() {
    EntityMeta occupationType =
        MetaProvider.entity("com.doublechaintech.retailscm.occupationtype.OccupationType")
            .with("features", "setting")
            .with("vg4company", "人力资源");
    occupationType.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    occupationType
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    occupationType
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    occupationType
        .property("code")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    occupationType
        .property("code")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    occupationType.property("company").with("features", "root,visible_all");

    occupationType
        .property("company")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    occupationType
        .property("company")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    occupationType
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    occupationType
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    occupationType
        .property("detailDescription")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    occupationType
        .property("detailDescription")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    occupationType
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    occupationType
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerLeaveType() {
    EntityMeta leaveType =
        MetaProvider.entity("com.doublechaintech.retailscm.leavetype.LeaveType")
            .with("features", "setting")
            .with("vg4company", "人力资源");
    leaveType.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    leaveType
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    leaveType
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    leaveType
        .property("code")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    leaveType
        .property("code")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    leaveType.property("company").with("features", "root,visible_all");

    leaveType
        .property("company")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    leaveType
        .property("company")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    leaveType
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    leaveType
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    leaveType
        .property("detailDescription")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    leaveType
        .property("detailDescription")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    leaveType
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    leaveType
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerSalaryGrade() {
    EntityMeta salaryGrade =
        MetaProvider.entity("com.doublechaintech.retailscm.salarygrade.SalaryGrade")
            .with("features", "setting")
            .with("vg4company", "人力资源");
    salaryGrade.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    salaryGrade
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    salaryGrade
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    salaryGrade
        .property("code")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    salaryGrade
        .property("code")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    salaryGrade.property("company").with("features", "root,visible_all");

    salaryGrade
        .property("company")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    salaryGrade
        .property("company")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    salaryGrade
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    salaryGrade
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    salaryGrade
        .property("detailDescription")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    salaryGrade
        .property("detailDescription")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    salaryGrade
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    salaryGrade
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerInterviewType() {
    EntityMeta interviewType =
        MetaProvider.entity("com.doublechaintech.retailscm.interviewtype.InterviewType")
            .with("features", "setting")
            .with("vg4company", "人力资源");
    interviewType.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    interviewType
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    interviewType
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    interviewType
        .property("code")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    interviewType
        .property("code")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    interviewType.property("company").with("features", "root,visible_all");

    interviewType
        .property("company")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    interviewType
        .property("company")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    interviewType
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    interviewType
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    interviewType
        .property("detailDescription")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    interviewType
        .property("detailDescription")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    interviewType
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    interviewType
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerTrainingCourseType() {
    EntityMeta trainingCourseType =
        MetaProvider.entity("com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType")
            .with("features", "setting")
            .with("vg4company", "人力资源");
    trainingCourseType.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    trainingCourseType
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    trainingCourseType
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    trainingCourseType
        .property("code")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    trainingCourseType
        .property("code")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    trainingCourseType.property("company").with("features", "root,visible_all");

    trainingCourseType
        .property("company")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    trainingCourseType
        .property("company")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    trainingCourseType
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    trainingCourseType
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    trainingCourseType
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    trainingCourseType
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    trainingCourseType
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    trainingCourseType
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerPublicHoliday() {
    EntityMeta publicHoliday =
        MetaProvider.entity("com.doublechaintech.retailscm.publicholiday.PublicHoliday")
            .with("features", "setting")
            .with("vg4company", "人力资源");
    publicHoliday.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    publicHoliday
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    publicHoliday
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    publicHoliday
        .property("code")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    publicHoliday
        .property("code")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    publicHoliday.property("company").with("features", "root,visible_all");

    publicHoliday
        .property("company")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    publicHoliday
        .property("company")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    publicHoliday
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    publicHoliday
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    publicHoliday
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    publicHoliday
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    publicHoliday
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    publicHoliday
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerTermination() {
    EntityMeta termination =
        MetaProvider.entity("com.doublechaintech.retailscm.termination.Termination")
            .with("features", "root,visible_all");
    termination.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    termination
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    termination
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    termination.property("reason").with("features", "setting").with("vg4company", "人力资源");

    termination
        .property("reason")
        .with("parentType", "com.doublechaintech.retailscm.terminationreason.TerminationReason");

    termination
        .property("reason")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    termination.property("type").with("features", "setting").with("vg4company", "人力资源");

    termination
        .property("type")
        .with("parentType", "com.doublechaintech.retailscm.terminationtype.TerminationType");

    termination
        .property("type")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    termination
        .property("comment")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    termination
        .property("comment")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    termination
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    termination
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerView() {
    EntityMeta view =
        MetaProvider.entity("com.doublechaintech.retailscm.view.View")
            .with("features", "root,visible_all");
    view.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    view.property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    view.property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    view.property("who")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    view.property("who")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    view.property("assessment")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    view.property("assessment")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    view.property("interviewTime")
        .with("java_type", "java.util.Date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    view.property("interviewTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    view.property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    view.property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerEmployee() {
    EntityMeta employee =
        MetaProvider.entity("com.doublechaintech.retailscm.employee.Employee")
            .with("features", "root,visible_all")
            .with("vg4company", "人力资源");
    employee.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employee
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    employee
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employee.property("company").with("features", "root,visible_all");

    employee
        .property("company")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    employee
        .property("company")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employee
        .property("title")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    employee
        .property("title")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employee.property("department").with("features", "root,visible_all");

    employee
        .property("department")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment");

    employee
        .property("department")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employee
        .property("familyName")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    employee
        .property("familyName")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employee
        .property("givenName")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    employee
        .property("givenName")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employee
        .property("email")
        .with("parent", "string")
        .with("editor", "emaileditor")
        .with("features", "root,visible_all,string,email")
        .with("searcheditor", "defaulteditor");

    employee
        .property("email")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EMAIL,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employee
        .property("city")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    employee
        .property("city")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employee
        .property("address")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    employee
        .property("address")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employee
        .property("cellPhone")
        .with("parent", "string")
        .with("features", "root,visible_all,string,mobile")
        .with("editor", "defaulteditor")
        .with("searcheditor", "defaulteditor");

    employee
        .property("cellPhone")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MOBILE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employee.property("occupation").with("features", "setting").with("vg4company", "人力资源");

    employee
        .property("occupation")
        .with("parentType", "com.doublechaintech.retailscm.occupationtype.OccupationType");

    employee
        .property("occupation")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    employee.property("responsibleFor").with("features", "setting").with("vg4company", "人力资源");

    employee
        .property("responsibleFor")
        .with("parentType", "com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType");

    employee
        .property("responsibleFor")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    employee.property("currentSalaryGrade").with("features", "setting").with("vg4company", "人力资源");

    employee
        .property("currentSalaryGrade")
        .with("parentType", "com.doublechaintech.retailscm.salarygrade.SalaryGrade");

    employee
        .property("currentSalaryGrade")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    employee
        .property("salaryAccount")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    employee
        .property("salaryAccount")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employee
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    employee
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employee
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    employee
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerInstructor() {
    EntityMeta instructor =
        MetaProvider.entity("com.doublechaintech.retailscm.instructor.Instructor")
            .with("features", "root,visible_all")
            .with("vg4company", "人力资源");
    instructor.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    instructor
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    instructor
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    instructor
        .property("title")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    instructor
        .property("title")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    instructor
        .property("familyName")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    instructor
        .property("familyName")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    instructor
        .property("givenName")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    instructor
        .property("givenName")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    instructor
        .property("cellPhone")
        .with("parent", "string")
        .with("features", "root,visible_all,string,mobile")
        .with("editor", "defaulteditor")
        .with("searcheditor", "defaulteditor");

    instructor
        .property("cellPhone")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MOBILE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    instructor
        .property("email")
        .with("parent", "string")
        .with("editor", "emaileditor")
        .with("features", "root,visible_all,string,email")
        .with("searcheditor", "defaulteditor");

    instructor
        .property("email")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EMAIL,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    instructor.property("company").with("features", "root,visible_all");

    instructor
        .property("company")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    instructor
        .property("company")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    instructor
        .property("introduction")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    instructor
        .property("introduction")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    instructor
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    instructor
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    instructor
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    instructor
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerCompanyTraining() {
    EntityMeta companyTraining =
        MetaProvider.entity("com.doublechaintech.retailscm.companytraining.CompanyTraining")
            .with("features", "root,visible_all")
            .with("vg4company", "人力资源");
    companyTraining.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    companyTraining
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    companyTraining
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    companyTraining
        .property("title")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    companyTraining
        .property("title")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    companyTraining.property("company").with("features", "root,visible_all");

    companyTraining
        .property("company")
        .with(
            "parentType",
            "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");

    companyTraining
        .property("company")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    companyTraining
        .property("instructor")
        .with("features", "root,visible_all")
        .with("vg4company", "人力资源");

    companyTraining
        .property("instructor")
        .with("parentType", "com.doublechaintech.retailscm.instructor.Instructor");

    companyTraining
        .property("instructor")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    companyTraining
        .property("trainingCourseType")
        .with("features", "setting")
        .with("vg4company", "人力资源");

    companyTraining
        .property("trainingCourseType")
        .with("parentType", "com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType");

    companyTraining
        .property("trainingCourseType")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    companyTraining
        .property("timeStart")
        .with("java_type", "java.util.Date")
        .with("parent", "date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    companyTraining
        .property("timeStart")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    companyTraining
        .property("durationHours")
        .with("parent", "number")
        .with("editor", "numbereditor")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,int");

    companyTraining
        .property("durationHours")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,INT,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    companyTraining
        .property("lastUpdateTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    companyTraining
        .property("lastUpdateTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    companyTraining
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    companyTraining
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerScoring() {
    EntityMeta scoring =
        MetaProvider.entity("com.doublechaintech.retailscm.scoring.Scoring")
            .with("features", "root,visible_all");
    scoring.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    scoring
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    scoring
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    scoring
        .property("scoredBy")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    scoring
        .property("scoredBy")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    scoring
        .property("score")
        .with("parent", "number")
        .with("editor", "numbereditor")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,int");

    scoring
        .property("score")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,INT,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    scoring
        .property("comment")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    scoring
        .property("comment")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    scoring
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    scoring
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerEmployeeCompanyTraining() {
    EntityMeta employeeCompanyTraining =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining")
            .with("features", "root,visible_all");
    employeeCompanyTraining.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeCompanyTraining
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    employeeCompanyTraining
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeCompanyTraining
        .property("employee")
        .with("features", "root,visible_all")
        .with("vg4company", "人力资源");

    employeeCompanyTraining
        .property("employee")
        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");

    employeeCompanyTraining
        .property("employee")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeCompanyTraining
        .property("training")
        .with("features", "root,visible_all")
        .with("vg4company", "人力资源");

    employeeCompanyTraining
        .property("training")
        .with("parentType", "com.doublechaintech.retailscm.companytraining.CompanyTraining");

    employeeCompanyTraining
        .property("training")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeCompanyTraining.property("scoring").with("features", "root,visible_all");

    employeeCompanyTraining
        .property("scoring")
        .with("parentType", "com.doublechaintech.retailscm.scoring.Scoring");

    employeeCompanyTraining
        .property("scoring")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeCompanyTraining
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    employeeCompanyTraining
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerEmployeeSkill() {
    EntityMeta employeeSkill =
        MetaProvider.entity("com.doublechaintech.retailscm.employeeskill.EmployeeSkill")
            .with("features", "root,visible_all");
    employeeSkill.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeSkill
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    employeeSkill
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeSkill
        .property("employee")
        .with("features", "root,visible_all")
        .with("vg4company", "人力资源");

    employeeSkill
        .property("employee")
        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");

    employeeSkill
        .property("employee")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeSkill.property("skillType").with("features", "setting").with("vg4company", "人力资源");

    employeeSkill
        .property("skillType")
        .with("parentType", "com.doublechaintech.retailscm.skilltype.SkillType");

    employeeSkill
        .property("skillType")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeSkill
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    employeeSkill
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeSkill
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    employeeSkill
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerEmployeePerformance() {
    EntityMeta employeePerformance =
        MetaProvider.entity("com.doublechaintech.retailscm.employeeperformance.EmployeePerformance")
            .with("features", "root,visible_all");
    employeePerformance.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeePerformance
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    employeePerformance
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeePerformance
        .property("employee")
        .with("features", "root,visible_all")
        .with("vg4company", "人力资源");

    employeePerformance
        .property("employee")
        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");

    employeePerformance
        .property("employee")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeePerformance
        .property("performanceComment")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    employeePerformance
        .property("performanceComment")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeePerformance
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    employeePerformance
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerEmployeeWorkExperience() {
    EntityMeta employeeWorkExperience =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperience")
            .with("features", "root,visible_all");
    employeeWorkExperience.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeWorkExperience
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    employeeWorkExperience
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeWorkExperience
        .property("employee")
        .with("features", "root,visible_all")
        .with("vg4company", "人力资源");

    employeeWorkExperience
        .property("employee")
        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");

    employeeWorkExperience
        .property("employee")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeWorkExperience
        .property("start")
        .with("java_type", "java.util.Date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    employeeWorkExperience
        .property("start")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeWorkExperience
        .property("end")
        .with("java_type", "java.util.Date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    employeeWorkExperience
        .property("end")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeWorkExperience
        .property("company")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    employeeWorkExperience
        .property("company")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeWorkExperience
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    employeeWorkExperience
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeWorkExperience
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    employeeWorkExperience
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerEmployeeLeave() {
    EntityMeta employeeLeave =
        MetaProvider.entity("com.doublechaintech.retailscm.employeeleave.EmployeeLeave")
            .with("features", "root,visible_all");
    employeeLeave.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeLeave
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    employeeLeave
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeLeave.property("who").with("features", "root,visible_all").with("vg4company", "人力资源");

    employeeLeave
        .property("who")
        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");

    employeeLeave
        .property("who")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeLeave.property("type").with("features", "setting").with("vg4company", "人力资源");

    employeeLeave
        .property("type")
        .with("parentType", "com.doublechaintech.retailscm.leavetype.LeaveType");

    employeeLeave
        .property("type")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeLeave
        .property("leaveDurationHour")
        .with("parent", "number")
        .with("editor", "numbereditor")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,int");

    employeeLeave
        .property("leaveDurationHour")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,INT,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeLeave
        .property("remark")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    employeeLeave
        .property("remark")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeLeave
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    employeeLeave
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerEmployeeInterview() {
    EntityMeta employeeInterview =
        MetaProvider.entity("com.doublechaintech.retailscm.employeeinterview.EmployeeInterview")
            .with("features", "root,visible_all");
    employeeInterview.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeInterview
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    employeeInterview
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeInterview
        .property("employee")
        .with("features", "root,visible_all")
        .with("vg4company", "人力资源");

    employeeInterview
        .property("employee")
        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");

    employeeInterview
        .property("employee")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeInterview
        .property("interviewType")
        .with("features", "setting")
        .with("vg4company", "人力资源");

    employeeInterview
        .property("interviewType")
        .with("parentType", "com.doublechaintech.retailscm.interviewtype.InterviewType");

    employeeInterview
        .property("interviewType")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeInterview
        .property("remark")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    employeeInterview
        .property("remark")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeInterview
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    employeeInterview
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerEmployeeAttendance() {
    EntityMeta employeeAttendance =
        MetaProvider.entity("com.doublechaintech.retailscm.employeeattendance.EmployeeAttendance")
            .with("features", "root,visible_all");
    employeeAttendance.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeAttendance
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    employeeAttendance
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeAttendance
        .property("employee")
        .with("features", "root,visible_all")
        .with("vg4company", "人力资源");

    employeeAttendance
        .property("employee")
        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");

    employeeAttendance
        .property("employee")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeAttendance
        .property("enterTime")
        .with("java_type", "java.util.Date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    employeeAttendance
        .property("enterTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeAttendance
        .property("leaveTime")
        .with("java_type", "java.util.Date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    employeeAttendance
        .property("leaveTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeAttendance
        .property("durationHours")
        .with("parent", "number")
        .with("editor", "numbereditor")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,int");

    employeeAttendance
        .property("durationHours")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,INT,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeAttendance
        .property("remark")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    employeeAttendance
        .property("remark")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeAttendance
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    employeeAttendance
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerEmployeeQualifier() {
    EntityMeta employeeQualifier =
        MetaProvider.entity("com.doublechaintech.retailscm.employeequalifier.EmployeeQualifier")
            .with("features", "root,visible_all");
    employeeQualifier.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeQualifier
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    employeeQualifier
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeQualifier
        .property("employee")
        .with("features", "root,visible_all")
        .with("vg4company", "人力资源");

    employeeQualifier
        .property("employee")
        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");

    employeeQualifier
        .property("employee")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeQualifier
        .property("qualifiedTime")
        .with("java_type", "java.util.Date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    employeeQualifier
        .property("qualifiedTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeQualifier
        .property("type")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    employeeQualifier
        .property("type")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeQualifier
        .property("level")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    employeeQualifier
        .property("level")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeQualifier
        .property("remark")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    employeeQualifier
        .property("remark")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeQualifier
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    employeeQualifier
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerEmployeeEducation() {
    EntityMeta employeeEducation =
        MetaProvider.entity("com.doublechaintech.retailscm.employeeeducation.EmployeeEducation")
            .with("features", "root,visible_all");
    employeeEducation.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeEducation
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    employeeEducation
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeEducation
        .property("employee")
        .with("features", "root,visible_all")
        .with("vg4company", "人力资源");

    employeeEducation
        .property("employee")
        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");

    employeeEducation
        .property("employee")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeEducation
        .property("completeTime")
        .with("java_type", "java.util.Date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    employeeEducation
        .property("completeTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeEducation
        .property("type")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    employeeEducation
        .property("type")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeEducation
        .property("remark")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    employeeEducation
        .property("remark")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeEducation
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    employeeEducation
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerEmployeeAward() {
    EntityMeta employeeAward =
        MetaProvider.entity("com.doublechaintech.retailscm.employeeaward.EmployeeAward")
            .with("features", "root,visible_all");
    employeeAward.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeAward
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    employeeAward
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeAward
        .property("employee")
        .with("features", "root,visible_all")
        .with("vg4company", "人力资源");

    employeeAward
        .property("employee")
        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");

    employeeAward
        .property("employee")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeAward
        .property("completeTime")
        .with("java_type", "java.util.Date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    employeeAward
        .property("completeTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeAward
        .property("type")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    employeeAward
        .property("type")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeAward
        .property("remark")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    employeeAward
        .property("remark")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeAward
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    employeeAward
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerEmployeeSalarySheet() {
    EntityMeta employeeSalarySheet =
        MetaProvider.entity("com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet")
            .with("features", "root,visible_all");
    employeeSalarySheet.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeSalarySheet
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    employeeSalarySheet
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeSalarySheet
        .property("employee")
        .with("features", "root,visible_all")
        .with("vg4company", "人力资源");

    employeeSalarySheet
        .property("employee")
        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");

    employeeSalarySheet
        .property("employee")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeSalarySheet
        .property("currentSalaryGrade")
        .with("features", "setting")
        .with("vg4company", "人力资源");

    employeeSalarySheet
        .property("currentSalaryGrade")
        .with("parentType", "com.doublechaintech.retailscm.salarygrade.SalaryGrade");

    employeeSalarySheet
        .property("currentSalaryGrade")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeSalarySheet
        .property("baseSalary")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    employeeSalarySheet
        .property("baseSalary")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeSalarySheet
        .property("bonus")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    employeeSalarySheet
        .property("bonus")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeSalarySheet
        .property("reward")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    employeeSalarySheet
        .property("reward")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeSalarySheet
        .property("personalTax")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    employeeSalarySheet
        .property("personalTax")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeSalarySheet
        .property("socialSecurity")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    employeeSalarySheet
        .property("socialSecurity")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeSalarySheet
        .property("housingFound")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    employeeSalarySheet
        .property("housingFound")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeSalarySheet
        .property("jobInsurance")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    employeeSalarySheet
        .property("jobInsurance")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeSalarySheet.property("payingOff").with("features", "root,visible_all");

    employeeSalarySheet
        .property("payingOff")
        .with("parentType", "com.doublechaintech.retailscm.payingoff.PayingOff");

    employeeSalarySheet
        .property("payingOff")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    employeeSalarySheet
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    employeeSalarySheet
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerPayingOff() {
    EntityMeta payingOff =
        MetaProvider.entity("com.doublechaintech.retailscm.payingoff.PayingOff")
            .with("features", "root,visible_all");
    payingOff.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    payingOff
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    payingOff
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    payingOff
        .property("who")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    payingOff
        .property("who")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    payingOff.property("paidFor").with("features", "root,visible_all").with("vg4company", "人力资源");

    payingOff
        .property("paidFor")
        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");

    payingOff
        .property("paidFor")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    payingOff
        .property("paidTime")
        .with("java_type", "java.util.Date")
        .with("editor", "datepicker")
        .with("features", "root,visible_all,date,search_between,search_before,search_after")
        .with("searcheditor", "daterangepicker");

    payingOff
        .property("paidTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    payingOff
        .property("amount")
        .with("java_type", "java.math.BigDecimal")
        .with("parent", "number")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,money")
        .with("editor", "booleaneditor");

    payingOff
        .property("amount")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MONEY,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    payingOff
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    payingOff
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerMobileApp() {
    EntityMeta mobileApp =
        MetaProvider.entity("com.doublechaintech.retailscm.mobileapp.MobileApp")
            .with("features", "root,visible_all");
    mobileApp.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    mobileApp
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    mobileApp
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    mobileApp
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    mobileApp
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    mobileApp
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    mobileApp
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerPage() {
    EntityMeta page =
        MetaProvider.entity("com.doublechaintech.retailscm.page.Page")
            .with("features", "root,visible_all")
            .with("vg4mobile_app", "页面管理");
    page.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    page.property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    page.property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    page.property("pageTitle")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    page.property("pageTitle")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    page.property("linkToUrl")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    page.property("linkToUrl")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    page.property("pageType").with("identified_by", "code").with("features", "status");

    page.property("pageType").with("parentType", "com.doublechaintech.retailscm.pagetype.PageType");

    page.property("pageType")
        .with(
            "tokens",
            "ACTION,ADMINUI,CONSTANT,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SAMPLE_DATA_COUNT_INFER,SEARCH,SEARCHABLE,TRANSFERABLE_CONSTANT,UPDATE,USERSPACE,VISIBLE_PARENT");

    page.property("displayOrder")
        .with("parent", "number")
        .with("editor", "numbereditor")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,int");

    page.property("displayOrder")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,INT,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    page.property("mobileApp").with("features", "root,visible_all");

    page.property("mobileApp")
        .with("parentType", "com.doublechaintech.retailscm.mobileapp.MobileApp");

    page.property("mobileApp")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    page.property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    page.property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerPageType() {
    EntityMeta pageType =
        MetaProvider.entity("com.doublechaintech.retailscm.pagetype.PageType")
            .with("identified_by", "code")
            .with("features", "status");
    pageType.with(
        "tokens",
        "ACTION,ADMINUI,CONSTANT,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SAMPLE_DATA_COUNT_INFER,SEARCH,SEARCHABLE,TRANSFERABLE_CONSTANT,UPDATE,USERSPACE,VISIBLE_PARENT");

    pageType
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    pageType
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    pageType
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    pageType
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    pageType
        .property("code")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    pageType
        .property("code")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    pageType.property("mobileApp").with("features", "root,visible_all");

    pageType
        .property("mobileApp")
        .with("parentType", "com.doublechaintech.retailscm.mobileapp.MobileApp");

    pageType
        .property("mobileApp")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    pageType
        .property("footerTab")
        .with("editor", "booleaneditor")
        .with("features", "root,visible_all,bool")
        .with("ignoreChecker", "true");

    pageType
        .property("footerTab")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,BOOL,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    pageType
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    pageType
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerSlide() {
    EntityMeta slide =
        MetaProvider.entity("com.doublechaintech.retailscm.slide.Slide")
            .with("features", "root,visible_all");
    slide.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    slide
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    slide
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    slide
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    slide
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    slide
        .property("displayOrder")
        .with("parent", "number")
        .with("editor", "numbereditor")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,int");

    slide
        .property("displayOrder")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,INT,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    slide
        .property("imageUrl")
        .with("parent", "string")
        .with("editor", "imageeditor")
        .with("features", "root,visible_all,string,attachment,image")
        .with("searcheditor", "defaulteditor");

    slide
        .property("imageUrl")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,ATTACHMENT,DELETE,EXCEL_VIEW,IMAGE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    slide
        .property("videoUrl")
        .with("parent", "string")
        .with("editor", "imageeditor")
        .with("features", "root,visible_all,string,attachment,image")
        .with("searcheditor", "defaulteditor");

    slide
        .property("videoUrl")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,ATTACHMENT,DELETE,EXCEL_VIEW,IMAGE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    slide
        .property("linkToUrl")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    slide
        .property("linkToUrl")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    slide.property("page").with("features", "root,visible_all").with("vg4mobile_app", "页面管理");

    slide.property("page").with("parentType", "com.doublechaintech.retailscm.page.Page");

    slide
        .property("page")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    slide
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    slide
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerUiAction() {
    EntityMeta uiAction =
        MetaProvider.entity("com.doublechaintech.retailscm.uiaction.UiAction")
            .with("features", "root,visible_all");
    uiAction.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    uiAction
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    uiAction
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    uiAction
        .property("code")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    uiAction
        .property("code")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    uiAction
        .property("icon")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    uiAction
        .property("icon")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    uiAction
        .property("title")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    uiAction
        .property("title")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    uiAction
        .property("displayOrder")
        .with("parent", "number")
        .with("editor", "numbereditor")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,int");

    uiAction
        .property("displayOrder")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,INT,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    uiAction
        .property("brief")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    uiAction
        .property("brief")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    uiAction
        .property("imageUrl")
        .with("parent", "string")
        .with("editor", "imageeditor")
        .with("features", "root,visible_all,string,attachment,image")
        .with("searcheditor", "defaulteditor");

    uiAction
        .property("imageUrl")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,ATTACHMENT,DELETE,EXCEL_VIEW,IMAGE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    uiAction
        .property("linkToUrl")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    uiAction
        .property("linkToUrl")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    uiAction
        .property("extraData")
        .with("parent", "string_longtext")
        .with("type", "string_longtext")
        .with("features", "root,visible_all,string,longtext")
        .with("editor", "defaulteditor")
        .with("searcheditor", "defaulteditor");

    uiAction
        .property("extraData")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,LONGTEXT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    uiAction.property("page").with("features", "root,visible_all").with("vg4mobile_app", "页面管理");

    uiAction.property("page").with("parentType", "com.doublechaintech.retailscm.page.Page");

    uiAction
        .property("page")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    uiAction
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    uiAction
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerSection() {
    EntityMeta section =
        MetaProvider.entity("com.doublechaintech.retailscm.section.Section")
            .with("features", "root,visible_all");
    section.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    section
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    section
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    section
        .property("title")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    section
        .property("title")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    section
        .property("brief")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    section
        .property("brief")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    section
        .property("icon")
        .with("parent", "string")
        .with("editor", "imageeditor")
        .with("features", "root,visible_all,string,attachment,image")
        .with("searcheditor", "defaulteditor");

    section
        .property("icon")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,ATTACHMENT,DELETE,EXCEL_VIEW,IMAGE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    section
        .property("displayOrder")
        .with("parent", "number")
        .with("editor", "numbereditor")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,int");

    section
        .property("displayOrder")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,INT,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    section
        .property("viewGroup")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    section
        .property("viewGroup")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    section
        .property("linkToUrl")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    section
        .property("linkToUrl")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    section.property("page").with("features", "root,visible_all").with("vg4mobile_app", "页面管理");

    section.property("page").with("parentType", "com.doublechaintech.retailscm.page.Page");

    section
        .property("page")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    section
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    section
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerUserDomain() {
    EntityMeta userDomain =
        MetaProvider.entity("com.doublechaintech.retailscm.userdomain.UserDomain")
            .with("features", "ootb,no_sample_data,iam")
            .with("zh_CN", "用户域");
    userDomain.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,IAM,PERSISTENCE,SEARCH,SEARCHABLE,UPDATE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    userDomain
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    userDomain
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    userDomain
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    userDomain
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    userDomain
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    userDomain
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerUserAllowList() {
    EntityMeta userAllowList =
        MetaProvider.entity("com.doublechaintech.retailscm.userallowlist.UserAllowList")
            .with("features", "syssetting")
            .with("zh_CN", "用户权限列表");
    userAllowList.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,PREFERENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    userAllowList
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    userAllowList
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    userAllowList
        .property("userIdentity")
        .with("parent", "string")
        .with("features", "root,visible_all,string,mobile")
        .with("editor", "defaulteditor")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "用户标识");

    userAllowList
        .property("userIdentity")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,MOBILE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    userAllowList
        .property("userSpecialFunctions")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "用户特权");

    userAllowList
        .property("userSpecialFunctions")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    userAllowList.property("domain").with("features", "ootb,no_sample_data,iam").with("zh_CN", "域");

    userAllowList
        .property("domain")
        .with("parentType", "com.doublechaintech.retailscm.userdomain.UserDomain");

    userAllowList
        .property("domain")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,IAM,PERSISTENCE,SEARCH,SEARCHABLE,UPDATE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    userAllowList
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    userAllowList
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerSecUser() {
    EntityMeta secUser =
        MetaProvider.entity("com.doublechaintech.retailscm.secuser.SecUser")
            .with("identified_by", "login,email,mobile")
            .with("features", "ootb,custom_manager")
            .with("zh_CN", "安全用户");
    secUser.with(
        "tokens",
        "ACTION,ADD,ADMINUI,CUSTOM_MANAGER,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    secUser
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    secUser
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    secUser
        .property("login")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "登录名");

    secUser
        .property("login")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    secUser
        .property("mobile")
        .with("parent", "string")
        .with("features", "root,visible_all,string,mobile")
        .with("editor", "defaulteditor")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "手机");

    secUser
        .property("mobile")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,IDENTIFIER,MOBILE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    secUser
        .property("email")
        .with("parent", "string")
        .with("editor", "emaileditor")
        .with("features", "root,visible_all,string,email")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "邮箱");

    secUser
        .property("email")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EMAIL,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    secUser
        .property("pwd")
        .with("parent", "string")
        .with("editor", "passwordeditor")
        .with("features", "root,visible_all,string,password")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "密码");

    secUser
        .property("pwd")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PASSWORD,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    secUser
        .property("weixinOpenid")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "微信openId");

    secUser
        .property("weixinOpenid")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    secUser
        .property("weixinAppid")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "微信应用ID");

    secUser
        .property("weixinAppid")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    secUser
        .property("accessToken")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "访问令牌");

    secUser
        .property("accessToken")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    secUser
        .property("verificationCode")
        .with("parent", "number")
        .with("editor", "numbereditor")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,int")
        .with("zh_CN", "验证码");

    secUser
        .property("verificationCode")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,INT,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    secUser
        .property("verificationCodeExpire")
        .with("java_type", "java.util.Date")
        .with("parent", "date")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("searcheditor", "daterangepicker")
        .with("zh_CN", "验证码有效期");

    secUser
        .property("verificationCodeExpire")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    secUser
        .property("lastLoginTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("searcheditor", "daterangepicker")
        .with("zh_CN", "最后登录时间");

    secUser
        .property("lastLoginTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    secUser.property("domain").with("features", "ootb,no_sample_data,iam").with("zh_CN", "域");

    secUser
        .property("domain")
        .with("parentType", "com.doublechaintech.retailscm.userdomain.UserDomain");

    secUser
        .property("domain")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,IAM,PERSISTENCE,SEARCH,SEARCHABLE,UPDATE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    secUser
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    secUser
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerUserApp() {
    EntityMeta userApp =
        MetaProvider.entity("com.doublechaintech.retailscm.userapp.UserApp")
            .with("features", "ootb,custom_manager")
            .with("zh_CN", "应用");
    userApp.with(
        "tokens",
        "ACTION,ADD,ADMINUI,CUSTOM_MANAGER,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    userApp
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    userApp
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    userApp
        .property("title")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "标题");

    userApp
        .property("title")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    userApp
        .property("secUser")
        .with("identified_by", "login,email,mobile")
        .with("features", "ootb,custom_manager")
        .with("zh_CN", "系统用户");

    userApp.property("secUser").with("parentType", "com.doublechaintech.retailscm.secuser.SecUser");

    userApp
        .property("secUser")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,CUSTOM_MANAGER,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    userApp
        .property("appIcon")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "图标");

    userApp
        .property("appIcon")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    userApp
        .property("fullAccess")
        .with("editor", "booleaneditor")
        .with("features", "root,visible_all,bool")
        .with("zh_CN", "完全访问")
        .with("ignoreChecker", "true");

    userApp
        .property("fullAccess")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,BOOL,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    userApp
        .property("permission")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "权限");

    userApp
        .property("permission")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    userApp
        .property("appType")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "对象类型");

    userApp
        .property("appType")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    userApp
        .property("appId")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "对象ID");

    userApp
        .property("appId")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    userApp
        .property("ctxType")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "上下文类型");

    userApp
        .property("ctxType")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    userApp
        .property("ctxId")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "上下文类型");

    userApp
        .property("ctxId")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    userApp
        .property("location")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "位置");

    userApp
        .property("location")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    userApp
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    userApp
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerQuickLink() {
    EntityMeta quickLink =
        MetaProvider.entity("com.doublechaintech.retailscm.quicklink.QuickLink")
            .with("features", "ootb");
    quickLink.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    quickLink
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    quickLink
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    quickLink
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    quickLink
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    quickLink
        .property("icon")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    quickLink
        .property("icon")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    quickLink
        .property("imagePath")
        .with("parent", "string")
        .with("editor", "imageeditor")
        .with("features", "root,visible_all,string,attachment,image")
        .with("searcheditor", "defaulteditor");

    quickLink
        .property("imagePath")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,ATTACHMENT,DELETE,EXCEL_VIEW,IMAGE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    quickLink
        .property("linkTarget")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor");

    quickLink
        .property("linkTarget")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    quickLink
        .property("createTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker");

    quickLink
        .property("createTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    quickLink.property("app").with("features", "ootb,custom_manager").with("zh_CN", "应用");

    quickLink.property("app").with("parentType", "com.doublechaintech.retailscm.userapp.UserApp");

    quickLink
        .property("app")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,CUSTOM_MANAGER,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    quickLink
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    quickLink
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerListAccess() {
    EntityMeta listAccess =
        MetaProvider.entity("com.doublechaintech.retailscm.listaccess.ListAccess")
            .with("features", "ootb")
            .with("zh_CN", "列表访问控制");
    listAccess.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    listAccess
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    listAccess
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    listAccess
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "名称");

    listAccess
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    listAccess
        .property("internalName")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "内部名称");

    listAccess
        .property("internalName")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    listAccess
        .property("readPermission")
        .with("editor", "booleaneditor")
        .with("features", "root,visible_all,bool")
        .with("zh_CN", "可读")
        .with("ignoreChecker", "true");

    listAccess
        .property("readPermission")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,BOOL,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    listAccess
        .property("createPermission")
        .with("editor", "booleaneditor")
        .with("features", "root,visible_all,bool")
        .with("zh_CN", "可创建")
        .with("ignoreChecker", "true");

    listAccess
        .property("createPermission")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,BOOL,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    listAccess
        .property("deletePermission")
        .with("editor", "booleaneditor")
        .with("features", "root,visible_all,bool")
        .with("zh_CN", "可删除")
        .with("ignoreChecker", "true");

    listAccess
        .property("deletePermission")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,BOOL,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    listAccess
        .property("updatePermission")
        .with("editor", "booleaneditor")
        .with("features", "root,visible_all,bool")
        .with("zh_CN", "可更新")
        .with("ignoreChecker", "true");

    listAccess
        .property("updatePermission")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,BOOL,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    listAccess
        .property("executionPermission")
        .with("editor", "booleaneditor")
        .with("features", "root,visible_all,bool")
        .with("zh_CN", "可执行")
        .with("ignoreChecker", "true");

    listAccess
        .property("executionPermission")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,BOOL,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    listAccess.property("app").with("features", "ootb,custom_manager").with("zh_CN", "应用");

    listAccess.property("app").with("parentType", "com.doublechaintech.retailscm.userapp.UserApp");

    listAccess
        .property("app")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,CUSTOM_MANAGER,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    listAccess
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    listAccess
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerLoginHistory() {
    EntityMeta loginHistory =
        MetaProvider.entity("com.doublechaintech.retailscm.loginhistory.LoginHistory")
            .with("features", "syslog")
            .with("zh_CN", "登录历史");
    loginHistory.with(
        "tokens",
        "ACTION,ADMINUI,EXCEL_VIEW,LOG,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    loginHistory
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    loginHistory
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    loginHistory
        .property("loginTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker")
        .with("zh_CN", "登录时间");

    loginHistory
        .property("loginTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    loginHistory
        .property("fromIp")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "来自IP");

    loginHistory
        .property("fromIp")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    loginHistory
        .property("description")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "描述");

    loginHistory
        .property("description")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    loginHistory
        .property("secUser")
        .with("identified_by", "login,email,mobile")
        .with("features", "ootb,custom_manager")
        .with("zh_CN", "系统用户");

    loginHistory
        .property("secUser")
        .with("parentType", "com.doublechaintech.retailscm.secuser.SecUser");

    loginHistory
        .property("secUser")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,CUSTOM_MANAGER,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    loginHistory
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    loginHistory
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerCandidateContainer() {
    EntityMeta candidateContainer =
        MetaProvider.entity("com.doublechaintech.retailscm.candidatecontainer.CandidateContainer")
            .with("features", "internal,ootb")
            .with("zh_CN", "候选容器");
    candidateContainer.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    candidateContainer
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    candidateContainer
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    candidateContainer
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "名称");

    candidateContainer
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    candidateContainer
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    candidateContainer
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerCandidateElement() {
    EntityMeta candidateElement =
        MetaProvider.entity("com.doublechaintech.retailscm.candidateelement.CandidateElement")
            .with("features", "internal,ootb");
    candidateElement.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    candidateElement
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    candidateElement
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    candidateElement
        .property("name")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "标题");

    candidateElement
        .property("name")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    candidateElement
        .property("type")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "类型");

    candidateElement
        .property("type")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    candidateElement
        .property("image")
        .with("parent", "string")
        .with("editor", "imageeditor")
        .with("features", "root,visible_all,string,attachment,image")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "图像");

    candidateElement
        .property("image")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,ATTACHMENT,DELETE,EXCEL_VIEW,IMAGE,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    candidateElement.property("container").with("features", "internal,ootb").with("zh_CN", "容器");

    candidateElement
        .property("container")
        .with("parentType", "com.doublechaintech.retailscm.candidatecontainer.CandidateContainer");

    candidateElement
        .property("container")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    candidateElement
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    candidateElement
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerWechatWorkappIdentity() {
    EntityMeta wechatWorkappIdentity =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentity")
            .with("features", "root,visible_all")
            .with("zh_CN", "企业微信认证");
    wechatWorkappIdentity.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    wechatWorkappIdentity
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    wechatWorkappIdentity
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    wechatWorkappIdentity
        .property("corpId")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "公司");

    wechatWorkappIdentity
        .property("corpId")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    wechatWorkappIdentity
        .property("userId")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "用户");

    wechatWorkappIdentity
        .property("userId")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    wechatWorkappIdentity
        .property("secUser")
        .with("identified_by", "login,email,mobile")
        .with("features", "ootb,custom_manager")
        .with("zh_CN", "系统用户");

    wechatWorkappIdentity
        .property("secUser")
        .with("parentType", "com.doublechaintech.retailscm.secuser.SecUser");

    wechatWorkappIdentity
        .property("secUser")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,CUSTOM_MANAGER,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    wechatWorkappIdentity
        .property("createTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker")
        .with("zh_CN", "创建时间");

    wechatWorkappIdentity
        .property("createTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    wechatWorkappIdentity
        .property("lastLoginTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("searcheditor", "daterangepicker")
        .with("zh_CN", "最后登录时间");

    wechatWorkappIdentity
        .property("lastLoginTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    wechatWorkappIdentity
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    wechatWorkappIdentity
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerWechatMiniappIdentity() {
    EntityMeta wechatMiniappIdentity =
        MetaProvider.entity(
                "com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentity")
            .with("features", "root,visible_all")
            .with("zh_CN", "微信小程序认证");
    wechatMiniappIdentity.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    wechatMiniappIdentity
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    wechatMiniappIdentity
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    wechatMiniappIdentity
        .property("openId")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "openId");

    wechatMiniappIdentity
        .property("openId")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    wechatMiniappIdentity
        .property("appId")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "应用ID");

    wechatMiniappIdentity
        .property("appId")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    wechatMiniappIdentity
        .property("unionId")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "UnionID");

    wechatMiniappIdentity
        .property("unionId")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    wechatMiniappIdentity
        .property("secUser")
        .with("identified_by", "login,email,mobile")
        .with("features", "ootb,custom_manager")
        .with("zh_CN", "系统用户");

    wechatMiniappIdentity
        .property("secUser")
        .with("parentType", "com.doublechaintech.retailscm.secuser.SecUser");

    wechatMiniappIdentity
        .property("secUser")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,CUSTOM_MANAGER,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    wechatMiniappIdentity
        .property("createTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker")
        .with("zh_CN", "创建时间");

    wechatMiniappIdentity
        .property("createTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    wechatMiniappIdentity
        .property("lastLoginTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("searcheditor", "daterangepicker")
        .with("zh_CN", "最后登录时间");

    wechatMiniappIdentity
        .property("lastLoginTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    wechatMiniappIdentity
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    wechatMiniappIdentity
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerKeyPairIdentity() {
    EntityMeta keyPairIdentity =
        MetaProvider.entity("com.doublechaintech.retailscm.keypairidentity.KeyPairIdentity")
            .with("features", "root,visible_all")
            .with("zh_CN", "秘钥对认证");
    keyPairIdentity.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    keyPairIdentity
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    keyPairIdentity
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    keyPairIdentity
        .property("publicKey")
        .with("parent", "string_longtext")
        .with("type", "string_longtext")
        .with("features", "root,visible_all,string,longtext")
        .with("editor", "defaulteditor")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "公钥");

    keyPairIdentity
        .property("publicKey")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,LONGTEXT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    keyPairIdentity.property("keyType").with("features", "root,visible_all").with("zh_CN", "秘钥类型");

    keyPairIdentity
        .property("keyType")
        .with("parentType", "com.doublechaintech.retailscm.publickeytype.PublicKeyType");

    keyPairIdentity
        .property("keyType")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    keyPairIdentity
        .property("secUser")
        .with("identified_by", "login,email,mobile")
        .with("features", "ootb,custom_manager")
        .with("zh_CN", "系统用户");

    keyPairIdentity
        .property("secUser")
        .with("parentType", "com.doublechaintech.retailscm.secuser.SecUser");

    keyPairIdentity
        .property("secUser")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,CUSTOM_MANAGER,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    keyPairIdentity
        .property("createTime")
        .with("java_type", "java.util.Date")
        .with("parent", "date_time")
        .with("editor", "datepicker")
        .with(
            "features", "root,visible_all,date,search_between,search_before,search_after,date_time")
        .with("auto_value", "userContext.now()")
        .with("searcheditor", "daterangepicker")
        .with("zh_CN", "创建时间");

    keyPairIdentity
        .property("createTime")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DATE,DATE_TIME,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_AFTER,SEARCH_BEFORE,SEARCH_BETWEEN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    keyPairIdentity
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    keyPairIdentity
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerPublicKeyType() {
    EntityMeta publicKeyType =
        MetaProvider.entity("com.doublechaintech.retailscm.publickeytype.PublicKeyType")
            .with("features", "root,visible_all")
            .with("zh_CN", "公钥类型");
    publicKeyType.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    publicKeyType
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    publicKeyType
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    publicKeyType
        .property("keyAlg")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "加密算法");

    publicKeyType
        .property("keyAlg")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    publicKeyType
        .property("signAlg")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "签名算法");

    publicKeyType
        .property("signAlg")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    publicKeyType.property("domain").with("features", "ootb,no_sample_data,iam").with("zh_CN", "域");

    publicKeyType
        .property("domain")
        .with("parentType", "com.doublechaintech.retailscm.userdomain.UserDomain");

    publicKeyType
        .property("domain")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,IAM,PERSISTENCE,SEARCH,SEARCHABLE,UPDATE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    publicKeyType
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    publicKeyType
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }

  public void registerTreeNode() {
    EntityMeta treeNode =
        MetaProvider.entity("com.doublechaintech.retailscm.treenode.TreeNode")
            .with("features", "root,visible_all")
            .with("zh_CN", "节点");
    treeNode.with(
        "tokens",
        "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    treeNode
        .property("id")
        .with("features", "root,visible_all,string,identifier,entity_base")
        .with("range_expression", "2,64")
        .with("editor", "defaulteditor")
        .with("type", "string")
        .with("searcheditor", "defaulteditor")
        .with("value", "AB")
        .with("parent", "string")
        .with("ui_ignore", "true");

    treeNode
        .property("id")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,IDENTIFIER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    treeNode
        .property("nodeId")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "节点ID");

    treeNode
        .property("nodeId")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    treeNode
        .property("nodeType")
        .with("editor", "defaulteditor")
        .with("features", "root,visible_all,string")
        .with("searcheditor", "defaulteditor")
        .with("zh_CN", "节点类型");

    treeNode
        .property("nodeType")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,STRING,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    treeNode
        .property("leftValue")
        .with("parent", "number")
        .with("editor", "numbereditor")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,int")
        .with("zh_CN", "左值");

    treeNode
        .property("leftValue")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,INT,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    treeNode
        .property("rightValue")
        .with("parent", "number")
        .with("editor", "numbereditor")
        .with(
            "features",
            "root,visible_all,number,search_between,search_greater_than,search_less_than,int")
        .with("zh_CN", "右值");

    treeNode
        .property("rightValue")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,EXCEL_VIEW,INT,NUMBER,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,SEARCH_BETWEEN,SEARCH_GREATER_THAN,SEARCH_LESS_THAN,UPDATE,USERSPACE,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");

    treeNode
        .property("version")
        .with("type", "int")
        .with("parent", "int")
        .with("ui_ignore", "true")
        .with("features", "root,visible_all,int,version,entity_base")
        .with("value", "2147483647");

    treeNode
        .property("version")
        .with(
            "tokens",
            "ACTION,ADD,ADMINUI,DELETE,ENTITY_BASE,EXCEL_VIEW,INT,PERSISTENCE,SAMPLE_DATA,SEARCH,SEARCHABLE,UPDATE,USERSPACE,VERSION,VIEWDETAIL,VISIBLE_CHILD,VISIBLE_PARENT");
  }
}
