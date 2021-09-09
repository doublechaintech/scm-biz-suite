
package com.doublechaintech.retailscm.retailstoreordershippinggroup;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

public class RetailStoreOrderShippingGroupMapper extends BaseRowMapper<RetailStoreOrderShippingGroup>{

	protected RetailStoreOrderShippingGroup internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = getRetailStoreOrderShippingGroup();
		
 		setId(retailStoreOrderShippingGroup, rs, rowNumber);
 		setName(retailStoreOrderShippingGroup, rs, rowNumber);
 		setBizOrder(retailStoreOrderShippingGroup, rs, rowNumber);
 		setAmount(retailStoreOrderShippingGroup, rs, rowNumber);
 		setVersion(retailStoreOrderShippingGroup, rs, rowNumber);

    
		return retailStoreOrderShippingGroup;
	}

	protected RetailStoreOrderShippingGroup getRetailStoreOrderShippingGroup(){
	  RetailStoreOrderShippingGroup entity = new RetailStoreOrderShippingGroup();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(RetailStoreOrderShippingGroupTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderShippingGroup.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setName(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(RetailStoreOrderShippingGroupTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderShippingGroup.setName(name);
		}catch (SQLException e){

    }
	}
		
 	protected void setBizOrder(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreOrderId;
 		try{
 		  retailStoreOrderId = rs.getString(RetailStoreOrderShippingGroupTable.COLUMN_BIZ_ORDER);
 		}catch(SQLException e){
 		  return;
 		}
 		if( retailStoreOrderId == null){
 			return;
 		}
 		if( retailStoreOrderId.isEmpty()){
 			return;
 		}
 		RetailStoreOrder retailStoreOrder = retailStoreOrderShippingGroup.getBizOrder();
 		if( retailStoreOrder != null ){
 			//if the root object 'retailStoreOrderShippingGroup' already have the property, just set the id for it;
 			retailStoreOrder.setId(retailStoreOrderId);

 			return;
 		}
 		retailStoreOrderShippingGroup.setBizOrder(createEmptyBizOrder(retailStoreOrderId));
 	}
 	
	protected void setAmount(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		BigDecimal amount = rs.getBigDecimal(RetailStoreOrderShippingGroupTable.COLUMN_AMOUNT);
		
		if(amount == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderShippingGroup.setAmount(amount);
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(RetailStoreOrderShippingGroupTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrderShippingGroup.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected RetailStoreOrder  createEmptyBizOrder(String retailStoreOrderId){
 		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
 		retailStoreOrder.setId(retailStoreOrderId);
 		retailStoreOrder.setVersion(Integer.MAX_VALUE);
 		return retailStoreOrder;
 	}
 	
}


