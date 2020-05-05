
package com.doublechaintech.retailscm.retailstoremember;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

public class RetailStoreMemberMapper extends BaseRowMapper<RetailStoreMember>{
	
	protected RetailStoreMember internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreMember retailStoreMember = getRetailStoreMember();		
		 		
 		setId(retailStoreMember, rs, rowNumber); 		
 		setName(retailStoreMember, rs, rowNumber); 		
 		setMobilePhone(retailStoreMember, rs, rowNumber); 		
 		setOwner(retailStoreMember, rs, rowNumber); 		
 		setVersion(retailStoreMember, rs, rowNumber);

		return retailStoreMember;
	}
	
	protected RetailStoreMember getRetailStoreMember(){
		return new RetailStoreMember();
	}		
		
	protected void setId(RetailStoreMember retailStoreMember, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(RetailStoreMemberTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreMember.setId(id);
	}
		
	protected void setName(RetailStoreMember retailStoreMember, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(RetailStoreMemberTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreMember.setName(name);
	}
		
	protected void setMobilePhone(RetailStoreMember retailStoreMember, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String mobilePhone = rs.getString(RetailStoreMemberTable.COLUMN_MOBILE_PHONE);
		
		if(mobilePhone == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreMember.setMobilePhone(mobilePhone);
	}
		 		
 	protected void setOwner(RetailStoreMember retailStoreMember, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId = rs.getString(RetailStoreMemberTable.COLUMN_OWNER);
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = retailStoreMember.getOwner();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'retailStoreMember' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 			
 			return;
 		}
 		retailStoreMember.setOwner(createEmptyOwner(retailStoreCountryCenterId));
 	}
 	
	protected void setVersion(RetailStoreMember retailStoreMember, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(RetailStoreMemberTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreMember.setVersion(version);
	}
		
		

 	protected RetailStoreCountryCenter  createEmptyOwner(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
}


