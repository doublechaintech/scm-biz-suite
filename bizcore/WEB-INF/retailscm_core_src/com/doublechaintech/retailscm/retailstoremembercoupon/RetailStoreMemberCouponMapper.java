
package com.doublechaintech.retailscm.retailstoremembercoupon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

public class RetailStoreMemberCouponMapper extends BaseRowMapper<RetailStoreMemberCoupon>{
	
	protected RetailStoreMemberCoupon internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreMemberCoupon retailStoreMemberCoupon = getRetailStoreMemberCoupon();		
		 		
 		setId(retailStoreMemberCoupon, rs, rowNumber); 		
 		setName(retailStoreMemberCoupon, rs, rowNumber); 		
 		setOwner(retailStoreMemberCoupon, rs, rowNumber); 		
 		setNumber(retailStoreMemberCoupon, rs, rowNumber); 		
 		setLastUpdateTime(retailStoreMemberCoupon, rs, rowNumber); 		
 		setVersion(retailStoreMemberCoupon, rs, rowNumber);

		return retailStoreMemberCoupon;
	}
	
	protected RetailStoreMemberCoupon getRetailStoreMemberCoupon(){
		return new RetailStoreMemberCoupon();
	}		
		
	protected void setId(RetailStoreMemberCoupon retailStoreMemberCoupon, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(RetailStoreMemberCouponTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreMemberCoupon.setId(id);
	}
		
	protected void setName(RetailStoreMemberCoupon retailStoreMemberCoupon, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(RetailStoreMemberCouponTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreMemberCoupon.setName(name);
	}
		 		
 	protected void setOwner(RetailStoreMemberCoupon retailStoreMemberCoupon, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreMemberId = rs.getString(RetailStoreMemberCouponTable.COLUMN_OWNER);
 		if( retailStoreMemberId == null){
 			return;
 		}
 		if( retailStoreMemberId.isEmpty()){
 			return;
 		}
 		RetailStoreMember retailStoreMember = retailStoreMemberCoupon.getOwner();
 		if( retailStoreMember != null ){
 			//if the root object 'retailStoreMemberCoupon' already have the property, just set the id for it;
 			retailStoreMember.setId(retailStoreMemberId);
 			
 			return;
 		}
 		retailStoreMemberCoupon.setOwner(createEmptyOwner(retailStoreMemberId));
 	}
 	
	protected void setNumber(RetailStoreMemberCoupon retailStoreMemberCoupon, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String number = rs.getString(RetailStoreMemberCouponTable.COLUMN_NUMBER);
		
		if(number == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreMemberCoupon.setNumber(number);
	}
		
	protected void setLastUpdateTime(RetailStoreMemberCoupon retailStoreMemberCoupon, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(RetailStoreMemberCouponTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreMemberCoupon.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		
	protected void setVersion(RetailStoreMemberCoupon retailStoreMemberCoupon, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(RetailStoreMemberCouponTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreMemberCoupon.setVersion(version);
	}
		
		

 	protected RetailStoreMember  createEmptyOwner(String retailStoreMemberId){
 		RetailStoreMember retailStoreMember = new RetailStoreMember();
 		retailStoreMember.setId(retailStoreMemberId);
 		retailStoreMember.setVersion(Integer.MAX_VALUE);
 		return retailStoreMember;
 	}
 	
}


