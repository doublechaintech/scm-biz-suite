
package com.doublechaintech.retailscm;
import java.util.HashMap;
import java.util.Map;

public class CustomRelation extends BaseRelation{

	protected void prepareRelation()
	{
		super.prepareRelation();
		//Uncomment to make any change to the relation type
		//replaceGenericRelation("Catalog"                               , BaseRelation.TRUST_CHAIN_ALL, "owner");
		//replaceGenericRelation("LevelOneCategory"                      , BaseRelation.TRUST_CHAIN_ALL, "catalog");
		//replaceGenericRelation("LevelTwoCategory"                      , BaseRelation.TRUST_CHAIN_ALL, "parentCategory");
		//replaceGenericRelation("LevelThreeCategory"                    , BaseRelation.TRUST_CHAIN_ALL, "parentCategory");
		//replaceGenericRelation("Product"                               , BaseRelation.TRUST_CHAIN_ALL, "parentCategory");
		//replaceGenericRelation("Sku"                                   , BaseRelation.TRUST_CHAIN_ALL, "product");
		//replaceGenericRelation("RetailStoreProvinceCenter"             , BaseRelation.TRUST_CHAIN_ALL, "country");
		//replaceGenericRelation("ProvinceCenterDepartment"              , BaseRelation.TRUST_CHAIN_ALL, "provinceCenter");
		//replaceGenericRelation("ProvinceCenterEmployee"                , BaseRelation.TRUST_CHAIN_ALL, "department");
		//replaceGenericRelation("ProvinceCenterEmployee"                , BaseRelation.TRUST_CHAIN_ALL, "provinceCenter");
		//replaceGenericRelation("RetailStoreCityServiceCenter"          , BaseRelation.TRUST_CHAIN_ALL, "belongsTo");
		//replaceGenericRelation("CityPartner"                           , BaseRelation.TRUST_CHAIN_ALL, "cityServiceCenter");
		//replaceGenericRelation("PotentialCustomer"                     , BaseRelation.TRUST_CHAIN_ALL, "cityServiceCenter");
		//replaceGenericRelation("PotentialCustomer"                     , BaseRelation.TRUST_CHAIN_ALL, "cityPartner");
		//replaceGenericRelation("PotentialCustomerContactPerson"        , BaseRelation.TRUST_CHAIN_ALL, "potentialCustomer");
		//replaceGenericRelation("PotentialCustomerContact"              , BaseRelation.TRUST_CHAIN_ALL, "potentialCustomer");
		//replaceGenericRelation("PotentialCustomerContact"              , BaseRelation.TRUST_CHAIN_ALL, "cityPartner");
		//replaceGenericRelation("PotentialCustomerContact"              , BaseRelation.TRUST_CHAIN_ALL, "contactTo");
		//replaceGenericRelation("CityEvent"                             , BaseRelation.TRUST_CHAIN_ALL, "cityServiceCenter");
		//replaceGenericRelation("EventAttendance"                       , BaseRelation.TRUST_CHAIN_ALL, "potentialCustomer");
		//replaceGenericRelation("EventAttendance"                       , BaseRelation.TRUST_CHAIN_ALL, "cityEvent");
		//replaceGenericRelation("RetailStore"                           , BaseRelation.TRUST_CHAIN_ALL, "retailStoreCountryCenter");
		//replaceGenericRelation("RetailStore"                           , BaseRelation.TRUST_CHAIN_ALL, "cityServiceCenter");
		//replaceGenericRelation("RetailStore"                           , BaseRelation.TRUST_CHAIN_ALL, "creation");
		//replaceGenericRelation("RetailStore"                           , BaseRelation.TRUST_CHAIN_ALL, "investmentInvitation");
		//replaceGenericRelation("RetailStore"                           , BaseRelation.TRUST_CHAIN_ALL, "franchising");
		//replaceGenericRelation("RetailStore"                           , BaseRelation.TRUST_CHAIN_ALL, "decoration");
		//replaceGenericRelation("RetailStore"                           , BaseRelation.TRUST_CHAIN_ALL, "opening");
		//replaceGenericRelation("RetailStore"                           , BaseRelation.TRUST_CHAIN_ALL, "closing");
		//replaceGenericRelation("RetailStoreMember"                     , BaseRelation.TRUST_CHAIN_ALL, "owner");
		//replaceGenericRelation("ConsumerOrder"                         , BaseRelation.TRUST_CHAIN_ALL, "consumer");
		//replaceGenericRelation("ConsumerOrder"                         , BaseRelation.TRUST_CHAIN_ALL, "store");
		//replaceGenericRelation("ConsumerOrderLineItem"                 , BaseRelation.TRUST_CHAIN_ALL, "bizOrder");
		//replaceGenericRelation("ConsumerOrderShippingGroup"            , BaseRelation.TRUST_CHAIN_ALL, "bizOrder");
		//replaceGenericRelation("ConsumerOrderPaymentGroup"             , BaseRelation.TRUST_CHAIN_ALL, "bizOrder");
		//replaceGenericRelation("ConsumerOrderPriceAdjustment"          , BaseRelation.TRUST_CHAIN_ALL, "bizOrder");
		//replaceGenericRelation("RetailStoreMemberCoupon"               , BaseRelation.TRUST_CHAIN_ALL, "owner");
		//replaceGenericRelation("MemberWishlist"                        , BaseRelation.TRUST_CHAIN_ALL, "owner");
		//replaceGenericRelation("MemberRewardPoint"                     , BaseRelation.TRUST_CHAIN_ALL, "owner");
		//replaceGenericRelation("MemberRewardPointRedemption"           , BaseRelation.TRUST_CHAIN_ALL, "owner");
		//replaceGenericRelation("MemberWishlistProduct"                 , BaseRelation.TRUST_CHAIN_ALL, "owner");
		//replaceGenericRelation("RetailStoreMemberAddress"              , BaseRelation.TRUST_CHAIN_ALL, "owner");
		//replaceGenericRelation("RetailStoreMemberGiftCard"             , BaseRelation.TRUST_CHAIN_ALL, "owner");
		//replaceGenericRelation("RetailStoreMemberGiftCardConsumeRecord", BaseRelation.TRUST_CHAIN_ALL, "owner");
		//replaceGenericRelation("RetailStoreMemberGiftCardConsumeRecord", BaseRelation.TRUST_CHAIN_ALL, "bizOrder");
		//replaceGenericRelation("GoodsSupplier"                         , BaseRelation.TRUST_CHAIN_ALL, "belongTo");
		//replaceGenericRelation("SupplierProduct"                       , BaseRelation.TRUST_CHAIN_ALL, "supplier");
		//replaceGenericRelation("ProductSupplyDuration"                 , BaseRelation.TRUST_CHAIN_ALL, "product");
		//replaceGenericRelation("SupplyOrder"                           , BaseRelation.TRUST_CHAIN_ALL, "buyer");
		//replaceGenericRelation("SupplyOrder"                           , BaseRelation.TRUST_CHAIN_ALL, "seller");
		//replaceGenericRelation("SupplyOrderLineItem"                   , BaseRelation.TRUST_CHAIN_ALL, "bizOrder");
		//replaceGenericRelation("SupplyOrderShippingGroup"              , BaseRelation.TRUST_CHAIN_ALL, "bizOrder");
		//replaceGenericRelation("SupplyOrderPaymentGroup"               , BaseRelation.TRUST_CHAIN_ALL, "bizOrder");
		//replaceGenericRelation("RetailStoreOrder"                      , BaseRelation.TRUST_CHAIN_ALL, "buyer");
		//replaceGenericRelation("RetailStoreOrder"                      , BaseRelation.TRUST_CHAIN_ALL, "seller");
		//replaceGenericRelation("RetailStoreOrderLineItem"              , BaseRelation.TRUST_CHAIN_ALL, "bizOrder");
		//replaceGenericRelation("RetailStoreOrderShippingGroup"         , BaseRelation.TRUST_CHAIN_ALL, "bizOrder");
		//replaceGenericRelation("RetailStoreOrderPaymentGroup"          , BaseRelation.TRUST_CHAIN_ALL, "bizOrder");
		//replaceGenericRelation("Warehouse"                             , BaseRelation.TRUST_CHAIN_ALL, "owner");
		//replaceGenericRelation("StorageSpace"                          , BaseRelation.TRUST_CHAIN_ALL, "warehouse");
		//replaceGenericRelation("SmartPallet"                           , BaseRelation.TRUST_CHAIN_ALL, "warehouse");
		//replaceGenericRelation("GoodsShelf"                            , BaseRelation.TRUST_CHAIN_ALL, "storageSpace");
		//replaceGenericRelation("GoodsShelf"                            , BaseRelation.TRUST_CHAIN_ALL, "supplierSpace");
		//replaceGenericRelation("GoodsShelf"                            , BaseRelation.TRUST_CHAIN_ALL, "damageSpace");
		//replaceGenericRelation("GoodsShelfStockCount"                  , BaseRelation.TRUST_CHAIN_ALL, "shelf");
		//replaceGenericRelation("StockCountIssueTrack"                  , BaseRelation.TRUST_CHAIN_ALL, "stockCount");
		//replaceGenericRelation("GoodsAllocation"                       , BaseRelation.TRUST_CHAIN_ALL, "goodsShelf");
		//replaceGenericRelation("Goods"                                 , BaseRelation.TRUST_CHAIN_ALL, "sku");
		//replaceGenericRelation("Goods"                                 , BaseRelation.TRUST_CHAIN_ALL, "receivingSpace");
		//replaceGenericRelation("Goods"                                 , BaseRelation.TRUST_CHAIN_ALL, "goodsAllocation");
		//replaceGenericRelation("Goods"                                 , BaseRelation.TRUST_CHAIN_ALL, "smartPallet");
		//replaceGenericRelation("Goods"                                 , BaseRelation.TRUST_CHAIN_ALL, "shippingSpace");
		//replaceGenericRelation("Goods"                                 , BaseRelation.TRUST_CHAIN_ALL, "transportTask");
		//replaceGenericRelation("Goods"                                 , BaseRelation.TRUST_CHAIN_ALL, "retailStore");
		//replaceGenericRelation("Goods"                                 , BaseRelation.TRUST_CHAIN_ALL, "bizOrder");
		//replaceGenericRelation("Goods"                                 , BaseRelation.TRUST_CHAIN_ALL, "retailStoreOrder");
		//replaceGenericRelation("GoodsMovement"                         , BaseRelation.TRUST_CHAIN_ALL, "goods");
		//replaceGenericRelation("SupplierSpace"                         , BaseRelation.TRUST_CHAIN_ALL, "warehouse");
		//replaceGenericRelation("ReceivingSpace"                        , BaseRelation.TRUST_CHAIN_ALL, "warehouse");
		//replaceGenericRelation("ShippingSpace"                         , BaseRelation.TRUST_CHAIN_ALL, "warehouse");
		//replaceGenericRelation("DamageSpace"                           , BaseRelation.TRUST_CHAIN_ALL, "warehouse");
		//replaceGenericRelation("WarehouseAsset"                        , BaseRelation.TRUST_CHAIN_ALL, "owner");
		//replaceGenericRelation("TransportFleet"                        , BaseRelation.TRUST_CHAIN_ALL, "owner");
		//replaceGenericRelation("TransportTruck"                        , BaseRelation.TRUST_CHAIN_ALL, "owner");
		//replaceGenericRelation("TruckDriver"                           , BaseRelation.TRUST_CHAIN_ALL, "belongsTo");
		//replaceGenericRelation("TransportTask"                         , BaseRelation.TRUST_CHAIN_ALL, "end");
		//replaceGenericRelation("TransportTask"                         , BaseRelation.TRUST_CHAIN_ALL, "driver");
		//replaceGenericRelation("TransportTask"                         , BaseRelation.TRUST_CHAIN_ALL, "truck");
		//replaceGenericRelation("TransportTask"                         , BaseRelation.TRUST_CHAIN_ALL, "belongsTo");
		//replaceGenericRelation("TransportTaskTrack"                    , BaseRelation.TRUST_CHAIN_ALL, "movement");
		//replaceGenericRelation("AccountSet"                            , BaseRelation.TRUST_CHAIN_ALL, "countryCenter");
		//replaceGenericRelation("AccountSet"                            , BaseRelation.TRUST_CHAIN_ALL, "retailStore");
		//replaceGenericRelation("AccountSet"                            , BaseRelation.TRUST_CHAIN_ALL, "goodsSupplier");
		//replaceGenericRelation("AccountingSubject"                     , BaseRelation.TRUST_CHAIN_ALL, "accountSet");
		//replaceGenericRelation("AccountingPeriod"                      , BaseRelation.TRUST_CHAIN_ALL, "accountSet");
		//replaceGenericRelation("AccountingDocumentType"                , BaseRelation.TRUST_CHAIN_ALL, "accountingPeriod");
		//replaceGenericRelation("AccountingDocument"                    , BaseRelation.TRUST_CHAIN_ALL, "accountingPeriod");
		//replaceGenericRelation("AccountingDocument"                    , BaseRelation.TRUST_CHAIN_ALL, "documentType");
		//replaceGenericRelation("OriginalVoucher"                       , BaseRelation.TRUST_CHAIN_ALL, "belongsTo");
		//replaceGenericRelation("AccountingDocumentLine"                , BaseRelation.TRUST_CHAIN_ALL, "belongsTo");
		//replaceGenericRelation("AccountingDocumentLine"                , BaseRelation.TRUST_CHAIN_ALL, "accountingSubject");
		//replaceGenericRelation("LevelOneDepartment"                    , BaseRelation.TRUST_CHAIN_ALL, "belongsTo");
		//replaceGenericRelation("LevelTwoDepartment"                    , BaseRelation.TRUST_CHAIN_ALL, "belongsTo");
		//replaceGenericRelation("LevelThreeDepartment"                  , BaseRelation.TRUST_CHAIN_ALL, "belongsTo");
		//replaceGenericRelation("SkillType"                             , BaseRelation.TRUST_CHAIN_ALL, "company");
		//replaceGenericRelation("ResponsibilityType"                    , BaseRelation.TRUST_CHAIN_ALL, "company");
		//replaceGenericRelation("TerminationReason"                     , BaseRelation.TRUST_CHAIN_ALL, "company");
		//replaceGenericRelation("TerminationType"                       , BaseRelation.TRUST_CHAIN_ALL, "company");
		//replaceGenericRelation("OccupationType"                        , BaseRelation.TRUST_CHAIN_ALL, "company");
		//replaceGenericRelation("LeaveType"                             , BaseRelation.TRUST_CHAIN_ALL, "company");
		//replaceGenericRelation("SalaryGrade"                           , BaseRelation.TRUST_CHAIN_ALL, "company");
		//replaceGenericRelation("InterviewType"                         , BaseRelation.TRUST_CHAIN_ALL, "company");
		//replaceGenericRelation("TrainingCourseType"                    , BaseRelation.TRUST_CHAIN_ALL, "company");
		//replaceGenericRelation("PublicHoliday"                         , BaseRelation.TRUST_CHAIN_ALL, "company");
		//replaceGenericRelation("Termination"                           , BaseRelation.TRUST_CHAIN_ALL, "reason");
		//replaceGenericRelation("Termination"                           , BaseRelation.TRUST_CHAIN_ALL, "type");
		//replaceGenericRelation("Employee"                              , BaseRelation.TRUST_CHAIN_ALL, "company");
		//replaceGenericRelation("Employee"                              , BaseRelation.TRUST_CHAIN_ALL, "department");
		//replaceGenericRelation("Employee"                              , BaseRelation.TRUST_CHAIN_ALL, "occupation");
		//replaceGenericRelation("Employee"                              , BaseRelation.TRUST_CHAIN_ALL, "responsibleFor");
		//replaceGenericRelation("Employee"                              , BaseRelation.TRUST_CHAIN_ALL, "currentSalaryGrade");
		//replaceGenericRelation("Instructor"                            , BaseRelation.TRUST_CHAIN_ALL, "company");
		//replaceGenericRelation("CompanyTraining"                       , BaseRelation.TRUST_CHAIN_ALL, "company");
		//replaceGenericRelation("CompanyTraining"                       , BaseRelation.TRUST_CHAIN_ALL, "instructor");
		//replaceGenericRelation("CompanyTraining"                       , BaseRelation.TRUST_CHAIN_ALL, "trainingCourseType");
		//replaceGenericRelation("EmployeeCompanyTraining"               , BaseRelation.TRUST_CHAIN_ALL, "employee");
		//replaceGenericRelation("EmployeeCompanyTraining"               , BaseRelation.TRUST_CHAIN_ALL, "training");
		//replaceGenericRelation("EmployeeCompanyTraining"               , BaseRelation.TRUST_CHAIN_ALL, "scoring");
		//replaceGenericRelation("EmployeeSkill"                         , BaseRelation.TRUST_CHAIN_ALL, "employee");
		//replaceGenericRelation("EmployeeSkill"                         , BaseRelation.TRUST_CHAIN_ALL, "skillType");
		//replaceGenericRelation("EmployeePerformance"                   , BaseRelation.TRUST_CHAIN_ALL, "employee");
		//replaceGenericRelation("EmployeeWorkExperience"                , BaseRelation.TRUST_CHAIN_ALL, "employee");
		//replaceGenericRelation("EmployeeLeave"                         , BaseRelation.TRUST_CHAIN_ALL, "who");
		//replaceGenericRelation("EmployeeLeave"                         , BaseRelation.TRUST_CHAIN_ALL, "type");
		//replaceGenericRelation("EmployeeInterview"                     , BaseRelation.TRUST_CHAIN_ALL, "employee");
		//replaceGenericRelation("EmployeeInterview"                     , BaseRelation.TRUST_CHAIN_ALL, "interviewType");
		//replaceGenericRelation("EmployeeAttendance"                    , BaseRelation.TRUST_CHAIN_ALL, "employee");
		//replaceGenericRelation("EmployeeQualifier"                     , BaseRelation.TRUST_CHAIN_ALL, "employee");
		//replaceGenericRelation("EmployeeEducation"                     , BaseRelation.TRUST_CHAIN_ALL, "employee");
		//replaceGenericRelation("EmployeeAward"                         , BaseRelation.TRUST_CHAIN_ALL, "employee");
		//replaceGenericRelation("EmployeeSalarySheet"                   , BaseRelation.TRUST_CHAIN_ALL, "employee");
		//replaceGenericRelation("EmployeeSalarySheet"                   , BaseRelation.TRUST_CHAIN_ALL, "currentSalaryGrade");
		//replaceGenericRelation("EmployeeSalarySheet"                   , BaseRelation.TRUST_CHAIN_ALL, "payingOff");
		//replaceGenericRelation("PayingOff"                             , BaseRelation.TRUST_CHAIN_ALL, "paidFor");
		//replaceGenericRelation("Page"                                  , BaseRelation.TRUST_CHAIN_ALL, "pageType");
		//replaceGenericRelation("Page"                                  , BaseRelation.TRUST_CHAIN_ALL, "mobileApp");
		//replaceGenericRelation("PageType"                              , BaseRelation.TRUST_CHAIN_ALL, "mobileApp");
		//replaceGenericRelation("Slide"                                 , BaseRelation.TRUST_CHAIN_ALL, "page");
		//replaceGenericRelation("UiAction"                              , BaseRelation.TRUST_CHAIN_ALL, "page");
		//replaceGenericRelation("Section"                               , BaseRelation.TRUST_CHAIN_ALL, "page");
		//replaceGenericRelation("UserAllowList"                         , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("SecUser"                               , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("UserApp"                               , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("QuickLink"                             , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("ListAccess"                            , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("LoginHistory"                          , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("CandidateElement"                      , BaseRelation.TRUST_CHAIN_ALL, "container");
		//replaceGenericRelation("WechatWorkappIdentity"                 , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("WechatMiniappIdentity"                 , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("KeypairIdentity"                       , BaseRelation.TRUST_CHAIN_ALL, "keyType");
		//replaceGenericRelation("KeypairIdentity"                       , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("PublicKeyType"                         , BaseRelation.TRUST_CHAIN_ALL, "domain");

	}
	
	protected void prepareRelationIndex()
	{
		super.prepareRelationIndex();
		/*
		
		Note: you could delete some of the possible relations if you do not want it.
		Just uncomment the definition line and replaceRelationIndex line to replace existing one.
		
		*/
		//String [] catalogRelatedObjectNames = {"owner:RetailStoreCountryCenter"};
		//replaceRelationIndex("Catalog",catalogRelatedObjectNames);

		//String [] levelOneCategoryRelatedObjectNames = {"catalog:Catalog"};
		//replaceRelationIndex("LevelOneCategory",levelOneCategoryRelatedObjectNames);

		//String [] levelTwoCategoryRelatedObjectNames = {"parent_category:LevelOneCategory"};
		//replaceRelationIndex("LevelTwoCategory",levelTwoCategoryRelatedObjectNames);

		//String [] levelThreeCategoryRelatedObjectNames = {"parent_category:LevelTwoCategory"};
		//replaceRelationIndex("LevelThreeCategory",levelThreeCategoryRelatedObjectNames);

		//String [] productRelatedObjectNames = {"parent_category:LevelThreeCategory"};
		//replaceRelationIndex("Product",productRelatedObjectNames);

		//String [] skuRelatedObjectNames = {"product:Product"};
		//replaceRelationIndex("Sku",skuRelatedObjectNames);

		//String [] retailStoreProvinceCenterRelatedObjectNames = {"country:RetailStoreCountryCenter"};
		//replaceRelationIndex("RetailStoreProvinceCenter",retailStoreProvinceCenterRelatedObjectNames);

		//String [] provinceCenterDepartmentRelatedObjectNames = {"province_center:RetailStoreProvinceCenter"};
		//replaceRelationIndex("ProvinceCenterDepartment",provinceCenterDepartmentRelatedObjectNames);

		//String [] provinceCenterEmployeeRelatedObjectNames = {"department:ProvinceCenterDepartment","province_center:RetailStoreProvinceCenter"};
		//replaceRelationIndex("ProvinceCenterEmployee",provinceCenterEmployeeRelatedObjectNames);

		//String [] retailStoreCityServiceCenterRelatedObjectNames = {"belongs_to:RetailStoreProvinceCenter"};
		//replaceRelationIndex("RetailStoreCityServiceCenter",retailStoreCityServiceCenterRelatedObjectNames);

		//String [] cityPartnerRelatedObjectNames = {"city_service_center:RetailStoreCityServiceCenter"};
		//replaceRelationIndex("CityPartner",cityPartnerRelatedObjectNames);

		//String [] potentialCustomerRelatedObjectNames = {"city_service_center:RetailStoreCityServiceCenter","city_partner:CityPartner"};
		//replaceRelationIndex("PotentialCustomer",potentialCustomerRelatedObjectNames);

		//String [] potentialCustomerContactPersonRelatedObjectNames = {"potential_customer:PotentialCustomer"};
		//replaceRelationIndex("PotentialCustomerContactPerson",potentialCustomerContactPersonRelatedObjectNames);

		//String [] potentialCustomerContactRelatedObjectNames = {"potential_customer:PotentialCustomer","city_partner:CityPartner","contact_to:PotentialCustomerContactPerson"};
		//replaceRelationIndex("PotentialCustomerContact",potentialCustomerContactRelatedObjectNames);

		//String [] cityEventRelatedObjectNames = {"city_service_center:RetailStoreCityServiceCenter"};
		//replaceRelationIndex("CityEvent",cityEventRelatedObjectNames);

		//String [] eventAttendanceRelatedObjectNames = {"potential_customer:PotentialCustomer","city_event:CityEvent"};
		//replaceRelationIndex("EventAttendance",eventAttendanceRelatedObjectNames);

		//String [] retailStoreRelatedObjectNames = {"retail_store_country_center:RetailStoreCountryCenter","city_service_center:RetailStoreCityServiceCenter","creation:RetailStoreCreation","investment_invitation:RetailStoreInvestmentInvitation","franchising:RetailStoreFranchising","decoration:RetailStoreDecoration","opening:RetailStoreOpening","closing:RetailStoreClosing"};
		//replaceRelationIndex("RetailStore",retailStoreRelatedObjectNames);

		//String [] retailStoreMemberRelatedObjectNames = {"owner:RetailStoreCountryCenter"};
		//replaceRelationIndex("RetailStoreMember",retailStoreMemberRelatedObjectNames);

		//String [] consumerOrderRelatedObjectNames = {"consumer:RetailStoreMember","store:RetailStore"};
		//replaceRelationIndex("ConsumerOrder",consumerOrderRelatedObjectNames);

		//String [] consumerOrderLineItemRelatedObjectNames = {"biz_order:ConsumerOrder"};
		//replaceRelationIndex("ConsumerOrderLineItem",consumerOrderLineItemRelatedObjectNames);

		//String [] consumerOrderShippingGroupRelatedObjectNames = {"biz_order:ConsumerOrder"};
		//replaceRelationIndex("ConsumerOrderShippingGroup",consumerOrderShippingGroupRelatedObjectNames);

		//String [] consumerOrderPaymentGroupRelatedObjectNames = {"biz_order:ConsumerOrder"};
		//replaceRelationIndex("ConsumerOrderPaymentGroup",consumerOrderPaymentGroupRelatedObjectNames);

		//String [] consumerOrderPriceAdjustmentRelatedObjectNames = {"biz_order:ConsumerOrder"};
		//replaceRelationIndex("ConsumerOrderPriceAdjustment",consumerOrderPriceAdjustmentRelatedObjectNames);

		//String [] retailStoreMemberCouponRelatedObjectNames = {"owner:RetailStoreMember"};
		//replaceRelationIndex("RetailStoreMemberCoupon",retailStoreMemberCouponRelatedObjectNames);

		//String [] memberWishlistRelatedObjectNames = {"owner:RetailStoreMember"};
		//replaceRelationIndex("MemberWishlist",memberWishlistRelatedObjectNames);

		//String [] memberRewardPointRelatedObjectNames = {"owner:RetailStoreMember"};
		//replaceRelationIndex("MemberRewardPoint",memberRewardPointRelatedObjectNames);

		//String [] memberRewardPointRedemptionRelatedObjectNames = {"owner:RetailStoreMember"};
		//replaceRelationIndex("MemberRewardPointRedemption",memberRewardPointRedemptionRelatedObjectNames);

		//String [] memberWishlistProductRelatedObjectNames = {"owner:MemberWishlist"};
		//replaceRelationIndex("MemberWishlistProduct",memberWishlistProductRelatedObjectNames);

		//String [] retailStoreMemberAddressRelatedObjectNames = {"owner:RetailStoreMember"};
		//replaceRelationIndex("RetailStoreMemberAddress",retailStoreMemberAddressRelatedObjectNames);

		//String [] retailStoreMemberGiftCardRelatedObjectNames = {"owner:RetailStoreMember"};
		//replaceRelationIndex("RetailStoreMemberGiftCard",retailStoreMemberGiftCardRelatedObjectNames);

		//String [] retailStoreMemberGiftCardConsumeRecordRelatedObjectNames = {"owner:RetailStoreMemberGiftCard","biz_order:ConsumerOrder"};
		//replaceRelationIndex("RetailStoreMemberGiftCardConsumeRecord",retailStoreMemberGiftCardConsumeRecordRelatedObjectNames);

		//String [] goodsSupplierRelatedObjectNames = {"belong_to:RetailStoreCountryCenter"};
		//replaceRelationIndex("GoodsSupplier",goodsSupplierRelatedObjectNames);

		//String [] supplierProductRelatedObjectNames = {"supplier:GoodsSupplier"};
		//replaceRelationIndex("SupplierProduct",supplierProductRelatedObjectNames);

		//String [] productSupplyDurationRelatedObjectNames = {"product:SupplierProduct"};
		//replaceRelationIndex("ProductSupplyDuration",productSupplyDurationRelatedObjectNames);

		//String [] supplyOrderRelatedObjectNames = {"buyer:RetailStoreCountryCenter","seller:GoodsSupplier"};
		//replaceRelationIndex("SupplyOrder",supplyOrderRelatedObjectNames);

		//String [] supplyOrderLineItemRelatedObjectNames = {"biz_order:SupplyOrder"};
		//replaceRelationIndex("SupplyOrderLineItem",supplyOrderLineItemRelatedObjectNames);

		//String [] supplyOrderShippingGroupRelatedObjectNames = {"biz_order:SupplyOrder"};
		//replaceRelationIndex("SupplyOrderShippingGroup",supplyOrderShippingGroupRelatedObjectNames);

		//String [] supplyOrderPaymentGroupRelatedObjectNames = {"biz_order:SupplyOrder"};
		//replaceRelationIndex("SupplyOrderPaymentGroup",supplyOrderPaymentGroupRelatedObjectNames);

		//String [] retailStoreOrderRelatedObjectNames = {"buyer:RetailStore","seller:RetailStoreCountryCenter"};
		//replaceRelationIndex("RetailStoreOrder",retailStoreOrderRelatedObjectNames);

		//String [] retailStoreOrderLineItemRelatedObjectNames = {"biz_order:RetailStoreOrder"};
		//replaceRelationIndex("RetailStoreOrderLineItem",retailStoreOrderLineItemRelatedObjectNames);

		//String [] retailStoreOrderShippingGroupRelatedObjectNames = {"biz_order:RetailStoreOrder"};
		//replaceRelationIndex("RetailStoreOrderShippingGroup",retailStoreOrderShippingGroupRelatedObjectNames);

		//String [] retailStoreOrderPaymentGroupRelatedObjectNames = {"biz_order:RetailStoreOrder"};
		//replaceRelationIndex("RetailStoreOrderPaymentGroup",retailStoreOrderPaymentGroupRelatedObjectNames);

		//String [] warehouseRelatedObjectNames = {"owner:RetailStoreCountryCenter"};
		//replaceRelationIndex("Warehouse",warehouseRelatedObjectNames);

		//String [] storageSpaceRelatedObjectNames = {"warehouse:Warehouse"};
		//replaceRelationIndex("StorageSpace",storageSpaceRelatedObjectNames);

		//String [] smartPalletRelatedObjectNames = {"warehouse:Warehouse"};
		//replaceRelationIndex("SmartPallet",smartPalletRelatedObjectNames);

		//String [] goodsShelfRelatedObjectNames = {"storage_space:StorageSpace","supplier_space:SupplierSpace","damage_space:DamageSpace"};
		//replaceRelationIndex("GoodsShelf",goodsShelfRelatedObjectNames);

		//String [] goodsShelfStockCountRelatedObjectNames = {"shelf:GoodsShelf"};
		//replaceRelationIndex("GoodsShelfStockCount",goodsShelfStockCountRelatedObjectNames);

		//String [] stockCountIssueTrackRelatedObjectNames = {"stock_count:GoodsShelfStockCount"};
		//replaceRelationIndex("StockCountIssueTrack",stockCountIssueTrackRelatedObjectNames);

		//String [] goodsAllocationRelatedObjectNames = {"goods_shelf:GoodsShelf"};
		//replaceRelationIndex("GoodsAllocation",goodsAllocationRelatedObjectNames);

		//String [] goodsRelatedObjectNames = {"sku:Sku","receiving_space:ReceivingSpace","goods_allocation:GoodsAllocation","smart_pallet:SmartPallet","shipping_space:ShippingSpace","transport_task:TransportTask","retail_store:RetailStore","biz_order:SupplyOrder","retail_store_order:RetailStoreOrder"};
		//replaceRelationIndex("Goods",goodsRelatedObjectNames);

		//String [] goodsMovementRelatedObjectNames = {"goods:Goods"};
		//replaceRelationIndex("GoodsMovement",goodsMovementRelatedObjectNames);

		//String [] supplierSpaceRelatedObjectNames = {"warehouse:Warehouse"};
		//replaceRelationIndex("SupplierSpace",supplierSpaceRelatedObjectNames);

		//String [] receivingSpaceRelatedObjectNames = {"warehouse:Warehouse"};
		//replaceRelationIndex("ReceivingSpace",receivingSpaceRelatedObjectNames);

		//String [] shippingSpaceRelatedObjectNames = {"warehouse:Warehouse"};
		//replaceRelationIndex("ShippingSpace",shippingSpaceRelatedObjectNames);

		//String [] damageSpaceRelatedObjectNames = {"warehouse:Warehouse"};
		//replaceRelationIndex("DamageSpace",damageSpaceRelatedObjectNames);

		//String [] warehouseAssetRelatedObjectNames = {"owner:Warehouse"};
		//replaceRelationIndex("WarehouseAsset",warehouseAssetRelatedObjectNames);

		//String [] transportFleetRelatedObjectNames = {"owner:RetailStoreCountryCenter"};
		//replaceRelationIndex("TransportFleet",transportFleetRelatedObjectNames);

		//String [] transportTruckRelatedObjectNames = {"owner:TransportFleet"};
		//replaceRelationIndex("TransportTruck",transportTruckRelatedObjectNames);

		//String [] truckDriverRelatedObjectNames = {"belongs_to:TransportFleet"};
		//replaceRelationIndex("TruckDriver",truckDriverRelatedObjectNames);

		//String [] transportTaskRelatedObjectNames = {"end:RetailStore","driver:TruckDriver","truck:TransportTruck","belongs_to:TransportFleet"};
		//replaceRelationIndex("TransportTask",transportTaskRelatedObjectNames);

		//String [] transportTaskTrackRelatedObjectNames = {"movement:TransportTask"};
		//replaceRelationIndex("TransportTaskTrack",transportTaskTrackRelatedObjectNames);

		//String [] accountSetRelatedObjectNames = {"country_center:RetailStoreCountryCenter","retail_store:RetailStore","goods_supplier:GoodsSupplier"};
		//replaceRelationIndex("AccountSet",accountSetRelatedObjectNames);

		//String [] accountingSubjectRelatedObjectNames = {"account_set:AccountSet"};
		//replaceRelationIndex("AccountingSubject",accountingSubjectRelatedObjectNames);

		//String [] accountingPeriodRelatedObjectNames = {"account_set:AccountSet"};
		//replaceRelationIndex("AccountingPeriod",accountingPeriodRelatedObjectNames);

		//String [] accountingDocumentTypeRelatedObjectNames = {"accounting_period:AccountSet"};
		//replaceRelationIndex("AccountingDocumentType",accountingDocumentTypeRelatedObjectNames);

		//String [] accountingDocumentRelatedObjectNames = {"accounting_period:AccountingPeriod","document_type:AccountingDocumentType"};
		//replaceRelationIndex("AccountingDocument",accountingDocumentRelatedObjectNames);

		//String [] originalVoucherRelatedObjectNames = {"belongs_to:AccountingDocument"};
		//replaceRelationIndex("OriginalVoucher",originalVoucherRelatedObjectNames);

		//String [] accountingDocumentLineRelatedObjectNames = {"belongs_to:AccountingDocument","accounting_subject:AccountingSubject"};
		//replaceRelationIndex("AccountingDocumentLine",accountingDocumentLineRelatedObjectNames);

		//String [] levelOneDepartmentRelatedObjectNames = {"belongs_to:RetailStoreCountryCenter"};
		//replaceRelationIndex("LevelOneDepartment",levelOneDepartmentRelatedObjectNames);

		//String [] levelTwoDepartmentRelatedObjectNames = {"belongs_to:LevelOneDepartment"};
		//replaceRelationIndex("LevelTwoDepartment",levelTwoDepartmentRelatedObjectNames);

		//String [] levelThreeDepartmentRelatedObjectNames = {"belongs_to:LevelTwoDepartment"};
		//replaceRelationIndex("LevelThreeDepartment",levelThreeDepartmentRelatedObjectNames);

		//String [] skillTypeRelatedObjectNames = {"company:RetailStoreCountryCenter"};
		//replaceRelationIndex("SkillType",skillTypeRelatedObjectNames);

		//String [] responsibilityTypeRelatedObjectNames = {"company:RetailStoreCountryCenter"};
		//replaceRelationIndex("ResponsibilityType",responsibilityTypeRelatedObjectNames);

		//String [] terminationReasonRelatedObjectNames = {"company:RetailStoreCountryCenter"};
		//replaceRelationIndex("TerminationReason",terminationReasonRelatedObjectNames);

		//String [] terminationTypeRelatedObjectNames = {"company:RetailStoreCountryCenter"};
		//replaceRelationIndex("TerminationType",terminationTypeRelatedObjectNames);

		//String [] occupationTypeRelatedObjectNames = {"company:RetailStoreCountryCenter"};
		//replaceRelationIndex("OccupationType",occupationTypeRelatedObjectNames);

		//String [] leaveTypeRelatedObjectNames = {"company:RetailStoreCountryCenter"};
		//replaceRelationIndex("LeaveType",leaveTypeRelatedObjectNames);

		//String [] salaryGradeRelatedObjectNames = {"company:RetailStoreCountryCenter"};
		//replaceRelationIndex("SalaryGrade",salaryGradeRelatedObjectNames);

		//String [] interviewTypeRelatedObjectNames = {"company:RetailStoreCountryCenter"};
		//replaceRelationIndex("InterviewType",interviewTypeRelatedObjectNames);

		//String [] trainingCourseTypeRelatedObjectNames = {"company:RetailStoreCountryCenter"};
		//replaceRelationIndex("TrainingCourseType",trainingCourseTypeRelatedObjectNames);

		//String [] publicHolidayRelatedObjectNames = {"company:RetailStoreCountryCenter"};
		//replaceRelationIndex("PublicHoliday",publicHolidayRelatedObjectNames);

		//String [] terminationRelatedObjectNames = {"reason:TerminationReason","type:TerminationType"};
		//replaceRelationIndex("Termination",terminationRelatedObjectNames);

		//String [] employeeRelatedObjectNames = {"company:RetailStoreCountryCenter","department:LevelThreeDepartment","occupation:OccupationType","responsible_for:ResponsibilityType","current_salary_grade:SalaryGrade"};
		//replaceRelationIndex("Employee",employeeRelatedObjectNames);

		//String [] instructorRelatedObjectNames = {"company:RetailStoreCountryCenter"};
		//replaceRelationIndex("Instructor",instructorRelatedObjectNames);

		//String [] companyTrainingRelatedObjectNames = {"company:RetailStoreCountryCenter","instructor:Instructor","training_course_type:TrainingCourseType"};
		//replaceRelationIndex("CompanyTraining",companyTrainingRelatedObjectNames);

		//String [] employeeCompanyTrainingRelatedObjectNames = {"employee:Employee","training:CompanyTraining","scoring:Scoring"};
		//replaceRelationIndex("EmployeeCompanyTraining",employeeCompanyTrainingRelatedObjectNames);

		//String [] employeeSkillRelatedObjectNames = {"employee:Employee","skill_type:SkillType"};
		//replaceRelationIndex("EmployeeSkill",employeeSkillRelatedObjectNames);

		//String [] employeePerformanceRelatedObjectNames = {"employee:Employee"};
		//replaceRelationIndex("EmployeePerformance",employeePerformanceRelatedObjectNames);

		//String [] employeeWorkExperienceRelatedObjectNames = {"employee:Employee"};
		//replaceRelationIndex("EmployeeWorkExperience",employeeWorkExperienceRelatedObjectNames);

		//String [] employeeLeaveRelatedObjectNames = {"who:Employee","type:LeaveType"};
		//replaceRelationIndex("EmployeeLeave",employeeLeaveRelatedObjectNames);

		//String [] employeeInterviewRelatedObjectNames = {"employee:Employee","interview_type:InterviewType"};
		//replaceRelationIndex("EmployeeInterview",employeeInterviewRelatedObjectNames);

		//String [] employeeAttendanceRelatedObjectNames = {"employee:Employee"};
		//replaceRelationIndex("EmployeeAttendance",employeeAttendanceRelatedObjectNames);

		//String [] employeeQualifierRelatedObjectNames = {"employee:Employee"};
		//replaceRelationIndex("EmployeeQualifier",employeeQualifierRelatedObjectNames);

		//String [] employeeEducationRelatedObjectNames = {"employee:Employee"};
		//replaceRelationIndex("EmployeeEducation",employeeEducationRelatedObjectNames);

		//String [] employeeAwardRelatedObjectNames = {"employee:Employee"};
		//replaceRelationIndex("EmployeeAward",employeeAwardRelatedObjectNames);

		//String [] employeeSalarySheetRelatedObjectNames = {"employee:Employee","current_salary_grade:SalaryGrade","paying_off:PayingOff"};
		//replaceRelationIndex("EmployeeSalarySheet",employeeSalarySheetRelatedObjectNames);

		//String [] payingOffRelatedObjectNames = {"paid_for:Employee"};
		//replaceRelationIndex("PayingOff",payingOffRelatedObjectNames);

		//String [] pageRelatedObjectNames = {"page_type:PageType","mobile_app:MobileApp"};
		//replaceRelationIndex("Page",pageRelatedObjectNames);

		//String [] pageTypeRelatedObjectNames = {"mobile_app:MobileApp"};
		//replaceRelationIndex("PageType",pageTypeRelatedObjectNames);

		//String [] slideRelatedObjectNames = {"page:Page"};
		//replaceRelationIndex("Slide",slideRelatedObjectNames);

		//String [] uiActionRelatedObjectNames = {"page:Page"};
		//replaceRelationIndex("UiAction",uiActionRelatedObjectNames);

		//String [] sectionRelatedObjectNames = {"page:Page"};
		//replaceRelationIndex("Section",sectionRelatedObjectNames);

		//String [] userAllowListRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("UserAllowList",userAllowListRelatedObjectNames);

		//String [] secUserRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("SecUser",secUserRelatedObjectNames);

		//String [] userAppRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("UserApp",userAppRelatedObjectNames);

		//String [] quickLinkRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("QuickLink",quickLinkRelatedObjectNames);

		//String [] listAccessRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("ListAccess",listAccessRelatedObjectNames);

		//String [] loginHistoryRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("LoginHistory",loginHistoryRelatedObjectNames);

		//String [] candidateElementRelatedObjectNames = {"container:CandidateContainer"};
		//replaceRelationIndex("CandidateElement",candidateElementRelatedObjectNames);

		//String [] wechatWorkappIdentityRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("WechatWorkappIdentity",wechatWorkappIdentityRelatedObjectNames);

		//String [] wechatMiniappIdentityRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("WechatMiniappIdentity",wechatMiniappIdentityRelatedObjectNames);

		//String [] keypairIdentityRelatedObjectNames = {"key_type:PublicKeyType","sec_user:SecUser"};
		//replaceRelationIndex("KeypairIdentity",keypairIdentityRelatedObjectNames);

		//String [] publicKeyTypeRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("PublicKeyType",publicKeyTypeRelatedObjectNames);

		
		
	
	}
	
	
	@Override
	public String getRelation(String fromType, String fromId, String targetField, String targetId)
	{

		String relation = super.getRelation(fromType, fromId, targetField, targetId);
		if(relation == null){
			throw new IllegalArgumentException("Not able to find any relation to the target type: "+ targetField);
		}
		return relation;
		
	}

}




















