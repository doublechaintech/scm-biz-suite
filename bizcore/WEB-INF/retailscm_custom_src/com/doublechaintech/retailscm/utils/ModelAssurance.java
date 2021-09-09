package com.doublechaintech.retailscm.utils;
import com.doublechaintech.retailscm.RetailscmUserContext;
import java.util.HashMap;
import java.util.Map;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTable;
import com.doublechaintech.retailscm.catalog.CatalogTable;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryTable;
import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryTable;
import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryTable;
import com.doublechaintech.retailscm.product.ProductTable;
import com.doublechaintech.retailscm.sku.SkuTable;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterTable;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartmentTable;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployeeTable;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterTable;
import com.doublechaintech.retailscm.citypartner.CityPartnerTable;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerTable;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPersonTable;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContactTable;
import com.doublechaintech.retailscm.cityevent.CityEventTable;
import com.doublechaintech.retailscm.eventattendance.EventAttendanceTable;
import com.doublechaintech.retailscm.retailstore.RetailStoreTable;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreationTable;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitationTable;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchisingTable;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecorationTable;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpeningTable;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosingTable;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberTable;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderTable;
import com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItemTable;
import com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroupTable;
import com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroupTable;
import com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustmentTable;
import com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCouponTable;
import com.doublechaintech.retailscm.memberwishlist.MemberWishlistTable;
import com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPointTable;
import com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemptionTable;
import com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProductTable;
import com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddressTable;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardTable;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordTable;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierTable;
import com.doublechaintech.retailscm.supplierproduct.SupplierProductTable;
import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDurationTable;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderTable;
import com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItemTable;
import com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroupTable;
import com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroupTable;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderTable;
import com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItemTable;
import com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroupTable;
import com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroupTable;
import com.doublechaintech.retailscm.warehouse.WarehouseTable;
import com.doublechaintech.retailscm.storagespace.StorageSpaceTable;
import com.doublechaintech.retailscm.smartpallet.SmartPalletTable;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelfTable;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountTable;
import com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrackTable;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocationTable;
import com.doublechaintech.retailscm.goods.GoodsTable;
import com.doublechaintech.retailscm.goodsmovement.GoodsMovementTable;
import com.doublechaintech.retailscm.supplierspace.SupplierSpaceTable;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpaceTable;
import com.doublechaintech.retailscm.shippingspace.ShippingSpaceTable;
import com.doublechaintech.retailscm.damagespace.DamageSpaceTable;
import com.doublechaintech.retailscm.warehouseasset.WarehouseAssetTable;
import com.doublechaintech.retailscm.transportfleet.TransportFleetTable;
import com.doublechaintech.retailscm.transporttruck.TransportTruckTable;
import com.doublechaintech.retailscm.truckdriver.TruckDriverTable;
import com.doublechaintech.retailscm.transporttask.TransportTaskTable;
import com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrackTable;
import com.doublechaintech.retailscm.accountset.AccountSetTable;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubjectTable;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriodTable;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeTable;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentTable;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucherTable;
import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLineTable;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentTable;
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentTable;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentTable;
import com.doublechaintech.retailscm.skilltype.SkillTypeTable;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeTable;
import com.doublechaintech.retailscm.terminationreason.TerminationReasonTable;
import com.doublechaintech.retailscm.terminationtype.TerminationTypeTable;
import com.doublechaintech.retailscm.occupationtype.OccupationTypeTable;
import com.doublechaintech.retailscm.leavetype.LeaveTypeTable;
import com.doublechaintech.retailscm.salarygrade.SalaryGradeTable;
import com.doublechaintech.retailscm.interviewtype.InterviewTypeTable;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeTable;
import com.doublechaintech.retailscm.publicholiday.PublicHolidayTable;
import com.doublechaintech.retailscm.termination.TerminationTable;
import com.doublechaintech.retailscm.view.ViewTable;
import com.doublechaintech.retailscm.employee.EmployeeTable;
import com.doublechaintech.retailscm.instructor.InstructorTable;
import com.doublechaintech.retailscm.companytraining.CompanyTrainingTable;
import com.doublechaintech.retailscm.scoring.ScoringTable;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingTable;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkillTable;
import com.doublechaintech.retailscm.employeeperformance.EmployeePerformanceTable;
import com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperienceTable;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeaveTable;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewTable;
import com.doublechaintech.retailscm.employeeattendance.EmployeeAttendanceTable;
import com.doublechaintech.retailscm.employeequalifier.EmployeeQualifierTable;
import com.doublechaintech.retailscm.employeeeducation.EmployeeEducationTable;
import com.doublechaintech.retailscm.employeeaward.EmployeeAwardTable;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetTable;
import com.doublechaintech.retailscm.payingoff.PayingOffTable;
import com.doublechaintech.retailscm.mobileapp.MobileAppTable;
import com.doublechaintech.retailscm.page.PageTable;
import com.doublechaintech.retailscm.pagetype.PageTypeTable;
import com.doublechaintech.retailscm.slide.SlideTable;
import com.doublechaintech.retailscm.uiaction.UiActionTable;
import com.doublechaintech.retailscm.section.SectionTable;
import com.doublechaintech.retailscm.userdomain.UserDomainTable;
import com.doublechaintech.retailscm.userallowlist.UserAllowListTable;
import com.doublechaintech.retailscm.secuser.SecUserTable;
import com.doublechaintech.retailscm.userapp.UserAppTable;
import com.doublechaintech.retailscm.quicklink.QuickLinkTable;
import com.doublechaintech.retailscm.listaccess.ListAccessTable;
import com.doublechaintech.retailscm.loginhistory.LoginHistoryTable;
import com.doublechaintech.retailscm.candidatecontainer.CandidateContainerTable;
import com.doublechaintech.retailscm.candidateelement.CandidateElementTable;
import com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentityTable;
import com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentityTable;
import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentityTable;
import com.doublechaintech.retailscm.publickeytype.PublicKeyTypeTable;
import com.doublechaintech.retailscm.treenode.TreeNodeTable;

public class ModelAssurance {

    public static Map<String, Object> ensureModelsInDB(RetailscmUserContext ctx) throws Exception{
        Map<String, Object> result = new HashMap<>();
        RetailStoreCountryCenterTable.ensureTable(ctx, result);
        CatalogTable.ensureTable(ctx, result);
        LevelOneCategoryTable.ensureTable(ctx, result);
        LevelTwoCategoryTable.ensureTable(ctx, result);
        LevelThreeCategoryTable.ensureTable(ctx, result);
        ProductTable.ensureTable(ctx, result);
        SkuTable.ensureTable(ctx, result);
        RetailStoreProvinceCenterTable.ensureTable(ctx, result);
        ProvinceCenterDepartmentTable.ensureTable(ctx, result);
        ProvinceCenterEmployeeTable.ensureTable(ctx, result);
        RetailStoreCityServiceCenterTable.ensureTable(ctx, result);
        CityPartnerTable.ensureTable(ctx, result);
        PotentialCustomerTable.ensureTable(ctx, result);
        PotentialCustomerContactPersonTable.ensureTable(ctx, result);
        PotentialCustomerContactTable.ensureTable(ctx, result);
        CityEventTable.ensureTable(ctx, result);
        EventAttendanceTable.ensureTable(ctx, result);
        RetailStoreTable.ensureTable(ctx, result);
        RetailStoreCreationTable.ensureTable(ctx, result);
        RetailStoreInvestmentInvitationTable.ensureTable(ctx, result);
        RetailStoreFranchisingTable.ensureTable(ctx, result);
        RetailStoreDecorationTable.ensureTable(ctx, result);
        RetailStoreOpeningTable.ensureTable(ctx, result);
        RetailStoreClosingTable.ensureTable(ctx, result);
        RetailStoreMemberTable.ensureTable(ctx, result);
        ConsumerOrderTable.ensureTable(ctx, result);
        ConsumerOrderLineItemTable.ensureTable(ctx, result);
        ConsumerOrderShippingGroupTable.ensureTable(ctx, result);
        ConsumerOrderPaymentGroupTable.ensureTable(ctx, result);
        ConsumerOrderPriceAdjustmentTable.ensureTable(ctx, result);
        RetailStoreMemberCouponTable.ensureTable(ctx, result);
        MemberWishlistTable.ensureTable(ctx, result);
        MemberRewardPointTable.ensureTable(ctx, result);
        MemberRewardPointRedemptionTable.ensureTable(ctx, result);
        MemberWishlistProductTable.ensureTable(ctx, result);
        RetailStoreMemberAddressTable.ensureTable(ctx, result);
        RetailStoreMemberGiftCardTable.ensureTable(ctx, result);
        RetailStoreMemberGiftCardConsumeRecordTable.ensureTable(ctx, result);
        GoodsSupplierTable.ensureTable(ctx, result);
        SupplierProductTable.ensureTable(ctx, result);
        ProductSupplyDurationTable.ensureTable(ctx, result);
        SupplyOrderTable.ensureTable(ctx, result);
        SupplyOrderLineItemTable.ensureTable(ctx, result);
        SupplyOrderShippingGroupTable.ensureTable(ctx, result);
        SupplyOrderPaymentGroupTable.ensureTable(ctx, result);
        RetailStoreOrderTable.ensureTable(ctx, result);
        RetailStoreOrderLineItemTable.ensureTable(ctx, result);
        RetailStoreOrderShippingGroupTable.ensureTable(ctx, result);
        RetailStoreOrderPaymentGroupTable.ensureTable(ctx, result);
        WarehouseTable.ensureTable(ctx, result);
        StorageSpaceTable.ensureTable(ctx, result);
        SmartPalletTable.ensureTable(ctx, result);
        GoodsShelfTable.ensureTable(ctx, result);
        GoodsShelfStockCountTable.ensureTable(ctx, result);
        StockCountIssueTrackTable.ensureTable(ctx, result);
        GoodsAllocationTable.ensureTable(ctx, result);
        GoodsTable.ensureTable(ctx, result);
        GoodsMovementTable.ensureTable(ctx, result);
        SupplierSpaceTable.ensureTable(ctx, result);
        ReceivingSpaceTable.ensureTable(ctx, result);
        ShippingSpaceTable.ensureTable(ctx, result);
        DamageSpaceTable.ensureTable(ctx, result);
        WarehouseAssetTable.ensureTable(ctx, result);
        TransportFleetTable.ensureTable(ctx, result);
        TransportTruckTable.ensureTable(ctx, result);
        TruckDriverTable.ensureTable(ctx, result);
        TransportTaskTable.ensureTable(ctx, result);
        TransportTaskTrackTable.ensureTable(ctx, result);
        AccountSetTable.ensureTable(ctx, result);
        AccountingSubjectTable.ensureTable(ctx, result);
        AccountingPeriodTable.ensureTable(ctx, result);
        AccountingDocumentTypeTable.ensureTable(ctx, result);
        AccountingDocumentTable.ensureTable(ctx, result);
        OriginalVoucherTable.ensureTable(ctx, result);
        AccountingDocumentLineTable.ensureTable(ctx, result);
        LevelOneDepartmentTable.ensureTable(ctx, result);
        LevelTwoDepartmentTable.ensureTable(ctx, result);
        LevelThreeDepartmentTable.ensureTable(ctx, result);
        SkillTypeTable.ensureTable(ctx, result);
        ResponsibilityTypeTable.ensureTable(ctx, result);
        TerminationReasonTable.ensureTable(ctx, result);
        TerminationTypeTable.ensureTable(ctx, result);
        OccupationTypeTable.ensureTable(ctx, result);
        LeaveTypeTable.ensureTable(ctx, result);
        SalaryGradeTable.ensureTable(ctx, result);
        InterviewTypeTable.ensureTable(ctx, result);
        TrainingCourseTypeTable.ensureTable(ctx, result);
        PublicHolidayTable.ensureTable(ctx, result);
        TerminationTable.ensureTable(ctx, result);
        ViewTable.ensureTable(ctx, result);
        EmployeeTable.ensureTable(ctx, result);
        InstructorTable.ensureTable(ctx, result);
        CompanyTrainingTable.ensureTable(ctx, result);
        ScoringTable.ensureTable(ctx, result);
        EmployeeCompanyTrainingTable.ensureTable(ctx, result);
        EmployeeSkillTable.ensureTable(ctx, result);
        EmployeePerformanceTable.ensureTable(ctx, result);
        EmployeeWorkExperienceTable.ensureTable(ctx, result);
        EmployeeLeaveTable.ensureTable(ctx, result);
        EmployeeInterviewTable.ensureTable(ctx, result);
        EmployeeAttendanceTable.ensureTable(ctx, result);
        EmployeeQualifierTable.ensureTable(ctx, result);
        EmployeeEducationTable.ensureTable(ctx, result);
        EmployeeAwardTable.ensureTable(ctx, result);
        EmployeeSalarySheetTable.ensureTable(ctx, result);
        PayingOffTable.ensureTable(ctx, result);
        MobileAppTable.ensureTable(ctx, result);
        PageTable.ensureTable(ctx, result);
        PageTypeTable.ensureTable(ctx, result);
        SlideTable.ensureTable(ctx, result);
        UiActionTable.ensureTable(ctx, result);
        SectionTable.ensureTable(ctx, result);
        UserDomainTable.ensureTable(ctx, result);
        UserAllowListTable.ensureTable(ctx, result);
        SecUserTable.ensureTable(ctx, result);
        UserAppTable.ensureTable(ctx, result);
        QuickLinkTable.ensureTable(ctx, result);
        ListAccessTable.ensureTable(ctx, result);
        LoginHistoryTable.ensureTable(ctx, result);
        CandidateContainerTable.ensureTable(ctx, result);
        CandidateElementTable.ensureTable(ctx, result);
        WechatWorkappIdentityTable.ensureTable(ctx, result);
        WechatMiniappIdentityTable.ensureTable(ctx, result);
        KeyPairIdentityTable.ensureTable(ctx, result);
        PublicKeyTypeTable.ensureTable(ctx, result);
        TreeNodeTable.ensureTable(ctx, result);


        PageTypeTable.ensureData(ctx, result);

        return result;
    }

}






















































