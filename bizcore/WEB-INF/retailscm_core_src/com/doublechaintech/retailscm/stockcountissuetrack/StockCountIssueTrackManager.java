
package com.doublechaintech.retailscm.stockcountissuetrack;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface StockCountIssueTrackManager{

		

	public StockCountIssueTrack createStockCountIssueTrack(RetailscmUserContext userContext, String title, Date countTime, String summary, String stockCountId) throws Exception;	
	public StockCountIssueTrack updateStockCountIssueTrack(RetailscmUserContext userContext,String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public StockCountIssueTrack loadStockCountIssueTrack(RetailscmUserContext userContext, String stockCountIssueTrackId, String [] tokensExpr) throws Exception;
	public StockCountIssueTrack internalSaveStockCountIssueTrack(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack) throws Exception;
	public StockCountIssueTrack internalSaveStockCountIssueTrack(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack,Map<String,Object>option) throws Exception;
	
	public StockCountIssueTrack transferToAnotherStockCount(RetailscmUserContext userContext, String stockCountIssueTrackId, String anotherStockCountId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String stockCountIssueTrackId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, StockCountIssueTrack newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


