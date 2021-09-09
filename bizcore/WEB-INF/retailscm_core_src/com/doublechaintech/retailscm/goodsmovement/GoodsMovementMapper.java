
package com.doublechaintech.retailscm.goodsmovement;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.goods.Goods;

public class GoodsMovementMapper extends BaseRowMapper<GoodsMovement>{

	protected GoodsMovement internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		GoodsMovement goodsMovement = getGoodsMovement();
		
 		setId(goodsMovement, rs, rowNumber);
 		setMoveTime(goodsMovement, rs, rowNumber);
 		setFacility(goodsMovement, rs, rowNumber);
 		setFacilityId(goodsMovement, rs, rowNumber);
 		setFromIp(goodsMovement, rs, rowNumber);
 		setUserAgent(goodsMovement, rs, rowNumber);
 		setSessionId(goodsMovement, rs, rowNumber);
 		setLatitude(goodsMovement, rs, rowNumber);
 		setLongitude(goodsMovement, rs, rowNumber);
 		setGoods(goodsMovement, rs, rowNumber);
 		setVersion(goodsMovement, rs, rowNumber);

    
		return goodsMovement;
	}

	protected GoodsMovement getGoodsMovement(){
	  GoodsMovement entity = new GoodsMovement();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(GoodsMovement goodsMovement, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(GoodsMovementTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsMovement.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setMoveTime(GoodsMovement goodsMovement, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date moveTime = rs.getTimestamp(GoodsMovementTable.COLUMN_MOVE_TIME);
		
		if(moveTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsMovement.setMoveTime(convertToDateTime(moveTime));
		}catch (SQLException e){

    }
	}
		
	protected void setFacility(GoodsMovement goodsMovement, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String facility = rs.getString(GoodsMovementTable.COLUMN_FACILITY);
		
		if(facility == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsMovement.setFacility(facility);
		}catch (SQLException e){

    }
	}
		
	protected void setFacilityId(GoodsMovement goodsMovement, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String facilityId = rs.getString(GoodsMovementTable.COLUMN_FACILITY_ID);
		
		if(facilityId == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsMovement.setFacilityId(facilityId);
		}catch (SQLException e){

    }
	}
		
	protected void setFromIp(GoodsMovement goodsMovement, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String fromIp = rs.getString(GoodsMovementTable.COLUMN_FROM_IP);
		
		if(fromIp == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsMovement.setFromIp(fromIp);
		}catch (SQLException e){

    }
	}
		
	protected void setUserAgent(GoodsMovement goodsMovement, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String userAgent = rs.getString(GoodsMovementTable.COLUMN_USER_AGENT);
		
		if(userAgent == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsMovement.setUserAgent(userAgent);
		}catch (SQLException e){

    }
	}
		
	protected void setSessionId(GoodsMovement goodsMovement, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String sessionId = rs.getString(GoodsMovementTable.COLUMN_SESSION_ID);
		
		if(sessionId == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsMovement.setSessionId(sessionId);
		}catch (SQLException e){

    }
	}
		
	protected void setLatitude(GoodsMovement goodsMovement, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		BigDecimal latitude = rs.getBigDecimal(GoodsMovementTable.COLUMN_LATITUDE);
		
		if(latitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsMovement.setLatitude(latitude);
		}catch (SQLException e){

    }
	}
		
	protected void setLongitude(GoodsMovement goodsMovement, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		BigDecimal longitude = rs.getBigDecimal(GoodsMovementTable.COLUMN_LONGITUDE);
		
		if(longitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsMovement.setLongitude(longitude);
		}catch (SQLException e){

    }
	}
		
 	protected void setGoods(GoodsMovement goodsMovement, ResultSet rs, int rowNumber) throws SQLException{
 		String goodsId;
 		try{
 		  goodsId = rs.getString(GoodsMovementTable.COLUMN_GOODS);
 		}catch(SQLException e){
 		  return;
 		}
 		if( goodsId == null){
 			return;
 		}
 		if( goodsId.isEmpty()){
 			return;
 		}
 		Goods goods = goodsMovement.getGoods();
 		if( goods != null ){
 			//if the root object 'goodsMovement' already have the property, just set the id for it;
 			goods.setId(goodsId);

 			return;
 		}
 		goodsMovement.setGoods(createEmptyGoods(goodsId));
 	}
 	
	protected void setVersion(GoodsMovement goodsMovement, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(GoodsMovementTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsMovement.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected Goods  createEmptyGoods(String goodsId){
 		Goods goods = new Goods();
 		goods.setId(goodsId);
 		goods.setVersion(Integer.MAX_VALUE);
 		return goods;
 	}
 	
}


