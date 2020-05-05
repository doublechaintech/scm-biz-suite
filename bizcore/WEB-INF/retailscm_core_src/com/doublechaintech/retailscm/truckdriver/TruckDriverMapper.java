
package com.doublechaintech.retailscm.truckdriver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;

public class TruckDriverMapper extends BaseRowMapper<TruckDriver>{
	
	protected TruckDriver internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		TruckDriver truckDriver = getTruckDriver();		
		 		
 		setId(truckDriver, rs, rowNumber); 		
 		setName(truckDriver, rs, rowNumber); 		
 		setDriverLicenseNumber(truckDriver, rs, rowNumber); 		
 		setContactNumber(truckDriver, rs, rowNumber); 		
 		setBelongsTo(truckDriver, rs, rowNumber); 		
 		setVersion(truckDriver, rs, rowNumber);

		return truckDriver;
	}
	
	protected TruckDriver getTruckDriver(){
		return new TruckDriver();
	}		
		
	protected void setId(TruckDriver truckDriver, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(TruckDriverTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		truckDriver.setId(id);
	}
		
	protected void setName(TruckDriver truckDriver, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(TruckDriverTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		truckDriver.setName(name);
	}
		
	protected void setDriverLicenseNumber(TruckDriver truckDriver, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String driverLicenseNumber = rs.getString(TruckDriverTable.COLUMN_DRIVER_LICENSE_NUMBER);
		
		if(driverLicenseNumber == null){
			//do nothing when nothing found in database
			return;
		}
		
		truckDriver.setDriverLicenseNumber(driverLicenseNumber);
	}
		
	protected void setContactNumber(TruckDriver truckDriver, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String contactNumber = rs.getString(TruckDriverTable.COLUMN_CONTACT_NUMBER);
		
		if(contactNumber == null){
			//do nothing when nothing found in database
			return;
		}
		
		truckDriver.setContactNumber(contactNumber);
	}
		 		
 	protected void setBelongsTo(TruckDriver truckDriver, ResultSet rs, int rowNumber) throws SQLException{
 		String transportFleetId = rs.getString(TruckDriverTable.COLUMN_BELONGS_TO);
 		if( transportFleetId == null){
 			return;
 		}
 		if( transportFleetId.isEmpty()){
 			return;
 		}
 		TransportFleet transportFleet = truckDriver.getBelongsTo();
 		if( transportFleet != null ){
 			//if the root object 'truckDriver' already have the property, just set the id for it;
 			transportFleet.setId(transportFleetId);
 			
 			return;
 		}
 		truckDriver.setBelongsTo(createEmptyBelongsTo(transportFleetId));
 	}
 	
	protected void setVersion(TruckDriver truckDriver, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(TruckDriverTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		truckDriver.setVersion(version);
	}
		
		

 	protected TransportFleet  createEmptyBelongsTo(String transportFleetId){
 		TransportFleet transportFleet = new TransportFleet();
 		transportFleet.setId(transportFleetId);
 		transportFleet.setVersion(Integer.MAX_VALUE);
 		return transportFleet;
 	}
 	
}


