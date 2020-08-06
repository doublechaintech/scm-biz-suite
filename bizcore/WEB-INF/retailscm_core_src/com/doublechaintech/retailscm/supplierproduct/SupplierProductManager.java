
package com.doublechaintech.retailscm.supplierproduct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface SupplierProductManager extends BaseManager{

		

	public SupplierProduct createSupplierProduct(RetailscmUserContext userContext, String productName,String productDescription,String productUnit,String supplierId) throws Exception;
	public SupplierProduct updateSupplierProduct(RetailscmUserContext userContext,String supplierProductId, int supplierProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplierProduct loadSupplierProduct(RetailscmUserContext userContext, String supplierProductId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public SupplierProduct internalSaveSupplierProduct(RetailscmUserContext userContext, SupplierProduct supplierProduct) throws Exception;
	public SupplierProduct internalSaveSupplierProduct(RetailscmUserContext userContext, SupplierProduct supplierProduct,Map<String,Object>option) throws Exception;

	public SupplierProduct transferToAnotherSupplier(RetailscmUserContext userContext, String supplierProductId, String anotherSupplierId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String supplierProductId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplierProduct newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  ProductSupplyDurationManager getProductSupplyDurationManager(RetailscmUserContext userContext, String supplierProductId, int quantity, String duration, BigDecimal price ,String [] tokensExpr)  throws Exception;

	public  SupplierProduct addProductSupplyDuration(RetailscmUserContext userContext, String supplierProductId, int quantity, String duration, BigDecimal price , String [] tokensExpr)  throws Exception;
	public  SupplierProduct removeProductSupplyDuration(RetailscmUserContext userContext, String supplierProductId, String productSupplyDurationId, int productSupplyDurationVersion,String [] tokensExpr)  throws Exception;
	public  SupplierProduct updateProductSupplyDuration(RetailscmUserContext userContext, String supplierProductId, String productSupplyDurationId, int productSupplyDurationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listBySupplier(RetailscmUserContext userContext,String supplierId) throws Exception;
	public Object listPageBySupplier(RetailscmUserContext userContext,String supplierId, int start, int count) throws Exception;
  

}


