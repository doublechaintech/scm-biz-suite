
package com.doublechaintech.retailscm.supplyorderpaymentgroup;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;

public class SupplyOrderPaymentGroupMapper extends BaseRowMapper<SupplyOrderPaymentGroup>{
	
	protected SupplyOrderPaymentGroup internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		SupplyOrderPaymentGroup supplyOrderPaymentGroup = getSupplyOrderPaymentGroup();		
		 		
 		setId(supplyOrderPaymentGroup, rs, rowNumber); 		
 		setName(supplyOrderPaymentGroup, rs, rowNumber); 		
 		setBizOrder(supplyOrderPaymentGroup, rs, rowNumber); 		
 		setCardNumber(supplyOrderPaymentGroup, rs, rowNumber); 		
 		setVersion(supplyOrderPaymentGroup, rs, rowNumber);

		return supplyOrderPaymentGroup;
	}
	
	protected SupplyOrderPaymentGroup getSupplyOrderPaymentGroup(){
		return new SupplyOrderPaymentGroup();
	}		
		
	protected void setId(SupplyOrderPaymentGroup supplyOrderPaymentGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(SupplyOrderPaymentGroupTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderPaymentGroup.setId(id);
	}
		
	protected void setName(SupplyOrderPaymentGroup supplyOrderPaymentGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(SupplyOrderPaymentGroupTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderPaymentGroup.setName(name);
	}
		 		
 	protected void setBizOrder(SupplyOrderPaymentGroup supplyOrderPaymentGroup, ResultSet rs, int rowNumber) throws SQLException{
 		String supplyOrderId = rs.getString(SupplyOrderPaymentGroupTable.COLUMN_BIZ_ORDER);
 		if( supplyOrderId == null){
 			return;
 		}
 		if( supplyOrderId.isEmpty()){
 			return;
 		}
 		SupplyOrder supplyOrder = supplyOrderPaymentGroup.getBizOrder();
 		if( supplyOrder != null ){
 			//if the root object 'supplyOrderPaymentGroup' already have the property, just set the id for it;
 			supplyOrder.setId(supplyOrderId);
 			
 			return;
 		}
 		supplyOrderPaymentGroup.setBizOrder(createEmptyBizOrder(supplyOrderId));
 	}
 	
	protected void setCardNumber(SupplyOrderPaymentGroup supplyOrderPaymentGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String cardNumber = rs.getString(SupplyOrderPaymentGroupTable.COLUMN_CARD_NUMBER);
		
		if(cardNumber == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderPaymentGroup.setCardNumber(cardNumber);
	}
		
	protected void setVersion(SupplyOrderPaymentGroup supplyOrderPaymentGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(SupplyOrderPaymentGroupTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderPaymentGroup.setVersion(version);
	}
		
		

 	protected SupplyOrder  createEmptyBizOrder(String supplyOrderId){
 		SupplyOrder supplyOrder = new SupplyOrder();
 		supplyOrder.setId(supplyOrderId);
 		supplyOrder.setVersion(Integer.MAX_VALUE);
 		return supplyOrder;
 	}
 	
}


