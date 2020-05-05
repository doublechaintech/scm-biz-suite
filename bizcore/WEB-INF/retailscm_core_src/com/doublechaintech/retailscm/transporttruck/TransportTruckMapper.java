
package com.doublechaintech.retailscm.transporttruck;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;

public class TransportTruckMapper extends BaseRowMapper<TransportTruck>{
	
	protected TransportTruck internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		TransportTruck transportTruck = getTransportTruck();		
		 		
 		setId(transportTruck, rs, rowNumber); 		
 		setName(transportTruck, rs, rowNumber); 		
 		setPlateNumber(transportTruck, rs, rowNumber); 		
 		setContactNumber(transportTruck, rs, rowNumber); 		
 		setVehicleLicenseNumber(transportTruck, rs, rowNumber); 		
 		setEngineNumber(transportTruck, rs, rowNumber); 		
 		setMakeDate(transportTruck, rs, rowNumber); 		
 		setMileage(transportTruck, rs, rowNumber); 		
 		setBodyColor(transportTruck, rs, rowNumber); 		
 		setOwner(transportTruck, rs, rowNumber); 		
 		setVersion(transportTruck, rs, rowNumber);

		return transportTruck;
	}
	
	protected TransportTruck getTransportTruck(){
		return new TransportTruck();
	}		
		
	protected void setId(TransportTruck transportTruck, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(TransportTruckTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTruck.setId(id);
	}
		
	protected void setName(TransportTruck transportTruck, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(TransportTruckTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTruck.setName(name);
	}
		
	protected void setPlateNumber(TransportTruck transportTruck, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String plateNumber = rs.getString(TransportTruckTable.COLUMN_PLATE_NUMBER);
		
		if(plateNumber == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTruck.setPlateNumber(plateNumber);
	}
		
	protected void setContactNumber(TransportTruck transportTruck, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String contactNumber = rs.getString(TransportTruckTable.COLUMN_CONTACT_NUMBER);
		
		if(contactNumber == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTruck.setContactNumber(contactNumber);
	}
		
	protected void setVehicleLicenseNumber(TransportTruck transportTruck, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String vehicleLicenseNumber = rs.getString(TransportTruckTable.COLUMN_VEHICLE_LICENSE_NUMBER);
		
		if(vehicleLicenseNumber == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTruck.setVehicleLicenseNumber(vehicleLicenseNumber);
	}
		
	protected void setEngineNumber(TransportTruck transportTruck, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String engineNumber = rs.getString(TransportTruckTable.COLUMN_ENGINE_NUMBER);
		
		if(engineNumber == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTruck.setEngineNumber(engineNumber);
	}
		
	protected void setMakeDate(TransportTruck transportTruck, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date makeDate = rs.getDate(TransportTruckTable.COLUMN_MAKE_DATE);
		
		if(makeDate == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTruck.setMakeDate(makeDate);
	}
		
	protected void setMileage(TransportTruck transportTruck, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String mileage = rs.getString(TransportTruckTable.COLUMN_MILEAGE);
		
		if(mileage == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTruck.setMileage(mileage);
	}
		
	protected void setBodyColor(TransportTruck transportTruck, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String bodyColor = rs.getString(TransportTruckTable.COLUMN_BODY_COLOR);
		
		if(bodyColor == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTruck.setBodyColor(bodyColor);
	}
		 		
 	protected void setOwner(TransportTruck transportTruck, ResultSet rs, int rowNumber) throws SQLException{
 		String transportFleetId = rs.getString(TransportTruckTable.COLUMN_OWNER);
 		if( transportFleetId == null){
 			return;
 		}
 		if( transportFleetId.isEmpty()){
 			return;
 		}
 		TransportFleet transportFleet = transportTruck.getOwner();
 		if( transportFleet != null ){
 			//if the root object 'transportTruck' already have the property, just set the id for it;
 			transportFleet.setId(transportFleetId);
 			
 			return;
 		}
 		transportTruck.setOwner(createEmptyOwner(transportFleetId));
 	}
 	
	protected void setVersion(TransportTruck transportTruck, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(TransportTruckTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTruck.setVersion(version);
	}
		
		

 	protected TransportFleet  createEmptyOwner(String transportFleetId){
 		TransportFleet transportFleet = new TransportFleet();
 		transportFleet.setId(transportFleetId);
 		transportFleet.setVersion(Integer.MAX_VALUE);
 		return transportFleet;
 	}
 	
}


