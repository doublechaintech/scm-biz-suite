package com.doublechaintech.retailscm.retailstoremember;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class RetailStoreMemberForm extends BaseForm {
	
	
	public RetailStoreMemberForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RetailStoreMemberForm retailStoreMemberIdField(String parameterName, String initValue){
		FormField field = idFromRetailStoreMember(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm retailStoreMemberIdField(String initValue){
		return retailStoreMemberIdField("retailStoreMemberId",initValue);
	}
	public RetailStoreMemberForm retailStoreMemberIdField(){
		return retailStoreMemberIdField("retailStoreMemberId","");
	}


	public RetailStoreMemberForm nameField(String parameterName, String initValue){
		FormField field = nameFromRetailStoreMember(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public RetailStoreMemberForm nameField(){
		return nameField("name","");
	}


	public RetailStoreMemberForm mobilePhoneField(String parameterName, String initValue){
		FormField field = mobilePhoneFromRetailStoreMember(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm mobilePhoneField(String initValue){
		return mobilePhoneField("mobilePhone",initValue);
	}
	public RetailStoreMemberForm mobilePhoneField(){
		return mobilePhoneField("mobilePhone","");
	}


	public RetailStoreMemberForm ownerIdField(String parameterName, String initValue){
		FormField field = ownerIdFromRetailStoreMember(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm ownerIdField(String initValue){
		return ownerIdField("ownerId",initValue);
	}
	public RetailStoreMemberForm ownerIdField(){
		return ownerIdField("ownerId","");
	}

	
	


	public RetailStoreMemberForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public RetailStoreMemberForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public RetailStoreMemberForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public RetailStoreMemberForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public RetailStoreMemberForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public RetailStoreMemberForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public RetailStoreMemberForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public RetailStoreMemberForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public RetailStoreMemberForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public RetailStoreMemberForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public RetailStoreMemberForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public RetailStoreMemberForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public RetailStoreMemberForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public RetailStoreMemberForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public RetailStoreMemberForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public RetailStoreMemberForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public RetailStoreMemberForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RetailStoreMemberForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public RetailStoreMemberForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}

	



	public RetailStoreMemberForm consumerOrderIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  idFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm consumerOrderIdFieldForConsumerOrder(String initValue){
		return consumerOrderIdFieldForConsumerOrder("consumerOrderId",initValue);
	}
	public RetailStoreMemberForm consumerOrderIdFieldForConsumerOrder(){
		return consumerOrderIdFieldForConsumerOrder("consumerOrderId","");
	}


	public RetailStoreMemberForm titleFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  titleFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm titleFieldForConsumerOrder(String initValue){
		return titleFieldForConsumerOrder("title",initValue);
	}
	public RetailStoreMemberForm titleFieldForConsumerOrder(){
		return titleFieldForConsumerOrder("title","");
	}


	public RetailStoreMemberForm consumerIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  consumerIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm consumerIdFieldForConsumerOrder(String initValue){
		return consumerIdFieldForConsumerOrder("consumerId",initValue);
	}
	public RetailStoreMemberForm consumerIdFieldForConsumerOrder(){
		return consumerIdFieldForConsumerOrder("consumerId","");
	}


	public RetailStoreMemberForm confirmationIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  confirmationIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm confirmationIdFieldForConsumerOrder(String initValue){
		return confirmationIdFieldForConsumerOrder("confirmationId",initValue);
	}
	public RetailStoreMemberForm confirmationIdFieldForConsumerOrder(){
		return confirmationIdFieldForConsumerOrder("confirmationId","");
	}


	public RetailStoreMemberForm approvalIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  approvalIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm approvalIdFieldForConsumerOrder(String initValue){
		return approvalIdFieldForConsumerOrder("approvalId",initValue);
	}
	public RetailStoreMemberForm approvalIdFieldForConsumerOrder(){
		return approvalIdFieldForConsumerOrder("approvalId","");
	}


	public RetailStoreMemberForm processingIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  processingIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm processingIdFieldForConsumerOrder(String initValue){
		return processingIdFieldForConsumerOrder("processingId",initValue);
	}
	public RetailStoreMemberForm processingIdFieldForConsumerOrder(){
		return processingIdFieldForConsumerOrder("processingId","");
	}


	public RetailStoreMemberForm shipmentIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  shipmentIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm shipmentIdFieldForConsumerOrder(String initValue){
		return shipmentIdFieldForConsumerOrder("shipmentId",initValue);
	}
	public RetailStoreMemberForm shipmentIdFieldForConsumerOrder(){
		return shipmentIdFieldForConsumerOrder("shipmentId","");
	}


	public RetailStoreMemberForm deliveryIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  deliveryIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm deliveryIdFieldForConsumerOrder(String initValue){
		return deliveryIdFieldForConsumerOrder("deliveryId",initValue);
	}
	public RetailStoreMemberForm deliveryIdFieldForConsumerOrder(){
		return deliveryIdFieldForConsumerOrder("deliveryId","");
	}


	public RetailStoreMemberForm storeIdFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  storeIdFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm storeIdFieldForConsumerOrder(String initValue){
		return storeIdFieldForConsumerOrder("storeId",initValue);
	}
	public RetailStoreMemberForm storeIdFieldForConsumerOrder(){
		return storeIdFieldForConsumerOrder("storeId","");
	}


	public RetailStoreMemberForm lastUpdateTimeFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm lastUpdateTimeFieldForConsumerOrder(String initValue){
		return lastUpdateTimeFieldForConsumerOrder("lastUpdateTime",initValue);
	}
	public RetailStoreMemberForm lastUpdateTimeFieldForConsumerOrder(){
		return lastUpdateTimeFieldForConsumerOrder("lastUpdateTime","");
	}


	public RetailStoreMemberForm currentStatusFieldForConsumerOrder(String parameterName, String initValue){
		FormField field =  currentStatusFromConsumerOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm currentStatusFieldForConsumerOrder(String initValue){
		return currentStatusFieldForConsumerOrder("currentStatus",initValue);
	}
	public RetailStoreMemberForm currentStatusFieldForConsumerOrder(){
		return currentStatusFieldForConsumerOrder("currentStatus","");
	}


	public RetailStoreMemberForm retailStoreMemberCouponIdFieldForRetailStoreMemberCoupon(String parameterName, String initValue){
		FormField field =  idFromRetailStoreMemberCoupon(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm retailStoreMemberCouponIdFieldForRetailStoreMemberCoupon(String initValue){
		return retailStoreMemberCouponIdFieldForRetailStoreMemberCoupon("retailStoreMemberCouponId",initValue);
	}
	public RetailStoreMemberForm retailStoreMemberCouponIdFieldForRetailStoreMemberCoupon(){
		return retailStoreMemberCouponIdFieldForRetailStoreMemberCoupon("retailStoreMemberCouponId","");
	}


	public RetailStoreMemberForm nameFieldForRetailStoreMemberCoupon(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreMemberCoupon(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm nameFieldForRetailStoreMemberCoupon(String initValue){
		return nameFieldForRetailStoreMemberCoupon("name",initValue);
	}
	public RetailStoreMemberForm nameFieldForRetailStoreMemberCoupon(){
		return nameFieldForRetailStoreMemberCoupon("name","");
	}


	public RetailStoreMemberForm ownerIdFieldForRetailStoreMemberCoupon(String parameterName, String initValue){
		FormField field =  ownerIdFromRetailStoreMemberCoupon(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm ownerIdFieldForRetailStoreMemberCoupon(String initValue){
		return ownerIdFieldForRetailStoreMemberCoupon("ownerId",initValue);
	}
	public RetailStoreMemberForm ownerIdFieldForRetailStoreMemberCoupon(){
		return ownerIdFieldForRetailStoreMemberCoupon("ownerId","");
	}


	public RetailStoreMemberForm numberFieldForRetailStoreMemberCoupon(String parameterName, String initValue){
		FormField field =  numberFromRetailStoreMemberCoupon(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm numberFieldForRetailStoreMemberCoupon(String initValue){
		return numberFieldForRetailStoreMemberCoupon("number",initValue);
	}
	public RetailStoreMemberForm numberFieldForRetailStoreMemberCoupon(){
		return numberFieldForRetailStoreMemberCoupon("number","");
	}


	public RetailStoreMemberForm lastUpdateTimeFieldForRetailStoreMemberCoupon(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromRetailStoreMemberCoupon(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm lastUpdateTimeFieldForRetailStoreMemberCoupon(String initValue){
		return lastUpdateTimeFieldForRetailStoreMemberCoupon("lastUpdateTime",initValue);
	}
	public RetailStoreMemberForm lastUpdateTimeFieldForRetailStoreMemberCoupon(){
		return lastUpdateTimeFieldForRetailStoreMemberCoupon("lastUpdateTime","");
	}


	public RetailStoreMemberForm memberWishlistIdFieldForMemberWishlist(String parameterName, String initValue){
		FormField field =  idFromMemberWishlist(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm memberWishlistIdFieldForMemberWishlist(String initValue){
		return memberWishlistIdFieldForMemberWishlist("memberWishlistId",initValue);
	}
	public RetailStoreMemberForm memberWishlistIdFieldForMemberWishlist(){
		return memberWishlistIdFieldForMemberWishlist("memberWishlistId","");
	}


	public RetailStoreMemberForm nameFieldForMemberWishlist(String parameterName, String initValue){
		FormField field =  nameFromMemberWishlist(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm nameFieldForMemberWishlist(String initValue){
		return nameFieldForMemberWishlist("name",initValue);
	}
	public RetailStoreMemberForm nameFieldForMemberWishlist(){
		return nameFieldForMemberWishlist("name","");
	}


	public RetailStoreMemberForm ownerIdFieldForMemberWishlist(String parameterName, String initValue){
		FormField field =  ownerIdFromMemberWishlist(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm ownerIdFieldForMemberWishlist(String initValue){
		return ownerIdFieldForMemberWishlist("ownerId",initValue);
	}
	public RetailStoreMemberForm ownerIdFieldForMemberWishlist(){
		return ownerIdFieldForMemberWishlist("ownerId","");
	}


	public RetailStoreMemberForm memberRewardPointIdFieldForMemberRewardPoint(String parameterName, String initValue){
		FormField field =  idFromMemberRewardPoint(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm memberRewardPointIdFieldForMemberRewardPoint(String initValue){
		return memberRewardPointIdFieldForMemberRewardPoint("memberRewardPointId",initValue);
	}
	public RetailStoreMemberForm memberRewardPointIdFieldForMemberRewardPoint(){
		return memberRewardPointIdFieldForMemberRewardPoint("memberRewardPointId","");
	}


	public RetailStoreMemberForm nameFieldForMemberRewardPoint(String parameterName, String initValue){
		FormField field =  nameFromMemberRewardPoint(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm nameFieldForMemberRewardPoint(String initValue){
		return nameFieldForMemberRewardPoint("name",initValue);
	}
	public RetailStoreMemberForm nameFieldForMemberRewardPoint(){
		return nameFieldForMemberRewardPoint("name","");
	}


	public RetailStoreMemberForm pointFieldForMemberRewardPoint(String parameterName, String initValue){
		FormField field =  pointFromMemberRewardPoint(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm pointFieldForMemberRewardPoint(String initValue){
		return pointFieldForMemberRewardPoint("point",initValue);
	}
	public RetailStoreMemberForm pointFieldForMemberRewardPoint(){
		return pointFieldForMemberRewardPoint("point","");
	}


	public RetailStoreMemberForm ownerIdFieldForMemberRewardPoint(String parameterName, String initValue){
		FormField field =  ownerIdFromMemberRewardPoint(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm ownerIdFieldForMemberRewardPoint(String initValue){
		return ownerIdFieldForMemberRewardPoint("ownerId",initValue);
	}
	public RetailStoreMemberForm ownerIdFieldForMemberRewardPoint(){
		return ownerIdFieldForMemberRewardPoint("ownerId","");
	}


	public RetailStoreMemberForm memberRewardPointRedemptionIdFieldForMemberRewardPointRedemption(String parameterName, String initValue){
		FormField field =  idFromMemberRewardPointRedemption(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm memberRewardPointRedemptionIdFieldForMemberRewardPointRedemption(String initValue){
		return memberRewardPointRedemptionIdFieldForMemberRewardPointRedemption("memberRewardPointRedemptionId",initValue);
	}
	public RetailStoreMemberForm memberRewardPointRedemptionIdFieldForMemberRewardPointRedemption(){
		return memberRewardPointRedemptionIdFieldForMemberRewardPointRedemption("memberRewardPointRedemptionId","");
	}


	public RetailStoreMemberForm nameFieldForMemberRewardPointRedemption(String parameterName, String initValue){
		FormField field =  nameFromMemberRewardPointRedemption(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm nameFieldForMemberRewardPointRedemption(String initValue){
		return nameFieldForMemberRewardPointRedemption("name",initValue);
	}
	public RetailStoreMemberForm nameFieldForMemberRewardPointRedemption(){
		return nameFieldForMemberRewardPointRedemption("name","");
	}


	public RetailStoreMemberForm pointFieldForMemberRewardPointRedemption(String parameterName, String initValue){
		FormField field =  pointFromMemberRewardPointRedemption(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm pointFieldForMemberRewardPointRedemption(String initValue){
		return pointFieldForMemberRewardPointRedemption("point",initValue);
	}
	public RetailStoreMemberForm pointFieldForMemberRewardPointRedemption(){
		return pointFieldForMemberRewardPointRedemption("point","");
	}


	public RetailStoreMemberForm ownerIdFieldForMemberRewardPointRedemption(String parameterName, String initValue){
		FormField field =  ownerIdFromMemberRewardPointRedemption(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm ownerIdFieldForMemberRewardPointRedemption(String initValue){
		return ownerIdFieldForMemberRewardPointRedemption("ownerId",initValue);
	}
	public RetailStoreMemberForm ownerIdFieldForMemberRewardPointRedemption(){
		return ownerIdFieldForMemberRewardPointRedemption("ownerId","");
	}


	public RetailStoreMemberForm retailStoreMemberAddressIdFieldForRetailStoreMemberAddress(String parameterName, String initValue){
		FormField field =  idFromRetailStoreMemberAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm retailStoreMemberAddressIdFieldForRetailStoreMemberAddress(String initValue){
		return retailStoreMemberAddressIdFieldForRetailStoreMemberAddress("retailStoreMemberAddressId",initValue);
	}
	public RetailStoreMemberForm retailStoreMemberAddressIdFieldForRetailStoreMemberAddress(){
		return retailStoreMemberAddressIdFieldForRetailStoreMemberAddress("retailStoreMemberAddressId","");
	}


	public RetailStoreMemberForm nameFieldForRetailStoreMemberAddress(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreMemberAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm nameFieldForRetailStoreMemberAddress(String initValue){
		return nameFieldForRetailStoreMemberAddress("name",initValue);
	}
	public RetailStoreMemberForm nameFieldForRetailStoreMemberAddress(){
		return nameFieldForRetailStoreMemberAddress("name","");
	}


	public RetailStoreMemberForm ownerIdFieldForRetailStoreMemberAddress(String parameterName, String initValue){
		FormField field =  ownerIdFromRetailStoreMemberAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm ownerIdFieldForRetailStoreMemberAddress(String initValue){
		return ownerIdFieldForRetailStoreMemberAddress("ownerId",initValue);
	}
	public RetailStoreMemberForm ownerIdFieldForRetailStoreMemberAddress(){
		return ownerIdFieldForRetailStoreMemberAddress("ownerId","");
	}


	public RetailStoreMemberForm mobilePhoneFieldForRetailStoreMemberAddress(String parameterName, String initValue){
		FormField field =  mobilePhoneFromRetailStoreMemberAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm mobilePhoneFieldForRetailStoreMemberAddress(String initValue){
		return mobilePhoneFieldForRetailStoreMemberAddress("mobilePhone",initValue);
	}
	public RetailStoreMemberForm mobilePhoneFieldForRetailStoreMemberAddress(){
		return mobilePhoneFieldForRetailStoreMemberAddress("mobilePhone","");
	}


	public RetailStoreMemberForm addressFieldForRetailStoreMemberAddress(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreMemberAddress(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm addressFieldForRetailStoreMemberAddress(String initValue){
		return addressFieldForRetailStoreMemberAddress("address",initValue);
	}
	public RetailStoreMemberForm addressFieldForRetailStoreMemberAddress(){
		return addressFieldForRetailStoreMemberAddress("address","");
	}


	public RetailStoreMemberForm retailStoreMemberGiftCardIdFieldForRetailStoreMemberGiftCard(String parameterName, String initValue){
		FormField field =  idFromRetailStoreMemberGiftCard(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm retailStoreMemberGiftCardIdFieldForRetailStoreMemberGiftCard(String initValue){
		return retailStoreMemberGiftCardIdFieldForRetailStoreMemberGiftCard("retailStoreMemberGiftCardId",initValue);
	}
	public RetailStoreMemberForm retailStoreMemberGiftCardIdFieldForRetailStoreMemberGiftCard(){
		return retailStoreMemberGiftCardIdFieldForRetailStoreMemberGiftCard("retailStoreMemberGiftCardId","");
	}


	public RetailStoreMemberForm nameFieldForRetailStoreMemberGiftCard(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreMemberGiftCard(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm nameFieldForRetailStoreMemberGiftCard(String initValue){
		return nameFieldForRetailStoreMemberGiftCard("name",initValue);
	}
	public RetailStoreMemberForm nameFieldForRetailStoreMemberGiftCard(){
		return nameFieldForRetailStoreMemberGiftCard("name","");
	}


	public RetailStoreMemberForm ownerIdFieldForRetailStoreMemberGiftCard(String parameterName, String initValue){
		FormField field =  ownerIdFromRetailStoreMemberGiftCard(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm ownerIdFieldForRetailStoreMemberGiftCard(String initValue){
		return ownerIdFieldForRetailStoreMemberGiftCard("ownerId",initValue);
	}
	public RetailStoreMemberForm ownerIdFieldForRetailStoreMemberGiftCard(){
		return ownerIdFieldForRetailStoreMemberGiftCard("ownerId","");
	}


	public RetailStoreMemberForm numberFieldForRetailStoreMemberGiftCard(String parameterName, String initValue){
		FormField field =  numberFromRetailStoreMemberGiftCard(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm numberFieldForRetailStoreMemberGiftCard(String initValue){
		return numberFieldForRetailStoreMemberGiftCard("number",initValue);
	}
	public RetailStoreMemberForm numberFieldForRetailStoreMemberGiftCard(){
		return numberFieldForRetailStoreMemberGiftCard("number","");
	}


	public RetailStoreMemberForm remainFieldForRetailStoreMemberGiftCard(String parameterName, String initValue){
		FormField field =  remainFromRetailStoreMemberGiftCard(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RetailStoreMemberForm remainFieldForRetailStoreMemberGiftCard(String initValue){
		return remainFieldForRetailStoreMemberGiftCard("remain",initValue);
	}
	public RetailStoreMemberForm remainFieldForRetailStoreMemberGiftCard(){
		return remainFieldForRetailStoreMemberGiftCard("remain","");
	}

	

	
 	public RetailStoreMemberForm transferToAnotherOwnerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherOwner/retailStoreMemberId/");
		this.addFormAction(action);
		return this;
	}

 

	public RetailStoreMemberForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


