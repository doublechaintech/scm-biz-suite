
package com.doublechaintech.retailscm.consumerorderpaymentgroup;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;

public class ConsumerOrderPaymentGroupMapper extends BaseRowMapper<ConsumerOrderPaymentGroup>{
	
	protected ConsumerOrderPaymentGroup internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ConsumerOrderPaymentGroup consumerOrderPaymentGroup = getConsumerOrderPaymentGroup();		
		 		
 		setId(consumerOrderPaymentGroup, rs, rowNumber); 		
 		setName(consumerOrderPaymentGroup, rs, rowNumber); 		
 		setBizOrder(consumerOrderPaymentGroup, rs, rowNumber); 		
 		setCardNumber(consumerOrderPaymentGroup, rs, rowNumber); 		
 		setVersion(consumerOrderPaymentGroup, rs, rowNumber);

		return consumerOrderPaymentGroup;
	}
	
	protected ConsumerOrderPaymentGroup getConsumerOrderPaymentGroup(){
		return new ConsumerOrderPaymentGroup();
	}		
		
	protected void setId(ConsumerOrderPaymentGroup consumerOrderPaymentGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(ConsumerOrderPaymentGroupTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderPaymentGroup.setId(id);
	}
		
	protected void setName(ConsumerOrderPaymentGroup consumerOrderPaymentGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(ConsumerOrderPaymentGroupTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderPaymentGroup.setName(name);
	}
		 		
 	protected void setBizOrder(ConsumerOrderPaymentGroup consumerOrderPaymentGroup, ResultSet rs, int rowNumber) throws SQLException{
 		String consumerOrderId = rs.getString(ConsumerOrderPaymentGroupTable.COLUMN_BIZ_ORDER);
 		if( consumerOrderId == null){
 			return;
 		}
 		if( consumerOrderId.isEmpty()){
 			return;
 		}
 		ConsumerOrder consumerOrder = consumerOrderPaymentGroup.getBizOrder();
 		if( consumerOrder != null ){
 			//if the root object 'consumerOrderPaymentGroup' already have the property, just set the id for it;
 			consumerOrder.setId(consumerOrderId);
 			
 			return;
 		}
 		consumerOrderPaymentGroup.setBizOrder(createEmptyBizOrder(consumerOrderId));
 	}
 	
	protected void setCardNumber(ConsumerOrderPaymentGroup consumerOrderPaymentGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String cardNumber = rs.getString(ConsumerOrderPaymentGroupTable.COLUMN_CARD_NUMBER);
		
		if(cardNumber == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderPaymentGroup.setCardNumber(cardNumber);
	}
		
	protected void setVersion(ConsumerOrderPaymentGroup consumerOrderPaymentGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(ConsumerOrderPaymentGroupTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		consumerOrderPaymentGroup.setVersion(version);
	}
		
		

 	protected ConsumerOrder  createEmptyBizOrder(String consumerOrderId){
 		ConsumerOrder consumerOrder = new ConsumerOrder();
 		consumerOrder.setId(consumerOrderId);
 		consumerOrder.setVersion(Integer.MAX_VALUE);
 		return consumerOrder;
 	}
 	
}


