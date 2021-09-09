
package com.doublechaintech.retailscm.retailstoreclosing;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.retailstore.RetailStore;import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class RetailStoreClosingManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreClosingManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = RetailStoreClosingTokens.start().withTokenFromListName(listName).done();
		RetailStoreClosing  retailStoreClosing = (RetailStoreClosing) this.loadRetailStoreClosing(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = retailStoreClosing.collectRefercencesFromLists();
		retailStoreClosingDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, retailStoreClosing, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new RetailStoreClosingGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "RetailStoreClosing";
	@Override
	public RetailStoreClosingDAO daoOf(RetailscmUserContext userContext) {
		return retailStoreClosingDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws RetailStoreClosingManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreClosingManagerException(message);

	}



 	protected RetailStoreClosing saveRetailStoreClosing(RetailscmUserContext userContext, RetailStoreClosing retailStoreClosing, String [] tokensExpr) throws Exception{
 		//return getRetailStoreClosingDAO().save(retailStoreClosing, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveRetailStoreClosing(userContext, retailStoreClosing, tokens);
 	}

 	protected RetailStoreClosing saveRetailStoreClosingDetail(RetailscmUserContext userContext, RetailStoreClosing retailStoreClosing) throws Exception{


 		return saveRetailStoreClosing(userContext, retailStoreClosing, allTokens());
 	}

 	public RetailStoreClosing loadRetailStoreClosing(RetailscmUserContext userContext, String retailStoreClosingId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfRetailStoreClosing(retailStoreClosingId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreClosingManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing( userContext, retailStoreClosingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreClosing, tokens);
 	}


 	 public RetailStoreClosing searchRetailStoreClosing(RetailscmUserContext userContext, String retailStoreClosingId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfRetailStoreClosing(retailStoreClosingId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreClosingManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing( userContext, retailStoreClosingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreClosing, tokens);
 	}



 	protected RetailStoreClosing present(RetailscmUserContext userContext, RetailStoreClosing retailStoreClosing, Map<String, Object> tokens) throws Exception {


		addActions(userContext,retailStoreClosing,tokens);
    

		RetailStoreClosing  retailStoreClosingToPresent = retailStoreClosingDaoOf(userContext).present(retailStoreClosing, tokens);

		List<BaseEntity> entityListToNaming = retailStoreClosingToPresent.collectRefercencesFromLists();
		retailStoreClosingDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,retailStoreClosing,tokens);

		return  retailStoreClosingToPresent;


	}



 	public RetailStoreClosing loadRetailStoreClosingDetail(RetailscmUserContext userContext, String retailStoreClosingId) throws Exception{
 		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing( userContext, retailStoreClosingId, allTokens());
 		return present(userContext,retailStoreClosing, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String retailStoreClosingId) throws Exception{
 		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing( userContext, retailStoreClosingId, viewTokens());
 		markVisited(userContext, retailStoreClosing);
 		return present(userContext,retailStoreClosing, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String retailStoreClosingId) throws Exception{
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing( userContext, retailStoreClosingId, viewTokens());
		retailStoreClosing.summarySuffix();
		markVisited(userContext, retailStoreClosing);
 		return present(userContext,retailStoreClosing, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String retailStoreClosingId) throws Exception{
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing( userContext, retailStoreClosingId, analyzeTokens());
		markVisited(userContext, retailStoreClosing);
		return present(userContext,retailStoreClosing, analyzeTokens());

	}
 	protected RetailStoreClosing saveRetailStoreClosing(RetailscmUserContext userContext, RetailStoreClosing retailStoreClosing, Map<String,Object>tokens) throws Exception{
 	
 		return retailStoreClosingDaoOf(userContext).save(retailStoreClosing, tokens);
 	}
 	protected RetailStoreClosing loadRetailStoreClosing(RetailscmUserContext userContext, String retailStoreClosingId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfRetailStoreClosing(retailStoreClosingId);

		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreClosingManagerException.class);



 		return retailStoreClosingDaoOf(userContext).load(retailStoreClosingId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreClosing retailStoreClosing, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreClosing, tokens);

		addAction(userContext, retailStoreClosing, tokens,"@create","createRetailStoreClosing","createRetailStoreClosing/","main","primary");
		addAction(userContext, retailStoreClosing, tokens,"@update","updateRetailStoreClosing","updateRetailStoreClosing/"+retailStoreClosing.getId()+"/","main","primary");
		addAction(userContext, retailStoreClosing, tokens,"@copy","cloneRetailStoreClosing","cloneRetailStoreClosing/"+retailStoreClosing.getId()+"/","main","primary");

		addAction(userContext, retailStoreClosing, tokens,"retail_store_closing.addRetailStore","addRetailStore","addRetailStore/"+retailStoreClosing.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreClosing, tokens,"retail_store_closing.removeRetailStore","removeRetailStore","removeRetailStore/"+retailStoreClosing.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreClosing, tokens,"retail_store_closing.updateRetailStore","updateRetailStore","updateRetailStore/"+retailStoreClosing.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreClosing, tokens,"retail_store_closing.copyRetailStoreFrom","copyRetailStoreFrom","copyRetailStoreFrom/"+retailStoreClosing.getId()+"/","retailStoreList","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreClosing retailStoreClosing, Map<String, Object> tokens){








  @Override
  public List<RetailStoreClosing> searchRetailStoreClosingList(RetailscmUserContext ctx, RetailStoreClosingRequest pRequest){
      pRequest.setUserContext(ctx);
      List<RetailStoreClosing> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public RetailStoreClosing searchRetailStoreClosing(RetailscmUserContext ctx, RetailStoreClosingRequest pRequest){
    pRequest.limit(0, 1);
    List<RetailStoreClosing> list = searchRetailStoreClosingList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public RetailStoreClosing createRetailStoreClosing(RetailscmUserContext userContext, String comment) throws Exception
	{





		checkerOf(userContext).checkCommentOfRetailStoreClosing(comment);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);



		RetailStoreClosing retailStoreClosing=createNewRetailStoreClosing();	

		retailStoreClosing.setComment(comment);

		retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreClosing);
		return retailStoreClosing;


	}
	protected RetailStoreClosing createNewRetailStoreClosing()
	{

		return new RetailStoreClosing();
	}

	protected void checkParamsForUpdatingRetailStoreClosing(RetailscmUserContext userContext,String retailStoreClosingId, int retailStoreClosingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfRetailStoreClosing(retailStoreClosingId);
		checkerOf(userContext).checkVersionOfRetailStoreClosing( retailStoreClosingVersion);


		if(RetailStoreClosing.COMMENT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCommentOfRetailStoreClosing(parseString(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);



	}



	public RetailStoreClosing clone(RetailscmUserContext userContext, String fromRetailStoreClosingId) throws Exception{

		return retailStoreClosingDaoOf(userContext).clone(fromRetailStoreClosingId, this.allTokens());
	}

	public RetailStoreClosing internalSaveRetailStoreClosing(RetailscmUserContext userContext, RetailStoreClosing retailStoreClosing) throws Exception
	{
		return internalSaveRetailStoreClosing(userContext, retailStoreClosing, allTokens());

	}
	public RetailStoreClosing internalSaveRetailStoreClosing(RetailscmUserContext userContext, RetailStoreClosing retailStoreClosing, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRetailStoreClosing(userContext, retailStoreClosingId, retailStoreClosingVersion, property, newValueExpr, tokensExpr);


		synchronized(retailStoreClosing){
			//will be good when the retailStoreClosing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreClosing.
			if (retailStoreClosing.isChanged()){
			
			}

      //checkerOf(userContext).checkAndFixRetailStoreClosing(retailStoreClosing);
			retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, options);
			return retailStoreClosing;

		}

	}

	public RetailStoreClosing updateRetailStoreClosing(RetailscmUserContext userContext,String retailStoreClosingId, int retailStoreClosingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreClosing(userContext, retailStoreClosingId, retailStoreClosingVersion, property, newValueExpr, tokensExpr);



		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());
		if(retailStoreClosing.getVersion() != retailStoreClosingVersion){
			String message = "The target version("+retailStoreClosing.getVersion()+") is not equals to version("+retailStoreClosingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreClosing){
			//will be good when the retailStoreClosing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreClosing.
			
			retailStoreClosing.changeProperty(property, newValueExpr);
			retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().done());
			return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
			//return saveRetailStoreClosing(userContext, retailStoreClosing, tokens().done());
		}

	}

	public RetailStoreClosing updateRetailStoreClosingProperty(RetailscmUserContext userContext,String retailStoreClosingId, int retailStoreClosingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreClosing(userContext, retailStoreClosingId, retailStoreClosingVersion, property, newValueExpr, tokensExpr);

		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());
		if(retailStoreClosing.getVersion() != retailStoreClosingVersion){
			String message = "The target version("+retailStoreClosing.getVersion()+") is not equals to version("+retailStoreClosingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreClosing){
			//will be good when the retailStoreClosing loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreClosing.

			retailStoreClosing.changeProperty(property, newValueExpr);
			
			retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().done());
			return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
			//return saveRetailStoreClosing(userContext, retailStoreClosing, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RetailStoreClosingTokens tokens(){
		return RetailStoreClosingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreClosingTokens.all();
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
		return RetailStoreClosingTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreClosingId, int retailStoreClosingVersion) throws Exception {
		//deleteInternal(userContext, retailStoreClosingId, retailStoreClosingVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreClosingId, int retailStoreClosingVersion) throws Exception{

		retailStoreClosingDaoOf(userContext).delete(retailStoreClosingId, retailStoreClosingVersion);
	}

	public RetailStoreClosing forgetByAll(RetailscmUserContext userContext, String retailStoreClosingId, int retailStoreClosingVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreClosingId, retailStoreClosingVersion);
	}
	protected RetailStoreClosing forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreClosingId, int retailStoreClosingVersion) throws Exception{

		return retailStoreClosingDaoOf(userContext).disconnectFromAll(retailStoreClosingId, retailStoreClosingVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreClosingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return retailStoreClosingDaoOf(userContext).deleteAll();
	}





	protected void checkParamsForAddingRetailStore(RetailscmUserContext userContext, String retailStoreClosingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreClosing(retailStoreClosingId);


		checkerOf(userContext).checkNameOfRetailStore(name);

		checkerOf(userContext).checkTelephoneOfRetailStore(telephone);

		checkerOf(userContext).checkOwnerOfRetailStore(owner);

		checkerOf(userContext).checkRetailStoreCountryCenterIdOfRetailStore(retailStoreCountryCenterId);

		checkerOf(userContext).checkCityServiceCenterIdOfRetailStore(cityServiceCenterId);

		checkerOf(userContext).checkCreationIdOfRetailStore(creationId);

		checkerOf(userContext).checkInvestmentInvitationIdOfRetailStore(investmentInvitationId);

		checkerOf(userContext).checkFranchisingIdOfRetailStore(franchisingId);

		checkerOf(userContext).checkDecorationIdOfRetailStore(decorationId);

		checkerOf(userContext).checkOpeningIdOfRetailStore(openingId);

		checkerOf(userContext).checkFoundedOfRetailStore(founded);

		checkerOf(userContext).checkLatitudeOfRetailStore(latitude);

		checkerOf(userContext).checkLongitudeOfRetailStore(longitude);

		checkerOf(userContext).checkDescriptionOfRetailStore(description);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);



	}
	public  RetailStoreClosing addRetailStore(RetailscmUserContext userContext, String retailStoreClosingId, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingRetailStore(userContext,retailStoreClosingId,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, creationId, investmentInvitationId, franchisingId, decorationId, openingId, founded, latitude, longitude, description,tokensExpr);

		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, retailStoreCountryCenterId, cityServiceCenterId, creationId, investmentInvitationId, franchisingId, decorationId, openingId, founded, latitude, longitude, description);

		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, emptyOptions());
		synchronized(retailStoreClosing){
			//Will be good when the retailStoreClosing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreClosing.addRetailStore( retailStore );
			retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
			
			retailStoreManagerOf(userContext).onNewInstanceCreated(userContext, retailStore);
			return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreProperties(RetailscmUserContext userContext, String retailStoreClosingId,String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreClosing(retailStoreClosingId);
		checkerOf(userContext).checkIdOfRetailStore(id);

		checkerOf(userContext).checkNameOfRetailStore( name);
		checkerOf(userContext).checkTelephoneOfRetailStore( telephone);
		checkerOf(userContext).checkOwnerOfRetailStore( owner);
		checkerOf(userContext).checkFoundedOfRetailStore( founded);
		checkerOf(userContext).checkLatitudeOfRetailStore( latitude);
		checkerOf(userContext).checkLongitudeOfRetailStore( longitude);
		checkerOf(userContext).checkDescriptionOfRetailStore( description);


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);


	}
	public  RetailStoreClosing updateRetailStoreProperties(RetailscmUserContext userContext, String retailStoreClosingId, String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreProperties(userContext,retailStoreClosingId,id,name,telephone,owner,founded,latitude,longitude,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreListList()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, tokens().is(), id).done();

		RetailStoreClosing retailStoreClosingToUpdate = loadRetailStoreClosing(userContext, retailStoreClosingId, options);

		if(retailStoreClosingToUpdate.getRetailStoreList().isEmpty()){
			throw new RetailStoreClosingManagerException("RetailStore is NOT FOUND with id: '"+id+"'");
		}

		RetailStore item = retailStoreClosingToUpdate.getRetailStoreList().first();
		beforeUpdateRetailStoreProperties(userContext,item, retailStoreClosingId,id,name,telephone,owner,founded,latitude,longitude,description,tokensExpr);
		item.updateName( name );
		item.updateTelephone( telephone );
		item.updateOwner( owner );
		item.updateFounded( founded );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );
		item.updateDescription( description );


		//checkParamsForAddingRetailStore(userContext,retailStoreClosingId,name, code, used,tokensExpr);
		RetailStoreClosing retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosingToUpdate, tokens().withRetailStoreList().done());
		synchronized(retailStoreClosing){
			return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateRetailStoreProperties(RetailscmUserContext userContext, RetailStore item, String retailStoreClosingId, String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected RetailStore createRetailStore(RetailscmUserContext userContext, String name, String telephone, String owner, String retailStoreCountryCenterId, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description) throws Exception{

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
		RetailStoreOpening  opening = new RetailStoreOpening();
		opening.setId(openingId);		
		retailStore.setOpening(opening);		
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

	protected void checkParamsForRemovingRetailStoreList(RetailscmUserContext userContext, String retailStoreClosingId,
			String retailStoreIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreClosing(retailStoreClosingId);
		for(String retailStoreIdItem: retailStoreIds){
			checkerOf(userContext).checkIdOfRetailStore(retailStoreIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);

	}
	public  RetailStoreClosing removeRetailStoreList(RetailscmUserContext userContext, String retailStoreClosingId,
			String retailStoreIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreList(userContext, retailStoreClosingId,  retailStoreIds, tokensExpr);


			RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());
			synchronized(retailStoreClosing){
				//Will be good when the retailStoreClosing loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreClosingDaoOf(userContext).planToRemoveRetailStoreList(retailStoreClosing, retailStoreIds, allTokens());
				retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
				deleteRelationListInGraph(userContext, retailStoreClosing.getRetailStoreList());
				return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStore(RetailscmUserContext userContext, String retailStoreClosingId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreClosing( retailStoreClosingId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);


	}
	public  RetailStoreClosing removeRetailStore(RetailscmUserContext userContext, String retailStoreClosingId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStore(userContext,retailStoreClosingId, retailStoreId, retailStoreVersion,tokensExpr);

		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());
		synchronized(retailStoreClosing){
			//Will be good when the retailStoreClosing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreClosing.removeRetailStore( retailStore );
			retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
			deleteRelationInGraph(userContext, retailStore);
			return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStore(RetailscmUserContext userContext, String retailStoreClosingId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreClosing( retailStoreClosingId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);


	}
	public  RetailStoreClosing copyRetailStoreFrom(RetailscmUserContext userContext, String retailStoreClosingId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStore(userContext,retailStoreClosingId, retailStoreId, retailStoreVersion,tokensExpr);

		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, allTokens());
		synchronized(retailStoreClosing){
			//Will be good when the retailStoreClosing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			retailStore.updateLastUpdateTime(userContext.now());

			retailStoreClosing.copyRetailStoreFrom( retailStore );
			retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
			
			retailStoreManagerOf(userContext).onNewInstanceCreated(userContext, (RetailStore)retailStoreClosing.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStore(RetailscmUserContext userContext, String retailStoreClosingId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfRetailStoreClosing(retailStoreClosingId);
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
		


		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreClosingManagerException.class);


	}

	public  RetailStoreClosing updateRetailStore(RetailscmUserContext userContext, String retailStoreClosingId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStore(userContext, retailStoreClosingId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreList().searchRetailStoreListWith(RetailStore.ID_PROPERTY, tokens().equals(), retailStoreId).done();



		RetailStoreClosing retailStoreClosing = loadRetailStoreClosing(userContext, retailStoreClosingId, loadTokens);

		synchronized(retailStoreClosing){
			//Will be good when the retailStoreClosing loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreClosing.removeRetailStore( retailStore );
			//make changes to AcceleraterAccount.
			RetailStore retailStoreIdVersionKey = createIndexedRetailStore(retailStoreId, retailStoreVersion);

			RetailStore retailStore = retailStoreClosing.findTheRetailStore(retailStoreIdVersionKey);
			if(retailStore == null){
				throw new RetailStoreClosingManagerException(retailStoreId+" is NOT FOUND" );
			}

			beforeUpdateRetailStore(userContext, retailStore, retailStoreClosingId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);
			retailStore.changeProperty(property, newValueExpr);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStoreClosing = saveRetailStoreClosing(userContext, retailStoreClosing, tokens().withRetailStoreList().done());
			retailStoreManagerOf(userContext).onUpdated(userContext, retailStore, this, "updateRetailStore");
			return present(userContext,retailStoreClosing, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateRetailStore(RetailscmUserContext userContext, RetailStore existed, String retailStoreClosingId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreClosing newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    retailStoreClosingDaoOf(ctx).loadAllAsStream().forEach(
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
		//   RetailStoreClosing newRetailStoreClosing = this.createRetailStoreClosing(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreClosing
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
    key.put(UserApp.APP_TYPE_PROPERTY, RetailStoreClosing.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<RetailStoreClosing> list) throws Exception {
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
 	public Object wxappview(RetailscmUserContext userContext, String retailStoreClosingId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		RetailStoreClosing merchantObj = (RetailStoreClosing) this.view(userContext, retailStoreClosingId);
    String merchantObjId = retailStoreClosingId;
    String linkToUrl =	"retailStoreClosingManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "门店关闭"+"详情";
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
		    "retailStoreManager/listByClosing/"+merchantObjId+"/",
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




