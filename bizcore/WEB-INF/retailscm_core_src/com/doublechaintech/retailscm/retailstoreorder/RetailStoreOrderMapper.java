
package com.doublechaintech.retailscm.retailstoreorder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstoreorderapproval.RetailStoreOrderApproval;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoreorderdelivery.RetailStoreOrderDelivery;
import com.doublechaintech.retailscm.retailstoreorderprocessing.RetailStoreOrderProcessing;
import com.doublechaintech.retailscm.retailstoreorderpicking.RetailStoreOrderPicking;
import com.doublechaintech.retailscm.retailstoreorderconfirmation.RetailStoreOrderConfirmation;
import com.doublechaintech.retailscm.retailstoreordershipment.RetailStoreOrderShipment;

public class RetailStoreOrderMapper extends BaseRowMapper<RetailStoreOrder>{
	
	protected RetailStoreOrder internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreOrder retailStoreOrder = getRetailStoreOrder();		
		 		
 		setId(retailStoreOrder, rs, rowNumber); 		
 		setBuyer(retailStoreOrder, rs, rowNumber); 		
 		setSeller(retailStoreOrder, rs, rowNumber); 		
 		setTitle(retailStoreOrder, rs, rowNumber); 		
 		setTotalAmount(retailStoreOrder, rs, rowNumber); 		
 		setConfirmation(retailStoreOrder, rs, rowNumber); 		
 		setApproval(retailStoreOrder, rs, rowNumber); 		
 		setProcessing(retailStoreOrder, rs, rowNumber); 		
 		setPicking(retailStoreOrder, rs, rowNumber); 		
 		setShipment(retailStoreOrder, rs, rowNumber); 		
 		setDelivery(retailStoreOrder, rs, rowNumber); 		
 		setLastUpdateTime(retailStoreOrder, rs, rowNumber); 		
 		setCurrentStatus(retailStoreOrder, rs, rowNumber); 		
 		setVersion(retailStoreOrder, rs, rowNumber);

		return retailStoreOrder;
	}
	
	protected RetailStoreOrder getRetailStoreOrder(){
		return new RetailStoreOrder();
	}		
		
	protected void setId(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(RetailStoreOrderTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrder.setId(id);
	}
		 		
 	protected void setBuyer(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreId = rs.getString(RetailStoreOrderTable.COLUMN_BUYER);
 		if( retailStoreId == null){
 			return;
 		}
 		if( retailStoreId.isEmpty()){
 			return;
 		}
 		RetailStore retailStore = retailStoreOrder.getBuyer();
 		if( retailStore != null ){
 			//if the root object 'retailStoreOrder' already have the property, just set the id for it;
 			retailStore.setId(retailStoreId);
 			
 			return;
 		}
 		retailStoreOrder.setBuyer(createEmptyBuyer(retailStoreId));
 	}
 	 		
 	protected void setSeller(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId = rs.getString(RetailStoreOrderTable.COLUMN_SELLER);
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = retailStoreOrder.getSeller();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'retailStoreOrder' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 			
 			return;
 		}
 		retailStoreOrder.setSeller(createEmptySeller(retailStoreCountryCenterId));
 	}
 	
	protected void setTitle(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String title = rs.getString(RetailStoreOrderTable.COLUMN_TITLE);
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrder.setTitle(title);
	}
		
	protected void setTotalAmount(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		BigDecimal totalAmount = rs.getBigDecimal(RetailStoreOrderTable.COLUMN_TOTAL_AMOUNT);
		if(totalAmount == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrder.setTotalAmount(totalAmount);
	}
		 		
 	protected void setConfirmation(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreOrderConfirmationId = rs.getString(RetailStoreOrderTable.COLUMN_CONFIRMATION);
 		if( retailStoreOrderConfirmationId == null){
 			return;
 		}
 		if( retailStoreOrderConfirmationId.isEmpty()){
 			return;
 		}
 		RetailStoreOrderConfirmation retailStoreOrderConfirmation = retailStoreOrder.getConfirmation();
 		if( retailStoreOrderConfirmation != null ){
 			//if the root object 'retailStoreOrder' already have the property, just set the id for it;
 			retailStoreOrderConfirmation.setId(retailStoreOrderConfirmationId);
 			
 			return;
 		}
 		retailStoreOrder.setConfirmation(createEmptyConfirmation(retailStoreOrderConfirmationId));
 	}
 	 		
 	protected void setApproval(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreOrderApprovalId = rs.getString(RetailStoreOrderTable.COLUMN_APPROVAL);
 		if( retailStoreOrderApprovalId == null){
 			return;
 		}
 		if( retailStoreOrderApprovalId.isEmpty()){
 			return;
 		}
 		RetailStoreOrderApproval retailStoreOrderApproval = retailStoreOrder.getApproval();
 		if( retailStoreOrderApproval != null ){
 			//if the root object 'retailStoreOrder' already have the property, just set the id for it;
 			retailStoreOrderApproval.setId(retailStoreOrderApprovalId);
 			
 			return;
 		}
 		retailStoreOrder.setApproval(createEmptyApproval(retailStoreOrderApprovalId));
 	}
 	 		
 	protected void setProcessing(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreOrderProcessingId = rs.getString(RetailStoreOrderTable.COLUMN_PROCESSING);
 		if( retailStoreOrderProcessingId == null){
 			return;
 		}
 		if( retailStoreOrderProcessingId.isEmpty()){
 			return;
 		}
 		RetailStoreOrderProcessing retailStoreOrderProcessing = retailStoreOrder.getProcessing();
 		if( retailStoreOrderProcessing != null ){
 			//if the root object 'retailStoreOrder' already have the property, just set the id for it;
 			retailStoreOrderProcessing.setId(retailStoreOrderProcessingId);
 			
 			return;
 		}
 		retailStoreOrder.setProcessing(createEmptyProcessing(retailStoreOrderProcessingId));
 	}
 	 		
 	protected void setPicking(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreOrderPickingId = rs.getString(RetailStoreOrderTable.COLUMN_PICKING);
 		if( retailStoreOrderPickingId == null){
 			return;
 		}
 		if( retailStoreOrderPickingId.isEmpty()){
 			return;
 		}
 		RetailStoreOrderPicking retailStoreOrderPicking = retailStoreOrder.getPicking();
 		if( retailStoreOrderPicking != null ){
 			//if the root object 'retailStoreOrder' already have the property, just set the id for it;
 			retailStoreOrderPicking.setId(retailStoreOrderPickingId);
 			
 			return;
 		}
 		retailStoreOrder.setPicking(createEmptyPicking(retailStoreOrderPickingId));
 	}
 	 		
 	protected void setShipment(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreOrderShipmentId = rs.getString(RetailStoreOrderTable.COLUMN_SHIPMENT);
 		if( retailStoreOrderShipmentId == null){
 			return;
 		}
 		if( retailStoreOrderShipmentId.isEmpty()){
 			return;
 		}
 		RetailStoreOrderShipment retailStoreOrderShipment = retailStoreOrder.getShipment();
 		if( retailStoreOrderShipment != null ){
 			//if the root object 'retailStoreOrder' already have the property, just set the id for it;
 			retailStoreOrderShipment.setId(retailStoreOrderShipmentId);
 			
 			return;
 		}
 		retailStoreOrder.setShipment(createEmptyShipment(retailStoreOrderShipmentId));
 	}
 	 		
 	protected void setDelivery(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreOrderDeliveryId = rs.getString(RetailStoreOrderTable.COLUMN_DELIVERY);
 		if( retailStoreOrderDeliveryId == null){
 			return;
 		}
 		if( retailStoreOrderDeliveryId.isEmpty()){
 			return;
 		}
 		RetailStoreOrderDelivery retailStoreOrderDelivery = retailStoreOrder.getDelivery();
 		if( retailStoreOrderDelivery != null ){
 			//if the root object 'retailStoreOrder' already have the property, just set the id for it;
 			retailStoreOrderDelivery.setId(retailStoreOrderDeliveryId);
 			
 			return;
 		}
 		retailStoreOrder.setDelivery(createEmptyDelivery(retailStoreOrderDeliveryId));
 	}
 	
	protected void setLastUpdateTime(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date lastUpdateTime = rs.getTimestamp(RetailStoreOrderTable.COLUMN_LAST_UPDATE_TIME);
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrder.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		
	protected void setCurrentStatus(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String currentStatus = rs.getString(RetailStoreOrderTable.COLUMN_CURRENT_STATUS);
		if(currentStatus == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrder.setCurrentStatus(currentStatus);
	}
		
	protected void setVersion(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(RetailStoreOrderTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrder.setVersion(version);
	}
		
		

 	protected RetailStore  createEmptyBuyer(String retailStoreId){
 		RetailStore retailStore = new RetailStore();
 		retailStore.setId(retailStoreId);
 		retailStore.setVersion(Integer.MAX_VALUE);
 		return retailStore;
 	}
 	
 	protected RetailStoreCountryCenter  createEmptySeller(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
 	protected RetailStoreOrderConfirmation  createEmptyConfirmation(String retailStoreOrderConfirmationId){
 		RetailStoreOrderConfirmation retailStoreOrderConfirmation = new RetailStoreOrderConfirmation();
 		retailStoreOrderConfirmation.setId(retailStoreOrderConfirmationId);
 		retailStoreOrderConfirmation.setVersion(Integer.MAX_VALUE);
 		return retailStoreOrderConfirmation;
 	}
 	
 	protected RetailStoreOrderApproval  createEmptyApproval(String retailStoreOrderApprovalId){
 		RetailStoreOrderApproval retailStoreOrderApproval = new RetailStoreOrderApproval();
 		retailStoreOrderApproval.setId(retailStoreOrderApprovalId);
 		retailStoreOrderApproval.setVersion(Integer.MAX_VALUE);
 		return retailStoreOrderApproval;
 	}
 	
 	protected RetailStoreOrderProcessing  createEmptyProcessing(String retailStoreOrderProcessingId){
 		RetailStoreOrderProcessing retailStoreOrderProcessing = new RetailStoreOrderProcessing();
 		retailStoreOrderProcessing.setId(retailStoreOrderProcessingId);
 		retailStoreOrderProcessing.setVersion(Integer.MAX_VALUE);
 		return retailStoreOrderProcessing;
 	}
 	
 	protected RetailStoreOrderPicking  createEmptyPicking(String retailStoreOrderPickingId){
 		RetailStoreOrderPicking retailStoreOrderPicking = new RetailStoreOrderPicking();
 		retailStoreOrderPicking.setId(retailStoreOrderPickingId);
 		retailStoreOrderPicking.setVersion(Integer.MAX_VALUE);
 		return retailStoreOrderPicking;
 	}
 	
 	protected RetailStoreOrderShipment  createEmptyShipment(String retailStoreOrderShipmentId){
 		RetailStoreOrderShipment retailStoreOrderShipment = new RetailStoreOrderShipment();
 		retailStoreOrderShipment.setId(retailStoreOrderShipmentId);
 		retailStoreOrderShipment.setVersion(Integer.MAX_VALUE);
 		return retailStoreOrderShipment;
 	}
 	
 	protected RetailStoreOrderDelivery  createEmptyDelivery(String retailStoreOrderDeliveryId){
 		RetailStoreOrderDelivery retailStoreOrderDelivery = new RetailStoreOrderDelivery();
 		retailStoreOrderDelivery.setId(retailStoreOrderDeliveryId);
 		retailStoreOrderDelivery.setVersion(Integer.MAX_VALUE);
 		return retailStoreOrderDelivery;
 	}
 	
}


