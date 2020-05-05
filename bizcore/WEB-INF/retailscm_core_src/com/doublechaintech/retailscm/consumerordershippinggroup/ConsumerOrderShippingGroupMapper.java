
package com.doublechaintech.retailscm.consumerordershippinggroup;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;

public class ConsumerOrderShippingGroupMapper extends BaseRowMapper<ConsumerOrderShippingGroup>{
	
	protected ConsumerOrderShippingGroup internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ConsumerOrderShippingGroup consumerOrderShippingGroup = getConsumerOrderShippingGroup();		
		 		
 		setId(consumerOrderShippingGroup, rs, rowNumber); 		
 		setName(consumerOrderShippingGroup, rs, rowNumber); 		
 		setBizOrder(consumerOrderShippingGroup, rs, rowNumber); 		
 		setAmount(consumerOrderShippingGroup, rs, rowNumber); 		
 		setVersion(consumerOrderShippingGroup, rs, rowNumber);

		return consumerOrderShippingGroup;
	}
	
	protected ConsumerOrderShippingGroup getConsumerOrderShippingGroup(){
		return new ConsumerOrderShippingGroup();
	}		
		
	protected void setId(ConsumerOrderShippingGroup consumerOrderShippingGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(ConsumerOrderShippingGroupTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderShippingGroup.setId(id);
	}
		
	protected void setName(ConsumerOrderShippingGroup consumerOrderShippingGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(ConsumerOrderShippingGroupTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderShippingGroup.setName(name);
	}
		 		
 	protected void setBizOrder(ConsumerOrderShippingGroup consumerOrderShippingGroup, ResultSet rs, int rowNumber) throws SQLException{
 		String consumerOrderId = rs.getString(ConsumerOrderShippingGroupTable.COLUMN_BIZ_ORDER);
 		if( consumerOrderId == null){
 			return;
 		}
 		if( consumerOrderId.isEmpty()){
 			return;
 		}
 		ConsumerOrder consumerOrder = consumerOrderShippingGroup.getBizOrder();
 		if( consumerOrder != null ){
 			//if the root object 'consumerOrderShippingGroup' already have the property, just set the id for it;
 			consumerOrder.setId(consumerOrderId);
 			
 			return;
 		}
 		consumerOrderShippingGroup.setBizOrder(createEmptyBizOrder(consumerOrderId));
 	}
 	
	protected void setAmount(ConsumerOrderShippingGroup consumerOrderShippingGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal amount = rs.getBigDecimal(ConsumerOrderShippingGroupTable.COLUMN_AMOUNT);
		
		if(amount == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderShippingGroup.setAmount(amount);
	}
		
	protected void setVersion(ConsumerOrderShippingGroup consumerOrderShippingGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(ConsumerOrderShippingGroupTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderShippingGroup.setVersion(version);
	}
		
		

 	protected ConsumerOrder  createEmptyBizOrder(String consumerOrderId){
 		ConsumerOrder consumerOrder = new ConsumerOrder();
 		consumerOrder.setId(consumerOrderId);
 		consumerOrder.setVersion(Integer.MAX_VALUE);
 		return consumerOrder;
 	}
 	
}


