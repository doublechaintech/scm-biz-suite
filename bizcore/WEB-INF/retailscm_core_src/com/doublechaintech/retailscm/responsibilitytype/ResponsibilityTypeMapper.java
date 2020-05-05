
package com.doublechaintech.retailscm.responsibilitytype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

public class ResponsibilityTypeMapper extends BaseRowMapper<ResponsibilityType>{
	
	protected ResponsibilityType internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ResponsibilityType responsibilityType = getResponsibilityType();		
		 		
 		setId(responsibilityType, rs, rowNumber); 		
 		setCode(responsibilityType, rs, rowNumber); 		
 		setCompany(responsibilityType, rs, rowNumber); 		
 		setBaseDescription(responsibilityType, rs, rowNumber); 		
 		setDetailDescription(responsibilityType, rs, rowNumber); 		
 		setVersion(responsibilityType, rs, rowNumber);

		return responsibilityType;
	}
	
	protected ResponsibilityType getResponsibilityType(){
		return new ResponsibilityType();
	}		
		
	protected void setId(ResponsibilityType responsibilityType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(ResponsibilityTypeTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		responsibilityType.setId(id);
	}
		
	protected void setCode(ResponsibilityType responsibilityType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String code = rs.getString(ResponsibilityTypeTable.COLUMN_CODE);
		
		if(code == null){
			//do nothing when nothing found in database
			return;
		}
		
		responsibilityType.setCode(code);
	}
		 		
 	protected void setCompany(ResponsibilityType responsibilityType, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId = rs.getString(ResponsibilityTypeTable.COLUMN_COMPANY);
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = responsibilityType.getCompany();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'responsibilityType' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 			
 			return;
 		}
 		responsibilityType.setCompany(createEmptyCompany(retailStoreCountryCenterId));
 	}
 	
	protected void setBaseDescription(ResponsibilityType responsibilityType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String baseDescription = rs.getString(ResponsibilityTypeTable.COLUMN_BASE_DESCRIPTION);
		
		if(baseDescription == null){
			//do nothing when nothing found in database
			return;
		}
		
		responsibilityType.setBaseDescription(baseDescription);
	}
		
	protected void setDetailDescription(ResponsibilityType responsibilityType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String detailDescription = rs.getString(ResponsibilityTypeTable.COLUMN_DETAIL_DESCRIPTION);
		
		if(detailDescription == null){
			//do nothing when nothing found in database
			return;
		}
		
		responsibilityType.setDetailDescription(detailDescription);
	}
		
	protected void setVersion(ResponsibilityType responsibilityType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(ResponsibilityTypeTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		responsibilityType.setVersion(version);
	}
		
		

 	protected RetailStoreCountryCenter  createEmptyCompany(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
}


