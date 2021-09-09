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
                  
                    retailStoreCountryCenter.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    retailStoreCountryCenter.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreCountryCenter.property("serviceNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreCountryCenter.property("founded")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    retailStoreCountryCenter.property("webSite")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreCountryCenter.property("address")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreCountryCenter.property("operatedBy")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreCountryCenter.property("legalRepresentative")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreCountryCenter.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreCountryCenter.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerCatalog(){
        EntityMeta catalog = MetaProvider.entity("com.doublechaintech.retailscm.catalog.Catalog")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4owner", "产品管理")
                  ;
                  
                    catalog.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    catalog.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    catalog.property("owner")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    catalog.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    catalog.property("subCount")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    

                    
                  
                    catalog.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    catalog.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerLevelOneCategory(){
        EntityMeta levelOneCategory = MetaProvider.entity("com.doublechaintech.retailscm.levelonecategory.LevelOneCategory")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    levelOneCategory.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    levelOneCategory.property("catalog")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "产品管理")
                      ;
                    
                    levelOneCategory.property("catalog")
                        .with("parentType", "com.doublechaintech.retailscm.catalog.Catalog");
                    

                    
                  
                    levelOneCategory.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    levelOneCategory.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerLevelTwoCategory(){
        EntityMeta levelTwoCategory = MetaProvider.entity("com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    levelTwoCategory.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    levelTwoCategory.property("parentCategory")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    levelTwoCategory.property("parentCategory")
                        .with("parentType", "com.doublechaintech.retailscm.levelonecategory.LevelOneCategory");
                    

                    
                  
                    levelTwoCategory.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    levelTwoCategory.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerLevelThreeCategory(){
        EntityMeta levelThreeCategory = MetaProvider.entity("com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    levelThreeCategory.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    levelThreeCategory.property("parentCategory")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    levelThreeCategory.property("parentCategory")
                        .with("parentType", "com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory");
                    

                    
                  
                    levelThreeCategory.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    levelThreeCategory.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerProduct(){
        EntityMeta product = MetaProvider.entity("com.doublechaintech.retailscm.product.Product")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    product.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    product.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    product.property("parentCategory")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    product.property("parentCategory")
                        .with("parentType", "com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory");
                    

                    
                  
                    product.property("origin")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    product.property("remark")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    product.property("brand")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    product.property("picture")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      ;
                    

                    
                  
                    product.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    product.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerSku(){
        EntityMeta sku = MetaProvider.entity("com.doublechaintech.retailscm.sku.Sku")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    sku.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    sku.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    sku.property("size")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    sku.property("product")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    sku.property("product")
                        .with("parentType", "com.doublechaintech.retailscm.product.Product");
                    

                    
                  
                    sku.property("barcode")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    sku.property("packageType")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    sku.property("netContent")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    sku.property("price")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    sku.property("picture")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      ;
                    

                    
                  
                    sku.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerRetailStoreProvinceCenter(){
        EntityMeta retailStoreProvinceCenter = MetaProvider.entity("com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter")
                  
                        .with("vg4country", "组织机构")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    retailStoreProvinceCenter.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    retailStoreProvinceCenter.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreProvinceCenter.property("founded")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    retailStoreProvinceCenter.property("country")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStoreProvinceCenter.property("country")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    retailStoreProvinceCenter.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    retailStoreProvinceCenter.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerProvinceCenterDepartment(){
        EntityMeta provinceCenterDepartment = MetaProvider.entity("com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment")
                  
                        .with("features", "setting")
                  ;
                  
                    provinceCenterDepartment.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    provinceCenterDepartment.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    provinceCenterDepartment.property("founded")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    provinceCenterDepartment.property("provinceCenter")
                      
                        .with("vg4country", "组织机构")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    provinceCenterDepartment.property("provinceCenter")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter");
                    

                    
                  
                    provinceCenterDepartment.property("manager")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    provinceCenterDepartment.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerProvinceCenterEmployee(){
        EntityMeta provinceCenterEmployee = MetaProvider.entity("com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    provinceCenterEmployee.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    provinceCenterEmployee.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    provinceCenterEmployee.property("mobile")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    

                    
                  
                    provinceCenterEmployee.property("email")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,email")
                      ;
                    

                    
                  
                    provinceCenterEmployee.property("founded")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    provinceCenterEmployee.property("department")
                      
                        .with("features", "setting")
                      ;
                    
                    provinceCenterEmployee.property("department")
                        .with("parentType", "com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment");
                    

                    
                  
                    provinceCenterEmployee.property("provinceCenter")
                      
                        .with("vg4country", "组织机构")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    provinceCenterEmployee.property("provinceCenter")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter");
                    

                    
                  
                    provinceCenterEmployee.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerRetailStoreCityServiceCenter(){
        EntityMeta retailStoreCityServiceCenter = MetaProvider.entity("com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    retailStoreCityServiceCenter.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    retailStoreCityServiceCenter.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreCityServiceCenter.property("founded")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    retailStoreCityServiceCenter.property("belongsTo")
                      
                        .with("vg4country", "组织机构")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStoreCityServiceCenter.property("belongsTo")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter");
                    

                    
                  
                    retailStoreCityServiceCenter.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    retailStoreCityServiceCenter.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerCityPartner(){
        EntityMeta cityPartner = MetaProvider.entity("com.doublechaintech.retailscm.citypartner.CityPartner")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    cityPartner.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    cityPartner.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    cityPartner.property("mobile")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    

                    
                  
                    cityPartner.property("cityServiceCenter")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    cityPartner.property("cityServiceCenter")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter");
                    

                    
                  
                    cityPartner.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    cityPartner.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    cityPartner.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerPotentialCustomer(){
        EntityMeta potentialCustomer = MetaProvider.entity("com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    potentialCustomer.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    potentialCustomer.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    potentialCustomer.property("mobile")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    

                    
                  
                    potentialCustomer.property("cityServiceCenter")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    potentialCustomer.property("cityServiceCenter")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter");
                    

                    
                  
                    potentialCustomer.property("cityPartner")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    potentialCustomer.property("cityPartner")
                        .with("parentType", "com.doublechaintech.retailscm.citypartner.CityPartner");
                    

                    
                  
                    potentialCustomer.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    potentialCustomer.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    potentialCustomer.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerPotentialCustomerContactPerson(){
        EntityMeta potentialCustomerContactPerson = MetaProvider.entity("com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    potentialCustomerContactPerson.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    potentialCustomerContactPerson.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    potentialCustomerContactPerson.property("mobile")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    

                    
                  
                    potentialCustomerContactPerson.property("potentialCustomer")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    potentialCustomerContactPerson.property("potentialCustomer")
                        .with("parentType", "com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer");
                    

                    
                  
                    potentialCustomerContactPerson.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    potentialCustomerContactPerson.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerPotentialCustomerContact(){
        EntityMeta potentialCustomerContact = MetaProvider.entity("com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    potentialCustomerContact.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    potentialCustomerContact.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    potentialCustomerContact.property("contactDate")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    potentialCustomerContact.property("contactMethod")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    potentialCustomerContact.property("potentialCustomer")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    potentialCustomerContact.property("potentialCustomer")
                        .with("parentType", "com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer");
                    

                    
                  
                    potentialCustomerContact.property("cityPartner")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    potentialCustomerContact.property("cityPartner")
                        .with("parentType", "com.doublechaintech.retailscm.citypartner.CityPartner");
                    

                    
                  
                    potentialCustomerContact.property("contactTo")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    potentialCustomerContact.property("contactTo")
                        .with("parentType", "com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson");
                    

                    
                  
                    potentialCustomerContact.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    potentialCustomerContact.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    potentialCustomerContact.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerCityEvent(){
        EntityMeta cityEvent = MetaProvider.entity("com.doublechaintech.retailscm.cityevent.CityEvent")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    cityEvent.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    cityEvent.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    cityEvent.property("mobile")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    

                    
                  
                    cityEvent.property("cityServiceCenter")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    cityEvent.property("cityServiceCenter")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter");
                    

                    
                  
                    cityEvent.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    cityEvent.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    cityEvent.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerEventAttendance(){
        EntityMeta eventAttendance = MetaProvider.entity("com.doublechaintech.retailscm.eventattendance.EventAttendance")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    eventAttendance.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    eventAttendance.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    eventAttendance.property("potentialCustomer")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    eventAttendance.property("potentialCustomer")
                        .with("parentType", "com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer");
                    

                    
                  
                    eventAttendance.property("cityEvent")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    eventAttendance.property("cityEvent")
                        .with("parentType", "com.doublechaintech.retailscm.cityevent.CityEvent");
                    

                    
                  
                    eventAttendance.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    eventAttendance.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerRetailStore(){
        EntityMeta retailStore = MetaProvider.entity("com.doublechaintech.retailscm.retailstore.RetailStore")
                  
                        .with("vg4retail_store_country_center", "加盟管理")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    retailStore.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    retailStore.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStore.property("telephone")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStore.property("owner")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStore.property("retailStoreCountryCenter")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStore.property("retailStoreCountryCenter")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    retailStore.property("cityServiceCenter")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStore.property("cityServiceCenter")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter");
                    

                    
                  
                    retailStore.property("creation")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStore.property("creation")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation");
                    

                    
                  
                    retailStore.property("investmentInvitation")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStore.property("investmentInvitation")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation");
                    

                    
                  
                    retailStore.property("franchising")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStore.property("franchising")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising");
                    

                    
                  
                    retailStore.property("decoration")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStore.property("decoration")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration");
                    

                    
                  
                    retailStore.property("opening")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStore.property("opening")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening");
                    

                    
                  
                    retailStore.property("closing")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStore.property("closing")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing");
                    

                    
                  
                    retailStore.property("founded")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    retailStore.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    retailStore.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    retailStore.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStore.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    retailStore.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerRetailStoreCreation(){
        EntityMeta retailStoreCreation = MetaProvider.entity("com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    retailStoreCreation.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    retailStoreCreation.property("comment")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreCreation.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerRetailStoreInvestmentInvitation(){
        EntityMeta retailStoreInvestmentInvitation = MetaProvider.entity("com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    retailStoreInvestmentInvitation.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    retailStoreInvestmentInvitation.property("comment")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreInvestmentInvitation.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerRetailStoreFranchising(){
        EntityMeta retailStoreFranchising = MetaProvider.entity("com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    retailStoreFranchising.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    retailStoreFranchising.property("comment")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreFranchising.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerRetailStoreDecoration(){
        EntityMeta retailStoreDecoration = MetaProvider.entity("com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    retailStoreDecoration.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    retailStoreDecoration.property("comment")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreDecoration.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerRetailStoreOpening(){
        EntityMeta retailStoreOpening = MetaProvider.entity("com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    retailStoreOpening.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    retailStoreOpening.property("comment")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreOpening.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerRetailStoreClosing(){
        EntityMeta retailStoreClosing = MetaProvider.entity("com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    retailStoreClosing.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    retailStoreClosing.property("comment")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreClosing.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerRetailStoreMember(){
        EntityMeta retailStoreMember = MetaProvider.entity("com.doublechaintech.retailscm.retailstoremember.RetailStoreMember")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4owner", "会员管理")
                  ;
                  
                    retailStoreMember.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    retailStoreMember.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreMember.property("mobilePhone")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    

                    
                  
                    retailStoreMember.property("owner")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStoreMember.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    retailStoreMember.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerConsumerOrder(){
        EntityMeta consumerOrder = MetaProvider.entity("com.doublechaintech.retailscm.consumerorder.ConsumerOrder")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    consumerOrder.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    consumerOrder.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    consumerOrder.property("consumer")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "会员管理")
                      ;
                    
                    consumerOrder.property("consumer")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");
                    

                    
                  
                    consumerOrder.property("store")
                      
                        .with("vg4retail_store_country_center", "加盟管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    consumerOrder.property("store")
                        .with("parentType", "com.doublechaintech.retailscm.retailstore.RetailStore");
                    

                    
                  
                    consumerOrder.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    consumerOrder.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerConsumerOrderLineItem(){
        EntityMeta consumerOrderLineItem = MetaProvider.entity("com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItem")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    consumerOrderLineItem.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    consumerOrderLineItem.property("bizOrder")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    consumerOrderLineItem.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.consumerorder.ConsumerOrder");
                    

                    
                  
                    consumerOrderLineItem.property("skuId")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    consumerOrderLineItem.property("skuName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    consumerOrderLineItem.property("price")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    consumerOrderLineItem.property("quantity")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    consumerOrderLineItem.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    consumerOrderLineItem.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    consumerOrderLineItem.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerConsumerOrderShippingGroup(){
        EntityMeta consumerOrderShippingGroup = MetaProvider.entity("com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    consumerOrderShippingGroup.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    consumerOrderShippingGroup.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    consumerOrderShippingGroup.property("bizOrder")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    consumerOrderShippingGroup.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.consumerorder.ConsumerOrder");
                    

                    
                  
                    consumerOrderShippingGroup.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    consumerOrderShippingGroup.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerConsumerOrderPaymentGroup(){
        EntityMeta consumerOrderPaymentGroup = MetaProvider.entity("com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    consumerOrderPaymentGroup.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    consumerOrderPaymentGroup.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    consumerOrderPaymentGroup.property("bizOrder")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    consumerOrderPaymentGroup.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.consumerorder.ConsumerOrder");
                    

                    
                  
                    consumerOrderPaymentGroup.property("cardNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    consumerOrderPaymentGroup.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerConsumerOrderPriceAdjustment(){
        EntityMeta consumerOrderPriceAdjustment = MetaProvider.entity("com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    consumerOrderPriceAdjustment.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    consumerOrderPriceAdjustment.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    consumerOrderPriceAdjustment.property("bizOrder")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    consumerOrderPriceAdjustment.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.consumerorder.ConsumerOrder");
                    

                    
                  
                    consumerOrderPriceAdjustment.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    consumerOrderPriceAdjustment.property("provider")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    consumerOrderPriceAdjustment.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerRetailStoreMemberCoupon(){
        EntityMeta retailStoreMemberCoupon = MetaProvider.entity("com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    retailStoreMemberCoupon.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    retailStoreMemberCoupon.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreMemberCoupon.property("owner")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "会员管理")
                      ;
                    
                    retailStoreMemberCoupon.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");
                    

                    
                  
                    retailStoreMemberCoupon.property("number")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreMemberCoupon.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    retailStoreMemberCoupon.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerMemberWishlist(){
        EntityMeta memberWishlist = MetaProvider.entity("com.doublechaintech.retailscm.memberwishlist.MemberWishlist")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    memberWishlist.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    memberWishlist.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    memberWishlist.property("owner")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "会员管理")
                      ;
                    
                    memberWishlist.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");
                    

                    
                  
                    memberWishlist.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerMemberRewardPoint(){
        EntityMeta memberRewardPoint = MetaProvider.entity("com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPoint")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    memberRewardPoint.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    memberRewardPoint.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    memberRewardPoint.property("point")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    

                    
                  
                    memberRewardPoint.property("owner")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "会员管理")
                      ;
                    
                    memberRewardPoint.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");
                    

                    
                  
                    memberRewardPoint.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerMemberRewardPointRedemption(){
        EntityMeta memberRewardPointRedemption = MetaProvider.entity("com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemption")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    memberRewardPointRedemption.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    memberRewardPointRedemption.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    memberRewardPointRedemption.property("point")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    

                    
                  
                    memberRewardPointRedemption.property("owner")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "会员管理")
                      ;
                    
                    memberRewardPointRedemption.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");
                    

                    
                  
                    memberRewardPointRedemption.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerMemberWishlistProduct(){
        EntityMeta memberWishlistProduct = MetaProvider.entity("com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProduct")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    memberWishlistProduct.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    memberWishlistProduct.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    memberWishlistProduct.property("owner")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    memberWishlistProduct.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.memberwishlist.MemberWishlist");
                    

                    
                  
                    memberWishlistProduct.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerRetailStoreMemberAddress(){
        EntityMeta retailStoreMemberAddress = MetaProvider.entity("com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddress")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    retailStoreMemberAddress.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    retailStoreMemberAddress.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreMemberAddress.property("owner")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "会员管理")
                      ;
                    
                    retailStoreMemberAddress.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");
                    

                    
                  
                    retailStoreMemberAddress.property("mobilePhone")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    

                    
                  
                    retailStoreMemberAddress.property("address")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreMemberAddress.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerRetailStoreMemberGiftCard(){
        EntityMeta retailStoreMemberGiftCard = MetaProvider.entity("com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    retailStoreMemberGiftCard.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    retailStoreMemberGiftCard.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreMemberGiftCard.property("owner")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "会员管理")
                      ;
                    
                    retailStoreMemberGiftCard.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoremember.RetailStoreMember");
                    

                    
                  
                    retailStoreMemberGiftCard.property("number")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreMemberGiftCard.property("remain")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    retailStoreMemberGiftCard.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerRetailStoreMemberGiftCardConsumeRecord(){
        EntityMeta retailStoreMemberGiftCardConsumeRecord = MetaProvider.entity("com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    retailStoreMemberGiftCardConsumeRecord.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    retailStoreMemberGiftCardConsumeRecord.property("occureTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    retailStoreMemberGiftCardConsumeRecord.property("owner")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStoreMemberGiftCardConsumeRecord.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard");
                    

                    
                  
                    retailStoreMemberGiftCardConsumeRecord.property("bizOrder")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStoreMemberGiftCardConsumeRecord.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.consumerorder.ConsumerOrder");
                    

                    
                  
                    retailStoreMemberGiftCardConsumeRecord.property("number")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreMemberGiftCardConsumeRecord.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    retailStoreMemberGiftCardConsumeRecord.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerGoodsSupplier(){
        EntityMeta goodsSupplier = MetaProvider.entity("com.doublechaintech.retailscm.goodssupplier.GoodsSupplier")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4belong_to", "供应管理")
                  ;
                  
                    goodsSupplier.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    goodsSupplier.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    goodsSupplier.property("supplyProduct")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    goodsSupplier.property("belongTo")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goodsSupplier.property("belongTo")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    goodsSupplier.property("contactNumber")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    

                    
                  
                    goodsSupplier.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    goodsSupplier.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    goodsSupplier.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerSupplierProduct(){
        EntityMeta supplierProduct = MetaProvider.entity("com.doublechaintech.retailscm.supplierproduct.SupplierProduct")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    supplierProduct.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    supplierProduct.property("productName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    supplierProduct.property("productDescription")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    supplierProduct.property("productUnit")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    supplierProduct.property("supplier")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4belong_to", "供应管理")
                      ;
                    
                    supplierProduct.property("supplier")
                        .with("parentType", "com.doublechaintech.retailscm.goodssupplier.GoodsSupplier");
                    

                    
                  
                    supplierProduct.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerProductSupplyDuration(){
        EntityMeta productSupplyDuration = MetaProvider.entity("com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDuration")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    productSupplyDuration.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    productSupplyDuration.property("quantity")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    

                    
                  
                    productSupplyDuration.property("duration")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    productSupplyDuration.property("price")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    productSupplyDuration.property("product")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    productSupplyDuration.property("product")
                        .with("parentType", "com.doublechaintech.retailscm.supplierproduct.SupplierProduct");
                    

                    
                  
                    productSupplyDuration.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerSupplyOrder(){
        EntityMeta supplyOrder = MetaProvider.entity("com.doublechaintech.retailscm.supplyorder.SupplyOrder")
                  
                        .with("vg4buyer", "供应管理")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    supplyOrder.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    supplyOrder.property("buyer")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    supplyOrder.property("buyer")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    supplyOrder.property("seller")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4belong_to", "供应管理")
                      ;
                    
                    supplyOrder.property("seller")
                        .with("parentType", "com.doublechaintech.retailscm.goodssupplier.GoodsSupplier");
                    

                    
                  
                    supplyOrder.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    supplyOrder.property("totalAmount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    supplyOrder.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    supplyOrder.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerSupplyOrderLineItem(){
        EntityMeta supplyOrderLineItem = MetaProvider.entity("com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItem")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    supplyOrderLineItem.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    supplyOrderLineItem.property("bizOrder")
                      
                        .with("vg4buyer", "供应管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    supplyOrderLineItem.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.supplyorder.SupplyOrder");
                    

                    
                  
                    supplyOrderLineItem.property("skuId")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    supplyOrderLineItem.property("skuName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    supplyOrderLineItem.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    supplyOrderLineItem.property("quantity")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    

                    
                  
                    supplyOrderLineItem.property("unitOfMeasurement")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    supplyOrderLineItem.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerSupplyOrderShippingGroup(){
        EntityMeta supplyOrderShippingGroup = MetaProvider.entity("com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    supplyOrderShippingGroup.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    supplyOrderShippingGroup.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    supplyOrderShippingGroup.property("bizOrder")
                      
                        .with("vg4buyer", "供应管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    supplyOrderShippingGroup.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.supplyorder.SupplyOrder");
                    

                    
                  
                    supplyOrderShippingGroup.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    supplyOrderShippingGroup.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerSupplyOrderPaymentGroup(){
        EntityMeta supplyOrderPaymentGroup = MetaProvider.entity("com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    supplyOrderPaymentGroup.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    supplyOrderPaymentGroup.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    supplyOrderPaymentGroup.property("bizOrder")
                      
                        .with("vg4buyer", "供应管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    supplyOrderPaymentGroup.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.supplyorder.SupplyOrder");
                    

                    
                  
                    supplyOrderPaymentGroup.property("cardNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    supplyOrderPaymentGroup.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerRetailStoreOrder(){
        EntityMeta retailStoreOrder = MetaProvider.entity("com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4seller", "销售管理")
                  ;
                  
                    retailStoreOrder.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    retailStoreOrder.property("buyer")
                      
                        .with("vg4retail_store_country_center", "加盟管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStoreOrder.property("buyer")
                        .with("parentType", "com.doublechaintech.retailscm.retailstore.RetailStore");
                    

                    
                  
                    retailStoreOrder.property("seller")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    retailStoreOrder.property("seller")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    retailStoreOrder.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreOrder.property("totalAmount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    retailStoreOrder.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    retailStoreOrder.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerRetailStoreOrderLineItem(){
        EntityMeta retailStoreOrderLineItem = MetaProvider.entity("com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    retailStoreOrderLineItem.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    retailStoreOrderLineItem.property("bizOrder")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4seller", "销售管理")
                      ;
                    
                    retailStoreOrderLineItem.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder");
                    

                    
                  
                    retailStoreOrderLineItem.property("skuId")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreOrderLineItem.property("skuName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreOrderLineItem.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    retailStoreOrderLineItem.property("quantity")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    

                    
                  
                    retailStoreOrderLineItem.property("unitOfMeasurement")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreOrderLineItem.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerRetailStoreOrderShippingGroup(){
        EntityMeta retailStoreOrderShippingGroup = MetaProvider.entity("com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    retailStoreOrderShippingGroup.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    retailStoreOrderShippingGroup.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreOrderShippingGroup.property("bizOrder")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4seller", "销售管理")
                      ;
                    
                    retailStoreOrderShippingGroup.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder");
                    

                    
                  
                    retailStoreOrderShippingGroup.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    retailStoreOrderShippingGroup.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerRetailStoreOrderPaymentGroup(){
        EntityMeta retailStoreOrderPaymentGroup = MetaProvider.entity("com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    retailStoreOrderPaymentGroup.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    retailStoreOrderPaymentGroup.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreOrderPaymentGroup.property("bizOrder")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4seller", "销售管理")
                      ;
                    
                    retailStoreOrderPaymentGroup.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder");
                    

                    
                  
                    retailStoreOrderPaymentGroup.property("cardNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    retailStoreOrderPaymentGroup.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerWarehouse(){
        EntityMeta warehouse = MetaProvider.entity("com.doublechaintech.retailscm.warehouse.Warehouse")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4owner", "仓配运一体化")
                  ;
                  
                    warehouse.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    warehouse.property("location")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    warehouse.property("contactNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    warehouse.property("totalArea")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    warehouse.property("owner")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    warehouse.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    warehouse.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    warehouse.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    warehouse.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    warehouse.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerStorageSpace(){
        EntityMeta storageSpace = MetaProvider.entity("com.doublechaintech.retailscm.storagespace.StorageSpace")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    storageSpace.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    storageSpace.property("location")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    storageSpace.property("contactNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    storageSpace.property("totalArea")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    storageSpace.property("warehouse")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "仓配运一体化")
                      ;
                    
                    storageSpace.property("warehouse")
                        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");
                    

                    
                  
                    storageSpace.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    storageSpace.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    storageSpace.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    storageSpace.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerSmartPallet(){
        EntityMeta smartPallet = MetaProvider.entity("com.doublechaintech.retailscm.smartpallet.SmartPallet")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    smartPallet.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    smartPallet.property("location")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    smartPallet.property("contactNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    smartPallet.property("totalArea")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    smartPallet.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    smartPallet.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    smartPallet.property("warehouse")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "仓配运一体化")
                      ;
                    
                    smartPallet.property("warehouse")
                        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");
                    

                    
                  
                    smartPallet.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    smartPallet.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerGoodsShelf(){
        EntityMeta goodsShelf = MetaProvider.entity("com.doublechaintech.retailscm.goodsshelf.GoodsShelf")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    goodsShelf.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    goodsShelf.property("location")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    goodsShelf.property("storageSpace")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goodsShelf.property("storageSpace")
                        .with("parentType", "com.doublechaintech.retailscm.storagespace.StorageSpace");
                    

                    
                  
                    goodsShelf.property("supplierSpace")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goodsShelf.property("supplierSpace")
                        .with("parentType", "com.doublechaintech.retailscm.supplierspace.SupplierSpace");
                    

                    
                  
                    goodsShelf.property("damageSpace")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goodsShelf.property("damageSpace")
                        .with("parentType", "com.doublechaintech.retailscm.damagespace.DamageSpace");
                    

                    
                  
                    goodsShelf.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    goodsShelf.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerGoodsShelfStockCount(){
        EntityMeta goodsShelfStockCount = MetaProvider.entity("com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    goodsShelfStockCount.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    goodsShelfStockCount.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    goodsShelfStockCount.property("countTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    goodsShelfStockCount.property("summary")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    goodsShelfStockCount.property("shelf")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goodsShelfStockCount.property("shelf")
                        .with("parentType", "com.doublechaintech.retailscm.goodsshelf.GoodsShelf");
                    

                    
                  
                    goodsShelfStockCount.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerStockCountIssueTrack(){
        EntityMeta stockCountIssueTrack = MetaProvider.entity("com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrack")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    stockCountIssueTrack.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    stockCountIssueTrack.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    stockCountIssueTrack.property("countTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    stockCountIssueTrack.property("summary")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    stockCountIssueTrack.property("stockCount")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    stockCountIssueTrack.property("stockCount")
                        .with("parentType", "com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount");
                    

                    
                  
                    stockCountIssueTrack.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerGoodsAllocation(){
        EntityMeta goodsAllocation = MetaProvider.entity("com.doublechaintech.retailscm.goodsallocation.GoodsAllocation")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    goodsAllocation.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    goodsAllocation.property("location")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    goodsAllocation.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    goodsAllocation.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    goodsAllocation.property("goodsShelf")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goodsAllocation.property("goodsShelf")
                        .with("parentType", "com.doublechaintech.retailscm.goodsshelf.GoodsShelf");
                    

                    
                  
                    goodsAllocation.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerGoods(){
        EntityMeta goods = MetaProvider.entity("com.doublechaintech.retailscm.goods.Goods")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    goods.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    goods.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    goods.property("rfid")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    goods.property("uom")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    goods.property("maxPackage")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    

                    
                  
                    goods.property("expireTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    goods.property("sku")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goods.property("sku")
                        .with("parentType", "com.doublechaintech.retailscm.sku.Sku");
                    

                    
                  
                    goods.property("receivingSpace")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goods.property("receivingSpace")
                        .with("parentType", "com.doublechaintech.retailscm.receivingspace.ReceivingSpace");
                    

                    
                  
                    goods.property("goodsAllocation")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goods.property("goodsAllocation")
                        .with("parentType", "com.doublechaintech.retailscm.goodsallocation.GoodsAllocation");
                    

                    
                  
                    goods.property("smartPallet")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goods.property("smartPallet")
                        .with("parentType", "com.doublechaintech.retailscm.smartpallet.SmartPallet");
                    

                    
                  
                    goods.property("shippingSpace")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goods.property("shippingSpace")
                        .with("parentType", "com.doublechaintech.retailscm.shippingspace.ShippingSpace");
                    

                    
                  
                    goods.property("transportTask")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goods.property("transportTask")
                        .with("parentType", "com.doublechaintech.retailscm.transporttask.TransportTask");
                    

                    
                  
                    goods.property("retailStore")
                      
                        .with("vg4retail_store_country_center", "加盟管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goods.property("retailStore")
                        .with("parentType", "com.doublechaintech.retailscm.retailstore.RetailStore");
                    

                    
                  
                    goods.property("bizOrder")
                      
                        .with("vg4buyer", "供应管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goods.property("bizOrder")
                        .with("parentType", "com.doublechaintech.retailscm.supplyorder.SupplyOrder");
                    

                    
                  
                    goods.property("retailStoreOrder")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4seller", "销售管理")
                      ;
                    
                    goods.property("retailStoreOrder")
                        .with("parentType", "com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder");
                    

                    
                  
                    goods.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerGoodsMovement(){
        EntityMeta goodsMovement = MetaProvider.entity("com.doublechaintech.retailscm.goodsmovement.GoodsMovement")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    goodsMovement.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    goodsMovement.property("moveTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date_time")
                      ;
                    

                    
                  
                    goodsMovement.property("facility")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    goodsMovement.property("facilityId")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    goodsMovement.property("fromIp")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    goodsMovement.property("userAgent")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    goodsMovement.property("sessionId")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    goodsMovement.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    goodsMovement.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    goodsMovement.property("goods")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    goodsMovement.property("goods")
                        .with("parentType", "com.doublechaintech.retailscm.goods.Goods");
                    

                    
                  
                    goodsMovement.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerSupplierSpace(){
        EntityMeta supplierSpace = MetaProvider.entity("com.doublechaintech.retailscm.supplierspace.SupplierSpace")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    supplierSpace.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    supplierSpace.property("location")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    supplierSpace.property("contactNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    supplierSpace.property("totalArea")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    supplierSpace.property("warehouse")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "仓配运一体化")
                      ;
                    
                    supplierSpace.property("warehouse")
                        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");
                    

                    
                  
                    supplierSpace.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    supplierSpace.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    supplierSpace.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    supplierSpace.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerReceivingSpace(){
        EntityMeta receivingSpace = MetaProvider.entity("com.doublechaintech.retailscm.receivingspace.ReceivingSpace")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    receivingSpace.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    receivingSpace.property("location")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    receivingSpace.property("contactNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    receivingSpace.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    receivingSpace.property("totalArea")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    receivingSpace.property("warehouse")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "仓配运一体化")
                      ;
                    
                    receivingSpace.property("warehouse")
                        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");
                    

                    
                  
                    receivingSpace.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    receivingSpace.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    receivingSpace.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    receivingSpace.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerShippingSpace(){
        EntityMeta shippingSpace = MetaProvider.entity("com.doublechaintech.retailscm.shippingspace.ShippingSpace")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    shippingSpace.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    shippingSpace.property("location")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    shippingSpace.property("contactNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    shippingSpace.property("totalArea")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    shippingSpace.property("warehouse")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "仓配运一体化")
                      ;
                    
                    shippingSpace.property("warehouse")
                        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");
                    

                    
                  
                    shippingSpace.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    shippingSpace.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    shippingSpace.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    shippingSpace.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    shippingSpace.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerDamageSpace(){
        EntityMeta damageSpace = MetaProvider.entity("com.doublechaintech.retailscm.damagespace.DamageSpace")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    damageSpace.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    damageSpace.property("location")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    damageSpace.property("contactNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    damageSpace.property("totalArea")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    damageSpace.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    damageSpace.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    damageSpace.property("warehouse")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "仓配运一体化")
                      ;
                    
                    damageSpace.property("warehouse")
                        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");
                    

                    
                  
                    damageSpace.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    damageSpace.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerWarehouseAsset(){
        EntityMeta warehouseAsset = MetaProvider.entity("com.doublechaintech.retailscm.warehouseasset.WarehouseAsset")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    warehouseAsset.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    warehouseAsset.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    warehouseAsset.property("position")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    warehouseAsset.property("owner")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "仓配运一体化")
                      ;
                    
                    warehouseAsset.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.warehouse.Warehouse");
                    

                    
                  
                    warehouseAsset.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    warehouseAsset.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerTransportFleet(){
        EntityMeta transportFleet = MetaProvider.entity("com.doublechaintech.retailscm.transportfleet.TransportFleet")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4owner", "仓配运一体化")
                  ;
                  
                    transportFleet.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    transportFleet.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    transportFleet.property("contactNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    transportFleet.property("owner")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    transportFleet.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    transportFleet.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    transportFleet.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerTransportTruck(){
        EntityMeta transportTruck = MetaProvider.entity("com.doublechaintech.retailscm.transporttruck.TransportTruck")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    transportTruck.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    transportTruck.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    transportTruck.property("plateNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    transportTruck.property("contactNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    transportTruck.property("vehicleLicenseNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    transportTruck.property("engineNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    transportTruck.property("makeDate")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    transportTruck.property("mileage")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    transportTruck.property("bodyColor")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    transportTruck.property("owner")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "仓配运一体化")
                      ;
                    
                    transportTruck.property("owner")
                        .with("parentType", "com.doublechaintech.retailscm.transportfleet.TransportFleet");
                    

                    
                  
                    transportTruck.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerTruckDriver(){
        EntityMeta truckDriver = MetaProvider.entity("com.doublechaintech.retailscm.truckdriver.TruckDriver")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    truckDriver.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    truckDriver.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    truckDriver.property("driverLicenseNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    truckDriver.property("contactNumber")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    

                    
                  
                    truckDriver.property("belongsTo")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "仓配运一体化")
                      ;
                    
                    truckDriver.property("belongsTo")
                        .with("parentType", "com.doublechaintech.retailscm.transportfleet.TransportFleet");
                    

                    
                  
                    truckDriver.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerTransportTask(){
        EntityMeta transportTask = MetaProvider.entity("com.doublechaintech.retailscm.transporttask.TransportTask")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    transportTask.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    transportTask.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    transportTask.property("start")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    transportTask.property("beginTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    transportTask.property("end")
                      
                        .with("vg4retail_store_country_center", "加盟管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    transportTask.property("end")
                        .with("parentType", "com.doublechaintech.retailscm.retailstore.RetailStore");
                    

                    
                  
                    transportTask.property("driver")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    transportTask.property("driver")
                        .with("parentType", "com.doublechaintech.retailscm.truckdriver.TruckDriver");
                    

                    
                  
                    transportTask.property("truck")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    transportTask.property("truck")
                        .with("parentType", "com.doublechaintech.retailscm.transporttruck.TransportTruck");
                    

                    
                  
                    transportTask.property("belongsTo")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4owner", "仓配运一体化")
                      ;
                    
                    transportTask.property("belongsTo")
                        .with("parentType", "com.doublechaintech.retailscm.transportfleet.TransportFleet");
                    

                    
                  
                    transportTask.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    transportTask.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    transportTask.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerTransportTaskTrack(){
        EntityMeta transportTaskTrack = MetaProvider.entity("com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrack")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    transportTaskTrack.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    transportTaskTrack.property("trackTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    transportTaskTrack.property("latitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    transportTaskTrack.property("longitude")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,double")
                      ;
                    

                    
                  
                    transportTaskTrack.property("movement")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    transportTaskTrack.property("movement")
                        .with("parentType", "com.doublechaintech.retailscm.transporttask.TransportTask");
                    

                    
                  
                    transportTaskTrack.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerAccountSet(){
        EntityMeta accountSet = MetaProvider.entity("com.doublechaintech.retailscm.accountset.AccountSet")
                  
                        .with("vg4country_center", "财务管理")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    accountSet.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    accountSet.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    accountSet.property("yearSet")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    accountSet.property("effectiveDate")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    accountSet.property("accountingSystem")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    accountSet.property("domesticCurrencyCode")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    accountSet.property("domesticCurrencyName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    accountSet.property("openingBank")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    accountSet.property("accountNumber")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    accountSet.property("countryCenter")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    accountSet.property("countryCenter")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    accountSet.property("retailStore")
                      
                        .with("vg4retail_store_country_center", "加盟管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    accountSet.property("retailStore")
                        .with("parentType", "com.doublechaintech.retailscm.retailstore.RetailStore");
                    

                    
                  
                    accountSet.property("goodsSupplier")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4belong_to", "供应管理")
                      ;
                    
                    accountSet.property("goodsSupplier")
                        .with("parentType", "com.doublechaintech.retailscm.goodssupplier.GoodsSupplier");
                    

                    
                  
                    accountSet.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    accountSet.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerAccountingSubject(){
        EntityMeta accountingSubject = MetaProvider.entity("com.doublechaintech.retailscm.accountingsubject.AccountingSubject")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    accountingSubject.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    accountingSubject.property("accountingSubjectCode")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    accountingSubject.property("accountingSubjectName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    accountingSubject.property("accountingSubjectClassCode")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    

                    
                  
                    accountingSubject.property("accountingSubjectClassName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    accountingSubject.property("accountSet")
                      
                        .with("vg4country_center", "财务管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    accountingSubject.property("accountSet")
                        .with("parentType", "com.doublechaintech.retailscm.accountset.AccountSet");
                    

                    
                  
                    accountingSubject.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerAccountingPeriod(){
        EntityMeta accountingPeriod = MetaProvider.entity("com.doublechaintech.retailscm.accountingperiod.AccountingPeriod")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    accountingPeriod.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    accountingPeriod.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    accountingPeriod.property("startDate")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    accountingPeriod.property("endDate")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    accountingPeriod.property("accountSet")
                      
                        .with("vg4country_center", "财务管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    accountingPeriod.property("accountSet")
                        .with("parentType", "com.doublechaintech.retailscm.accountset.AccountSet");
                    

                    
                  
                    accountingPeriod.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerAccountingDocumentType(){
        EntityMeta accountingDocumentType = MetaProvider.entity("com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    accountingDocumentType.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    accountingDocumentType.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    accountingDocumentType.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    accountingDocumentType.property("accountingPeriod")
                      
                        .with("vg4country_center", "财务管理")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    accountingDocumentType.property("accountingPeriod")
                        .with("parentType", "com.doublechaintech.retailscm.accountset.AccountSet");
                    

                    
                  
                    accountingDocumentType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerAccountingDocument(){
        EntityMeta accountingDocument = MetaProvider.entity("com.doublechaintech.retailscm.accountingdocument.AccountingDocument")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    accountingDocument.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    accountingDocument.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    accountingDocument.property("accountingDocumentDate")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    accountingDocument.property("accountingPeriod")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    accountingDocument.property("accountingPeriod")
                        .with("parentType", "com.doublechaintech.retailscm.accountingperiod.AccountingPeriod");
                    

                    
                  
                    accountingDocument.property("documentType")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    accountingDocument.property("documentType")
                        .with("parentType", "com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType");
                    

                    
                  
                    accountingDocument.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerOriginalVoucher(){
        EntityMeta originalVoucher = MetaProvider.entity("com.doublechaintech.retailscm.originalvoucher.OriginalVoucher")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    originalVoucher.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    originalVoucher.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    originalVoucher.property("madeBy")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    originalVoucher.property("receivedBy")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    originalVoucher.property("voucherType")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    originalVoucher.property("voucherImage")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      ;
                    

                    
                  
                    originalVoucher.property("belongsTo")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    originalVoucher.property("belongsTo")
                        .with("parentType", "com.doublechaintech.retailscm.accountingdocument.AccountingDocument");
                    

                    
                  
                    originalVoucher.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerAccountingDocumentLine(){
        EntityMeta accountingDocumentLine = MetaProvider.entity("com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    accountingDocumentLine.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    accountingDocumentLine.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    accountingDocumentLine.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    accountingDocumentLine.property("direct")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    accountingDocumentLine.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    accountingDocumentLine.property("belongsTo")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    accountingDocumentLine.property("belongsTo")
                        .with("parentType", "com.doublechaintech.retailscm.accountingdocument.AccountingDocument");
                    

                    
                  
                    accountingDocumentLine.property("accountingSubject")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    accountingDocumentLine.property("accountingSubject")
                        .with("parentType", "com.doublechaintech.retailscm.accountingsubject.AccountingSubject");
                    

                    
                  
                    accountingDocumentLine.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerLevelOneDepartment(){
        EntityMeta levelOneDepartment = MetaProvider.entity("com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4belongs_to", "组织机构")
                  ;
                  
                    levelOneDepartment.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    levelOneDepartment.property("belongsTo")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    levelOneDepartment.property("belongsTo")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    levelOneDepartment.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    levelOneDepartment.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    levelOneDepartment.property("manager")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    levelOneDepartment.property("founded")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    levelOneDepartment.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerLevelTwoDepartment(){
        EntityMeta levelTwoDepartment = MetaProvider.entity("com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    levelTwoDepartment.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    levelTwoDepartment.property("belongsTo")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4belongs_to", "组织机构")
                      ;
                    
                    levelTwoDepartment.property("belongsTo")
                        .with("parentType", "com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment");
                    

                    
                  
                    levelTwoDepartment.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    levelTwoDepartment.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    levelTwoDepartment.property("founded")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    levelTwoDepartment.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerLevelThreeDepartment(){
        EntityMeta levelThreeDepartment = MetaProvider.entity("com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    levelThreeDepartment.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    levelThreeDepartment.property("belongsTo")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    levelThreeDepartment.property("belongsTo")
                        .with("parentType", "com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment");
                    

                    
                  
                    levelThreeDepartment.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    levelThreeDepartment.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    levelThreeDepartment.property("founded")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    levelThreeDepartment.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerSkillType(){
        EntityMeta skillType = MetaProvider.entity("com.doublechaintech.retailscm.skilltype.SkillType")
                  
                        .with("features", "setting")
                  
                        .with("vg4company", "人力资源")
                  ;
                  
                    skillType.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    skillType.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    skillType.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    skillType.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    skillType.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    skillType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerResponsibilityType(){
        EntityMeta responsibilityType = MetaProvider.entity("com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType")
                  
                        .with("features", "setting")
                  
                        .with("vg4company", "人力资源")
                  ;
                  
                    responsibilityType.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    responsibilityType.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    responsibilityType.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    responsibilityType.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    responsibilityType.property("baseDescription")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    responsibilityType.property("detailDescription")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    responsibilityType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerTerminationReason(){
        EntityMeta terminationReason = MetaProvider.entity("com.doublechaintech.retailscm.terminationreason.TerminationReason")
                  
                        .with("features", "setting")
                  
                        .with("vg4company", "人力资源")
                  ;
                  
                    terminationReason.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    terminationReason.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    terminationReason.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    terminationReason.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    terminationReason.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    terminationReason.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerTerminationType(){
        EntityMeta terminationType = MetaProvider.entity("com.doublechaintech.retailscm.terminationtype.TerminationType")
                  
                        .with("features", "setting")
                  
                        .with("vg4company", "人力资源")
                  ;
                  
                    terminationType.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    terminationType.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    terminationType.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    terminationType.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    terminationType.property("baseDescription")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    terminationType.property("detailDescription")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    terminationType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerOccupationType(){
        EntityMeta occupationType = MetaProvider.entity("com.doublechaintech.retailscm.occupationtype.OccupationType")
                  
                        .with("features", "setting")
                  
                        .with("vg4company", "人力资源")
                  ;
                  
                    occupationType.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    occupationType.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    occupationType.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    occupationType.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    occupationType.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    occupationType.property("detailDescription")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    occupationType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerLeaveType(){
        EntityMeta leaveType = MetaProvider.entity("com.doublechaintech.retailscm.leavetype.LeaveType")
                  
                        .with("features", "setting")
                  
                        .with("vg4company", "人力资源")
                  ;
                  
                    leaveType.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    leaveType.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    leaveType.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    leaveType.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    leaveType.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    leaveType.property("detailDescription")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    leaveType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerSalaryGrade(){
        EntityMeta salaryGrade = MetaProvider.entity("com.doublechaintech.retailscm.salarygrade.SalaryGrade")
                  
                        .with("features", "setting")
                  
                        .with("vg4company", "人力资源")
                  ;
                  
                    salaryGrade.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    salaryGrade.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    salaryGrade.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    salaryGrade.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    salaryGrade.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    salaryGrade.property("detailDescription")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    salaryGrade.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerInterviewType(){
        EntityMeta interviewType = MetaProvider.entity("com.doublechaintech.retailscm.interviewtype.InterviewType")
                  
                        .with("features", "setting")
                  
                        .with("vg4company", "人力资源")
                  ;
                  
                    interviewType.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    interviewType.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    interviewType.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    interviewType.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    interviewType.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    interviewType.property("detailDescription")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    interviewType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerTrainingCourseType(){
        EntityMeta trainingCourseType = MetaProvider.entity("com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType")
                  
                        .with("features", "setting")
                  
                        .with("vg4company", "人力资源")
                  ;
                  
                    trainingCourseType.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    trainingCourseType.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    trainingCourseType.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    trainingCourseType.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    trainingCourseType.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    trainingCourseType.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    trainingCourseType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerPublicHoliday(){
        EntityMeta publicHoliday = MetaProvider.entity("com.doublechaintech.retailscm.publicholiday.PublicHoliday")
                  
                        .with("features", "setting")
                  
                        .with("vg4company", "人力资源")
                  ;
                  
                    publicHoliday.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    publicHoliday.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    publicHoliday.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    publicHoliday.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    publicHoliday.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    publicHoliday.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    publicHoliday.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerTermination(){
        EntityMeta termination = MetaProvider.entity("com.doublechaintech.retailscm.termination.Termination")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    termination.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    termination.property("reason")
                      
                        .with("features", "setting")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    termination.property("reason")
                        .with("parentType", "com.doublechaintech.retailscm.terminationreason.TerminationReason");
                    

                    
                  
                    termination.property("type")
                      
                        .with("features", "setting")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    termination.property("type")
                        .with("parentType", "com.doublechaintech.retailscm.terminationtype.TerminationType");
                    

                    
                  
                    termination.property("comment")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    termination.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerView(){
        EntityMeta view = MetaProvider.entity("com.doublechaintech.retailscm.view.View")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    view.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    view.property("who")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    view.property("assessment")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    view.property("interviewTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    view.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerEmployee(){
        EntityMeta employee = MetaProvider.entity("com.doublechaintech.retailscm.employee.Employee")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4company", "人力资源")
                  ;
                  
                    employee.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    employee.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    employee.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    employee.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    employee.property("department")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    employee.property("department")
                        .with("parentType", "com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment");
                    

                    
                  
                    employee.property("familyName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    employee.property("givenName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    employee.property("email")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,email")
                      ;
                    

                    
                  
                    employee.property("city")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    employee.property("address")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    employee.property("cellPhone")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    

                    
                  
                    employee.property("occupation")
                      
                        .with("features", "setting")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employee.property("occupation")
                        .with("parentType", "com.doublechaintech.retailscm.occupationtype.OccupationType");
                    

                    
                  
                    employee.property("responsibleFor")
                      
                        .with("features", "setting")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employee.property("responsibleFor")
                        .with("parentType", "com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType");
                    

                    
                  
                    employee.property("currentSalaryGrade")
                      
                        .with("features", "setting")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employee.property("currentSalaryGrade")
                        .with("parentType", "com.doublechaintech.retailscm.salarygrade.SalaryGrade");
                    

                    
                  
                    employee.property("salaryAccount")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    employee.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    employee.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerInstructor(){
        EntityMeta instructor = MetaProvider.entity("com.doublechaintech.retailscm.instructor.Instructor")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4company", "人力资源")
                  ;
                  
                    instructor.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    instructor.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    instructor.property("familyName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    instructor.property("givenName")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    instructor.property("cellPhone")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      ;
                    

                    
                  
                    instructor.property("email")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,email")
                      ;
                    

                    
                  
                    instructor.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    instructor.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    instructor.property("introduction")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    instructor.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    instructor.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerCompanyTraining(){
        EntityMeta companyTraining = MetaProvider.entity("com.doublechaintech.retailscm.companytraining.CompanyTraining")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4company", "人力资源")
                  ;
                  
                    companyTraining.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    companyTraining.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    companyTraining.property("company")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    companyTraining.property("company")
                        .with("parentType", "com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter");
                    

                    
                  
                    companyTraining.property("instructor")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    companyTraining.property("instructor")
                        .with("parentType", "com.doublechaintech.retailscm.instructor.Instructor");
                    

                    
                  
                    companyTraining.property("trainingCourseType")
                      
                        .with("features", "setting")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    companyTraining.property("trainingCourseType")
                        .with("parentType", "com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType");
                    

                    
                  
                    companyTraining.property("timeStart")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    companyTraining.property("durationHours")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    

                    
                  
                    companyTraining.property("lastUpdateTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    companyTraining.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerScoring(){
        EntityMeta scoring = MetaProvider.entity("com.doublechaintech.retailscm.scoring.Scoring")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    scoring.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    scoring.property("scoredBy")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    scoring.property("score")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    

                    
                  
                    scoring.property("comment")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    scoring.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerEmployeeCompanyTraining(){
        EntityMeta employeeCompanyTraining = MetaProvider.entity("com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    employeeCompanyTraining.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    employeeCompanyTraining.property("employee")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeCompanyTraining.property("employee")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    

                    
                  
                    employeeCompanyTraining.property("training")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeCompanyTraining.property("training")
                        .with("parentType", "com.doublechaintech.retailscm.companytraining.CompanyTraining");
                    

                    
                  
                    employeeCompanyTraining.property("scoring")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    employeeCompanyTraining.property("scoring")
                        .with("parentType", "com.doublechaintech.retailscm.scoring.Scoring");
                    

                    
                  
                    employeeCompanyTraining.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerEmployeeSkill(){
        EntityMeta employeeSkill = MetaProvider.entity("com.doublechaintech.retailscm.employeeskill.EmployeeSkill")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    employeeSkill.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    employeeSkill.property("employee")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeSkill.property("employee")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    

                    
                  
                    employeeSkill.property("skillType")
                      
                        .with("features", "setting")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeSkill.property("skillType")
                        .with("parentType", "com.doublechaintech.retailscm.skilltype.SkillType");
                    

                    
                  
                    employeeSkill.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    employeeSkill.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerEmployeePerformance(){
        EntityMeta employeePerformance = MetaProvider.entity("com.doublechaintech.retailscm.employeeperformance.EmployeePerformance")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    employeePerformance.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    employeePerformance.property("employee")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeePerformance.property("employee")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    

                    
                  
                    employeePerformance.property("performanceComment")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    employeePerformance.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerEmployeeWorkExperience(){
        EntityMeta employeeWorkExperience = MetaProvider.entity("com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperience")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    employeeWorkExperience.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    employeeWorkExperience.property("employee")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeWorkExperience.property("employee")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    

                    
                  
                    employeeWorkExperience.property("start")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    employeeWorkExperience.property("end")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    employeeWorkExperience.property("company")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    employeeWorkExperience.property("description")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    employeeWorkExperience.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerEmployeeLeave(){
        EntityMeta employeeLeave = MetaProvider.entity("com.doublechaintech.retailscm.employeeleave.EmployeeLeave")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    employeeLeave.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    employeeLeave.property("who")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeLeave.property("who")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    

                    
                  
                    employeeLeave.property("type")
                      
                        .with("features", "setting")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeLeave.property("type")
                        .with("parentType", "com.doublechaintech.retailscm.leavetype.LeaveType");
                    

                    
                  
                    employeeLeave.property("leaveDurationHour")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    

                    
                  
                    employeeLeave.property("remark")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    employeeLeave.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerEmployeeInterview(){
        EntityMeta employeeInterview = MetaProvider.entity("com.doublechaintech.retailscm.employeeinterview.EmployeeInterview")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    employeeInterview.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    employeeInterview.property("employee")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeInterview.property("employee")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    

                    
                  
                    employeeInterview.property("interviewType")
                      
                        .with("features", "setting")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeInterview.property("interviewType")
                        .with("parentType", "com.doublechaintech.retailscm.interviewtype.InterviewType");
                    

                    
                  
                    employeeInterview.property("remark")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    employeeInterview.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerEmployeeAttendance(){
        EntityMeta employeeAttendance = MetaProvider.entity("com.doublechaintech.retailscm.employeeattendance.EmployeeAttendance")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    employeeAttendance.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    employeeAttendance.property("employee")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeAttendance.property("employee")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    

                    
                  
                    employeeAttendance.property("enterTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    employeeAttendance.property("leaveTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    employeeAttendance.property("durationHours")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    

                    
                  
                    employeeAttendance.property("remark")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    employeeAttendance.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerEmployeeQualifier(){
        EntityMeta employeeQualifier = MetaProvider.entity("com.doublechaintech.retailscm.employeequalifier.EmployeeQualifier")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    employeeQualifier.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    employeeQualifier.property("employee")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeQualifier.property("employee")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    

                    
                  
                    employeeQualifier.property("qualifiedTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    employeeQualifier.property("type")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    employeeQualifier.property("level")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    employeeQualifier.property("remark")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    employeeQualifier.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerEmployeeEducation(){
        EntityMeta employeeEducation = MetaProvider.entity("com.doublechaintech.retailscm.employeeeducation.EmployeeEducation")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    employeeEducation.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    employeeEducation.property("employee")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeEducation.property("employee")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    

                    
                  
                    employeeEducation.property("completeTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    employeeEducation.property("type")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    employeeEducation.property("remark")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    employeeEducation.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerEmployeeAward(){
        EntityMeta employeeAward = MetaProvider.entity("com.doublechaintech.retailscm.employeeaward.EmployeeAward")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    employeeAward.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    employeeAward.property("employee")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeAward.property("employee")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    

                    
                  
                    employeeAward.property("completeTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    employeeAward.property("type")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    employeeAward.property("remark")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    employeeAward.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerEmployeeSalarySheet(){
        EntityMeta employeeSalarySheet = MetaProvider.entity("com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    employeeSalarySheet.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    employeeSalarySheet.property("employee")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeSalarySheet.property("employee")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    

                    
                  
                    employeeSalarySheet.property("currentSalaryGrade")
                      
                        .with("features", "setting")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    employeeSalarySheet.property("currentSalaryGrade")
                        .with("parentType", "com.doublechaintech.retailscm.salarygrade.SalaryGrade");
                    

                    
                  
                    employeeSalarySheet.property("baseSalary")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    employeeSalarySheet.property("bonus")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    employeeSalarySheet.property("reward")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    employeeSalarySheet.property("personalTax")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    employeeSalarySheet.property("socialSecurity")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    employeeSalarySheet.property("housingFound")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    employeeSalarySheet.property("jobInsurance")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    employeeSalarySheet.property("payingOff")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    employeeSalarySheet.property("payingOff")
                        .with("parentType", "com.doublechaintech.retailscm.payingoff.PayingOff");
                    

                    
                  
                    employeeSalarySheet.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerPayingOff(){
        EntityMeta payingOff = MetaProvider.entity("com.doublechaintech.retailscm.payingoff.PayingOff")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    payingOff.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    payingOff.property("who")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    payingOff.property("paidFor")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4company", "人力资源")
                      ;
                    
                    payingOff.property("paidFor")
                        .with("parentType", "com.doublechaintech.retailscm.employee.Employee");
                    

                    
                  
                    payingOff.property("paidTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date")
                      ;
                    

                    
                  
                    payingOff.property("amount")
                      
                        .with("java_type", "java.math.BigDecimal")
                      
                        .with("features", "root,visible_all,money")
                      ;
                    

                    
                  
                    payingOff.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerMobileApp(){
        EntityMeta mobileApp = MetaProvider.entity("com.doublechaintech.retailscm.mobileapp.MobileApp")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    mobileApp.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    mobileApp.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    mobileApp.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerPage(){
        EntityMeta page = MetaProvider.entity("com.doublechaintech.retailscm.page.Page")
                  
                        .with("features", "root,visible_all")
                  
                        .with("vg4mobile_app", "页面管理")
                  ;
                  
                    page.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    page.property("pageTitle")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    page.property("linkToUrl")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    page.property("pageType")
                      
                        .with("identified_by", "code")
                      
                        .with("features", "status")
                      ;
                    
                    page.property("pageType")
                        .with("parentType", "com.doublechaintech.retailscm.pagetype.PageType");
                    

                    
                  
                    page.property("displayOrder")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    

                    
                  
                    page.property("mobileApp")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    page.property("mobileApp")
                        .with("parentType", "com.doublechaintech.retailscm.mobileapp.MobileApp");
                    

                    
                  
                    page.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerPageType(){
        EntityMeta pageType = MetaProvider.entity("com.doublechaintech.retailscm.pagetype.PageType")
                  
                        .with("identified_by", "code")
                  
                        .with("features", "status")
                  ;
                  
                    pageType.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    pageType.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    pageType.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    pageType.property("mobileApp")
                      
                        .with("features", "root,visible_all")
                      ;
                    
                    pageType.property("mobileApp")
                        .with("parentType", "com.doublechaintech.retailscm.mobileapp.MobileApp");
                    

                    
                  
                    pageType.property("footerTab")
                      
                        .with("features", "root,visible_all,bool")
                      ;
                    

                    
                  
                    pageType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerSlide(){
        EntityMeta slide = MetaProvider.entity("com.doublechaintech.retailscm.slide.Slide")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    slide.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    slide.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    slide.property("displayOrder")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    

                    
                  
                    slide.property("imageUrl")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      ;
                    

                    
                  
                    slide.property("videoUrl")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      ;
                    

                    
                  
                    slide.property("linkToUrl")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    slide.property("page")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4mobile_app", "页面管理")
                      ;
                    
                    slide.property("page")
                        .with("parentType", "com.doublechaintech.retailscm.page.Page");
                    

                    
                  
                    slide.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerUiAction(){
        EntityMeta uiAction = MetaProvider.entity("com.doublechaintech.retailscm.uiaction.UiAction")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    uiAction.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    uiAction.property("code")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    uiAction.property("icon")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    uiAction.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    uiAction.property("displayOrder")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    

                    
                  
                    uiAction.property("brief")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    uiAction.property("imageUrl")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      ;
                    

                    
                  
                    uiAction.property("linkToUrl")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    uiAction.property("extraData")
                      
                        .with("parent", "string_longtext")
                      
                        .with("type", "string_longtext")
                      
                        .with("features", "root,visible_all,string,longtext")
                      ;
                    

                    
                  
                    uiAction.property("page")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4mobile_app", "页面管理")
                      ;
                    
                    uiAction.property("page")
                        .with("parentType", "com.doublechaintech.retailscm.page.Page");
                    

                    
                  
                    uiAction.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerSection(){
        EntityMeta section = MetaProvider.entity("com.doublechaintech.retailscm.section.Section")
                  
                        .with("features", "root,visible_all")
                  ;
                  
                    section.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    section.property("title")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    section.property("brief")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    section.property("icon")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      ;
                    

                    
                  
                    section.property("displayOrder")
                      
                        .with("features", "root,visible_all,int")
                      ;
                    

                    
                  
                    section.property("viewGroup")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    section.property("linkToUrl")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    section.property("page")
                      
                        .with("features", "root,visible_all")
                      
                        .with("vg4mobile_app", "页面管理")
                      ;
                    
                    section.property("page")
                        .with("parentType", "com.doublechaintech.retailscm.page.Page");
                    

                    
                  
                    section.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerUserDomain(){
        EntityMeta userDomain = MetaProvider.entity("com.doublechaintech.retailscm.userdomain.UserDomain")
                  
                        .with("features", "ootb,no_sample_data,iam")
                  
                        .with("zh_CN", "用户域")
                  ;
                  
                    userDomain.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    userDomain.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    userDomain.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerUserAllowList(){
        EntityMeta userAllowList = MetaProvider.entity("com.doublechaintech.retailscm.userallowlist.UserAllowList")
                  
                        .with("features", "syssetting")
                  
                        .with("zh_CN", "用户权限列表")
                  ;
                  
                    userAllowList.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    userAllowList.property("userIdentity")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      
                        .with("zh_CN", "用户标识")
                      ;
                    

                    
                  
                    userAllowList.property("userSpecialFunctions")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "用户特权")
                      ;
                    

                    
                  
                    userAllowList.property("domain")
                      
                        .with("features", "ootb,no_sample_data,iam")
                      
                        .with("zh_CN", "域")
                      ;
                    
                    userAllowList.property("domain")
                        .with("parentType", "com.doublechaintech.retailscm.userdomain.UserDomain");
                    

                    
                  
                    userAllowList.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerSecUser(){
        EntityMeta secUser = MetaProvider.entity("com.doublechaintech.retailscm.secuser.SecUser")
                  
                        .with("identified_by", "login,email,mobile")
                  
                        .with("features", "ootb")
                  
                        .with("zh_CN", "安全用户")
                  ;
                  
                    secUser.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    secUser.property("login")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "登录名")
                      ;
                    

                    
                  
                    secUser.property("mobile")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,mobile")
                      
                        .with("zh_CN", "手机")
                      ;
                    

                    
                  
                    secUser.property("email")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,email")
                      
                        .with("zh_CN", "邮箱")
                      ;
                    

                    
                  
                    secUser.property("pwd")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,password")
                      
                        .with("zh_CN", "密码")
                      ;
                    

                    
                  
                    secUser.property("weixinOpenid")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "微信openId")
                      ;
                    

                    
                  
                    secUser.property("weixinAppid")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "微信应用ID")
                      ;
                    

                    
                  
                    secUser.property("accessToken")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "访问令牌")
                      ;
                    

                    
                  
                    secUser.property("verificationCode")
                      
                        .with("features", "root,visible_all,int")
                      
                        .with("zh_CN", "验证码")
                      ;
                    

                    
                  
                    secUser.property("verificationCodeExpire")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("zh_CN", "验证码有效期")
                      ;
                    

                    
                  
                    secUser.property("lastLoginTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("zh_CN", "最后登录时间")
                      ;
                    

                    
                  
                    secUser.property("domain")
                      
                        .with("features", "ootb,no_sample_data,iam")
                      
                        .with("zh_CN", "域")
                      ;
                    
                    secUser.property("domain")
                        .with("parentType", "com.doublechaintech.retailscm.userdomain.UserDomain");
                    

                    
                  
                    secUser.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerUserApp(){
        EntityMeta userApp = MetaProvider.entity("com.doublechaintech.retailscm.userapp.UserApp")
                  
                        .with("features", "ootb")
                  
                        .with("zh_CN", "应用")
                  ;
                  
                    userApp.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    userApp.property("title")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "标题")
                      ;
                    

                    
                  
                    userApp.property("secUser")
                      
                        .with("identified_by", "login,email,mobile")
                      
                        .with("features", "ootb")
                      
                        .with("zh_CN", "系统用户")
                      ;
                    
                    userApp.property("secUser")
                        .with("parentType", "com.doublechaintech.retailscm.secuser.SecUser");
                    

                    
                  
                    userApp.property("appIcon")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "图标")
                      ;
                    

                    
                  
                    userApp.property("fullAccess")
                      
                        .with("features", "root,visible_all,bool")
                      
                        .with("zh_CN", "完全访问")
                      ;
                    

                    
                  
                    userApp.property("permission")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "权限")
                      ;
                    

                    
                  
                    userApp.property("appType")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "对象类型")
                      ;
                    

                    
                  
                    userApp.property("appId")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "对象ID")
                      ;
                    

                    
                  
                    userApp.property("ctxType")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "上下文类型")
                      ;
                    

                    
                  
                    userApp.property("ctxId")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "上下文类型")
                      ;
                    

                    
                  
                    userApp.property("location")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "位置")
                      ;
                    

                    
                  
                    userApp.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerQuickLink(){
        EntityMeta quickLink = MetaProvider.entity("com.doublechaintech.retailscm.quicklink.QuickLink")
                  
                        .with("features", "ootb")
                  ;
                  
                    quickLink.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    quickLink.property("name")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    quickLink.property("icon")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    quickLink.property("imagePath")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      ;
                    

                    
                  
                    quickLink.property("linkTarget")
                      
                        .with("features", "root,visible_all,string")
                      ;
                    

                    
                  
                    quickLink.property("createTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      ;
                    

                    
                  
                    quickLink.property("app")
                      
                        .with("features", "ootb")
                      
                        .with("zh_CN", "应用")
                      ;
                    
                    quickLink.property("app")
                        .with("parentType", "com.doublechaintech.retailscm.userapp.UserApp");
                    

                    
                  
                    quickLink.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerListAccess(){
        EntityMeta listAccess = MetaProvider.entity("com.doublechaintech.retailscm.listaccess.ListAccess")
                  
                        .with("features", "ootb")
                  
                        .with("zh_CN", "列表访问控制")
                  ;
                  
                    listAccess.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    listAccess.property("name")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "名称")
                      ;
                    

                    
                  
                    listAccess.property("internalName")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "内部名称")
                      ;
                    

                    
                  
                    listAccess.property("readPermission")
                      
                        .with("features", "root,visible_all,bool")
                      
                        .with("zh_CN", "可读")
                      ;
                    

                    
                  
                    listAccess.property("createPermission")
                      
                        .with("features", "root,visible_all,bool")
                      
                        .with("zh_CN", "可创建")
                      ;
                    

                    
                  
                    listAccess.property("deletePermission")
                      
                        .with("features", "root,visible_all,bool")
                      
                        .with("zh_CN", "可删除")
                      ;
                    

                    
                  
                    listAccess.property("updatePermission")
                      
                        .with("features", "root,visible_all,bool")
                      
                        .with("zh_CN", "可更新")
                      ;
                    

                    
                  
                    listAccess.property("executionPermission")
                      
                        .with("features", "root,visible_all,bool")
                      
                        .with("zh_CN", "可执行")
                      ;
                    

                    
                  
                    listAccess.property("app")
                      
                        .with("features", "ootb")
                      
                        .with("zh_CN", "应用")
                      ;
                    
                    listAccess.property("app")
                        .with("parentType", "com.doublechaintech.retailscm.userapp.UserApp");
                    

                    
                  
                    listAccess.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerLoginHistory(){
        EntityMeta loginHistory = MetaProvider.entity("com.doublechaintech.retailscm.loginhistory.LoginHistory")
                  
                        .with("features", "syslog")
                  
                        .with("zh_CN", "登录历史")
                  ;
                  
                    loginHistory.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    loginHistory.property("loginTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      
                        .with("zh_CN", "登录时间")
                      ;
                    

                    
                  
                    loginHistory.property("fromIp")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "来自IP")
                      ;
                    

                    
                  
                    loginHistory.property("description")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "描述")
                      ;
                    

                    
                  
                    loginHistory.property("secUser")
                      
                        .with("identified_by", "login,email,mobile")
                      
                        .with("features", "ootb")
                      
                        .with("zh_CN", "系统用户")
                      ;
                    
                    loginHistory.property("secUser")
                        .with("parentType", "com.doublechaintech.retailscm.secuser.SecUser");
                    

                    
                  
                    loginHistory.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerCandidateContainer(){
        EntityMeta candidateContainer = MetaProvider.entity("com.doublechaintech.retailscm.candidatecontainer.CandidateContainer")
                  
                        .with("features", "internal,ootb")
                  
                        .with("zh_CN", "候选容器")
                  ;
                  
                    candidateContainer.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    candidateContainer.property("name")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "名称")
                      ;
                    

                    
                  
                    candidateContainer.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerCandidateElement(){
        EntityMeta candidateElement = MetaProvider.entity("com.doublechaintech.retailscm.candidateelement.CandidateElement")
                  
                        .with("features", "internal,ootb")
                  ;
                  
                    candidateElement.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    candidateElement.property("name")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "标题")
                      ;
                    

                    
                  
                    candidateElement.property("type")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "类型")
                      ;
                    

                    
                  
                    candidateElement.property("image")
                      
                        .with("parent", "string")
                      
                        .with("features", "root,visible_all,string,attachment,image")
                      
                        .with("zh_CN", "图像")
                      ;
                    

                    
                  
                    candidateElement.property("container")
                      
                        .with("features", "internal,ootb")
                      
                        .with("zh_CN", "容器")
                      ;
                    
                    candidateElement.property("container")
                        .with("parentType", "com.doublechaintech.retailscm.candidatecontainer.CandidateContainer");
                    

                    
                  
                    candidateElement.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerWechatWorkappIdentity(){
        EntityMeta wechatWorkappIdentity = MetaProvider.entity("com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentity")
                  
                        .with("features", "root,visible_all")
                  
                        .with("zh_CN", "企业微信认证")
                  ;
                  
                    wechatWorkappIdentity.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    wechatWorkappIdentity.property("corpId")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "公司")
                      ;
                    

                    
                  
                    wechatWorkappIdentity.property("userId")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "用户")
                      ;
                    

                    
                  
                    wechatWorkappIdentity.property("secUser")
                      
                        .with("identified_by", "login,email,mobile")
                      
                        .with("features", "ootb")
                      
                        .with("zh_CN", "系统用户")
                      ;
                    
                    wechatWorkappIdentity.property("secUser")
                        .with("parentType", "com.doublechaintech.retailscm.secuser.SecUser");
                    

                    
                  
                    wechatWorkappIdentity.property("createTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      
                        .with("zh_CN", "创建时间")
                      ;
                    

                    
                  
                    wechatWorkappIdentity.property("lastLoginTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("zh_CN", "最后登录时间")
                      ;
                    

                    
                  
                    wechatWorkappIdentity.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerWechatMiniappIdentity(){
        EntityMeta wechatMiniappIdentity = MetaProvider.entity("com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentity")
                  
                        .with("features", "root,visible_all")
                  
                        .with("zh_CN", "微信小程序认证")
                  ;
                  
                    wechatMiniappIdentity.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    wechatMiniappIdentity.property("openId")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "openId")
                      ;
                    

                    
                  
                    wechatMiniappIdentity.property("appId")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "应用ID")
                      ;
                    

                    
                  
                    wechatMiniappIdentity.property("unionId")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "UnionID")
                      ;
                    

                    
                  
                    wechatMiniappIdentity.property("secUser")
                      
                        .with("identified_by", "login,email,mobile")
                      
                        .with("features", "ootb")
                      
                        .with("zh_CN", "系统用户")
                      ;
                    
                    wechatMiniappIdentity.property("secUser")
                        .with("parentType", "com.doublechaintech.retailscm.secuser.SecUser");
                    

                    
                  
                    wechatMiniappIdentity.property("createTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      
                        .with("zh_CN", "创建时间")
                      ;
                    

                    
                  
                    wechatMiniappIdentity.property("lastLoginTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("zh_CN", "最后登录时间")
                      ;
                    

                    
                  
                    wechatMiniappIdentity.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerKeyPairIdentity(){
        EntityMeta keyPairIdentity = MetaProvider.entity("com.doublechaintech.retailscm.keypairidentity.KeyPairIdentity")
                  
                        .with("features", "root,visible_all")
                  
                        .with("zh_CN", "秘钥对认证")
                  ;
                  
                    keyPairIdentity.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    keyPairIdentity.property("publicKey")
                      
                        .with("parent", "string_longtext")
                      
                        .with("type", "string_longtext")
                      
                        .with("features", "root,visible_all,string,longtext")
                      
                        .with("zh_CN", "公钥")
                      ;
                    

                    
                  
                    keyPairIdentity.property("keyType")
                      
                        .with("features", "root,visible_all")
                      
                        .with("zh_CN", "秘钥类型")
                      ;
                    
                    keyPairIdentity.property("keyType")
                        .with("parentType", "com.doublechaintech.retailscm.publickeytype.PublicKeyType");
                    

                    
                  
                    keyPairIdentity.property("secUser")
                      
                        .with("identified_by", "login,email,mobile")
                      
                        .with("features", "ootb")
                      
                        .with("zh_CN", "系统用户")
                      ;
                    
                    keyPairIdentity.property("secUser")
                        .with("parentType", "com.doublechaintech.retailscm.secuser.SecUser");
                    

                    
                  
                    keyPairIdentity.property("createTime")
                      
                        .with("java_type", "java.util.Date")
                      
                        .with("parent", "date_time")
                      
                        .with("features", "root,visible_all,date_time")
                      
                        .with("auto_value", "userContext.now()")
                      
                        .with("zh_CN", "创建时间")
                      ;
                    

                    
                  
                    keyPairIdentity.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerPublicKeyType(){
        EntityMeta publicKeyType = MetaProvider.entity("com.doublechaintech.retailscm.publickeytype.PublicKeyType")
                  
                        .with("features", "root,visible_all")
                  
                        .with("zh_CN", "公钥类型")
                  ;
                  
                    publicKeyType.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    publicKeyType.property("keyAlg")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "加密算法")
                      ;
                    

                    
                  
                    publicKeyType.property("signAlg")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "签名算法")
                      ;
                    

                    
                  
                    publicKeyType.property("domain")
                      
                        .with("features", "ootb,no_sample_data,iam")
                      
                        .with("zh_CN", "域")
                      ;
                    
                    publicKeyType.property("domain")
                        .with("parentType", "com.doublechaintech.retailscm.userdomain.UserDomain");
                    

                    
                  
                    publicKeyType.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }

    public void  registerTreeNode(){
        EntityMeta treeNode = MetaProvider.entity("com.doublechaintech.retailscm.treenode.TreeNode")
                  
                        .with("features", "root,visible_all")
                  
                        .with("zh_CN", "节点")
                  ;
                  
                    treeNode.property("id")
                      
                        .with("parent", "string")
                      
                        .with("type", "string")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,string,identifier,entity_base")
                      
                        .with("range_expression", "2,64")
                      
                        .with("value", "AB")
                      ;
                    

                    
                  
                    treeNode.property("nodeId")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "节点ID")
                      ;
                    

                    
                  
                    treeNode.property("nodeType")
                      
                        .with("features", "root,visible_all,string")
                      
                        .with("zh_CN", "节点类型")
                      ;
                    

                    
                  
                    treeNode.property("leftValue")
                      
                        .with("features", "root,visible_all,int")
                      
                        .with("zh_CN", "左值")
                      ;
                    

                    
                  
                    treeNode.property("rightValue")
                      
                        .with("features", "root,visible_all,int")
                      
                        .with("zh_CN", "右值")
                      ;
                    

                    
                  
                    treeNode.property("version")
                      
                        .with("type", "int")
                      
                        .with("parent", "int")
                      
                        .with("ui_ignore", "true")
                      
                        .with("features", "root,visible_all,int,version,entity_base")
                      
                        .with("value", "2147483647")
                      ;
                    

                    
                  
    }


}
















