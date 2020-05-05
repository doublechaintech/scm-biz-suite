
package com.doublechaintech.retailscm.goodsallocation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;

public class GoodsAllocationMapper extends BaseRowMapper<GoodsAllocation>{
	
	protected GoodsAllocation internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		GoodsAllocation goodsAllocation = getGoodsAllocation();		
		 		
 		setId(goodsAllocation, rs, rowNumber); 		
 		setLocation(goodsAllocation, rs, rowNumber); 		
 		setLatitude(goodsAllocation, rs, rowNumber); 		
 		setLongitude(goodsAllocation, rs, rowNumber); 		
 		setGoodsShelf(goodsAllocation, rs, rowNumber); 		
 		setVersion(goodsAllocation, rs, rowNumber);

		return goodsAllocation;
	}
	
	protected GoodsAllocation getGoodsAllocation(){
		return new GoodsAllocation();
	}		
		
	protected void setId(GoodsAllocation goodsAllocation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(GoodsAllocationTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsAllocation.setId(id);
	}
		
	protected void setLocation(GoodsAllocation goodsAllocation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String location = rs.getString(GoodsAllocationTable.COLUMN_LOCATION);
		
		if(location == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsAllocation.setLocation(location);
	}
		
	protected void setLatitude(GoodsAllocation goodsAllocation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal latitude = rs.getBigDecimal(GoodsAllocationTable.COLUMN_LATITUDE);
		
		if(latitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsAllocation.setLatitude(latitude);
	}
		
	protected void setLongitude(GoodsAllocation goodsAllocation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal longitude = rs.getBigDecimal(GoodsAllocationTable.COLUMN_LONGITUDE);
		
		if(longitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsAllocation.setLongitude(longitude);
	}
		 		
 	protected void setGoodsShelf(GoodsAllocation goodsAllocation, ResultSet rs, int rowNumber) throws SQLException{
 		String goodsShelfId = rs.getString(GoodsAllocationTable.COLUMN_GOODS_SHELF);
 		if( goodsShelfId == null){
 			return;
 		}
 		if( goodsShelfId.isEmpty()){
 			return;
 		}
 		GoodsShelf goodsShelf = goodsAllocation.getGoodsShelf();
 		if( goodsShelf != null ){
 			//if the root object 'goodsAllocation' already have the property, just set the id for it;
 			goodsShelf.setId(goodsShelfId);
 			
 			return;
 		}
 		goodsAllocation.setGoodsShelf(createEmptyGoodsShelf(goodsShelfId));
 	}
 	
	protected void setVersion(GoodsAllocation goodsAllocation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(GoodsAllocationTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsAllocation.setVersion(version);
	}
		
		

 	protected GoodsShelf  createEmptyGoodsShelf(String goodsShelfId){
 		GoodsShelf goodsShelf = new GoodsShelf();
 		goodsShelf.setId(goodsShelfId);
 		goodsShelf.setVersion(Integer.MAX_VALUE);
 		return goodsShelf;
 	}
 	
}


