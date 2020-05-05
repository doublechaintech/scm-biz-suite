
package com.doublechaintech.retailscm.retailstorecityservicecenter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;

public class RetailStoreCityServiceCenterMapper extends BaseRowMapper<RetailStoreCityServiceCenter>{
	
	protected RetailStoreCityServiceCenter internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = getRetailStoreCityServiceCenter();		
		 		
 		setId(retailStoreCityServiceCenter, rs, rowNumber); 		
 		setName(retailStoreCityServiceCenter, rs, rowNumber); 		
 		setFounded(retailStoreCityServiceCenter, rs, rowNumber); 		
 		setBelongsTo(retailStoreCityServiceCenter, rs, rowNumber); 		
 		setLastUpdateTime(retailStoreCityServiceCenter, rs, rowNumber); 		
 		setVersion(retailStoreCityServiceCenter, rs, rowNumber);

		return retailStoreCityServiceCenter;
	}
	
	protected RetailStoreCityServiceCenter getRetailStoreCityServiceCenter(){
		return new RetailStoreCityServiceCenter();
	}		
		
	protected void setId(RetailStoreCityServiceCenter retailStoreCityServiceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(RetailStoreCityServiceCenterTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreCityServiceCenter.setId(id);
	}
		
	protected void setName(RetailStoreCityServiceCenter retailStoreCityServiceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(RetailStoreCityServiceCenterTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreCityServiceCenter.setName(name);
	}
		
	protected void setFounded(RetailStoreCityServiceCenter retailStoreCityServiceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date founded = rs.getDate(RetailStoreCityServiceCenterTable.COLUMN_FOUNDED);
		
		if(founded == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreCityServiceCenter.setFounded(founded);
	}
		 		
 	protected void setBelongsTo(RetailStoreCityServiceCenter retailStoreCityServiceCenter, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreProvinceCenterId = rs.getString(RetailStoreCityServiceCenterTable.COLUMN_BELONGS_TO);
 		if( retailStoreProvinceCenterId == null){
 			return;
 		}
 		if( retailStoreProvinceCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreProvinceCenter retailStoreProvinceCenter = retailStoreCityServiceCenter.getBelongsTo();
 		if( retailStoreProvinceCenter != null ){
 			//if the root object 'retailStoreCityServiceCenter' already have the property, just set the id for it;
 			retailStoreProvinceCenter.setId(retailStoreProvinceCenterId);
 			
 			return;
 		}
 		retailStoreCityServiceCenter.setBelongsTo(createEmptyBelongsTo(retailStoreProvinceCenterId));
 	}
 	
	protected void setLastUpdateTime(RetailStoreCityServiceCenter retailStoreCityServiceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(RetailStoreCityServiceCenterTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreCityServiceCenter.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		
	protected void setVersion(RetailStoreCityServiceCenter retailStoreCityServiceCenter, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(RetailStoreCityServiceCenterTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreCityServiceCenter.setVersion(version);
	}
		
		

 	protected RetailStoreProvinceCenter  createEmptyBelongsTo(String retailStoreProvinceCenterId){
 		RetailStoreProvinceCenter retailStoreProvinceCenter = new RetailStoreProvinceCenter();
 		retailStoreProvinceCenter.setId(retailStoreProvinceCenterId);
 		retailStoreProvinceCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreProvinceCenter;
 	}
 	
}


