

import React from 'react'
import { Router, Route, Switch } from 'dva/router'
import { LocaleProvider } from 'antd'
import zhCN from 'antd/lib/locale-provider/zh_CN'
// import enUS from 'antd/lib/locale-provider/en_US'
import Launcher from '../launcher/Launcher'
import ForgetPasswordForm from '../launcher/ForgetPasswordForm'

import GlobalComponents from './'


function RouterConfig({ history }) {

	const {RetailStoreCountryCenterBizApp} = GlobalComponents
	const {ReportBizApp} = GlobalComponents
	const {ReportLineBizApp} = GlobalComponents
	const {CatalogBizApp} = GlobalComponents
	const {LevelOneCategoryBizApp} = GlobalComponents
	const {LevelTwoCategoryBizApp} = GlobalComponents
	const {LevelThreeCategoryBizApp} = GlobalComponents
	const {ProductBizApp} = GlobalComponents
	const {SkuBizApp} = GlobalComponents
	const {RetailStoreProvinceCenterBizApp} = GlobalComponents
	const {ProvinceCenterDepartmentBizApp} = GlobalComponents
	const {ProvinceCenterEmployeeBizApp} = GlobalComponents
	const {RetailStoreCityServiceCenterBizApp} = GlobalComponents
	const {CityPartnerBizApp} = GlobalComponents
	const {PotentialCustomerBizApp} = GlobalComponents
	const {PotentialCustomerContactPersonBizApp} = GlobalComponents
	const {PotentialCustomerContactBizApp} = GlobalComponents
	const {CityEventBizApp} = GlobalComponents
	const {EventAttendanceBizApp} = GlobalComponents
	const {RetailStoreBizApp} = GlobalComponents
	const {RetailStoreCreationBizApp} = GlobalComponents
	const {RetailStoreInvestmentInvitationBizApp} = GlobalComponents
	const {RetailStoreFranchisingBizApp} = GlobalComponents
	const {RetailStoreDecorationBizApp} = GlobalComponents
	const {RetailStoreOpeningBizApp} = GlobalComponents
	const {RetailStoreClosingBizApp} = GlobalComponents
	const {RetailStoreMemberBizApp} = GlobalComponents
	const {ConsumerOrderBizApp} = GlobalComponents
	const {ConsumerOrderConfirmationBizApp} = GlobalComponents
	const {ConsumerOrderApprovalBizApp} = GlobalComponents
	const {ConsumerOrderProcessingBizApp} = GlobalComponents
	const {ConsumerOrderShipmentBizApp} = GlobalComponents
	const {ConsumerOrderDeliveryBizApp} = GlobalComponents
	const {ConsumerOrderLineItemBizApp} = GlobalComponents
	const {ConsumerOrderShippingGroupBizApp} = GlobalComponents
	const {ConsumerOrderPaymentGroupBizApp} = GlobalComponents
	const {ConsumerOrderPriceAdjustmentBizApp} = GlobalComponents
	const {RetailStoreMemberCouponBizApp} = GlobalComponents
	const {MemberWishlistBizApp} = GlobalComponents
	const {MemberRewardPointBizApp} = GlobalComponents
	const {MemberRewardPointRedemptionBizApp} = GlobalComponents
	const {MemberWishlistProductBizApp} = GlobalComponents
	const {RetailStoreMemberAddressBizApp} = GlobalComponents
	const {RetailStoreMemberGiftCardBizApp} = GlobalComponents
	const {RetailStoreMemberGiftCardConsumeRecordBizApp} = GlobalComponents
	const {GoodsSupplierBizApp} = GlobalComponents
	const {SupplierProductBizApp} = GlobalComponents
	const {ProductSupplyDurationBizApp} = GlobalComponents
	const {SupplyOrderBizApp} = GlobalComponents
	const {SupplyOrderConfirmationBizApp} = GlobalComponents
	const {SupplyOrderApprovalBizApp} = GlobalComponents
	const {SupplyOrderProcessingBizApp} = GlobalComponents
	const {SupplyOrderPickingBizApp} = GlobalComponents
	const {SupplyOrderShipmentBizApp} = GlobalComponents
	const {SupplyOrderDeliveryBizApp} = GlobalComponents
	const {SupplyOrderLineItemBizApp} = GlobalComponents
	const {SupplyOrderShippingGroupBizApp} = GlobalComponents
	const {SupplyOrderPaymentGroupBizApp} = GlobalComponents
	const {RetailStoreOrderBizApp} = GlobalComponents
	const {RetailStoreOrderConfirmationBizApp} = GlobalComponents
	const {RetailStoreOrderApprovalBizApp} = GlobalComponents
	const {RetailStoreOrderProcessingBizApp} = GlobalComponents
	const {RetailStoreOrderPickingBizApp} = GlobalComponents
	const {RetailStoreOrderShipmentBizApp} = GlobalComponents
	const {RetailStoreOrderDeliveryBizApp} = GlobalComponents
	const {RetailStoreOrderLineItemBizApp} = GlobalComponents
	const {RetailStoreOrderShippingGroupBizApp} = GlobalComponents
	const {RetailStoreOrderPaymentGroupBizApp} = GlobalComponents
	const {WarehouseBizApp} = GlobalComponents
	const {StorageSpaceBizApp} = GlobalComponents
	const {SmartPalletBizApp} = GlobalComponents
	const {GoodsShelfBizApp} = GlobalComponents
	const {GoodsShelfStockCountBizApp} = GlobalComponents
	const {StockCountIssueTrackBizApp} = GlobalComponents
	const {GoodsAllocationBizApp} = GlobalComponents
	const {GoodsBizApp} = GlobalComponents
	const {GoodsPackagingBizApp} = GlobalComponents
	const {GoodsMovementBizApp} = GlobalComponents
	const {SupplierSpaceBizApp} = GlobalComponents
	const {ReceivingSpaceBizApp} = GlobalComponents
	const {ShippingSpaceBizApp} = GlobalComponents
	const {DamageSpaceBizApp} = GlobalComponents
	const {WarehouseAssetBizApp} = GlobalComponents
	const {TransportFleetBizApp} = GlobalComponents
	const {TransportTruckBizApp} = GlobalComponents
	const {TruckDriverBizApp} = GlobalComponents
	const {TransportTaskBizApp} = GlobalComponents
	const {TransportTaskTrackBizApp} = GlobalComponents
	const {AccountSetBizApp} = GlobalComponents
	const {AccountingSubjectBizApp} = GlobalComponents
	const {AccountingPeriodBizApp} = GlobalComponents
	const {AccountingDocumentTypeBizApp} = GlobalComponents
	const {AccountingDocumentBizApp} = GlobalComponents
	const {AccountingDocumentCreationBizApp} = GlobalComponents
	const {AccountingDocumentConfirmationBizApp} = GlobalComponents
	const {AccountingDocumentAuditingBizApp} = GlobalComponents
	const {AccountingDocumentPostingBizApp} = GlobalComponents
	const {OriginalVoucherBizApp} = GlobalComponents
	const {OriginalVoucherCreationBizApp} = GlobalComponents
	const {OriginalVoucherConfirmationBizApp} = GlobalComponents
	const {OriginalVoucherAuditingBizApp} = GlobalComponents
	const {AccountingDocumentLineBizApp} = GlobalComponents
	const {LevelOneDepartmentBizApp} = GlobalComponents
	const {LevelTwoDepartmentBizApp} = GlobalComponents
	const {LevelThreeDepartmentBizApp} = GlobalComponents
	const {SkillTypeBizApp} = GlobalComponents
	const {ResponsibilityTypeBizApp} = GlobalComponents
	const {TerminationReasonBizApp} = GlobalComponents
	const {TerminationTypeBizApp} = GlobalComponents
	const {OccupationTypeBizApp} = GlobalComponents
	const {LeaveTypeBizApp} = GlobalComponents
	const {SalaryGradeBizApp} = GlobalComponents
	const {InterviewTypeBizApp} = GlobalComponents
	const {TrainingCourseTypeBizApp} = GlobalComponents
	const {PublicHolidayBizApp} = GlobalComponents
	const {TerminationBizApp} = GlobalComponents
	const {ViewBizApp} = GlobalComponents
	const {EmployeeBizApp} = GlobalComponents
	const {JobApplicationBizApp} = GlobalComponents
	const {ProfessionInterviewBizApp} = GlobalComponents
	const {HrInterviewBizApp} = GlobalComponents
	const {OfferApprovalBizApp} = GlobalComponents
	const {OfferAcceptanceBizApp} = GlobalComponents
	const {EmployeeBoardingBizApp} = GlobalComponents
	const {InstructorBizApp} = GlobalComponents
	const {CompanyTrainingBizApp} = GlobalComponents
	const {ScoringBizApp} = GlobalComponents
	const {EmployeeCompanyTrainingBizApp} = GlobalComponents
	const {EmployeeSkillBizApp} = GlobalComponents
	const {EmployeePerformanceBizApp} = GlobalComponents
	const {EmployeeWorkExperienceBizApp} = GlobalComponents
	const {EmployeeLeaveBizApp} = GlobalComponents
	const {EmployeeInterviewBizApp} = GlobalComponents
	const {EmployeeAttendanceBizApp} = GlobalComponents
	const {EmployeeQualifierBizApp} = GlobalComponents
	const {EmployeeEducationBizApp} = GlobalComponents
	const {EmployeeAwardBizApp} = GlobalComponents
	const {EmployeeSalarySheetBizApp} = GlobalComponents
	const {PayingOffBizApp} = GlobalComponents
	const {UserDomainBizApp} = GlobalComponents
	const {UserWhiteListBizApp} = GlobalComponents
	const {SecUserBizApp} = GlobalComponents
	const {SecUserBlockingBizApp} = GlobalComponents
	const {UserAppBizApp} = GlobalComponents
	const {ListAccessBizApp} = GlobalComponents
	const {ObjectAccessBizApp} = GlobalComponents
	const {LoginHistoryBizApp} = GlobalComponents



  return (
    <LocaleProvider locale={zhCN}>
      <Router history={history}>
        <Switch>
         <Route path="/home" component={Launcher} />
         <Route path="/forgetpass" component={ForgetPasswordForm} />
          <Route path="/retailStoreCountryCenter/" component={RetailStoreCountryCenterBizApp} />
          <Route path="/report/" component={ReportBizApp} />
          <Route path="/reportLine/" component={ReportLineBizApp} />
          <Route path="/catalog/" component={CatalogBizApp} />
          <Route path="/levelOneCategory/" component={LevelOneCategoryBizApp} />
          <Route path="/levelTwoCategory/" component={LevelTwoCategoryBizApp} />
          <Route path="/levelThreeCategory/" component={LevelThreeCategoryBizApp} />
          <Route path="/product/" component={ProductBizApp} />
          <Route path="/sku/" component={SkuBizApp} />
          <Route path="/retailStoreProvinceCenter/" component={RetailStoreProvinceCenterBizApp} />
          <Route path="/provinceCenterDepartment/" component={ProvinceCenterDepartmentBizApp} />
          <Route path="/provinceCenterEmployee/" component={ProvinceCenterEmployeeBizApp} />
          <Route path="/retailStoreCityServiceCenter/" component={RetailStoreCityServiceCenterBizApp} />
          <Route path="/cityPartner/" component={CityPartnerBizApp} />
          <Route path="/potentialCustomer/" component={PotentialCustomerBizApp} />
          <Route path="/potentialCustomerContactPerson/" component={PotentialCustomerContactPersonBizApp} />
          <Route path="/potentialCustomerContact/" component={PotentialCustomerContactBizApp} />
          <Route path="/cityEvent/" component={CityEventBizApp} />
          <Route path="/eventAttendance/" component={EventAttendanceBizApp} />
          <Route path="/retailStore/" component={RetailStoreBizApp} />
          <Route path="/retailStoreCreation/" component={RetailStoreCreationBizApp} />
          <Route path="/retailStoreInvestmentInvitation/" component={RetailStoreInvestmentInvitationBizApp} />
          <Route path="/retailStoreFranchising/" component={RetailStoreFranchisingBizApp} />
          <Route path="/retailStoreDecoration/" component={RetailStoreDecorationBizApp} />
          <Route path="/retailStoreOpening/" component={RetailStoreOpeningBizApp} />
          <Route path="/retailStoreClosing/" component={RetailStoreClosingBizApp} />
          <Route path="/retailStoreMember/" component={RetailStoreMemberBizApp} />
          <Route path="/consumerOrder/" component={ConsumerOrderBizApp} />
          <Route path="/consumerOrderConfirmation/" component={ConsumerOrderConfirmationBizApp} />
          <Route path="/consumerOrderApproval/" component={ConsumerOrderApprovalBizApp} />
          <Route path="/consumerOrderProcessing/" component={ConsumerOrderProcessingBizApp} />
          <Route path="/consumerOrderShipment/" component={ConsumerOrderShipmentBizApp} />
          <Route path="/consumerOrderDelivery/" component={ConsumerOrderDeliveryBizApp} />
          <Route path="/consumerOrderLineItem/" component={ConsumerOrderLineItemBizApp} />
          <Route path="/consumerOrderShippingGroup/" component={ConsumerOrderShippingGroupBizApp} />
          <Route path="/consumerOrderPaymentGroup/" component={ConsumerOrderPaymentGroupBizApp} />
          <Route path="/consumerOrderPriceAdjustment/" component={ConsumerOrderPriceAdjustmentBizApp} />
          <Route path="/retailStoreMemberCoupon/" component={RetailStoreMemberCouponBizApp} />
          <Route path="/memberWishlist/" component={MemberWishlistBizApp} />
          <Route path="/memberRewardPoint/" component={MemberRewardPointBizApp} />
          <Route path="/memberRewardPointRedemption/" component={MemberRewardPointRedemptionBizApp} />
          <Route path="/memberWishlistProduct/" component={MemberWishlistProductBizApp} />
          <Route path="/retailStoreMemberAddress/" component={RetailStoreMemberAddressBizApp} />
          <Route path="/retailStoreMemberGiftCard/" component={RetailStoreMemberGiftCardBizApp} />
          <Route path="/retailStoreMemberGiftCardConsumeRecord/" component={RetailStoreMemberGiftCardConsumeRecordBizApp} />
          <Route path="/goodsSupplier/" component={GoodsSupplierBizApp} />
          <Route path="/supplierProduct/" component={SupplierProductBizApp} />
          <Route path="/productSupplyDuration/" component={ProductSupplyDurationBizApp} />
          <Route path="/supplyOrder/" component={SupplyOrderBizApp} />
          <Route path="/supplyOrderConfirmation/" component={SupplyOrderConfirmationBizApp} />
          <Route path="/supplyOrderApproval/" component={SupplyOrderApprovalBizApp} />
          <Route path="/supplyOrderProcessing/" component={SupplyOrderProcessingBizApp} />
          <Route path="/supplyOrderPicking/" component={SupplyOrderPickingBizApp} />
          <Route path="/supplyOrderShipment/" component={SupplyOrderShipmentBizApp} />
          <Route path="/supplyOrderDelivery/" component={SupplyOrderDeliveryBizApp} />
          <Route path="/supplyOrderLineItem/" component={SupplyOrderLineItemBizApp} />
          <Route path="/supplyOrderShippingGroup/" component={SupplyOrderShippingGroupBizApp} />
          <Route path="/supplyOrderPaymentGroup/" component={SupplyOrderPaymentGroupBizApp} />
          <Route path="/retailStoreOrder/" component={RetailStoreOrderBizApp} />
          <Route path="/retailStoreOrderConfirmation/" component={RetailStoreOrderConfirmationBizApp} />
          <Route path="/retailStoreOrderApproval/" component={RetailStoreOrderApprovalBizApp} />
          <Route path="/retailStoreOrderProcessing/" component={RetailStoreOrderProcessingBizApp} />
          <Route path="/retailStoreOrderPicking/" component={RetailStoreOrderPickingBizApp} />
          <Route path="/retailStoreOrderShipment/" component={RetailStoreOrderShipmentBizApp} />
          <Route path="/retailStoreOrderDelivery/" component={RetailStoreOrderDeliveryBizApp} />
          <Route path="/retailStoreOrderLineItem/" component={RetailStoreOrderLineItemBizApp} />
          <Route path="/retailStoreOrderShippingGroup/" component={RetailStoreOrderShippingGroupBizApp} />
          <Route path="/retailStoreOrderPaymentGroup/" component={RetailStoreOrderPaymentGroupBizApp} />
          <Route path="/warehouse/" component={WarehouseBizApp} />
          <Route path="/storageSpace/" component={StorageSpaceBizApp} />
          <Route path="/smartPallet/" component={SmartPalletBizApp} />
          <Route path="/goodsShelf/" component={GoodsShelfBizApp} />
          <Route path="/goodsShelfStockCount/" component={GoodsShelfStockCountBizApp} />
          <Route path="/stockCountIssueTrack/" component={StockCountIssueTrackBizApp} />
          <Route path="/goodsAllocation/" component={GoodsAllocationBizApp} />
          <Route path="/goods/" component={GoodsBizApp} />
          <Route path="/goodsPackaging/" component={GoodsPackagingBizApp} />
          <Route path="/goodsMovement/" component={GoodsMovementBizApp} />
          <Route path="/supplierSpace/" component={SupplierSpaceBizApp} />
          <Route path="/receivingSpace/" component={ReceivingSpaceBizApp} />
          <Route path="/shippingSpace/" component={ShippingSpaceBizApp} />
          <Route path="/damageSpace/" component={DamageSpaceBizApp} />
          <Route path="/warehouseAsset/" component={WarehouseAssetBizApp} />
          <Route path="/transportFleet/" component={TransportFleetBizApp} />
          <Route path="/transportTruck/" component={TransportTruckBizApp} />
          <Route path="/truckDriver/" component={TruckDriverBizApp} />
          <Route path="/transportTask/" component={TransportTaskBizApp} />
          <Route path="/transportTaskTrack/" component={TransportTaskTrackBizApp} />
          <Route path="/accountSet/" component={AccountSetBizApp} />
          <Route path="/accountingSubject/" component={AccountingSubjectBizApp} />
          <Route path="/accountingPeriod/" component={AccountingPeriodBizApp} />
          <Route path="/accountingDocumentType/" component={AccountingDocumentTypeBizApp} />
          <Route path="/accountingDocument/" component={AccountingDocumentBizApp} />
          <Route path="/accountingDocumentCreation/" component={AccountingDocumentCreationBizApp} />
          <Route path="/accountingDocumentConfirmation/" component={AccountingDocumentConfirmationBizApp} />
          <Route path="/accountingDocumentAuditing/" component={AccountingDocumentAuditingBizApp} />
          <Route path="/accountingDocumentPosting/" component={AccountingDocumentPostingBizApp} />
          <Route path="/originalVoucher/" component={OriginalVoucherBizApp} />
          <Route path="/originalVoucherCreation/" component={OriginalVoucherCreationBizApp} />
          <Route path="/originalVoucherConfirmation/" component={OriginalVoucherConfirmationBizApp} />
          <Route path="/originalVoucherAuditing/" component={OriginalVoucherAuditingBizApp} />
          <Route path="/accountingDocumentLine/" component={AccountingDocumentLineBizApp} />
          <Route path="/levelOneDepartment/" component={LevelOneDepartmentBizApp} />
          <Route path="/levelTwoDepartment/" component={LevelTwoDepartmentBizApp} />
          <Route path="/levelThreeDepartment/" component={LevelThreeDepartmentBizApp} />
          <Route path="/skillType/" component={SkillTypeBizApp} />
          <Route path="/responsibilityType/" component={ResponsibilityTypeBizApp} />
          <Route path="/terminationReason/" component={TerminationReasonBizApp} />
          <Route path="/terminationType/" component={TerminationTypeBizApp} />
          <Route path="/occupationType/" component={OccupationTypeBizApp} />
          <Route path="/leaveType/" component={LeaveTypeBizApp} />
          <Route path="/salaryGrade/" component={SalaryGradeBizApp} />
          <Route path="/interviewType/" component={InterviewTypeBizApp} />
          <Route path="/trainingCourseType/" component={TrainingCourseTypeBizApp} />
          <Route path="/publicHoliday/" component={PublicHolidayBizApp} />
          <Route path="/termination/" component={TerminationBizApp} />
          <Route path="/view/" component={ViewBizApp} />
          <Route path="/employee/" component={EmployeeBizApp} />
          <Route path="/jobApplication/" component={JobApplicationBizApp} />
          <Route path="/professionInterview/" component={ProfessionInterviewBizApp} />
          <Route path="/hrInterview/" component={HrInterviewBizApp} />
          <Route path="/offerApproval/" component={OfferApprovalBizApp} />
          <Route path="/offerAcceptance/" component={OfferAcceptanceBizApp} />
          <Route path="/employeeBoarding/" component={EmployeeBoardingBizApp} />
          <Route path="/instructor/" component={InstructorBizApp} />
          <Route path="/companyTraining/" component={CompanyTrainingBizApp} />
          <Route path="/scoring/" component={ScoringBizApp} />
          <Route path="/employeeCompanyTraining/" component={EmployeeCompanyTrainingBizApp} />
          <Route path="/employeeSkill/" component={EmployeeSkillBizApp} />
          <Route path="/employeePerformance/" component={EmployeePerformanceBizApp} />
          <Route path="/employeeWorkExperience/" component={EmployeeWorkExperienceBizApp} />
          <Route path="/employeeLeave/" component={EmployeeLeaveBizApp} />
          <Route path="/employeeInterview/" component={EmployeeInterviewBizApp} />
          <Route path="/employeeAttendance/" component={EmployeeAttendanceBizApp} />
          <Route path="/employeeQualifier/" component={EmployeeQualifierBizApp} />
          <Route path="/employeeEducation/" component={EmployeeEducationBizApp} />
          <Route path="/employeeAward/" component={EmployeeAwardBizApp} />
          <Route path="/employeeSalarySheet/" component={EmployeeSalarySheetBizApp} />
          <Route path="/payingOff/" component={PayingOffBizApp} />
          <Route path="/userDomain/" component={UserDomainBizApp} />
          <Route path="/userWhiteList/" component={UserWhiteListBizApp} />
          <Route path="/secUser/" component={SecUserBizApp} />
          <Route path="/secUserBlocking/" component={SecUserBlockingBizApp} />
          <Route path="/userApp/" component={UserAppBizApp} />
          <Route path="/listAccess/" component={ListAccessBizApp} />
          <Route path="/objectAccess/" component={ObjectAccessBizApp} />
          <Route path="/loginHistory/" component={LoginHistoryBizApp} />
         <Route path="/" component={Launcher} />
        </Switch>
      </Router>
    </LocaleProvider>
  )
}

export default RouterConfig










