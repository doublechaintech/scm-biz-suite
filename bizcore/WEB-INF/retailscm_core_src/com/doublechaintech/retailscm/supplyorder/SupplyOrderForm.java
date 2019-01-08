package com.doublechaintech.retailscm.supplyorder;
import com.doublechaintech.retailscm.BaseForm;
import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;



public class SupplyOrderForm extends BaseForm {
	
	
	public SupplyOrderForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public SupplyOrderForm supplyOrderIdField(String parameterName, String initValue){
		FormField field = idFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm supplyOrderIdField(String initValue){
		return supplyOrderIdField("supplyOrderId",initValue);
	}
	public SupplyOrderForm supplyOrderIdField(){
		return supplyOrderIdField("supplyOrderId","");
	}


	public SupplyOrderForm buyerIdField(String parameterName, String initValue){
		FormField field = buyerIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm buyerIdField(String initValue){
		return buyerIdField("buyerId",initValue);
	}
	public SupplyOrderForm buyerIdField(){
		return buyerIdField("buyerId","");
	}


	public SupplyOrderForm sellerIdField(String parameterName, String initValue){
		FormField field = sellerIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm sellerIdField(String initValue){
		return sellerIdField("sellerId",initValue);
	}
	public SupplyOrderForm sellerIdField(){
		return sellerIdField("sellerId","");
	}


	public SupplyOrderForm titleField(String parameterName, String initValue){
		FormField field = titleFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm titleField(String initValue){
		return titleField("title",initValue);
	}
	public SupplyOrderForm titleField(){
		return titleField("title","");
	}


	public SupplyOrderForm totalAmountField(String parameterName, String initValue){
		FormField field = totalAmountFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm totalAmountField(String initValue){
		return totalAmountField("totalAmount",initValue);
	}
	public SupplyOrderForm totalAmountField(){
		return totalAmountField("totalAmount","");
	}


	public SupplyOrderForm confirmationIdField(String parameterName, String initValue){
		FormField field = confirmationIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm confirmationIdField(String initValue){
		return confirmationIdField("confirmationId",initValue);
	}
	public SupplyOrderForm confirmationIdField(){
		return confirmationIdField("confirmationId","");
	}


	public SupplyOrderForm approvalIdField(String parameterName, String initValue){
		FormField field = approvalIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm approvalIdField(String initValue){
		return approvalIdField("approvalId",initValue);
	}
	public SupplyOrderForm approvalIdField(){
		return approvalIdField("approvalId","");
	}


	public SupplyOrderForm processingIdField(String parameterName, String initValue){
		FormField field = processingIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm processingIdField(String initValue){
		return processingIdField("processingId",initValue);
	}
	public SupplyOrderForm processingIdField(){
		return processingIdField("processingId","");
	}


	public SupplyOrderForm pickingIdField(String parameterName, String initValue){
		FormField field = pickingIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm pickingIdField(String initValue){
		return pickingIdField("pickingId",initValue);
	}
	public SupplyOrderForm pickingIdField(){
		return pickingIdField("pickingId","");
	}


	public SupplyOrderForm shipmentIdField(String parameterName, String initValue){
		FormField field = shipmentIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm shipmentIdField(String initValue){
		return shipmentIdField("shipmentId",initValue);
	}
	public SupplyOrderForm shipmentIdField(){
		return shipmentIdField("shipmentId","");
	}


	public SupplyOrderForm deliveryIdField(String parameterName, String initValue){
		FormField field = deliveryIdFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm deliveryIdField(String initValue){
		return deliveryIdField("deliveryId",initValue);
	}
	public SupplyOrderForm deliveryIdField(){
		return deliveryIdField("deliveryId","");
	}


	public SupplyOrderForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public SupplyOrderForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}


	public SupplyOrderForm currentStatusField(String parameterName, String initValue){
		FormField field = currentStatusFromSupplyOrder(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm currentStatusField(String initValue){
		return currentStatusField("currentStatus",initValue);
	}
	public SupplyOrderForm currentStatusField(){
		return currentStatusField("currentStatus","");
	}

	
	


	public SupplyOrderForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  idFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(String initValue){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId",initValue);
	}
	public SupplyOrderForm retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter(){
		return retailStoreCountryCenterIdFieldOfRetailStoreCountryCenter("retailStoreCountryCenterId","");
	}


	public SupplyOrderForm nameFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  nameFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm nameFieldOfRetailStoreCountryCenter(String initValue){
		return nameFieldOfRetailStoreCountryCenter("name",initValue);
	}
	public SupplyOrderForm nameFieldOfRetailStoreCountryCenter(){
		return nameFieldOfRetailStoreCountryCenter("name","");
	}


	public SupplyOrderForm serviceNumberFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  serviceNumberFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm serviceNumberFieldOfRetailStoreCountryCenter(String initValue){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber",initValue);
	}
	public SupplyOrderForm serviceNumberFieldOfRetailStoreCountryCenter(){
		return serviceNumberFieldOfRetailStoreCountryCenter("serviceNumber","");
	}


	public SupplyOrderForm foundedFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  foundedFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm foundedFieldOfRetailStoreCountryCenter(String initValue){
		return foundedFieldOfRetailStoreCountryCenter("founded",initValue);
	}
	public SupplyOrderForm foundedFieldOfRetailStoreCountryCenter(){
		return foundedFieldOfRetailStoreCountryCenter("founded","");
	}


	public SupplyOrderForm webSiteFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  webSiteFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm webSiteFieldOfRetailStoreCountryCenter(String initValue){
		return webSiteFieldOfRetailStoreCountryCenter("webSite",initValue);
	}
	public SupplyOrderForm webSiteFieldOfRetailStoreCountryCenter(){
		return webSiteFieldOfRetailStoreCountryCenter("webSite","");
	}


	public SupplyOrderForm addressFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  addressFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm addressFieldOfRetailStoreCountryCenter(String initValue){
		return addressFieldOfRetailStoreCountryCenter("address",initValue);
	}
	public SupplyOrderForm addressFieldOfRetailStoreCountryCenter(){
		return addressFieldOfRetailStoreCountryCenter("address","");
	}


	public SupplyOrderForm operatedByFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  operatedByFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm operatedByFieldOfRetailStoreCountryCenter(String initValue){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy",initValue);
	}
	public SupplyOrderForm operatedByFieldOfRetailStoreCountryCenter(){
		return operatedByFieldOfRetailStoreCountryCenter("operatedBy","");
	}


	public SupplyOrderForm legalRepresentativeFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  legalRepresentativeFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm legalRepresentativeFieldOfRetailStoreCountryCenter(String initValue){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative",initValue);
	}
	public SupplyOrderForm legalRepresentativeFieldOfRetailStoreCountryCenter(){
		return legalRepresentativeFieldOfRetailStoreCountryCenter("legalRepresentative","");
	}


	public SupplyOrderForm descriptionFieldOfRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field =  descriptionFromRetailStoreCountryCenter(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm descriptionFieldOfRetailStoreCountryCenter(String initValue){
		return descriptionFieldOfRetailStoreCountryCenter("description",initValue);
	}
	public SupplyOrderForm descriptionFieldOfRetailStoreCountryCenter(){
		return descriptionFieldOfRetailStoreCountryCenter("description","");
	}


	public SupplyOrderForm goodsSupplierIdFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  idFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm goodsSupplierIdFieldOfGoodsSupplier(String initValue){
		return goodsSupplierIdFieldOfGoodsSupplier("goodsSupplierId",initValue);
	}
	public SupplyOrderForm goodsSupplierIdFieldOfGoodsSupplier(){
		return goodsSupplierIdFieldOfGoodsSupplier("goodsSupplierId","");
	}


	public SupplyOrderForm nameFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  nameFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm nameFieldOfGoodsSupplier(String initValue){
		return nameFieldOfGoodsSupplier("name",initValue);
	}
	public SupplyOrderForm nameFieldOfGoodsSupplier(){
		return nameFieldOfGoodsSupplier("name","");
	}


	public SupplyOrderForm supplyProductFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  supplyProductFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm supplyProductFieldOfGoodsSupplier(String initValue){
		return supplyProductFieldOfGoodsSupplier("supplyProduct",initValue);
	}
	public SupplyOrderForm supplyProductFieldOfGoodsSupplier(){
		return supplyProductFieldOfGoodsSupplier("supplyProduct","");
	}


	public SupplyOrderForm belongToIdFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  belongToIdFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm belongToIdFieldOfGoodsSupplier(String initValue){
		return belongToIdFieldOfGoodsSupplier("belongToId",initValue);
	}
	public SupplyOrderForm belongToIdFieldOfGoodsSupplier(){
		return belongToIdFieldOfGoodsSupplier("belongToId","");
	}


	public SupplyOrderForm contactNumberFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  contactNumberFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm contactNumberFieldOfGoodsSupplier(String initValue){
		return contactNumberFieldOfGoodsSupplier("contactNumber",initValue);
	}
	public SupplyOrderForm contactNumberFieldOfGoodsSupplier(){
		return contactNumberFieldOfGoodsSupplier("contactNumber","");
	}


	public SupplyOrderForm descriptionFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  descriptionFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm descriptionFieldOfGoodsSupplier(String initValue){
		return descriptionFieldOfGoodsSupplier("description",initValue);
	}
	public SupplyOrderForm descriptionFieldOfGoodsSupplier(){
		return descriptionFieldOfGoodsSupplier("description","");
	}


	public SupplyOrderForm lastUpdateTimeFieldOfGoodsSupplier(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromGoodsSupplier(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm lastUpdateTimeFieldOfGoodsSupplier(String initValue){
		return lastUpdateTimeFieldOfGoodsSupplier("lastUpdateTime",initValue);
	}
	public SupplyOrderForm lastUpdateTimeFieldOfGoodsSupplier(){
		return lastUpdateTimeFieldOfGoodsSupplier("lastUpdateTime","");
	}


	public SupplyOrderForm supplyOrderConfirmationIdFieldOfSupplyOrderConfirmation(String parameterName, String initValue){
		FormField field =  idFromSupplyOrderConfirmation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm supplyOrderConfirmationIdFieldOfSupplyOrderConfirmation(String initValue){
		return supplyOrderConfirmationIdFieldOfSupplyOrderConfirmation("supplyOrderConfirmationId",initValue);
	}
	public SupplyOrderForm supplyOrderConfirmationIdFieldOfSupplyOrderConfirmation(){
		return supplyOrderConfirmationIdFieldOfSupplyOrderConfirmation("supplyOrderConfirmationId","");
	}


	public SupplyOrderForm whoFieldOfSupplyOrderConfirmation(String parameterName, String initValue){
		FormField field =  whoFromSupplyOrderConfirmation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm whoFieldOfSupplyOrderConfirmation(String initValue){
		return whoFieldOfSupplyOrderConfirmation("who",initValue);
	}
	public SupplyOrderForm whoFieldOfSupplyOrderConfirmation(){
		return whoFieldOfSupplyOrderConfirmation("who","");
	}


	public SupplyOrderForm confirmTimeFieldOfSupplyOrderConfirmation(String parameterName, String initValue){
		FormField field =  confirmTimeFromSupplyOrderConfirmation(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm confirmTimeFieldOfSupplyOrderConfirmation(String initValue){
		return confirmTimeFieldOfSupplyOrderConfirmation("confirmTime",initValue);
	}
	public SupplyOrderForm confirmTimeFieldOfSupplyOrderConfirmation(){
		return confirmTimeFieldOfSupplyOrderConfirmation("confirmTime","");
	}


	public SupplyOrderForm supplyOrderApprovalIdFieldOfSupplyOrderApproval(String parameterName, String initValue){
		FormField field =  idFromSupplyOrderApproval(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm supplyOrderApprovalIdFieldOfSupplyOrderApproval(String initValue){
		return supplyOrderApprovalIdFieldOfSupplyOrderApproval("supplyOrderApprovalId",initValue);
	}
	public SupplyOrderForm supplyOrderApprovalIdFieldOfSupplyOrderApproval(){
		return supplyOrderApprovalIdFieldOfSupplyOrderApproval("supplyOrderApprovalId","");
	}


	public SupplyOrderForm whoFieldOfSupplyOrderApproval(String parameterName, String initValue){
		FormField field =  whoFromSupplyOrderApproval(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm whoFieldOfSupplyOrderApproval(String initValue){
		return whoFieldOfSupplyOrderApproval("who",initValue);
	}
	public SupplyOrderForm whoFieldOfSupplyOrderApproval(){
		return whoFieldOfSupplyOrderApproval("who","");
	}


	public SupplyOrderForm approveTimeFieldOfSupplyOrderApproval(String parameterName, String initValue){
		FormField field =  approveTimeFromSupplyOrderApproval(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm approveTimeFieldOfSupplyOrderApproval(String initValue){
		return approveTimeFieldOfSupplyOrderApproval("approveTime",initValue);
	}
	public SupplyOrderForm approveTimeFieldOfSupplyOrderApproval(){
		return approveTimeFieldOfSupplyOrderApproval("approveTime","");
	}


	public SupplyOrderForm supplyOrderProcessingIdFieldOfSupplyOrderProcessing(String parameterName, String initValue){
		FormField field =  idFromSupplyOrderProcessing(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm supplyOrderProcessingIdFieldOfSupplyOrderProcessing(String initValue){
		return supplyOrderProcessingIdFieldOfSupplyOrderProcessing("supplyOrderProcessingId",initValue);
	}
	public SupplyOrderForm supplyOrderProcessingIdFieldOfSupplyOrderProcessing(){
		return supplyOrderProcessingIdFieldOfSupplyOrderProcessing("supplyOrderProcessingId","");
	}


	public SupplyOrderForm whoFieldOfSupplyOrderProcessing(String parameterName, String initValue){
		FormField field =  whoFromSupplyOrderProcessing(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm whoFieldOfSupplyOrderProcessing(String initValue){
		return whoFieldOfSupplyOrderProcessing("who",initValue);
	}
	public SupplyOrderForm whoFieldOfSupplyOrderProcessing(){
		return whoFieldOfSupplyOrderProcessing("who","");
	}


	public SupplyOrderForm processTimeFieldOfSupplyOrderProcessing(String parameterName, String initValue){
		FormField field =  processTimeFromSupplyOrderProcessing(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm processTimeFieldOfSupplyOrderProcessing(String initValue){
		return processTimeFieldOfSupplyOrderProcessing("processTime",initValue);
	}
	public SupplyOrderForm processTimeFieldOfSupplyOrderProcessing(){
		return processTimeFieldOfSupplyOrderProcessing("processTime","");
	}


	public SupplyOrderForm supplyOrderPickingIdFieldOfSupplyOrderPicking(String parameterName, String initValue){
		FormField field =  idFromSupplyOrderPicking(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm supplyOrderPickingIdFieldOfSupplyOrderPicking(String initValue){
		return supplyOrderPickingIdFieldOfSupplyOrderPicking("supplyOrderPickingId",initValue);
	}
	public SupplyOrderForm supplyOrderPickingIdFieldOfSupplyOrderPicking(){
		return supplyOrderPickingIdFieldOfSupplyOrderPicking("supplyOrderPickingId","");
	}


	public SupplyOrderForm whoFieldOfSupplyOrderPicking(String parameterName, String initValue){
		FormField field =  whoFromSupplyOrderPicking(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm whoFieldOfSupplyOrderPicking(String initValue){
		return whoFieldOfSupplyOrderPicking("who",initValue);
	}
	public SupplyOrderForm whoFieldOfSupplyOrderPicking(){
		return whoFieldOfSupplyOrderPicking("who","");
	}


	public SupplyOrderForm processTimeFieldOfSupplyOrderPicking(String parameterName, String initValue){
		FormField field =  processTimeFromSupplyOrderPicking(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm processTimeFieldOfSupplyOrderPicking(String initValue){
		return processTimeFieldOfSupplyOrderPicking("processTime",initValue);
	}
	public SupplyOrderForm processTimeFieldOfSupplyOrderPicking(){
		return processTimeFieldOfSupplyOrderPicking("processTime","");
	}


	public SupplyOrderForm supplyOrderShipmentIdFieldOfSupplyOrderShipment(String parameterName, String initValue){
		FormField field =  idFromSupplyOrderShipment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm supplyOrderShipmentIdFieldOfSupplyOrderShipment(String initValue){
		return supplyOrderShipmentIdFieldOfSupplyOrderShipment("supplyOrderShipmentId",initValue);
	}
	public SupplyOrderForm supplyOrderShipmentIdFieldOfSupplyOrderShipment(){
		return supplyOrderShipmentIdFieldOfSupplyOrderShipment("supplyOrderShipmentId","");
	}


	public SupplyOrderForm whoFieldOfSupplyOrderShipment(String parameterName, String initValue){
		FormField field =  whoFromSupplyOrderShipment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm whoFieldOfSupplyOrderShipment(String initValue){
		return whoFieldOfSupplyOrderShipment("who",initValue);
	}
	public SupplyOrderForm whoFieldOfSupplyOrderShipment(){
		return whoFieldOfSupplyOrderShipment("who","");
	}


	public SupplyOrderForm shipTimeFieldOfSupplyOrderShipment(String parameterName, String initValue){
		FormField field =  shipTimeFromSupplyOrderShipment(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm shipTimeFieldOfSupplyOrderShipment(String initValue){
		return shipTimeFieldOfSupplyOrderShipment("shipTime",initValue);
	}
	public SupplyOrderForm shipTimeFieldOfSupplyOrderShipment(){
		return shipTimeFieldOfSupplyOrderShipment("shipTime","");
	}


	public SupplyOrderForm supplyOrderDeliveryIdFieldOfSupplyOrderDelivery(String parameterName, String initValue){
		FormField field =  idFromSupplyOrderDelivery(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm supplyOrderDeliveryIdFieldOfSupplyOrderDelivery(String initValue){
		return supplyOrderDeliveryIdFieldOfSupplyOrderDelivery("supplyOrderDeliveryId",initValue);
	}
	public SupplyOrderForm supplyOrderDeliveryIdFieldOfSupplyOrderDelivery(){
		return supplyOrderDeliveryIdFieldOfSupplyOrderDelivery("supplyOrderDeliveryId","");
	}


	public SupplyOrderForm whoFieldOfSupplyOrderDelivery(String parameterName, String initValue){
		FormField field =  whoFromSupplyOrderDelivery(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm whoFieldOfSupplyOrderDelivery(String initValue){
		return whoFieldOfSupplyOrderDelivery("who",initValue);
	}
	public SupplyOrderForm whoFieldOfSupplyOrderDelivery(){
		return whoFieldOfSupplyOrderDelivery("who","");
	}


	public SupplyOrderForm deliveryTimeFieldOfSupplyOrderDelivery(String parameterName, String initValue){
		FormField field =  deliveryTimeFromSupplyOrderDelivery(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public SupplyOrderForm deliveryTimeFieldOfSupplyOrderDelivery(String initValue){
		return deliveryTimeFieldOfSupplyOrderDelivery("deliveryTime",initValue);
	}
	public SupplyOrderForm deliveryTimeFieldOfSupplyOrderDelivery(){
		return deliveryTimeFieldOfSupplyOrderDelivery("deliveryTime","");
	}

	



	public SupplyOrderForm supplyOrderLineItemIdFieldForSupplyOrderLineItem(String parameterName, String initValue){
		FormField field =  idFromSupplyOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm supplyOrderLineItemIdFieldForSupplyOrderLineItem(String initValue){
		return supplyOrderLineItemIdFieldForSupplyOrderLineItem("supplyOrderLineItemId",initValue);
	}
	public SupplyOrderForm supplyOrderLineItemIdFieldForSupplyOrderLineItem(){
		return supplyOrderLineItemIdFieldForSupplyOrderLineItem("supplyOrderLineItemId","");
	}


	public SupplyOrderForm bizOrderIdFieldForSupplyOrderLineItem(String parameterName, String initValue){
		FormField field =  bizOrderIdFromSupplyOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm bizOrderIdFieldForSupplyOrderLineItem(String initValue){
		return bizOrderIdFieldForSupplyOrderLineItem("bizOrderId",initValue);
	}
	public SupplyOrderForm bizOrderIdFieldForSupplyOrderLineItem(){
		return bizOrderIdFieldForSupplyOrderLineItem("bizOrderId","");
	}


	public SupplyOrderForm skuIdFieldForSupplyOrderLineItem(String parameterName, String initValue){
		FormField field =  skuIdFromSupplyOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm skuIdFieldForSupplyOrderLineItem(String initValue){
		return skuIdFieldForSupplyOrderLineItem("skuId",initValue);
	}
	public SupplyOrderForm skuIdFieldForSupplyOrderLineItem(){
		return skuIdFieldForSupplyOrderLineItem("skuId","");
	}


	public SupplyOrderForm skuNameFieldForSupplyOrderLineItem(String parameterName, String initValue){
		FormField field =  skuNameFromSupplyOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm skuNameFieldForSupplyOrderLineItem(String initValue){
		return skuNameFieldForSupplyOrderLineItem("skuName",initValue);
	}
	public SupplyOrderForm skuNameFieldForSupplyOrderLineItem(){
		return skuNameFieldForSupplyOrderLineItem("skuName","");
	}


	public SupplyOrderForm amountFieldForSupplyOrderLineItem(String parameterName, String initValue){
		FormField field =  amountFromSupplyOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm amountFieldForSupplyOrderLineItem(String initValue){
		return amountFieldForSupplyOrderLineItem("amount",initValue);
	}
	public SupplyOrderForm amountFieldForSupplyOrderLineItem(){
		return amountFieldForSupplyOrderLineItem("amount","");
	}


	public SupplyOrderForm quantityFieldForSupplyOrderLineItem(String parameterName, String initValue){
		FormField field =  quantityFromSupplyOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm quantityFieldForSupplyOrderLineItem(String initValue){
		return quantityFieldForSupplyOrderLineItem("quantity",initValue);
	}
	public SupplyOrderForm quantityFieldForSupplyOrderLineItem(){
		return quantityFieldForSupplyOrderLineItem("quantity","");
	}


	public SupplyOrderForm unitOfMeasurementFieldForSupplyOrderLineItem(String parameterName, String initValue){
		FormField field =  unitOfMeasurementFromSupplyOrderLineItem(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm unitOfMeasurementFieldForSupplyOrderLineItem(String initValue){
		return unitOfMeasurementFieldForSupplyOrderLineItem("unitOfMeasurement",initValue);
	}
	public SupplyOrderForm unitOfMeasurementFieldForSupplyOrderLineItem(){
		return unitOfMeasurementFieldForSupplyOrderLineItem("unitOfMeasurement","");
	}


	public SupplyOrderForm supplyOrderShippingGroupIdFieldForSupplyOrderShippingGroup(String parameterName, String initValue){
		FormField field =  idFromSupplyOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm supplyOrderShippingGroupIdFieldForSupplyOrderShippingGroup(String initValue){
		return supplyOrderShippingGroupIdFieldForSupplyOrderShippingGroup("supplyOrderShippingGroupId",initValue);
	}
	public SupplyOrderForm supplyOrderShippingGroupIdFieldForSupplyOrderShippingGroup(){
		return supplyOrderShippingGroupIdFieldForSupplyOrderShippingGroup("supplyOrderShippingGroupId","");
	}


	public SupplyOrderForm nameFieldForSupplyOrderShippingGroup(String parameterName, String initValue){
		FormField field =  nameFromSupplyOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm nameFieldForSupplyOrderShippingGroup(String initValue){
		return nameFieldForSupplyOrderShippingGroup("name",initValue);
	}
	public SupplyOrderForm nameFieldForSupplyOrderShippingGroup(){
		return nameFieldForSupplyOrderShippingGroup("name","");
	}


	public SupplyOrderForm bizOrderIdFieldForSupplyOrderShippingGroup(String parameterName, String initValue){
		FormField field =  bizOrderIdFromSupplyOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm bizOrderIdFieldForSupplyOrderShippingGroup(String initValue){
		return bizOrderIdFieldForSupplyOrderShippingGroup("bizOrderId",initValue);
	}
	public SupplyOrderForm bizOrderIdFieldForSupplyOrderShippingGroup(){
		return bizOrderIdFieldForSupplyOrderShippingGroup("bizOrderId","");
	}


	public SupplyOrderForm amountFieldForSupplyOrderShippingGroup(String parameterName, String initValue){
		FormField field =  amountFromSupplyOrderShippingGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm amountFieldForSupplyOrderShippingGroup(String initValue){
		return amountFieldForSupplyOrderShippingGroup("amount",initValue);
	}
	public SupplyOrderForm amountFieldForSupplyOrderShippingGroup(){
		return amountFieldForSupplyOrderShippingGroup("amount","");
	}


	public SupplyOrderForm supplyOrderPaymentGroupIdFieldForSupplyOrderPaymentGroup(String parameterName, String initValue){
		FormField field =  idFromSupplyOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm supplyOrderPaymentGroupIdFieldForSupplyOrderPaymentGroup(String initValue){
		return supplyOrderPaymentGroupIdFieldForSupplyOrderPaymentGroup("supplyOrderPaymentGroupId",initValue);
	}
	public SupplyOrderForm supplyOrderPaymentGroupIdFieldForSupplyOrderPaymentGroup(){
		return supplyOrderPaymentGroupIdFieldForSupplyOrderPaymentGroup("supplyOrderPaymentGroupId","");
	}


	public SupplyOrderForm nameFieldForSupplyOrderPaymentGroup(String parameterName, String initValue){
		FormField field =  nameFromSupplyOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm nameFieldForSupplyOrderPaymentGroup(String initValue){
		return nameFieldForSupplyOrderPaymentGroup("name",initValue);
	}
	public SupplyOrderForm nameFieldForSupplyOrderPaymentGroup(){
		return nameFieldForSupplyOrderPaymentGroup("name","");
	}


	public SupplyOrderForm bizOrderIdFieldForSupplyOrderPaymentGroup(String parameterName, String initValue){
		FormField field =  bizOrderIdFromSupplyOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm bizOrderIdFieldForSupplyOrderPaymentGroup(String initValue){
		return bizOrderIdFieldForSupplyOrderPaymentGroup("bizOrderId",initValue);
	}
	public SupplyOrderForm bizOrderIdFieldForSupplyOrderPaymentGroup(){
		return bizOrderIdFieldForSupplyOrderPaymentGroup("bizOrderId","");
	}


	public SupplyOrderForm cardNumberFieldForSupplyOrderPaymentGroup(String parameterName, String initValue){
		FormField field =  cardNumberFromSupplyOrderPaymentGroup(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm cardNumberFieldForSupplyOrderPaymentGroup(String initValue){
		return cardNumberFieldForSupplyOrderPaymentGroup("cardNumber",initValue);
	}
	public SupplyOrderForm cardNumberFieldForSupplyOrderPaymentGroup(){
		return cardNumberFieldForSupplyOrderPaymentGroup("cardNumber","");
	}


	public SupplyOrderForm goodsIdFieldForGoods(String parameterName, String initValue){
		FormField field =  idFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm goodsIdFieldForGoods(String initValue){
		return goodsIdFieldForGoods("goodsId",initValue);
	}
	public SupplyOrderForm goodsIdFieldForGoods(){
		return goodsIdFieldForGoods("goodsId","");
	}


	public SupplyOrderForm nameFieldForGoods(String parameterName, String initValue){
		FormField field =  nameFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm nameFieldForGoods(String initValue){
		return nameFieldForGoods("name",initValue);
	}
	public SupplyOrderForm nameFieldForGoods(){
		return nameFieldForGoods("name","");
	}


	public SupplyOrderForm rfidFieldForGoods(String parameterName, String initValue){
		FormField field =  rfidFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm rfidFieldForGoods(String initValue){
		return rfidFieldForGoods("rfid",initValue);
	}
	public SupplyOrderForm rfidFieldForGoods(){
		return rfidFieldForGoods("rfid","");
	}


	public SupplyOrderForm uomFieldForGoods(String parameterName, String initValue){
		FormField field =  uomFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm uomFieldForGoods(String initValue){
		return uomFieldForGoods("uom",initValue);
	}
	public SupplyOrderForm uomFieldForGoods(){
		return uomFieldForGoods("uom","");
	}


	public SupplyOrderForm maxPackageFieldForGoods(String parameterName, String initValue){
		FormField field =  maxPackageFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm maxPackageFieldForGoods(String initValue){
		return maxPackageFieldForGoods("maxPackage",initValue);
	}
	public SupplyOrderForm maxPackageFieldForGoods(){
		return maxPackageFieldForGoods("maxPackage","");
	}


	public SupplyOrderForm expireTimeFieldForGoods(String parameterName, String initValue){
		FormField field =  expireTimeFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm expireTimeFieldForGoods(String initValue){
		return expireTimeFieldForGoods("expireTime",initValue);
	}
	public SupplyOrderForm expireTimeFieldForGoods(){
		return expireTimeFieldForGoods("expireTime","");
	}


	public SupplyOrderForm skuIdFieldForGoods(String parameterName, String initValue){
		FormField field =  skuIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm skuIdFieldForGoods(String initValue){
		return skuIdFieldForGoods("skuId",initValue);
	}
	public SupplyOrderForm skuIdFieldForGoods(){
		return skuIdFieldForGoods("skuId","");
	}


	public SupplyOrderForm receivingSpaceIdFieldForGoods(String parameterName, String initValue){
		FormField field =  receivingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm receivingSpaceIdFieldForGoods(String initValue){
		return receivingSpaceIdFieldForGoods("receivingSpaceId",initValue);
	}
	public SupplyOrderForm receivingSpaceIdFieldForGoods(){
		return receivingSpaceIdFieldForGoods("receivingSpaceId","");
	}


	public SupplyOrderForm goodsAllocationIdFieldForGoods(String parameterName, String initValue){
		FormField field =  goodsAllocationIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm goodsAllocationIdFieldForGoods(String initValue){
		return goodsAllocationIdFieldForGoods("goodsAllocationId",initValue);
	}
	public SupplyOrderForm goodsAllocationIdFieldForGoods(){
		return goodsAllocationIdFieldForGoods("goodsAllocationId","");
	}


	public SupplyOrderForm smartPalletIdFieldForGoods(String parameterName, String initValue){
		FormField field =  smartPalletIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm smartPalletIdFieldForGoods(String initValue){
		return smartPalletIdFieldForGoods("smartPalletId",initValue);
	}
	public SupplyOrderForm smartPalletIdFieldForGoods(){
		return smartPalletIdFieldForGoods("smartPalletId","");
	}


	public SupplyOrderForm shippingSpaceIdFieldForGoods(String parameterName, String initValue){
		FormField field =  shippingSpaceIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm shippingSpaceIdFieldForGoods(String initValue){
		return shippingSpaceIdFieldForGoods("shippingSpaceId",initValue);
	}
	public SupplyOrderForm shippingSpaceIdFieldForGoods(){
		return shippingSpaceIdFieldForGoods("shippingSpaceId","");
	}


	public SupplyOrderForm transportTaskIdFieldForGoods(String parameterName, String initValue){
		FormField field =  transportTaskIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm transportTaskIdFieldForGoods(String initValue){
		return transportTaskIdFieldForGoods("transportTaskId",initValue);
	}
	public SupplyOrderForm transportTaskIdFieldForGoods(){
		return transportTaskIdFieldForGoods("transportTaskId","");
	}


	public SupplyOrderForm retailStoreIdFieldForGoods(String parameterName, String initValue){
		FormField field =  retailStoreIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm retailStoreIdFieldForGoods(String initValue){
		return retailStoreIdFieldForGoods("retailStoreId",initValue);
	}
	public SupplyOrderForm retailStoreIdFieldForGoods(){
		return retailStoreIdFieldForGoods("retailStoreId","");
	}


	public SupplyOrderForm bizOrderIdFieldForGoods(String parameterName, String initValue){
		FormField field =  bizOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm bizOrderIdFieldForGoods(String initValue){
		return bizOrderIdFieldForGoods("bizOrderId",initValue);
	}
	public SupplyOrderForm bizOrderIdFieldForGoods(){
		return bizOrderIdFieldForGoods("bizOrderId","");
	}


	public SupplyOrderForm retailStoreOrderIdFieldForGoods(String parameterName, String initValue){
		FormField field =  retailStoreOrderIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm retailStoreOrderIdFieldForGoods(String initValue){
		return retailStoreOrderIdFieldForGoods("retailStoreOrderId",initValue);
	}
	public SupplyOrderForm retailStoreOrderIdFieldForGoods(){
		return retailStoreOrderIdFieldForGoods("retailStoreOrderId","");
	}


	public SupplyOrderForm packagingIdFieldForGoods(String parameterName, String initValue){
		FormField field =  packagingIdFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm packagingIdFieldForGoods(String initValue){
		return packagingIdFieldForGoods("packagingId",initValue);
	}
	public SupplyOrderForm packagingIdFieldForGoods(){
		return packagingIdFieldForGoods("packagingId","");
	}


	public SupplyOrderForm currentStatusFieldForGoods(String parameterName, String initValue){
		FormField field =  currentStatusFromGoods(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public SupplyOrderForm currentStatusFieldForGoods(String initValue){
		return currentStatusFieldForGoods("currentStatus",initValue);
	}
	public SupplyOrderForm currentStatusFieldForGoods(){
		return currentStatusFieldForGoods("currentStatus","");
	}

	

	
 	public SupplyOrderForm transferToAnotherBuyerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherBuyer/supplyOrderId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public SupplyOrderForm transferToAnotherSellerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherSeller/supplyOrderId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public SupplyOrderForm  confirmAction(){
		FormAction action = new FormAction();
		action.setLabel("Confirm");
		action.setLocaleKey("supply_order.confirm");
		action.setUrl("supplyOrderManager/confirm/supplyOrderId/who/confirmTime/");
		this.addFormAction(action);
		return this;
	}	
 	public SupplyOrderForm  approveAction(){
		FormAction action = new FormAction();
		action.setLabel("Approve");
		action.setLocaleKey("supply_order.approve");
		action.setUrl("supplyOrderManager/approve/supplyOrderId/who/approveTime/");
		this.addFormAction(action);
		return this;
	}	
 	public SupplyOrderForm  processAction(){
		FormAction action = new FormAction();
		action.setLabel("Process");
		action.setLocaleKey("supply_order.process");
		action.setUrl("supplyOrderManager/process/supplyOrderId/who/processTime/");
		this.addFormAction(action);
		return this;
	}	
 	public SupplyOrderForm  pickAction(){
		FormAction action = new FormAction();
		action.setLabel("Pick");
		action.setLocaleKey("supply_order.pick");
		action.setUrl("supplyOrderManager/pick/supplyOrderId/who/processTime/");
		this.addFormAction(action);
		return this;
	}	
 	public SupplyOrderForm  shipAction(){
		FormAction action = new FormAction();
		action.setLabel("Ship");
		action.setLocaleKey("supply_order.ship");
		action.setUrl("supplyOrderManager/ship/supplyOrderId/who/shipTime/");
		this.addFormAction(action);
		return this;
	}	
 	public SupplyOrderForm  deliverAction(){
		FormAction action = new FormAction();
		action.setLabel("Deliver");
		action.setLocaleKey("supply_order.deliver");
		action.setUrl("supplyOrderManager/deliver/supplyOrderId/who/deliveryTime/");
		this.addFormAction(action);
		return this;
	}

	public SupplyOrderForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


