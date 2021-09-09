
package com.doublechaintech.retailscm.retailstoreopening;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.retailstore.RetailStore;import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class RetailStoreOpeningManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreOpeningManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = RetailStoreOpeningTokens.start().withTokenFromListName(listName).done();
		RetailStoreOpening  retailStoreOpening = (RetailStoreOpening) this.loadRetailStoreOpening(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = retailStoreOpening.collectRefercencesFromLists();
		retailStoreOpeningDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, retailStoreOpening, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new RetailStoreOpeningGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "RetailStoreOpening";
	@Override
	public RetailStoreOpeningDAO daoOf(RetailscmUserContext userContext) {
		return retailStoreOpeningDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws RetailStoreOpeningManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreOpeningManagerException(message);

	}



 	protected RetailStoreOpening saveRetailStoreOpening(RetailscmUserContext userContext, RetailStoreOpening retailStoreOpening, String [] tokensExpr) throws Exception{
 		//return getRetailStoreOpeningDAO().save(retailStoreOpening, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveRetailStoreOpening(userContext, retailStoreOpening, tokens);
 	}

 	protected RetailStoreOpening saveRetailStoreOpeningDetail(RetailscmUserContext userContext, RetailStoreOpening retailStoreOpening) throws Exception{


 		return saveRetailStoreOpening(userContext, retailStoreOpening, allTokens());
 	}

 	public RetailStoreOpening loadRetailStoreOpening(RetailscmUserContext userContext, String retailStoreOpeningId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfRetailStoreOpening(retailStoreOpeningId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOpeningManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening( userContext, retailStoreOpeningId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOpening, tokens);
 	}


 	 public RetailStoreOpening searchRetailStoreOpening(RetailscmUserContext userContext, String retailStoreOpeningId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfRetailStoreOpening(retailStoreOpeningId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOpeningManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening( userContext, retailStoreOpeningId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreOpening, tokens);
 	}



 	protected RetailStoreOpening present(RetailscmUserContext userContext, RetailStoreOpening retailStoreOpening, Map<String, Object> tokens) throws Exception {


		addActions(userContext,retailStoreOpening,tokens);
    

		RetailStoreOpening  retailStoreOpeningToPresent = retailStoreOpeningDaoOf(userContext).present(retailStoreOpening, tokens);

		List<BaseEntity> entityListToNaming = retailStoreOpeningToPresent.collectRefercencesFromLists();
		retailStoreOpeningDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,retailStoreOpening,tokens);

		return  retailStoreOpeningToPresent;


	}



 	public RetailStoreOpening loadRetailStoreOpeningDetail(RetailscmUserContext userContext, String retailStoreOpeningId) throws Exception{
 		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening( userContext, retailStoreOpeningId, allTokens());
 		return present(userContext,retailStoreOpening, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String retailStoreOpeningId) throws Exception{
 		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening( userContext, retailStoreOpeningId, viewTokens());
 		markVisited(userContext, retailStoreOpening);
 		return present(userContext,retailStoreOpening, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String retailStoreOpeningId) throws Exception{
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening( userContext, retailStoreOpeningId, viewTokens());
		retailStoreOpening.summarySuffix();
		markVisited(userContext, retailStoreOpening);
 		return present(userContext,retailStoreOpening, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String retailStoreOpeningId) throws Exception{
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening( userContext, retailStoreOpeningId, analyzeTokens());
		markVisited(userContext, retailStoreOpening);
		return present(userContext,retailStoreOpening, analyzeTokens());

	}
 	protected RetailStoreOpening saveRetailStoreOpening(RetailscmUserContext userContext, RetailStoreOpening retailStoreOpening, Map<String,Object>tokens) throws Exception{
 	
 		return retailStoreOpeningDaoOf(userContext).save(retailStoreOpening, tokens);
 	}
 	protected RetailStoreOpening loadRetailStoreOpening(RetailscmUserContext userContext, String retailStoreOpeningId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfRetailStoreOpening(retailStoreOpeningId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreOpeningManagerException.class);



 		return retailStoreOpeningDaoOf(userContext).load(retailStoreOpeningId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOpening retailStoreOpening, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreOpening, tokens);

		addAction(userContext, retailStoreOpening, tokens,"@create","createRetailStoreOpening","createRetailStoreOpening/","main","primary");
		addAction(userContext, retailStoreOpening, tokens,"@update","updateRetailStoreOpening","updateRetailStoreOpening/"+retailStoreOpening.getId()+"/","main","primary");
		addAction(userContext, retailStoreOpening, tokens,"@copy","cloneRetailStoreOpening","cloneRetailStoreOpening/"+retailStoreOpening.getId()+"/","main","primary");

		addAction(userContext, retailStoreOpening, tokens,"retail_store_opening.addRetailStore","addRetailStore","addRetailStore/"+retailStoreOpening.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreOpening, tokens,"retail_store_opening.removeRetailStore","removeRetailStore","removeRetailStore/"+retailStoreOpening.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreOpening, tokens,"retail_store_opening.updateRetailStore","updateRetailStore","updateRetailStore/"+retailStoreOpening.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreOpening, tokens,"retail_store_opening.copyRetailStoreFrom","copyRetailStoreFrom","copyRetailStoreFrom/"+retailStoreOpening.getId()+"/","retailStoreList","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreOpening retailStoreOpening, Map<String, Object> tokens){








  @Override
  public List<RetailStoreOpening> searchRetailStoreOpeningList(RetailscmUserContext ctx, RetailStoreOpeningRequest pRequest){
      pRequest.setUserContext(ctx);
      List<RetailStoreOpening> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public RetailStoreOpening searchRetailStoreOpening(RetailscmUserContext ctx, RetailStoreOpeningRequest pRequest){
    pRequest.limit(0, 1);
    List<RetailStoreOpening> list = searchRetailStoreOpeningList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public RetailStoreOpening createRetailStoreOpening(RetailscmUserContext userContext, String comment) throws Exception
	{





		checkerOf(userContext).checkCommentOfRetailStoreOpening(comment);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);



		RetailStoreOpening retailStoreOpening=createNewRetailStoreOpening();	

		retailStoreOpening.setComment(comment);

		retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreOpening);
		return retailStoreOpening;


	}
	protected RetailStoreOpening createNewRetailStoreOpening()
	{

		return new RetailStoreOpening();
	}

	protected void checkParamsForUpdatingRetailStoreOpening(RetailscmUserContext userContext,String retailStoreOpeningId, int retailStoreOpeningVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfRetailStoreOpening(retailStoreOpeningId);
		checkerOf(userContext).checkVersionOfRetailStoreOpening( retailStoreOpeningVersion);


		if(RetailStoreOpening.COMMENT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentOfRetailStoreOpening(parseString(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);



	}



	public RetailStoreOpening clone(RetailscmUserContext userContext, String fromRetailStoreOpeningId) throws Exception{

		return retailStoreOpeningDaoOf(userContext).clone(fromRetailStoreOpeningId, this.allTokens());
	}

	public RetailStoreOpening internalSaveRetailStoreOpening(RetailscmUserContext userContext, RetailStoreOpening retailStoreOpening) throws Exception
	{
		return internalSaveRetailStoreOpening(userContext, retailStoreOpening, allTokens());

	}
	public RetailStoreOpening internalSaveRetailStoreOpening(RetailscmUserContext userContext, RetailStoreOpening retailStoreOpening, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRetailStoreOpening(userContext, retailStoreOpeningId, retailStoreOpeningVersion, property, newValueExpr, tokensExpr);


		synchronized(retailStoreOpening){
			//will be good when the retailStoreOpening loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOpening.
			if (retailStoreOpening.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixRetailStoreOpening(retailStoreOpening);
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, options);
			return retailStoreOpening;

		}

	}

	public RetailStoreOpening updateRetailStoreOpening(RetailscmUserContext userContext,String retailStoreOpeningId, int retailStoreOpeningVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOpening(userContext, retailStoreOpeningId, retailStoreOpeningVersion, property, newValueExpr, tokensExpr);



		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
		if(retailStoreOpening.getVersion() != retailStoreOpeningVersion){
			String message = "The target version("+retailStoreOpening.getVersion()+") is not equals to version("+retailStoreOpeningVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOpening){
			//will be good when the retailStoreOpening loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOpening.
			
			retailStoreOpening.changeProperty(property, newValueExpr);
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().done());
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOpening(userContext, retailStoreOpening, tokens().done());
		}

	}

	public RetailStoreOpening updateRetailStoreOpeningProperty(RetailscmUserContext userContext,String retailStoreOpeningId, int retailStoreOpeningVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOpening(userContext, retailStoreOpeningId, retailStoreOpeningVersion, property, newValueExpr, tokensExpr);

		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
		if(retailStoreOpening.getVersion() != retailStoreOpeningVersion){
			String message = "The target version("+retailStoreOpening.getVersion()+") is not equals to version("+retailStoreOpeningVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreOpening){
			//will be good when the retailStoreOpening loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreOpening.

			retailStoreOpening.changeProperty(property, newValueExpr);
			
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().done());
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
			//return saveRetailStoreOpening(userContext, retailStoreOpening, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RetailStoreOpeningTokens tokens(){
		return RetailStoreOpeningTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreOpeningTokens.all();
	}
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRetailStoreListWith(RetailStore.ID_PROPERTY,sortDesc())
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreOpeningTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreOpeningId, int retailStoreOpeningVersion) throws Exception {
		//deleteInternal(userContext, retailStoreOpeningId, retailStoreOpeningVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreOpeningId, int retailStoreOpeningVersion) throws Exception{

		retailStoreOpeningDaoOf(userContext).delete(retailStoreOpeningId, retailStoreOpeningVersion);
	}

	public RetailStoreOpening forgetByAll(RetailscmUserContext userContext, String retailStoreOpeningId, int retailStoreOpeningVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreOpeningId, retailStoreOpeningVersion);
	}
	protected RetailStoreOpening forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreOpeningId, int retailStoreOpeningVersion) throws Exception{

		return retailStoreOpeningDaoOf(userContext).disconnectFromAll(retailStoreOpeningId, retailStoreOpeningVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreOpeningManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return retailStoreOpeningDaoOf(userContext).deleteAll();
	}





	protected void checkParamsForAddingRetailStore(RetailscmUserContext userContext, String retailStoreOpeningId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreOpening(retailStoreOpeningId);


		checkerOf(userContext).checkNameOfRetailStore(name);

		checkerOf(userContext).checkTelephoneOfRetailStore(telephone);

		checkerOf(userContext).checkOwnerOfRetailStore(owner);

		checkerOf(userContext).checkRetailStoreCountryCenterIdOfRetailStore(retailStoreCountryCenterId);

		checkerOf(userContext).checkCityServiceCenterIdOfRetailStore(cityServiceCenterId);

		checkerOf(userContext).checkCreationIdOfRetailStore(creationId);

		checkerOf(userContext).checkInvestmentInvitationIdOfRetailStore(investmentInvitationId);

		checkerOf(userContext).checkFranchisingIdOfRetailStore(franchisingId);

		checkerOf(userContext).checkDecorationIdOfRetailStore(decorationId);

		checkerOf(userContext).checkClosingIdOfRetailStore(closingId);

		checkerOf(userContext).checkFoundedOfRetailStore(founded);

		checkerOf(userContext).checkLatitudeOfRetailStore(latitude);

		checkerOf(userContext).checkLongitudeOfRetailStore(longitude);

		checkerOf(userContext).checkDescriptionOfRetailStore(description);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);



	}
	public  RetailStoreOpening addRetailStore(RetailscmUserContext userContext, String retailStoreOpeningId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingRetailStore(userContext,retailStoreOpeningId,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, creationId, investmentInvitationId, franchisingId, decorationId, closingId, founded, latitude, longitude, description,tokensExpr);

		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, creationId, investmentInvitationId, franchisingId, decorationId, closingId, founded, latitude, longitude, description);

		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, emptyOptions());
		synchronized(retailStoreOpening){
			//Will be good when the retailStoreOpening loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOpening.addRetailStore( retailStore );
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
			
			retailStoreManagerOf(userContext).onNewInstanceCreated(userContext, retailStore);
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreProperties(RetailscmUserContext userContext, String retailStoreOpeningId,String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreOpening(retailStoreOpeningId);
		checkerOf(userContext).checkIdOfRetailStore(id);

		checkerOf(userContext).checkNameOfRetailStore( name);
		checkerOf(userContext).checkTelephoneOfRetailStore( telephone);
		checkerOf(userContext).checkOwnerOfRetailStore( owner);
		checkerOf(userContext).checkFoundedOfRetailStore( founded);
		checkerOf(userContext).checkLatitudeOfRetailStore( latitude);
		checkerOf(userContext).checkLongitudeOfRetailStore( longitude);
		checkerOf(userContext).checkDescriptionOfRetailStore( description);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);


	}
	public  RetailStoreOpening updateRetailStoreProperties(RetailscmUserContext userContext, String retailStoreOpeningId, String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreProperties(userContext,retailStoreOpeningId,id,name,telephone,owner,founded,latitude,longitude,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreListList()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, tokens().is(), id).done();

		RetailStoreOpening retailStoreOpeningToUpdate = loadRetailStoreOpening(userContext, retailStoreOpeningId, options);

		if(retailStoreOpeningToUpdate.getRetailStoreList().isEmpty()){
			throw new RetailStoreOpeningManagerException("RetailStore is NOT FOUND with id: '"+id+"'");
		}

		RetailStore item = retailStoreOpeningToUpdate.getRetailStoreList().first();
		beforeUpdateRetailStoreProperties(userContext,item, retailStoreOpeningId,id,name,telephone,owner,founded,latitude,longitude,description,tokensExpr);
		item.updateName( name );
		item.updateTelephone( telephone );
		item.updateOwner( owner );
		item.updateFounded( founded );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );
		item.updateDescription( description );


		//checkParamsForAddingRetailStore(userContext,retailStoreOpeningId,name, code, used,tokensExpr);
		RetailStoreOpening retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpeningToUpdate, tokens().withRetailStoreList().done());
		synchronized(retailStoreOpening){
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateRetailStoreProperties(RetailscmUserContext userContext, RetailStore item, String retailStoreOpeningId, String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected RetailStore createRetailStore(RetailscmUserContext userContext, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description) throws Exception{

		RetailStore retailStore = new RetailStore();
		
		
		retailStore.setName(name);		
		retailStore.setTelephone(telephone);		
		retailStore.setOwner(owner);		
		RetailStoreCountryCenter  retailStoreCountryCenter = new RetailStoreCountryCenter();
		retailStoreCountryCenter.setId(retailStoreCountryCenterId);		
		retailStore.setRetailStoreCountryCenter(retailStoreCountryCenter);		
		RetailStoreCityServiceCenter  cityServiceCenter = new RetailStoreCityServiceCenter();
		cityServiceCenter.setId(cityServiceCenterId);		
		retailStore.setCityServiceCenter(cityServiceCenter);		
		RetailStoreCreation  creation = new RetailStoreCreation();
		creation.setId(creationId);		
		retailStore.setCreation(creation);		
		RetailStoreInvestmentInvitation  investmentInvitation = new RetailStoreInvestmentInvitation();
		investmentInvitation.setId(investmentInvitationId);		
		retailStore.setInvestmentInvitation(investmentInvitation);		
		RetailStoreFranchising  franchising = new RetailStoreFranchising();
		franchising.setId(franchisingId);		
		retailStore.setFranchising(franchising);		
		RetailStoreDecoration  decoration = new RetailStoreDecoration();
		decoration.setId(decorationId);		
		retailStore.setDecoration(decoration);		
		RetailStoreClosing  closing = new RetailStoreClosing();
		closing.setId(closingId);		
		retailStore.setClosing(closing);		
		retailStore.setFounded(founded);		
		retailStore.setLatitude(latitude);		
		retailStore.setLongitude(longitude);		
		retailStore.setDescription(description);		
		retailStore.setLastUpdateTime(userContext.now());
	
		
		return retailStore;


	}

	protected RetailStore createIndexedRetailStore(String id, int version){

		RetailStore retailStore = new RetailStore();
		retailStore.setId(id);
		retailStore.setVersion(version);
		return retailStore;

	}

	protected void checkParamsForRemovingRetailStoreList(RetailscmUserContext userContext, String retailStoreOpeningId,
			String retailStoreIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreOpening(retailStoreOpeningId);
		for(String retailStoreIdItem: retailStoreIds){
			checkerOf(userContext).checkIdOfRetailStore(retailStoreIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);

	}
	public  RetailStoreOpening removeRetailStoreList(RetailscmUserContext userContext, String retailStoreOpeningId,
			String retailStoreIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreList(userContext, retailStoreOpeningId,  retailStoreIds, tokensExpr);


			RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
			synchronized(retailStoreOpening){
				//Will be good when the retailStoreOpening loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreOpeningDaoOf(userContext).planToRemoveRetailStoreList(retailStoreOpening, retailStoreIds, allTokens());
				retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
				deleteRelationListInGraph(userContext, retailStoreOpening.getRetailStoreList());
				return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStore(RetailscmUserContext userContext, String retailStoreOpeningId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreOpening( retailStoreOpeningId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);


	}
	public  RetailStoreOpening removeRetailStore(RetailscmUserContext userContext, String retailStoreOpeningId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStore(userContext,retailStoreOpeningId, retailStoreId, retailStoreVersion,tokensExpr);

		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
		synchronized(retailStoreOpening){
			//Will be good when the retailStoreOpening loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreOpening.removeRetailStore( retailStore );
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
			deleteRelationInGraph(userContext, retailStore);
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStore(RetailscmUserContext userContext, String retailStoreOpeningId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreOpening( retailStoreOpeningId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);


	}
	public  RetailStoreOpening copyRetailStoreFrom(RetailscmUserContext userContext, String retailStoreOpeningId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStore(userContext,retailStoreOpeningId, retailStoreId, retailStoreVersion,tokensExpr);

		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, allTokens());
		synchronized(retailStoreOpening){
			//Will be good when the retailStoreOpening loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			retailStore.updateLastUpdateTime(userContext.now());

			retailStoreOpening.copyRetailStoreFrom( retailStore );
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
			
			retailStoreManagerOf(userContext).onNewInstanceCreated(userContext, (RetailStore)retailStoreOpening.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStore(RetailscmUserContext userContext, String retailStoreOpeningId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfRetailStoreOpening(retailStoreOpeningId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);


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
		


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreOpeningManagerException.class);


	}

	public  RetailStoreOpening updateRetailStore(RetailscmUserContext userContext, String retailStoreOpeningId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStore(userContext, retailStoreOpeningId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreList().searchRetailStoreListWith(RetailStore.ID_PROPERTY, tokens().equals(), retailStoreId).done();



		RetailStoreOpening retailStoreOpening = loadRetailStoreOpening(userContext, retailStoreOpeningId, loadTokens);

		synchronized(retailStoreOpening){
			//Will be good when the retailStoreOpening loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreOpening.removeRetailStore( retailStore );
			//make changes to AcceleraterAccount.
			RetailStore retailStoreIdVersionKey = createIndexedRetailStore(retailStoreId, retailStoreVersion);

			RetailStore retailStore = retailStoreOpening.findTheRetailStore(retailStoreIdVersionKey);
			if(retailStore == null){
				throw new RetailStoreOpeningManagerException(retailStoreId+" is NOT FOUND" );
			}

			beforeUpdateRetailStore(userContext, retailStore, retailStoreOpeningId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);
			retailStore.changeProperty(property, newValueExpr);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStoreOpening = saveRetailStoreOpening(userContext, retailStoreOpening, tokens().withRetailStoreList().done());
			retailStoreManagerOf(userContext).onUpdated(userContext, retailStore, this, "updateRetailStore");
			return present(userContext,retailStoreOpening, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateRetailStore(RetailscmUserContext userContext, RetailStore existed, String retailStoreOpeningId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOpening newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    retailStoreOpeningDaoOf(ctx).loadAllAsStream().forEach(
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
		//   RetailStoreOpening newRetailStoreOpening = this.createRetailStoreOpening(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreOpening
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
    key.put(UserApp.APP_TYPE_PROPERTY, RetailStoreOpening.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<RetailStoreOpening> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}


    }
	
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String retailStoreOpeningId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		RetailStoreOpening merchantObj = (RetailStoreOpening) this.view(userContext, retailStoreOpeningId);
    String merchantObjId = retailStoreOpeningId;
    String linkToUrl =	"retailStoreOpeningManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "生超开业"+"详情";
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
				MapUtil.put("id", "2-comment")
				    .put("fieldName", "comment")
				    .put("label", "评论")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("comment", merchantObj.getComment());

		//处理 sectionList

		//处理Section：retailStoreListSection
		Map retailStoreListSection = ListofUtils.buildSection(
		    "retailStoreListSection",
		    "零售门店列表",
		    null,
		    "",
		    "__no_group",
		    "retailStoreManager/listByOpening/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(retailStoreListSection);

		result.put("retailStoreListSection", ListofUtils.toShortList(merchantObj.getRetailStoreList(), "retailStore"));

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




