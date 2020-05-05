
package com.doublechaintech.retailscm.goodsshelfstockcount;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;

public class GoodsShelfStockCountMapper extends BaseRowMapper<GoodsShelfStockCount>{
	
	protected GoodsShelfStockCount internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		GoodsShelfStockCount goodsShelfStockCount = getGoodsShelfStockCount();		
		 		
 		setId(goodsShelfStockCount, rs, rowNumber); 		
 		setTitle(goodsShelfStockCount, rs, rowNumber); 		
 		setCountTime(goodsShelfStockCount, rs, rowNumber); 		
 		setSummary(goodsShelfStockCount, rs, rowNumber); 		
 		setShelf(goodsShelfStockCount, rs, rowNumber); 		
 		setVersion(goodsShelfStockCount, rs, rowNumber);

		return goodsShelfStockCount;
	}
	
	protected GoodsShelfStockCount getGoodsShelfStockCount(){
		return new GoodsShelfStockCount();
	}		
		
	protected void setId(GoodsShelfStockCount goodsShelfStockCount, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(GoodsShelfStockCountTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsShelfStockCount.setId(id);
	}
		
	protected void setTitle(GoodsShelfStockCount goodsShelfStockCount, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String title = rs.getString(GoodsShelfStockCountTable.COLUMN_TITLE);
		
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsShelfStockCount.setTitle(title);
	}
		
	protected void setCountTime(GoodsShelfStockCount goodsShelfStockCount, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date countTime = rs.getDate(GoodsShelfStockCountTable.COLUMN_COUNT_TIME);
		
		if(countTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsShelfStockCount.setCountTime(countTime);
	}
		
	protected void setSummary(GoodsShelfStockCount goodsShelfStockCount, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String summary = rs.getString(GoodsShelfStockCountTable.COLUMN_SUMMARY);
		
		if(summary == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsShelfStockCount.setSummary(summary);
	}
		 		
 	protected void setShelf(GoodsShelfStockCount goodsShelfStockCount, ResultSet rs, int rowNumber) throws SQLException{
 		String goodsShelfId = rs.getString(GoodsShelfStockCountTable.COLUMN_SHELF);
 		if( goodsShelfId == null){
 			return;
 		}
 		if( goodsShelfId.isEmpty()){
 			return;
 		}
 		GoodsShelf goodsShelf = goodsShelfStockCount.getShelf();
 		if( goodsShelf != null ){
 			//if the root object 'goodsShelfStockCount' already have the property, just set the id for it;
 			goodsShelf.setId(goodsShelfId);
 			
 			return;
 		}
 		goodsShelfStockCount.setShelf(createEmptyShelf(goodsShelfId));
 	}
 	
	protected void setVersion(GoodsShelfStockCount goodsShelfStockCount, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(GoodsShelfStockCountTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsShelfStockCount.setVersion(version);
	}
		
		

 	protected GoodsShelf  createEmptyShelf(String goodsShelfId){
 		GoodsShelf goodsShelf = new GoodsShelf();
 		goodsShelf.setId(goodsShelfId);
 		goodsShelf.setVersion(Integer.MAX_VALUE);
 		return goodsShelf;
 	}
 	
}


