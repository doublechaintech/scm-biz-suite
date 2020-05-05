
package com.doublechaintech.retailscm.retailstoreorderpaymentgroup;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

public class RetailStoreOrderPaymentGroupMapper extends BaseRowMapper<RetailStoreOrderPaymentGroup>{
	
	protected RetailStoreOrderPaymentGroup internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = getRetailStoreOrderPaymentGroup();		
		 		
 		setId(retailStoreOrderPaymentGroup, rs, rowNumber); 		
 		setName(retailStoreOrderPaymentGroup, rs, rowNumber); 		
 		setBizOrder(retailStoreOrderPaymentGroup, rs, rowNumber); 		
 		setCardNumber(retailStoreOrderPaymentGroup, rs, rowNumber); 		
 		setVersion(retailStoreOrderPaymentGroup, rs, rowNumber);

		return retailStoreOrderPaymentGroup;
	}
	
	protected RetailStoreOrderPaymentGroup getRetailStoreOrderPaymentGroup(){
		return new RetailStoreOrderPaymentGroup();
	}		
		
	protected void setId(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(RetailStoreOrderPaymentGroupTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderPaymentGroup.setId(id);
	}
		
	protected void setName(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(RetailStoreOrderPaymentGroupTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderPaymentGroup.setName(name);
	}
		 		
 	protected void setBizOrder(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreOrderId = rs.getString(RetailStoreOrderPaymentGroupTable.COLUMN_BIZ_ORDER);
 		if( retailStoreOrderId == null){
 			return;
 		}
 		if( retailStoreOrderId.isEmpty()){
 			return;
 		}
 		RetailStoreOrder retailStoreOrder = retailStoreOrderPaymentGroup.getBizOrder();
 		if( retailStoreOrder != null ){
 			//if the root object 'retailStoreOrderPaymentGroup' already have the property, just set the id for it;
 			retailStoreOrder.setId(retailStoreOrderId);
 			
 			return;
 		}
 		retailStoreOrderPaymentGroup.setBizOrder(createEmptyBizOrder(retailStoreOrderId));
 	}
 	
	protected void setCardNumber(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String cardNumber = rs.getString(RetailStoreOrderPaymentGroupTable.COLUMN_CARD_NUMBER);
		
		if(cardNumber == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderPaymentGroup.setCardNumber(cardNumber);
	}
		
	protected void setVersion(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(RetailStoreOrderPaymentGroupTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderPaymentGroup.setVersion(version);
	}
		
		

 	protected RetailStoreOrder  createEmptyBizOrder(String retailStoreOrderId){
 		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
 		retailStoreOrder.setId(retailStoreOrderId);
 		retailStoreOrder.setVersion(Integer.MAX_VALUE);
 		return retailStoreOrder;
 	}
 	
}


