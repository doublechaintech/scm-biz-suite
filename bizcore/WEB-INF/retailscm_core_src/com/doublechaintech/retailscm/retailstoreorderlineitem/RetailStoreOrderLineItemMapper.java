
package com.doublechaintech.retailscm.retailstoreorderlineitem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

public class RetailStoreOrderLineItemMapper extends BaseRowMapper<RetailStoreOrderLineItem>{
	
	protected RetailStoreOrderLineItem internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreOrderLineItem retailStoreOrderLineItem = getRetailStoreOrderLineItem();		
		 		
 		setId(retailStoreOrderLineItem, rs, rowNumber); 		
 		setBizOrder(retailStoreOrderLineItem, rs, rowNumber); 		
 		setSkuId(retailStoreOrderLineItem, rs, rowNumber); 		
 		setSkuName(retailStoreOrderLineItem, rs, rowNumber); 		
 		setAmount(retailStoreOrderLineItem, rs, rowNumber); 		
 		setQuantity(retailStoreOrderLineItem, rs, rowNumber); 		
 		setUnitOfMeasurement(retailStoreOrderLineItem, rs, rowNumber); 		
 		setVersion(retailStoreOrderLineItem, rs, rowNumber);

		return retailStoreOrderLineItem;
	}
	
	protected RetailStoreOrderLineItem getRetailStoreOrderLineItem(){
		return new RetailStoreOrderLineItem();
	}		
		
	protected void setId(RetailStoreOrderLineItem retailStoreOrderLineItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(RetailStoreOrderLineItemTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderLineItem.setId(id);
	}
		 		
 	protected void setBizOrder(RetailStoreOrderLineItem retailStoreOrderLineItem, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreOrderId = rs.getString(RetailStoreOrderLineItemTable.COLUMN_BIZ_ORDER);
 		if( retailStoreOrderId == null){
 			return;
 		}
 		if( retailStoreOrderId.isEmpty()){
 			return;
 		}
 		RetailStoreOrder retailStoreOrder = retailStoreOrderLineItem.getBizOrder();
 		if( retailStoreOrder != null ){
 			//if the root object 'retailStoreOrderLineItem' already have the property, just set the id for it;
 			retailStoreOrder.setId(retailStoreOrderId);
 			
 			return;
 		}
 		retailStoreOrderLineItem.setBizOrder(createEmptyBizOrder(retailStoreOrderId));
 	}
 	
	protected void setSkuId(RetailStoreOrderLineItem retailStoreOrderLineItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String skuId = rs.getString(RetailStoreOrderLineItemTable.COLUMN_SKU_ID);
		
		if(skuId == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderLineItem.setSkuId(skuId);
	}
		
	protected void setSkuName(RetailStoreOrderLineItem retailStoreOrderLineItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String skuName = rs.getString(RetailStoreOrderLineItemTable.COLUMN_SKU_NAME);
		
		if(skuName == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderLineItem.setSkuName(skuName);
	}
		
	protected void setAmount(RetailStoreOrderLineItem retailStoreOrderLineItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal amount = rs.getBigDecimal(RetailStoreOrderLineItemTable.COLUMN_AMOUNT);
		
		if(amount == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderLineItem.setAmount(amount);
	}
		
	protected void setQuantity(RetailStoreOrderLineItem retailStoreOrderLineItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer quantity = rs.getInt(RetailStoreOrderLineItemTable.COLUMN_QUANTITY);
		
		if(quantity == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderLineItem.setQuantity(quantity);
	}
		
	protected void setUnitOfMeasurement(RetailStoreOrderLineItem retailStoreOrderLineItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String unitOfMeasurement = rs.getString(RetailStoreOrderLineItemTable.COLUMN_UNIT_OF_MEASUREMENT);
		
		if(unitOfMeasurement == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderLineItem.setUnitOfMeasurement(unitOfMeasurement);
	}
		
	protected void setVersion(RetailStoreOrderLineItem retailStoreOrderLineItem, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(RetailStoreOrderLineItemTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderLineItem.setVersion(version);
	}
		
		

 	protected RetailStoreOrder  createEmptyBizOrder(String retailStoreOrderId){
 		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
 		retailStoreOrder.setId(retailStoreOrderId);
 		retailStoreOrder.setVersion(Integer.MAX_VALUE);
 		return retailStoreOrder;
 	}
 	
}


