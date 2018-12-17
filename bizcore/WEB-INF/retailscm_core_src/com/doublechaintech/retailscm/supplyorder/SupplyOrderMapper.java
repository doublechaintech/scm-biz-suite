
package com.doublechaintech.retailscm.supplyorder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.supplyorderapproval.SupplyOrderApproval;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.doublechaintech.retailscm.supplyorderpicking.SupplyOrderPicking;
import com.doublechaintech.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.doublechaintech.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.doublechaintech.retailscm.supplyordershipment.SupplyOrderShipment;

public class SupplyOrderMapper extends BaseRowMapper<SupplyOrder>{
	
	protected SupplyOrder internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		SupplyOrder supplyOrder = getSupplyOrder();		
		 		
 		setId(supplyOrder, rs, rowNumber); 		
 		setBuyer(supplyOrder, rs, rowNumber); 		
 		setSeller(supplyOrder, rs, rowNumber); 		
 		setTitle(supplyOrder, rs, rowNumber); 		
 		setTotalAmount(supplyOrder, rs, rowNumber); 		
 		setConfirmation(supplyOrder, rs, rowNumber); 		
 		setApproval(supplyOrder, rs, rowNumber); 		
 		setProcessing(supplyOrder, rs, rowNumber); 		
 		setPicking(supplyOrder, rs, rowNumber); 		
 		setShipment(supplyOrder, rs, rowNumber); 		
 		setDelivery(supplyOrder, rs, rowNumber); 		
 		setLastUpdateTime(supplyOrder, rs, rowNumber); 		
 		setCurrentStatus(supplyOrder, rs, rowNumber); 		
 		setVersion(supplyOrder, rs, rowNumber);

		return supplyOrder;
	}
	
	protected SupplyOrder getSupplyOrder(){
		return new SupplyOrder();
	}		
		
	protected void setId(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(SupplyOrderTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrder.setId(id);
	}
		 		
 	protected void setBuyer(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId = rs.getString(SupplyOrderTable.COLUMN_BUYER);
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = supplyOrder.getBuyer();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'supplyOrder' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 			
 			return;
 		}
 		supplyOrder.setBuyer(createEmptyBuyer(retailStoreCountryCenterId));
 	}
 	 		
 	protected void setSeller(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String goodsSupplierId = rs.getString(SupplyOrderTable.COLUMN_SELLER);
 		if( goodsSupplierId == null){
 			return;
 		}
 		if( goodsSupplierId.isEmpty()){
 			return;
 		}
 		GoodsSupplier goodsSupplier = supplyOrder.getSeller();
 		if( goodsSupplier != null ){
 			//if the root object 'supplyOrder' already have the property, just set the id for it;
 			goodsSupplier.setId(goodsSupplierId);
 			
 			return;
 		}
 		supplyOrder.setSeller(createEmptySeller(goodsSupplierId));
 	}
 	
	protected void setTitle(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String title = rs.getString(SupplyOrderTable.COLUMN_TITLE);
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrder.setTitle(title);
	}
		
	protected void setTotalAmount(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		BigDecimal totalAmount = rs.getBigDecimal(SupplyOrderTable.COLUMN_TOTAL_AMOUNT);
		if(totalAmount == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrder.setTotalAmount(totalAmount);
	}
		 		
 	protected void setConfirmation(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String supplyOrderConfirmationId = rs.getString(SupplyOrderTable.COLUMN_CONFIRMATION);
 		if( supplyOrderConfirmationId == null){
 			return;
 		}
 		if( supplyOrderConfirmationId.isEmpty()){
 			return;
 		}
 		SupplyOrderConfirmation supplyOrderConfirmation = supplyOrder.getConfirmation();
 		if( supplyOrderConfirmation != null ){
 			//if the root object 'supplyOrder' already have the property, just set the id for it;
 			supplyOrderConfirmation.setId(supplyOrderConfirmationId);
 			
 			return;
 		}
 		supplyOrder.setConfirmation(createEmptyConfirmation(supplyOrderConfirmationId));
 	}
 	 		
 	protected void setApproval(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String supplyOrderApprovalId = rs.getString(SupplyOrderTable.COLUMN_APPROVAL);
 		if( supplyOrderApprovalId == null){
 			return;
 		}
 		if( supplyOrderApprovalId.isEmpty()){
 			return;
 		}
 		SupplyOrderApproval supplyOrderApproval = supplyOrder.getApproval();
 		if( supplyOrderApproval != null ){
 			//if the root object 'supplyOrder' already have the property, just set the id for it;
 			supplyOrderApproval.setId(supplyOrderApprovalId);
 			
 			return;
 		}
 		supplyOrder.setApproval(createEmptyApproval(supplyOrderApprovalId));
 	}
 	 		
 	protected void setProcessing(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String supplyOrderProcessingId = rs.getString(SupplyOrderTable.COLUMN_PROCESSING);
 		if( supplyOrderProcessingId == null){
 			return;
 		}
 		if( supplyOrderProcessingId.isEmpty()){
 			return;
 		}
 		SupplyOrderProcessing supplyOrderProcessing = supplyOrder.getProcessing();
 		if( supplyOrderProcessing != null ){
 			//if the root object 'supplyOrder' already have the property, just set the id for it;
 			supplyOrderProcessing.setId(supplyOrderProcessingId);
 			
 			return;
 		}
 		supplyOrder.setProcessing(createEmptyProcessing(supplyOrderProcessingId));
 	}
 	 		
 	protected void setPicking(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String supplyOrderPickingId = rs.getString(SupplyOrderTable.COLUMN_PICKING);
 		if( supplyOrderPickingId == null){
 			return;
 		}
 		if( supplyOrderPickingId.isEmpty()){
 			return;
 		}
 		SupplyOrderPicking supplyOrderPicking = supplyOrder.getPicking();
 		if( supplyOrderPicking != null ){
 			//if the root object 'supplyOrder' already have the property, just set the id for it;
 			supplyOrderPicking.setId(supplyOrderPickingId);
 			
 			return;
 		}
 		supplyOrder.setPicking(createEmptyPicking(supplyOrderPickingId));
 	}
 	 		
 	protected void setShipment(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String supplyOrderShipmentId = rs.getString(SupplyOrderTable.COLUMN_SHIPMENT);
 		if( supplyOrderShipmentId == null){
 			return;
 		}
 		if( supplyOrderShipmentId.isEmpty()){
 			return;
 		}
 		SupplyOrderShipment supplyOrderShipment = supplyOrder.getShipment();
 		if( supplyOrderShipment != null ){
 			//if the root object 'supplyOrder' already have the property, just set the id for it;
 			supplyOrderShipment.setId(supplyOrderShipmentId);
 			
 			return;
 		}
 		supplyOrder.setShipment(createEmptyShipment(supplyOrderShipmentId));
 	}
 	 		
 	protected void setDelivery(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String supplyOrderDeliveryId = rs.getString(SupplyOrderTable.COLUMN_DELIVERY);
 		if( supplyOrderDeliveryId == null){
 			return;
 		}
 		if( supplyOrderDeliveryId.isEmpty()){
 			return;
 		}
 		SupplyOrderDelivery supplyOrderDelivery = supplyOrder.getDelivery();
 		if( supplyOrderDelivery != null ){
 			//if the root object 'supplyOrder' already have the property, just set the id for it;
 			supplyOrderDelivery.setId(supplyOrderDeliveryId);
 			
 			return;
 		}
 		supplyOrder.setDelivery(createEmptyDelivery(supplyOrderDeliveryId));
 	}
 	
	protected void setLastUpdateTime(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date lastUpdateTime = rs.getTimestamp(SupplyOrderTable.COLUMN_LAST_UPDATE_TIME);
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrder.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		
	protected void setCurrentStatus(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String currentStatus = rs.getString(SupplyOrderTable.COLUMN_CURRENT_STATUS);
		if(currentStatus == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrder.setCurrentStatus(currentStatus);
	}
		
	protected void setVersion(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(SupplyOrderTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrder.setVersion(version);
	}
		
		

 	protected RetailStoreCountryCenter  createEmptyBuyer(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
 	protected GoodsSupplier  createEmptySeller(String goodsSupplierId){
 		GoodsSupplier goodsSupplier = new GoodsSupplier();
 		goodsSupplier.setId(goodsSupplierId);
 		goodsSupplier.setVersion(Integer.MAX_VALUE);
 		return goodsSupplier;
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
 	
 	protected SupplyOrderPicking  createEmptyPicking(String supplyOrderPickingId){
 		SupplyOrderPicking supplyOrderPicking = new SupplyOrderPicking();
 		supplyOrderPicking.setId(supplyOrderPickingId);
 		supplyOrderPicking.setVersion(Integer.MAX_VALUE);
 		return supplyOrderPicking;
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
 	
}


