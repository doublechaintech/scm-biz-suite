
package com.doublechaintech.retailscm.transportfleet;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.List;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;




public interface TransportFleetManager extends BaseManager{

		

  List<TransportFleet> searchTransportFleetList(RetailscmUserContext ctx, TransportFleetRequest pRequest);
  TransportFleet searchTransportFleet(RetailscmUserContext ctx, TransportFleetRequest pRequest);
	public TransportFleet createTransportFleet(RetailscmUserContext userContext, String name,String contactNumber,String ownerId,String contract) throws Exception;
	public TransportFleet updateTransportFleet(RetailscmUserContext userContext,String transportFleetId, int transportFleetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TransportFleet loadTransportFleet(RetailscmUserContext userContext, String transportFleetId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public TransportFleet internalSaveTransportFleet(RetailscmUserContext userContext, TransportFleet transportFleet) throws Exception;
	public TransportFleet internalSaveTransportFleet(RetailscmUserContext userContext, TransportFleet transportFleet,Map<String,Object>option) throws Exception;

	public TransportFleet transferToAnotherOwner(RetailscmUserContext userContext, String transportFleetId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String transportFleetId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, TransportFleet newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, TransportFleet updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  TransportTruckManager getTransportTruckManager(RetailscmUserContext userContext, String transportFleetId, String name, String plateNumber, String contactNumber, String vehicleLicenseNumber, String engineNumber, Date makeDate, String mileage, String bodyColor ,String [] tokensExpr)  throws Exception;

	public  TransportFleet addTransportTruck(RetailscmUserContext userContext, String transportFleetId, String name, String plateNumber, String contactNumber, String vehicleLicenseNumber, String engineNumber, Date makeDate, String mileage, String bodyColor , String [] tokensExpr)  throws Exception;
	public  TransportFleet removeTransportTruck(RetailscmUserContext userContext, String transportFleetId, String transportTruckId, int transportTruckVersion,String [] tokensExpr)  throws Exception;
	public  TransportFleet updateTransportTruck(RetailscmUserContext userContext, String transportFleetId, String transportTruckId, int transportTruckVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TruckDriverManager getTruckDriverManager(RetailscmUserContext userContext, String transportFleetId, String name, String driverLicenseNumber, String contactNumber ,String [] tokensExpr)  throws Exception;

	public  TransportFleet addTruckDriver(RetailscmUserContext userContext, String transportFleetId, String name, String driverLicenseNumber, String contactNumber , String [] tokensExpr)  throws Exception;
	public  TransportFleet removeTruckDriver(RetailscmUserContext userContext, String transportFleetId, String truckDriverId, int truckDriverVersion,String [] tokensExpr)  throws Exception;
	public  TransportFleet updateTruckDriver(RetailscmUserContext userContext, String transportFleetId, String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TransportTaskManager getTransportTaskManager(RetailscmUserContext userContext, String transportFleetId, String name, String start, Date beginTime, String endId, String driverId, String truckId, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  TransportFleet addTransportTask(RetailscmUserContext userContext, String transportFleetId, String name, String start, Date beginTime, String endId, String driverId, String truckId, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  TransportFleet removeTransportTask(RetailscmUserContext userContext, String transportFleetId, String transportTaskId, int transportTaskVersion,String [] tokensExpr)  throws Exception;
	public  TransportFleet updateTransportTask(RetailscmUserContext userContext, String transportFleetId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByOwner(RetailscmUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(RetailscmUserContext userContext,String ownerId, int start, int count) throws Exception;
  




}


