
package com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.consumerorder.CandidateConsumerOrder;import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.retailstoremembergiftcard.CandidateRetailStoreMemberGiftCard;import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class RetailStoreMemberGiftCardConsumeRecordManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreMemberGiftCardConsumeRecordManager, BusinessHandler{

	// Only some of ods have such function
	




  


	private static final String SERVICE_TYPE = "RetailStoreMemberGiftCardConsumeRecord";
	@Override
	public RetailStoreMemberGiftCardConsumeRecordDAO daoOf(RetailscmUserContext userContext) {
		return retailStoreMemberGiftCardConsumeRecordDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws RetailStoreMemberGiftCardConsumeRecordManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreMemberGiftCardConsumeRecordManagerException(message);

	}



 	protected RetailStoreMemberGiftCardConsumeRecord saveRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, String [] tokensExpr) throws Exception{
 		//return getRetailStoreMemberGiftCardConsumeRecordDAO().save(retailStoreMemberGiftCardConsumeRecord, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, tokens);
 	}

 	protected RetailStoreMemberGiftCardConsumeRecord saveRetailStoreMemberGiftCardConsumeRecordDetail(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord) throws Exception{


 		return saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, allTokens());
 	}

 	public RetailStoreMemberGiftCardConsumeRecord loadRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreMemberGiftCardConsumeRecordManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord( userContext, retailStoreMemberGiftCardConsumeRecordId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMemberGiftCardConsumeRecord, tokens);
 	}


 	 public RetailStoreMemberGiftCardConsumeRecord searchRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreMemberGiftCardConsumeRecordManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord( userContext, retailStoreMemberGiftCardConsumeRecordId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreMemberGiftCardConsumeRecord, tokens);
 	}



 	protected RetailStoreMemberGiftCardConsumeRecord present(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, Map<String, Object> tokens) throws Exception {


		addActions(userContext,retailStoreMemberGiftCardConsumeRecord,tokens);
    

		RetailStoreMemberGiftCardConsumeRecord  retailStoreMemberGiftCardConsumeRecordToPresent = retailStoreMemberGiftCardConsumeRecordDaoOf(userContext).present(retailStoreMemberGiftCardConsumeRecord, tokens);

		List<BaseEntity> entityListToNaming = retailStoreMemberGiftCardConsumeRecordToPresent.collectRefercencesFromLists();
		retailStoreMemberGiftCardConsumeRecordDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,retailStoreMemberGiftCardConsumeRecord,tokens);

		return  retailStoreMemberGiftCardConsumeRecordToPresent;


	}



 	public RetailStoreMemberGiftCardConsumeRecord loadRetailStoreMemberGiftCardConsumeRecordDetail(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId) throws Exception{
 		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord( userContext, retailStoreMemberGiftCardConsumeRecordId, allTokens());
 		return present(userContext,retailStoreMemberGiftCardConsumeRecord, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId) throws Exception{
 		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord( userContext, retailStoreMemberGiftCardConsumeRecordId, viewTokens());
 		markVisited(userContext, retailStoreMemberGiftCardConsumeRecord);
 		return present(userContext,retailStoreMemberGiftCardConsumeRecord, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId) throws Exception{
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord( userContext, retailStoreMemberGiftCardConsumeRecordId, viewTokens());
		retailStoreMemberGiftCardConsumeRecord.summarySuffix();
		markVisited(userContext, retailStoreMemberGiftCardConsumeRecord);
 		return present(userContext,retailStoreMemberGiftCardConsumeRecord, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId) throws Exception{
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord( userContext, retailStoreMemberGiftCardConsumeRecordId, analyzeTokens());
		markVisited(userContext, retailStoreMemberGiftCardConsumeRecord);
		return present(userContext,retailStoreMemberGiftCardConsumeRecord, analyzeTokens());

	}
 	protected RetailStoreMemberGiftCardConsumeRecord saveRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, Map<String,Object>tokens) throws Exception{
 	
 		return retailStoreMemberGiftCardConsumeRecordDaoOf(userContext).save(retailStoreMemberGiftCardConsumeRecord, tokens);
 	}
 	protected RetailStoreMemberGiftCardConsumeRecord loadRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreMemberGiftCardConsumeRecordManagerException.class);



 		return retailStoreMemberGiftCardConsumeRecordDaoOf(userContext).load(retailStoreMemberGiftCardConsumeRecordId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreMemberGiftCardConsumeRecord, tokens);

		addAction(userContext, retailStoreMemberGiftCardConsumeRecord, tokens,"@create","createRetailStoreMemberGiftCardConsumeRecord","createRetailStoreMemberGiftCardConsumeRecord/","main","primary");
		addAction(userContext, retailStoreMemberGiftCardConsumeRecord, tokens,"@update","updateRetailStoreMemberGiftCardConsumeRecord","updateRetailStoreMemberGiftCardConsumeRecord/"+retailStoreMemberGiftCardConsumeRecord.getId()+"/","main","primary");
		addAction(userContext, retailStoreMemberGiftCardConsumeRecord, tokens,"@copy","cloneRetailStoreMemberGiftCardConsumeRecord","cloneRetailStoreMemberGiftCardConsumeRecord/"+retailStoreMemberGiftCardConsumeRecord.getId()+"/","main","primary");

		addAction(userContext, retailStoreMemberGiftCardConsumeRecord, tokens,"retail_store_member_gift_card_consume_record.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+retailStoreMemberGiftCardConsumeRecord.getId()+"/","main","primary");
		addAction(userContext, retailStoreMemberGiftCardConsumeRecord, tokens,"retail_store_member_gift_card_consume_record.transfer_to_biz_order","transferToAnotherBizOrder","transferToAnotherBizOrder/"+retailStoreMemberGiftCardConsumeRecord.getId()+"/","main","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, Map<String, Object> tokens){








  @Override
  public List<RetailStoreMemberGiftCardConsumeRecord> searchRetailStoreMemberGiftCardConsumeRecordList(RetailscmUserContext ctx, RetailStoreMemberGiftCardConsumeRecordRequest pRequest){
      pRequest.setUserContext(ctx);
      List<RetailStoreMemberGiftCardConsumeRecord> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public RetailStoreMemberGiftCardConsumeRecord searchRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext ctx, RetailStoreMemberGiftCardConsumeRecordRequest pRequest){
    pRequest.limit(0, 1);
    List<RetailStoreMemberGiftCardConsumeRecord> list = searchRetailStoreMemberGiftCardConsumeRecordList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public RetailStoreMemberGiftCardConsumeRecord createRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, Date occureTime,String ownerId,String bizOrderId,String number,BigDecimal amount) throws Exception
	{





		checkerOf(userContext).checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(occureTime);
		checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCardConsumeRecord(number);
		checkerOf(userContext).checkAmountOfRetailStoreMemberGiftCardConsumeRecord(amount);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberGiftCardConsumeRecordManagerException.class);



		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord=createNewRetailStoreMemberGiftCardConsumeRecord();	

		retailStoreMemberGiftCardConsumeRecord.setOccureTime(occureTime);
			
		RetailStoreMemberGiftCard owner = loadRetailStoreMemberGiftCard(userContext, ownerId,emptyOptions());
		retailStoreMemberGiftCardConsumeRecord.setOwner(owner);
		
		
			
		ConsumerOrder bizOrder = loadConsumerOrder(userContext, bizOrderId,emptyOptions());
		retailStoreMemberGiftCardConsumeRecord.setBizOrder(bizOrder);
		
		
		retailStoreMemberGiftCardConsumeRecord.setNumber(number);
		retailStoreMemberGiftCardConsumeRecord.setAmount(amount);

		retailStoreMemberGiftCardConsumeRecord = saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreMemberGiftCardConsumeRecord);
		return retailStoreMemberGiftCardConsumeRecord;


	}
	protected RetailStoreMemberGiftCardConsumeRecord createNewRetailStoreMemberGiftCardConsumeRecord()
	{

		return new RetailStoreMemberGiftCardConsumeRecord();
	}

	protected void checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext,String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
		checkerOf(userContext).checkVersionOfRetailStoreMemberGiftCardConsumeRecord( retailStoreMemberGiftCardConsumeRecordVersion);


		if(RetailStoreMemberGiftCardConsumeRecord.OCCURE_TIME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(parseDate(newValueExpr));
		

		}

		

		
		if(RetailStoreMemberGiftCardConsumeRecord.NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNumberOfRetailStoreMemberGiftCardConsumeRecord(parseString(newValueExpr));
		

		}
		if(RetailStoreMemberGiftCardConsumeRecord.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfRetailStoreMemberGiftCardConsumeRecord(parseBigDecimal(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberGiftCardConsumeRecordManagerException.class);



	}



	public RetailStoreMemberGiftCardConsumeRecord clone(RetailscmUserContext userContext, String fromRetailStoreMemberGiftCardConsumeRecordId) throws Exception{

		return retailStoreMemberGiftCardConsumeRecordDaoOf(userContext).clone(fromRetailStoreMemberGiftCardConsumeRecordId, this.allTokens());
	}

	public RetailStoreMemberGiftCardConsumeRecord internalSaveRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord) throws Exception
	{
		return internalSaveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, allTokens());

	}
	public RetailStoreMemberGiftCardConsumeRecord internalSaveRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion, property, newValueExpr, tokensExpr);


		synchronized(retailStoreMemberGiftCardConsumeRecord){
			//will be good when the retailStoreMemberGiftCardConsumeRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMemberGiftCardConsumeRecord.
			if (retailStoreMemberGiftCardConsumeRecord.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecord);
			retailStoreMemberGiftCardConsumeRecord = saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, options);
			return retailStoreMemberGiftCardConsumeRecord;

		}

	}

	public RetailStoreMemberGiftCardConsumeRecord updateRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext,String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion, property, newValueExpr, tokensExpr);



		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, allTokens());
		if(retailStoreMemberGiftCardConsumeRecord.getVersion() != retailStoreMemberGiftCardConsumeRecordVersion){
			String message = "The target version("+retailStoreMemberGiftCardConsumeRecord.getVersion()+") is not equals to version("+retailStoreMemberGiftCardConsumeRecordVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreMemberGiftCardConsumeRecord){
			//will be good when the retailStoreMemberGiftCardConsumeRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMemberGiftCardConsumeRecord.
			
			retailStoreMemberGiftCardConsumeRecord.changeProperty(property, newValueExpr);
			retailStoreMemberGiftCardConsumeRecord = saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, tokens().done());
			return present(userContext,retailStoreMemberGiftCardConsumeRecord, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, tokens().done());
		}

	}

	public RetailStoreMemberGiftCardConsumeRecord updateRetailStoreMemberGiftCardConsumeRecordProperty(RetailscmUserContext userContext,String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion, property, newValueExpr, tokensExpr);

		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, allTokens());
		if(retailStoreMemberGiftCardConsumeRecord.getVersion() != retailStoreMemberGiftCardConsumeRecordVersion){
			String message = "The target version("+retailStoreMemberGiftCardConsumeRecord.getVersion()+") is not equals to version("+retailStoreMemberGiftCardConsumeRecordVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreMemberGiftCardConsumeRecord){
			//will be good when the retailStoreMemberGiftCardConsumeRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreMemberGiftCardConsumeRecord.

			retailStoreMemberGiftCardConsumeRecord.changeProperty(property, newValueExpr);
			
			retailStoreMemberGiftCardConsumeRecord = saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, tokens().done());
			return present(userContext,retailStoreMemberGiftCardConsumeRecord, mergedAllTokens(tokensExpr));
			//return saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RetailStoreMemberGiftCardConsumeRecordTokens tokens(){
		return RetailStoreMemberGiftCardConsumeRecordTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreMemberGiftCardConsumeRecordTokens.all();
	}
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreMemberGiftCardConsumeRecordTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String anotherOwnerId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
 		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCard(anotherOwnerId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberGiftCardConsumeRecordManagerException.class);

 	}
 	public RetailStoreMemberGiftCardConsumeRecord transferToAnotherOwner(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, retailStoreMemberGiftCardConsumeRecordId,anotherOwnerId);
 
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, allTokens());
		synchronized(retailStoreMemberGiftCardConsumeRecord){
			//will be good when the retailStoreMemberGiftCardConsumeRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreMemberGiftCard owner = loadRetailStoreMemberGiftCard(userContext, anotherOwnerId, emptyOptions());
			retailStoreMemberGiftCardConsumeRecord.updateOwner(owner);
			
			retailStoreMemberGiftCardConsumeRecord = saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, emptyOptions());

			return present(userContext,retailStoreMemberGiftCardConsumeRecord, allTokens());

		}

 	}

	


	public CandidateRetailStoreMemberGiftCard requestCandidateOwner(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreMemberGiftCard result = new CandidateRetailStoreMemberGiftCard();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreMemberGiftCard> candidateList = retailStoreMemberGiftCardDaoOf(userContext).requestCandidateRetailStoreMemberGiftCardForRetailStoreMemberGiftCardConsumeRecord(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherBizOrder(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String anotherBizOrderId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecordId);
 		checkerOf(userContext).checkIdOfConsumerOrder(anotherBizOrderId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreMemberGiftCardConsumeRecordManagerException.class);

 	}
 	public RetailStoreMemberGiftCardConsumeRecord transferToAnotherBizOrder(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, String anotherBizOrderId) throws Exception
 	{
 		checkParamsForTransferingAnotherBizOrder(userContext, retailStoreMemberGiftCardConsumeRecordId,anotherBizOrderId);
 
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = loadRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecordId, allTokens());
		synchronized(retailStoreMemberGiftCardConsumeRecord){
			//will be good when the retailStoreMemberGiftCardConsumeRecord loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ConsumerOrder bizOrder = loadConsumerOrder(userContext, anotherBizOrderId, emptyOptions());
			retailStoreMemberGiftCardConsumeRecord.updateBizOrder(bizOrder);
			
			retailStoreMemberGiftCardConsumeRecord = saveRetailStoreMemberGiftCardConsumeRecord(userContext, retailStoreMemberGiftCardConsumeRecord, emptyOptions());

			return present(userContext,retailStoreMemberGiftCardConsumeRecord, allTokens());

		}

 	}

	


	public CandidateConsumerOrder requestCandidateBizOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateConsumerOrder result = new CandidateConsumerOrder();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<ConsumerOrder> candidateList = consumerOrderDaoOf(userContext).requestCandidateConsumerOrderForRetailStoreMemberGiftCardConsumeRecord(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreMemberGiftCard loadRetailStoreMemberGiftCard(RetailscmUserContext userContext, String newOwnerId, Map<String,Object> options) throws Exception
 	{
    
 		return retailStoreMemberGiftCardDaoOf(userContext).load(newOwnerId, options);
 	  
 	}
 	


	

 	protected ConsumerOrder loadConsumerOrder(RetailscmUserContext userContext, String newBizOrderId, Map<String,Object> options) throws Exception
 	{
    
 		return consumerOrderDaoOf(userContext).load(newBizOrderId, options);
 	  
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion) throws Exception {
		//deleteInternal(userContext, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion) throws Exception{

		retailStoreMemberGiftCardConsumeRecordDaoOf(userContext).delete(retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);
	}

	public RetailStoreMemberGiftCardConsumeRecord forgetByAll(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);
	}
	protected RetailStoreMemberGiftCardConsumeRecord forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreMemberGiftCardConsumeRecordId, int retailStoreMemberGiftCardConsumeRecordVersion) throws Exception{

		return retailStoreMemberGiftCardConsumeRecordDaoOf(userContext).disconnectFromAll(retailStoreMemberGiftCardConsumeRecordId, retailStoreMemberGiftCardConsumeRecordVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreMemberGiftCardConsumeRecordManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return retailStoreMemberGiftCardConsumeRecordDaoOf(userContext).deleteAll();
	}





	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreMemberGiftCardConsumeRecord newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    retailStoreMemberGiftCardConsumeRecordDaoOf(ctx).loadAllAsStream().forEach(
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
		//   RetailStoreMemberGiftCardConsumeRecord newRetailStoreMemberGiftCardConsumeRecord = this.createRetailStoreMemberGiftCardConsumeRecord(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreMemberGiftCardConsumeRecord
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
    key.put(UserApp.APP_TYPE_PROPERTY, RetailStoreMemberGiftCardConsumeRecord.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<RetailStoreMemberGiftCardConsumeRecord> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreMemberGiftCard> ownerList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreMemberGiftCard.class);
		userContext.getDAOGroup().enhanceList(ownerList, RetailStoreMemberGiftCard.class);
		List<ConsumerOrder> bizOrderList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, ConsumerOrder.class);
		userContext.getDAOGroup().enhanceList(bizOrderList, ConsumerOrder.class);


    }
	
	public Object listByOwner(RetailscmUserContext userContext,String ownerId) throws Exception {
		return listPageByOwner(userContext, ownerId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByOwner(RetailscmUserContext userContext,String ownerId, int start, int count) throws Exception {
		SmartList<RetailStoreMemberGiftCardConsumeRecord> list = retailStoreMemberGiftCardConsumeRecordDaoOf(userContext).findRetailStoreMemberGiftCardConsumeRecordByOwner(ownerId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(RetailStoreMemberGiftCardConsumeRecord.class);
		page.setContainerObject(RetailStoreMemberGiftCard.withId(ownerId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("零售门店会员卡消费记录列表");
		page.setRequestName("listByOwner");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByOwner/%s/",  getBeanName(), ownerId)));

		page.assemblerContent(userContext, "listByOwner");
		return page.doRender(userContext);
	}
  
	public Object listByBizOrder(RetailscmUserContext userContext,String bizOrderId) throws Exception {
		return listPageByBizOrder(userContext, bizOrderId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByBizOrder(RetailscmUserContext userContext,String bizOrderId, int start, int count) throws Exception {
		SmartList<RetailStoreMemberGiftCardConsumeRecord> list = retailStoreMemberGiftCardConsumeRecordDaoOf(userContext).findRetailStoreMemberGiftCardConsumeRecordByBizOrder(bizOrderId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(RetailStoreMemberGiftCardConsumeRecord.class);
		page.setContainerObject(ConsumerOrder.withId(bizOrderId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("零售门店会员卡消费记录列表");
		page.setRequestName("listByBizOrder");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByBizOrder/%s/",  getBeanName(), bizOrderId)));

		page.assemblerContent(userContext, "listByBizOrder");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String retailStoreMemberGiftCardConsumeRecordId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		RetailStoreMemberGiftCardConsumeRecord merchantObj = (RetailStoreMemberGiftCardConsumeRecord) this.view(userContext, retailStoreMemberGiftCardConsumeRecordId);
    String merchantObjId = retailStoreMemberGiftCardConsumeRecordId;
    String linkToUrl =	"retailStoreMemberGiftCardConsumeRecordManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "零售门店会员卡消费记录"+"详情";
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
				MapUtil.put("id", "2-occureTime")
				    .put("fieldName", "occureTime")
				    .put("label", "发生时间")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("occureTime", merchantObj.getOccureTime());

		propList.add(
				MapUtil.put("id", "3-owner")
				    .put("fieldName", "owner")
				    .put("label", "业主")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreMemberGiftCardManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"remain\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("owner", merchantObj.getOwner());

		propList.add(
				MapUtil.put("id", "4-bizOrder")
				    .put("fieldName", "bizOrder")
				    .put("label", "订单")
				    .put("type", "auto")
				    .put("linkToUrl", "consumerOrderManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"title\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("bizOrder", merchantObj.getBizOrder());

		propList.add(
				MapUtil.put("id", "5-number")
				    .put("fieldName", "number")
				    .put("label", "数")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("number", merchantObj.getNumber());

		propList.add(
				MapUtil.put("id", "6-amount")
				    .put("fieldName", "amount")
				    .put("label", "金额")
				    .put("type", "money")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("amount", merchantObj.getAmount());

		//处理 sectionList

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




