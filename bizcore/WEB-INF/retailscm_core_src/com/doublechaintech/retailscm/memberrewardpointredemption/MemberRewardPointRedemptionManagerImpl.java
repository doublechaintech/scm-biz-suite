
package com.doublechaintech.retailscm.memberrewardpointredemption;

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

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

import com.doublechaintech.retailscm.retailstoremember.CandidateRetailStoreMember;







public class MemberRewardPointRedemptionManagerImpl extends CustomRetailscmCheckerManager implements MemberRewardPointRedemptionManager {
	
	private static final String SERVICE_TYPE = "MemberRewardPointRedemption";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws MemberRewardPointRedemptionManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new MemberRewardPointRedemptionManagerException(message);

	}
	
	

 	protected MemberRewardPointRedemption saveMemberRewardPointRedemption(RetailscmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption, String [] tokensExpr) throws Exception{	
 		//return getMemberRewardPointRedemptionDAO().save(memberRewardPointRedemption, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, tokens);
 	}
 	
 	protected MemberRewardPointRedemption saveMemberRewardPointRedemptionDetail(RetailscmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption) throws Exception{	

 		
 		return saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, allTokens());
 	}
 	
 	public MemberRewardPointRedemption loadMemberRewardPointRedemption(RetailscmUserContext userContext, String memberRewardPointRedemptionId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionId);
		userContext.getChecker().throwExceptionIfHasErrors( MemberRewardPointRedemptionManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		MemberRewardPointRedemption memberRewardPointRedemption = loadMemberRewardPointRedemption( userContext, memberRewardPointRedemptionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,memberRewardPointRedemption, tokens);
 	}
 	
 	
 	 public MemberRewardPointRedemption searchMemberRewardPointRedemption(RetailscmUserContext userContext, String memberRewardPointRedemptionId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionId);
		userContext.getChecker().throwExceptionIfHasErrors( MemberRewardPointRedemptionManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		MemberRewardPointRedemption memberRewardPointRedemption = loadMemberRewardPointRedemption( userContext, memberRewardPointRedemptionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,memberRewardPointRedemption, tokens);
 	}
 	
 	

 	protected MemberRewardPointRedemption present(RetailscmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,memberRewardPointRedemption,tokens);
		
		
		MemberRewardPointRedemption  memberRewardPointRedemptionToPresent = userContext.getDAOGroup().getMemberRewardPointRedemptionDAO().present(memberRewardPointRedemption, tokens);
		
		List<BaseEntity> entityListToNaming = memberRewardPointRedemptionToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getMemberRewardPointRedemptionDAO().alias(entityListToNaming);
		
		return  memberRewardPointRedemptionToPresent;
		
		
	}
 
 	
 	
 	public MemberRewardPointRedemption loadMemberRewardPointRedemptionDetail(RetailscmUserContext userContext, String memberRewardPointRedemptionId) throws Exception{	
 		MemberRewardPointRedemption memberRewardPointRedemption = loadMemberRewardPointRedemption( userContext, memberRewardPointRedemptionId, allTokens());
 		return present(userContext,memberRewardPointRedemption, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String memberRewardPointRedemptionId) throws Exception{	
 		MemberRewardPointRedemption memberRewardPointRedemption = loadMemberRewardPointRedemption( userContext, memberRewardPointRedemptionId, viewTokens());
 		return present(userContext,memberRewardPointRedemption, allTokens());
		
 	}
 	protected MemberRewardPointRedemption saveMemberRewardPointRedemption(RetailscmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getMemberRewardPointRedemptionDAO().save(memberRewardPointRedemption, tokens);
 	}
 	protected MemberRewardPointRedemption loadMemberRewardPointRedemption(RetailscmUserContext userContext, String memberRewardPointRedemptionId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionId);
		userContext.getChecker().throwExceptionIfHasErrors( MemberRewardPointRedemptionManagerException.class);

 
 		return userContext.getDAOGroup().getMemberRewardPointRedemptionDAO().load(memberRewardPointRedemptionId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption, Map<String, Object> tokens){
		super.addActions(userContext, memberRewardPointRedemption, tokens);
		
		addAction(userContext, memberRewardPointRedemption, tokens,"@create","createMemberRewardPointRedemption","createMemberRewardPointRedemption/","main","primary");
		addAction(userContext, memberRewardPointRedemption, tokens,"@update","updateMemberRewardPointRedemption","updateMemberRewardPointRedemption/"+memberRewardPointRedemption.getId()+"/","main","primary");
		addAction(userContext, memberRewardPointRedemption, tokens,"@copy","cloneMemberRewardPointRedemption","cloneMemberRewardPointRedemption/"+memberRewardPointRedemption.getId()+"/","main","primary");
		
		addAction(userContext, memberRewardPointRedemption, tokens,"member_reward_point_redemption.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+memberRewardPointRedemption.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public MemberRewardPointRedemption createMemberRewardPointRedemption(RetailscmUserContext userContext,String name, int point, String ownerId) throws Exception
	{
		
		

		

		userContext.getChecker().checkNameOfMemberRewardPointRedemption(name);
		userContext.getChecker().checkPointOfMemberRewardPointRedemption(point);
	
		userContext.getChecker().throwExceptionIfHasErrors(MemberRewardPointRedemptionManagerException.class);


		MemberRewardPointRedemption memberRewardPointRedemption=createNewMemberRewardPointRedemption();	

		memberRewardPointRedemption.setName(name);
		memberRewardPointRedemption.setPoint(point);
			
		RetailStoreMember owner = loadRetailStoreMember(userContext, ownerId,emptyOptions());
		memberRewardPointRedemption.setOwner(owner);
		
		

		memberRewardPointRedemption = saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, emptyOptions());
		
		onNewInstanceCreated(userContext, memberRewardPointRedemption);
		return memberRewardPointRedemption;

		
	}
	protected MemberRewardPointRedemption createNewMemberRewardPointRedemption() 
	{
		
		return new MemberRewardPointRedemption();		
	}
	
	protected void checkParamsForUpdatingMemberRewardPointRedemption(RetailscmUserContext userContext,String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionId);
		userContext.getChecker().checkVersionOfMemberRewardPointRedemption( memberRewardPointRedemptionVersion);
		

		if(MemberRewardPointRedemption.NAME_PROPERTY.equals(property)){
			userContext.getChecker().checkNameOfMemberRewardPointRedemption(parseString(newValueExpr));
		}
		if(MemberRewardPointRedemption.POINT_PROPERTY.equals(property)){
			userContext.getChecker().checkPointOfMemberRewardPointRedemption(parseInt(newValueExpr));
		}		

		
	
		userContext.getChecker().throwExceptionIfHasErrors(MemberRewardPointRedemptionManagerException.class);
	
		
	}
	
	
	
	public MemberRewardPointRedemption clone(RetailscmUserContext userContext, String fromMemberRewardPointRedemptionId) throws Exception{
		
		return userContext.getDAOGroup().getMemberRewardPointRedemptionDAO().clone(fromMemberRewardPointRedemptionId, this.allTokens());
	}
	
	public MemberRewardPointRedemption internalSaveMemberRewardPointRedemption(RetailscmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption) throws Exception 
	{
		return internalSaveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, allTokens());

	}
	public MemberRewardPointRedemption internalSaveMemberRewardPointRedemption(RetailscmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(memberRewardPointRedemption){ 
			//will be good when the memberRewardPointRedemption loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MemberRewardPointRedemption.
			
			
			memberRewardPointRedemption = saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, options);
			return memberRewardPointRedemption;
			
		}

	}
	
	public MemberRewardPointRedemption updateMemberRewardPointRedemption(RetailscmUserContext userContext,String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion, property, newValueExpr, tokensExpr);
		
		
		
		MemberRewardPointRedemption memberRewardPointRedemption = loadMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, allTokens());
		if(memberRewardPointRedemption.getVersion() != memberRewardPointRedemptionVersion){
			String message = "The target version("+memberRewardPointRedemption.getVersion()+") is not equals to version("+memberRewardPointRedemptionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(memberRewardPointRedemption){ 
			//will be good when the memberRewardPointRedemption loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MemberRewardPointRedemption.
			
			memberRewardPointRedemption.changeProperty(property, newValueExpr);
			memberRewardPointRedemption = saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, tokens().done());
			return present(userContext,memberRewardPointRedemption, mergedAllTokens(tokensExpr));
			//return saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, tokens().done());
		}

	}
	
	public MemberRewardPointRedemption updateMemberRewardPointRedemptionProperty(RetailscmUserContext userContext,String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion, property, newValueExpr, tokensExpr);
		
		MemberRewardPointRedemption memberRewardPointRedemption = loadMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, allTokens());
		if(memberRewardPointRedemption.getVersion() != memberRewardPointRedemptionVersion){
			String message = "The target version("+memberRewardPointRedemption.getVersion()+") is not equals to version("+memberRewardPointRedemptionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(memberRewardPointRedemption){ 
			//will be good when the memberRewardPointRedemption loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to MemberRewardPointRedemption.
			
			memberRewardPointRedemption.changeProperty(property, newValueExpr);
			
			memberRewardPointRedemption = saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, tokens().done());
			return present(userContext,memberRewardPointRedemption, mergedAllTokens(tokensExpr));
			//return saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected MemberRewardPointRedemptionTokens tokens(){
		return MemberRewardPointRedemptionTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return MemberRewardPointRedemptionTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return MemberRewardPointRedemptionTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(RetailscmUserContext userContext, String memberRewardPointRedemptionId, String anotherOwnerId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionId);
 		userContext.getChecker().checkIdOfRetailStoreMember(anotherOwnerId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(MemberRewardPointRedemptionManagerException.class);
 		
 	}
 	public MemberRewardPointRedemption transferToAnotherOwner(RetailscmUserContext userContext, String memberRewardPointRedemptionId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, memberRewardPointRedemptionId,anotherOwnerId);
 
		MemberRewardPointRedemption memberRewardPointRedemption = loadMemberRewardPointRedemption(userContext, memberRewardPointRedemptionId, allTokens());	
		synchronized(memberRewardPointRedemption){
			//will be good when the memberRewardPointRedemption loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreMember owner = loadRetailStoreMember(userContext, anotherOwnerId, emptyOptions());		
			memberRewardPointRedemption.updateOwner(owner);		
			memberRewardPointRedemption = saveMemberRewardPointRedemption(userContext, memberRewardPointRedemption, emptyOptions());
			
			return present(userContext,memberRewardPointRedemption, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreMember requestCandidateOwner(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreMember result = new CandidateRetailStoreMember();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreMember> candidateList = userContext.getDAOGroup().getRetailStoreMemberDAO().requestCandidateRetailStoreMemberForMemberRewardPointRedemption(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreMember loadRetailStoreMember(RetailscmUserContext userContext, String newOwnerId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreMemberDAO().load(newOwnerId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion) throws Exception {
		//deleteInternal(userContext, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion) throws Exception{
			
		userContext.getDAOGroup().getMemberRewardPointRedemptionDAO().delete(memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);
	}
	
	public MemberRewardPointRedemption forgetByAll(RetailscmUserContext userContext, String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion) throws Exception {
		return forgetByAllInternal(userContext, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);		
	}
	protected MemberRewardPointRedemption forgetByAllInternal(RetailscmUserContext userContext,
			String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion) throws Exception{
			
		return userContext.getDAOGroup().getMemberRewardPointRedemptionDAO().disconnectFromAll(memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new MemberRewardPointRedemptionManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getMemberRewardPointRedemptionDAO().deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(RetailscmUserContext userContext, MemberRewardPointRedemption newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


