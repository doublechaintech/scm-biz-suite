
package com.doublechaintech.retailscm.retailstoreorder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstore.RetailStore;

public class RetailStoreOrderMapper extends BaseRowMapper<RetailStoreOrder>{
	
	protected RetailStoreOrder internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreOrder retailStoreOrder = getRetailStoreOrder();		
		 		
 		setId(retailStoreOrder, rs, rowNumber); 		
 		setBuyer(retailStoreOrder, rs, rowNumber); 		
 		setSeller(retailStoreOrder, rs, rowNumber); 		
 		setTitle(retailStoreOrder, rs, rowNumber); 		
 		setTotalAmount(retailStoreOrder, rs, rowNumber); 		
 		setLastUpdateTime(retailStoreOrder, rs, rowNumber); 		
 		setVersion(retailStoreOrder, rs, rowNumber);

		return retailStoreOrder;
	}
	
	protected RetailStoreOrder getRetailStoreOrder(){
		return new RetailStoreOrder();
	}		
		
	protected void setId(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(RetailStoreOrderTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrder.setId(id);
	}
		 		
 	protected void setBuyer(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreId = rs.getString(RetailStoreOrderTable.COLUMN_BUYER);
 		if( retailStoreId == null){
 			return;
 		}
 		if( retailStoreId.isEmpty()){
 			return;
 		}
 		RetailStore retailStore = retailStoreOrder.getBuyer();
 		if( retailStore != null ){
 			//if the root object 'retailStoreOrder' already have the property, just set the id for it;
 			retailStore.setId(retailStoreId);
 			
 			return;
 		}
 		retailStoreOrder.setBuyer(createEmptyBuyer(retailStoreId));
 	}
 	 		
 	protected void setSeller(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId = rs.getString(RetailStoreOrderTable.COLUMN_SELLER);
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = retailStoreOrder.getSeller();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'retailStoreOrder' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 			
 			return;
 		}
 		retailStoreOrder.setSeller(createEmptySeller(retailStoreCountryCenterId));
 	}
 	
	protected void setTitle(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String title = rs.getString(RetailStoreOrderTable.COLUMN_TITLE);
		
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrder.setTitle(title);
	}
		
	protected void setTotalAmount(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal totalAmount = rs.getBigDecimal(RetailStoreOrderTable.COLUMN_TOTAL_AMOUNT);
		
		if(totalAmount == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrder.setTotalAmount(totalAmount);
	}
		
	protected void setLastUpdateTime(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(RetailStoreOrderTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrder.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		
	protected void setVersion(RetailStoreOrder retailStoreOrder, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(RetailStoreOrderTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOrder.setVersion(version);
	}
		
		

 	protected RetailStore  createEmptyBuyer(String retailStoreId){
 		RetailStore retailStore = new RetailStore();
 		retailStore.setId(retailStoreId);
 		retailStore.setVersion(Integer.MAX_VALUE);
 		return retailStore;
 	}
 	
 	protected RetailStoreCountryCenter  createEmptySeller(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
}


