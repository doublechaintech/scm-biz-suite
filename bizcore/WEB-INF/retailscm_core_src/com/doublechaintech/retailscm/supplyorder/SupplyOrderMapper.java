
package com.doublechaintech.retailscm.supplyorder;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;

public class SupplyOrderMapper extends BaseRowMapper<SupplyOrder>{

	protected SupplyOrder internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		SupplyOrder supplyOrder = getSupplyOrder();
		
 		setId(supplyOrder, rs, rowNumber);
 		setBuyer(supplyOrder, rs, rowNumber);
 		setSeller(supplyOrder, rs, rowNumber);
 		setTitle(supplyOrder, rs, rowNumber);
 		setContract(supplyOrder, rs, rowNumber);
 		setTotalAmount(supplyOrder, rs, rowNumber);
 		setLastUpdateTime(supplyOrder, rs, rowNumber);
 		setVersion(supplyOrder, rs, rowNumber);

    
		return supplyOrder;
	}

	protected SupplyOrder getSupplyOrder(){
	  SupplyOrder entity = new SupplyOrder();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(SupplyOrderTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrder.setId(id);
		}catch (SQLException e){

    }
	}
		
 	protected void setBuyer(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId;
 		try{
 		  retailStoreCountryCenterId = rs.getString(SupplyOrderTable.COLUMN_BUYER);
 		}catch(SQLException e){
 		  return;
 		}
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = supplyOrder.getBuyer();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'supplyOrder' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);

 			return;
 		}
 		supplyOrder.setBuyer(createEmptyBuyer(retailStoreCountryCenterId));
 	}
 	
 	protected void setSeller(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
 		String goodsSupplierId;
 		try{
 		  goodsSupplierId = rs.getString(SupplyOrderTable.COLUMN_SELLER);
 		}catch(SQLException e){
 		  return;
 		}
 		if( goodsSupplierId == null){
 			return;
 		}
 		if( goodsSupplierId.isEmpty()){
 			return;
 		}
 		GoodsSupplier goodsSupplier = supplyOrder.getSeller();
 		if( goodsSupplier != null ){
 			//if the root object 'supplyOrder' already have the property, just set the id for it;
 			goodsSupplier.setId(goodsSupplierId);

 			return;
 		}
 		supplyOrder.setSeller(createEmptySeller(goodsSupplierId));
 	}
 	
	protected void setTitle(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String title = rs.getString(SupplyOrderTable.COLUMN_TITLE);
		
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrder.setTitle(title);
		}catch (SQLException e){

    }
	}
		
	protected void setContract(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String contract = rs.getString(SupplyOrderTable.COLUMN_CONTRACT);
		
		if(contract == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrder.setContract(contract);
		}catch (SQLException e){

    }
	}
		
	protected void setTotalAmount(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		BigDecimal totalAmount = rs.getBigDecimal(SupplyOrderTable.COLUMN_TOTAL_AMOUNT);
		
		if(totalAmount == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrder.setTotalAmount(totalAmount);
		}catch (SQLException e){

    }
	}
		
	protected void setLastUpdateTime(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(SupplyOrderTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrder.setLastUpdateTime(convertToDateTime(lastUpdateTime));
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(SupplyOrder supplyOrder, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(SupplyOrderTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		supplyOrder.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected RetailStoreCountryCenter  createEmptyBuyer(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
 	protected GoodsSupplier  createEmptySeller(String goodsSupplierId){
 		GoodsSupplier goodsSupplier = new GoodsSupplier();
 		goodsSupplier.setId(goodsSupplierId);
 		goodsSupplier.setVersion(Integer.MAX_VALUE);
 		return goodsSupplier;
 	}
 	
}


