
package com.doublechaintech.retailscm.consumerorderpriceadjustment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;

public class ConsumerOrderPriceAdjustmentMapper extends BaseRowMapper<ConsumerOrderPriceAdjustment>{
	
	protected ConsumerOrderPriceAdjustment internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = getConsumerOrderPriceAdjustment();		
		 		
 		setId(consumerOrderPriceAdjustment, rs, rowNumber); 		
 		setName(consumerOrderPriceAdjustment, rs, rowNumber); 		
 		setBizOrder(consumerOrderPriceAdjustment, rs, rowNumber); 		
 		setAmount(consumerOrderPriceAdjustment, rs, rowNumber); 		
 		setProvider(consumerOrderPriceAdjustment, rs, rowNumber); 		
 		setVersion(consumerOrderPriceAdjustment, rs, rowNumber);

		return consumerOrderPriceAdjustment;
	}
	
	protected ConsumerOrderPriceAdjustment getConsumerOrderPriceAdjustment(){
		return new ConsumerOrderPriceAdjustment();
	}		
		
	protected void setId(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(ConsumerOrderPriceAdjustmentTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderPriceAdjustment.setId(id);
	}
		
	protected void setName(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(ConsumerOrderPriceAdjustmentTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderPriceAdjustment.setName(name);
	}
		 		
 	protected void setBizOrder(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, ResultSet rs, int rowNumber) throws SQLException{
 		String consumerOrderId = rs.getString(ConsumerOrderPriceAdjustmentTable.COLUMN_BIZ_ORDER);
 		if( consumerOrderId == null){
 			return;
 		}
 		if( consumerOrderId.isEmpty()){
 			return;
 		}
 		ConsumerOrder consumerOrder = consumerOrderPriceAdjustment.getBizOrder();
 		if( consumerOrder != null ){
 			//if the root object 'consumerOrderPriceAdjustment' already have the property, just set the id for it;
 			consumerOrder.setId(consumerOrderId);
 			
 			return;
 		}
 		consumerOrderPriceAdjustment.setBizOrder(createEmptyBizOrder(consumerOrderId));
 	}
 	
	protected void setAmount(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal amount = rs.getBigDecimal(ConsumerOrderPriceAdjustmentTable.COLUMN_AMOUNT);
		
		if(amount == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderPriceAdjustment.setAmount(amount);
	}
		
	protected void setProvider(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String provider = rs.getString(ConsumerOrderPriceAdjustmentTable.COLUMN_PROVIDER);
		
		if(provider == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderPriceAdjustment.setProvider(provider);
	}
		
	protected void setVersion(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(ConsumerOrderPriceAdjustmentTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderPriceAdjustment.setVersion(version);
	}
		
		

 	protected ConsumerOrder  createEmptyBizOrder(String consumerOrderId){
 		ConsumerOrder consumerOrder = new ConsumerOrder();
 		consumerOrder.setId(consumerOrderId);
 		consumerOrder.setVersion(Integer.MAX_VALUE);
 		return consumerOrder;
 	}
 	
}


