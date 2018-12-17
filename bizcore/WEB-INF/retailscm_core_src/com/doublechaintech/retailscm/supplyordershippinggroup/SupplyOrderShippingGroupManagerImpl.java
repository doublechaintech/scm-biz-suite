
package com.doublechaintech.retailscm.supplyordershippinggroup;

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







public class SupplyOrderShippingGroupManagerImpl extends CustomRetailscmCheckerManager implements SupplyOrderShippingGroupManager {
	
	private static final String SERVICE_TYPE = "SupplyOrderShippingGroup";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SupplyOrderShippingGroupManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SupplyOrderShippingGroupManagerException(message);

	}
	
	

 	protected SupplyOrderShippingGroup saveSupplyOrderShippingGroup(RetailscmUserContext userContext, SupplyOrderShippingGroup supplyOrderShippingGroup, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderShippingGroupDAO().save(supplyOrderShippingGroup, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderShippingGroup(userContext, supplyOrderShippingGroup, tokens);
 	}
 	
 	protected SupplyOrderShippingGroup saveSupplyOrderShippingGroupDetail(RetailscmUserContext userContext, SupplyOrderShippingGroup supplyOrderShippingGroup) throws Exception{	

 		
 		return saveSupplyOrderShippingGroup(userContext, supplyOrderShippingGroup, allTokens());
 	}
 	
 	public SupplyOrderShippingGroup loadSupplyOrderShippingGroup(RetailscmUserContext userContext, String supplyOrderShippingGroupId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplyOrderShippingGroup(supplyOrderShippingGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderShippingGroupManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderShippingGroup supplyOrderShippingGroup = loadSupplyOrderShippingGroup( userContext, supplyOrderShippingGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderShippingGroup, tokens);
 	}
 	
 	
 	 public SupplyOrderShippingGroup searchSupplyOrderShippingGroup(RetailscmUserContext userContext, String supplyOrderShippingGroupId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplyOrderShippingGroup(supplyOrderShippingGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderShippingGroupManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplyOrderShippingGroup supplyOrderShippingGroup = loadSupplyOrderShippingGroup( userContext, supplyOrderShippingGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderShippingGroup, tokens);
 	}
 	
 	

 	protected SupplyOrderShippingGroup present(RetailscmUserContext userContext, SupplyOrderShippingGroup supplyOrderShippingGroup, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderShippingGroup,tokens);
		
		
		SupplyOrderShippingGroup  supplyOrderShippingGroupToPresent = userContext.getDAOGroup().getSupplyOrderShippingGroupDAO().present(supplyOrderShippingGroup, tokens);
		
		List<BaseEntity> entityListToNaming = supplyOrderShippingGroupToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getSupplyOrderShippingGroupDAO().alias(entityListToNaming);
		
		return  supplyOrderShippingGroupToPresent;
		
		
	}
 
 	
 	
 	public SupplyOrderShippingGroup loadSupplyOrderShippingGroupDetail(RetailscmUserContext userContext, String supplyOrderShippingGroupId) throws Exception{	
 		SupplyOrderShippingGroup supplyOrderShippingGroup = loadSupplyOrderShippingGroup( userContext, supplyOrderShippingGroupId, allTokens());
 		return present(userContext,supplyOrderShippingGroup, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String supplyOrderShippingGroupId) throws Exception{	
 		SupplyOrderShippingGroup supplyOrderShippingGroup = loadSupplyOrderShippingGroup( userContext, supplyOrderShippingGroupId, viewTokens());
 		return present(userContext,supplyOrderShippingGroup, allTokens());
		
 	}
 	protected SupplyOrderShippingGroup saveSupplyOrderShippingGroup(RetailscmUserContext userContext, SupplyOrderShippingGroup supplyOrderShippingGroup, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getSupplyOrderShippingGroupDAO().save(supplyOrderShippingGroup, tokens);
 	}
 	protected SupplyOrderShippingGroup loadSupplyOrderShippingGroup(RetailscmUserContext userContext, String supplyOrderShippingGroupId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfSupplyOrderShippingGroup(supplyOrderShippingGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderShippingGroupManagerException.class);

 
 		return userContext.getDAOGroup().getSupplyOrderShippingGroupDAO().load(supplyOrderShippingGroupId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderShippingGroup supplyOrderShippingGroup, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderShippingGroup, tokens);
		
		addAction(userContext, supplyOrderShippingGroup, tokens,"@create","createSupplyOrderShippingGroup","createSupplyOrderShippingGroup/","main","primary");
		addAction(userContext, supplyOrderShippingGroup, tokens,"@update","updateSupplyOrderShippingGroup","updateSupplyOrderShippingGroup/"+supplyOrderShippingGroup.getId()+"/","main","primary");
		addAction(userContext, supplyOrderShippingGroup, tokens,"@copy","cloneSupplyOrderShippingGroup","cloneSupplyOrderShippingGroup/"+supplyOrderShippingGroup.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderShippingGroup, tokens,"supply_order_shipping_group.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+supplyOrderShippingGroup.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderShippingGroup supplyOrderShippingGroup, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplyOrderShippingGroup createSupplyOrderShippingGroup(RetailscmUserContext userContext,String name, String bizOrderId, BigDecimal amount) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfSupplyOrderShippingGroup(name);
		userContext.getChecker().checkAmountOfSupplyOrderShippingGroup(amount);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderShippingGroupManagerException.class);


		SupplyOrderShippingGroup supplyOrderShippingGroup=createNewSupplyOrderShippingGroup();	

		supplyOrderShippingGroup.setName(name);
			
		SupplyOrder bizOrder = loadSupplyOrder(userContext, bizOrderId,emptyOptions());
		supplyOrderShippingGroup.setBizOrder(bizOrder);
		
		
		supplyOrderShippingGroup.setAmount(amount);

		supplyOrderShippingGroup = saveSupplyOrderShippingGroup(userContext, supplyOrderShippingGroup, emptyOptions());
		
		onNewInstanceCreated(userContext, supplyOrderShippingGroup);
		return supplyOrderShippingGroup;

		
	}
	protected SupplyOrderShippingGroup createNewSupplyOrderShippingGroup() 
	{
		
		return new SupplyOrderShippingGroup();		
	}
	
	protected void checkParamsForUpdatingSupplyOrderShippingGroup(RetailscmUserContext userContext,String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfSupplyOrderShippingGroup(supplyOrderShippingGroupId);
		userContext.getChecker().checkVersionOfSupplyOrderShippingGroup( supplyOrderShippingGroupVersion);
		

		if(SupplyOrderShippingGroup.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfSupplyOrderShippingGroup(parseString(newValueExpr));
		}		

		
		if(SupplyOrderShippingGroup.AMOUNT_PROPERTY.equals(property)){
			userContext.getChecker().checkAmountOfSupplyOrderShippingGroup(parseBigDecimal(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderShippingGroupManagerException.class);
	
		
	}
	
	
	
	public SupplyOrderShippingGroup clone(RetailscmUserContext userContext, String fromSupplyOrderShippingGroupId) throws Exception{
		
		return userContext.getDAOGroup().getSupplyOrderShippingGroupDAO().clone(fromSupplyOrderShippingGroupId, this.allTokens());
	}
	
	public SupplyOrderShippingGroup internalSaveSupplyOrderShippingGroup(RetailscmUserContext userContext, SupplyOrderShippingGroup supplyOrderShippingGroup) throws Exception 
	{
		return internalSaveSupplyOrderShippingGroup(userContext, supplyOrderShippingGroup, allTokens());

	}
	public SupplyOrderShippingGroup internalSaveSupplyOrderShippingGroup(RetailscmUserContext userContext, SupplyOrderShippingGroup supplyOrderShippingGroup, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupId, supplyOrderShippingGroupVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(supplyOrderShippingGroup){ 
			//will be good when the supplyOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderShippingGroup.
			
			
			supplyOrderShippingGroup = saveSupplyOrderShippingGroup(userContext, supplyOrderShippingGroup, options);
			return supplyOrderShippingGroup;
			
		}

	}
	
	public SupplyOrderShippingGroup updateSupplyOrderShippingGroup(RetailscmUserContext userContext,String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupId, supplyOrderShippingGroupVersion, property, newValueExpr, tokensExpr);
		
		
		
		SupplyOrderShippingGroup supplyOrderShippingGroup = loadSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupId, allTokens());
		if(supplyOrderShippingGroup.getVersion() != supplyOrderShippingGroupVersion){
			String message = "The target version("+supplyOrderShippingGroup.getVersion()+") is not equals to version("+supplyOrderShippingGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderShippingGroup){ 
			//will be good when the supplyOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderShippingGroup.
			
			supplyOrderShippingGroup.changeProperty(property, newValueExpr);
			supplyOrderShippingGroup = saveSupplyOrderShippingGroup(userContext, supplyOrderShippingGroup, tokens().done());
			return present(userContext,supplyOrderShippingGroup, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderShippingGroup(userContext, supplyOrderShippingGroup, tokens().done());
		}

	}
	
	public SupplyOrderShippingGroup updateSupplyOrderShippingGroupProperty(RetailscmUserContext userContext,String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupId, supplyOrderShippingGroupVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrderShippingGroup supplyOrderShippingGroup = loadSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupId, allTokens());
		if(supplyOrderShippingGroup.getVersion() != supplyOrderShippingGroupVersion){
			String message = "The target version("+supplyOrderShippingGroup.getVersion()+") is not equals to version("+supplyOrderShippingGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderShippingGroup){ 
			//will be good when the supplyOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderShippingGroup.
			
			supplyOrderShippingGroup.changeProperty(property, newValueExpr);
			
			supplyOrderShippingGroup = saveSupplyOrderShippingGroup(userContext, supplyOrderShippingGroup, tokens().done());
			return present(userContext,supplyOrderShippingGroup, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderShippingGroup(userContext, supplyOrderShippingGroup, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderShippingGroupTokens tokens(){
		return SupplyOrderShippingGroupTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderShippingGroupTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderShippingGroupTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String supplyOrderShippingGroupId, String anotherBizOrderId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfSupplyOrderShippingGroup(supplyOrderShippingGroupId);
 		userContext.getChecker().checkIdOfSupplyOrder(anotherBizOrderId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderShippingGroupManagerException.class);
 		
 	}
 	public SupplyOrderShippingGroup transferToAnotherBizOrder(RetailscmUserContext userContext, String supplyOrderShippingGroupId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, supplyOrderShippingGroupId,anotherBizOrderId);
 
		SupplyOrderShippingGroup supplyOrderShippingGroup = loadSupplyOrderShippingGroup(userContext, supplyOrderShippingGroupId, allTokens());	
		synchronized(supplyOrderShippingGroup){
			//will be good when the supplyOrderShippingGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrder bizOrder = loadSupplyOrder(userContext, anotherBizOrderId, emptyOptions());		
			supplyOrderShippingGroup.updateBizOrder(bizOrder);		
			supplyOrderShippingGroup = saveSupplyOrderShippingGroup(userContext, supplyOrderShippingGroup, emptyOptions());
			
			return present(userContext,supplyOrderShippingGroup, allTokens());
			
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
		SmartList<SupplyOrder> candidateList = userContext.getDAOGroup().getSupplyOrderDAO().requestCandidateSupplyOrderForSupplyOrderShippingGroup(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion) throws Exception {
		//deleteInternal(userContext, supplyOrderShippingGroupId, supplyOrderShippingGroupVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion) throws Exception{
			
		userContext.getDAOGroup().getSupplyOrderShippingGroupDAO().delete(supplyOrderShippingGroupId, supplyOrderShippingGroupVersion);
	}
	
	public SupplyOrderShippingGroup forgetByAll(RetailscmUserContext userContext, String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion) throws Exception {
		return forgetByAllInternal(userContext, supplyOrderShippingGroupId, supplyOrderShippingGroupVersion);		
	}
	protected SupplyOrderShippingGroup forgetByAllInternal(RetailscmUserContext userContext,
			String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion) throws Exception{
			
		return userContext.getDAOGroup().getSupplyOrderShippingGroupDAO().disconnectFromAll(supplyOrderShippingGroupId, supplyOrderShippingGroupVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderShippingGroupManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getSupplyOrderShippingGroupDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderShippingGroup newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


