
package com.doublechaintech.retailscm.product;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface ProductManager extends BaseManager{

		

	public Product createProduct(RetailscmUserContext userContext, String name,String parentCategoryId,String origin,String remark,String brand,String picture) throws Exception;
	public Product updateProduct(RetailscmUserContext userContext,String productId, int productVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Product loadProduct(RetailscmUserContext userContext, String productId, String [] tokensExpr) throws Exception;
	public Product internalSaveProduct(RetailscmUserContext userContext, Product product) throws Exception;
	public Product internalSaveProduct(RetailscmUserContext userContext, Product product,Map<String,Object>option) throws Exception;

	public Product transferToAnotherParentCategory(RetailscmUserContext userContext, String productId, String anotherParentCategoryId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String productId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, Product newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  SkuManager getSkuManager(RetailscmUserContext userContext, String productId, String name, String size, String barcode, String packageType, String netContent, BigDecimal price, String picture ,String [] tokensExpr)  throws Exception;

	public  Product addSku(RetailscmUserContext userContext, String productId, String name, String size, String barcode, String packageType, String netContent, BigDecimal price, String picture , String [] tokensExpr)  throws Exception;
	public  Product removeSku(RetailscmUserContext userContext, String productId, String skuId, int skuVersion,String [] tokensExpr)  throws Exception;
	public  Product updateSku(RetailscmUserContext userContext, String productId, String skuId, int skuVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByParentCategory(RetailscmUserContext userContext,String parentCategoryId) throws Exception;
	public Object listPageByParentCategory(RetailscmUserContext userContext,String parentCategoryId, int start, int count) throws Exception;
  

}


