package com.doublechaintech.retailscm;


import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.catalog.Catalog;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;
import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory;
import com.doublechaintech.retailscm.product.Product;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.cityevent.CityEvent;
import com.doublechaintech.retailscm.eventattendance.EventAttendance;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItem;
import com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup;
import com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup;
import com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment;
import com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon;
import com.doublechaintech.retailscm.memberwishlist.MemberWishlist;
import com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPoint;
import com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemption;
import com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProduct;
import com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddress;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;
import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDuration;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItem;
import com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup;
import com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem;
import com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup;
import com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup;
import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.storagespace.StorageSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;
import com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrack;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.goodsmovement.GoodsMovement;
import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.warehouseasset.WarehouseAsset;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrack;
import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucher;
import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment;
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.skilltype.SkillType;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;
import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.leavetype.LeaveType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.interviewtype.InterviewType;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;
import com.doublechaintech.retailscm.publicholiday.PublicHoliday;
import com.doublechaintech.retailscm.termination.Termination;
import com.doublechaintech.retailscm.view.View;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;
import com.doublechaintech.retailscm.scoring.Scoring;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkill;
import com.doublechaintech.retailscm.employeeperformance.EmployeePerformance;
import com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperience;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeave;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterview;
import com.doublechaintech.retailscm.employeeattendance.EmployeeAttendance;
import com.doublechaintech.retailscm.employeequalifier.EmployeeQualifier;
import com.doublechaintech.retailscm.employeeeducation.EmployeeEducation;
import com.doublechaintech.retailscm.employeeaward.EmployeeAward;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.mobileapp.MobileApp;
import com.doublechaintech.retailscm.page.Page;
import com.doublechaintech.retailscm.pagetype.PageType;
import com.doublechaintech.retailscm.slide.Slide;
import com.doublechaintech.retailscm.uiaction.UiAction;
import com.doublechaintech.retailscm.section.Section;
import com.doublechaintech.retailscm.userdomain.UserDomain;
import com.doublechaintech.retailscm.userwhitelist.UserWhiteList;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.quicklink.QuickLink;
import com.doublechaintech.retailscm.listaccess.ListAccess;
import com.doublechaintech.retailscm.loginhistory.LoginHistory;
import com.doublechaintech.retailscm.candidatecontainer.CandidateContainer;
import com.doublechaintech.retailscm.candidateelement.CandidateElement;
import com.doublechaintech.retailscm.wechatworkappidentify.WechatWorkappIdentify;
import com.doublechaintech.retailscm.wechatminiappidentify.WechatMiniappIdentify;
import com.doublechaintech.retailscm.keypairidentify.KeypairIdentify;
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;
import com.doublechaintech.retailscm.treenode.TreeNode;


public class RetailscmBaseViewScope {

	protected static SerializeScope RetailStoreCountryCenterBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreCountryCenter.ID_PROPERTY)
		.field(RetailStoreCountryCenter.NAME_PROPERTY)
		.field(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY)
		.field(RetailStoreCountryCenter.FOUNDED_PROPERTY)
		.field(RetailStoreCountryCenter.WEB_SITE_PROPERTY)
		.field(RetailStoreCountryCenter.ADDRESS_PROPERTY)
		.field(RetailStoreCountryCenter.OPERATED_BY_PROPERTY)
		.field(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY)
		.field(RetailStoreCountryCenter.DESCRIPTION_PROPERTY)
		;
	/** 用于RetailStoreCountryCenter的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreCountryCenterSummaryScope() {
		return RetailStoreCountryCenterBaseSummaryScope;
	}

	protected static SerializeScope CatalogBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Catalog.ID_PROPERTY)
		.field(Catalog.NAME_PROPERTY)
		.field(Catalog.SUB_COUNT_PROPERTY)
		.field(Catalog.AMOUNT_PROPERTY)
		;
	/** 用于Catalog的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCatalogSummaryScope() {
		return CatalogBaseSummaryScope;
	}

	protected static SerializeScope LevelOneCategoryBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelOneCategory.ID_PROPERTY)
		.field(LevelOneCategory.NAME_PROPERTY)
		;
	/** 用于LevelOneCategory的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLevelOneCategorySummaryScope() {
		return LevelOneCategoryBaseSummaryScope;
	}

	protected static SerializeScope LevelTwoCategoryBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelTwoCategory.ID_PROPERTY)
		.field(LevelTwoCategory.NAME_PROPERTY)
		;
	/** 用于LevelTwoCategory的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLevelTwoCategorySummaryScope() {
		return LevelTwoCategoryBaseSummaryScope;
	}

	protected static SerializeScope LevelThreeCategoryBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelThreeCategory.ID_PROPERTY)
		.field(LevelThreeCategory.NAME_PROPERTY)
		;
	/** 用于LevelThreeCategory的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLevelThreeCategorySummaryScope() {
		return LevelThreeCategoryBaseSummaryScope;
	}

	protected static SerializeScope ProductBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Product.ID_PROPERTY)
		.field(Product.NAME_PROPERTY)
		.field(Product.ORIGIN_PROPERTY)
		.field(Product.REMARK_PROPERTY)
		.field(Product.BRAND_PROPERTY)
		.field(Product.PICTURE_PROPERTY)
		.field(Product.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于Product的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getProductSummaryScope() {
		return ProductBaseSummaryScope;
	}

	protected static SerializeScope SkuBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Sku.ID_PROPERTY)
		.field(Sku.NAME_PROPERTY)
		.field(Sku.SIZE_PROPERTY)
		.field(Sku.BARCODE_PROPERTY)
		.field(Sku.PACKAGE_TYPE_PROPERTY)
		.field(Sku.NET_CONTENT_PROPERTY)
		.field(Sku.PRICE_PROPERTY)
		.field(Sku.PICTURE_PROPERTY)
		;
	/** 用于Sku的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSkuSummaryScope() {
		return SkuBaseSummaryScope;
	}

	protected static SerializeScope RetailStoreProvinceCenterBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreProvinceCenter.ID_PROPERTY)
		.field(RetailStoreProvinceCenter.NAME_PROPERTY)
		.field(RetailStoreProvinceCenter.FOUNDED_PROPERTY)
		.field(RetailStoreProvinceCenter.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于RetailStoreProvinceCenter的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreProvinceCenterSummaryScope() {
		return RetailStoreProvinceCenterBaseSummaryScope;
	}

	protected static SerializeScope ProvinceCenterDepartmentBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ProvinceCenterDepartment.ID_PROPERTY)
		.field(ProvinceCenterDepartment.NAME_PROPERTY)
		.field(ProvinceCenterDepartment.FOUNDED_PROPERTY)
		.field(ProvinceCenterDepartment.MANAGER_PROPERTY)
		;
	/** 用于ProvinceCenterDepartment的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getProvinceCenterDepartmentSummaryScope() {
		return ProvinceCenterDepartmentBaseSummaryScope;
	}

	protected static SerializeScope ProvinceCenterEmployeeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ProvinceCenterEmployee.ID_PROPERTY)
		.field(ProvinceCenterEmployee.NAME_PROPERTY)
		.field(ProvinceCenterEmployee.MOBILE_PROPERTY)
		.field(ProvinceCenterEmployee.EMAIL_PROPERTY)
		.field(ProvinceCenterEmployee.FOUNDED_PROPERTY)
		;
	/** 用于ProvinceCenterEmployee的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getProvinceCenterEmployeeSummaryScope() {
		return ProvinceCenterEmployeeBaseSummaryScope;
	}

	protected static SerializeScope RetailStoreCityServiceCenterBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreCityServiceCenter.ID_PROPERTY)
		.field(RetailStoreCityServiceCenter.NAME_PROPERTY)
		.field(RetailStoreCityServiceCenter.FOUNDED_PROPERTY)
		.field(RetailStoreCityServiceCenter.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于RetailStoreCityServiceCenter的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreCityServiceCenterSummaryScope() {
		return RetailStoreCityServiceCenterBaseSummaryScope;
	}

	protected static SerializeScope CityPartnerBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(CityPartner.ID_PROPERTY)
		.field(CityPartner.NAME_PROPERTY)
		.field(CityPartner.MOBILE_PROPERTY)
		.field(CityPartner.DESCRIPTION_PROPERTY)
		.field(CityPartner.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于CityPartner的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCityPartnerSummaryScope() {
		return CityPartnerBaseSummaryScope;
	}

	protected static SerializeScope PotentialCustomerBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomer.ID_PROPERTY)
		.field(PotentialCustomer.NAME_PROPERTY)
		.field(PotentialCustomer.MOBILE_PROPERTY)
		.field(PotentialCustomer.DESCRIPTION_PROPERTY)
		.field(PotentialCustomer.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于PotentialCustomer的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerSummaryScope() {
		return PotentialCustomerBaseSummaryScope;
	}

	protected static SerializeScope PotentialCustomerContactPersonBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomerContactPerson.ID_PROPERTY)
		.field(PotentialCustomerContactPerson.NAME_PROPERTY)
		.field(PotentialCustomerContactPerson.MOBILE_PROPERTY)
		.field(PotentialCustomerContactPerson.DESCRIPTION_PROPERTY)
		;
	/** 用于PotentialCustomerContactPerson的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerContactPersonSummaryScope() {
		return PotentialCustomerContactPersonBaseSummaryScope;
	}

	protected static SerializeScope PotentialCustomerContactBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomerContact.ID_PROPERTY)
		.field(PotentialCustomerContact.NAME_PROPERTY)
		.field(PotentialCustomerContact.CONTACT_DATE_PROPERTY)
		.field(PotentialCustomerContact.CONTACT_METHOD_PROPERTY)
		.field(PotentialCustomerContact.DESCRIPTION_PROPERTY)
		.field(PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于PotentialCustomerContact的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerContactSummaryScope() {
		return PotentialCustomerContactBaseSummaryScope;
	}

	protected static SerializeScope CityEventBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(CityEvent.ID_PROPERTY)
		.field(CityEvent.NAME_PROPERTY)
		.field(CityEvent.MOBILE_PROPERTY)
		.field(CityEvent.DESCRIPTION_PROPERTY)
		.field(CityEvent.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于CityEvent的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCityEventSummaryScope() {
		return CityEventBaseSummaryScope;
	}

	protected static SerializeScope EventAttendanceBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EventAttendance.ID_PROPERTY)
		.field(EventAttendance.NAME_PROPERTY)
		.field(EventAttendance.DESCRIPTION_PROPERTY)
		;
	/** 用于EventAttendance的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEventAttendanceSummaryScope() {
		return EventAttendanceBaseSummaryScope;
	}

	protected static SerializeScope RetailStoreBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStore.ID_PROPERTY)
		.field(RetailStore.NAME_PROPERTY)
		.field(RetailStore.TELEPHONE_PROPERTY)
		.field(RetailStore.OWNER_PROPERTY)
		.field(RetailStore.FOUNDED_PROPERTY)
		.field(RetailStore.LATITUDE_PROPERTY)
		.field(RetailStore.LONGITUDE_PROPERTY)
		.field(RetailStore.DESCRIPTION_PROPERTY)
		.field(RetailStore.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于RetailStore的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreSummaryScope() {
		return RetailStoreBaseSummaryScope;
	}

	protected static SerializeScope RetailStoreCreationBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreCreation.ID_PROPERTY)
		.field(RetailStoreCreation.COMMENT_PROPERTY)
		;
	/** 用于RetailStoreCreation的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreCreationSummaryScope() {
		return RetailStoreCreationBaseSummaryScope;
	}

	protected static SerializeScope RetailStoreInvestmentInvitationBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreInvestmentInvitation.ID_PROPERTY)
		.field(RetailStoreInvestmentInvitation.COMMENT_PROPERTY)
		;
	/** 用于RetailStoreInvestmentInvitation的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreInvestmentInvitationSummaryScope() {
		return RetailStoreInvestmentInvitationBaseSummaryScope;
	}

	protected static SerializeScope RetailStoreFranchisingBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreFranchising.ID_PROPERTY)
		.field(RetailStoreFranchising.COMMENT_PROPERTY)
		;
	/** 用于RetailStoreFranchising的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreFranchisingSummaryScope() {
		return RetailStoreFranchisingBaseSummaryScope;
	}

	protected static SerializeScope RetailStoreDecorationBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreDecoration.ID_PROPERTY)
		.field(RetailStoreDecoration.COMMENT_PROPERTY)
		;
	/** 用于RetailStoreDecoration的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreDecorationSummaryScope() {
		return RetailStoreDecorationBaseSummaryScope;
	}

	protected static SerializeScope RetailStoreOpeningBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreOpening.ID_PROPERTY)
		.field(RetailStoreOpening.COMMENT_PROPERTY)
		;
	/** 用于RetailStoreOpening的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreOpeningSummaryScope() {
		return RetailStoreOpeningBaseSummaryScope;
	}

	protected static SerializeScope RetailStoreClosingBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreClosing.ID_PROPERTY)
		.field(RetailStoreClosing.COMMENT_PROPERTY)
		;
	/** 用于RetailStoreClosing的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreClosingSummaryScope() {
		return RetailStoreClosingBaseSummaryScope;
	}

	protected static SerializeScope RetailStoreMemberBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreMember.ID_PROPERTY)
		.field(RetailStoreMember.NAME_PROPERTY)
		.field(RetailStoreMember.MOBILE_PHONE_PROPERTY)
		;
	/** 用于RetailStoreMember的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreMemberSummaryScope() {
		return RetailStoreMemberBaseSummaryScope;
	}

	protected static SerializeScope ConsumerOrderBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ConsumerOrder.ID_PROPERTY)
		.field(ConsumerOrder.TITLE_PROPERTY)
		.field(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于ConsumerOrder的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getConsumerOrderSummaryScope() {
		return ConsumerOrderBaseSummaryScope;
	}

	protected static SerializeScope ConsumerOrderLineItemBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ConsumerOrderLineItem.ID_PROPERTY)
		.field(ConsumerOrderLineItem.SKU_ID_PROPERTY)
		.field(ConsumerOrderLineItem.SKU_NAME_PROPERTY)
		.field(ConsumerOrderLineItem.PRICE_PROPERTY)
		.field(ConsumerOrderLineItem.QUANTITY_PROPERTY)
		.field(ConsumerOrderLineItem.AMOUNT_PROPERTY)
		.field(ConsumerOrderLineItem.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于ConsumerOrderLineItem的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getConsumerOrderLineItemSummaryScope() {
		return ConsumerOrderLineItemBaseSummaryScope;
	}

	protected static SerializeScope ConsumerOrderShippingGroupBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ConsumerOrderShippingGroup.ID_PROPERTY)
		.field(ConsumerOrderShippingGroup.NAME_PROPERTY)
		.field(ConsumerOrderShippingGroup.AMOUNT_PROPERTY)
		;
	/** 用于ConsumerOrderShippingGroup的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getConsumerOrderShippingGroupSummaryScope() {
		return ConsumerOrderShippingGroupBaseSummaryScope;
	}

	protected static SerializeScope ConsumerOrderPaymentGroupBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ConsumerOrderPaymentGroup.ID_PROPERTY)
		.field(ConsumerOrderPaymentGroup.NAME_PROPERTY)
		.field(ConsumerOrderPaymentGroup.CARD_NUMBER_PROPERTY)
		;
	/** 用于ConsumerOrderPaymentGroup的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getConsumerOrderPaymentGroupSummaryScope() {
		return ConsumerOrderPaymentGroupBaseSummaryScope;
	}

	protected static SerializeScope ConsumerOrderPriceAdjustmentBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ConsumerOrderPriceAdjustment.ID_PROPERTY)
		.field(ConsumerOrderPriceAdjustment.NAME_PROPERTY)
		.field(ConsumerOrderPriceAdjustment.AMOUNT_PROPERTY)
		.field(ConsumerOrderPriceAdjustment.PROVIDER_PROPERTY)
		;
	/** 用于ConsumerOrderPriceAdjustment的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getConsumerOrderPriceAdjustmentSummaryScope() {
		return ConsumerOrderPriceAdjustmentBaseSummaryScope;
	}

	protected static SerializeScope RetailStoreMemberCouponBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreMemberCoupon.ID_PROPERTY)
		.field(RetailStoreMemberCoupon.NAME_PROPERTY)
		.field(RetailStoreMemberCoupon.NUMBER_PROPERTY)
		.field(RetailStoreMemberCoupon.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于RetailStoreMemberCoupon的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreMemberCouponSummaryScope() {
		return RetailStoreMemberCouponBaseSummaryScope;
	}

	protected static SerializeScope MemberWishlistBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(MemberWishlist.ID_PROPERTY)
		.field(MemberWishlist.NAME_PROPERTY)
		;
	/** 用于MemberWishlist的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getMemberWishlistSummaryScope() {
		return MemberWishlistBaseSummaryScope;
	}

	protected static SerializeScope MemberRewardPointBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(MemberRewardPoint.ID_PROPERTY)
		.field(MemberRewardPoint.NAME_PROPERTY)
		.field(MemberRewardPoint.POINT_PROPERTY)
		;
	/** 用于MemberRewardPoint的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getMemberRewardPointSummaryScope() {
		return MemberRewardPointBaseSummaryScope;
	}

	protected static SerializeScope MemberRewardPointRedemptionBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(MemberRewardPointRedemption.ID_PROPERTY)
		.field(MemberRewardPointRedemption.NAME_PROPERTY)
		.field(MemberRewardPointRedemption.POINT_PROPERTY)
		;
	/** 用于MemberRewardPointRedemption的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getMemberRewardPointRedemptionSummaryScope() {
		return MemberRewardPointRedemptionBaseSummaryScope;
	}

	protected static SerializeScope MemberWishlistProductBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(MemberWishlistProduct.ID_PROPERTY)
		.field(MemberWishlistProduct.NAME_PROPERTY)
		;
	/** 用于MemberWishlistProduct的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getMemberWishlistProductSummaryScope() {
		return MemberWishlistProductBaseSummaryScope;
	}

	protected static SerializeScope RetailStoreMemberAddressBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreMemberAddress.ID_PROPERTY)
		.field(RetailStoreMemberAddress.NAME_PROPERTY)
		.field(RetailStoreMemberAddress.MOBILE_PHONE_PROPERTY)
		.field(RetailStoreMemberAddress.ADDRESS_PROPERTY)
		;
	/** 用于RetailStoreMemberAddress的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreMemberAddressSummaryScope() {
		return RetailStoreMemberAddressBaseSummaryScope;
	}

	protected static SerializeScope RetailStoreMemberGiftCardBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreMemberGiftCard.ID_PROPERTY)
		.field(RetailStoreMemberGiftCard.NAME_PROPERTY)
		.field(RetailStoreMemberGiftCard.NUMBER_PROPERTY)
		.field(RetailStoreMemberGiftCard.REMAIN_PROPERTY)
		;
	/** 用于RetailStoreMemberGiftCard的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreMemberGiftCardSummaryScope() {
		return RetailStoreMemberGiftCardBaseSummaryScope;
	}

	protected static SerializeScope RetailStoreMemberGiftCardConsumeRecordBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY)
		.field(RetailStoreMemberGiftCardConsumeRecord.OCCURE_TIME_PROPERTY)
		.field(RetailStoreMemberGiftCardConsumeRecord.NUMBER_PROPERTY)
		.field(RetailStoreMemberGiftCardConsumeRecord.AMOUNT_PROPERTY)
		;
	/** 用于RetailStoreMemberGiftCardConsumeRecord的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreMemberGiftCardConsumeRecordSummaryScope() {
		return RetailStoreMemberGiftCardConsumeRecordBaseSummaryScope;
	}

	protected static SerializeScope GoodsSupplierBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(GoodsSupplier.ID_PROPERTY)
		.field(GoodsSupplier.NAME_PROPERTY)
		.field(GoodsSupplier.SUPPLY_PRODUCT_PROPERTY)
		.field(GoodsSupplier.CONTACT_NUMBER_PROPERTY)
		.field(GoodsSupplier.DESCRIPTION_PROPERTY)
		.field(GoodsSupplier.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于GoodsSupplier的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGoodsSupplierSummaryScope() {
		return GoodsSupplierBaseSummaryScope;
	}

	protected static SerializeScope SupplierProductBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplierProduct.ID_PROPERTY)
		.field(SupplierProduct.PRODUCT_NAME_PROPERTY)
		.field(SupplierProduct.PRODUCT_DESCRIPTION_PROPERTY)
		.field(SupplierProduct.PRODUCT_UNIT_PROPERTY)
		;
	/** 用于SupplierProduct的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSupplierProductSummaryScope() {
		return SupplierProductBaseSummaryScope;
	}

	protected static SerializeScope ProductSupplyDurationBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ProductSupplyDuration.ID_PROPERTY)
		.field(ProductSupplyDuration.QUANTITY_PROPERTY)
		.field(ProductSupplyDuration.DURATION_PROPERTY)
		.field(ProductSupplyDuration.PRICE_PROPERTY)
		;
	/** 用于ProductSupplyDuration的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getProductSupplyDurationSummaryScope() {
		return ProductSupplyDurationBaseSummaryScope;
	}

	protected static SerializeScope SupplyOrderBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplyOrder.ID_PROPERTY)
		.field(SupplyOrder.TITLE_PROPERTY)
		.field(SupplyOrder.TOTAL_AMOUNT_PROPERTY)
		.field(SupplyOrder.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于SupplyOrder的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSupplyOrderSummaryScope() {
		return SupplyOrderBaseSummaryScope;
	}

	protected static SerializeScope SupplyOrderLineItemBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplyOrderLineItem.ID_PROPERTY)
		.field(SupplyOrderLineItem.SKU_ID_PROPERTY)
		.field(SupplyOrderLineItem.SKU_NAME_PROPERTY)
		.field(SupplyOrderLineItem.AMOUNT_PROPERTY)
		.field(SupplyOrderLineItem.QUANTITY_PROPERTY)
		.field(SupplyOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY)
		;
	/** 用于SupplyOrderLineItem的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSupplyOrderLineItemSummaryScope() {
		return SupplyOrderLineItemBaseSummaryScope;
	}

	protected static SerializeScope SupplyOrderShippingGroupBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplyOrderShippingGroup.ID_PROPERTY)
		.field(SupplyOrderShippingGroup.NAME_PROPERTY)
		.field(SupplyOrderShippingGroup.AMOUNT_PROPERTY)
		;
	/** 用于SupplyOrderShippingGroup的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSupplyOrderShippingGroupSummaryScope() {
		return SupplyOrderShippingGroupBaseSummaryScope;
	}

	protected static SerializeScope SupplyOrderPaymentGroupBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplyOrderPaymentGroup.ID_PROPERTY)
		.field(SupplyOrderPaymentGroup.NAME_PROPERTY)
		.field(SupplyOrderPaymentGroup.CARD_NUMBER_PROPERTY)
		;
	/** 用于SupplyOrderPaymentGroup的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSupplyOrderPaymentGroupSummaryScope() {
		return SupplyOrderPaymentGroupBaseSummaryScope;
	}

	protected static SerializeScope RetailStoreOrderBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreOrder.ID_PROPERTY)
		.field(RetailStoreOrder.TITLE_PROPERTY)
		.field(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY)
		.field(RetailStoreOrder.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于RetailStoreOrder的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreOrderSummaryScope() {
		return RetailStoreOrderBaseSummaryScope;
	}

	protected static SerializeScope RetailStoreOrderLineItemBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreOrderLineItem.ID_PROPERTY)
		.field(RetailStoreOrderLineItem.SKU_ID_PROPERTY)
		.field(RetailStoreOrderLineItem.SKU_NAME_PROPERTY)
		.field(RetailStoreOrderLineItem.AMOUNT_PROPERTY)
		.field(RetailStoreOrderLineItem.QUANTITY_PROPERTY)
		.field(RetailStoreOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY)
		;
	/** 用于RetailStoreOrderLineItem的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreOrderLineItemSummaryScope() {
		return RetailStoreOrderLineItemBaseSummaryScope;
	}

	protected static SerializeScope RetailStoreOrderShippingGroupBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreOrderShippingGroup.ID_PROPERTY)
		.field(RetailStoreOrderShippingGroup.NAME_PROPERTY)
		.field(RetailStoreOrderShippingGroup.AMOUNT_PROPERTY)
		;
	/** 用于RetailStoreOrderShippingGroup的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreOrderShippingGroupSummaryScope() {
		return RetailStoreOrderShippingGroupBaseSummaryScope;
	}

	protected static SerializeScope RetailStoreOrderPaymentGroupBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreOrderPaymentGroup.ID_PROPERTY)
		.field(RetailStoreOrderPaymentGroup.NAME_PROPERTY)
		.field(RetailStoreOrderPaymentGroup.CARD_NUMBER_PROPERTY)
		;
	/** 用于RetailStoreOrderPaymentGroup的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreOrderPaymentGroupSummaryScope() {
		return RetailStoreOrderPaymentGroupBaseSummaryScope;
	}

	protected static SerializeScope WarehouseBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Warehouse.ID_PROPERTY)
		.field(Warehouse.LOCATION_PROPERTY)
		.field(Warehouse.CONTACT_NUMBER_PROPERTY)
		.field(Warehouse.TOTAL_AREA_PROPERTY)
		.field(Warehouse.LATITUDE_PROPERTY)
		.field(Warehouse.LONGITUDE_PROPERTY)
		.field(Warehouse.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于Warehouse的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getWarehouseSummaryScope() {
		return WarehouseBaseSummaryScope;
	}

	protected static SerializeScope StorageSpaceBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(StorageSpace.ID_PROPERTY)
		.field(StorageSpace.LOCATION_PROPERTY)
		.field(StorageSpace.CONTACT_NUMBER_PROPERTY)
		.field(StorageSpace.TOTAL_AREA_PROPERTY)
		.field(StorageSpace.LATITUDE_PROPERTY)
		.field(StorageSpace.LONGITUDE_PROPERTY)
		.field(StorageSpace.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于StorageSpace的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getStorageSpaceSummaryScope() {
		return StorageSpaceBaseSummaryScope;
	}

	protected static SerializeScope SmartPalletBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SmartPallet.ID_PROPERTY)
		.field(SmartPallet.LOCATION_PROPERTY)
		.field(SmartPallet.CONTACT_NUMBER_PROPERTY)
		.field(SmartPallet.TOTAL_AREA_PROPERTY)
		.field(SmartPallet.LATITUDE_PROPERTY)
		.field(SmartPallet.LONGITUDE_PROPERTY)
		.field(SmartPallet.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于SmartPallet的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSmartPalletSummaryScope() {
		return SmartPalletBaseSummaryScope;
	}

	protected static SerializeScope GoodsShelfBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(GoodsShelf.ID_PROPERTY)
		.field(GoodsShelf.LOCATION_PROPERTY)
		.field(GoodsShelf.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于GoodsShelf的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGoodsShelfSummaryScope() {
		return GoodsShelfBaseSummaryScope;
	}

	protected static SerializeScope GoodsShelfStockCountBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(GoodsShelfStockCount.ID_PROPERTY)
		.field(GoodsShelfStockCount.TITLE_PROPERTY)
		.field(GoodsShelfStockCount.COUNT_TIME_PROPERTY)
		.field(GoodsShelfStockCount.SUMMARY_PROPERTY)
		;
	/** 用于GoodsShelfStockCount的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGoodsShelfStockCountSummaryScope() {
		return GoodsShelfStockCountBaseSummaryScope;
	}

	protected static SerializeScope StockCountIssueTrackBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(StockCountIssueTrack.ID_PROPERTY)
		.field(StockCountIssueTrack.TITLE_PROPERTY)
		.field(StockCountIssueTrack.COUNT_TIME_PROPERTY)
		.field(StockCountIssueTrack.SUMMARY_PROPERTY)
		;
	/** 用于StockCountIssueTrack的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getStockCountIssueTrackSummaryScope() {
		return StockCountIssueTrackBaseSummaryScope;
	}

	protected static SerializeScope GoodsAllocationBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(GoodsAllocation.ID_PROPERTY)
		.field(GoodsAllocation.LOCATION_PROPERTY)
		.field(GoodsAllocation.LATITUDE_PROPERTY)
		.field(GoodsAllocation.LONGITUDE_PROPERTY)
		;
	/** 用于GoodsAllocation的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGoodsAllocationSummaryScope() {
		return GoodsAllocationBaseSummaryScope;
	}

	protected static SerializeScope GoodsBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Goods.ID_PROPERTY)
		.field(Goods.NAME_PROPERTY)
		.field(Goods.RFID_PROPERTY)
		.field(Goods.UOM_PROPERTY)
		.field(Goods.MAX_PACKAGE_PROPERTY)
		.field(Goods.EXPIRE_TIME_PROPERTY)
		;
	/** 用于Goods的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGoodsSummaryScope() {
		return GoodsBaseSummaryScope;
	}

	protected static SerializeScope GoodsMovementBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(GoodsMovement.ID_PROPERTY)
		.field(GoodsMovement.MOVE_TIME_PROPERTY)
		.field(GoodsMovement.FACILITY_PROPERTY)
		.field(GoodsMovement.FACILITY_ID_PROPERTY)
		.field(GoodsMovement.FROM_IP_PROPERTY)
		.field(GoodsMovement.USER_AGENT_PROPERTY)
		.field(GoodsMovement.SESSION_ID_PROPERTY)
		.field(GoodsMovement.LATITUDE_PROPERTY)
		.field(GoodsMovement.LONGITUDE_PROPERTY)
		;
	/** 用于GoodsMovement的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGoodsMovementSummaryScope() {
		return GoodsMovementBaseSummaryScope;
	}

	protected static SerializeScope SupplierSpaceBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplierSpace.ID_PROPERTY)
		.field(SupplierSpace.LOCATION_PROPERTY)
		.field(SupplierSpace.CONTACT_NUMBER_PROPERTY)
		.field(SupplierSpace.TOTAL_AREA_PROPERTY)
		.field(SupplierSpace.LATITUDE_PROPERTY)
		.field(SupplierSpace.LONGITUDE_PROPERTY)
		.field(SupplierSpace.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于SupplierSpace的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSupplierSpaceSummaryScope() {
		return SupplierSpaceBaseSummaryScope;
	}

	protected static SerializeScope ReceivingSpaceBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ReceivingSpace.ID_PROPERTY)
		.field(ReceivingSpace.LOCATION_PROPERTY)
		.field(ReceivingSpace.CONTACT_NUMBER_PROPERTY)
		.field(ReceivingSpace.DESCRIPTION_PROPERTY)
		.field(ReceivingSpace.TOTAL_AREA_PROPERTY)
		.field(ReceivingSpace.LATITUDE_PROPERTY)
		.field(ReceivingSpace.LONGITUDE_PROPERTY)
		.field(ReceivingSpace.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于ReceivingSpace的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getReceivingSpaceSummaryScope() {
		return ReceivingSpaceBaseSummaryScope;
	}

	protected static SerializeScope ShippingSpaceBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ShippingSpace.ID_PROPERTY)
		.field(ShippingSpace.LOCATION_PROPERTY)
		.field(ShippingSpace.CONTACT_NUMBER_PROPERTY)
		.field(ShippingSpace.TOTAL_AREA_PROPERTY)
		.field(ShippingSpace.LATITUDE_PROPERTY)
		.field(ShippingSpace.LONGITUDE_PROPERTY)
		.field(ShippingSpace.DESCRIPTION_PROPERTY)
		.field(ShippingSpace.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于ShippingSpace的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getShippingSpaceSummaryScope() {
		return ShippingSpaceBaseSummaryScope;
	}

	protected static SerializeScope DamageSpaceBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(DamageSpace.ID_PROPERTY)
		.field(DamageSpace.LOCATION_PROPERTY)
		.field(DamageSpace.CONTACT_NUMBER_PROPERTY)
		.field(DamageSpace.TOTAL_AREA_PROPERTY)
		.field(DamageSpace.LATITUDE_PROPERTY)
		.field(DamageSpace.LONGITUDE_PROPERTY)
		.field(DamageSpace.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于DamageSpace的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getDamageSpaceSummaryScope() {
		return DamageSpaceBaseSummaryScope;
	}

	protected static SerializeScope WarehouseAssetBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(WarehouseAsset.ID_PROPERTY)
		.field(WarehouseAsset.NAME_PROPERTY)
		.field(WarehouseAsset.POSITION_PROPERTY)
		.field(WarehouseAsset.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于WarehouseAsset的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getWarehouseAssetSummaryScope() {
		return WarehouseAssetBaseSummaryScope;
	}

	protected static SerializeScope TransportFleetBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TransportFleet.ID_PROPERTY)
		.field(TransportFleet.NAME_PROPERTY)
		.field(TransportFleet.CONTACT_NUMBER_PROPERTY)
		.field(TransportFleet.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于TransportFleet的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTransportFleetSummaryScope() {
		return TransportFleetBaseSummaryScope;
	}

	protected static SerializeScope TransportTruckBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TransportTruck.ID_PROPERTY)
		.field(TransportTruck.NAME_PROPERTY)
		.field(TransportTruck.PLATE_NUMBER_PROPERTY)
		.field(TransportTruck.CONTACT_NUMBER_PROPERTY)
		.field(TransportTruck.VEHICLE_LICENSE_NUMBER_PROPERTY)
		.field(TransportTruck.ENGINE_NUMBER_PROPERTY)
		.field(TransportTruck.MAKE_DATE_PROPERTY)
		.field(TransportTruck.MILEAGE_PROPERTY)
		.field(TransportTruck.BODY_COLOR_PROPERTY)
		;
	/** 用于TransportTruck的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTransportTruckSummaryScope() {
		return TransportTruckBaseSummaryScope;
	}

	protected static SerializeScope TruckDriverBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TruckDriver.ID_PROPERTY)
		.field(TruckDriver.NAME_PROPERTY)
		.field(TruckDriver.DRIVER_LICENSE_NUMBER_PROPERTY)
		.field(TruckDriver.CONTACT_NUMBER_PROPERTY)
		;
	/** 用于TruckDriver的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTruckDriverSummaryScope() {
		return TruckDriverBaseSummaryScope;
	}

	protected static SerializeScope TransportTaskBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TransportTask.ID_PROPERTY)
		.field(TransportTask.NAME_PROPERTY)
		.field(TransportTask.START_PROPERTY)
		.field(TransportTask.BEGIN_TIME_PROPERTY)
		.field(TransportTask.LATITUDE_PROPERTY)
		.field(TransportTask.LONGITUDE_PROPERTY)
		;
	/** 用于TransportTask的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTransportTaskSummaryScope() {
		return TransportTaskBaseSummaryScope;
	}

	protected static SerializeScope TransportTaskTrackBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TransportTaskTrack.ID_PROPERTY)
		.field(TransportTaskTrack.TRACK_TIME_PROPERTY)
		.field(TransportTaskTrack.LATITUDE_PROPERTY)
		.field(TransportTaskTrack.LONGITUDE_PROPERTY)
		;
	/** 用于TransportTaskTrack的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTransportTaskTrackSummaryScope() {
		return TransportTaskTrackBaseSummaryScope;
	}

	protected static SerializeScope AccountSetBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountSet.ID_PROPERTY)
		.field(AccountSet.NAME_PROPERTY)
		.field(AccountSet.YEAR_SET_PROPERTY)
		.field(AccountSet.EFFECTIVE_DATE_PROPERTY)
		.field(AccountSet.ACCOUNTING_SYSTEM_PROPERTY)
		.field(AccountSet.DOMESTIC_CURRENCY_CODE_PROPERTY)
		.field(AccountSet.DOMESTIC_CURRENCY_NAME_PROPERTY)
		.field(AccountSet.OPENING_BANK_PROPERTY)
		.field(AccountSet.ACCOUNT_NUMBER_PROPERTY)
		.field(AccountSet.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于AccountSet的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getAccountSetSummaryScope() {
		return AccountSetBaseSummaryScope;
	}

	protected static SerializeScope AccountingSubjectBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountingSubject.ID_PROPERTY)
		.field(AccountingSubject.ACCOUNTING_SUBJECT_CODE_PROPERTY)
		.field(AccountingSubject.ACCOUNTING_SUBJECT_NAME_PROPERTY)
		.field(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY)
		.field(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY)
		;
	/** 用于AccountingSubject的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getAccountingSubjectSummaryScope() {
		return AccountingSubjectBaseSummaryScope;
	}

	protected static SerializeScope AccountingPeriodBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountingPeriod.ID_PROPERTY)
		.field(AccountingPeriod.NAME_PROPERTY)
		.field(AccountingPeriod.START_DATE_PROPERTY)
		.field(AccountingPeriod.END_DATE_PROPERTY)
		;
	/** 用于AccountingPeriod的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getAccountingPeriodSummaryScope() {
		return AccountingPeriodBaseSummaryScope;
	}

	protected static SerializeScope AccountingDocumentTypeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountingDocumentType.ID_PROPERTY)
		.field(AccountingDocumentType.NAME_PROPERTY)
		.field(AccountingDocumentType.DESCRIPTION_PROPERTY)
		;
	/** 用于AccountingDocumentType的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getAccountingDocumentTypeSummaryScope() {
		return AccountingDocumentTypeBaseSummaryScope;
	}

	protected static SerializeScope AccountingDocumentBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountingDocument.ID_PROPERTY)
		.field(AccountingDocument.NAME_PROPERTY)
		.field(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY)
		;
	/** 用于AccountingDocument的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getAccountingDocumentSummaryScope() {
		return AccountingDocumentBaseSummaryScope;
	}

	protected static SerializeScope OriginalVoucherBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(OriginalVoucher.ID_PROPERTY)
		.field(OriginalVoucher.TITLE_PROPERTY)
		.field(OriginalVoucher.MADE_BY_PROPERTY)
		.field(OriginalVoucher.RECEIVED_BY_PROPERTY)
		.field(OriginalVoucher.VOUCHER_TYPE_PROPERTY)
		.field(OriginalVoucher.VOUCHER_IMAGE_PROPERTY)
		;
	/** 用于OriginalVoucher的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getOriginalVoucherSummaryScope() {
		return OriginalVoucherBaseSummaryScope;
	}

	protected static SerializeScope AccountingDocumentLineBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountingDocumentLine.ID_PROPERTY)
		.field(AccountingDocumentLine.NAME_PROPERTY)
		.field(AccountingDocumentLine.CODE_PROPERTY)
		.field(AccountingDocumentLine.DIRECT_PROPERTY)
		.field(AccountingDocumentLine.AMOUNT_PROPERTY)
		;
	/** 用于AccountingDocumentLine的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getAccountingDocumentLineSummaryScope() {
		return AccountingDocumentLineBaseSummaryScope;
	}

	protected static SerializeScope LevelOneDepartmentBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelOneDepartment.ID_PROPERTY)
		.field(LevelOneDepartment.NAME_PROPERTY)
		.field(LevelOneDepartment.DESCRIPTION_PROPERTY)
		.field(LevelOneDepartment.MANAGER_PROPERTY)
		.field(LevelOneDepartment.FOUNDED_PROPERTY)
		;
	/** 用于LevelOneDepartment的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLevelOneDepartmentSummaryScope() {
		return LevelOneDepartmentBaseSummaryScope;
	}

	protected static SerializeScope LevelTwoDepartmentBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelTwoDepartment.ID_PROPERTY)
		.field(LevelTwoDepartment.NAME_PROPERTY)
		.field(LevelTwoDepartment.DESCRIPTION_PROPERTY)
		.field(LevelTwoDepartment.FOUNDED_PROPERTY)
		;
	/** 用于LevelTwoDepartment的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLevelTwoDepartmentSummaryScope() {
		return LevelTwoDepartmentBaseSummaryScope;
	}

	protected static SerializeScope LevelThreeDepartmentBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelThreeDepartment.ID_PROPERTY)
		.field(LevelThreeDepartment.NAME_PROPERTY)
		.field(LevelThreeDepartment.DESCRIPTION_PROPERTY)
		.field(LevelThreeDepartment.FOUNDED_PROPERTY)
		;
	/** 用于LevelThreeDepartment的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLevelThreeDepartmentSummaryScope() {
		return LevelThreeDepartmentBaseSummaryScope;
	}

	protected static SerializeScope SkillTypeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SkillType.ID_PROPERTY)
		.field(SkillType.CODE_PROPERTY)
		.field(SkillType.DESCRIPTION_PROPERTY)
		;
	/** 用于SkillType的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSkillTypeSummaryScope() {
		return SkillTypeBaseSummaryScope;
	}

	protected static SerializeScope ResponsibilityTypeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ResponsibilityType.ID_PROPERTY)
		.field(ResponsibilityType.CODE_PROPERTY)
		.field(ResponsibilityType.BASE_DESCRIPTION_PROPERTY)
		.field(ResponsibilityType.DETAIL_DESCRIPTION_PROPERTY)
		;
	/** 用于ResponsibilityType的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getResponsibilityTypeSummaryScope() {
		return ResponsibilityTypeBaseSummaryScope;
	}

	protected static SerializeScope TerminationReasonBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TerminationReason.ID_PROPERTY)
		.field(TerminationReason.CODE_PROPERTY)
		.field(TerminationReason.DESCRIPTION_PROPERTY)
		;
	/** 用于TerminationReason的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTerminationReasonSummaryScope() {
		return TerminationReasonBaseSummaryScope;
	}

	protected static SerializeScope TerminationTypeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TerminationType.ID_PROPERTY)
		.field(TerminationType.CODE_PROPERTY)
		.field(TerminationType.BASE_DESCRIPTION_PROPERTY)
		.field(TerminationType.DETAIL_DESCRIPTION_PROPERTY)
		;
	/** 用于TerminationType的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTerminationTypeSummaryScope() {
		return TerminationTypeBaseSummaryScope;
	}

	protected static SerializeScope OccupationTypeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(OccupationType.ID_PROPERTY)
		.field(OccupationType.CODE_PROPERTY)
		.field(OccupationType.DESCRIPTION_PROPERTY)
		.field(OccupationType.DETAIL_DESCRIPTION_PROPERTY)
		;
	/** 用于OccupationType的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getOccupationTypeSummaryScope() {
		return OccupationTypeBaseSummaryScope;
	}

	protected static SerializeScope LeaveTypeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LeaveType.ID_PROPERTY)
		.field(LeaveType.CODE_PROPERTY)
		.field(LeaveType.DESCRIPTION_PROPERTY)
		.field(LeaveType.DETAIL_DESCRIPTION_PROPERTY)
		;
	/** 用于LeaveType的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLeaveTypeSummaryScope() {
		return LeaveTypeBaseSummaryScope;
	}

	protected static SerializeScope SalaryGradeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SalaryGrade.ID_PROPERTY)
		.field(SalaryGrade.CODE_PROPERTY)
		.field(SalaryGrade.NAME_PROPERTY)
		.field(SalaryGrade.DETAIL_DESCRIPTION_PROPERTY)
		;
	/** 用于SalaryGrade的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSalaryGradeSummaryScope() {
		return SalaryGradeBaseSummaryScope;
	}

	protected static SerializeScope InterviewTypeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(InterviewType.ID_PROPERTY)
		.field(InterviewType.CODE_PROPERTY)
		.field(InterviewType.DESCRIPTION_PROPERTY)
		.field(InterviewType.DETAIL_DESCRIPTION_PROPERTY)
		;
	/** 用于InterviewType的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getInterviewTypeSummaryScope() {
		return InterviewTypeBaseSummaryScope;
	}

	protected static SerializeScope TrainingCourseTypeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TrainingCourseType.ID_PROPERTY)
		.field(TrainingCourseType.CODE_PROPERTY)
		.field(TrainingCourseType.NAME_PROPERTY)
		.field(TrainingCourseType.DESCRIPTION_PROPERTY)
		;
	/** 用于TrainingCourseType的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTrainingCourseTypeSummaryScope() {
		return TrainingCourseTypeBaseSummaryScope;
	}

	protected static SerializeScope PublicHolidayBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PublicHoliday.ID_PROPERTY)
		.field(PublicHoliday.CODE_PROPERTY)
		.field(PublicHoliday.NAME_PROPERTY)
		.field(PublicHoliday.DESCRIPTION_PROPERTY)
		;
	/** 用于PublicHoliday的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPublicHolidaySummaryScope() {
		return PublicHolidayBaseSummaryScope;
	}

	protected static SerializeScope TerminationBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Termination.ID_PROPERTY)
		.field(Termination.COMMENT_PROPERTY)
		;
	/** 用于Termination的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTerminationSummaryScope() {
		return TerminationBaseSummaryScope;
	}

	protected static SerializeScope ViewBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(View.ID_PROPERTY)
		.field(View.WHO_PROPERTY)
		.field(View.ASSESSMENT_PROPERTY)
		.field(View.INTERVIEW_TIME_PROPERTY)
		;
	/** 用于View的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getViewSummaryScope() {
		return ViewBaseSummaryScope;
	}

	protected static SerializeScope EmployeeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Employee.ID_PROPERTY)
		.field(Employee.TITLE_PROPERTY)
		.field(Employee.FAMILY_NAME_PROPERTY)
		.field(Employee.GIVEN_NAME_PROPERTY)
		.field(Employee.EMAIL_PROPERTY)
		.field(Employee.CITY_PROPERTY)
		.field(Employee.ADDRESS_PROPERTY)
		.field(Employee.CELL_PHONE_PROPERTY)
		.field(Employee.SALARY_ACCOUNT_PROPERTY)
		.field(Employee.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于Employee的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeSummaryScope() {
		return EmployeeBaseSummaryScope;
	}

	protected static SerializeScope InstructorBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Instructor.ID_PROPERTY)
		.field(Instructor.TITLE_PROPERTY)
		.field(Instructor.FAMILY_NAME_PROPERTY)
		.field(Instructor.GIVEN_NAME_PROPERTY)
		.field(Instructor.CELL_PHONE_PROPERTY)
		.field(Instructor.EMAIL_PROPERTY)
		.field(Instructor.INTRODUCTION_PROPERTY)
		.field(Instructor.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于Instructor的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getInstructorSummaryScope() {
		return InstructorBaseSummaryScope;
	}

	protected static SerializeScope CompanyTrainingBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(CompanyTraining.ID_PROPERTY)
		.field(CompanyTraining.TITLE_PROPERTY)
		.field(CompanyTraining.TIME_START_PROPERTY)
		.field(CompanyTraining.DURATION_HOURS_PROPERTY)
		.field(CompanyTraining.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于CompanyTraining的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCompanyTrainingSummaryScope() {
		return CompanyTrainingBaseSummaryScope;
	}

	protected static SerializeScope ScoringBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Scoring.ID_PROPERTY)
		.field(Scoring.SCORED_BY_PROPERTY)
		.field(Scoring.SCORE_PROPERTY)
		.field(Scoring.COMMENT_PROPERTY)
		;
	/** 用于Scoring的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getScoringSummaryScope() {
		return ScoringBaseSummaryScope;
	}

	protected static SerializeScope EmployeeCompanyTrainingBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeCompanyTraining.ID_PROPERTY)
		;
	/** 用于EmployeeCompanyTraining的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeCompanyTrainingSummaryScope() {
		return EmployeeCompanyTrainingBaseSummaryScope;
	}

	protected static SerializeScope EmployeeSkillBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeSkill.ID_PROPERTY)
		.field(EmployeeSkill.DESCRIPTION_PROPERTY)
		;
	/** 用于EmployeeSkill的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeSkillSummaryScope() {
		return EmployeeSkillBaseSummaryScope;
	}

	protected static SerializeScope EmployeePerformanceBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeePerformance.ID_PROPERTY)
		.field(EmployeePerformance.PERFORMANCE_COMMENT_PROPERTY)
		;
	/** 用于EmployeePerformance的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeePerformanceSummaryScope() {
		return EmployeePerformanceBaseSummaryScope;
	}

	protected static SerializeScope EmployeeWorkExperienceBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeWorkExperience.ID_PROPERTY)
		.field(EmployeeWorkExperience.START_PROPERTY)
		.field(EmployeeWorkExperience.END_PROPERTY)
		.field(EmployeeWorkExperience.COMPANY_PROPERTY)
		.field(EmployeeWorkExperience.DESCRIPTION_PROPERTY)
		;
	/** 用于EmployeeWorkExperience的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeWorkExperienceSummaryScope() {
		return EmployeeWorkExperienceBaseSummaryScope;
	}

	protected static SerializeScope EmployeeLeaveBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeLeave.ID_PROPERTY)
		.field(EmployeeLeave.LEAVE_DURATION_HOUR_PROPERTY)
		.field(EmployeeLeave.REMARK_PROPERTY)
		;
	/** 用于EmployeeLeave的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeLeaveSummaryScope() {
		return EmployeeLeaveBaseSummaryScope;
	}

	protected static SerializeScope EmployeeInterviewBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeInterview.ID_PROPERTY)
		.field(EmployeeInterview.REMARK_PROPERTY)
		;
	/** 用于EmployeeInterview的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeInterviewSummaryScope() {
		return EmployeeInterviewBaseSummaryScope;
	}

	protected static SerializeScope EmployeeAttendanceBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeAttendance.ID_PROPERTY)
		.field(EmployeeAttendance.ENTER_TIME_PROPERTY)
		.field(EmployeeAttendance.LEAVE_TIME_PROPERTY)
		.field(EmployeeAttendance.DURATION_HOURS_PROPERTY)
		.field(EmployeeAttendance.REMARK_PROPERTY)
		;
	/** 用于EmployeeAttendance的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeAttendanceSummaryScope() {
		return EmployeeAttendanceBaseSummaryScope;
	}

	protected static SerializeScope EmployeeQualifierBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeQualifier.ID_PROPERTY)
		.field(EmployeeQualifier.QUALIFIED_TIME_PROPERTY)
		.field(EmployeeQualifier.TYPE_PROPERTY)
		.field(EmployeeQualifier.LEVEL_PROPERTY)
		.field(EmployeeQualifier.REMARK_PROPERTY)
		;
	/** 用于EmployeeQualifier的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeQualifierSummaryScope() {
		return EmployeeQualifierBaseSummaryScope;
	}

	protected static SerializeScope EmployeeEducationBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeEducation.ID_PROPERTY)
		.field(EmployeeEducation.COMPLETE_TIME_PROPERTY)
		.field(EmployeeEducation.TYPE_PROPERTY)
		.field(EmployeeEducation.REMARK_PROPERTY)
		;
	/** 用于EmployeeEducation的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeEducationSummaryScope() {
		return EmployeeEducationBaseSummaryScope;
	}

	protected static SerializeScope EmployeeAwardBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeAward.ID_PROPERTY)
		.field(EmployeeAward.COMPLETE_TIME_PROPERTY)
		.field(EmployeeAward.TYPE_PROPERTY)
		.field(EmployeeAward.REMARK_PROPERTY)
		;
	/** 用于EmployeeAward的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeAwardSummaryScope() {
		return EmployeeAwardBaseSummaryScope;
	}

	protected static SerializeScope EmployeeSalarySheetBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeSalarySheet.ID_PROPERTY)
		.field(EmployeeSalarySheet.BASE_SALARY_PROPERTY)
		.field(EmployeeSalarySheet.BONUS_PROPERTY)
		.field(EmployeeSalarySheet.REWARD_PROPERTY)
		.field(EmployeeSalarySheet.PERSONAL_TAX_PROPERTY)
		.field(EmployeeSalarySheet.SOCIAL_SECURITY_PROPERTY)
		.field(EmployeeSalarySheet.HOUSING_FOUND_PROPERTY)
		.field(EmployeeSalarySheet.JOB_INSURANCE_PROPERTY)
		;
	/** 用于EmployeeSalarySheet的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeSalarySheetSummaryScope() {
		return EmployeeSalarySheetBaseSummaryScope;
	}

	protected static SerializeScope PayingOffBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PayingOff.ID_PROPERTY)
		.field(PayingOff.WHO_PROPERTY)
		.field(PayingOff.PAID_TIME_PROPERTY)
		.field(PayingOff.AMOUNT_PROPERTY)
		;
	/** 用于PayingOff的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPayingOffSummaryScope() {
		return PayingOffBaseSummaryScope;
	}

	protected static SerializeScope MobileAppBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(MobileApp.ID_PROPERTY)
		.field(MobileApp.NAME_PROPERTY)
		;
	/** 用于MobileApp的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getMobileAppSummaryScope() {
		return MobileAppBaseSummaryScope;
	}

	protected static SerializeScope PageBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Page.ID_PROPERTY)
		.field(Page.PAGE_TITLE_PROPERTY)
		.field(Page.LINK_TO_URL_PROPERTY)
		.field(Page.DISPLAY_ORDER_PROPERTY)
		;
	/** 用于Page的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPageSummaryScope() {
		return PageBaseSummaryScope;
	}

	protected static SerializeScope PageTypeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PageType.ID_PROPERTY)
		.field(PageType.NAME_PROPERTY)
		.field(PageType.CODE_PROPERTY)
		.field(PageType.FOOTER_TAB_PROPERTY)
		;
	/** 用于PageType的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPageTypeSummaryScope() {
		return PageTypeBaseSummaryScope;
	}

	protected static SerializeScope SlideBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Slide.ID_PROPERTY)
		.field(Slide.NAME_PROPERTY)
		.field(Slide.DISPLAY_ORDER_PROPERTY)
		.field(Slide.IMAGE_URL_PROPERTY)
		.field(Slide.VIDEO_URL_PROPERTY)
		.field(Slide.LINK_TO_URL_PROPERTY)
		;
	/** 用于Slide的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSlideSummaryScope() {
		return SlideBaseSummaryScope;
	}

	protected static SerializeScope UiActionBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(UiAction.ID_PROPERTY)
		.field(UiAction.CODE_PROPERTY)
		.field(UiAction.ICON_PROPERTY)
		.field(UiAction.TITLE_PROPERTY)
		.field(UiAction.DISPLAY_ORDER_PROPERTY)
		.field(UiAction.BRIEF_PROPERTY)
		.field(UiAction.IMAGE_URL_PROPERTY)
		.field(UiAction.LINK_TO_URL_PROPERTY)
		.field(UiAction.EXTRA_DATA_PROPERTY)
		;
	/** 用于UiAction的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUiActionSummaryScope() {
		return UiActionBaseSummaryScope;
	}

	protected static SerializeScope SectionBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Section.ID_PROPERTY)
		.field(Section.TITLE_PROPERTY)
		.field(Section.BRIEF_PROPERTY)
		.field(Section.ICON_PROPERTY)
		.field(Section.DISPLAY_ORDER_PROPERTY)
		.field(Section.VIEW_GROUP_PROPERTY)
		.field(Section.LINK_TO_URL_PROPERTY)
		;
	/** 用于Section的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSectionSummaryScope() {
		return SectionBaseSummaryScope;
	}

	protected static SerializeScope UserDomainBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		;
	/** 用于UserDomain的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserDomainSummaryScope() {
		return UserDomainBaseSummaryScope;
	}

	protected static SerializeScope UserWhiteListBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		;
	/** 用于UserWhiteList的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListSummaryScope() {
		return UserWhiteListBaseSummaryScope;
	}

	protected static SerializeScope SecUserBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SecUser.ID_PROPERTY)
		.field(SecUser.LOGIN_PROPERTY)
		.field(SecUser.MOBILE_PROPERTY)
		.field(SecUser.EMAIL_PROPERTY)
		.field(SecUser.PWD_PROPERTY)
		.field(SecUser.WEIXIN_OPENID_PROPERTY)
		.field(SecUser.WEIXIN_APPID_PROPERTY)
		.field(SecUser.ACCESS_TOKEN_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
		.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于SecUser的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSecUserSummaryScope() {
		return SecUserBaseSummaryScope;
	}

	protected static SerializeScope UserAppBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		;
	/** 用于UserApp的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserAppSummaryScope() {
		return UserAppBaseSummaryScope;
	}

	protected static SerializeScope QuickLinkBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		;
	/** 用于QuickLink的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkSummaryScope() {
		return QuickLinkBaseSummaryScope;
	}

	protected static SerializeScope ListAccessBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		;
	/** 用于ListAccess的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getListAccessSummaryScope() {
		return ListAccessBaseSummaryScope;
	}

	protected static SerializeScope LoginHistoryBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		;
	/** 用于LoginHistory的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLoginHistorySummaryScope() {
		return LoginHistoryBaseSummaryScope;
	}

	protected static SerializeScope CandidateContainerBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		;
	/** 用于CandidateContainer的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerSummaryScope() {
		return CandidateContainerBaseSummaryScope;
	}

	protected static SerializeScope CandidateElementBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		;
	/** 用于CandidateElement的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementSummaryScope() {
		return CandidateElementBaseSummaryScope;
	}

	protected static SerializeScope WechatWorkappIdentifyBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(WechatWorkappIdentify.ID_PROPERTY)
		.field(WechatWorkappIdentify.CORP_ID_PROPERTY)
		.field(WechatWorkappIdentify.USER_ID_PROPERTY)
		.field(WechatWorkappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatWorkappIdentify的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getWechatWorkappIdentifySummaryScope() {
		return WechatWorkappIdentifyBaseSummaryScope;
	}

	protected static SerializeScope WechatMiniappIdentifyBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(WechatMiniappIdentify.ID_PROPERTY)
		.field(WechatMiniappIdentify.OPEN_ID_PROPERTY)
		.field(WechatMiniappIdentify.APP_ID_PROPERTY)
		.field(WechatMiniappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatMiniappIdentify的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getWechatMiniappIdentifySummaryScope() {
		return WechatMiniappIdentifyBaseSummaryScope;
	}

	protected static SerializeScope KeypairIdentifyBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(KeypairIdentify.ID_PROPERTY)
		.field(KeypairIdentify.PUBLIC_KEY_PROPERTY)
		.field(KeypairIdentify.CREATE_TIME_PROPERTY)
		;
	/** 用于KeypairIdentify的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getKeypairIdentifySummaryScope() {
		return KeypairIdentifyBaseSummaryScope;
	}

	protected static SerializeScope PublicKeyTypeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PublicKeyType.ID_PROPERTY)
		.field(PublicKeyType.NAME_PROPERTY)
		.field(PublicKeyType.CODE_PROPERTY)
		;
	/** 用于PublicKeyType的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPublicKeyTypeSummaryScope() {
		return PublicKeyTypeBaseSummaryScope;
	}

	protected static SerializeScope TreeNodeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TreeNode.ID_PROPERTY)
		.field(TreeNode.NODE_ID_PROPERTY)
		.field(TreeNode.NODE_TYPE_PROPERTY)
		.field(TreeNode.LEFT_VALUE_PROPERTY)
		.field(TreeNode.RIGHT_VALUE_PROPERTY)
		;
	/** 用于TreeNode的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTreeNodeSummaryScope() {
		return TreeNodeBaseSummaryScope;
	}

	protected static SerializeScope RetailStoreCountryCenterBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreCountryCenter.ID_PROPERTY)
		.field(RetailStoreCountryCenter.NAME_PROPERTY)
		.field(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY)
		.field(RetailStoreCountryCenter.FOUNDED_PROPERTY)
		.field(RetailStoreCountryCenter.WEB_SITE_PROPERTY)
		.field(RetailStoreCountryCenter.ADDRESS_PROPERTY)
		.field(RetailStoreCountryCenter.OPERATED_BY_PROPERTY)
		.field(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY)
		.field(RetailStoreCountryCenter.DESCRIPTION_PROPERTY)
		;
	/** 用于RetailStoreCountryCenter的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreCountryCenterSecondaryListItemScope() {
		return RetailStoreCountryCenterBaseSecondaryListItemScope;
	}

	protected static SerializeScope CatalogBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Catalog.ID_PROPERTY)
		.field(Catalog.NAME_PROPERTY)
		.field(Catalog.SUB_COUNT_PROPERTY)
		.field(Catalog.AMOUNT_PROPERTY)
		;
	/** 用于Catalog的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCatalogSecondaryListItemScope() {
		return CatalogBaseSecondaryListItemScope;
	}

	protected static SerializeScope LevelOneCategoryBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelOneCategory.ID_PROPERTY)
		.field(LevelOneCategory.NAME_PROPERTY)
		;
	/** 用于LevelOneCategory的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLevelOneCategorySecondaryListItemScope() {
		return LevelOneCategoryBaseSecondaryListItemScope;
	}

	protected static SerializeScope LevelTwoCategoryBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelTwoCategory.ID_PROPERTY)
		.field(LevelTwoCategory.NAME_PROPERTY)
		;
	/** 用于LevelTwoCategory的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLevelTwoCategorySecondaryListItemScope() {
		return LevelTwoCategoryBaseSecondaryListItemScope;
	}

	protected static SerializeScope LevelThreeCategoryBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelThreeCategory.ID_PROPERTY)
		.field(LevelThreeCategory.NAME_PROPERTY)
		;
	/** 用于LevelThreeCategory的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLevelThreeCategorySecondaryListItemScope() {
		return LevelThreeCategoryBaseSecondaryListItemScope;
	}

	protected static SerializeScope ProductBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Product.ID_PROPERTY)
		.field(Product.NAME_PROPERTY)
		.field(Product.ORIGIN_PROPERTY)
		.field(Product.REMARK_PROPERTY)
		.field(Product.BRAND_PROPERTY)
		.field(Product.PICTURE_PROPERTY)
		.field(Product.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于Product的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getProductSecondaryListItemScope() {
		return ProductBaseSecondaryListItemScope;
	}

	protected static SerializeScope SkuBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Sku.ID_PROPERTY)
		.field(Sku.NAME_PROPERTY)
		.field(Sku.SIZE_PROPERTY)
		.field(Sku.BARCODE_PROPERTY)
		.field(Sku.PACKAGE_TYPE_PROPERTY)
		.field(Sku.NET_CONTENT_PROPERTY)
		.field(Sku.PRICE_PROPERTY)
		.field(Sku.PICTURE_PROPERTY)
		;
	/** 用于Sku的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSkuSecondaryListItemScope() {
		return SkuBaseSecondaryListItemScope;
	}

	protected static SerializeScope RetailStoreProvinceCenterBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreProvinceCenter.ID_PROPERTY)
		.field(RetailStoreProvinceCenter.NAME_PROPERTY)
		.field(RetailStoreProvinceCenter.FOUNDED_PROPERTY)
		.field(RetailStoreProvinceCenter.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于RetailStoreProvinceCenter的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreProvinceCenterSecondaryListItemScope() {
		return RetailStoreProvinceCenterBaseSecondaryListItemScope;
	}

	protected static SerializeScope ProvinceCenterDepartmentBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ProvinceCenterDepartment.ID_PROPERTY)
		.field(ProvinceCenterDepartment.NAME_PROPERTY)
		.field(ProvinceCenterDepartment.FOUNDED_PROPERTY)
		.field(ProvinceCenterDepartment.MANAGER_PROPERTY)
		;
	/** 用于ProvinceCenterDepartment的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getProvinceCenterDepartmentSecondaryListItemScope() {
		return ProvinceCenterDepartmentBaseSecondaryListItemScope;
	}

	protected static SerializeScope ProvinceCenterEmployeeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ProvinceCenterEmployee.ID_PROPERTY)
		.field(ProvinceCenterEmployee.NAME_PROPERTY)
		.field(ProvinceCenterEmployee.MOBILE_PROPERTY)
		.field(ProvinceCenterEmployee.EMAIL_PROPERTY)
		.field(ProvinceCenterEmployee.FOUNDED_PROPERTY)
		;
	/** 用于ProvinceCenterEmployee的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getProvinceCenterEmployeeSecondaryListItemScope() {
		return ProvinceCenterEmployeeBaseSecondaryListItemScope;
	}

	protected static SerializeScope RetailStoreCityServiceCenterBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreCityServiceCenter.ID_PROPERTY)
		.field(RetailStoreCityServiceCenter.NAME_PROPERTY)
		.field(RetailStoreCityServiceCenter.FOUNDED_PROPERTY)
		.field(RetailStoreCityServiceCenter.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于RetailStoreCityServiceCenter的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreCityServiceCenterSecondaryListItemScope() {
		return RetailStoreCityServiceCenterBaseSecondaryListItemScope;
	}

	protected static SerializeScope CityPartnerBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(CityPartner.ID_PROPERTY)
		.field(CityPartner.NAME_PROPERTY)
		.field(CityPartner.MOBILE_PROPERTY)
		.field(CityPartner.DESCRIPTION_PROPERTY)
		.field(CityPartner.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于CityPartner的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCityPartnerSecondaryListItemScope() {
		return CityPartnerBaseSecondaryListItemScope;
	}

	protected static SerializeScope PotentialCustomerBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomer.ID_PROPERTY)
		.field(PotentialCustomer.NAME_PROPERTY)
		.field(PotentialCustomer.MOBILE_PROPERTY)
		.field(PotentialCustomer.DESCRIPTION_PROPERTY)
		.field(PotentialCustomer.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于PotentialCustomer的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerSecondaryListItemScope() {
		return PotentialCustomerBaseSecondaryListItemScope;
	}

	protected static SerializeScope PotentialCustomerContactPersonBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomerContactPerson.ID_PROPERTY)
		.field(PotentialCustomerContactPerson.NAME_PROPERTY)
		.field(PotentialCustomerContactPerson.MOBILE_PROPERTY)
		.field(PotentialCustomerContactPerson.DESCRIPTION_PROPERTY)
		;
	/** 用于PotentialCustomerContactPerson的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerContactPersonSecondaryListItemScope() {
		return PotentialCustomerContactPersonBaseSecondaryListItemScope;
	}

	protected static SerializeScope PotentialCustomerContactBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomerContact.ID_PROPERTY)
		.field(PotentialCustomerContact.NAME_PROPERTY)
		.field(PotentialCustomerContact.CONTACT_DATE_PROPERTY)
		.field(PotentialCustomerContact.CONTACT_METHOD_PROPERTY)
		.field(PotentialCustomerContact.DESCRIPTION_PROPERTY)
		.field(PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于PotentialCustomerContact的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerContactSecondaryListItemScope() {
		return PotentialCustomerContactBaseSecondaryListItemScope;
	}

	protected static SerializeScope CityEventBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(CityEvent.ID_PROPERTY)
		.field(CityEvent.NAME_PROPERTY)
		.field(CityEvent.MOBILE_PROPERTY)
		.field(CityEvent.DESCRIPTION_PROPERTY)
		.field(CityEvent.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于CityEvent的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCityEventSecondaryListItemScope() {
		return CityEventBaseSecondaryListItemScope;
	}

	protected static SerializeScope EventAttendanceBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EventAttendance.ID_PROPERTY)
		.field(EventAttendance.NAME_PROPERTY)
		.field(EventAttendance.DESCRIPTION_PROPERTY)
		;
	/** 用于EventAttendance的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEventAttendanceSecondaryListItemScope() {
		return EventAttendanceBaseSecondaryListItemScope;
	}

	protected static SerializeScope RetailStoreBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStore.ID_PROPERTY)
		.field(RetailStore.NAME_PROPERTY)
		.field(RetailStore.TELEPHONE_PROPERTY)
		.field(RetailStore.OWNER_PROPERTY)
		.field(RetailStore.FOUNDED_PROPERTY)
		.field(RetailStore.LATITUDE_PROPERTY)
		.field(RetailStore.LONGITUDE_PROPERTY)
		.field(RetailStore.DESCRIPTION_PROPERTY)
		.field(RetailStore.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于RetailStore的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreSecondaryListItemScope() {
		return RetailStoreBaseSecondaryListItemScope;
	}

	protected static SerializeScope RetailStoreCreationBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreCreation.ID_PROPERTY)
		.field(RetailStoreCreation.COMMENT_PROPERTY)
		;
	/** 用于RetailStoreCreation的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreCreationSecondaryListItemScope() {
		return RetailStoreCreationBaseSecondaryListItemScope;
	}

	protected static SerializeScope RetailStoreInvestmentInvitationBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreInvestmentInvitation.ID_PROPERTY)
		.field(RetailStoreInvestmentInvitation.COMMENT_PROPERTY)
		;
	/** 用于RetailStoreInvestmentInvitation的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreInvestmentInvitationSecondaryListItemScope() {
		return RetailStoreInvestmentInvitationBaseSecondaryListItemScope;
	}

	protected static SerializeScope RetailStoreFranchisingBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreFranchising.ID_PROPERTY)
		.field(RetailStoreFranchising.COMMENT_PROPERTY)
		;
	/** 用于RetailStoreFranchising的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreFranchisingSecondaryListItemScope() {
		return RetailStoreFranchisingBaseSecondaryListItemScope;
	}

	protected static SerializeScope RetailStoreDecorationBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreDecoration.ID_PROPERTY)
		.field(RetailStoreDecoration.COMMENT_PROPERTY)
		;
	/** 用于RetailStoreDecoration的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreDecorationSecondaryListItemScope() {
		return RetailStoreDecorationBaseSecondaryListItemScope;
	}

	protected static SerializeScope RetailStoreOpeningBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreOpening.ID_PROPERTY)
		.field(RetailStoreOpening.COMMENT_PROPERTY)
		;
	/** 用于RetailStoreOpening的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreOpeningSecondaryListItemScope() {
		return RetailStoreOpeningBaseSecondaryListItemScope;
	}

	protected static SerializeScope RetailStoreClosingBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreClosing.ID_PROPERTY)
		.field(RetailStoreClosing.COMMENT_PROPERTY)
		;
	/** 用于RetailStoreClosing的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreClosingSecondaryListItemScope() {
		return RetailStoreClosingBaseSecondaryListItemScope;
	}

	protected static SerializeScope RetailStoreMemberBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreMember.ID_PROPERTY)
		.field(RetailStoreMember.NAME_PROPERTY)
		.field(RetailStoreMember.MOBILE_PHONE_PROPERTY)
		;
	/** 用于RetailStoreMember的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreMemberSecondaryListItemScope() {
		return RetailStoreMemberBaseSecondaryListItemScope;
	}

	protected static SerializeScope ConsumerOrderBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ConsumerOrder.ID_PROPERTY)
		.field(ConsumerOrder.TITLE_PROPERTY)
		.field(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于ConsumerOrder的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getConsumerOrderSecondaryListItemScope() {
		return ConsumerOrderBaseSecondaryListItemScope;
	}

	protected static SerializeScope ConsumerOrderLineItemBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ConsumerOrderLineItem.ID_PROPERTY)
		.field(ConsumerOrderLineItem.SKU_ID_PROPERTY)
		.field(ConsumerOrderLineItem.SKU_NAME_PROPERTY)
		.field(ConsumerOrderLineItem.PRICE_PROPERTY)
		.field(ConsumerOrderLineItem.QUANTITY_PROPERTY)
		.field(ConsumerOrderLineItem.AMOUNT_PROPERTY)
		.field(ConsumerOrderLineItem.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于ConsumerOrderLineItem的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getConsumerOrderLineItemSecondaryListItemScope() {
		return ConsumerOrderLineItemBaseSecondaryListItemScope;
	}

	protected static SerializeScope ConsumerOrderShippingGroupBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ConsumerOrderShippingGroup.ID_PROPERTY)
		.field(ConsumerOrderShippingGroup.NAME_PROPERTY)
		.field(ConsumerOrderShippingGroup.AMOUNT_PROPERTY)
		;
	/** 用于ConsumerOrderShippingGroup的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getConsumerOrderShippingGroupSecondaryListItemScope() {
		return ConsumerOrderShippingGroupBaseSecondaryListItemScope;
	}

	protected static SerializeScope ConsumerOrderPaymentGroupBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ConsumerOrderPaymentGroup.ID_PROPERTY)
		.field(ConsumerOrderPaymentGroup.NAME_PROPERTY)
		.field(ConsumerOrderPaymentGroup.CARD_NUMBER_PROPERTY)
		;
	/** 用于ConsumerOrderPaymentGroup的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getConsumerOrderPaymentGroupSecondaryListItemScope() {
		return ConsumerOrderPaymentGroupBaseSecondaryListItemScope;
	}

	protected static SerializeScope ConsumerOrderPriceAdjustmentBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ConsumerOrderPriceAdjustment.ID_PROPERTY)
		.field(ConsumerOrderPriceAdjustment.NAME_PROPERTY)
		.field(ConsumerOrderPriceAdjustment.AMOUNT_PROPERTY)
		.field(ConsumerOrderPriceAdjustment.PROVIDER_PROPERTY)
		;
	/** 用于ConsumerOrderPriceAdjustment的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getConsumerOrderPriceAdjustmentSecondaryListItemScope() {
		return ConsumerOrderPriceAdjustmentBaseSecondaryListItemScope;
	}

	protected static SerializeScope RetailStoreMemberCouponBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreMemberCoupon.ID_PROPERTY)
		.field(RetailStoreMemberCoupon.NAME_PROPERTY)
		.field(RetailStoreMemberCoupon.NUMBER_PROPERTY)
		.field(RetailStoreMemberCoupon.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于RetailStoreMemberCoupon的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreMemberCouponSecondaryListItemScope() {
		return RetailStoreMemberCouponBaseSecondaryListItemScope;
	}

	protected static SerializeScope MemberWishlistBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(MemberWishlist.ID_PROPERTY)
		.field(MemberWishlist.NAME_PROPERTY)
		;
	/** 用于MemberWishlist的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getMemberWishlistSecondaryListItemScope() {
		return MemberWishlistBaseSecondaryListItemScope;
	}

	protected static SerializeScope MemberRewardPointBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(MemberRewardPoint.ID_PROPERTY)
		.field(MemberRewardPoint.NAME_PROPERTY)
		.field(MemberRewardPoint.POINT_PROPERTY)
		;
	/** 用于MemberRewardPoint的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getMemberRewardPointSecondaryListItemScope() {
		return MemberRewardPointBaseSecondaryListItemScope;
	}

	protected static SerializeScope MemberRewardPointRedemptionBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(MemberRewardPointRedemption.ID_PROPERTY)
		.field(MemberRewardPointRedemption.NAME_PROPERTY)
		.field(MemberRewardPointRedemption.POINT_PROPERTY)
		;
	/** 用于MemberRewardPointRedemption的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getMemberRewardPointRedemptionSecondaryListItemScope() {
		return MemberRewardPointRedemptionBaseSecondaryListItemScope;
	}

	protected static SerializeScope MemberWishlistProductBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(MemberWishlistProduct.ID_PROPERTY)
		.field(MemberWishlistProduct.NAME_PROPERTY)
		;
	/** 用于MemberWishlistProduct的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getMemberWishlistProductSecondaryListItemScope() {
		return MemberWishlistProductBaseSecondaryListItemScope;
	}

	protected static SerializeScope RetailStoreMemberAddressBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreMemberAddress.ID_PROPERTY)
		.field(RetailStoreMemberAddress.NAME_PROPERTY)
		.field(RetailStoreMemberAddress.MOBILE_PHONE_PROPERTY)
		.field(RetailStoreMemberAddress.ADDRESS_PROPERTY)
		;
	/** 用于RetailStoreMemberAddress的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreMemberAddressSecondaryListItemScope() {
		return RetailStoreMemberAddressBaseSecondaryListItemScope;
	}

	protected static SerializeScope RetailStoreMemberGiftCardBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreMemberGiftCard.ID_PROPERTY)
		.field(RetailStoreMemberGiftCard.NAME_PROPERTY)
		.field(RetailStoreMemberGiftCard.NUMBER_PROPERTY)
		.field(RetailStoreMemberGiftCard.REMAIN_PROPERTY)
		;
	/** 用于RetailStoreMemberGiftCard的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreMemberGiftCardSecondaryListItemScope() {
		return RetailStoreMemberGiftCardBaseSecondaryListItemScope;
	}

	protected static SerializeScope RetailStoreMemberGiftCardConsumeRecordBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY)
		.field(RetailStoreMemberGiftCardConsumeRecord.OCCURE_TIME_PROPERTY)
		.field(RetailStoreMemberGiftCardConsumeRecord.NUMBER_PROPERTY)
		.field(RetailStoreMemberGiftCardConsumeRecord.AMOUNT_PROPERTY)
		;
	/** 用于RetailStoreMemberGiftCardConsumeRecord的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreMemberGiftCardConsumeRecordSecondaryListItemScope() {
		return RetailStoreMemberGiftCardConsumeRecordBaseSecondaryListItemScope;
	}

	protected static SerializeScope GoodsSupplierBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(GoodsSupplier.ID_PROPERTY)
		.field(GoodsSupplier.NAME_PROPERTY)
		.field(GoodsSupplier.SUPPLY_PRODUCT_PROPERTY)
		.field(GoodsSupplier.CONTACT_NUMBER_PROPERTY)
		.field(GoodsSupplier.DESCRIPTION_PROPERTY)
		.field(GoodsSupplier.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于GoodsSupplier的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGoodsSupplierSecondaryListItemScope() {
		return GoodsSupplierBaseSecondaryListItemScope;
	}

	protected static SerializeScope SupplierProductBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplierProduct.ID_PROPERTY)
		.field(SupplierProduct.PRODUCT_NAME_PROPERTY)
		.field(SupplierProduct.PRODUCT_DESCRIPTION_PROPERTY)
		.field(SupplierProduct.PRODUCT_UNIT_PROPERTY)
		;
	/** 用于SupplierProduct的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSupplierProductSecondaryListItemScope() {
		return SupplierProductBaseSecondaryListItemScope;
	}

	protected static SerializeScope ProductSupplyDurationBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ProductSupplyDuration.ID_PROPERTY)
		.field(ProductSupplyDuration.QUANTITY_PROPERTY)
		.field(ProductSupplyDuration.DURATION_PROPERTY)
		.field(ProductSupplyDuration.PRICE_PROPERTY)
		;
	/** 用于ProductSupplyDuration的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getProductSupplyDurationSecondaryListItemScope() {
		return ProductSupplyDurationBaseSecondaryListItemScope;
	}

	protected static SerializeScope SupplyOrderBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplyOrder.ID_PROPERTY)
		.field(SupplyOrder.TITLE_PROPERTY)
		.field(SupplyOrder.TOTAL_AMOUNT_PROPERTY)
		.field(SupplyOrder.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于SupplyOrder的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSupplyOrderSecondaryListItemScope() {
		return SupplyOrderBaseSecondaryListItemScope;
	}

	protected static SerializeScope SupplyOrderLineItemBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplyOrderLineItem.ID_PROPERTY)
		.field(SupplyOrderLineItem.SKU_ID_PROPERTY)
		.field(SupplyOrderLineItem.SKU_NAME_PROPERTY)
		.field(SupplyOrderLineItem.AMOUNT_PROPERTY)
		.field(SupplyOrderLineItem.QUANTITY_PROPERTY)
		.field(SupplyOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY)
		;
	/** 用于SupplyOrderLineItem的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSupplyOrderLineItemSecondaryListItemScope() {
		return SupplyOrderLineItemBaseSecondaryListItemScope;
	}

	protected static SerializeScope SupplyOrderShippingGroupBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplyOrderShippingGroup.ID_PROPERTY)
		.field(SupplyOrderShippingGroup.NAME_PROPERTY)
		.field(SupplyOrderShippingGroup.AMOUNT_PROPERTY)
		;
	/** 用于SupplyOrderShippingGroup的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSupplyOrderShippingGroupSecondaryListItemScope() {
		return SupplyOrderShippingGroupBaseSecondaryListItemScope;
	}

	protected static SerializeScope SupplyOrderPaymentGroupBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplyOrderPaymentGroup.ID_PROPERTY)
		.field(SupplyOrderPaymentGroup.NAME_PROPERTY)
		.field(SupplyOrderPaymentGroup.CARD_NUMBER_PROPERTY)
		;
	/** 用于SupplyOrderPaymentGroup的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSupplyOrderPaymentGroupSecondaryListItemScope() {
		return SupplyOrderPaymentGroupBaseSecondaryListItemScope;
	}

	protected static SerializeScope RetailStoreOrderBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreOrder.ID_PROPERTY)
		.field(RetailStoreOrder.TITLE_PROPERTY)
		.field(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY)
		.field(RetailStoreOrder.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于RetailStoreOrder的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreOrderSecondaryListItemScope() {
		return RetailStoreOrderBaseSecondaryListItemScope;
	}

	protected static SerializeScope RetailStoreOrderLineItemBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreOrderLineItem.ID_PROPERTY)
		.field(RetailStoreOrderLineItem.SKU_ID_PROPERTY)
		.field(RetailStoreOrderLineItem.SKU_NAME_PROPERTY)
		.field(RetailStoreOrderLineItem.AMOUNT_PROPERTY)
		.field(RetailStoreOrderLineItem.QUANTITY_PROPERTY)
		.field(RetailStoreOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY)
		;
	/** 用于RetailStoreOrderLineItem的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreOrderLineItemSecondaryListItemScope() {
		return RetailStoreOrderLineItemBaseSecondaryListItemScope;
	}

	protected static SerializeScope RetailStoreOrderShippingGroupBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreOrderShippingGroup.ID_PROPERTY)
		.field(RetailStoreOrderShippingGroup.NAME_PROPERTY)
		.field(RetailStoreOrderShippingGroup.AMOUNT_PROPERTY)
		;
	/** 用于RetailStoreOrderShippingGroup的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreOrderShippingGroupSecondaryListItemScope() {
		return RetailStoreOrderShippingGroupBaseSecondaryListItemScope;
	}

	protected static SerializeScope RetailStoreOrderPaymentGroupBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreOrderPaymentGroup.ID_PROPERTY)
		.field(RetailStoreOrderPaymentGroup.NAME_PROPERTY)
		.field(RetailStoreOrderPaymentGroup.CARD_NUMBER_PROPERTY)
		;
	/** 用于RetailStoreOrderPaymentGroup的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreOrderPaymentGroupSecondaryListItemScope() {
		return RetailStoreOrderPaymentGroupBaseSecondaryListItemScope;
	}

	protected static SerializeScope WarehouseBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Warehouse.ID_PROPERTY)
		.field(Warehouse.LOCATION_PROPERTY)
		.field(Warehouse.CONTACT_NUMBER_PROPERTY)
		.field(Warehouse.TOTAL_AREA_PROPERTY)
		.field(Warehouse.LATITUDE_PROPERTY)
		.field(Warehouse.LONGITUDE_PROPERTY)
		.field(Warehouse.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于Warehouse的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getWarehouseSecondaryListItemScope() {
		return WarehouseBaseSecondaryListItemScope;
	}

	protected static SerializeScope StorageSpaceBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(StorageSpace.ID_PROPERTY)
		.field(StorageSpace.LOCATION_PROPERTY)
		.field(StorageSpace.CONTACT_NUMBER_PROPERTY)
		.field(StorageSpace.TOTAL_AREA_PROPERTY)
		.field(StorageSpace.LATITUDE_PROPERTY)
		.field(StorageSpace.LONGITUDE_PROPERTY)
		.field(StorageSpace.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于StorageSpace的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getStorageSpaceSecondaryListItemScope() {
		return StorageSpaceBaseSecondaryListItemScope;
	}

	protected static SerializeScope SmartPalletBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SmartPallet.ID_PROPERTY)
		.field(SmartPallet.LOCATION_PROPERTY)
		.field(SmartPallet.CONTACT_NUMBER_PROPERTY)
		.field(SmartPallet.TOTAL_AREA_PROPERTY)
		.field(SmartPallet.LATITUDE_PROPERTY)
		.field(SmartPallet.LONGITUDE_PROPERTY)
		.field(SmartPallet.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于SmartPallet的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSmartPalletSecondaryListItemScope() {
		return SmartPalletBaseSecondaryListItemScope;
	}

	protected static SerializeScope GoodsShelfBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(GoodsShelf.ID_PROPERTY)
		.field(GoodsShelf.LOCATION_PROPERTY)
		.field(GoodsShelf.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于GoodsShelf的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGoodsShelfSecondaryListItemScope() {
		return GoodsShelfBaseSecondaryListItemScope;
	}

	protected static SerializeScope GoodsShelfStockCountBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(GoodsShelfStockCount.ID_PROPERTY)
		.field(GoodsShelfStockCount.TITLE_PROPERTY)
		.field(GoodsShelfStockCount.COUNT_TIME_PROPERTY)
		.field(GoodsShelfStockCount.SUMMARY_PROPERTY)
		;
	/** 用于GoodsShelfStockCount的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGoodsShelfStockCountSecondaryListItemScope() {
		return GoodsShelfStockCountBaseSecondaryListItemScope;
	}

	protected static SerializeScope StockCountIssueTrackBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(StockCountIssueTrack.ID_PROPERTY)
		.field(StockCountIssueTrack.TITLE_PROPERTY)
		.field(StockCountIssueTrack.COUNT_TIME_PROPERTY)
		.field(StockCountIssueTrack.SUMMARY_PROPERTY)
		;
	/** 用于StockCountIssueTrack的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getStockCountIssueTrackSecondaryListItemScope() {
		return StockCountIssueTrackBaseSecondaryListItemScope;
	}

	protected static SerializeScope GoodsAllocationBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(GoodsAllocation.ID_PROPERTY)
		.field(GoodsAllocation.LOCATION_PROPERTY)
		.field(GoodsAllocation.LATITUDE_PROPERTY)
		.field(GoodsAllocation.LONGITUDE_PROPERTY)
		;
	/** 用于GoodsAllocation的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGoodsAllocationSecondaryListItemScope() {
		return GoodsAllocationBaseSecondaryListItemScope;
	}

	protected static SerializeScope GoodsBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Goods.ID_PROPERTY)
		.field(Goods.NAME_PROPERTY)
		.field(Goods.RFID_PROPERTY)
		.field(Goods.UOM_PROPERTY)
		.field(Goods.MAX_PACKAGE_PROPERTY)
		.field(Goods.EXPIRE_TIME_PROPERTY)
		;
	/** 用于Goods的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGoodsSecondaryListItemScope() {
		return GoodsBaseSecondaryListItemScope;
	}

	protected static SerializeScope GoodsMovementBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(GoodsMovement.ID_PROPERTY)
		.field(GoodsMovement.MOVE_TIME_PROPERTY)
		.field(GoodsMovement.FACILITY_PROPERTY)
		.field(GoodsMovement.FACILITY_ID_PROPERTY)
		.field(GoodsMovement.FROM_IP_PROPERTY)
		.field(GoodsMovement.USER_AGENT_PROPERTY)
		.field(GoodsMovement.SESSION_ID_PROPERTY)
		.field(GoodsMovement.LATITUDE_PROPERTY)
		.field(GoodsMovement.LONGITUDE_PROPERTY)
		;
	/** 用于GoodsMovement的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGoodsMovementSecondaryListItemScope() {
		return GoodsMovementBaseSecondaryListItemScope;
	}

	protected static SerializeScope SupplierSpaceBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplierSpace.ID_PROPERTY)
		.field(SupplierSpace.LOCATION_PROPERTY)
		.field(SupplierSpace.CONTACT_NUMBER_PROPERTY)
		.field(SupplierSpace.TOTAL_AREA_PROPERTY)
		.field(SupplierSpace.LATITUDE_PROPERTY)
		.field(SupplierSpace.LONGITUDE_PROPERTY)
		.field(SupplierSpace.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于SupplierSpace的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSupplierSpaceSecondaryListItemScope() {
		return SupplierSpaceBaseSecondaryListItemScope;
	}

	protected static SerializeScope ReceivingSpaceBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ReceivingSpace.ID_PROPERTY)
		.field(ReceivingSpace.LOCATION_PROPERTY)
		.field(ReceivingSpace.CONTACT_NUMBER_PROPERTY)
		.field(ReceivingSpace.DESCRIPTION_PROPERTY)
		.field(ReceivingSpace.TOTAL_AREA_PROPERTY)
		.field(ReceivingSpace.LATITUDE_PROPERTY)
		.field(ReceivingSpace.LONGITUDE_PROPERTY)
		.field(ReceivingSpace.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于ReceivingSpace的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getReceivingSpaceSecondaryListItemScope() {
		return ReceivingSpaceBaseSecondaryListItemScope;
	}

	protected static SerializeScope ShippingSpaceBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ShippingSpace.ID_PROPERTY)
		.field(ShippingSpace.LOCATION_PROPERTY)
		.field(ShippingSpace.CONTACT_NUMBER_PROPERTY)
		.field(ShippingSpace.TOTAL_AREA_PROPERTY)
		.field(ShippingSpace.LATITUDE_PROPERTY)
		.field(ShippingSpace.LONGITUDE_PROPERTY)
		.field(ShippingSpace.DESCRIPTION_PROPERTY)
		.field(ShippingSpace.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于ShippingSpace的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getShippingSpaceSecondaryListItemScope() {
		return ShippingSpaceBaseSecondaryListItemScope;
	}

	protected static SerializeScope DamageSpaceBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(DamageSpace.ID_PROPERTY)
		.field(DamageSpace.LOCATION_PROPERTY)
		.field(DamageSpace.CONTACT_NUMBER_PROPERTY)
		.field(DamageSpace.TOTAL_AREA_PROPERTY)
		.field(DamageSpace.LATITUDE_PROPERTY)
		.field(DamageSpace.LONGITUDE_PROPERTY)
		.field(DamageSpace.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于DamageSpace的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getDamageSpaceSecondaryListItemScope() {
		return DamageSpaceBaseSecondaryListItemScope;
	}

	protected static SerializeScope WarehouseAssetBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(WarehouseAsset.ID_PROPERTY)
		.field(WarehouseAsset.NAME_PROPERTY)
		.field(WarehouseAsset.POSITION_PROPERTY)
		.field(WarehouseAsset.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于WarehouseAsset的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getWarehouseAssetSecondaryListItemScope() {
		return WarehouseAssetBaseSecondaryListItemScope;
	}

	protected static SerializeScope TransportFleetBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TransportFleet.ID_PROPERTY)
		.field(TransportFleet.NAME_PROPERTY)
		.field(TransportFleet.CONTACT_NUMBER_PROPERTY)
		.field(TransportFleet.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于TransportFleet的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTransportFleetSecondaryListItemScope() {
		return TransportFleetBaseSecondaryListItemScope;
	}

	protected static SerializeScope TransportTruckBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TransportTruck.ID_PROPERTY)
		.field(TransportTruck.NAME_PROPERTY)
		.field(TransportTruck.PLATE_NUMBER_PROPERTY)
		.field(TransportTruck.CONTACT_NUMBER_PROPERTY)
		.field(TransportTruck.VEHICLE_LICENSE_NUMBER_PROPERTY)
		.field(TransportTruck.ENGINE_NUMBER_PROPERTY)
		.field(TransportTruck.MAKE_DATE_PROPERTY)
		.field(TransportTruck.MILEAGE_PROPERTY)
		.field(TransportTruck.BODY_COLOR_PROPERTY)
		;
	/** 用于TransportTruck的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTransportTruckSecondaryListItemScope() {
		return TransportTruckBaseSecondaryListItemScope;
	}

	protected static SerializeScope TruckDriverBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TruckDriver.ID_PROPERTY)
		.field(TruckDriver.NAME_PROPERTY)
		.field(TruckDriver.DRIVER_LICENSE_NUMBER_PROPERTY)
		.field(TruckDriver.CONTACT_NUMBER_PROPERTY)
		;
	/** 用于TruckDriver的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTruckDriverSecondaryListItemScope() {
		return TruckDriverBaseSecondaryListItemScope;
	}

	protected static SerializeScope TransportTaskBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TransportTask.ID_PROPERTY)
		.field(TransportTask.NAME_PROPERTY)
		.field(TransportTask.START_PROPERTY)
		.field(TransportTask.BEGIN_TIME_PROPERTY)
		.field(TransportTask.LATITUDE_PROPERTY)
		.field(TransportTask.LONGITUDE_PROPERTY)
		;
	/** 用于TransportTask的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTransportTaskSecondaryListItemScope() {
		return TransportTaskBaseSecondaryListItemScope;
	}

	protected static SerializeScope TransportTaskTrackBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TransportTaskTrack.ID_PROPERTY)
		.field(TransportTaskTrack.TRACK_TIME_PROPERTY)
		.field(TransportTaskTrack.LATITUDE_PROPERTY)
		.field(TransportTaskTrack.LONGITUDE_PROPERTY)
		;
	/** 用于TransportTaskTrack的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTransportTaskTrackSecondaryListItemScope() {
		return TransportTaskTrackBaseSecondaryListItemScope;
	}

	protected static SerializeScope AccountSetBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountSet.ID_PROPERTY)
		.field(AccountSet.NAME_PROPERTY)
		.field(AccountSet.YEAR_SET_PROPERTY)
		.field(AccountSet.EFFECTIVE_DATE_PROPERTY)
		.field(AccountSet.ACCOUNTING_SYSTEM_PROPERTY)
		.field(AccountSet.DOMESTIC_CURRENCY_CODE_PROPERTY)
		.field(AccountSet.DOMESTIC_CURRENCY_NAME_PROPERTY)
		.field(AccountSet.OPENING_BANK_PROPERTY)
		.field(AccountSet.ACCOUNT_NUMBER_PROPERTY)
		.field(AccountSet.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于AccountSet的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getAccountSetSecondaryListItemScope() {
		return AccountSetBaseSecondaryListItemScope;
	}

	protected static SerializeScope AccountingSubjectBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountingSubject.ID_PROPERTY)
		.field(AccountingSubject.ACCOUNTING_SUBJECT_CODE_PROPERTY)
		.field(AccountingSubject.ACCOUNTING_SUBJECT_NAME_PROPERTY)
		.field(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY)
		.field(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY)
		;
	/** 用于AccountingSubject的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getAccountingSubjectSecondaryListItemScope() {
		return AccountingSubjectBaseSecondaryListItemScope;
	}

	protected static SerializeScope AccountingPeriodBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountingPeriod.ID_PROPERTY)
		.field(AccountingPeriod.NAME_PROPERTY)
		.field(AccountingPeriod.START_DATE_PROPERTY)
		.field(AccountingPeriod.END_DATE_PROPERTY)
		;
	/** 用于AccountingPeriod的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getAccountingPeriodSecondaryListItemScope() {
		return AccountingPeriodBaseSecondaryListItemScope;
	}

	protected static SerializeScope AccountingDocumentTypeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountingDocumentType.ID_PROPERTY)
		.field(AccountingDocumentType.NAME_PROPERTY)
		.field(AccountingDocumentType.DESCRIPTION_PROPERTY)
		;
	/** 用于AccountingDocumentType的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getAccountingDocumentTypeSecondaryListItemScope() {
		return AccountingDocumentTypeBaseSecondaryListItemScope;
	}

	protected static SerializeScope AccountingDocumentBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountingDocument.ID_PROPERTY)
		.field(AccountingDocument.NAME_PROPERTY)
		.field(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY)
		;
	/** 用于AccountingDocument的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getAccountingDocumentSecondaryListItemScope() {
		return AccountingDocumentBaseSecondaryListItemScope;
	}

	protected static SerializeScope OriginalVoucherBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(OriginalVoucher.ID_PROPERTY)
		.field(OriginalVoucher.TITLE_PROPERTY)
		.field(OriginalVoucher.MADE_BY_PROPERTY)
		.field(OriginalVoucher.RECEIVED_BY_PROPERTY)
		.field(OriginalVoucher.VOUCHER_TYPE_PROPERTY)
		.field(OriginalVoucher.VOUCHER_IMAGE_PROPERTY)
		;
	/** 用于OriginalVoucher的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getOriginalVoucherSecondaryListItemScope() {
		return OriginalVoucherBaseSecondaryListItemScope;
	}

	protected static SerializeScope AccountingDocumentLineBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountingDocumentLine.ID_PROPERTY)
		.field(AccountingDocumentLine.NAME_PROPERTY)
		.field(AccountingDocumentLine.CODE_PROPERTY)
		.field(AccountingDocumentLine.DIRECT_PROPERTY)
		.field(AccountingDocumentLine.AMOUNT_PROPERTY)
		;
	/** 用于AccountingDocumentLine的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getAccountingDocumentLineSecondaryListItemScope() {
		return AccountingDocumentLineBaseSecondaryListItemScope;
	}

	protected static SerializeScope LevelOneDepartmentBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelOneDepartment.ID_PROPERTY)
		.field(LevelOneDepartment.NAME_PROPERTY)
		.field(LevelOneDepartment.DESCRIPTION_PROPERTY)
		.field(LevelOneDepartment.MANAGER_PROPERTY)
		.field(LevelOneDepartment.FOUNDED_PROPERTY)
		;
	/** 用于LevelOneDepartment的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLevelOneDepartmentSecondaryListItemScope() {
		return LevelOneDepartmentBaseSecondaryListItemScope;
	}

	protected static SerializeScope LevelTwoDepartmentBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelTwoDepartment.ID_PROPERTY)
		.field(LevelTwoDepartment.NAME_PROPERTY)
		.field(LevelTwoDepartment.DESCRIPTION_PROPERTY)
		.field(LevelTwoDepartment.FOUNDED_PROPERTY)
		;
	/** 用于LevelTwoDepartment的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLevelTwoDepartmentSecondaryListItemScope() {
		return LevelTwoDepartmentBaseSecondaryListItemScope;
	}

	protected static SerializeScope LevelThreeDepartmentBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelThreeDepartment.ID_PROPERTY)
		.field(LevelThreeDepartment.NAME_PROPERTY)
		.field(LevelThreeDepartment.DESCRIPTION_PROPERTY)
		.field(LevelThreeDepartment.FOUNDED_PROPERTY)
		;
	/** 用于LevelThreeDepartment的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLevelThreeDepartmentSecondaryListItemScope() {
		return LevelThreeDepartmentBaseSecondaryListItemScope;
	}

	protected static SerializeScope SkillTypeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SkillType.ID_PROPERTY)
		.field(SkillType.CODE_PROPERTY)
		.field(SkillType.DESCRIPTION_PROPERTY)
		;
	/** 用于SkillType的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSkillTypeSecondaryListItemScope() {
		return SkillTypeBaseSecondaryListItemScope;
	}

	protected static SerializeScope ResponsibilityTypeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ResponsibilityType.ID_PROPERTY)
		.field(ResponsibilityType.CODE_PROPERTY)
		.field(ResponsibilityType.BASE_DESCRIPTION_PROPERTY)
		.field(ResponsibilityType.DETAIL_DESCRIPTION_PROPERTY)
		;
	/** 用于ResponsibilityType的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getResponsibilityTypeSecondaryListItemScope() {
		return ResponsibilityTypeBaseSecondaryListItemScope;
	}

	protected static SerializeScope TerminationReasonBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TerminationReason.ID_PROPERTY)
		.field(TerminationReason.CODE_PROPERTY)
		.field(TerminationReason.DESCRIPTION_PROPERTY)
		;
	/** 用于TerminationReason的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTerminationReasonSecondaryListItemScope() {
		return TerminationReasonBaseSecondaryListItemScope;
	}

	protected static SerializeScope TerminationTypeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TerminationType.ID_PROPERTY)
		.field(TerminationType.CODE_PROPERTY)
		.field(TerminationType.BASE_DESCRIPTION_PROPERTY)
		.field(TerminationType.DETAIL_DESCRIPTION_PROPERTY)
		;
	/** 用于TerminationType的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTerminationTypeSecondaryListItemScope() {
		return TerminationTypeBaseSecondaryListItemScope;
	}

	protected static SerializeScope OccupationTypeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(OccupationType.ID_PROPERTY)
		.field(OccupationType.CODE_PROPERTY)
		.field(OccupationType.DESCRIPTION_PROPERTY)
		.field(OccupationType.DETAIL_DESCRIPTION_PROPERTY)
		;
	/** 用于OccupationType的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getOccupationTypeSecondaryListItemScope() {
		return OccupationTypeBaseSecondaryListItemScope;
	}

	protected static SerializeScope LeaveTypeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LeaveType.ID_PROPERTY)
		.field(LeaveType.CODE_PROPERTY)
		.field(LeaveType.DESCRIPTION_PROPERTY)
		.field(LeaveType.DETAIL_DESCRIPTION_PROPERTY)
		;
	/** 用于LeaveType的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLeaveTypeSecondaryListItemScope() {
		return LeaveTypeBaseSecondaryListItemScope;
	}

	protected static SerializeScope SalaryGradeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SalaryGrade.ID_PROPERTY)
		.field(SalaryGrade.CODE_PROPERTY)
		.field(SalaryGrade.NAME_PROPERTY)
		.field(SalaryGrade.DETAIL_DESCRIPTION_PROPERTY)
		;
	/** 用于SalaryGrade的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSalaryGradeSecondaryListItemScope() {
		return SalaryGradeBaseSecondaryListItemScope;
	}

	protected static SerializeScope InterviewTypeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(InterviewType.ID_PROPERTY)
		.field(InterviewType.CODE_PROPERTY)
		.field(InterviewType.DESCRIPTION_PROPERTY)
		.field(InterviewType.DETAIL_DESCRIPTION_PROPERTY)
		;
	/** 用于InterviewType的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getInterviewTypeSecondaryListItemScope() {
		return InterviewTypeBaseSecondaryListItemScope;
	}

	protected static SerializeScope TrainingCourseTypeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TrainingCourseType.ID_PROPERTY)
		.field(TrainingCourseType.CODE_PROPERTY)
		.field(TrainingCourseType.NAME_PROPERTY)
		.field(TrainingCourseType.DESCRIPTION_PROPERTY)
		;
	/** 用于TrainingCourseType的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTrainingCourseTypeSecondaryListItemScope() {
		return TrainingCourseTypeBaseSecondaryListItemScope;
	}

	protected static SerializeScope PublicHolidayBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PublicHoliday.ID_PROPERTY)
		.field(PublicHoliday.CODE_PROPERTY)
		.field(PublicHoliday.NAME_PROPERTY)
		.field(PublicHoliday.DESCRIPTION_PROPERTY)
		;
	/** 用于PublicHoliday的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPublicHolidaySecondaryListItemScope() {
		return PublicHolidayBaseSecondaryListItemScope;
	}

	protected static SerializeScope TerminationBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Termination.ID_PROPERTY)
		.field(Termination.COMMENT_PROPERTY)
		;
	/** 用于Termination的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTerminationSecondaryListItemScope() {
		return TerminationBaseSecondaryListItemScope;
	}

	protected static SerializeScope ViewBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(View.ID_PROPERTY)
		.field(View.WHO_PROPERTY)
		.field(View.ASSESSMENT_PROPERTY)
		.field(View.INTERVIEW_TIME_PROPERTY)
		;
	/** 用于View的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getViewSecondaryListItemScope() {
		return ViewBaseSecondaryListItemScope;
	}

	protected static SerializeScope EmployeeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Employee.ID_PROPERTY)
		.field(Employee.TITLE_PROPERTY)
		.field(Employee.FAMILY_NAME_PROPERTY)
		.field(Employee.GIVEN_NAME_PROPERTY)
		.field(Employee.EMAIL_PROPERTY)
		.field(Employee.CITY_PROPERTY)
		.field(Employee.ADDRESS_PROPERTY)
		.field(Employee.CELL_PHONE_PROPERTY)
		.field(Employee.SALARY_ACCOUNT_PROPERTY)
		.field(Employee.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于Employee的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeSecondaryListItemScope() {
		return EmployeeBaseSecondaryListItemScope;
	}

	protected static SerializeScope InstructorBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Instructor.ID_PROPERTY)
		.field(Instructor.TITLE_PROPERTY)
		.field(Instructor.FAMILY_NAME_PROPERTY)
		.field(Instructor.GIVEN_NAME_PROPERTY)
		.field(Instructor.CELL_PHONE_PROPERTY)
		.field(Instructor.EMAIL_PROPERTY)
		.field(Instructor.INTRODUCTION_PROPERTY)
		.field(Instructor.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于Instructor的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getInstructorSecondaryListItemScope() {
		return InstructorBaseSecondaryListItemScope;
	}

	protected static SerializeScope CompanyTrainingBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(CompanyTraining.ID_PROPERTY)
		.field(CompanyTraining.TITLE_PROPERTY)
		.field(CompanyTraining.TIME_START_PROPERTY)
		.field(CompanyTraining.DURATION_HOURS_PROPERTY)
		.field(CompanyTraining.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于CompanyTraining的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCompanyTrainingSecondaryListItemScope() {
		return CompanyTrainingBaseSecondaryListItemScope;
	}

	protected static SerializeScope ScoringBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Scoring.ID_PROPERTY)
		.field(Scoring.SCORED_BY_PROPERTY)
		.field(Scoring.SCORE_PROPERTY)
		.field(Scoring.COMMENT_PROPERTY)
		;
	/** 用于Scoring的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getScoringSecondaryListItemScope() {
		return ScoringBaseSecondaryListItemScope;
	}

	protected static SerializeScope EmployeeCompanyTrainingBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeCompanyTraining.ID_PROPERTY)
		;
	/** 用于EmployeeCompanyTraining的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeCompanyTrainingSecondaryListItemScope() {
		return EmployeeCompanyTrainingBaseSecondaryListItemScope;
	}

	protected static SerializeScope EmployeeSkillBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeSkill.ID_PROPERTY)
		.field(EmployeeSkill.DESCRIPTION_PROPERTY)
		;
	/** 用于EmployeeSkill的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeSkillSecondaryListItemScope() {
		return EmployeeSkillBaseSecondaryListItemScope;
	}

	protected static SerializeScope EmployeePerformanceBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeePerformance.ID_PROPERTY)
		.field(EmployeePerformance.PERFORMANCE_COMMENT_PROPERTY)
		;
	/** 用于EmployeePerformance的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeePerformanceSecondaryListItemScope() {
		return EmployeePerformanceBaseSecondaryListItemScope;
	}

	protected static SerializeScope EmployeeWorkExperienceBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeWorkExperience.ID_PROPERTY)
		.field(EmployeeWorkExperience.START_PROPERTY)
		.field(EmployeeWorkExperience.END_PROPERTY)
		.field(EmployeeWorkExperience.COMPANY_PROPERTY)
		.field(EmployeeWorkExperience.DESCRIPTION_PROPERTY)
		;
	/** 用于EmployeeWorkExperience的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeWorkExperienceSecondaryListItemScope() {
		return EmployeeWorkExperienceBaseSecondaryListItemScope;
	}

	protected static SerializeScope EmployeeLeaveBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeLeave.ID_PROPERTY)
		.field(EmployeeLeave.LEAVE_DURATION_HOUR_PROPERTY)
		.field(EmployeeLeave.REMARK_PROPERTY)
		;
	/** 用于EmployeeLeave的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeLeaveSecondaryListItemScope() {
		return EmployeeLeaveBaseSecondaryListItemScope;
	}

	protected static SerializeScope EmployeeInterviewBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeInterview.ID_PROPERTY)
		.field(EmployeeInterview.REMARK_PROPERTY)
		;
	/** 用于EmployeeInterview的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeInterviewSecondaryListItemScope() {
		return EmployeeInterviewBaseSecondaryListItemScope;
	}

	protected static SerializeScope EmployeeAttendanceBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeAttendance.ID_PROPERTY)
		.field(EmployeeAttendance.ENTER_TIME_PROPERTY)
		.field(EmployeeAttendance.LEAVE_TIME_PROPERTY)
		.field(EmployeeAttendance.DURATION_HOURS_PROPERTY)
		.field(EmployeeAttendance.REMARK_PROPERTY)
		;
	/** 用于EmployeeAttendance的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeAttendanceSecondaryListItemScope() {
		return EmployeeAttendanceBaseSecondaryListItemScope;
	}

	protected static SerializeScope EmployeeQualifierBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeQualifier.ID_PROPERTY)
		.field(EmployeeQualifier.QUALIFIED_TIME_PROPERTY)
		.field(EmployeeQualifier.TYPE_PROPERTY)
		.field(EmployeeQualifier.LEVEL_PROPERTY)
		.field(EmployeeQualifier.REMARK_PROPERTY)
		;
	/** 用于EmployeeQualifier的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeQualifierSecondaryListItemScope() {
		return EmployeeQualifierBaseSecondaryListItemScope;
	}

	protected static SerializeScope EmployeeEducationBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeEducation.ID_PROPERTY)
		.field(EmployeeEducation.COMPLETE_TIME_PROPERTY)
		.field(EmployeeEducation.TYPE_PROPERTY)
		.field(EmployeeEducation.REMARK_PROPERTY)
		;
	/** 用于EmployeeEducation的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeEducationSecondaryListItemScope() {
		return EmployeeEducationBaseSecondaryListItemScope;
	}

	protected static SerializeScope EmployeeAwardBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeAward.ID_PROPERTY)
		.field(EmployeeAward.COMPLETE_TIME_PROPERTY)
		.field(EmployeeAward.TYPE_PROPERTY)
		.field(EmployeeAward.REMARK_PROPERTY)
		;
	/** 用于EmployeeAward的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeAwardSecondaryListItemScope() {
		return EmployeeAwardBaseSecondaryListItemScope;
	}

	protected static SerializeScope EmployeeSalarySheetBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeSalarySheet.ID_PROPERTY)
		.field(EmployeeSalarySheet.BASE_SALARY_PROPERTY)
		.field(EmployeeSalarySheet.BONUS_PROPERTY)
		.field(EmployeeSalarySheet.REWARD_PROPERTY)
		.field(EmployeeSalarySheet.PERSONAL_TAX_PROPERTY)
		.field(EmployeeSalarySheet.SOCIAL_SECURITY_PROPERTY)
		.field(EmployeeSalarySheet.HOUSING_FOUND_PROPERTY)
		.field(EmployeeSalarySheet.JOB_INSURANCE_PROPERTY)
		;
	/** 用于EmployeeSalarySheet的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeSalarySheetSecondaryListItemScope() {
		return EmployeeSalarySheetBaseSecondaryListItemScope;
	}

	protected static SerializeScope PayingOffBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PayingOff.ID_PROPERTY)
		.field(PayingOff.WHO_PROPERTY)
		.field(PayingOff.PAID_TIME_PROPERTY)
		.field(PayingOff.AMOUNT_PROPERTY)
		;
	/** 用于PayingOff的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPayingOffSecondaryListItemScope() {
		return PayingOffBaseSecondaryListItemScope;
	}

	protected static SerializeScope MobileAppBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(MobileApp.ID_PROPERTY)
		.field(MobileApp.NAME_PROPERTY)
		;
	/** 用于MobileApp的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getMobileAppSecondaryListItemScope() {
		return MobileAppBaseSecondaryListItemScope;
	}

	protected static SerializeScope PageBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Page.ID_PROPERTY)
		.field(Page.PAGE_TITLE_PROPERTY)
		.field(Page.LINK_TO_URL_PROPERTY)
		.field(Page.DISPLAY_ORDER_PROPERTY)
		;
	/** 用于Page的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPageSecondaryListItemScope() {
		return PageBaseSecondaryListItemScope;
	}

	protected static SerializeScope PageTypeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PageType.ID_PROPERTY)
		.field(PageType.NAME_PROPERTY)
		.field(PageType.CODE_PROPERTY)
		.field(PageType.FOOTER_TAB_PROPERTY)
		;
	/** 用于PageType的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPageTypeSecondaryListItemScope() {
		return PageTypeBaseSecondaryListItemScope;
	}

	protected static SerializeScope SlideBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Slide.ID_PROPERTY)
		.field(Slide.NAME_PROPERTY)
		.field(Slide.DISPLAY_ORDER_PROPERTY)
		.field(Slide.IMAGE_URL_PROPERTY)
		.field(Slide.VIDEO_URL_PROPERTY)
		.field(Slide.LINK_TO_URL_PROPERTY)
		;
	/** 用于Slide的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSlideSecondaryListItemScope() {
		return SlideBaseSecondaryListItemScope;
	}

	protected static SerializeScope UiActionBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(UiAction.ID_PROPERTY)
		.field(UiAction.CODE_PROPERTY)
		.field(UiAction.ICON_PROPERTY)
		.field(UiAction.TITLE_PROPERTY)
		.field(UiAction.DISPLAY_ORDER_PROPERTY)
		.field(UiAction.BRIEF_PROPERTY)
		.field(UiAction.IMAGE_URL_PROPERTY)
		.field(UiAction.LINK_TO_URL_PROPERTY)
		.field(UiAction.EXTRA_DATA_PROPERTY)
		;
	/** 用于UiAction的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUiActionSecondaryListItemScope() {
		return UiActionBaseSecondaryListItemScope;
	}

	protected static SerializeScope SectionBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Section.ID_PROPERTY)
		.field(Section.TITLE_PROPERTY)
		.field(Section.BRIEF_PROPERTY)
		.field(Section.ICON_PROPERTY)
		.field(Section.DISPLAY_ORDER_PROPERTY)
		.field(Section.VIEW_GROUP_PROPERTY)
		.field(Section.LINK_TO_URL_PROPERTY)
		;
	/** 用于Section的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSectionSecondaryListItemScope() {
		return SectionBaseSecondaryListItemScope;
	}

	protected static SerializeScope UserDomainBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		;
	/** 用于UserDomain的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserDomainSecondaryListItemScope() {
		return UserDomainBaseSecondaryListItemScope;
	}

	protected static SerializeScope UserWhiteListBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		;
	/** 用于UserWhiteList的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListSecondaryListItemScope() {
		return UserWhiteListBaseSecondaryListItemScope;
	}

	protected static SerializeScope SecUserBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SecUser.ID_PROPERTY)
		.field(SecUser.LOGIN_PROPERTY)
		.field(SecUser.MOBILE_PROPERTY)
		.field(SecUser.EMAIL_PROPERTY)
		.field(SecUser.PWD_PROPERTY)
		.field(SecUser.WEIXIN_OPENID_PROPERTY)
		.field(SecUser.WEIXIN_APPID_PROPERTY)
		.field(SecUser.ACCESS_TOKEN_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
		.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于SecUser的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSecUserSecondaryListItemScope() {
		return SecUserBaseSecondaryListItemScope;
	}

	protected static SerializeScope UserAppBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		;
	/** 用于UserApp的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserAppSecondaryListItemScope() {
		return UserAppBaseSecondaryListItemScope;
	}

	protected static SerializeScope QuickLinkBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		;
	/** 用于QuickLink的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkSecondaryListItemScope() {
		return QuickLinkBaseSecondaryListItemScope;
	}

	protected static SerializeScope ListAccessBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		;
	/** 用于ListAccess的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getListAccessSecondaryListItemScope() {
		return ListAccessBaseSecondaryListItemScope;
	}

	protected static SerializeScope LoginHistoryBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		;
	/** 用于LoginHistory的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLoginHistorySecondaryListItemScope() {
		return LoginHistoryBaseSecondaryListItemScope;
	}

	protected static SerializeScope CandidateContainerBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		;
	/** 用于CandidateContainer的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerSecondaryListItemScope() {
		return CandidateContainerBaseSecondaryListItemScope;
	}

	protected static SerializeScope CandidateElementBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		;
	/** 用于CandidateElement的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementSecondaryListItemScope() {
		return CandidateElementBaseSecondaryListItemScope;
	}

	protected static SerializeScope WechatWorkappIdentifyBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(WechatWorkappIdentify.ID_PROPERTY)
		.field(WechatWorkappIdentify.CORP_ID_PROPERTY)
		.field(WechatWorkappIdentify.USER_ID_PROPERTY)
		.field(WechatWorkappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatWorkappIdentify的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getWechatWorkappIdentifySecondaryListItemScope() {
		return WechatWorkappIdentifyBaseSecondaryListItemScope;
	}

	protected static SerializeScope WechatMiniappIdentifyBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(WechatMiniappIdentify.ID_PROPERTY)
		.field(WechatMiniappIdentify.OPEN_ID_PROPERTY)
		.field(WechatMiniappIdentify.APP_ID_PROPERTY)
		.field(WechatMiniappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatMiniappIdentify的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getWechatMiniappIdentifySecondaryListItemScope() {
		return WechatMiniappIdentifyBaseSecondaryListItemScope;
	}

	protected static SerializeScope KeypairIdentifyBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(KeypairIdentify.ID_PROPERTY)
		.field(KeypairIdentify.PUBLIC_KEY_PROPERTY)
		.field(KeypairIdentify.CREATE_TIME_PROPERTY)
		;
	/** 用于KeypairIdentify的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getKeypairIdentifySecondaryListItemScope() {
		return KeypairIdentifyBaseSecondaryListItemScope;
	}

	protected static SerializeScope PublicKeyTypeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PublicKeyType.ID_PROPERTY)
		.field(PublicKeyType.NAME_PROPERTY)
		.field(PublicKeyType.CODE_PROPERTY)
		;
	/** 用于PublicKeyType的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPublicKeyTypeSecondaryListItemScope() {
		return PublicKeyTypeBaseSecondaryListItemScope;
	}

	protected static SerializeScope TreeNodeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TreeNode.ID_PROPERTY)
		.field(TreeNode.NODE_ID_PROPERTY)
		.field(TreeNode.NODE_TYPE_PROPERTY)
		.field(TreeNode.LEFT_VALUE_PROPERTY)
		.field(TreeNode.RIGHT_VALUE_PROPERTY)
		;
	/** 用于TreeNode的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTreeNodeSecondaryListItemScope() {
		return TreeNodeBaseSecondaryListItemScope;
	}

	protected static SerializeScope RetailStoreCountryCenterBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreCountryCenter.ID_PROPERTY)
		.field(RetailStoreCountryCenter.NAME_PROPERTY)
		.field(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY)
		.field(RetailStoreCountryCenter.FOUNDED_PROPERTY)
		.field(RetailStoreCountryCenter.WEB_SITE_PROPERTY)
		.field(RetailStoreCountryCenter.ADDRESS_PROPERTY)
		.field(RetailStoreCountryCenter.OPERATED_BY_PROPERTY)
		.field(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY)
		.field(RetailStoreCountryCenter.DESCRIPTION_PROPERTY)
		.field(RetailStoreCountryCenter.CATALOG_LIST, getCatalogSecondaryListItemScope())
		.field(RetailStoreCountryCenter.RETAIL_STORE_PROVINCE_CENTER_LIST, getRetailStoreProvinceCenterSecondaryListItemScope())
		.field(RetailStoreCountryCenter.RETAIL_STORE_LIST, getRetailStoreSecondaryListItemScope())
		.field(RetailStoreCountryCenter.RETAIL_STORE_MEMBER_LIST, getRetailStoreMemberSecondaryListItemScope())
		.field(RetailStoreCountryCenter.GOODS_SUPPLIER_LIST, getGoodsSupplierSecondaryListItemScope())
		.field(RetailStoreCountryCenter.SUPPLY_ORDER_LIST, getSupplyOrderSecondaryListItemScope())
		.field(RetailStoreCountryCenter.RETAIL_STORE_ORDER_LIST, getRetailStoreOrderSecondaryListItemScope())
		.field(RetailStoreCountryCenter.WAREHOUSE_LIST, getWarehouseSecondaryListItemScope())
		.field(RetailStoreCountryCenter.TRANSPORT_FLEET_LIST, getTransportFleetSecondaryListItemScope())
		.field(RetailStoreCountryCenter.ACCOUNT_SET_LIST, getAccountSetSecondaryListItemScope())
		.field(RetailStoreCountryCenter.LEVEL_ONE_DEPARTMENT_LIST, getLevelOneDepartmentSecondaryListItemScope())
		.field(RetailStoreCountryCenter.SKILL_TYPE_LIST, getSkillTypeSecondaryListItemScope())
		.field(RetailStoreCountryCenter.RESPONSIBILITY_TYPE_LIST, getResponsibilityTypeSecondaryListItemScope())
		.field(RetailStoreCountryCenter.TERMINATION_REASON_LIST, getTerminationReasonSecondaryListItemScope())
		.field(RetailStoreCountryCenter.TERMINATION_TYPE_LIST, getTerminationTypeSecondaryListItemScope())
		.field(RetailStoreCountryCenter.OCCUPATION_TYPE_LIST, getOccupationTypeSecondaryListItemScope())
		.field(RetailStoreCountryCenter.LEAVE_TYPE_LIST, getLeaveTypeSecondaryListItemScope())
		.field(RetailStoreCountryCenter.SALARY_GRADE_LIST, getSalaryGradeSecondaryListItemScope())
		.field(RetailStoreCountryCenter.INTERVIEW_TYPE_LIST, getInterviewTypeSecondaryListItemScope())
		.field(RetailStoreCountryCenter.TRAINING_COURSE_TYPE_LIST, getTrainingCourseTypeSecondaryListItemScope())
		.field(RetailStoreCountryCenter.PUBLIC_HOLIDAY_LIST, getPublicHolidaySecondaryListItemScope())
		.field(RetailStoreCountryCenter.EMPLOYEE_LIST, getEmployeeSecondaryListItemScope())
		.field(RetailStoreCountryCenter.INSTRUCTOR_LIST, getInstructorSecondaryListItemScope())
		.field(RetailStoreCountryCenter.COMPANY_TRAINING_LIST, getCompanyTrainingSecondaryListItemScope())
		;
	/** 用于RetailStoreCountryCenter对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreCountryCenterListItemScope() {
		return RetailStoreCountryCenterBaseListItemScope;
	}

	protected static SerializeScope CatalogBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Catalog.ID_PROPERTY)
		.field(Catalog.NAME_PROPERTY)
		.field(Catalog.OWNER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(Catalog.SUB_COUNT_PROPERTY)
		.field(Catalog.AMOUNT_PROPERTY)
		.field(Catalog.LEVEL_ONE_CATEGORY_LIST, getLevelOneCategorySecondaryListItemScope())
		;
	/** 用于Catalog对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCatalogListItemScope() {
		return CatalogBaseListItemScope;
	}

	protected static SerializeScope LevelOneCategoryBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelOneCategory.ID_PROPERTY)
		.field(LevelOneCategory.CATALOG_PROPERTY, getCatalogSummaryScope())
		.field(LevelOneCategory.NAME_PROPERTY)
		.field(LevelOneCategory.LEVEL_TWO_CATEGORY_LIST, getLevelTwoCategorySecondaryListItemScope())
		;
	/** 用于LevelOneCategory对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLevelOneCategoryListItemScope() {
		return LevelOneCategoryBaseListItemScope;
	}

	protected static SerializeScope LevelTwoCategoryBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelTwoCategory.ID_PROPERTY)
		.field(LevelTwoCategory.PARENT_CATEGORY_PROPERTY, getLevelOneCategorySummaryScope())
		.field(LevelTwoCategory.NAME_PROPERTY)
		.field(LevelTwoCategory.LEVEL_THREE_CATEGORY_LIST, getLevelThreeCategorySecondaryListItemScope())
		;
	/** 用于LevelTwoCategory对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLevelTwoCategoryListItemScope() {
		return LevelTwoCategoryBaseListItemScope;
	}

	protected static SerializeScope LevelThreeCategoryBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelThreeCategory.ID_PROPERTY)
		.field(LevelThreeCategory.PARENT_CATEGORY_PROPERTY, getLevelTwoCategorySummaryScope())
		.field(LevelThreeCategory.NAME_PROPERTY)
		.field(LevelThreeCategory.PRODUCT_LIST, getProductSecondaryListItemScope())
		;
	/** 用于LevelThreeCategory对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLevelThreeCategoryListItemScope() {
		return LevelThreeCategoryBaseListItemScope;
	}

	protected static SerializeScope ProductBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Product.ID_PROPERTY)
		.field(Product.NAME_PROPERTY)
		.field(Product.PARENT_CATEGORY_PROPERTY, getLevelThreeCategorySummaryScope())
		.field(Product.ORIGIN_PROPERTY)
		.field(Product.REMARK_PROPERTY)
		.field(Product.BRAND_PROPERTY)
		.field(Product.PICTURE_PROPERTY)
		.field(Product.LAST_UPDATE_TIME_PROPERTY)
		.field(Product.SKU_LIST, getSkuSecondaryListItemScope())
		;
	/** 用于Product对象的列表时需要序列化的属性列表 */
	public static SerializeScope getProductListItemScope() {
		return ProductBaseListItemScope;
	}

	protected static SerializeScope SkuBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Sku.ID_PROPERTY)
		.field(Sku.NAME_PROPERTY)
		.field(Sku.SIZE_PROPERTY)
		.field(Sku.PRODUCT_PROPERTY, getProductSummaryScope())
		.field(Sku.BARCODE_PROPERTY)
		.field(Sku.PACKAGE_TYPE_PROPERTY)
		.field(Sku.NET_CONTENT_PROPERTY)
		.field(Sku.PRICE_PROPERTY)
		.field(Sku.PICTURE_PROPERTY)
		.field(Sku.GOODS_LIST, getGoodsSecondaryListItemScope())
		;
	/** 用于Sku对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSkuListItemScope() {
		return SkuBaseListItemScope;
	}

	protected static SerializeScope RetailStoreProvinceCenterBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreProvinceCenter.ID_PROPERTY)
		.field(RetailStoreProvinceCenter.NAME_PROPERTY)
		.field(RetailStoreProvinceCenter.FOUNDED_PROPERTY)
		.field(RetailStoreProvinceCenter.COUNTRY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(RetailStoreProvinceCenter.LAST_UPDATE_TIME_PROPERTY)
		.field(RetailStoreProvinceCenter.PROVINCE_CENTER_DEPARTMENT_LIST, getProvinceCenterDepartmentSecondaryListItemScope())
		.field(RetailStoreProvinceCenter.PROVINCE_CENTER_EMPLOYEE_LIST, getProvinceCenterEmployeeSecondaryListItemScope())
		.field(RetailStoreProvinceCenter.RETAIL_STORE_CITY_SERVICE_CENTER_LIST, getRetailStoreCityServiceCenterSecondaryListItemScope())
		;
	/** 用于RetailStoreProvinceCenter对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreProvinceCenterListItemScope() {
		return RetailStoreProvinceCenterBaseListItemScope;
	}

	protected static SerializeScope ProvinceCenterDepartmentBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ProvinceCenterDepartment.ID_PROPERTY)
		.field(ProvinceCenterDepartment.NAME_PROPERTY)
		.field(ProvinceCenterDepartment.FOUNDED_PROPERTY)
		.field(ProvinceCenterDepartment.PROVINCE_CENTER_PROPERTY, getRetailStoreProvinceCenterSummaryScope())
		.field(ProvinceCenterDepartment.MANAGER_PROPERTY)
		.field(ProvinceCenterDepartment.PROVINCE_CENTER_EMPLOYEE_LIST, getProvinceCenterEmployeeSecondaryListItemScope())
		;
	/** 用于ProvinceCenterDepartment对象的列表时需要序列化的属性列表 */
	public static SerializeScope getProvinceCenterDepartmentListItemScope() {
		return ProvinceCenterDepartmentBaseListItemScope;
	}

	protected static SerializeScope ProvinceCenterEmployeeBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ProvinceCenterEmployee.ID_PROPERTY)
		.field(ProvinceCenterEmployee.NAME_PROPERTY)
		.field(ProvinceCenterEmployee.MOBILE_PROPERTY)
		.field(ProvinceCenterEmployee.EMAIL_PROPERTY)
		.field(ProvinceCenterEmployee.FOUNDED_PROPERTY)
		.field(ProvinceCenterEmployee.DEPARTMENT_PROPERTY, getProvinceCenterDepartmentSummaryScope())
		.field(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY, getRetailStoreProvinceCenterSummaryScope())
		;
	/** 用于ProvinceCenterEmployee对象的列表时需要序列化的属性列表 */
	public static SerializeScope getProvinceCenterEmployeeListItemScope() {
		return ProvinceCenterEmployeeBaseListItemScope;
	}

	protected static SerializeScope RetailStoreCityServiceCenterBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreCityServiceCenter.ID_PROPERTY)
		.field(RetailStoreCityServiceCenter.NAME_PROPERTY)
		.field(RetailStoreCityServiceCenter.FOUNDED_PROPERTY)
		.field(RetailStoreCityServiceCenter.BELONGS_TO_PROPERTY, getRetailStoreProvinceCenterSummaryScope())
		.field(RetailStoreCityServiceCenter.LAST_UPDATE_TIME_PROPERTY)
		.field(RetailStoreCityServiceCenter.CITY_PARTNER_LIST, getCityPartnerSecondaryListItemScope())
		.field(RetailStoreCityServiceCenter.POTENTIAL_CUSTOMER_LIST, getPotentialCustomerSecondaryListItemScope())
		.field(RetailStoreCityServiceCenter.CITY_EVENT_LIST, getCityEventSecondaryListItemScope())
		.field(RetailStoreCityServiceCenter.RETAIL_STORE_LIST, getRetailStoreSecondaryListItemScope())
		;
	/** 用于RetailStoreCityServiceCenter对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreCityServiceCenterListItemScope() {
		return RetailStoreCityServiceCenterBaseListItemScope;
	}

	protected static SerializeScope CityPartnerBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(CityPartner.ID_PROPERTY)
		.field(CityPartner.NAME_PROPERTY)
		.field(CityPartner.MOBILE_PROPERTY)
		.field(CityPartner.CITY_SERVICE_CENTER_PROPERTY, getRetailStoreCityServiceCenterSummaryScope())
		.field(CityPartner.DESCRIPTION_PROPERTY)
		.field(CityPartner.LAST_UPDATE_TIME_PROPERTY)
		.field(CityPartner.POTENTIAL_CUSTOMER_LIST, getPotentialCustomerSecondaryListItemScope())
		.field(CityPartner.POTENTIAL_CUSTOMER_CONTACT_LIST, getPotentialCustomerContactSecondaryListItemScope())
		;
	/** 用于CityPartner对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCityPartnerListItemScope() {
		return CityPartnerBaseListItemScope;
	}

	protected static SerializeScope PotentialCustomerBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomer.ID_PROPERTY)
		.field(PotentialCustomer.NAME_PROPERTY)
		.field(PotentialCustomer.MOBILE_PROPERTY)
		.field(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, getRetailStoreCityServiceCenterSummaryScope())
		.field(PotentialCustomer.CITY_PARTNER_PROPERTY, getCityPartnerSummaryScope())
		.field(PotentialCustomer.DESCRIPTION_PROPERTY)
		.field(PotentialCustomer.LAST_UPDATE_TIME_PROPERTY)
		.field(PotentialCustomer.POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST, getPotentialCustomerContactPersonSecondaryListItemScope())
		.field(PotentialCustomer.POTENTIAL_CUSTOMER_CONTACT_LIST, getPotentialCustomerContactSecondaryListItemScope())
		.field(PotentialCustomer.EVENT_ATTENDANCE_LIST, getEventAttendanceSecondaryListItemScope())
		;
	/** 用于PotentialCustomer对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerListItemScope() {
		return PotentialCustomerBaseListItemScope;
	}

	protected static SerializeScope PotentialCustomerContactPersonBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomerContactPerson.ID_PROPERTY)
		.field(PotentialCustomerContactPerson.NAME_PROPERTY)
		.field(PotentialCustomerContactPerson.MOBILE_PROPERTY)
		.field(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomerSummaryScope())
		.field(PotentialCustomerContactPerson.DESCRIPTION_PROPERTY)
		.field(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_CONTACT_LIST, getPotentialCustomerContactSecondaryListItemScope())
		;
	/** 用于PotentialCustomerContactPerson对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerContactPersonListItemScope() {
		return PotentialCustomerContactPersonBaseListItemScope;
	}

	protected static SerializeScope PotentialCustomerContactBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomerContact.ID_PROPERTY)
		.field(PotentialCustomerContact.NAME_PROPERTY)
		.field(PotentialCustomerContact.CONTACT_DATE_PROPERTY)
		.field(PotentialCustomerContact.CONTACT_METHOD_PROPERTY)
		.field(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomerSummaryScope())
		.field(PotentialCustomerContact.CITY_PARTNER_PROPERTY, getCityPartnerSummaryScope())
		.field(PotentialCustomerContact.CONTACT_TO_PROPERTY, getPotentialCustomerContactPersonSummaryScope())
		.field(PotentialCustomerContact.DESCRIPTION_PROPERTY)
		.field(PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于PotentialCustomerContact对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerContactListItemScope() {
		return PotentialCustomerContactBaseListItemScope;
	}

	protected static SerializeScope CityEventBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(CityEvent.ID_PROPERTY)
		.field(CityEvent.NAME_PROPERTY)
		.field(CityEvent.MOBILE_PROPERTY)
		.field(CityEvent.CITY_SERVICE_CENTER_PROPERTY, getRetailStoreCityServiceCenterSummaryScope())
		.field(CityEvent.DESCRIPTION_PROPERTY)
		.field(CityEvent.LAST_UPDATE_TIME_PROPERTY)
		.field(CityEvent.EVENT_ATTENDANCE_LIST, getEventAttendanceSecondaryListItemScope())
		;
	/** 用于CityEvent对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCityEventListItemScope() {
		return CityEventBaseListItemScope;
	}

	protected static SerializeScope EventAttendanceBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EventAttendance.ID_PROPERTY)
		.field(EventAttendance.NAME_PROPERTY)
		.field(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomerSummaryScope())
		.field(EventAttendance.CITY_EVENT_PROPERTY, getCityEventSummaryScope())
		.field(EventAttendance.DESCRIPTION_PROPERTY)
		;
	/** 用于EventAttendance对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEventAttendanceListItemScope() {
		return EventAttendanceBaseListItemScope;
	}

	protected static SerializeScope RetailStoreBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStore.ID_PROPERTY)
		.field(RetailStore.NAME_PROPERTY)
		.field(RetailStore.TELEPHONE_PROPERTY)
		.field(RetailStore.OWNER_PROPERTY)
		.field(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(RetailStore.CITY_SERVICE_CENTER_PROPERTY, getRetailStoreCityServiceCenterSummaryScope())
		.field(RetailStore.CREATION_PROPERTY, getRetailStoreCreationSummaryScope())
		.field(RetailStore.INVESTMENT_INVITATION_PROPERTY, getRetailStoreInvestmentInvitationSummaryScope())
		.field(RetailStore.FRANCHISING_PROPERTY, getRetailStoreFranchisingSummaryScope())
		.field(RetailStore.DECORATION_PROPERTY, getRetailStoreDecorationSummaryScope())
		.field(RetailStore.OPENING_PROPERTY, getRetailStoreOpeningSummaryScope())
		.field(RetailStore.CLOSING_PROPERTY, getRetailStoreClosingSummaryScope())
		.field(RetailStore.FOUNDED_PROPERTY)
		.field(RetailStore.LATITUDE_PROPERTY)
		.field(RetailStore.LONGITUDE_PROPERTY)
		.field(RetailStore.DESCRIPTION_PROPERTY)
		.field(RetailStore.LAST_UPDATE_TIME_PROPERTY)
		.field(RetailStore.CONSUMER_ORDER_LIST, getConsumerOrderSecondaryListItemScope())
		.field(RetailStore.RETAIL_STORE_ORDER_LIST, getRetailStoreOrderSecondaryListItemScope())
		.field(RetailStore.GOODS_LIST, getGoodsSecondaryListItemScope())
		.field(RetailStore.TRANSPORT_TASK_LIST, getTransportTaskSecondaryListItemScope())
		.field(RetailStore.ACCOUNT_SET_LIST, getAccountSetSecondaryListItemScope())
		;
	/** 用于RetailStore对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreListItemScope() {
		return RetailStoreBaseListItemScope;
	}

	protected static SerializeScope RetailStoreCreationBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreCreation.ID_PROPERTY)
		.field(RetailStoreCreation.COMMENT_PROPERTY)
		.field(RetailStoreCreation.RETAIL_STORE_LIST, getRetailStoreSecondaryListItemScope())
		;
	/** 用于RetailStoreCreation对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreCreationListItemScope() {
		return RetailStoreCreationBaseListItemScope;
	}

	protected static SerializeScope RetailStoreInvestmentInvitationBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreInvestmentInvitation.ID_PROPERTY)
		.field(RetailStoreInvestmentInvitation.COMMENT_PROPERTY)
		.field(RetailStoreInvestmentInvitation.RETAIL_STORE_LIST, getRetailStoreSecondaryListItemScope())
		;
	/** 用于RetailStoreInvestmentInvitation对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreInvestmentInvitationListItemScope() {
		return RetailStoreInvestmentInvitationBaseListItemScope;
	}

	protected static SerializeScope RetailStoreFranchisingBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreFranchising.ID_PROPERTY)
		.field(RetailStoreFranchising.COMMENT_PROPERTY)
		.field(RetailStoreFranchising.RETAIL_STORE_LIST, getRetailStoreSecondaryListItemScope())
		;
	/** 用于RetailStoreFranchising对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreFranchisingListItemScope() {
		return RetailStoreFranchisingBaseListItemScope;
	}

	protected static SerializeScope RetailStoreDecorationBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreDecoration.ID_PROPERTY)
		.field(RetailStoreDecoration.COMMENT_PROPERTY)
		.field(RetailStoreDecoration.RETAIL_STORE_LIST, getRetailStoreSecondaryListItemScope())
		;
	/** 用于RetailStoreDecoration对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreDecorationListItemScope() {
		return RetailStoreDecorationBaseListItemScope;
	}

	protected static SerializeScope RetailStoreOpeningBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreOpening.ID_PROPERTY)
		.field(RetailStoreOpening.COMMENT_PROPERTY)
		.field(RetailStoreOpening.RETAIL_STORE_LIST, getRetailStoreSecondaryListItemScope())
		;
	/** 用于RetailStoreOpening对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreOpeningListItemScope() {
		return RetailStoreOpeningBaseListItemScope;
	}

	protected static SerializeScope RetailStoreClosingBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreClosing.ID_PROPERTY)
		.field(RetailStoreClosing.COMMENT_PROPERTY)
		.field(RetailStoreClosing.RETAIL_STORE_LIST, getRetailStoreSecondaryListItemScope())
		;
	/** 用于RetailStoreClosing对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreClosingListItemScope() {
		return RetailStoreClosingBaseListItemScope;
	}

	protected static SerializeScope RetailStoreMemberBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreMember.ID_PROPERTY)
		.field(RetailStoreMember.NAME_PROPERTY)
		.field(RetailStoreMember.MOBILE_PHONE_PROPERTY)
		.field(RetailStoreMember.OWNER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(RetailStoreMember.CONSUMER_ORDER_LIST, getConsumerOrderSecondaryListItemScope())
		.field(RetailStoreMember.RETAIL_STORE_MEMBER_COUPON_LIST, getRetailStoreMemberCouponSecondaryListItemScope())
		.field(RetailStoreMember.MEMBER_WISHLIST_LIST, getMemberWishlistSecondaryListItemScope())
		.field(RetailStoreMember.MEMBER_REWARD_POINT_LIST, getMemberRewardPointSecondaryListItemScope())
		.field(RetailStoreMember.MEMBER_REWARD_POINT_REDEMPTION_LIST, getMemberRewardPointRedemptionSecondaryListItemScope())
		.field(RetailStoreMember.RETAIL_STORE_MEMBER_ADDRESS_LIST, getRetailStoreMemberAddressSecondaryListItemScope())
		.field(RetailStoreMember.RETAIL_STORE_MEMBER_GIFT_CARD_LIST, getRetailStoreMemberGiftCardSecondaryListItemScope())
		;
	/** 用于RetailStoreMember对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreMemberListItemScope() {
		return RetailStoreMemberBaseListItemScope;
	}

	protected static SerializeScope ConsumerOrderBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ConsumerOrder.ID_PROPERTY)
		.field(ConsumerOrder.TITLE_PROPERTY)
		.field(ConsumerOrder.CONSUMER_PROPERTY, getRetailStoreMemberSummaryScope())
		.field(ConsumerOrder.STORE_PROPERTY, getRetailStoreSummaryScope())
		.field(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY)
		.field(ConsumerOrder.CONSUMER_ORDER_LINE_ITEM_LIST, getConsumerOrderLineItemSecondaryListItemScope())
		.field(ConsumerOrder.CONSUMER_ORDER_SHIPPING_GROUP_LIST, getConsumerOrderShippingGroupSecondaryListItemScope())
		.field(ConsumerOrder.CONSUMER_ORDER_PAYMENT_GROUP_LIST, getConsumerOrderPaymentGroupSecondaryListItemScope())
		.field(ConsumerOrder.CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST, getConsumerOrderPriceAdjustmentSecondaryListItemScope())
		.field(ConsumerOrder.RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST, getRetailStoreMemberGiftCardConsumeRecordSecondaryListItemScope())
		;
	/** 用于ConsumerOrder对象的列表时需要序列化的属性列表 */
	public static SerializeScope getConsumerOrderListItemScope() {
		return ConsumerOrderBaseListItemScope;
	}

	protected static SerializeScope ConsumerOrderLineItemBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ConsumerOrderLineItem.ID_PROPERTY)
		.field(ConsumerOrderLineItem.BIZ_ORDER_PROPERTY, getConsumerOrderSummaryScope())
		.field(ConsumerOrderLineItem.SKU_ID_PROPERTY)
		.field(ConsumerOrderLineItem.SKU_NAME_PROPERTY)
		.field(ConsumerOrderLineItem.PRICE_PROPERTY)
		.field(ConsumerOrderLineItem.QUANTITY_PROPERTY)
		.field(ConsumerOrderLineItem.AMOUNT_PROPERTY)
		.field(ConsumerOrderLineItem.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于ConsumerOrderLineItem对象的列表时需要序列化的属性列表 */
	public static SerializeScope getConsumerOrderLineItemListItemScope() {
		return ConsumerOrderLineItemBaseListItemScope;
	}

	protected static SerializeScope ConsumerOrderShippingGroupBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ConsumerOrderShippingGroup.ID_PROPERTY)
		.field(ConsumerOrderShippingGroup.NAME_PROPERTY)
		.field(ConsumerOrderShippingGroup.BIZ_ORDER_PROPERTY, getConsumerOrderSummaryScope())
		.field(ConsumerOrderShippingGroup.AMOUNT_PROPERTY)
		;
	/** 用于ConsumerOrderShippingGroup对象的列表时需要序列化的属性列表 */
	public static SerializeScope getConsumerOrderShippingGroupListItemScope() {
		return ConsumerOrderShippingGroupBaseListItemScope;
	}

	protected static SerializeScope ConsumerOrderPaymentGroupBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ConsumerOrderPaymentGroup.ID_PROPERTY)
		.field(ConsumerOrderPaymentGroup.NAME_PROPERTY)
		.field(ConsumerOrderPaymentGroup.BIZ_ORDER_PROPERTY, getConsumerOrderSummaryScope())
		.field(ConsumerOrderPaymentGroup.CARD_NUMBER_PROPERTY)
		;
	/** 用于ConsumerOrderPaymentGroup对象的列表时需要序列化的属性列表 */
	public static SerializeScope getConsumerOrderPaymentGroupListItemScope() {
		return ConsumerOrderPaymentGroupBaseListItemScope;
	}

	protected static SerializeScope ConsumerOrderPriceAdjustmentBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ConsumerOrderPriceAdjustment.ID_PROPERTY)
		.field(ConsumerOrderPriceAdjustment.NAME_PROPERTY)
		.field(ConsumerOrderPriceAdjustment.BIZ_ORDER_PROPERTY, getConsumerOrderSummaryScope())
		.field(ConsumerOrderPriceAdjustment.AMOUNT_PROPERTY)
		.field(ConsumerOrderPriceAdjustment.PROVIDER_PROPERTY)
		;
	/** 用于ConsumerOrderPriceAdjustment对象的列表时需要序列化的属性列表 */
	public static SerializeScope getConsumerOrderPriceAdjustmentListItemScope() {
		return ConsumerOrderPriceAdjustmentBaseListItemScope;
	}

	protected static SerializeScope RetailStoreMemberCouponBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreMemberCoupon.ID_PROPERTY)
		.field(RetailStoreMemberCoupon.NAME_PROPERTY)
		.field(RetailStoreMemberCoupon.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
		.field(RetailStoreMemberCoupon.NUMBER_PROPERTY)
		.field(RetailStoreMemberCoupon.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于RetailStoreMemberCoupon对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreMemberCouponListItemScope() {
		return RetailStoreMemberCouponBaseListItemScope;
	}

	protected static SerializeScope MemberWishlistBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(MemberWishlist.ID_PROPERTY)
		.field(MemberWishlist.NAME_PROPERTY)
		.field(MemberWishlist.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
		.field(MemberWishlist.MEMBER_WISHLIST_PRODUCT_LIST, getMemberWishlistProductSecondaryListItemScope())
		;
	/** 用于MemberWishlist对象的列表时需要序列化的属性列表 */
	public static SerializeScope getMemberWishlistListItemScope() {
		return MemberWishlistBaseListItemScope;
	}

	protected static SerializeScope MemberRewardPointBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(MemberRewardPoint.ID_PROPERTY)
		.field(MemberRewardPoint.NAME_PROPERTY)
		.field(MemberRewardPoint.POINT_PROPERTY)
		.field(MemberRewardPoint.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
		;
	/** 用于MemberRewardPoint对象的列表时需要序列化的属性列表 */
	public static SerializeScope getMemberRewardPointListItemScope() {
		return MemberRewardPointBaseListItemScope;
	}

	protected static SerializeScope MemberRewardPointRedemptionBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(MemberRewardPointRedemption.ID_PROPERTY)
		.field(MemberRewardPointRedemption.NAME_PROPERTY)
		.field(MemberRewardPointRedemption.POINT_PROPERTY)
		.field(MemberRewardPointRedemption.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
		;
	/** 用于MemberRewardPointRedemption对象的列表时需要序列化的属性列表 */
	public static SerializeScope getMemberRewardPointRedemptionListItemScope() {
		return MemberRewardPointRedemptionBaseListItemScope;
	}

	protected static SerializeScope MemberWishlistProductBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(MemberWishlistProduct.ID_PROPERTY)
		.field(MemberWishlistProduct.NAME_PROPERTY)
		.field(MemberWishlistProduct.OWNER_PROPERTY, getMemberWishlistSummaryScope())
		;
	/** 用于MemberWishlistProduct对象的列表时需要序列化的属性列表 */
	public static SerializeScope getMemberWishlistProductListItemScope() {
		return MemberWishlistProductBaseListItemScope;
	}

	protected static SerializeScope RetailStoreMemberAddressBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreMemberAddress.ID_PROPERTY)
		.field(RetailStoreMemberAddress.NAME_PROPERTY)
		.field(RetailStoreMemberAddress.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
		.field(RetailStoreMemberAddress.MOBILE_PHONE_PROPERTY)
		.field(RetailStoreMemberAddress.ADDRESS_PROPERTY)
		;
	/** 用于RetailStoreMemberAddress对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreMemberAddressListItemScope() {
		return RetailStoreMemberAddressBaseListItemScope;
	}

	protected static SerializeScope RetailStoreMemberGiftCardBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreMemberGiftCard.ID_PROPERTY)
		.field(RetailStoreMemberGiftCard.NAME_PROPERTY)
		.field(RetailStoreMemberGiftCard.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
		.field(RetailStoreMemberGiftCard.NUMBER_PROPERTY)
		.field(RetailStoreMemberGiftCard.REMAIN_PROPERTY)
		.field(RetailStoreMemberGiftCard.RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST, getRetailStoreMemberGiftCardConsumeRecordSecondaryListItemScope())
		;
	/** 用于RetailStoreMemberGiftCard对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreMemberGiftCardListItemScope() {
		return RetailStoreMemberGiftCardBaseListItemScope;
	}

	protected static SerializeScope RetailStoreMemberGiftCardConsumeRecordBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY)
		.field(RetailStoreMemberGiftCardConsumeRecord.OCCURE_TIME_PROPERTY)
		.field(RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY, getRetailStoreMemberGiftCardSummaryScope())
		.field(RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY, getConsumerOrderSummaryScope())
		.field(RetailStoreMemberGiftCardConsumeRecord.NUMBER_PROPERTY)
		.field(RetailStoreMemberGiftCardConsumeRecord.AMOUNT_PROPERTY)
		;
	/** 用于RetailStoreMemberGiftCardConsumeRecord对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreMemberGiftCardConsumeRecordListItemScope() {
		return RetailStoreMemberGiftCardConsumeRecordBaseListItemScope;
	}

	protected static SerializeScope GoodsSupplierBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(GoodsSupplier.ID_PROPERTY)
		.field(GoodsSupplier.NAME_PROPERTY)
		.field(GoodsSupplier.SUPPLY_PRODUCT_PROPERTY)
		.field(GoodsSupplier.BELONG_TO_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(GoodsSupplier.CONTACT_NUMBER_PROPERTY)
		.field(GoodsSupplier.DESCRIPTION_PROPERTY)
		.field(GoodsSupplier.LAST_UPDATE_TIME_PROPERTY)
		.field(GoodsSupplier.SUPPLIER_PRODUCT_LIST, getSupplierProductSecondaryListItemScope())
		.field(GoodsSupplier.SUPPLY_ORDER_LIST, getSupplyOrderSecondaryListItemScope())
		.field(GoodsSupplier.ACCOUNT_SET_LIST, getAccountSetSecondaryListItemScope())
		;
	/** 用于GoodsSupplier对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGoodsSupplierListItemScope() {
		return GoodsSupplierBaseListItemScope;
	}

	protected static SerializeScope SupplierProductBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplierProduct.ID_PROPERTY)
		.field(SupplierProduct.PRODUCT_NAME_PROPERTY)
		.field(SupplierProduct.PRODUCT_DESCRIPTION_PROPERTY)
		.field(SupplierProduct.PRODUCT_UNIT_PROPERTY)
		.field(SupplierProduct.SUPPLIER_PROPERTY, getGoodsSupplierSummaryScope())
		.field(SupplierProduct.PRODUCT_SUPPLY_DURATION_LIST, getProductSupplyDurationSecondaryListItemScope())
		;
	/** 用于SupplierProduct对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSupplierProductListItemScope() {
		return SupplierProductBaseListItemScope;
	}

	protected static SerializeScope ProductSupplyDurationBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ProductSupplyDuration.ID_PROPERTY)
		.field(ProductSupplyDuration.QUANTITY_PROPERTY)
		.field(ProductSupplyDuration.DURATION_PROPERTY)
		.field(ProductSupplyDuration.PRICE_PROPERTY)
		.field(ProductSupplyDuration.PRODUCT_PROPERTY, getSupplierProductSummaryScope())
		;
	/** 用于ProductSupplyDuration对象的列表时需要序列化的属性列表 */
	public static SerializeScope getProductSupplyDurationListItemScope() {
		return ProductSupplyDurationBaseListItemScope;
	}

	protected static SerializeScope SupplyOrderBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplyOrder.ID_PROPERTY)
		.field(SupplyOrder.BUYER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(SupplyOrder.SELLER_PROPERTY, getGoodsSupplierSummaryScope())
		.field(SupplyOrder.TITLE_PROPERTY)
		.field(SupplyOrder.TOTAL_AMOUNT_PROPERTY)
		.field(SupplyOrder.LAST_UPDATE_TIME_PROPERTY)
		.field(SupplyOrder.SUPPLY_ORDER_LINE_ITEM_LIST, getSupplyOrderLineItemSecondaryListItemScope())
		.field(SupplyOrder.SUPPLY_ORDER_SHIPPING_GROUP_LIST, getSupplyOrderShippingGroupSecondaryListItemScope())
		.field(SupplyOrder.SUPPLY_ORDER_PAYMENT_GROUP_LIST, getSupplyOrderPaymentGroupSecondaryListItemScope())
		.field(SupplyOrder.GOODS_LIST, getGoodsSecondaryListItemScope())
		;
	/** 用于SupplyOrder对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSupplyOrderListItemScope() {
		return SupplyOrderBaseListItemScope;
	}

	protected static SerializeScope SupplyOrderLineItemBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplyOrderLineItem.ID_PROPERTY)
		.field(SupplyOrderLineItem.BIZ_ORDER_PROPERTY, getSupplyOrderSummaryScope())
		.field(SupplyOrderLineItem.SKU_ID_PROPERTY)
		.field(SupplyOrderLineItem.SKU_NAME_PROPERTY)
		.field(SupplyOrderLineItem.AMOUNT_PROPERTY)
		.field(SupplyOrderLineItem.QUANTITY_PROPERTY)
		.field(SupplyOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY)
		;
	/** 用于SupplyOrderLineItem对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSupplyOrderLineItemListItemScope() {
		return SupplyOrderLineItemBaseListItemScope;
	}

	protected static SerializeScope SupplyOrderShippingGroupBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplyOrderShippingGroup.ID_PROPERTY)
		.field(SupplyOrderShippingGroup.NAME_PROPERTY)
		.field(SupplyOrderShippingGroup.BIZ_ORDER_PROPERTY, getSupplyOrderSummaryScope())
		.field(SupplyOrderShippingGroup.AMOUNT_PROPERTY)
		;
	/** 用于SupplyOrderShippingGroup对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSupplyOrderShippingGroupListItemScope() {
		return SupplyOrderShippingGroupBaseListItemScope;
	}

	protected static SerializeScope SupplyOrderPaymentGroupBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplyOrderPaymentGroup.ID_PROPERTY)
		.field(SupplyOrderPaymentGroup.NAME_PROPERTY)
		.field(SupplyOrderPaymentGroup.BIZ_ORDER_PROPERTY, getSupplyOrderSummaryScope())
		.field(SupplyOrderPaymentGroup.CARD_NUMBER_PROPERTY)
		;
	/** 用于SupplyOrderPaymentGroup对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSupplyOrderPaymentGroupListItemScope() {
		return SupplyOrderPaymentGroupBaseListItemScope;
	}

	protected static SerializeScope RetailStoreOrderBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreOrder.ID_PROPERTY)
		.field(RetailStoreOrder.BUYER_PROPERTY, getRetailStoreSummaryScope())
		.field(RetailStoreOrder.SELLER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(RetailStoreOrder.TITLE_PROPERTY)
		.field(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY)
		.field(RetailStoreOrder.LAST_UPDATE_TIME_PROPERTY)
		.field(RetailStoreOrder.RETAIL_STORE_ORDER_LINE_ITEM_LIST, getRetailStoreOrderLineItemSecondaryListItemScope())
		.field(RetailStoreOrder.RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST, getRetailStoreOrderShippingGroupSecondaryListItemScope())
		.field(RetailStoreOrder.RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST, getRetailStoreOrderPaymentGroupSecondaryListItemScope())
		.field(RetailStoreOrder.GOODS_LIST, getGoodsSecondaryListItemScope())
		;
	/** 用于RetailStoreOrder对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreOrderListItemScope() {
		return RetailStoreOrderBaseListItemScope;
	}

	protected static SerializeScope RetailStoreOrderLineItemBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreOrderLineItem.ID_PROPERTY)
		.field(RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY, getRetailStoreOrderSummaryScope())
		.field(RetailStoreOrderLineItem.SKU_ID_PROPERTY)
		.field(RetailStoreOrderLineItem.SKU_NAME_PROPERTY)
		.field(RetailStoreOrderLineItem.AMOUNT_PROPERTY)
		.field(RetailStoreOrderLineItem.QUANTITY_PROPERTY)
		.field(RetailStoreOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY)
		;
	/** 用于RetailStoreOrderLineItem对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreOrderLineItemListItemScope() {
		return RetailStoreOrderLineItemBaseListItemScope;
	}

	protected static SerializeScope RetailStoreOrderShippingGroupBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreOrderShippingGroup.ID_PROPERTY)
		.field(RetailStoreOrderShippingGroup.NAME_PROPERTY)
		.field(RetailStoreOrderShippingGroup.BIZ_ORDER_PROPERTY, getRetailStoreOrderSummaryScope())
		.field(RetailStoreOrderShippingGroup.AMOUNT_PROPERTY)
		;
	/** 用于RetailStoreOrderShippingGroup对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreOrderShippingGroupListItemScope() {
		return RetailStoreOrderShippingGroupBaseListItemScope;
	}

	protected static SerializeScope RetailStoreOrderPaymentGroupBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreOrderPaymentGroup.ID_PROPERTY)
		.field(RetailStoreOrderPaymentGroup.NAME_PROPERTY)
		.field(RetailStoreOrderPaymentGroup.BIZ_ORDER_PROPERTY, getRetailStoreOrderSummaryScope())
		.field(RetailStoreOrderPaymentGroup.CARD_NUMBER_PROPERTY)
		;
	/** 用于RetailStoreOrderPaymentGroup对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreOrderPaymentGroupListItemScope() {
		return RetailStoreOrderPaymentGroupBaseListItemScope;
	}

	protected static SerializeScope WarehouseBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Warehouse.ID_PROPERTY)
		.field(Warehouse.LOCATION_PROPERTY)
		.field(Warehouse.CONTACT_NUMBER_PROPERTY)
		.field(Warehouse.TOTAL_AREA_PROPERTY)
		.field(Warehouse.OWNER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(Warehouse.LATITUDE_PROPERTY)
		.field(Warehouse.LONGITUDE_PROPERTY)
		.field(Warehouse.LAST_UPDATE_TIME_PROPERTY)
		.field(Warehouse.STORAGE_SPACE_LIST, getStorageSpaceSecondaryListItemScope())
		.field(Warehouse.SMART_PALLET_LIST, getSmartPalletSecondaryListItemScope())
		.field(Warehouse.SUPPLIER_SPACE_LIST, getSupplierSpaceSecondaryListItemScope())
		.field(Warehouse.RECEIVING_SPACE_LIST, getReceivingSpaceSecondaryListItemScope())
		.field(Warehouse.SHIPPING_SPACE_LIST, getShippingSpaceSecondaryListItemScope())
		.field(Warehouse.DAMAGE_SPACE_LIST, getDamageSpaceSecondaryListItemScope())
		.field(Warehouse.WAREHOUSE_ASSET_LIST, getWarehouseAssetSecondaryListItemScope())
		;
	/** 用于Warehouse对象的列表时需要序列化的属性列表 */
	public static SerializeScope getWarehouseListItemScope() {
		return WarehouseBaseListItemScope;
	}

	protected static SerializeScope StorageSpaceBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(StorageSpace.ID_PROPERTY)
		.field(StorageSpace.LOCATION_PROPERTY)
		.field(StorageSpace.CONTACT_NUMBER_PROPERTY)
		.field(StorageSpace.TOTAL_AREA_PROPERTY)
		.field(StorageSpace.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
		.field(StorageSpace.LATITUDE_PROPERTY)
		.field(StorageSpace.LONGITUDE_PROPERTY)
		.field(StorageSpace.LAST_UPDATE_TIME_PROPERTY)
		.field(StorageSpace.GOODS_SHELF_LIST, getGoodsShelfSecondaryListItemScope())
		;
	/** 用于StorageSpace对象的列表时需要序列化的属性列表 */
	public static SerializeScope getStorageSpaceListItemScope() {
		return StorageSpaceBaseListItemScope;
	}

	protected static SerializeScope SmartPalletBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SmartPallet.ID_PROPERTY)
		.field(SmartPallet.LOCATION_PROPERTY)
		.field(SmartPallet.CONTACT_NUMBER_PROPERTY)
		.field(SmartPallet.TOTAL_AREA_PROPERTY)
		.field(SmartPallet.LATITUDE_PROPERTY)
		.field(SmartPallet.LONGITUDE_PROPERTY)
		.field(SmartPallet.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
		.field(SmartPallet.LAST_UPDATE_TIME_PROPERTY)
		.field(SmartPallet.GOODS_LIST, getGoodsSecondaryListItemScope())
		;
	/** 用于SmartPallet对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSmartPalletListItemScope() {
		return SmartPalletBaseListItemScope;
	}

	protected static SerializeScope GoodsShelfBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(GoodsShelf.ID_PROPERTY)
		.field(GoodsShelf.LOCATION_PROPERTY)
		.field(GoodsShelf.STORAGE_SPACE_PROPERTY, getStorageSpaceSummaryScope())
		.field(GoodsShelf.SUPPLIER_SPACE_PROPERTY, getSupplierSpaceSummaryScope())
		.field(GoodsShelf.DAMAGE_SPACE_PROPERTY, getDamageSpaceSummaryScope())
		.field(GoodsShelf.LAST_UPDATE_TIME_PROPERTY)
		.field(GoodsShelf.GOODS_SHELF_STOCK_COUNT_LIST, getGoodsShelfStockCountSecondaryListItemScope())
		.field(GoodsShelf.GOODS_ALLOCATION_LIST, getGoodsAllocationSecondaryListItemScope())
		;
	/** 用于GoodsShelf对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGoodsShelfListItemScope() {
		return GoodsShelfBaseListItemScope;
	}

	protected static SerializeScope GoodsShelfStockCountBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(GoodsShelfStockCount.ID_PROPERTY)
		.field(GoodsShelfStockCount.TITLE_PROPERTY)
		.field(GoodsShelfStockCount.COUNT_TIME_PROPERTY)
		.field(GoodsShelfStockCount.SUMMARY_PROPERTY)
		.field(GoodsShelfStockCount.SHELF_PROPERTY, getGoodsShelfSummaryScope())
		.field(GoodsShelfStockCount.STOCK_COUNT_ISSUE_TRACK_LIST, getStockCountIssueTrackSecondaryListItemScope())
		;
	/** 用于GoodsShelfStockCount对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGoodsShelfStockCountListItemScope() {
		return GoodsShelfStockCountBaseListItemScope;
	}

	protected static SerializeScope StockCountIssueTrackBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(StockCountIssueTrack.ID_PROPERTY)
		.field(StockCountIssueTrack.TITLE_PROPERTY)
		.field(StockCountIssueTrack.COUNT_TIME_PROPERTY)
		.field(StockCountIssueTrack.SUMMARY_PROPERTY)
		.field(StockCountIssueTrack.STOCK_COUNT_PROPERTY, getGoodsShelfStockCountSummaryScope())
		;
	/** 用于StockCountIssueTrack对象的列表时需要序列化的属性列表 */
	public static SerializeScope getStockCountIssueTrackListItemScope() {
		return StockCountIssueTrackBaseListItemScope;
	}

	protected static SerializeScope GoodsAllocationBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(GoodsAllocation.ID_PROPERTY)
		.field(GoodsAllocation.LOCATION_PROPERTY)
		.field(GoodsAllocation.LATITUDE_PROPERTY)
		.field(GoodsAllocation.LONGITUDE_PROPERTY)
		.field(GoodsAllocation.GOODS_SHELF_PROPERTY, getGoodsShelfSummaryScope())
		.field(GoodsAllocation.GOODS_LIST, getGoodsSecondaryListItemScope())
		;
	/** 用于GoodsAllocation对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGoodsAllocationListItemScope() {
		return GoodsAllocationBaseListItemScope;
	}

	protected static SerializeScope GoodsBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Goods.ID_PROPERTY)
		.field(Goods.NAME_PROPERTY)
		.field(Goods.RFID_PROPERTY)
		.field(Goods.UOM_PROPERTY)
		.field(Goods.MAX_PACKAGE_PROPERTY)
		.field(Goods.EXPIRE_TIME_PROPERTY)
		.field(Goods.SKU_PROPERTY, getSkuSummaryScope())
		.field(Goods.RECEIVING_SPACE_PROPERTY, getReceivingSpaceSummaryScope())
		.field(Goods.GOODS_ALLOCATION_PROPERTY, getGoodsAllocationSummaryScope())
		.field(Goods.SMART_PALLET_PROPERTY, getSmartPalletSummaryScope())
		.field(Goods.SHIPPING_SPACE_PROPERTY, getShippingSpaceSummaryScope())
		.field(Goods.TRANSPORT_TASK_PROPERTY, getTransportTaskSummaryScope())
		.field(Goods.RETAIL_STORE_PROPERTY, getRetailStoreSummaryScope())
		.field(Goods.BIZ_ORDER_PROPERTY, getSupplyOrderSummaryScope())
		.field(Goods.RETAIL_STORE_ORDER_PROPERTY, getRetailStoreOrderSummaryScope())
		.field(Goods.GOODS_MOVEMENT_LIST, getGoodsMovementSecondaryListItemScope())
		;
	/** 用于Goods对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGoodsListItemScope() {
		return GoodsBaseListItemScope;
	}

	protected static SerializeScope GoodsMovementBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(GoodsMovement.ID_PROPERTY)
		.field(GoodsMovement.MOVE_TIME_PROPERTY)
		.field(GoodsMovement.FACILITY_PROPERTY)
		.field(GoodsMovement.FACILITY_ID_PROPERTY)
		.field(GoodsMovement.FROM_IP_PROPERTY)
		.field(GoodsMovement.USER_AGENT_PROPERTY)
		.field(GoodsMovement.SESSION_ID_PROPERTY)
		.field(GoodsMovement.LATITUDE_PROPERTY)
		.field(GoodsMovement.LONGITUDE_PROPERTY)
		.field(GoodsMovement.GOODS_PROPERTY, getGoodsSummaryScope())
		;
	/** 用于GoodsMovement对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGoodsMovementListItemScope() {
		return GoodsMovementBaseListItemScope;
	}

	protected static SerializeScope SupplierSpaceBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplierSpace.ID_PROPERTY)
		.field(SupplierSpace.LOCATION_PROPERTY)
		.field(SupplierSpace.CONTACT_NUMBER_PROPERTY)
		.field(SupplierSpace.TOTAL_AREA_PROPERTY)
		.field(SupplierSpace.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
		.field(SupplierSpace.LATITUDE_PROPERTY)
		.field(SupplierSpace.LONGITUDE_PROPERTY)
		.field(SupplierSpace.LAST_UPDATE_TIME_PROPERTY)
		.field(SupplierSpace.GOODS_SHELF_LIST, getGoodsShelfSecondaryListItemScope())
		;
	/** 用于SupplierSpace对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSupplierSpaceListItemScope() {
		return SupplierSpaceBaseListItemScope;
	}

	protected static SerializeScope ReceivingSpaceBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ReceivingSpace.ID_PROPERTY)
		.field(ReceivingSpace.LOCATION_PROPERTY)
		.field(ReceivingSpace.CONTACT_NUMBER_PROPERTY)
		.field(ReceivingSpace.DESCRIPTION_PROPERTY)
		.field(ReceivingSpace.TOTAL_AREA_PROPERTY)
		.field(ReceivingSpace.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
		.field(ReceivingSpace.LATITUDE_PROPERTY)
		.field(ReceivingSpace.LONGITUDE_PROPERTY)
		.field(ReceivingSpace.LAST_UPDATE_TIME_PROPERTY)
		.field(ReceivingSpace.GOODS_LIST, getGoodsSecondaryListItemScope())
		;
	/** 用于ReceivingSpace对象的列表时需要序列化的属性列表 */
	public static SerializeScope getReceivingSpaceListItemScope() {
		return ReceivingSpaceBaseListItemScope;
	}

	protected static SerializeScope ShippingSpaceBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ShippingSpace.ID_PROPERTY)
		.field(ShippingSpace.LOCATION_PROPERTY)
		.field(ShippingSpace.CONTACT_NUMBER_PROPERTY)
		.field(ShippingSpace.TOTAL_AREA_PROPERTY)
		.field(ShippingSpace.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
		.field(ShippingSpace.LATITUDE_PROPERTY)
		.field(ShippingSpace.LONGITUDE_PROPERTY)
		.field(ShippingSpace.DESCRIPTION_PROPERTY)
		.field(ShippingSpace.LAST_UPDATE_TIME_PROPERTY)
		.field(ShippingSpace.GOODS_LIST, getGoodsSecondaryListItemScope())
		;
	/** 用于ShippingSpace对象的列表时需要序列化的属性列表 */
	public static SerializeScope getShippingSpaceListItemScope() {
		return ShippingSpaceBaseListItemScope;
	}

	protected static SerializeScope DamageSpaceBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(DamageSpace.ID_PROPERTY)
		.field(DamageSpace.LOCATION_PROPERTY)
		.field(DamageSpace.CONTACT_NUMBER_PROPERTY)
		.field(DamageSpace.TOTAL_AREA_PROPERTY)
		.field(DamageSpace.LATITUDE_PROPERTY)
		.field(DamageSpace.LONGITUDE_PROPERTY)
		.field(DamageSpace.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
		.field(DamageSpace.LAST_UPDATE_TIME_PROPERTY)
		.field(DamageSpace.GOODS_SHELF_LIST, getGoodsShelfSecondaryListItemScope())
		;
	/** 用于DamageSpace对象的列表时需要序列化的属性列表 */
	public static SerializeScope getDamageSpaceListItemScope() {
		return DamageSpaceBaseListItemScope;
	}

	protected static SerializeScope WarehouseAssetBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(WarehouseAsset.ID_PROPERTY)
		.field(WarehouseAsset.NAME_PROPERTY)
		.field(WarehouseAsset.POSITION_PROPERTY)
		.field(WarehouseAsset.OWNER_PROPERTY, getWarehouseSummaryScope())
		.field(WarehouseAsset.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于WarehouseAsset对象的列表时需要序列化的属性列表 */
	public static SerializeScope getWarehouseAssetListItemScope() {
		return WarehouseAssetBaseListItemScope;
	}

	protected static SerializeScope TransportFleetBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TransportFleet.ID_PROPERTY)
		.field(TransportFleet.NAME_PROPERTY)
		.field(TransportFleet.CONTACT_NUMBER_PROPERTY)
		.field(TransportFleet.OWNER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(TransportFleet.LAST_UPDATE_TIME_PROPERTY)
		.field(TransportFleet.TRANSPORT_TRUCK_LIST, getTransportTruckSecondaryListItemScope())
		.field(TransportFleet.TRUCK_DRIVER_LIST, getTruckDriverSecondaryListItemScope())
		.field(TransportFleet.TRANSPORT_TASK_LIST, getTransportTaskSecondaryListItemScope())
		;
	/** 用于TransportFleet对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTransportFleetListItemScope() {
		return TransportFleetBaseListItemScope;
	}

	protected static SerializeScope TransportTruckBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TransportTruck.ID_PROPERTY)
		.field(TransportTruck.NAME_PROPERTY)
		.field(TransportTruck.PLATE_NUMBER_PROPERTY)
		.field(TransportTruck.CONTACT_NUMBER_PROPERTY)
		.field(TransportTruck.VEHICLE_LICENSE_NUMBER_PROPERTY)
		.field(TransportTruck.ENGINE_NUMBER_PROPERTY)
		.field(TransportTruck.MAKE_DATE_PROPERTY)
		.field(TransportTruck.MILEAGE_PROPERTY)
		.field(TransportTruck.BODY_COLOR_PROPERTY)
		.field(TransportTruck.OWNER_PROPERTY, getTransportFleetSummaryScope())
		.field(TransportTruck.TRANSPORT_TASK_LIST, getTransportTaskSecondaryListItemScope())
		;
	/** 用于TransportTruck对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTransportTruckListItemScope() {
		return TransportTruckBaseListItemScope;
	}

	protected static SerializeScope TruckDriverBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TruckDriver.ID_PROPERTY)
		.field(TruckDriver.NAME_PROPERTY)
		.field(TruckDriver.DRIVER_LICENSE_NUMBER_PROPERTY)
		.field(TruckDriver.CONTACT_NUMBER_PROPERTY)
		.field(TruckDriver.BELONGS_TO_PROPERTY, getTransportFleetSummaryScope())
		.field(TruckDriver.TRANSPORT_TASK_LIST, getTransportTaskSecondaryListItemScope())
		;
	/** 用于TruckDriver对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTruckDriverListItemScope() {
		return TruckDriverBaseListItemScope;
	}

	protected static SerializeScope TransportTaskBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TransportTask.ID_PROPERTY)
		.field(TransportTask.NAME_PROPERTY)
		.field(TransportTask.START_PROPERTY)
		.field(TransportTask.BEGIN_TIME_PROPERTY)
		.field(TransportTask.END_PROPERTY, getRetailStoreSummaryScope())
		.field(TransportTask.DRIVER_PROPERTY, getTruckDriverSummaryScope())
		.field(TransportTask.TRUCK_PROPERTY, getTransportTruckSummaryScope())
		.field(TransportTask.BELONGS_TO_PROPERTY, getTransportFleetSummaryScope())
		.field(TransportTask.LATITUDE_PROPERTY)
		.field(TransportTask.LONGITUDE_PROPERTY)
		.field(TransportTask.GOODS_LIST, getGoodsSecondaryListItemScope())
		.field(TransportTask.TRANSPORT_TASK_TRACK_LIST, getTransportTaskTrackSecondaryListItemScope())
		;
	/** 用于TransportTask对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTransportTaskListItemScope() {
		return TransportTaskBaseListItemScope;
	}

	protected static SerializeScope TransportTaskTrackBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TransportTaskTrack.ID_PROPERTY)
		.field(TransportTaskTrack.TRACK_TIME_PROPERTY)
		.field(TransportTaskTrack.LATITUDE_PROPERTY)
		.field(TransportTaskTrack.LONGITUDE_PROPERTY)
		.field(TransportTaskTrack.MOVEMENT_PROPERTY, getTransportTaskSummaryScope())
		;
	/** 用于TransportTaskTrack对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTransportTaskTrackListItemScope() {
		return TransportTaskTrackBaseListItemScope;
	}

	protected static SerializeScope AccountSetBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountSet.ID_PROPERTY)
		.field(AccountSet.NAME_PROPERTY)
		.field(AccountSet.YEAR_SET_PROPERTY)
		.field(AccountSet.EFFECTIVE_DATE_PROPERTY)
		.field(AccountSet.ACCOUNTING_SYSTEM_PROPERTY)
		.field(AccountSet.DOMESTIC_CURRENCY_CODE_PROPERTY)
		.field(AccountSet.DOMESTIC_CURRENCY_NAME_PROPERTY)
		.field(AccountSet.OPENING_BANK_PROPERTY)
		.field(AccountSet.ACCOUNT_NUMBER_PROPERTY)
		.field(AccountSet.COUNTRY_CENTER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(AccountSet.RETAIL_STORE_PROPERTY, getRetailStoreSummaryScope())
		.field(AccountSet.GOODS_SUPPLIER_PROPERTY, getGoodsSupplierSummaryScope())
		.field(AccountSet.LAST_UPDATE_TIME_PROPERTY)
		.field(AccountSet.ACCOUNTING_SUBJECT_LIST, getAccountingSubjectSecondaryListItemScope())
		.field(AccountSet.ACCOUNTING_PERIOD_LIST, getAccountingPeriodSecondaryListItemScope())
		.field(AccountSet.ACCOUNTING_DOCUMENT_TYPE_LIST, getAccountingDocumentTypeSecondaryListItemScope())
		;
	/** 用于AccountSet对象的列表时需要序列化的属性列表 */
	public static SerializeScope getAccountSetListItemScope() {
		return AccountSetBaseListItemScope;
	}

	protected static SerializeScope AccountingSubjectBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountingSubject.ID_PROPERTY)
		.field(AccountingSubject.ACCOUNTING_SUBJECT_CODE_PROPERTY)
		.field(AccountingSubject.ACCOUNTING_SUBJECT_NAME_PROPERTY)
		.field(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY)
		.field(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY)
		.field(AccountingSubject.ACCOUNT_SET_PROPERTY, getAccountSetSummaryScope())
		.field(AccountingSubject.ACCOUNTING_DOCUMENT_LINE_LIST, getAccountingDocumentLineSecondaryListItemScope())
		;
	/** 用于AccountingSubject对象的列表时需要序列化的属性列表 */
	public static SerializeScope getAccountingSubjectListItemScope() {
		return AccountingSubjectBaseListItemScope;
	}

	protected static SerializeScope AccountingPeriodBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountingPeriod.ID_PROPERTY)
		.field(AccountingPeriod.NAME_PROPERTY)
		.field(AccountingPeriod.START_DATE_PROPERTY)
		.field(AccountingPeriod.END_DATE_PROPERTY)
		.field(AccountingPeriod.ACCOUNT_SET_PROPERTY, getAccountSetSummaryScope())
		.field(AccountingPeriod.ACCOUNTING_DOCUMENT_LIST, getAccountingDocumentSecondaryListItemScope())
		;
	/** 用于AccountingPeriod对象的列表时需要序列化的属性列表 */
	public static SerializeScope getAccountingPeriodListItemScope() {
		return AccountingPeriodBaseListItemScope;
	}

	protected static SerializeScope AccountingDocumentTypeBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountingDocumentType.ID_PROPERTY)
		.field(AccountingDocumentType.NAME_PROPERTY)
		.field(AccountingDocumentType.DESCRIPTION_PROPERTY)
		.field(AccountingDocumentType.ACCOUNTING_PERIOD_PROPERTY, getAccountSetSummaryScope())
		.field(AccountingDocumentType.ACCOUNTING_DOCUMENT_LIST, getAccountingDocumentSecondaryListItemScope())
		;
	/** 用于AccountingDocumentType对象的列表时需要序列化的属性列表 */
	public static SerializeScope getAccountingDocumentTypeListItemScope() {
		return AccountingDocumentTypeBaseListItemScope;
	}

	protected static SerializeScope AccountingDocumentBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountingDocument.ID_PROPERTY)
		.field(AccountingDocument.NAME_PROPERTY)
		.field(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY)
		.field(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, getAccountingPeriodSummaryScope())
		.field(AccountingDocument.DOCUMENT_TYPE_PROPERTY, getAccountingDocumentTypeSummaryScope())
		.field(AccountingDocument.ORIGINAL_VOUCHER_LIST, getOriginalVoucherSecondaryListItemScope())
		.field(AccountingDocument.ACCOUNTING_DOCUMENT_LINE_LIST, getAccountingDocumentLineSecondaryListItemScope())
		;
	/** 用于AccountingDocument对象的列表时需要序列化的属性列表 */
	public static SerializeScope getAccountingDocumentListItemScope() {
		return AccountingDocumentBaseListItemScope;
	}

	protected static SerializeScope OriginalVoucherBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(OriginalVoucher.ID_PROPERTY)
		.field(OriginalVoucher.TITLE_PROPERTY)
		.field(OriginalVoucher.MADE_BY_PROPERTY)
		.field(OriginalVoucher.RECEIVED_BY_PROPERTY)
		.field(OriginalVoucher.VOUCHER_TYPE_PROPERTY)
		.field(OriginalVoucher.VOUCHER_IMAGE_PROPERTY)
		.field(OriginalVoucher.BELONGS_TO_PROPERTY, getAccountingDocumentSummaryScope())
		;
	/** 用于OriginalVoucher对象的列表时需要序列化的属性列表 */
	public static SerializeScope getOriginalVoucherListItemScope() {
		return OriginalVoucherBaseListItemScope;
	}

	protected static SerializeScope AccountingDocumentLineBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountingDocumentLine.ID_PROPERTY)
		.field(AccountingDocumentLine.NAME_PROPERTY)
		.field(AccountingDocumentLine.CODE_PROPERTY)
		.field(AccountingDocumentLine.DIRECT_PROPERTY)
		.field(AccountingDocumentLine.AMOUNT_PROPERTY)
		.field(AccountingDocumentLine.BELONGS_TO_PROPERTY, getAccountingDocumentSummaryScope())
		.field(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY, getAccountingSubjectSummaryScope())
		;
	/** 用于AccountingDocumentLine对象的列表时需要序列化的属性列表 */
	public static SerializeScope getAccountingDocumentLineListItemScope() {
		return AccountingDocumentLineBaseListItemScope;
	}

	protected static SerializeScope LevelOneDepartmentBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelOneDepartment.ID_PROPERTY)
		.field(LevelOneDepartment.BELONGS_TO_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(LevelOneDepartment.NAME_PROPERTY)
		.field(LevelOneDepartment.DESCRIPTION_PROPERTY)
		.field(LevelOneDepartment.MANAGER_PROPERTY)
		.field(LevelOneDepartment.FOUNDED_PROPERTY)
		.field(LevelOneDepartment.LEVEL_TWO_DEPARTMENT_LIST, getLevelTwoDepartmentSecondaryListItemScope())
		;
	/** 用于LevelOneDepartment对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLevelOneDepartmentListItemScope() {
		return LevelOneDepartmentBaseListItemScope;
	}

	protected static SerializeScope LevelTwoDepartmentBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelTwoDepartment.ID_PROPERTY)
		.field(LevelTwoDepartment.BELONGS_TO_PROPERTY, getLevelOneDepartmentSummaryScope())
		.field(LevelTwoDepartment.NAME_PROPERTY)
		.field(LevelTwoDepartment.DESCRIPTION_PROPERTY)
		.field(LevelTwoDepartment.FOUNDED_PROPERTY)
		.field(LevelTwoDepartment.LEVEL_THREE_DEPARTMENT_LIST, getLevelThreeDepartmentSecondaryListItemScope())
		;
	/** 用于LevelTwoDepartment对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLevelTwoDepartmentListItemScope() {
		return LevelTwoDepartmentBaseListItemScope;
	}

	protected static SerializeScope LevelThreeDepartmentBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelThreeDepartment.ID_PROPERTY)
		.field(LevelThreeDepartment.BELONGS_TO_PROPERTY, getLevelTwoDepartmentSummaryScope())
		.field(LevelThreeDepartment.NAME_PROPERTY)
		.field(LevelThreeDepartment.DESCRIPTION_PROPERTY)
		.field(LevelThreeDepartment.FOUNDED_PROPERTY)
		.field(LevelThreeDepartment.EMPLOYEE_LIST, getEmployeeSecondaryListItemScope())
		;
	/** 用于LevelThreeDepartment对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLevelThreeDepartmentListItemScope() {
		return LevelThreeDepartmentBaseListItemScope;
	}

	protected static SerializeScope SkillTypeBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SkillType.ID_PROPERTY)
		.field(SkillType.CODE_PROPERTY)
		.field(SkillType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(SkillType.DESCRIPTION_PROPERTY)
		.field(SkillType.EMPLOYEE_SKILL_LIST, getEmployeeSkillSecondaryListItemScope())
		;
	/** 用于SkillType对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSkillTypeListItemScope() {
		return SkillTypeBaseListItemScope;
	}

	protected static SerializeScope ResponsibilityTypeBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ResponsibilityType.ID_PROPERTY)
		.field(ResponsibilityType.CODE_PROPERTY)
		.field(ResponsibilityType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(ResponsibilityType.BASE_DESCRIPTION_PROPERTY)
		.field(ResponsibilityType.DETAIL_DESCRIPTION_PROPERTY)
		.field(ResponsibilityType.EMPLOYEE_LIST, getEmployeeSecondaryListItemScope())
		;
	/** 用于ResponsibilityType对象的列表时需要序列化的属性列表 */
	public static SerializeScope getResponsibilityTypeListItemScope() {
		return ResponsibilityTypeBaseListItemScope;
	}

	protected static SerializeScope TerminationReasonBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TerminationReason.ID_PROPERTY)
		.field(TerminationReason.CODE_PROPERTY)
		.field(TerminationReason.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(TerminationReason.DESCRIPTION_PROPERTY)
		.field(TerminationReason.TERMINATION_LIST, getTerminationSecondaryListItemScope())
		;
	/** 用于TerminationReason对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTerminationReasonListItemScope() {
		return TerminationReasonBaseListItemScope;
	}

	protected static SerializeScope TerminationTypeBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TerminationType.ID_PROPERTY)
		.field(TerminationType.CODE_PROPERTY)
		.field(TerminationType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(TerminationType.BASE_DESCRIPTION_PROPERTY)
		.field(TerminationType.DETAIL_DESCRIPTION_PROPERTY)
		.field(TerminationType.TERMINATION_LIST, getTerminationSecondaryListItemScope())
		;
	/** 用于TerminationType对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTerminationTypeListItemScope() {
		return TerminationTypeBaseListItemScope;
	}

	protected static SerializeScope OccupationTypeBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(OccupationType.ID_PROPERTY)
		.field(OccupationType.CODE_PROPERTY)
		.field(OccupationType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(OccupationType.DESCRIPTION_PROPERTY)
		.field(OccupationType.DETAIL_DESCRIPTION_PROPERTY)
		.field(OccupationType.EMPLOYEE_LIST, getEmployeeSecondaryListItemScope())
		;
	/** 用于OccupationType对象的列表时需要序列化的属性列表 */
	public static SerializeScope getOccupationTypeListItemScope() {
		return OccupationTypeBaseListItemScope;
	}

	protected static SerializeScope LeaveTypeBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LeaveType.ID_PROPERTY)
		.field(LeaveType.CODE_PROPERTY)
		.field(LeaveType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(LeaveType.DESCRIPTION_PROPERTY)
		.field(LeaveType.DETAIL_DESCRIPTION_PROPERTY)
		.field(LeaveType.EMPLOYEE_LEAVE_LIST, getEmployeeLeaveSecondaryListItemScope())
		;
	/** 用于LeaveType对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLeaveTypeListItemScope() {
		return LeaveTypeBaseListItemScope;
	}

	protected static SerializeScope SalaryGradeBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SalaryGrade.ID_PROPERTY)
		.field(SalaryGrade.CODE_PROPERTY)
		.field(SalaryGrade.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(SalaryGrade.NAME_PROPERTY)
		.field(SalaryGrade.DETAIL_DESCRIPTION_PROPERTY)
		.field(SalaryGrade.EMPLOYEE_LIST, getEmployeeSecondaryListItemScope())
		.field(SalaryGrade.EMPLOYEE_SALARY_SHEET_LIST, getEmployeeSalarySheetSecondaryListItemScope())
		;
	/** 用于SalaryGrade对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSalaryGradeListItemScope() {
		return SalaryGradeBaseListItemScope;
	}

	protected static SerializeScope InterviewTypeBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(InterviewType.ID_PROPERTY)
		.field(InterviewType.CODE_PROPERTY)
		.field(InterviewType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(InterviewType.DESCRIPTION_PROPERTY)
		.field(InterviewType.DETAIL_DESCRIPTION_PROPERTY)
		.field(InterviewType.EMPLOYEE_INTERVIEW_LIST, getEmployeeInterviewSecondaryListItemScope())
		;
	/** 用于InterviewType对象的列表时需要序列化的属性列表 */
	public static SerializeScope getInterviewTypeListItemScope() {
		return InterviewTypeBaseListItemScope;
	}

	protected static SerializeScope TrainingCourseTypeBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TrainingCourseType.ID_PROPERTY)
		.field(TrainingCourseType.CODE_PROPERTY)
		.field(TrainingCourseType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(TrainingCourseType.NAME_PROPERTY)
		.field(TrainingCourseType.DESCRIPTION_PROPERTY)
		.field(TrainingCourseType.COMPANY_TRAINING_LIST, getCompanyTrainingSecondaryListItemScope())
		;
	/** 用于TrainingCourseType对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTrainingCourseTypeListItemScope() {
		return TrainingCourseTypeBaseListItemScope;
	}

	protected static SerializeScope PublicHolidayBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PublicHoliday.ID_PROPERTY)
		.field(PublicHoliday.CODE_PROPERTY)
		.field(PublicHoliday.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(PublicHoliday.NAME_PROPERTY)
		.field(PublicHoliday.DESCRIPTION_PROPERTY)
		;
	/** 用于PublicHoliday对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPublicHolidayListItemScope() {
		return PublicHolidayBaseListItemScope;
	}

	protected static SerializeScope TerminationBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Termination.ID_PROPERTY)
		.field(Termination.REASON_PROPERTY, getTerminationReasonSummaryScope())
		.field(Termination.TYPE_PROPERTY, getTerminationTypeSummaryScope())
		.field(Termination.COMMENT_PROPERTY)
		;
	/** 用于Termination对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTerminationListItemScope() {
		return TerminationBaseListItemScope;
	}

	protected static SerializeScope ViewBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(View.ID_PROPERTY)
		.field(View.WHO_PROPERTY)
		.field(View.ASSESSMENT_PROPERTY)
		.field(View.INTERVIEW_TIME_PROPERTY)
		;
	/** 用于View对象的列表时需要序列化的属性列表 */
	public static SerializeScope getViewListItemScope() {
		return ViewBaseListItemScope;
	}

	protected static SerializeScope EmployeeBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Employee.ID_PROPERTY)
		.field(Employee.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(Employee.TITLE_PROPERTY)
		.field(Employee.DEPARTMENT_PROPERTY, getLevelThreeDepartmentSummaryScope())
		.field(Employee.FAMILY_NAME_PROPERTY)
		.field(Employee.GIVEN_NAME_PROPERTY)
		.field(Employee.EMAIL_PROPERTY)
		.field(Employee.CITY_PROPERTY)
		.field(Employee.ADDRESS_PROPERTY)
		.field(Employee.CELL_PHONE_PROPERTY)
		.field(Employee.OCCUPATION_PROPERTY, getOccupationTypeSummaryScope())
		.field(Employee.RESPONSIBLE_FOR_PROPERTY, getResponsibilityTypeSummaryScope())
		.field(Employee.CURRENT_SALARY_GRADE_PROPERTY, getSalaryGradeSummaryScope())
		.field(Employee.SALARY_ACCOUNT_PROPERTY)
		.field(Employee.LAST_UPDATE_TIME_PROPERTY)
		.field(Employee.EMPLOYEE_COMPANY_TRAINING_LIST, getEmployeeCompanyTrainingSecondaryListItemScope())
		.field(Employee.EMPLOYEE_SKILL_LIST, getEmployeeSkillSecondaryListItemScope())
		.field(Employee.EMPLOYEE_PERFORMANCE_LIST, getEmployeePerformanceSecondaryListItemScope())
		.field(Employee.EMPLOYEE_WORK_EXPERIENCE_LIST, getEmployeeWorkExperienceSecondaryListItemScope())
		.field(Employee.EMPLOYEE_LEAVE_LIST, getEmployeeLeaveSecondaryListItemScope())
		.field(Employee.EMPLOYEE_INTERVIEW_LIST, getEmployeeInterviewSecondaryListItemScope())
		.field(Employee.EMPLOYEE_ATTENDANCE_LIST, getEmployeeAttendanceSecondaryListItemScope())
		.field(Employee.EMPLOYEE_QUALIFIER_LIST, getEmployeeQualifierSecondaryListItemScope())
		.field(Employee.EMPLOYEE_EDUCATION_LIST, getEmployeeEducationSecondaryListItemScope())
		.field(Employee.EMPLOYEE_AWARD_LIST, getEmployeeAwardSecondaryListItemScope())
		.field(Employee.EMPLOYEE_SALARY_SHEET_LIST, getEmployeeSalarySheetSecondaryListItemScope())
		.field(Employee.PAYING_OFF_LIST, getPayingOffSecondaryListItemScope())
		;
	/** 用于Employee对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeListItemScope() {
		return EmployeeBaseListItemScope;
	}

	protected static SerializeScope InstructorBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Instructor.ID_PROPERTY)
		.field(Instructor.TITLE_PROPERTY)
		.field(Instructor.FAMILY_NAME_PROPERTY)
		.field(Instructor.GIVEN_NAME_PROPERTY)
		.field(Instructor.CELL_PHONE_PROPERTY)
		.field(Instructor.EMAIL_PROPERTY)
		.field(Instructor.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(Instructor.INTRODUCTION_PROPERTY)
		.field(Instructor.LAST_UPDATE_TIME_PROPERTY)
		.field(Instructor.COMPANY_TRAINING_LIST, getCompanyTrainingSecondaryListItemScope())
		;
	/** 用于Instructor对象的列表时需要序列化的属性列表 */
	public static SerializeScope getInstructorListItemScope() {
		return InstructorBaseListItemScope;
	}

	protected static SerializeScope CompanyTrainingBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(CompanyTraining.ID_PROPERTY)
		.field(CompanyTraining.TITLE_PROPERTY)
		.field(CompanyTraining.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(CompanyTraining.INSTRUCTOR_PROPERTY, getInstructorSummaryScope())
		.field(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, getTrainingCourseTypeSummaryScope())
		.field(CompanyTraining.TIME_START_PROPERTY)
		.field(CompanyTraining.DURATION_HOURS_PROPERTY)
		.field(CompanyTraining.LAST_UPDATE_TIME_PROPERTY)
		.field(CompanyTraining.EMPLOYEE_COMPANY_TRAINING_LIST, getEmployeeCompanyTrainingSecondaryListItemScope())
		;
	/** 用于CompanyTraining对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCompanyTrainingListItemScope() {
		return CompanyTrainingBaseListItemScope;
	}

	protected static SerializeScope ScoringBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Scoring.ID_PROPERTY)
		.field(Scoring.SCORED_BY_PROPERTY)
		.field(Scoring.SCORE_PROPERTY)
		.field(Scoring.COMMENT_PROPERTY)
		.field(Scoring.EMPLOYEE_COMPANY_TRAINING_LIST, getEmployeeCompanyTrainingSecondaryListItemScope())
		;
	/** 用于Scoring对象的列表时需要序列化的属性列表 */
	public static SerializeScope getScoringListItemScope() {
		return ScoringBaseListItemScope;
	}

	protected static SerializeScope EmployeeCompanyTrainingBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeCompanyTraining.ID_PROPERTY)
		.field(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeeCompanyTraining.TRAINING_PROPERTY, getCompanyTrainingSummaryScope())
		.field(EmployeeCompanyTraining.SCORING_PROPERTY, getScoringSummaryScope())
		;
	/** 用于EmployeeCompanyTraining对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeCompanyTrainingListItemScope() {
		return EmployeeCompanyTrainingBaseListItemScope;
	}

	protected static SerializeScope EmployeeSkillBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeSkill.ID_PROPERTY)
		.field(EmployeeSkill.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeeSkill.SKILL_TYPE_PROPERTY, getSkillTypeSummaryScope())
		.field(EmployeeSkill.DESCRIPTION_PROPERTY)
		;
	/** 用于EmployeeSkill对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeSkillListItemScope() {
		return EmployeeSkillBaseListItemScope;
	}

	protected static SerializeScope EmployeePerformanceBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeePerformance.ID_PROPERTY)
		.field(EmployeePerformance.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeePerformance.PERFORMANCE_COMMENT_PROPERTY)
		;
	/** 用于EmployeePerformance对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeePerformanceListItemScope() {
		return EmployeePerformanceBaseListItemScope;
	}

	protected static SerializeScope EmployeeWorkExperienceBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeWorkExperience.ID_PROPERTY)
		.field(EmployeeWorkExperience.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeeWorkExperience.START_PROPERTY)
		.field(EmployeeWorkExperience.END_PROPERTY)
		.field(EmployeeWorkExperience.COMPANY_PROPERTY)
		.field(EmployeeWorkExperience.DESCRIPTION_PROPERTY)
		;
	/** 用于EmployeeWorkExperience对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeWorkExperienceListItemScope() {
		return EmployeeWorkExperienceBaseListItemScope;
	}

	protected static SerializeScope EmployeeLeaveBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeLeave.ID_PROPERTY)
		.field(EmployeeLeave.WHO_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeeLeave.TYPE_PROPERTY, getLeaveTypeSummaryScope())
		.field(EmployeeLeave.LEAVE_DURATION_HOUR_PROPERTY)
		.field(EmployeeLeave.REMARK_PROPERTY)
		;
	/** 用于EmployeeLeave对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeLeaveListItemScope() {
		return EmployeeLeaveBaseListItemScope;
	}

	protected static SerializeScope EmployeeInterviewBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeInterview.ID_PROPERTY)
		.field(EmployeeInterview.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeeInterview.INTERVIEW_TYPE_PROPERTY, getInterviewTypeSummaryScope())
		.field(EmployeeInterview.REMARK_PROPERTY)
		;
	/** 用于EmployeeInterview对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeInterviewListItemScope() {
		return EmployeeInterviewBaseListItemScope;
	}

	protected static SerializeScope EmployeeAttendanceBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeAttendance.ID_PROPERTY)
		.field(EmployeeAttendance.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeeAttendance.ENTER_TIME_PROPERTY)
		.field(EmployeeAttendance.LEAVE_TIME_PROPERTY)
		.field(EmployeeAttendance.DURATION_HOURS_PROPERTY)
		.field(EmployeeAttendance.REMARK_PROPERTY)
		;
	/** 用于EmployeeAttendance对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeAttendanceListItemScope() {
		return EmployeeAttendanceBaseListItemScope;
	}

	protected static SerializeScope EmployeeQualifierBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeQualifier.ID_PROPERTY)
		.field(EmployeeQualifier.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeeQualifier.QUALIFIED_TIME_PROPERTY)
		.field(EmployeeQualifier.TYPE_PROPERTY)
		.field(EmployeeQualifier.LEVEL_PROPERTY)
		.field(EmployeeQualifier.REMARK_PROPERTY)
		;
	/** 用于EmployeeQualifier对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeQualifierListItemScope() {
		return EmployeeQualifierBaseListItemScope;
	}

	protected static SerializeScope EmployeeEducationBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeEducation.ID_PROPERTY)
		.field(EmployeeEducation.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeeEducation.COMPLETE_TIME_PROPERTY)
		.field(EmployeeEducation.TYPE_PROPERTY)
		.field(EmployeeEducation.REMARK_PROPERTY)
		;
	/** 用于EmployeeEducation对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeEducationListItemScope() {
		return EmployeeEducationBaseListItemScope;
	}

	protected static SerializeScope EmployeeAwardBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeAward.ID_PROPERTY)
		.field(EmployeeAward.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeeAward.COMPLETE_TIME_PROPERTY)
		.field(EmployeeAward.TYPE_PROPERTY)
		.field(EmployeeAward.REMARK_PROPERTY)
		;
	/** 用于EmployeeAward对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeAwardListItemScope() {
		return EmployeeAwardBaseListItemScope;
	}

	protected static SerializeScope EmployeeSalarySheetBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeSalarySheet.ID_PROPERTY)
		.field(EmployeeSalarySheet.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY, getSalaryGradeSummaryScope())
		.field(EmployeeSalarySheet.BASE_SALARY_PROPERTY)
		.field(EmployeeSalarySheet.BONUS_PROPERTY)
		.field(EmployeeSalarySheet.REWARD_PROPERTY)
		.field(EmployeeSalarySheet.PERSONAL_TAX_PROPERTY)
		.field(EmployeeSalarySheet.SOCIAL_SECURITY_PROPERTY)
		.field(EmployeeSalarySheet.HOUSING_FOUND_PROPERTY)
		.field(EmployeeSalarySheet.JOB_INSURANCE_PROPERTY)
		.field(EmployeeSalarySheet.PAYING_OFF_PROPERTY, getPayingOffSummaryScope())
		;
	/** 用于EmployeeSalarySheet对象的列表时需要序列化的属性列表 */
	public static SerializeScope getEmployeeSalarySheetListItemScope() {
		return EmployeeSalarySheetBaseListItemScope;
	}

	protected static SerializeScope PayingOffBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PayingOff.ID_PROPERTY)
		.field(PayingOff.WHO_PROPERTY)
		.field(PayingOff.PAID_FOR_PROPERTY, getEmployeeSummaryScope())
		.field(PayingOff.PAID_TIME_PROPERTY)
		.field(PayingOff.AMOUNT_PROPERTY)
		.field(PayingOff.EMPLOYEE_SALARY_SHEET_LIST, getEmployeeSalarySheetSecondaryListItemScope())
		;
	/** 用于PayingOff对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPayingOffListItemScope() {
		return PayingOffBaseListItemScope;
	}

	protected static SerializeScope MobileAppBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(MobileApp.ID_PROPERTY)
		.field(MobileApp.NAME_PROPERTY)
		.field(MobileApp.PAGE_LIST, getPageSecondaryListItemScope())
		.field(MobileApp.PAGE_TYPE_LIST, getPageTypeSecondaryListItemScope())
		;
	/** 用于MobileApp对象的列表时需要序列化的属性列表 */
	public static SerializeScope getMobileAppListItemScope() {
		return MobileAppBaseListItemScope;
	}

	protected static SerializeScope PageBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Page.ID_PROPERTY)
		.field(Page.PAGE_TITLE_PROPERTY)
		.field(Page.LINK_TO_URL_PROPERTY)
		.field(Page.PAGE_TYPE_PROPERTY, getPageTypeSummaryScope())
		.field(Page.DISPLAY_ORDER_PROPERTY)
		.field(Page.MOBILE_APP_PROPERTY, getMobileAppSummaryScope())
		.field(Page.SLIDE_LIST, getSlideSecondaryListItemScope())
		.field(Page.UI_ACTION_LIST, getUiActionSecondaryListItemScope())
		.field(Page.SECTION_LIST, getSectionSecondaryListItemScope())
		;
	/** 用于Page对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPageListItemScope() {
		return PageBaseListItemScope;
	}

	protected static SerializeScope PageTypeBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PageType.ID_PROPERTY)
		.field(PageType.NAME_PROPERTY)
		.field(PageType.CODE_PROPERTY)
		.field(PageType.MOBILE_APP_PROPERTY, getMobileAppSummaryScope())
		.field(PageType.FOOTER_TAB_PROPERTY)
		.field(PageType.PAGE_LIST, getPageSecondaryListItemScope())
		;
	/** 用于PageType对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPageTypeListItemScope() {
		return PageTypeBaseListItemScope;
	}

	protected static SerializeScope SlideBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Slide.ID_PROPERTY)
		.field(Slide.NAME_PROPERTY)
		.field(Slide.DISPLAY_ORDER_PROPERTY)
		.field(Slide.IMAGE_URL_PROPERTY)
		.field(Slide.VIDEO_URL_PROPERTY)
		.field(Slide.LINK_TO_URL_PROPERTY)
		.field(Slide.PAGE_PROPERTY, getPageSummaryScope())
		;
	/** 用于Slide对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSlideListItemScope() {
		return SlideBaseListItemScope;
	}

	protected static SerializeScope UiActionBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(UiAction.ID_PROPERTY)
		.field(UiAction.CODE_PROPERTY)
		.field(UiAction.ICON_PROPERTY)
		.field(UiAction.TITLE_PROPERTY)
		.field(UiAction.DISPLAY_ORDER_PROPERTY)
		.field(UiAction.BRIEF_PROPERTY)
		.field(UiAction.IMAGE_URL_PROPERTY)
		.field(UiAction.LINK_TO_URL_PROPERTY)
		.field(UiAction.EXTRA_DATA_PROPERTY)
		.field(UiAction.PAGE_PROPERTY, getPageSummaryScope())
		;
	/** 用于UiAction对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUiActionListItemScope() {
		return UiActionBaseListItemScope;
	}

	protected static SerializeScope SectionBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Section.ID_PROPERTY)
		.field(Section.TITLE_PROPERTY)
		.field(Section.BRIEF_PROPERTY)
		.field(Section.ICON_PROPERTY)
		.field(Section.DISPLAY_ORDER_PROPERTY)
		.field(Section.VIEW_GROUP_PROPERTY)
		.field(Section.LINK_TO_URL_PROPERTY)
		.field(Section.PAGE_PROPERTY, getPageSummaryScope())
		;
	/** 用于Section对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSectionListItemScope() {
		return SectionBaseListItemScope;
	}

	protected static SerializeScope UserDomainBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		.field(UserDomain.USER_WHITE_LIST_LIST, getUserWhiteListSecondaryListItemScope())
		.field(UserDomain.SEC_USER_LIST, getSecUserSecondaryListItemScope())
		.field(UserDomain.PUBLIC_KEY_TYPE_LIST, getPublicKeyTypeSecondaryListItemScope())
		;
	/** 用于UserDomain对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserDomainListItemScope() {
		return UserDomainBaseListItemScope;
	}

	protected static SerializeScope UserWhiteListBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		.field(UserWhiteList.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		;
	/** 用于UserWhiteList对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListListItemScope() {
		return UserWhiteListBaseListItemScope;
	}

	protected static SerializeScope SecUserBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SecUser.ID_PROPERTY)
		.field(SecUser.LOGIN_PROPERTY)
		.field(SecUser.MOBILE_PROPERTY)
		.field(SecUser.EMAIL_PROPERTY)
		.field(SecUser.PWD_PROPERTY)
		.field(SecUser.WEIXIN_OPENID_PROPERTY)
		.field(SecUser.WEIXIN_APPID_PROPERTY)
		.field(SecUser.ACCESS_TOKEN_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
		.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
		.field(SecUser.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		.field(SecUser.USER_APP_LIST, getUserAppSecondaryListItemScope())
		.field(SecUser.LOGIN_HISTORY_LIST, getLoginHistorySecondaryListItemScope())
		.field(SecUser.WECHAT_WORKAPP_IDENTIFY_LIST, getWechatWorkappIdentifySecondaryListItemScope())
		.field(SecUser.WECHAT_MINIAPP_IDENTIFY_LIST, getWechatMiniappIdentifySecondaryListItemScope())
		.field(SecUser.KEYPAIR_IDENTIFY_LIST, getKeypairIdentifySecondaryListItemScope())
		;
	/** 用于SecUser对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSecUserListItemScope() {
		return SecUserBaseListItemScope;
	}

	protected static SerializeScope UserAppBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		.field(UserApp.QUICK_LINK_LIST, getQuickLinkSecondaryListItemScope())
		.field(UserApp.LIST_ACCESS_LIST, getListAccessSecondaryListItemScope())
		;
	/** 用于UserApp对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserAppListItemScope() {
		return UserAppBaseListItemScope;
	}

	protected static SerializeScope QuickLinkBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		.field(QuickLink.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于QuickLink对象的列表时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkListItemScope() {
		return QuickLinkBaseListItemScope;
	}

	protected static SerializeScope ListAccessBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		.field(ListAccess.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于ListAccess对象的列表时需要序列化的属性列表 */
	public static SerializeScope getListAccessListItemScope() {
		return ListAccessBaseListItemScope;
	}

	protected static SerializeScope LoginHistoryBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		.field(LoginHistory.SEC_USER_PROPERTY, getSecUserSummaryScope())
		;
	/** 用于LoginHistory对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLoginHistoryListItemScope() {
		return LoginHistoryBaseListItemScope;
	}

	protected static SerializeScope CandidateContainerBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		.field(CandidateContainer.CANDIDATE_ELEMENT_LIST, getCandidateElementSecondaryListItemScope())
		;
	/** 用于CandidateContainer对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerListItemScope() {
		return CandidateContainerBaseListItemScope;
	}

	protected static SerializeScope CandidateElementBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		.field(CandidateElement.CONTAINER_PROPERTY, getCandidateContainerSummaryScope())
		;
	/** 用于CandidateElement对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementListItemScope() {
		return CandidateElementBaseListItemScope;
	}

	protected static SerializeScope WechatWorkappIdentifyBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(WechatWorkappIdentify.ID_PROPERTY)
		.field(WechatWorkappIdentify.CORP_ID_PROPERTY)
		.field(WechatWorkappIdentify.USER_ID_PROPERTY)
		.field(WechatWorkappIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(WechatWorkappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatWorkappIdentify对象的列表时需要序列化的属性列表 */
	public static SerializeScope getWechatWorkappIdentifyListItemScope() {
		return WechatWorkappIdentifyBaseListItemScope;
	}

	protected static SerializeScope WechatMiniappIdentifyBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(WechatMiniappIdentify.ID_PROPERTY)
		.field(WechatMiniappIdentify.OPEN_ID_PROPERTY)
		.field(WechatMiniappIdentify.APP_ID_PROPERTY)
		.field(WechatMiniappIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(WechatMiniappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatMiniappIdentify对象的列表时需要序列化的属性列表 */
	public static SerializeScope getWechatMiniappIdentifyListItemScope() {
		return WechatMiniappIdentifyBaseListItemScope;
	}

	protected static SerializeScope KeypairIdentifyBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(KeypairIdentify.ID_PROPERTY)
		.field(KeypairIdentify.PUBLIC_KEY_PROPERTY)
		.field(KeypairIdentify.KEY_TYPE_PROPERTY, getPublicKeyTypeSummaryScope())
		.field(KeypairIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(KeypairIdentify.CREATE_TIME_PROPERTY)
		;
	/** 用于KeypairIdentify对象的列表时需要序列化的属性列表 */
	public static SerializeScope getKeypairIdentifyListItemScope() {
		return KeypairIdentifyBaseListItemScope;
	}

	protected static SerializeScope PublicKeyTypeBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PublicKeyType.ID_PROPERTY)
		.field(PublicKeyType.NAME_PROPERTY)
		.field(PublicKeyType.CODE_PROPERTY)
		.field(PublicKeyType.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		.field(PublicKeyType.KEYPAIR_IDENTIFY_LIST, getKeypairIdentifySecondaryListItemScope())
		;
	/** 用于PublicKeyType对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPublicKeyTypeListItemScope() {
		return PublicKeyTypeBaseListItemScope;
	}

	protected static SerializeScope TreeNodeBaseListItemScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TreeNode.ID_PROPERTY)
		.field(TreeNode.NODE_ID_PROPERTY)
		.field(TreeNode.NODE_TYPE_PROPERTY)
		.field(TreeNode.LEFT_VALUE_PROPERTY)
		.field(TreeNode.RIGHT_VALUE_PROPERTY)
		;
	/** 用于TreeNode对象的列表时需要序列化的属性列表 */
	public static SerializeScope getTreeNodeListItemScope() {
		return TreeNodeBaseListItemScope;
	}

	protected static SerializeScope RetailStoreCountryCenterBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreCountryCenter.ID_PROPERTY)
		.field(RetailStoreCountryCenter.NAME_PROPERTY)
		.field(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY)
		.field(RetailStoreCountryCenter.FOUNDED_PROPERTY)
		.field(RetailStoreCountryCenter.WEB_SITE_PROPERTY)
		.field(RetailStoreCountryCenter.ADDRESS_PROPERTY)
		.field(RetailStoreCountryCenter.OPERATED_BY_PROPERTY)
		.field(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY)
		.field(RetailStoreCountryCenter.DESCRIPTION_PROPERTY)
		.field(RetailStoreCountryCenter.CATALOG_LIST, getCatalogListItemScope())
		.field(RetailStoreCountryCenter.RETAIL_STORE_PROVINCE_CENTER_LIST, getRetailStoreProvinceCenterListItemScope())
		.field(RetailStoreCountryCenter.RETAIL_STORE_LIST, getRetailStoreListItemScope())
		.field(RetailStoreCountryCenter.RETAIL_STORE_MEMBER_LIST, getRetailStoreMemberListItemScope())
		.field(RetailStoreCountryCenter.GOODS_SUPPLIER_LIST, getGoodsSupplierListItemScope())
		.field(RetailStoreCountryCenter.SUPPLY_ORDER_LIST, getSupplyOrderListItemScope())
		.field(RetailStoreCountryCenter.RETAIL_STORE_ORDER_LIST, getRetailStoreOrderListItemScope())
		.field(RetailStoreCountryCenter.WAREHOUSE_LIST, getWarehouseListItemScope())
		.field(RetailStoreCountryCenter.TRANSPORT_FLEET_LIST, getTransportFleetListItemScope())
		.field(RetailStoreCountryCenter.ACCOUNT_SET_LIST, getAccountSetListItemScope())
		.field(RetailStoreCountryCenter.LEVEL_ONE_DEPARTMENT_LIST, getLevelOneDepartmentListItemScope())
		.field(RetailStoreCountryCenter.SKILL_TYPE_LIST, getSkillTypeListItemScope())
		.field(RetailStoreCountryCenter.RESPONSIBILITY_TYPE_LIST, getResponsibilityTypeListItemScope())
		.field(RetailStoreCountryCenter.TERMINATION_REASON_LIST, getTerminationReasonListItemScope())
		.field(RetailStoreCountryCenter.TERMINATION_TYPE_LIST, getTerminationTypeListItemScope())
		.field(RetailStoreCountryCenter.OCCUPATION_TYPE_LIST, getOccupationTypeListItemScope())
		.field(RetailStoreCountryCenter.LEAVE_TYPE_LIST, getLeaveTypeListItemScope())
		.field(RetailStoreCountryCenter.SALARY_GRADE_LIST, getSalaryGradeListItemScope())
		.field(RetailStoreCountryCenter.INTERVIEW_TYPE_LIST, getInterviewTypeListItemScope())
		.field(RetailStoreCountryCenter.TRAINING_COURSE_TYPE_LIST, getTrainingCourseTypeListItemScope())
		.field(RetailStoreCountryCenter.PUBLIC_HOLIDAY_LIST, getPublicHolidayListItemScope())
		.field(RetailStoreCountryCenter.EMPLOYEE_LIST, getEmployeeListItemScope())
		.field(RetailStoreCountryCenter.INSTRUCTOR_LIST, getInstructorListItemScope())
		.field(RetailStoreCountryCenter.COMPANY_TRAINING_LIST, getCompanyTrainingListItemScope())
		;
	/** 用于RetailStoreCountryCenter对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreCountryCenterDetailScope() {
		return RetailStoreCountryCenterBaseDetailScope;
	}

	protected static SerializeScope CatalogBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Catalog.ID_PROPERTY)
		.field(Catalog.NAME_PROPERTY)
		.field(Catalog.OWNER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(Catalog.SUB_COUNT_PROPERTY)
		.field(Catalog.AMOUNT_PROPERTY)
		.field(Catalog.LEVEL_ONE_CATEGORY_LIST, getLevelOneCategoryListItemScope())
		;
	/** 用于Catalog对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCatalogDetailScope() {
		return CatalogBaseDetailScope;
	}

	protected static SerializeScope LevelOneCategoryBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelOneCategory.ID_PROPERTY)
		.field(LevelOneCategory.CATALOG_PROPERTY, getCatalogSummaryScope())
		.field(LevelOneCategory.NAME_PROPERTY)
		.field(LevelOneCategory.LEVEL_TWO_CATEGORY_LIST, getLevelTwoCategoryListItemScope())
		;
	/** 用于LevelOneCategory对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLevelOneCategoryDetailScope() {
		return LevelOneCategoryBaseDetailScope;
	}

	protected static SerializeScope LevelTwoCategoryBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelTwoCategory.ID_PROPERTY)
		.field(LevelTwoCategory.PARENT_CATEGORY_PROPERTY, getLevelOneCategorySummaryScope())
		.field(LevelTwoCategory.NAME_PROPERTY)
		.field(LevelTwoCategory.LEVEL_THREE_CATEGORY_LIST, getLevelThreeCategoryListItemScope())
		;
	/** 用于LevelTwoCategory对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLevelTwoCategoryDetailScope() {
		return LevelTwoCategoryBaseDetailScope;
	}

	protected static SerializeScope LevelThreeCategoryBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelThreeCategory.ID_PROPERTY)
		.field(LevelThreeCategory.PARENT_CATEGORY_PROPERTY, getLevelTwoCategorySummaryScope())
		.field(LevelThreeCategory.NAME_PROPERTY)
		.field(LevelThreeCategory.PRODUCT_LIST, getProductListItemScope())
		;
	/** 用于LevelThreeCategory对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLevelThreeCategoryDetailScope() {
		return LevelThreeCategoryBaseDetailScope;
	}

	protected static SerializeScope ProductBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Product.ID_PROPERTY)
		.field(Product.NAME_PROPERTY)
		.field(Product.PARENT_CATEGORY_PROPERTY, getLevelThreeCategorySummaryScope())
		.field(Product.ORIGIN_PROPERTY)
		.field(Product.REMARK_PROPERTY)
		.field(Product.BRAND_PROPERTY)
		.field(Product.PICTURE_PROPERTY)
		.field(Product.LAST_UPDATE_TIME_PROPERTY)
		.field(Product.SKU_LIST, getSkuListItemScope())
		;
	/** 用于Product对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getProductDetailScope() {
		return ProductBaseDetailScope;
	}

	protected static SerializeScope SkuBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Sku.ID_PROPERTY)
		.field(Sku.NAME_PROPERTY)
		.field(Sku.SIZE_PROPERTY)
		.field(Sku.PRODUCT_PROPERTY, getProductSummaryScope())
		.field(Sku.BARCODE_PROPERTY)
		.field(Sku.PACKAGE_TYPE_PROPERTY)
		.field(Sku.NET_CONTENT_PROPERTY)
		.field(Sku.PRICE_PROPERTY)
		.field(Sku.PICTURE_PROPERTY)
		.field(Sku.GOODS_LIST, getGoodsListItemScope())
		;
	/** 用于Sku对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSkuDetailScope() {
		return SkuBaseDetailScope;
	}

	protected static SerializeScope RetailStoreProvinceCenterBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreProvinceCenter.ID_PROPERTY)
		.field(RetailStoreProvinceCenter.NAME_PROPERTY)
		.field(RetailStoreProvinceCenter.FOUNDED_PROPERTY)
		.field(RetailStoreProvinceCenter.COUNTRY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(RetailStoreProvinceCenter.LAST_UPDATE_TIME_PROPERTY)
		.field(RetailStoreProvinceCenter.PROVINCE_CENTER_DEPARTMENT_LIST, getProvinceCenterDepartmentListItemScope())
		.field(RetailStoreProvinceCenter.PROVINCE_CENTER_EMPLOYEE_LIST, getProvinceCenterEmployeeListItemScope())
		.field(RetailStoreProvinceCenter.RETAIL_STORE_CITY_SERVICE_CENTER_LIST, getRetailStoreCityServiceCenterListItemScope())
		;
	/** 用于RetailStoreProvinceCenter对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreProvinceCenterDetailScope() {
		return RetailStoreProvinceCenterBaseDetailScope;
	}

	protected static SerializeScope ProvinceCenterDepartmentBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ProvinceCenterDepartment.ID_PROPERTY)
		.field(ProvinceCenterDepartment.NAME_PROPERTY)
		.field(ProvinceCenterDepartment.FOUNDED_PROPERTY)
		.field(ProvinceCenterDepartment.PROVINCE_CENTER_PROPERTY, getRetailStoreProvinceCenterSummaryScope())
		.field(ProvinceCenterDepartment.MANAGER_PROPERTY)
		.field(ProvinceCenterDepartment.PROVINCE_CENTER_EMPLOYEE_LIST, getProvinceCenterEmployeeListItemScope())
		;
	/** 用于ProvinceCenterDepartment对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getProvinceCenterDepartmentDetailScope() {
		return ProvinceCenterDepartmentBaseDetailScope;
	}

	protected static SerializeScope ProvinceCenterEmployeeBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ProvinceCenterEmployee.ID_PROPERTY)
		.field(ProvinceCenterEmployee.NAME_PROPERTY)
		.field(ProvinceCenterEmployee.MOBILE_PROPERTY)
		.field(ProvinceCenterEmployee.EMAIL_PROPERTY)
		.field(ProvinceCenterEmployee.FOUNDED_PROPERTY)
		.field(ProvinceCenterEmployee.DEPARTMENT_PROPERTY, getProvinceCenterDepartmentSummaryScope())
		.field(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY, getRetailStoreProvinceCenterSummaryScope())
		;
	/** 用于ProvinceCenterEmployee对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getProvinceCenterEmployeeDetailScope() {
		return ProvinceCenterEmployeeBaseDetailScope;
	}

	protected static SerializeScope RetailStoreCityServiceCenterBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreCityServiceCenter.ID_PROPERTY)
		.field(RetailStoreCityServiceCenter.NAME_PROPERTY)
		.field(RetailStoreCityServiceCenter.FOUNDED_PROPERTY)
		.field(RetailStoreCityServiceCenter.BELONGS_TO_PROPERTY, getRetailStoreProvinceCenterSummaryScope())
		.field(RetailStoreCityServiceCenter.LAST_UPDATE_TIME_PROPERTY)
		.field(RetailStoreCityServiceCenter.CITY_PARTNER_LIST, getCityPartnerListItemScope())
		.field(RetailStoreCityServiceCenter.POTENTIAL_CUSTOMER_LIST, getPotentialCustomerListItemScope())
		.field(RetailStoreCityServiceCenter.CITY_EVENT_LIST, getCityEventListItemScope())
		.field(RetailStoreCityServiceCenter.RETAIL_STORE_LIST, getRetailStoreListItemScope())
		;
	/** 用于RetailStoreCityServiceCenter对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreCityServiceCenterDetailScope() {
		return RetailStoreCityServiceCenterBaseDetailScope;
	}

	protected static SerializeScope CityPartnerBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(CityPartner.ID_PROPERTY)
		.field(CityPartner.NAME_PROPERTY)
		.field(CityPartner.MOBILE_PROPERTY)
		.field(CityPartner.CITY_SERVICE_CENTER_PROPERTY, getRetailStoreCityServiceCenterSummaryScope())
		.field(CityPartner.DESCRIPTION_PROPERTY)
		.field(CityPartner.LAST_UPDATE_TIME_PROPERTY)
		.field(CityPartner.POTENTIAL_CUSTOMER_LIST, getPotentialCustomerListItemScope())
		.field(CityPartner.POTENTIAL_CUSTOMER_CONTACT_LIST, getPotentialCustomerContactListItemScope())
		;
	/** 用于CityPartner对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCityPartnerDetailScope() {
		return CityPartnerBaseDetailScope;
	}

	protected static SerializeScope PotentialCustomerBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomer.ID_PROPERTY)
		.field(PotentialCustomer.NAME_PROPERTY)
		.field(PotentialCustomer.MOBILE_PROPERTY)
		.field(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, getRetailStoreCityServiceCenterSummaryScope())
		.field(PotentialCustomer.CITY_PARTNER_PROPERTY, getCityPartnerSummaryScope())
		.field(PotentialCustomer.DESCRIPTION_PROPERTY)
		.field(PotentialCustomer.LAST_UPDATE_TIME_PROPERTY)
		.field(PotentialCustomer.POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST, getPotentialCustomerContactPersonListItemScope())
		.field(PotentialCustomer.POTENTIAL_CUSTOMER_CONTACT_LIST, getPotentialCustomerContactListItemScope())
		.field(PotentialCustomer.EVENT_ATTENDANCE_LIST, getEventAttendanceListItemScope())
		;
	/** 用于PotentialCustomer对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerDetailScope() {
		return PotentialCustomerBaseDetailScope;
	}

	protected static SerializeScope PotentialCustomerContactPersonBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomerContactPerson.ID_PROPERTY)
		.field(PotentialCustomerContactPerson.NAME_PROPERTY)
		.field(PotentialCustomerContactPerson.MOBILE_PROPERTY)
		.field(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomerSummaryScope())
		.field(PotentialCustomerContactPerson.DESCRIPTION_PROPERTY)
		.field(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_CONTACT_LIST, getPotentialCustomerContactListItemScope())
		;
	/** 用于PotentialCustomerContactPerson对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerContactPersonDetailScope() {
		return PotentialCustomerContactPersonBaseDetailScope;
	}

	protected static SerializeScope PotentialCustomerContactBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PotentialCustomerContact.ID_PROPERTY)
		.field(PotentialCustomerContact.NAME_PROPERTY)
		.field(PotentialCustomerContact.CONTACT_DATE_PROPERTY)
		.field(PotentialCustomerContact.CONTACT_METHOD_PROPERTY)
		.field(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomerSummaryScope())
		.field(PotentialCustomerContact.CITY_PARTNER_PROPERTY, getCityPartnerSummaryScope())
		.field(PotentialCustomerContact.CONTACT_TO_PROPERTY, getPotentialCustomerContactPersonSummaryScope())
		.field(PotentialCustomerContact.DESCRIPTION_PROPERTY)
		.field(PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于PotentialCustomerContact对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPotentialCustomerContactDetailScope() {
		return PotentialCustomerContactBaseDetailScope;
	}

	protected static SerializeScope CityEventBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(CityEvent.ID_PROPERTY)
		.field(CityEvent.NAME_PROPERTY)
		.field(CityEvent.MOBILE_PROPERTY)
		.field(CityEvent.CITY_SERVICE_CENTER_PROPERTY, getRetailStoreCityServiceCenterSummaryScope())
		.field(CityEvent.DESCRIPTION_PROPERTY)
		.field(CityEvent.LAST_UPDATE_TIME_PROPERTY)
		.field(CityEvent.EVENT_ATTENDANCE_LIST, getEventAttendanceListItemScope())
		;
	/** 用于CityEvent对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCityEventDetailScope() {
		return CityEventBaseDetailScope;
	}

	protected static SerializeScope EventAttendanceBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EventAttendance.ID_PROPERTY)
		.field(EventAttendance.NAME_PROPERTY)
		.field(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomerSummaryScope())
		.field(EventAttendance.CITY_EVENT_PROPERTY, getCityEventSummaryScope())
		.field(EventAttendance.DESCRIPTION_PROPERTY)
		;
	/** 用于EventAttendance对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEventAttendanceDetailScope() {
		return EventAttendanceBaseDetailScope;
	}

	protected static SerializeScope RetailStoreBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStore.ID_PROPERTY)
		.field(RetailStore.NAME_PROPERTY)
		.field(RetailStore.TELEPHONE_PROPERTY)
		.field(RetailStore.OWNER_PROPERTY)
		.field(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(RetailStore.CITY_SERVICE_CENTER_PROPERTY, getRetailStoreCityServiceCenterSummaryScope())
		.field(RetailStore.CREATION_PROPERTY, getRetailStoreCreationSummaryScope())
		.field(RetailStore.INVESTMENT_INVITATION_PROPERTY, getRetailStoreInvestmentInvitationSummaryScope())
		.field(RetailStore.FRANCHISING_PROPERTY, getRetailStoreFranchisingSummaryScope())
		.field(RetailStore.DECORATION_PROPERTY, getRetailStoreDecorationSummaryScope())
		.field(RetailStore.OPENING_PROPERTY, getRetailStoreOpeningSummaryScope())
		.field(RetailStore.CLOSING_PROPERTY, getRetailStoreClosingSummaryScope())
		.field(RetailStore.FOUNDED_PROPERTY)
		.field(RetailStore.LATITUDE_PROPERTY)
		.field(RetailStore.LONGITUDE_PROPERTY)
		.field(RetailStore.DESCRIPTION_PROPERTY)
		.field(RetailStore.LAST_UPDATE_TIME_PROPERTY)
		.field(RetailStore.CONSUMER_ORDER_LIST, getConsumerOrderListItemScope())
		.field(RetailStore.RETAIL_STORE_ORDER_LIST, getRetailStoreOrderListItemScope())
		.field(RetailStore.GOODS_LIST, getGoodsListItemScope())
		.field(RetailStore.TRANSPORT_TASK_LIST, getTransportTaskListItemScope())
		.field(RetailStore.ACCOUNT_SET_LIST, getAccountSetListItemScope())
		;
	/** 用于RetailStore对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreDetailScope() {
		return RetailStoreBaseDetailScope;
	}

	protected static SerializeScope RetailStoreCreationBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreCreation.ID_PROPERTY)
		.field(RetailStoreCreation.COMMENT_PROPERTY)
		.field(RetailStoreCreation.RETAIL_STORE_LIST, getRetailStoreListItemScope())
		;
	/** 用于RetailStoreCreation对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreCreationDetailScope() {
		return RetailStoreCreationBaseDetailScope;
	}

	protected static SerializeScope RetailStoreInvestmentInvitationBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreInvestmentInvitation.ID_PROPERTY)
		.field(RetailStoreInvestmentInvitation.COMMENT_PROPERTY)
		.field(RetailStoreInvestmentInvitation.RETAIL_STORE_LIST, getRetailStoreListItemScope())
		;
	/** 用于RetailStoreInvestmentInvitation对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreInvestmentInvitationDetailScope() {
		return RetailStoreInvestmentInvitationBaseDetailScope;
	}

	protected static SerializeScope RetailStoreFranchisingBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreFranchising.ID_PROPERTY)
		.field(RetailStoreFranchising.COMMENT_PROPERTY)
		.field(RetailStoreFranchising.RETAIL_STORE_LIST, getRetailStoreListItemScope())
		;
	/** 用于RetailStoreFranchising对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreFranchisingDetailScope() {
		return RetailStoreFranchisingBaseDetailScope;
	}

	protected static SerializeScope RetailStoreDecorationBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreDecoration.ID_PROPERTY)
		.field(RetailStoreDecoration.COMMENT_PROPERTY)
		.field(RetailStoreDecoration.RETAIL_STORE_LIST, getRetailStoreListItemScope())
		;
	/** 用于RetailStoreDecoration对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreDecorationDetailScope() {
		return RetailStoreDecorationBaseDetailScope;
	}

	protected static SerializeScope RetailStoreOpeningBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreOpening.ID_PROPERTY)
		.field(RetailStoreOpening.COMMENT_PROPERTY)
		.field(RetailStoreOpening.RETAIL_STORE_LIST, getRetailStoreListItemScope())
		;
	/** 用于RetailStoreOpening对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreOpeningDetailScope() {
		return RetailStoreOpeningBaseDetailScope;
	}

	protected static SerializeScope RetailStoreClosingBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreClosing.ID_PROPERTY)
		.field(RetailStoreClosing.COMMENT_PROPERTY)
		.field(RetailStoreClosing.RETAIL_STORE_LIST, getRetailStoreListItemScope())
		;
	/** 用于RetailStoreClosing对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreClosingDetailScope() {
		return RetailStoreClosingBaseDetailScope;
	}

	protected static SerializeScope RetailStoreMemberBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreMember.ID_PROPERTY)
		.field(RetailStoreMember.NAME_PROPERTY)
		.field(RetailStoreMember.MOBILE_PHONE_PROPERTY)
		.field(RetailStoreMember.OWNER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(RetailStoreMember.CONSUMER_ORDER_LIST, getConsumerOrderListItemScope())
		.field(RetailStoreMember.RETAIL_STORE_MEMBER_COUPON_LIST, getRetailStoreMemberCouponListItemScope())
		.field(RetailStoreMember.MEMBER_WISHLIST_LIST, getMemberWishlistListItemScope())
		.field(RetailStoreMember.MEMBER_REWARD_POINT_LIST, getMemberRewardPointListItemScope())
		.field(RetailStoreMember.MEMBER_REWARD_POINT_REDEMPTION_LIST, getMemberRewardPointRedemptionListItemScope())
		.field(RetailStoreMember.RETAIL_STORE_MEMBER_ADDRESS_LIST, getRetailStoreMemberAddressListItemScope())
		.field(RetailStoreMember.RETAIL_STORE_MEMBER_GIFT_CARD_LIST, getRetailStoreMemberGiftCardListItemScope())
		;
	/** 用于RetailStoreMember对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreMemberDetailScope() {
		return RetailStoreMemberBaseDetailScope;
	}

	protected static SerializeScope ConsumerOrderBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ConsumerOrder.ID_PROPERTY)
		.field(ConsumerOrder.TITLE_PROPERTY)
		.field(ConsumerOrder.CONSUMER_PROPERTY, getRetailStoreMemberSummaryScope())
		.field(ConsumerOrder.STORE_PROPERTY, getRetailStoreSummaryScope())
		.field(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY)
		.field(ConsumerOrder.CONSUMER_ORDER_LINE_ITEM_LIST, getConsumerOrderLineItemListItemScope())
		.field(ConsumerOrder.CONSUMER_ORDER_SHIPPING_GROUP_LIST, getConsumerOrderShippingGroupListItemScope())
		.field(ConsumerOrder.CONSUMER_ORDER_PAYMENT_GROUP_LIST, getConsumerOrderPaymentGroupListItemScope())
		.field(ConsumerOrder.CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST, getConsumerOrderPriceAdjustmentListItemScope())
		.field(ConsumerOrder.RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST, getRetailStoreMemberGiftCardConsumeRecordListItemScope())
		;
	/** 用于ConsumerOrder对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getConsumerOrderDetailScope() {
		return ConsumerOrderBaseDetailScope;
	}

	protected static SerializeScope ConsumerOrderLineItemBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ConsumerOrderLineItem.ID_PROPERTY)
		.field(ConsumerOrderLineItem.BIZ_ORDER_PROPERTY, getConsumerOrderSummaryScope())
		.field(ConsumerOrderLineItem.SKU_ID_PROPERTY)
		.field(ConsumerOrderLineItem.SKU_NAME_PROPERTY)
		.field(ConsumerOrderLineItem.PRICE_PROPERTY)
		.field(ConsumerOrderLineItem.QUANTITY_PROPERTY)
		.field(ConsumerOrderLineItem.AMOUNT_PROPERTY)
		.field(ConsumerOrderLineItem.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于ConsumerOrderLineItem对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getConsumerOrderLineItemDetailScope() {
		return ConsumerOrderLineItemBaseDetailScope;
	}

	protected static SerializeScope ConsumerOrderShippingGroupBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ConsumerOrderShippingGroup.ID_PROPERTY)
		.field(ConsumerOrderShippingGroup.NAME_PROPERTY)
		.field(ConsumerOrderShippingGroup.BIZ_ORDER_PROPERTY, getConsumerOrderSummaryScope())
		.field(ConsumerOrderShippingGroup.AMOUNT_PROPERTY)
		;
	/** 用于ConsumerOrderShippingGroup对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getConsumerOrderShippingGroupDetailScope() {
		return ConsumerOrderShippingGroupBaseDetailScope;
	}

	protected static SerializeScope ConsumerOrderPaymentGroupBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ConsumerOrderPaymentGroup.ID_PROPERTY)
		.field(ConsumerOrderPaymentGroup.NAME_PROPERTY)
		.field(ConsumerOrderPaymentGroup.BIZ_ORDER_PROPERTY, getConsumerOrderSummaryScope())
		.field(ConsumerOrderPaymentGroup.CARD_NUMBER_PROPERTY)
		;
	/** 用于ConsumerOrderPaymentGroup对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getConsumerOrderPaymentGroupDetailScope() {
		return ConsumerOrderPaymentGroupBaseDetailScope;
	}

	protected static SerializeScope ConsumerOrderPriceAdjustmentBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ConsumerOrderPriceAdjustment.ID_PROPERTY)
		.field(ConsumerOrderPriceAdjustment.NAME_PROPERTY)
		.field(ConsumerOrderPriceAdjustment.BIZ_ORDER_PROPERTY, getConsumerOrderSummaryScope())
		.field(ConsumerOrderPriceAdjustment.AMOUNT_PROPERTY)
		.field(ConsumerOrderPriceAdjustment.PROVIDER_PROPERTY)
		;
	/** 用于ConsumerOrderPriceAdjustment对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getConsumerOrderPriceAdjustmentDetailScope() {
		return ConsumerOrderPriceAdjustmentBaseDetailScope;
	}

	protected static SerializeScope RetailStoreMemberCouponBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreMemberCoupon.ID_PROPERTY)
		.field(RetailStoreMemberCoupon.NAME_PROPERTY)
		.field(RetailStoreMemberCoupon.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
		.field(RetailStoreMemberCoupon.NUMBER_PROPERTY)
		.field(RetailStoreMemberCoupon.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于RetailStoreMemberCoupon对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreMemberCouponDetailScope() {
		return RetailStoreMemberCouponBaseDetailScope;
	}

	protected static SerializeScope MemberWishlistBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(MemberWishlist.ID_PROPERTY)
		.field(MemberWishlist.NAME_PROPERTY)
		.field(MemberWishlist.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
		.field(MemberWishlist.MEMBER_WISHLIST_PRODUCT_LIST, getMemberWishlistProductListItemScope())
		;
	/** 用于MemberWishlist对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getMemberWishlistDetailScope() {
		return MemberWishlistBaseDetailScope;
	}

	protected static SerializeScope MemberRewardPointBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(MemberRewardPoint.ID_PROPERTY)
		.field(MemberRewardPoint.NAME_PROPERTY)
		.field(MemberRewardPoint.POINT_PROPERTY)
		.field(MemberRewardPoint.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
		;
	/** 用于MemberRewardPoint对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getMemberRewardPointDetailScope() {
		return MemberRewardPointBaseDetailScope;
	}

	protected static SerializeScope MemberRewardPointRedemptionBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(MemberRewardPointRedemption.ID_PROPERTY)
		.field(MemberRewardPointRedemption.NAME_PROPERTY)
		.field(MemberRewardPointRedemption.POINT_PROPERTY)
		.field(MemberRewardPointRedemption.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
		;
	/** 用于MemberRewardPointRedemption对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getMemberRewardPointRedemptionDetailScope() {
		return MemberRewardPointRedemptionBaseDetailScope;
	}

	protected static SerializeScope MemberWishlistProductBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(MemberWishlistProduct.ID_PROPERTY)
		.field(MemberWishlistProduct.NAME_PROPERTY)
		.field(MemberWishlistProduct.OWNER_PROPERTY, getMemberWishlistSummaryScope())
		;
	/** 用于MemberWishlistProduct对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getMemberWishlistProductDetailScope() {
		return MemberWishlistProductBaseDetailScope;
	}

	protected static SerializeScope RetailStoreMemberAddressBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreMemberAddress.ID_PROPERTY)
		.field(RetailStoreMemberAddress.NAME_PROPERTY)
		.field(RetailStoreMemberAddress.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
		.field(RetailStoreMemberAddress.MOBILE_PHONE_PROPERTY)
		.field(RetailStoreMemberAddress.ADDRESS_PROPERTY)
		;
	/** 用于RetailStoreMemberAddress对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreMemberAddressDetailScope() {
		return RetailStoreMemberAddressBaseDetailScope;
	}

	protected static SerializeScope RetailStoreMemberGiftCardBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreMemberGiftCard.ID_PROPERTY)
		.field(RetailStoreMemberGiftCard.NAME_PROPERTY)
		.field(RetailStoreMemberGiftCard.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
		.field(RetailStoreMemberGiftCard.NUMBER_PROPERTY)
		.field(RetailStoreMemberGiftCard.REMAIN_PROPERTY)
		.field(RetailStoreMemberGiftCard.RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST, getRetailStoreMemberGiftCardConsumeRecordListItemScope())
		;
	/** 用于RetailStoreMemberGiftCard对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreMemberGiftCardDetailScope() {
		return RetailStoreMemberGiftCardBaseDetailScope;
	}

	protected static SerializeScope RetailStoreMemberGiftCardConsumeRecordBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY)
		.field(RetailStoreMemberGiftCardConsumeRecord.OCCURE_TIME_PROPERTY)
		.field(RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY, getRetailStoreMemberGiftCardSummaryScope())
		.field(RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY, getConsumerOrderSummaryScope())
		.field(RetailStoreMemberGiftCardConsumeRecord.NUMBER_PROPERTY)
		.field(RetailStoreMemberGiftCardConsumeRecord.AMOUNT_PROPERTY)
		;
	/** 用于RetailStoreMemberGiftCardConsumeRecord对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreMemberGiftCardConsumeRecordDetailScope() {
		return RetailStoreMemberGiftCardConsumeRecordBaseDetailScope;
	}

	protected static SerializeScope GoodsSupplierBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(GoodsSupplier.ID_PROPERTY)
		.field(GoodsSupplier.NAME_PROPERTY)
		.field(GoodsSupplier.SUPPLY_PRODUCT_PROPERTY)
		.field(GoodsSupplier.BELONG_TO_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(GoodsSupplier.CONTACT_NUMBER_PROPERTY)
		.field(GoodsSupplier.DESCRIPTION_PROPERTY)
		.field(GoodsSupplier.LAST_UPDATE_TIME_PROPERTY)
		.field(GoodsSupplier.SUPPLIER_PRODUCT_LIST, getSupplierProductListItemScope())
		.field(GoodsSupplier.SUPPLY_ORDER_LIST, getSupplyOrderListItemScope())
		.field(GoodsSupplier.ACCOUNT_SET_LIST, getAccountSetListItemScope())
		;
	/** 用于GoodsSupplier对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGoodsSupplierDetailScope() {
		return GoodsSupplierBaseDetailScope;
	}

	protected static SerializeScope SupplierProductBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplierProduct.ID_PROPERTY)
		.field(SupplierProduct.PRODUCT_NAME_PROPERTY)
		.field(SupplierProduct.PRODUCT_DESCRIPTION_PROPERTY)
		.field(SupplierProduct.PRODUCT_UNIT_PROPERTY)
		.field(SupplierProduct.SUPPLIER_PROPERTY, getGoodsSupplierSummaryScope())
		.field(SupplierProduct.PRODUCT_SUPPLY_DURATION_LIST, getProductSupplyDurationListItemScope())
		;
	/** 用于SupplierProduct对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSupplierProductDetailScope() {
		return SupplierProductBaseDetailScope;
	}

	protected static SerializeScope ProductSupplyDurationBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ProductSupplyDuration.ID_PROPERTY)
		.field(ProductSupplyDuration.QUANTITY_PROPERTY)
		.field(ProductSupplyDuration.DURATION_PROPERTY)
		.field(ProductSupplyDuration.PRICE_PROPERTY)
		.field(ProductSupplyDuration.PRODUCT_PROPERTY, getSupplierProductSummaryScope())
		;
	/** 用于ProductSupplyDuration对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getProductSupplyDurationDetailScope() {
		return ProductSupplyDurationBaseDetailScope;
	}

	protected static SerializeScope SupplyOrderBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplyOrder.ID_PROPERTY)
		.field(SupplyOrder.BUYER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(SupplyOrder.SELLER_PROPERTY, getGoodsSupplierSummaryScope())
		.field(SupplyOrder.TITLE_PROPERTY)
		.field(SupplyOrder.TOTAL_AMOUNT_PROPERTY)
		.field(SupplyOrder.LAST_UPDATE_TIME_PROPERTY)
		.field(SupplyOrder.SUPPLY_ORDER_LINE_ITEM_LIST, getSupplyOrderLineItemListItemScope())
		.field(SupplyOrder.SUPPLY_ORDER_SHIPPING_GROUP_LIST, getSupplyOrderShippingGroupListItemScope())
		.field(SupplyOrder.SUPPLY_ORDER_PAYMENT_GROUP_LIST, getSupplyOrderPaymentGroupListItemScope())
		.field(SupplyOrder.GOODS_LIST, getGoodsListItemScope())
		;
	/** 用于SupplyOrder对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSupplyOrderDetailScope() {
		return SupplyOrderBaseDetailScope;
	}

	protected static SerializeScope SupplyOrderLineItemBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplyOrderLineItem.ID_PROPERTY)
		.field(SupplyOrderLineItem.BIZ_ORDER_PROPERTY, getSupplyOrderSummaryScope())
		.field(SupplyOrderLineItem.SKU_ID_PROPERTY)
		.field(SupplyOrderLineItem.SKU_NAME_PROPERTY)
		.field(SupplyOrderLineItem.AMOUNT_PROPERTY)
		.field(SupplyOrderLineItem.QUANTITY_PROPERTY)
		.field(SupplyOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY)
		;
	/** 用于SupplyOrderLineItem对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSupplyOrderLineItemDetailScope() {
		return SupplyOrderLineItemBaseDetailScope;
	}

	protected static SerializeScope SupplyOrderShippingGroupBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplyOrderShippingGroup.ID_PROPERTY)
		.field(SupplyOrderShippingGroup.NAME_PROPERTY)
		.field(SupplyOrderShippingGroup.BIZ_ORDER_PROPERTY, getSupplyOrderSummaryScope())
		.field(SupplyOrderShippingGroup.AMOUNT_PROPERTY)
		;
	/** 用于SupplyOrderShippingGroup对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSupplyOrderShippingGroupDetailScope() {
		return SupplyOrderShippingGroupBaseDetailScope;
	}

	protected static SerializeScope SupplyOrderPaymentGroupBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplyOrderPaymentGroup.ID_PROPERTY)
		.field(SupplyOrderPaymentGroup.NAME_PROPERTY)
		.field(SupplyOrderPaymentGroup.BIZ_ORDER_PROPERTY, getSupplyOrderSummaryScope())
		.field(SupplyOrderPaymentGroup.CARD_NUMBER_PROPERTY)
		;
	/** 用于SupplyOrderPaymentGroup对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSupplyOrderPaymentGroupDetailScope() {
		return SupplyOrderPaymentGroupBaseDetailScope;
	}

	protected static SerializeScope RetailStoreOrderBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreOrder.ID_PROPERTY)
		.field(RetailStoreOrder.BUYER_PROPERTY, getRetailStoreSummaryScope())
		.field(RetailStoreOrder.SELLER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(RetailStoreOrder.TITLE_PROPERTY)
		.field(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY)
		.field(RetailStoreOrder.LAST_UPDATE_TIME_PROPERTY)
		.field(RetailStoreOrder.RETAIL_STORE_ORDER_LINE_ITEM_LIST, getRetailStoreOrderLineItemListItemScope())
		.field(RetailStoreOrder.RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST, getRetailStoreOrderShippingGroupListItemScope())
		.field(RetailStoreOrder.RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST, getRetailStoreOrderPaymentGroupListItemScope())
		.field(RetailStoreOrder.GOODS_LIST, getGoodsListItemScope())
		;
	/** 用于RetailStoreOrder对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreOrderDetailScope() {
		return RetailStoreOrderBaseDetailScope;
	}

	protected static SerializeScope RetailStoreOrderLineItemBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreOrderLineItem.ID_PROPERTY)
		.field(RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY, getRetailStoreOrderSummaryScope())
		.field(RetailStoreOrderLineItem.SKU_ID_PROPERTY)
		.field(RetailStoreOrderLineItem.SKU_NAME_PROPERTY)
		.field(RetailStoreOrderLineItem.AMOUNT_PROPERTY)
		.field(RetailStoreOrderLineItem.QUANTITY_PROPERTY)
		.field(RetailStoreOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY)
		;
	/** 用于RetailStoreOrderLineItem对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreOrderLineItemDetailScope() {
		return RetailStoreOrderLineItemBaseDetailScope;
	}

	protected static SerializeScope RetailStoreOrderShippingGroupBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreOrderShippingGroup.ID_PROPERTY)
		.field(RetailStoreOrderShippingGroup.NAME_PROPERTY)
		.field(RetailStoreOrderShippingGroup.BIZ_ORDER_PROPERTY, getRetailStoreOrderSummaryScope())
		.field(RetailStoreOrderShippingGroup.AMOUNT_PROPERTY)
		;
	/** 用于RetailStoreOrderShippingGroup对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreOrderShippingGroupDetailScope() {
		return RetailStoreOrderShippingGroupBaseDetailScope;
	}

	protected static SerializeScope RetailStoreOrderPaymentGroupBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(RetailStoreOrderPaymentGroup.ID_PROPERTY)
		.field(RetailStoreOrderPaymentGroup.NAME_PROPERTY)
		.field(RetailStoreOrderPaymentGroup.BIZ_ORDER_PROPERTY, getRetailStoreOrderSummaryScope())
		.field(RetailStoreOrderPaymentGroup.CARD_NUMBER_PROPERTY)
		;
	/** 用于RetailStoreOrderPaymentGroup对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRetailStoreOrderPaymentGroupDetailScope() {
		return RetailStoreOrderPaymentGroupBaseDetailScope;
	}

	protected static SerializeScope WarehouseBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Warehouse.ID_PROPERTY)
		.field(Warehouse.LOCATION_PROPERTY)
		.field(Warehouse.CONTACT_NUMBER_PROPERTY)
		.field(Warehouse.TOTAL_AREA_PROPERTY)
		.field(Warehouse.OWNER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(Warehouse.LATITUDE_PROPERTY)
		.field(Warehouse.LONGITUDE_PROPERTY)
		.field(Warehouse.LAST_UPDATE_TIME_PROPERTY)
		.field(Warehouse.STORAGE_SPACE_LIST, getStorageSpaceListItemScope())
		.field(Warehouse.SMART_PALLET_LIST, getSmartPalletListItemScope())
		.field(Warehouse.SUPPLIER_SPACE_LIST, getSupplierSpaceListItemScope())
		.field(Warehouse.RECEIVING_SPACE_LIST, getReceivingSpaceListItemScope())
		.field(Warehouse.SHIPPING_SPACE_LIST, getShippingSpaceListItemScope())
		.field(Warehouse.DAMAGE_SPACE_LIST, getDamageSpaceListItemScope())
		.field(Warehouse.WAREHOUSE_ASSET_LIST, getWarehouseAssetListItemScope())
		;
	/** 用于Warehouse对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getWarehouseDetailScope() {
		return WarehouseBaseDetailScope;
	}

	protected static SerializeScope StorageSpaceBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(StorageSpace.ID_PROPERTY)
		.field(StorageSpace.LOCATION_PROPERTY)
		.field(StorageSpace.CONTACT_NUMBER_PROPERTY)
		.field(StorageSpace.TOTAL_AREA_PROPERTY)
		.field(StorageSpace.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
		.field(StorageSpace.LATITUDE_PROPERTY)
		.field(StorageSpace.LONGITUDE_PROPERTY)
		.field(StorageSpace.LAST_UPDATE_TIME_PROPERTY)
		.field(StorageSpace.GOODS_SHELF_LIST, getGoodsShelfListItemScope())
		;
	/** 用于StorageSpace对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getStorageSpaceDetailScope() {
		return StorageSpaceBaseDetailScope;
	}

	protected static SerializeScope SmartPalletBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SmartPallet.ID_PROPERTY)
		.field(SmartPallet.LOCATION_PROPERTY)
		.field(SmartPallet.CONTACT_NUMBER_PROPERTY)
		.field(SmartPallet.TOTAL_AREA_PROPERTY)
		.field(SmartPallet.LATITUDE_PROPERTY)
		.field(SmartPallet.LONGITUDE_PROPERTY)
		.field(SmartPallet.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
		.field(SmartPallet.LAST_UPDATE_TIME_PROPERTY)
		.field(SmartPallet.GOODS_LIST, getGoodsListItemScope())
		;
	/** 用于SmartPallet对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSmartPalletDetailScope() {
		return SmartPalletBaseDetailScope;
	}

	protected static SerializeScope GoodsShelfBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(GoodsShelf.ID_PROPERTY)
		.field(GoodsShelf.LOCATION_PROPERTY)
		.field(GoodsShelf.STORAGE_SPACE_PROPERTY, getStorageSpaceSummaryScope())
		.field(GoodsShelf.SUPPLIER_SPACE_PROPERTY, getSupplierSpaceSummaryScope())
		.field(GoodsShelf.DAMAGE_SPACE_PROPERTY, getDamageSpaceSummaryScope())
		.field(GoodsShelf.LAST_UPDATE_TIME_PROPERTY)
		.field(GoodsShelf.GOODS_SHELF_STOCK_COUNT_LIST, getGoodsShelfStockCountListItemScope())
		.field(GoodsShelf.GOODS_ALLOCATION_LIST, getGoodsAllocationListItemScope())
		;
	/** 用于GoodsShelf对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGoodsShelfDetailScope() {
		return GoodsShelfBaseDetailScope;
	}

	protected static SerializeScope GoodsShelfStockCountBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(GoodsShelfStockCount.ID_PROPERTY)
		.field(GoodsShelfStockCount.TITLE_PROPERTY)
		.field(GoodsShelfStockCount.COUNT_TIME_PROPERTY)
		.field(GoodsShelfStockCount.SUMMARY_PROPERTY)
		.field(GoodsShelfStockCount.SHELF_PROPERTY, getGoodsShelfSummaryScope())
		.field(GoodsShelfStockCount.STOCK_COUNT_ISSUE_TRACK_LIST, getStockCountIssueTrackListItemScope())
		;
	/** 用于GoodsShelfStockCount对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGoodsShelfStockCountDetailScope() {
		return GoodsShelfStockCountBaseDetailScope;
	}

	protected static SerializeScope StockCountIssueTrackBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(StockCountIssueTrack.ID_PROPERTY)
		.field(StockCountIssueTrack.TITLE_PROPERTY)
		.field(StockCountIssueTrack.COUNT_TIME_PROPERTY)
		.field(StockCountIssueTrack.SUMMARY_PROPERTY)
		.field(StockCountIssueTrack.STOCK_COUNT_PROPERTY, getGoodsShelfStockCountSummaryScope())
		;
	/** 用于StockCountIssueTrack对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getStockCountIssueTrackDetailScope() {
		return StockCountIssueTrackBaseDetailScope;
	}

	protected static SerializeScope GoodsAllocationBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(GoodsAllocation.ID_PROPERTY)
		.field(GoodsAllocation.LOCATION_PROPERTY)
		.field(GoodsAllocation.LATITUDE_PROPERTY)
		.field(GoodsAllocation.LONGITUDE_PROPERTY)
		.field(GoodsAllocation.GOODS_SHELF_PROPERTY, getGoodsShelfSummaryScope())
		.field(GoodsAllocation.GOODS_LIST, getGoodsListItemScope())
		;
	/** 用于GoodsAllocation对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGoodsAllocationDetailScope() {
		return GoodsAllocationBaseDetailScope;
	}

	protected static SerializeScope GoodsBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Goods.ID_PROPERTY)
		.field(Goods.NAME_PROPERTY)
		.field(Goods.RFID_PROPERTY)
		.field(Goods.UOM_PROPERTY)
		.field(Goods.MAX_PACKAGE_PROPERTY)
		.field(Goods.EXPIRE_TIME_PROPERTY)
		.field(Goods.SKU_PROPERTY, getSkuSummaryScope())
		.field(Goods.RECEIVING_SPACE_PROPERTY, getReceivingSpaceSummaryScope())
		.field(Goods.GOODS_ALLOCATION_PROPERTY, getGoodsAllocationSummaryScope())
		.field(Goods.SMART_PALLET_PROPERTY, getSmartPalletSummaryScope())
		.field(Goods.SHIPPING_SPACE_PROPERTY, getShippingSpaceSummaryScope())
		.field(Goods.TRANSPORT_TASK_PROPERTY, getTransportTaskSummaryScope())
		.field(Goods.RETAIL_STORE_PROPERTY, getRetailStoreSummaryScope())
		.field(Goods.BIZ_ORDER_PROPERTY, getSupplyOrderSummaryScope())
		.field(Goods.RETAIL_STORE_ORDER_PROPERTY, getRetailStoreOrderSummaryScope())
		.field(Goods.GOODS_MOVEMENT_LIST, getGoodsMovementListItemScope())
		;
	/** 用于Goods对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGoodsDetailScope() {
		return GoodsBaseDetailScope;
	}

	protected static SerializeScope GoodsMovementBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(GoodsMovement.ID_PROPERTY)
		.field(GoodsMovement.MOVE_TIME_PROPERTY)
		.field(GoodsMovement.FACILITY_PROPERTY)
		.field(GoodsMovement.FACILITY_ID_PROPERTY)
		.field(GoodsMovement.FROM_IP_PROPERTY)
		.field(GoodsMovement.USER_AGENT_PROPERTY)
		.field(GoodsMovement.SESSION_ID_PROPERTY)
		.field(GoodsMovement.LATITUDE_PROPERTY)
		.field(GoodsMovement.LONGITUDE_PROPERTY)
		.field(GoodsMovement.GOODS_PROPERTY, getGoodsSummaryScope())
		;
	/** 用于GoodsMovement对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGoodsMovementDetailScope() {
		return GoodsMovementBaseDetailScope;
	}

	protected static SerializeScope SupplierSpaceBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SupplierSpace.ID_PROPERTY)
		.field(SupplierSpace.LOCATION_PROPERTY)
		.field(SupplierSpace.CONTACT_NUMBER_PROPERTY)
		.field(SupplierSpace.TOTAL_AREA_PROPERTY)
		.field(SupplierSpace.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
		.field(SupplierSpace.LATITUDE_PROPERTY)
		.field(SupplierSpace.LONGITUDE_PROPERTY)
		.field(SupplierSpace.LAST_UPDATE_TIME_PROPERTY)
		.field(SupplierSpace.GOODS_SHELF_LIST, getGoodsShelfListItemScope())
		;
	/** 用于SupplierSpace对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSupplierSpaceDetailScope() {
		return SupplierSpaceBaseDetailScope;
	}

	protected static SerializeScope ReceivingSpaceBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ReceivingSpace.ID_PROPERTY)
		.field(ReceivingSpace.LOCATION_PROPERTY)
		.field(ReceivingSpace.CONTACT_NUMBER_PROPERTY)
		.field(ReceivingSpace.DESCRIPTION_PROPERTY)
		.field(ReceivingSpace.TOTAL_AREA_PROPERTY)
		.field(ReceivingSpace.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
		.field(ReceivingSpace.LATITUDE_PROPERTY)
		.field(ReceivingSpace.LONGITUDE_PROPERTY)
		.field(ReceivingSpace.LAST_UPDATE_TIME_PROPERTY)
		.field(ReceivingSpace.GOODS_LIST, getGoodsListItemScope())
		;
	/** 用于ReceivingSpace对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getReceivingSpaceDetailScope() {
		return ReceivingSpaceBaseDetailScope;
	}

	protected static SerializeScope ShippingSpaceBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ShippingSpace.ID_PROPERTY)
		.field(ShippingSpace.LOCATION_PROPERTY)
		.field(ShippingSpace.CONTACT_NUMBER_PROPERTY)
		.field(ShippingSpace.TOTAL_AREA_PROPERTY)
		.field(ShippingSpace.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
		.field(ShippingSpace.LATITUDE_PROPERTY)
		.field(ShippingSpace.LONGITUDE_PROPERTY)
		.field(ShippingSpace.DESCRIPTION_PROPERTY)
		.field(ShippingSpace.LAST_UPDATE_TIME_PROPERTY)
		.field(ShippingSpace.GOODS_LIST, getGoodsListItemScope())
		;
	/** 用于ShippingSpace对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getShippingSpaceDetailScope() {
		return ShippingSpaceBaseDetailScope;
	}

	protected static SerializeScope DamageSpaceBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(DamageSpace.ID_PROPERTY)
		.field(DamageSpace.LOCATION_PROPERTY)
		.field(DamageSpace.CONTACT_NUMBER_PROPERTY)
		.field(DamageSpace.TOTAL_AREA_PROPERTY)
		.field(DamageSpace.LATITUDE_PROPERTY)
		.field(DamageSpace.LONGITUDE_PROPERTY)
		.field(DamageSpace.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
		.field(DamageSpace.LAST_UPDATE_TIME_PROPERTY)
		.field(DamageSpace.GOODS_SHELF_LIST, getGoodsShelfListItemScope())
		;
	/** 用于DamageSpace对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getDamageSpaceDetailScope() {
		return DamageSpaceBaseDetailScope;
	}

	protected static SerializeScope WarehouseAssetBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(WarehouseAsset.ID_PROPERTY)
		.field(WarehouseAsset.NAME_PROPERTY)
		.field(WarehouseAsset.POSITION_PROPERTY)
		.field(WarehouseAsset.OWNER_PROPERTY, getWarehouseSummaryScope())
		.field(WarehouseAsset.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于WarehouseAsset对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getWarehouseAssetDetailScope() {
		return WarehouseAssetBaseDetailScope;
	}

	protected static SerializeScope TransportFleetBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TransportFleet.ID_PROPERTY)
		.field(TransportFleet.NAME_PROPERTY)
		.field(TransportFleet.CONTACT_NUMBER_PROPERTY)
		.field(TransportFleet.OWNER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(TransportFleet.LAST_UPDATE_TIME_PROPERTY)
		.field(TransportFleet.TRANSPORT_TRUCK_LIST, getTransportTruckListItemScope())
		.field(TransportFleet.TRUCK_DRIVER_LIST, getTruckDriverListItemScope())
		.field(TransportFleet.TRANSPORT_TASK_LIST, getTransportTaskListItemScope())
		;
	/** 用于TransportFleet对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTransportFleetDetailScope() {
		return TransportFleetBaseDetailScope;
	}

	protected static SerializeScope TransportTruckBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TransportTruck.ID_PROPERTY)
		.field(TransportTruck.NAME_PROPERTY)
		.field(TransportTruck.PLATE_NUMBER_PROPERTY)
		.field(TransportTruck.CONTACT_NUMBER_PROPERTY)
		.field(TransportTruck.VEHICLE_LICENSE_NUMBER_PROPERTY)
		.field(TransportTruck.ENGINE_NUMBER_PROPERTY)
		.field(TransportTruck.MAKE_DATE_PROPERTY)
		.field(TransportTruck.MILEAGE_PROPERTY)
		.field(TransportTruck.BODY_COLOR_PROPERTY)
		.field(TransportTruck.OWNER_PROPERTY, getTransportFleetSummaryScope())
		.field(TransportTruck.TRANSPORT_TASK_LIST, getTransportTaskListItemScope())
		;
	/** 用于TransportTruck对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTransportTruckDetailScope() {
		return TransportTruckBaseDetailScope;
	}

	protected static SerializeScope TruckDriverBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TruckDriver.ID_PROPERTY)
		.field(TruckDriver.NAME_PROPERTY)
		.field(TruckDriver.DRIVER_LICENSE_NUMBER_PROPERTY)
		.field(TruckDriver.CONTACT_NUMBER_PROPERTY)
		.field(TruckDriver.BELONGS_TO_PROPERTY, getTransportFleetSummaryScope())
		.field(TruckDriver.TRANSPORT_TASK_LIST, getTransportTaskListItemScope())
		;
	/** 用于TruckDriver对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTruckDriverDetailScope() {
		return TruckDriverBaseDetailScope;
	}

	protected static SerializeScope TransportTaskBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TransportTask.ID_PROPERTY)
		.field(TransportTask.NAME_PROPERTY)
		.field(TransportTask.START_PROPERTY)
		.field(TransportTask.BEGIN_TIME_PROPERTY)
		.field(TransportTask.END_PROPERTY, getRetailStoreSummaryScope())
		.field(TransportTask.DRIVER_PROPERTY, getTruckDriverSummaryScope())
		.field(TransportTask.TRUCK_PROPERTY, getTransportTruckSummaryScope())
		.field(TransportTask.BELONGS_TO_PROPERTY, getTransportFleetSummaryScope())
		.field(TransportTask.LATITUDE_PROPERTY)
		.field(TransportTask.LONGITUDE_PROPERTY)
		.field(TransportTask.GOODS_LIST, getGoodsListItemScope())
		.field(TransportTask.TRANSPORT_TASK_TRACK_LIST, getTransportTaskTrackListItemScope())
		;
	/** 用于TransportTask对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTransportTaskDetailScope() {
		return TransportTaskBaseDetailScope;
	}

	protected static SerializeScope TransportTaskTrackBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TransportTaskTrack.ID_PROPERTY)
		.field(TransportTaskTrack.TRACK_TIME_PROPERTY)
		.field(TransportTaskTrack.LATITUDE_PROPERTY)
		.field(TransportTaskTrack.LONGITUDE_PROPERTY)
		.field(TransportTaskTrack.MOVEMENT_PROPERTY, getTransportTaskSummaryScope())
		;
	/** 用于TransportTaskTrack对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTransportTaskTrackDetailScope() {
		return TransportTaskTrackBaseDetailScope;
	}

	protected static SerializeScope AccountSetBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountSet.ID_PROPERTY)
		.field(AccountSet.NAME_PROPERTY)
		.field(AccountSet.YEAR_SET_PROPERTY)
		.field(AccountSet.EFFECTIVE_DATE_PROPERTY)
		.field(AccountSet.ACCOUNTING_SYSTEM_PROPERTY)
		.field(AccountSet.DOMESTIC_CURRENCY_CODE_PROPERTY)
		.field(AccountSet.DOMESTIC_CURRENCY_NAME_PROPERTY)
		.field(AccountSet.OPENING_BANK_PROPERTY)
		.field(AccountSet.ACCOUNT_NUMBER_PROPERTY)
		.field(AccountSet.COUNTRY_CENTER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(AccountSet.RETAIL_STORE_PROPERTY, getRetailStoreSummaryScope())
		.field(AccountSet.GOODS_SUPPLIER_PROPERTY, getGoodsSupplierSummaryScope())
		.field(AccountSet.LAST_UPDATE_TIME_PROPERTY)
		.field(AccountSet.ACCOUNTING_SUBJECT_LIST, getAccountingSubjectListItemScope())
		.field(AccountSet.ACCOUNTING_PERIOD_LIST, getAccountingPeriodListItemScope())
		.field(AccountSet.ACCOUNTING_DOCUMENT_TYPE_LIST, getAccountingDocumentTypeListItemScope())
		;
	/** 用于AccountSet对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getAccountSetDetailScope() {
		return AccountSetBaseDetailScope;
	}

	protected static SerializeScope AccountingSubjectBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountingSubject.ID_PROPERTY)
		.field(AccountingSubject.ACCOUNTING_SUBJECT_CODE_PROPERTY)
		.field(AccountingSubject.ACCOUNTING_SUBJECT_NAME_PROPERTY)
		.field(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY)
		.field(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY)
		.field(AccountingSubject.ACCOUNT_SET_PROPERTY, getAccountSetSummaryScope())
		.field(AccountingSubject.ACCOUNTING_DOCUMENT_LINE_LIST, getAccountingDocumentLineListItemScope())
		;
	/** 用于AccountingSubject对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getAccountingSubjectDetailScope() {
		return AccountingSubjectBaseDetailScope;
	}

	protected static SerializeScope AccountingPeriodBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountingPeriod.ID_PROPERTY)
		.field(AccountingPeriod.NAME_PROPERTY)
		.field(AccountingPeriod.START_DATE_PROPERTY)
		.field(AccountingPeriod.END_DATE_PROPERTY)
		.field(AccountingPeriod.ACCOUNT_SET_PROPERTY, getAccountSetSummaryScope())
		.field(AccountingPeriod.ACCOUNTING_DOCUMENT_LIST, getAccountingDocumentListItemScope())
		;
	/** 用于AccountingPeriod对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getAccountingPeriodDetailScope() {
		return AccountingPeriodBaseDetailScope;
	}

	protected static SerializeScope AccountingDocumentTypeBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountingDocumentType.ID_PROPERTY)
		.field(AccountingDocumentType.NAME_PROPERTY)
		.field(AccountingDocumentType.DESCRIPTION_PROPERTY)
		.field(AccountingDocumentType.ACCOUNTING_PERIOD_PROPERTY, getAccountSetSummaryScope())
		.field(AccountingDocumentType.ACCOUNTING_DOCUMENT_LIST, getAccountingDocumentListItemScope())
		;
	/** 用于AccountingDocumentType对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getAccountingDocumentTypeDetailScope() {
		return AccountingDocumentTypeBaseDetailScope;
	}

	protected static SerializeScope AccountingDocumentBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountingDocument.ID_PROPERTY)
		.field(AccountingDocument.NAME_PROPERTY)
		.field(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY)
		.field(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, getAccountingPeriodSummaryScope())
		.field(AccountingDocument.DOCUMENT_TYPE_PROPERTY, getAccountingDocumentTypeSummaryScope())
		.field(AccountingDocument.ORIGINAL_VOUCHER_LIST, getOriginalVoucherListItemScope())
		.field(AccountingDocument.ACCOUNTING_DOCUMENT_LINE_LIST, getAccountingDocumentLineListItemScope())
		;
	/** 用于AccountingDocument对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getAccountingDocumentDetailScope() {
		return AccountingDocumentBaseDetailScope;
	}

	protected static SerializeScope OriginalVoucherBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(OriginalVoucher.ID_PROPERTY)
		.field(OriginalVoucher.TITLE_PROPERTY)
		.field(OriginalVoucher.MADE_BY_PROPERTY)
		.field(OriginalVoucher.RECEIVED_BY_PROPERTY)
		.field(OriginalVoucher.VOUCHER_TYPE_PROPERTY)
		.field(OriginalVoucher.VOUCHER_IMAGE_PROPERTY)
		.field(OriginalVoucher.BELONGS_TO_PROPERTY, getAccountingDocumentSummaryScope())
		;
	/** 用于OriginalVoucher对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getOriginalVoucherDetailScope() {
		return OriginalVoucherBaseDetailScope;
	}

	protected static SerializeScope AccountingDocumentLineBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(AccountingDocumentLine.ID_PROPERTY)
		.field(AccountingDocumentLine.NAME_PROPERTY)
		.field(AccountingDocumentLine.CODE_PROPERTY)
		.field(AccountingDocumentLine.DIRECT_PROPERTY)
		.field(AccountingDocumentLine.AMOUNT_PROPERTY)
		.field(AccountingDocumentLine.BELONGS_TO_PROPERTY, getAccountingDocumentSummaryScope())
		.field(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY, getAccountingSubjectSummaryScope())
		;
	/** 用于AccountingDocumentLine对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getAccountingDocumentLineDetailScope() {
		return AccountingDocumentLineBaseDetailScope;
	}

	protected static SerializeScope LevelOneDepartmentBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelOneDepartment.ID_PROPERTY)
		.field(LevelOneDepartment.BELONGS_TO_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(LevelOneDepartment.NAME_PROPERTY)
		.field(LevelOneDepartment.DESCRIPTION_PROPERTY)
		.field(LevelOneDepartment.MANAGER_PROPERTY)
		.field(LevelOneDepartment.FOUNDED_PROPERTY)
		.field(LevelOneDepartment.LEVEL_TWO_DEPARTMENT_LIST, getLevelTwoDepartmentListItemScope())
		;
	/** 用于LevelOneDepartment对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLevelOneDepartmentDetailScope() {
		return LevelOneDepartmentBaseDetailScope;
	}

	protected static SerializeScope LevelTwoDepartmentBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelTwoDepartment.ID_PROPERTY)
		.field(LevelTwoDepartment.BELONGS_TO_PROPERTY, getLevelOneDepartmentSummaryScope())
		.field(LevelTwoDepartment.NAME_PROPERTY)
		.field(LevelTwoDepartment.DESCRIPTION_PROPERTY)
		.field(LevelTwoDepartment.FOUNDED_PROPERTY)
		.field(LevelTwoDepartment.LEVEL_THREE_DEPARTMENT_LIST, getLevelThreeDepartmentListItemScope())
		;
	/** 用于LevelTwoDepartment对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLevelTwoDepartmentDetailScope() {
		return LevelTwoDepartmentBaseDetailScope;
	}

	protected static SerializeScope LevelThreeDepartmentBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LevelThreeDepartment.ID_PROPERTY)
		.field(LevelThreeDepartment.BELONGS_TO_PROPERTY, getLevelTwoDepartmentSummaryScope())
		.field(LevelThreeDepartment.NAME_PROPERTY)
		.field(LevelThreeDepartment.DESCRIPTION_PROPERTY)
		.field(LevelThreeDepartment.FOUNDED_PROPERTY)
		.field(LevelThreeDepartment.EMPLOYEE_LIST, getEmployeeListItemScope())
		;
	/** 用于LevelThreeDepartment对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLevelThreeDepartmentDetailScope() {
		return LevelThreeDepartmentBaseDetailScope;
	}

	protected static SerializeScope SkillTypeBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SkillType.ID_PROPERTY)
		.field(SkillType.CODE_PROPERTY)
		.field(SkillType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(SkillType.DESCRIPTION_PROPERTY)
		.field(SkillType.EMPLOYEE_SKILL_LIST, getEmployeeSkillListItemScope())
		;
	/** 用于SkillType对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSkillTypeDetailScope() {
		return SkillTypeBaseDetailScope;
	}

	protected static SerializeScope ResponsibilityTypeBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ResponsibilityType.ID_PROPERTY)
		.field(ResponsibilityType.CODE_PROPERTY)
		.field(ResponsibilityType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(ResponsibilityType.BASE_DESCRIPTION_PROPERTY)
		.field(ResponsibilityType.DETAIL_DESCRIPTION_PROPERTY)
		.field(ResponsibilityType.EMPLOYEE_LIST, getEmployeeListItemScope())
		;
	/** 用于ResponsibilityType对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getResponsibilityTypeDetailScope() {
		return ResponsibilityTypeBaseDetailScope;
	}

	protected static SerializeScope TerminationReasonBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TerminationReason.ID_PROPERTY)
		.field(TerminationReason.CODE_PROPERTY)
		.field(TerminationReason.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(TerminationReason.DESCRIPTION_PROPERTY)
		.field(TerminationReason.TERMINATION_LIST, getTerminationListItemScope())
		;
	/** 用于TerminationReason对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTerminationReasonDetailScope() {
		return TerminationReasonBaseDetailScope;
	}

	protected static SerializeScope TerminationTypeBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TerminationType.ID_PROPERTY)
		.field(TerminationType.CODE_PROPERTY)
		.field(TerminationType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(TerminationType.BASE_DESCRIPTION_PROPERTY)
		.field(TerminationType.DETAIL_DESCRIPTION_PROPERTY)
		.field(TerminationType.TERMINATION_LIST, getTerminationListItemScope())
		;
	/** 用于TerminationType对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTerminationTypeDetailScope() {
		return TerminationTypeBaseDetailScope;
	}

	protected static SerializeScope OccupationTypeBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(OccupationType.ID_PROPERTY)
		.field(OccupationType.CODE_PROPERTY)
		.field(OccupationType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(OccupationType.DESCRIPTION_PROPERTY)
		.field(OccupationType.DETAIL_DESCRIPTION_PROPERTY)
		.field(OccupationType.EMPLOYEE_LIST, getEmployeeListItemScope())
		;
	/** 用于OccupationType对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getOccupationTypeDetailScope() {
		return OccupationTypeBaseDetailScope;
	}

	protected static SerializeScope LeaveTypeBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LeaveType.ID_PROPERTY)
		.field(LeaveType.CODE_PROPERTY)
		.field(LeaveType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(LeaveType.DESCRIPTION_PROPERTY)
		.field(LeaveType.DETAIL_DESCRIPTION_PROPERTY)
		.field(LeaveType.EMPLOYEE_LEAVE_LIST, getEmployeeLeaveListItemScope())
		;
	/** 用于LeaveType对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLeaveTypeDetailScope() {
		return LeaveTypeBaseDetailScope;
	}

	protected static SerializeScope SalaryGradeBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SalaryGrade.ID_PROPERTY)
		.field(SalaryGrade.CODE_PROPERTY)
		.field(SalaryGrade.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(SalaryGrade.NAME_PROPERTY)
		.field(SalaryGrade.DETAIL_DESCRIPTION_PROPERTY)
		.field(SalaryGrade.EMPLOYEE_LIST, getEmployeeListItemScope())
		.field(SalaryGrade.EMPLOYEE_SALARY_SHEET_LIST, getEmployeeSalarySheetListItemScope())
		;
	/** 用于SalaryGrade对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSalaryGradeDetailScope() {
		return SalaryGradeBaseDetailScope;
	}

	protected static SerializeScope InterviewTypeBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(InterviewType.ID_PROPERTY)
		.field(InterviewType.CODE_PROPERTY)
		.field(InterviewType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(InterviewType.DESCRIPTION_PROPERTY)
		.field(InterviewType.DETAIL_DESCRIPTION_PROPERTY)
		.field(InterviewType.EMPLOYEE_INTERVIEW_LIST, getEmployeeInterviewListItemScope())
		;
	/** 用于InterviewType对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getInterviewTypeDetailScope() {
		return InterviewTypeBaseDetailScope;
	}

	protected static SerializeScope TrainingCourseTypeBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TrainingCourseType.ID_PROPERTY)
		.field(TrainingCourseType.CODE_PROPERTY)
		.field(TrainingCourseType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(TrainingCourseType.NAME_PROPERTY)
		.field(TrainingCourseType.DESCRIPTION_PROPERTY)
		.field(TrainingCourseType.COMPANY_TRAINING_LIST, getCompanyTrainingListItemScope())
		;
	/** 用于TrainingCourseType对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTrainingCourseTypeDetailScope() {
		return TrainingCourseTypeBaseDetailScope;
	}

	protected static SerializeScope PublicHolidayBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PublicHoliday.ID_PROPERTY)
		.field(PublicHoliday.CODE_PROPERTY)
		.field(PublicHoliday.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(PublicHoliday.NAME_PROPERTY)
		.field(PublicHoliday.DESCRIPTION_PROPERTY)
		;
	/** 用于PublicHoliday对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPublicHolidayDetailScope() {
		return PublicHolidayBaseDetailScope;
	}

	protected static SerializeScope TerminationBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Termination.ID_PROPERTY)
		.field(Termination.REASON_PROPERTY, getTerminationReasonSummaryScope())
		.field(Termination.TYPE_PROPERTY, getTerminationTypeSummaryScope())
		.field(Termination.COMMENT_PROPERTY)
		;
	/** 用于Termination对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTerminationDetailScope() {
		return TerminationBaseDetailScope;
	}

	protected static SerializeScope ViewBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(View.ID_PROPERTY)
		.field(View.WHO_PROPERTY)
		.field(View.ASSESSMENT_PROPERTY)
		.field(View.INTERVIEW_TIME_PROPERTY)
		;
	/** 用于View对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getViewDetailScope() {
		return ViewBaseDetailScope;
	}

	protected static SerializeScope EmployeeBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Employee.ID_PROPERTY)
		.field(Employee.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(Employee.TITLE_PROPERTY)
		.field(Employee.DEPARTMENT_PROPERTY, getLevelThreeDepartmentSummaryScope())
		.field(Employee.FAMILY_NAME_PROPERTY)
		.field(Employee.GIVEN_NAME_PROPERTY)
		.field(Employee.EMAIL_PROPERTY)
		.field(Employee.CITY_PROPERTY)
		.field(Employee.ADDRESS_PROPERTY)
		.field(Employee.CELL_PHONE_PROPERTY)
		.field(Employee.OCCUPATION_PROPERTY, getOccupationTypeSummaryScope())
		.field(Employee.RESPONSIBLE_FOR_PROPERTY, getResponsibilityTypeSummaryScope())
		.field(Employee.CURRENT_SALARY_GRADE_PROPERTY, getSalaryGradeSummaryScope())
		.field(Employee.SALARY_ACCOUNT_PROPERTY)
		.field(Employee.LAST_UPDATE_TIME_PROPERTY)
		.field(Employee.EMPLOYEE_COMPANY_TRAINING_LIST, getEmployeeCompanyTrainingListItemScope())
		.field(Employee.EMPLOYEE_SKILL_LIST, getEmployeeSkillListItemScope())
		.field(Employee.EMPLOYEE_PERFORMANCE_LIST, getEmployeePerformanceListItemScope())
		.field(Employee.EMPLOYEE_WORK_EXPERIENCE_LIST, getEmployeeWorkExperienceListItemScope())
		.field(Employee.EMPLOYEE_LEAVE_LIST, getEmployeeLeaveListItemScope())
		.field(Employee.EMPLOYEE_INTERVIEW_LIST, getEmployeeInterviewListItemScope())
		.field(Employee.EMPLOYEE_ATTENDANCE_LIST, getEmployeeAttendanceListItemScope())
		.field(Employee.EMPLOYEE_QUALIFIER_LIST, getEmployeeQualifierListItemScope())
		.field(Employee.EMPLOYEE_EDUCATION_LIST, getEmployeeEducationListItemScope())
		.field(Employee.EMPLOYEE_AWARD_LIST, getEmployeeAwardListItemScope())
		.field(Employee.EMPLOYEE_SALARY_SHEET_LIST, getEmployeeSalarySheetListItemScope())
		.field(Employee.PAYING_OFF_LIST, getPayingOffListItemScope())
		;
	/** 用于Employee对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeDetailScope() {
		return EmployeeBaseDetailScope;
	}

	protected static SerializeScope InstructorBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Instructor.ID_PROPERTY)
		.field(Instructor.TITLE_PROPERTY)
		.field(Instructor.FAMILY_NAME_PROPERTY)
		.field(Instructor.GIVEN_NAME_PROPERTY)
		.field(Instructor.CELL_PHONE_PROPERTY)
		.field(Instructor.EMAIL_PROPERTY)
		.field(Instructor.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(Instructor.INTRODUCTION_PROPERTY)
		.field(Instructor.LAST_UPDATE_TIME_PROPERTY)
		.field(Instructor.COMPANY_TRAINING_LIST, getCompanyTrainingListItemScope())
		;
	/** 用于Instructor对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getInstructorDetailScope() {
		return InstructorBaseDetailScope;
	}

	protected static SerializeScope CompanyTrainingBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(CompanyTraining.ID_PROPERTY)
		.field(CompanyTraining.TITLE_PROPERTY)
		.field(CompanyTraining.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
		.field(CompanyTraining.INSTRUCTOR_PROPERTY, getInstructorSummaryScope())
		.field(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, getTrainingCourseTypeSummaryScope())
		.field(CompanyTraining.TIME_START_PROPERTY)
		.field(CompanyTraining.DURATION_HOURS_PROPERTY)
		.field(CompanyTraining.LAST_UPDATE_TIME_PROPERTY)
		.field(CompanyTraining.EMPLOYEE_COMPANY_TRAINING_LIST, getEmployeeCompanyTrainingListItemScope())
		;
	/** 用于CompanyTraining对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCompanyTrainingDetailScope() {
		return CompanyTrainingBaseDetailScope;
	}

	protected static SerializeScope ScoringBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Scoring.ID_PROPERTY)
		.field(Scoring.SCORED_BY_PROPERTY)
		.field(Scoring.SCORE_PROPERTY)
		.field(Scoring.COMMENT_PROPERTY)
		.field(Scoring.EMPLOYEE_COMPANY_TRAINING_LIST, getEmployeeCompanyTrainingListItemScope())
		;
	/** 用于Scoring对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getScoringDetailScope() {
		return ScoringBaseDetailScope;
	}

	protected static SerializeScope EmployeeCompanyTrainingBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeCompanyTraining.ID_PROPERTY)
		.field(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeeCompanyTraining.TRAINING_PROPERTY, getCompanyTrainingSummaryScope())
		.field(EmployeeCompanyTraining.SCORING_PROPERTY, getScoringSummaryScope())
		;
	/** 用于EmployeeCompanyTraining对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeCompanyTrainingDetailScope() {
		return EmployeeCompanyTrainingBaseDetailScope;
	}

	protected static SerializeScope EmployeeSkillBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeSkill.ID_PROPERTY)
		.field(EmployeeSkill.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeeSkill.SKILL_TYPE_PROPERTY, getSkillTypeSummaryScope())
		.field(EmployeeSkill.DESCRIPTION_PROPERTY)
		;
	/** 用于EmployeeSkill对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeSkillDetailScope() {
		return EmployeeSkillBaseDetailScope;
	}

	protected static SerializeScope EmployeePerformanceBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeePerformance.ID_PROPERTY)
		.field(EmployeePerformance.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeePerformance.PERFORMANCE_COMMENT_PROPERTY)
		;
	/** 用于EmployeePerformance对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeePerformanceDetailScope() {
		return EmployeePerformanceBaseDetailScope;
	}

	protected static SerializeScope EmployeeWorkExperienceBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeWorkExperience.ID_PROPERTY)
		.field(EmployeeWorkExperience.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeeWorkExperience.START_PROPERTY)
		.field(EmployeeWorkExperience.END_PROPERTY)
		.field(EmployeeWorkExperience.COMPANY_PROPERTY)
		.field(EmployeeWorkExperience.DESCRIPTION_PROPERTY)
		;
	/** 用于EmployeeWorkExperience对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeWorkExperienceDetailScope() {
		return EmployeeWorkExperienceBaseDetailScope;
	}

	protected static SerializeScope EmployeeLeaveBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeLeave.ID_PROPERTY)
		.field(EmployeeLeave.WHO_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeeLeave.TYPE_PROPERTY, getLeaveTypeSummaryScope())
		.field(EmployeeLeave.LEAVE_DURATION_HOUR_PROPERTY)
		.field(EmployeeLeave.REMARK_PROPERTY)
		;
	/** 用于EmployeeLeave对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeLeaveDetailScope() {
		return EmployeeLeaveBaseDetailScope;
	}

	protected static SerializeScope EmployeeInterviewBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeInterview.ID_PROPERTY)
		.field(EmployeeInterview.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeeInterview.INTERVIEW_TYPE_PROPERTY, getInterviewTypeSummaryScope())
		.field(EmployeeInterview.REMARK_PROPERTY)
		;
	/** 用于EmployeeInterview对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeInterviewDetailScope() {
		return EmployeeInterviewBaseDetailScope;
	}

	protected static SerializeScope EmployeeAttendanceBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeAttendance.ID_PROPERTY)
		.field(EmployeeAttendance.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeeAttendance.ENTER_TIME_PROPERTY)
		.field(EmployeeAttendance.LEAVE_TIME_PROPERTY)
		.field(EmployeeAttendance.DURATION_HOURS_PROPERTY)
		.field(EmployeeAttendance.REMARK_PROPERTY)
		;
	/** 用于EmployeeAttendance对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeAttendanceDetailScope() {
		return EmployeeAttendanceBaseDetailScope;
	}

	protected static SerializeScope EmployeeQualifierBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeQualifier.ID_PROPERTY)
		.field(EmployeeQualifier.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeeQualifier.QUALIFIED_TIME_PROPERTY)
		.field(EmployeeQualifier.TYPE_PROPERTY)
		.field(EmployeeQualifier.LEVEL_PROPERTY)
		.field(EmployeeQualifier.REMARK_PROPERTY)
		;
	/** 用于EmployeeQualifier对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeQualifierDetailScope() {
		return EmployeeQualifierBaseDetailScope;
	}

	protected static SerializeScope EmployeeEducationBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeEducation.ID_PROPERTY)
		.field(EmployeeEducation.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeeEducation.COMPLETE_TIME_PROPERTY)
		.field(EmployeeEducation.TYPE_PROPERTY)
		.field(EmployeeEducation.REMARK_PROPERTY)
		;
	/** 用于EmployeeEducation对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeEducationDetailScope() {
		return EmployeeEducationBaseDetailScope;
	}

	protected static SerializeScope EmployeeAwardBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeAward.ID_PROPERTY)
		.field(EmployeeAward.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeeAward.COMPLETE_TIME_PROPERTY)
		.field(EmployeeAward.TYPE_PROPERTY)
		.field(EmployeeAward.REMARK_PROPERTY)
		;
	/** 用于EmployeeAward对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeAwardDetailScope() {
		return EmployeeAwardBaseDetailScope;
	}

	protected static SerializeScope EmployeeSalarySheetBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(EmployeeSalarySheet.ID_PROPERTY)
		.field(EmployeeSalarySheet.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
		.field(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY, getSalaryGradeSummaryScope())
		.field(EmployeeSalarySheet.BASE_SALARY_PROPERTY)
		.field(EmployeeSalarySheet.BONUS_PROPERTY)
		.field(EmployeeSalarySheet.REWARD_PROPERTY)
		.field(EmployeeSalarySheet.PERSONAL_TAX_PROPERTY)
		.field(EmployeeSalarySheet.SOCIAL_SECURITY_PROPERTY)
		.field(EmployeeSalarySheet.HOUSING_FOUND_PROPERTY)
		.field(EmployeeSalarySheet.JOB_INSURANCE_PROPERTY)
		.field(EmployeeSalarySheet.PAYING_OFF_PROPERTY, getPayingOffSummaryScope())
		;
	/** 用于EmployeeSalarySheet对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getEmployeeSalarySheetDetailScope() {
		return EmployeeSalarySheetBaseDetailScope;
	}

	protected static SerializeScope PayingOffBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PayingOff.ID_PROPERTY)
		.field(PayingOff.WHO_PROPERTY)
		.field(PayingOff.PAID_FOR_PROPERTY, getEmployeeSummaryScope())
		.field(PayingOff.PAID_TIME_PROPERTY)
		.field(PayingOff.AMOUNT_PROPERTY)
		.field(PayingOff.EMPLOYEE_SALARY_SHEET_LIST, getEmployeeSalarySheetListItemScope())
		;
	/** 用于PayingOff对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPayingOffDetailScope() {
		return PayingOffBaseDetailScope;
	}

	protected static SerializeScope MobileAppBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(MobileApp.ID_PROPERTY)
		.field(MobileApp.NAME_PROPERTY)
		.field(MobileApp.PAGE_LIST, getPageListItemScope())
		.field(MobileApp.PAGE_TYPE_LIST, getPageTypeListItemScope())
		;
	/** 用于MobileApp对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getMobileAppDetailScope() {
		return MobileAppBaseDetailScope;
	}

	protected static SerializeScope PageBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Page.ID_PROPERTY)
		.field(Page.PAGE_TITLE_PROPERTY)
		.field(Page.LINK_TO_URL_PROPERTY)
		.field(Page.PAGE_TYPE_PROPERTY, getPageTypeSummaryScope())
		.field(Page.DISPLAY_ORDER_PROPERTY)
		.field(Page.MOBILE_APP_PROPERTY, getMobileAppSummaryScope())
		.field(Page.SLIDE_LIST, getSlideListItemScope())
		.field(Page.UI_ACTION_LIST, getUiActionListItemScope())
		.field(Page.SECTION_LIST, getSectionListItemScope())
		;
	/** 用于Page对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPageDetailScope() {
		return PageBaseDetailScope;
	}

	protected static SerializeScope PageTypeBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PageType.ID_PROPERTY)
		.field(PageType.NAME_PROPERTY)
		.field(PageType.CODE_PROPERTY)
		.field(PageType.MOBILE_APP_PROPERTY, getMobileAppSummaryScope())
		.field(PageType.FOOTER_TAB_PROPERTY)
		.field(PageType.PAGE_LIST, getPageListItemScope())
		;
	/** 用于PageType对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPageTypeDetailScope() {
		return PageTypeBaseDetailScope;
	}

	protected static SerializeScope SlideBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Slide.ID_PROPERTY)
		.field(Slide.NAME_PROPERTY)
		.field(Slide.DISPLAY_ORDER_PROPERTY)
		.field(Slide.IMAGE_URL_PROPERTY)
		.field(Slide.VIDEO_URL_PROPERTY)
		.field(Slide.LINK_TO_URL_PROPERTY)
		.field(Slide.PAGE_PROPERTY, getPageSummaryScope())
		;
	/** 用于Slide对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSlideDetailScope() {
		return SlideBaseDetailScope;
	}

	protected static SerializeScope UiActionBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(UiAction.ID_PROPERTY)
		.field(UiAction.CODE_PROPERTY)
		.field(UiAction.ICON_PROPERTY)
		.field(UiAction.TITLE_PROPERTY)
		.field(UiAction.DISPLAY_ORDER_PROPERTY)
		.field(UiAction.BRIEF_PROPERTY)
		.field(UiAction.IMAGE_URL_PROPERTY)
		.field(UiAction.LINK_TO_URL_PROPERTY)
		.field(UiAction.EXTRA_DATA_PROPERTY)
		.field(UiAction.PAGE_PROPERTY, getPageSummaryScope())
		;
	/** 用于UiAction对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUiActionDetailScope() {
		return UiActionBaseDetailScope;
	}

	protected static SerializeScope SectionBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(Section.ID_PROPERTY)
		.field(Section.TITLE_PROPERTY)
		.field(Section.BRIEF_PROPERTY)
		.field(Section.ICON_PROPERTY)
		.field(Section.DISPLAY_ORDER_PROPERTY)
		.field(Section.VIEW_GROUP_PROPERTY)
		.field(Section.LINK_TO_URL_PROPERTY)
		.field(Section.PAGE_PROPERTY, getPageSummaryScope())
		;
	/** 用于Section对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSectionDetailScope() {
		return SectionBaseDetailScope;
	}

	protected static SerializeScope UserDomainBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		.field(UserDomain.USER_WHITE_LIST_LIST, getUserWhiteListListItemScope())
		.field(UserDomain.SEC_USER_LIST, getSecUserListItemScope())
		.field(UserDomain.PUBLIC_KEY_TYPE_LIST, getPublicKeyTypeListItemScope())
		;
	/** 用于UserDomain对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserDomainDetailScope() {
		return UserDomainBaseDetailScope;
	}

	protected static SerializeScope UserWhiteListBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		.field(UserWhiteList.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		;
	/** 用于UserWhiteList对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListDetailScope() {
		return UserWhiteListBaseDetailScope;
	}

	protected static SerializeScope SecUserBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(SecUser.ID_PROPERTY)
		.field(SecUser.LOGIN_PROPERTY)
		.field(SecUser.MOBILE_PROPERTY)
		.field(SecUser.EMAIL_PROPERTY)
		.field(SecUser.PWD_PROPERTY)
		.field(SecUser.WEIXIN_OPENID_PROPERTY)
		.field(SecUser.WEIXIN_APPID_PROPERTY)
		.field(SecUser.ACCESS_TOKEN_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
		.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
		.field(SecUser.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		.field(SecUser.USER_APP_LIST, getUserAppListItemScope())
		.field(SecUser.LOGIN_HISTORY_LIST, getLoginHistoryListItemScope())
		.field(SecUser.WECHAT_WORKAPP_IDENTIFY_LIST, getWechatWorkappIdentifyListItemScope())
		.field(SecUser.WECHAT_MINIAPP_IDENTIFY_LIST, getWechatMiniappIdentifyListItemScope())
		.field(SecUser.KEYPAIR_IDENTIFY_LIST, getKeypairIdentifyListItemScope())
		;
	/** 用于SecUser对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSecUserDetailScope() {
		return SecUserBaseDetailScope;
	}

	protected static SerializeScope UserAppBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		.field(UserApp.QUICK_LINK_LIST, getQuickLinkListItemScope())
		.field(UserApp.LIST_ACCESS_LIST, getListAccessListItemScope())
		;
	/** 用于UserApp对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserAppDetailScope() {
		return UserAppBaseDetailScope;
	}

	protected static SerializeScope QuickLinkBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		.field(QuickLink.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于QuickLink对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkDetailScope() {
		return QuickLinkBaseDetailScope;
	}

	protected static SerializeScope ListAccessBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		.field(ListAccess.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于ListAccess对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getListAccessDetailScope() {
		return ListAccessBaseDetailScope;
	}

	protected static SerializeScope LoginHistoryBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		.field(LoginHistory.SEC_USER_PROPERTY, getSecUserSummaryScope())
		;
	/** 用于LoginHistory对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLoginHistoryDetailScope() {
		return LoginHistoryBaseDetailScope;
	}

	protected static SerializeScope CandidateContainerBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		.field(CandidateContainer.CANDIDATE_ELEMENT_LIST, getCandidateElementListItemScope())
		;
	/** 用于CandidateContainer对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerDetailScope() {
		return CandidateContainerBaseDetailScope;
	}

	protected static SerializeScope CandidateElementBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		.field(CandidateElement.CONTAINER_PROPERTY, getCandidateContainerSummaryScope())
		;
	/** 用于CandidateElement对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementDetailScope() {
		return CandidateElementBaseDetailScope;
	}

	protected static SerializeScope WechatWorkappIdentifyBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(WechatWorkappIdentify.ID_PROPERTY)
		.field(WechatWorkappIdentify.CORP_ID_PROPERTY)
		.field(WechatWorkappIdentify.USER_ID_PROPERTY)
		.field(WechatWorkappIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(WechatWorkappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatWorkappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatWorkappIdentify对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getWechatWorkappIdentifyDetailScope() {
		return WechatWorkappIdentifyBaseDetailScope;
	}

	protected static SerializeScope WechatMiniappIdentifyBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(WechatMiniappIdentify.ID_PROPERTY)
		.field(WechatMiniappIdentify.OPEN_ID_PROPERTY)
		.field(WechatMiniappIdentify.APP_ID_PROPERTY)
		.field(WechatMiniappIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(WechatMiniappIdentify.CREATE_TIME_PROPERTY)
		.field(WechatMiniappIdentify.LAST_LOGIN_TIME_PROPERTY)
		;
	/** 用于WechatMiniappIdentify对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getWechatMiniappIdentifyDetailScope() {
		return WechatMiniappIdentifyBaseDetailScope;
	}

	protected static SerializeScope KeypairIdentifyBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(KeypairIdentify.ID_PROPERTY)
		.field(KeypairIdentify.PUBLIC_KEY_PROPERTY)
		.field(KeypairIdentify.KEY_TYPE_PROPERTY, getPublicKeyTypeSummaryScope())
		.field(KeypairIdentify.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(KeypairIdentify.CREATE_TIME_PROPERTY)
		;
	/** 用于KeypairIdentify对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getKeypairIdentifyDetailScope() {
		return KeypairIdentifyBaseDetailScope;
	}

	protected static SerializeScope PublicKeyTypeBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(PublicKeyType.ID_PROPERTY)
		.field(PublicKeyType.NAME_PROPERTY)
		.field(PublicKeyType.CODE_PROPERTY)
		.field(PublicKeyType.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		.field(PublicKeyType.KEYPAIR_IDENTIFY_LIST, getKeypairIdentifyListItemScope())
		;
	/** 用于PublicKeyType对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPublicKeyTypeDetailScope() {
		return PublicKeyTypeBaseDetailScope;
	}

	protected static SerializeScope TreeNodeBaseDetailScope = SerializeScope.INCLUDE()
		.field(RetailscmBaseConstants.X_LINK_TO_URL)
		.field(TreeNode.ID_PROPERTY)
		.field(TreeNode.NODE_ID_PROPERTY)
		.field(TreeNode.NODE_TYPE_PROPERTY)
		.field(TreeNode.LEFT_VALUE_PROPERTY)
		.field(TreeNode.RIGHT_VALUE_PROPERTY)
		;
	/** 用于TreeNode对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getTreeNodeDetailScope() {
		return TreeNodeBaseDetailScope;
	}

	

}
















