
package com.doublechaintech.retailscm.supplyordershippinggroup;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;

public class SupplyOrderShippingGroupMapper extends BaseRowMapper<SupplyOrderShippingGroup>{
	
	protected SupplyOrderShippingGroup internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		SupplyOrderShippingGroup supplyOrderShippingGroup = getSupplyOrderShippingGroup();		
		 		
 		setId(supplyOrderShippingGroup, rs, rowNumber); 		
 		setName(supplyOrderShippingGroup, rs, rowNumber); 		
 		setBizOrder(supplyOrderShippingGroup, rs, rowNumber); 		
 		setAmount(supplyOrderShippingGroup, rs, rowNumber); 		
 		setVersion(supplyOrderShippingGroup, rs, rowNumber);

		return supplyOrderShippingGroup;
	}
	
	protected SupplyOrderShippingGroup getSupplyOrderShippingGroup(){
		return new SupplyOrderShippingGroup();
	}		
		
	protected void setId(SupplyOrderShippingGroup supplyOrderShippingGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(SupplyOrderShippingGroupTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderShippingGroup.setId(id);
	}
		
	protected void setName(SupplyOrderShippingGroup supplyOrderShippingGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(SupplyOrderShippingGroupTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderShippingGroup.setName(name);
	}
		 		
 	protected void setBizOrder(SupplyOrderShippingGroup supplyOrderShippingGroup, ResultSet rs, int rowNumber) throws SQLException{
 		String supplyOrderId = rs.getString(SupplyOrderShippingGroupTable.COLUMN_BIZ_ORDER);
 		if( supplyOrderId == null){
 			return;
 		}
 		if( supplyOrderId.isEmpty()){
 			return;
 		}
 		SupplyOrder supplyOrder = supplyOrderShippingGroup.getBizOrder();
 		if( supplyOrder != null ){
 			//if the root object 'supplyOrderShippingGroup' already have the property, just set the id for it;
 			supplyOrder.setId(supplyOrderId);
 			
 			return;
 		}
 		supplyOrderShippingGroup.setBizOrder(createEmptyBizOrder(supplyOrderId));
 	}
 	
	protected void setAmount(SupplyOrderShippingGroup supplyOrderShippingGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal amount = rs.getBigDecimal(SupplyOrderShippingGroupTable.COLUMN_AMOUNT);
		
		if(amount == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderShippingGroup.setAmount(amount);
	}
		
	protected void setVersion(SupplyOrderShippingGroup supplyOrderShippingGroup, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(SupplyOrderShippingGroupTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrderShippingGroup.setVersion(version);
	}
		
		

 	protected SupplyOrder  createEmptyBizOrder(String supplyOrderId){
 		SupplyOrder supplyOrder = new SupplyOrder();
 		supplyOrder.setId(supplyOrderId);
 		supplyOrder.setVersion(Integer.MAX_VALUE);
 		return supplyOrder;
 	}
 	
}


