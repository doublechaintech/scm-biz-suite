
package com.doublechaintech.retailscm.stockcountissuetrack;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;

public class StockCountIssueTrackMapper extends BaseRowMapper<StockCountIssueTrack>{

	protected StockCountIssueTrack internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		StockCountIssueTrack stockCountIssueTrack = getStockCountIssueTrack();
		
 		setId(stockCountIssueTrack, rs, rowNumber);
 		setTitle(stockCountIssueTrack, rs, rowNumber);
 		setCountTime(stockCountIssueTrack, rs, rowNumber);
 		setSummary(stockCountIssueTrack, rs, rowNumber);
 		setStockCount(stockCountIssueTrack, rs, rowNumber);
 		setVersion(stockCountIssueTrack, rs, rowNumber);

    
		return stockCountIssueTrack;
	}

	protected StockCountIssueTrack getStockCountIssueTrack(){
	  StockCountIssueTrack entity = new StockCountIssueTrack();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(StockCountIssueTrack stockCountIssueTrack, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(StockCountIssueTrackTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		stockCountIssueTrack.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setTitle(StockCountIssueTrack stockCountIssueTrack, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String title = rs.getString(StockCountIssueTrackTable.COLUMN_TITLE);
		
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		stockCountIssueTrack.setTitle(title);
		}catch (SQLException e){

    }
	}
		
	protected void setCountTime(StockCountIssueTrack stockCountIssueTrack, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date countTime = rs.getDate(StockCountIssueTrackTable.COLUMN_COUNT_TIME);
		
		if(countTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		stockCountIssueTrack.setCountTime(countTime);
		}catch (SQLException e){

    }
	}
		
	protected void setSummary(StockCountIssueTrack stockCountIssueTrack, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String summary = rs.getString(StockCountIssueTrackTable.COLUMN_SUMMARY);
		
		if(summary == null){
			//do nothing when nothing found in database
			return;
		}
		
		stockCountIssueTrack.setSummary(summary);
		}catch (SQLException e){

    }
	}
		
 	protected void setStockCount(StockCountIssueTrack stockCountIssueTrack, ResultSet rs, int rowNumber) throws SQLException{
 		String goodsShelfStockCountId;
 		try{
 		  goodsShelfStockCountId = rs.getString(StockCountIssueTrackTable.COLUMN_STOCK_COUNT);
 		}catch(SQLException e){
 		  return;
 		}
 		if( goodsShelfStockCountId == null){
 			return;
 		}
 		if( goodsShelfStockCountId.isEmpty()){
 			return;
 		}
 		GoodsShelfStockCount goodsShelfStockCount = stockCountIssueTrack.getStockCount();
 		if( goodsShelfStockCount != null ){
 			//if the root object 'stockCountIssueTrack' already have the property, just set the id for it;
 			goodsShelfStockCount.setId(goodsShelfStockCountId);

 			return;
 		}
 		stockCountIssueTrack.setStockCount(createEmptyStockCount(goodsShelfStockCountId));
 	}
 	
	protected void setVersion(StockCountIssueTrack stockCountIssueTrack, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(StockCountIssueTrackTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		stockCountIssueTrack.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected GoodsShelfStockCount  createEmptyStockCount(String goodsShelfStockCountId){
 		GoodsShelfStockCount goodsShelfStockCount = new GoodsShelfStockCount();
 		goodsShelfStockCount.setId(goodsShelfStockCountId);
 		goodsShelfStockCount.setVersion(Integer.MAX_VALUE);
 		return goodsShelfStockCount;
 	}
 	
}


