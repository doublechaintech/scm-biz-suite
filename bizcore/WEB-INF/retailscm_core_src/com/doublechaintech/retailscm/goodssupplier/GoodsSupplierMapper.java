
package com.doublechaintech.retailscm.goodssupplier;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

public class GoodsSupplierMapper extends BaseRowMapper<GoodsSupplier>{

	protected GoodsSupplier internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		GoodsSupplier goodsSupplier = getGoodsSupplier();
		
 		setId(goodsSupplier, rs, rowNumber);
 		setName(goodsSupplier, rs, rowNumber);
 		setSupplyProduct(goodsSupplier, rs, rowNumber);
 		setBelongTo(goodsSupplier, rs, rowNumber);
 		setContactNumber(goodsSupplier, rs, rowNumber);
 		setDescription(goodsSupplier, rs, rowNumber);
 		setLastUpdateTime(goodsSupplier, rs, rowNumber);
 		setVersion(goodsSupplier, rs, rowNumber);

    
		return goodsSupplier;
	}

	protected GoodsSupplier getGoodsSupplier(){
	  GoodsSupplier entity = new GoodsSupplier();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(GoodsSupplier goodsSupplier, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(GoodsSupplierTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsSupplier.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setName(GoodsSupplier goodsSupplier, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(GoodsSupplierTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsSupplier.setName(name);
		}catch (SQLException e){

    }
	}
		
	protected void setSupplyProduct(GoodsSupplier goodsSupplier, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String supplyProduct = rs.getString(GoodsSupplierTable.COLUMN_SUPPLY_PRODUCT);
		
		if(supplyProduct == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsSupplier.setSupplyProduct(supplyProduct);
		}catch (SQLException e){

    }
	}
		
 	protected void setBelongTo(GoodsSupplier goodsSupplier, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId;
 		try{
 		  retailStoreCountryCenterId = rs.getString(GoodsSupplierTable.COLUMN_BELONG_TO);
 		}catch(SQLException e){
 		  return;
 		}
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = goodsSupplier.getBelongTo();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'goodsSupplier' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);

 			return;
 		}
 		goodsSupplier.setBelongTo(createEmptyBelongTo(retailStoreCountryCenterId));
 	}
 	
	protected void setContactNumber(GoodsSupplier goodsSupplier, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String contactNumber = rs.getString(GoodsSupplierTable.COLUMN_CONTACT_NUMBER);
		
		if(contactNumber == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsSupplier.setContactNumber(contactNumber);
		}catch (SQLException e){

    }
	}
		
	protected void setDescription(GoodsSupplier goodsSupplier, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(GoodsSupplierTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsSupplier.setDescription(description);
		}catch (SQLException e){

    }
	}
		
	protected void setLastUpdateTime(GoodsSupplier goodsSupplier, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(GoodsSupplierTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsSupplier.setLastUpdateTime(convertToDateTime(lastUpdateTime));
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(GoodsSupplier goodsSupplier, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(GoodsSupplierTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsSupplier.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected RetailStoreCountryCenter  createEmptyBelongTo(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
}


