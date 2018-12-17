
package com.doublechaintech.retailscm.consumerorder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.supplyorderapproval.SupplyOrderApproval;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.doublechaintech.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.doublechaintech.retailscm.supplyordershipment.SupplyOrderShipment;

public class ConsumerOrderMapper extends BaseRowMapper<ConsumerOrder>{
	
	protected ConsumerOrder internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ConsumerOrder consumerOrder = getConsumerOrder();		
		 		
 		setId(consumerOrder, rs, rowNumber); 		
 		setTitle(consumerOrder, rs, rowNumber); 		
 		setConsumer(consumerOrder, rs, rowNumber); 		
 		setConfirmation(consumerOrder, rs, rowNumber); 		
 		setApproval(consumerOrder, rs, rowNumber); 		
 		setProcessing(consumerOrder, rs, rowNumber); 		
 		setShipment(consumerOrder, rs, rowNumber); 		
 		setDelivery(consumerOrder, rs, rowNumber); 		
 		setStore(consumerOrder, rs, rowNumber); 		
 		setLastUpdateTime(consumerOrder, rs, rowNumber); 		
 		setCurrentStatus(consumerOrder, rs, rowNumber); 		
 		setVersion(consumerOrder, rs, rowNumber);

		return consumerOrder;
	}
	
	protected ConsumerOrder getConsumerOrder(){
		return new ConsumerOrder();
	}		
		
	protected void setId(ConsumerOrder consumerOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ConsumerOrderTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrder.setId(id);
	}
		
	protected void setTitle(ConsumerOrder consumerOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String title = rs.getString(ConsumerOrderTable.COLUMN_TITLE);
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrder.setTitle(title);
	}
		 		
 	protected void setConsumer(ConsumerOrder consumerOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreMemberId = rs.getString(ConsumerOrderTable.COLUMN_CONSUMER);
 		if( retailStoreMemberId == null){
 			return;
 		}
 		if( retailStoreMemberId.isEmpty()){
 			return;
 		}
 		RetailStoreMember retailStoreMember = consumerOrder.getConsumer();
 		if( retailStoreMember != null ){
 			//if the root object 'consumerOrder' already have the property, just set the id for it;
 			retailStoreMember.setId(retailStoreMemberId);
 			
 			return;
 		}
 		consumerOrder.setConsumer(createEmptyConsumer(retailStoreMemberId));
 	}
 	 		
 	protected void setConfirmation(ConsumerOrder consumerOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String supplyOrderConfirmationId = rs.getString(ConsumerOrderTable.COLUMN_CONFIRMATION);
 		if( supplyOrderConfirmationId == null){
 			return;
 		}
 		if( supplyOrderConfirmationId.isEmpty()){
 			return;
 		}
 		SupplyOrderConfirmation supplyOrderConfirmation = consumerOrder.getConfirmation();
 		if( supplyOrderConfirmation != null ){
 			//if the root object 'consumerOrder' already have the property, just set the id for it;
 			supplyOrderConfirmation.setId(supplyOrderConfirmationId);
 			
 			return;
 		}
 		consumerOrder.setConfirmation(createEmptyConfirmation(supplyOrderConfirmationId));
 	}
 	 		
 	protected void setApproval(ConsumerOrder consumerOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String supplyOrderApprovalId = rs.getString(ConsumerOrderTable.COLUMN_APPROVAL);
 		if( supplyOrderApprovalId == null){
 			return;
 		}
 		if( supplyOrderApprovalId.isEmpty()){
 			return;
 		}
 		SupplyOrderApproval supplyOrderApproval = consumerOrder.getApproval();
 		if( supplyOrderApproval != null ){
 			//if the root object 'consumerOrder' already have the property, just set the id for it;
 			supplyOrderApproval.setId(supplyOrderApprovalId);
 			
 			return;
 		}
 		consumerOrder.setApproval(createEmptyApproval(supplyOrderApprovalId));
 	}
 	 		
 	protected void setProcessing(ConsumerOrder consumerOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String supplyOrderProcessingId = rs.getString(ConsumerOrderTable.COLUMN_PROCESSING);
 		if( supplyOrderProcessingId == null){
 			return;
 		}
 		if( supplyOrderProcessingId.isEmpty()){
 			return;
 		}
 		SupplyOrderProcessing supplyOrderProcessing = consumerOrder.getProcessing();
 		if( supplyOrderProcessing != null ){
 			//if the root object 'consumerOrder' already have the property, just set the id for it;
 			supplyOrderProcessing.setId(supplyOrderProcessingId);
 			
 			return;
 		}
 		consumerOrder.setProcessing(createEmptyProcessing(supplyOrderProcessingId));
 	}
 	 		
 	protected void setShipment(ConsumerOrder consumerOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String supplyOrderShipmentId = rs.getString(ConsumerOrderTable.COLUMN_SHIPMENT);
 		if( supplyOrderShipmentId == null){
 			return;
 		}
 		if( supplyOrderShipmentId.isEmpty()){
 			return;
 		}
 		SupplyOrderShipment supplyOrderShipment = consumerOrder.getShipment();
 		if( supplyOrderShipment != null ){
 			//if the root object 'consumerOrder' already have the property, just set the id for it;
 			supplyOrderShipment.setId(supplyOrderShipmentId);
 			
 			return;
 		}
 		consumerOrder.setShipment(createEmptyShipment(supplyOrderShipmentId));
 	}
 	 		
 	protected void setDelivery(ConsumerOrder consumerOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String supplyOrderDeliveryId = rs.getString(ConsumerOrderTable.COLUMN_DELIVERY);
 		if( supplyOrderDeliveryId == null){
 			return;
 		}
 		if( supplyOrderDeliveryId.isEmpty()){
 			return;
 		}
 		SupplyOrderDelivery supplyOrderDelivery = consumerOrder.getDelivery();
 		if( supplyOrderDelivery != null ){
 			//if the root object 'consumerOrder' already have the property, just set the id for it;
 			supplyOrderDelivery.setId(supplyOrderDeliveryId);
 			
 			return;
 		}
 		consumerOrder.setDelivery(createEmptyDelivery(supplyOrderDeliveryId));
 	}
 	 		
 	protected void setStore(ConsumerOrder consumerOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreId = rs.getString(ConsumerOrderTable.COLUMN_STORE);
 		if( retailStoreId == null){
 			return;
 		}
 		if( retailStoreId.isEmpty()){
 			return;
 		}
 		RetailStore retailStore = consumerOrder.getStore();
 		if( retailStore != null ){
 			//if the root object 'consumerOrder' already have the property, just set the id for it;
 			retailStore.setId(retailStoreId);
 			
 			return;
 		}
 		consumerOrder.setStore(createEmptyStore(retailStoreId));
 	}
 	
	protected void setLastUpdateTime(ConsumerOrder consumerOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date lastUpdateTime = rs.getTimestamp(ConsumerOrderTable.COLUMN_LAST_UPDATE_TIME);
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrder.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		
	protected void setCurrentStatus(ConsumerOrder consumerOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String currentStatus = rs.getString(ConsumerOrderTable.COLUMN_CURRENT_STATUS);
		if(currentStatus == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrder.setCurrentStatus(currentStatus);
	}
		
	protected void setVersion(ConsumerOrder consumerOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ConsumerOrderTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrder.setVersion(version);
	}
		
		

 	protected RetailStoreMember  createEmptyConsumer(String retailStoreMemberId){
 		RetailStoreMember retailStoreMember = new RetailStoreMember();
 		retailStoreMember.setId(retailStoreMemberId);
 		retailStoreMember.setVersion(Integer.MAX_VALUE);
 		return retailStoreMember;
 	}
 	
 	protected SupplyOrderConfirmation  createEmptyConfirmation(String supplyOrderConfirmationId){
 		SupplyOrderConfirmation supplyOrderConfirmation = new SupplyOrderConfirmation();
 		supplyOrderConfirmation.setId(supplyOrderConfirmationId);
 		supplyOrderConfirmation.setVersion(Integer.MAX_VALUE);
 		return supplyOrderConfirmation;
 	}
 	
 	protected SupplyOrderApproval  createEmptyApproval(String supplyOrderApprovalId){
 		SupplyOrderApproval supplyOrderApproval = new SupplyOrderApproval();
 		supplyOrderApproval.setId(supplyOrderApprovalId);
 		supplyOrderApproval.setVersion(Integer.MAX_VALUE);
 		return supplyOrderApproval;
 	}
 	
 	protected SupplyOrderProcessing  createEmptyProcessing(String supplyOrderProcessingId){
 		SupplyOrderProcessing supplyOrderProcessing = new SupplyOrderProcessing();
 		supplyOrderProcessing.setId(supplyOrderProcessingId);
 		supplyOrderProcessing.setVersion(Integer.MAX_VALUE);
 		return supplyOrderProcessing;
 	}
 	
 	protected SupplyOrderShipment  createEmptyShipment(String supplyOrderShipmentId){
 		SupplyOrderShipment supplyOrderShipment = new SupplyOrderShipment();
 		supplyOrderShipment.setId(supplyOrderShipmentId);
 		supplyOrderShipment.setVersion(Integer.MAX_VALUE);
 		return supplyOrderShipment;
 	}
 	
 	protected SupplyOrderDelivery  createEmptyDelivery(String supplyOrderDeliveryId){
 		SupplyOrderDelivery supplyOrderDelivery = new SupplyOrderDelivery();
 		supplyOrderDelivery.setId(supplyOrderDeliveryId);
 		supplyOrderDelivery.setVersion(Integer.MAX_VALUE);
 		return supplyOrderDelivery;
 	}
 	
 	protected RetailStore  createEmptyStore(String retailStoreId){
 		RetailStore retailStore = new RetailStore();
 		retailStore.setId(retailStoreId);
 		retailStore.setVersion(Integer.MAX_VALUE);
 		return retailStore;
 	}
 	
}


