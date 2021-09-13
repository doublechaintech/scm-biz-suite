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



    public void  registerRetailStoreCountryCenter(){
        EntityMeta retailStoreCountryCenter = MetaProvider.entity("com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter")
                  
                        .with("features", "root,visible_all")
                  ;
                  retailStoreCountryCenter.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    retailStoreCountryCenter.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    retailStoreCountryCenter.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreCountryCenter.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreCountryCenter.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreCountryCenter.property("serviceNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreCountryCenter.property("serviceNumber")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreCountryCenter.property("founded")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    retailStoreCountryCenter.property("founded")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreCountryCenter.property("webSite")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreCountryCenter.property("webSite")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreCountryCenter.property("address")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreCountryCenter.property("address")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreCountryCenter.property("operatedBy")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreCountryCenter.property("operatedBy")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreCountryCenter.property("legalRepresentative")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreCountryCenter.property("legalRepresentative")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreCountryCenter.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreCountryCenter.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreCountryCenter.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    retailStoreCountryCenter.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerCatalog(){
        EntityMeta catalog = MetaProvider.entity("com.doublechaintech.retailscm.catalog.Catalog")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4owner", "产品管理")
                  ;
                  catalog.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    catalog.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    catalog.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    catalog.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    catalog.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    catalog.property("owner")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    catalog.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    catalog.property("owner")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    catalog.property("subCount")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    
                    catalog.property("subCount")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    catalog.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    catalog.property("amount")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    catalog.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    catalog.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerLevelOneCategory(){
        EntityMeta levelOneCategory = MetaProvider.entity("com.doublechaintech.retailscm.levelonecategory.LevelOneCategory")
                  
                        .with("features", "root,visible_all")
                  ;
                  levelOneCategory.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    levelOneCategory.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    levelOneCategory.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelOneCategory.property("catalog")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "产品管理")
                      ;
                    
                    levelOneCategory.property("catalog")
                        .with("parentType", "com.doublechaintech.retailscm.catalog.Catalog");
                    
                    levelOneCategory.property("catalog")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelOneCategory.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    levelOneCategory.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelOneCategory.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    levelOneCategory.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerLevelTwoCategory(){
        EntityMeta levelTwoCategory = MetaProvider.entity("com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory")
                  
                        .with("features", "root,visible_all")
                  ;
                  levelTwoCategory.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    levelTwoCategory.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    levelTwoCategory.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelTwoCategory.property("parentCategory")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    levelTwoCategory.property("parentCategory")
                        .with("parentType", "com.doublechaintech.retailscm.levelonecategory.LevelOneCategory");
                    
                    levelTwoCategory.property("parentCategory")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelTwoCategory.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    levelTwoCategory.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelTwoCategory.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    levelTwoCategory.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerLevelThreeCategory(){
        EntityMeta levelThreeCategory = MetaProvider.entity("com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory")
                  
                        .with("features", "root,visible_all")
                  ;
                  levelThreeCategory.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    levelThreeCategory.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    levelThreeCategory.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelThreeCategory.property("parentCategory")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    levelThreeCategory.property("parentCategory")
                        .with("parentType", "com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory");
                    
                    levelThreeCategory.property("parentCategory")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelThreeCategory.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    levelThreeCategory.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelThreeCategory.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    levelThreeCategory.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerProduct(){
        EntityMeta product = MetaProvider.entity("com.doublechaintech.retailscm.product.Product")
                  
                        .with("features", "root,visible_all")
                  ;
                  product.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    product.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    product.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    product.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    product.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    product.property("parentCategory")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    product.property("parentCategory")
                        .with("parentType", "com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory");
                    
                    product.property("parentCategory")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    product.property("origin")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    product.property("origin")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    product.property("remark")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    product.property("remark")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    product.property("brand")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    product.property("brand")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    product.property("picture")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      ;
                    
                    product.property("picture")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,IMAGE,DELETE,VISIBLE_PARENT,VIEWDETAIL,ATTACHMENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    product.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    product.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    product.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    product.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerSku(){
        EntityMeta sku = MetaProvider.entity("com.doublechaintech.retailscm.sku.Sku")
                  
                        .with("features", "root,visible_all")
                  ;
                  sku.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    sku.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    sku.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    sku.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    sku.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    sku.property("size")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    sku.property("size")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    sku.property("product")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    sku.property("product")
                        .with("parentType", "com.doublechaintech.retailscm.product.Product");
                    
                    sku.property("product")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    sku.property("barcode")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    sku.property("barcode")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    sku.property("packageType")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    sku.property("packageType")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    sku.property("netContent")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    sku.property("netContent")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    sku.property("price")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    sku.property("price")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    sku.property("picture")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      ;
                    
                    sku.property("picture")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,IMAGE,DELETE,VISIBLE_PARENT,VIEWDETAIL,ATTACHMENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    sku.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    sku.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerRetailStoreProvinceCenter(){
        EntityMeta retailStoreProvinceCenter = MetaProvider.entity("com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter")
                  
                        .with("vg4country", "组织机构")
                  
                        .with("features", "root,visible_all")
                  ;
                  retailStoreProvinceCenter.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    retailStoreProvinceCenter.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    retailStoreProvinceCenter.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreProvinceCenter.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreProvinceCenter.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreProvinceCenter.property("founded")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    retailStoreProvinceCenter.property("founded")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreProvinceCenter.property("country")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStoreProvinceCenter.property("country")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    retailStoreProvinceCenter.property("country")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreProvinceCenter.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    retailStoreProvinceCenter.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreProvinceCenter.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    retailStoreProvinceCenter.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerProvinceCenterDepartment(){
        EntityMeta provinceCenterDepartment = MetaProvider.entity("com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment")
                  
                        .with("features", "setting")
                  ;
                  provinceCenterDepartment.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");
                  
                    provinceCenterDepartment.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    provinceCenterDepartment.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    provinceCenterDepartment.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    provinceCenterDepartment.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    provinceCenterDepartment.property("founded")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    provinceCenterDepartment.property("founded")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    provinceCenterDepartment.property("provinceCenter")
                      
                        .with("vg4country", "组织机构")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    provinceCenterDepartment.property("provinceCenter")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter");
                    
                    provinceCenterDepartment.property("provinceCenter")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    provinceCenterDepartment.property("manager")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    provinceCenterDepartment.property("manager")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    provinceCenterDepartment.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    provinceCenterDepartment.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerProvinceCenterEmployee(){
        EntityMeta provinceCenterEmployee = MetaProvider.entity("com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee")
                  
                        .with("features", "root,visible_all")
                  ;
                  provinceCenterEmployee.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    provinceCenterEmployee.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    provinceCenterEmployee.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    provinceCenterEmployee.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    provinceCenterEmployee.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    provinceCenterEmployee.property("mobile")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    
                    provinceCenterEmployee.property("mobile")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,MOBILE,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    provinceCenterEmployee.property("email")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,email")
                      ;
                    
                    provinceCenterEmployee.property("email")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,EMAIL,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    provinceCenterEmployee.property("founded")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    provinceCenterEmployee.property("founded")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    provinceCenterEmployee.property("department")
                      
                        .with("features", "setting")
                      ;
                    
                    provinceCenterEmployee.property("department")
                        .with("parentType", "com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment");
                    
                    provinceCenterEmployee.property("department")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");

                    
                  
                    provinceCenterEmployee.property("provinceCenter")
                      
                        .with("vg4country", "组织机构")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    provinceCenterEmployee.property("provinceCenter")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter");
                    
                    provinceCenterEmployee.property("provinceCenter")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    provinceCenterEmployee.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    provinceCenterEmployee.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerRetailStoreCityServiceCenter(){
        EntityMeta retailStoreCityServiceCenter = MetaProvider.entity("com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter")
                  
                        .with("features", "root,visible_all")
                  ;
                  retailStoreCityServiceCenter.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    retailStoreCityServiceCenter.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    retailStoreCityServiceCenter.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreCityServiceCenter.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreCityServiceCenter.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreCityServiceCenter.property("founded")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    retailStoreCityServiceCenter.property("founded")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreCityServiceCenter.property("belongsTo")
                      
                        .with("vg4country", "组织机构")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStoreCityServiceCenter.property("belongsTo")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter");
                    
                    retailStoreCityServiceCenter.property("belongsTo")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreCityServiceCenter.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    retailStoreCityServiceCenter.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreCityServiceCenter.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    retailStoreCityServiceCenter.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerCityPartner(){
        EntityMeta cityPartner = MetaProvider.entity("com.doublechaintech.retailscm.citypartner.CityPartner")
                  
                        .with("features", "root,visible_all")
                  ;
                  cityPartner.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    cityPartner.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    cityPartner.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    cityPartner.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    cityPartner.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    cityPartner.property("mobile")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    
                    cityPartner.property("mobile")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,MOBILE,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    cityPartner.property("cityServiceCenter")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    cityPartner.property("cityServiceCenter")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter");
                    
                    cityPartner.property("cityServiceCenter")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    cityPartner.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    cityPartner.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    cityPartner.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    cityPartner.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    cityPartner.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    cityPartner.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerPotentialCustomer(){
        EntityMeta potentialCustomer = MetaProvider.entity("com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer")
                  
                        .with("features", "root,visible_all")
                  ;
                  potentialCustomer.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    potentialCustomer.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    potentialCustomer.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomer.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    potentialCustomer.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomer.property("mobile")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    
                    potentialCustomer.property("mobile")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,MOBILE,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomer.property("cityServiceCenter")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    potentialCustomer.property("cityServiceCenter")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter");
                    
                    potentialCustomer.property("cityServiceCenter")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomer.property("cityPartner")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    potentialCustomer.property("cityPartner")
                        .with("parentType", "com.doublechaintech.retailscm.citypartner.CityPartner");
                    
                    potentialCustomer.property("cityPartner")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomer.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    potentialCustomer.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomer.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    potentialCustomer.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomer.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    potentialCustomer.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerPotentialCustomerContactPerson(){
        EntityMeta potentialCustomerContactPerson = MetaProvider.entity("com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson")
                  
                        .with("features", "root,visible_all")
                  ;
                  potentialCustomerContactPerson.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    potentialCustomerContactPerson.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    potentialCustomerContactPerson.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomerContactPerson.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    potentialCustomerContactPerson.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomerContactPerson.property("mobile")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    
                    potentialCustomerContactPerson.property("mobile")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,MOBILE,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomerContactPerson.property("potentialCustomer")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    potentialCustomerContactPerson.property("potentialCustomer")
                        .with("parentType", "com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer");
                    
                    potentialCustomerContactPerson.property("potentialCustomer")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomerContactPerson.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    potentialCustomerContactPerson.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomerContactPerson.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    potentialCustomerContactPerson.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerPotentialCustomerContact(){
        EntityMeta potentialCustomerContact = MetaProvider.entity("com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact")
                  
                        .with("features", "root,visible_all")
                  ;
                  potentialCustomerContact.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    potentialCustomerContact.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    potentialCustomerContact.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomerContact.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    potentialCustomerContact.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomerContact.property("contactDate")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    potentialCustomerContact.property("contactDate")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomerContact.property("contactMethod")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    potentialCustomerContact.property("contactMethod")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomerContact.property("potentialCustomer")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    potentialCustomerContact.property("potentialCustomer")
                        .with("parentType", "com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer");
                    
                    potentialCustomerContact.property("potentialCustomer")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomerContact.property("cityPartner")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    potentialCustomerContact.property("cityPartner")
                        .with("parentType", "com.doublechaintech.retailscm.citypartner.CityPartner");
                    
                    potentialCustomerContact.property("cityPartner")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomerContact.property("contactTo")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    potentialCustomerContact.property("contactTo")
                        .with("parentType", "com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson");
                    
                    potentialCustomerContact.property("contactTo")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomerContact.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    potentialCustomerContact.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomerContact.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    potentialCustomerContact.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    potentialCustomerContact.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    potentialCustomerContact.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerCityEvent(){
        EntityMeta cityEvent = MetaProvider.entity("com.doublechaintech.retailscm.cityevent.CityEvent")
                  
                        .with("features", "root,visible_all")
                  ;
                  cityEvent.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    cityEvent.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    cityEvent.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    cityEvent.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    cityEvent.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    cityEvent.property("mobile")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    
                    cityEvent.property("mobile")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,MOBILE,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    cityEvent.property("cityServiceCenter")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    cityEvent.property("cityServiceCenter")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter");
                    
                    cityEvent.property("cityServiceCenter")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    cityEvent.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    cityEvent.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    cityEvent.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    cityEvent.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    cityEvent.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    cityEvent.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerEventAttendance(){
        EntityMeta eventAttendance = MetaProvider.entity("com.doublechaintech.retailscm.eventattendance.EventAttendance")
                  
                        .with("features", "root,visible_all")
                  ;
                  eventAttendance.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    eventAttendance.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    eventAttendance.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    eventAttendance.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    eventAttendance.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    eventAttendance.property("potentialCustomer")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    eventAttendance.property("potentialCustomer")
                        .with("parentType", "com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer");
                    
                    eventAttendance.property("potentialCustomer")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    eventAttendance.property("cityEvent")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    eventAttendance.property("cityEvent")
                        .with("parentType", "com.doublechaintech.retailscm.cityevent.CityEvent");
                    
                    eventAttendance.property("cityEvent")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    eventAttendance.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    eventAttendance.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    eventAttendance.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    eventAttendance.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerRetailStore(){
        EntityMeta retailStore = MetaProvider.entity("com.doublechaintech.retailscm.retailstore.RetailStore")
                  
                        .with("vg4retail_store_country_center", "加盟管理")
                  
                        .with("features", "root,visible_all")
                  ;
                  retailStore.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    retailStore.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    retailStore.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStore.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStore.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStore.property("telephone")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStore.property("telephone")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStore.property("owner")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStore.property("owner")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStore.property("retailStoreCountryCenter")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStore.property("retailStoreCountryCenter")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    retailStore.property("retailStoreCountryCenter")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStore.property("cityServiceCenter")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStore.property("cityServiceCenter")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter");
                    
                    retailStore.property("cityServiceCenter")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStore.property("creation")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStore.property("creation")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation");
                    
                    retailStore.property("creation")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStore.property("investmentInvitation")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStore.property("investmentInvitation")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation");
                    
                    retailStore.property("investmentInvitation")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStore.property("franchising")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStore.property("franchising")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising");
                    
                    retailStore.property("franchising")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStore.property("decoration")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStore.property("decoration")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration");
                    
                    retailStore.property("decoration")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStore.property("opening")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStore.property("opening")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening");
                    
                    retailStore.property("opening")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStore.property("closing")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStore.property("closing")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing");
                    
                    retailStore.property("closing")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStore.property("founded")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    retailStore.property("founded")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStore.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    retailStore.property("latitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    retailStore.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    retailStore.property("longitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    retailStore.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStore.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStore.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    retailStore.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStore.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    retailStore.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerRetailStoreCreation(){
        EntityMeta retailStoreCreation = MetaProvider.entity("com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation")
                  
                        .with("features", "root,visible_all")
                  ;
                  retailStoreCreation.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    retailStoreCreation.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    retailStoreCreation.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreCreation.property("comment")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreCreation.property("comment")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreCreation.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    retailStoreCreation.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerRetailStoreInvestmentInvitation(){
        EntityMeta retailStoreInvestmentInvitation = MetaProvider.entity("com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation")
                  
                        .with("features", "root,visible_all")
                  ;
                  retailStoreInvestmentInvitation.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    retailStoreInvestmentInvitation.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    retailStoreInvestmentInvitation.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreInvestmentInvitation.property("comment")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreInvestmentInvitation.property("comment")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreInvestmentInvitation.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    retailStoreInvestmentInvitation.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerRetailStoreFranchising(){
        EntityMeta retailStoreFranchising = MetaProvider.entity("com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising")
                  
                        .with("features", "root,visible_all")
                  ;
                  retailStoreFranchising.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    retailStoreFranchising.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    retailStoreFranchising.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreFranchising.property("comment")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreFranchising.property("comment")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreFranchising.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    retailStoreFranchising.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerRetailStoreDecoration(){
        EntityMeta retailStoreDecoration = MetaProvider.entity("com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration")
                  
                        .with("features", "root,visible_all")
                  ;
                  retailStoreDecoration.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    retailStoreDecoration.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    retailStoreDecoration.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreDecoration.property("comment")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreDecoration.property("comment")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreDecoration.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    retailStoreDecoration.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerRetailStoreOpening(){
        EntityMeta retailStoreOpening = MetaProvider.entity("com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening")
                  
                        .with("features", "root,visible_all")
                  ;
                  retailStoreOpening.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    retailStoreOpening.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    retailStoreOpening.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOpening.property("comment")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreOpening.property("comment")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOpening.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    retailStoreOpening.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerRetailStoreClosing(){
        EntityMeta retailStoreClosing = MetaProvider.entity("com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing")
                  
                        .with("features", "root,visible_all")
                  ;
                  retailStoreClosing.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    retailStoreClosing.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    retailStoreClosing.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreClosing.property("comment")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreClosing.property("comment")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreClosing.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    retailStoreClosing.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerRetailStoreMember(){
        EntityMeta retailStoreMember = MetaProvider.entity("com.doublechaintech.retailscm.retailstoremember.RetailStoreMember")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4owner", "会员管理")
                  ;
                  retailStoreMember.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    retailStoreMember.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    retailStoreMember.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMember.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreMember.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMember.property("mobilePhone")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    
                    retailStoreMember.property("mobilePhone")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,MOBILE,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMember.property("owner")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStoreMember.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    retailStoreMember.property("owner")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMember.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    retailStoreMember.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerConsumerOrder(){
        EntityMeta consumerOrder = MetaProvider.entity("com.doublechaintech.retailscm.consumerorder.ConsumerOrder")
                  
                        .with("features", "root,visible_all")
                  ;
                  consumerOrder.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    consumerOrder.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    consumerOrder.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrder.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    consumerOrder.property("title")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrder.property("consumer")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "会员管理")
                      ;
                    
                    consumerOrder.property("consumer")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");
                    
                    consumerOrder.property("consumer")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrder.property("store")
                      
                        .with("vg4retail_store_country_center", "加盟管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    consumerOrder.property("store")
                        .with("parentType", "com.doublechaintech.retailscm.retailstore.RetailStore");
                    
                    consumerOrder.property("store")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrder.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    consumerOrder.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrder.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    consumerOrder.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerConsumerOrderLineItem(){
        EntityMeta consumerOrderLineItem = MetaProvider.entity("com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItem")
                  
                        .with("features", "root,visible_all")
                  ;
                  consumerOrderLineItem.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    consumerOrderLineItem.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    consumerOrderLineItem.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrderLineItem.property("bizOrder")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    consumerOrderLineItem.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.consumerorder.ConsumerOrder");
                    
                    consumerOrderLineItem.property("bizOrder")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrderLineItem.property("skuId")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    consumerOrderLineItem.property("skuId")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrderLineItem.property("skuName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    consumerOrderLineItem.property("skuName")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrderLineItem.property("price")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    consumerOrderLineItem.property("price")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrderLineItem.property("quantity")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    consumerOrderLineItem.property("quantity")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    consumerOrderLineItem.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    consumerOrderLineItem.property("amount")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrderLineItem.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    consumerOrderLineItem.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrderLineItem.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    consumerOrderLineItem.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerConsumerOrderShippingGroup(){
        EntityMeta consumerOrderShippingGroup = MetaProvider.entity("com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup")
                  
                        .with("features", "root,visible_all")
                  ;
                  consumerOrderShippingGroup.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    consumerOrderShippingGroup.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    consumerOrderShippingGroup.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrderShippingGroup.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    consumerOrderShippingGroup.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrderShippingGroup.property("bizOrder")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    consumerOrderShippingGroup.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.consumerorder.ConsumerOrder");
                    
                    consumerOrderShippingGroup.property("bizOrder")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrderShippingGroup.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    consumerOrderShippingGroup.property("amount")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrderShippingGroup.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    consumerOrderShippingGroup.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerConsumerOrderPaymentGroup(){
        EntityMeta consumerOrderPaymentGroup = MetaProvider.entity("com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup")
                  
                        .with("features", "root,visible_all")
                  ;
                  consumerOrderPaymentGroup.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    consumerOrderPaymentGroup.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    consumerOrderPaymentGroup.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrderPaymentGroup.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    consumerOrderPaymentGroup.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrderPaymentGroup.property("bizOrder")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    consumerOrderPaymentGroup.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.consumerorder.ConsumerOrder");
                    
                    consumerOrderPaymentGroup.property("bizOrder")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrderPaymentGroup.property("cardNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    consumerOrderPaymentGroup.property("cardNumber")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrderPaymentGroup.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    consumerOrderPaymentGroup.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerConsumerOrderPriceAdjustment(){
        EntityMeta consumerOrderPriceAdjustment = MetaProvider.entity("com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment")
                  
                        .with("features", "root,visible_all")
                  ;
                  consumerOrderPriceAdjustment.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    consumerOrderPriceAdjustment.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    consumerOrderPriceAdjustment.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrderPriceAdjustment.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    consumerOrderPriceAdjustment.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrderPriceAdjustment.property("bizOrder")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    consumerOrderPriceAdjustment.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.consumerorder.ConsumerOrder");
                    
                    consumerOrderPriceAdjustment.property("bizOrder")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrderPriceAdjustment.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    consumerOrderPriceAdjustment.property("amount")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrderPriceAdjustment.property("provider")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    consumerOrderPriceAdjustment.property("provider")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    consumerOrderPriceAdjustment.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    consumerOrderPriceAdjustment.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerRetailStoreMemberCoupon(){
        EntityMeta retailStoreMemberCoupon = MetaProvider.entity("com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon")
                  
                        .with("features", "root,visible_all")
                  ;
                  retailStoreMemberCoupon.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    retailStoreMemberCoupon.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    retailStoreMemberCoupon.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberCoupon.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreMemberCoupon.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberCoupon.property("owner")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "会员管理")
                      ;
                    
                    retailStoreMemberCoupon.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");
                    
                    retailStoreMemberCoupon.property("owner")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberCoupon.property("number")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreMemberCoupon.property("number")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberCoupon.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    retailStoreMemberCoupon.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberCoupon.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    retailStoreMemberCoupon.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerMemberWishlist(){
        EntityMeta memberWishlist = MetaProvider.entity("com.doublechaintech.retailscm.memberwishlist.MemberWishlist")
                  
                        .with("features", "root,visible_all")
                  ;
                  memberWishlist.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    memberWishlist.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    memberWishlist.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    memberWishlist.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    memberWishlist.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    memberWishlist.property("owner")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "会员管理")
                      ;
                    
                    memberWishlist.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");
                    
                    memberWishlist.property("owner")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    memberWishlist.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    memberWishlist.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerMemberRewardPoint(){
        EntityMeta memberRewardPoint = MetaProvider.entity("com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPoint")
                  
                        .with("features", "root,visible_all")
                  ;
                  memberRewardPoint.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    memberRewardPoint.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    memberRewardPoint.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    memberRewardPoint.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    memberRewardPoint.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    memberRewardPoint.property("point")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    
                    memberRewardPoint.property("point")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    memberRewardPoint.property("owner")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "会员管理")
                      ;
                    
                    memberRewardPoint.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");
                    
                    memberRewardPoint.property("owner")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    memberRewardPoint.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    memberRewardPoint.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerMemberRewardPointRedemption(){
        EntityMeta memberRewardPointRedemption = MetaProvider.entity("com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemption")
                  
                        .with("features", "root,visible_all")
                  ;
                  memberRewardPointRedemption.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    memberRewardPointRedemption.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    memberRewardPointRedemption.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    memberRewardPointRedemption.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    memberRewardPointRedemption.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    memberRewardPointRedemption.property("point")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    
                    memberRewardPointRedemption.property("point")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    memberRewardPointRedemption.property("owner")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "会员管理")
                      ;
                    
                    memberRewardPointRedemption.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");
                    
                    memberRewardPointRedemption.property("owner")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    memberRewardPointRedemption.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    memberRewardPointRedemption.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerMemberWishlistProduct(){
        EntityMeta memberWishlistProduct = MetaProvider.entity("com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProduct")
                  
                        .with("features", "root,visible_all")
                  ;
                  memberWishlistProduct.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    memberWishlistProduct.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    memberWishlistProduct.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    memberWishlistProduct.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    memberWishlistProduct.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    memberWishlistProduct.property("owner")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    memberWishlistProduct.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.memberwishlist.MemberWishlist");
                    
                    memberWishlistProduct.property("owner")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    memberWishlistProduct.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    memberWishlistProduct.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerRetailStoreMemberAddress(){
        EntityMeta retailStoreMemberAddress = MetaProvider.entity("com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddress")
                  
                        .with("features", "root,visible_all")
                  ;
                  retailStoreMemberAddress.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    retailStoreMemberAddress.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    retailStoreMemberAddress.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberAddress.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreMemberAddress.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberAddress.property("owner")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "会员管理")
                      ;
                    
                    retailStoreMemberAddress.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");
                    
                    retailStoreMemberAddress.property("owner")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberAddress.property("mobilePhone")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    
                    retailStoreMemberAddress.property("mobilePhone")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,MOBILE,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberAddress.property("address")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreMemberAddress.property("address")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberAddress.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    retailStoreMemberAddress.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerRetailStoreMemberGiftCard(){
        EntityMeta retailStoreMemberGiftCard = MetaProvider.entity("com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard")
                  
                        .with("features", "root,visible_all")
                  ;
                  retailStoreMemberGiftCard.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    retailStoreMemberGiftCard.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    retailStoreMemberGiftCard.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberGiftCard.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreMemberGiftCard.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberGiftCard.property("owner")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "会员管理")
                      ;
                    
                    retailStoreMemberGiftCard.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");
                    
                    retailStoreMemberGiftCard.property("owner")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberGiftCard.property("number")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreMemberGiftCard.property("number")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberGiftCard.property("remain")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    retailStoreMemberGiftCard.property("remain")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberGiftCard.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    retailStoreMemberGiftCard.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerRetailStoreMemberGiftCardConsumeRecord(){
        EntityMeta retailStoreMemberGiftCardConsumeRecord = MetaProvider.entity("com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord")
                  
                        .with("features", "root,visible_all")
                  ;
                  retailStoreMemberGiftCardConsumeRecord.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    retailStoreMemberGiftCardConsumeRecord.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    retailStoreMemberGiftCardConsumeRecord.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberGiftCardConsumeRecord.property("occureTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    retailStoreMemberGiftCardConsumeRecord.property("occureTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberGiftCardConsumeRecord.property("owner")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStoreMemberGiftCardConsumeRecord.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard");
                    
                    retailStoreMemberGiftCardConsumeRecord.property("owner")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberGiftCardConsumeRecord.property("bizOrder")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStoreMemberGiftCardConsumeRecord.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.consumerorder.ConsumerOrder");
                    
                    retailStoreMemberGiftCardConsumeRecord.property("bizOrder")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberGiftCardConsumeRecord.property("number")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreMemberGiftCardConsumeRecord.property("number")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberGiftCardConsumeRecord.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    retailStoreMemberGiftCardConsumeRecord.property("amount")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreMemberGiftCardConsumeRecord.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    retailStoreMemberGiftCardConsumeRecord.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerGoodsSupplier(){
        EntityMeta goodsSupplier = MetaProvider.entity("com.doublechaintech.retailscm.goodssupplier.GoodsSupplier")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4belong_to", "供应管理")
                  ;
                  goodsSupplier.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    goodsSupplier.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    goodsSupplier.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsSupplier.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    goodsSupplier.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsSupplier.property("supplyProduct")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    goodsSupplier.property("supplyProduct")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsSupplier.property("belongTo")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goodsSupplier.property("belongTo")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    goodsSupplier.property("belongTo")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsSupplier.property("contactNumber")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    
                    goodsSupplier.property("contactNumber")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,MOBILE,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsSupplier.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    goodsSupplier.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsSupplier.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    goodsSupplier.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsSupplier.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    goodsSupplier.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerSupplierProduct(){
        EntityMeta supplierProduct = MetaProvider.entity("com.doublechaintech.retailscm.supplierproduct.SupplierProduct")
                  
                        .with("features", "root,visible_all")
                  ;
                  supplierProduct.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    supplierProduct.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    supplierProduct.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplierProduct.property("productName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    supplierProduct.property("productName")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplierProduct.property("productDescription")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    supplierProduct.property("productDescription")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplierProduct.property("productUnit")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    supplierProduct.property("productUnit")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplierProduct.property("supplier")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4belong_to", "供应管理")
                      ;
                    
                    supplierProduct.property("supplier")
                        .with("parentType", "com.doublechaintech.retailscm.goodssupplier.GoodsSupplier");
                    
                    supplierProduct.property("supplier")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplierProduct.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    supplierProduct.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerProductSupplyDuration(){
        EntityMeta productSupplyDuration = MetaProvider.entity("com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDuration")
                  
                        .with("features", "root,visible_all")
                  ;
                  productSupplyDuration.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    productSupplyDuration.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    productSupplyDuration.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    productSupplyDuration.property("quantity")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    
                    productSupplyDuration.property("quantity")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    productSupplyDuration.property("duration")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    productSupplyDuration.property("duration")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    productSupplyDuration.property("price")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    productSupplyDuration.property("price")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    productSupplyDuration.property("product")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    productSupplyDuration.property("product")
                        .with("parentType", "com.doublechaintech.retailscm.supplierproduct.SupplierProduct");
                    
                    productSupplyDuration.property("product")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    productSupplyDuration.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    productSupplyDuration.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerSupplyOrder(){
        EntityMeta supplyOrder = MetaProvider.entity("com.doublechaintech.retailscm.supplyorder.SupplyOrder")
                  
                        .with("vg4buyer", "供应管理")
                  
                        .with("features", "root,visible_all")
                  ;
                  supplyOrder.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    supplyOrder.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    supplyOrder.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrder.property("buyer")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    supplyOrder.property("buyer")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    supplyOrder.property("buyer")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrder.property("seller")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4belong_to", "供应管理")
                      ;
                    
                    supplyOrder.property("seller")
                        .with("parentType", "com.doublechaintech.retailscm.goodssupplier.GoodsSupplier");
                    
                    supplyOrder.property("seller")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrder.property("title")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "标题")
                      ;
                    
                    supplyOrder.property("title")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrder.property("contract")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment")
                      ;
                    
                    supplyOrder.property("contract")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ATTACHMENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrder.property("totalAmount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    supplyOrder.property("totalAmount")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrder.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    supplyOrder.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrder.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    supplyOrder.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerSupplyOrderLineItem(){
        EntityMeta supplyOrderLineItem = MetaProvider.entity("com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItem")
                  
                        .with("features", "root,visible_all")
                  ;
                  supplyOrderLineItem.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    supplyOrderLineItem.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    supplyOrderLineItem.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrderLineItem.property("bizOrder")
                      
                        .with("vg4buyer", "供应管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    supplyOrderLineItem.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.supplyorder.SupplyOrder");
                    
                    supplyOrderLineItem.property("bizOrder")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrderLineItem.property("skuId")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    supplyOrderLineItem.property("skuId")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrderLineItem.property("skuName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    supplyOrderLineItem.property("skuName")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrderLineItem.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    supplyOrderLineItem.property("amount")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrderLineItem.property("quantity")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    
                    supplyOrderLineItem.property("quantity")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrderLineItem.property("unitOfMeasurement")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    supplyOrderLineItem.property("unitOfMeasurement")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrderLineItem.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    supplyOrderLineItem.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerSupplyOrderShippingGroup(){
        EntityMeta supplyOrderShippingGroup = MetaProvider.entity("com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup")
                  
                        .with("features", "root,visible_all")
                  ;
                  supplyOrderShippingGroup.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    supplyOrderShippingGroup.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    supplyOrderShippingGroup.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrderShippingGroup.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    supplyOrderShippingGroup.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrderShippingGroup.property("bizOrder")
                      
                        .with("vg4buyer", "供应管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    supplyOrderShippingGroup.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.supplyorder.SupplyOrder");
                    
                    supplyOrderShippingGroup.property("bizOrder")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrderShippingGroup.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    supplyOrderShippingGroup.property("amount")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrderShippingGroup.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    supplyOrderShippingGroup.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerSupplyOrderPaymentGroup(){
        EntityMeta supplyOrderPaymentGroup = MetaProvider.entity("com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup")
                  
                        .with("features", "root,visible_all")
                  ;
                  supplyOrderPaymentGroup.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    supplyOrderPaymentGroup.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    supplyOrderPaymentGroup.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrderPaymentGroup.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    supplyOrderPaymentGroup.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrderPaymentGroup.property("bizOrder")
                      
                        .with("vg4buyer", "供应管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    supplyOrderPaymentGroup.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.supplyorder.SupplyOrder");
                    
                    supplyOrderPaymentGroup.property("bizOrder")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrderPaymentGroup.property("cardNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    supplyOrderPaymentGroup.property("cardNumber")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplyOrderPaymentGroup.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    supplyOrderPaymentGroup.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerRetailStoreOrder(){
        EntityMeta retailStoreOrder = MetaProvider.entity("com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4seller", "销售管理")
                  ;
                  retailStoreOrder.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    retailStoreOrder.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    retailStoreOrder.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrder.property("buyer")
                      
                        .with("vg4retail_store_country_center", "加盟管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStoreOrder.property("buyer")
                        .with("parentType", "com.doublechaintech.retailscm.retailstore.RetailStore");
                    
                    retailStoreOrder.property("buyer")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrder.property("seller")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStoreOrder.property("seller")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    retailStoreOrder.property("seller")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrder.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreOrder.property("title")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrder.property("totalAmount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    retailStoreOrder.property("totalAmount")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrder.property("contract")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment")
                      ;
                    
                    retailStoreOrder.property("contract")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ATTACHMENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrder.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    retailStoreOrder.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrder.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    retailStoreOrder.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerRetailStoreOrderLineItem(){
        EntityMeta retailStoreOrderLineItem = MetaProvider.entity("com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem")
                  
                        .with("features", "root,visible_all")
                  ;
                  retailStoreOrderLineItem.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    retailStoreOrderLineItem.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    retailStoreOrderLineItem.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrderLineItem.property("bizOrder")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4seller", "销售管理")
                      ;
                    
                    retailStoreOrderLineItem.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder");
                    
                    retailStoreOrderLineItem.property("bizOrder")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrderLineItem.property("skuId")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreOrderLineItem.property("skuId")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrderLineItem.property("skuName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreOrderLineItem.property("skuName")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrderLineItem.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    retailStoreOrderLineItem.property("amount")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrderLineItem.property("quantity")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    
                    retailStoreOrderLineItem.property("quantity")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrderLineItem.property("unitOfMeasurement")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreOrderLineItem.property("unitOfMeasurement")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrderLineItem.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    retailStoreOrderLineItem.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerRetailStoreOrderShippingGroup(){
        EntityMeta retailStoreOrderShippingGroup = MetaProvider.entity("com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup")
                  
                        .with("features", "root,visible_all")
                  ;
                  retailStoreOrderShippingGroup.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    retailStoreOrderShippingGroup.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    retailStoreOrderShippingGroup.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrderShippingGroup.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreOrderShippingGroup.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrderShippingGroup.property("bizOrder")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4seller", "销售管理")
                      ;
                    
                    retailStoreOrderShippingGroup.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder");
                    
                    retailStoreOrderShippingGroup.property("bizOrder")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrderShippingGroup.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    retailStoreOrderShippingGroup.property("amount")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrderShippingGroup.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    retailStoreOrderShippingGroup.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerRetailStoreOrderPaymentGroup(){
        EntityMeta retailStoreOrderPaymentGroup = MetaProvider.entity("com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup")
                  
                        .with("features", "root,visible_all")
                  ;
                  retailStoreOrderPaymentGroup.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    retailStoreOrderPaymentGroup.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    retailStoreOrderPaymentGroup.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrderPaymentGroup.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreOrderPaymentGroup.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrderPaymentGroup.property("bizOrder")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4seller", "销售管理")
                      ;
                    
                    retailStoreOrderPaymentGroup.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder");
                    
                    retailStoreOrderPaymentGroup.property("bizOrder")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrderPaymentGroup.property("cardNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    retailStoreOrderPaymentGroup.property("cardNumber")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    retailStoreOrderPaymentGroup.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    retailStoreOrderPaymentGroup.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerWarehouse(){
        EntityMeta warehouse = MetaProvider.entity("com.doublechaintech.retailscm.warehouse.Warehouse")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4owner", "仓配运一体化")
                  ;
                  warehouse.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    warehouse.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    warehouse.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    warehouse.property("location")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    warehouse.property("location")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    warehouse.property("contactNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    warehouse.property("contactNumber")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    warehouse.property("totalArea")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    warehouse.property("totalArea")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    warehouse.property("owner")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    warehouse.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    warehouse.property("owner")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    warehouse.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    warehouse.property("latitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    warehouse.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    warehouse.property("longitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    warehouse.property("contract")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment")
                      ;
                    
                    warehouse.property("contract")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ATTACHMENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    warehouse.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    warehouse.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    warehouse.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    warehouse.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerStorageSpace(){
        EntityMeta storageSpace = MetaProvider.entity("com.doublechaintech.retailscm.storagespace.StorageSpace")
                  
                        .with("features", "root,visible_all")
                  ;
                  storageSpace.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    storageSpace.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    storageSpace.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    storageSpace.property("location")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    storageSpace.property("location")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    storageSpace.property("contactNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    storageSpace.property("contactNumber")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    storageSpace.property("totalArea")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    storageSpace.property("totalArea")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    storageSpace.property("warehouse")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "仓配运一体化")
                      ;
                    
                    storageSpace.property("warehouse")
                        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");
                    
                    storageSpace.property("warehouse")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    storageSpace.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    storageSpace.property("latitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    storageSpace.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    storageSpace.property("longitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    storageSpace.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    storageSpace.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    storageSpace.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    storageSpace.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerSmartPallet(){
        EntityMeta smartPallet = MetaProvider.entity("com.doublechaintech.retailscm.smartpallet.SmartPallet")
                  
                        .with("features", "root,visible_all")
                  ;
                  smartPallet.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    smartPallet.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    smartPallet.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    smartPallet.property("location")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    smartPallet.property("location")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    smartPallet.property("contactNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    smartPallet.property("contactNumber")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    smartPallet.property("totalArea")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    smartPallet.property("totalArea")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    smartPallet.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    smartPallet.property("latitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    smartPallet.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    smartPallet.property("longitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    smartPallet.property("warehouse")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "仓配运一体化")
                      ;
                    
                    smartPallet.property("warehouse")
                        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");
                    
                    smartPallet.property("warehouse")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    smartPallet.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    smartPallet.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    smartPallet.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    smartPallet.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerGoodsShelf(){
        EntityMeta goodsShelf = MetaProvider.entity("com.doublechaintech.retailscm.goodsshelf.GoodsShelf")
                  
                        .with("features", "root,visible_all")
                  ;
                  goodsShelf.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    goodsShelf.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    goodsShelf.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsShelf.property("location")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    goodsShelf.property("location")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsShelf.property("storageSpace")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goodsShelf.property("storageSpace")
                        .with("parentType", "com.doublechaintech.retailscm.storagespace.StorageSpace");
                    
                    goodsShelf.property("storageSpace")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsShelf.property("supplierSpace")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goodsShelf.property("supplierSpace")
                        .with("parentType", "com.doublechaintech.retailscm.supplierspace.SupplierSpace");
                    
                    goodsShelf.property("supplierSpace")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsShelf.property("damageSpace")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goodsShelf.property("damageSpace")
                        .with("parentType", "com.doublechaintech.retailscm.damagespace.DamageSpace");
                    
                    goodsShelf.property("damageSpace")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsShelf.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    goodsShelf.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsShelf.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    goodsShelf.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerGoodsShelfStockCount(){
        EntityMeta goodsShelfStockCount = MetaProvider.entity("com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount")
                  
                        .with("features", "root,visible_all")
                  ;
                  goodsShelfStockCount.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    goodsShelfStockCount.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    goodsShelfStockCount.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsShelfStockCount.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    goodsShelfStockCount.property("title")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsShelfStockCount.property("countTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    goodsShelfStockCount.property("countTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsShelfStockCount.property("summary")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    goodsShelfStockCount.property("summary")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsShelfStockCount.property("shelf")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goodsShelfStockCount.property("shelf")
                        .with("parentType", "com.doublechaintech.retailscm.goodsshelf.GoodsShelf");
                    
                    goodsShelfStockCount.property("shelf")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsShelfStockCount.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    goodsShelfStockCount.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerStockCountIssueTrack(){
        EntityMeta stockCountIssueTrack = MetaProvider.entity("com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrack")
                  
                        .with("features", "root,visible_all")
                  ;
                  stockCountIssueTrack.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    stockCountIssueTrack.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    stockCountIssueTrack.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    stockCountIssueTrack.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    stockCountIssueTrack.property("title")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    stockCountIssueTrack.property("countTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    stockCountIssueTrack.property("countTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    stockCountIssueTrack.property("summary")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    stockCountIssueTrack.property("summary")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    stockCountIssueTrack.property("stockCount")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    stockCountIssueTrack.property("stockCount")
                        .with("parentType", "com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount");
                    
                    stockCountIssueTrack.property("stockCount")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    stockCountIssueTrack.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    stockCountIssueTrack.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerGoodsAllocation(){
        EntityMeta goodsAllocation = MetaProvider.entity("com.doublechaintech.retailscm.goodsallocation.GoodsAllocation")
                  
                        .with("features", "root,visible_all")
                  ;
                  goodsAllocation.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    goodsAllocation.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    goodsAllocation.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsAllocation.property("location")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    goodsAllocation.property("location")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsAllocation.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    goodsAllocation.property("latitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    goodsAllocation.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    goodsAllocation.property("longitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    goodsAllocation.property("goodsShelf")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goodsAllocation.property("goodsShelf")
                        .with("parentType", "com.doublechaintech.retailscm.goodsshelf.GoodsShelf");
                    
                    goodsAllocation.property("goodsShelf")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsAllocation.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    goodsAllocation.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerGoods(){
        EntityMeta goods = MetaProvider.entity("com.doublechaintech.retailscm.goods.Goods")
                  
                        .with("features", "root,visible_all")
                  ;
                  goods.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    goods.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    goods.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goods.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    goods.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goods.property("rfid")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    goods.property("rfid")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goods.property("uom")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    goods.property("uom")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goods.property("maxPackage")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    
                    goods.property("maxPackage")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goods.property("expireTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    goods.property("expireTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goods.property("sku")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goods.property("sku")
                        .with("parentType", "com.doublechaintech.retailscm.sku.Sku");
                    
                    goods.property("sku")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goods.property("receivingSpace")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goods.property("receivingSpace")
                        .with("parentType", "com.doublechaintech.retailscm.receivingspace.ReceivingSpace");
                    
                    goods.property("receivingSpace")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goods.property("goodsAllocation")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goods.property("goodsAllocation")
                        .with("parentType", "com.doublechaintech.retailscm.goodsallocation.GoodsAllocation");
                    
                    goods.property("goodsAllocation")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goods.property("smartPallet")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goods.property("smartPallet")
                        .with("parentType", "com.doublechaintech.retailscm.smartpallet.SmartPallet");
                    
                    goods.property("smartPallet")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goods.property("shippingSpace")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goods.property("shippingSpace")
                        .with("parentType", "com.doublechaintech.retailscm.shippingspace.ShippingSpace");
                    
                    goods.property("shippingSpace")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goods.property("transportTask")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goods.property("transportTask")
                        .with("parentType", "com.doublechaintech.retailscm.transporttask.TransportTask");
                    
                    goods.property("transportTask")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goods.property("retailStore")
                      
                        .with("vg4retail_store_country_center", "加盟管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goods.property("retailStore")
                        .with("parentType", "com.doublechaintech.retailscm.retailstore.RetailStore");
                    
                    goods.property("retailStore")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goods.property("bizOrder")
                      
                        .with("vg4buyer", "供应管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goods.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.supplyorder.SupplyOrder");
                    
                    goods.property("bizOrder")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goods.property("retailStoreOrder")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4seller", "销售管理")
                      ;
                    
                    goods.property("retailStoreOrder")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder");
                    
                    goods.property("retailStoreOrder")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goods.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    goods.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerGoodsMovement(){
        EntityMeta goodsMovement = MetaProvider.entity("com.doublechaintech.retailscm.goodsmovement.GoodsMovement")
                  
                        .with("features", "root,visible_all")
                  ;
                  goodsMovement.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    goodsMovement.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    goodsMovement.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsMovement.property("moveTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date_time")
                      ;
                    
                    goodsMovement.property("moveTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsMovement.property("facility")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    goodsMovement.property("facility")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsMovement.property("facilityId")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    goodsMovement.property("facilityId")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsMovement.property("fromIp")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    goodsMovement.property("fromIp")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsMovement.property("userAgent")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    goodsMovement.property("userAgent")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsMovement.property("sessionId")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    goodsMovement.property("sessionId")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsMovement.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    goodsMovement.property("latitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    goodsMovement.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    goodsMovement.property("longitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    goodsMovement.property("goods")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goodsMovement.property("goods")
                        .with("parentType", "com.doublechaintech.retailscm.goods.Goods");
                    
                    goodsMovement.property("goods")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    goodsMovement.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    goodsMovement.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerSupplierSpace(){
        EntityMeta supplierSpace = MetaProvider.entity("com.doublechaintech.retailscm.supplierspace.SupplierSpace")
                  
                        .with("features", "root,visible_all")
                  ;
                  supplierSpace.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    supplierSpace.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    supplierSpace.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplierSpace.property("location")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    supplierSpace.property("location")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplierSpace.property("contactNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    supplierSpace.property("contactNumber")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplierSpace.property("totalArea")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    supplierSpace.property("totalArea")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplierSpace.property("warehouse")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "仓配运一体化")
                      ;
                    
                    supplierSpace.property("warehouse")
                        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");
                    
                    supplierSpace.property("warehouse")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplierSpace.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    supplierSpace.property("latitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    supplierSpace.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    supplierSpace.property("longitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    supplierSpace.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    supplierSpace.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    supplierSpace.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    supplierSpace.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerReceivingSpace(){
        EntityMeta receivingSpace = MetaProvider.entity("com.doublechaintech.retailscm.receivingspace.ReceivingSpace")
                  
                        .with("features", "root,visible_all")
                  ;
                  receivingSpace.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    receivingSpace.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    receivingSpace.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    receivingSpace.property("location")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    receivingSpace.property("location")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    receivingSpace.property("contactNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    receivingSpace.property("contactNumber")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    receivingSpace.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    receivingSpace.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    receivingSpace.property("totalArea")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    receivingSpace.property("totalArea")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    receivingSpace.property("warehouse")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "仓配运一体化")
                      ;
                    
                    receivingSpace.property("warehouse")
                        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");
                    
                    receivingSpace.property("warehouse")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    receivingSpace.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    receivingSpace.property("latitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    receivingSpace.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    receivingSpace.property("longitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    receivingSpace.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    receivingSpace.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    receivingSpace.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    receivingSpace.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerShippingSpace(){
        EntityMeta shippingSpace = MetaProvider.entity("com.doublechaintech.retailscm.shippingspace.ShippingSpace")
                  
                        .with("features", "root,visible_all")
                  ;
                  shippingSpace.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    shippingSpace.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    shippingSpace.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    shippingSpace.property("location")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    shippingSpace.property("location")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    shippingSpace.property("contactNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    shippingSpace.property("contactNumber")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    shippingSpace.property("totalArea")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    shippingSpace.property("totalArea")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    shippingSpace.property("warehouse")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "仓配运一体化")
                      ;
                    
                    shippingSpace.property("warehouse")
                        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");
                    
                    shippingSpace.property("warehouse")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    shippingSpace.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    shippingSpace.property("latitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    shippingSpace.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    shippingSpace.property("longitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    shippingSpace.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    shippingSpace.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    shippingSpace.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    shippingSpace.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    shippingSpace.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    shippingSpace.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerDamageSpace(){
        EntityMeta damageSpace = MetaProvider.entity("com.doublechaintech.retailscm.damagespace.DamageSpace")
                  
                        .with("features", "root,visible_all")
                  ;
                  damageSpace.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    damageSpace.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    damageSpace.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    damageSpace.property("location")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    damageSpace.property("location")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    damageSpace.property("contactNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    damageSpace.property("contactNumber")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    damageSpace.property("totalArea")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    damageSpace.property("totalArea")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    damageSpace.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    damageSpace.property("latitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    damageSpace.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    damageSpace.property("longitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    damageSpace.property("warehouse")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "仓配运一体化")
                      ;
                    
                    damageSpace.property("warehouse")
                        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");
                    
                    damageSpace.property("warehouse")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    damageSpace.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    damageSpace.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    damageSpace.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    damageSpace.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerWarehouseAsset(){
        EntityMeta warehouseAsset = MetaProvider.entity("com.doublechaintech.retailscm.warehouseasset.WarehouseAsset")
                  
                        .with("features", "root,visible_all")
                  ;
                  warehouseAsset.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    warehouseAsset.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    warehouseAsset.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    warehouseAsset.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    warehouseAsset.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    warehouseAsset.property("position")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    warehouseAsset.property("position")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    warehouseAsset.property("owner")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "仓配运一体化")
                      ;
                    
                    warehouseAsset.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");
                    
                    warehouseAsset.property("owner")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    warehouseAsset.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    warehouseAsset.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    warehouseAsset.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    warehouseAsset.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerTransportFleet(){
        EntityMeta transportFleet = MetaProvider.entity("com.doublechaintech.retailscm.transportfleet.TransportFleet")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4owner", "仓配运一体化")
                  ;
                  transportFleet.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    transportFleet.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    transportFleet.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportFleet.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    transportFleet.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportFleet.property("contactNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    transportFleet.property("contactNumber")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportFleet.property("owner")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    transportFleet.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    transportFleet.property("owner")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportFleet.property("contract")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment")
                      ;
                    
                    transportFleet.property("contract")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ATTACHMENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportFleet.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    transportFleet.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportFleet.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    transportFleet.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerTransportTruck(){
        EntityMeta transportTruck = MetaProvider.entity("com.doublechaintech.retailscm.transporttruck.TransportTruck")
                  
                        .with("features", "root,visible_all")
                  ;
                  transportTruck.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    transportTruck.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    transportTruck.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTruck.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    transportTruck.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTruck.property("plateNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    transportTruck.property("plateNumber")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTruck.property("contactNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    transportTruck.property("contactNumber")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTruck.property("vehicleLicenseNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    transportTruck.property("vehicleLicenseNumber")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTruck.property("engineNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    transportTruck.property("engineNumber")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTruck.property("makeDate")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    transportTruck.property("makeDate")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTruck.property("mileage")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    transportTruck.property("mileage")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTruck.property("bodyColor")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    transportTruck.property("bodyColor")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTruck.property("owner")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "仓配运一体化")
                      ;
                    
                    transportTruck.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.transportfleet.TransportFleet");
                    
                    transportTruck.property("owner")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTruck.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    transportTruck.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerTruckDriver(){
        EntityMeta truckDriver = MetaProvider.entity("com.doublechaintech.retailscm.truckdriver.TruckDriver")
                  
                        .with("features", "root,visible_all")
                  ;
                  truckDriver.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    truckDriver.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    truckDriver.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    truckDriver.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    truckDriver.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    truckDriver.property("driverLicenseNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    truckDriver.property("driverLicenseNumber")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    truckDriver.property("contactNumber")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    
                    truckDriver.property("contactNumber")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,MOBILE,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    truckDriver.property("belongsTo")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "仓配运一体化")
                      ;
                    
                    truckDriver.property("belongsTo")
                        .with("parentType", "com.doublechaintech.retailscm.transportfleet.TransportFleet");
                    
                    truckDriver.property("belongsTo")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    truckDriver.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    truckDriver.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerTransportTask(){
        EntityMeta transportTask = MetaProvider.entity("com.doublechaintech.retailscm.transporttask.TransportTask")
                  
                        .with("features", "root,visible_all")
                  ;
                  transportTask.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    transportTask.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    transportTask.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTask.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    transportTask.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTask.property("start")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    transportTask.property("start")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTask.property("beginTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    transportTask.property("beginTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTask.property("end")
                      
                        .with("vg4retail_store_country_center", "加盟管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    transportTask.property("end")
                        .with("parentType", "com.doublechaintech.retailscm.retailstore.RetailStore");
                    
                    transportTask.property("end")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTask.property("driver")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    transportTask.property("driver")
                        .with("parentType", "com.doublechaintech.retailscm.truckdriver.TruckDriver");
                    
                    transportTask.property("driver")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTask.property("truck")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    transportTask.property("truck")
                        .with("parentType", "com.doublechaintech.retailscm.transporttruck.TransportTruck");
                    
                    transportTask.property("truck")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTask.property("belongsTo")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "仓配运一体化")
                      ;
                    
                    transportTask.property("belongsTo")
                        .with("parentType", "com.doublechaintech.retailscm.transportfleet.TransportFleet");
                    
                    transportTask.property("belongsTo")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTask.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    transportTask.property("latitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    transportTask.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    transportTask.property("longitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    transportTask.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    transportTask.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerTransportTaskTrack(){
        EntityMeta transportTaskTrack = MetaProvider.entity("com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrack")
                  
                        .with("features", "root,visible_all")
                  ;
                  transportTaskTrack.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    transportTaskTrack.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    transportTaskTrack.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTaskTrack.property("trackTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    transportTaskTrack.property("trackTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTaskTrack.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    transportTaskTrack.property("latitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    transportTaskTrack.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    
                    transportTaskTrack.property("longitude")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,DOUBLE");

                    
                  
                    transportTaskTrack.property("movement")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    transportTaskTrack.property("movement")
                        .with("parentType", "com.doublechaintech.retailscm.transporttask.TransportTask");
                    
                    transportTaskTrack.property("movement")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    transportTaskTrack.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    transportTaskTrack.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerAccountSet(){
        EntityMeta accountSet = MetaProvider.entity("com.doublechaintech.retailscm.accountset.AccountSet")
                  
                        .with("vg4country_center", "财务管理")
                  
                        .with("features", "root,visible_all")
                  ;
                  accountSet.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    accountSet.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    accountSet.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountSet.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    accountSet.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountSet.property("yearSet")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    accountSet.property("yearSet")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountSet.property("effectiveDate")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    accountSet.property("effectiveDate")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountSet.property("accountingSystem")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    accountSet.property("accountingSystem")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountSet.property("domesticCurrencyCode")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    accountSet.property("domesticCurrencyCode")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountSet.property("domesticCurrencyName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    accountSet.property("domesticCurrencyName")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountSet.property("openingBank")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    accountSet.property("openingBank")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountSet.property("accountNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    accountSet.property("accountNumber")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountSet.property("countryCenter")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    accountSet.property("countryCenter")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    accountSet.property("countryCenter")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountSet.property("retailStore")
                      
                        .with("vg4retail_store_country_center", "加盟管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    accountSet.property("retailStore")
                        .with("parentType", "com.doublechaintech.retailscm.retailstore.RetailStore");
                    
                    accountSet.property("retailStore")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountSet.property("goodsSupplier")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4belong_to", "供应管理")
                      ;
                    
                    accountSet.property("goodsSupplier")
                        .with("parentType", "com.doublechaintech.retailscm.goodssupplier.GoodsSupplier");
                    
                    accountSet.property("goodsSupplier")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountSet.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    accountSet.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountSet.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    accountSet.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerAccountingSubject(){
        EntityMeta accountingSubject = MetaProvider.entity("com.doublechaintech.retailscm.accountingsubject.AccountingSubject")
                  
                        .with("features", "root,visible_all")
                  ;
                  accountingSubject.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    accountingSubject.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    accountingSubject.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingSubject.property("accountingSubjectCode")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    accountingSubject.property("accountingSubjectCode")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingSubject.property("accountingSubjectName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    accountingSubject.property("accountingSubjectName")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingSubject.property("accountingSubjectClassCode")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    
                    accountingSubject.property("accountingSubjectClassCode")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingSubject.property("accountingSubjectClassName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    accountingSubject.property("accountingSubjectClassName")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingSubject.property("accountSet")
                      
                        .with("vg4country_center", "财务管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    accountingSubject.property("accountSet")
                        .with("parentType", "com.doublechaintech.retailscm.accountset.AccountSet");
                    
                    accountingSubject.property("accountSet")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingSubject.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    accountingSubject.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerAccountingPeriod(){
        EntityMeta accountingPeriod = MetaProvider.entity("com.doublechaintech.retailscm.accountingperiod.AccountingPeriod")
                  
                        .with("features", "root,visible_all")
                  ;
                  accountingPeriod.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    accountingPeriod.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    accountingPeriod.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingPeriod.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    accountingPeriod.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingPeriod.property("startDate")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    accountingPeriod.property("startDate")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingPeriod.property("endDate")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    accountingPeriod.property("endDate")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingPeriod.property("accountSet")
                      
                        .with("vg4country_center", "财务管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    accountingPeriod.property("accountSet")
                        .with("parentType", "com.doublechaintech.retailscm.accountset.AccountSet");
                    
                    accountingPeriod.property("accountSet")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingPeriod.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    accountingPeriod.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerAccountingDocumentType(){
        EntityMeta accountingDocumentType = MetaProvider.entity("com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType")
                  
                        .with("features", "root,visible_all")
                  ;
                  accountingDocumentType.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    accountingDocumentType.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    accountingDocumentType.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingDocumentType.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    accountingDocumentType.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingDocumentType.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    accountingDocumentType.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingDocumentType.property("accountingPeriod")
                      
                        .with("vg4country_center", "财务管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    accountingDocumentType.property("accountingPeriod")
                        .with("parentType", "com.doublechaintech.retailscm.accountset.AccountSet");
                    
                    accountingDocumentType.property("accountingPeriod")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingDocumentType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    accountingDocumentType.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerAccountingDocument(){
        EntityMeta accountingDocument = MetaProvider.entity("com.doublechaintech.retailscm.accountingdocument.AccountingDocument")
                  
                        .with("features", "root,visible_all")
                  ;
                  accountingDocument.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    accountingDocument.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    accountingDocument.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingDocument.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    accountingDocument.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingDocument.property("accountingDocumentDate")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    accountingDocument.property("accountingDocumentDate")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingDocument.property("accountingPeriod")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    accountingDocument.property("accountingPeriod")
                        .with("parentType", "com.doublechaintech.retailscm.accountingperiod.AccountingPeriod");
                    
                    accountingDocument.property("accountingPeriod")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingDocument.property("documentType")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    accountingDocument.property("documentType")
                        .with("parentType", "com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType");
                    
                    accountingDocument.property("documentType")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingDocument.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    accountingDocument.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerOriginalVoucher(){
        EntityMeta originalVoucher = MetaProvider.entity("com.doublechaintech.retailscm.originalvoucher.OriginalVoucher")
                  
                        .with("features", "root,visible_all")
                  ;
                  originalVoucher.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    originalVoucher.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    originalVoucher.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    originalVoucher.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    originalVoucher.property("title")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    originalVoucher.property("madeBy")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    originalVoucher.property("madeBy")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    originalVoucher.property("receivedBy")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    originalVoucher.property("receivedBy")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    originalVoucher.property("voucherType")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    originalVoucher.property("voucherType")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    originalVoucher.property("voucherImage")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      ;
                    
                    originalVoucher.property("voucherImage")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,IMAGE,DELETE,VISIBLE_PARENT,VIEWDETAIL,ATTACHMENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    originalVoucher.property("belongsTo")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    originalVoucher.property("belongsTo")
                        .with("parentType", "com.doublechaintech.retailscm.accountingdocument.AccountingDocument");
                    
                    originalVoucher.property("belongsTo")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    originalVoucher.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    originalVoucher.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerAccountingDocumentLine(){
        EntityMeta accountingDocumentLine = MetaProvider.entity("com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine")
                  
                        .with("features", "root,visible_all")
                  ;
                  accountingDocumentLine.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    accountingDocumentLine.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    accountingDocumentLine.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingDocumentLine.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    accountingDocumentLine.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingDocumentLine.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    accountingDocumentLine.property("code")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingDocumentLine.property("direct")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    accountingDocumentLine.property("direct")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingDocumentLine.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    accountingDocumentLine.property("amount")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingDocumentLine.property("belongsTo")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    accountingDocumentLine.property("belongsTo")
                        .with("parentType", "com.doublechaintech.retailscm.accountingdocument.AccountingDocument");
                    
                    accountingDocumentLine.property("belongsTo")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingDocumentLine.property("accountingSubject")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    accountingDocumentLine.property("accountingSubject")
                        .with("parentType", "com.doublechaintech.retailscm.accountingsubject.AccountingSubject");
                    
                    accountingDocumentLine.property("accountingSubject")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    accountingDocumentLine.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    accountingDocumentLine.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerLevelOneDepartment(){
        EntityMeta levelOneDepartment = MetaProvider.entity("com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4belongs_to", "组织机构")
                  ;
                  levelOneDepartment.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    levelOneDepartment.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    levelOneDepartment.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelOneDepartment.property("belongsTo")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    levelOneDepartment.property("belongsTo")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    levelOneDepartment.property("belongsTo")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelOneDepartment.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    levelOneDepartment.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelOneDepartment.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    levelOneDepartment.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelOneDepartment.property("manager")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    levelOneDepartment.property("manager")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelOneDepartment.property("founded")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    levelOneDepartment.property("founded")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelOneDepartment.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    levelOneDepartment.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerLevelTwoDepartment(){
        EntityMeta levelTwoDepartment = MetaProvider.entity("com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment")
                  
                        .with("features", "root,visible_all")
                  ;
                  levelTwoDepartment.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    levelTwoDepartment.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    levelTwoDepartment.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelTwoDepartment.property("belongsTo")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4belongs_to", "组织机构")
                      ;
                    
                    levelTwoDepartment.property("belongsTo")
                        .with("parentType", "com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment");
                    
                    levelTwoDepartment.property("belongsTo")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelTwoDepartment.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    levelTwoDepartment.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelTwoDepartment.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    levelTwoDepartment.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelTwoDepartment.property("founded")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    levelTwoDepartment.property("founded")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelTwoDepartment.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    levelTwoDepartment.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerLevelThreeDepartment(){
        EntityMeta levelThreeDepartment = MetaProvider.entity("com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment")
                  
                        .with("features", "root,visible_all")
                  ;
                  levelThreeDepartment.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    levelThreeDepartment.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    levelThreeDepartment.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelThreeDepartment.property("belongsTo")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    levelThreeDepartment.property("belongsTo")
                        .with("parentType", "com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment");
                    
                    levelThreeDepartment.property("belongsTo")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelThreeDepartment.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    levelThreeDepartment.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelThreeDepartment.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    levelThreeDepartment.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelThreeDepartment.property("founded")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    levelThreeDepartment.property("founded")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    levelThreeDepartment.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    levelThreeDepartment.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerSkillType(){
        EntityMeta skillType = MetaProvider.entity("com.doublechaintech.retailscm.skilltype.SkillType")
                  
                        .with("features", "setting")
                  
                        .with("vg4company", "人力资源")
                  ;
                  skillType.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");
                  
                    skillType.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    skillType.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    skillType.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    skillType.property("code")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    skillType.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    skillType.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    skillType.property("company")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    skillType.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    skillType.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    skillType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    skillType.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerResponsibilityType(){
        EntityMeta responsibilityType = MetaProvider.entity("com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType")
                  
                        .with("features", "setting")
                  
                        .with("vg4company", "人力资源")
                  ;
                  responsibilityType.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");
                  
                    responsibilityType.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    responsibilityType.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    responsibilityType.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    responsibilityType.property("code")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    responsibilityType.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    responsibilityType.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    responsibilityType.property("company")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    responsibilityType.property("baseDescription")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    responsibilityType.property("baseDescription")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    responsibilityType.property("detailDescription")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    responsibilityType.property("detailDescription")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    responsibilityType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    responsibilityType.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerTerminationReason(){
        EntityMeta terminationReason = MetaProvider.entity("com.doublechaintech.retailscm.terminationreason.TerminationReason")
                  
                        .with("features", "setting")
                  
                        .with("vg4company", "人力资源")
                  ;
                  terminationReason.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");
                  
                    terminationReason.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    terminationReason.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    terminationReason.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    terminationReason.property("code")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    terminationReason.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    terminationReason.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    terminationReason.property("company")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    terminationReason.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    terminationReason.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    terminationReason.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    terminationReason.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerTerminationType(){
        EntityMeta terminationType = MetaProvider.entity("com.doublechaintech.retailscm.terminationtype.TerminationType")
                  
                        .with("features", "setting")
                  
                        .with("vg4company", "人力资源")
                  ;
                  terminationType.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");
                  
                    terminationType.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    terminationType.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    terminationType.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    terminationType.property("code")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    terminationType.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    terminationType.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    terminationType.property("company")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    terminationType.property("baseDescription")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    terminationType.property("baseDescription")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    terminationType.property("detailDescription")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    terminationType.property("detailDescription")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    terminationType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    terminationType.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerOccupationType(){
        EntityMeta occupationType = MetaProvider.entity("com.doublechaintech.retailscm.occupationtype.OccupationType")
                  
                        .with("features", "setting")
                  
                        .with("vg4company", "人力资源")
                  ;
                  occupationType.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");
                  
                    occupationType.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    occupationType.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    occupationType.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    occupationType.property("code")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    occupationType.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    occupationType.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    occupationType.property("company")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    occupationType.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    occupationType.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    occupationType.property("detailDescription")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    occupationType.property("detailDescription")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    occupationType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    occupationType.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerLeaveType(){
        EntityMeta leaveType = MetaProvider.entity("com.doublechaintech.retailscm.leavetype.LeaveType")
                  
                        .with("features", "setting")
                  
                        .with("vg4company", "人力资源")
                  ;
                  leaveType.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");
                  
                    leaveType.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    leaveType.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    leaveType.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    leaveType.property("code")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    leaveType.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    leaveType.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    leaveType.property("company")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    leaveType.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    leaveType.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    leaveType.property("detailDescription")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    leaveType.property("detailDescription")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    leaveType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    leaveType.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerSalaryGrade(){
        EntityMeta salaryGrade = MetaProvider.entity("com.doublechaintech.retailscm.salarygrade.SalaryGrade")
                  
                        .with("features", "setting")
                  
                        .with("vg4company", "人力资源")
                  ;
                  salaryGrade.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");
                  
                    salaryGrade.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    salaryGrade.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    salaryGrade.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    salaryGrade.property("code")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    salaryGrade.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    salaryGrade.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    salaryGrade.property("company")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    salaryGrade.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    salaryGrade.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    salaryGrade.property("detailDescription")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    salaryGrade.property("detailDescription")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    salaryGrade.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    salaryGrade.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerInterviewType(){
        EntityMeta interviewType = MetaProvider.entity("com.doublechaintech.retailscm.interviewtype.InterviewType")
                  
                        .with("features", "setting")
                  
                        .with("vg4company", "人力资源")
                  ;
                  interviewType.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");
                  
                    interviewType.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    interviewType.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    interviewType.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    interviewType.property("code")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    interviewType.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    interviewType.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    interviewType.property("company")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    interviewType.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    interviewType.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    interviewType.property("detailDescription")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    interviewType.property("detailDescription")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    interviewType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    interviewType.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerTrainingCourseType(){
        EntityMeta trainingCourseType = MetaProvider.entity("com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType")
                  
                        .with("features", "setting")
                  
                        .with("vg4company", "人力资源")
                  ;
                  trainingCourseType.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");
                  
                    trainingCourseType.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    trainingCourseType.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    trainingCourseType.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    trainingCourseType.property("code")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    trainingCourseType.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    trainingCourseType.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    trainingCourseType.property("company")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    trainingCourseType.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    trainingCourseType.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    trainingCourseType.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    trainingCourseType.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    trainingCourseType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    trainingCourseType.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerPublicHoliday(){
        EntityMeta publicHoliday = MetaProvider.entity("com.doublechaintech.retailscm.publicholiday.PublicHoliday")
                  
                        .with("features", "setting")
                  
                        .with("vg4company", "人力资源")
                  ;
                  publicHoliday.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");
                  
                    publicHoliday.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    publicHoliday.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    publicHoliday.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    publicHoliday.property("code")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    publicHoliday.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    publicHoliday.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    publicHoliday.property("company")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    publicHoliday.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    publicHoliday.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    publicHoliday.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    publicHoliday.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    publicHoliday.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    publicHoliday.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerTermination(){
        EntityMeta termination = MetaProvider.entity("com.doublechaintech.retailscm.termination.Termination")
                  
                        .with("features", "root,visible_all")
                  ;
                  termination.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    termination.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    termination.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    termination.property("reason")
                      
                        .with("features", "setting")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    termination.property("reason")
                        .with("parentType", "com.doublechaintech.retailscm.terminationreason.TerminationReason");
                    
                    termination.property("reason")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");

                    
                  
                    termination.property("type")
                      
                        .with("features", "setting")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    termination.property("type")
                        .with("parentType", "com.doublechaintech.retailscm.terminationtype.TerminationType");
                    
                    termination.property("type")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");

                    
                  
                    termination.property("comment")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    termination.property("comment")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    termination.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    termination.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerView(){
        EntityMeta view = MetaProvider.entity("com.doublechaintech.retailscm.view.View")
                  
                        .with("features", "root,visible_all")
                  ;
                  view.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    view.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    view.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    view.property("who")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    view.property("who")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    view.property("assessment")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    view.property("assessment")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    view.property("interviewTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    view.property("interviewTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    view.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    view.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerEmployee(){
        EntityMeta employee = MetaProvider.entity("com.doublechaintech.retailscm.employee.Employee")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4company", "人力资源")
                  ;
                  employee.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    employee.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    employee.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employee.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    employee.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    employee.property("company")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employee.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    employee.property("title")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employee.property("department")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    employee.property("department")
                        .with("parentType", "com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment");
                    
                    employee.property("department")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employee.property("familyName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    employee.property("familyName")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employee.property("givenName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    employee.property("givenName")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employee.property("email")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,email")
                      ;
                    
                    employee.property("email")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,EMAIL,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employee.property("city")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    employee.property("city")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employee.property("address")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    employee.property("address")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employee.property("cellPhone")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    
                    employee.property("cellPhone")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,MOBILE,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employee.property("occupation")
                      
                        .with("features", "setting")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employee.property("occupation")
                        .with("parentType", "com.doublechaintech.retailscm.occupationtype.OccupationType");
                    
                    employee.property("occupation")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");

                    
                  
                    employee.property("responsibleFor")
                      
                        .with("features", "setting")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employee.property("responsibleFor")
                        .with("parentType", "com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType");
                    
                    employee.property("responsibleFor")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");

                    
                  
                    employee.property("currentSalaryGrade")
                      
                        .with("features", "setting")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employee.property("currentSalaryGrade")
                        .with("parentType", "com.doublechaintech.retailscm.salarygrade.SalaryGrade");
                    
                    employee.property("currentSalaryGrade")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");

                    
                  
                    employee.property("salaryAccount")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    employee.property("salaryAccount")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employee.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    employee.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employee.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    employee.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerInstructor(){
        EntityMeta instructor = MetaProvider.entity("com.doublechaintech.retailscm.instructor.Instructor")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4company", "人力资源")
                  ;
                  instructor.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    instructor.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    instructor.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    instructor.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    instructor.property("title")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    instructor.property("familyName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    instructor.property("familyName")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    instructor.property("givenName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    instructor.property("givenName")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    instructor.property("cellPhone")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    
                    instructor.property("cellPhone")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,MOBILE,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    instructor.property("email")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,email")
                      ;
                    
                    instructor.property("email")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,EMAIL,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    instructor.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    instructor.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    instructor.property("company")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    instructor.property("introduction")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    instructor.property("introduction")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    instructor.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    instructor.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    instructor.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    instructor.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerCompanyTraining(){
        EntityMeta companyTraining = MetaProvider.entity("com.doublechaintech.retailscm.companytraining.CompanyTraining")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4company", "人力资源")
                  ;
                  companyTraining.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    companyTraining.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    companyTraining.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    companyTraining.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    companyTraining.property("title")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    companyTraining.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    companyTraining.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    
                    companyTraining.property("company")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    companyTraining.property("instructor")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    companyTraining.property("instructor")
                        .with("parentType", "com.doublechaintech.retailscm.instructor.Instructor");
                    
                    companyTraining.property("instructor")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    companyTraining.property("trainingCourseType")
                      
                        .with("features", "setting")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    companyTraining.property("trainingCourseType")
                        .with("parentType", "com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType");
                    
                    companyTraining.property("trainingCourseType")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");

                    
                  
                    companyTraining.property("timeStart")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    companyTraining.property("timeStart")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    companyTraining.property("durationHours")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    
                    companyTraining.property("durationHours")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    companyTraining.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    companyTraining.property("lastUpdateTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    companyTraining.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    companyTraining.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerScoring(){
        EntityMeta scoring = MetaProvider.entity("com.doublechaintech.retailscm.scoring.Scoring")
                  
                        .with("features", "root,visible_all")
                  ;
                  scoring.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    scoring.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    scoring.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    scoring.property("scoredBy")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    scoring.property("scoredBy")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    scoring.property("score")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    
                    scoring.property("score")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    scoring.property("comment")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    scoring.property("comment")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    scoring.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    scoring.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerEmployeeCompanyTraining(){
        EntityMeta employeeCompanyTraining = MetaProvider.entity("com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining")
                  
                        .with("features", "root,visible_all")
                  ;
                  employeeCompanyTraining.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    employeeCompanyTraining.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    employeeCompanyTraining.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeCompanyTraining.property("employee")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeCompanyTraining.property("employee")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    
                    employeeCompanyTraining.property("employee")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeCompanyTraining.property("training")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeCompanyTraining.property("training")
                        .with("parentType", "com.doublechaintech.retailscm.companytraining.CompanyTraining");
                    
                    employeeCompanyTraining.property("training")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeCompanyTraining.property("scoring")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    employeeCompanyTraining.property("scoring")
                        .with("parentType", "com.doublechaintech.retailscm.scoring.Scoring");
                    
                    employeeCompanyTraining.property("scoring")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeCompanyTraining.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    employeeCompanyTraining.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerEmployeeSkill(){
        EntityMeta employeeSkill = MetaProvider.entity("com.doublechaintech.retailscm.employeeskill.EmployeeSkill")
                  
                        .with("features", "root,visible_all")
                  ;
                  employeeSkill.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    employeeSkill.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    employeeSkill.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeSkill.property("employee")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeSkill.property("employee")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    
                    employeeSkill.property("employee")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeSkill.property("skillType")
                      
                        .with("features", "setting")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeSkill.property("skillType")
                        .with("parentType", "com.doublechaintech.retailscm.skilltype.SkillType");
                    
                    employeeSkill.property("skillType")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");

                    
                  
                    employeeSkill.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    employeeSkill.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeSkill.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    employeeSkill.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerEmployeePerformance(){
        EntityMeta employeePerformance = MetaProvider.entity("com.doublechaintech.retailscm.employeeperformance.EmployeePerformance")
                  
                        .with("features", "root,visible_all")
                  ;
                  employeePerformance.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    employeePerformance.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    employeePerformance.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeePerformance.property("employee")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeePerformance.property("employee")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    
                    employeePerformance.property("employee")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeePerformance.property("performanceComment")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    employeePerformance.property("performanceComment")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeePerformance.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    employeePerformance.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerEmployeeWorkExperience(){
        EntityMeta employeeWorkExperience = MetaProvider.entity("com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperience")
                  
                        .with("features", "root,visible_all")
                  ;
                  employeeWorkExperience.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    employeeWorkExperience.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    employeeWorkExperience.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeWorkExperience.property("employee")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeWorkExperience.property("employee")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    
                    employeeWorkExperience.property("employee")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeWorkExperience.property("start")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    employeeWorkExperience.property("start")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeWorkExperience.property("end")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    employeeWorkExperience.property("end")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeWorkExperience.property("company")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    employeeWorkExperience.property("company")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeWorkExperience.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    employeeWorkExperience.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeWorkExperience.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    employeeWorkExperience.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerEmployeeLeave(){
        EntityMeta employeeLeave = MetaProvider.entity("com.doublechaintech.retailscm.employeeleave.EmployeeLeave")
                  
                        .with("features", "root,visible_all")
                  ;
                  employeeLeave.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    employeeLeave.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    employeeLeave.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeLeave.property("who")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeLeave.property("who")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    
                    employeeLeave.property("who")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeLeave.property("type")
                      
                        .with("features", "setting")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeLeave.property("type")
                        .with("parentType", "com.doublechaintech.retailscm.leavetype.LeaveType");
                    
                    employeeLeave.property("type")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");

                    
                  
                    employeeLeave.property("leaveDurationHour")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    
                    employeeLeave.property("leaveDurationHour")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeLeave.property("remark")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    employeeLeave.property("remark")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeLeave.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    employeeLeave.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerEmployeeInterview(){
        EntityMeta employeeInterview = MetaProvider.entity("com.doublechaintech.retailscm.employeeinterview.EmployeeInterview")
                  
                        .with("features", "root,visible_all")
                  ;
                  employeeInterview.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    employeeInterview.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    employeeInterview.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeInterview.property("employee")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeInterview.property("employee")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    
                    employeeInterview.property("employee")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeInterview.property("interviewType")
                      
                        .with("features", "setting")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeInterview.property("interviewType")
                        .with("parentType", "com.doublechaintech.retailscm.interviewtype.InterviewType");
                    
                    employeeInterview.property("interviewType")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");

                    
                  
                    employeeInterview.property("remark")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    employeeInterview.property("remark")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeInterview.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    employeeInterview.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerEmployeeAttendance(){
        EntityMeta employeeAttendance = MetaProvider.entity("com.doublechaintech.retailscm.employeeattendance.EmployeeAttendance")
                  
                        .with("features", "root,visible_all")
                  ;
                  employeeAttendance.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    employeeAttendance.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    employeeAttendance.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeAttendance.property("employee")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeAttendance.property("employee")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    
                    employeeAttendance.property("employee")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeAttendance.property("enterTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    employeeAttendance.property("enterTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeAttendance.property("leaveTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    employeeAttendance.property("leaveTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeAttendance.property("durationHours")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    
                    employeeAttendance.property("durationHours")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeAttendance.property("remark")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    employeeAttendance.property("remark")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeAttendance.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    employeeAttendance.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerEmployeeQualifier(){
        EntityMeta employeeQualifier = MetaProvider.entity("com.doublechaintech.retailscm.employeequalifier.EmployeeQualifier")
                  
                        .with("features", "root,visible_all")
                  ;
                  employeeQualifier.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    employeeQualifier.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    employeeQualifier.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeQualifier.property("employee")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeQualifier.property("employee")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    
                    employeeQualifier.property("employee")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeQualifier.property("qualifiedTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    employeeQualifier.property("qualifiedTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeQualifier.property("type")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    employeeQualifier.property("type")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeQualifier.property("level")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    employeeQualifier.property("level")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeQualifier.property("remark")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    employeeQualifier.property("remark")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeQualifier.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    employeeQualifier.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerEmployeeEducation(){
        EntityMeta employeeEducation = MetaProvider.entity("com.doublechaintech.retailscm.employeeeducation.EmployeeEducation")
                  
                        .with("features", "root,visible_all")
                  ;
                  employeeEducation.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    employeeEducation.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    employeeEducation.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeEducation.property("employee")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeEducation.property("employee")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    
                    employeeEducation.property("employee")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeEducation.property("completeTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    employeeEducation.property("completeTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeEducation.property("type")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    employeeEducation.property("type")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeEducation.property("remark")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    employeeEducation.property("remark")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeEducation.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    employeeEducation.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerEmployeeAward(){
        EntityMeta employeeAward = MetaProvider.entity("com.doublechaintech.retailscm.employeeaward.EmployeeAward")
                  
                        .with("features", "root,visible_all")
                  ;
                  employeeAward.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    employeeAward.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    employeeAward.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeAward.property("employee")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeAward.property("employee")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    
                    employeeAward.property("employee")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeAward.property("completeTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    employeeAward.property("completeTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeAward.property("type")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    employeeAward.property("type")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeAward.property("remark")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    employeeAward.property("remark")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeAward.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    employeeAward.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerEmployeeSalarySheet(){
        EntityMeta employeeSalarySheet = MetaProvider.entity("com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet")
                  
                        .with("features", "root,visible_all")
                  ;
                  employeeSalarySheet.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    employeeSalarySheet.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    employeeSalarySheet.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeSalarySheet.property("employee")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeSalarySheet.property("employee")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    
                    employeeSalarySheet.property("employee")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeSalarySheet.property("currentSalaryGrade")
                      
                        .with("features", "setting")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeSalarySheet.property("currentSalaryGrade")
                        .with("parentType", "com.doublechaintech.retailscm.salarygrade.SalaryGrade");
                    
                    employeeSalarySheet.property("currentSalaryGrade")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");

                    
                  
                    employeeSalarySheet.property("baseSalary")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    employeeSalarySheet.property("baseSalary")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeSalarySheet.property("bonus")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    employeeSalarySheet.property("bonus")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeSalarySheet.property("reward")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    employeeSalarySheet.property("reward")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeSalarySheet.property("personalTax")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    employeeSalarySheet.property("personalTax")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeSalarySheet.property("socialSecurity")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    employeeSalarySheet.property("socialSecurity")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeSalarySheet.property("housingFound")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    employeeSalarySheet.property("housingFound")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeSalarySheet.property("jobInsurance")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    employeeSalarySheet.property("jobInsurance")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeSalarySheet.property("payingOff")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    employeeSalarySheet.property("payingOff")
                        .with("parentType", "com.doublechaintech.retailscm.payingoff.PayingOff");
                    
                    employeeSalarySheet.property("payingOff")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    employeeSalarySheet.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    employeeSalarySheet.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerPayingOff(){
        EntityMeta payingOff = MetaProvider.entity("com.doublechaintech.retailscm.payingoff.PayingOff")
                  
                        .with("features", "root,visible_all")
                  ;
                  payingOff.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    payingOff.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    payingOff.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    payingOff.property("who")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    payingOff.property("who")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    payingOff.property("paidFor")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    payingOff.property("paidFor")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    
                    payingOff.property("paidFor")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    payingOff.property("paidTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    
                    payingOff.property("paidTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,DATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    payingOff.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    
                    payingOff.property("amount")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,MONEY,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    payingOff.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    payingOff.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerMobileApp(){
        EntityMeta mobileApp = MetaProvider.entity("com.doublechaintech.retailscm.mobileapp.MobileApp")
                  
                        .with("features", "root,visible_all")
                  ;
                  mobileApp.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    mobileApp.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    mobileApp.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    mobileApp.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    mobileApp.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    mobileApp.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    mobileApp.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerPage(){
        EntityMeta page = MetaProvider.entity("com.doublechaintech.retailscm.page.Page")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4mobile_app", "页面管理")
                  ;
                  page.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    page.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    page.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    page.property("pageTitle")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    page.property("pageTitle")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    page.property("linkToUrl")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    page.property("linkToUrl")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    page.property("pageType")
                      
                        .with("identified_by", "code")
                      
                        .with("features", "status")
                      ;
                    
                    page.property("pageType")
                        .with("parentType", "com.doublechaintech.retailscm.pagetype.PageType");
                    
                    page.property("pageType")
                        .with("tokens", "SAMPLE_DATA_COUNT_INFER,TRANSFERABLE_CONSTANT,SEARCHABLE,PERSISTENCE,SEARCH,VISIBLE_PARENT,USERSPACE,ACTION,SAMPLE_DATA,CONSTANT,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");

                    
                  
                    page.property("displayOrder")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    
                    page.property("displayOrder")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    page.property("mobileApp")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    page.property("mobileApp")
                        .with("parentType", "com.doublechaintech.retailscm.mobileapp.MobileApp");
                    
                    page.property("mobileApp")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    page.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    page.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerPageType(){
        EntityMeta pageType = MetaProvider.entity("com.doublechaintech.retailscm.pagetype.PageType")
                  
                        .with("identified_by", "code")
                  
                        .with("features", "status")
                  ;
                  pageType.with("tokens", "SAMPLE_DATA_COUNT_INFER,TRANSFERABLE_CONSTANT,SEARCHABLE,PERSISTENCE,SEARCH,VISIBLE_PARENT,USERSPACE,ACTION,SAMPLE_DATA,CONSTANT,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");
                  
                    pageType.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    pageType.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    pageType.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    pageType.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    pageType.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    pageType.property("code")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    pageType.property("mobileApp")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    pageType.property("mobileApp")
                        .with("parentType", "com.doublechaintech.retailscm.mobileapp.MobileApp");
                    
                    pageType.property("mobileApp")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    pageType.property("footerTab")
                      
                        .with("features", "root,visible_all,bool")
                      ;
                    
                    pageType.property("footerTab")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,BOOL,ADMINUI,EXCEL_VIEW");

                    
                  
                    pageType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    pageType.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerSlide(){
        EntityMeta slide = MetaProvider.entity("com.doublechaintech.retailscm.slide.Slide")
                  
                        .with("features", "root,visible_all")
                  ;
                  slide.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    slide.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    slide.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    slide.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    slide.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    slide.property("displayOrder")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    
                    slide.property("displayOrder")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    slide.property("imageUrl")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      ;
                    
                    slide.property("imageUrl")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,IMAGE,DELETE,VISIBLE_PARENT,VIEWDETAIL,ATTACHMENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    slide.property("videoUrl")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      ;
                    
                    slide.property("videoUrl")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,IMAGE,DELETE,VISIBLE_PARENT,VIEWDETAIL,ATTACHMENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    slide.property("linkToUrl")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    slide.property("linkToUrl")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    slide.property("page")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4mobile_app", "页面管理")
                      ;
                    
                    slide.property("page")
                        .with("parentType", "com.doublechaintech.retailscm.page.Page");
                    
                    slide.property("page")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    slide.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    slide.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerUiAction(){
        EntityMeta uiAction = MetaProvider.entity("com.doublechaintech.retailscm.uiaction.UiAction")
                  
                        .with("features", "root,visible_all")
                  ;
                  uiAction.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    uiAction.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    uiAction.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    uiAction.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    uiAction.property("code")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    uiAction.property("icon")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    uiAction.property("icon")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    uiAction.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    uiAction.property("title")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    uiAction.property("displayOrder")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    
                    uiAction.property("displayOrder")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    uiAction.property("brief")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    uiAction.property("brief")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    uiAction.property("imageUrl")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      ;
                    
                    uiAction.property("imageUrl")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,IMAGE,DELETE,VISIBLE_PARENT,VIEWDETAIL,ATTACHMENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    uiAction.property("linkToUrl")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    uiAction.property("linkToUrl")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    uiAction.property("extraData")
                      
                        .with("parent", "string_longtext")
                      
                        .with("type", "string_longtext")
                      
                        .with("features", "root,visible_all,string,longtext")
                      ;
                    
                    uiAction.property("extraData")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,LONGTEXT,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    uiAction.property("page")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4mobile_app", "页面管理")
                      ;
                    
                    uiAction.property("page")
                        .with("parentType", "com.doublechaintech.retailscm.page.Page");
                    
                    uiAction.property("page")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    uiAction.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    uiAction.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerSection(){
        EntityMeta section = MetaProvider.entity("com.doublechaintech.retailscm.section.Section")
                  
                        .with("features", "root,visible_all")
                  ;
                  section.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    section.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    section.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    section.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    section.property("title")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    section.property("brief")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    section.property("brief")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    section.property("icon")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      ;
                    
                    section.property("icon")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,IMAGE,DELETE,VISIBLE_PARENT,VIEWDETAIL,ATTACHMENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    section.property("displayOrder")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    
                    section.property("displayOrder")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    section.property("viewGroup")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    section.property("viewGroup")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    section.property("linkToUrl")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    section.property("linkToUrl")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    section.property("page")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4mobile_app", "页面管理")
                      ;
                    
                    section.property("page")
                        .with("parentType", "com.doublechaintech.retailscm.page.Page");
                    
                    section.property("page")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    section.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    section.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerUserDomain(){
        EntityMeta userDomain = MetaProvider.entity("com.doublechaintech.retailscm.userdomain.UserDomain")
                  
                        .with("features", "ootb,no_sample_data,iam")
                  
                        .with("zh_CN", "用户域")
                  ;
                  userDomain.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ACTION,ADD,UPDATE,ADMINUI,EXCEL_VIEW,IAM");
                  
                    userDomain.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    userDomain.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    userDomain.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    userDomain.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    userDomain.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    userDomain.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerUserAllowList(){
        EntityMeta userAllowList = MetaProvider.entity("com.doublechaintech.retailscm.userallowlist.UserAllowList")
                  
                        .with("features", "syssetting")
                  
                        .with("zh_CN", "用户权限列表")
                  ;
                  userAllowList.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW,PREFERENCE");
                  
                    userAllowList.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    userAllowList.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    userAllowList.property("userIdentity")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      
                        .with("zh_CN", "用户标识")
                      ;
                    
                    userAllowList.property("userIdentity")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,MOBILE,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    userAllowList.property("userSpecialFunctions")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "用户特权")
                      ;
                    
                    userAllowList.property("userSpecialFunctions")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    userAllowList.property("domain")
                      
                        .with("features", "ootb,no_sample_data,iam")
                      
                        .with("zh_CN", "域")
                      ;
                    
                    userAllowList.property("domain")
                        .with("parentType", "com.doublechaintech.retailscm.userdomain.UserDomain");
                    
                    userAllowList.property("domain")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ACTION,ADD,UPDATE,ADMINUI,EXCEL_VIEW,IAM");

                    
                  
                    userAllowList.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    userAllowList.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerSecUser(){
        EntityMeta secUser = MetaProvider.entity("com.doublechaintech.retailscm.secuser.SecUser")
                  
                        .with("identified_by", "login,email,mobile")
                  
                        .with("features", "ootb")
                  
                        .with("zh_CN", "安全用户")
                  ;
                  secUser.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    secUser.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    secUser.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    secUser.property("login")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "登录名")
                      ;
                    
                    secUser.property("login")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    secUser.property("mobile")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      
                        .with("zh_CN", "手机")
                      ;
                    
                    secUser.property("mobile")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,MOBILE,IDENTIFIER,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    secUser.property("email")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,email")
                      
                        .with("zh_CN", "邮箱")
                      ;
                    
                    secUser.property("email")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,EMAIL,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    secUser.property("pwd")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,password")
                      
                        .with("zh_CN", "密码")
                      ;
                    
                    secUser.property("pwd")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,PASSWORD,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    secUser.property("weixinOpenid")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "微信openId")
                      ;
                    
                    secUser.property("weixinOpenid")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    secUser.property("weixinAppid")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "微信应用ID")
                      ;
                    
                    secUser.property("weixinAppid")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    secUser.property("accessToken")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "访问令牌")
                      ;
                    
                    secUser.property("accessToken")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    secUser.property("verificationCode")
                      
                        .with("features", "root,visible_all,int")
                      
                        .with("zh_CN", "验证码")
                      ;
                    
                    secUser.property("verificationCode")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    secUser.property("verificationCodeExpire")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("zh_CN", "验证码有效期")
                      ;
                    
                    secUser.property("verificationCodeExpire")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    secUser.property("lastLoginTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("zh_CN", "最后登录时间")
                      ;
                    
                    secUser.property("lastLoginTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    secUser.property("domain")
                      
                        .with("features", "ootb,no_sample_data,iam")
                      
                        .with("zh_CN", "域")
                      ;
                    
                    secUser.property("domain")
                        .with("parentType", "com.doublechaintech.retailscm.userdomain.UserDomain");
                    
                    secUser.property("domain")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ACTION,ADD,UPDATE,ADMINUI,EXCEL_VIEW,IAM");

                    
                  
                    secUser.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    secUser.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerUserApp(){
        EntityMeta userApp = MetaProvider.entity("com.doublechaintech.retailscm.userapp.UserApp")
                  
                        .with("features", "ootb")
                  
                        .with("zh_CN", "应用")
                  ;
                  userApp.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    userApp.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    userApp.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    userApp.property("title")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "标题")
                      ;
                    
                    userApp.property("title")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    userApp.property("secUser")
                      
                        .with("identified_by", "login,email,mobile")
                      
                        .with("features", "ootb")
                      
                        .with("zh_CN", "系统用户")
                      ;
                    
                    userApp.property("secUser")
                        .with("parentType", "com.doublechaintech.retailscm.secuser.SecUser");
                    
                    userApp.property("secUser")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    userApp.property("appIcon")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "图标")
                      ;
                    
                    userApp.property("appIcon")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    userApp.property("fullAccess")
                      
                        .with("features", "root,visible_all,bool")
                      
                        .with("zh_CN", "完全访问")
                      ;
                    
                    userApp.property("fullAccess")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,BOOL,ADMINUI,EXCEL_VIEW");

                    
                  
                    userApp.property("permission")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "权限")
                      ;
                    
                    userApp.property("permission")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    userApp.property("appType")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "对象类型")
                      ;
                    
                    userApp.property("appType")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    userApp.property("appId")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "对象ID")
                      ;
                    
                    userApp.property("appId")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    userApp.property("ctxType")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "上下文类型")
                      ;
                    
                    userApp.property("ctxType")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    userApp.property("ctxId")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "上下文类型")
                      ;
                    
                    userApp.property("ctxId")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    userApp.property("location")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "位置")
                      ;
                    
                    userApp.property("location")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    userApp.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    userApp.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerQuickLink(){
        EntityMeta quickLink = MetaProvider.entity("com.doublechaintech.retailscm.quicklink.QuickLink")
                  
                        .with("features", "ootb")
                  ;
                  quickLink.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    quickLink.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    quickLink.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    quickLink.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    quickLink.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    quickLink.property("icon")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    quickLink.property("icon")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    quickLink.property("imagePath")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      ;
                    
                    quickLink.property("imagePath")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,IMAGE,DELETE,VISIBLE_PARENT,VIEWDETAIL,ATTACHMENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    quickLink.property("linkTarget")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    
                    quickLink.property("linkTarget")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    quickLink.property("createTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    
                    quickLink.property("createTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    quickLink.property("app")
                      
                        .with("features", "ootb")
                      
                        .with("zh_CN", "应用")
                      ;
                    
                    quickLink.property("app")
                        .with("parentType", "com.doublechaintech.retailscm.userapp.UserApp");
                    
                    quickLink.property("app")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    quickLink.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    quickLink.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerListAccess(){
        EntityMeta listAccess = MetaProvider.entity("com.doublechaintech.retailscm.listaccess.ListAccess")
                  
                        .with("features", "ootb")
                  
                        .with("zh_CN", "列表访问控制")
                  ;
                  listAccess.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    listAccess.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    listAccess.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    listAccess.property("name")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "名称")
                      ;
                    
                    listAccess.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    listAccess.property("internalName")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "内部名称")
                      ;
                    
                    listAccess.property("internalName")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    listAccess.property("readPermission")
                      
                        .with("features", "root,visible_all,bool")
                      
                        .with("zh_CN", "可读")
                      ;
                    
                    listAccess.property("readPermission")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,BOOL,ADMINUI,EXCEL_VIEW");

                    
                  
                    listAccess.property("createPermission")
                      
                        .with("features", "root,visible_all,bool")
                      
                        .with("zh_CN", "可创建")
                      ;
                    
                    listAccess.property("createPermission")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,BOOL,ADMINUI,EXCEL_VIEW");

                    
                  
                    listAccess.property("deletePermission")
                      
                        .with("features", "root,visible_all,bool")
                      
                        .with("zh_CN", "可删除")
                      ;
                    
                    listAccess.property("deletePermission")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,BOOL,ADMINUI,EXCEL_VIEW");

                    
                  
                    listAccess.property("updatePermission")
                      
                        .with("features", "root,visible_all,bool")
                      
                        .with("zh_CN", "可更新")
                      ;
                    
                    listAccess.property("updatePermission")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,BOOL,ADMINUI,EXCEL_VIEW");

                    
                  
                    listAccess.property("executionPermission")
                      
                        .with("features", "root,visible_all,bool")
                      
                        .with("zh_CN", "可执行")
                      ;
                    
                    listAccess.property("executionPermission")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,BOOL,ADMINUI,EXCEL_VIEW");

                    
                  
                    listAccess.property("app")
                      
                        .with("features", "ootb")
                      
                        .with("zh_CN", "应用")
                      ;
                    
                    listAccess.property("app")
                        .with("parentType", "com.doublechaintech.retailscm.userapp.UserApp");
                    
                    listAccess.property("app")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    listAccess.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    listAccess.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerLoginHistory(){
        EntityMeta loginHistory = MetaProvider.entity("com.doublechaintech.retailscm.loginhistory.LoginHistory")
                  
                        .with("features", "syslog")
                  
                        .with("zh_CN", "登录历史")
                  ;
                  loginHistory.with("tokens", "VISIBLE_PARENT,SEARCHABLE,VIEWDETAIL,VISIBLE_CHILD,PERSISTENCE,ACTION,SAMPLE_DATA,SEARCH,LOG,ADMINUI,EXCEL_VIEW");
                  
                    loginHistory.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    loginHistory.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    loginHistory.property("loginTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      
                        .with("zh_CN", "登录时间")
                      ;
                    
                    loginHistory.property("loginTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    loginHistory.property("fromIp")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "来自IP")
                      ;
                    
                    loginHistory.property("fromIp")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    loginHistory.property("description")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "描述")
                      ;
                    
                    loginHistory.property("description")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    loginHistory.property("secUser")
                      
                        .with("identified_by", "login,email,mobile")
                      
                        .with("features", "ootb")
                      
                        .with("zh_CN", "系统用户")
                      ;
                    
                    loginHistory.property("secUser")
                        .with("parentType", "com.doublechaintech.retailscm.secuser.SecUser");
                    
                    loginHistory.property("secUser")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    loginHistory.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    loginHistory.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerCandidateContainer(){
        EntityMeta candidateContainer = MetaProvider.entity("com.doublechaintech.retailscm.candidatecontainer.CandidateContainer")
                  
                        .with("features", "internal,ootb")
                  
                        .with("zh_CN", "候选容器")
                  ;
                  candidateContainer.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ACTION,ADD,SAMPLE_DATA,UPDATE,EXCEL_VIEW,ADMINUI");
                  
                    candidateContainer.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    candidateContainer.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    candidateContainer.property("name")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "名称")
                      ;
                    
                    candidateContainer.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    candidateContainer.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    candidateContainer.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerCandidateElement(){
        EntityMeta candidateElement = MetaProvider.entity("com.doublechaintech.retailscm.candidateelement.CandidateElement")
                  
                        .with("features", "internal,ootb")
                  ;
                  candidateElement.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ACTION,ADD,SAMPLE_DATA,UPDATE,EXCEL_VIEW,ADMINUI");
                  
                    candidateElement.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    candidateElement.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    candidateElement.property("name")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "标题")
                      ;
                    
                    candidateElement.property("name")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    candidateElement.property("type")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "类型")
                      ;
                    
                    candidateElement.property("type")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    candidateElement.property("image")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      
                        .with("zh_CN", "图像")
                      ;
                    
                    candidateElement.property("image")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,IMAGE,DELETE,VISIBLE_PARENT,VIEWDETAIL,ATTACHMENT,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    candidateElement.property("container")
                      
                        .with("features", "internal,ootb")
                      
                        .with("zh_CN", "容器")
                      ;
                    
                    candidateElement.property("container")
                        .with("parentType", "com.doublechaintech.retailscm.candidatecontainer.CandidateContainer");
                    
                    candidateElement.property("container")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ACTION,ADD,SAMPLE_DATA,UPDATE,EXCEL_VIEW,ADMINUI");

                    
                  
                    candidateElement.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    candidateElement.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerWechatWorkappIdentity(){
        EntityMeta wechatWorkappIdentity = MetaProvider.entity("com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentity")
                  
                        .with("features", "root,visible_all")
                  
                        .with("zh_CN", "企业微信认证")
                  ;
                  wechatWorkappIdentity.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    wechatWorkappIdentity.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    wechatWorkappIdentity.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    wechatWorkappIdentity.property("corpId")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "公司")
                      ;
                    
                    wechatWorkappIdentity.property("corpId")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    wechatWorkappIdentity.property("userId")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "用户")
                      ;
                    
                    wechatWorkappIdentity.property("userId")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    wechatWorkappIdentity.property("secUser")
                      
                        .with("identified_by", "login,email,mobile")
                      
                        .with("features", "ootb")
                      
                        .with("zh_CN", "系统用户")
                      ;
                    
                    wechatWorkappIdentity.property("secUser")
                        .with("parentType", "com.doublechaintech.retailscm.secuser.SecUser");
                    
                    wechatWorkappIdentity.property("secUser")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    wechatWorkappIdentity.property("createTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      
                        .with("zh_CN", "创建时间")
                      ;
                    
                    wechatWorkappIdentity.property("createTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    wechatWorkappIdentity.property("lastLoginTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("zh_CN", "最后登录时间")
                      ;
                    
                    wechatWorkappIdentity.property("lastLoginTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    wechatWorkappIdentity.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    wechatWorkappIdentity.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerWechatMiniappIdentity(){
        EntityMeta wechatMiniappIdentity = MetaProvider.entity("com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentity")
                  
                        .with("features", "root,visible_all")
                  
                        .with("zh_CN", "微信小程序认证")
                  ;
                  wechatMiniappIdentity.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    wechatMiniappIdentity.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    wechatMiniappIdentity.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    wechatMiniappIdentity.property("openId")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "openId")
                      ;
                    
                    wechatMiniappIdentity.property("openId")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    wechatMiniappIdentity.property("appId")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "应用ID")
                      ;
                    
                    wechatMiniappIdentity.property("appId")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    wechatMiniappIdentity.property("unionId")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "UnionID")
                      ;
                    
                    wechatMiniappIdentity.property("unionId")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    wechatMiniappIdentity.property("secUser")
                      
                        .with("identified_by", "login,email,mobile")
                      
                        .with("features", "ootb")
                      
                        .with("zh_CN", "系统用户")
                      ;
                    
                    wechatMiniappIdentity.property("secUser")
                        .with("parentType", "com.doublechaintech.retailscm.secuser.SecUser");
                    
                    wechatMiniappIdentity.property("secUser")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    wechatMiniappIdentity.property("createTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      
                        .with("zh_CN", "创建时间")
                      ;
                    
                    wechatMiniappIdentity.property("createTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    wechatMiniappIdentity.property("lastLoginTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("zh_CN", "最后登录时间")
                      ;
                    
                    wechatMiniappIdentity.property("lastLoginTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    wechatMiniappIdentity.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    wechatMiniappIdentity.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerKeyPairIdentity(){
        EntityMeta keyPairIdentity = MetaProvider.entity("com.doublechaintech.retailscm.keypairidentity.KeyPairIdentity")
                  
                        .with("features", "root,visible_all")
                  
                        .with("zh_CN", "秘钥对认证")
                  ;
                  keyPairIdentity.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    keyPairIdentity.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    keyPairIdentity.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    keyPairIdentity.property("publicKey")
                      
                        .with("parent", "string_longtext")
                      
                        .with("type", "string_longtext")
                      
                        .with("features", "root,visible_all,string,longtext")
                      
                        .with("zh_CN", "公钥")
                      ;
                    
                    keyPairIdentity.property("publicKey")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,LONGTEXT,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    keyPairIdentity.property("keyType")
                      
                        .with("features", "root,visible_all")
                      
                        .with("zh_CN", "秘钥类型")
                      ;
                    
                    keyPairIdentity.property("keyType")
                        .with("parentType", "com.doublechaintech.retailscm.publickeytype.PublicKeyType");
                    
                    keyPairIdentity.property("keyType")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    keyPairIdentity.property("secUser")
                      
                        .with("identified_by", "login,email,mobile")
                      
                        .with("features", "ootb")
                      
                        .with("zh_CN", "系统用户")
                      ;
                    
                    keyPairIdentity.property("secUser")
                        .with("parentType", "com.doublechaintech.retailscm.secuser.SecUser");
                    
                    keyPairIdentity.property("secUser")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    keyPairIdentity.property("createTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      
                        .with("zh_CN", "创建时间")
                      ;
                    
                    keyPairIdentity.property("createTime")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,DATE_TIME,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    keyPairIdentity.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    keyPairIdentity.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerPublicKeyType(){
        EntityMeta publicKeyType = MetaProvider.entity("com.doublechaintech.retailscm.publickeytype.PublicKeyType")
                  
                        .with("features", "root,visible_all")
                  
                        .with("zh_CN", "公钥类型")
                  ;
                  publicKeyType.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    publicKeyType.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    publicKeyType.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    publicKeyType.property("keyAlg")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "加密算法")
                      ;
                    
                    publicKeyType.property("keyAlg")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    publicKeyType.property("signAlg")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "签名算法")
                      ;
                    
                    publicKeyType.property("signAlg")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    publicKeyType.property("domain")
                      
                        .with("features", "ootb,no_sample_data,iam")
                      
                        .with("zh_CN", "域")
                      ;
                    
                    publicKeyType.property("domain")
                        .with("parentType", "com.doublechaintech.retailscm.userdomain.UserDomain");
                    
                    publicKeyType.property("domain")
                        .with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,ACTION,ADD,UPDATE,ADMINUI,EXCEL_VIEW,IAM");

                    
                  
                    publicKeyType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    publicKeyType.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }

    public void  registerTreeNode(){
        EntityMeta treeNode = MetaProvider.entity("com.doublechaintech.retailscm.treenode.TreeNode")
                  
                        .with("features", "root,visible_all")
                  
                        .with("zh_CN", "节点")
                  ;
                  treeNode.with("tokens", "SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");
                  
                    treeNode.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    
                    treeNode.property("id")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,IDENTIFIER,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    treeNode.property("nodeId")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "节点ID")
                      ;
                    
                    treeNode.property("nodeId")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    treeNode.property("nodeType")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "节点类型")
                      ;
                    
                    treeNode.property("nodeType")
                        .with("tokens", "SEARCHABLE,STRING,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    treeNode.property("leftValue")
                      
                        .with("features", "root,visible_all,int")
                      
                        .with("zh_CN", "左值")
                      ;
                    
                    treeNode.property("leftValue")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    treeNode.property("rightValue")
                      
                        .with("features", "root,visible_all,int")
                      
                        .with("zh_CN", "右值")
                      ;
                    
                    treeNode.property("rightValue")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
                    treeNode.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    
                    treeNode.property("version")
                        .with("tokens", "INT,SEARCHABLE,VISIBLE_CHILD,PERSISTENCE,SEARCH,DELETE,VERSION,VISIBLE_PARENT,VIEWDETAIL,USERSPACE,ACTION,ENTITY_BASE,ADD,SAMPLE_DATA,UPDATE,ADMINUI,EXCEL_VIEW");

                    
                  
    }


}
















