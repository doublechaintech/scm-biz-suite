package com.doublechaintech.retailscm;

import java.util.HashMap;
import java.util.Map;
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
import com.doublechaintech.retailscm.userallowlist.UserAllowList;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.quicklink.QuickLink;
import com.doublechaintech.retailscm.listaccess.ListAccess;
import com.doublechaintech.retailscm.loginhistory.LoginHistory;
import com.doublechaintech.retailscm.candidatecontainer.CandidateContainer;
import com.doublechaintech.retailscm.candidateelement.CandidateElement;
import com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentity;
import com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentity;
import com.doublechaintech.retailscm.keypairidentity.KeypairIdentity;
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;
import com.doublechaintech.retailscm.treenode.TreeNode;


public class BaseRetailscmListOfViewScope {

	/** RetailStoreCountryCenter的简单属性序列化列表 */
	protected SerializeScope getRetailStoreCountryCenterSummaryScope() {
		return SerializeScope.INCLUDE()
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
			.field(RetailStoreCountryCenter.VERSION_PROPERTY)
		;
	}

	/** Catalog的简单属性序列化列表 */
	protected SerializeScope getCatalogSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Catalog.ID_PROPERTY)
			.field(Catalog.NAME_PROPERTY)
			.field(Catalog.SUB_COUNT_PROPERTY)
			.field(Catalog.AMOUNT_PROPERTY)
			.field(Catalog.VERSION_PROPERTY)
		;
	}

	/** LevelOneCategory的简单属性序列化列表 */
	protected SerializeScope getLevelOneCategorySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(LevelOneCategory.ID_PROPERTY)
			.field(LevelOneCategory.NAME_PROPERTY)
			.field(LevelOneCategory.VERSION_PROPERTY)
		;
	}

	/** LevelTwoCategory的简单属性序列化列表 */
	protected SerializeScope getLevelTwoCategorySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(LevelTwoCategory.ID_PROPERTY)
			.field(LevelTwoCategory.NAME_PROPERTY)
			.field(LevelTwoCategory.VERSION_PROPERTY)
		;
	}

	/** LevelThreeCategory的简单属性序列化列表 */
	protected SerializeScope getLevelThreeCategorySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(LevelThreeCategory.ID_PROPERTY)
			.field(LevelThreeCategory.NAME_PROPERTY)
			.field(LevelThreeCategory.VERSION_PROPERTY)
		;
	}

	/** Product的简单属性序列化列表 */
	protected SerializeScope getProductSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Product.ID_PROPERTY)
			.field(Product.NAME_PROPERTY)
			.field(Product.ORIGIN_PROPERTY)
			.field(Product.REMARK_PROPERTY)
			.field(Product.BRAND_PROPERTY)
			.field(Product.PICTURE_PROPERTY)
			.field(Product.LAST_UPDATE_TIME_PROPERTY)
			.field(Product.VERSION_PROPERTY)
		;
	}

	/** Sku的简单属性序列化列表 */
	protected SerializeScope getSkuSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Sku.ID_PROPERTY)
			.field(Sku.NAME_PROPERTY)
			.field(Sku.SIZE_PROPERTY)
			.field(Sku.BARCODE_PROPERTY)
			.field(Sku.PACKAGE_TYPE_PROPERTY)
			.field(Sku.NET_CONTENT_PROPERTY)
			.field(Sku.PRICE_PROPERTY)
			.field(Sku.PICTURE_PROPERTY)
			.field(Sku.VERSION_PROPERTY)
		;
	}

	/** RetailStoreProvinceCenter的简单属性序列化列表 */
	protected SerializeScope getRetailStoreProvinceCenterSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreProvinceCenter.ID_PROPERTY)
			.field(RetailStoreProvinceCenter.NAME_PROPERTY)
			.field(RetailStoreProvinceCenter.FOUNDED_PROPERTY)
			.field(RetailStoreProvinceCenter.LAST_UPDATE_TIME_PROPERTY)
			.field(RetailStoreProvinceCenter.VERSION_PROPERTY)
		;
	}

	/** ProvinceCenterDepartment的简单属性序列化列表 */
	protected SerializeScope getProvinceCenterDepartmentSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ProvinceCenterDepartment.ID_PROPERTY)
			.field(ProvinceCenterDepartment.NAME_PROPERTY)
			.field(ProvinceCenterDepartment.FOUNDED_PROPERTY)
			.field(ProvinceCenterDepartment.MANAGER_PROPERTY)
			.field(ProvinceCenterDepartment.VERSION_PROPERTY)
		;
	}

	/** ProvinceCenterEmployee的简单属性序列化列表 */
	protected SerializeScope getProvinceCenterEmployeeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ProvinceCenterEmployee.ID_PROPERTY)
			.field(ProvinceCenterEmployee.NAME_PROPERTY)
			.field(ProvinceCenterEmployee.MOBILE_PROPERTY)
			.field(ProvinceCenterEmployee.EMAIL_PROPERTY)
			.field(ProvinceCenterEmployee.FOUNDED_PROPERTY)
			.field(ProvinceCenterEmployee.VERSION_PROPERTY)
		;
	}

	/** RetailStoreCityServiceCenter的简单属性序列化列表 */
	protected SerializeScope getRetailStoreCityServiceCenterSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreCityServiceCenter.ID_PROPERTY)
			.field(RetailStoreCityServiceCenter.NAME_PROPERTY)
			.field(RetailStoreCityServiceCenter.FOUNDED_PROPERTY)
			.field(RetailStoreCityServiceCenter.LAST_UPDATE_TIME_PROPERTY)
			.field(RetailStoreCityServiceCenter.VERSION_PROPERTY)
		;
	}

	/** CityPartner的简单属性序列化列表 */
	protected SerializeScope getCityPartnerSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(CityPartner.ID_PROPERTY)
			.field(CityPartner.NAME_PROPERTY)
			.field(CityPartner.MOBILE_PROPERTY)
			.field(CityPartner.DESCRIPTION_PROPERTY)
			.field(CityPartner.LAST_UPDATE_TIME_PROPERTY)
			.field(CityPartner.VERSION_PROPERTY)
		;
	}

	/** PotentialCustomer的简单属性序列化列表 */
	protected SerializeScope getPotentialCustomerSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(PotentialCustomer.ID_PROPERTY)
			.field(PotentialCustomer.NAME_PROPERTY)
			.field(PotentialCustomer.MOBILE_PROPERTY)
			.field(PotentialCustomer.DESCRIPTION_PROPERTY)
			.field(PotentialCustomer.LAST_UPDATE_TIME_PROPERTY)
			.field(PotentialCustomer.VERSION_PROPERTY)
		;
	}

	/** PotentialCustomerContactPerson的简单属性序列化列表 */
	protected SerializeScope getPotentialCustomerContactPersonSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(PotentialCustomerContactPerson.ID_PROPERTY)
			.field(PotentialCustomerContactPerson.NAME_PROPERTY)
			.field(PotentialCustomerContactPerson.MOBILE_PROPERTY)
			.field(PotentialCustomerContactPerson.DESCRIPTION_PROPERTY)
			.field(PotentialCustomerContactPerson.VERSION_PROPERTY)
		;
	}

	/** PotentialCustomerContact的简单属性序列化列表 */
	protected SerializeScope getPotentialCustomerContactSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(PotentialCustomerContact.ID_PROPERTY)
			.field(PotentialCustomerContact.NAME_PROPERTY)
			.field(PotentialCustomerContact.CONTACT_DATE_PROPERTY)
			.field(PotentialCustomerContact.CONTACT_METHOD_PROPERTY)
			.field(PotentialCustomerContact.DESCRIPTION_PROPERTY)
			.field(PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY)
			.field(PotentialCustomerContact.VERSION_PROPERTY)
		;
	}

	/** CityEvent的简单属性序列化列表 */
	protected SerializeScope getCityEventSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(CityEvent.ID_PROPERTY)
			.field(CityEvent.NAME_PROPERTY)
			.field(CityEvent.MOBILE_PROPERTY)
			.field(CityEvent.DESCRIPTION_PROPERTY)
			.field(CityEvent.LAST_UPDATE_TIME_PROPERTY)
			.field(CityEvent.VERSION_PROPERTY)
		;
	}

	/** EventAttendance的简单属性序列化列表 */
	protected SerializeScope getEventAttendanceSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EventAttendance.ID_PROPERTY)
			.field(EventAttendance.NAME_PROPERTY)
			.field(EventAttendance.DESCRIPTION_PROPERTY)
			.field(EventAttendance.VERSION_PROPERTY)
		;
	}

	/** RetailStore的简单属性序列化列表 */
	protected SerializeScope getRetailStoreSummaryScope() {
		return SerializeScope.INCLUDE()
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
			.field(RetailStore.VERSION_PROPERTY)
		;
	}

	/** RetailStoreCreation的简单属性序列化列表 */
	protected SerializeScope getRetailStoreCreationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreCreation.ID_PROPERTY)
			.field(RetailStoreCreation.COMMENT_PROPERTY)
			.field(RetailStoreCreation.VERSION_PROPERTY)
		;
	}

	/** RetailStoreInvestmentInvitation的简单属性序列化列表 */
	protected SerializeScope getRetailStoreInvestmentInvitationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreInvestmentInvitation.ID_PROPERTY)
			.field(RetailStoreInvestmentInvitation.COMMENT_PROPERTY)
			.field(RetailStoreInvestmentInvitation.VERSION_PROPERTY)
		;
	}

	/** RetailStoreFranchising的简单属性序列化列表 */
	protected SerializeScope getRetailStoreFranchisingSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreFranchising.ID_PROPERTY)
			.field(RetailStoreFranchising.COMMENT_PROPERTY)
			.field(RetailStoreFranchising.VERSION_PROPERTY)
		;
	}

	/** RetailStoreDecoration的简单属性序列化列表 */
	protected SerializeScope getRetailStoreDecorationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreDecoration.ID_PROPERTY)
			.field(RetailStoreDecoration.COMMENT_PROPERTY)
			.field(RetailStoreDecoration.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOpening的简单属性序列化列表 */
	protected SerializeScope getRetailStoreOpeningSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOpening.ID_PROPERTY)
			.field(RetailStoreOpening.COMMENT_PROPERTY)
			.field(RetailStoreOpening.VERSION_PROPERTY)
		;
	}

	/** RetailStoreClosing的简单属性序列化列表 */
	protected SerializeScope getRetailStoreClosingSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreClosing.ID_PROPERTY)
			.field(RetailStoreClosing.COMMENT_PROPERTY)
			.field(RetailStoreClosing.VERSION_PROPERTY)
		;
	}

	/** RetailStoreMember的简单属性序列化列表 */
	protected SerializeScope getRetailStoreMemberSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreMember.ID_PROPERTY)
			.field(RetailStoreMember.NAME_PROPERTY)
			.field(RetailStoreMember.MOBILE_PHONE_PROPERTY)
			.field(RetailStoreMember.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrder的简单属性序列化列表 */
	protected SerializeScope getConsumerOrderSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrder.ID_PROPERTY)
			.field(ConsumerOrder.TITLE_PROPERTY)
			.field(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY)
			.field(ConsumerOrder.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderLineItem的简单属性序列化列表 */
	protected SerializeScope getConsumerOrderLineItemSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderLineItem.ID_PROPERTY)
			.field(ConsumerOrderLineItem.SKU_ID_PROPERTY)
			.field(ConsumerOrderLineItem.SKU_NAME_PROPERTY)
			.field(ConsumerOrderLineItem.PRICE_PROPERTY)
			.field(ConsumerOrderLineItem.QUANTITY_PROPERTY)
			.field(ConsumerOrderLineItem.AMOUNT_PROPERTY)
			.field(ConsumerOrderLineItem.LAST_UPDATE_TIME_PROPERTY)
			.field(ConsumerOrderLineItem.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderShippingGroup的简单属性序列化列表 */
	protected SerializeScope getConsumerOrderShippingGroupSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderShippingGroup.ID_PROPERTY)
			.field(ConsumerOrderShippingGroup.NAME_PROPERTY)
			.field(ConsumerOrderShippingGroup.AMOUNT_PROPERTY)
			.field(ConsumerOrderShippingGroup.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderPaymentGroup的简单属性序列化列表 */
	protected SerializeScope getConsumerOrderPaymentGroupSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderPaymentGroup.ID_PROPERTY)
			.field(ConsumerOrderPaymentGroup.NAME_PROPERTY)
			.field(ConsumerOrderPaymentGroup.CARD_NUMBER_PROPERTY)
			.field(ConsumerOrderPaymentGroup.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderPriceAdjustment的简单属性序列化列表 */
	protected SerializeScope getConsumerOrderPriceAdjustmentSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderPriceAdjustment.ID_PROPERTY)
			.field(ConsumerOrderPriceAdjustment.NAME_PROPERTY)
			.field(ConsumerOrderPriceAdjustment.AMOUNT_PROPERTY)
			.field(ConsumerOrderPriceAdjustment.PROVIDER_PROPERTY)
			.field(ConsumerOrderPriceAdjustment.VERSION_PROPERTY)
		;
	}

	/** RetailStoreMemberCoupon的简单属性序列化列表 */
	protected SerializeScope getRetailStoreMemberCouponSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreMemberCoupon.ID_PROPERTY)
			.field(RetailStoreMemberCoupon.NAME_PROPERTY)
			.field(RetailStoreMemberCoupon.NUMBER_PROPERTY)
			.field(RetailStoreMemberCoupon.LAST_UPDATE_TIME_PROPERTY)
			.field(RetailStoreMemberCoupon.VERSION_PROPERTY)
		;
	}

	/** MemberWishlist的简单属性序列化列表 */
	protected SerializeScope getMemberWishlistSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(MemberWishlist.ID_PROPERTY)
			.field(MemberWishlist.NAME_PROPERTY)
			.field(MemberWishlist.VERSION_PROPERTY)
		;
	}

	/** MemberRewardPoint的简单属性序列化列表 */
	protected SerializeScope getMemberRewardPointSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(MemberRewardPoint.ID_PROPERTY)
			.field(MemberRewardPoint.NAME_PROPERTY)
			.field(MemberRewardPoint.POINT_PROPERTY)
			.field(MemberRewardPoint.VERSION_PROPERTY)
		;
	}

	/** MemberRewardPointRedemption的简单属性序列化列表 */
	protected SerializeScope getMemberRewardPointRedemptionSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(MemberRewardPointRedemption.ID_PROPERTY)
			.field(MemberRewardPointRedemption.NAME_PROPERTY)
			.field(MemberRewardPointRedemption.POINT_PROPERTY)
			.field(MemberRewardPointRedemption.VERSION_PROPERTY)
		;
	}

	/** MemberWishlistProduct的简单属性序列化列表 */
	protected SerializeScope getMemberWishlistProductSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(MemberWishlistProduct.ID_PROPERTY)
			.field(MemberWishlistProduct.NAME_PROPERTY)
			.field(MemberWishlistProduct.VERSION_PROPERTY)
		;
	}

	/** RetailStoreMemberAddress的简单属性序列化列表 */
	protected SerializeScope getRetailStoreMemberAddressSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreMemberAddress.ID_PROPERTY)
			.field(RetailStoreMemberAddress.NAME_PROPERTY)
			.field(RetailStoreMemberAddress.MOBILE_PHONE_PROPERTY)
			.field(RetailStoreMemberAddress.ADDRESS_PROPERTY)
			.field(RetailStoreMemberAddress.VERSION_PROPERTY)
		;
	}

	/** RetailStoreMemberGiftCard的简单属性序列化列表 */
	protected SerializeScope getRetailStoreMemberGiftCardSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreMemberGiftCard.ID_PROPERTY)
			.field(RetailStoreMemberGiftCard.NAME_PROPERTY)
			.field(RetailStoreMemberGiftCard.NUMBER_PROPERTY)
			.field(RetailStoreMemberGiftCard.REMAIN_PROPERTY)
			.field(RetailStoreMemberGiftCard.VERSION_PROPERTY)
		;
	}

	/** RetailStoreMemberGiftCardConsumeRecord的简单属性序列化列表 */
	protected SerializeScope getRetailStoreMemberGiftCardConsumeRecordSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY)
			.field(RetailStoreMemberGiftCardConsumeRecord.OCCURE_TIME_PROPERTY)
			.field(RetailStoreMemberGiftCardConsumeRecord.NUMBER_PROPERTY)
			.field(RetailStoreMemberGiftCardConsumeRecord.AMOUNT_PROPERTY)
			.field(RetailStoreMemberGiftCardConsumeRecord.VERSION_PROPERTY)
		;
	}

	/** GoodsSupplier的简单属性序列化列表 */
	protected SerializeScope getGoodsSupplierSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(GoodsSupplier.ID_PROPERTY)
			.field(GoodsSupplier.NAME_PROPERTY)
			.field(GoodsSupplier.SUPPLY_PRODUCT_PROPERTY)
			.field(GoodsSupplier.CONTACT_NUMBER_PROPERTY)
			.field(GoodsSupplier.DESCRIPTION_PROPERTY)
			.field(GoodsSupplier.LAST_UPDATE_TIME_PROPERTY)
			.field(GoodsSupplier.VERSION_PROPERTY)
		;
	}

	/** SupplierProduct的简单属性序列化列表 */
	protected SerializeScope getSupplierProductSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(SupplierProduct.ID_PROPERTY)
			.field(SupplierProduct.PRODUCT_NAME_PROPERTY)
			.field(SupplierProduct.PRODUCT_DESCRIPTION_PROPERTY)
			.field(SupplierProduct.PRODUCT_UNIT_PROPERTY)
			.field(SupplierProduct.VERSION_PROPERTY)
		;
	}

	/** ProductSupplyDuration的简单属性序列化列表 */
	protected SerializeScope getProductSupplyDurationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ProductSupplyDuration.ID_PROPERTY)
			.field(ProductSupplyDuration.QUANTITY_PROPERTY)
			.field(ProductSupplyDuration.DURATION_PROPERTY)
			.field(ProductSupplyDuration.PRICE_PROPERTY)
			.field(ProductSupplyDuration.VERSION_PROPERTY)
		;
	}

	/** SupplyOrder的简单属性序列化列表 */
	protected SerializeScope getSupplyOrderSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrder.ID_PROPERTY)
			.field(SupplyOrder.TITLE_PROPERTY)
			.field(SupplyOrder.TOTAL_AMOUNT_PROPERTY)
			.field(SupplyOrder.LAST_UPDATE_TIME_PROPERTY)
			.field(SupplyOrder.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderLineItem的简单属性序列化列表 */
	protected SerializeScope getSupplyOrderLineItemSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderLineItem.ID_PROPERTY)
			.field(SupplyOrderLineItem.SKU_ID_PROPERTY)
			.field(SupplyOrderLineItem.SKU_NAME_PROPERTY)
			.field(SupplyOrderLineItem.AMOUNT_PROPERTY)
			.field(SupplyOrderLineItem.QUANTITY_PROPERTY)
			.field(SupplyOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY)
			.field(SupplyOrderLineItem.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderShippingGroup的简单属性序列化列表 */
	protected SerializeScope getSupplyOrderShippingGroupSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderShippingGroup.ID_PROPERTY)
			.field(SupplyOrderShippingGroup.NAME_PROPERTY)
			.field(SupplyOrderShippingGroup.AMOUNT_PROPERTY)
			.field(SupplyOrderShippingGroup.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderPaymentGroup的简单属性序列化列表 */
	protected SerializeScope getSupplyOrderPaymentGroupSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderPaymentGroup.ID_PROPERTY)
			.field(SupplyOrderPaymentGroup.NAME_PROPERTY)
			.field(SupplyOrderPaymentGroup.CARD_NUMBER_PROPERTY)
			.field(SupplyOrderPaymentGroup.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrder的简单属性序列化列表 */
	protected SerializeScope getRetailStoreOrderSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrder.ID_PROPERTY)
			.field(RetailStoreOrder.TITLE_PROPERTY)
			.field(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY)
			.field(RetailStoreOrder.LAST_UPDATE_TIME_PROPERTY)
			.field(RetailStoreOrder.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderLineItem的简单属性序列化列表 */
	protected SerializeScope getRetailStoreOrderLineItemSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderLineItem.ID_PROPERTY)
			.field(RetailStoreOrderLineItem.SKU_ID_PROPERTY)
			.field(RetailStoreOrderLineItem.SKU_NAME_PROPERTY)
			.field(RetailStoreOrderLineItem.AMOUNT_PROPERTY)
			.field(RetailStoreOrderLineItem.QUANTITY_PROPERTY)
			.field(RetailStoreOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY)
			.field(RetailStoreOrderLineItem.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderShippingGroup的简单属性序列化列表 */
	protected SerializeScope getRetailStoreOrderShippingGroupSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderShippingGroup.ID_PROPERTY)
			.field(RetailStoreOrderShippingGroup.NAME_PROPERTY)
			.field(RetailStoreOrderShippingGroup.AMOUNT_PROPERTY)
			.field(RetailStoreOrderShippingGroup.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderPaymentGroup的简单属性序列化列表 */
	protected SerializeScope getRetailStoreOrderPaymentGroupSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderPaymentGroup.ID_PROPERTY)
			.field(RetailStoreOrderPaymentGroup.NAME_PROPERTY)
			.field(RetailStoreOrderPaymentGroup.CARD_NUMBER_PROPERTY)
			.field(RetailStoreOrderPaymentGroup.VERSION_PROPERTY)
		;
	}

	/** Warehouse的简单属性序列化列表 */
	protected SerializeScope getWarehouseSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Warehouse.ID_PROPERTY)
			.field(Warehouse.LOCATION_PROPERTY)
			.field(Warehouse.CONTACT_NUMBER_PROPERTY)
			.field(Warehouse.TOTAL_AREA_PROPERTY)
			.field(Warehouse.LATITUDE_PROPERTY)
			.field(Warehouse.LONGITUDE_PROPERTY)
			.field(Warehouse.LAST_UPDATE_TIME_PROPERTY)
			.field(Warehouse.VERSION_PROPERTY)
		;
	}

	/** StorageSpace的简单属性序列化列表 */
	protected SerializeScope getStorageSpaceSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(StorageSpace.ID_PROPERTY)
			.field(StorageSpace.LOCATION_PROPERTY)
			.field(StorageSpace.CONTACT_NUMBER_PROPERTY)
			.field(StorageSpace.TOTAL_AREA_PROPERTY)
			.field(StorageSpace.LATITUDE_PROPERTY)
			.field(StorageSpace.LONGITUDE_PROPERTY)
			.field(StorageSpace.LAST_UPDATE_TIME_PROPERTY)
			.field(StorageSpace.VERSION_PROPERTY)
		;
	}

	/** SmartPallet的简单属性序列化列表 */
	protected SerializeScope getSmartPalletSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(SmartPallet.ID_PROPERTY)
			.field(SmartPallet.LOCATION_PROPERTY)
			.field(SmartPallet.CONTACT_NUMBER_PROPERTY)
			.field(SmartPallet.TOTAL_AREA_PROPERTY)
			.field(SmartPallet.LATITUDE_PROPERTY)
			.field(SmartPallet.LONGITUDE_PROPERTY)
			.field(SmartPallet.LAST_UPDATE_TIME_PROPERTY)
			.field(SmartPallet.VERSION_PROPERTY)
		;
	}

	/** GoodsShelf的简单属性序列化列表 */
	protected SerializeScope getGoodsShelfSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(GoodsShelf.ID_PROPERTY)
			.field(GoodsShelf.LOCATION_PROPERTY)
			.field(GoodsShelf.LAST_UPDATE_TIME_PROPERTY)
			.field(GoodsShelf.VERSION_PROPERTY)
		;
	}

	/** GoodsShelfStockCount的简单属性序列化列表 */
	protected SerializeScope getGoodsShelfStockCountSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(GoodsShelfStockCount.ID_PROPERTY)
			.field(GoodsShelfStockCount.TITLE_PROPERTY)
			.field(GoodsShelfStockCount.COUNT_TIME_PROPERTY)
			.field(GoodsShelfStockCount.SUMMARY_PROPERTY)
			.field(GoodsShelfStockCount.VERSION_PROPERTY)
		;
	}

	/** StockCountIssueTrack的简单属性序列化列表 */
	protected SerializeScope getStockCountIssueTrackSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(StockCountIssueTrack.ID_PROPERTY)
			.field(StockCountIssueTrack.TITLE_PROPERTY)
			.field(StockCountIssueTrack.COUNT_TIME_PROPERTY)
			.field(StockCountIssueTrack.SUMMARY_PROPERTY)
			.field(StockCountIssueTrack.VERSION_PROPERTY)
		;
	}

	/** GoodsAllocation的简单属性序列化列表 */
	protected SerializeScope getGoodsAllocationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(GoodsAllocation.ID_PROPERTY)
			.field(GoodsAllocation.LOCATION_PROPERTY)
			.field(GoodsAllocation.LATITUDE_PROPERTY)
			.field(GoodsAllocation.LONGITUDE_PROPERTY)
			.field(GoodsAllocation.VERSION_PROPERTY)
		;
	}

	/** Goods的简单属性序列化列表 */
	protected SerializeScope getGoodsSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Goods.ID_PROPERTY)
			.field(Goods.NAME_PROPERTY)
			.field(Goods.RFID_PROPERTY)
			.field(Goods.UOM_PROPERTY)
			.field(Goods.MAX_PACKAGE_PROPERTY)
			.field(Goods.EXPIRE_TIME_PROPERTY)
			.field(Goods.VERSION_PROPERTY)
		;
	}

	/** GoodsMovement的简单属性序列化列表 */
	protected SerializeScope getGoodsMovementSummaryScope() {
		return SerializeScope.INCLUDE()
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
			.field(GoodsMovement.VERSION_PROPERTY)
		;
	}

	/** SupplierSpace的简单属性序列化列表 */
	protected SerializeScope getSupplierSpaceSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(SupplierSpace.ID_PROPERTY)
			.field(SupplierSpace.LOCATION_PROPERTY)
			.field(SupplierSpace.CONTACT_NUMBER_PROPERTY)
			.field(SupplierSpace.TOTAL_AREA_PROPERTY)
			.field(SupplierSpace.LATITUDE_PROPERTY)
			.field(SupplierSpace.LONGITUDE_PROPERTY)
			.field(SupplierSpace.LAST_UPDATE_TIME_PROPERTY)
			.field(SupplierSpace.VERSION_PROPERTY)
		;
	}

	/** ReceivingSpace的简单属性序列化列表 */
	protected SerializeScope getReceivingSpaceSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ReceivingSpace.ID_PROPERTY)
			.field(ReceivingSpace.LOCATION_PROPERTY)
			.field(ReceivingSpace.CONTACT_NUMBER_PROPERTY)
			.field(ReceivingSpace.DESCRIPTION_PROPERTY)
			.field(ReceivingSpace.TOTAL_AREA_PROPERTY)
			.field(ReceivingSpace.LATITUDE_PROPERTY)
			.field(ReceivingSpace.LONGITUDE_PROPERTY)
			.field(ReceivingSpace.LAST_UPDATE_TIME_PROPERTY)
			.field(ReceivingSpace.VERSION_PROPERTY)
		;
	}

	/** ShippingSpace的简单属性序列化列表 */
	protected SerializeScope getShippingSpaceSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ShippingSpace.ID_PROPERTY)
			.field(ShippingSpace.LOCATION_PROPERTY)
			.field(ShippingSpace.CONTACT_NUMBER_PROPERTY)
			.field(ShippingSpace.TOTAL_AREA_PROPERTY)
			.field(ShippingSpace.LATITUDE_PROPERTY)
			.field(ShippingSpace.LONGITUDE_PROPERTY)
			.field(ShippingSpace.DESCRIPTION_PROPERTY)
			.field(ShippingSpace.LAST_UPDATE_TIME_PROPERTY)
			.field(ShippingSpace.VERSION_PROPERTY)
		;
	}

	/** DamageSpace的简单属性序列化列表 */
	protected SerializeScope getDamageSpaceSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(DamageSpace.ID_PROPERTY)
			.field(DamageSpace.LOCATION_PROPERTY)
			.field(DamageSpace.CONTACT_NUMBER_PROPERTY)
			.field(DamageSpace.TOTAL_AREA_PROPERTY)
			.field(DamageSpace.LATITUDE_PROPERTY)
			.field(DamageSpace.LONGITUDE_PROPERTY)
			.field(DamageSpace.LAST_UPDATE_TIME_PROPERTY)
			.field(DamageSpace.VERSION_PROPERTY)
		;
	}

	/** WarehouseAsset的简单属性序列化列表 */
	protected SerializeScope getWarehouseAssetSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(WarehouseAsset.ID_PROPERTY)
			.field(WarehouseAsset.NAME_PROPERTY)
			.field(WarehouseAsset.POSITION_PROPERTY)
			.field(WarehouseAsset.LAST_UPDATE_TIME_PROPERTY)
			.field(WarehouseAsset.VERSION_PROPERTY)
		;
	}

	/** TransportFleet的简单属性序列化列表 */
	protected SerializeScope getTransportFleetSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(TransportFleet.ID_PROPERTY)
			.field(TransportFleet.NAME_PROPERTY)
			.field(TransportFleet.CONTACT_NUMBER_PROPERTY)
			.field(TransportFleet.LAST_UPDATE_TIME_PROPERTY)
			.field(TransportFleet.VERSION_PROPERTY)
		;
	}

	/** TransportTruck的简单属性序列化列表 */
	protected SerializeScope getTransportTruckSummaryScope() {
		return SerializeScope.INCLUDE()
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
			.field(TransportTruck.VERSION_PROPERTY)
		;
	}

	/** TruckDriver的简单属性序列化列表 */
	protected SerializeScope getTruckDriverSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(TruckDriver.ID_PROPERTY)
			.field(TruckDriver.NAME_PROPERTY)
			.field(TruckDriver.DRIVER_LICENSE_NUMBER_PROPERTY)
			.field(TruckDriver.CONTACT_NUMBER_PROPERTY)
			.field(TruckDriver.VERSION_PROPERTY)
		;
	}

	/** TransportTask的简单属性序列化列表 */
	protected SerializeScope getTransportTaskSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(TransportTask.ID_PROPERTY)
			.field(TransportTask.NAME_PROPERTY)
			.field(TransportTask.START_PROPERTY)
			.field(TransportTask.BEGIN_TIME_PROPERTY)
			.field(TransportTask.LATITUDE_PROPERTY)
			.field(TransportTask.LONGITUDE_PROPERTY)
			.field(TransportTask.VERSION_PROPERTY)
		;
	}

	/** TransportTaskTrack的简单属性序列化列表 */
	protected SerializeScope getTransportTaskTrackSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(TransportTaskTrack.ID_PROPERTY)
			.field(TransportTaskTrack.TRACK_TIME_PROPERTY)
			.field(TransportTaskTrack.LATITUDE_PROPERTY)
			.field(TransportTaskTrack.LONGITUDE_PROPERTY)
			.field(TransportTaskTrack.VERSION_PROPERTY)
		;
	}

	/** AccountSet的简单属性序列化列表 */
	protected SerializeScope getAccountSetSummaryScope() {
		return SerializeScope.INCLUDE()
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
			.field(AccountSet.VERSION_PROPERTY)
		;
	}

	/** AccountingSubject的简单属性序列化列表 */
	protected SerializeScope getAccountingSubjectSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(AccountingSubject.ID_PROPERTY)
			.field(AccountingSubject.ACCOUNTING_SUBJECT_CODE_PROPERTY)
			.field(AccountingSubject.ACCOUNTING_SUBJECT_NAME_PROPERTY)
			.field(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY)
			.field(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY)
			.field(AccountingSubject.VERSION_PROPERTY)
		;
	}

	/** AccountingPeriod的简单属性序列化列表 */
	protected SerializeScope getAccountingPeriodSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(AccountingPeriod.ID_PROPERTY)
			.field(AccountingPeriod.NAME_PROPERTY)
			.field(AccountingPeriod.START_DATE_PROPERTY)
			.field(AccountingPeriod.END_DATE_PROPERTY)
			.field(AccountingPeriod.VERSION_PROPERTY)
		;
	}

	/** AccountingDocumentType的简单属性序列化列表 */
	protected SerializeScope getAccountingDocumentTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(AccountingDocumentType.ID_PROPERTY)
			.field(AccountingDocumentType.NAME_PROPERTY)
			.field(AccountingDocumentType.DESCRIPTION_PROPERTY)
			.field(AccountingDocumentType.VERSION_PROPERTY)
		;
	}

	/** AccountingDocument的简单属性序列化列表 */
	protected SerializeScope getAccountingDocumentSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(AccountingDocument.ID_PROPERTY)
			.field(AccountingDocument.NAME_PROPERTY)
			.field(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY)
			.field(AccountingDocument.VERSION_PROPERTY)
		;
	}

	/** OriginalVoucher的简单属性序列化列表 */
	protected SerializeScope getOriginalVoucherSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(OriginalVoucher.ID_PROPERTY)
			.field(OriginalVoucher.TITLE_PROPERTY)
			.field(OriginalVoucher.MADE_BY_PROPERTY)
			.field(OriginalVoucher.RECEIVED_BY_PROPERTY)
			.field(OriginalVoucher.VOUCHER_TYPE_PROPERTY)
			.field(OriginalVoucher.VOUCHER_IMAGE_PROPERTY)
			.field(OriginalVoucher.VERSION_PROPERTY)
		;
	}

	/** AccountingDocumentLine的简单属性序列化列表 */
	protected SerializeScope getAccountingDocumentLineSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(AccountingDocumentLine.ID_PROPERTY)
			.field(AccountingDocumentLine.NAME_PROPERTY)
			.field(AccountingDocumentLine.CODE_PROPERTY)
			.field(AccountingDocumentLine.DIRECT_PROPERTY)
			.field(AccountingDocumentLine.AMOUNT_PROPERTY)
			.field(AccountingDocumentLine.VERSION_PROPERTY)
		;
	}

	/** LevelOneDepartment的简单属性序列化列表 */
	protected SerializeScope getLevelOneDepartmentSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(LevelOneDepartment.ID_PROPERTY)
			.field(LevelOneDepartment.NAME_PROPERTY)
			.field(LevelOneDepartment.DESCRIPTION_PROPERTY)
			.field(LevelOneDepartment.MANAGER_PROPERTY)
			.field(LevelOneDepartment.FOUNDED_PROPERTY)
			.field(LevelOneDepartment.VERSION_PROPERTY)
		;
	}

	/** LevelTwoDepartment的简单属性序列化列表 */
	protected SerializeScope getLevelTwoDepartmentSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(LevelTwoDepartment.ID_PROPERTY)
			.field(LevelTwoDepartment.NAME_PROPERTY)
			.field(LevelTwoDepartment.DESCRIPTION_PROPERTY)
			.field(LevelTwoDepartment.FOUNDED_PROPERTY)
			.field(LevelTwoDepartment.VERSION_PROPERTY)
		;
	}

	/** LevelThreeDepartment的简单属性序列化列表 */
	protected SerializeScope getLevelThreeDepartmentSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(LevelThreeDepartment.ID_PROPERTY)
			.field(LevelThreeDepartment.NAME_PROPERTY)
			.field(LevelThreeDepartment.DESCRIPTION_PROPERTY)
			.field(LevelThreeDepartment.FOUNDED_PROPERTY)
			.field(LevelThreeDepartment.VERSION_PROPERTY)
		;
	}

	/** SkillType的简单属性序列化列表 */
	protected SerializeScope getSkillTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(SkillType.ID_PROPERTY)
			.field(SkillType.CODE_PROPERTY)
			.field(SkillType.DESCRIPTION_PROPERTY)
			.field(SkillType.VERSION_PROPERTY)
		;
	}

	/** ResponsibilityType的简单属性序列化列表 */
	protected SerializeScope getResponsibilityTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ResponsibilityType.ID_PROPERTY)
			.field(ResponsibilityType.CODE_PROPERTY)
			.field(ResponsibilityType.BASE_DESCRIPTION_PROPERTY)
			.field(ResponsibilityType.DETAIL_DESCRIPTION_PROPERTY)
			.field(ResponsibilityType.VERSION_PROPERTY)
		;
	}

	/** TerminationReason的简单属性序列化列表 */
	protected SerializeScope getTerminationReasonSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(TerminationReason.ID_PROPERTY)
			.field(TerminationReason.CODE_PROPERTY)
			.field(TerminationReason.DESCRIPTION_PROPERTY)
			.field(TerminationReason.VERSION_PROPERTY)
		;
	}

	/** TerminationType的简单属性序列化列表 */
	protected SerializeScope getTerminationTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(TerminationType.ID_PROPERTY)
			.field(TerminationType.CODE_PROPERTY)
			.field(TerminationType.BASE_DESCRIPTION_PROPERTY)
			.field(TerminationType.DETAIL_DESCRIPTION_PROPERTY)
			.field(TerminationType.VERSION_PROPERTY)
		;
	}

	/** OccupationType的简单属性序列化列表 */
	protected SerializeScope getOccupationTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(OccupationType.ID_PROPERTY)
			.field(OccupationType.CODE_PROPERTY)
			.field(OccupationType.DESCRIPTION_PROPERTY)
			.field(OccupationType.DETAIL_DESCRIPTION_PROPERTY)
			.field(OccupationType.VERSION_PROPERTY)
		;
	}

	/** LeaveType的简单属性序列化列表 */
	protected SerializeScope getLeaveTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(LeaveType.ID_PROPERTY)
			.field(LeaveType.CODE_PROPERTY)
			.field(LeaveType.DESCRIPTION_PROPERTY)
			.field(LeaveType.DETAIL_DESCRIPTION_PROPERTY)
			.field(LeaveType.VERSION_PROPERTY)
		;
	}

	/** SalaryGrade的简单属性序列化列表 */
	protected SerializeScope getSalaryGradeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(SalaryGrade.ID_PROPERTY)
			.field(SalaryGrade.CODE_PROPERTY)
			.field(SalaryGrade.NAME_PROPERTY)
			.field(SalaryGrade.DETAIL_DESCRIPTION_PROPERTY)
			.field(SalaryGrade.VERSION_PROPERTY)
		;
	}

	/** InterviewType的简单属性序列化列表 */
	protected SerializeScope getInterviewTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(InterviewType.ID_PROPERTY)
			.field(InterviewType.CODE_PROPERTY)
			.field(InterviewType.DESCRIPTION_PROPERTY)
			.field(InterviewType.DETAIL_DESCRIPTION_PROPERTY)
			.field(InterviewType.VERSION_PROPERTY)
		;
	}

	/** TrainingCourseType的简单属性序列化列表 */
	protected SerializeScope getTrainingCourseTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(TrainingCourseType.ID_PROPERTY)
			.field(TrainingCourseType.CODE_PROPERTY)
			.field(TrainingCourseType.NAME_PROPERTY)
			.field(TrainingCourseType.DESCRIPTION_PROPERTY)
			.field(TrainingCourseType.VERSION_PROPERTY)
		;
	}

	/** PublicHoliday的简单属性序列化列表 */
	protected SerializeScope getPublicHolidaySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(PublicHoliday.ID_PROPERTY)
			.field(PublicHoliday.CODE_PROPERTY)
			.field(PublicHoliday.NAME_PROPERTY)
			.field(PublicHoliday.DESCRIPTION_PROPERTY)
			.field(PublicHoliday.VERSION_PROPERTY)
		;
	}

	/** Termination的简单属性序列化列表 */
	protected SerializeScope getTerminationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Termination.ID_PROPERTY)
			.field(Termination.COMMENT_PROPERTY)
			.field(Termination.VERSION_PROPERTY)
		;
	}

	/** View的简单属性序列化列表 */
	protected SerializeScope getViewSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(View.ID_PROPERTY)
			.field(View.WHO_PROPERTY)
			.field(View.ASSESSMENT_PROPERTY)
			.field(View.INTERVIEW_TIME_PROPERTY)
			.field(View.VERSION_PROPERTY)
		;
	}

	/** Employee的简单属性序列化列表 */
	protected SerializeScope getEmployeeSummaryScope() {
		return SerializeScope.INCLUDE()
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
			.field(Employee.VERSION_PROPERTY)
		;
	}

	/** Instructor的简单属性序列化列表 */
	protected SerializeScope getInstructorSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Instructor.ID_PROPERTY)
			.field(Instructor.TITLE_PROPERTY)
			.field(Instructor.FAMILY_NAME_PROPERTY)
			.field(Instructor.GIVEN_NAME_PROPERTY)
			.field(Instructor.CELL_PHONE_PROPERTY)
			.field(Instructor.EMAIL_PROPERTY)
			.field(Instructor.INTRODUCTION_PROPERTY)
			.field(Instructor.LAST_UPDATE_TIME_PROPERTY)
			.field(Instructor.VERSION_PROPERTY)
		;
	}

	/** CompanyTraining的简单属性序列化列表 */
	protected SerializeScope getCompanyTrainingSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(CompanyTraining.ID_PROPERTY)
			.field(CompanyTraining.TITLE_PROPERTY)
			.field(CompanyTraining.TIME_START_PROPERTY)
			.field(CompanyTraining.DURATION_HOURS_PROPERTY)
			.field(CompanyTraining.LAST_UPDATE_TIME_PROPERTY)
			.field(CompanyTraining.VERSION_PROPERTY)
		;
	}

	/** Scoring的简单属性序列化列表 */
	protected SerializeScope getScoringSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Scoring.ID_PROPERTY)
			.field(Scoring.SCORED_BY_PROPERTY)
			.field(Scoring.SCORE_PROPERTY)
			.field(Scoring.COMMENT_PROPERTY)
			.field(Scoring.VERSION_PROPERTY)
		;
	}

	/** EmployeeCompanyTraining的简单属性序列化列表 */
	protected SerializeScope getEmployeeCompanyTrainingSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeeCompanyTraining.ID_PROPERTY)
			.field(EmployeeCompanyTraining.VERSION_PROPERTY)
		;
	}

	/** EmployeeSkill的简单属性序列化列表 */
	protected SerializeScope getEmployeeSkillSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeeSkill.ID_PROPERTY)
			.field(EmployeeSkill.DESCRIPTION_PROPERTY)
			.field(EmployeeSkill.VERSION_PROPERTY)
		;
	}

	/** EmployeePerformance的简单属性序列化列表 */
	protected SerializeScope getEmployeePerformanceSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeePerformance.ID_PROPERTY)
			.field(EmployeePerformance.PERFORMANCE_COMMENT_PROPERTY)
			.field(EmployeePerformance.VERSION_PROPERTY)
		;
	}

	/** EmployeeWorkExperience的简单属性序列化列表 */
	protected SerializeScope getEmployeeWorkExperienceSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeeWorkExperience.ID_PROPERTY)
			.field(EmployeeWorkExperience.START_PROPERTY)
			.field(EmployeeWorkExperience.END_PROPERTY)
			.field(EmployeeWorkExperience.COMPANY_PROPERTY)
			.field(EmployeeWorkExperience.DESCRIPTION_PROPERTY)
			.field(EmployeeWorkExperience.VERSION_PROPERTY)
		;
	}

	/** EmployeeLeave的简单属性序列化列表 */
	protected SerializeScope getEmployeeLeaveSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeeLeave.ID_PROPERTY)
			.field(EmployeeLeave.LEAVE_DURATION_HOUR_PROPERTY)
			.field(EmployeeLeave.REMARK_PROPERTY)
			.field(EmployeeLeave.VERSION_PROPERTY)
		;
	}

	/** EmployeeInterview的简单属性序列化列表 */
	protected SerializeScope getEmployeeInterviewSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeeInterview.ID_PROPERTY)
			.field(EmployeeInterview.REMARK_PROPERTY)
			.field(EmployeeInterview.VERSION_PROPERTY)
		;
	}

	/** EmployeeAttendance的简单属性序列化列表 */
	protected SerializeScope getEmployeeAttendanceSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeeAttendance.ID_PROPERTY)
			.field(EmployeeAttendance.ENTER_TIME_PROPERTY)
			.field(EmployeeAttendance.LEAVE_TIME_PROPERTY)
			.field(EmployeeAttendance.DURATION_HOURS_PROPERTY)
			.field(EmployeeAttendance.REMARK_PROPERTY)
			.field(EmployeeAttendance.VERSION_PROPERTY)
		;
	}

	/** EmployeeQualifier的简单属性序列化列表 */
	protected SerializeScope getEmployeeQualifierSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeeQualifier.ID_PROPERTY)
			.field(EmployeeQualifier.QUALIFIED_TIME_PROPERTY)
			.field(EmployeeQualifier.TYPE_PROPERTY)
			.field(EmployeeQualifier.LEVEL_PROPERTY)
			.field(EmployeeQualifier.REMARK_PROPERTY)
			.field(EmployeeQualifier.VERSION_PROPERTY)
		;
	}

	/** EmployeeEducation的简单属性序列化列表 */
	protected SerializeScope getEmployeeEducationSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeeEducation.ID_PROPERTY)
			.field(EmployeeEducation.COMPLETE_TIME_PROPERTY)
			.field(EmployeeEducation.TYPE_PROPERTY)
			.field(EmployeeEducation.REMARK_PROPERTY)
			.field(EmployeeEducation.VERSION_PROPERTY)
		;
	}

	/** EmployeeAward的简单属性序列化列表 */
	protected SerializeScope getEmployeeAwardSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeeAward.ID_PROPERTY)
			.field(EmployeeAward.COMPLETE_TIME_PROPERTY)
			.field(EmployeeAward.TYPE_PROPERTY)
			.field(EmployeeAward.REMARK_PROPERTY)
			.field(EmployeeAward.VERSION_PROPERTY)
		;
	}

	/** EmployeeSalarySheet的简单属性序列化列表 */
	protected SerializeScope getEmployeeSalarySheetSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeeSalarySheet.ID_PROPERTY)
			.field(EmployeeSalarySheet.BASE_SALARY_PROPERTY)
			.field(EmployeeSalarySheet.BONUS_PROPERTY)
			.field(EmployeeSalarySheet.REWARD_PROPERTY)
			.field(EmployeeSalarySheet.PERSONAL_TAX_PROPERTY)
			.field(EmployeeSalarySheet.SOCIAL_SECURITY_PROPERTY)
			.field(EmployeeSalarySheet.HOUSING_FOUND_PROPERTY)
			.field(EmployeeSalarySheet.JOB_INSURANCE_PROPERTY)
			.field(EmployeeSalarySheet.VERSION_PROPERTY)
		;
	}

	/** PayingOff的简单属性序列化列表 */
	protected SerializeScope getPayingOffSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(PayingOff.ID_PROPERTY)
			.field(PayingOff.WHO_PROPERTY)
			.field(PayingOff.PAID_TIME_PROPERTY)
			.field(PayingOff.AMOUNT_PROPERTY)
			.field(PayingOff.VERSION_PROPERTY)
		;
	}

	/** MobileApp的简单属性序列化列表 */
	protected SerializeScope getMobileAppSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(MobileApp.ID_PROPERTY)
			.field(MobileApp.NAME_PROPERTY)
			.field(MobileApp.VERSION_PROPERTY)
		;
	}

	/** Page的简单属性序列化列表 */
	protected SerializeScope getPageSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Page.ID_PROPERTY)
			.field(Page.PAGE_TITLE_PROPERTY)
			.field(Page.LINK_TO_URL_PROPERTY)
			.field(Page.DISPLAY_ORDER_PROPERTY)
			.field(Page.VERSION_PROPERTY)
		;
	}

	/** PageType的简单属性序列化列表 */
	protected SerializeScope getPageTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(PageType.ID_PROPERTY)
			.field(PageType.NAME_PROPERTY)
			.field(PageType.CODE_PROPERTY)
			.field(PageType.FOOTER_TAB_PROPERTY)
			.field(PageType.VERSION_PROPERTY)
		;
	}

	/** Slide的简单属性序列化列表 */
	protected SerializeScope getSlideSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Slide.ID_PROPERTY)
			.field(Slide.NAME_PROPERTY)
			.field(Slide.DISPLAY_ORDER_PROPERTY)
			.field(Slide.IMAGE_URL_PROPERTY)
			.field(Slide.VIDEO_URL_PROPERTY)
			.field(Slide.LINK_TO_URL_PROPERTY)
			.field(Slide.VERSION_PROPERTY)
		;
	}

	/** UiAction的简单属性序列化列表 */
	protected SerializeScope getUiActionSummaryScope() {
		return SerializeScope.INCLUDE()
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
			.field(UiAction.VERSION_PROPERTY)
		;
	}

	/** Section的简单属性序列化列表 */
	protected SerializeScope getSectionSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Section.ID_PROPERTY)
			.field(Section.TITLE_PROPERTY)
			.field(Section.BRIEF_PROPERTY)
			.field(Section.ICON_PROPERTY)
			.field(Section.DISPLAY_ORDER_PROPERTY)
			.field(Section.VIEW_GROUP_PROPERTY)
			.field(Section.LINK_TO_URL_PROPERTY)
			.field(Section.VERSION_PROPERTY)
		;
	}

	/** UserDomain的简单属性序列化列表 */
	protected SerializeScope getUserDomainSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(UserDomain.ID_PROPERTY)
			.field(UserDomain.NAME_PROPERTY)
			.field(UserDomain.VERSION_PROPERTY)
		;
	}

	/** UserAllowList的简单属性序列化列表 */
	protected SerializeScope getUserAllowListSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(UserAllowList.ID_PROPERTY)
			.field(UserAllowList.USER_IDENTITY_PROPERTY)
			.field(UserAllowList.USER_SPECIAL_FUNCTIONS_PROPERTY)
			.field(UserAllowList.VERSION_PROPERTY)
		;
	}

	/** SecUser的简单属性序列化列表 */
	protected SerializeScope getSecUserSummaryScope() {
		return SerializeScope.INCLUDE()
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
			.field(SecUser.VERSION_PROPERTY)
		;
	}

	/** UserApp的简单属性序列化列表 */
	protected SerializeScope getUserAppSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(UserApp.ID_PROPERTY)
			.field(UserApp.TITLE_PROPERTY)
			.field(UserApp.APP_ICON_PROPERTY)
			.field(UserApp.FULL_ACCESS_PROPERTY)
			.field(UserApp.PERMISSION_PROPERTY)
			.field(UserApp.OBJECT_TYPE_PROPERTY)
			.field(UserApp.OBJECT_ID_PROPERTY)
			.field(UserApp.LOCATION_PROPERTY)
			.field(UserApp.VERSION_PROPERTY)
		;
	}

	/** QuickLink的简单属性序列化列表 */
	protected SerializeScope getQuickLinkSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(QuickLink.ID_PROPERTY)
			.field(QuickLink.NAME_PROPERTY)
			.field(QuickLink.ICON_PROPERTY)
			.field(QuickLink.IMAGE_PATH_PROPERTY)
			.field(QuickLink.LINK_TARGET_PROPERTY)
			.field(QuickLink.CREATE_TIME_PROPERTY)
			.field(QuickLink.VERSION_PROPERTY)
		;
	}

	/** ListAccess的简单属性序列化列表 */
	protected SerializeScope getListAccessSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ListAccess.ID_PROPERTY)
			.field(ListAccess.NAME_PROPERTY)
			.field(ListAccess.INTERNAL_NAME_PROPERTY)
			.field(ListAccess.READ_PERMISSION_PROPERTY)
			.field(ListAccess.CREATE_PERMISSION_PROPERTY)
			.field(ListAccess.DELETE_PERMISSION_PROPERTY)
			.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
			.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
			.field(ListAccess.VERSION_PROPERTY)
		;
	}

	/** LoginHistory的简单属性序列化列表 */
	protected SerializeScope getLoginHistorySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(LoginHistory.ID_PROPERTY)
			.field(LoginHistory.LOGIN_TIME_PROPERTY)
			.field(LoginHistory.FROM_IP_PROPERTY)
			.field(LoginHistory.DESCRIPTION_PROPERTY)
			.field(LoginHistory.VERSION_PROPERTY)
		;
	}

	/** CandidateContainer的简单属性序列化列表 */
	protected SerializeScope getCandidateContainerSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(CandidateContainer.ID_PROPERTY)
			.field(CandidateContainer.NAME_PROPERTY)
			.field(CandidateContainer.VERSION_PROPERTY)
		;
	}

	/** CandidateElement的简单属性序列化列表 */
	protected SerializeScope getCandidateElementSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(CandidateElement.ID_PROPERTY)
			.field(CandidateElement.NAME_PROPERTY)
			.field(CandidateElement.TYPE_PROPERTY)
			.field(CandidateElement.IMAGE_PROPERTY)
			.field(CandidateElement.VERSION_PROPERTY)
		;
	}

	/** WechatWorkappIdentity的简单属性序列化列表 */
	protected SerializeScope getWechatWorkappIdentitySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(WechatWorkappIdentity.ID_PROPERTY)
			.field(WechatWorkappIdentity.CORP_ID_PROPERTY)
			.field(WechatWorkappIdentity.USER_ID_PROPERTY)
			.field(WechatWorkappIdentity.CREATE_TIME_PROPERTY)
			.field(WechatWorkappIdentity.LAST_LOGIN_TIME_PROPERTY)
			.field(WechatWorkappIdentity.VERSION_PROPERTY)
		;
	}

	/** WechatMiniappIdentity的简单属性序列化列表 */
	protected SerializeScope getWechatMiniappIdentitySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(WechatMiniappIdentity.ID_PROPERTY)
			.field(WechatMiniappIdentity.OPEN_ID_PROPERTY)
			.field(WechatMiniappIdentity.APP_ID_PROPERTY)
			.field(WechatMiniappIdentity.CREATE_TIME_PROPERTY)
			.field(WechatMiniappIdentity.LAST_LOGIN_TIME_PROPERTY)
			.field(WechatMiniappIdentity.VERSION_PROPERTY)
		;
	}

	/** KeypairIdentity的简单属性序列化列表 */
	protected SerializeScope getKeypairIdentitySummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(KeypairIdentity.ID_PROPERTY)
			.field(KeypairIdentity.PUBLIC_KEY_PROPERTY)
			.field(KeypairIdentity.CREATE_TIME_PROPERTY)
			.field(KeypairIdentity.VERSION_PROPERTY)
		;
	}

	/** PublicKeyType的简单属性序列化列表 */
	protected SerializeScope getPublicKeyTypeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(PublicKeyType.ID_PROPERTY)
			.field(PublicKeyType.NAME_PROPERTY)
			.field(PublicKeyType.CODE_PROPERTY)
			.field(PublicKeyType.VERSION_PROPERTY)
		;
	}

	/** TreeNode的简单属性序列化列表 */
	protected SerializeScope getTreeNodeSummaryScope() {
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(TreeNode.ID_PROPERTY)
			.field(TreeNode.NODE_ID_PROPERTY)
			.field(TreeNode.NODE_TYPE_PROPERTY)
			.field(TreeNode.LEFT_VALUE_PROPERTY)
			.field(TreeNode.RIGHT_VALUE_PROPERTY)
			.field(TreeNode.VERSION_PROPERTY)
		;
	}

	/** RetailStoreCountryCenter的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreCountryCenterListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='双链小超中国国运营中心|双链小超美国国运营中心|双链小超日本国运营中心|双链小超泰国国运营中心'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='中国中心正式成立，恭喜恭喜'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreCountryCenter.ID_PROPERTY)
			.field(RetailStoreCountryCenter.NAME_PROPERTY).as("title")
			.field(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY)
			.field(RetailStoreCountryCenter.FOUNDED_PROPERTY)
			.field(RetailStoreCountryCenter.WEB_SITE_PROPERTY)
			.field(RetailStoreCountryCenter.ADDRESS_PROPERTY)
			.field(RetailStoreCountryCenter.OPERATED_BY_PROPERTY)
			.field(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY)
			.field(RetailStoreCountryCenter.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(RetailStoreCountryCenter.VERSION_PROPERTY)
		;
	}

	/** Catalog的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCatalogListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='水果蔬菜|肉禽蛋奶|冷热速食|休闲食品|酒水饮料|粮油调味|清洁日化|家居用品|鲜花蛋糕|医药健康'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='amount'; 
		//	type='money'; 
		//	value='$10.11'; 
		//	required='true'; 
		//	features='{name=money}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Catalog.ID_PROPERTY)
			.field(Catalog.NAME_PROPERTY).as("title")
			.field(Catalog.OWNER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(Catalog.SUB_COUNT_PROPERTY)
			.field(Catalog.AMOUNT_PROPERTY).as("brief").with_prefix("金额: ")
			.field(Catalog.VERSION_PROPERTY)
		;
	}

	/** LevelOneCategory的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLevelOneCategoryListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='水果蔬菜|肉禽蛋奶|冷热速食|休闲食品|酒水饮料|粮油调味|清洁日化|家居用品|鲜花蛋糕|医药健康'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(LevelOneCategory.ID_PROPERTY)
			.field(LevelOneCategory.CATALOG_PROPERTY, getCatalogSummaryScope())
			.field(LevelOneCategory.NAME_PROPERTY).as("title")
			.field(LevelOneCategory.VERSION_PROPERTY)
		;
	}

	/** LevelTwoCategory的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLevelTwoCategoryListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='水果蔬菜|肉禽蛋奶|冷热速食|休闲食品|酒水饮料|粮油调味|清洁日化|家居用品|鲜花蛋糕|医药健康'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(LevelTwoCategory.ID_PROPERTY)
			.field(LevelTwoCategory.PARENT_CATEGORY_PROPERTY, getLevelOneCategorySummaryScope())
			.field(LevelTwoCategory.NAME_PROPERTY).as("title")
			.field(LevelTwoCategory.VERSION_PROPERTY)
		;
	}

	/** LevelThreeCategory的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLevelThreeCategoryListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='水果蔬菜|肉禽蛋奶|冷热速食|休闲食品|酒水饮料|粮油调味|清洁日化|家居用品|鲜花蛋糕|医药健康'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(LevelThreeCategory.ID_PROPERTY)
			.field(LevelThreeCategory.PARENT_CATEGORY_PROPERTY, getLevelTwoCategorySummaryScope())
			.field(LevelThreeCategory.NAME_PROPERTY).as("title")
			.field(LevelThreeCategory.VERSION_PROPERTY)
		;
	}

	/** Product的ListOf时需要序列化的属性列表 */
	protected SerializeScope getProductListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='啤酒|可乐|久久鸭'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='origin'; 
		//	type='string'; 
		//	value='四川|广东|江苏|安徽|日本|法国'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=fieldesc{
		//	name='picture'; 
		//	type='string_image'; 
		//	value='this is a looooooooooog.jpg'; 
		//	required='true'; 
		//	features='{name=string_image, features=attachment}';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Product.ID_PROPERTY)
			.field(Product.NAME_PROPERTY).as("title")
			.field(Product.PARENT_CATEGORY_PROPERTY, getLevelThreeCategorySummaryScope())
			.field(Product.ORIGIN_PROPERTY).as("brief").with_prefix("产地: ")
			.field(Product.REMARK_PROPERTY)
			.field(Product.BRAND_PROPERTY)
			.field(Product.PICTURE_PROPERTY).as("imageUrl")
			.field(Product.LAST_UPDATE_TIME_PROPERTY)
			.field(Product.VERSION_PROPERTY)
		;
	}

	/** Sku的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSkuListOfViewScope() {
		// DisplayMode{name='product', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='可乐-大罐的'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='net_content'; 
		//	type='string'; 
		//	value='包装数量等信息,包装数量等信息,包装数量等信息'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=fieldesc{
		//	name='picture'; 
		//	type='string_image'; 
		//	value='coco.jpg'; 
		//	required='true'; 
		//	features='{name=string_image, features=attachment}';
		//}
		//, imageListField=null, propList=[DisplayProperty{name='listPrice', level=null}]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Sku.ID_PROPERTY)
			.field(Sku.NAME_PROPERTY).as("title")
			.field(Sku.SIZE_PROPERTY)
			.field(Sku.PRODUCT_PROPERTY, getProductSummaryScope())
			.field(Sku.BARCODE_PROPERTY)
			.field(Sku.PACKAGE_TYPE_PROPERTY)
			.field(Sku.NET_CONTENT_PROPERTY).as("brief").with_prefix("净含量: ")
			.field(Sku.PRICE_PROPERTY).as("listPrice")
			.field(Sku.PICTURE_PROPERTY).as("imageUrl")
			.field(Sku.VERSION_PROPERTY)
		;
	}

	/** RetailStoreProvinceCenter的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreProvinceCenterListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='双链小超四川省运营中心|双链小超北京运营中心'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='founded'; 
		//	type='date_past'; 
		//	value='past()'; 
		//	required='true'; 
		//	features='{name=date_past, parent=date}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreProvinceCenter.ID_PROPERTY)
			.field(RetailStoreProvinceCenter.NAME_PROPERTY).as("title")
			.field(RetailStoreProvinceCenter.FOUNDED_PROPERTY).as("brief").with_prefix("成立: ")
			.field(RetailStoreProvinceCenter.COUNTRY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(RetailStoreProvinceCenter.LAST_UPDATE_TIME_PROPERTY)
			.field(RetailStoreProvinceCenter.VERSION_PROPERTY)
		;
	}

	/** ProvinceCenterDepartment的ListOf时需要序列化的属性列表 */
	protected SerializeScope getProvinceCenterDepartmentListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='供应链部|采购部|管理部|财务部|法务部|市场部|人力资源部'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='manager'; 
		//	type='string'; 
		//	value='刘强|王德宏'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ProvinceCenterDepartment.ID_PROPERTY)
			.field(ProvinceCenterDepartment.NAME_PROPERTY).as("title")
			.field(ProvinceCenterDepartment.FOUNDED_PROPERTY)
			.field(ProvinceCenterDepartment.PROVINCE_CENTER_PROPERTY, getRetailStoreProvinceCenterSummaryScope())
			.field(ProvinceCenterDepartment.MANAGER_PROPERTY).as("brief").with_prefix("经理: ")
			.field(ProvinceCenterDepartment.VERSION_PROPERTY)
		;
	}

	/** ProvinceCenterEmployee的ListOf时需要序列化的属性列表 */
	protected SerializeScope getProvinceCenterEmployeeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='刘强|王德宏'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='mobile'; 
		//	type='string_china_mobile_phone'; 
		//	value='13999998888'; 
		//	required='true'; 
		//	features='{name=string_china_mobile_phone}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ProvinceCenterEmployee.ID_PROPERTY)
			.field(ProvinceCenterEmployee.NAME_PROPERTY).as("title")
			.field(ProvinceCenterEmployee.MOBILE_PROPERTY).as("brief").with_prefix("手机: ")
			.field(ProvinceCenterEmployee.EMAIL_PROPERTY)
			.field(ProvinceCenterEmployee.FOUNDED_PROPERTY)
			.field(ProvinceCenterEmployee.DEPARTMENT_PROPERTY, getProvinceCenterDepartmentSummaryScope())
			.field(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY, getRetailStoreProvinceCenterSummaryScope())
			.field(ProvinceCenterEmployee.VERSION_PROPERTY)
		;
	}

	/** RetailStoreCityServiceCenter的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreCityServiceCenterListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='双链小超成都办事处|双链小超绵阳办事处|双链小超巴中办事处'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='founded'; 
		//	type='date_past'; 
		//	value='past()'; 
		//	required='true'; 
		//	features='{name=date_past, parent=date}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreCityServiceCenter.ID_PROPERTY)
			.field(RetailStoreCityServiceCenter.NAME_PROPERTY).as("title")
			.field(RetailStoreCityServiceCenter.FOUNDED_PROPERTY).as("brief").with_prefix("成立: ")
			.field(RetailStoreCityServiceCenter.BELONGS_TO_PROPERTY, getRetailStoreProvinceCenterSummaryScope())
			.field(RetailStoreCityServiceCenter.LAST_UPDATE_TIME_PROPERTY)
			.field(RetailStoreCityServiceCenter.VERSION_PROPERTY)
		;
	}

	/** CityPartner的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCityPartnerListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='曾倩|黄风格|郭超'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='负责开拓市场，具有极强的开拓能力'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(CityPartner.ID_PROPERTY)
			.field(CityPartner.NAME_PROPERTY).as("title")
			.field(CityPartner.MOBILE_PROPERTY)
			.field(CityPartner.CITY_SERVICE_CENTER_PROPERTY, getRetailStoreCityServiceCenterSummaryScope())
			.field(CityPartner.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(CityPartner.LAST_UPDATE_TIME_PROPERTY)
			.field(CityPartner.VERSION_PROPERTY)
		;
	}

	/** PotentialCustomer的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPotentialCustomerListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='曾倩|黄风格|郭超'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='负责开拓市场，具有极强的开拓能力'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(PotentialCustomer.ID_PROPERTY)
			.field(PotentialCustomer.NAME_PROPERTY).as("title")
			.field(PotentialCustomer.MOBILE_PROPERTY)
			.field(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, getRetailStoreCityServiceCenterSummaryScope())
			.field(PotentialCustomer.CITY_PARTNER_PROPERTY, getCityPartnerSummaryScope())
			.field(PotentialCustomer.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(PotentialCustomer.LAST_UPDATE_TIME_PROPERTY)
			.field(PotentialCustomer.VERSION_PROPERTY)
		;
	}

	/** PotentialCustomerContactPerson的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPotentialCustomerContactPersonListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='赵先生'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='这人在决策中战友较大的权重，密切观察中.....'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(PotentialCustomerContactPerson.ID_PROPERTY)
			.field(PotentialCustomerContactPerson.NAME_PROPERTY).as("title")
			.field(PotentialCustomerContactPerson.MOBILE_PROPERTY)
			.field(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomerSummaryScope())
			.field(PotentialCustomerContactPerson.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(PotentialCustomerContactPerson.VERSION_PROPERTY)
		;
	}

	/** PotentialCustomerContact的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPotentialCustomerContactListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='和连载客户的联系记录'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='转化希望很大'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(PotentialCustomerContact.ID_PROPERTY)
			.field(PotentialCustomerContact.NAME_PROPERTY).as("title")
			.field(PotentialCustomerContact.CONTACT_DATE_PROPERTY)
			.field(PotentialCustomerContact.CONTACT_METHOD_PROPERTY)
			.field(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomerSummaryScope())
			.field(PotentialCustomerContact.CITY_PARTNER_PROPERTY, getCityPartnerSummaryScope())
			.field(PotentialCustomerContact.CONTACT_TO_PROPERTY, getPotentialCustomerContactPersonSummaryScope())
			.field(PotentialCustomerContact.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY)
			.field(PotentialCustomerContact.VERSION_PROPERTY)
		;
	}

	/** CityEvent的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCityEventListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='小超见面会|双链小超说明会'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='给大家讲解小超的发展蓝图'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(CityEvent.ID_PROPERTY)
			.field(CityEvent.NAME_PROPERTY).as("title")
			.field(CityEvent.MOBILE_PROPERTY)
			.field(CityEvent.CITY_SERVICE_CENTER_PROPERTY, getRetailStoreCityServiceCenterSummaryScope())
			.field(CityEvent.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(CityEvent.LAST_UPDATE_TIME_PROPERTY)
			.field(CityEvent.VERSION_PROPERTY)
		;
	}

	/** EventAttendance的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEventAttendanceListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='小超见面会参加信息'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='体会不错，考虑加盟'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EventAttendance.ID_PROPERTY)
			.field(EventAttendance.NAME_PROPERTY).as("title")
			.field(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomerSummaryScope())
			.field(EventAttendance.CITY_EVENT_PROPERTY, getCityEventSummaryScope())
			.field(EventAttendance.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(EventAttendance.VERSION_PROPERTY)
		;
	}

	/** RetailStore的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='中和社区小超|华阳社区小超|大源社区小超'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='啤酒饮料矿泉水，香肠瓜子方便面, 请让一让'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStore.ID_PROPERTY)
			.field(RetailStore.NAME_PROPERTY).as("title")
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
			.field(RetailStore.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(RetailStore.LAST_UPDATE_TIME_PROPERTY)
			.field(RetailStore.VERSION_PROPERTY)
		;
	}

	/** RetailStoreCreation的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreCreationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='comment'; 
		//	type='string'; 
		//	value='已经建好了'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreCreation.ID_PROPERTY)
			.field(RetailStoreCreation.COMMENT_PROPERTY).as("title")
			.field(RetailStoreCreation.VERSION_PROPERTY)
		;
	}

	/** RetailStoreInvestmentInvitation的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreInvestmentInvitationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='comment'; 
		//	type='string'; 
		//	value='欢迎前来咨询'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreInvestmentInvitation.ID_PROPERTY)
			.field(RetailStoreInvestmentInvitation.COMMENT_PROPERTY).as("title")
			.field(RetailStoreInvestmentInvitation.VERSION_PROPERTY)
		;
	}

	/** RetailStoreFranchising的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreFranchisingListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='comment'; 
		//	type='string'; 
		//	value='谢谢加盟'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreFranchising.ID_PROPERTY)
			.field(RetailStoreFranchising.COMMENT_PROPERTY).as("title")
			.field(RetailStoreFranchising.VERSION_PROPERTY)
		;
	}

	/** RetailStoreDecoration的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreDecorationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='comment'; 
		//	type='string'; 
		//	value='装修'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreDecoration.ID_PROPERTY)
			.field(RetailStoreDecoration.COMMENT_PROPERTY).as("title")
			.field(RetailStoreDecoration.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOpening的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreOpeningListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='comment'; 
		//	type='string'; 
		//	value='装修'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOpening.ID_PROPERTY)
			.field(RetailStoreOpening.COMMENT_PROPERTY).as("title")
			.field(RetailStoreOpening.VERSION_PROPERTY)
		;
	}

	/** RetailStoreClosing的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreClosingListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='comment'; 
		//	type='string'; 
		//	value='关闭'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreClosing.ID_PROPERTY)
			.field(RetailStoreClosing.COMMENT_PROPERTY).as("title")
			.field(RetailStoreClosing.VERSION_PROPERTY)
		;
	}

	/** RetailStoreMember的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreMemberListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='李亚青'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='mobile_phone'; 
		//	type='string_china_mobile_phone'; 
		//	value='18099887766'; 
		//	required='true'; 
		//	features='{name=string_china_mobile_phone}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreMember.ID_PROPERTY)
			.field(RetailStoreMember.NAME_PROPERTY).as("title")
			.field(RetailStoreMember.MOBILE_PHONE_PROPERTY).as("brief").with_prefix("移动电话: ")
			.field(RetailStoreMember.OWNER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(RetailStoreMember.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrder的ListOf时需要序列化的属性列表 */
	protected SerializeScope getConsumerOrderListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title'; 
		//	type='string'; 
		//	value='消费订单'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrder.ID_PROPERTY)
			.field(ConsumerOrder.TITLE_PROPERTY).as("title")
			.field(ConsumerOrder.CONSUMER_PROPERTY, getRetailStoreMemberSummaryScope())
			.field(ConsumerOrder.STORE_PROPERTY, getRetailStoreSummaryScope())
			.field(ConsumerOrder.LAST_UPDATE_TIME_PROPERTY)
			.field(ConsumerOrder.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderLineItem的ListOf时需要序列化的属性列表 */
	protected SerializeScope getConsumerOrderLineItemListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='sku_name'; 
		//	type='string'; 
		//	value='大瓶可乐'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='sku_id'; 
		//	type='string'; 
		//	value='SKU'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderLineItem.ID_PROPERTY)
			.field(ConsumerOrderLineItem.BIZ_ORDER_PROPERTY, getConsumerOrderSummaryScope())
			.field(ConsumerOrderLineItem.SKU_ID_PROPERTY).as("brief").with_prefix("产品ID: ")
			.field(ConsumerOrderLineItem.SKU_NAME_PROPERTY).as("title")
			.field(ConsumerOrderLineItem.PRICE_PROPERTY)
			.field(ConsumerOrderLineItem.QUANTITY_PROPERTY)
			.field(ConsumerOrderLineItem.AMOUNT_PROPERTY)
			.field(ConsumerOrderLineItem.LAST_UPDATE_TIME_PROPERTY)
			.field(ConsumerOrderLineItem.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderShippingGroup的ListOf时需要序列化的属性列表 */
	protected SerializeScope getConsumerOrderShippingGroupListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='送货到刘强家'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='amount'; 
		//	type='money'; 
		//	value='$599.99'; 
		//	required='true'; 
		//	features='{name=money}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderShippingGroup.ID_PROPERTY)
			.field(ConsumerOrderShippingGroup.NAME_PROPERTY).as("title")
			.field(ConsumerOrderShippingGroup.BIZ_ORDER_PROPERTY, getConsumerOrderSummaryScope())
			.field(ConsumerOrderShippingGroup.AMOUNT_PROPERTY).as("brief").with_prefix("金额: ")
			.field(ConsumerOrderShippingGroup.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderPaymentGroup的ListOf时需要序列化的属性列表 */
	protected SerializeScope getConsumerOrderPaymentGroupListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='信用卡|支付宝|微信支付'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='card_number'; 
		//	type='string'; 
		//	value='4111 1111 1111 - '; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderPaymentGroup.ID_PROPERTY)
			.field(ConsumerOrderPaymentGroup.NAME_PROPERTY).as("title")
			.field(ConsumerOrderPaymentGroup.BIZ_ORDER_PROPERTY, getConsumerOrderSummaryScope())
			.field(ConsumerOrderPaymentGroup.CARD_NUMBER_PROPERTY).as("brief").with_prefix("卡号码: ")
			.field(ConsumerOrderPaymentGroup.VERSION_PROPERTY)
		;
	}

	/** ConsumerOrderPriceAdjustment的ListOf时需要序列化的属性列表 */
	protected SerializeScope getConsumerOrderPriceAdjustmentListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='端午促销'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='amount'; 
		//	type='money'; 
		//	value='$599.99'; 
		//	required='true'; 
		//	features='{name=money}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ConsumerOrderPriceAdjustment.ID_PROPERTY)
			.field(ConsumerOrderPriceAdjustment.NAME_PROPERTY).as("title")
			.field(ConsumerOrderPriceAdjustment.BIZ_ORDER_PROPERTY, getConsumerOrderSummaryScope())
			.field(ConsumerOrderPriceAdjustment.AMOUNT_PROPERTY).as("brief").with_prefix("金额: ")
			.field(ConsumerOrderPriceAdjustment.PROVIDER_PROPERTY)
			.field(ConsumerOrderPriceAdjustment.VERSION_PROPERTY)
		;
	}

	/** RetailStoreMemberCoupon的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreMemberCouponListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='优惠券'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='number'; 
		//	type='string'; 
		//	value='CP00001'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreMemberCoupon.ID_PROPERTY)
			.field(RetailStoreMemberCoupon.NAME_PROPERTY).as("title")
			.field(RetailStoreMemberCoupon.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
			.field(RetailStoreMemberCoupon.NUMBER_PROPERTY).as("brief").with_prefix("数: ")
			.field(RetailStoreMemberCoupon.LAST_UPDATE_TIME_PROPERTY)
			.field(RetailStoreMemberCoupon.VERSION_PROPERTY)
		;
	}

	/** MemberWishlist的ListOf时需要序列化的属性列表 */
	protected SerializeScope getMemberWishlistListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='每周购买清单|每月购买清单'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(MemberWishlist.ID_PROPERTY)
			.field(MemberWishlist.NAME_PROPERTY).as("title")
			.field(MemberWishlist.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
			.field(MemberWishlist.VERSION_PROPERTY)
		;
	}

	/** MemberRewardPoint的ListOf时需要序列化的属性列表 */
	protected SerializeScope getMemberRewardPointListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='购买积分|每月购买清单'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='point'; 
		//	type='int'; 
		//	value='20'; 
		//	required='true'; 
		//	features='{name=int}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(MemberRewardPoint.ID_PROPERTY)
			.field(MemberRewardPoint.NAME_PROPERTY).as("title")
			.field(MemberRewardPoint.POINT_PROPERTY).as("brief").with_prefix("点: ")
			.field(MemberRewardPoint.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
			.field(MemberRewardPoint.VERSION_PROPERTY)
		;
	}

	/** MemberRewardPointRedemption的ListOf时需要序列化的属性列表 */
	protected SerializeScope getMemberRewardPointRedemptionListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='积分换锅|积分换刀'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='point'; 
		//	type='int'; 
		//	value='20'; 
		//	required='true'; 
		//	features='{name=int}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(MemberRewardPointRedemption.ID_PROPERTY)
			.field(MemberRewardPointRedemption.NAME_PROPERTY).as("title")
			.field(MemberRewardPointRedemption.POINT_PROPERTY).as("brief").with_prefix("点: ")
			.field(MemberRewardPointRedemption.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
			.field(MemberRewardPointRedemption.VERSION_PROPERTY)
		;
	}

	/** MemberWishlistProduct的ListOf时需要序列化的属性列表 */
	protected SerializeScope getMemberWishlistProductListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='农夫山泉|利箭口香糖'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(MemberWishlistProduct.ID_PROPERTY)
			.field(MemberWishlistProduct.NAME_PROPERTY).as("title")
			.field(MemberWishlistProduct.OWNER_PROPERTY, getMemberWishlistSummaryScope())
			.field(MemberWishlistProduct.VERSION_PROPERTY)
		;
	}

	/** RetailStoreMemberAddress的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreMemberAddressListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='家里|办公室|出差临时地址'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='mobile_phone'; 
		//	type='string_china_mobile_phone'; 
		//	value='18099887766'; 
		//	required='true'; 
		//	features='{name=string_china_mobile_phone}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreMemberAddress.ID_PROPERTY)
			.field(RetailStoreMemberAddress.NAME_PROPERTY).as("title")
			.field(RetailStoreMemberAddress.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
			.field(RetailStoreMemberAddress.MOBILE_PHONE_PROPERTY).as("brief").with_prefix("移动电话: ")
			.field(RetailStoreMemberAddress.ADDRESS_PROPERTY)
			.field(RetailStoreMemberAddress.VERSION_PROPERTY)
		;
	}

	/** RetailStoreMemberGiftCard的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreMemberGiftCardListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='礼品卡'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='remain'; 
		//	type='money'; 
		//	value='$213.99'; 
		//	required='true'; 
		//	features='{name=money}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreMemberGiftCard.ID_PROPERTY)
			.field(RetailStoreMemberGiftCard.NAME_PROPERTY).as("title")
			.field(RetailStoreMemberGiftCard.OWNER_PROPERTY, getRetailStoreMemberSummaryScope())
			.field(RetailStoreMemberGiftCard.NUMBER_PROPERTY)
			.field(RetailStoreMemberGiftCard.REMAIN_PROPERTY).as("brief").with_prefix("保持: ")
			.field(RetailStoreMemberGiftCard.VERSION_PROPERTY)
		;
	}

	/** RetailStoreMemberGiftCardConsumeRecord的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreMemberGiftCardConsumeRecordListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='number'; 
		//	type='string'; 
		//	value='GF00001'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='amount'; 
		//	type='money'; 
		//	value='$20.99'; 
		//	required='true'; 
		//	features='{name=money}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreMemberGiftCardConsumeRecord.ID_PROPERTY)
			.field(RetailStoreMemberGiftCardConsumeRecord.OCCURE_TIME_PROPERTY)
			.field(RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY, getRetailStoreMemberGiftCardSummaryScope())
			.field(RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY, getConsumerOrderSummaryScope())
			.field(RetailStoreMemberGiftCardConsumeRecord.NUMBER_PROPERTY).as("title")
			.field(RetailStoreMemberGiftCardConsumeRecord.AMOUNT_PROPERTY).as("brief").with_prefix("金额: ")
			.field(RetailStoreMemberGiftCardConsumeRecord.VERSION_PROPERTY)
		;
	}

	/** GoodsSupplier的ListOf时需要序列化的属性列表 */
	protected SerializeScope getGoodsSupplierListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='宝洁|中粮|福临门'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='啤酒饮料矿泉水，香肠瓜子方便面都提供'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(GoodsSupplier.ID_PROPERTY)
			.field(GoodsSupplier.NAME_PROPERTY).as("title")
			.field(GoodsSupplier.SUPPLY_PRODUCT_PROPERTY)
			.field(GoodsSupplier.BELONG_TO_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(GoodsSupplier.CONTACT_NUMBER_PROPERTY)
			.field(GoodsSupplier.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(GoodsSupplier.LAST_UPDATE_TIME_PROPERTY)
			.field(GoodsSupplier.VERSION_PROPERTY)
		;
	}

	/** SupplierProduct的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSupplierProductListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='product_name'; 
		//	type='string'; 
		//	value='黑人牙膏'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='product_description'; 
		//	type='string'; 
		//	value='最好的黑人牙膏，只卖3块喽'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(SupplierProduct.ID_PROPERTY)
			.field(SupplierProduct.PRODUCT_NAME_PROPERTY).as("title")
			.field(SupplierProduct.PRODUCT_DESCRIPTION_PROPERTY).as("brief").with_prefix("产品描述: ")
			.field(SupplierProduct.PRODUCT_UNIT_PROPERTY)
			.field(SupplierProduct.SUPPLIER_PROPERTY, getGoodsSupplierSummaryScope())
			.field(SupplierProduct.VERSION_PROPERTY)
		;
	}

	/** ProductSupplyDuration的ListOf时需要序列化的属性列表 */
	protected SerializeScope getProductSupplyDurationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='duration'; 
		//	type='string'; 
		//	value='现货|两天|三天|一周'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='price'; 
		//	type='money'; 
		//	value='$9999.99'; 
		//	required='true'; 
		//	features='{name=money}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ProductSupplyDuration.ID_PROPERTY)
			.field(ProductSupplyDuration.QUANTITY_PROPERTY)
			.field(ProductSupplyDuration.DURATION_PROPERTY).as("title")
			.field(ProductSupplyDuration.PRICE_PROPERTY).as("brief").with_prefix("价格: ")
			.field(ProductSupplyDuration.PRODUCT_PROPERTY, getSupplierProductSummaryScope())
			.field(ProductSupplyDuration.VERSION_PROPERTY)
		;
	}

	/** SupplyOrder的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSupplyOrderListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title'; 
		//	type='string'; 
		//	value='双链给供货商下的订单'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='total_amount'; 
		//	type='money'; 
		//	value='$3000000000.88'; 
		//	required='true'; 
		//	features='{name=money}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrder.ID_PROPERTY)
			.field(SupplyOrder.BUYER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(SupplyOrder.SELLER_PROPERTY, getGoodsSupplierSummaryScope())
			.field(SupplyOrder.TITLE_PROPERTY).as("title")
			.field(SupplyOrder.TOTAL_AMOUNT_PROPERTY).as("brief").with_prefix("总金额: ")
			.field(SupplyOrder.LAST_UPDATE_TIME_PROPERTY)
			.field(SupplyOrder.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderLineItem的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSupplyOrderLineItemListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='sku_name'; 
		//	type='string'; 
		//	value='大瓶可乐'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='amount'; 
		//	type='money'; 
		//	value='$5.97'; 
		//	required='true'; 
		//	features='{name=money}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderLineItem.ID_PROPERTY)
			.field(SupplyOrderLineItem.BIZ_ORDER_PROPERTY, getSupplyOrderSummaryScope())
			.field(SupplyOrderLineItem.SKU_ID_PROPERTY)
			.field(SupplyOrderLineItem.SKU_NAME_PROPERTY).as("title")
			.field(SupplyOrderLineItem.AMOUNT_PROPERTY).as("brief").with_prefix("金额: ")
			.field(SupplyOrderLineItem.QUANTITY_PROPERTY)
			.field(SupplyOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY)
			.field(SupplyOrderLineItem.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderShippingGroup的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSupplyOrderShippingGroupListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='送货到双链成都2号仓'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='amount'; 
		//	type='money'; 
		//	value='$5.99'; 
		//	required='true'; 
		//	features='{name=money}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderShippingGroup.ID_PROPERTY)
			.field(SupplyOrderShippingGroup.NAME_PROPERTY).as("title")
			.field(SupplyOrderShippingGroup.BIZ_ORDER_PROPERTY, getSupplyOrderSummaryScope())
			.field(SupplyOrderShippingGroup.AMOUNT_PROPERTY).as("brief").with_prefix("金额: ")
			.field(SupplyOrderShippingGroup.VERSION_PROPERTY)
		;
	}

	/** SupplyOrderPaymentGroup的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSupplyOrderPaymentGroupListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='付款办法'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='card_number'; 
		//	type='string'; 
		//	value='4111 1111 1111 - '; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(SupplyOrderPaymentGroup.ID_PROPERTY)
			.field(SupplyOrderPaymentGroup.NAME_PROPERTY).as("title")
			.field(SupplyOrderPaymentGroup.BIZ_ORDER_PROPERTY, getSupplyOrderSummaryScope())
			.field(SupplyOrderPaymentGroup.CARD_NUMBER_PROPERTY).as("brief").with_prefix("卡号码: ")
			.field(SupplyOrderPaymentGroup.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrder的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreOrderListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title'; 
		//	type='string'; 
		//	value='双链小超给双链供应链下的订单'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='total_amount'; 
		//	type='money'; 
		//	value='$3000000000.88'; 
		//	required='true'; 
		//	features='{name=money}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrder.ID_PROPERTY)
			.field(RetailStoreOrder.BUYER_PROPERTY, getRetailStoreSummaryScope())
			.field(RetailStoreOrder.SELLER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(RetailStoreOrder.TITLE_PROPERTY).as("title")
			.field(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY).as("brief").with_prefix("总金额: ")
			.field(RetailStoreOrder.LAST_UPDATE_TIME_PROPERTY)
			.field(RetailStoreOrder.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderLineItem的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreOrderLineItemListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='sku_name'; 
		//	type='string'; 
		//	value='大瓶可乐'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='amount'; 
		//	type='money'; 
		//	value='$3.97'; 
		//	required='true'; 
		//	features='{name=money}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderLineItem.ID_PROPERTY)
			.field(RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY, getRetailStoreOrderSummaryScope())
			.field(RetailStoreOrderLineItem.SKU_ID_PROPERTY)
			.field(RetailStoreOrderLineItem.SKU_NAME_PROPERTY).as("title")
			.field(RetailStoreOrderLineItem.AMOUNT_PROPERTY).as("brief").with_prefix("金额: ")
			.field(RetailStoreOrderLineItem.QUANTITY_PROPERTY)
			.field(RetailStoreOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY)
			.field(RetailStoreOrderLineItem.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderShippingGroup的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreOrderShippingGroupListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='送货到双链中和社区店'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='amount'; 
		//	type='money'; 
		//	value='$5.99'; 
		//	required='true'; 
		//	features='{name=money}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderShippingGroup.ID_PROPERTY)
			.field(RetailStoreOrderShippingGroup.NAME_PROPERTY).as("title")
			.field(RetailStoreOrderShippingGroup.BIZ_ORDER_PROPERTY, getRetailStoreOrderSummaryScope())
			.field(RetailStoreOrderShippingGroup.AMOUNT_PROPERTY).as("brief").with_prefix("金额: ")
			.field(RetailStoreOrderShippingGroup.VERSION_PROPERTY)
		;
	}

	/** RetailStoreOrderPaymentGroup的ListOf时需要序列化的属性列表 */
	protected SerializeScope getRetailStoreOrderPaymentGroupListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='付款办法'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='card_number'; 
		//	type='string'; 
		//	value='4111 1111 1111 - '; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(RetailStoreOrderPaymentGroup.ID_PROPERTY)
			.field(RetailStoreOrderPaymentGroup.NAME_PROPERTY).as("title")
			.field(RetailStoreOrderPaymentGroup.BIZ_ORDER_PROPERTY, getRetailStoreOrderSummaryScope())
			.field(RetailStoreOrderPaymentGroup.CARD_NUMBER_PROPERTY).as("brief").with_prefix("卡号码: ")
			.field(RetailStoreOrderPaymentGroup.VERSION_PROPERTY)
		;
	}

	/** Warehouse的ListOf时需要序列化的属性列表 */
	protected SerializeScope getWarehouseListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='location'; 
		//	type='string'; 
		//	value='成都龙泉驿飞鹤路20号'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='contact_number'; 
		//	type='string'; 
		//	value='028 87654321'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Warehouse.ID_PROPERTY)
			.field(Warehouse.LOCATION_PROPERTY).as("title")
			.field(Warehouse.CONTACT_NUMBER_PROPERTY).as("brief").with_prefix("联系电话: ")
			.field(Warehouse.TOTAL_AREA_PROPERTY)
			.field(Warehouse.OWNER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(Warehouse.LATITUDE_PROPERTY)
			.field(Warehouse.LONGITUDE_PROPERTY)
			.field(Warehouse.LAST_UPDATE_TIME_PROPERTY)
			.field(Warehouse.VERSION_PROPERTY)
		;
	}

	/** StorageSpace的ListOf时需要序列化的属性列表 */
	protected SerializeScope getStorageSpaceListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='location'; 
		//	type='string'; 
		//	value='成都龙泉驿飞鹤路20号存货区'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='contact_number'; 
		//	type='string'; 
		//	value='028 87654321'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(StorageSpace.ID_PROPERTY)
			.field(StorageSpace.LOCATION_PROPERTY).as("title")
			.field(StorageSpace.CONTACT_NUMBER_PROPERTY).as("brief").with_prefix("联系电话: ")
			.field(StorageSpace.TOTAL_AREA_PROPERTY)
			.field(StorageSpace.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
			.field(StorageSpace.LATITUDE_PROPERTY)
			.field(StorageSpace.LONGITUDE_PROPERTY)
			.field(StorageSpace.LAST_UPDATE_TIME_PROPERTY)
			.field(StorageSpace.VERSION_PROPERTY)
		;
	}

	/** SmartPallet的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSmartPalletListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='location'; 
		//	type='string'; 
		//	value='成都龙泉驿飞鹤路20号移动区域，比如过道，货运通道等'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='contact_number'; 
		//	type='string'; 
		//	value='028 87654321'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(SmartPallet.ID_PROPERTY)
			.field(SmartPallet.LOCATION_PROPERTY).as("title")
			.field(SmartPallet.CONTACT_NUMBER_PROPERTY).as("brief").with_prefix("联系电话: ")
			.field(SmartPallet.TOTAL_AREA_PROPERTY)
			.field(SmartPallet.LATITUDE_PROPERTY)
			.field(SmartPallet.LONGITUDE_PROPERTY)
			.field(SmartPallet.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
			.field(SmartPallet.LAST_UPDATE_TIME_PROPERTY)
			.field(SmartPallet.VERSION_PROPERTY)
		;
	}

	/** GoodsShelf的ListOf时需要序列化的属性列表 */
	protected SerializeScope getGoodsShelfListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='location'; 
		//	type='string'; 
		//	value='成都龙泉驿飞鹤路20号存货区货架'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(GoodsShelf.ID_PROPERTY)
			.field(GoodsShelf.LOCATION_PROPERTY).as("title")
			.field(GoodsShelf.STORAGE_SPACE_PROPERTY, getStorageSpaceSummaryScope())
			.field(GoodsShelf.SUPPLIER_SPACE_PROPERTY, getSupplierSpaceSummaryScope())
			.field(GoodsShelf.DAMAGE_SPACE_PROPERTY, getDamageSpaceSummaryScope())
			.field(GoodsShelf.LAST_UPDATE_TIME_PROPERTY)
			.field(GoodsShelf.VERSION_PROPERTY)
		;
	}

	/** GoodsShelfStockCount的ListOf时需要序列化的属性列表 */
	protected SerializeScope getGoodsShelfStockCountListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title'; 
		//	type='string'; 
		//	value='每日盘点|每周盘点|每月盘点|年终盘点'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='summary'; 
		//	type='string'; 
		//	value='使用先进的rfid技术，没有任何错误'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(GoodsShelfStockCount.ID_PROPERTY)
			.field(GoodsShelfStockCount.TITLE_PROPERTY).as("title")
			.field(GoodsShelfStockCount.COUNT_TIME_PROPERTY)
			.field(GoodsShelfStockCount.SUMMARY_PROPERTY).as("brief").with_prefix("概览: ")
			.field(GoodsShelfStockCount.SHELF_PROPERTY, getGoodsShelfSummaryScope())
			.field(GoodsShelfStockCount.VERSION_PROPERTY)
		;
	}

	/** StockCountIssueTrack的ListOf时需要序列化的属性列表 */
	protected SerializeScope getStockCountIssueTrackListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title'; 
		//	type='string'; 
		//	value='盘点差错'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='summary'; 
		//	type='string'; 
		//	value='发现错误已经修正完成'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(StockCountIssueTrack.ID_PROPERTY)
			.field(StockCountIssueTrack.TITLE_PROPERTY).as("title")
			.field(StockCountIssueTrack.COUNT_TIME_PROPERTY)
			.field(StockCountIssueTrack.SUMMARY_PROPERTY).as("brief").with_prefix("概览: ")
			.field(StockCountIssueTrack.STOCK_COUNT_PROPERTY, getGoodsShelfStockCountSummaryScope())
			.field(StockCountIssueTrack.VERSION_PROPERTY)
		;
	}

	/** GoodsAllocation的ListOf时需要序列化的属性列表 */
	protected SerializeScope getGoodsAllocationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='location'; 
		//	type='string'; 
		//	value='成都龙泉驿飞鹤路20号存货区货架20号货位'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='latitude'; 
		//	type='double'; 
		//	value='40.776877'; 
		//	required='true'; 
		//	features='{name=double}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(GoodsAllocation.ID_PROPERTY)
			.field(GoodsAllocation.LOCATION_PROPERTY).as("title")
			.field(GoodsAllocation.LATITUDE_PROPERTY).as("brief").with_prefix("纬度: ")
			.field(GoodsAllocation.LONGITUDE_PROPERTY)
			.field(GoodsAllocation.GOODS_SHELF_PROPERTY, getGoodsShelfSummaryScope())
			.field(GoodsAllocation.VERSION_PROPERTY)
		;
	}

	/** Goods的ListOf时需要序列化的属性列表 */
	protected SerializeScope getGoodsListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='可口可乐'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='max_package'; 
		//	type='int'; 
		//	value='10'; 
		//	required='true'; 
		//	features='{name=int}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Goods.ID_PROPERTY)
			.field(Goods.NAME_PROPERTY).as("title")
			.field(Goods.RFID_PROPERTY)
			.field(Goods.UOM_PROPERTY)
			.field(Goods.MAX_PACKAGE_PROPERTY).as("brief").with_prefix("最大包装: ")
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
			.field(Goods.VERSION_PROPERTY)
		;
	}

	/** GoodsMovement的ListOf时需要序列化的属性列表 */
	protected SerializeScope getGoodsMovementListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='facility'; 
		//	type='string'; 
		//	value='仓库货位|卡车|小超'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='user_agent'; 
		//	type='string'; 
		//	value='Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B405'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(GoodsMovement.ID_PROPERTY)
			.field(GoodsMovement.MOVE_TIME_PROPERTY)
			.field(GoodsMovement.FACILITY_PROPERTY).as("title")
			.field(GoodsMovement.FACILITY_ID_PROPERTY)
			.field(GoodsMovement.FROM_IP_PROPERTY)
			.field(GoodsMovement.USER_AGENT_PROPERTY).as("brief").with_prefix("用户代理: ")
			.field(GoodsMovement.SESSION_ID_PROPERTY)
			.field(GoodsMovement.LATITUDE_PROPERTY)
			.field(GoodsMovement.LONGITUDE_PROPERTY)
			.field(GoodsMovement.GOODS_PROPERTY, getGoodsSummaryScope())
			.field(GoodsMovement.VERSION_PROPERTY)
		;
	}

	/** SupplierSpace的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSupplierSpaceListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='location'; 
		//	type='string'; 
		//	value='成都龙泉驿飞鹤路20号供货商独立管理区'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='contact_number'; 
		//	type='string'; 
		//	value='028 87654321'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(SupplierSpace.ID_PROPERTY)
			.field(SupplierSpace.LOCATION_PROPERTY).as("title")
			.field(SupplierSpace.CONTACT_NUMBER_PROPERTY).as("brief").with_prefix("联系电话: ")
			.field(SupplierSpace.TOTAL_AREA_PROPERTY)
			.field(SupplierSpace.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
			.field(SupplierSpace.LATITUDE_PROPERTY)
			.field(SupplierSpace.LONGITUDE_PROPERTY)
			.field(SupplierSpace.LAST_UPDATE_TIME_PROPERTY)
			.field(SupplierSpace.VERSION_PROPERTY)
		;
	}

	/** ReceivingSpace的ListOf时需要序列化的属性列表 */
	protected SerializeScope getReceivingSpaceListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='location'; 
		//	type='string'; 
		//	value='成都龙泉驿飞鹤路20号仓库卸货区'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='每个收货区可以供一辆车卸货'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ReceivingSpace.ID_PROPERTY)
			.field(ReceivingSpace.LOCATION_PROPERTY).as("title")
			.field(ReceivingSpace.CONTACT_NUMBER_PROPERTY)
			.field(ReceivingSpace.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(ReceivingSpace.TOTAL_AREA_PROPERTY)
			.field(ReceivingSpace.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
			.field(ReceivingSpace.LATITUDE_PROPERTY)
			.field(ReceivingSpace.LONGITUDE_PROPERTY)
			.field(ReceivingSpace.LAST_UPDATE_TIME_PROPERTY)
			.field(ReceivingSpace.VERSION_PROPERTY)
		;
	}

	/** ShippingSpace的ListOf时需要序列化的属性列表 */
	protected SerializeScope getShippingSpaceListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='location'; 
		//	type='string'; 
		//	value='成都龙泉驿飞鹤路20号装货区'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='每个收货区可以供一辆车装货'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ShippingSpace.ID_PROPERTY)
			.field(ShippingSpace.LOCATION_PROPERTY).as("title")
			.field(ShippingSpace.CONTACT_NUMBER_PROPERTY)
			.field(ShippingSpace.TOTAL_AREA_PROPERTY)
			.field(ShippingSpace.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
			.field(ShippingSpace.LATITUDE_PROPERTY)
			.field(ShippingSpace.LONGITUDE_PROPERTY)
			.field(ShippingSpace.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(ShippingSpace.LAST_UPDATE_TIME_PROPERTY)
			.field(ShippingSpace.VERSION_PROPERTY)
		;
	}

	/** DamageSpace的ListOf时需要序列化的属性列表 */
	protected SerializeScope getDamageSpaceListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='location'; 
		//	type='string'; 
		//	value='成都龙泉驿飞鹤路20号仓库损坏货物堆放区'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='contact_number'; 
		//	type='string'; 
		//	value='028 87654321'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(DamageSpace.ID_PROPERTY)
			.field(DamageSpace.LOCATION_PROPERTY).as("title")
			.field(DamageSpace.CONTACT_NUMBER_PROPERTY).as("brief").with_prefix("联系电话: ")
			.field(DamageSpace.TOTAL_AREA_PROPERTY)
			.field(DamageSpace.LATITUDE_PROPERTY)
			.field(DamageSpace.LONGITUDE_PROPERTY)
			.field(DamageSpace.WAREHOUSE_PROPERTY, getWarehouseSummaryScope())
			.field(DamageSpace.LAST_UPDATE_TIME_PROPERTY)
			.field(DamageSpace.VERSION_PROPERTY)
		;
	}

	/** WarehouseAsset的ListOf时需要序列化的属性列表 */
	protected SerializeScope getWarehouseAssetListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='叉车|托盘|传送带备件'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='position'; 
		//	type='string'; 
		//	value='备用件存放区设备库房'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(WarehouseAsset.ID_PROPERTY)
			.field(WarehouseAsset.NAME_PROPERTY).as("title")
			.field(WarehouseAsset.POSITION_PROPERTY).as("brief").with_prefix("位置: ")
			.field(WarehouseAsset.OWNER_PROPERTY, getWarehouseSummaryScope())
			.field(WarehouseAsset.LAST_UPDATE_TIME_PROPERTY)
			.field(WarehouseAsset.VERSION_PROPERTY)
		;
	}

	/** TransportFleet的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTransportFleetListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='双链先锋号车队'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='contact_number'; 
		//	type='string'; 
		//	value='028 87654321'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(TransportFleet.ID_PROPERTY)
			.field(TransportFleet.NAME_PROPERTY).as("title")
			.field(TransportFleet.CONTACT_NUMBER_PROPERTY).as("brief").with_prefix("联系电话: ")
			.field(TransportFleet.OWNER_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(TransportFleet.LAST_UPDATE_TIME_PROPERTY)
			.field(TransportFleet.VERSION_PROPERTY)
		;
	}

	/** TransportTruck的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTransportTruckListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='运货卡车'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='plate_number'; 
		//	type='string'; 
		//	value='川AK5'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(TransportTruck.ID_PROPERTY)
			.field(TransportTruck.NAME_PROPERTY).as("title")
			.field(TransportTruck.PLATE_NUMBER_PROPERTY).as("brief").with_prefix("车牌号码: ")
			.field(TransportTruck.CONTACT_NUMBER_PROPERTY)
			.field(TransportTruck.VEHICLE_LICENSE_NUMBER_PROPERTY)
			.field(TransportTruck.ENGINE_NUMBER_PROPERTY)
			.field(TransportTruck.MAKE_DATE_PROPERTY)
			.field(TransportTruck.MILEAGE_PROPERTY)
			.field(TransportTruck.BODY_COLOR_PROPERTY)
			.field(TransportTruck.OWNER_PROPERTY, getTransportFleetSummaryScope())
			.field(TransportTruck.VERSION_PROPERTY)
		;
	}

	/** TruckDriver的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTruckDriverListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='运货卡车司机'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='driver_license_number'; 
		//	type='string'; 
		//	value='5109 9887 733'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(TruckDriver.ID_PROPERTY)
			.field(TruckDriver.NAME_PROPERTY).as("title")
			.field(TruckDriver.DRIVER_LICENSE_NUMBER_PROPERTY).as("brief").with_prefix("驾驶执照号码: ")
			.field(TruckDriver.CONTACT_NUMBER_PROPERTY)
			.field(TruckDriver.BELONGS_TO_PROPERTY, getTransportFleetSummaryScope())
			.field(TruckDriver.VERSION_PROPERTY)
		;
	}

	/** TransportTask的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTransportTaskListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='货运记录'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='start'; 
		//	type='string'; 
		//	value='双链二号仓'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(TransportTask.ID_PROPERTY)
			.field(TransportTask.NAME_PROPERTY).as("title")
			.field(TransportTask.START_PROPERTY).as("brief").with_prefix("开始: ")
			.field(TransportTask.BEGIN_TIME_PROPERTY)
			.field(TransportTask.END_PROPERTY, getRetailStoreSummaryScope())
			.field(TransportTask.DRIVER_PROPERTY, getTruckDriverSummaryScope())
			.field(TransportTask.TRUCK_PROPERTY, getTransportTruckSummaryScope())
			.field(TransportTask.BELONGS_TO_PROPERTY, getTransportFleetSummaryScope())
			.field(TransportTask.LATITUDE_PROPERTY)
			.field(TransportTask.LONGITUDE_PROPERTY)
			.field(TransportTask.VERSION_PROPERTY)
		;
	}

	/** TransportTaskTrack的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTransportTaskTrackListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='track_time'; 
		//	type='date_past'; 
		//	value='past()'; 
		//	required='true'; 
		//	features='{name=date_past, parent=date}';
		//}
		//, briefField=fieldesc{
		//	name='latitude'; 
		//	type='double'; 
		//	value='30.912929'; 
		//	required='true'; 
		//	features='{name=double}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(TransportTaskTrack.ID_PROPERTY)
			.field(TransportTaskTrack.TRACK_TIME_PROPERTY).as("title")
			.field(TransportTaskTrack.LATITUDE_PROPERTY).as("brief").with_prefix("纬度: ")
			.field(TransportTaskTrack.LONGITUDE_PROPERTY)
			.field(TransportTaskTrack.MOVEMENT_PROPERTY, getTransportTaskSummaryScope())
			.field(TransportTaskTrack.VERSION_PROPERTY)
		;
	}

	/** AccountSet的ListOf时需要序列化的属性列表 */
	protected SerializeScope getAccountSetListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='账套2017|账套2018|账套2019'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='year_set'; 
		//	type='string'; 
		//	value='2017年|2018年|2019年'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(AccountSet.ID_PROPERTY)
			.field(AccountSet.NAME_PROPERTY).as("title")
			.field(AccountSet.YEAR_SET_PROPERTY).as("brief").with_prefix("年组: ")
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
			.field(AccountSet.VERSION_PROPERTY)
		;
	}

	/** AccountingSubject的ListOf时需要序列化的属性列表 */
	protected SerializeScope getAccountingSubjectListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='accounting_subject_name'; 
		//	type='string'; 
		//	value='银行存款'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='accounting_subject_class_code'; 
		//	type='int'; 
		//	value='1|2|3|4|5|6'; 
		//	required='true'; 
		//	features='{name=int}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(AccountingSubject.ID_PROPERTY)
			.field(AccountingSubject.ACCOUNTING_SUBJECT_CODE_PROPERTY)
			.field(AccountingSubject.ACCOUNTING_SUBJECT_NAME_PROPERTY).as("title")
			.field(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY).as("brief").with_prefix("会计科目类别代码: ")
			.field(AccountingSubject.ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY)
			.field(AccountingSubject.ACCOUNT_SET_PROPERTY, getAccountSetSummaryScope())
			.field(AccountingSubject.VERSION_PROPERTY)
		;
	}

	/** AccountingPeriod的ListOf时需要序列化的属性列表 */
	protected SerializeScope getAccountingPeriodListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='2017年1月|2017年2月|2017年3月|2017年4月|2017年5月|2017年6月|2017年7月|2017年8月|2017年9月|2017年10月|2017年11月|2017年12月'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='start_date'; 
		//	type='date'; 
		//	value='2017-01-09'; 
		//	required='true'; 
		//	features='{name=date}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(AccountingPeriod.ID_PROPERTY)
			.field(AccountingPeriod.NAME_PROPERTY).as("title")
			.field(AccountingPeriod.START_DATE_PROPERTY).as("brief").with_prefix("开始日期: ")
			.field(AccountingPeriod.END_DATE_PROPERTY)
			.field(AccountingPeriod.ACCOUNT_SET_PROPERTY, getAccountSetSummaryScope())
			.field(AccountingPeriod.VERSION_PROPERTY)
		;
	}

	/** AccountingDocumentType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getAccountingDocumentTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='记账凭证|收款凭证|付款凭证'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(AccountingDocumentType.ID_PROPERTY)
			.field(AccountingDocumentType.NAME_PROPERTY).as("title")
			.field(AccountingDocumentType.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(AccountingDocumentType.ACCOUNTING_PERIOD_PROPERTY, getAccountSetSummaryScope())
			.field(AccountingDocumentType.VERSION_PROPERTY)
		;
	}

	/** AccountingDocument的ListOf时需要序列化的属性列表 */
	protected SerializeScope getAccountingDocumentListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='记账凭证'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='accounting_document_date'; 
		//	type='date'; 
		//	value='2018-09-09'; 
		//	required='true'; 
		//	features='{name=date}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(AccountingDocument.ID_PROPERTY)
			.field(AccountingDocument.NAME_PROPERTY).as("title")
			.field(AccountingDocument.ACCOUNTING_DOCUMENT_DATE_PROPERTY).as("brief").with_prefix("会计凭证日期: ")
			.field(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, getAccountingPeriodSummaryScope())
			.field(AccountingDocument.DOCUMENT_TYPE_PROPERTY, getAccountingDocumentTypeSummaryScope())
			.field(AccountingDocument.VERSION_PROPERTY)
		;
	}

	/** OriginalVoucher的ListOf时需要序列化的属性列表 */
	protected SerializeScope getOriginalVoucherListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title'; 
		//	type='string'; 
		//	value='这是手写的发票'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='made_by'; 
		//	type='string'; 
		//	value='李亚青'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=fieldesc{
		//	name='voucher_image'; 
		//	type='string_image'; 
		//	value='goodthing.jpg'; 
		//	required='true'; 
		//	features='{name=string_image, features=attachment}';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(OriginalVoucher.ID_PROPERTY)
			.field(OriginalVoucher.TITLE_PROPERTY).as("title")
			.field(OriginalVoucher.MADE_BY_PROPERTY).as("brief").with_prefix("由: ")
			.field(OriginalVoucher.RECEIVED_BY_PROPERTY)
			.field(OriginalVoucher.VOUCHER_TYPE_PROPERTY)
			.field(OriginalVoucher.VOUCHER_IMAGE_PROPERTY).as("imageUrl")
			.field(OriginalVoucher.BELONGS_TO_PROPERTY, getAccountingDocumentSummaryScope())
			.field(OriginalVoucher.VERSION_PROPERTY)
		;
	}

	/** AccountingDocumentLine的ListOf时需要序列化的属性列表 */
	protected SerializeScope getAccountingDocumentLineListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='收到存款'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='amount'; 
		//	type='money'; 
		//	value='$989127.99'; 
		//	required='true'; 
		//	features='{name=money}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(AccountingDocumentLine.ID_PROPERTY)
			.field(AccountingDocumentLine.NAME_PROPERTY).as("title")
			.field(AccountingDocumentLine.CODE_PROPERTY)
			.field(AccountingDocumentLine.DIRECT_PROPERTY)
			.field(AccountingDocumentLine.AMOUNT_PROPERTY).as("brief").with_prefix("金额: ")
			.field(AccountingDocumentLine.BELONGS_TO_PROPERTY, getAccountingDocumentSummaryScope())
			.field(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY, getAccountingSubjectSummaryScope())
			.field(AccountingDocumentLine.VERSION_PROPERTY)
		;
	}

	/** LevelOneDepartment的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLevelOneDepartmentListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='供应链部|采购部|管理部|财务部|信息技术部|法务部|市场部|人力资源部'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='主要执行集团信息系统建设，维护，规划'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(LevelOneDepartment.ID_PROPERTY)
			.field(LevelOneDepartment.BELONGS_TO_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(LevelOneDepartment.NAME_PROPERTY).as("title")
			.field(LevelOneDepartment.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(LevelOneDepartment.MANAGER_PROPERTY)
			.field(LevelOneDepartment.FOUNDED_PROPERTY)
			.field(LevelOneDepartment.VERSION_PROPERTY)
		;
	}

	/** LevelTwoDepartment的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLevelTwoDepartmentListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='信息系统部大数据部门'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='主要执行集团信息系统建设，维护，规划'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(LevelTwoDepartment.ID_PROPERTY)
			.field(LevelTwoDepartment.BELONGS_TO_PROPERTY, getLevelOneDepartmentSummaryScope())
			.field(LevelTwoDepartment.NAME_PROPERTY).as("title")
			.field(LevelTwoDepartment.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(LevelTwoDepartment.FOUNDED_PROPERTY)
			.field(LevelTwoDepartment.VERSION_PROPERTY)
		;
	}

	/** LevelThreeDepartment的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLevelThreeDepartmentListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='信息系统部大数据清洗组|信息系统部大数据运算组|信息系统部大数据解决方案组'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='主要执行集团信息系统建设，维护，规划'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(LevelThreeDepartment.ID_PROPERTY)
			.field(LevelThreeDepartment.BELONGS_TO_PROPERTY, getLevelTwoDepartmentSummaryScope())
			.field(LevelThreeDepartment.NAME_PROPERTY).as("title")
			.field(LevelThreeDepartment.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(LevelThreeDepartment.FOUNDED_PROPERTY)
			.field(LevelThreeDepartment.VERSION_PROPERTY)
		;
	}

	/** SkillType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSkillTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='code'; 
		//	type='string'; 
		//	value='S0000'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='JAVA编程|大数据|并行计算|操作系统|数据库'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(SkillType.ID_PROPERTY)
			.field(SkillType.CODE_PROPERTY).as("title")
			.field(SkillType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(SkillType.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(SkillType.VERSION_PROPERTY)
		;
	}

	/** ResponsibilityType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getResponsibilityTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='code'; 
		//	type='string'; 
		//	value='S0000'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='base_description'; 
		//	type='string'; 
		//	value='合规管理|财务管理|总务管理|信息管理|库存管理|市场管理|产品管理|采购管理|资产管理|销售管理|安全管理'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ResponsibilityType.ID_PROPERTY)
			.field(ResponsibilityType.CODE_PROPERTY).as("title")
			.field(ResponsibilityType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(ResponsibilityType.BASE_DESCRIPTION_PROPERTY).as("brief").with_prefix("基本描述: ")
			.field(ResponsibilityType.DETAIL_DESCRIPTION_PROPERTY)
			.field(ResponsibilityType.VERSION_PROPERTY)
		;
	}

	/** TerminationReason的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTerminationReasonListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='code'; 
		//	type='string'; 
		//	value='ETR0000'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='业务发展，公司转型|战略调整|业务优化'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(TerminationReason.ID_PROPERTY)
			.field(TerminationReason.CODE_PROPERTY).as("title")
			.field(TerminationReason.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(TerminationReason.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(TerminationReason.VERSION_PROPERTY)
		;
	}

	/** TerminationType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTerminationTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='code'; 
		//	type='string'; 
		//	value='ETT0000'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='base_description'; 
		//	type='string'; 
		//	value='合同解除|辞职|退休'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(TerminationType.ID_PROPERTY)
			.field(TerminationType.CODE_PROPERTY).as("title")
			.field(TerminationType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(TerminationType.BASE_DESCRIPTION_PROPERTY).as("brief").with_prefix("基本描述: ")
			.field(TerminationType.DETAIL_DESCRIPTION_PROPERTY)
			.field(TerminationType.VERSION_PROPERTY)
		;
	}

	/** OccupationType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getOccupationTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='code'; 
		//	type='string'; 
		//	value='OT0000'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='需求分析员|软件工程师|高级软件工程师|财务分析师|财务主管|出纳|总经理|副总经历|大数据架构师|销售经理|销售总监|技术总监|区域销售经理'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(OccupationType.ID_PROPERTY)
			.field(OccupationType.CODE_PROPERTY).as("title")
			.field(OccupationType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(OccupationType.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(OccupationType.DETAIL_DESCRIPTION_PROPERTY)
			.field(OccupationType.VERSION_PROPERTY)
		;
	}

	/** LeaveType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLeaveTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='code'; 
		//	type='string'; 
		//	value='LT0000'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='带薪年假|病假|事假|婚假|产假|陪产假|丧假|探亲假|哺乳假|待产假|陪待产假'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(LeaveType.ID_PROPERTY)
			.field(LeaveType.CODE_PROPERTY).as("title")
			.field(LeaveType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(LeaveType.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(LeaveType.DETAIL_DESCRIPTION_PROPERTY)
			.field(LeaveType.VERSION_PROPERTY)
		;
	}

	/** SalaryGrade的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSalaryGradeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='一级薪资|二级薪资|三级薪资|四级薪资|五级薪资|六级薪资|七级薪资'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='detail_description'; 
		//	type='string'; 
		//	value='故事还得从遥远的古代开始.................................................'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(SalaryGrade.ID_PROPERTY)
			.field(SalaryGrade.CODE_PROPERTY)
			.field(SalaryGrade.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(SalaryGrade.NAME_PROPERTY).as("title")
			.field(SalaryGrade.DETAIL_DESCRIPTION_PROPERTY).as("brief").with_prefix("详细描述: ")
			.field(SalaryGrade.VERSION_PROPERTY)
		;
	}

	/** InterviewType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getInterviewTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='code'; 
		//	type='string'; 
		//	value='INTRVW00'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='特别情况面试|离职面试|信息面试|入职面试'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(InterviewType.ID_PROPERTY)
			.field(InterviewType.CODE_PROPERTY).as("title")
			.field(InterviewType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(InterviewType.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(InterviewType.DETAIL_DESCRIPTION_PROPERTY)
			.field(InterviewType.VERSION_PROPERTY)
		;
	}

	/** TrainingCourseType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTrainingCourseTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='入职培训|售前培训|技术培训|管理培训|外训'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='培训是提升个人和企业竞争力的法宝'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(TrainingCourseType.ID_PROPERTY)
			.field(TrainingCourseType.CODE_PROPERTY)
			.field(TrainingCourseType.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(TrainingCourseType.NAME_PROPERTY).as("title")
			.field(TrainingCourseType.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(TrainingCourseType.VERSION_PROPERTY)
		;
	}

	/** PublicHoliday的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPublicHolidayListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='元旦节|春节|妇女节|清明节|端午节|暑假|国庆节|中秋节'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='节日快乐，万事如意！'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(PublicHoliday.ID_PROPERTY)
			.field(PublicHoliday.CODE_PROPERTY)
			.field(PublicHoliday.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(PublicHoliday.NAME_PROPERTY).as("title")
			.field(PublicHoliday.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(PublicHoliday.VERSION_PROPERTY)
		;
	}

	/** Termination的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTerminationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='comment'; 
		//	type='string'; 
		//	value='员工离职'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Termination.ID_PROPERTY)
			.field(Termination.REASON_PROPERTY, getTerminationReasonSummaryScope())
			.field(Termination.TYPE_PROPERTY, getTerminationTypeSummaryScope())
			.field(Termination.COMMENT_PROPERTY).as("title")
			.field(Termination.VERSION_PROPERTY)
		;
	}

	/** View的ListOf时需要序列化的属性列表 */
	protected SerializeScope getViewListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who'; 
		//	type='string'; 
		//	value='面试官'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='assessment'; 
		//	type='string'; 
		//	value='小伙子不错，值得培养'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(View.ID_PROPERTY)
			.field(View.WHO_PROPERTY).as("title")
			.field(View.ASSESSMENT_PROPERTY).as("brief").with_prefix("评估: ")
			.field(View.INTERVIEW_TIME_PROPERTY)
			.field(View.VERSION_PROPERTY)
		;
	}

	/** Employee的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title'; 
		//	type='string'; 
		//	value='程序员'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='family_name'; 
		//	type='string'; 
		//	value='张|王|李|贺'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Employee.ID_PROPERTY)
			.field(Employee.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(Employee.TITLE_PROPERTY).as("title")
			.field(Employee.DEPARTMENT_PROPERTY, getLevelThreeDepartmentSummaryScope())
			.field(Employee.FAMILY_NAME_PROPERTY).as("brief").with_prefix("姓: ")
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
			.field(Employee.VERSION_PROPERTY)
		;
	}

	/** Instructor的ListOf时需要序列化的属性列表 */
	protected SerializeScope getInstructorListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title'; 
		//	type='string'; 
		//	value='高级讲师'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='family_name'; 
		//	type='string'; 
		//	value='张|王|李|贺'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Instructor.ID_PROPERTY)
			.field(Instructor.TITLE_PROPERTY).as("title")
			.field(Instructor.FAMILY_NAME_PROPERTY).as("brief").with_prefix("姓: ")
			.field(Instructor.GIVEN_NAME_PROPERTY)
			.field(Instructor.CELL_PHONE_PROPERTY)
			.field(Instructor.EMAIL_PROPERTY)
			.field(Instructor.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(Instructor.INTRODUCTION_PROPERTY)
			.field(Instructor.LAST_UPDATE_TIME_PROPERTY)
			.field(Instructor.VERSION_PROPERTY)
		;
	}

	/** CompanyTraining的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCompanyTrainingListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title'; 
		//	type='string'; 
		//	value='入职培训'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='duration_hours'; 
		//	type='int'; 
		//	value='3'; 
		//	required='true'; 
		//	features='{name=int}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(CompanyTraining.ID_PROPERTY)
			.field(CompanyTraining.TITLE_PROPERTY).as("title")
			.field(CompanyTraining.COMPANY_PROPERTY, getRetailStoreCountryCenterSummaryScope())
			.field(CompanyTraining.INSTRUCTOR_PROPERTY, getInstructorSummaryScope())
			.field(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, getTrainingCourseTypeSummaryScope())
			.field(CompanyTraining.TIME_START_PROPERTY)
			.field(CompanyTraining.DURATION_HOURS_PROPERTY).as("brief").with_prefix("持续时间: ")
			.field(CompanyTraining.LAST_UPDATE_TIME_PROPERTY)
			.field(CompanyTraining.VERSION_PROPERTY)
		;
	}

	/** Scoring的ListOf时需要序列化的属性列表 */
	protected SerializeScope getScoringListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='scored_by'; 
		//	type='string'; 
		//	value='王志文'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='score'; 
		//	type='int'; 
		//	value='100'; 
		//	required='true'; 
		//	features='{name=int}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Scoring.ID_PROPERTY)
			.field(Scoring.SCORED_BY_PROPERTY).as("title")
			.field(Scoring.SCORE_PROPERTY).as("brief").with_prefix("分数: ")
			.field(Scoring.COMMENT_PROPERTY)
			.field(Scoring.VERSION_PROPERTY)
		;
	}

	/** EmployeeCompanyTraining的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeCompanyTrainingListOfViewScope() {
		// DisplayMode{name='auto', titleField=null, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeeCompanyTraining.ID_PROPERTY)
			.field(EmployeeCompanyTraining.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeeCompanyTraining.TRAINING_PROPERTY, getCompanyTrainingSummaryScope())
			.field(EmployeeCompanyTraining.SCORING_PROPERTY, getScoringSummaryScope())
			.field(EmployeeCompanyTraining.VERSION_PROPERTY)
		;
	}

	/** EmployeeSkill的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeSkillListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='高手高手高高手'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeeSkill.ID_PROPERTY)
			.field(EmployeeSkill.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeeSkill.SKILL_TYPE_PROPERTY, getSkillTypeSummaryScope())
			.field(EmployeeSkill.DESCRIPTION_PROPERTY).as("title")
			.field(EmployeeSkill.VERSION_PROPERTY)
		;
	}

	/** EmployeePerformance的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeePerformanceListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='performance_comment'; 
		//	type='string'; 
		//	value='绩效大大的不错'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeePerformance.ID_PROPERTY)
			.field(EmployeePerformance.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeePerformance.PERFORMANCE_COMMENT_PROPERTY).as("title")
			.field(EmployeePerformance.VERSION_PROPERTY)
		;
	}

	/** EmployeeWorkExperience的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeWorkExperienceListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='company'; 
		//	type='string'; 
		//	value='丝芙兰化妆品公司'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='在此期间取得非常好的绩效，赢得了客户的信赖'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeeWorkExperience.ID_PROPERTY)
			.field(EmployeeWorkExperience.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeeWorkExperience.START_PROPERTY)
			.field(EmployeeWorkExperience.END_PROPERTY)
			.field(EmployeeWorkExperience.COMPANY_PROPERTY).as("title")
			.field(EmployeeWorkExperience.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(EmployeeWorkExperience.VERSION_PROPERTY)
		;
	}

	/** EmployeeLeave的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeLeaveListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='remark'; 
		//	type='string'; 
		//	value='请年假，出去耍！！！！'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='leave_duration_hour'; 
		//	type='int'; 
		//	value='8'; 
		//	required='true'; 
		//	features='{name=int}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeeLeave.ID_PROPERTY)
			.field(EmployeeLeave.WHO_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeeLeave.TYPE_PROPERTY, getLeaveTypeSummaryScope())
			.field(EmployeeLeave.LEAVE_DURATION_HOUR_PROPERTY).as("brief").with_prefix("请假时长: ")
			.field(EmployeeLeave.REMARK_PROPERTY).as("title")
			.field(EmployeeLeave.VERSION_PROPERTY)
		;
	}

	/** EmployeeInterview的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeInterviewListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='remark'; 
		//	type='string'; 
		//	value='结果不错，面试通过！'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeeInterview.ID_PROPERTY)
			.field(EmployeeInterview.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeeInterview.INTERVIEW_TYPE_PROPERTY, getInterviewTypeSummaryScope())
			.field(EmployeeInterview.REMARK_PROPERTY).as("title")
			.field(EmployeeInterview.VERSION_PROPERTY)
		;
	}

	/** EmployeeAttendance的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeAttendanceListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='remark'; 
		//	type='string'; 
		//	value='今天状态不错啊'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='duration_hours'; 
		//	type='int'; 
		//	value='8'; 
		//	required='true'; 
		//	features='{name=int}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeeAttendance.ID_PROPERTY)
			.field(EmployeeAttendance.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeeAttendance.ENTER_TIME_PROPERTY)
			.field(EmployeeAttendance.LEAVE_TIME_PROPERTY)
			.field(EmployeeAttendance.DURATION_HOURS_PROPERTY).as("brief").with_prefix("持续时间: ")
			.field(EmployeeAttendance.REMARK_PROPERTY).as("title")
			.field(EmployeeAttendance.VERSION_PROPERTY)
		;
	}

	/** EmployeeQualifier的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeQualifierListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='type'; 
		//	type='string'; 
		//	value='认证药剂师|认证架构师|认证会计师|认证经济师|OCP|CCNA|CCNP'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='level'; 
		//	type='string'; 
		//	value='高级|中级|初级'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeeQualifier.ID_PROPERTY)
			.field(EmployeeQualifier.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeeQualifier.QUALIFIED_TIME_PROPERTY)
			.field(EmployeeQualifier.TYPE_PROPERTY).as("title")
			.field(EmployeeQualifier.LEVEL_PROPERTY).as("brief").with_prefix("水平: ")
			.field(EmployeeQualifier.REMARK_PROPERTY)
			.field(EmployeeQualifier.VERSION_PROPERTY)
		;
	}

	/** EmployeeEducation的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeEducationListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='type'; 
		//	type='string'; 
		//	value='小学|初中|高中|大学|硕士|博士|职业教育'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='remark'; 
		//	type='string'; 
		//	value='考试成绩当年第一名'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeeEducation.ID_PROPERTY)
			.field(EmployeeEducation.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeeEducation.COMPLETE_TIME_PROPERTY)
			.field(EmployeeEducation.TYPE_PROPERTY).as("title")
			.field(EmployeeEducation.REMARK_PROPERTY).as("brief").with_prefix("备注: ")
			.field(EmployeeEducation.VERSION_PROPERTY)
		;
	}

	/** EmployeeAward的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeAwardListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='type'; 
		//	type='string'; 
		//	value='明星员工|销售之星|技术之星|管理之星|终身成就奖'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='remark'; 
		//	type='string'; 
		//	value='考试成绩当年第一名'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeeAward.ID_PROPERTY)
			.field(EmployeeAward.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeeAward.COMPLETE_TIME_PROPERTY)
			.field(EmployeeAward.TYPE_PROPERTY).as("title")
			.field(EmployeeAward.REMARK_PROPERTY).as("brief").with_prefix("备注: ")
			.field(EmployeeAward.VERSION_PROPERTY)
		;
	}

	/** EmployeeSalarySheet的ListOf时需要序列化的属性列表 */
	protected SerializeScope getEmployeeSalarySheetListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='base_salary'; 
		//	type='money'; 
		//	value='$3000.10'; 
		//	required='true'; 
		//	features='{name=money}';
		//}
		//, briefField=fieldesc{
		//	name='bonus'; 
		//	type='money'; 
		//	value='$1000.10'; 
		//	required='true'; 
		//	features='{name=money}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(EmployeeSalarySheet.ID_PROPERTY)
			.field(EmployeeSalarySheet.EMPLOYEE_PROPERTY, getEmployeeSummaryScope())
			.field(EmployeeSalarySheet.CURRENT_SALARY_GRADE_PROPERTY, getSalaryGradeSummaryScope())
			.field(EmployeeSalarySheet.BASE_SALARY_PROPERTY).as("title")
			.field(EmployeeSalarySheet.BONUS_PROPERTY).as("brief").with_prefix("奖金: ")
			.field(EmployeeSalarySheet.REWARD_PROPERTY)
			.field(EmployeeSalarySheet.PERSONAL_TAX_PROPERTY)
			.field(EmployeeSalarySheet.SOCIAL_SECURITY_PROPERTY)
			.field(EmployeeSalarySheet.HOUSING_FOUND_PROPERTY)
			.field(EmployeeSalarySheet.JOB_INSURANCE_PROPERTY)
			.field(EmployeeSalarySheet.PAYING_OFF_PROPERTY, getPayingOffSummaryScope())
			.field(EmployeeSalarySheet.VERSION_PROPERTY)
		;
	}

	/** PayingOff的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPayingOffListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='who'; 
		//	type='string'; 
		//	value='出纳'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='amount'; 
		//	type='money'; 
		//	value='$5223.88'; 
		//	required='true'; 
		//	features='{name=money}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(PayingOff.ID_PROPERTY)
			.field(PayingOff.WHO_PROPERTY).as("title")
			.field(PayingOff.PAID_FOR_PROPERTY, getEmployeeSummaryScope())
			.field(PayingOff.PAID_TIME_PROPERTY)
			.field(PayingOff.AMOUNT_PROPERTY).as("brief").with_prefix("金额: ")
			.field(PayingOff.VERSION_PROPERTY)
		;
	}

	/** MobileApp的ListOf时需要序列化的属性列表 */
	protected SerializeScope getMobileAppListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='移动端配置'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(MobileApp.ID_PROPERTY)
			.field(MobileApp.NAME_PROPERTY).as("title")
			.field(MobileApp.VERSION_PROPERTY)
		;
	}

	/** Page的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPageListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='page_title'; 
		//	type='string'; 
		//	value='首页'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='display_order'; 
		//	type='int'; 
		//	value='1|2|3'; 
		//	required='true'; 
		//	features='{name=int}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Page.ID_PROPERTY)
			.field(Page.PAGE_TITLE_PROPERTY).as("title")
			.field(Page.LINK_TO_URL_PROPERTY)
			.field(Page.PAGE_TYPE_PROPERTY, getPageTypeSummaryScope())
			.field(Page.DISPLAY_ORDER_PROPERTY).as("brief").with_prefix("顺序: ")
			.field(Page.MOBILE_APP_PROPERTY, getMobileAppSummaryScope())
			.field(Page.VERSION_PROPERTY)
		;
	}

	/** PageType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPageTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='首页|我的|Generic Page|Listof Page|功能大厅|普通'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='code'; 
		//	type='string'; 
		//	value='home|me|generic-page|listof-page|service-center|simple'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(PageType.ID_PROPERTY)
			.field(PageType.NAME_PROPERTY).as("title")
			.field(PageType.CODE_PROPERTY).as("brief").with_prefix("代码: ")
			.field(PageType.MOBILE_APP_PROPERTY, getMobileAppSummaryScope())
			.field(PageType.FOOTER_TAB_PROPERTY)
			.field(PageType.VERSION_PROPERTY)
		;
	}

	/** Slide的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSlideListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='首页Focus的内容'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='display_order'; 
		//	type='int'; 
		//	value='1|2|3'; 
		//	required='true'; 
		//	features='{name=int}';
		//}
		//, imageUrlField=fieldesc{
		//	name='image_url'; 
		//	type='string_image'; 
		//	value='https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg'; 
		//	required='true'; 
		//	features='{name=string_image, features=attachment}';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Slide.ID_PROPERTY)
			.field(Slide.NAME_PROPERTY).as("title")
			.field(Slide.DISPLAY_ORDER_PROPERTY).as("brief").with_prefix("顺序: ")
			.field(Slide.IMAGE_URL_PROPERTY).as("imageUrl")
			.field(Slide.VIDEO_URL_PROPERTY)
			.field(Slide.LINK_TO_URL_PROPERTY)
			.field(Slide.PAGE_PROPERTY, getPageSummaryScope())
			.field(Slide.VERSION_PROPERTY)
		;
	}

	/** UiAction的ListOf时需要序列化的属性列表 */
	protected SerializeScope getUiActionListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title'; 
		//	type='string'; 
		//	value='提交|分享|查看|更多'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='brief'; 
		//	type='string'; 
		//	value='Submit|Share|View|View More'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=fieldesc{
		//	name='image_url'; 
		//	type='string_image'; 
		//	value='https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_1.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_2.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_3.jpg|https://xubai-test.oss-cn-beijing.aliyuncs.com/app/test/slide_4.jpg'; 
		//	required='true'; 
		//	features='{name=string_image, features=attachment}';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(UiAction.ID_PROPERTY)
			.field(UiAction.CODE_PROPERTY)
			.field(UiAction.ICON_PROPERTY)
			.field(UiAction.TITLE_PROPERTY).as("title")
			.field(UiAction.DISPLAY_ORDER_PROPERTY)
			.field(UiAction.BRIEF_PROPERTY).as("brief").with_prefix("短暂的: ")
			.field(UiAction.IMAGE_URL_PROPERTY).as("imageUrl")
			.field(UiAction.LINK_TO_URL_PROPERTY)
			.field(UiAction.EXTRA_DATA_PROPERTY)
			.field(UiAction.PAGE_PROPERTY, getPageSummaryScope())
			.field(UiAction.VERSION_PROPERTY)
		;
	}

	/** Section的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSectionListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title'; 
		//	type='string'; 
		//	value='文章|作品'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='brief'; 
		//	type='string'; 
		//	value='Article|Artwork'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=fieldesc{
		//	name='icon'; 
		//	type='string_image'; 
		//	value='icon.jpg'; 
		//	required='true'; 
		//	features='{name=string_image, features=attachment}';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(Section.ID_PROPERTY)
			.field(Section.TITLE_PROPERTY).as("title")
			.field(Section.BRIEF_PROPERTY).as("brief").with_prefix("短暂的: ")
			.field(Section.ICON_PROPERTY).as("imageUrl")
			.field(Section.DISPLAY_ORDER_PROPERTY)
			.field(Section.VIEW_GROUP_PROPERTY)
			.field(Section.LINK_TO_URL_PROPERTY)
			.field(Section.PAGE_PROPERTY, getPageSummaryScope())
			.field(Section.VERSION_PROPERTY)
		;
	}

	/** UserDomain的ListOf时需要序列化的属性列表 */
	protected SerializeScope getUserDomainListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='用户区域'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(UserDomain.ID_PROPERTY)
			.field(UserDomain.NAME_PROPERTY).as("title")
			.field(UserDomain.VERSION_PROPERTY)
		;
	}

	/** UserAllowList的ListOf时需要序列化的属性列表 */
	protected SerializeScope getUserAllowListListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='user_identity'; 
		//	type='string'; 
		//	value='clariones|13808188512'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='user_special_functions'; 
		//	type='string'; 
		//	value='tester;ios-spokesperson'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(UserAllowList.ID_PROPERTY)
			.field(UserAllowList.USER_IDENTITY_PROPERTY).as("title")
			.field(UserAllowList.USER_SPECIAL_FUNCTIONS_PROPERTY).as("brief").with_prefix("用户特殊功能: ")
			.field(UserAllowList.DOMAIN_PROPERTY, getUserDomainSummaryScope())
			.field(UserAllowList.VERSION_PROPERTY)
		;
	}

	/** SecUser的ListOf时需要序列化的属性列表 */
	protected SerializeScope getSecUserListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='login'; 
		//	type='string'; 
		//	value='login'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='verification_code'; 
		//	type='int'; 
		//	value='0|9999999'; 
		//	required='true'; 
		//	features='{name=int}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(SecUser.ID_PROPERTY)
			.field(SecUser.LOGIN_PROPERTY).as("title")
			.field(SecUser.MOBILE_PROPERTY)
			.field(SecUser.EMAIL_PROPERTY)
			.field(SecUser.PWD_PROPERTY)
			.field(SecUser.WEIXIN_OPENID_PROPERTY)
			.field(SecUser.WEIXIN_APPID_PROPERTY)
			.field(SecUser.ACCESS_TOKEN_PROPERTY)
			.field(SecUser.VERIFICATION_CODE_PROPERTY).as("brief").with_prefix("验证码: ")
			.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
			.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
			.field(SecUser.DOMAIN_PROPERTY, getUserDomainSummaryScope())
			.field(SecUser.VERSION_PROPERTY)
		;
	}

	/** UserApp的ListOf时需要序列化的属性列表 */
	protected SerializeScope getUserAppListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='title'; 
		//	type='string'; 
		//	value='审车平台|账户管理|接车公司|审车公司|维修公司|顾客'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='app_icon'; 
		//	type='string'; 
		//	value='users|bank|wechat|bar-chart|user|users'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(UserApp.ID_PROPERTY)
			.field(UserApp.TITLE_PROPERTY).as("title")
			.field(UserApp.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(UserApp.APP_ICON_PROPERTY).as("brief").with_prefix("应用程序图标: ")
			.field(UserApp.FULL_ACCESS_PROPERTY)
			.field(UserApp.PERMISSION_PROPERTY)
			.field(UserApp.OBJECT_TYPE_PROPERTY)
			.field(UserApp.OBJECT_ID_PROPERTY)
			.field(UserApp.LOCATION_PROPERTY)
			.field(UserApp.VERSION_PROPERTY)
		;
	}

	/** QuickLink的ListOf时需要序列化的属性列表 */
	protected SerializeScope getQuickLinkListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='列表'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='icon'; 
		//	type='string'; 
		//	value='facebook|google'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=fieldesc{
		//	name='image_path'; 
		//	type='string_image'; 
		//	value='y-200-200-red.jpg'; 
		//	required='true'; 
		//	features='{name=string_image, features=attachment}';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(QuickLink.ID_PROPERTY)
			.field(QuickLink.NAME_PROPERTY).as("title")
			.field(QuickLink.ICON_PROPERTY).as("brief").with_prefix("图标: ")
			.field(QuickLink.IMAGE_PATH_PROPERTY).as("imageUrl")
			.field(QuickLink.LINK_TARGET_PROPERTY)
			.field(QuickLink.CREATE_TIME_PROPERTY)
			.field(QuickLink.APP_PROPERTY, getUserAppSummaryScope())
			.field(QuickLink.VERSION_PROPERTY)
		;
	}

	/** ListAccess的ListOf时需要序列化的属性列表 */
	protected SerializeScope getListAccessListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='列表'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='internal_name'; 
		//	type='string'; 
		//	value='levelOneCategoryList'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(ListAccess.ID_PROPERTY)
			.field(ListAccess.NAME_PROPERTY).as("title")
			.field(ListAccess.INTERNAL_NAME_PROPERTY).as("brief").with_prefix("内部名称: ")
			.field(ListAccess.READ_PERMISSION_PROPERTY)
			.field(ListAccess.CREATE_PERMISSION_PROPERTY)
			.field(ListAccess.DELETE_PERMISSION_PROPERTY)
			.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
			.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
			.field(ListAccess.APP_PROPERTY, getUserAppSummaryScope())
			.field(ListAccess.VERSION_PROPERTY)
		;
	}

	/** LoginHistory的ListOf时需要序列化的属性列表 */
	protected SerializeScope getLoginHistoryListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='from_ip'; 
		//	type='string'; 
		//	value='192.168.1.1|192.168.1.2'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='description'; 
		//	type='string'; 
		//	value='登陆成功'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(LoginHistory.ID_PROPERTY)
			.field(LoginHistory.LOGIN_TIME_PROPERTY)
			.field(LoginHistory.FROM_IP_PROPERTY).as("title")
			.field(LoginHistory.DESCRIPTION_PROPERTY).as("brief").with_prefix("描述: ")
			.field(LoginHistory.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(LoginHistory.VERSION_PROPERTY)
		;
	}

	/** CandidateContainer的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCandidateContainerListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='我只是一个容器'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(CandidateContainer.ID_PROPERTY)
			.field(CandidateContainer.NAME_PROPERTY).as("title")
			.field(CandidateContainer.VERSION_PROPERTY)
		;
	}

	/** CandidateElement的ListOf时需要序列化的属性列表 */
	protected SerializeScope getCandidateElementListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='搜索到的匹配字段'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='type'; 
		//	type='string'; 
		//	value='类型描述'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=fieldesc{
		//	name='image'; 
		//	type='string_image'; 
		//	value='1.jpg'; 
		//	required='true'; 
		//	features='{name=string_image, features=attachment}';
		//}
		//, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(CandidateElement.ID_PROPERTY)
			.field(CandidateElement.NAME_PROPERTY).as("title")
			.field(CandidateElement.TYPE_PROPERTY).as("brief").with_prefix("类型: ")
			.field(CandidateElement.IMAGE_PROPERTY).as("imageUrl")
			.field(CandidateElement.CONTAINER_PROPERTY, getCandidateContainerSummaryScope())
			.field(CandidateElement.VERSION_PROPERTY)
		;
	}

	/** WechatWorkappIdentity的ListOf时需要序列化的属性列表 */
	protected SerializeScope getWechatWorkappIdentityListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='corp_id'; 
		//	type='string'; 
		//	value='corporation123'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='user_id'; 
		//	type='string'; 
		//	value='user123'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(WechatWorkappIdentity.ID_PROPERTY)
			.field(WechatWorkappIdentity.CORP_ID_PROPERTY).as("title")
			.field(WechatWorkappIdentity.USER_ID_PROPERTY).as("brief").with_prefix("用户Id: ")
			.field(WechatWorkappIdentity.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(WechatWorkappIdentity.CREATE_TIME_PROPERTY)
			.field(WechatWorkappIdentity.LAST_LOGIN_TIME_PROPERTY)
			.field(WechatWorkappIdentity.VERSION_PROPERTY)
		;
	}

	/** WechatMiniappIdentity的ListOf时需要序列化的属性列表 */
	protected SerializeScope getWechatMiniappIdentityListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='open_id'; 
		//	type='string'; 
		//	value='wechat_open_id_1234567890'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='app_id'; 
		//	type='string'; 
		//	value='wechat_miniapp_id_1234567890'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(WechatMiniappIdentity.ID_PROPERTY)
			.field(WechatMiniappIdentity.OPEN_ID_PROPERTY).as("title")
			.field(WechatMiniappIdentity.APP_ID_PROPERTY).as("brief").with_prefix("应用程序Id: ")
			.field(WechatMiniappIdentity.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(WechatMiniappIdentity.CREATE_TIME_PROPERTY)
			.field(WechatMiniappIdentity.LAST_LOGIN_TIME_PROPERTY)
			.field(WechatMiniappIdentity.VERSION_PROPERTY)
		;
	}

	/** KeypairIdentity的ListOf时需要序列化的属性列表 */
	protected SerializeScope getKeypairIdentityListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='public_key'; 
		//	type='string_longtext'; 
		//	value='text()'; 
		//	required='true'; 
		//	features='{name=text, features=longtext, type=string_longtext, parent=string_longtext}';
		//}
		//, briefField=null, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(KeypairIdentity.ID_PROPERTY)
			.field(KeypairIdentity.PUBLIC_KEY_PROPERTY).as("title")
			.field(KeypairIdentity.KEY_TYPE_PROPERTY, getPublicKeyTypeSummaryScope())
			.field(KeypairIdentity.SEC_USER_PROPERTY, getSecUserSummaryScope())
			.field(KeypairIdentity.CREATE_TIME_PROPERTY)
			.field(KeypairIdentity.VERSION_PROPERTY)
		;
	}

	/** PublicKeyType的ListOf时需要序列化的属性列表 */
	protected SerializeScope getPublicKeyTypeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='name'; 
		//	type='string'; 
		//	value='rsa|ecc'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='code'; 
		//	type='string'; 
		//	value='rsa|ecc'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(PublicKeyType.ID_PROPERTY)
			.field(PublicKeyType.NAME_PROPERTY).as("title")
			.field(PublicKeyType.CODE_PROPERTY).as("brief").with_prefix("代码: ")
			.field(PublicKeyType.DOMAIN_PROPERTY, getUserDomainSummaryScope())
			.field(PublicKeyType.VERSION_PROPERTY)
		;
	}

	/** TreeNode的ListOf时需要序列化的属性列表 */
	protected SerializeScope getTreeNodeListOfViewScope() {
		// DisplayMode{name='auto', titleField=fieldesc{
		//	name='node_id'; 
		//	type='string'; 
		//	value='node000001'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, briefField=fieldesc{
		//	name='node_type'; 
		//	type='string'; 
		//	value='nodetype'; 
		//	required='true'; 
		//	features='{name=string}';
		//}
		//, imageUrlField=null, imageListField=null, propList=[]}
		return SerializeScope.INCLUDE()
			.field(RetailscmBaseConstants.X_LINK_TO_URL)
			.field(TreeNode.ID_PROPERTY)
			.field(TreeNode.NODE_ID_PROPERTY).as("title")
			.field(TreeNode.NODE_TYPE_PROPERTY).as("brief").with_prefix("节点类型: ")
			.field(TreeNode.LEFT_VALUE_PROPERTY)
			.field(TreeNode.RIGHT_VALUE_PROPERTY)
			.field(TreeNode.VERSION_PROPERTY)
		;
	}

	
	public SerializeScope getListOfViewScope(String listClassName, String ownerClassName) {
		return scopes.get(listClassName);
	}
	
	
	protected Map<String, SerializeScope> scopes;
	protected void initAllViewScope() {
		scopes = new HashMap<>();
		scopes.put(RetailStoreCountryCenter.class.getName(),getRetailStoreCountryCenterListOfViewScope());
		scopes.put(Catalog.class.getName(),getCatalogListOfViewScope());
		scopes.put(LevelOneCategory.class.getName(),getLevelOneCategoryListOfViewScope());
		scopes.put(LevelTwoCategory.class.getName(),getLevelTwoCategoryListOfViewScope());
		scopes.put(LevelThreeCategory.class.getName(),getLevelThreeCategoryListOfViewScope());
		scopes.put(Product.class.getName(),getProductListOfViewScope());
		scopes.put(Sku.class.getName(),getSkuListOfViewScope());
		scopes.put(RetailStoreProvinceCenter.class.getName(),getRetailStoreProvinceCenterListOfViewScope());
		scopes.put(ProvinceCenterDepartment.class.getName(),getProvinceCenterDepartmentListOfViewScope());
		scopes.put(ProvinceCenterEmployee.class.getName(),getProvinceCenterEmployeeListOfViewScope());
		scopes.put(RetailStoreCityServiceCenter.class.getName(),getRetailStoreCityServiceCenterListOfViewScope());
		scopes.put(CityPartner.class.getName(),getCityPartnerListOfViewScope());
		scopes.put(PotentialCustomer.class.getName(),getPotentialCustomerListOfViewScope());
		scopes.put(PotentialCustomerContactPerson.class.getName(),getPotentialCustomerContactPersonListOfViewScope());
		scopes.put(PotentialCustomerContact.class.getName(),getPotentialCustomerContactListOfViewScope());
		scopes.put(CityEvent.class.getName(),getCityEventListOfViewScope());
		scopes.put(EventAttendance.class.getName(),getEventAttendanceListOfViewScope());
		scopes.put(RetailStore.class.getName(),getRetailStoreListOfViewScope());
		scopes.put(RetailStoreCreation.class.getName(),getRetailStoreCreationListOfViewScope());
		scopes.put(RetailStoreInvestmentInvitation.class.getName(),getRetailStoreInvestmentInvitationListOfViewScope());
		scopes.put(RetailStoreFranchising.class.getName(),getRetailStoreFranchisingListOfViewScope());
		scopes.put(RetailStoreDecoration.class.getName(),getRetailStoreDecorationListOfViewScope());
		scopes.put(RetailStoreOpening.class.getName(),getRetailStoreOpeningListOfViewScope());
		scopes.put(RetailStoreClosing.class.getName(),getRetailStoreClosingListOfViewScope());
		scopes.put(RetailStoreMember.class.getName(),getRetailStoreMemberListOfViewScope());
		scopes.put(ConsumerOrder.class.getName(),getConsumerOrderListOfViewScope());
		scopes.put(ConsumerOrderLineItem.class.getName(),getConsumerOrderLineItemListOfViewScope());
		scopes.put(ConsumerOrderShippingGroup.class.getName(),getConsumerOrderShippingGroupListOfViewScope());
		scopes.put(ConsumerOrderPaymentGroup.class.getName(),getConsumerOrderPaymentGroupListOfViewScope());
		scopes.put(ConsumerOrderPriceAdjustment.class.getName(),getConsumerOrderPriceAdjustmentListOfViewScope());
		scopes.put(RetailStoreMemberCoupon.class.getName(),getRetailStoreMemberCouponListOfViewScope());
		scopes.put(MemberWishlist.class.getName(),getMemberWishlistListOfViewScope());
		scopes.put(MemberRewardPoint.class.getName(),getMemberRewardPointListOfViewScope());
		scopes.put(MemberRewardPointRedemption.class.getName(),getMemberRewardPointRedemptionListOfViewScope());
		scopes.put(MemberWishlistProduct.class.getName(),getMemberWishlistProductListOfViewScope());
		scopes.put(RetailStoreMemberAddress.class.getName(),getRetailStoreMemberAddressListOfViewScope());
		scopes.put(RetailStoreMemberGiftCard.class.getName(),getRetailStoreMemberGiftCardListOfViewScope());
		scopes.put(RetailStoreMemberGiftCardConsumeRecord.class.getName(),getRetailStoreMemberGiftCardConsumeRecordListOfViewScope());
		scopes.put(GoodsSupplier.class.getName(),getGoodsSupplierListOfViewScope());
		scopes.put(SupplierProduct.class.getName(),getSupplierProductListOfViewScope());
		scopes.put(ProductSupplyDuration.class.getName(),getProductSupplyDurationListOfViewScope());
		scopes.put(SupplyOrder.class.getName(),getSupplyOrderListOfViewScope());
		scopes.put(SupplyOrderLineItem.class.getName(),getSupplyOrderLineItemListOfViewScope());
		scopes.put(SupplyOrderShippingGroup.class.getName(),getSupplyOrderShippingGroupListOfViewScope());
		scopes.put(SupplyOrderPaymentGroup.class.getName(),getSupplyOrderPaymentGroupListOfViewScope());
		scopes.put(RetailStoreOrder.class.getName(),getRetailStoreOrderListOfViewScope());
		scopes.put(RetailStoreOrderLineItem.class.getName(),getRetailStoreOrderLineItemListOfViewScope());
		scopes.put(RetailStoreOrderShippingGroup.class.getName(),getRetailStoreOrderShippingGroupListOfViewScope());
		scopes.put(RetailStoreOrderPaymentGroup.class.getName(),getRetailStoreOrderPaymentGroupListOfViewScope());
		scopes.put(Warehouse.class.getName(),getWarehouseListOfViewScope());
		scopes.put(StorageSpace.class.getName(),getStorageSpaceListOfViewScope());
		scopes.put(SmartPallet.class.getName(),getSmartPalletListOfViewScope());
		scopes.put(GoodsShelf.class.getName(),getGoodsShelfListOfViewScope());
		scopes.put(GoodsShelfStockCount.class.getName(),getGoodsShelfStockCountListOfViewScope());
		scopes.put(StockCountIssueTrack.class.getName(),getStockCountIssueTrackListOfViewScope());
		scopes.put(GoodsAllocation.class.getName(),getGoodsAllocationListOfViewScope());
		scopes.put(Goods.class.getName(),getGoodsListOfViewScope());
		scopes.put(GoodsMovement.class.getName(),getGoodsMovementListOfViewScope());
		scopes.put(SupplierSpace.class.getName(),getSupplierSpaceListOfViewScope());
		scopes.put(ReceivingSpace.class.getName(),getReceivingSpaceListOfViewScope());
		scopes.put(ShippingSpace.class.getName(),getShippingSpaceListOfViewScope());
		scopes.put(DamageSpace.class.getName(),getDamageSpaceListOfViewScope());
		scopes.put(WarehouseAsset.class.getName(),getWarehouseAssetListOfViewScope());
		scopes.put(TransportFleet.class.getName(),getTransportFleetListOfViewScope());
		scopes.put(TransportTruck.class.getName(),getTransportTruckListOfViewScope());
		scopes.put(TruckDriver.class.getName(),getTruckDriverListOfViewScope());
		scopes.put(TransportTask.class.getName(),getTransportTaskListOfViewScope());
		scopes.put(TransportTaskTrack.class.getName(),getTransportTaskTrackListOfViewScope());
		scopes.put(AccountSet.class.getName(),getAccountSetListOfViewScope());
		scopes.put(AccountingSubject.class.getName(),getAccountingSubjectListOfViewScope());
		scopes.put(AccountingPeriod.class.getName(),getAccountingPeriodListOfViewScope());
		scopes.put(AccountingDocumentType.class.getName(),getAccountingDocumentTypeListOfViewScope());
		scopes.put(AccountingDocument.class.getName(),getAccountingDocumentListOfViewScope());
		scopes.put(OriginalVoucher.class.getName(),getOriginalVoucherListOfViewScope());
		scopes.put(AccountingDocumentLine.class.getName(),getAccountingDocumentLineListOfViewScope());
		scopes.put(LevelOneDepartment.class.getName(),getLevelOneDepartmentListOfViewScope());
		scopes.put(LevelTwoDepartment.class.getName(),getLevelTwoDepartmentListOfViewScope());
		scopes.put(LevelThreeDepartment.class.getName(),getLevelThreeDepartmentListOfViewScope());
		scopes.put(SkillType.class.getName(),getSkillTypeListOfViewScope());
		scopes.put(ResponsibilityType.class.getName(),getResponsibilityTypeListOfViewScope());
		scopes.put(TerminationReason.class.getName(),getTerminationReasonListOfViewScope());
		scopes.put(TerminationType.class.getName(),getTerminationTypeListOfViewScope());
		scopes.put(OccupationType.class.getName(),getOccupationTypeListOfViewScope());
		scopes.put(LeaveType.class.getName(),getLeaveTypeListOfViewScope());
		scopes.put(SalaryGrade.class.getName(),getSalaryGradeListOfViewScope());
		scopes.put(InterviewType.class.getName(),getInterviewTypeListOfViewScope());
		scopes.put(TrainingCourseType.class.getName(),getTrainingCourseTypeListOfViewScope());
		scopes.put(PublicHoliday.class.getName(),getPublicHolidayListOfViewScope());
		scopes.put(Termination.class.getName(),getTerminationListOfViewScope());
		scopes.put(View.class.getName(),getViewListOfViewScope());
		scopes.put(Employee.class.getName(),getEmployeeListOfViewScope());
		scopes.put(Instructor.class.getName(),getInstructorListOfViewScope());
		scopes.put(CompanyTraining.class.getName(),getCompanyTrainingListOfViewScope());
		scopes.put(Scoring.class.getName(),getScoringListOfViewScope());
		scopes.put(EmployeeCompanyTraining.class.getName(),getEmployeeCompanyTrainingListOfViewScope());
		scopes.put(EmployeeSkill.class.getName(),getEmployeeSkillListOfViewScope());
		scopes.put(EmployeePerformance.class.getName(),getEmployeePerformanceListOfViewScope());
		scopes.put(EmployeeWorkExperience.class.getName(),getEmployeeWorkExperienceListOfViewScope());
		scopes.put(EmployeeLeave.class.getName(),getEmployeeLeaveListOfViewScope());
		scopes.put(EmployeeInterview.class.getName(),getEmployeeInterviewListOfViewScope());
		scopes.put(EmployeeAttendance.class.getName(),getEmployeeAttendanceListOfViewScope());
		scopes.put(EmployeeQualifier.class.getName(),getEmployeeQualifierListOfViewScope());
		scopes.put(EmployeeEducation.class.getName(),getEmployeeEducationListOfViewScope());
		scopes.put(EmployeeAward.class.getName(),getEmployeeAwardListOfViewScope());
		scopes.put(EmployeeSalarySheet.class.getName(),getEmployeeSalarySheetListOfViewScope());
		scopes.put(PayingOff.class.getName(),getPayingOffListOfViewScope());
		scopes.put(MobileApp.class.getName(),getMobileAppListOfViewScope());
		scopes.put(Page.class.getName(),getPageListOfViewScope());
		scopes.put(PageType.class.getName(),getPageTypeListOfViewScope());
		scopes.put(Slide.class.getName(),getSlideListOfViewScope());
		scopes.put(UiAction.class.getName(),getUiActionListOfViewScope());
		scopes.put(Section.class.getName(),getSectionListOfViewScope());
		scopes.put(UserDomain.class.getName(),getUserDomainListOfViewScope());
		scopes.put(UserAllowList.class.getName(),getUserAllowListListOfViewScope());
		scopes.put(SecUser.class.getName(),getSecUserListOfViewScope());
		scopes.put(UserApp.class.getName(),getUserAppListOfViewScope());
		scopes.put(QuickLink.class.getName(),getQuickLinkListOfViewScope());
		scopes.put(ListAccess.class.getName(),getListAccessListOfViewScope());
		scopes.put(LoginHistory.class.getName(),getLoginHistoryListOfViewScope());
		scopes.put(CandidateContainer.class.getName(),getCandidateContainerListOfViewScope());
		scopes.put(CandidateElement.class.getName(),getCandidateElementListOfViewScope());
		scopes.put(WechatWorkappIdentity.class.getName(),getWechatWorkappIdentityListOfViewScope());
		scopes.put(WechatMiniappIdentity.class.getName(),getWechatMiniappIdentityListOfViewScope());
		scopes.put(KeypairIdentity.class.getName(),getKeypairIdentityListOfViewScope());
		scopes.put(PublicKeyType.class.getName(),getPublicKeyTypeListOfViewScope());
		scopes.put(TreeNode.class.getName(),getTreeNodeListOfViewScope());
	}

}
















