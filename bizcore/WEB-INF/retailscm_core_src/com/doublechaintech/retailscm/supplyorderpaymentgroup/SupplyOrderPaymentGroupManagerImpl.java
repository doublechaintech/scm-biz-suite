
package com.doublechaintech.retailscm.supplyorderpaymentgroup;

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







public class SupplyOrderPaymentGroupManagerImpl extends CustomRetailscmCheckerManager implements SupplyOrderPaymentGroupManager {
	
	private static final String SERVICE_TYPE = "SupplyOrderPaymentGroup";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SupplyOrderPaymentGroupManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SupplyOrderPaymentGroupManagerException(message);

	}
	
	

 	protected SupplyOrderPaymentGroup saveSupplyOrderPaymentGroup(RetailscmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup, String [] tokensExpr) throws Exception{	
 		//return getSupplyOrderPaymentGroupDAO().save(supplyOrderPaymentGroup, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, tokens);
 	}
 	
 	protected SupplyOrderPaymentGroup saveSupplyOrderPaymentGroupDetail(RetailscmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup) throws Exception{	

 		
 		return saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, allTokens());
 	}
 	
 	public SupplyOrderPaymentGroup loadSupplyOrderPaymentGroup(RetailscmUserContext userContext, String supplyOrderPaymentGroupId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderPaymentGroupManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup( userContext, supplyOrderPaymentGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderPaymentGroup, tokens);
 	}
 	
 	
 	 public SupplyOrderPaymentGroup searchSupplyOrderPaymentGroup(RetailscmUserContext userContext, String supplyOrderPaymentGroupId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderPaymentGroupManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup( userContext, supplyOrderPaymentGroupId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,supplyOrderPaymentGroup, tokens);
 	}
 	
 	

 	protected SupplyOrderPaymentGroup present(RetailscmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,supplyOrderPaymentGroup,tokens);
		
		
		SupplyOrderPaymentGroup  supplyOrderPaymentGroupToPresent = userContext.getDAOGroup().getSupplyOrderPaymentGroupDAO().present(supplyOrderPaymentGroup, tokens);
		
		List<BaseEntity> entityListToNaming = supplyOrderPaymentGroupToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getSupplyOrderPaymentGroupDAO().alias(entityListToNaming);
		
		return  supplyOrderPaymentGroupToPresent;
		
		
	}
 
 	
 	
 	public SupplyOrderPaymentGroup loadSupplyOrderPaymentGroupDetail(RetailscmUserContext userContext, String supplyOrderPaymentGroupId) throws Exception{	
 		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup( userContext, supplyOrderPaymentGroupId, allTokens());
 		return present(userContext,supplyOrderPaymentGroup, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String supplyOrderPaymentGroupId) throws Exception{	
 		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup( userContext, supplyOrderPaymentGroupId, viewTokens());
 		return present(userContext,supplyOrderPaymentGroup, allTokens());
		
 	}
 	protected SupplyOrderPaymentGroup saveSupplyOrderPaymentGroup(RetailscmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getSupplyOrderPaymentGroupDAO().save(supplyOrderPaymentGroup, tokens);
 	}
 	protected SupplyOrderPaymentGroup loadSupplyOrderPaymentGroup(RetailscmUserContext userContext, String supplyOrderPaymentGroupId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupId);
		userContext.getChecker().throwExceptionIfHasErrors( SupplyOrderPaymentGroupManagerException.class);

 
 		return userContext.getDAOGroup().getSupplyOrderPaymentGroupDAO().load(supplyOrderPaymentGroupId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup, Map<String, Object> tokens){
		super.addActions(userContext, supplyOrderPaymentGroup, tokens);
		
		addAction(userContext, supplyOrderPaymentGroup, tokens,"@create","createSupplyOrderPaymentGroup","createSupplyOrderPaymentGroup/","main","primary");
		addAction(userContext, supplyOrderPaymentGroup, tokens,"@update","updateSupplyOrderPaymentGroup","updateSupplyOrderPaymentGroup/"+supplyOrderPaymentGroup.getId()+"/","main","primary");
		addAction(userContext, supplyOrderPaymentGroup, tokens,"@copy","cloneSupplyOrderPaymentGroup","cloneSupplyOrderPaymentGroup/"+supplyOrderPaymentGroup.getId()+"/","main","primary");
		
		addAction(userContext, supplyOrderPaymentGroup, tokens,"supply_order_payment_group.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+supplyOrderPaymentGroup.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SupplyOrderPaymentGroup createSupplyOrderPaymentGroup(RetailscmUserContext userContext,String name, String bizOrderId, String cardNumber) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfSupplyOrderPaymentGroup(name);
		userContext.getChecker().checkCardNumberOfSupplyOrderPaymentGroup(cardNumber);
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderPaymentGroupManagerException.class);


		SupplyOrderPaymentGroup supplyOrderPaymentGroup=createNewSupplyOrderPaymentGroup();	

		supplyOrderPaymentGroup.setName(name);
			
		SupplyOrder bizOrder = loadSupplyOrder(userContext, bizOrderId,emptyOptions());
		supplyOrderPaymentGroup.setBizOrder(bizOrder);
		
		
		supplyOrderPaymentGroup.setCardNumber(cardNumber);

		supplyOrderPaymentGroup = saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, emptyOptions());
		
		onNewInstanceCreated(userContext, supplyOrderPaymentGroup);
		return supplyOrderPaymentGroup;

		
	}
	protected SupplyOrderPaymentGroup createNewSupplyOrderPaymentGroup() 
	{
		
		return new SupplyOrderPaymentGroup();		
	}
	
	protected void checkParamsForUpdatingSupplyOrderPaymentGroup(RetailscmUserContext userContext,String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupId);
		userContext.getChecker().checkVersionOfSupplyOrderPaymentGroup( supplyOrderPaymentGroupVersion);
		

		if(SupplyOrderPaymentGroup.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfSupplyOrderPaymentGroup(parseString(newValueExpr));
		}		

		
		if(SupplyOrderPaymentGroup.CARD_NUMBER_PROPERTY.equals(property)){
			userContext.getChecker().checkCardNumberOfSupplyOrderPaymentGroup(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderPaymentGroupManagerException.class);
	
		
	}
	
	
	
	public SupplyOrderPaymentGroup clone(RetailscmUserContext userContext, String fromSupplyOrderPaymentGroupId) throws Exception{
		
		return userContext.getDAOGroup().getSupplyOrderPaymentGroupDAO().clone(fromSupplyOrderPaymentGroupId, this.allTokens());
	}
	
	public SupplyOrderPaymentGroup internalSaveSupplyOrderPaymentGroup(RetailscmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup) throws Exception 
	{
		return internalSaveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, allTokens());

	}
	public SupplyOrderPaymentGroup internalSaveSupplyOrderPaymentGroup(RetailscmUserContext userContext, SupplyOrderPaymentGroup supplyOrderPaymentGroup, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(supplyOrderPaymentGroup){ 
			//will be good when the supplyOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderPaymentGroup.
			
			
			supplyOrderPaymentGroup = saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, options);
			return supplyOrderPaymentGroup;
			
		}

	}
	
	public SupplyOrderPaymentGroup updateSupplyOrderPaymentGroup(RetailscmUserContext userContext,String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);
		
		
		
		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, allTokens());
		if(supplyOrderPaymentGroup.getVersion() != supplyOrderPaymentGroupVersion){
			String message = "The target version("+supplyOrderPaymentGroup.getVersion()+") is not equals to version("+supplyOrderPaymentGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderPaymentGroup){ 
			//will be good when the supplyOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderPaymentGroup.
			
			supplyOrderPaymentGroup.changeProperty(property, newValueExpr);
			supplyOrderPaymentGroup = saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, tokens().done());
			return present(userContext,supplyOrderPaymentGroup, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, tokens().done());
		}

	}
	
	public SupplyOrderPaymentGroup updateSupplyOrderPaymentGroupProperty(RetailscmUserContext userContext,String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion, property, newValueExpr, tokensExpr);
		
		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, allTokens());
		if(supplyOrderPaymentGroup.getVersion() != supplyOrderPaymentGroupVersion){
			String message = "The target version("+supplyOrderPaymentGroup.getVersion()+") is not equals to version("+supplyOrderPaymentGroupVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(supplyOrderPaymentGroup){ 
			//will be good when the supplyOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SupplyOrderPaymentGroup.
			
			supplyOrderPaymentGroup.changeProperty(property, newValueExpr);
			
			supplyOrderPaymentGroup = saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, tokens().done());
			return present(userContext,supplyOrderPaymentGroup, mergedAllTokens(tokensExpr));
			//return saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SupplyOrderPaymentGroupTokens tokens(){
		return SupplyOrderPaymentGroupTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SupplyOrderPaymentGroupTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SupplyOrderPaymentGroupTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String supplyOrderPaymentGroupId, String anotherBizOrderId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfSupplyOrderPaymentGroup(supplyOrderPaymentGroupId);
 		userContext.getChecker().checkIdOfSupplyOrder(anotherBizOrderId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(SupplyOrderPaymentGroupManagerException.class);
 		
 	}
 	public SupplyOrderPaymentGroup transferToAnotherBizOrder(RetailscmUserContext userContext, String supplyOrderPaymentGroupId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, supplyOrderPaymentGroupId,anotherBizOrderId);
 
		SupplyOrderPaymentGroup supplyOrderPaymentGroup = loadSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroupId, allTokens());	
		synchronized(supplyOrderPaymentGroup){
			//will be good when the supplyOrderPaymentGroup loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SupplyOrder bizOrder = loadSupplyOrder(userContext, anotherBizOrderId, emptyOptions());		
			supplyOrderPaymentGroup.updateBizOrder(bizOrder);		
			supplyOrderPaymentGroup = saveSupplyOrderPaymentGroup(userContext, supplyOrderPaymentGroup, emptyOptions());
			
			return present(userContext,supplyOrderPaymentGroup, allTokens());
			
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
		SmartList<SupplyOrder> candidateList = userContext.getDAOGroup().getSupplyOrderDAO().requestCandidateSupplyOrderForSupplyOrderPaymentGroup(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion) throws Exception {
		//deleteInternal(userContext, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion) throws Exception{
			
		userContext.getDAOGroup().getSupplyOrderPaymentGroupDAO().delete(supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion);
	}
	
	public SupplyOrderPaymentGroup forgetByAll(RetailscmUserContext userContext, String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion) throws Exception {
		return forgetByAllInternal(userContext, supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion);		
	}
	protected SupplyOrderPaymentGroup forgetByAllInternal(RetailscmUserContext userContext,
			String supplyOrderPaymentGroupId, int supplyOrderPaymentGroupVersion) throws Exception{
			
		return userContext.getDAOGroup().getSupplyOrderPaymentGroupDAO().disconnectFromAll(supplyOrderPaymentGroupId, supplyOrderPaymentGroupVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SupplyOrderPaymentGroupManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getSupplyOrderPaymentGroupDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderPaymentGroup newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


