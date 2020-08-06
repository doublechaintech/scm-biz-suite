package com.doublechaintech.retailscm;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTokens;
import com.doublechaintech.retailscm.catalog.Catalog;
import com.doublechaintech.retailscm.catalog.CatalogDAO;
import com.doublechaintech.retailscm.catalog.CatalogTokens;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryDAO;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryTokens;
import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryDAO;
import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryTokens;
import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory;
import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryDAO;
import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryTokens;
import com.doublechaintech.retailscm.product.Product;
import com.doublechaintech.retailscm.product.ProductDAO;
import com.doublechaintech.retailscm.product.ProductTokens;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.sku.SkuDAO;
import com.doublechaintech.retailscm.sku.SkuTokens;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterDAO;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterTokens;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartmentDAO;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartmentTokens;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployeeDAO;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployeeTokens;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterTokens;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.citypartner.CityPartnerDAO;
import com.doublechaintech.retailscm.citypartner.CityPartnerTokens;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerDAO;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerTokens;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPersonDAO;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPersonTokens;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContactDAO;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContactTokens;
import com.doublechaintech.retailscm.cityevent.CityEvent;
import com.doublechaintech.retailscm.cityevent.CityEventDAO;
import com.doublechaintech.retailscm.cityevent.CityEventTokens;
import com.doublechaintech.retailscm.eventattendance.EventAttendance;
import com.doublechaintech.retailscm.eventattendance.EventAttendanceDAO;
import com.doublechaintech.retailscm.eventattendance.EventAttendanceTokens;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;
import com.doublechaintech.retailscm.retailstore.RetailStoreTokens;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreationDAO;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreationTokens;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitationDAO;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitationTokens;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchisingDAO;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchisingTokens;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecorationDAO;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecorationTokens;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpeningDAO;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpeningTokens;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosingDAO;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosingTokens;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberDAO;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberTokens;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderDAO;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderTokens;
import com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItem;
import com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItemDAO;
import com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItemTokens;
import com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup;
import com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroupDAO;
import com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroupTokens;
import com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup;
import com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroupDAO;
import com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroupTokens;
import com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment;
import com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustmentDAO;
import com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustmentTokens;
import com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon;
import com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCouponDAO;
import com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCouponTokens;
import com.doublechaintech.retailscm.memberwishlist.MemberWishlist;
import com.doublechaintech.retailscm.memberwishlist.MemberWishlistDAO;
import com.doublechaintech.retailscm.memberwishlist.MemberWishlistTokens;
import com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPoint;
import com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPointDAO;
import com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPointTokens;
import com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemption;
import com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemptionDAO;
import com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemptionTokens;
import com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProduct;
import com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProductDAO;
import com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProductTokens;
import com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddress;
import com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddressDAO;
import com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddressTokens;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardDAO;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardTokens;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordDAO;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordTokens;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierDAO;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierTokens;
import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;
import com.doublechaintech.retailscm.supplierproduct.SupplierProductDAO;
import com.doublechaintech.retailscm.supplierproduct.SupplierProductTokens;
import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDuration;
import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDurationDAO;
import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDurationTokens;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderTokens;
import com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItem;
import com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItemDAO;
import com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItemTokens;
import com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup;
import com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroupDAO;
import com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroupTokens;
import com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup;
import com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroupDAO;
import com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroupTokens;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderDAO;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderTokens;
import com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem;
import com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItemDAO;
import com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItemTokens;
import com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup;
import com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroupDAO;
import com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroupTokens;
import com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup;
import com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroupDAO;
import com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroupTokens;
import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.warehouse.WarehouseDAO;
import com.doublechaintech.retailscm.warehouse.WarehouseTokens;
import com.doublechaintech.retailscm.storagespace.StorageSpace;
import com.doublechaintech.retailscm.storagespace.StorageSpaceDAO;
import com.doublechaintech.retailscm.storagespace.StorageSpaceTokens;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.smartpallet.SmartPalletDAO;
import com.doublechaintech.retailscm.smartpallet.SmartPalletTokens;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelfDAO;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelfTokens;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountDAO;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountTokens;
import com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrack;
import com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrackDAO;
import com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrackTokens;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocationDAO;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocationTokens;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.goods.GoodsDAO;
import com.doublechaintech.retailscm.goods.GoodsTokens;
import com.doublechaintech.retailscm.goodsmovement.GoodsMovement;
import com.doublechaintech.retailscm.goodsmovement.GoodsMovementDAO;
import com.doublechaintech.retailscm.goodsmovement.GoodsMovementTokens;
import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
import com.doublechaintech.retailscm.supplierspace.SupplierSpaceDAO;
import com.doublechaintech.retailscm.supplierspace.SupplierSpaceTokens;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpaceDAO;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpaceTokens;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.shippingspace.ShippingSpaceDAO;
import com.doublechaintech.retailscm.shippingspace.ShippingSpaceTokens;
import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.damagespace.DamageSpaceDAO;
import com.doublechaintech.retailscm.damagespace.DamageSpaceTokens;
import com.doublechaintech.retailscm.warehouseasset.WarehouseAsset;
import com.doublechaintech.retailscm.warehouseasset.WarehouseAssetDAO;
import com.doublechaintech.retailscm.warehouseasset.WarehouseAssetTokens;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.transportfleet.TransportFleetDAO;
import com.doublechaintech.retailscm.transportfleet.TransportFleetTokens;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.transporttruck.TransportTruckDAO;
import com.doublechaintech.retailscm.transporttruck.TransportTruckTokens;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.truckdriver.TruckDriverDAO;
import com.doublechaintech.retailscm.truckdriver.TruckDriverTokens;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.transporttask.TransportTaskDAO;
import com.doublechaintech.retailscm.transporttask.TransportTaskTokens;
import com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrack;
import com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrackDAO;
import com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrackTokens;
import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.accountset.AccountSetDAO;
import com.doublechaintech.retailscm.accountset.AccountSetTokens;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubjectDAO;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubjectTokens;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriodDAO;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriodTokens;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeDAO;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeTokens;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentDAO;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentTokens;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucher;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucherDAO;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucherTokens;
import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLineDAO;
import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLineTokens;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentDAO;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentTokens;
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentDAO;
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentTokens;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentDAO;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentTokens;
import com.doublechaintech.retailscm.skilltype.SkillType;
import com.doublechaintech.retailscm.skilltype.SkillTypeDAO;
import com.doublechaintech.retailscm.skilltype.SkillTypeTokens;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeDAO;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeTokens;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;
import com.doublechaintech.retailscm.terminationreason.TerminationReasonDAO;
import com.doublechaintech.retailscm.terminationreason.TerminationReasonTokens;
import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationtype.TerminationTypeDAO;
import com.doublechaintech.retailscm.terminationtype.TerminationTypeTokens;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.occupationtype.OccupationTypeDAO;
import com.doublechaintech.retailscm.occupationtype.OccupationTypeTokens;
import com.doublechaintech.retailscm.leavetype.LeaveType;
import com.doublechaintech.retailscm.leavetype.LeaveTypeDAO;
import com.doublechaintech.retailscm.leavetype.LeaveTypeTokens;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.salarygrade.SalaryGradeDAO;
import com.doublechaintech.retailscm.salarygrade.SalaryGradeTokens;
import com.doublechaintech.retailscm.interviewtype.InterviewType;
import com.doublechaintech.retailscm.interviewtype.InterviewTypeDAO;
import com.doublechaintech.retailscm.interviewtype.InterviewTypeTokens;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeDAO;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeTokens;
import com.doublechaintech.retailscm.publicholiday.PublicHoliday;
import com.doublechaintech.retailscm.publicholiday.PublicHolidayDAO;
import com.doublechaintech.retailscm.publicholiday.PublicHolidayTokens;
import com.doublechaintech.retailscm.termination.Termination;
import com.doublechaintech.retailscm.termination.TerminationDAO;
import com.doublechaintech.retailscm.termination.TerminationTokens;
import com.doublechaintech.retailscm.view.View;
import com.doublechaintech.retailscm.view.ViewDAO;
import com.doublechaintech.retailscm.view.ViewTokens;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employee.EmployeeDAO;
import com.doublechaintech.retailscm.employee.EmployeeTokens;
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.instructor.InstructorDAO;
import com.doublechaintech.retailscm.instructor.InstructorTokens;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;
import com.doublechaintech.retailscm.companytraining.CompanyTrainingDAO;
import com.doublechaintech.retailscm.companytraining.CompanyTrainingTokens;
import com.doublechaintech.retailscm.scoring.Scoring;
import com.doublechaintech.retailscm.scoring.ScoringDAO;
import com.doublechaintech.retailscm.scoring.ScoringTokens;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingDAO;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingTokens;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkill;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkillDAO;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkillTokens;
import com.doublechaintech.retailscm.employeeperformance.EmployeePerformance;
import com.doublechaintech.retailscm.employeeperformance.EmployeePerformanceDAO;
import com.doublechaintech.retailscm.employeeperformance.EmployeePerformanceTokens;
import com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperience;
import com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperienceDAO;
import com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperienceTokens;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeave;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeaveDAO;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeaveTokens;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterview;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewDAO;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewTokens;
import com.doublechaintech.retailscm.employeeattendance.EmployeeAttendance;
import com.doublechaintech.retailscm.employeeattendance.EmployeeAttendanceDAO;
import com.doublechaintech.retailscm.employeeattendance.EmployeeAttendanceTokens;
import com.doublechaintech.retailscm.employeequalifier.EmployeeQualifier;
import com.doublechaintech.retailscm.employeequalifier.EmployeeQualifierDAO;
import com.doublechaintech.retailscm.employeequalifier.EmployeeQualifierTokens;
import com.doublechaintech.retailscm.employeeeducation.EmployeeEducation;
import com.doublechaintech.retailscm.employeeeducation.EmployeeEducationDAO;
import com.doublechaintech.retailscm.employeeeducation.EmployeeEducationTokens;
import com.doublechaintech.retailscm.employeeaward.EmployeeAward;
import com.doublechaintech.retailscm.employeeaward.EmployeeAwardDAO;
import com.doublechaintech.retailscm.employeeaward.EmployeeAwardTokens;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetDAO;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetTokens;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.payingoff.PayingOffDAO;
import com.doublechaintech.retailscm.payingoff.PayingOffTokens;
import com.doublechaintech.retailscm.mobileapp.MobileApp;
import com.doublechaintech.retailscm.mobileapp.MobileAppDAO;
import com.doublechaintech.retailscm.mobileapp.MobileAppTokens;
import com.doublechaintech.retailscm.page.Page;
import com.doublechaintech.retailscm.page.PageDAO;
import com.doublechaintech.retailscm.page.PageTokens;
import com.doublechaintech.retailscm.pagetype.PageType;
import com.doublechaintech.retailscm.pagetype.PageTypeDAO;
import com.doublechaintech.retailscm.pagetype.PageTypeTokens;
import com.doublechaintech.retailscm.slide.Slide;
import com.doublechaintech.retailscm.slide.SlideDAO;
import com.doublechaintech.retailscm.slide.SlideTokens;
import com.doublechaintech.retailscm.uiaction.UiAction;
import com.doublechaintech.retailscm.uiaction.UiActionDAO;
import com.doublechaintech.retailscm.uiaction.UiActionTokens;
import com.doublechaintech.retailscm.section.Section;
import com.doublechaintech.retailscm.section.SectionDAO;
import com.doublechaintech.retailscm.section.SectionTokens;
import com.doublechaintech.retailscm.userdomain.UserDomain;
import com.doublechaintech.retailscm.userdomain.UserDomainDAO;
import com.doublechaintech.retailscm.userdomain.UserDomainTokens;
import com.doublechaintech.retailscm.userallowlist.UserAllowList;
import com.doublechaintech.retailscm.userallowlist.UserAllowListDAO;
import com.doublechaintech.retailscm.userallowlist.UserAllowListTokens;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.secuser.SecUserDAO;
import com.doublechaintech.retailscm.secuser.SecUserTokens;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.userapp.UserAppDAO;
import com.doublechaintech.retailscm.userapp.UserAppTokens;
import com.doublechaintech.retailscm.quicklink.QuickLink;
import com.doublechaintech.retailscm.quicklink.QuickLinkDAO;
import com.doublechaintech.retailscm.quicklink.QuickLinkTokens;
import com.doublechaintech.retailscm.listaccess.ListAccess;
import com.doublechaintech.retailscm.listaccess.ListAccessDAO;
import com.doublechaintech.retailscm.listaccess.ListAccessTokens;
import com.doublechaintech.retailscm.loginhistory.LoginHistory;
import com.doublechaintech.retailscm.loginhistory.LoginHistoryDAO;
import com.doublechaintech.retailscm.loginhistory.LoginHistoryTokens;
import com.doublechaintech.retailscm.candidatecontainer.CandidateContainer;
import com.doublechaintech.retailscm.candidatecontainer.CandidateContainerDAO;
import com.doublechaintech.retailscm.candidatecontainer.CandidateContainerTokens;
import com.doublechaintech.retailscm.candidateelement.CandidateElement;
import com.doublechaintech.retailscm.candidateelement.CandidateElementDAO;
import com.doublechaintech.retailscm.candidateelement.CandidateElementTokens;
import com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentity;
import com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentityDAO;
import com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentityTokens;
import com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentity;
import com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentityDAO;
import com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentityTokens;
import com.doublechaintech.retailscm.keypairidentity.KeypairIdentity;
import com.doublechaintech.retailscm.keypairidentity.KeypairIdentityDAO;
import com.doublechaintech.retailscm.keypairidentity.KeypairIdentityTokens;
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;
import com.doublechaintech.retailscm.publickeytype.PublicKeyTypeDAO;
import com.doublechaintech.retailscm.publickeytype.PublicKeyTypeTokens;
import com.doublechaintech.retailscm.treenode.TreeNode;
import com.doublechaintech.retailscm.treenode.TreeNodeDAO;
import com.doublechaintech.retailscm.treenode.TreeNodeTokens;

public class DAOGroup {

	protected RetailStoreCountryCenterDAO retailStoreCountryCenterDAO;

	protected CatalogDAO catalogDAO;

	protected LevelOneCategoryDAO levelOneCategoryDAO;

	protected LevelTwoCategoryDAO levelTwoCategoryDAO;

	protected LevelThreeCategoryDAO levelThreeCategoryDAO;

	protected ProductDAO productDAO;

	protected SkuDAO skuDAO;

	protected RetailStoreProvinceCenterDAO retailStoreProvinceCenterDAO;

	protected ProvinceCenterDepartmentDAO provinceCenterDepartmentDAO;

	protected ProvinceCenterEmployeeDAO provinceCenterEmployeeDAO;

	protected RetailStoreCityServiceCenterDAO retailStoreCityServiceCenterDAO;

	protected CityPartnerDAO cityPartnerDAO;

	protected PotentialCustomerDAO potentialCustomerDAO;

	protected PotentialCustomerContactPersonDAO potentialCustomerContactPersonDAO;

	protected PotentialCustomerContactDAO potentialCustomerContactDAO;

	protected CityEventDAO cityEventDAO;

	protected EventAttendanceDAO eventAttendanceDAO;

	protected RetailStoreDAO retailStoreDAO;

	protected RetailStoreCreationDAO retailStoreCreationDAO;

	protected RetailStoreInvestmentInvitationDAO retailStoreInvestmentInvitationDAO;

	protected RetailStoreFranchisingDAO retailStoreFranchisingDAO;

	protected RetailStoreDecorationDAO retailStoreDecorationDAO;

	protected RetailStoreOpeningDAO retailStoreOpeningDAO;

	protected RetailStoreClosingDAO retailStoreClosingDAO;

	protected RetailStoreMemberDAO retailStoreMemberDAO;

	protected ConsumerOrderDAO consumerOrderDAO;

	protected ConsumerOrderLineItemDAO consumerOrderLineItemDAO;

	protected ConsumerOrderShippingGroupDAO consumerOrderShippingGroupDAO;

	protected ConsumerOrderPaymentGroupDAO consumerOrderPaymentGroupDAO;

	protected ConsumerOrderPriceAdjustmentDAO consumerOrderPriceAdjustmentDAO;

	protected RetailStoreMemberCouponDAO retailStoreMemberCouponDAO;

	protected MemberWishlistDAO memberWishlistDAO;

	protected MemberRewardPointDAO memberRewardPointDAO;

	protected MemberRewardPointRedemptionDAO memberRewardPointRedemptionDAO;

	protected MemberWishlistProductDAO memberWishlistProductDAO;

	protected RetailStoreMemberAddressDAO retailStoreMemberAddressDAO;

	protected RetailStoreMemberGiftCardDAO retailStoreMemberGiftCardDAO;

	protected RetailStoreMemberGiftCardConsumeRecordDAO retailStoreMemberGiftCardConsumeRecordDAO;

	protected GoodsSupplierDAO goodsSupplierDAO;

	protected SupplierProductDAO supplierProductDAO;

	protected ProductSupplyDurationDAO productSupplyDurationDAO;

	protected SupplyOrderDAO supplyOrderDAO;

	protected SupplyOrderLineItemDAO supplyOrderLineItemDAO;

	protected SupplyOrderShippingGroupDAO supplyOrderShippingGroupDAO;

	protected SupplyOrderPaymentGroupDAO supplyOrderPaymentGroupDAO;

	protected RetailStoreOrderDAO retailStoreOrderDAO;

	protected RetailStoreOrderLineItemDAO retailStoreOrderLineItemDAO;

	protected RetailStoreOrderShippingGroupDAO retailStoreOrderShippingGroupDAO;

	protected RetailStoreOrderPaymentGroupDAO retailStoreOrderPaymentGroupDAO;

	protected WarehouseDAO warehouseDAO;

	protected StorageSpaceDAO storageSpaceDAO;

	protected SmartPalletDAO smartPalletDAO;

	protected GoodsShelfDAO goodsShelfDAO;

	protected GoodsShelfStockCountDAO goodsShelfStockCountDAO;

	protected StockCountIssueTrackDAO stockCountIssueTrackDAO;

	protected GoodsAllocationDAO goodsAllocationDAO;

	protected GoodsDAO goodsDAO;

	protected GoodsMovementDAO goodsMovementDAO;

	protected SupplierSpaceDAO supplierSpaceDAO;

	protected ReceivingSpaceDAO receivingSpaceDAO;

	protected ShippingSpaceDAO shippingSpaceDAO;

	protected DamageSpaceDAO damageSpaceDAO;

	protected WarehouseAssetDAO warehouseAssetDAO;

	protected TransportFleetDAO transportFleetDAO;

	protected TransportTruckDAO transportTruckDAO;

	protected TruckDriverDAO truckDriverDAO;

	protected TransportTaskDAO transportTaskDAO;

	protected TransportTaskTrackDAO transportTaskTrackDAO;

	protected AccountSetDAO accountSetDAO;

	protected AccountingSubjectDAO accountingSubjectDAO;

	protected AccountingPeriodDAO accountingPeriodDAO;

	protected AccountingDocumentTypeDAO accountingDocumentTypeDAO;

	protected AccountingDocumentDAO accountingDocumentDAO;

	protected OriginalVoucherDAO originalVoucherDAO;

	protected AccountingDocumentLineDAO accountingDocumentLineDAO;

	protected LevelOneDepartmentDAO levelOneDepartmentDAO;

	protected LevelTwoDepartmentDAO levelTwoDepartmentDAO;

	protected LevelThreeDepartmentDAO levelThreeDepartmentDAO;

	protected SkillTypeDAO skillTypeDAO;

	protected ResponsibilityTypeDAO responsibilityTypeDAO;

	protected TerminationReasonDAO terminationReasonDAO;

	protected TerminationTypeDAO terminationTypeDAO;

	protected OccupationTypeDAO occupationTypeDAO;

	protected LeaveTypeDAO leaveTypeDAO;

	protected SalaryGradeDAO salaryGradeDAO;

	protected InterviewTypeDAO interviewTypeDAO;

	protected TrainingCourseTypeDAO trainingCourseTypeDAO;

	protected PublicHolidayDAO publicHolidayDAO;

	protected TerminationDAO terminationDAO;

	protected ViewDAO viewDAO;

	protected EmployeeDAO employeeDAO;

	protected InstructorDAO instructorDAO;

	protected CompanyTrainingDAO companyTrainingDAO;

	protected ScoringDAO scoringDAO;

	protected EmployeeCompanyTrainingDAO employeeCompanyTrainingDAO;

	protected EmployeeSkillDAO employeeSkillDAO;

	protected EmployeePerformanceDAO employeePerformanceDAO;

	protected EmployeeWorkExperienceDAO employeeWorkExperienceDAO;

	protected EmployeeLeaveDAO employeeLeaveDAO;

	protected EmployeeInterviewDAO employeeInterviewDAO;

	protected EmployeeAttendanceDAO employeeAttendanceDAO;

	protected EmployeeQualifierDAO employeeQualifierDAO;

	protected EmployeeEducationDAO employeeEducationDAO;

	protected EmployeeAwardDAO employeeAwardDAO;

	protected EmployeeSalarySheetDAO employeeSalarySheetDAO;

	protected PayingOffDAO payingOffDAO;

	protected MobileAppDAO mobileAppDAO;

	protected PageDAO pageDAO;

	protected PageTypeDAO pageTypeDAO;

	protected SlideDAO slideDAO;

	protected UiActionDAO uiActionDAO;

	protected SectionDAO sectionDAO;

	protected UserDomainDAO userDomainDAO;

	protected UserAllowListDAO userAllowListDAO;

	protected SecUserDAO secUserDAO;

	protected UserAppDAO userAppDAO;

	protected QuickLinkDAO quickLinkDAO;

	protected ListAccessDAO listAccessDAO;

	protected LoginHistoryDAO loginHistoryDAO;

	protected CandidateContainerDAO candidateContainerDAO;

	protected CandidateElementDAO candidateElementDAO;

	protected WechatWorkappIdentityDAO wechatWorkappIdentityDAO;

	protected WechatMiniappIdentityDAO wechatMiniappIdentityDAO;

	protected KeypairIdentityDAO keypairIdentityDAO;

	protected PublicKeyTypeDAO publicKeyTypeDAO;

	protected TreeNodeDAO treeNodeDAO;



	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
		return this.retailStoreCountryCenterDAO;
	}
	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO dao){
		this.retailStoreCountryCenterDAO = dao;
	}


	public CatalogDAO getCatalogDAO(){
		return this.catalogDAO;
	}
	public void setCatalogDAO(CatalogDAO dao){
		this.catalogDAO = dao;
	}


	public LevelOneCategoryDAO getLevelOneCategoryDAO(){
		return this.levelOneCategoryDAO;
	}
	public void setLevelOneCategoryDAO(LevelOneCategoryDAO dao){
		this.levelOneCategoryDAO = dao;
	}


	public LevelTwoCategoryDAO getLevelTwoCategoryDAO(){
		return this.levelTwoCategoryDAO;
	}
	public void setLevelTwoCategoryDAO(LevelTwoCategoryDAO dao){
		this.levelTwoCategoryDAO = dao;
	}


	public LevelThreeCategoryDAO getLevelThreeCategoryDAO(){
		return this.levelThreeCategoryDAO;
	}
	public void setLevelThreeCategoryDAO(LevelThreeCategoryDAO dao){
		this.levelThreeCategoryDAO = dao;
	}


	public ProductDAO getProductDAO(){
		return this.productDAO;
	}
	public void setProductDAO(ProductDAO dao){
		this.productDAO = dao;
	}


	public SkuDAO getSkuDAO(){
		return this.skuDAO;
	}
	public void setSkuDAO(SkuDAO dao){
		this.skuDAO = dao;
	}


	public RetailStoreProvinceCenterDAO getRetailStoreProvinceCenterDAO(){
		return this.retailStoreProvinceCenterDAO;
	}
	public void setRetailStoreProvinceCenterDAO(RetailStoreProvinceCenterDAO dao){
		this.retailStoreProvinceCenterDAO = dao;
	}


	public ProvinceCenterDepartmentDAO getProvinceCenterDepartmentDAO(){
		return this.provinceCenterDepartmentDAO;
	}
	public void setProvinceCenterDepartmentDAO(ProvinceCenterDepartmentDAO dao){
		this.provinceCenterDepartmentDAO = dao;
	}


	public ProvinceCenterEmployeeDAO getProvinceCenterEmployeeDAO(){
		return this.provinceCenterEmployeeDAO;
	}
	public void setProvinceCenterEmployeeDAO(ProvinceCenterEmployeeDAO dao){
		this.provinceCenterEmployeeDAO = dao;
	}


	public RetailStoreCityServiceCenterDAO getRetailStoreCityServiceCenterDAO(){
		return this.retailStoreCityServiceCenterDAO;
	}
	public void setRetailStoreCityServiceCenterDAO(RetailStoreCityServiceCenterDAO dao){
		this.retailStoreCityServiceCenterDAO = dao;
	}


	public CityPartnerDAO getCityPartnerDAO(){
		return this.cityPartnerDAO;
	}
	public void setCityPartnerDAO(CityPartnerDAO dao){
		this.cityPartnerDAO = dao;
	}


	public PotentialCustomerDAO getPotentialCustomerDAO(){
		return this.potentialCustomerDAO;
	}
	public void setPotentialCustomerDAO(PotentialCustomerDAO dao){
		this.potentialCustomerDAO = dao;
	}


	public PotentialCustomerContactPersonDAO getPotentialCustomerContactPersonDAO(){
		return this.potentialCustomerContactPersonDAO;
	}
	public void setPotentialCustomerContactPersonDAO(PotentialCustomerContactPersonDAO dao){
		this.potentialCustomerContactPersonDAO = dao;
	}


	public PotentialCustomerContactDAO getPotentialCustomerContactDAO(){
		return this.potentialCustomerContactDAO;
	}
	public void setPotentialCustomerContactDAO(PotentialCustomerContactDAO dao){
		this.potentialCustomerContactDAO = dao;
	}


	public CityEventDAO getCityEventDAO(){
		return this.cityEventDAO;
	}
	public void setCityEventDAO(CityEventDAO dao){
		this.cityEventDAO = dao;
	}


	public EventAttendanceDAO getEventAttendanceDAO(){
		return this.eventAttendanceDAO;
	}
	public void setEventAttendanceDAO(EventAttendanceDAO dao){
		this.eventAttendanceDAO = dao;
	}


	public RetailStoreDAO getRetailStoreDAO(){
		return this.retailStoreDAO;
	}
	public void setRetailStoreDAO(RetailStoreDAO dao){
		this.retailStoreDAO = dao;
	}


	public RetailStoreCreationDAO getRetailStoreCreationDAO(){
		return this.retailStoreCreationDAO;
	}
	public void setRetailStoreCreationDAO(RetailStoreCreationDAO dao){
		this.retailStoreCreationDAO = dao;
	}


	public RetailStoreInvestmentInvitationDAO getRetailStoreInvestmentInvitationDAO(){
		return this.retailStoreInvestmentInvitationDAO;
	}
	public void setRetailStoreInvestmentInvitationDAO(RetailStoreInvestmentInvitationDAO dao){
		this.retailStoreInvestmentInvitationDAO = dao;
	}


	public RetailStoreFranchisingDAO getRetailStoreFranchisingDAO(){
		return this.retailStoreFranchisingDAO;
	}
	public void setRetailStoreFranchisingDAO(RetailStoreFranchisingDAO dao){
		this.retailStoreFranchisingDAO = dao;
	}


	public RetailStoreDecorationDAO getRetailStoreDecorationDAO(){
		return this.retailStoreDecorationDAO;
	}
	public void setRetailStoreDecorationDAO(RetailStoreDecorationDAO dao){
		this.retailStoreDecorationDAO = dao;
	}


	public RetailStoreOpeningDAO getRetailStoreOpeningDAO(){
		return this.retailStoreOpeningDAO;
	}
	public void setRetailStoreOpeningDAO(RetailStoreOpeningDAO dao){
		this.retailStoreOpeningDAO = dao;
	}


	public RetailStoreClosingDAO getRetailStoreClosingDAO(){
		return this.retailStoreClosingDAO;
	}
	public void setRetailStoreClosingDAO(RetailStoreClosingDAO dao){
		this.retailStoreClosingDAO = dao;
	}


	public RetailStoreMemberDAO getRetailStoreMemberDAO(){
		return this.retailStoreMemberDAO;
	}
	public void setRetailStoreMemberDAO(RetailStoreMemberDAO dao){
		this.retailStoreMemberDAO = dao;
	}


	public ConsumerOrderDAO getConsumerOrderDAO(){
		return this.consumerOrderDAO;
	}
	public void setConsumerOrderDAO(ConsumerOrderDAO dao){
		this.consumerOrderDAO = dao;
	}


	public ConsumerOrderLineItemDAO getConsumerOrderLineItemDAO(){
		return this.consumerOrderLineItemDAO;
	}
	public void setConsumerOrderLineItemDAO(ConsumerOrderLineItemDAO dao){
		this.consumerOrderLineItemDAO = dao;
	}


	public ConsumerOrderShippingGroupDAO getConsumerOrderShippingGroupDAO(){
		return this.consumerOrderShippingGroupDAO;
	}
	public void setConsumerOrderShippingGroupDAO(ConsumerOrderShippingGroupDAO dao){
		this.consumerOrderShippingGroupDAO = dao;
	}


	public ConsumerOrderPaymentGroupDAO getConsumerOrderPaymentGroupDAO(){
		return this.consumerOrderPaymentGroupDAO;
	}
	public void setConsumerOrderPaymentGroupDAO(ConsumerOrderPaymentGroupDAO dao){
		this.consumerOrderPaymentGroupDAO = dao;
	}


	public ConsumerOrderPriceAdjustmentDAO getConsumerOrderPriceAdjustmentDAO(){
		return this.consumerOrderPriceAdjustmentDAO;
	}
	public void setConsumerOrderPriceAdjustmentDAO(ConsumerOrderPriceAdjustmentDAO dao){
		this.consumerOrderPriceAdjustmentDAO = dao;
	}


	public RetailStoreMemberCouponDAO getRetailStoreMemberCouponDAO(){
		return this.retailStoreMemberCouponDAO;
	}
	public void setRetailStoreMemberCouponDAO(RetailStoreMemberCouponDAO dao){
		this.retailStoreMemberCouponDAO = dao;
	}


	public MemberWishlistDAO getMemberWishlistDAO(){
		return this.memberWishlistDAO;
	}
	public void setMemberWishlistDAO(MemberWishlistDAO dao){
		this.memberWishlistDAO = dao;
	}


	public MemberRewardPointDAO getMemberRewardPointDAO(){
		return this.memberRewardPointDAO;
	}
	public void setMemberRewardPointDAO(MemberRewardPointDAO dao){
		this.memberRewardPointDAO = dao;
	}


	public MemberRewardPointRedemptionDAO getMemberRewardPointRedemptionDAO(){
		return this.memberRewardPointRedemptionDAO;
	}
	public void setMemberRewardPointRedemptionDAO(MemberRewardPointRedemptionDAO dao){
		this.memberRewardPointRedemptionDAO = dao;
	}


	public MemberWishlistProductDAO getMemberWishlistProductDAO(){
		return this.memberWishlistProductDAO;
	}
	public void setMemberWishlistProductDAO(MemberWishlistProductDAO dao){
		this.memberWishlistProductDAO = dao;
	}


	public RetailStoreMemberAddressDAO getRetailStoreMemberAddressDAO(){
		return this.retailStoreMemberAddressDAO;
	}
	public void setRetailStoreMemberAddressDAO(RetailStoreMemberAddressDAO dao){
		this.retailStoreMemberAddressDAO = dao;
	}


	public RetailStoreMemberGiftCardDAO getRetailStoreMemberGiftCardDAO(){
		return this.retailStoreMemberGiftCardDAO;
	}
	public void setRetailStoreMemberGiftCardDAO(RetailStoreMemberGiftCardDAO dao){
		this.retailStoreMemberGiftCardDAO = dao;
	}


	public RetailStoreMemberGiftCardConsumeRecordDAO getRetailStoreMemberGiftCardConsumeRecordDAO(){
		return this.retailStoreMemberGiftCardConsumeRecordDAO;
	}
	public void setRetailStoreMemberGiftCardConsumeRecordDAO(RetailStoreMemberGiftCardConsumeRecordDAO dao){
		this.retailStoreMemberGiftCardConsumeRecordDAO = dao;
	}


	public GoodsSupplierDAO getGoodsSupplierDAO(){
		return this.goodsSupplierDAO;
	}
	public void setGoodsSupplierDAO(GoodsSupplierDAO dao){
		this.goodsSupplierDAO = dao;
	}


	public SupplierProductDAO getSupplierProductDAO(){
		return this.supplierProductDAO;
	}
	public void setSupplierProductDAO(SupplierProductDAO dao){
		this.supplierProductDAO = dao;
	}


	public ProductSupplyDurationDAO getProductSupplyDurationDAO(){
		return this.productSupplyDurationDAO;
	}
	public void setProductSupplyDurationDAO(ProductSupplyDurationDAO dao){
		this.productSupplyDurationDAO = dao;
	}


	public SupplyOrderDAO getSupplyOrderDAO(){
		return this.supplyOrderDAO;
	}
	public void setSupplyOrderDAO(SupplyOrderDAO dao){
		this.supplyOrderDAO = dao;
	}


	public SupplyOrderLineItemDAO getSupplyOrderLineItemDAO(){
		return this.supplyOrderLineItemDAO;
	}
	public void setSupplyOrderLineItemDAO(SupplyOrderLineItemDAO dao){
		this.supplyOrderLineItemDAO = dao;
	}


	public SupplyOrderShippingGroupDAO getSupplyOrderShippingGroupDAO(){
		return this.supplyOrderShippingGroupDAO;
	}
	public void setSupplyOrderShippingGroupDAO(SupplyOrderShippingGroupDAO dao){
		this.supplyOrderShippingGroupDAO = dao;
	}


	public SupplyOrderPaymentGroupDAO getSupplyOrderPaymentGroupDAO(){
		return this.supplyOrderPaymentGroupDAO;
	}
	public void setSupplyOrderPaymentGroupDAO(SupplyOrderPaymentGroupDAO dao){
		this.supplyOrderPaymentGroupDAO = dao;
	}


	public RetailStoreOrderDAO getRetailStoreOrderDAO(){
		return this.retailStoreOrderDAO;
	}
	public void setRetailStoreOrderDAO(RetailStoreOrderDAO dao){
		this.retailStoreOrderDAO = dao;
	}


	public RetailStoreOrderLineItemDAO getRetailStoreOrderLineItemDAO(){
		return this.retailStoreOrderLineItemDAO;
	}
	public void setRetailStoreOrderLineItemDAO(RetailStoreOrderLineItemDAO dao){
		this.retailStoreOrderLineItemDAO = dao;
	}


	public RetailStoreOrderShippingGroupDAO getRetailStoreOrderShippingGroupDAO(){
		return this.retailStoreOrderShippingGroupDAO;
	}
	public void setRetailStoreOrderShippingGroupDAO(RetailStoreOrderShippingGroupDAO dao){
		this.retailStoreOrderShippingGroupDAO = dao;
	}


	public RetailStoreOrderPaymentGroupDAO getRetailStoreOrderPaymentGroupDAO(){
		return this.retailStoreOrderPaymentGroupDAO;
	}
	public void setRetailStoreOrderPaymentGroupDAO(RetailStoreOrderPaymentGroupDAO dao){
		this.retailStoreOrderPaymentGroupDAO = dao;
	}


	public WarehouseDAO getWarehouseDAO(){
		return this.warehouseDAO;
	}
	public void setWarehouseDAO(WarehouseDAO dao){
		this.warehouseDAO = dao;
	}


	public StorageSpaceDAO getStorageSpaceDAO(){
		return this.storageSpaceDAO;
	}
	public void setStorageSpaceDAO(StorageSpaceDAO dao){
		this.storageSpaceDAO = dao;
	}


	public SmartPalletDAO getSmartPalletDAO(){
		return this.smartPalletDAO;
	}
	public void setSmartPalletDAO(SmartPalletDAO dao){
		this.smartPalletDAO = dao;
	}


	public GoodsShelfDAO getGoodsShelfDAO(){
		return this.goodsShelfDAO;
	}
	public void setGoodsShelfDAO(GoodsShelfDAO dao){
		this.goodsShelfDAO = dao;
	}


	public GoodsShelfStockCountDAO getGoodsShelfStockCountDAO(){
		return this.goodsShelfStockCountDAO;
	}
	public void setGoodsShelfStockCountDAO(GoodsShelfStockCountDAO dao){
		this.goodsShelfStockCountDAO = dao;
	}


	public StockCountIssueTrackDAO getStockCountIssueTrackDAO(){
		return this.stockCountIssueTrackDAO;
	}
	public void setStockCountIssueTrackDAO(StockCountIssueTrackDAO dao){
		this.stockCountIssueTrackDAO = dao;
	}


	public GoodsAllocationDAO getGoodsAllocationDAO(){
		return this.goodsAllocationDAO;
	}
	public void setGoodsAllocationDAO(GoodsAllocationDAO dao){
		this.goodsAllocationDAO = dao;
	}


	public GoodsDAO getGoodsDAO(){
		return this.goodsDAO;
	}
	public void setGoodsDAO(GoodsDAO dao){
		this.goodsDAO = dao;
	}


	public GoodsMovementDAO getGoodsMovementDAO(){
		return this.goodsMovementDAO;
	}
	public void setGoodsMovementDAO(GoodsMovementDAO dao){
		this.goodsMovementDAO = dao;
	}


	public SupplierSpaceDAO getSupplierSpaceDAO(){
		return this.supplierSpaceDAO;
	}
	public void setSupplierSpaceDAO(SupplierSpaceDAO dao){
		this.supplierSpaceDAO = dao;
	}


	public ReceivingSpaceDAO getReceivingSpaceDAO(){
		return this.receivingSpaceDAO;
	}
	public void setReceivingSpaceDAO(ReceivingSpaceDAO dao){
		this.receivingSpaceDAO = dao;
	}


	public ShippingSpaceDAO getShippingSpaceDAO(){
		return this.shippingSpaceDAO;
	}
	public void setShippingSpaceDAO(ShippingSpaceDAO dao){
		this.shippingSpaceDAO = dao;
	}


	public DamageSpaceDAO getDamageSpaceDAO(){
		return this.damageSpaceDAO;
	}
	public void setDamageSpaceDAO(DamageSpaceDAO dao){
		this.damageSpaceDAO = dao;
	}


	public WarehouseAssetDAO getWarehouseAssetDAO(){
		return this.warehouseAssetDAO;
	}
	public void setWarehouseAssetDAO(WarehouseAssetDAO dao){
		this.warehouseAssetDAO = dao;
	}


	public TransportFleetDAO getTransportFleetDAO(){
		return this.transportFleetDAO;
	}
	public void setTransportFleetDAO(TransportFleetDAO dao){
		this.transportFleetDAO = dao;
	}


	public TransportTruckDAO getTransportTruckDAO(){
		return this.transportTruckDAO;
	}
	public void setTransportTruckDAO(TransportTruckDAO dao){
		this.transportTruckDAO = dao;
	}


	public TruckDriverDAO getTruckDriverDAO(){
		return this.truckDriverDAO;
	}
	public void setTruckDriverDAO(TruckDriverDAO dao){
		this.truckDriverDAO = dao;
	}


	public TransportTaskDAO getTransportTaskDAO(){
		return this.transportTaskDAO;
	}
	public void setTransportTaskDAO(TransportTaskDAO dao){
		this.transportTaskDAO = dao;
	}


	public TransportTaskTrackDAO getTransportTaskTrackDAO(){
		return this.transportTaskTrackDAO;
	}
	public void setTransportTaskTrackDAO(TransportTaskTrackDAO dao){
		this.transportTaskTrackDAO = dao;
	}


	public AccountSetDAO getAccountSetDAO(){
		return this.accountSetDAO;
	}
	public void setAccountSetDAO(AccountSetDAO dao){
		this.accountSetDAO = dao;
	}


	public AccountingSubjectDAO getAccountingSubjectDAO(){
		return this.accountingSubjectDAO;
	}
	public void setAccountingSubjectDAO(AccountingSubjectDAO dao){
		this.accountingSubjectDAO = dao;
	}


	public AccountingPeriodDAO getAccountingPeriodDAO(){
		return this.accountingPeriodDAO;
	}
	public void setAccountingPeriodDAO(AccountingPeriodDAO dao){
		this.accountingPeriodDAO = dao;
	}


	public AccountingDocumentTypeDAO getAccountingDocumentTypeDAO(){
		return this.accountingDocumentTypeDAO;
	}
	public void setAccountingDocumentTypeDAO(AccountingDocumentTypeDAO dao){
		this.accountingDocumentTypeDAO = dao;
	}


	public AccountingDocumentDAO getAccountingDocumentDAO(){
		return this.accountingDocumentDAO;
	}
	public void setAccountingDocumentDAO(AccountingDocumentDAO dao){
		this.accountingDocumentDAO = dao;
	}


	public OriginalVoucherDAO getOriginalVoucherDAO(){
		return this.originalVoucherDAO;
	}
	public void setOriginalVoucherDAO(OriginalVoucherDAO dao){
		this.originalVoucherDAO = dao;
	}


	public AccountingDocumentLineDAO getAccountingDocumentLineDAO(){
		return this.accountingDocumentLineDAO;
	}
	public void setAccountingDocumentLineDAO(AccountingDocumentLineDAO dao){
		this.accountingDocumentLineDAO = dao;
	}


	public LevelOneDepartmentDAO getLevelOneDepartmentDAO(){
		return this.levelOneDepartmentDAO;
	}
	public void setLevelOneDepartmentDAO(LevelOneDepartmentDAO dao){
		this.levelOneDepartmentDAO = dao;
	}


	public LevelTwoDepartmentDAO getLevelTwoDepartmentDAO(){
		return this.levelTwoDepartmentDAO;
	}
	public void setLevelTwoDepartmentDAO(LevelTwoDepartmentDAO dao){
		this.levelTwoDepartmentDAO = dao;
	}


	public LevelThreeDepartmentDAO getLevelThreeDepartmentDAO(){
		return this.levelThreeDepartmentDAO;
	}
	public void setLevelThreeDepartmentDAO(LevelThreeDepartmentDAO dao){
		this.levelThreeDepartmentDAO = dao;
	}


	public SkillTypeDAO getSkillTypeDAO(){
		return this.skillTypeDAO;
	}
	public void setSkillTypeDAO(SkillTypeDAO dao){
		this.skillTypeDAO = dao;
	}


	public ResponsibilityTypeDAO getResponsibilityTypeDAO(){
		return this.responsibilityTypeDAO;
	}
	public void setResponsibilityTypeDAO(ResponsibilityTypeDAO dao){
		this.responsibilityTypeDAO = dao;
	}


	public TerminationReasonDAO getTerminationReasonDAO(){
		return this.terminationReasonDAO;
	}
	public void setTerminationReasonDAO(TerminationReasonDAO dao){
		this.terminationReasonDAO = dao;
	}


	public TerminationTypeDAO getTerminationTypeDAO(){
		return this.terminationTypeDAO;
	}
	public void setTerminationTypeDAO(TerminationTypeDAO dao){
		this.terminationTypeDAO = dao;
	}


	public OccupationTypeDAO getOccupationTypeDAO(){
		return this.occupationTypeDAO;
	}
	public void setOccupationTypeDAO(OccupationTypeDAO dao){
		this.occupationTypeDAO = dao;
	}


	public LeaveTypeDAO getLeaveTypeDAO(){
		return this.leaveTypeDAO;
	}
	public void setLeaveTypeDAO(LeaveTypeDAO dao){
		this.leaveTypeDAO = dao;
	}


	public SalaryGradeDAO getSalaryGradeDAO(){
		return this.salaryGradeDAO;
	}
	public void setSalaryGradeDAO(SalaryGradeDAO dao){
		this.salaryGradeDAO = dao;
	}


	public InterviewTypeDAO getInterviewTypeDAO(){
		return this.interviewTypeDAO;
	}
	public void setInterviewTypeDAO(InterviewTypeDAO dao){
		this.interviewTypeDAO = dao;
	}


	public TrainingCourseTypeDAO getTrainingCourseTypeDAO(){
		return this.trainingCourseTypeDAO;
	}
	public void setTrainingCourseTypeDAO(TrainingCourseTypeDAO dao){
		this.trainingCourseTypeDAO = dao;
	}


	public PublicHolidayDAO getPublicHolidayDAO(){
		return this.publicHolidayDAO;
	}
	public void setPublicHolidayDAO(PublicHolidayDAO dao){
		this.publicHolidayDAO = dao;
	}


	public TerminationDAO getTerminationDAO(){
		return this.terminationDAO;
	}
	public void setTerminationDAO(TerminationDAO dao){
		this.terminationDAO = dao;
	}


	public ViewDAO getViewDAO(){
		return this.viewDAO;
	}
	public void setViewDAO(ViewDAO dao){
		this.viewDAO = dao;
	}


	public EmployeeDAO getEmployeeDAO(){
		return this.employeeDAO;
	}
	public void setEmployeeDAO(EmployeeDAO dao){
		this.employeeDAO = dao;
	}


	public InstructorDAO getInstructorDAO(){
		return this.instructorDAO;
	}
	public void setInstructorDAO(InstructorDAO dao){
		this.instructorDAO = dao;
	}


	public CompanyTrainingDAO getCompanyTrainingDAO(){
		return this.companyTrainingDAO;
	}
	public void setCompanyTrainingDAO(CompanyTrainingDAO dao){
		this.companyTrainingDAO = dao;
	}


	public ScoringDAO getScoringDAO(){
		return this.scoringDAO;
	}
	public void setScoringDAO(ScoringDAO dao){
		this.scoringDAO = dao;
	}


	public EmployeeCompanyTrainingDAO getEmployeeCompanyTrainingDAO(){
		return this.employeeCompanyTrainingDAO;
	}
	public void setEmployeeCompanyTrainingDAO(EmployeeCompanyTrainingDAO dao){
		this.employeeCompanyTrainingDAO = dao;
	}


	public EmployeeSkillDAO getEmployeeSkillDAO(){
		return this.employeeSkillDAO;
	}
	public void setEmployeeSkillDAO(EmployeeSkillDAO dao){
		this.employeeSkillDAO = dao;
	}


	public EmployeePerformanceDAO getEmployeePerformanceDAO(){
		return this.employeePerformanceDAO;
	}
	public void setEmployeePerformanceDAO(EmployeePerformanceDAO dao){
		this.employeePerformanceDAO = dao;
	}


	public EmployeeWorkExperienceDAO getEmployeeWorkExperienceDAO(){
		return this.employeeWorkExperienceDAO;
	}
	public void setEmployeeWorkExperienceDAO(EmployeeWorkExperienceDAO dao){
		this.employeeWorkExperienceDAO = dao;
	}


	public EmployeeLeaveDAO getEmployeeLeaveDAO(){
		return this.employeeLeaveDAO;
	}
	public void setEmployeeLeaveDAO(EmployeeLeaveDAO dao){
		this.employeeLeaveDAO = dao;
	}


	public EmployeeInterviewDAO getEmployeeInterviewDAO(){
		return this.employeeInterviewDAO;
	}
	public void setEmployeeInterviewDAO(EmployeeInterviewDAO dao){
		this.employeeInterviewDAO = dao;
	}


	public EmployeeAttendanceDAO getEmployeeAttendanceDAO(){
		return this.employeeAttendanceDAO;
	}
	public void setEmployeeAttendanceDAO(EmployeeAttendanceDAO dao){
		this.employeeAttendanceDAO = dao;
	}


	public EmployeeQualifierDAO getEmployeeQualifierDAO(){
		return this.employeeQualifierDAO;
	}
	public void setEmployeeQualifierDAO(EmployeeQualifierDAO dao){
		this.employeeQualifierDAO = dao;
	}


	public EmployeeEducationDAO getEmployeeEducationDAO(){
		return this.employeeEducationDAO;
	}
	public void setEmployeeEducationDAO(EmployeeEducationDAO dao){
		this.employeeEducationDAO = dao;
	}


	public EmployeeAwardDAO getEmployeeAwardDAO(){
		return this.employeeAwardDAO;
	}
	public void setEmployeeAwardDAO(EmployeeAwardDAO dao){
		this.employeeAwardDAO = dao;
	}


	public EmployeeSalarySheetDAO getEmployeeSalarySheetDAO(){
		return this.employeeSalarySheetDAO;
	}
	public void setEmployeeSalarySheetDAO(EmployeeSalarySheetDAO dao){
		this.employeeSalarySheetDAO = dao;
	}


	public PayingOffDAO getPayingOffDAO(){
		return this.payingOffDAO;
	}
	public void setPayingOffDAO(PayingOffDAO dao){
		this.payingOffDAO = dao;
	}


	public MobileAppDAO getMobileAppDAO(){
		return this.mobileAppDAO;
	}
	public void setMobileAppDAO(MobileAppDAO dao){
		this.mobileAppDAO = dao;
	}


	public PageDAO getPageDAO(){
		return this.pageDAO;
	}
	public void setPageDAO(PageDAO dao){
		this.pageDAO = dao;
	}


	public PageTypeDAO getPageTypeDAO(){
		return this.pageTypeDAO;
	}
	public void setPageTypeDAO(PageTypeDAO dao){
		this.pageTypeDAO = dao;
	}


	public SlideDAO getSlideDAO(){
		return this.slideDAO;
	}
	public void setSlideDAO(SlideDAO dao){
		this.slideDAO = dao;
	}


	public UiActionDAO getUiActionDAO(){
		return this.uiActionDAO;
	}
	public void setUiActionDAO(UiActionDAO dao){
		this.uiActionDAO = dao;
	}


	public SectionDAO getSectionDAO(){
		return this.sectionDAO;
	}
	public void setSectionDAO(SectionDAO dao){
		this.sectionDAO = dao;
	}


	public UserDomainDAO getUserDomainDAO(){
		return this.userDomainDAO;
	}
	public void setUserDomainDAO(UserDomainDAO dao){
		this.userDomainDAO = dao;
	}


	public UserAllowListDAO getUserAllowListDAO(){
		return this.userAllowListDAO;
	}
	public void setUserAllowListDAO(UserAllowListDAO dao){
		this.userAllowListDAO = dao;
	}


	public SecUserDAO getSecUserDAO(){
		return this.secUserDAO;
	}
	public void setSecUserDAO(SecUserDAO dao){
		this.secUserDAO = dao;
	}


	public UserAppDAO getUserAppDAO(){
		return this.userAppDAO;
	}
	public void setUserAppDAO(UserAppDAO dao){
		this.userAppDAO = dao;
	}


	public QuickLinkDAO getQuickLinkDAO(){
		return this.quickLinkDAO;
	}
	public void setQuickLinkDAO(QuickLinkDAO dao){
		this.quickLinkDAO = dao;
	}


	public ListAccessDAO getListAccessDAO(){
		return this.listAccessDAO;
	}
	public void setListAccessDAO(ListAccessDAO dao){
		this.listAccessDAO = dao;
	}


	public LoginHistoryDAO getLoginHistoryDAO(){
		return this.loginHistoryDAO;
	}
	public void setLoginHistoryDAO(LoginHistoryDAO dao){
		this.loginHistoryDAO = dao;
	}


	public CandidateContainerDAO getCandidateContainerDAO(){
		return this.candidateContainerDAO;
	}
	public void setCandidateContainerDAO(CandidateContainerDAO dao){
		this.candidateContainerDAO = dao;
	}


	public CandidateElementDAO getCandidateElementDAO(){
		return this.candidateElementDAO;
	}
	public void setCandidateElementDAO(CandidateElementDAO dao){
		this.candidateElementDAO = dao;
	}


	public WechatWorkappIdentityDAO getWechatWorkappIdentityDAO(){
		return this.wechatWorkappIdentityDAO;
	}
	public void setWechatWorkappIdentityDAO(WechatWorkappIdentityDAO dao){
		this.wechatWorkappIdentityDAO = dao;
	}


	public WechatMiniappIdentityDAO getWechatMiniappIdentityDAO(){
		return this.wechatMiniappIdentityDAO;
	}
	public void setWechatMiniappIdentityDAO(WechatMiniappIdentityDAO dao){
		this.wechatMiniappIdentityDAO = dao;
	}


	public KeypairIdentityDAO getKeypairIdentityDAO(){
		return this.keypairIdentityDAO;
	}
	public void setKeypairIdentityDAO(KeypairIdentityDAO dao){
		this.keypairIdentityDAO = dao;
	}


	public PublicKeyTypeDAO getPublicKeyTypeDAO(){
		return this.publicKeyTypeDAO;
	}
	public void setPublicKeyTypeDAO(PublicKeyTypeDAO dao){
		this.publicKeyTypeDAO = dao;
	}


	public TreeNodeDAO getTreeNodeDAO(){
		return this.treeNodeDAO;
	}
	public void setTreeNodeDAO(TreeNodeDAO dao){
		this.treeNodeDAO = dao;
	}


	private interface BasicLoader{
	    BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception;
	    void enhanceList(DAOGroup daoGoup, List list) throws Exception;
	    List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> list) throws Exception;
	    BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception;
	    BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception;
	    SmartList<? extends BaseEntity> queryList(DAOGroup daoGoup, String sql, Object... parmeters) throws Exception;
	}
	private static Map<String, BasicLoader> internalLoaderMap;
	static {
		internalLoaderMap = new HashMap<String, BasicLoader>();

		internalLoaderMap.put("RetailStoreCountryCenter", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRetailStoreCountryCenterDAO().load(id, RetailStoreCountryCenterTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getRetailStoreCountryCenterDAO().enhanceList((List<RetailStoreCountryCenter>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreCountryCenterDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreCountryCenterDAO().present((RetailStoreCountryCenter)data, tokens);
			}
			@Override
			public SmartList<RetailStoreCountryCenter> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getRetailStoreCountryCenterDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)RetailStoreCountryCenter.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Catalog", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCatalogDAO().load(id, CatalogTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCatalogDAO().enhanceList((List<Catalog>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCatalogDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCatalogDAO().present((Catalog)data, tokens);
			}
			@Override
			public SmartList<Catalog> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getCatalogDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Catalog.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("LevelOneCategory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLevelOneCategoryDAO().load(id, LevelOneCategoryTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getLevelOneCategoryDAO().enhanceList((List<LevelOneCategory>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelOneCategoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelOneCategoryDAO().present((LevelOneCategory)data, tokens);
			}
			@Override
			public SmartList<LevelOneCategory> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getLevelOneCategoryDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)LevelOneCategory.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("LevelTwoCategory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLevelTwoCategoryDAO().load(id, LevelTwoCategoryTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getLevelTwoCategoryDAO().enhanceList((List<LevelTwoCategory>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelTwoCategoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelTwoCategoryDAO().present((LevelTwoCategory)data, tokens);
			}
			@Override
			public SmartList<LevelTwoCategory> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getLevelTwoCategoryDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)LevelTwoCategory.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("LevelThreeCategory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLevelThreeCategoryDAO().load(id, LevelThreeCategoryTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getLevelThreeCategoryDAO().enhanceList((List<LevelThreeCategory>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelThreeCategoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelThreeCategoryDAO().present((LevelThreeCategory)data, tokens);
			}
			@Override
			public SmartList<LevelThreeCategory> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getLevelThreeCategoryDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)LevelThreeCategory.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Product", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getProductDAO().load(id, ProductTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getProductDAO().enhanceList((List<Product>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProductDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProductDAO().present((Product)data, tokens);
			}
			@Override
			public SmartList<Product> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getProductDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Product.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Sku", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSkuDAO().load(id, SkuTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSkuDAO().enhanceList((List<Sku>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSkuDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSkuDAO().present((Sku)data, tokens);
			}
			@Override
			public SmartList<Sku> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getSkuDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Sku.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("RetailStoreProvinceCenter", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRetailStoreProvinceCenterDAO().load(id, RetailStoreProvinceCenterTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getRetailStoreProvinceCenterDAO().enhanceList((List<RetailStoreProvinceCenter>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreProvinceCenterDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreProvinceCenterDAO().present((RetailStoreProvinceCenter)data, tokens);
			}
			@Override
			public SmartList<RetailStoreProvinceCenter> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getRetailStoreProvinceCenterDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)RetailStoreProvinceCenter.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("ProvinceCenterDepartment", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getProvinceCenterDepartmentDAO().load(id, ProvinceCenterDepartmentTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getProvinceCenterDepartmentDAO().enhanceList((List<ProvinceCenterDepartment>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProvinceCenterDepartmentDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProvinceCenterDepartmentDAO().present((ProvinceCenterDepartment)data, tokens);
			}
			@Override
			public SmartList<ProvinceCenterDepartment> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getProvinceCenterDepartmentDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)ProvinceCenterDepartment.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("ProvinceCenterEmployee", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getProvinceCenterEmployeeDAO().load(id, ProvinceCenterEmployeeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getProvinceCenterEmployeeDAO().enhanceList((List<ProvinceCenterEmployee>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProvinceCenterEmployeeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProvinceCenterEmployeeDAO().present((ProvinceCenterEmployee)data, tokens);
			}
			@Override
			public SmartList<ProvinceCenterEmployee> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getProvinceCenterEmployeeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)ProvinceCenterEmployee.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("RetailStoreCityServiceCenter", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRetailStoreCityServiceCenterDAO().load(id, RetailStoreCityServiceCenterTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getRetailStoreCityServiceCenterDAO().enhanceList((List<RetailStoreCityServiceCenter>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreCityServiceCenterDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreCityServiceCenterDAO().present((RetailStoreCityServiceCenter)data, tokens);
			}
			@Override
			public SmartList<RetailStoreCityServiceCenter> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getRetailStoreCityServiceCenterDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)RetailStoreCityServiceCenter.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("CityPartner", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCityPartnerDAO().load(id, CityPartnerTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCityPartnerDAO().enhanceList((List<CityPartner>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCityPartnerDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCityPartnerDAO().present((CityPartner)data, tokens);
			}
			@Override
			public SmartList<CityPartner> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getCityPartnerDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)CityPartner.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("PotentialCustomer", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPotentialCustomerDAO().load(id, PotentialCustomerTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getPotentialCustomerDAO().enhanceList((List<PotentialCustomer>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPotentialCustomerDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPotentialCustomerDAO().present((PotentialCustomer)data, tokens);
			}
			@Override
			public SmartList<PotentialCustomer> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getPotentialCustomerDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)PotentialCustomer.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("PotentialCustomerContactPerson", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPotentialCustomerContactPersonDAO().load(id, PotentialCustomerContactPersonTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getPotentialCustomerContactPersonDAO().enhanceList((List<PotentialCustomerContactPerson>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPotentialCustomerContactPersonDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPotentialCustomerContactPersonDAO().present((PotentialCustomerContactPerson)data, tokens);
			}
			@Override
			public SmartList<PotentialCustomerContactPerson> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getPotentialCustomerContactPersonDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)PotentialCustomerContactPerson.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("PotentialCustomerContact", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPotentialCustomerContactDAO().load(id, PotentialCustomerContactTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getPotentialCustomerContactDAO().enhanceList((List<PotentialCustomerContact>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPotentialCustomerContactDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPotentialCustomerContactDAO().present((PotentialCustomerContact)data, tokens);
			}
			@Override
			public SmartList<PotentialCustomerContact> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getPotentialCustomerContactDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)PotentialCustomerContact.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("CityEvent", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCityEventDAO().load(id, CityEventTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCityEventDAO().enhanceList((List<CityEvent>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCityEventDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCityEventDAO().present((CityEvent)data, tokens);
			}
			@Override
			public SmartList<CityEvent> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getCityEventDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)CityEvent.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("EventAttendance", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getEventAttendanceDAO().load(id, EventAttendanceTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getEventAttendanceDAO().enhanceList((List<EventAttendance>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEventAttendanceDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEventAttendanceDAO().present((EventAttendance)data, tokens);
			}
			@Override
			public SmartList<EventAttendance> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getEventAttendanceDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)EventAttendance.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("RetailStore", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRetailStoreDAO().load(id, RetailStoreTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getRetailStoreDAO().enhanceList((List<RetailStore>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreDAO().present((RetailStore)data, tokens);
			}
			@Override
			public SmartList<RetailStore> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getRetailStoreDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)RetailStore.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("RetailStoreCreation", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRetailStoreCreationDAO().load(id, RetailStoreCreationTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getRetailStoreCreationDAO().enhanceList((List<RetailStoreCreation>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreCreationDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreCreationDAO().present((RetailStoreCreation)data, tokens);
			}
			@Override
			public SmartList<RetailStoreCreation> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getRetailStoreCreationDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)RetailStoreCreation.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("RetailStoreInvestmentInvitation", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRetailStoreInvestmentInvitationDAO().load(id, RetailStoreInvestmentInvitationTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getRetailStoreInvestmentInvitationDAO().enhanceList((List<RetailStoreInvestmentInvitation>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreInvestmentInvitationDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreInvestmentInvitationDAO().present((RetailStoreInvestmentInvitation)data, tokens);
			}
			@Override
			public SmartList<RetailStoreInvestmentInvitation> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getRetailStoreInvestmentInvitationDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)RetailStoreInvestmentInvitation.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("RetailStoreFranchising", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRetailStoreFranchisingDAO().load(id, RetailStoreFranchisingTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getRetailStoreFranchisingDAO().enhanceList((List<RetailStoreFranchising>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreFranchisingDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreFranchisingDAO().present((RetailStoreFranchising)data, tokens);
			}
			@Override
			public SmartList<RetailStoreFranchising> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getRetailStoreFranchisingDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)RetailStoreFranchising.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("RetailStoreDecoration", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRetailStoreDecorationDAO().load(id, RetailStoreDecorationTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getRetailStoreDecorationDAO().enhanceList((List<RetailStoreDecoration>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreDecorationDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreDecorationDAO().present((RetailStoreDecoration)data, tokens);
			}
			@Override
			public SmartList<RetailStoreDecoration> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getRetailStoreDecorationDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)RetailStoreDecoration.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("RetailStoreOpening", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRetailStoreOpeningDAO().load(id, RetailStoreOpeningTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getRetailStoreOpeningDAO().enhanceList((List<RetailStoreOpening>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreOpeningDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreOpeningDAO().present((RetailStoreOpening)data, tokens);
			}
			@Override
			public SmartList<RetailStoreOpening> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getRetailStoreOpeningDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)RetailStoreOpening.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("RetailStoreClosing", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRetailStoreClosingDAO().load(id, RetailStoreClosingTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getRetailStoreClosingDAO().enhanceList((List<RetailStoreClosing>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreClosingDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreClosingDAO().present((RetailStoreClosing)data, tokens);
			}
			@Override
			public SmartList<RetailStoreClosing> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getRetailStoreClosingDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)RetailStoreClosing.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("RetailStoreMember", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRetailStoreMemberDAO().load(id, RetailStoreMemberTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getRetailStoreMemberDAO().enhanceList((List<RetailStoreMember>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreMemberDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreMemberDAO().present((RetailStoreMember)data, tokens);
			}
			@Override
			public SmartList<RetailStoreMember> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getRetailStoreMemberDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)RetailStoreMember.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("ConsumerOrder", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getConsumerOrderDAO().load(id, ConsumerOrderTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getConsumerOrderDAO().enhanceList((List<ConsumerOrder>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getConsumerOrderDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getConsumerOrderDAO().present((ConsumerOrder)data, tokens);
			}
			@Override
			public SmartList<ConsumerOrder> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getConsumerOrderDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)ConsumerOrder.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("ConsumerOrderLineItem", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getConsumerOrderLineItemDAO().load(id, ConsumerOrderLineItemTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getConsumerOrderLineItemDAO().enhanceList((List<ConsumerOrderLineItem>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getConsumerOrderLineItemDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getConsumerOrderLineItemDAO().present((ConsumerOrderLineItem)data, tokens);
			}
			@Override
			public SmartList<ConsumerOrderLineItem> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getConsumerOrderLineItemDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)ConsumerOrderLineItem.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("ConsumerOrderShippingGroup", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getConsumerOrderShippingGroupDAO().load(id, ConsumerOrderShippingGroupTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getConsumerOrderShippingGroupDAO().enhanceList((List<ConsumerOrderShippingGroup>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getConsumerOrderShippingGroupDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getConsumerOrderShippingGroupDAO().present((ConsumerOrderShippingGroup)data, tokens);
			}
			@Override
			public SmartList<ConsumerOrderShippingGroup> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getConsumerOrderShippingGroupDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)ConsumerOrderShippingGroup.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("ConsumerOrderPaymentGroup", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getConsumerOrderPaymentGroupDAO().load(id, ConsumerOrderPaymentGroupTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getConsumerOrderPaymentGroupDAO().enhanceList((List<ConsumerOrderPaymentGroup>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getConsumerOrderPaymentGroupDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getConsumerOrderPaymentGroupDAO().present((ConsumerOrderPaymentGroup)data, tokens);
			}
			@Override
			public SmartList<ConsumerOrderPaymentGroup> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getConsumerOrderPaymentGroupDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)ConsumerOrderPaymentGroup.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("ConsumerOrderPriceAdjustment", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getConsumerOrderPriceAdjustmentDAO().load(id, ConsumerOrderPriceAdjustmentTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getConsumerOrderPriceAdjustmentDAO().enhanceList((List<ConsumerOrderPriceAdjustment>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getConsumerOrderPriceAdjustmentDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getConsumerOrderPriceAdjustmentDAO().present((ConsumerOrderPriceAdjustment)data, tokens);
			}
			@Override
			public SmartList<ConsumerOrderPriceAdjustment> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getConsumerOrderPriceAdjustmentDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)ConsumerOrderPriceAdjustment.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("RetailStoreMemberCoupon", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRetailStoreMemberCouponDAO().load(id, RetailStoreMemberCouponTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getRetailStoreMemberCouponDAO().enhanceList((List<RetailStoreMemberCoupon>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreMemberCouponDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreMemberCouponDAO().present((RetailStoreMemberCoupon)data, tokens);
			}
			@Override
			public SmartList<RetailStoreMemberCoupon> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getRetailStoreMemberCouponDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)RetailStoreMemberCoupon.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("MemberWishlist", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getMemberWishlistDAO().load(id, MemberWishlistTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getMemberWishlistDAO().enhanceList((List<MemberWishlist>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getMemberWishlistDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getMemberWishlistDAO().present((MemberWishlist)data, tokens);
			}
			@Override
			public SmartList<MemberWishlist> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getMemberWishlistDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)MemberWishlist.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("MemberRewardPoint", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getMemberRewardPointDAO().load(id, MemberRewardPointTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getMemberRewardPointDAO().enhanceList((List<MemberRewardPoint>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getMemberRewardPointDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getMemberRewardPointDAO().present((MemberRewardPoint)data, tokens);
			}
			@Override
			public SmartList<MemberRewardPoint> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getMemberRewardPointDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)MemberRewardPoint.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("MemberRewardPointRedemption", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getMemberRewardPointRedemptionDAO().load(id, MemberRewardPointRedemptionTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getMemberRewardPointRedemptionDAO().enhanceList((List<MemberRewardPointRedemption>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getMemberRewardPointRedemptionDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getMemberRewardPointRedemptionDAO().present((MemberRewardPointRedemption)data, tokens);
			}
			@Override
			public SmartList<MemberRewardPointRedemption> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getMemberRewardPointRedemptionDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)MemberRewardPointRedemption.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("MemberWishlistProduct", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getMemberWishlistProductDAO().load(id, MemberWishlistProductTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getMemberWishlistProductDAO().enhanceList((List<MemberWishlistProduct>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getMemberWishlistProductDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getMemberWishlistProductDAO().present((MemberWishlistProduct)data, tokens);
			}
			@Override
			public SmartList<MemberWishlistProduct> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getMemberWishlistProductDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)MemberWishlistProduct.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("RetailStoreMemberAddress", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRetailStoreMemberAddressDAO().load(id, RetailStoreMemberAddressTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getRetailStoreMemberAddressDAO().enhanceList((List<RetailStoreMemberAddress>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreMemberAddressDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreMemberAddressDAO().present((RetailStoreMemberAddress)data, tokens);
			}
			@Override
			public SmartList<RetailStoreMemberAddress> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getRetailStoreMemberAddressDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)RetailStoreMemberAddress.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("RetailStoreMemberGiftCard", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRetailStoreMemberGiftCardDAO().load(id, RetailStoreMemberGiftCardTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getRetailStoreMemberGiftCardDAO().enhanceList((List<RetailStoreMemberGiftCard>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreMemberGiftCardDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreMemberGiftCardDAO().present((RetailStoreMemberGiftCard)data, tokens);
			}
			@Override
			public SmartList<RetailStoreMemberGiftCard> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getRetailStoreMemberGiftCardDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)RetailStoreMemberGiftCard.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("RetailStoreMemberGiftCardConsumeRecord", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRetailStoreMemberGiftCardConsumeRecordDAO().load(id, RetailStoreMemberGiftCardConsumeRecordTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getRetailStoreMemberGiftCardConsumeRecordDAO().enhanceList((List<RetailStoreMemberGiftCardConsumeRecord>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreMemberGiftCardConsumeRecordDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreMemberGiftCardConsumeRecordDAO().present((RetailStoreMemberGiftCardConsumeRecord)data, tokens);
			}
			@Override
			public SmartList<RetailStoreMemberGiftCardConsumeRecord> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getRetailStoreMemberGiftCardConsumeRecordDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)RetailStoreMemberGiftCardConsumeRecord.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("GoodsSupplier", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getGoodsSupplierDAO().load(id, GoodsSupplierTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getGoodsSupplierDAO().enhanceList((List<GoodsSupplier>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGoodsSupplierDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGoodsSupplierDAO().present((GoodsSupplier)data, tokens);
			}
			@Override
			public SmartList<GoodsSupplier> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getGoodsSupplierDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)GoodsSupplier.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("SupplierProduct", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSupplierProductDAO().load(id, SupplierProductTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSupplierProductDAO().enhanceList((List<SupplierProduct>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSupplierProductDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSupplierProductDAO().present((SupplierProduct)data, tokens);
			}
			@Override
			public SmartList<SupplierProduct> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getSupplierProductDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)SupplierProduct.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("ProductSupplyDuration", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getProductSupplyDurationDAO().load(id, ProductSupplyDurationTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getProductSupplyDurationDAO().enhanceList((List<ProductSupplyDuration>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProductSupplyDurationDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getProductSupplyDurationDAO().present((ProductSupplyDuration)data, tokens);
			}
			@Override
			public SmartList<ProductSupplyDuration> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getProductSupplyDurationDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)ProductSupplyDuration.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("SupplyOrder", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSupplyOrderDAO().load(id, SupplyOrderTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSupplyOrderDAO().enhanceList((List<SupplyOrder>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSupplyOrderDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSupplyOrderDAO().present((SupplyOrder)data, tokens);
			}
			@Override
			public SmartList<SupplyOrder> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getSupplyOrderDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)SupplyOrder.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("SupplyOrderLineItem", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSupplyOrderLineItemDAO().load(id, SupplyOrderLineItemTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSupplyOrderLineItemDAO().enhanceList((List<SupplyOrderLineItem>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSupplyOrderLineItemDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSupplyOrderLineItemDAO().present((SupplyOrderLineItem)data, tokens);
			}
			@Override
			public SmartList<SupplyOrderLineItem> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getSupplyOrderLineItemDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)SupplyOrderLineItem.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("SupplyOrderShippingGroup", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSupplyOrderShippingGroupDAO().load(id, SupplyOrderShippingGroupTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSupplyOrderShippingGroupDAO().enhanceList((List<SupplyOrderShippingGroup>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSupplyOrderShippingGroupDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSupplyOrderShippingGroupDAO().present((SupplyOrderShippingGroup)data, tokens);
			}
			@Override
			public SmartList<SupplyOrderShippingGroup> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getSupplyOrderShippingGroupDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)SupplyOrderShippingGroup.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("SupplyOrderPaymentGroup", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSupplyOrderPaymentGroupDAO().load(id, SupplyOrderPaymentGroupTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSupplyOrderPaymentGroupDAO().enhanceList((List<SupplyOrderPaymentGroup>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSupplyOrderPaymentGroupDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSupplyOrderPaymentGroupDAO().present((SupplyOrderPaymentGroup)data, tokens);
			}
			@Override
			public SmartList<SupplyOrderPaymentGroup> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getSupplyOrderPaymentGroupDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)SupplyOrderPaymentGroup.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("RetailStoreOrder", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRetailStoreOrderDAO().load(id, RetailStoreOrderTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getRetailStoreOrderDAO().enhanceList((List<RetailStoreOrder>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreOrderDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreOrderDAO().present((RetailStoreOrder)data, tokens);
			}
			@Override
			public SmartList<RetailStoreOrder> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getRetailStoreOrderDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)RetailStoreOrder.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("RetailStoreOrderLineItem", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRetailStoreOrderLineItemDAO().load(id, RetailStoreOrderLineItemTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getRetailStoreOrderLineItemDAO().enhanceList((List<RetailStoreOrderLineItem>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreOrderLineItemDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreOrderLineItemDAO().present((RetailStoreOrderLineItem)data, tokens);
			}
			@Override
			public SmartList<RetailStoreOrderLineItem> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getRetailStoreOrderLineItemDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)RetailStoreOrderLineItem.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("RetailStoreOrderShippingGroup", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRetailStoreOrderShippingGroupDAO().load(id, RetailStoreOrderShippingGroupTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getRetailStoreOrderShippingGroupDAO().enhanceList((List<RetailStoreOrderShippingGroup>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreOrderShippingGroupDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreOrderShippingGroupDAO().present((RetailStoreOrderShippingGroup)data, tokens);
			}
			@Override
			public SmartList<RetailStoreOrderShippingGroup> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getRetailStoreOrderShippingGroupDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)RetailStoreOrderShippingGroup.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("RetailStoreOrderPaymentGroup", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getRetailStoreOrderPaymentGroupDAO().load(id, RetailStoreOrderPaymentGroupTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getRetailStoreOrderPaymentGroupDAO().enhanceList((List<RetailStoreOrderPaymentGroup>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreOrderPaymentGroupDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getRetailStoreOrderPaymentGroupDAO().present((RetailStoreOrderPaymentGroup)data, tokens);
			}
			@Override
			public SmartList<RetailStoreOrderPaymentGroup> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getRetailStoreOrderPaymentGroupDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)RetailStoreOrderPaymentGroup.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Warehouse", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getWarehouseDAO().load(id, WarehouseTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getWarehouseDAO().enhanceList((List<Warehouse>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWarehouseDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWarehouseDAO().present((Warehouse)data, tokens);
			}
			@Override
			public SmartList<Warehouse> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getWarehouseDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Warehouse.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("StorageSpace", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getStorageSpaceDAO().load(id, StorageSpaceTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getStorageSpaceDAO().enhanceList((List<StorageSpace>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getStorageSpaceDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getStorageSpaceDAO().present((StorageSpace)data, tokens);
			}
			@Override
			public SmartList<StorageSpace> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getStorageSpaceDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)StorageSpace.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("SmartPallet", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSmartPalletDAO().load(id, SmartPalletTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSmartPalletDAO().enhanceList((List<SmartPallet>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSmartPalletDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSmartPalletDAO().present((SmartPallet)data, tokens);
			}
			@Override
			public SmartList<SmartPallet> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getSmartPalletDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)SmartPallet.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("GoodsShelf", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getGoodsShelfDAO().load(id, GoodsShelfTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getGoodsShelfDAO().enhanceList((List<GoodsShelf>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGoodsShelfDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGoodsShelfDAO().present((GoodsShelf)data, tokens);
			}
			@Override
			public SmartList<GoodsShelf> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getGoodsShelfDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)GoodsShelf.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("GoodsShelfStockCount", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getGoodsShelfStockCountDAO().load(id, GoodsShelfStockCountTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getGoodsShelfStockCountDAO().enhanceList((List<GoodsShelfStockCount>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGoodsShelfStockCountDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGoodsShelfStockCountDAO().present((GoodsShelfStockCount)data, tokens);
			}
			@Override
			public SmartList<GoodsShelfStockCount> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getGoodsShelfStockCountDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)GoodsShelfStockCount.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("StockCountIssueTrack", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getStockCountIssueTrackDAO().load(id, StockCountIssueTrackTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getStockCountIssueTrackDAO().enhanceList((List<StockCountIssueTrack>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getStockCountIssueTrackDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getStockCountIssueTrackDAO().present((StockCountIssueTrack)data, tokens);
			}
			@Override
			public SmartList<StockCountIssueTrack> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getStockCountIssueTrackDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)StockCountIssueTrack.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("GoodsAllocation", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getGoodsAllocationDAO().load(id, GoodsAllocationTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getGoodsAllocationDAO().enhanceList((List<GoodsAllocation>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGoodsAllocationDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGoodsAllocationDAO().present((GoodsAllocation)data, tokens);
			}
			@Override
			public SmartList<GoodsAllocation> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getGoodsAllocationDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)GoodsAllocation.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Goods", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getGoodsDAO().load(id, GoodsTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getGoodsDAO().enhanceList((List<Goods>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGoodsDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGoodsDAO().present((Goods)data, tokens);
			}
			@Override
			public SmartList<Goods> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getGoodsDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Goods.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("GoodsMovement", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getGoodsMovementDAO().load(id, GoodsMovementTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getGoodsMovementDAO().enhanceList((List<GoodsMovement>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGoodsMovementDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getGoodsMovementDAO().present((GoodsMovement)data, tokens);
			}
			@Override
			public SmartList<GoodsMovement> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getGoodsMovementDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)GoodsMovement.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("SupplierSpace", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSupplierSpaceDAO().load(id, SupplierSpaceTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSupplierSpaceDAO().enhanceList((List<SupplierSpace>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSupplierSpaceDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSupplierSpaceDAO().present((SupplierSpace)data, tokens);
			}
			@Override
			public SmartList<SupplierSpace> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getSupplierSpaceDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)SupplierSpace.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("ReceivingSpace", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getReceivingSpaceDAO().load(id, ReceivingSpaceTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getReceivingSpaceDAO().enhanceList((List<ReceivingSpace>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getReceivingSpaceDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getReceivingSpaceDAO().present((ReceivingSpace)data, tokens);
			}
			@Override
			public SmartList<ReceivingSpace> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getReceivingSpaceDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)ReceivingSpace.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("ShippingSpace", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getShippingSpaceDAO().load(id, ShippingSpaceTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getShippingSpaceDAO().enhanceList((List<ShippingSpace>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getShippingSpaceDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getShippingSpaceDAO().present((ShippingSpace)data, tokens);
			}
			@Override
			public SmartList<ShippingSpace> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getShippingSpaceDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)ShippingSpace.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("DamageSpace", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getDamageSpaceDAO().load(id, DamageSpaceTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getDamageSpaceDAO().enhanceList((List<DamageSpace>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getDamageSpaceDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getDamageSpaceDAO().present((DamageSpace)data, tokens);
			}
			@Override
			public SmartList<DamageSpace> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getDamageSpaceDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)DamageSpace.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("WarehouseAsset", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getWarehouseAssetDAO().load(id, WarehouseAssetTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getWarehouseAssetDAO().enhanceList((List<WarehouseAsset>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWarehouseAssetDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWarehouseAssetDAO().present((WarehouseAsset)data, tokens);
			}
			@Override
			public SmartList<WarehouseAsset> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getWarehouseAssetDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)WarehouseAsset.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("TransportFleet", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTransportFleetDAO().load(id, TransportFleetTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getTransportFleetDAO().enhanceList((List<TransportFleet>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransportFleetDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransportFleetDAO().present((TransportFleet)data, tokens);
			}
			@Override
			public SmartList<TransportFleet> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getTransportFleetDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)TransportFleet.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("TransportTruck", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTransportTruckDAO().load(id, TransportTruckTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getTransportTruckDAO().enhanceList((List<TransportTruck>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransportTruckDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransportTruckDAO().present((TransportTruck)data, tokens);
			}
			@Override
			public SmartList<TransportTruck> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getTransportTruckDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)TransportTruck.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("TruckDriver", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTruckDriverDAO().load(id, TruckDriverTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getTruckDriverDAO().enhanceList((List<TruckDriver>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTruckDriverDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTruckDriverDAO().present((TruckDriver)data, tokens);
			}
			@Override
			public SmartList<TruckDriver> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getTruckDriverDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)TruckDriver.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("TransportTask", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTransportTaskDAO().load(id, TransportTaskTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getTransportTaskDAO().enhanceList((List<TransportTask>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransportTaskDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransportTaskDAO().present((TransportTask)data, tokens);
			}
			@Override
			public SmartList<TransportTask> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getTransportTaskDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)TransportTask.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("TransportTaskTrack", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTransportTaskTrackDAO().load(id, TransportTaskTrackTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getTransportTaskTrackDAO().enhanceList((List<TransportTaskTrack>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransportTaskTrackDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTransportTaskTrackDAO().present((TransportTaskTrack)data, tokens);
			}
			@Override
			public SmartList<TransportTaskTrack> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getTransportTaskTrackDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)TransportTaskTrack.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("AccountSet", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getAccountSetDAO().load(id, AccountSetTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getAccountSetDAO().enhanceList((List<AccountSet>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getAccountSetDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getAccountSetDAO().present((AccountSet)data, tokens);
			}
			@Override
			public SmartList<AccountSet> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getAccountSetDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)AccountSet.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("AccountingSubject", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getAccountingSubjectDAO().load(id, AccountingSubjectTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getAccountingSubjectDAO().enhanceList((List<AccountingSubject>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getAccountingSubjectDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getAccountingSubjectDAO().present((AccountingSubject)data, tokens);
			}
			@Override
			public SmartList<AccountingSubject> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getAccountingSubjectDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)AccountingSubject.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("AccountingPeriod", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getAccountingPeriodDAO().load(id, AccountingPeriodTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getAccountingPeriodDAO().enhanceList((List<AccountingPeriod>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getAccountingPeriodDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getAccountingPeriodDAO().present((AccountingPeriod)data, tokens);
			}
			@Override
			public SmartList<AccountingPeriod> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getAccountingPeriodDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)AccountingPeriod.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("AccountingDocumentType", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getAccountingDocumentTypeDAO().load(id, AccountingDocumentTypeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getAccountingDocumentTypeDAO().enhanceList((List<AccountingDocumentType>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getAccountingDocumentTypeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getAccountingDocumentTypeDAO().present((AccountingDocumentType)data, tokens);
			}
			@Override
			public SmartList<AccountingDocumentType> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getAccountingDocumentTypeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)AccountingDocumentType.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("AccountingDocument", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getAccountingDocumentDAO().load(id, AccountingDocumentTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getAccountingDocumentDAO().enhanceList((List<AccountingDocument>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getAccountingDocumentDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getAccountingDocumentDAO().present((AccountingDocument)data, tokens);
			}
			@Override
			public SmartList<AccountingDocument> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getAccountingDocumentDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)AccountingDocument.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("OriginalVoucher", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getOriginalVoucherDAO().load(id, OriginalVoucherTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getOriginalVoucherDAO().enhanceList((List<OriginalVoucher>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getOriginalVoucherDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getOriginalVoucherDAO().present((OriginalVoucher)data, tokens);
			}
			@Override
			public SmartList<OriginalVoucher> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getOriginalVoucherDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)OriginalVoucher.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("AccountingDocumentLine", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getAccountingDocumentLineDAO().load(id, AccountingDocumentLineTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getAccountingDocumentLineDAO().enhanceList((List<AccountingDocumentLine>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getAccountingDocumentLineDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getAccountingDocumentLineDAO().present((AccountingDocumentLine)data, tokens);
			}
			@Override
			public SmartList<AccountingDocumentLine> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getAccountingDocumentLineDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)AccountingDocumentLine.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("LevelOneDepartment", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLevelOneDepartmentDAO().load(id, LevelOneDepartmentTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getLevelOneDepartmentDAO().enhanceList((List<LevelOneDepartment>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelOneDepartmentDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelOneDepartmentDAO().present((LevelOneDepartment)data, tokens);
			}
			@Override
			public SmartList<LevelOneDepartment> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getLevelOneDepartmentDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)LevelOneDepartment.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("LevelTwoDepartment", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLevelTwoDepartmentDAO().load(id, LevelTwoDepartmentTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getLevelTwoDepartmentDAO().enhanceList((List<LevelTwoDepartment>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelTwoDepartmentDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelTwoDepartmentDAO().present((LevelTwoDepartment)data, tokens);
			}
			@Override
			public SmartList<LevelTwoDepartment> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getLevelTwoDepartmentDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)LevelTwoDepartment.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("LevelThreeDepartment", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLevelThreeDepartmentDAO().load(id, LevelThreeDepartmentTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getLevelThreeDepartmentDAO().enhanceList((List<LevelThreeDepartment>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelThreeDepartmentDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLevelThreeDepartmentDAO().present((LevelThreeDepartment)data, tokens);
			}
			@Override
			public SmartList<LevelThreeDepartment> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getLevelThreeDepartmentDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)LevelThreeDepartment.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("SkillType", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSkillTypeDAO().load(id, SkillTypeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSkillTypeDAO().enhanceList((List<SkillType>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSkillTypeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSkillTypeDAO().present((SkillType)data, tokens);
			}
			@Override
			public SmartList<SkillType> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getSkillTypeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)SkillType.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("ResponsibilityType", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getResponsibilityTypeDAO().load(id, ResponsibilityTypeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getResponsibilityTypeDAO().enhanceList((List<ResponsibilityType>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getResponsibilityTypeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getResponsibilityTypeDAO().present((ResponsibilityType)data, tokens);
			}
			@Override
			public SmartList<ResponsibilityType> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getResponsibilityTypeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)ResponsibilityType.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("TerminationReason", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTerminationReasonDAO().load(id, TerminationReasonTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getTerminationReasonDAO().enhanceList((List<TerminationReason>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTerminationReasonDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTerminationReasonDAO().present((TerminationReason)data, tokens);
			}
			@Override
			public SmartList<TerminationReason> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getTerminationReasonDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)TerminationReason.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("TerminationType", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTerminationTypeDAO().load(id, TerminationTypeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getTerminationTypeDAO().enhanceList((List<TerminationType>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTerminationTypeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTerminationTypeDAO().present((TerminationType)data, tokens);
			}
			@Override
			public SmartList<TerminationType> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getTerminationTypeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)TerminationType.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("OccupationType", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getOccupationTypeDAO().load(id, OccupationTypeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getOccupationTypeDAO().enhanceList((List<OccupationType>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getOccupationTypeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getOccupationTypeDAO().present((OccupationType)data, tokens);
			}
			@Override
			public SmartList<OccupationType> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getOccupationTypeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)OccupationType.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("LeaveType", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLeaveTypeDAO().load(id, LeaveTypeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getLeaveTypeDAO().enhanceList((List<LeaveType>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLeaveTypeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLeaveTypeDAO().present((LeaveType)data, tokens);
			}
			@Override
			public SmartList<LeaveType> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getLeaveTypeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)LeaveType.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("SalaryGrade", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSalaryGradeDAO().load(id, SalaryGradeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSalaryGradeDAO().enhanceList((List<SalaryGrade>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSalaryGradeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSalaryGradeDAO().present((SalaryGrade)data, tokens);
			}
			@Override
			public SmartList<SalaryGrade> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getSalaryGradeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)SalaryGrade.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("InterviewType", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getInterviewTypeDAO().load(id, InterviewTypeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getInterviewTypeDAO().enhanceList((List<InterviewType>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getInterviewTypeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getInterviewTypeDAO().present((InterviewType)data, tokens);
			}
			@Override
			public SmartList<InterviewType> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getInterviewTypeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)InterviewType.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("TrainingCourseType", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTrainingCourseTypeDAO().load(id, TrainingCourseTypeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getTrainingCourseTypeDAO().enhanceList((List<TrainingCourseType>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTrainingCourseTypeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTrainingCourseTypeDAO().present((TrainingCourseType)data, tokens);
			}
			@Override
			public SmartList<TrainingCourseType> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getTrainingCourseTypeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)TrainingCourseType.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("PublicHoliday", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPublicHolidayDAO().load(id, PublicHolidayTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getPublicHolidayDAO().enhanceList((List<PublicHoliday>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPublicHolidayDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPublicHolidayDAO().present((PublicHoliday)data, tokens);
			}
			@Override
			public SmartList<PublicHoliday> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getPublicHolidayDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)PublicHoliday.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Termination", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTerminationDAO().load(id, TerminationTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getTerminationDAO().enhanceList((List<Termination>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTerminationDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTerminationDAO().present((Termination)data, tokens);
			}
			@Override
			public SmartList<Termination> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getTerminationDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Termination.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("View", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getViewDAO().load(id, ViewTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getViewDAO().enhanceList((List<View>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getViewDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getViewDAO().present((View)data, tokens);
			}
			@Override
			public SmartList<View> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getViewDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)View.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Employee", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getEmployeeDAO().load(id, EmployeeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getEmployeeDAO().enhanceList((List<Employee>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeDAO().present((Employee)data, tokens);
			}
			@Override
			public SmartList<Employee> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getEmployeeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Employee.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Instructor", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getInstructorDAO().load(id, InstructorTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getInstructorDAO().enhanceList((List<Instructor>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getInstructorDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getInstructorDAO().present((Instructor)data, tokens);
			}
			@Override
			public SmartList<Instructor> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getInstructorDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Instructor.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("CompanyTraining", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCompanyTrainingDAO().load(id, CompanyTrainingTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCompanyTrainingDAO().enhanceList((List<CompanyTraining>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCompanyTrainingDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCompanyTrainingDAO().present((CompanyTraining)data, tokens);
			}
			@Override
			public SmartList<CompanyTraining> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getCompanyTrainingDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)CompanyTraining.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Scoring", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getScoringDAO().load(id, ScoringTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getScoringDAO().enhanceList((List<Scoring>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getScoringDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getScoringDAO().present((Scoring)data, tokens);
			}
			@Override
			public SmartList<Scoring> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getScoringDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Scoring.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("EmployeeCompanyTraining", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getEmployeeCompanyTrainingDAO().load(id, EmployeeCompanyTrainingTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getEmployeeCompanyTrainingDAO().enhanceList((List<EmployeeCompanyTraining>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeCompanyTrainingDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeCompanyTrainingDAO().present((EmployeeCompanyTraining)data, tokens);
			}
			@Override
			public SmartList<EmployeeCompanyTraining> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getEmployeeCompanyTrainingDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)EmployeeCompanyTraining.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("EmployeeSkill", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getEmployeeSkillDAO().load(id, EmployeeSkillTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getEmployeeSkillDAO().enhanceList((List<EmployeeSkill>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeSkillDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeSkillDAO().present((EmployeeSkill)data, tokens);
			}
			@Override
			public SmartList<EmployeeSkill> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getEmployeeSkillDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)EmployeeSkill.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("EmployeePerformance", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getEmployeePerformanceDAO().load(id, EmployeePerformanceTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getEmployeePerformanceDAO().enhanceList((List<EmployeePerformance>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeePerformanceDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeePerformanceDAO().present((EmployeePerformance)data, tokens);
			}
			@Override
			public SmartList<EmployeePerformance> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getEmployeePerformanceDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)EmployeePerformance.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("EmployeeWorkExperience", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getEmployeeWorkExperienceDAO().load(id, EmployeeWorkExperienceTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getEmployeeWorkExperienceDAO().enhanceList((List<EmployeeWorkExperience>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeWorkExperienceDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeWorkExperienceDAO().present((EmployeeWorkExperience)data, tokens);
			}
			@Override
			public SmartList<EmployeeWorkExperience> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getEmployeeWorkExperienceDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)EmployeeWorkExperience.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("EmployeeLeave", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getEmployeeLeaveDAO().load(id, EmployeeLeaveTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getEmployeeLeaveDAO().enhanceList((List<EmployeeLeave>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeLeaveDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeLeaveDAO().present((EmployeeLeave)data, tokens);
			}
			@Override
			public SmartList<EmployeeLeave> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getEmployeeLeaveDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)EmployeeLeave.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("EmployeeInterview", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getEmployeeInterviewDAO().load(id, EmployeeInterviewTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getEmployeeInterviewDAO().enhanceList((List<EmployeeInterview>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeInterviewDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeInterviewDAO().present((EmployeeInterview)data, tokens);
			}
			@Override
			public SmartList<EmployeeInterview> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getEmployeeInterviewDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)EmployeeInterview.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("EmployeeAttendance", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getEmployeeAttendanceDAO().load(id, EmployeeAttendanceTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getEmployeeAttendanceDAO().enhanceList((List<EmployeeAttendance>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeAttendanceDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeAttendanceDAO().present((EmployeeAttendance)data, tokens);
			}
			@Override
			public SmartList<EmployeeAttendance> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getEmployeeAttendanceDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)EmployeeAttendance.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("EmployeeQualifier", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getEmployeeQualifierDAO().load(id, EmployeeQualifierTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getEmployeeQualifierDAO().enhanceList((List<EmployeeQualifier>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeQualifierDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeQualifierDAO().present((EmployeeQualifier)data, tokens);
			}
			@Override
			public SmartList<EmployeeQualifier> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getEmployeeQualifierDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)EmployeeQualifier.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("EmployeeEducation", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getEmployeeEducationDAO().load(id, EmployeeEducationTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getEmployeeEducationDAO().enhanceList((List<EmployeeEducation>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeEducationDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeEducationDAO().present((EmployeeEducation)data, tokens);
			}
			@Override
			public SmartList<EmployeeEducation> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getEmployeeEducationDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)EmployeeEducation.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("EmployeeAward", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getEmployeeAwardDAO().load(id, EmployeeAwardTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getEmployeeAwardDAO().enhanceList((List<EmployeeAward>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeAwardDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeAwardDAO().present((EmployeeAward)data, tokens);
			}
			@Override
			public SmartList<EmployeeAward> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getEmployeeAwardDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)EmployeeAward.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("EmployeeSalarySheet", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getEmployeeSalarySheetDAO().load(id, EmployeeSalarySheetTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getEmployeeSalarySheetDAO().enhanceList((List<EmployeeSalarySheet>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeSalarySheetDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getEmployeeSalarySheetDAO().present((EmployeeSalarySheet)data, tokens);
			}
			@Override
			public SmartList<EmployeeSalarySheet> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getEmployeeSalarySheetDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)EmployeeSalarySheet.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("PayingOff", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPayingOffDAO().load(id, PayingOffTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getPayingOffDAO().enhanceList((List<PayingOff>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPayingOffDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPayingOffDAO().present((PayingOff)data, tokens);
			}
			@Override
			public SmartList<PayingOff> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getPayingOffDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)PayingOff.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("MobileApp", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getMobileAppDAO().load(id, MobileAppTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getMobileAppDAO().enhanceList((List<MobileApp>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getMobileAppDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getMobileAppDAO().present((MobileApp)data, tokens);
			}
			@Override
			public SmartList<MobileApp> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getMobileAppDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)MobileApp.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Page", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPageDAO().load(id, PageTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getPageDAO().enhanceList((List<Page>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPageDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPageDAO().present((Page)data, tokens);
			}
			@Override
			public SmartList<Page> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getPageDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Page.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("PageType", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPageTypeDAO().load(id, PageTypeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getPageTypeDAO().enhanceList((List<PageType>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPageTypeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPageTypeDAO().present((PageType)data, tokens);
			}
			@Override
			public SmartList<PageType> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getPageTypeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)PageType.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Slide", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSlideDAO().load(id, SlideTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSlideDAO().enhanceList((List<Slide>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSlideDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSlideDAO().present((Slide)data, tokens);
			}
			@Override
			public SmartList<Slide> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getSlideDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Slide.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("UiAction", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUiActionDAO().load(id, UiActionTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUiActionDAO().enhanceList((List<UiAction>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUiActionDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUiActionDAO().present((UiAction)data, tokens);
			}
			@Override
			public SmartList<UiAction> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getUiActionDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)UiAction.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("Section", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSectionDAO().load(id, SectionTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSectionDAO().enhanceList((List<Section>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSectionDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSectionDAO().present((Section)data, tokens);
			}
			@Override
			public SmartList<Section> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getSectionDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)Section.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("UserDomain", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, UserDomainTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUserDomainDAO().enhanceList((List<UserDomain>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserDomainDAO().present((UserDomain)data, tokens);
			}
			@Override
			public SmartList<UserDomain> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getUserDomainDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)UserDomain.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("UserAllowList", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserAllowListDAO().load(id, UserAllowListTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUserAllowListDAO().enhanceList((List<UserAllowList>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAllowListDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAllowListDAO().present((UserAllowList)data, tokens);
			}
			@Override
			public SmartList<UserAllowList> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getUserAllowListDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)UserAllowList.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("SecUser", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getSecUserDAO().load(id, SecUserTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getSecUserDAO().enhanceList((List<SecUser>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getSecUserDAO().present((SecUser)data, tokens);
			}
			@Override
			public SmartList<SecUser> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getSecUserDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)SecUser.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("UserApp", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getUserAppDAO().load(id, UserAppTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getUserAppDAO().enhanceList((List<UserApp>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getUserAppDAO().present((UserApp)data, tokens);
			}
			@Override
			public SmartList<UserApp> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getUserAppDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)UserApp.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("QuickLink", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getQuickLinkDAO().load(id, QuickLinkTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getQuickLinkDAO().enhanceList((List<QuickLink>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getQuickLinkDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getQuickLinkDAO().present((QuickLink)data, tokens);
			}
			@Override
			public SmartList<QuickLink> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getQuickLinkDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)QuickLink.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("ListAccess", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getListAccessDAO().load(id, ListAccessTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getListAccessDAO().enhanceList((List<ListAccess>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getListAccessDAO().present((ListAccess)data, tokens);
			}
			@Override
			public SmartList<ListAccess> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getListAccessDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)ListAccess.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("LoginHistory", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, LoginHistoryTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getLoginHistoryDAO().enhanceList((List<LoginHistory>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getLoginHistoryDAO().present((LoginHistory)data, tokens);
			}
			@Override
			public SmartList<LoginHistory> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getLoginHistoryDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)LoginHistory.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("CandidateContainer", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCandidateContainerDAO().load(id, CandidateContainerTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCandidateContainerDAO().enhanceList((List<CandidateContainer>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateContainerDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateContainerDAO().present((CandidateContainer)data, tokens);
			}
			@Override
			public SmartList<CandidateContainer> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getCandidateContainerDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)CandidateContainer.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("CandidateElement", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getCandidateElementDAO().load(id, CandidateElementTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getCandidateElementDAO().enhanceList((List<CandidateElement>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateElementDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getCandidateElementDAO().present((CandidateElement)data, tokens);
			}
			@Override
			public SmartList<CandidateElement> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getCandidateElementDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)CandidateElement.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("WechatWorkappIdentity", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getWechatWorkappIdentityDAO().load(id, WechatWorkappIdentityTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getWechatWorkappIdentityDAO().enhanceList((List<WechatWorkappIdentity>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWechatWorkappIdentityDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWechatWorkappIdentityDAO().present((WechatWorkappIdentity)data, tokens);
			}
			@Override
			public SmartList<WechatWorkappIdentity> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getWechatWorkappIdentityDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)WechatWorkappIdentity.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("WechatMiniappIdentity", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getWechatMiniappIdentityDAO().load(id, WechatMiniappIdentityTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getWechatMiniappIdentityDAO().enhanceList((List<WechatMiniappIdentity>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWechatMiniappIdentityDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getWechatMiniappIdentityDAO().present((WechatMiniappIdentity)data, tokens);
			}
			@Override
			public SmartList<WechatMiniappIdentity> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getWechatMiniappIdentityDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)WechatMiniappIdentity.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("KeypairIdentity", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getKeypairIdentityDAO().load(id, KeypairIdentityTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getKeypairIdentityDAO().enhanceList((List<KeypairIdentity>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getKeypairIdentityDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getKeypairIdentityDAO().present((KeypairIdentity)data, tokens);
			}
			@Override
			public SmartList<KeypairIdentity> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getKeypairIdentityDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)KeypairIdentity.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("PublicKeyType", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getPublicKeyTypeDAO().load(id, PublicKeyTypeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getPublicKeyTypeDAO().enhanceList((List<PublicKeyType>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPublicKeyTypeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getPublicKeyTypeDAO().present((PublicKeyType)data, tokens);
			}
			@Override
			public SmartList<PublicKeyType> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getPublicKeyTypeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)PublicKeyType.withId(id)).collect(Collectors.toList());
			}
		});

		internalLoaderMap.put("TreeNode", new BasicLoader() {
			@Override
			public BaseEntity loadBasicData(DAOGroup daoGoup, String id) throws Exception {
				return daoGoup.getTreeNodeDAO().load(id, TreeNodeTokens.withoutLists());
			}
			@Override
			public void enhanceList(DAOGroup daoGoup, List list) throws Exception {
				daoGoup.getTreeNodeDAO().enhanceList((List<TreeNode>)list);
			}
			@Override
			public BaseEntity loadBasicDataWithToken(DAOGroup daoGoup, String id, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTreeNodeDAO().load(id, tokens);
			}
			@Override
			public BaseEntity present(DAOGroup daoGoup, BaseEntity data, Map<String, Object> tokens) throws Exception {
				return daoGoup.getTreeNodeDAO().present((TreeNode)data, tokens);
			}
			@Override
			public SmartList<TreeNode> queryList(DAOGroup daoGoup, String sql, Object ... parmeters) throws Exception {
				return daoGoup.getTreeNodeDAO().queryList(sql, parmeters);
			}
      @Override
			public List<BaseEntity> wrapperList(DAOGroup daoGoup, List<String> ids) throws Exception{
				return ids.stream().map(id-> (BaseEntity)TreeNode.withId(id)).collect(Collectors.toList());
			}
		});

	}
	public BaseEntity loadBasicData(String type, String id){
	    BasicLoader loader = internalLoaderMap.get(type);
	    if (loader == null) {
	    	return null;
	    }
	    try{
	    	return loader.loadBasicData(this, id);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}

	public List<BaseEntity> wrapperList(String type, List<String> ids){
  	    BasicLoader loader = internalLoaderMap.get(type);
  	    if (loader == null) {
  	    	return null;
  	    }
  	    try{
  	    	return loader.wrapperList(this, ids);
  	    }catch(Exception e) {
  	    	e.printStackTrace();
  	    	return null;
  	    }
  	}

	public BaseEntity loadBasicDataWithTokens(String type, String id, Map<String, Object> tokens){
	    BasicLoader loader = internalLoaderMap.get(type);
	    if (loader == null) {
	    	return null;
	    }
	    try{
	    	return loader.loadBasicDataWithToken(this, id, tokens);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public BaseEntity present(BaseEntity data, Map<String, Object> tokens){
	    BasicLoader loader = internalLoaderMap.get(data.getInternalType());
	    if (loader == null || data == null) {
	    	return null;
	    }
	    try{
	    	return loader.present(this, data, tokens);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	public <T> void enhanceList(List list, Class<T> clazz) throws Exception{
	    BasicLoader loader = internalLoaderMap.get(clazz.getSimpleName());
	    if (loader == null) {
	    	return ;
	    }

	    loader.enhanceList(this, list);
	}

	public void enhanceList(List list, String type) throws Exception{
  	    BasicLoader loader = internalLoaderMap.get(type);
  	    if (loader == null) {
  	    	return ;
  	    }

  	    loader.enhanceList(this, list);
  	}

  	public SmartList<? extends BaseEntity> queryList(String type, String sql, Object ... parameters) throws Exception{
  	    BasicLoader loader = internalLoaderMap.get(type);
  	    if (loader == null) {
  	    	return new SmartList();
  	    }

  	    return loader.queryList(this, sql, parameters);
  	}
}

