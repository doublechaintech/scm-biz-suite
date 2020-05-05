
package com.doublechaintech.retailscm.terminationtype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

public class TerminationTypeMapper extends BaseRowMapper<TerminationType>{
	
	protected TerminationType internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		TerminationType terminationType = getTerminationType();		
		 		
 		setId(terminationType, rs, rowNumber); 		
 		setCode(terminationType, rs, rowNumber); 		
 		setCompany(terminationType, rs, rowNumber); 		
 		setBaseDescription(terminationType, rs, rowNumber); 		
 		setDetailDescription(terminationType, rs, rowNumber); 		
 		setVersion(terminationType, rs, rowNumber);

		return terminationType;
	}
	
	protected TerminationType getTerminationType(){
		return new TerminationType();
	}		
		
	protected void setId(TerminationType terminationType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(TerminationTypeTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		terminationType.setId(id);
	}
		
	protected void setCode(TerminationType terminationType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String code = rs.getString(TerminationTypeTable.COLUMN_CODE);
		
		if(code == null){
			//do nothing when nothing found in database
			return;
		}
		
		terminationType.setCode(code);
	}
		 		
 	protected void setCompany(TerminationType terminationType, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId = rs.getString(TerminationTypeTable.COLUMN_COMPANY);
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = terminationType.getCompany();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'terminationType' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 			
 			return;
 		}
 		terminationType.setCompany(createEmptyCompany(retailStoreCountryCenterId));
 	}
 	
	protected void setBaseDescription(TerminationType terminationType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String baseDescription = rs.getString(TerminationTypeTable.COLUMN_BASE_DESCRIPTION);
		
		if(baseDescription == null){
			//do nothing when nothing found in database
			return;
		}
		
		terminationType.setBaseDescription(baseDescription);
	}
		
	protected void setDetailDescription(TerminationType terminationType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String detailDescription = rs.getString(TerminationTypeTable.COLUMN_DETAIL_DESCRIPTION);
		
		if(detailDescription == null){
			//do nothing when nothing found in database
			return;
		}
		
		terminationType.setDetailDescription(detailDescription);
	}
		
	protected void setVersion(TerminationType terminationType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(TerminationTypeTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		terminationType.setVersion(version);
	}
		
		

 	protected RetailStoreCountryCenter  createEmptyCompany(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
}


