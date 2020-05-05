
package com.doublechaintech.retailscm.occupationtype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

public class OccupationTypeMapper extends BaseRowMapper<OccupationType>{
	
	protected OccupationType internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		OccupationType occupationType = getOccupationType();		
		 		
 		setId(occupationType, rs, rowNumber); 		
 		setCode(occupationType, rs, rowNumber); 		
 		setCompany(occupationType, rs, rowNumber); 		
 		setDescription(occupationType, rs, rowNumber); 		
 		setDetailDescription(occupationType, rs, rowNumber); 		
 		setVersion(occupationType, rs, rowNumber);

		return occupationType;
	}
	
	protected OccupationType getOccupationType(){
		return new OccupationType();
	}		
		
	protected void setId(OccupationType occupationType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(OccupationTypeTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		occupationType.setId(id);
	}
		
	protected void setCode(OccupationType occupationType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String code = rs.getString(OccupationTypeTable.COLUMN_CODE);
		
		if(code == null){
			//do nothing when nothing found in database
			return;
		}
		
		occupationType.setCode(code);
	}
		 		
 	protected void setCompany(OccupationType occupationType, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId = rs.getString(OccupationTypeTable.COLUMN_COMPANY);
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = occupationType.getCompany();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'occupationType' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 			
 			return;
 		}
 		occupationType.setCompany(createEmptyCompany(retailStoreCountryCenterId));
 	}
 	
	protected void setDescription(OccupationType occupationType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(OccupationTypeTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		occupationType.setDescription(description);
	}
		
	protected void setDetailDescription(OccupationType occupationType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String detailDescription = rs.getString(OccupationTypeTable.COLUMN_DETAIL_DESCRIPTION);
		
		if(detailDescription == null){
			//do nothing when nothing found in database
			return;
		}
		
		occupationType.setDetailDescription(detailDescription);
	}
		
	protected void setVersion(OccupationType occupationType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(OccupationTypeTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		occupationType.setVersion(version);
	}
		
		

 	protected RetailStoreCountryCenter  createEmptyCompany(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
}


