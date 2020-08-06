
package com.doublechaintech.retailscm.productsupplyduration;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface ProductSupplyDurationManager extends BaseManager{

		

	public ProductSupplyDuration createProductSupplyDuration(RetailscmUserContext userContext, int quantity,String duration,BigDecimal price,String productId) throws Exception;
	public ProductSupplyDuration updateProductSupplyDuration(RetailscmUserContext userContext,String productSupplyDurationId, int productSupplyDurationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ProductSupplyDuration loadProductSupplyDuration(RetailscmUserContext userContext, String productSupplyDurationId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public ProductSupplyDuration internalSaveProductSupplyDuration(RetailscmUserContext userContext, ProductSupplyDuration productSupplyDuration) throws Exception;
	public ProductSupplyDuration internalSaveProductSupplyDuration(RetailscmUserContext userContext, ProductSupplyDuration productSupplyDuration,Map<String,Object>option) throws Exception;

	public ProductSupplyDuration transferToAnotherProduct(RetailscmUserContext userContext, String productSupplyDurationId, String anotherProductId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String productSupplyDurationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, ProductSupplyDuration newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByProduct(RetailscmUserContext userContext,String productId) throws Exception;
	public Object listPageByProduct(RetailscmUserContext userContext,String productId, int start, int count) throws Exception;
  

}


