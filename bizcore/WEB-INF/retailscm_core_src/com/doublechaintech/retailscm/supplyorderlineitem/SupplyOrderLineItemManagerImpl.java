
package com.doublechaintech.retailscm.supplyorderlineitem;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;


import com.doublechaintech.retailscm.Message;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;

import com.doublechaintech.retailscm.RetailscmUserContext;
//import com.doublechaintech.retailscm.BaseManagerImpl;
import com.doublechaintech.retailscm.RetailscmCheckerManager;
import com.doublechaintech.retailscm.CustomRetailscmCheckerManager;

import com.doublechaintech.retailscm.supplyorder.SupplyOrder;

import com.doublechaintech.retailscm.supplyorder.CandidateSupplyOrder;







public class SupplyOrderLineItemManagerImpl extends CustomRetailscmCheckerManager implements SupplyOrderLineItemManager {
	
	private static final String SERVICE_TYPE = "SupplyOrderLineItem";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SupplyOrderLineItemManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SupplyOrderLineItemManagerException(message);

	}
	
	

 	protected SupplyOrderLineItem saveSupplyOrderLineItem(RetailscmUserContext userContext, SupplyOrderLineItem supplyOrderLineItem, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderLineItemDAO().save(supplyOrderLineItem, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderLineItem(userContext, supplyOrderLineItem, tokens);
 	}
 	
 	protected SupplyOrderLineItem saveSupplyOrderLineItemDetail(RetailscmUserContext userContext, SupplyOrderLineItem supplyOrderLineItem) throws Exception{	

 		
 		return saveSupplyOrderLineItem(userContext, supplyOrderLineItem, allTokens());
 	}
 	
 	public SupplyOrderLineItem loadSupplyOrderLineItem(RetailscmUserContext userContext, String supplyOrderLineItemId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderLineItemManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderLineItem supplyOrderLineItem = loadSupplyOrderLineItem( userContext, supplyOrderLineItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderLineItem, tokens);
 	}
 	
 	
 	 public SupplyOrderLineItem searchSupplyOrderLineItem(RetailscmUserContext userContext, String supplyOrderLineItemId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderLineItemManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplyOrderLineItem supplyOrderLineItem = loadSupplyOrderLineItem( userContext, supplyOrderLineItemId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderLineItem, tokens);
 	}
 	
 	

 	protected SupplyOrderLineItem present(RetailscmUserContext userContext, SupplyOrderLineItem supplyOrderLineItem, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderLineItem,tokens);
		
		
		SupplyOrderLineItem  supplyOrderLineItemToPresent = userContext.getDAOGroup().getSupplyOrderLineItemDAO().present(supplyOrderLineItem, tokens);
		
		List<BaseEntity> entityListToNaming = supplyOrderLineItemToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getSupplyOrderLineItemDAO().alias(entityListToNaming);
		
		return  supplyOrderLineItemToPresent;
		
		
	}
 
 	
 	
 	public SupplyOrderLineItem loadSupplyOrderLineItemDetail(RetailscmUserContext userContext, String supplyOrderLineItemId) throws Exception{	
 		SupplyOrderLineItem supplyOrderLineItem = loadSupplyOrderLineItem( userContext, supplyOrderLineItemId, allTokens());
 		return present(userContext,supplyOrderLineItem, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String supplyOrderLineItemId) throws Exception{	
 		SupplyOrderLineItem supplyOrderLineItem = loadSupplyOrderLineItem( userContext, supplyOrderLineItemId, viewTokens());
 		return present(userContext,supplyOrderLineItem, allTokens());
		
 	}
 	protected SupplyOrderLineItem saveSupplyOrderLineItem(RetailscmUserContext userContext, SupplyOrderLineItem supplyOrderLineItem, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getSupplyOrderLineItemDAO().save(supplyOrderLineItem, tokens);
 	}
 	protected SupplyOrderLineItem loadSupplyOrderLineItem(RetailscmUserContext userContext, String supplyOrderLineItemId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderLineItemManagerException.class);

 
 		return userContext.getDAOGroup().getSupplyOrderLineItemDAO().load(supplyOrderLineItemId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderLineItem supplyOrderLineItem, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderLineItem, tokens);
		
		addAction(userContext, supplyOrderLineItem, tokens,"@create","createSupplyOrderLineItem","createSupplyOrderLineItem/","main","primary");
		addAction(userContext, supplyOrderLineItem, tokens,"@update","updateSupplyOrderLineItem","updateSupplyOrderLineItem/"+supplyOrderLineItem.getId()+"/","main","primary");
		addAction(userContext, supplyOrderLineItem, tokens,"@copy","cloneSupplyOrderLineItem","cloneSupplyOrderLineItem/"+supplyOrderLineItem.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderLineItem, tokens,"supply_order_line_item.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+supplyOrderLineItem.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderLineItem supplyOrderLineItem, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplyOrderLineItem createSupplyOrderLineItem(RetailscmUserContext userContext,String bizOrderId, String skuId, String skuName, BigDecimal amount, int quantity, String unitOfMeasurement) throws Exception
	{
		
		

		

		userContext.getChecker().checkSkuIdOfSupplyOrderLineItem(skuId);
		userContext.getChecker().checkSkuNameOfSupplyOrderLineItem(skuName);
		userContext.getChecker().checkAmountOfSupplyOrderLineItem(amount);
		userContext.getChecker().checkQuantityOfSupplyOrderLineItem(quantity);
		userContext.getChecker().checkUnitOfMeasurementOfSupplyOrderLineItem(unitOfMeasurement);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderLineItemManagerException.class);


		SupplyOrderLineItem supplyOrderLineItem=createNewSupplyOrderLineItem();	

			
		SupplyOrder bizOrder = loadSupplyOrder(userContext, bizOrderId,emptyOptions());
		supplyOrderLineItem.setBizOrder(bizOrder);
		
		
		supplyOrderLineItem.setSkuId(skuId);
		supplyOrderLineItem.setSkuName(skuName);
		supplyOrderLineItem.setAmount(amount);
		supplyOrderLineItem.setQuantity(quantity);
		supplyOrderLineItem.setUnitOfMeasurement(unitOfMeasurement);

		supplyOrderLineItem = saveSupplyOrderLineItem(userContext, supplyOrderLineItem, emptyOptions());
		
		onNewInstanceCreated(userContext, supplyOrderLineItem);
		return supplyOrderLineItem;

		
	}
	protected SupplyOrderLineItem createNewSupplyOrderLineItem() 
	{
		
		return new SupplyOrderLineItem();		
	}
	
	protected void checkParamsForUpdatingSupplyOrderLineItem(RetailscmUserContext userContext,String supplyOrderLineItemId, int supplyOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);
		userContext.getChecker().checkVersionOfSupplyOrderLineItem( supplyOrderLineItemVersion);
		
		

		
		if(SupplyOrderLineItem.SKU_ID_PROPERTY.equals(property)){
			userContext.getChecker().checkSkuIdOfSupplyOrderLineItem(parseString(newValueExpr));
		}
		if(SupplyOrderLineItem.SKU_NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkSkuNameOfSupplyOrderLineItem(parseString(newValueExpr));
		}
		if(SupplyOrderLineItem.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfSupplyOrderLineItem(parseBigDecimal(newValueExpr));
		}
		if(SupplyOrderLineItem.QUANTITY_PROPERTY.equals(property)){
			userContext.getChecker().checkQuantityOfSupplyOrderLineItem(parseInt(newValueExpr));
		}
		if(SupplyOrderLineItem.UNIT_OF_MEASUREMENT_PROPERTY.equals(property)){
			userContext.getChecker().checkUnitOfMeasurementOfSupplyOrderLineItem(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderLineItemManagerException.class);
	
		
	}
	
	
	
	public SupplyOrderLineItem clone(RetailscmUserContext userContext, String fromSupplyOrderLineItemId) throws Exception{
		
		return userContext.getDAOGroup().getSupplyOrderLineItemDAO().clone(fromSupplyOrderLineItemId, this.allTokens());
	}
	
	public SupplyOrderLineItem internalSaveSupplyOrderLineItem(RetailscmUserContext userContext, SupplyOrderLineItem supplyOrderLineItem) throws Exception 
	{
		return internalSaveSupplyOrderLineItem(userContext, supplyOrderLineItem, allTokens());

	}
	public SupplyOrderLineItem internalSaveSupplyOrderLineItem(RetailscmUserContext userContext, SupplyOrderLineItem supplyOrderLineItem, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSupplyOrderLineItem(userContext, supplyOrderLineItemId, supplyOrderLineItemVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(supplyOrderLineItem){ 
			//will be good when the supplyOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderLineItem.
			
			
			supplyOrderLineItem = saveSupplyOrderLineItem(userContext, supplyOrderLineItem, options);
			return supplyOrderLineItem;
			
		}

	}
	
	public SupplyOrderLineItem updateSupplyOrderLineItem(RetailscmUserContext userContext,String supplyOrderLineItemId, int supplyOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderLineItem(userContext, supplyOrderLineItemId, supplyOrderLineItemVersion, property, newValueExpr, tokensExpr);
		
		
		
		SupplyOrderLineItem supplyOrderLineItem = loadSupplyOrderLineItem(userContext, supplyOrderLineItemId, allTokens());
		if(supplyOrderLineItem.getVersion() != supplyOrderLineItemVersion){
			String message = "The target version("+supplyOrderLineItem.getVersion()+") is not equals to version("+supplyOrderLineItemVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderLineItem){ 
			//will be good when the supplyOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderLineItem.
			
			supplyOrderLineItem.changeProperty(property, newValueExpr);
			supplyOrderLineItem = saveSupplyOrderLineItem(userContext, supplyOrderLineItem, tokens().done());
			return present(userContext,supplyOrderLineItem, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderLineItem(userContext, supplyOrderLineItem, tokens().done());
		}

	}
	
	public SupplyOrderLineItem updateSupplyOrderLineItemProperty(RetailscmUserContext userContext,String supplyOrderLineItemId, int supplyOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderLineItem(userContext, supplyOrderLineItemId, supplyOrderLineItemVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrderLineItem supplyOrderLineItem = loadSupplyOrderLineItem(userContext, supplyOrderLineItemId, allTokens());
		if(supplyOrderLineItem.getVersion() != supplyOrderLineItemVersion){
			String message = "The target version("+supplyOrderLineItem.getVersion()+") is not equals to version("+supplyOrderLineItemVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderLineItem){ 
			//will be good when the supplyOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderLineItem.
			
			supplyOrderLineItem.changeProperty(property, newValueExpr);
			
			supplyOrderLineItem = saveSupplyOrderLineItem(userContext, supplyOrderLineItem, tokens().done());
			return present(userContext,supplyOrderLineItem, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderLineItem(userContext, supplyOrderLineItem, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderLineItemTokens tokens(){
		return SupplyOrderLineItemTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderLineItemTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderLineItemTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String supplyOrderLineItemId, String anotherBizOrderId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfSupplyOrderLineItem(supplyOrderLineItemId);
 		userContext.getChecker().checkIdOfSupplyOrder(anotherBizOrderId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderLineItemManagerException.class);
 		
 	}
 	public SupplyOrderLineItem transferToAnotherBizOrder(RetailscmUserContext userContext, String supplyOrderLineItemId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, supplyOrderLineItemId,anotherBizOrderId);
 
		SupplyOrderLineItem supplyOrderLineItem = loadSupplyOrderLineItem(userContext, supplyOrderLineItemId, allTokens());	
		synchronized(supplyOrderLineItem){
			//will be good when the supplyOrderLineItem loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrder bizOrder = loadSupplyOrder(userContext, anotherBizOrderId, emptyOptions());		
			supplyOrderLineItem.updateBizOrder(bizOrder);		
			supplyOrderLineItem = saveSupplyOrderLineItem(userContext, supplyOrderLineItem, emptyOptions());
			
			return present(userContext,supplyOrderLineItem, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateSupplyOrder requestCandidateBizOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSupplyOrder result = new CandidateSupplyOrder();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("buyer");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SupplyOrder> candidateList = userContext.getDAOGroup().getSupplyOrderDAO().requestCandidateSupplyOrderForSupplyOrderLineItem(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected SupplyOrder loadSupplyOrder(RetailscmUserContext userContext, String newBizOrderId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getSupplyOrderDAO().load(newBizOrderId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String supplyOrderLineItemId, int supplyOrderLineItemVersion) throws Exception {
		//deleteInternal(userContext, supplyOrderLineItemId, supplyOrderLineItemVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String supplyOrderLineItemId, int supplyOrderLineItemVersion) throws Exception{
			
		userContext.getDAOGroup().getSupplyOrderLineItemDAO().delete(supplyOrderLineItemId, supplyOrderLineItemVersion);
	}
	
	public SupplyOrderLineItem forgetByAll(RetailscmUserContext userContext, String supplyOrderLineItemId, int supplyOrderLineItemVersion) throws Exception {
		return forgetByAllInternal(userContext, supplyOrderLineItemId, supplyOrderLineItemVersion);		
	}
	protected SupplyOrderLineItem forgetByAllInternal(RetailscmUserContext userContext,
			String supplyOrderLineItemId, int supplyOrderLineItemVersion) throws Exception{
			
		return userContext.getDAOGroup().getSupplyOrderLineItemDAO().disconnectFromAll(supplyOrderLineItemId, supplyOrderLineItemVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderLineItemManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getSupplyOrderLineItemDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderLineItem newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


