
package com.doublechaintech.retailscm.goodssupplier;
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




public interface GoodsSupplierManager extends BaseManager{

		

  List<GoodsSupplier> searchGoodsSupplierList(RetailscmUserContext ctx, GoodsSupplierRequest pRequest);
  GoodsSupplier searchGoodsSupplier(RetailscmUserContext ctx, GoodsSupplierRequest pRequest);
	public GoodsSupplier createGoodsSupplier(RetailscmUserContext userContext, String name,String supplyProduct,String belongToId,String contactNumber,String description) throws Exception;
	public GoodsSupplier updateGoodsSupplier(RetailscmUserContext userContext,String goodsSupplierId, int goodsSupplierVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public GoodsSupplier loadGoodsSupplier(RetailscmUserContext userContext, String goodsSupplierId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public GoodsSupplier internalSaveGoodsSupplier(RetailscmUserContext userContext, GoodsSupplier goodsSupplier) throws Exception;
	public GoodsSupplier internalSaveGoodsSupplier(RetailscmUserContext userContext, GoodsSupplier goodsSupplier,Map<String,Object>option) throws Exception;

	public GoodsSupplier transferToAnotherBelongTo(RetailscmUserContext userContext, String goodsSupplierId, String anotherBelongToId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String goodsSupplierId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, GoodsSupplier newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, GoodsSupplier updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  SupplierProductManager getSupplierProductManager(RetailscmUserContext userContext, String goodsSupplierId, String productName, String productDescription, String productUnit ,String [] tokensExpr)  throws Exception;

	public  GoodsSupplier addSupplierProduct(RetailscmUserContext userContext, String goodsSupplierId, String productName, String productDescription, String productUnit , String [] tokensExpr)  throws Exception;
	public  GoodsSupplier removeSupplierProduct(RetailscmUserContext userContext, String goodsSupplierId, String supplierProductId, int supplierProductVersion,String [] tokensExpr)  throws Exception;
	public  GoodsSupplier updateSupplierProduct(RetailscmUserContext userContext, String goodsSupplierId, String supplierProductId, int supplierProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplyOrderManager getSupplyOrderManager(RetailscmUserContext userContext, String goodsSupplierId, String buyerId, String title, String contract, BigDecimal totalAmount ,String [] tokensExpr)  throws Exception;

	public  GoodsSupplier addSupplyOrder(RetailscmUserContext userContext, String goodsSupplierId, String buyerId, String title, String contract, BigDecimal totalAmount , String [] tokensExpr)  throws Exception;
	public  GoodsSupplier removeSupplyOrder(RetailscmUserContext userContext, String goodsSupplierId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  GoodsSupplier updateSupplyOrder(RetailscmUserContext userContext, String goodsSupplierId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  AccountSetManager getAccountSetManager(RetailscmUserContext userContext, String goodsSupplierId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String retailStoreId ,String [] tokensExpr)  throws Exception;

	public  GoodsSupplier addAccountSet(RetailscmUserContext userContext, String goodsSupplierId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String retailStoreId , String [] tokensExpr)  throws Exception;
	public  GoodsSupplier removeAccountSet(RetailscmUserContext userContext, String goodsSupplierId, String accountSetId, int accountSetVersion,String [] tokensExpr)  throws Exception;
	public  GoodsSupplier updateAccountSet(RetailscmUserContext userContext, String goodsSupplierId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByBelongTo(RetailscmUserContext userContext,String belongToId) throws Exception;
	public Object listPageByBelongTo(RetailscmUserContext userContext,String belongToId, int start, int count) throws Exception;
  




}


