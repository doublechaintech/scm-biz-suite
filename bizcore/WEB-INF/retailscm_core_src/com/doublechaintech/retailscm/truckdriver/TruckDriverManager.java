
package com.doublechaintech.retailscm.truckdriver;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface TruckDriverManager extends BaseManager{

		

	public TruckDriver createTruckDriver(RetailscmUserContext userContext, String name,String driverLicenseNumber,String contactNumber,String belongsToId) throws Exception;
	public TruckDriver updateTruckDriver(RetailscmUserContext userContext,String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TruckDriver loadTruckDriver(RetailscmUserContext userContext, String truckDriverId, String [] tokensExpr) throws Exception;
	public TruckDriver internalSaveTruckDriver(RetailscmUserContext userContext, TruckDriver truckDriver) throws Exception;
	public TruckDriver internalSaveTruckDriver(RetailscmUserContext userContext, TruckDriver truckDriver,Map<String,Object>option) throws Exception;

	public TruckDriver transferToAnotherBelongsTo(RetailscmUserContext userContext, String truckDriverId, String anotherBelongsToId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String truckDriverId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, TruckDriver newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  TransportTaskManager getTransportTaskManager(RetailscmUserContext userContext, String truckDriverId, String name, String start, Date beginTime, String endId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;

	public  TruckDriver addTransportTask(RetailscmUserContext userContext, String truckDriverId, String name, String start, Date beginTime, String endId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  TruckDriver removeTransportTask(RetailscmUserContext userContext, String truckDriverId, String transportTaskId, int transportTaskVersion,String [] tokensExpr)  throws Exception;
	public  TruckDriver updateTransportTask(RetailscmUserContext userContext, String truckDriverId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByBelongsTo(RetailscmUserContext userContext,String belongsToId) throws Exception;
	public Object listPageByBelongsTo(RetailscmUserContext userContext,String belongsToId, int start, int count) throws Exception;
  

}


