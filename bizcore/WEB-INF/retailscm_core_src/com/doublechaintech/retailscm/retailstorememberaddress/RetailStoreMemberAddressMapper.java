
package com.doublechaintech.retailscm.retailstorememberaddress;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

public class RetailStoreMemberAddressMapper extends BaseRowMapper<RetailStoreMemberAddress>{

	protected RetailStoreMemberAddress internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreMemberAddress retailStoreMemberAddress = getRetailStoreMemberAddress();
		
 		setId(retailStoreMemberAddress, rs, rowNumber);
 		setName(retailStoreMemberAddress, rs, rowNumber);
 		setOwner(retailStoreMemberAddress, rs, rowNumber);
 		setMobilePhone(retailStoreMemberAddress, rs, rowNumber);
 		setAddress(retailStoreMemberAddress, rs, rowNumber);
 		setVersion(retailStoreMemberAddress, rs, rowNumber);

    
		return retailStoreMemberAddress;
	}

	protected RetailStoreMemberAddress getRetailStoreMemberAddress(){
	  RetailStoreMemberAddress entity = new RetailStoreMemberAddress();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(RetailStoreMemberAddress retailStoreMemberAddress, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(RetailStoreMemberAddressTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreMemberAddress.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setName(RetailStoreMemberAddress retailStoreMemberAddress, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(RetailStoreMemberAddressTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreMemberAddress.setName(name);
		}catch (SQLException e){

    }
	}
		
 	protected void setOwner(RetailStoreMemberAddress retailStoreMemberAddress, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreMemberId;
 		try{
 		  retailStoreMemberId = rs.getString(RetailStoreMemberAddressTable.COLUMN_OWNER);
 		}catch(SQLException e){
 		  return;
 		}
 		if( retailStoreMemberId == null){
 			return;
 		}
 		if( retailStoreMemberId.isEmpty()){
 			return;
 		}
 		RetailStoreMember retailStoreMember = retailStoreMemberAddress.getOwner();
 		if( retailStoreMember != null ){
 			//if the root object 'retailStoreMemberAddress' already have the property, just set the id for it;
 			retailStoreMember.setId(retailStoreMemberId);

 			return;
 		}
 		retailStoreMemberAddress.setOwner(createEmptyOwner(retailStoreMemberId));
 	}
 	
	protected void setMobilePhone(RetailStoreMemberAddress retailStoreMemberAddress, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String mobilePhone = rs.getString(RetailStoreMemberAddressTable.COLUMN_MOBILE_PHONE);
		
		if(mobilePhone == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreMemberAddress.setMobilePhone(mobilePhone);
		}catch (SQLException e){

    }
	}
		
	protected void setAddress(RetailStoreMemberAddress retailStoreMemberAddress, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String address = rs.getString(RetailStoreMemberAddressTable.COLUMN_ADDRESS);
		
		if(address == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreMemberAddress.setAddress(address);
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(RetailStoreMemberAddress retailStoreMemberAddress, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(RetailStoreMemberAddressTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreMemberAddress.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected RetailStoreMember  createEmptyOwner(String retailStoreMemberId){
 		RetailStoreMember retailStoreMember = new RetailStoreMember();
 		retailStoreMember.setId(retailStoreMemberId);
 		retailStoreMember.setVersion(Integer.MAX_VALUE);
 		return retailStoreMember;
 	}
 	
}


