
package com.doublechaintech.retailscm.goodspackaging;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class GoodsPackagingMapper extends BaseRowMapper<GoodsPackaging>{
	
	protected GoodsPackaging internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		GoodsPackaging goodsPackaging = getGoodsPackaging();		
		 		
 		setId(goodsPackaging, rs, rowNumber); 		
 		setPackageName(goodsPackaging, rs, rowNumber); 		
 		setRfid(goodsPackaging, rs, rowNumber); 		
 		setPackageTime(goodsPackaging, rs, rowNumber); 		
 		setDescription(goodsPackaging, rs, rowNumber); 		
 		setVersion(goodsPackaging, rs, rowNumber);

		return goodsPackaging;
	}
	
	protected GoodsPackaging getGoodsPackaging(){
		return new GoodsPackaging();
	}		
		
	protected void setId(GoodsPackaging goodsPackaging, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(GoodsPackagingTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsPackaging.setId(id);
	}
		
	protected void setPackageName(GoodsPackaging goodsPackaging, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String packageName = rs.getString(GoodsPackagingTable.COLUMN_PACKAGE_NAME);
		if(packageName == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsPackaging.setPackageName(packageName);
	}
		
	protected void setRfid(GoodsPackaging goodsPackaging, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String rfid = rs.getString(GoodsPackagingTable.COLUMN_RFID);
		if(rfid == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsPackaging.setRfid(rfid);
	}
		
	protected void setPackageTime(GoodsPackaging goodsPackaging, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date packageTime = rs.getDate(GoodsPackagingTable.COLUMN_PACKAGE_TIME);
		if(packageTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsPackaging.setPackageTime(packageTime);
	}
		
	protected void setDescription(GoodsPackaging goodsPackaging, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String description = rs.getString(GoodsPackagingTable.COLUMN_DESCRIPTION);
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsPackaging.setDescription(description);
	}
		
	protected void setVersion(GoodsPackaging goodsPackaging, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(GoodsPackagingTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsPackaging.setVersion(version);
	}
		
		

}


