
package com.doublechaintech.retailscm.consumerorderlineitem;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;

public class ConsumerOrderLineItemMapper extends BaseRowMapper<ConsumerOrderLineItem>{

	protected ConsumerOrderLineItem internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ConsumerOrderLineItem consumerOrderLineItem = getConsumerOrderLineItem();
		
 		setId(consumerOrderLineItem, rs, rowNumber);
 		setBizOrder(consumerOrderLineItem, rs, rowNumber);
 		setSkuId(consumerOrderLineItem, rs, rowNumber);
 		setSkuName(consumerOrderLineItem, rs, rowNumber);
 		setPrice(consumerOrderLineItem, rs, rowNumber);
 		setQuantity(consumerOrderLineItem, rs, rowNumber);
 		setAmount(consumerOrderLineItem, rs, rowNumber);
 		setLastUpdateTime(consumerOrderLineItem, rs, rowNumber);
 		setVersion(consumerOrderLineItem, rs, rowNumber);

    
		return consumerOrderLineItem;
	}

	protected ConsumerOrderLineItem getConsumerOrderLineItem(){
	  ConsumerOrderLineItem entity = new ConsumerOrderLineItem();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(ConsumerOrderLineItem consumerOrderLineItem, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(ConsumerOrderLineItemTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderLineItem.setId(id);
		}catch (SQLException e){

    }
	}
		
 	protected void setBizOrder(ConsumerOrderLineItem consumerOrderLineItem, ResultSet rs, int rowNumber) throws SQLException{
 		String consumerOrderId;
 		try{
 		  consumerOrderId = rs.getString(ConsumerOrderLineItemTable.COLUMN_BIZ_ORDER);
 		}catch(SQLException e){
 		  return;
 		}
 		if( consumerOrderId == null){
 			return;
 		}
 		if( consumerOrderId.isEmpty()){
 			return;
 		}
 		ConsumerOrder consumerOrder = consumerOrderLineItem.getBizOrder();
 		if( consumerOrder != null ){
 			//if the root object 'consumerOrderLineItem' already have the property, just set the id for it;
 			consumerOrder.setId(consumerOrderId);

 			return;
 		}
 		consumerOrderLineItem.setBizOrder(createEmptyBizOrder(consumerOrderId));
 	}
 	
	protected void setSkuId(ConsumerOrderLineItem consumerOrderLineItem, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String skuId = rs.getString(ConsumerOrderLineItemTable.COLUMN_SKU_ID);
		
		if(skuId == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderLineItem.setSkuId(skuId);
		}catch (SQLException e){

    }
	}
		
	protected void setSkuName(ConsumerOrderLineItem consumerOrderLineItem, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String skuName = rs.getString(ConsumerOrderLineItemTable.COLUMN_SKU_NAME);
		
		if(skuName == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderLineItem.setSkuName(skuName);
		}catch (SQLException e){

    }
	}
		
	protected void setPrice(ConsumerOrderLineItem consumerOrderLineItem, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		BigDecimal price = rs.getBigDecimal(ConsumerOrderLineItemTable.COLUMN_PRICE);
		
		if(price == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderLineItem.setPrice(price);
		}catch (SQLException e){

    }
	}
		
	protected void setQuantity(ConsumerOrderLineItem consumerOrderLineItem, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		BigDecimal quantity = rs.getBigDecimal(ConsumerOrderLineItemTable.COLUMN_QUANTITY);
		
		if(quantity == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderLineItem.setQuantity(quantity);
		}catch (SQLException e){

    }
	}
		
	protected void setAmount(ConsumerOrderLineItem consumerOrderLineItem, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		BigDecimal amount = rs.getBigDecimal(ConsumerOrderLineItemTable.COLUMN_AMOUNT);
		
		if(amount == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderLineItem.setAmount(amount);
		}catch (SQLException e){

    }
	}
		
	protected void setLastUpdateTime(ConsumerOrderLineItem consumerOrderLineItem, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(ConsumerOrderLineItemTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderLineItem.setLastUpdateTime(convertToDateTime(lastUpdateTime));
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(ConsumerOrderLineItem consumerOrderLineItem, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(ConsumerOrderLineItemTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderLineItem.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected ConsumerOrder  createEmptyBizOrder(String consumerOrderId){
 		ConsumerOrder consumerOrder = new ConsumerOrder();
 		consumerOrder.setId(consumerOrderId);
 		consumerOrder.setVersion(Integer.MAX_VALUE);
 		return consumerOrder;
 	}
 	
}


