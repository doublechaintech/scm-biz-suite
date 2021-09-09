
package com.doublechaintech.retailscm.retailstoremember;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPoint;import com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemption;import com.doublechaintech.retailscm.memberwishlist.MemberWishlist;import com.doublechaintech.retailscm.retailstore.RetailStore;import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;import com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddress;import com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon;import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class RetailStoreMemberManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreMemberManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = RetailStoreMemberTokens.start().withTokenFromListName(listName).done();
		RetailStoreMember  retailStoreMember = (RetailStoreMember) this.loadRetailStoreMember(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = retailStoreMember.collectRefercencesFromLists();
		retailStoreMemberDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, retailStoreMember, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new RetailStoreMemberGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "RetailStoreMember";
	@Override
	public RetailStoreMemberDAO daoOf(RetailscmUserContext userContext) {
		return retailStoreMemberDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws RetailStoreMemberManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreMemberManagerException(message);

	}



 	protected RetailStoreMember saveRetailStoreMember(RetailscmUserContext userContext, RetailStoreMember retailStoreMember, String [] tokensExpr) throws Exception{
 		//return getRetailStoreMemberDAO().save(retailStoreMember, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveRetailStoreMember(userContext, retailStoreMember, tokens);
 	}

 	protected RetailStoreMember saveRetailStoreMemberDetail(RetailscmUserContext userContext, RetailStoreMember retailStoreMember) throws Exception{


 		return saveRetailStoreMember(userContext, retailStoreMember, allTokens());
 	}

 	public RetailStoreMember loadRetailStoreMember(RetailscmUserContext userContext, String retailStoreMemberId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreMemberManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		RetailStoreMember retailStoreMember = loadRetailStoreMember( userContext, retailStoreMemberId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMember, tokens);
 	}


 	 public RetailStoreMember searchRetailStoreMember(RetailscmUserContext userContext, String retailStoreMemberId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreMemberManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		RetailStoreMember retailStoreMember = loadRetailStoreMember( userContext, retailStoreMemberId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMember, tokens);
 	}



 	protected RetailStoreMember present(RetailscmUserContext userContext, RetailStoreMember retailStoreMember, Map<String, Object> tokens) throws Exception {


		addActions(userContext,retailStoreMember,tokens);
    

		RetailStoreMember  retailStoreMemberToPresent = retailStoreMemberDaoOf(userContext).present(retailStoreMember, tokens);

		List<BaseEntity> entityListToNaming = retailStoreMemberToPresent.collectRefercencesFromLists();
		retailStoreMemberDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,retailStoreMember,tokens);

		return  retailStoreMemberToPresent;


	}



 	public RetailStoreMember loadRetailStoreMemberDetail(RetailscmUserContext userContext, String retailStoreMemberId) throws Exception{
 		RetailStoreMember retailStoreMember = loadRetailStoreMember( userContext, retailStoreMemberId, allTokens());
 		return present(userContext,retailStoreMember, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String retailStoreMemberId) throws Exception{
 		RetailStoreMember retailStoreMember = loadRetailStoreMember( userContext, retailStoreMemberId, viewTokens());
 		markVisited(userContext, retailStoreMember);
 		return present(userContext,retailStoreMember, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String retailStoreMemberId) throws Exception{
		RetailStoreMember retailStoreMember = loadRetailStoreMember( userContext, retailStoreMemberId, viewTokens());
		retailStoreMember.summarySuffix();
		markVisited(userContext, retailStoreMember);
 		return present(userContext,retailStoreMember, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String retailStoreMemberId) throws Exception{
		RetailStoreMember retailStoreMember = loadRetailStoreMember( userContext, retailStoreMemberId, analyzeTokens());
		markVisited(userContext, retailStoreMember);
		return present(userContext,retailStoreMember, analyzeTokens());

	}
 	protected RetailStoreMember saveRetailStoreMember(RetailscmUserContext userContext, RetailStoreMember retailStoreMember, Map<String,Object>tokens) throws Exception{
 	
 		return retailStoreMemberDaoOf(userContext).save(retailStoreMember, tokens);
 	}
 	protected RetailStoreMember loadRetailStoreMember(RetailscmUserContext userContext, String retailStoreMemberId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreMemberManagerException.class);



 		return retailStoreMemberDaoOf(userContext).load(retailStoreMemberId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreMember retailStoreMember, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreMember, tokens);

		addAction(userContext, retailStoreMember, tokens,"@create","createRetailStoreMember","createRetailStoreMember/","main","primary");
		addAction(userContext, retailStoreMember, tokens,"@update","updateRetailStoreMember","updateRetailStoreMember/"+retailStoreMember.getId()+"/","main","primary");
		addAction(userContext, retailStoreMember, tokens,"@copy","cloneRetailStoreMember","cloneRetailStoreMember/"+retailStoreMember.getId()+"/","main","primary");

		addAction(userContext, retailStoreMember, tokens,"retail_store_member.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+retailStoreMember.getId()+"/","main","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+retailStoreMember.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+retailStoreMember.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+retailStoreMember.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+retailStoreMember.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addRetailStoreMemberCoupon","addRetailStoreMemberCoupon","addRetailStoreMemberCoupon/"+retailStoreMember.getId()+"/","retailStoreMemberCouponList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeRetailStoreMemberCoupon","removeRetailStoreMemberCoupon","removeRetailStoreMemberCoupon/"+retailStoreMember.getId()+"/","retailStoreMemberCouponList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateRetailStoreMemberCoupon","updateRetailStoreMemberCoupon","updateRetailStoreMemberCoupon/"+retailStoreMember.getId()+"/","retailStoreMemberCouponList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyRetailStoreMemberCouponFrom","copyRetailStoreMemberCouponFrom","copyRetailStoreMemberCouponFrom/"+retailStoreMember.getId()+"/","retailStoreMemberCouponList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addMemberWishlist","addMemberWishlist","addMemberWishlist/"+retailStoreMember.getId()+"/","memberWishlistList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeMemberWishlist","removeMemberWishlist","removeMemberWishlist/"+retailStoreMember.getId()+"/","memberWishlistList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateMemberWishlist","updateMemberWishlist","updateMemberWishlist/"+retailStoreMember.getId()+"/","memberWishlistList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyMemberWishlistFrom","copyMemberWishlistFrom","copyMemberWishlistFrom/"+retailStoreMember.getId()+"/","memberWishlistList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addMemberRewardPoint","addMemberRewardPoint","addMemberRewardPoint/"+retailStoreMember.getId()+"/","memberRewardPointList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeMemberRewardPoint","removeMemberRewardPoint","removeMemberRewardPoint/"+retailStoreMember.getId()+"/","memberRewardPointList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateMemberRewardPoint","updateMemberRewardPoint","updateMemberRewardPoint/"+retailStoreMember.getId()+"/","memberRewardPointList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyMemberRewardPointFrom","copyMemberRewardPointFrom","copyMemberRewardPointFrom/"+retailStoreMember.getId()+"/","memberRewardPointList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addMemberRewardPointRedemption","addMemberRewardPointRedemption","addMemberRewardPointRedemption/"+retailStoreMember.getId()+"/","memberRewardPointRedemptionList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeMemberRewardPointRedemption","removeMemberRewardPointRedemption","removeMemberRewardPointRedemption/"+retailStoreMember.getId()+"/","memberRewardPointRedemptionList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateMemberRewardPointRedemption","updateMemberRewardPointRedemption","updateMemberRewardPointRedemption/"+retailStoreMember.getId()+"/","memberRewardPointRedemptionList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyMemberRewardPointRedemptionFrom","copyMemberRewardPointRedemptionFrom","copyMemberRewardPointRedemptionFrom/"+retailStoreMember.getId()+"/","memberRewardPointRedemptionList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addRetailStoreMemberAddress","addRetailStoreMemberAddress","addRetailStoreMemberAddress/"+retailStoreMember.getId()+"/","retailStoreMemberAddressList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeRetailStoreMemberAddress","removeRetailStoreMemberAddress","removeRetailStoreMemberAddress/"+retailStoreMember.getId()+"/","retailStoreMemberAddressList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateRetailStoreMemberAddress","updateRetailStoreMemberAddress","updateRetailStoreMemberAddress/"+retailStoreMember.getId()+"/","retailStoreMemberAddressList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyRetailStoreMemberAddressFrom","copyRetailStoreMemberAddressFrom","copyRetailStoreMemberAddressFrom/"+retailStoreMember.getId()+"/","retailStoreMemberAddressList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.addRetailStoreMemberGiftCard","addRetailStoreMemberGiftCard","addRetailStoreMemberGiftCard/"+retailStoreMember.getId()+"/","retailStoreMemberGiftCardList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.removeRetailStoreMemberGiftCard","removeRetailStoreMemberGiftCard","removeRetailStoreMemberGiftCard/"+retailStoreMember.getId()+"/","retailStoreMemberGiftCardList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.updateRetailStoreMemberGiftCard","updateRetailStoreMemberGiftCard","updateRetailStoreMemberGiftCard/"+retailStoreMember.getId()+"/","retailStoreMemberGiftCardList","primary");
		addAction(userContext, retailStoreMember, tokens,"retail_store_member.copyRetailStoreMemberGiftCardFrom","copyRetailStoreMemberGiftCardFrom","copyRetailStoreMemberGiftCardFrom/"+retailStoreMember.getId()+"/","retailStoreMemberGiftCardList","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreMember retailStoreMember, Map<String, Object> tokens){








  @Override
  public List<RetailStoreMember> searchRetailStoreMemberList(RetailscmUserContext ctx, RetailStoreMemberRequest pRequest){
      pRequest.setUserContext(ctx);
      List<RetailStoreMember> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public RetailStoreMember searchRetailStoreMember(RetailscmUserContext ctx, RetailStoreMemberRequest pRequest){
    pRequest.limit(0, 1);
    List<RetailStoreMember> list = searchRetailStoreMemberList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public RetailStoreMember createRetailStoreMember(RetailscmUserContext userContext, String name,String mobilePhone,String ownerId) throws Exception
	{





		checkerOf(userContext).checkNameOfRetailStoreMember(name);
		checkerOf(userContext).checkMobilePhoneOfRetailStoreMember(mobilePhone);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);



		RetailStoreMember retailStoreMember=createNewRetailStoreMember();	

		retailStoreMember.setName(name);
		retailStoreMember.setMobilePhone(mobilePhone);
			
		RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(userContext, ownerId,emptyOptions());
		retailStoreMember.setOwner(owner);
		
		

		retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreMember);
		return retailStoreMember;


	}
	protected RetailStoreMember createNewRetailStoreMember()
	{

		return new RetailStoreMember();
	}

	protected void checkParamsForUpdatingRetailStoreMember(RetailscmUserContext userContext,String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkVersionOfRetailStoreMember( retailStoreMemberVersion);


		if(RetailStoreMember.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfRetailStoreMember(parseString(newValueExpr));
		

		}
		if(RetailStoreMember.MOBILE_PHONE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMobilePhoneOfRetailStoreMember(parseString(newValueExpr));
		

		}

		


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);



	}



	public RetailStoreMember clone(RetailscmUserContext userContext, String fromRetailStoreMemberId) throws Exception{

		return retailStoreMemberDaoOf(userContext).clone(fromRetailStoreMemberId, this.allTokens());
	}

	public RetailStoreMember internalSaveRetailStoreMember(RetailscmUserContext userContext, RetailStoreMember retailStoreMember) throws Exception
	{
		return internalSaveRetailStoreMember(userContext, retailStoreMember, allTokens());

	}
	public RetailStoreMember internalSaveRetailStoreMember(RetailscmUserContext userContext, RetailStoreMember retailStoreMember, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRetailStoreMember(userContext, retailStoreMemberId, retailStoreMemberVersion, property, newValueExpr, tokensExpr);


		synchronized(retailStoreMember){
			//will be good when the retailStoreMember loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMember.
			if (retailStoreMember.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixRetailStoreMember(retailStoreMember);
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, options);
			return retailStoreMember;

		}

	}

	public RetailStoreMember updateRetailStoreMember(RetailscmUserContext userContext,String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreMember(userContext, retailStoreMemberId, retailStoreMemberVersion, property, newValueExpr, tokensExpr);



		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		if(retailStoreMember.getVersion() != retailStoreMemberVersion){
			String message = "The target version("+retailStoreMember.getVersion()+") is not equals to version("+retailStoreMemberVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreMember){
			//will be good when the retailStoreMember loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMember.
			
			retailStoreMember.changeProperty(property, newValueExpr);
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMember(userContext, retailStoreMember, tokens().done());
		}

	}

	public RetailStoreMember updateRetailStoreMemberProperty(RetailscmUserContext userContext,String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreMember(userContext, retailStoreMemberId, retailStoreMemberVersion, property, newValueExpr, tokensExpr);

		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		if(retailStoreMember.getVersion() != retailStoreMemberVersion){
			String message = "The target version("+retailStoreMember.getVersion()+") is not equals to version("+retailStoreMemberVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreMember){
			//will be good when the retailStoreMember loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMember.

			retailStoreMember.changeProperty(property, newValueExpr);
			
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().done());
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMember(userContext, retailStoreMember, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RetailStoreMemberTokens tokens(){
		return RetailStoreMemberTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreMemberTokens.all();
	}
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortConsumerOrderListWith(ConsumerOrder.ID_PROPERTY,sortDesc())
		.sortRetailStoreMemberCouponListWith(RetailStoreMemberCoupon.ID_PROPERTY,sortDesc())
		.sortMemberWishlistListWith(MemberWishlist.ID_PROPERTY,sortDesc())
		.sortMemberRewardPointListWith(MemberRewardPoint.ID_PROPERTY,sortDesc())
		.sortMemberRewardPointRedemptionListWith(MemberRewardPointRedemption.ID_PROPERTY,sortDesc())
		.sortRetailStoreMemberAddressListWith(RetailStoreMemberAddress.ID_PROPERTY,sortDesc())
		.sortRetailStoreMemberGiftCardListWith(RetailStoreMemberGiftCard.ID_PROPERTY,sortDesc())
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreMemberTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(RetailscmUserContext userContext, String retailStoreMemberId, String anotherOwnerId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherOwnerId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

 	}
 	public RetailStoreMember transferToAnotherOwner(RetailscmUserContext userContext, String retailStoreMemberId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, retailStoreMemberId,anotherOwnerId);
 
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//will be good when the retailStoreMember loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(userContext, anotherOwnerId, emptyOptions());
			retailStoreMember.updateOwner(owner);
			
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, emptyOptions());

			return present(userContext,retailStoreMember, allTokens());

		}

 	}

	


	public CandidateRetailStoreCountryCenter requestCandidateOwner(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreCountryCenter result = new CandidateRetailStoreCountryCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForRetailStoreMember(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newOwnerId, Map<String,Object> options) throws Exception
 	{
    
 		return retailStoreCountryCenterDaoOf(userContext).load(newOwnerId, options);
 	  
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreMemberId, int retailStoreMemberVersion) throws Exception {
		//deleteInternal(userContext, retailStoreMemberId, retailStoreMemberVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreMemberId, int retailStoreMemberVersion) throws Exception{

		retailStoreMemberDaoOf(userContext).delete(retailStoreMemberId, retailStoreMemberVersion);
	}

	public RetailStoreMember forgetByAll(RetailscmUserContext userContext, String retailStoreMemberId, int retailStoreMemberVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreMemberId, retailStoreMemberVersion);
	}
	protected RetailStoreMember forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreMemberId, int retailStoreMemberVersion) throws Exception{

		return retailStoreMemberDaoOf(userContext).disconnectFromAll(retailStoreMemberId, retailStoreMemberVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreMemberManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return retailStoreMemberDaoOf(userContext).deleteAll();
	}





	protected void checkParamsForAddingConsumerOrder(RetailscmUserContext userContext, String retailStoreMemberId, String title, String storeId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);


		checkerOf(userContext).checkTitleOfConsumerOrder(title);

		checkerOf(userContext).checkStoreIdOfConsumerOrder(storeId);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);



	}
	public  RetailStoreMember addConsumerOrder(RetailscmUserContext userContext, String retailStoreMemberId, String title, String storeId, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingConsumerOrder(userContext,retailStoreMemberId,title, storeId,tokensExpr);

		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, storeId);

		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, emptyOptions());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addConsumerOrder( consumerOrder );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
			
			consumerOrderManagerOf(userContext).onNewInstanceCreated(userContext, consumerOrder);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderProperties(RetailscmUserContext userContext, String retailStoreMemberId,String id,String title,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfConsumerOrder(id);

		checkerOf(userContext).checkTitleOfConsumerOrder( title);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember updateConsumerOrderProperties(RetailscmUserContext userContext, String retailStoreMemberId, String id,String title, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderProperties(userContext,retailStoreMemberId,id,title,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderListList()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, tokens().is(), id).done();

		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);

		if(retailStoreMemberToUpdate.getConsumerOrderList().isEmpty()){
			throw new RetailStoreMemberManagerException("ConsumerOrder is NOT FOUND with id: '"+id+"'");
		}

		ConsumerOrder item = retailStoreMemberToUpdate.getConsumerOrderList().first();
		beforeUpdateConsumerOrderProperties(userContext,item, retailStoreMemberId,id,title,tokensExpr);
		item.updateTitle( title );


		//checkParamsForAddingConsumerOrder(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withConsumerOrderList().done());
		synchronized(retailStoreMember){
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateConsumerOrderProperties(RetailscmUserContext userContext, ConsumerOrder item, String retailStoreMemberId, String id,String title, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected ConsumerOrder createConsumerOrder(RetailscmUserContext userContext, String title, String storeId) throws Exception{

		ConsumerOrder consumerOrder = new ConsumerOrder();
		
		
		consumerOrder.setTitle(title);		
		RetailStore  store = new RetailStore();
		store.setId(storeId);		
		consumerOrder.setStore(store);		
		consumerOrder.setLastUpdateTime(userContext.now());
	
		
		return consumerOrder;


	}

	protected ConsumerOrder createIndexedConsumerOrder(String id, int version){

		ConsumerOrder consumerOrder = new ConsumerOrder();
		consumerOrder.setId(id);
		consumerOrder.setVersion(version);
		return consumerOrder;

	}

	protected void checkParamsForRemovingConsumerOrderList(RetailscmUserContext userContext, String retailStoreMemberId,
			String consumerOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String consumerOrderIdItem: consumerOrderIds){
			checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeConsumerOrderList(RetailscmUserContext userContext, String retailStoreMemberId,
			String consumerOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingConsumerOrderList(userContext, retailStoreMemberId,  consumerOrderIds, tokensExpr);


			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreMemberDaoOf(userContext).planToRemoveConsumerOrderList(retailStoreMember, consumerOrderIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getConsumerOrderList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingConsumerOrder(RetailscmUserContext userContext, String retailStoreMemberId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember removeConsumerOrder(RetailscmUserContext userContext, String retailStoreMemberId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingConsumerOrder(userContext,retailStoreMemberId, consumerOrderId, consumerOrderVersion,tokensExpr);

		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeConsumerOrder( consumerOrder );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
			deleteRelationInGraph(userContext, consumerOrder);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingConsumerOrder(RetailscmUserContext userContext, String retailStoreMemberId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember copyConsumerOrderFrom(RetailscmUserContext userContext, String retailStoreMemberId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingConsumerOrder(userContext,retailStoreMemberId, consumerOrderId, consumerOrderVersion,tokensExpr);

		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			consumerOrder.updateLastUpdateTime(userContext.now());

			retailStoreMember.copyConsumerOrderFrom( consumerOrder );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
			
			consumerOrderManagerOf(userContext).onNewInstanceCreated(userContext, (ConsumerOrder)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingConsumerOrder(RetailscmUserContext userContext, String retailStoreMemberId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);


		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
			checkerOf(userContext).checkTitleOfConsumerOrder(parseString(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}

	public  RetailStoreMember updateConsumerOrder(RetailscmUserContext userContext, String retailStoreMemberId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingConsumerOrder(userContext, retailStoreMemberId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withConsumerOrderList().searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, tokens().equals(), consumerOrderId).done();



		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);

		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeConsumerOrder( consumerOrder );
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIdVersionKey = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);

			ConsumerOrder consumerOrder = retailStoreMember.findTheConsumerOrder(consumerOrderIdVersionKey);
			if(consumerOrder == null){
				throw new RetailStoreMemberManagerException(consumerOrderId+" is NOT FOUND" );
			}

			beforeUpdateConsumerOrder(userContext, consumerOrder, retailStoreMemberId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);
			consumerOrder.changeProperty(property, newValueExpr);
			consumerOrder.updateLastUpdateTime(userContext.now());
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withConsumerOrderList().done());
			consumerOrderManagerOf(userContext).onUpdated(userContext, consumerOrder, this, "updateConsumerOrder");
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateConsumerOrder(RetailscmUserContext userContext, ConsumerOrder existed, String retailStoreMemberId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	protected void checkParamsForAddingRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberId, String name, String number,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);


		checkerOf(userContext).checkNameOfRetailStoreMemberCoupon(name);

		checkerOf(userContext).checkNumberOfRetailStoreMemberCoupon(number);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);



	}
	public  RetailStoreMember addRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberId, String name, String number, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingRetailStoreMemberCoupon(userContext,retailStoreMemberId,name, number,tokensExpr);

		RetailStoreMemberCoupon retailStoreMemberCoupon = createRetailStoreMemberCoupon(userContext,name, number);

		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, emptyOptions());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addRetailStoreMemberCoupon( retailStoreMemberCoupon );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberCouponList().done());
			
			retailStoreMemberCouponManagerOf(userContext).onNewInstanceCreated(userContext, retailStoreMemberCoupon);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreMemberCouponProperties(RetailscmUserContext userContext, String retailStoreMemberId,String id,String name,String number,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberCoupon(id);

		checkerOf(userContext).checkNameOfRetailStoreMemberCoupon( name);
		checkerOf(userContext).checkNumberOfRetailStoreMemberCoupon( number);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember updateRetailStoreMemberCouponProperties(RetailscmUserContext userContext, String retailStoreMemberId, String id,String name,String number, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreMemberCouponProperties(userContext,retailStoreMemberId,id,name,number,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreMemberCouponListList()
				.searchRetailStoreMemberCouponListWith(RetailStoreMemberCoupon.ID_PROPERTY, tokens().is(), id).done();

		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);

		if(retailStoreMemberToUpdate.getRetailStoreMemberCouponList().isEmpty()){
			throw new RetailStoreMemberManagerException("RetailStoreMemberCoupon is NOT FOUND with id: '"+id+"'");
		}

		RetailStoreMemberCoupon item = retailStoreMemberToUpdate.getRetailStoreMemberCouponList().first();
		beforeUpdateRetailStoreMemberCouponProperties(userContext,item, retailStoreMemberId,id,name,number,tokensExpr);
		item.updateName( name );
		item.updateNumber( number );


		//checkParamsForAddingRetailStoreMemberCoupon(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withRetailStoreMemberCouponList().done());
		synchronized(retailStoreMember){
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateRetailStoreMemberCouponProperties(RetailscmUserContext userContext, RetailStoreMemberCoupon item, String retailStoreMemberId, String id,String name,String number, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected RetailStoreMemberCoupon createRetailStoreMemberCoupon(RetailscmUserContext userContext, String name, String number) throws Exception{

		RetailStoreMemberCoupon retailStoreMemberCoupon = new RetailStoreMemberCoupon();
		
		
		retailStoreMemberCoupon.setName(name);		
		retailStoreMemberCoupon.setNumber(number);		
		retailStoreMemberCoupon.setLastUpdateTime(userContext.now());
	
		
		return retailStoreMemberCoupon;


	}

	protected RetailStoreMemberCoupon createIndexedRetailStoreMemberCoupon(String id, int version){

		RetailStoreMemberCoupon retailStoreMemberCoupon = new RetailStoreMemberCoupon();
		retailStoreMemberCoupon.setId(id);
		retailStoreMemberCoupon.setVersion(version);
		return retailStoreMemberCoupon;

	}

	protected void checkParamsForRemovingRetailStoreMemberCouponList(RetailscmUserContext userContext, String retailStoreMemberId,
			String retailStoreMemberCouponIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String retailStoreMemberCouponIdItem: retailStoreMemberCouponIds){
			checkerOf(userContext).checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeRetailStoreMemberCouponList(RetailscmUserContext userContext, String retailStoreMemberId,
			String retailStoreMemberCouponIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreMemberCouponList(userContext, retailStoreMemberId,  retailStoreMemberCouponIds, tokensExpr);


			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreMemberDaoOf(userContext).planToRemoveRetailStoreMemberCouponList(retailStoreMember, retailStoreMemberCouponIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberCouponList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getRetailStoreMemberCouponList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberCouponId, int retailStoreMemberCouponVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberCoupon(retailStoreMemberCouponVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember removeRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberCouponId, int retailStoreMemberCouponVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStoreMemberCoupon(userContext,retailStoreMemberId, retailStoreMemberCouponId, retailStoreMemberCouponVersion,tokensExpr);

		RetailStoreMemberCoupon retailStoreMemberCoupon = createIndexedRetailStoreMemberCoupon(retailStoreMemberCouponId, retailStoreMemberCouponVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeRetailStoreMemberCoupon( retailStoreMemberCoupon );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberCouponList().done());
			deleteRelationInGraph(userContext, retailStoreMemberCoupon);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberCouponId, int retailStoreMemberCouponVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberCoupon(retailStoreMemberCouponVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember copyRetailStoreMemberCouponFrom(RetailscmUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberCouponId, int retailStoreMemberCouponVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStoreMemberCoupon(userContext,retailStoreMemberId, retailStoreMemberCouponId, retailStoreMemberCouponVersion,tokensExpr);

		RetailStoreMemberCoupon retailStoreMemberCoupon = createIndexedRetailStoreMemberCoupon(retailStoreMemberCouponId, retailStoreMemberCouponVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			retailStoreMemberCoupon.updateLastUpdateTime(userContext.now());

			retailStoreMember.copyRetailStoreMemberCouponFrom( retailStoreMemberCoupon );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberCouponList().done());
			
			retailStoreMemberCouponManagerOf(userContext).onNewInstanceCreated(userContext, (RetailStoreMemberCoupon)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberId, String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberCoupon(retailStoreMemberCouponId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberCoupon(retailStoreMemberCouponVersion);


		if(RetailStoreMemberCoupon.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfRetailStoreMemberCoupon(parseString(newValueExpr));
		}
		
		if(RetailStoreMemberCoupon.NUMBER_PROPERTY.equals(property)){
			checkerOf(userContext).checkNumberOfRetailStoreMemberCoupon(parseString(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}

	public  RetailStoreMember updateRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberId, String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStoreMemberCoupon(userContext, retailStoreMemberId, retailStoreMemberCouponId, retailStoreMemberCouponVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreMemberCouponList().searchRetailStoreMemberCouponListWith(RetailStoreMemberCoupon.ID_PROPERTY, tokens().equals(), retailStoreMemberCouponId).done();



		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);

		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeRetailStoreMemberCoupon( retailStoreMemberCoupon );
			//make changes to AcceleraterAccount.
			RetailStoreMemberCoupon retailStoreMemberCouponIdVersionKey = createIndexedRetailStoreMemberCoupon(retailStoreMemberCouponId, retailStoreMemberCouponVersion);

			RetailStoreMemberCoupon retailStoreMemberCoupon = retailStoreMember.findTheRetailStoreMemberCoupon(retailStoreMemberCouponIdVersionKey);
			if(retailStoreMemberCoupon == null){
				throw new RetailStoreMemberManagerException(retailStoreMemberCouponId+" is NOT FOUND" );
			}

			beforeUpdateRetailStoreMemberCoupon(userContext, retailStoreMemberCoupon, retailStoreMemberId, retailStoreMemberCouponId, retailStoreMemberCouponVersion, property, newValueExpr,  tokensExpr);
			retailStoreMemberCoupon.changeProperty(property, newValueExpr);
			retailStoreMemberCoupon.updateLastUpdateTime(userContext.now());
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberCouponList().done());
			retailStoreMemberCouponManagerOf(userContext).onUpdated(userContext, retailStoreMemberCoupon, this, "updateRetailStoreMemberCoupon");
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateRetailStoreMemberCoupon(RetailscmUserContext userContext, RetailStoreMemberCoupon existed, String retailStoreMemberId, String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	protected void checkParamsForAddingMemberWishlist(RetailscmUserContext userContext, String retailStoreMemberId, String name,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);


		checkerOf(userContext).checkNameOfMemberWishlist(name);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);



	}
	public  RetailStoreMember addMemberWishlist(RetailscmUserContext userContext, String retailStoreMemberId, String name, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingMemberWishlist(userContext,retailStoreMemberId,name,tokensExpr);

		MemberWishlist memberWishlist = createMemberWishlist(userContext,name);

		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, emptyOptions());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addMemberWishlist( memberWishlist );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberWishlistList().done());
			
			memberWishlistManagerOf(userContext).onNewInstanceCreated(userContext, memberWishlist);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingMemberWishlistProperties(RetailscmUserContext userContext, String retailStoreMemberId,String id,String name,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberWishlist(id);

		checkerOf(userContext).checkNameOfMemberWishlist( name);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember updateMemberWishlistProperties(RetailscmUserContext userContext, String retailStoreMemberId, String id,String name, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingMemberWishlistProperties(userContext,retailStoreMemberId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withMemberWishlistListList()
				.searchMemberWishlistListWith(MemberWishlist.ID_PROPERTY, tokens().is(), id).done();

		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);

		if(retailStoreMemberToUpdate.getMemberWishlistList().isEmpty()){
			throw new RetailStoreMemberManagerException("MemberWishlist is NOT FOUND with id: '"+id+"'");
		}

		MemberWishlist item = retailStoreMemberToUpdate.getMemberWishlistList().first();
		beforeUpdateMemberWishlistProperties(userContext,item, retailStoreMemberId,id,name,tokensExpr);
		item.updateName( name );


		//checkParamsForAddingMemberWishlist(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withMemberWishlistList().done());
		synchronized(retailStoreMember){
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateMemberWishlistProperties(RetailscmUserContext userContext, MemberWishlist item, String retailStoreMemberId, String id,String name, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected MemberWishlist createMemberWishlist(RetailscmUserContext userContext, String name) throws Exception{

		MemberWishlist memberWishlist = new MemberWishlist();
		
		
		memberWishlist.setName(name);
	
		
		return memberWishlist;


	}

	protected MemberWishlist createIndexedMemberWishlist(String id, int version){

		MemberWishlist memberWishlist = new MemberWishlist();
		memberWishlist.setId(id);
		memberWishlist.setVersion(version);
		return memberWishlist;

	}

	protected void checkParamsForRemovingMemberWishlistList(RetailscmUserContext userContext, String retailStoreMemberId,
			String memberWishlistIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String memberWishlistIdItem: memberWishlistIds){
			checkerOf(userContext).checkIdOfMemberWishlist(memberWishlistIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeMemberWishlistList(RetailscmUserContext userContext, String retailStoreMemberId,
			String memberWishlistIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingMemberWishlistList(userContext, retailStoreMemberId,  memberWishlistIds, tokensExpr);


			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreMemberDaoOf(userContext).planToRemoveMemberWishlistList(retailStoreMember, memberWishlistIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberWishlistList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getMemberWishlistList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingMemberWishlist(RetailscmUserContext userContext, String retailStoreMemberId,
		String memberWishlistId, int memberWishlistVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberWishlist(memberWishlistId);
		checkerOf(userContext).checkVersionOfMemberWishlist(memberWishlistVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember removeMemberWishlist(RetailscmUserContext userContext, String retailStoreMemberId,
		String memberWishlistId, int memberWishlistVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingMemberWishlist(userContext,retailStoreMemberId, memberWishlistId, memberWishlistVersion,tokensExpr);

		MemberWishlist memberWishlist = createIndexedMemberWishlist(memberWishlistId, memberWishlistVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeMemberWishlist( memberWishlist );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberWishlistList().done());
			deleteRelationInGraph(userContext, memberWishlist);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingMemberWishlist(RetailscmUserContext userContext, String retailStoreMemberId,
		String memberWishlistId, int memberWishlistVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberWishlist(memberWishlistId);
		checkerOf(userContext).checkVersionOfMemberWishlist(memberWishlistVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember copyMemberWishlistFrom(RetailscmUserContext userContext, String retailStoreMemberId,
		String memberWishlistId, int memberWishlistVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingMemberWishlist(userContext,retailStoreMemberId, memberWishlistId, memberWishlistVersion,tokensExpr);

		MemberWishlist memberWishlist = createIndexedMemberWishlist(memberWishlistId, memberWishlistVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreMember.copyMemberWishlistFrom( memberWishlist );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberWishlistList().done());
			
			memberWishlistManagerOf(userContext).onNewInstanceCreated(userContext, (MemberWishlist)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingMemberWishlist(RetailscmUserContext userContext, String retailStoreMemberId, String memberWishlistId, int memberWishlistVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberWishlist(memberWishlistId);
		checkerOf(userContext).checkVersionOfMemberWishlist(memberWishlistVersion);


		if(MemberWishlist.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfMemberWishlist(parseString(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}

	public  RetailStoreMember updateMemberWishlist(RetailscmUserContext userContext, String retailStoreMemberId, String memberWishlistId, int memberWishlistVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingMemberWishlist(userContext, retailStoreMemberId, memberWishlistId, memberWishlistVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withMemberWishlistList().searchMemberWishlistListWith(MemberWishlist.ID_PROPERTY, tokens().equals(), memberWishlistId).done();



		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);

		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeMemberWishlist( memberWishlist );
			//make changes to AcceleraterAccount.
			MemberWishlist memberWishlistIdVersionKey = createIndexedMemberWishlist(memberWishlistId, memberWishlistVersion);

			MemberWishlist memberWishlist = retailStoreMember.findTheMemberWishlist(memberWishlistIdVersionKey);
			if(memberWishlist == null){
				throw new RetailStoreMemberManagerException(memberWishlistId+" is NOT FOUND" );
			}

			beforeUpdateMemberWishlist(userContext, memberWishlist, retailStoreMemberId, memberWishlistId, memberWishlistVersion, property, newValueExpr,  tokensExpr);
			memberWishlist.changeProperty(property, newValueExpr);
			
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberWishlistList().done());
			memberWishlistManagerOf(userContext).onUpdated(userContext, memberWishlist, this, "updateMemberWishlist");
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateMemberWishlist(RetailscmUserContext userContext, MemberWishlist existed, String retailStoreMemberId, String memberWishlistId, int memberWishlistVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	protected void checkParamsForAddingMemberRewardPoint(RetailscmUserContext userContext, String retailStoreMemberId, String name, int point,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);


		checkerOf(userContext).checkNameOfMemberRewardPoint(name);

		checkerOf(userContext).checkPointOfMemberRewardPoint(point);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);



	}
	public  RetailStoreMember addMemberRewardPoint(RetailscmUserContext userContext, String retailStoreMemberId, String name, int point, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingMemberRewardPoint(userContext,retailStoreMemberId,name, point,tokensExpr);

		MemberRewardPoint memberRewardPoint = createMemberRewardPoint(userContext,name, point);

		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, emptyOptions());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addMemberRewardPoint( memberRewardPoint );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointList().done());
			
			memberRewardPointManagerOf(userContext).onNewInstanceCreated(userContext, memberRewardPoint);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingMemberRewardPointProperties(RetailscmUserContext userContext, String retailStoreMemberId,String id,String name,int point,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberRewardPoint(id);

		checkerOf(userContext).checkNameOfMemberRewardPoint( name);
		checkerOf(userContext).checkPointOfMemberRewardPoint( point);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember updateMemberRewardPointProperties(RetailscmUserContext userContext, String retailStoreMemberId, String id,String name,int point, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingMemberRewardPointProperties(userContext,retailStoreMemberId,id,name,point,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withMemberRewardPointListList()
				.searchMemberRewardPointListWith(MemberRewardPoint.ID_PROPERTY, tokens().is(), id).done();

		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);

		if(retailStoreMemberToUpdate.getMemberRewardPointList().isEmpty()){
			throw new RetailStoreMemberManagerException("MemberRewardPoint is NOT FOUND with id: '"+id+"'");
		}

		MemberRewardPoint item = retailStoreMemberToUpdate.getMemberRewardPointList().first();
		beforeUpdateMemberRewardPointProperties(userContext,item, retailStoreMemberId,id,name,point,tokensExpr);
		item.updateName( name );
		item.updatePoint( point );


		//checkParamsForAddingMemberRewardPoint(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withMemberRewardPointList().done());
		synchronized(retailStoreMember){
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateMemberRewardPointProperties(RetailscmUserContext userContext, MemberRewardPoint item, String retailStoreMemberId, String id,String name,int point, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected MemberRewardPoint createMemberRewardPoint(RetailscmUserContext userContext, String name, int point) throws Exception{

		MemberRewardPoint memberRewardPoint = new MemberRewardPoint();
		
		
		memberRewardPoint.setName(name);		
		memberRewardPoint.setPoint(point);
	
		
		return memberRewardPoint;


	}

	protected MemberRewardPoint createIndexedMemberRewardPoint(String id, int version){

		MemberRewardPoint memberRewardPoint = new MemberRewardPoint();
		memberRewardPoint.setId(id);
		memberRewardPoint.setVersion(version);
		return memberRewardPoint;

	}

	protected void checkParamsForRemovingMemberRewardPointList(RetailscmUserContext userContext, String retailStoreMemberId,
			String memberRewardPointIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String memberRewardPointIdItem: memberRewardPointIds){
			checkerOf(userContext).checkIdOfMemberRewardPoint(memberRewardPointIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeMemberRewardPointList(RetailscmUserContext userContext, String retailStoreMemberId,
			String memberRewardPointIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingMemberRewardPointList(userContext, retailStoreMemberId,  memberRewardPointIds, tokensExpr);


			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreMemberDaoOf(userContext).planToRemoveMemberRewardPointList(retailStoreMember, memberRewardPointIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getMemberRewardPointList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingMemberRewardPoint(RetailscmUserContext userContext, String retailStoreMemberId,
		String memberRewardPointId, int memberRewardPointVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberRewardPoint(memberRewardPointId);
		checkerOf(userContext).checkVersionOfMemberRewardPoint(memberRewardPointVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember removeMemberRewardPoint(RetailscmUserContext userContext, String retailStoreMemberId,
		String memberRewardPointId, int memberRewardPointVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingMemberRewardPoint(userContext,retailStoreMemberId, memberRewardPointId, memberRewardPointVersion,tokensExpr);

		MemberRewardPoint memberRewardPoint = createIndexedMemberRewardPoint(memberRewardPointId, memberRewardPointVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeMemberRewardPoint( memberRewardPoint );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointList().done());
			deleteRelationInGraph(userContext, memberRewardPoint);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingMemberRewardPoint(RetailscmUserContext userContext, String retailStoreMemberId,
		String memberRewardPointId, int memberRewardPointVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberRewardPoint(memberRewardPointId);
		checkerOf(userContext).checkVersionOfMemberRewardPoint(memberRewardPointVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember copyMemberRewardPointFrom(RetailscmUserContext userContext, String retailStoreMemberId,
		String memberRewardPointId, int memberRewardPointVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingMemberRewardPoint(userContext,retailStoreMemberId, memberRewardPointId, memberRewardPointVersion,tokensExpr);

		MemberRewardPoint memberRewardPoint = createIndexedMemberRewardPoint(memberRewardPointId, memberRewardPointVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreMember.copyMemberRewardPointFrom( memberRewardPoint );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointList().done());
			
			memberRewardPointManagerOf(userContext).onNewInstanceCreated(userContext, (MemberRewardPoint)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingMemberRewardPoint(RetailscmUserContext userContext, String retailStoreMemberId, String memberRewardPointId, int memberRewardPointVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberRewardPoint(memberRewardPointId);
		checkerOf(userContext).checkVersionOfMemberRewardPoint(memberRewardPointVersion);


		if(MemberRewardPoint.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfMemberRewardPoint(parseString(newValueExpr));
		}
		
		if(MemberRewardPoint.POINT_PROPERTY.equals(property)){
			checkerOf(userContext).checkPointOfMemberRewardPoint(parseInt(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}

	public  RetailStoreMember updateMemberRewardPoint(RetailscmUserContext userContext, String retailStoreMemberId, String memberRewardPointId, int memberRewardPointVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingMemberRewardPoint(userContext, retailStoreMemberId, memberRewardPointId, memberRewardPointVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withMemberRewardPointList().searchMemberRewardPointListWith(MemberRewardPoint.ID_PROPERTY, tokens().equals(), memberRewardPointId).done();



		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);

		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeMemberRewardPoint( memberRewardPoint );
			//make changes to AcceleraterAccount.
			MemberRewardPoint memberRewardPointIdVersionKey = createIndexedMemberRewardPoint(memberRewardPointId, memberRewardPointVersion);

			MemberRewardPoint memberRewardPoint = retailStoreMember.findTheMemberRewardPoint(memberRewardPointIdVersionKey);
			if(memberRewardPoint == null){
				throw new RetailStoreMemberManagerException(memberRewardPointId+" is NOT FOUND" );
			}

			beforeUpdateMemberRewardPoint(userContext, memberRewardPoint, retailStoreMemberId, memberRewardPointId, memberRewardPointVersion, property, newValueExpr,  tokensExpr);
			memberRewardPoint.changeProperty(property, newValueExpr);
			
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointList().done());
			memberRewardPointManagerOf(userContext).onUpdated(userContext, memberRewardPoint, this, "updateMemberRewardPoint");
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateMemberRewardPoint(RetailscmUserContext userContext, MemberRewardPoint existed, String retailStoreMemberId, String memberRewardPointId, int memberRewardPointVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	protected void checkParamsForAddingMemberRewardPointRedemption(RetailscmUserContext userContext, String retailStoreMemberId, String name, int point,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);


		checkerOf(userContext).checkNameOfMemberRewardPointRedemption(name);

		checkerOf(userContext).checkPointOfMemberRewardPointRedemption(point);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);



	}
	public  RetailStoreMember addMemberRewardPointRedemption(RetailscmUserContext userContext, String retailStoreMemberId, String name, int point, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingMemberRewardPointRedemption(userContext,retailStoreMemberId,name, point,tokensExpr);

		MemberRewardPointRedemption memberRewardPointRedemption = createMemberRewardPointRedemption(userContext,name, point);

		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, emptyOptions());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addMemberRewardPointRedemption( memberRewardPointRedemption );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointRedemptionList().done());
			
			memberRewardPointRedemptionManagerOf(userContext).onNewInstanceCreated(userContext, memberRewardPointRedemption);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingMemberRewardPointRedemptionProperties(RetailscmUserContext userContext, String retailStoreMemberId,String id,String name,int point,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberRewardPointRedemption(id);

		checkerOf(userContext).checkNameOfMemberRewardPointRedemption( name);
		checkerOf(userContext).checkPointOfMemberRewardPointRedemption( point);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember updateMemberRewardPointRedemptionProperties(RetailscmUserContext userContext, String retailStoreMemberId, String id,String name,int point, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingMemberRewardPointRedemptionProperties(userContext,retailStoreMemberId,id,name,point,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withMemberRewardPointRedemptionListList()
				.searchMemberRewardPointRedemptionListWith(MemberRewardPointRedemption.ID_PROPERTY, tokens().is(), id).done();

		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);

		if(retailStoreMemberToUpdate.getMemberRewardPointRedemptionList().isEmpty()){
			throw new RetailStoreMemberManagerException("MemberRewardPointRedemption is NOT FOUND with id: '"+id+"'");
		}

		MemberRewardPointRedemption item = retailStoreMemberToUpdate.getMemberRewardPointRedemptionList().first();
		beforeUpdateMemberRewardPointRedemptionProperties(userContext,item, retailStoreMemberId,id,name,point,tokensExpr);
		item.updateName( name );
		item.updatePoint( point );


		//checkParamsForAddingMemberRewardPointRedemption(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withMemberRewardPointRedemptionList().done());
		synchronized(retailStoreMember){
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateMemberRewardPointRedemptionProperties(RetailscmUserContext userContext, MemberRewardPointRedemption item, String retailStoreMemberId, String id,String name,int point, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected MemberRewardPointRedemption createMemberRewardPointRedemption(RetailscmUserContext userContext, String name, int point) throws Exception{

		MemberRewardPointRedemption memberRewardPointRedemption = new MemberRewardPointRedemption();
		
		
		memberRewardPointRedemption.setName(name);		
		memberRewardPointRedemption.setPoint(point);
	
		
		return memberRewardPointRedemption;


	}

	protected MemberRewardPointRedemption createIndexedMemberRewardPointRedemption(String id, int version){

		MemberRewardPointRedemption memberRewardPointRedemption = new MemberRewardPointRedemption();
		memberRewardPointRedemption.setId(id);
		memberRewardPointRedemption.setVersion(version);
		return memberRewardPointRedemption;

	}

	protected void checkParamsForRemovingMemberRewardPointRedemptionList(RetailscmUserContext userContext, String retailStoreMemberId,
			String memberRewardPointRedemptionIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String memberRewardPointRedemptionIdItem: memberRewardPointRedemptionIds){
			checkerOf(userContext).checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeMemberRewardPointRedemptionList(RetailscmUserContext userContext, String retailStoreMemberId,
			String memberRewardPointRedemptionIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingMemberRewardPointRedemptionList(userContext, retailStoreMemberId,  memberRewardPointRedemptionIds, tokensExpr);


			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreMemberDaoOf(userContext).planToRemoveMemberRewardPointRedemptionList(retailStoreMember, memberRewardPointRedemptionIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointRedemptionList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getMemberRewardPointRedemptionList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingMemberRewardPointRedemption(RetailscmUserContext userContext, String retailStoreMemberId,
		String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionId);
		checkerOf(userContext).checkVersionOfMemberRewardPointRedemption(memberRewardPointRedemptionVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember removeMemberRewardPointRedemption(RetailscmUserContext userContext, String retailStoreMemberId,
		String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingMemberRewardPointRedemption(userContext,retailStoreMemberId, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion,tokensExpr);

		MemberRewardPointRedemption memberRewardPointRedemption = createIndexedMemberRewardPointRedemption(memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeMemberRewardPointRedemption( memberRewardPointRedemption );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointRedemptionList().done());
			deleteRelationInGraph(userContext, memberRewardPointRedemption);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingMemberRewardPointRedemption(RetailscmUserContext userContext, String retailStoreMemberId,
		String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionId);
		checkerOf(userContext).checkVersionOfMemberRewardPointRedemption(memberRewardPointRedemptionVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember copyMemberRewardPointRedemptionFrom(RetailscmUserContext userContext, String retailStoreMemberId,
		String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingMemberRewardPointRedemption(userContext,retailStoreMemberId, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion,tokensExpr);

		MemberRewardPointRedemption memberRewardPointRedemption = createIndexedMemberRewardPointRedemption(memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreMember.copyMemberRewardPointRedemptionFrom( memberRewardPointRedemption );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointRedemptionList().done());
			
			memberRewardPointRedemptionManagerOf(userContext).onNewInstanceCreated(userContext, (MemberRewardPointRedemption)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingMemberRewardPointRedemption(RetailscmUserContext userContext, String retailStoreMemberId, String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfMemberRewardPointRedemption(memberRewardPointRedemptionId);
		checkerOf(userContext).checkVersionOfMemberRewardPointRedemption(memberRewardPointRedemptionVersion);


		if(MemberRewardPointRedemption.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfMemberRewardPointRedemption(parseString(newValueExpr));
		}
		
		if(MemberRewardPointRedemption.POINT_PROPERTY.equals(property)){
			checkerOf(userContext).checkPointOfMemberRewardPointRedemption(parseInt(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}

	public  RetailStoreMember updateMemberRewardPointRedemption(RetailscmUserContext userContext, String retailStoreMemberId, String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingMemberRewardPointRedemption(userContext, retailStoreMemberId, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withMemberRewardPointRedemptionList().searchMemberRewardPointRedemptionListWith(MemberRewardPointRedemption.ID_PROPERTY, tokens().equals(), memberRewardPointRedemptionId).done();



		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);

		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeMemberRewardPointRedemption( memberRewardPointRedemption );
			//make changes to AcceleraterAccount.
			MemberRewardPointRedemption memberRewardPointRedemptionIdVersionKey = createIndexedMemberRewardPointRedemption(memberRewardPointRedemptionId, memberRewardPointRedemptionVersion);

			MemberRewardPointRedemption memberRewardPointRedemption = retailStoreMember.findTheMemberRewardPointRedemption(memberRewardPointRedemptionIdVersionKey);
			if(memberRewardPointRedemption == null){
				throw new RetailStoreMemberManagerException(memberRewardPointRedemptionId+" is NOT FOUND" );
			}

			beforeUpdateMemberRewardPointRedemption(userContext, memberRewardPointRedemption, retailStoreMemberId, memberRewardPointRedemptionId, memberRewardPointRedemptionVersion, property, newValueExpr,  tokensExpr);
			memberRewardPointRedemption.changeProperty(property, newValueExpr);
			
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withMemberRewardPointRedemptionList().done());
			memberRewardPointRedemptionManagerOf(userContext).onUpdated(userContext, memberRewardPointRedemption, this, "updateMemberRewardPointRedemption");
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateMemberRewardPointRedemption(RetailscmUserContext userContext, MemberRewardPointRedemption existed, String retailStoreMemberId, String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	protected void checkParamsForAddingRetailStoreMemberAddress(RetailscmUserContext userContext, String retailStoreMemberId, String name, String mobilePhone, String address,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);


		checkerOf(userContext).checkNameOfRetailStoreMemberAddress(name);

		checkerOf(userContext).checkMobilePhoneOfRetailStoreMemberAddress(mobilePhone);

		checkerOf(userContext).checkAddressOfRetailStoreMemberAddress(address);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);



	}
	public  RetailStoreMember addRetailStoreMemberAddress(RetailscmUserContext userContext, String retailStoreMemberId, String name, String mobilePhone, String address, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingRetailStoreMemberAddress(userContext,retailStoreMemberId,name, mobilePhone, address,tokensExpr);

		RetailStoreMemberAddress retailStoreMemberAddress = createRetailStoreMemberAddress(userContext,name, mobilePhone, address);

		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, emptyOptions());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addRetailStoreMemberAddress( retailStoreMemberAddress );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberAddressList().done());
			
			retailStoreMemberAddressManagerOf(userContext).onNewInstanceCreated(userContext, retailStoreMemberAddress);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreMemberAddressProperties(RetailscmUserContext userContext, String retailStoreMemberId,String id,String name,String mobilePhone,String address,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberAddress(id);

		checkerOf(userContext).checkNameOfRetailStoreMemberAddress( name);
		checkerOf(userContext).checkMobilePhoneOfRetailStoreMemberAddress( mobilePhone);
		checkerOf(userContext).checkAddressOfRetailStoreMemberAddress( address);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember updateRetailStoreMemberAddressProperties(RetailscmUserContext userContext, String retailStoreMemberId, String id,String name,String mobilePhone,String address, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreMemberAddressProperties(userContext,retailStoreMemberId,id,name,mobilePhone,address,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreMemberAddressListList()
				.searchRetailStoreMemberAddressListWith(RetailStoreMemberAddress.ID_PROPERTY, tokens().is(), id).done();

		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);

		if(retailStoreMemberToUpdate.getRetailStoreMemberAddressList().isEmpty()){
			throw new RetailStoreMemberManagerException("RetailStoreMemberAddress is NOT FOUND with id: '"+id+"'");
		}

		RetailStoreMemberAddress item = retailStoreMemberToUpdate.getRetailStoreMemberAddressList().first();
		beforeUpdateRetailStoreMemberAddressProperties(userContext,item, retailStoreMemberId,id,name,mobilePhone,address,tokensExpr);
		item.updateName( name );
		item.updateMobilePhone( mobilePhone );
		item.updateAddress( address );


		//checkParamsForAddingRetailStoreMemberAddress(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withRetailStoreMemberAddressList().done());
		synchronized(retailStoreMember){
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateRetailStoreMemberAddressProperties(RetailscmUserContext userContext, RetailStoreMemberAddress item, String retailStoreMemberId, String id,String name,String mobilePhone,String address, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected RetailStoreMemberAddress createRetailStoreMemberAddress(RetailscmUserContext userContext, String name, String mobilePhone, String address) throws Exception{

		RetailStoreMemberAddress retailStoreMemberAddress = new RetailStoreMemberAddress();
		
		
		retailStoreMemberAddress.setName(name);		
		retailStoreMemberAddress.setMobilePhone(mobilePhone);		
		retailStoreMemberAddress.setAddress(address);
	
		
		return retailStoreMemberAddress;


	}

	protected RetailStoreMemberAddress createIndexedRetailStoreMemberAddress(String id, int version){

		RetailStoreMemberAddress retailStoreMemberAddress = new RetailStoreMemberAddress();
		retailStoreMemberAddress.setId(id);
		retailStoreMemberAddress.setVersion(version);
		return retailStoreMemberAddress;

	}

	protected void checkParamsForRemovingRetailStoreMemberAddressList(RetailscmUserContext userContext, String retailStoreMemberId,
			String retailStoreMemberAddressIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String retailStoreMemberAddressIdItem: retailStoreMemberAddressIds){
			checkerOf(userContext).checkIdOfRetailStoreMemberAddress(retailStoreMemberAddressIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeRetailStoreMemberAddressList(RetailscmUserContext userContext, String retailStoreMemberId,
			String retailStoreMemberAddressIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreMemberAddressList(userContext, retailStoreMemberId,  retailStoreMemberAddressIds, tokensExpr);


			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreMemberDaoOf(userContext).planToRemoveRetailStoreMemberAddressList(retailStoreMember, retailStoreMemberAddressIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberAddressList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getRetailStoreMemberAddressList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStoreMemberAddress(RetailscmUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberAddressId, int retailStoreMemberAddressVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberAddress(retailStoreMemberAddressId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberAddress(retailStoreMemberAddressVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember removeRetailStoreMemberAddress(RetailscmUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberAddressId, int retailStoreMemberAddressVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStoreMemberAddress(userContext,retailStoreMemberId, retailStoreMemberAddressId, retailStoreMemberAddressVersion,tokensExpr);

		RetailStoreMemberAddress retailStoreMemberAddress = createIndexedRetailStoreMemberAddress(retailStoreMemberAddressId, retailStoreMemberAddressVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeRetailStoreMemberAddress( retailStoreMemberAddress );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberAddressList().done());
			deleteRelationInGraph(userContext, retailStoreMemberAddress);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStoreMemberAddress(RetailscmUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberAddressId, int retailStoreMemberAddressVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberAddress(retailStoreMemberAddressId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberAddress(retailStoreMemberAddressVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember copyRetailStoreMemberAddressFrom(RetailscmUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberAddressId, int retailStoreMemberAddressVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStoreMemberAddress(userContext,retailStoreMemberId, retailStoreMemberAddressId, retailStoreMemberAddressVersion,tokensExpr);

		RetailStoreMemberAddress retailStoreMemberAddress = createIndexedRetailStoreMemberAddress(retailStoreMemberAddressId, retailStoreMemberAddressVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreMember.copyRetailStoreMemberAddressFrom( retailStoreMemberAddress );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberAddressList().done());
			
			retailStoreMemberAddressManagerOf(userContext).onNewInstanceCreated(userContext, (RetailStoreMemberAddress)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStoreMemberAddress(RetailscmUserContext userContext, String retailStoreMemberId, String retailStoreMemberAddressId, int retailStoreMemberAddressVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberAddress(retailStoreMemberAddressId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberAddress(retailStoreMemberAddressVersion);


		if(RetailStoreMemberAddress.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfRetailStoreMemberAddress(parseString(newValueExpr));
		}
		
		if(RetailStoreMemberAddress.MOBILE_PHONE_PROPERTY.equals(property)){
			checkerOf(userContext).checkMobilePhoneOfRetailStoreMemberAddress(parseString(newValueExpr));
		}
		
		if(RetailStoreMemberAddress.ADDRESS_PROPERTY.equals(property)){
			checkerOf(userContext).checkAddressOfRetailStoreMemberAddress(parseString(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}

	public  RetailStoreMember updateRetailStoreMemberAddress(RetailscmUserContext userContext, String retailStoreMemberId, String retailStoreMemberAddressId, int retailStoreMemberAddressVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStoreMemberAddress(userContext, retailStoreMemberId, retailStoreMemberAddressId, retailStoreMemberAddressVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreMemberAddressList().searchRetailStoreMemberAddressListWith(RetailStoreMemberAddress.ID_PROPERTY, tokens().equals(), retailStoreMemberAddressId).done();



		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);

		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeRetailStoreMemberAddress( retailStoreMemberAddress );
			//make changes to AcceleraterAccount.
			RetailStoreMemberAddress retailStoreMemberAddressIdVersionKey = createIndexedRetailStoreMemberAddress(retailStoreMemberAddressId, retailStoreMemberAddressVersion);

			RetailStoreMemberAddress retailStoreMemberAddress = retailStoreMember.findTheRetailStoreMemberAddress(retailStoreMemberAddressIdVersionKey);
			if(retailStoreMemberAddress == null){
				throw new RetailStoreMemberManagerException(retailStoreMemberAddressId+" is NOT FOUND" );
			}

			beforeUpdateRetailStoreMemberAddress(userContext, retailStoreMemberAddress, retailStoreMemberId, retailStoreMemberAddressId, retailStoreMemberAddressVersion, property, newValueExpr,  tokensExpr);
			retailStoreMemberAddress.changeProperty(property, newValueExpr);
			
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberAddressList().done());
			retailStoreMemberAddressManagerOf(userContext).onUpdated(userContext, retailStoreMemberAddress, this, "updateRetailStoreMemberAddress");
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateRetailStoreMemberAddress(RetailscmUserContext userContext, RetailStoreMemberAddress existed, String retailStoreMemberId, String retailStoreMemberAddressId, int retailStoreMemberAddressVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	protected void checkParamsForAddingRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberId, String name, String number, BigDecimal remain,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);


		checkerOf(userContext).checkNameOfRetailStoreMemberGiftCard(name);

		checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCard(number);

		checkerOf(userContext).checkRemainOfRetailStoreMemberGiftCard(remain);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);



	}
	public  RetailStoreMember addRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberId, String name, String number, BigDecimal remain, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingRetailStoreMemberGiftCard(userContext,retailStoreMemberId,name, number, remain,tokensExpr);

		RetailStoreMemberGiftCard retailStoreMemberGiftCard = createRetailStoreMemberGiftCard(userContext,name, number, remain);

		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, emptyOptions());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.addRetailStoreMemberGiftCard( retailStoreMemberGiftCard );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberGiftCardList().done());
			
			retailStoreMemberGiftCardManagerOf(userContext).onNewInstanceCreated(userContext, retailStoreMemberGiftCard);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreMemberGiftCardProperties(RetailscmUserContext userContext, String retailStoreMemberId,String id,String name,String number,BigDecimal remain,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(id);

		checkerOf(userContext).checkNameOfRetailStoreMemberGiftCard( name);
		checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCard( number);
		checkerOf(userContext).checkRemainOfRetailStoreMemberGiftCard( remain);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember updateRetailStoreMemberGiftCardProperties(RetailscmUserContext userContext, String retailStoreMemberId, String id,String name,String number,BigDecimal remain, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreMemberGiftCardProperties(userContext,retailStoreMemberId,id,name,number,remain,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreMemberGiftCardListList()
				.searchRetailStoreMemberGiftCardListWith(RetailStoreMemberGiftCard.ID_PROPERTY, tokens().is(), id).done();

		RetailStoreMember retailStoreMemberToUpdate = loadRetailStoreMember(userContext, retailStoreMemberId, options);

		if(retailStoreMemberToUpdate.getRetailStoreMemberGiftCardList().isEmpty()){
			throw new RetailStoreMemberManagerException("RetailStoreMemberGiftCard is NOT FOUND with id: '"+id+"'");
		}

		RetailStoreMemberGiftCard item = retailStoreMemberToUpdate.getRetailStoreMemberGiftCardList().first();
		beforeUpdateRetailStoreMemberGiftCardProperties(userContext,item, retailStoreMemberId,id,name,number,remain,tokensExpr);
		item.updateName( name );
		item.updateNumber( number );
		item.updateRemain( remain );


		//checkParamsForAddingRetailStoreMemberGiftCard(userContext,retailStoreMemberId,name, code, used,tokensExpr);
		RetailStoreMember retailStoreMember = saveRetailStoreMember(userContext, retailStoreMemberToUpdate, tokens().withRetailStoreMemberGiftCardList().done());
		synchronized(retailStoreMember){
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateRetailStoreMemberGiftCardProperties(RetailscmUserContext userContext, RetailStoreMemberGiftCard item, String retailStoreMemberId, String id,String name,String number,BigDecimal remain, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected RetailStoreMemberGiftCard createRetailStoreMemberGiftCard(RetailscmUserContext userContext, String name, String number, BigDecimal remain) throws Exception{

		RetailStoreMemberGiftCard retailStoreMemberGiftCard = new RetailStoreMemberGiftCard();
		
		
		retailStoreMemberGiftCard.setName(name);		
		retailStoreMemberGiftCard.setNumber(number);		
		retailStoreMemberGiftCard.setRemain(remain);
	
		
		return retailStoreMemberGiftCard;


	}

	protected RetailStoreMemberGiftCard createIndexedRetailStoreMemberGiftCard(String id, int version){

		RetailStoreMemberGiftCard retailStoreMemberGiftCard = new RetailStoreMemberGiftCard();
		retailStoreMemberGiftCard.setId(id);
		retailStoreMemberGiftCard.setVersion(version);
		return retailStoreMemberGiftCard;

	}

	protected void checkParamsForRemovingRetailStoreMemberGiftCardList(RetailscmUserContext userContext, String retailStoreMemberId,
			String retailStoreMemberGiftCardIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		for(String retailStoreMemberGiftCardIdItem: retailStoreMemberGiftCardIds){
			checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);

	}
	public  RetailStoreMember removeRetailStoreMemberGiftCardList(RetailscmUserContext userContext, String retailStoreMemberId,
			String retailStoreMemberGiftCardIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreMemberGiftCardList(userContext, retailStoreMemberId,  retailStoreMemberGiftCardIds, tokensExpr);


			RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
			synchronized(retailStoreMember){
				//Will be good when the retailStoreMember loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreMemberDaoOf(userContext).planToRemoveRetailStoreMemberGiftCardList(retailStoreMember, retailStoreMemberGiftCardIds, allTokens());
				retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberGiftCardList().done());
				deleteRelationListInGraph(userContext, retailStoreMember.getRetailStoreMemberGiftCardList());
				return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember removeRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStoreMemberGiftCard(userContext,retailStoreMemberId, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion,tokensExpr);

		RetailStoreMemberGiftCard retailStoreMemberGiftCard = createIndexedRetailStoreMemberGiftCard(retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreMember.removeRetailStoreMemberGiftCard( retailStoreMemberGiftCard );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberGiftCardList().done());
			deleteRelationInGraph(userContext, retailStoreMemberGiftCard);
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreMember( retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}
	public  RetailStoreMember copyRetailStoreMemberGiftCardFrom(RetailscmUserContext userContext, String retailStoreMemberId,
		String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStoreMemberGiftCard(userContext,retailStoreMemberId, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion,tokensExpr);

		RetailStoreMemberGiftCard retailStoreMemberGiftCard = createIndexedRetailStoreMemberGiftCard(retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);
		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, allTokens());
		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreMember.copyRetailStoreMemberGiftCardFrom( retailStoreMemberGiftCard );
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberGiftCardList().done());
			
			retailStoreMemberGiftCardManagerOf(userContext).onNewInstanceCreated(userContext, (RetailStoreMemberGiftCard)retailStoreMember.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberId, String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberGiftCard(retailStoreMemberGiftCardVersion);


		if(RetailStoreMemberGiftCard.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfRetailStoreMemberGiftCard(parseString(newValueExpr));
		}
		
		if(RetailStoreMemberGiftCard.NUMBER_PROPERTY.equals(property)){
			checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCard(parseString(newValueExpr));
		}
		
		if(RetailStoreMemberGiftCard.REMAIN_PROPERTY.equals(property)){
			checkerOf(userContext).checkRemainOfRetailStoreMemberGiftCard(parseBigDecimal(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberManagerException.class);


	}

	public  RetailStoreMember updateRetailStoreMemberGiftCard(RetailscmUserContext userContext, String retailStoreMemberId, String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStoreMemberGiftCard(userContext, retailStoreMemberId, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreMemberGiftCardList().searchRetailStoreMemberGiftCardListWith(RetailStoreMemberGiftCard.ID_PROPERTY, tokens().equals(), retailStoreMemberGiftCardId).done();



		RetailStoreMember retailStoreMember = loadRetailStoreMember(userContext, retailStoreMemberId, loadTokens);

		synchronized(retailStoreMember){
			//Will be good when the retailStoreMember loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreMember.removeRetailStoreMemberGiftCard( retailStoreMemberGiftCard );
			//make changes to AcceleraterAccount.
			RetailStoreMemberGiftCard retailStoreMemberGiftCardIdVersionKey = createIndexedRetailStoreMemberGiftCard(retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion);

			RetailStoreMemberGiftCard retailStoreMemberGiftCard = retailStoreMember.findTheRetailStoreMemberGiftCard(retailStoreMemberGiftCardIdVersionKey);
			if(retailStoreMemberGiftCard == null){
				throw new RetailStoreMemberManagerException(retailStoreMemberGiftCardId+" is NOT FOUND" );
			}

			beforeUpdateRetailStoreMemberGiftCard(userContext, retailStoreMemberGiftCard, retailStoreMemberId, retailStoreMemberGiftCardId, retailStoreMemberGiftCardVersion, property, newValueExpr,  tokensExpr);
			retailStoreMemberGiftCard.changeProperty(property, newValueExpr);
			
			retailStoreMember = saveRetailStoreMember(userContext, retailStoreMember, tokens().withRetailStoreMemberGiftCardList().done());
			retailStoreMemberGiftCardManagerOf(userContext).onUpdated(userContext, retailStoreMemberGiftCard, this, "updateRetailStoreMemberGiftCard");
			return present(userContext,retailStoreMember, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateRetailStoreMemberGiftCard(RetailscmUserContext userContext, RetailStoreMemberGiftCard existed, String retailStoreMemberId, String retailStoreMemberGiftCardId, int retailStoreMemberGiftCardVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreMember newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    retailStoreMemberDaoOf(ctx).loadAllAsStream().forEach(
          event -> sendInitEvent(ctx, event)
    );
  }



	// -----------------------------------//  登录部分处理 \\-----------------------------------
	@Override
  protected BusinessHandler getLoginProcessBizHandler(RetailscmUserContextImpl userContext) {
    return this;
  }

	public void onAuthenticationFailed(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, failed is failed, nothing can do
	}
	// when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd party service.
	public void onAuthenticateNewUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// Generally speaking, when authenticated user logined, we will create a new account for him/her.
		// you need do it like :
		// First, you should create new data such as:
		//   RetailStoreMember newRetailStoreMember = this.createRetailStoreMember(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreMember
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// and in most case, this should be considered as "login success"
		//   loginResult.setSuccess(true);
		//
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	protected SmartList<UserApp> getRelatedUserAppList(RetailscmUserContext userContext, SecUser secUser) {
    MultipleAccessKey key = new MultipleAccessKey();
    key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
    key.put(UserApp.APP_TYPE_PROPERTY, RetailStoreMember.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<RetailStoreMember> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreCountryCenter> ownerList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCountryCenter.class);
		userContext.getDAOGroup().enhanceList(ownerList, RetailStoreCountryCenter.class);


    }
	
	public Object listByOwner(RetailscmUserContext userContext,String ownerId) throws Exception {
		return listPageByOwner(userContext, ownerId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByOwner(RetailscmUserContext userContext,String ownerId, int start, int count) throws Exception {
		SmartList<RetailStoreMember> list = retailStoreMemberDaoOf(userContext).findRetailStoreMemberByOwner(ownerId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(RetailStoreMember.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(ownerId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("生超会员列表");
		page.setRequestName("listByOwner");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByOwner/%s/",  getBeanName(), ownerId)));

		page.assemblerContent(userContext, "listByOwner");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String retailStoreMemberId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		RetailStoreMember merchantObj = (RetailStoreMember) this.view(userContext, retailStoreMemberId);
    String merchantObjId = retailStoreMemberId;
    String linkToUrl =	"retailStoreMemberManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "生超会员"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "ID")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

		propList.add(
				MapUtil.put("id", "3-mobilePhone")
				    .put("fieldName", "mobilePhone")
				    .put("label", "移动电话")
				    .put("type", "mobile")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("mobilePhone", merchantObj.getMobilePhone());

		propList.add(
				MapUtil.put("id", "4-owner")
				    .put("fieldName", "owner")
				    .put("label", "业主")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("owner", merchantObj.getOwner());

		//处理 sectionList

		//处理Section：consumerOrderListSection
		Map consumerOrderListSection = ListofUtils.buildSection(
		    "consumerOrderListSection",
		    "消费者的订单列表",
		    null,
		    "",
		    "__no_group",
		    "consumerOrderManager/listByConsumer/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(consumerOrderListSection);

		result.put("consumerOrderListSection", ListofUtils.toShortList(merchantObj.getConsumerOrderList(), "consumerOrder"));

		//处理Section：retailStoreMemberCouponListSection
		Map retailStoreMemberCouponListSection = ListofUtils.buildSection(
		    "retailStoreMemberCouponListSection",
		    "零售会员优惠券列表",
		    null,
		    "",
		    "__no_group",
		    "retailStoreMemberCouponManager/listByOwner/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(retailStoreMemberCouponListSection);

		result.put("retailStoreMemberCouponListSection", ListofUtils.toShortList(merchantObj.getRetailStoreMemberCouponList(), "retailStoreMemberCoupon"));

		//处理Section：memberWishlistListSection
		Map memberWishlistListSection = ListofUtils.buildSection(
		    "memberWishlistListSection",
		    "成员的清单列表",
		    null,
		    "",
		    "__no_group",
		    "memberWishlistManager/listByOwner/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(memberWishlistListSection);

		result.put("memberWishlistListSection", ListofUtils.toShortList(merchantObj.getMemberWishlistList(), "memberWishlist"));

		//处理Section：memberRewardPointListSection
		Map memberRewardPointListSection = ListofUtils.buildSection(
		    "memberRewardPointListSection",
		    "会员奖励积分表",
		    null,
		    "",
		    "__no_group",
		    "memberRewardPointManager/listByOwner/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(memberRewardPointListSection);

		result.put("memberRewardPointListSection", ListofUtils.toShortList(merchantObj.getMemberRewardPointList(), "memberRewardPoint"));

		//处理Section：memberRewardPointRedemptionListSection
		Map memberRewardPointRedemptionListSection = ListofUtils.buildSection(
		    "memberRewardPointRedemptionListSection",
		    "会员奖励积分兑换名单",
		    null,
		    "",
		    "__no_group",
		    "memberRewardPointRedemptionManager/listByOwner/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(memberRewardPointRedemptionListSection);

		result.put("memberRewardPointRedemptionListSection", ListofUtils.toShortList(merchantObj.getMemberRewardPointRedemptionList(), "memberRewardPointRedemption"));

		//处理Section：retailStoreMemberAddressListSection
		Map retailStoreMemberAddressListSection = ListofUtils.buildSection(
		    "retailStoreMemberAddressListSection",
		    "零售店会员地址列表",
		    null,
		    "",
		    "__no_group",
		    "retailStoreMemberAddressManager/listByOwner/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(retailStoreMemberAddressListSection);

		result.put("retailStoreMemberAddressListSection", ListofUtils.toShortList(merchantObj.getRetailStoreMemberAddressList(), "retailStoreMemberAddress"));

		//处理Section：retailStoreMemberGiftCardListSection
		Map retailStoreMemberGiftCardListSection = ListofUtils.buildSection(
		    "retailStoreMemberGiftCardListSection",
		    "零售店会员礼品卡列表",
		    null,
		    "",
		    "__no_group",
		    "retailStoreMemberGiftCardManager/listByOwner/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(retailStoreMemberGiftCardListSection);

		result.put("retailStoreMemberGiftCardListSection", ListofUtils.toShortList(merchantObj.getRetailStoreMemberGiftCardList(), "retailStoreMemberGiftCard"));

		result.put("propList", propList);
		result.put("sectionList", sections);
		result.put("pageTitle", pageTitle);
		result.put("linkToUrl", linkToUrl);

		vscope.field("propList", SerializeScope.EXCLUDE())
				.field("sectionList", SerializeScope.EXCLUDE())
				.field("pageTitle", SerializeScope.EXCLUDE())
				.field("linkToUrl", SerializeScope.EXCLUDE());
		userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
		return BaseViewPage.serialize(result, vscope);
	}

  










}




