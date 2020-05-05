
package com.doublechaintech.retailscm.transporttask;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;

public class TransportTaskMapper extends BaseRowMapper<TransportTask>{
	
	protected TransportTask internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		TransportTask transportTask = getTransportTask();		
		 		
 		setId(transportTask, rs, rowNumber); 		
 		setName(transportTask, rs, rowNumber); 		
 		setStart(transportTask, rs, rowNumber); 		
 		setBeginTime(transportTask, rs, rowNumber); 		
 		setEnd(transportTask, rs, rowNumber); 		
 		setDriver(transportTask, rs, rowNumber); 		
 		setTruck(transportTask, rs, rowNumber); 		
 		setBelongsTo(transportTask, rs, rowNumber); 		
 		setLatitude(transportTask, rs, rowNumber); 		
 		setLongitude(transportTask, rs, rowNumber); 		
 		setVersion(transportTask, rs, rowNumber);

		return transportTask;
	}
	
	protected TransportTask getTransportTask(){
		return new TransportTask();
	}		
		
	protected void setId(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(TransportTaskTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTask.setId(id);
	}
		
	protected void setName(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(TransportTaskTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTask.setName(name);
	}
		
	protected void setStart(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String start = rs.getString(TransportTaskTable.COLUMN_START);
		
		if(start == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTask.setStart(start);
	}
		
	protected void setBeginTime(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date beginTime = rs.getDate(TransportTaskTable.COLUMN_BEGIN_TIME);
		
		if(beginTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTask.setBeginTime(beginTime);
	}
		 		
 	protected void setEnd(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreId = rs.getString(TransportTaskTable.COLUMN_END);
 		if( retailStoreId == null){
 			return;
 		}
 		if( retailStoreId.isEmpty()){
 			return;
 		}
 		RetailStore retailStore = transportTask.getEnd();
 		if( retailStore != null ){
 			//if the root object 'transportTask' already have the property, just set the id for it;
 			retailStore.setId(retailStoreId);
 			
 			return;
 		}
 		transportTask.setEnd(createEmptyEnd(retailStoreId));
 	}
 	 		
 	protected void setDriver(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
 		String truckDriverId = rs.getString(TransportTaskTable.COLUMN_DRIVER);
 		if( truckDriverId == null){
 			return;
 		}
 		if( truckDriverId.isEmpty()){
 			return;
 		}
 		TruckDriver truckDriver = transportTask.getDriver();
 		if( truckDriver != null ){
 			//if the root object 'transportTask' already have the property, just set the id for it;
 			truckDriver.setId(truckDriverId);
 			
 			return;
 		}
 		transportTask.setDriver(createEmptyDriver(truckDriverId));
 	}
 	 		
 	protected void setTruck(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
 		String transportTruckId = rs.getString(TransportTaskTable.COLUMN_TRUCK);
 		if( transportTruckId == null){
 			return;
 		}
 		if( transportTruckId.isEmpty()){
 			return;
 		}
 		TransportTruck transportTruck = transportTask.getTruck();
 		if( transportTruck != null ){
 			//if the root object 'transportTask' already have the property, just set the id for it;
 			transportTruck.setId(transportTruckId);
 			
 			return;
 		}
 		transportTask.setTruck(createEmptyTruck(transportTruckId));
 	}
 	 		
 	protected void setBelongsTo(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
 		String transportFleetId = rs.getString(TransportTaskTable.COLUMN_BELONGS_TO);
 		if( transportFleetId == null){
 			return;
 		}
 		if( transportFleetId.isEmpty()){
 			return;
 		}
 		TransportFleet transportFleet = transportTask.getBelongsTo();
 		if( transportFleet != null ){
 			//if the root object 'transportTask' already have the property, just set the id for it;
 			transportFleet.setId(transportFleetId);
 			
 			return;
 		}
 		transportTask.setBelongsTo(createEmptyBelongsTo(transportFleetId));
 	}
 	
	protected void setLatitude(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal latitude = rs.getBigDecimal(TransportTaskTable.COLUMN_LATITUDE);
		
		if(latitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTask.setLatitude(latitude);
	}
		
	protected void setLongitude(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal longitude = rs.getBigDecimal(TransportTaskTable.COLUMN_LONGITUDE);
		
		if(longitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTask.setLongitude(longitude);
	}
		
	protected void setVersion(TransportTask transportTask, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(TransportTaskTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		transportTask.setVersion(version);
	}
		
		

 	protected RetailStore  createEmptyEnd(String retailStoreId){
 		RetailStore retailStore = new RetailStore();
 		retailStore.setId(retailStoreId);
 		retailStore.setVersion(Integer.MAX_VALUE);
 		return retailStore;
 	}
 	
 	protected TruckDriver  createEmptyDriver(String truckDriverId){
 		TruckDriver truckDriver = new TruckDriver();
 		truckDriver.setId(truckDriverId);
 		truckDriver.setVersion(Integer.MAX_VALUE);
 		return truckDriver;
 	}
 	
 	protected TransportTruck  createEmptyTruck(String transportTruckId){
 		TransportTruck transportTruck = new TransportTruck();
 		transportTruck.setId(transportTruckId);
 		transportTruck.setVersion(Integer.MAX_VALUE);
 		return transportTruck;
 	}
 	
 	protected TransportFleet  createEmptyBelongsTo(String transportFleetId){
 		TransportFleet transportFleet = new TransportFleet();
 		transportFleet.setId(transportFleetId);
 		transportFleet.setVersion(Integer.MAX_VALUE);
 		return transportFleet;
 	}
 	
}


