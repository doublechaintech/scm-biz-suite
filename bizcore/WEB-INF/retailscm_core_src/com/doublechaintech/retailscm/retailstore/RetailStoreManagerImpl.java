
package com.doublechaintech.retailscm.retailstore;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.accountset.AccountSet;import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;import com.doublechaintech.retailscm.goods.Goods;import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;import com.doublechaintech.retailscm.retailstore.RetailStore;import com.doublechaintech.retailscm.retailstorecityservicecenter.CandidateRetailStoreCityServiceCenter;import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;import com.doublechaintech.retailscm.retailstoreclosing.CandidateRetailStoreClosing;import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;import com.doublechaintech.retailscm.retailstorecreation.CandidateRetailStoreCreation;import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;import com.doublechaintech.retailscm.retailstoredecoration.CandidateRetailStoreDecoration;import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;import com.doublechaintech.retailscm.retailstorefranchising.CandidateRetailStoreFranchising;import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.CandidateRetailStoreInvestmentInvitation;import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;import com.doublechaintech.retailscm.retailstoreopening.CandidateRetailStoreOpening;import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.shippingspace.ShippingSpace;import com.doublechaintech.retailscm.sku.Sku;import com.doublechaintech.retailscm.smartpallet.SmartPallet;import com.doublechaintech.retailscm.supplyorder.SupplyOrder;import com.doublechaintech.retailscm.transportfleet.TransportFleet;import com.doublechaintech.retailscm.transporttask.TransportTask;import com.doublechaintech.retailscm.transporttruck.TransportTruck;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.truckdriver.TruckDriver;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class RetailStoreManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = RetailStoreTokens.start().withTokenFromListName(listName).done();
		RetailStore  retailStore = (RetailStore) this.loadRetailStore(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = retailStore.collectRefercencesFromLists();
		retailStoreDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, retailStore, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new RetailStoreGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "RetailStore";
	@Override
	public RetailStoreDAO daoOf(RetailscmUserContext userContext) {
		return retailStoreDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws RetailStoreManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreManagerException(message);

	}



 	protected RetailStore saveRetailStore(RetailscmUserContext userContext, RetailStore retailStore, String [] tokensExpr) throws Exception{
 		//return getRetailStoreDAO().save(retailStore, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveRetailStore(userContext, retailStore, tokens);
 	}

 	protected RetailStore saveRetailStoreDetail(RetailscmUserContext userContext, RetailStore retailStore) throws Exception{


 		return saveRetailStore(userContext, retailStore, allTokens());
 	}

 	public RetailStore loadRetailStore(RetailscmUserContext userContext, String retailStoreId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		RetailStore retailStore = loadRetailStore( userContext, retailStoreId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStore, tokens);
 	}


 	 public RetailStore searchRetailStore(RetailscmUserContext userContext, String retailStoreId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		RetailStore retailStore = loadRetailStore( userContext, retailStoreId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStore, tokens);
 	}



 	protected RetailStore present(RetailscmUserContext userContext, RetailStore retailStore, Map<String, Object> tokens) throws Exception {


		addActions(userContext,retailStore,tokens);
    

		RetailStore  retailStoreToPresent = retailStoreDaoOf(userContext).present(retailStore, tokens);

		List<BaseEntity> entityListToNaming = retailStoreToPresent.collectRefercencesFromLists();
		retailStoreDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,retailStore,tokens);

		return  retailStoreToPresent;


	}



 	public RetailStore loadRetailStoreDetail(RetailscmUserContext userContext, String retailStoreId) throws Exception{
 		RetailStore retailStore = loadRetailStore( userContext, retailStoreId, allTokens());
 		return present(userContext,retailStore, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String retailStoreId) throws Exception{
 		RetailStore retailStore = loadRetailStore( userContext, retailStoreId, viewTokens());
 		markVisited(userContext, retailStore);
 		return present(userContext,retailStore, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String retailStoreId) throws Exception{
		RetailStore retailStore = loadRetailStore( userContext, retailStoreId, viewTokens());
		retailStore.summarySuffix();
		markVisited(userContext, retailStore);
 		return present(userContext,retailStore, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String retailStoreId) throws Exception{
		RetailStore retailStore = loadRetailStore( userContext, retailStoreId, analyzeTokens());
		markVisited(userContext, retailStore);
		return present(userContext,retailStore, analyzeTokens());

	}
 	protected RetailStore saveRetailStore(RetailscmUserContext userContext, RetailStore retailStore, Map<String,Object>tokens) throws Exception{
 	
 		return retailStoreDaoOf(userContext).save(retailStore, tokens);
 	}
 	protected RetailStore loadRetailStore(RetailscmUserContext userContext, String retailStoreId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreManagerException.class);



 		return retailStoreDaoOf(userContext).load(retailStoreId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStore retailStore, Map<String, Object> tokens){
		super.addActions(userContext, retailStore, tokens);

		addAction(userContext, retailStore, tokens,"@create","createRetailStore","createRetailStore/","main","primary");
		addAction(userContext, retailStore, tokens,"@update","updateRetailStore","updateRetailStore/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"@copy","cloneRetailStore","cloneRetailStore/"+retailStore.getId()+"/","main","primary");

		addAction(userContext, retailStore, tokens,"retail_store.transfer_to_retail_store_country_center","transferToAnotherRetailStoreCountryCenter","transferToAnotherRetailStoreCountryCenter/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.transfer_to_city_service_center","transferToAnotherCityServiceCenter","transferToAnotherCityServiceCenter/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.transfer_to_creation","transferToAnotherCreation","transferToAnotherCreation/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.transfer_to_investment_invitation","transferToAnotherInvestmentInvitation","transferToAnotherInvestmentInvitation/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.transfer_to_franchising","transferToAnotherFranchising","transferToAnotherFranchising/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.transfer_to_decoration","transferToAnotherDecoration","transferToAnotherDecoration/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.transfer_to_opening","transferToAnotherOpening","transferToAnotherOpening/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.transfer_to_closing","transferToAnotherClosing","transferToAnotherClosing/"+retailStore.getId()+"/","main","primary");
		addAction(userContext, retailStore, tokens,"retail_store.addConsumerOrder","addConsumerOrder","addConsumerOrder/"+retailStore.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.removeConsumerOrder","removeConsumerOrder","removeConsumerOrder/"+retailStore.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.updateConsumerOrder","updateConsumerOrder","updateConsumerOrder/"+retailStore.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.copyConsumerOrderFrom","copyConsumerOrderFrom","copyConsumerOrderFrom/"+retailStore.getId()+"/","consumerOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.addRetailStoreOrder","addRetailStoreOrder","addRetailStoreOrder/"+retailStore.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.removeRetailStoreOrder","removeRetailStoreOrder","removeRetailStoreOrder/"+retailStore.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.updateRetailStoreOrder","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStore.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.copyRetailStoreOrderFrom","copyRetailStoreOrderFrom","copyRetailStoreOrderFrom/"+retailStore.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.addGoods","addGoods","addGoods/"+retailStore.getId()+"/","goodsList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.removeGoods","removeGoods","removeGoods/"+retailStore.getId()+"/","goodsList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.updateGoods","updateGoods","updateGoods/"+retailStore.getId()+"/","goodsList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.copyGoodsFrom","copyGoodsFrom","copyGoodsFrom/"+retailStore.getId()+"/","goodsList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.addTransportTask","addTransportTask","addTransportTask/"+retailStore.getId()+"/","transportTaskList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.removeTransportTask","removeTransportTask","removeTransportTask/"+retailStore.getId()+"/","transportTaskList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.updateTransportTask","updateTransportTask","updateTransportTask/"+retailStore.getId()+"/","transportTaskList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.copyTransportTaskFrom","copyTransportTaskFrom","copyTransportTaskFrom/"+retailStore.getId()+"/","transportTaskList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.addAccountSet","addAccountSet","addAccountSet/"+retailStore.getId()+"/","accountSetList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.removeAccountSet","removeAccountSet","removeAccountSet/"+retailStore.getId()+"/","accountSetList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.updateAccountSet","updateAccountSet","updateAccountSet/"+retailStore.getId()+"/","accountSetList","primary");
		addAction(userContext, retailStore, tokens,"retail_store.copyAccountSetFrom","copyAccountSetFrom","copyAccountSetFrom/"+retailStore.getId()+"/","accountSetList","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStore retailStore, Map<String, Object> tokens){








  @Override
  public List<RetailStore> searchRetailStoreList(RetailscmUserContext ctx, RetailStoreRequest pRequest){
      pRequest.setUserContext(ctx);
      List<RetailStore> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public RetailStore searchRetailStore(RetailscmUserContext ctx, RetailStoreRequest pRequest){
    pRequest.limit(0, 1);
    List<RetailStore> list = searchRetailStoreList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public RetailStore createRetailStore(RetailscmUserContext userContext, String name,String telephone,String owner,String retailStoreCountryCenterId,String cityServiceCenterId,String creationId,String investmentInvitationId,String franchisingId,String decorationId,String openingId,String closingId,Date founded,BigDecimal latitude,BigDecimal longitude,String description) throws Exception
	{





		checkerOf(userContext).checkNameOfRetailStore(name);
		checkerOf(userContext).checkTelephoneOfRetailStore(telephone);
		checkerOf(userContext).checkOwnerOfRetailStore(owner);
		checkerOf(userContext).checkFoundedOfRetailStore(founded);
		checkerOf(userContext).checkLatitudeOfRetailStore(latitude);
		checkerOf(userContext).checkLongitudeOfRetailStore(longitude);
		checkerOf(userContext).checkDescriptionOfRetailStore(description);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);



		RetailStore retailStore=createNewRetailStore();	

		retailStore.setName(name);
		retailStore.setTelephone(telephone);
		retailStore.setOwner(owner);
			
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId,emptyOptions());
		retailStore.setRetailStoreCountryCenter(retailStoreCountryCenter);
		
		
			
		RetailStoreCityServiceCenter cityServiceCenter = loadRetailStoreCityServiceCenter(userContext, cityServiceCenterId,emptyOptions());
		retailStore.setCityServiceCenter(cityServiceCenter);
		
		
			
		RetailStoreCreation creation = loadRetailStoreCreation(userContext, creationId,emptyOptions());
		retailStore.setCreation(creation);
		
		
			
		RetailStoreInvestmentInvitation investmentInvitation = loadRetailStoreInvestmentInvitation(userContext, investmentInvitationId,emptyOptions());
		retailStore.setInvestmentInvitation(investmentInvitation);
		
		
			
		RetailStoreFranchising franchising = loadRetailStoreFranchising(userContext, franchisingId,emptyOptions());
		retailStore.setFranchising(franchising);
		
		
			
		RetailStoreDecoration decoration = loadRetailStoreDecoration(userContext, decorationId,emptyOptions());
		retailStore.setDecoration(decoration);
		
		
			
		RetailStoreOpening opening = loadRetailStoreOpening(userContext, openingId,emptyOptions());
		retailStore.setOpening(opening);
		
		
			
		RetailStoreClosing closing = loadRetailStoreClosing(userContext, closingId,emptyOptions());
		retailStore.setClosing(closing);
		
		
		retailStore.setFounded(founded);
		retailStore.setLatitude(latitude);
		retailStore.setLongitude(longitude);
		retailStore.setDescription(description);
		retailStore.setLastUpdateTime(userContext.now());

		retailStore = saveRetailStore(userContext, retailStore, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStore);
		return retailStore;


	}
	protected RetailStore createNewRetailStore()
	{

		return new RetailStore();
	}

	protected void checkParamsForUpdatingRetailStore(RetailscmUserContext userContext,String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore( retailStoreVersion);


		if(RetailStore.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfRetailStore(parseString(newValueExpr));
		

		}
		if(RetailStore.TELEPHONE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTelephoneOfRetailStore(parseString(newValueExpr));
		

		}
		if(RetailStore.OWNER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkOwnerOfRetailStore(parseString(newValueExpr));
		

		}

		

		

		

		

		

		

		

		
		if(RetailStore.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfRetailStore(parseDate(newValueExpr));
		

		}
		if(RetailStore.LATITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLatitudeOfRetailStore(parseBigDecimal(newValueExpr));
		

		}
		if(RetailStore.LONGITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLongitudeOfRetailStore(parseBigDecimal(newValueExpr));
		

		}
		if(RetailStore.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfRetailStore(parseString(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);



	}



	public RetailStore clone(RetailscmUserContext userContext, String fromRetailStoreId) throws Exception{

		return retailStoreDaoOf(userContext).clone(fromRetailStoreId, this.allTokens());
	}

	public RetailStore internalSaveRetailStore(RetailscmUserContext userContext, RetailStore retailStore) throws Exception
	{
		return internalSaveRetailStore(userContext, retailStore, allTokens());

	}
	public RetailStore internalSaveRetailStore(RetailscmUserContext userContext, RetailStore retailStore, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRetailStore(userContext, retailStoreId, retailStoreVersion, property, newValueExpr, tokensExpr);


		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStore.
			if (retailStore.isChanged()){
			retailStore.updateLastUpdateTime(userContext.now());
			}

      //checkerOf(userContext).checkAndFixRetailStore(retailStore);
			retailStore = saveRetailStore(userContext, retailStore, options);
			return retailStore;

		}

	}

	public RetailStore updateRetailStore(RetailscmUserContext userContext,String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStore(userContext, retailStoreId, retailStoreVersion, property, newValueExpr, tokensExpr);



		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		if(retailStore.getVersion() != retailStoreVersion){
			String message = "The target version("+retailStore.getVersion()+") is not equals to version("+retailStoreVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStore.
			retailStore.updateLastUpdateTime(userContext.now());
			retailStore.changeProperty(property, newValueExpr);
			retailStore = saveRetailStore(userContext, retailStore, tokens().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			//return saveRetailStore(userContext, retailStore, tokens().done());
		}

	}

	public RetailStore updateRetailStoreProperty(RetailscmUserContext userContext,String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStore(userContext, retailStoreId, retailStoreVersion, property, newValueExpr, tokensExpr);

		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		if(retailStore.getVersion() != retailStoreVersion){
			String message = "The target version("+retailStore.getVersion()+") is not equals to version("+retailStoreVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStore.

			retailStore.changeProperty(property, newValueExpr);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStore = saveRetailStore(userContext, retailStore, tokens().done());
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			//return saveRetailStore(userContext, retailStore, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RetailStoreTokens tokens(){
		return RetailStoreTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreTokens.all();
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
		.sortRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY,sortDesc())
		.sortGoodsListWith(Goods.ID_PROPERTY,sortDesc())
		.sortTransportTaskListWith(TransportTask.ID_PROPERTY,sortDesc())
		.sortAccountSetListWith(AccountSet.ID_PROPERTY,sortDesc())
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherRetailStoreCountryCenter(RetailscmUserContext userContext, String retailStoreId, String anotherRetailStoreCountryCenterId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherRetailStoreCountryCenterId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore transferToAnotherRetailStoreCountryCenter(RetailscmUserContext userContext, String retailStoreId, String anotherRetailStoreCountryCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherRetailStoreCountryCenter(userContext, retailStoreId,anotherRetailStoreCountryCenterId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, anotherRetailStoreCountryCenterId, emptyOptions());
			retailStore.updateRetailStoreCountryCenter(retailStoreCountryCenter);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());

			return present(userContext,retailStore, allTokens());

		}

 	}

	


	public CandidateRetailStoreCountryCenter requestCandidateRetailStoreCountryCenter(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherCityServiceCenter(RetailscmUserContext userContext, String retailStoreId, String anotherCityServiceCenterId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
 		checkerOf(userContext).checkIdOfRetailStoreCityServiceCenter(anotherCityServiceCenterId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore transferToAnotherCityServiceCenter(RetailscmUserContext userContext, String retailStoreId, String anotherCityServiceCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherCityServiceCenter(userContext, retailStoreId,anotherCityServiceCenterId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCityServiceCenter cityServiceCenter = loadRetailStoreCityServiceCenter(userContext, anotherCityServiceCenterId, emptyOptions());
			retailStore.updateCityServiceCenter(cityServiceCenter);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());

			return present(userContext,retailStore, allTokens());

		}

 	}

	


	public CandidateRetailStoreCityServiceCenter requestCandidateCityServiceCenter(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreCityServiceCenter result = new CandidateRetailStoreCityServiceCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreCityServiceCenter> candidateList = retailStoreCityServiceCenterDaoOf(userContext).requestCandidateRetailStoreCityServiceCenterForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherCreation(RetailscmUserContext userContext, String retailStoreId, String anotherCreationId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
 		checkerOf(userContext).checkIdOfRetailStoreCreation(anotherCreationId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore transferToAnotherCreation(RetailscmUserContext userContext, String retailStoreId, String anotherCreationId) throws Exception
 	{
 		checkParamsForTransferingAnotherCreation(userContext, retailStoreId,anotherCreationId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCreation creation = loadRetailStoreCreation(userContext, anotherCreationId, emptyOptions());
			retailStore.updateCreation(creation);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());

			return present(userContext,retailStore, allTokens());

		}

 	}

	


	public CandidateRetailStoreCreation requestCandidateCreation(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreCreation result = new CandidateRetailStoreCreation();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("comment");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreCreation> candidateList = retailStoreCreationDaoOf(userContext).requestCandidateRetailStoreCreationForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherInvestmentInvitation(RetailscmUserContext userContext, String retailStoreId, String anotherInvestmentInvitationId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
 		checkerOf(userContext).checkIdOfRetailStoreInvestmentInvitation(anotherInvestmentInvitationId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore transferToAnotherInvestmentInvitation(RetailscmUserContext userContext, String retailStoreId, String anotherInvestmentInvitationId) throws Exception
 	{
 		checkParamsForTransferingAnotherInvestmentInvitation(userContext, retailStoreId,anotherInvestmentInvitationId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreInvestmentInvitation investmentInvitation = loadRetailStoreInvestmentInvitation(userContext, anotherInvestmentInvitationId, emptyOptions());
			retailStore.updateInvestmentInvitation(investmentInvitation);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());

			return present(userContext,retailStore, allTokens());

		}

 	}

	


	public CandidateRetailStoreInvestmentInvitation requestCandidateInvestmentInvitation(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreInvestmentInvitation result = new CandidateRetailStoreInvestmentInvitation();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("comment");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreInvestmentInvitation> candidateList = retailStoreInvestmentInvitationDaoOf(userContext).requestCandidateRetailStoreInvestmentInvitationForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherFranchising(RetailscmUserContext userContext, String retailStoreId, String anotherFranchisingId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
 		checkerOf(userContext).checkIdOfRetailStoreFranchising(anotherFranchisingId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore transferToAnotherFranchising(RetailscmUserContext userContext, String retailStoreId, String anotherFranchisingId) throws Exception
 	{
 		checkParamsForTransferingAnotherFranchising(userContext, retailStoreId,anotherFranchisingId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreFranchising franchising = loadRetailStoreFranchising(userContext, anotherFranchisingId, emptyOptions());
			retailStore.updateFranchising(franchising);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());

			return present(userContext,retailStore, allTokens());

		}

 	}

	


	public CandidateRetailStoreFranchising requestCandidateFranchising(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreFranchising result = new CandidateRetailStoreFranchising();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("comment");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreFranchising> candidateList = retailStoreFranchisingDaoOf(userContext).requestCandidateRetailStoreFranchisingForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherDecoration(RetailscmUserContext userContext, String retailStoreId, String anotherDecorationId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
 		checkerOf(userContext).checkIdOfRetailStoreDecoration(anotherDecorationId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore transferToAnotherDecoration(RetailscmUserContext userContext, String retailStoreId, String anotherDecorationId) throws Exception
 	{
 		checkParamsForTransferingAnotherDecoration(userContext, retailStoreId,anotherDecorationId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreDecoration decoration = loadRetailStoreDecoration(userContext, anotherDecorationId, emptyOptions());
			retailStore.updateDecoration(decoration);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());

			return present(userContext,retailStore, allTokens());

		}

 	}

	


	public CandidateRetailStoreDecoration requestCandidateDecoration(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreDecoration result = new CandidateRetailStoreDecoration();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("comment");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreDecoration> candidateList = retailStoreDecorationDaoOf(userContext).requestCandidateRetailStoreDecorationForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherOpening(RetailscmUserContext userContext, String retailStoreId, String anotherOpeningId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
 		checkerOf(userContext).checkIdOfRetailStoreOpening(anotherOpeningId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore transferToAnotherOpening(RetailscmUserContext userContext, String retailStoreId, String anotherOpeningId) throws Exception
 	{
 		checkParamsForTransferingAnotherOpening(userContext, retailStoreId,anotherOpeningId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreOpening opening = loadRetailStoreOpening(userContext, anotherOpeningId, emptyOptions());
			retailStore.updateOpening(opening);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());

			return present(userContext,retailStore, allTokens());

		}

 	}

	


	public CandidateRetailStoreOpening requestCandidateOpening(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreOpening result = new CandidateRetailStoreOpening();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("comment");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreOpening> candidateList = retailStoreOpeningDaoOf(userContext).requestCandidateRetailStoreOpeningForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 	protected void checkParamsForTransferingAnotherClosing(RetailscmUserContext userContext, String retailStoreId, String anotherClosingId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
 		checkerOf(userContext).checkIdOfRetailStoreClosing(anotherClosingId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

 	}
 	public RetailStore transferToAnotherClosing(RetailscmUserContext userContext, String retailStoreId, String anotherClosingId) throws Exception
 	{
 		checkParamsForTransferingAnotherClosing(userContext, retailStoreId,anotherClosingId);
 
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//will be good when the retailStore loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreClosing closing = loadRetailStoreClosing(userContext, anotherClosingId, emptyOptions());
			retailStore.updateClosing(closing);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStore = saveRetailStore(userContext, retailStore, emptyOptions());

			return present(userContext,retailStore, allTokens());

		}

 	}

	


	public CandidateRetailStoreClosing requestCandidateClosing(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreClosing result = new CandidateRetailStoreClosing();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("comment");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreClosing> candidateList = retailStoreClosingDaoOf(userContext).requestCandidateRetailStoreClosingForRetailStore(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreOpening loadRetailStoreOpening(RetailscmUserContext userContext, String newOpeningId, Map<String,Object> options) throws Exception
 	{
    
 		return retailStoreOpeningDaoOf(userContext).load(newOpeningId, options);
 	  
 	}
 	


	

 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newRetailStoreCountryCenterId, Map<String,Object> options) throws Exception
 	{
    
 		return retailStoreCountryCenterDaoOf(userContext).load(newRetailStoreCountryCenterId, options);
 	  
 	}
 	


	

 	protected RetailStoreCityServiceCenter loadRetailStoreCityServiceCenter(RetailscmUserContext userContext, String newCityServiceCenterId, Map<String,Object> options) throws Exception
 	{
    
 		return retailStoreCityServiceCenterDaoOf(userContext).load(newCityServiceCenterId, options);
 	  
 	}
 	


	

 	protected RetailStoreClosing loadRetailStoreClosing(RetailscmUserContext userContext, String newClosingId, Map<String,Object> options) throws Exception
 	{
    
 		return retailStoreClosingDaoOf(userContext).load(newClosingId, options);
 	  
 	}
 	


	

 	protected RetailStoreCreation loadRetailStoreCreation(RetailscmUserContext userContext, String newCreationId, Map<String,Object> options) throws Exception
 	{
    
 		return retailStoreCreationDaoOf(userContext).load(newCreationId, options);
 	  
 	}
 	


	

 	protected RetailStoreFranchising loadRetailStoreFranchising(RetailscmUserContext userContext, String newFranchisingId, Map<String,Object> options) throws Exception
 	{
    
 		return retailStoreFranchisingDaoOf(userContext).load(newFranchisingId, options);
 	  
 	}
 	


	

 	protected RetailStoreDecoration loadRetailStoreDecoration(RetailscmUserContext userContext, String newDecorationId, Map<String,Object> options) throws Exception
 	{
    
 		return retailStoreDecorationDaoOf(userContext).load(newDecorationId, options);
 	  
 	}
 	


	

 	protected RetailStoreInvestmentInvitation loadRetailStoreInvestmentInvitation(RetailscmUserContext userContext, String newInvestmentInvitationId, Map<String,Object> options) throws Exception
 	{
    
 		return retailStoreInvestmentInvitationDaoOf(userContext).load(newInvestmentInvitationId, options);
 	  
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreId, int retailStoreVersion) throws Exception {
		//deleteInternal(userContext, retailStoreId, retailStoreVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreId, int retailStoreVersion) throws Exception{

		retailStoreDaoOf(userContext).delete(retailStoreId, retailStoreVersion);
	}

	public RetailStore forgetByAll(RetailscmUserContext userContext, String retailStoreId, int retailStoreVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreId, retailStoreVersion);
	}
	protected RetailStore forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreId, int retailStoreVersion) throws Exception{

		return retailStoreDaoOf(userContext).disconnectFromAll(retailStoreId, retailStoreVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return retailStoreDaoOf(userContext).deleteAll();
	}





	protected void checkParamsForAddingConsumerOrder(RetailscmUserContext userContext, String retailStoreId, String title, String consumerId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStore(retailStoreId);


		checkerOf(userContext).checkTitleOfConsumerOrder(title);

		checkerOf(userContext).checkConsumerIdOfConsumerOrder(consumerId);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);



	}
	public  RetailStore addConsumerOrder(RetailscmUserContext userContext, String retailStoreId, String title, String consumerId, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingConsumerOrder(userContext,retailStoreId,title, consumerId,tokensExpr);

		ConsumerOrder consumerOrder = createConsumerOrder(userContext,title, consumerId);

		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, emptyOptions());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.addConsumerOrder( consumerOrder );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
			
			consumerOrderManagerOf(userContext).onNewInstanceCreated(userContext, consumerOrder);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingConsumerOrderProperties(RetailscmUserContext userContext, String retailStoreId,String id,String title,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkIdOfConsumerOrder(id);

		checkerOf(userContext).checkTitleOfConsumerOrder( title);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}
	public  RetailStore updateConsumerOrderProperties(RetailscmUserContext userContext, String retailStoreId, String id,String title, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingConsumerOrderProperties(userContext,retailStoreId,id,title,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withConsumerOrderListList()
				.searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, tokens().is(), id).done();

		RetailStore retailStoreToUpdate = loadRetailStore(userContext, retailStoreId, options);

		if(retailStoreToUpdate.getConsumerOrderList().isEmpty()){
			throw new RetailStoreManagerException("ConsumerOrder is NOT FOUND with id: '"+id+"'");
		}

		ConsumerOrder item = retailStoreToUpdate.getConsumerOrderList().first();
		beforeUpdateConsumerOrderProperties(userContext,item, retailStoreId,id,title,tokensExpr);
		item.updateTitle( title );


		//checkParamsForAddingConsumerOrder(userContext,retailStoreId,name, code, used,tokensExpr);
		RetailStore retailStore = saveRetailStore(userContext, retailStoreToUpdate, tokens().withConsumerOrderList().done());
		synchronized(retailStore){
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateConsumerOrderProperties(RetailscmUserContext userContext, ConsumerOrder item, String retailStoreId, String id,String title, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected ConsumerOrder createConsumerOrder(RetailscmUserContext userContext, String title, String consumerId) throws Exception{

		ConsumerOrder consumerOrder = new ConsumerOrder();
		
		
		consumerOrder.setTitle(title);		
		RetailStoreMember  consumer = new RetailStoreMember();
		consumer.setId(consumerId);		
		consumerOrder.setConsumer(consumer);		
		consumerOrder.setLastUpdateTime(userContext.now());
	
		
		return consumerOrder;


	}

	protected ConsumerOrder createIndexedConsumerOrder(String id, int version){

		ConsumerOrder consumerOrder = new ConsumerOrder();
		consumerOrder.setId(id);
		consumerOrder.setVersion(version);
		return consumerOrder;

	}

	protected void checkParamsForRemovingConsumerOrderList(RetailscmUserContext userContext, String retailStoreId,
			String consumerOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		for(String consumerOrderIdItem: consumerOrderIds){
			checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore removeConsumerOrderList(RetailscmUserContext userContext, String retailStoreId,
			String consumerOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingConsumerOrderList(userContext, retailStoreId,  consumerOrderIds, tokensExpr);


			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
			synchronized(retailStore){
				//Will be good when the retailStore loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreDaoOf(userContext).planToRemoveConsumerOrderList(retailStore, consumerOrderIds, allTokens());
				retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
				deleteRelationListInGraph(userContext, retailStore.getConsumerOrderList());
				return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingConsumerOrder(RetailscmUserContext userContext, String retailStoreId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStore( retailStoreId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}
	public  RetailStore removeConsumerOrder(RetailscmUserContext userContext, String retailStoreId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingConsumerOrder(userContext,retailStoreId, consumerOrderId, consumerOrderVersion,tokensExpr);

		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.removeConsumerOrder( consumerOrder );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
			deleteRelationInGraph(userContext, consumerOrder);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingConsumerOrder(RetailscmUserContext userContext, String retailStoreId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStore( retailStoreId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}
	public  RetailStore copyConsumerOrderFrom(RetailscmUserContext userContext, String retailStoreId,
		String consumerOrderId, int consumerOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingConsumerOrder(userContext,retailStoreId, consumerOrderId, consumerOrderVersion,tokensExpr);

		ConsumerOrder consumerOrder = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			consumerOrder.updateLastUpdateTime(userContext.now());

			retailStore.copyConsumerOrderFrom( consumerOrder );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
			
			consumerOrderManagerOf(userContext).onNewInstanceCreated(userContext, (ConsumerOrder)retailStore.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingConsumerOrder(RetailscmUserContext userContext, String retailStoreId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkIdOfConsumerOrder(consumerOrderId);
		checkerOf(userContext).checkVersionOfConsumerOrder(consumerOrderVersion);


		if(ConsumerOrder.TITLE_PROPERTY.equals(property)){
			checkerOf(userContext).checkTitleOfConsumerOrder(parseString(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}

	public  RetailStore updateConsumerOrder(RetailscmUserContext userContext, String retailStoreId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingConsumerOrder(userContext, retailStoreId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withConsumerOrderList().searchConsumerOrderListWith(ConsumerOrder.ID_PROPERTY, tokens().equals(), consumerOrderId).done();



		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, loadTokens);

		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStore.removeConsumerOrder( consumerOrder );
			//make changes to AcceleraterAccount.
			ConsumerOrder consumerOrderIdVersionKey = createIndexedConsumerOrder(consumerOrderId, consumerOrderVersion);

			ConsumerOrder consumerOrder = retailStore.findTheConsumerOrder(consumerOrderIdVersionKey);
			if(consumerOrder == null){
				throw new RetailStoreManagerException(consumerOrderId+" is NOT FOUND" );
			}

			beforeUpdateConsumerOrder(userContext, consumerOrder, retailStoreId, consumerOrderId, consumerOrderVersion, property, newValueExpr,  tokensExpr);
			consumerOrder.changeProperty(property, newValueExpr);
			consumerOrder.updateLastUpdateTime(userContext.now());
			retailStore = saveRetailStore(userContext, retailStore, tokens().withConsumerOrderList().done());
			consumerOrderManagerOf(userContext).onUpdated(userContext, consumerOrder, this, "updateConsumerOrder");
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateConsumerOrder(RetailscmUserContext userContext, ConsumerOrder existed, String retailStoreId, String consumerOrderId, int consumerOrderVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	protected void checkParamsForAddingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreId, String sellerId, String title, BigDecimal totalAmount,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStore(retailStoreId);


		checkerOf(userContext).checkSellerIdOfRetailStoreOrder(sellerId);

		checkerOf(userContext).checkTitleOfRetailStoreOrder(title);

		checkerOf(userContext).checkTotalAmountOfRetailStoreOrder(totalAmount);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);



	}
	public  RetailStore addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreId, String sellerId, String title, BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingRetailStoreOrder(userContext,retailStoreId,sellerId, title, totalAmount,tokensExpr);

		RetailStoreOrder retailStoreOrder = createRetailStoreOrder(userContext,sellerId, title, totalAmount);

		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, emptyOptions());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.addRetailStoreOrder( retailStoreOrder );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
			
			retailStoreOrderManagerOf(userContext).onNewInstanceCreated(userContext, retailStoreOrder);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreOrderProperties(RetailscmUserContext userContext, String retailStoreId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(id);

		checkerOf(userContext).checkTitleOfRetailStoreOrder( title);
		checkerOf(userContext).checkTotalAmountOfRetailStoreOrder( totalAmount);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}
	public  RetailStore updateRetailStoreOrderProperties(RetailscmUserContext userContext, String retailStoreId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderProperties(userContext,retailStoreId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreOrderListList()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, tokens().is(), id).done();

		RetailStore retailStoreToUpdate = loadRetailStore(userContext, retailStoreId, options);

		if(retailStoreToUpdate.getRetailStoreOrderList().isEmpty()){
			throw new RetailStoreManagerException("RetailStoreOrder is NOT FOUND with id: '"+id+"'");
		}

		RetailStoreOrder item = retailStoreToUpdate.getRetailStoreOrderList().first();
		beforeUpdateRetailStoreOrderProperties(userContext,item, retailStoreId,id,title,totalAmount,tokensExpr);
		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );


		//checkParamsForAddingRetailStoreOrder(userContext,retailStoreId,name, code, used,tokensExpr);
		RetailStore retailStore = saveRetailStore(userContext, retailStoreToUpdate, tokens().withRetailStoreOrderList().done());
		synchronized(retailStore){
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateRetailStoreOrderProperties(RetailscmUserContext userContext, RetailStoreOrder item, String retailStoreId, String id,String title,BigDecimal totalAmount, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected RetailStoreOrder createRetailStoreOrder(RetailscmUserContext userContext, String sellerId, String title, BigDecimal totalAmount) throws Exception{

		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
		
		
		RetailStoreCountryCenter  seller = new RetailStoreCountryCenter();
		seller.setId(sellerId);		
		retailStoreOrder.setSeller(seller);		
		retailStoreOrder.setTitle(title);		
		retailStoreOrder.setTotalAmount(totalAmount);		
		retailStoreOrder.setLastUpdateTime(userContext.now());
	
		
		return retailStoreOrder;


	}

	protected RetailStoreOrder createIndexedRetailStoreOrder(String id, int version){

		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
		retailStoreOrder.setId(id);
		retailStoreOrder.setVersion(version);
		return retailStoreOrder;

	}

	protected void checkParamsForRemovingRetailStoreOrderList(RetailscmUserContext userContext, String retailStoreId,
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		for(String retailStoreOrderIdItem: retailStoreOrderIds){
			checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore removeRetailStoreOrderList(RetailscmUserContext userContext, String retailStoreId,
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreOrderList(userContext, retailStoreId,  retailStoreOrderIds, tokensExpr);


			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
			synchronized(retailStore){
				//Will be good when the retailStore loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreDaoOf(userContext).planToRemoveRetailStoreOrderList(retailStore, retailStoreOrderIds, allTokens());
				retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
				deleteRelationListInGraph(userContext, retailStore.getRetailStoreOrderList());
				return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStore( retailStoreId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}
	public  RetailStore removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStoreOrder(userContext,retailStoreId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);

		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.removeRetailStoreOrder( retailStoreOrder );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
			deleteRelationInGraph(userContext, retailStoreOrder);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStore( retailStoreId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}
	public  RetailStore copyRetailStoreOrderFrom(RetailscmUserContext userContext, String retailStoreId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStoreOrder(userContext,retailStoreId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);

		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			retailStoreOrder.updateLastUpdateTime(userContext.now());

			retailStore.copyRetailStoreOrderFrom( retailStoreOrder );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
			
			retailStoreOrderManagerOf(userContext).onNewInstanceCreated(userContext, (RetailStoreOrder)retailStore.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);


		if(RetailStoreOrder.TITLE_PROPERTY.equals(property)){
			checkerOf(userContext).checkTitleOfRetailStoreOrder(parseString(newValueExpr));
		}
		
		if(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
			checkerOf(userContext).checkTotalAmountOfRetailStoreOrder(parseBigDecimal(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}

	public  RetailStore updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreOrderList().searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, tokens().equals(), retailStoreOrderId).done();



		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, loadTokens);

		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStore.removeRetailStoreOrder( retailStoreOrder );
			//make changes to AcceleraterAccount.
			RetailStoreOrder retailStoreOrderIdVersionKey = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);

			RetailStoreOrder retailStoreOrder = retailStore.findTheRetailStoreOrder(retailStoreOrderIdVersionKey);
			if(retailStoreOrder == null){
				throw new RetailStoreManagerException(retailStoreOrderId+" is NOT FOUND" );
			}

			beforeUpdateRetailStoreOrder(userContext, retailStoreOrder, retailStoreId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);
			retailStoreOrder.changeProperty(property, newValueExpr);
			retailStoreOrder.updateLastUpdateTime(userContext.now());
			retailStore = saveRetailStore(userContext, retailStore, tokens().withRetailStoreOrderList().done());
			retailStoreOrderManagerOf(userContext).onUpdated(userContext, retailStoreOrder, this, "updateRetailStoreOrder");
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateRetailStoreOrder(RetailscmUserContext userContext, RetailStoreOrder existed, String retailStoreId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	protected void checkParamsForAddingGoods(RetailscmUserContext userContext, String retailStoreId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String bizOrderId, String retailStoreOrderId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStore(retailStoreId);


		checkerOf(userContext).checkNameOfGoods(name);

		checkerOf(userContext).checkRfidOfGoods(rfid);

		checkerOf(userContext).checkUomOfGoods(uom);

		checkerOf(userContext).checkMaxPackageOfGoods(maxPackage);

		checkerOf(userContext).checkExpireTimeOfGoods(expireTime);

		checkerOf(userContext).checkSkuIdOfGoods(skuId);

		checkerOf(userContext).checkReceivingSpaceIdOfGoods(receivingSpaceId);

		checkerOf(userContext).checkGoodsAllocationIdOfGoods(goodsAllocationId);

		checkerOf(userContext).checkSmartPalletIdOfGoods(smartPalletId);

		checkerOf(userContext).checkShippingSpaceIdOfGoods(shippingSpaceId);

		checkerOf(userContext).checkTransportTaskIdOfGoods(transportTaskId);

		checkerOf(userContext).checkBizOrderIdOfGoods(bizOrderId);

		checkerOf(userContext).checkRetailStoreOrderIdOfGoods(retailStoreOrderId);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);



	}
	public  RetailStore addGoods(RetailscmUserContext userContext, String retailStoreId, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String bizOrderId, String retailStoreOrderId, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingGoods(userContext,retailStoreId,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, bizOrderId, retailStoreOrderId,tokensExpr);

		Goods goods = createGoods(userContext,name, rfid, uom, maxPackage, expireTime, skuId, receivingSpaceId, goodsAllocationId, smartPalletId, shippingSpaceId, transportTaskId, bizOrderId, retailStoreOrderId);

		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, emptyOptions());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.addGoods( goods );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
			
			goodsManagerOf(userContext).onNewInstanceCreated(userContext, goods);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsProperties(RetailscmUserContext userContext, String retailStoreId,String id,String name,String rfid,String uom,int maxPackage,Date expireTime,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkIdOfGoods(id);

		checkerOf(userContext).checkNameOfGoods( name);
		checkerOf(userContext).checkRfidOfGoods( rfid);
		checkerOf(userContext).checkUomOfGoods( uom);
		checkerOf(userContext).checkMaxPackageOfGoods( maxPackage);
		checkerOf(userContext).checkExpireTimeOfGoods( expireTime);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}
	public  RetailStore updateGoodsProperties(RetailscmUserContext userContext, String retailStoreId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingGoodsProperties(userContext,retailStoreId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsListList()
				.searchGoodsListWith(Goods.ID_PROPERTY, tokens().is(), id).done();

		RetailStore retailStoreToUpdate = loadRetailStore(userContext, retailStoreId, options);

		if(retailStoreToUpdate.getGoodsList().isEmpty()){
			throw new RetailStoreManagerException("Goods is NOT FOUND with id: '"+id+"'");
		}

		Goods item = retailStoreToUpdate.getGoodsList().first();
		beforeUpdateGoodsProperties(userContext,item, retailStoreId,id,name,rfid,uom,maxPackage,expireTime,tokensExpr);
		item.updateName( name );
		item.updateRfid( rfid );
		item.updateUom( uom );
		item.updateMaxPackage( maxPackage );
		item.updateExpireTime( expireTime );


		//checkParamsForAddingGoods(userContext,retailStoreId,name, code, used,tokensExpr);
		RetailStore retailStore = saveRetailStore(userContext, retailStoreToUpdate, tokens().withGoodsList().done());
		synchronized(retailStore){
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateGoodsProperties(RetailscmUserContext userContext, Goods item, String retailStoreId, String id,String name,String rfid,String uom,int maxPackage,Date expireTime, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected Goods createGoods(RetailscmUserContext userContext, String name, String rfid, String uom, int maxPackage, Date expireTime, String skuId, String receivingSpaceId, String goodsAllocationId, String smartPalletId, String shippingSpaceId, String transportTaskId, String bizOrderId, String retailStoreOrderId) throws Exception{

		Goods goods = new Goods();
		
		
		goods.setName(name);		
		goods.setRfid(rfid);		
		goods.setUom(uom);		
		goods.setMaxPackage(maxPackage);		
		goods.setExpireTime(expireTime);		
		Sku  sku = new Sku();
		sku.setId(skuId);		
		goods.setSku(sku);		
		ReceivingSpace  receivingSpace = new ReceivingSpace();
		receivingSpace.setId(receivingSpaceId);		
		goods.setReceivingSpace(receivingSpace);		
		GoodsAllocation  goodsAllocation = new GoodsAllocation();
		goodsAllocation.setId(goodsAllocationId);		
		goods.setGoodsAllocation(goodsAllocation);		
		SmartPallet  smartPallet = new SmartPallet();
		smartPallet.setId(smartPalletId);		
		goods.setSmartPallet(smartPallet);		
		ShippingSpace  shippingSpace = new ShippingSpace();
		shippingSpace.setId(shippingSpaceId);		
		goods.setShippingSpace(shippingSpace);		
		TransportTask  transportTask = new TransportTask();
		transportTask.setId(transportTaskId);		
		goods.setTransportTask(transportTask);		
		SupplyOrder  bizOrder = new SupplyOrder();
		bizOrder.setId(bizOrderId);		
		goods.setBizOrder(bizOrder);		
		RetailStoreOrder  retailStoreOrder = new RetailStoreOrder();
		retailStoreOrder.setId(retailStoreOrderId);		
		goods.setRetailStoreOrder(retailStoreOrder);
	
		
		return goods;


	}

	protected Goods createIndexedGoods(String id, int version){

		Goods goods = new Goods();
		goods.setId(id);
		goods.setVersion(version);
		return goods;

	}

	protected void checkParamsForRemovingGoodsList(RetailscmUserContext userContext, String retailStoreId,
			String goodsIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		for(String goodsIdItem: goodsIds){
			checkerOf(userContext).checkIdOfGoods(goodsIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore removeGoodsList(RetailscmUserContext userContext, String retailStoreId,
			String goodsIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingGoodsList(userContext, retailStoreId,  goodsIds, tokensExpr);


			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
			synchronized(retailStore){
				//Will be good when the retailStore loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreDaoOf(userContext).planToRemoveGoodsList(retailStore, goodsIds, allTokens());
				retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
				deleteRelationListInGraph(userContext, retailStore.getGoodsList());
				return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingGoods(RetailscmUserContext userContext, String retailStoreId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStore( retailStoreId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}
	public  RetailStore removeGoods(RetailscmUserContext userContext, String retailStoreId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingGoods(userContext,retailStoreId, goodsId, goodsVersion,tokensExpr);

		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.removeGoods( goods );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
			deleteRelationInGraph(userContext, goods);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingGoods(RetailscmUserContext userContext, String retailStoreId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStore( retailStoreId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}
	public  RetailStore copyGoodsFrom(RetailscmUserContext userContext, String retailStoreId,
		String goodsId, int goodsVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingGoods(userContext,retailStoreId, goodsId, goodsVersion,tokensExpr);

		Goods goods = createIndexedGoods(goodsId, goodsVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStore.copyGoodsFrom( goods );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
			
			goodsManagerOf(userContext).onNewInstanceCreated(userContext, (Goods)retailStore.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingGoods(RetailscmUserContext userContext, String retailStoreId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkIdOfGoods(goodsId);
		checkerOf(userContext).checkVersionOfGoods(goodsVersion);


		if(Goods.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfGoods(parseString(newValueExpr));
		}
		
		if(Goods.RFID_PROPERTY.equals(property)){
			checkerOf(userContext).checkRfidOfGoods(parseString(newValueExpr));
		}
		
		if(Goods.UOM_PROPERTY.equals(property)){
			checkerOf(userContext).checkUomOfGoods(parseString(newValueExpr));
		}
		
		if(Goods.MAX_PACKAGE_PROPERTY.equals(property)){
			checkerOf(userContext).checkMaxPackageOfGoods(parseInt(newValueExpr));
		}
		
		if(Goods.EXPIRE_TIME_PROPERTY.equals(property)){
			checkerOf(userContext).checkExpireTimeOfGoods(parseDate(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}

	public  RetailStore updateGoods(RetailscmUserContext userContext, String retailStoreId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingGoods(userContext, retailStoreId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withGoodsList().searchGoodsListWith(Goods.ID_PROPERTY, tokens().equals(), goodsId).done();



		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, loadTokens);

		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStore.removeGoods( goods );
			//make changes to AcceleraterAccount.
			Goods goodsIdVersionKey = createIndexedGoods(goodsId, goodsVersion);

			Goods goods = retailStore.findTheGoods(goodsIdVersionKey);
			if(goods == null){
				throw new RetailStoreManagerException(goodsId+" is NOT FOUND" );
			}

			beforeUpdateGoods(userContext, goods, retailStoreId, goodsId, goodsVersion, property, newValueExpr,  tokensExpr);
			goods.changeProperty(property, newValueExpr);
			
			retailStore = saveRetailStore(userContext, retailStore, tokens().withGoodsList().done());
			goodsManagerOf(userContext).onUpdated(userContext, goods, this, "updateGoods");
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateGoods(RetailscmUserContext userContext, Goods existed, String retailStoreId, String goodsId, int goodsVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	protected void checkParamsForAddingTransportTask(RetailscmUserContext userContext, String retailStoreId, String name, String start, Date beginTime, String driverId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStore(retailStoreId);


		checkerOf(userContext).checkNameOfTransportTask(name);

		checkerOf(userContext).checkStartOfTransportTask(start);

		checkerOf(userContext).checkBeginTimeOfTransportTask(beginTime);

		checkerOf(userContext).checkDriverIdOfTransportTask(driverId);

		checkerOf(userContext).checkTruckIdOfTransportTask(truckId);

		checkerOf(userContext).checkBelongsToIdOfTransportTask(belongsToId);

		checkerOf(userContext).checkLatitudeOfTransportTask(latitude);

		checkerOf(userContext).checkLongitudeOfTransportTask(longitude);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);



	}
	public  RetailStore addTransportTask(RetailscmUserContext userContext, String retailStoreId, String name, String start, Date beginTime, String driverId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingTransportTask(userContext,retailStoreId,name, start, beginTime, driverId, truckId, belongsToId, latitude, longitude,tokensExpr);

		TransportTask transportTask = createTransportTask(userContext,name, start, beginTime, driverId, truckId, belongsToId, latitude, longitude);

		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, emptyOptions());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.addTransportTask( transportTask );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
			
			transportTaskManagerOf(userContext).onNewInstanceCreated(userContext, transportTask);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportTaskProperties(RetailscmUserContext userContext, String retailStoreId,String id,String name,String start,Date beginTime,BigDecimal latitude,BigDecimal longitude,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkIdOfTransportTask(id);

		checkerOf(userContext).checkNameOfTransportTask( name);
		checkerOf(userContext).checkStartOfTransportTask( start);
		checkerOf(userContext).checkBeginTimeOfTransportTask( beginTime);
		checkerOf(userContext).checkLatitudeOfTransportTask( latitude);
		checkerOf(userContext).checkLongitudeOfTransportTask( longitude);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}
	public  RetailStore updateTransportTaskProperties(RetailscmUserContext userContext, String retailStoreId, String id,String name,String start,Date beginTime,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTransportTaskProperties(userContext,retailStoreId,id,name,start,beginTime,latitude,longitude,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportTaskListList()
				.searchTransportTaskListWith(TransportTask.ID_PROPERTY, tokens().is(), id).done();

		RetailStore retailStoreToUpdate = loadRetailStore(userContext, retailStoreId, options);

		if(retailStoreToUpdate.getTransportTaskList().isEmpty()){
			throw new RetailStoreManagerException("TransportTask is NOT FOUND with id: '"+id+"'");
		}

		TransportTask item = retailStoreToUpdate.getTransportTaskList().first();
		beforeUpdateTransportTaskProperties(userContext,item, retailStoreId,id,name,start,beginTime,latitude,longitude,tokensExpr);
		item.updateName( name );
		item.updateStart( start );
		item.updateBeginTime( beginTime );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );


		//checkParamsForAddingTransportTask(userContext,retailStoreId,name, code, used,tokensExpr);
		RetailStore retailStore = saveRetailStore(userContext, retailStoreToUpdate, tokens().withTransportTaskList().done());
		synchronized(retailStore){
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateTransportTaskProperties(RetailscmUserContext userContext, TransportTask item, String retailStoreId, String id,String name,String start,Date beginTime,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected TransportTask createTransportTask(RetailscmUserContext userContext, String name, String start, Date beginTime, String driverId, String truckId, String belongsToId, BigDecimal latitude, BigDecimal longitude) throws Exception{

		TransportTask transportTask = new TransportTask();
		
		
		transportTask.setName(name);		
		transportTask.setStart(start);		
		transportTask.setBeginTime(beginTime);		
		TruckDriver  driver = new TruckDriver();
		driver.setId(driverId);		
		transportTask.setDriver(driver);		
		TransportTruck  truck = new TransportTruck();
		truck.setId(truckId);		
		transportTask.setTruck(truck);		
		TransportFleet  belongsTo = new TransportFleet();
		belongsTo.setId(belongsToId);		
		transportTask.setBelongsTo(belongsTo);		
		transportTask.setLatitude(latitude);		
		transportTask.setLongitude(longitude);
	
		
		return transportTask;


	}

	protected TransportTask createIndexedTransportTask(String id, int version){

		TransportTask transportTask = new TransportTask();
		transportTask.setId(id);
		transportTask.setVersion(version);
		return transportTask;

	}

	protected void checkParamsForRemovingTransportTaskList(RetailscmUserContext userContext, String retailStoreId,
			String transportTaskIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		for(String transportTaskIdItem: transportTaskIds){
			checkerOf(userContext).checkIdOfTransportTask(transportTaskIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore removeTransportTaskList(RetailscmUserContext userContext, String retailStoreId,
			String transportTaskIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingTransportTaskList(userContext, retailStoreId,  transportTaskIds, tokensExpr);


			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
			synchronized(retailStore){
				//Will be good when the retailStore loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreDaoOf(userContext).planToRemoveTransportTaskList(retailStore, transportTaskIds, allTokens());
				retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
				deleteRelationListInGraph(userContext, retailStore.getTransportTaskList());
				return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingTransportTask(RetailscmUserContext userContext, String retailStoreId,
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStore( retailStoreId);
		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).checkVersionOfTransportTask(transportTaskVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}
	public  RetailStore removeTransportTask(RetailscmUserContext userContext, String retailStoreId,
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingTransportTask(userContext,retailStoreId, transportTaskId, transportTaskVersion,tokensExpr);

		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.removeTransportTask( transportTask );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
			deleteRelationInGraph(userContext, transportTask);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingTransportTask(RetailscmUserContext userContext, String retailStoreId,
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStore( retailStoreId);
		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).checkVersionOfTransportTask(transportTaskVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}
	public  RetailStore copyTransportTaskFrom(RetailscmUserContext userContext, String retailStoreId,
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingTransportTask(userContext,retailStoreId, transportTaskId, transportTaskVersion,tokensExpr);

		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStore.copyTransportTaskFrom( transportTask );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
			
			transportTaskManagerOf(userContext).onNewInstanceCreated(userContext, (TransportTask)retailStore.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingTransportTask(RetailscmUserContext userContext, String retailStoreId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).checkVersionOfTransportTask(transportTaskVersion);


		if(TransportTask.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfTransportTask(parseString(newValueExpr));
		}
		
		if(TransportTask.START_PROPERTY.equals(property)){
			checkerOf(userContext).checkStartOfTransportTask(parseString(newValueExpr));
		}
		
		if(TransportTask.BEGIN_TIME_PROPERTY.equals(property)){
			checkerOf(userContext).checkBeginTimeOfTransportTask(parseDate(newValueExpr));
		}
		
		if(TransportTask.LATITUDE_PROPERTY.equals(property)){
			checkerOf(userContext).checkLatitudeOfTransportTask(parseBigDecimal(newValueExpr));
		}
		
		if(TransportTask.LONGITUDE_PROPERTY.equals(property)){
			checkerOf(userContext).checkLongitudeOfTransportTask(parseBigDecimal(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}

	public  RetailStore updateTransportTask(RetailscmUserContext userContext, String retailStoreId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingTransportTask(userContext, retailStoreId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withTransportTaskList().searchTransportTaskListWith(TransportTask.ID_PROPERTY, tokens().equals(), transportTaskId).done();



		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, loadTokens);

		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStore.removeTransportTask( transportTask );
			//make changes to AcceleraterAccount.
			TransportTask transportTaskIdVersionKey = createIndexedTransportTask(transportTaskId, transportTaskVersion);

			TransportTask transportTask = retailStore.findTheTransportTask(transportTaskIdVersionKey);
			if(transportTask == null){
				throw new RetailStoreManagerException(transportTaskId+" is NOT FOUND" );
			}

			beforeUpdateTransportTask(userContext, transportTask, retailStoreId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);
			transportTask.changeProperty(property, newValueExpr);
			
			retailStore = saveRetailStore(userContext, retailStore, tokens().withTransportTaskList().done());
			transportTaskManagerOf(userContext).onUpdated(userContext, transportTask, this, "updateTransportTask");
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateTransportTask(RetailscmUserContext userContext, TransportTask existed, String retailStoreId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	protected void checkParamsForAddingAccountSet(RetailscmUserContext userContext, String retailStoreId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String goodsSupplierId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStore(retailStoreId);


		checkerOf(userContext).checkNameOfAccountSet(name);

		checkerOf(userContext).checkYearSetOfAccountSet(yearSet);

		checkerOf(userContext).checkEffectiveDateOfAccountSet(effectiveDate);

		checkerOf(userContext).checkAccountingSystemOfAccountSet(accountingSystem);

		checkerOf(userContext).checkDomesticCurrencyCodeOfAccountSet(domesticCurrencyCode);

		checkerOf(userContext).checkDomesticCurrencyNameOfAccountSet(domesticCurrencyName);

		checkerOf(userContext).checkOpeningBankOfAccountSet(openingBank);

		checkerOf(userContext).checkAccountNumberOfAccountSet(accountNumber);

		checkerOf(userContext).checkCountryCenterIdOfAccountSet(countryCenterId);

		checkerOf(userContext).checkGoodsSupplierIdOfAccountSet(goodsSupplierId);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);



	}
	public  RetailStore addAccountSet(RetailscmUserContext userContext, String retailStoreId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String goodsSupplierId, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingAccountSet(userContext,retailStoreId,name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenterId, goodsSupplierId,tokensExpr);

		AccountSet accountSet = createAccountSet(userContext,name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenterId, goodsSupplierId);

		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, emptyOptions());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.addAccountSet( accountSet );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
			
			accountSetManagerOf(userContext).onNewInstanceCreated(userContext, accountSet);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountSetProperties(RetailscmUserContext userContext, String retailStoreId,String id,String name,String yearSet,Date effectiveDate,String accountingSystem,String domesticCurrencyCode,String domesticCurrencyName,String openingBank,String accountNumber,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkIdOfAccountSet(id);

		checkerOf(userContext).checkNameOfAccountSet( name);
		checkerOf(userContext).checkYearSetOfAccountSet( yearSet);
		checkerOf(userContext).checkEffectiveDateOfAccountSet( effectiveDate);
		checkerOf(userContext).checkAccountingSystemOfAccountSet( accountingSystem);
		checkerOf(userContext).checkDomesticCurrencyCodeOfAccountSet( domesticCurrencyCode);
		checkerOf(userContext).checkDomesticCurrencyNameOfAccountSet( domesticCurrencyName);
		checkerOf(userContext).checkOpeningBankOfAccountSet( openingBank);
		checkerOf(userContext).checkAccountNumberOfAccountSet( accountNumber);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}
	public  RetailStore updateAccountSetProperties(RetailscmUserContext userContext, String retailStoreId, String id,String name,String yearSet,Date effectiveDate,String accountingSystem,String domesticCurrencyCode,String domesticCurrencyName,String openingBank,String accountNumber, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountSetProperties(userContext,retailStoreId,id,name,yearSet,effectiveDate,accountingSystem,domesticCurrencyCode,domesticCurrencyName,openingBank,accountNumber,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountSetListList()
				.searchAccountSetListWith(AccountSet.ID_PROPERTY, tokens().is(), id).done();

		RetailStore retailStoreToUpdate = loadRetailStore(userContext, retailStoreId, options);

		if(retailStoreToUpdate.getAccountSetList().isEmpty()){
			throw new RetailStoreManagerException("AccountSet is NOT FOUND with id: '"+id+"'");
		}

		AccountSet item = retailStoreToUpdate.getAccountSetList().first();
		beforeUpdateAccountSetProperties(userContext,item, retailStoreId,id,name,yearSet,effectiveDate,accountingSystem,domesticCurrencyCode,domesticCurrencyName,openingBank,accountNumber,tokensExpr);
		item.updateName( name );
		item.updateYearSet( yearSet );
		item.updateEffectiveDate( effectiveDate );
		item.updateAccountingSystem( accountingSystem );
		item.updateDomesticCurrencyCode( domesticCurrencyCode );
		item.updateDomesticCurrencyName( domesticCurrencyName );
		item.updateOpeningBank( openingBank );
		item.updateAccountNumber( accountNumber );


		//checkParamsForAddingAccountSet(userContext,retailStoreId,name, code, used,tokensExpr);
		RetailStore retailStore = saveRetailStore(userContext, retailStoreToUpdate, tokens().withAccountSetList().done());
		synchronized(retailStore){
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateAccountSetProperties(RetailscmUserContext userContext, AccountSet item, String retailStoreId, String id,String name,String yearSet,Date effectiveDate,String accountingSystem,String domesticCurrencyCode,String domesticCurrencyName,String openingBank,String accountNumber, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected AccountSet createAccountSet(RetailscmUserContext userContext, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String countryCenterId, String goodsSupplierId) throws Exception{

		AccountSet accountSet = new AccountSet();
		
		
		accountSet.setName(name);		
		accountSet.setYearSet(yearSet);		
		accountSet.setEffectiveDate(effectiveDate);		
		accountSet.setAccountingSystem(accountingSystem);		
		accountSet.setDomesticCurrencyCode(domesticCurrencyCode);		
		accountSet.setDomesticCurrencyName(domesticCurrencyName);		
		accountSet.setOpeningBank(openingBank);		
		accountSet.setAccountNumber(accountNumber);		
		RetailStoreCountryCenter  countryCenter = new RetailStoreCountryCenter();
		countryCenter.setId(countryCenterId);		
		accountSet.setCountryCenter(countryCenter);		
		GoodsSupplier  goodsSupplier = new GoodsSupplier();
		goodsSupplier.setId(goodsSupplierId);		
		accountSet.setGoodsSupplier(goodsSupplier);		
		accountSet.setLastUpdateTime(userContext.now());
	
		
		return accountSet;


	}

	protected AccountSet createIndexedAccountSet(String id, int version){

		AccountSet accountSet = new AccountSet();
		accountSet.setId(id);
		accountSet.setVersion(version);
		return accountSet;

	}

	protected void checkParamsForRemovingAccountSetList(RetailscmUserContext userContext, String retailStoreId,
			String accountSetIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		for(String accountSetIdItem: accountSetIds){
			checkerOf(userContext).checkIdOfAccountSet(accountSetIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);

	}
	public  RetailStore removeAccountSetList(RetailscmUserContext userContext, String retailStoreId,
			String accountSetIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingAccountSetList(userContext, retailStoreId,  accountSetIds, tokensExpr);


			RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
			synchronized(retailStore){
				//Will be good when the retailStore loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreDaoOf(userContext).planToRemoveAccountSetList(retailStore, accountSetIds, allTokens());
				retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
				deleteRelationListInGraph(userContext, retailStore.getAccountSetList());
				return present(userContext,retailStore, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingAccountSet(RetailscmUserContext userContext, String retailStoreId,
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStore( retailStoreId);
		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		checkerOf(userContext).checkVersionOfAccountSet(accountSetVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}
	public  RetailStore removeAccountSet(RetailscmUserContext userContext, String retailStoreId,
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingAccountSet(userContext,retailStoreId, accountSetId, accountSetVersion,tokensExpr);

		AccountSet accountSet = createIndexedAccountSet(accountSetId, accountSetVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStore.removeAccountSet( accountSet );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
			deleteRelationInGraph(userContext, accountSet);
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingAccountSet(RetailscmUserContext userContext, String retailStoreId,
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStore( retailStoreId);
		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		checkerOf(userContext).checkVersionOfAccountSet(accountSetVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}
	public  RetailStore copyAccountSetFrom(RetailscmUserContext userContext, String retailStoreId,
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingAccountSet(userContext,retailStoreId, accountSetId, accountSetVersion,tokensExpr);

		AccountSet accountSet = createIndexedAccountSet(accountSetId, accountSetVersion);
		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, allTokens());
		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			accountSet.updateLastUpdateTime(userContext.now());

			retailStore.copyAccountSetFrom( accountSet );
			retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
			
			accountSetManagerOf(userContext).onNewInstanceCreated(userContext, (AccountSet)retailStore.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingAccountSet(RetailscmUserContext userContext, String retailStoreId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		checkerOf(userContext).checkVersionOfAccountSet(accountSetVersion);


		if(AccountSet.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfAccountSet(parseString(newValueExpr));
		}
		
		if(AccountSet.YEAR_SET_PROPERTY.equals(property)){
			checkerOf(userContext).checkYearSetOfAccountSet(parseString(newValueExpr));
		}
		
		if(AccountSet.EFFECTIVE_DATE_PROPERTY.equals(property)){
			checkerOf(userContext).checkEffectiveDateOfAccountSet(parseDate(newValueExpr));
		}
		
		if(AccountSet.ACCOUNTING_SYSTEM_PROPERTY.equals(property)){
			checkerOf(userContext).checkAccountingSystemOfAccountSet(parseString(newValueExpr));
		}
		
		if(AccountSet.DOMESTIC_CURRENCY_CODE_PROPERTY.equals(property)){
			checkerOf(userContext).checkDomesticCurrencyCodeOfAccountSet(parseString(newValueExpr));
		}
		
		if(AccountSet.DOMESTIC_CURRENCY_NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkDomesticCurrencyNameOfAccountSet(parseString(newValueExpr));
		}
		
		if(AccountSet.OPENING_BANK_PROPERTY.equals(property)){
			checkerOf(userContext).checkOpeningBankOfAccountSet(parseString(newValueExpr));
		}
		
		if(AccountSet.ACCOUNT_NUMBER_PROPERTY.equals(property)){
			checkerOf(userContext).checkAccountNumberOfAccountSet(parseString(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreManagerException.class);


	}

	public  RetailStore updateAccountSet(RetailscmUserContext userContext, String retailStoreId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingAccountSet(userContext, retailStoreId, accountSetId, accountSetVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withAccountSetList().searchAccountSetListWith(AccountSet.ID_PROPERTY, tokens().equals(), accountSetId).done();



		RetailStore retailStore = loadRetailStore(userContext, retailStoreId, loadTokens);

		synchronized(retailStore){
			//Will be good when the retailStore loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStore.removeAccountSet( accountSet );
			//make changes to AcceleraterAccount.
			AccountSet accountSetIdVersionKey = createIndexedAccountSet(accountSetId, accountSetVersion);

			AccountSet accountSet = retailStore.findTheAccountSet(accountSetIdVersionKey);
			if(accountSet == null){
				throw new RetailStoreManagerException(accountSetId+" is NOT FOUND" );
			}

			beforeUpdateAccountSet(userContext, accountSet, retailStoreId, accountSetId, accountSetVersion, property, newValueExpr,  tokensExpr);
			accountSet.changeProperty(property, newValueExpr);
			accountSet.updateLastUpdateTime(userContext.now());
			retailStore = saveRetailStore(userContext, retailStore, tokens().withAccountSetList().done());
			accountSetManagerOf(userContext).onUpdated(userContext, accountSet, this, "updateAccountSet");
			return present(userContext,retailStore, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateAccountSet(RetailscmUserContext userContext, AccountSet existed, String retailStoreId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStore newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    retailStoreDaoOf(ctx).loadAllAsStream().forEach(
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
		//   RetailStore newRetailStore = this.createRetailStore(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStore
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
    key.put(UserApp.APP_TYPE_PROPERTY, RetailStore.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<RetailStore> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreCountryCenter> retailStoreCountryCenterList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCountryCenter.class);
		userContext.getDAOGroup().enhanceList(retailStoreCountryCenterList, RetailStoreCountryCenter.class);
		List<RetailStoreCityServiceCenter> cityServiceCenterList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCityServiceCenter.class);
		userContext.getDAOGroup().enhanceList(cityServiceCenterList, RetailStoreCityServiceCenter.class);
		List<RetailStoreCreation> creationList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCreation.class);
		userContext.getDAOGroup().enhanceList(creationList, RetailStoreCreation.class);
		List<RetailStoreInvestmentInvitation> investmentInvitationList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreInvestmentInvitation.class);
		userContext.getDAOGroup().enhanceList(investmentInvitationList, RetailStoreInvestmentInvitation.class);
		List<RetailStoreFranchising> franchisingList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreFranchising.class);
		userContext.getDAOGroup().enhanceList(franchisingList, RetailStoreFranchising.class);
		List<RetailStoreDecoration> decorationList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreDecoration.class);
		userContext.getDAOGroup().enhanceList(decorationList, RetailStoreDecoration.class);
		List<RetailStoreOpening> openingList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreOpening.class);
		userContext.getDAOGroup().enhanceList(openingList, RetailStoreOpening.class);
		List<RetailStoreClosing> closingList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreClosing.class);
		userContext.getDAOGroup().enhanceList(closingList, RetailStoreClosing.class);


    }
	
	public Object listByRetailStoreCountryCenter(RetailscmUserContext userContext,String retailStoreCountryCenterId) throws Exception {
		return listPageByRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByRetailStoreCountryCenter(RetailscmUserContext userContext,String retailStoreCountryCenterId, int start, int count) throws Exception {
		SmartList<RetailStore> list = retailStoreDaoOf(userContext).findRetailStoreByRetailStoreCountryCenter(retailStoreCountryCenterId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(RetailStore.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(retailStoreCountryCenterId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("双链小超列表");
		page.setRequestName("listByRetailStoreCountryCenter");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByRetailStoreCountryCenter/%s/",  getBeanName(), retailStoreCountryCenterId)));

		page.assemblerContent(userContext, "listByRetailStoreCountryCenter");
		return page.doRender(userContext);
	}
  
	public Object listByCityServiceCenter(RetailscmUserContext userContext,String cityServiceCenterId) throws Exception {
		return listPageByCityServiceCenter(userContext, cityServiceCenterId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCityServiceCenter(RetailscmUserContext userContext,String cityServiceCenterId, int start, int count) throws Exception {
		SmartList<RetailStore> list = retailStoreDaoOf(userContext).findRetailStoreByCityServiceCenter(cityServiceCenterId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(RetailStore.class);
		page.setContainerObject(RetailStoreCityServiceCenter.withId(cityServiceCenterId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("双链小超列表");
		page.setRequestName("listByCityServiceCenter");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCityServiceCenter/%s/",  getBeanName(), cityServiceCenterId)));

		page.assemblerContent(userContext, "listByCityServiceCenter");
		return page.doRender(userContext);
	}
  
	public Object listByCreation(RetailscmUserContext userContext,String creationId) throws Exception {
		return listPageByCreation(userContext, creationId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCreation(RetailscmUserContext userContext,String creationId, int start, int count) throws Exception {
		SmartList<RetailStore> list = retailStoreDaoOf(userContext).findRetailStoreByCreation(creationId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(RetailStore.class);
		page.setContainerObject(RetailStoreCreation.withId(creationId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("双链小超列表");
		page.setRequestName("listByCreation");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCreation/%s/",  getBeanName(), creationId)));

		page.assemblerContent(userContext, "listByCreation");
		return page.doRender(userContext);
	}
  
	public Object listByInvestmentInvitation(RetailscmUserContext userContext,String investmentInvitationId) throws Exception {
		return listPageByInvestmentInvitation(userContext, investmentInvitationId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByInvestmentInvitation(RetailscmUserContext userContext,String investmentInvitationId, int start, int count) throws Exception {
		SmartList<RetailStore> list = retailStoreDaoOf(userContext).findRetailStoreByInvestmentInvitation(investmentInvitationId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(RetailStore.class);
		page.setContainerObject(RetailStoreInvestmentInvitation.withId(investmentInvitationId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("双链小超列表");
		page.setRequestName("listByInvestmentInvitation");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByInvestmentInvitation/%s/",  getBeanName(), investmentInvitationId)));

		page.assemblerContent(userContext, "listByInvestmentInvitation");
		return page.doRender(userContext);
	}
  
	public Object listByFranchising(RetailscmUserContext userContext,String franchisingId) throws Exception {
		return listPageByFranchising(userContext, franchisingId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByFranchising(RetailscmUserContext userContext,String franchisingId, int start, int count) throws Exception {
		SmartList<RetailStore> list = retailStoreDaoOf(userContext).findRetailStoreByFranchising(franchisingId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(RetailStore.class);
		page.setContainerObject(RetailStoreFranchising.withId(franchisingId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("双链小超列表");
		page.setRequestName("listByFranchising");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByFranchising/%s/",  getBeanName(), franchisingId)));

		page.assemblerContent(userContext, "listByFranchising");
		return page.doRender(userContext);
	}
  
	public Object listByDecoration(RetailscmUserContext userContext,String decorationId) throws Exception {
		return listPageByDecoration(userContext, decorationId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByDecoration(RetailscmUserContext userContext,String decorationId, int start, int count) throws Exception {
		SmartList<RetailStore> list = retailStoreDaoOf(userContext).findRetailStoreByDecoration(decorationId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(RetailStore.class);
		page.setContainerObject(RetailStoreDecoration.withId(decorationId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("双链小超列表");
		page.setRequestName("listByDecoration");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByDecoration/%s/",  getBeanName(), decorationId)));

		page.assemblerContent(userContext, "listByDecoration");
		return page.doRender(userContext);
	}
  
	public Object listByOpening(RetailscmUserContext userContext,String openingId) throws Exception {
		return listPageByOpening(userContext, openingId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByOpening(RetailscmUserContext userContext,String openingId, int start, int count) throws Exception {
		SmartList<RetailStore> list = retailStoreDaoOf(userContext).findRetailStoreByOpening(openingId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(RetailStore.class);
		page.setContainerObject(RetailStoreOpening.withId(openingId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("双链小超列表");
		page.setRequestName("listByOpening");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByOpening/%s/",  getBeanName(), openingId)));

		page.assemblerContent(userContext, "listByOpening");
		return page.doRender(userContext);
	}
  
	public Object listByClosing(RetailscmUserContext userContext,String closingId) throws Exception {
		return listPageByClosing(userContext, closingId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByClosing(RetailscmUserContext userContext,String closingId, int start, int count) throws Exception {
		SmartList<RetailStore> list = retailStoreDaoOf(userContext).findRetailStoreByClosing(closingId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(RetailStore.class);
		page.setContainerObject(RetailStoreClosing.withId(closingId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("双链小超列表");
		page.setRequestName("listByClosing");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByClosing/%s/",  getBeanName(), closingId)));

		page.assemblerContent(userContext, "listByClosing");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String retailStoreId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		RetailStore merchantObj = (RetailStore) this.view(userContext, retailStoreId);
    String merchantObjId = retailStoreId;
    String linkToUrl =	"retailStoreManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "双链小超"+"详情";
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
				MapUtil.put("id", "3-telephone")
				    .put("fieldName", "telephone")
				    .put("label", "电话")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("telephone", merchantObj.getTelephone());

		propList.add(
				MapUtil.put("id", "4-owner")
				    .put("fieldName", "owner")
				    .put("label", "业主")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("owner", merchantObj.getOwner());

		propList.add(
				MapUtil.put("id", "5-retailStoreCountryCenter")
				    .put("fieldName", "retailStoreCountryCenter")
				    .put("label", "双链小超全国运营中心")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("retailStoreCountryCenter", merchantObj.getRetailStoreCountryCenter());

		propList.add(
				MapUtil.put("id", "6-cityServiceCenter")
				    .put("fieldName", "cityServiceCenter")
				    .put("label", "城市服务中心")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCityServiceCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"founded\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("cityServiceCenter", merchantObj.getCityServiceCenter());

		propList.add(
				MapUtil.put("id", "7-creation")
				    .put("fieldName", "creation")
				    .put("label", "创建")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCreationManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"comment\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("creation", merchantObj.getCreation());

		propList.add(
				MapUtil.put("id", "8-investmentInvitation")
				    .put("fieldName", "investmentInvitation")
				    .put("label", "招商")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreInvestmentInvitationManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"comment\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("investmentInvitation", merchantObj.getInvestmentInvitation());

		propList.add(
				MapUtil.put("id", "9-franchising")
				    .put("fieldName", "franchising")
				    .put("label", "加盟")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreFranchisingManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"comment\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("franchising", merchantObj.getFranchising());

		propList.add(
				MapUtil.put("id", "10-decoration")
				    .put("fieldName", "decoration")
				    .put("label", "装修")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreDecorationManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"comment\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("decoration", merchantObj.getDecoration());

		propList.add(
				MapUtil.put("id", "11-opening")
				    .put("fieldName", "opening")
				    .put("label", "开业")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreOpeningManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"comment\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("opening", merchantObj.getOpening());

		propList.add(
				MapUtil.put("id", "12-closing")
				    .put("fieldName", "closing")
				    .put("label", "关闭")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreClosingManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"comment\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("closing", merchantObj.getClosing());

		propList.add(
				MapUtil.put("id", "13-founded")
				    .put("fieldName", "founded")
				    .put("label", "成立")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("founded", merchantObj.getFounded());

		propList.add(
				MapUtil.put("id", "14-latitude")
				    .put("fieldName", "latitude")
				    .put("label", "纬度")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("latitude", merchantObj.getLatitude());

		propList.add(
				MapUtil.put("id", "15-longitude")
				    .put("fieldName", "longitude")
				    .put("label", "经度")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("longitude", merchantObj.getLongitude());

		propList.add(
				MapUtil.put("id", "16-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

		propList.add(
				MapUtil.put("id", "17-lastUpdateTime")
				    .put("fieldName", "lastUpdateTime")
				    .put("label", "更新于")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

		//处理 sectionList

		//处理Section：consumerOrderListSection
		Map consumerOrderListSection = ListofUtils.buildSection(
		    "consumerOrderListSection",
		    "消费者的订单列表",
		    null,
		    "",
		    "__no_group",
		    "consumerOrderManager/listByStore/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(consumerOrderListSection);

		result.put("consumerOrderListSection", ListofUtils.toShortList(merchantObj.getConsumerOrderList(), "consumerOrder"));

		//处理Section：retailStoreOrderListSection
		Map retailStoreOrderListSection = ListofUtils.buildSection(
		    "retailStoreOrderListSection",
		    "零售店订购单",
		    null,
		    "",
		    "__no_group",
		    "retailStoreOrderManager/listByBuyer/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(retailStoreOrderListSection);

		result.put("retailStoreOrderListSection", ListofUtils.toShortList(merchantObj.getRetailStoreOrderList(), "retailStoreOrder"));

		//处理Section：goodsListSection
		Map goodsListSection = ListofUtils.buildSection(
		    "goodsListSection",
		    "商品列表",
		    null,
		    "",
		    "__no_group",
		    "goodsManager/listByRetailStore/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(goodsListSection);

		result.put("goodsListSection", ListofUtils.toShortList(merchantObj.getGoodsList(), "goods"));

		//处理Section：transportTaskListSection
		Map transportTaskListSection = ListofUtils.buildSection(
		    "transportTaskListSection",
		    "运输任务列表",
		    null,
		    "",
		    "__no_group",
		    "transportTaskManager/listByEnd/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(transportTaskListSection);

		result.put("transportTaskListSection", ListofUtils.toShortList(merchantObj.getTransportTaskList(), "transportTask"));

		//处理Section：accountSetListSection
		Map accountSetListSection = ListofUtils.buildSection(
		    "accountSetListSection",
		    "帐户设置列表",
		    null,
		    "",
		    "__no_group",
		    "accountSetManager/listByRetailStore/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(accountSetListSection);

		result.put("accountSetListSection", ListofUtils.toShortList(merchantObj.getAccountSetList(), "accountSet"));

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




