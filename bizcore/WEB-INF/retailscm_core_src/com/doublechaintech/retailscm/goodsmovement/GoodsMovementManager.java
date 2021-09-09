
package com.doublechaintech.retailscm.goodsmovement;
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




public interface GoodsMovementManager extends BaseManager{

		

  List<GoodsMovement> searchGoodsMovementList(RetailscmUserContext ctx, GoodsMovementRequest pRequest);
  GoodsMovement searchGoodsMovement(RetailscmUserContext ctx, GoodsMovementRequest pRequest);
	public GoodsMovement createGoodsMovement(RetailscmUserContext userContext, DateTime moveTime,String facility,String facilityId,String fromIp,String userAgent,String sessionId,BigDecimal latitude,BigDecimal longitude,String goodsId) throws Exception;
	public GoodsMovement updateGoodsMovement(RetailscmUserContext userContext,String goodsMovementId, int goodsMovementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public GoodsMovement loadGoodsMovement(RetailscmUserContext userContext, String goodsMovementId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public GoodsMovement internalSaveGoodsMovement(RetailscmUserContext userContext, GoodsMovement goodsMovement) throws Exception;
	public GoodsMovement internalSaveGoodsMovement(RetailscmUserContext userContext, GoodsMovement goodsMovement,Map<String,Object>option) throws Exception;

	public GoodsMovement transferToAnotherGoods(RetailscmUserContext userContext, String goodsMovementId, String anotherGoodsId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String goodsMovementId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, GoodsMovement newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, GoodsMovement updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByGoods(RetailscmUserContext userContext,String goodsId) throws Exception;
	public Object listPageByGoods(RetailscmUserContext userContext,String goodsId, int start, int count) throws Exception;
  




}


