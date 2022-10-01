package com.doublechaintech.retailscm.search;

public class Q {
  static final String VERSION_PROPERTY = "version";

  public static com.doublechaintech.retailscm.retailstorecountrycenter
          .RetailStoreCountryCenterRequest
      retailStoreCountryCenter() {
    return com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.retailstorecountrycenter
          .RetailStoreCountryCenterRequest
      retailStoreCountryCenterWithIdField() {
    return com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.retailstorecountrycenter
          .RetailStoreCountryCenterRequest
      retailStoreCountryCenter(String id) {
    return retailStoreCountryCenter().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.catalog.CatalogRequest catalog() {
    return com.doublechaintech.retailscm.catalog.CatalogRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.catalog.CatalogRequest catalogWithIdField() {
    return com.doublechaintech.retailscm.catalog.CatalogRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.catalog.CatalogRequest catalog(String id) {
    return catalog().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryRequest
      levelOneCategory() {
    return com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryRequest
      levelOneCategoryWithIdField() {
    return com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryRequest
      levelOneCategory(String id) {
    return levelOneCategory().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryRequest
      levelTwoCategory() {
    return com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryRequest
      levelTwoCategoryWithIdField() {
    return com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryRequest
      levelTwoCategory(String id) {
    return levelTwoCategory().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryRequest
      levelThreeCategory() {
    return com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryRequest
      levelThreeCategoryWithIdField() {
    return com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryRequest
      levelThreeCategory(String id) {
    return levelThreeCategory().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.product.ProductRequest product() {
    return com.doublechaintech.retailscm.product.ProductRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.product.ProductRequest productWithIdField() {
    return com.doublechaintech.retailscm.product.ProductRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.product.ProductRequest product(String id) {
    return product().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.sku.SkuRequest sku() {
    return com.doublechaintech.retailscm.sku.SkuRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.sku.SkuRequest skuWithIdField() {
    return com.doublechaintech.retailscm.sku.SkuRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.sku.SkuRequest sku(String id) {
    return sku().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.retailstoreprovincecenter
          .RetailStoreProvinceCenterRequest
      retailStoreProvinceCenter() {
    return com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.retailstoreprovincecenter
          .RetailStoreProvinceCenterRequest
      retailStoreProvinceCenterWithIdField() {
    return com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.retailstoreprovincecenter
          .RetailStoreProvinceCenterRequest
      retailStoreProvinceCenter(String id) {
    return retailStoreProvinceCenter().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.provincecenterdepartment
          .ProvinceCenterDepartmentRequest
      provinceCenterDepartment() {
    return com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartmentRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.provincecenterdepartment
          .ProvinceCenterDepartmentRequest
      provinceCenterDepartmentWithIdField() {
    return com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartmentRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.provincecenterdepartment
          .ProvinceCenterDepartmentRequest
      provinceCenterDepartment(String id) {
    return provinceCenterDepartment().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployeeRequest
      provinceCenterEmployee() {
    return com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployeeRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployeeRequest
      provinceCenterEmployeeWithIdField() {
    return com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployeeRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployeeRequest
      provinceCenterEmployee(String id) {
    return provinceCenterEmployee().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.retailstorecityservicecenter
          .RetailStoreCityServiceCenterRequest
      retailStoreCityServiceCenter() {
    return com.doublechaintech.retailscm.retailstorecityservicecenter
        .RetailStoreCityServiceCenterRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.retailstorecityservicecenter
          .RetailStoreCityServiceCenterRequest
      retailStoreCityServiceCenterWithIdField() {
    return com.doublechaintech.retailscm.retailstorecityservicecenter
        .RetailStoreCityServiceCenterRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.retailstorecityservicecenter
          .RetailStoreCityServiceCenterRequest
      retailStoreCityServiceCenter(String id) {
    return retailStoreCityServiceCenter().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.citypartner.CityPartnerRequest cityPartner() {
    return com.doublechaintech.retailscm.citypartner.CityPartnerRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.citypartner.CityPartnerRequest
      cityPartnerWithIdField() {
    return com.doublechaintech.retailscm.citypartner.CityPartnerRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.citypartner.CityPartnerRequest cityPartner(
      String id) {
    return cityPartner().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerRequest
      potentialCustomer() {
    return com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerRequest
      potentialCustomerWithIdField() {
    return com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerRequest
      potentialCustomer(String id) {
    return potentialCustomer().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.potentialcustomercontactperson
          .PotentialCustomerContactPersonRequest
      potentialCustomerContactPerson() {
    return com.doublechaintech.retailscm.potentialcustomercontactperson
        .PotentialCustomerContactPersonRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.potentialcustomercontactperson
          .PotentialCustomerContactPersonRequest
      potentialCustomerContactPersonWithIdField() {
    return com.doublechaintech.retailscm.potentialcustomercontactperson
        .PotentialCustomerContactPersonRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.potentialcustomercontactperson
          .PotentialCustomerContactPersonRequest
      potentialCustomerContactPerson(String id) {
    return potentialCustomerContactPerson().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.potentialcustomercontact
          .PotentialCustomerContactRequest
      potentialCustomerContact() {
    return com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContactRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.potentialcustomercontact
          .PotentialCustomerContactRequest
      potentialCustomerContactWithIdField() {
    return com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContactRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.potentialcustomercontact
          .PotentialCustomerContactRequest
      potentialCustomerContact(String id) {
    return potentialCustomerContact().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.cityevent.CityEventRequest cityEvent() {
    return com.doublechaintech.retailscm.cityevent.CityEventRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.cityevent.CityEventRequest cityEventWithIdField() {
    return com.doublechaintech.retailscm.cityevent.CityEventRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.cityevent.CityEventRequest cityEvent(String id) {
    return cityEvent().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.eventattendance.EventAttendanceRequest
      eventAttendance() {
    return com.doublechaintech.retailscm.eventattendance.EventAttendanceRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.eventattendance.EventAttendanceRequest
      eventAttendanceWithIdField() {
    return com.doublechaintech.retailscm.eventattendance.EventAttendanceRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.eventattendance.EventAttendanceRequest
      eventAttendance(String id) {
    return eventAttendance().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.retailstore.RetailStoreRequest retailStore() {
    return com.doublechaintech.retailscm.retailstore.RetailStoreRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.retailstore.RetailStoreRequest
      retailStoreWithIdField() {
    return com.doublechaintech.retailscm.retailstore.RetailStoreRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.retailstore.RetailStoreRequest retailStore(
      String id) {
    return retailStore().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreationRequest
      retailStoreCreation() {
    return com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreationRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreationRequest
      retailStoreCreationWithIdField() {
    return com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreationRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreationRequest
      retailStoreCreation(String id) {
    return retailStoreCreation().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.retailstoreinvestmentinvitation
          .RetailStoreInvestmentInvitationRequest
      retailStoreInvestmentInvitation() {
    return com.doublechaintech.retailscm.retailstoreinvestmentinvitation
        .RetailStoreInvestmentInvitationRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.retailstoreinvestmentinvitation
          .RetailStoreInvestmentInvitationRequest
      retailStoreInvestmentInvitationWithIdField() {
    return com.doublechaintech.retailscm.retailstoreinvestmentinvitation
        .RetailStoreInvestmentInvitationRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.retailstoreinvestmentinvitation
          .RetailStoreInvestmentInvitationRequest
      retailStoreInvestmentInvitation(String id) {
    return retailStoreInvestmentInvitation().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchisingRequest
      retailStoreFranchising() {
    return com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchisingRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchisingRequest
      retailStoreFranchisingWithIdField() {
    return com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchisingRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchisingRequest
      retailStoreFranchising(String id) {
    return retailStoreFranchising().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecorationRequest
      retailStoreDecoration() {
    return com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecorationRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecorationRequest
      retailStoreDecorationWithIdField() {
    return com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecorationRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecorationRequest
      retailStoreDecoration(String id) {
    return retailStoreDecoration().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpeningRequest
      retailStoreOpening() {
    return com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpeningRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpeningRequest
      retailStoreOpeningWithIdField() {
    return com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpeningRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpeningRequest
      retailStoreOpening(String id) {
    return retailStoreOpening().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosingRequest
      retailStoreClosing() {
    return com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosingRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosingRequest
      retailStoreClosingWithIdField() {
    return com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosingRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosingRequest
      retailStoreClosing(String id) {
    return retailStoreClosing().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberRequest
      retailStoreMember() {
    return com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberRequest
      retailStoreMemberWithIdField() {
    return com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberRequest
      retailStoreMember(String id) {
    return retailStoreMember().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.consumerorder.ConsumerOrderRequest consumerOrder() {
    return com.doublechaintech.retailscm.consumerorder.ConsumerOrderRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.consumerorder.ConsumerOrderRequest
      consumerOrderWithIdField() {
    return com.doublechaintech.retailscm.consumerorder.ConsumerOrderRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.consumerorder.ConsumerOrderRequest consumerOrder(
      String id) {
    return consumerOrder().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItemRequest
      consumerOrderLineItem() {
    return com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItemRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItemRequest
      consumerOrderLineItemWithIdField() {
    return com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItemRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItemRequest
      consumerOrderLineItem(String id) {
    return consumerOrderLineItem().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.consumerordershippinggroup
          .ConsumerOrderShippingGroupRequest
      consumerOrderShippingGroup() {
    return com.doublechaintech.retailscm.consumerordershippinggroup
        .ConsumerOrderShippingGroupRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.consumerordershippinggroup
          .ConsumerOrderShippingGroupRequest
      consumerOrderShippingGroupWithIdField() {
    return com.doublechaintech.retailscm.consumerordershippinggroup
        .ConsumerOrderShippingGroupRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.consumerordershippinggroup
          .ConsumerOrderShippingGroupRequest
      consumerOrderShippingGroup(String id) {
    return consumerOrderShippingGroup().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.consumerorderpaymentgroup
          .ConsumerOrderPaymentGroupRequest
      consumerOrderPaymentGroup() {
    return com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroupRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.consumerorderpaymentgroup
          .ConsumerOrderPaymentGroupRequest
      consumerOrderPaymentGroupWithIdField() {
    return com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroupRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.consumerorderpaymentgroup
          .ConsumerOrderPaymentGroupRequest
      consumerOrderPaymentGroup(String id) {
    return consumerOrderPaymentGroup().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.consumerorderpriceadjustment
          .ConsumerOrderPriceAdjustmentRequest
      consumerOrderPriceAdjustment() {
    return com.doublechaintech.retailscm.consumerorderpriceadjustment
        .ConsumerOrderPriceAdjustmentRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.consumerorderpriceadjustment
          .ConsumerOrderPriceAdjustmentRequest
      consumerOrderPriceAdjustmentWithIdField() {
    return com.doublechaintech.retailscm.consumerorderpriceadjustment
        .ConsumerOrderPriceAdjustmentRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.consumerorderpriceadjustment
          .ConsumerOrderPriceAdjustmentRequest
      consumerOrderPriceAdjustment(String id) {
    return consumerOrderPriceAdjustment().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCouponRequest
      retailStoreMemberCoupon() {
    return com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCouponRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCouponRequest
      retailStoreMemberCouponWithIdField() {
    return com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCouponRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCouponRequest
      retailStoreMemberCoupon(String id) {
    return retailStoreMemberCoupon().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.memberwishlist.MemberWishlistRequest
      memberWishlist() {
    return com.doublechaintech.retailscm.memberwishlist.MemberWishlistRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.memberwishlist.MemberWishlistRequest
      memberWishlistWithIdField() {
    return com.doublechaintech.retailscm.memberwishlist.MemberWishlistRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.memberwishlist.MemberWishlistRequest memberWishlist(
      String id) {
    return memberWishlist().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPointRequest
      memberRewardPoint() {
    return com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPointRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPointRequest
      memberRewardPointWithIdField() {
    return com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPointRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPointRequest
      memberRewardPoint(String id) {
    return memberRewardPoint().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.memberrewardpointredemption
          .MemberRewardPointRedemptionRequest
      memberRewardPointRedemption() {
    return com.doublechaintech.retailscm.memberrewardpointredemption
        .MemberRewardPointRedemptionRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.memberrewardpointredemption
          .MemberRewardPointRedemptionRequest
      memberRewardPointRedemptionWithIdField() {
    return com.doublechaintech.retailscm.memberrewardpointredemption
        .MemberRewardPointRedemptionRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.memberrewardpointredemption
          .MemberRewardPointRedemptionRequest
      memberRewardPointRedemption(String id) {
    return memberRewardPointRedemption().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProductRequest
      memberWishlistProduct() {
    return com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProductRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProductRequest
      memberWishlistProductWithIdField() {
    return com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProductRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProductRequest
      memberWishlistProduct(String id) {
    return memberWishlistProduct().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.retailstorememberaddress
          .RetailStoreMemberAddressRequest
      retailStoreMemberAddress() {
    return com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddressRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.retailstorememberaddress
          .RetailStoreMemberAddressRequest
      retailStoreMemberAddressWithIdField() {
    return com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddressRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.retailstorememberaddress
          .RetailStoreMemberAddressRequest
      retailStoreMemberAddress(String id) {
    return retailStoreMemberAddress().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.retailstoremembergiftcard
          .RetailStoreMemberGiftCardRequest
      retailStoreMemberGiftCard() {
    return com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.retailstoremembergiftcard
          .RetailStoreMemberGiftCardRequest
      retailStoreMemberGiftCardWithIdField() {
    return com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.retailstoremembergiftcard
          .RetailStoreMemberGiftCardRequest
      retailStoreMemberGiftCard(String id) {
    return retailStoreMemberGiftCard().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord
          .RetailStoreMemberGiftCardConsumeRecordRequest
      retailStoreMemberGiftCardConsumeRecord() {
    return com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord
        .RetailStoreMemberGiftCardConsumeRecordRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord
          .RetailStoreMemberGiftCardConsumeRecordRequest
      retailStoreMemberGiftCardConsumeRecordWithIdField() {
    return com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord
        .RetailStoreMemberGiftCardConsumeRecordRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord
          .RetailStoreMemberGiftCardConsumeRecordRequest
      retailStoreMemberGiftCardConsumeRecord(String id) {
    return retailStoreMemberGiftCardConsumeRecord().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.goodssupplier.GoodsSupplierRequest goodsSupplier() {
    return com.doublechaintech.retailscm.goodssupplier.GoodsSupplierRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.goodssupplier.GoodsSupplierRequest
      goodsSupplierWithIdField() {
    return com.doublechaintech.retailscm.goodssupplier.GoodsSupplierRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.goodssupplier.GoodsSupplierRequest goodsSupplier(
      String id) {
    return goodsSupplier().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.supplierproduct.SupplierProductRequest
      supplierProduct() {
    return com.doublechaintech.retailscm.supplierproduct.SupplierProductRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.supplierproduct.SupplierProductRequest
      supplierProductWithIdField() {
    return com.doublechaintech.retailscm.supplierproduct.SupplierProductRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.supplierproduct.SupplierProductRequest
      supplierProduct(String id) {
    return supplierProduct().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDurationRequest
      productSupplyDuration() {
    return com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDurationRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDurationRequest
      productSupplyDurationWithIdField() {
    return com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDurationRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDurationRequest
      productSupplyDuration(String id) {
    return productSupplyDuration().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.supplyorder.SupplyOrderRequest supplyOrder() {
    return com.doublechaintech.retailscm.supplyorder.SupplyOrderRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.supplyorder.SupplyOrderRequest
      supplyOrderWithIdField() {
    return com.doublechaintech.retailscm.supplyorder.SupplyOrderRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.supplyorder.SupplyOrderRequest supplyOrder(
      String id) {
    return supplyOrder().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItemRequest
      supplyOrderLineItem() {
    return com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItemRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItemRequest
      supplyOrderLineItemWithIdField() {
    return com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItemRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItemRequest
      supplyOrderLineItem(String id) {
    return supplyOrderLineItem().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.supplyordershippinggroup
          .SupplyOrderShippingGroupRequest
      supplyOrderShippingGroup() {
    return com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroupRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.supplyordershippinggroup
          .SupplyOrderShippingGroupRequest
      supplyOrderShippingGroupWithIdField() {
    return com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroupRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.supplyordershippinggroup
          .SupplyOrderShippingGroupRequest
      supplyOrderShippingGroup(String id) {
    return supplyOrderShippingGroup().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroupRequest
      supplyOrderPaymentGroup() {
    return com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroupRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroupRequest
      supplyOrderPaymentGroupWithIdField() {
    return com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroupRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroupRequest
      supplyOrderPaymentGroup(String id) {
    return supplyOrderPaymentGroup().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderRequest
      retailStoreOrder() {
    return com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderRequest
      retailStoreOrderWithIdField() {
    return com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderRequest
      retailStoreOrder(String id) {
    return retailStoreOrder().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.retailstoreorderlineitem
          .RetailStoreOrderLineItemRequest
      retailStoreOrderLineItem() {
    return com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItemRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.retailstoreorderlineitem
          .RetailStoreOrderLineItemRequest
      retailStoreOrderLineItemWithIdField() {
    return com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItemRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.retailstoreorderlineitem
          .RetailStoreOrderLineItemRequest
      retailStoreOrderLineItem(String id) {
    return retailStoreOrderLineItem().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.retailstoreordershippinggroup
          .RetailStoreOrderShippingGroupRequest
      retailStoreOrderShippingGroup() {
    return com.doublechaintech.retailscm.retailstoreordershippinggroup
        .RetailStoreOrderShippingGroupRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.retailstoreordershippinggroup
          .RetailStoreOrderShippingGroupRequest
      retailStoreOrderShippingGroupWithIdField() {
    return com.doublechaintech.retailscm.retailstoreordershippinggroup
        .RetailStoreOrderShippingGroupRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.retailstoreordershippinggroup
          .RetailStoreOrderShippingGroupRequest
      retailStoreOrderShippingGroup(String id) {
    return retailStoreOrderShippingGroup().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.retailstoreorderpaymentgroup
          .RetailStoreOrderPaymentGroupRequest
      retailStoreOrderPaymentGroup() {
    return com.doublechaintech.retailscm.retailstoreorderpaymentgroup
        .RetailStoreOrderPaymentGroupRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.retailstoreorderpaymentgroup
          .RetailStoreOrderPaymentGroupRequest
      retailStoreOrderPaymentGroupWithIdField() {
    return com.doublechaintech.retailscm.retailstoreorderpaymentgroup
        .RetailStoreOrderPaymentGroupRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.retailstoreorderpaymentgroup
          .RetailStoreOrderPaymentGroupRequest
      retailStoreOrderPaymentGroup(String id) {
    return retailStoreOrderPaymentGroup().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.warehouse.WarehouseRequest warehouse() {
    return com.doublechaintech.retailscm.warehouse.WarehouseRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.warehouse.WarehouseRequest warehouseWithIdField() {
    return com.doublechaintech.retailscm.warehouse.WarehouseRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.warehouse.WarehouseRequest warehouse(String id) {
    return warehouse().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.storagespace.StorageSpaceRequest storageSpace() {
    return com.doublechaintech.retailscm.storagespace.StorageSpaceRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.storagespace.StorageSpaceRequest
      storageSpaceWithIdField() {
    return com.doublechaintech.retailscm.storagespace.StorageSpaceRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.storagespace.StorageSpaceRequest storageSpace(
      String id) {
    return storageSpace().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.smartpallet.SmartPalletRequest smartPallet() {
    return com.doublechaintech.retailscm.smartpallet.SmartPalletRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.smartpallet.SmartPalletRequest
      smartPalletWithIdField() {
    return com.doublechaintech.retailscm.smartpallet.SmartPalletRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.smartpallet.SmartPalletRequest smartPallet(
      String id) {
    return smartPallet().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.goodsshelf.GoodsShelfRequest goodsShelf() {
    return com.doublechaintech.retailscm.goodsshelf.GoodsShelfRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.goodsshelf.GoodsShelfRequest goodsShelfWithIdField() {
    return com.doublechaintech.retailscm.goodsshelf.GoodsShelfRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.goodsshelf.GoodsShelfRequest goodsShelf(String id) {
    return goodsShelf().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountRequest
      goodsShelfStockCount() {
    return com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountRequest
      goodsShelfStockCountWithIdField() {
    return com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountRequest
      goodsShelfStockCount(String id) {
    return goodsShelfStockCount().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrackRequest
      stockCountIssueTrack() {
    return com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrackRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrackRequest
      stockCountIssueTrackWithIdField() {
    return com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrackRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrackRequest
      stockCountIssueTrack(String id) {
    return stockCountIssueTrack().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.goodsallocation.GoodsAllocationRequest
      goodsAllocation() {
    return com.doublechaintech.retailscm.goodsallocation.GoodsAllocationRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.goodsallocation.GoodsAllocationRequest
      goodsAllocationWithIdField() {
    return com.doublechaintech.retailscm.goodsallocation.GoodsAllocationRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.goodsallocation.GoodsAllocationRequest
      goodsAllocation(String id) {
    return goodsAllocation().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.goods.GoodsRequest goods() {
    return com.doublechaintech.retailscm.goods.GoodsRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.goods.GoodsRequest goodsWithIdField() {
    return com.doublechaintech.retailscm.goods.GoodsRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.goods.GoodsRequest goods(String id) {
    return goods().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.goodsmovement.GoodsMovementRequest goodsMovement() {
    return com.doublechaintech.retailscm.goodsmovement.GoodsMovementRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.goodsmovement.GoodsMovementRequest
      goodsMovementWithIdField() {
    return com.doublechaintech.retailscm.goodsmovement.GoodsMovementRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.goodsmovement.GoodsMovementRequest goodsMovement(
      String id) {
    return goodsMovement().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.supplierspace.SupplierSpaceRequest supplierSpace() {
    return com.doublechaintech.retailscm.supplierspace.SupplierSpaceRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.supplierspace.SupplierSpaceRequest
      supplierSpaceWithIdField() {
    return com.doublechaintech.retailscm.supplierspace.SupplierSpaceRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.supplierspace.SupplierSpaceRequest supplierSpace(
      String id) {
    return supplierSpace().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.receivingspace.ReceivingSpaceRequest
      receivingSpace() {
    return com.doublechaintech.retailscm.receivingspace.ReceivingSpaceRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.receivingspace.ReceivingSpaceRequest
      receivingSpaceWithIdField() {
    return com.doublechaintech.retailscm.receivingspace.ReceivingSpaceRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.receivingspace.ReceivingSpaceRequest receivingSpace(
      String id) {
    return receivingSpace().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.shippingspace.ShippingSpaceRequest shippingSpace() {
    return com.doublechaintech.retailscm.shippingspace.ShippingSpaceRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.shippingspace.ShippingSpaceRequest
      shippingSpaceWithIdField() {
    return com.doublechaintech.retailscm.shippingspace.ShippingSpaceRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.shippingspace.ShippingSpaceRequest shippingSpace(
      String id) {
    return shippingSpace().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.damagespace.DamageSpaceRequest damageSpace() {
    return com.doublechaintech.retailscm.damagespace.DamageSpaceRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.damagespace.DamageSpaceRequest
      damageSpaceWithIdField() {
    return com.doublechaintech.retailscm.damagespace.DamageSpaceRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.damagespace.DamageSpaceRequest damageSpace(
      String id) {
    return damageSpace().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.warehouseasset.WarehouseAssetRequest
      warehouseAsset() {
    return com.doublechaintech.retailscm.warehouseasset.WarehouseAssetRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.warehouseasset.WarehouseAssetRequest
      warehouseAssetWithIdField() {
    return com.doublechaintech.retailscm.warehouseasset.WarehouseAssetRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.warehouseasset.WarehouseAssetRequest warehouseAsset(
      String id) {
    return warehouseAsset().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.transportfleet.TransportFleetRequest
      transportFleet() {
    return com.doublechaintech.retailscm.transportfleet.TransportFleetRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.transportfleet.TransportFleetRequest
      transportFleetWithIdField() {
    return com.doublechaintech.retailscm.transportfleet.TransportFleetRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.transportfleet.TransportFleetRequest transportFleet(
      String id) {
    return transportFleet().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.transporttruck.TransportTruckRequest
      transportTruck() {
    return com.doublechaintech.retailscm.transporttruck.TransportTruckRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.transporttruck.TransportTruckRequest
      transportTruckWithIdField() {
    return com.doublechaintech.retailscm.transporttruck.TransportTruckRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.transporttruck.TransportTruckRequest transportTruck(
      String id) {
    return transportTruck().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.truckdriver.TruckDriverRequest truckDriver() {
    return com.doublechaintech.retailscm.truckdriver.TruckDriverRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.truckdriver.TruckDriverRequest
      truckDriverWithIdField() {
    return com.doublechaintech.retailscm.truckdriver.TruckDriverRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.truckdriver.TruckDriverRequest truckDriver(
      String id) {
    return truckDriver().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.transporttask.TransportTaskRequest transportTask() {
    return com.doublechaintech.retailscm.transporttask.TransportTaskRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.transporttask.TransportTaskRequest
      transportTaskWithIdField() {
    return com.doublechaintech.retailscm.transporttask.TransportTaskRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.transporttask.TransportTaskRequest transportTask(
      String id) {
    return transportTask().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrackRequest
      transportTaskTrack() {
    return com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrackRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrackRequest
      transportTaskTrackWithIdField() {
    return com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrackRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrackRequest
      transportTaskTrack(String id) {
    return transportTaskTrack().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.accountset.AccountSetRequest accountSet() {
    return com.doublechaintech.retailscm.accountset.AccountSetRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.accountset.AccountSetRequest accountSetWithIdField() {
    return com.doublechaintech.retailscm.accountset.AccountSetRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.accountset.AccountSetRequest accountSet(String id) {
    return accountSet().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.accountingsubject.AccountingSubjectRequest
      accountingSubject() {
    return com.doublechaintech.retailscm.accountingsubject.AccountingSubjectRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.accountingsubject.AccountingSubjectRequest
      accountingSubjectWithIdField() {
    return com.doublechaintech.retailscm.accountingsubject.AccountingSubjectRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.accountingsubject.AccountingSubjectRequest
      accountingSubject(String id) {
    return accountingSubject().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.accountingperiod.AccountingPeriodRequest
      accountingPeriod() {
    return com.doublechaintech.retailscm.accountingperiod.AccountingPeriodRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.accountingperiod.AccountingPeriodRequest
      accountingPeriodWithIdField() {
    return com.doublechaintech.retailscm.accountingperiod.AccountingPeriodRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.accountingperiod.AccountingPeriodRequest
      accountingPeriod(String id) {
    return accountingPeriod().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeRequest
      accountingDocumentType() {
    return com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeRequest
      accountingDocumentTypeWithIdField() {
    return com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeRequest
      accountingDocumentType(String id) {
    return accountingDocumentType().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.accountingdocument.AccountingDocumentRequest
      accountingDocument() {
    return com.doublechaintech.retailscm.accountingdocument.AccountingDocumentRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.accountingdocument.AccountingDocumentRequest
      accountingDocumentWithIdField() {
    return com.doublechaintech.retailscm.accountingdocument.AccountingDocumentRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.accountingdocument.AccountingDocumentRequest
      accountingDocument(String id) {
    return accountingDocument().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.originalvoucher.OriginalVoucherRequest
      originalVoucher() {
    return com.doublechaintech.retailscm.originalvoucher.OriginalVoucherRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.originalvoucher.OriginalVoucherRequest
      originalVoucherWithIdField() {
    return com.doublechaintech.retailscm.originalvoucher.OriginalVoucherRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.originalvoucher.OriginalVoucherRequest
      originalVoucher(String id) {
    return originalVoucher().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLineRequest
      accountingDocumentLine() {
    return com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLineRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLineRequest
      accountingDocumentLineWithIdField() {
    return com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLineRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLineRequest
      accountingDocumentLine(String id) {
    return accountingDocumentLine().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentRequest
      levelOneDepartment() {
    return com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentRequest
      levelOneDepartmentWithIdField() {
    return com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentRequest
      levelOneDepartment(String id) {
    return levelOneDepartment().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentRequest
      levelTwoDepartment() {
    return com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentRequest
      levelTwoDepartmentWithIdField() {
    return com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentRequest
      levelTwoDepartment(String id) {
    return levelTwoDepartment().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentRequest
      levelThreeDepartment() {
    return com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentRequest
      levelThreeDepartmentWithIdField() {
    return com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartmentRequest
      levelThreeDepartment(String id) {
    return levelThreeDepartment().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.skilltype.SkillTypeRequest skillType() {
    return com.doublechaintech.retailscm.skilltype.SkillTypeRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.skilltype.SkillTypeRequest skillTypeWithIdField() {
    return com.doublechaintech.retailscm.skilltype.SkillTypeRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.skilltype.SkillTypeRequest skillType(String id) {
    return skillType().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeRequest
      responsibilityType() {
    return com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeRequest
      responsibilityTypeWithIdField() {
    return com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeRequest
      responsibilityType(String id) {
    return responsibilityType().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.terminationreason.TerminationReasonRequest
      terminationReason() {
    return com.doublechaintech.retailscm.terminationreason.TerminationReasonRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.terminationreason.TerminationReasonRequest
      terminationReasonWithIdField() {
    return com.doublechaintech.retailscm.terminationreason.TerminationReasonRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.terminationreason.TerminationReasonRequest
      terminationReason(String id) {
    return terminationReason().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.terminationtype.TerminationTypeRequest
      terminationType() {
    return com.doublechaintech.retailscm.terminationtype.TerminationTypeRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.terminationtype.TerminationTypeRequest
      terminationTypeWithIdField() {
    return com.doublechaintech.retailscm.terminationtype.TerminationTypeRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.terminationtype.TerminationTypeRequest
      terminationType(String id) {
    return terminationType().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.occupationtype.OccupationTypeRequest
      occupationType() {
    return com.doublechaintech.retailscm.occupationtype.OccupationTypeRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.occupationtype.OccupationTypeRequest
      occupationTypeWithIdField() {
    return com.doublechaintech.retailscm.occupationtype.OccupationTypeRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.occupationtype.OccupationTypeRequest occupationType(
      String id) {
    return occupationType().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.leavetype.LeaveTypeRequest leaveType() {
    return com.doublechaintech.retailscm.leavetype.LeaveTypeRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.leavetype.LeaveTypeRequest leaveTypeWithIdField() {
    return com.doublechaintech.retailscm.leavetype.LeaveTypeRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.leavetype.LeaveTypeRequest leaveType(String id) {
    return leaveType().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.salarygrade.SalaryGradeRequest salaryGrade() {
    return com.doublechaintech.retailscm.salarygrade.SalaryGradeRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.salarygrade.SalaryGradeRequest
      salaryGradeWithIdField() {
    return com.doublechaintech.retailscm.salarygrade.SalaryGradeRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.salarygrade.SalaryGradeRequest salaryGrade(
      String id) {
    return salaryGrade().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.interviewtype.InterviewTypeRequest interviewType() {
    return com.doublechaintech.retailscm.interviewtype.InterviewTypeRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.interviewtype.InterviewTypeRequest
      interviewTypeWithIdField() {
    return com.doublechaintech.retailscm.interviewtype.InterviewTypeRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.interviewtype.InterviewTypeRequest interviewType(
      String id) {
    return interviewType().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeRequest
      trainingCourseType() {
    return com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeRequest
      trainingCourseTypeWithIdField() {
    return com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeRequest
      trainingCourseType(String id) {
    return trainingCourseType().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.publicholiday.PublicHolidayRequest publicHoliday() {
    return com.doublechaintech.retailscm.publicholiday.PublicHolidayRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.publicholiday.PublicHolidayRequest
      publicHolidayWithIdField() {
    return com.doublechaintech.retailscm.publicholiday.PublicHolidayRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.publicholiday.PublicHolidayRequest publicHoliday(
      String id) {
    return publicHoliday().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.termination.TerminationRequest termination() {
    return com.doublechaintech.retailscm.termination.TerminationRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.termination.TerminationRequest
      terminationWithIdField() {
    return com.doublechaintech.retailscm.termination.TerminationRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.termination.TerminationRequest termination(
      String id) {
    return termination().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.view.ViewRequest view() {
    return com.doublechaintech.retailscm.view.ViewRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.view.ViewRequest viewWithIdField() {
    return com.doublechaintech.retailscm.view.ViewRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.view.ViewRequest view(String id) {
    return view().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.employee.EmployeeRequest employee() {
    return com.doublechaintech.retailscm.employee.EmployeeRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.employee.EmployeeRequest employeeWithIdField() {
    return com.doublechaintech.retailscm.employee.EmployeeRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.employee.EmployeeRequest employee(String id) {
    return employee().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.instructor.InstructorRequest instructor() {
    return com.doublechaintech.retailscm.instructor.InstructorRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.instructor.InstructorRequest instructorWithIdField() {
    return com.doublechaintech.retailscm.instructor.InstructorRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.instructor.InstructorRequest instructor(String id) {
    return instructor().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.companytraining.CompanyTrainingRequest
      companyTraining() {
    return com.doublechaintech.retailscm.companytraining.CompanyTrainingRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.companytraining.CompanyTrainingRequest
      companyTrainingWithIdField() {
    return com.doublechaintech.retailscm.companytraining.CompanyTrainingRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.companytraining.CompanyTrainingRequest
      companyTraining(String id) {
    return companyTraining().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.scoring.ScoringRequest scoring() {
    return com.doublechaintech.retailscm.scoring.ScoringRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.scoring.ScoringRequest scoringWithIdField() {
    return com.doublechaintech.retailscm.scoring.ScoringRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.scoring.ScoringRequest scoring(String id) {
    return scoring().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingRequest
      employeeCompanyTraining() {
    return com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingRequest
      employeeCompanyTrainingWithIdField() {
    return com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingRequest
      employeeCompanyTraining(String id) {
    return employeeCompanyTraining().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.employeeskill.EmployeeSkillRequest employeeSkill() {
    return com.doublechaintech.retailscm.employeeskill.EmployeeSkillRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.employeeskill.EmployeeSkillRequest
      employeeSkillWithIdField() {
    return com.doublechaintech.retailscm.employeeskill.EmployeeSkillRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.employeeskill.EmployeeSkillRequest employeeSkill(
      String id) {
    return employeeSkill().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.employeeperformance.EmployeePerformanceRequest
      employeePerformance() {
    return com.doublechaintech.retailscm.employeeperformance.EmployeePerformanceRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.employeeperformance.EmployeePerformanceRequest
      employeePerformanceWithIdField() {
    return com.doublechaintech.retailscm.employeeperformance.EmployeePerformanceRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.employeeperformance.EmployeePerformanceRequest
      employeePerformance(String id) {
    return employeePerformance().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperienceRequest
      employeeWorkExperience() {
    return com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperienceRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperienceRequest
      employeeWorkExperienceWithIdField() {
    return com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperienceRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperienceRequest
      employeeWorkExperience(String id) {
    return employeeWorkExperience().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.employeeleave.EmployeeLeaveRequest employeeLeave() {
    return com.doublechaintech.retailscm.employeeleave.EmployeeLeaveRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.employeeleave.EmployeeLeaveRequest
      employeeLeaveWithIdField() {
    return com.doublechaintech.retailscm.employeeleave.EmployeeLeaveRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.employeeleave.EmployeeLeaveRequest employeeLeave(
      String id) {
    return employeeLeave().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewRequest
      employeeInterview() {
    return com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewRequest
      employeeInterviewWithIdField() {
    return com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewRequest
      employeeInterview(String id) {
    return employeeInterview().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.employeeattendance.EmployeeAttendanceRequest
      employeeAttendance() {
    return com.doublechaintech.retailscm.employeeattendance.EmployeeAttendanceRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.employeeattendance.EmployeeAttendanceRequest
      employeeAttendanceWithIdField() {
    return com.doublechaintech.retailscm.employeeattendance.EmployeeAttendanceRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.employeeattendance.EmployeeAttendanceRequest
      employeeAttendance(String id) {
    return employeeAttendance().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.employeequalifier.EmployeeQualifierRequest
      employeeQualifier() {
    return com.doublechaintech.retailscm.employeequalifier.EmployeeQualifierRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.employeequalifier.EmployeeQualifierRequest
      employeeQualifierWithIdField() {
    return com.doublechaintech.retailscm.employeequalifier.EmployeeQualifierRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.employeequalifier.EmployeeQualifierRequest
      employeeQualifier(String id) {
    return employeeQualifier().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.employeeeducation.EmployeeEducationRequest
      employeeEducation() {
    return com.doublechaintech.retailscm.employeeeducation.EmployeeEducationRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.employeeeducation.EmployeeEducationRequest
      employeeEducationWithIdField() {
    return com.doublechaintech.retailscm.employeeeducation.EmployeeEducationRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.employeeeducation.EmployeeEducationRequest
      employeeEducation(String id) {
    return employeeEducation().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.employeeaward.EmployeeAwardRequest employeeAward() {
    return com.doublechaintech.retailscm.employeeaward.EmployeeAwardRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.employeeaward.EmployeeAwardRequest
      employeeAwardWithIdField() {
    return com.doublechaintech.retailscm.employeeaward.EmployeeAwardRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.employeeaward.EmployeeAwardRequest employeeAward(
      String id) {
    return employeeAward().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetRequest
      employeeSalarySheet() {
    return com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetRequest
      employeeSalarySheetWithIdField() {
    return com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetRequest
      employeeSalarySheet(String id) {
    return employeeSalarySheet().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.payingoff.PayingOffRequest payingOff() {
    return com.doublechaintech.retailscm.payingoff.PayingOffRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.payingoff.PayingOffRequest payingOffWithIdField() {
    return com.doublechaintech.retailscm.payingoff.PayingOffRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.payingoff.PayingOffRequest payingOff(String id) {
    return payingOff().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.mobileapp.MobileAppRequest mobileApp() {
    return com.doublechaintech.retailscm.mobileapp.MobileAppRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.mobileapp.MobileAppRequest mobileAppWithIdField() {
    return com.doublechaintech.retailscm.mobileapp.MobileAppRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.mobileapp.MobileAppRequest mobileApp(String id) {
    return mobileApp().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.page.PageRequest page() {
    return com.doublechaintech.retailscm.page.PageRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.page.PageRequest pageWithIdField() {
    return com.doublechaintech.retailscm.page.PageRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.page.PageRequest page(String id) {
    return page().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.pagetype.PageTypeRequest pageType() {
    return com.doublechaintech.retailscm.pagetype.PageTypeRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.pagetype.PageTypeRequest pageTypeWithIdField() {
    return com.doublechaintech.retailscm.pagetype.PageTypeRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.pagetype.PageTypeRequest pageType(String id) {
    return pageType().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.slide.SlideRequest slide() {
    return com.doublechaintech.retailscm.slide.SlideRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.slide.SlideRequest slideWithIdField() {
    return com.doublechaintech.retailscm.slide.SlideRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.slide.SlideRequest slide(String id) {
    return slide().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.uiaction.UiActionRequest uiAction() {
    return com.doublechaintech.retailscm.uiaction.UiActionRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.uiaction.UiActionRequest uiActionWithIdField() {
    return com.doublechaintech.retailscm.uiaction.UiActionRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.uiaction.UiActionRequest uiAction(String id) {
    return uiAction().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.section.SectionRequest section() {
    return com.doublechaintech.retailscm.section.SectionRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.section.SectionRequest sectionWithIdField() {
    return com.doublechaintech.retailscm.section.SectionRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.section.SectionRequest section(String id) {
    return section().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.userdomain.UserDomainRequest userDomain() {
    return com.doublechaintech.retailscm.userdomain.UserDomainRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.userdomain.UserDomainRequest userDomainWithIdField() {
    return com.doublechaintech.retailscm.userdomain.UserDomainRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.userdomain.UserDomainRequest userDomain(String id) {
    return userDomain().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.userallowlist.UserAllowListRequest userAllowList() {
    return com.doublechaintech.retailscm.userallowlist.UserAllowListRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.userallowlist.UserAllowListRequest
      userAllowListWithIdField() {
    return com.doublechaintech.retailscm.userallowlist.UserAllowListRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.userallowlist.UserAllowListRequest userAllowList(
      String id) {
    return userAllowList().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.secuser.SecUserRequest secUser() {
    return com.doublechaintech.retailscm.secuser.SecUserRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.secuser.SecUserRequest secUserWithIdField() {
    return com.doublechaintech.retailscm.secuser.SecUserRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.secuser.SecUserRequest secUser(String id) {
    return secUser().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.userapp.UserAppRequest userApp() {
    return com.doublechaintech.retailscm.userapp.UserAppRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.userapp.UserAppRequest userAppWithIdField() {
    return com.doublechaintech.retailscm.userapp.UserAppRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.userapp.UserAppRequest userApp(String id) {
    return userApp().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.quicklink.QuickLinkRequest quickLink() {
    return com.doublechaintech.retailscm.quicklink.QuickLinkRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.quicklink.QuickLinkRequest quickLinkWithIdField() {
    return com.doublechaintech.retailscm.quicklink.QuickLinkRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.quicklink.QuickLinkRequest quickLink(String id) {
    return quickLink().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.listaccess.ListAccessRequest listAccess() {
    return com.doublechaintech.retailscm.listaccess.ListAccessRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.listaccess.ListAccessRequest listAccessWithIdField() {
    return com.doublechaintech.retailscm.listaccess.ListAccessRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.listaccess.ListAccessRequest listAccess(String id) {
    return listAccess().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.loginhistory.LoginHistoryRequest loginHistory() {
    return com.doublechaintech.retailscm.loginhistory.LoginHistoryRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.loginhistory.LoginHistoryRequest
      loginHistoryWithIdField() {
    return com.doublechaintech.retailscm.loginhistory.LoginHistoryRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.loginhistory.LoginHistoryRequest loginHistory(
      String id) {
    return loginHistory().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.candidatecontainer.CandidateContainerRequest
      candidateContainer() {
    return com.doublechaintech.retailscm.candidatecontainer.CandidateContainerRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.candidatecontainer.CandidateContainerRequest
      candidateContainerWithIdField() {
    return com.doublechaintech.retailscm.candidatecontainer.CandidateContainerRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.candidatecontainer.CandidateContainerRequest
      candidateContainer(String id) {
    return candidateContainer().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.candidateelement.CandidateElementRequest
      candidateElement() {
    return com.doublechaintech.retailscm.candidateelement.CandidateElementRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.candidateelement.CandidateElementRequest
      candidateElementWithIdField() {
    return com.doublechaintech.retailscm.candidateelement.CandidateElementRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.candidateelement.CandidateElementRequest
      candidateElement(String id) {
    return candidateElement().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentityRequest
      wechatWorkappIdentity() {
    return com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentityRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentityRequest
      wechatWorkappIdentityWithIdField() {
    return com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentityRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentityRequest
      wechatWorkappIdentity(String id) {
    return wechatWorkappIdentity().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentityRequest
      wechatMiniappIdentity() {
    return com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentityRequest
        .newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentityRequest
      wechatMiniappIdentityWithIdField() {
    return com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentityRequest
        .newInstance();
  }

  public static com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentityRequest
      wechatMiniappIdentity(String id) {
    return wechatMiniappIdentity().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.keypairidentity.KeyPairIdentityRequest
      keyPairIdentity() {
    return com.doublechaintech.retailscm.keypairidentity.KeyPairIdentityRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.keypairidentity.KeyPairIdentityRequest
      keyPairIdentityWithIdField() {
    return com.doublechaintech.retailscm.keypairidentity.KeyPairIdentityRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.keypairidentity.KeyPairIdentityRequest
      keyPairIdentity(String id) {
    return keyPairIdentity().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.publickeytype.PublicKeyTypeRequest publicKeyType() {
    return com.doublechaintech.retailscm.publickeytype.PublicKeyTypeRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.publickeytype.PublicKeyTypeRequest
      publicKeyTypeWithIdField() {
    return com.doublechaintech.retailscm.publickeytype.PublicKeyTypeRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.publickeytype.PublicKeyTypeRequest publicKeyType(
      String id) {
    return publicKeyType().withId(id).selectSelf();
  }

  public static com.doublechaintech.retailscm.treenode.TreeNodeRequest treeNode() {
    return com.doublechaintech.retailscm.treenode.TreeNodeRequest.newInstance()
        .selectSelf()
        .where(VERSION_PROPERTY, QueryOperator.GREATER_THAN, 0);
  }

  public static com.doublechaintech.retailscm.treenode.TreeNodeRequest treeNodeWithIdField() {
    return com.doublechaintech.retailscm.treenode.TreeNodeRequest.newInstance();
  }

  public static com.doublechaintech.retailscm.treenode.TreeNodeRequest treeNode(String id) {
    return treeNode().withId(id).selectSelf();
  }
}
