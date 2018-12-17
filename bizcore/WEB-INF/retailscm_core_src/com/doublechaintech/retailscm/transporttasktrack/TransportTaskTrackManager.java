
package com.doublechaintech.retailscm.transporttasktrack;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface TransportTaskTrackManager{

		

	public TransportTaskTrack createTransportTaskTrack(RetailscmUserContext userContext, Date trackTime, BigDecimal latitude, BigDecimal longitude, String movementId) throws Exception;	
	public TransportTaskTrack updateTransportTaskTrack(RetailscmUserContext userContext,String transportTaskTrackId, int transportTaskTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TransportTaskTrack loadTransportTaskTrack(RetailscmUserContext userContext, String transportTaskTrackId, String [] tokensExpr) throws Exception;
	public TransportTaskTrack internalSaveTransportTaskTrack(RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack) throws Exception;
	public TransportTaskTrack internalSaveTransportTaskTrack(RetailscmUserContext userContext, TransportTaskTrack transportTaskTrack,Map<String,Object>option) throws Exception;
	
	public TransportTaskTrack transferToAnotherMovement(RetailscmUserContext userContext, String transportTaskTrackId, String anotherMovementId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String transportTaskTrackId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, TransportTaskTrack newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


