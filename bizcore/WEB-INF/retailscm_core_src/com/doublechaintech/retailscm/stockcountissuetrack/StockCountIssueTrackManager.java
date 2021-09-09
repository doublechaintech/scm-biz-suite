
package com.doublechaintech.retailscm.stockcountissuetrack;
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




public interface StockCountIssueTrackManager extends BaseManager{

		

  List<StockCountIssueTrack> searchStockCountIssueTrackList(RetailscmUserContext ctx, StockCountIssueTrackRequest pRequest);
  StockCountIssueTrack searchStockCountIssueTrack(RetailscmUserContext ctx, StockCountIssueTrackRequest pRequest);
	public StockCountIssueTrack createStockCountIssueTrack(RetailscmUserContext userContext, String title,Date countTime,String summary,String stockCountId) throws Exception;
	public StockCountIssueTrack updateStockCountIssueTrack(RetailscmUserContext userContext,String stockCountIssueTrackId, int stockCountIssueTrackVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public StockCountIssueTrack loadStockCountIssueTrack(RetailscmUserContext userContext, String stockCountIssueTrackId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public StockCountIssueTrack internalSaveStockCountIssueTrack(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack) throws Exception;
	public StockCountIssueTrack internalSaveStockCountIssueTrack(RetailscmUserContext userContext, StockCountIssueTrack stockCountIssueTrack,Map<String,Object>option) throws Exception;

	public StockCountIssueTrack transferToAnotherStockCount(RetailscmUserContext userContext, String stockCountIssueTrackId, String anotherStockCountId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String stockCountIssueTrackId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, StockCountIssueTrack newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, StockCountIssueTrack updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByStockCount(RetailscmUserContext userContext,String stockCountId) throws Exception;
	public Object listPageByStockCount(RetailscmUserContext userContext,String stockCountId, int start, int count) throws Exception;
  




}


