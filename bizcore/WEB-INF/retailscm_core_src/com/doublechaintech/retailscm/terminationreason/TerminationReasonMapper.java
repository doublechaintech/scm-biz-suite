
package com.doublechaintech.retailscm.terminationreason;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

public class TerminationReasonMapper extends BaseRowMapper<TerminationReason>{
	
	protected TerminationReason internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		TerminationReason terminationReason = getTerminationReason();		
		 		
 		setId(terminationReason, rs, rowNumber); 		
 		setCode(terminationReason, rs, rowNumber); 		
 		setCompany(terminationReason, rs, rowNumber); 		
 		setDescription(terminationReason, rs, rowNumber); 		
 		setVersion(terminationReason, rs, rowNumber);

		return terminationReason;
	}
	
	protected TerminationReason getTerminationReason(){
		return new TerminationReason();
	}		
		
	protected void setId(TerminationReason terminationReason, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(TerminationReasonTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		terminationReason.setId(id);
	}
		
	protected void setCode(TerminationReason terminationReason, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String code = rs.getString(TerminationReasonTable.COLUMN_CODE);
		
		if(code == null){
			//do nothing when nothing found in database
			return;
		}
		
		terminationReason.setCode(code);
	}
		 		
 	protected void setCompany(TerminationReason terminationReason, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId = rs.getString(TerminationReasonTable.COLUMN_COMPANY);
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = terminationReason.getCompany();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'terminationReason' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 			
 			return;
 		}
 		terminationReason.setCompany(createEmptyCompany(retailStoreCountryCenterId));
 	}
 	
	protected void setDescription(TerminationReason terminationReason, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(TerminationReasonTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		terminationReason.setDescription(description);
	}
		
	protected void setVersion(TerminationReason terminationReason, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(TerminationReasonTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		terminationReason.setVersion(version);
	}
		
		

 	protected RetailStoreCountryCenter  createEmptyCompany(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
}


