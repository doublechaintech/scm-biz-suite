
package com.doublechaintech.retailscm.transportfleet;















import com.doublechaintech.retailscm.*;import com.doublechaintech.retailscm.BaseViewPage;import com.doublechaintech.retailscm.RetailscmUserContextImpl;import com.doublechaintech.retailscm.iamservice.*;import com.doublechaintech.retailscm.retailstore.RetailStore;import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;import com.doublechaintech.retailscm.secuser.SecUser;import com.doublechaintech.retailscm.services.IamService;import com.doublechaintech.retailscm.transportfleet.TransportFleet;import com.doublechaintech.retailscm.transporttask.TransportTask;import com.doublechaintech.retailscm.transporttruck.TransportTruck;import com.doublechaintech.retailscm.tree.*;import com.doublechaintech.retailscm.treenode.*;import com.doublechaintech.retailscm.truckdriver.TruckDriver;import com.doublechaintech.retailscm.userapp.UserApp;import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;import com.terapico.caf.DateTime;import com.terapico.caf.Images;import com.terapico.caf.Password;import com.terapico.caf.baseelement.PlainText;import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;


public class TransportFleetManagerImpl extends CustomRetailscmCheckerManager implements TransportFleetManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = TransportFleetTokens.start().withTokenFromListName(listName).done();
		TransportFleet  transportFleet = (TransportFleet) this.loadTransportFleet(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = transportFleet.collectRefercencesFromLists();
		transportFleetDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, transportFleet, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new TransportFleetGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "TransportFleet";
	@Override
	public TransportFleetDAO daoOf(RetailscmUserContext userContext) {
		return transportFleetDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}



	protected void throwExceptionWithMessage(String value) throws TransportFleetManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new TransportFleetManagerException(message);

	}



 	protected TransportFleet saveTransportFleet(RetailscmUserContext userContext, TransportFleet transportFleet, String [] tokensExpr) throws Exception{
 		//return getTransportFleetDAO().save(transportFleet, tokens);

 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		return saveTransportFleet(userContext, transportFleet, tokens);
 	}

 	protected TransportFleet saveTransportFleetDetail(RetailscmUserContext userContext, TransportFleet transportFleet) throws Exception{


 		return saveTransportFleet(userContext, transportFleet, allTokens());
 	}

 	public TransportFleet loadTransportFleet(RetailscmUserContext userContext, String transportFleetId, String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfTransportFleet(transportFleetId);

		checkerOf(userContext).throwExceptionIfHasErrors( TransportFleetManagerException.class);



 		Map<String,Object>tokens = parseTokens(tokensExpr);

 		TransportFleet transportFleet = loadTransportFleet( userContext, transportFleetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportFleet, tokens);
 	}


 	 public TransportFleet searchTransportFleet(RetailscmUserContext userContext, String transportFleetId, String textToSearch,String [] tokensExpr) throws Exception{

 		checkerOf(userContext).checkIdOfTransportFleet(transportFleetId);

		checkerOf(userContext).throwExceptionIfHasErrors( TransportFleetManagerException.class);



 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);

 		TransportFleet transportFleet = loadTransportFleet( userContext, transportFleetId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,transportFleet, tokens);
 	}



 	protected TransportFleet present(RetailscmUserContext userContext, TransportFleet transportFleet, Map<String, Object> tokens) throws Exception {


		addActions(userContext,transportFleet,tokens);
    

		TransportFleet  transportFleetToPresent = transportFleetDaoOf(userContext).present(transportFleet, tokens);

		List<BaseEntity> entityListToNaming = transportFleetToPresent.collectRefercencesFromLists();
		transportFleetDaoOf(userContext).alias(entityListToNaming);


		renderActionForList(userContext,transportFleet,tokens);

		return  transportFleetToPresent;


	}



 	public TransportFleet loadTransportFleetDetail(RetailscmUserContext userContext, String transportFleetId) throws Exception{
 		TransportFleet transportFleet = loadTransportFleet( userContext, transportFleetId, allTokens());
 		return present(userContext,transportFleet, allTokens());

 	}

	public Object prepareContextForUserApp(BaseUserContext userContext,Object targetUserApp) throws Exception{
		
        UserApp userApp=(UserApp) targetUserApp;
        return this.view ((RetailscmUserContext)userContext,userApp.getAppId());
        
    }

	


 	public Object view(RetailscmUserContext userContext, String transportFleetId) throws Exception{
 		TransportFleet transportFleet = loadTransportFleet( userContext, transportFleetId, viewTokens());
 		markVisited(userContext, transportFleet);
 		return present(userContext,transportFleet, viewTokens());

	 }
	 public Object summaryView(RetailscmUserContext userContext, String transportFleetId) throws Exception{
		TransportFleet transportFleet = loadTransportFleet( userContext, transportFleetId, viewTokens());
		transportFleet.summarySuffix();
		markVisited(userContext, transportFleet);
 		return present(userContext,transportFleet, summaryTokens());

	}
	 public Object analyze(RetailscmUserContext userContext, String transportFleetId) throws Exception{
		TransportFleet transportFleet = loadTransportFleet( userContext, transportFleetId, analyzeTokens());
		markVisited(userContext, transportFleet);
		return present(userContext,transportFleet, analyzeTokens());

	}
 	protected TransportFleet saveTransportFleet(RetailscmUserContext userContext, TransportFleet transportFleet, Map<String,Object>tokens) throws Exception{
 	
 		return transportFleetDaoOf(userContext).save(transportFleet, tokens);
 	}
 	protected TransportFleet loadTransportFleet(RetailscmUserContext userContext, String transportFleetId, Map<String,Object>tokens) throws Exception{
		checkerOf(userContext).checkIdOfTransportFleet(transportFleetId);

		checkerOf(userContext).throwExceptionIfHasErrors( TransportFleetManagerException.class);



 		return transportFleetDaoOf(userContext).load(transportFleetId, tokens);
 	}

	







 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, TransportFleet transportFleet, Map<String, Object> tokens){
		super.addActions(userContext, transportFleet, tokens);

		addAction(userContext, transportFleet, tokens,"@create","createTransportFleet","createTransportFleet/","main","primary");
		addAction(userContext, transportFleet, tokens,"@update","updateTransportFleet","updateTransportFleet/"+transportFleet.getId()+"/","main","primary");
		addAction(userContext, transportFleet, tokens,"@copy","cloneTransportFleet","cloneTransportFleet/"+transportFleet.getId()+"/","main","primary");

		addAction(userContext, transportFleet, tokens,"transport_fleet.transfer_to_owner","transferToAnotherOwner","transferToAnotherOwner/"+transportFleet.getId()+"/","main","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.addTransportTruck","addTransportTruck","addTransportTruck/"+transportFleet.getId()+"/","transportTruckList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.removeTransportTruck","removeTransportTruck","removeTransportTruck/"+transportFleet.getId()+"/","transportTruckList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.updateTransportTruck","updateTransportTruck","updateTransportTruck/"+transportFleet.getId()+"/","transportTruckList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.copyTransportTruckFrom","copyTransportTruckFrom","copyTransportTruckFrom/"+transportFleet.getId()+"/","transportTruckList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.addTruckDriver","addTruckDriver","addTruckDriver/"+transportFleet.getId()+"/","truckDriverList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.removeTruckDriver","removeTruckDriver","removeTruckDriver/"+transportFleet.getId()+"/","truckDriverList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.updateTruckDriver","updateTruckDriver","updateTruckDriver/"+transportFleet.getId()+"/","truckDriverList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.copyTruckDriverFrom","copyTruckDriverFrom","copyTruckDriverFrom/"+transportFleet.getId()+"/","truckDriverList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.addTransportTask","addTransportTask","addTransportTask/"+transportFleet.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.removeTransportTask","removeTransportTask","removeTransportTask/"+transportFleet.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.updateTransportTask","updateTransportTask","updateTransportTask/"+transportFleet.getId()+"/","transportTaskList","primary");
		addAction(userContext, transportFleet, tokens,"transport_fleet.copyTransportTaskFrom","copyTransportTaskFrom","copyTransportTaskFrom/"+transportFleet.getId()+"/","transportTaskList","primary");






	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, TransportFleet transportFleet, Map<String, Object> tokens){








  @Override
  public List<TransportFleet> searchTransportFleetList(RetailscmUserContext ctx, TransportFleetRequest pRequest){
      pRequest.setUserContext(ctx);
      List<TransportFleet> list = daoOf(ctx).search(pRequest);
      Searcher.enhance(list, pRequest);
      return list;
  }

  @Override
  public TransportFleet searchTransportFleet(RetailscmUserContext ctx, TransportFleetRequest pRequest){
    pRequest.limit(0, 1);
    List<TransportFleet> list = searchTransportFleetList(ctx, pRequest);
    if (list == null || list.isEmpty()){
      return null;
    }
    return list.get(0);
  }

	public TransportFleet createTransportFleet(RetailscmUserContext userContext, String name,String contactNumber,String ownerId,String contract) throws Exception
	{





		checkerOf(userContext).checkNameOfTransportFleet(name);
		checkerOf(userContext).checkContactNumberOfTransportFleet(contactNumber);
		checkerOf(userContext).checkContractOfTransportFleet(contract);


		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);



		TransportFleet transportFleet=createNewTransportFleet();	

		transportFleet.setName(name);
		transportFleet.setContactNumber(contactNumber);
			
		RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(userContext, ownerId,emptyOptions());
		transportFleet.setOwner(owner);
		
		
		transportFleet.setContract(contract);
		transportFleet.setLastUpdateTime(userContext.now());

		transportFleet = saveTransportFleet(userContext, transportFleet, emptyOptions());
		
		onNewInstanceCreated(userContext, transportFleet);
		return transportFleet;


	}
	protected TransportFleet createNewTransportFleet()
	{

		return new TransportFleet();
	}

	protected void checkParamsForUpdatingTransportFleet(RetailscmUserContext userContext,String transportFleetId, int transportFleetVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		



		checkerOf(userContext).checkIdOfTransportFleet(transportFleetId);
		checkerOf(userContext).checkVersionOfTransportFleet( transportFleetVersion);


		if(TransportFleet.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfTransportFleet(parseString(newValueExpr));
		

		}
		if(TransportFleet.CONTACT_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkContactNumberOfTransportFleet(parseString(newValueExpr));
		

		}

		
		if(TransportFleet.CONTRACT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkContractOfTransportFleet(parseString(newValueExpr));
		

		}


		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);



	}



	public TransportFleet clone(RetailscmUserContext userContext, String fromTransportFleetId) throws Exception{

		return transportFleetDaoOf(userContext).clone(fromTransportFleetId, this.allTokens());
	}

	public TransportFleet internalSaveTransportFleet(RetailscmUserContext userContext, TransportFleet transportFleet) throws Exception
	{
		return internalSaveTransportFleet(userContext, transportFleet, allTokens());

	}
	public TransportFleet internalSaveTransportFleet(RetailscmUserContext userContext, TransportFleet transportFleet, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingTransportFleet(userContext, transportFleetId, transportFleetVersion, property, newValueExpr, tokensExpr);


		synchronized(transportFleet){
			//will be good when the transportFleet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportFleet.
			if (transportFleet.isChanged()){
			transportFleet.updateLastUpdateTime(userContext.now());
			}

      //checkerOf(userContext).checkAndFixTransportFleet(transportFleet);
			transportFleet = saveTransportFleet(userContext, transportFleet, options);
			return transportFleet;

		}

	}

	public TransportFleet updateTransportFleet(RetailscmUserContext userContext,String transportFleetId, int transportFleetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTransportFleet(userContext, transportFleetId, transportFleetVersion, property, newValueExpr, tokensExpr);



		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		if(transportFleet.getVersion() != transportFleetVersion){
			String message = "The target version("+transportFleet.getVersion()+") is not equals to version("+transportFleetVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportFleet){
			//will be good when the transportFleet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportFleet.
			transportFleet.updateLastUpdateTime(userContext.now());
			transportFleet.changeProperty(property, newValueExpr);
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().done());
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
			//return saveTransportFleet(userContext, transportFleet, tokens().done());
		}

	}

	public TransportFleet updateTransportFleetProperty(RetailscmUserContext userContext,String transportFleetId, int transportFleetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTransportFleet(userContext, transportFleetId, transportFleetVersion, property, newValueExpr, tokensExpr);

		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		if(transportFleet.getVersion() != transportFleetVersion){
			String message = "The target version("+transportFleet.getVersion()+") is not equals to version("+transportFleetVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(transportFleet){
			//will be good when the transportFleet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to TransportFleet.

			transportFleet.changeProperty(property, newValueExpr);
			transportFleet.updateLastUpdateTime(userContext.now());
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().done());
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
			//return saveTransportFleet(userContext, transportFleet, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected TransportFleetTokens tokens(){
		return TransportFleetTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return TransportFleetTokens.all();
	}
	protected Map<String,Object> analyzeTokens(){
		return tokens().allTokens().analyzeAllLists().done();
	}
	protected Map<String,Object> summaryTokens(){
		return tokens().allTokens().done();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortTransportTruckListWith(TransportTruck.ID_PROPERTY,sortDesc())
		.sortTruckDriverListWith(TruckDriver.ID_PROPERTY,sortDesc())
		.sortTransportTaskListWith(TransportTask.ID_PROPERTY,sortDesc())
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return TransportFleetTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherOwner(RetailscmUserContext userContext, String transportFleetId, String anotherOwnerId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfTransportFleet(transportFleetId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherOwnerId);//check for optional reference

 		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);

 	}
 	public TransportFleet transferToAnotherOwner(RetailscmUserContext userContext, String transportFleetId, String anotherOwnerId) throws Exception
 	{
 		checkParamsForTransferingAnotherOwner(userContext, transportFleetId,anotherOwnerId);
 
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){
			//will be good when the transportFleet loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter owner = loadRetailStoreCountryCenter(userContext, anotherOwnerId, emptyOptions());
			transportFleet.updateOwner(owner);
			transportFleet.updateLastUpdateTime(userContext.now());
			transportFleet = saveTransportFleet(userContext, transportFleet, emptyOptions());

			return present(userContext,transportFleet, allTokens());

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
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForTransportFleet(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(RetailscmUserContext userContext, String transportFleetId, int transportFleetVersion) throws Exception {
		//deleteInternal(userContext, transportFleetId, transportFleetVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String transportFleetId, int transportFleetVersion) throws Exception{

		transportFleetDaoOf(userContext).delete(transportFleetId, transportFleetVersion);
	}

	public TransportFleet forgetByAll(RetailscmUserContext userContext, String transportFleetId, int transportFleetVersion) throws Exception {
		return forgetByAllInternal(userContext, transportFleetId, transportFleetVersion);
	}
	protected TransportFleet forgetByAllInternal(RetailscmUserContext userContext,
			String transportFleetId, int transportFleetVersion) throws Exception{

		return transportFleetDaoOf(userContext).disconnectFromAll(transportFleetId, transportFleetVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new TransportFleetManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return transportFleetDaoOf(userContext).deleteAll();
	}





	protected void checkParamsForAddingTransportTruck(RetailscmUserContext userContext, String transportFleetId, String name, String plateNumber, String contactNumber, String vehicleLicenseNumber, String engineNumber, Date makeDate, String mileage, String bodyColor,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfTransportFleet(transportFleetId);


		checkerOf(userContext).checkNameOfTransportTruck(name);

		checkerOf(userContext).checkPlateNumberOfTransportTruck(plateNumber);

		checkerOf(userContext).checkContactNumberOfTransportTruck(contactNumber);

		checkerOf(userContext).checkVehicleLicenseNumberOfTransportTruck(vehicleLicenseNumber);

		checkerOf(userContext).checkEngineNumberOfTransportTruck(engineNumber);

		checkerOf(userContext).checkMakeDateOfTransportTruck(makeDate);

		checkerOf(userContext).checkMileageOfTransportTruck(mileage);

		checkerOf(userContext).checkBodyColorOfTransportTruck(bodyColor);


		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);



	}
	public  TransportFleet addTransportTruck(RetailscmUserContext userContext, String transportFleetId, String name, String plateNumber, String contactNumber, String vehicleLicenseNumber, String engineNumber, Date makeDate, String mileage, String bodyColor, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingTransportTruck(userContext,transportFleetId,name, plateNumber, contactNumber, vehicleLicenseNumber, engineNumber, makeDate, mileage, bodyColor,tokensExpr);

		TransportTruck transportTruck = createTransportTruck(userContext,name, plateNumber, contactNumber, vehicleLicenseNumber, engineNumber, makeDate, mileage, bodyColor);

		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, emptyOptions());
		synchronized(transportFleet){
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.addTransportTruck( transportTruck );
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTruckList().done());
			
			transportTruckManagerOf(userContext).onNewInstanceCreated(userContext, transportTruck);
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportTruckProperties(RetailscmUserContext userContext, String transportFleetId,String id,String name,String plateNumber,String contactNumber,String vehicleLicenseNumber,String engineNumber,Date makeDate,String mileage,String bodyColor,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfTransportFleet(transportFleetId);
		checkerOf(userContext).checkIdOfTransportTruck(id);

		checkerOf(userContext).checkNameOfTransportTruck( name);
		checkerOf(userContext).checkPlateNumberOfTransportTruck( plateNumber);
		checkerOf(userContext).checkContactNumberOfTransportTruck( contactNumber);
		checkerOf(userContext).checkVehicleLicenseNumberOfTransportTruck( vehicleLicenseNumber);
		checkerOf(userContext).checkEngineNumberOfTransportTruck( engineNumber);
		checkerOf(userContext).checkMakeDateOfTransportTruck( makeDate);
		checkerOf(userContext).checkMileageOfTransportTruck( mileage);
		checkerOf(userContext).checkBodyColorOfTransportTruck( bodyColor);


		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);


	}
	public  TransportFleet updateTransportTruckProperties(RetailscmUserContext userContext, String transportFleetId, String id,String name,String plateNumber,String contactNumber,String vehicleLicenseNumber,String engineNumber,Date makeDate,String mileage,String bodyColor, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTransportTruckProperties(userContext,transportFleetId,id,name,plateNumber,contactNumber,vehicleLicenseNumber,engineNumber,makeDate,mileage,bodyColor,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportTruckListList()
				.searchTransportTruckListWith(TransportTruck.ID_PROPERTY, tokens().is(), id).done();

		TransportFleet transportFleetToUpdate = loadTransportFleet(userContext, transportFleetId, options);

		if(transportFleetToUpdate.getTransportTruckList().isEmpty()){
			throw new TransportFleetManagerException("TransportTruck is NOT FOUND with id: '"+id+"'");
		}

		TransportTruck item = transportFleetToUpdate.getTransportTruckList().first();
		beforeUpdateTransportTruckProperties(userContext,item, transportFleetId,id,name,plateNumber,contactNumber,vehicleLicenseNumber,engineNumber,makeDate,mileage,bodyColor,tokensExpr);
		item.updateName( name );
		item.updatePlateNumber( plateNumber );
		item.updateContactNumber( contactNumber );
		item.updateVehicleLicenseNumber( vehicleLicenseNumber );
		item.updateEngineNumber( engineNumber );
		item.updateMakeDate( makeDate );
		item.updateMileage( mileage );
		item.updateBodyColor( bodyColor );


		//checkParamsForAddingTransportTruck(userContext,transportFleetId,name, code, used,tokensExpr);
		TransportFleet transportFleet = saveTransportFleet(userContext, transportFleetToUpdate, tokens().withTransportTruckList().done());
		synchronized(transportFleet){
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateTransportTruckProperties(RetailscmUserContext userContext, TransportTruck item, String transportFleetId, String id,String name,String plateNumber,String contactNumber,String vehicleLicenseNumber,String engineNumber,Date makeDate,String mileage,String bodyColor, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected TransportTruck createTransportTruck(RetailscmUserContext userContext, String name, String plateNumber, String contactNumber, String vehicleLicenseNumber, String engineNumber, Date makeDate, String mileage, String bodyColor) throws Exception{

		TransportTruck transportTruck = new TransportTruck();
		
		
		transportTruck.setName(name);		
		transportTruck.setPlateNumber(plateNumber);		
		transportTruck.setContactNumber(contactNumber);		
		transportTruck.setVehicleLicenseNumber(vehicleLicenseNumber);		
		transportTruck.setEngineNumber(engineNumber);		
		transportTruck.setMakeDate(makeDate);		
		transportTruck.setMileage(mileage);		
		transportTruck.setBodyColor(bodyColor);
	
		
		return transportTruck;


	}

	protected TransportTruck createIndexedTransportTruck(String id, int version){

		TransportTruck transportTruck = new TransportTruck();
		transportTruck.setId(id);
		transportTruck.setVersion(version);
		return transportTruck;

	}

	protected void checkParamsForRemovingTransportTruckList(RetailscmUserContext userContext, String transportFleetId,
			String transportTruckIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfTransportFleet(transportFleetId);
		for(String transportTruckIdItem: transportTruckIds){
			checkerOf(userContext).checkIdOfTransportTruck(transportTruckIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);

	}
	public  TransportFleet removeTransportTruckList(RetailscmUserContext userContext, String transportFleetId,
			String transportTruckIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingTransportTruckList(userContext, transportFleetId,  transportTruckIds, tokensExpr);


			TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
			synchronized(transportFleet){
				//Will be good when the transportFleet loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				transportFleetDaoOf(userContext).planToRemoveTransportTruckList(transportFleet, transportTruckIds, allTokens());
				transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTruckList().done());
				deleteRelationListInGraph(userContext, transportFleet.getTransportTruckList());
				return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingTransportTruck(RetailscmUserContext userContext, String transportFleetId,
		String transportTruckId, int transportTruckVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfTransportFleet( transportFleetId);
		checkerOf(userContext).checkIdOfTransportTruck(transportTruckId);
		checkerOf(userContext).checkVersionOfTransportTruck(transportTruckVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);


	}
	public  TransportFleet removeTransportTruck(RetailscmUserContext userContext, String transportFleetId,
		String transportTruckId, int transportTruckVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingTransportTruck(userContext,transportFleetId, transportTruckId, transportTruckVersion,tokensExpr);

		TransportTruck transportTruck = createIndexedTransportTruck(transportTruckId, transportTruckVersion);
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.removeTransportTruck( transportTruck );
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTruckList().done());
			deleteRelationInGraph(userContext, transportTruck);
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingTransportTruck(RetailscmUserContext userContext, String transportFleetId,
		String transportTruckId, int transportTruckVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfTransportFleet( transportFleetId);
		checkerOf(userContext).checkIdOfTransportTruck(transportTruckId);
		checkerOf(userContext).checkVersionOfTransportTruck(transportTruckVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);


	}
	public  TransportFleet copyTransportTruckFrom(RetailscmUserContext userContext, String transportFleetId,
		String transportTruckId, int transportTruckVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingTransportTruck(userContext,transportFleetId, transportTruckId, transportTruckVersion,tokensExpr);

		TransportTruck transportTruck = createIndexedTransportTruck(transportTruckId, transportTruckVersion);
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			transportFleet.copyTransportTruckFrom( transportTruck );
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTruckList().done());
			
			transportTruckManagerOf(userContext).onNewInstanceCreated(userContext, (TransportTruck)transportFleet.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingTransportTruck(RetailscmUserContext userContext, String transportFleetId, String transportTruckId, int transportTruckVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfTransportFleet(transportFleetId);
		checkerOf(userContext).checkIdOfTransportTruck(transportTruckId);
		checkerOf(userContext).checkVersionOfTransportTruck(transportTruckVersion);


		if(TransportTruck.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfTransportTruck(parseString(newValueExpr));
		}
		
		if(TransportTruck.PLATE_NUMBER_PROPERTY.equals(property)){
			checkerOf(userContext).checkPlateNumberOfTransportTruck(parseString(newValueExpr));
		}
		
		if(TransportTruck.CONTACT_NUMBER_PROPERTY.equals(property)){
			checkerOf(userContext).checkContactNumberOfTransportTruck(parseString(newValueExpr));
		}
		
		if(TransportTruck.VEHICLE_LICENSE_NUMBER_PROPERTY.equals(property)){
			checkerOf(userContext).checkVehicleLicenseNumberOfTransportTruck(parseString(newValueExpr));
		}
		
		if(TransportTruck.ENGINE_NUMBER_PROPERTY.equals(property)){
			checkerOf(userContext).checkEngineNumberOfTransportTruck(parseString(newValueExpr));
		}
		
		if(TransportTruck.MAKE_DATE_PROPERTY.equals(property)){
			checkerOf(userContext).checkMakeDateOfTransportTruck(parseDate(newValueExpr));
		}
		
		if(TransportTruck.MILEAGE_PROPERTY.equals(property)){
			checkerOf(userContext).checkMileageOfTransportTruck(parseString(newValueExpr));
		}
		
		if(TransportTruck.BODY_COLOR_PROPERTY.equals(property)){
			checkerOf(userContext).checkBodyColorOfTransportTruck(parseString(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);


	}

	public  TransportFleet updateTransportTruck(RetailscmUserContext userContext, String transportFleetId, String transportTruckId, int transportTruckVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingTransportTruck(userContext, transportFleetId, transportTruckId, transportTruckVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withTransportTruckList().searchTransportTruckListWith(TransportTruck.ID_PROPERTY, tokens().equals(), transportTruckId).done();



		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, loadTokens);

		synchronized(transportFleet){
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transportFleet.removeTransportTruck( transportTruck );
			//make changes to AcceleraterAccount.
			TransportTruck transportTruckIdVersionKey = createIndexedTransportTruck(transportTruckId, transportTruckVersion);

			TransportTruck transportTruck = transportFleet.findTheTransportTruck(transportTruckIdVersionKey);
			if(transportTruck == null){
				throw new TransportFleetManagerException(transportTruckId+" is NOT FOUND" );
			}

			beforeUpdateTransportTruck(userContext, transportTruck, transportFleetId, transportTruckId, transportTruckVersion, property, newValueExpr,  tokensExpr);
			transportTruck.changeProperty(property, newValueExpr);
			
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTruckList().done());
			transportTruckManagerOf(userContext).onUpdated(userContext, transportTruck, this, "updateTransportTruck");
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateTransportTruck(RetailscmUserContext userContext, TransportTruck existed, String transportFleetId, String transportTruckId, int transportTruckVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	protected void checkParamsForAddingTruckDriver(RetailscmUserContext userContext, String transportFleetId, String name, String driverLicenseNumber, String contactNumber,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfTransportFleet(transportFleetId);


		checkerOf(userContext).checkNameOfTruckDriver(name);

		checkerOf(userContext).checkDriverLicenseNumberOfTruckDriver(driverLicenseNumber);

		checkerOf(userContext).checkContactNumberOfTruckDriver(contactNumber);


		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);



	}
	public  TransportFleet addTruckDriver(RetailscmUserContext userContext, String transportFleetId, String name, String driverLicenseNumber, String contactNumber, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingTruckDriver(userContext,transportFleetId,name, driverLicenseNumber, contactNumber,tokensExpr);

		TruckDriver truckDriver = createTruckDriver(userContext,name, driverLicenseNumber, contactNumber);

		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, emptyOptions());
		synchronized(transportFleet){
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.addTruckDriver( truckDriver );
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTruckDriverList().done());
			
			truckDriverManagerOf(userContext).onNewInstanceCreated(userContext, truckDriver);
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTruckDriverProperties(RetailscmUserContext userContext, String transportFleetId,String id,String name,String driverLicenseNumber,String contactNumber,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfTransportFleet(transportFleetId);
		checkerOf(userContext).checkIdOfTruckDriver(id);

		checkerOf(userContext).checkNameOfTruckDriver( name);
		checkerOf(userContext).checkDriverLicenseNumberOfTruckDriver( driverLicenseNumber);
		checkerOf(userContext).checkContactNumberOfTruckDriver( contactNumber);


		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);


	}
	public  TransportFleet updateTruckDriverProperties(RetailscmUserContext userContext, String transportFleetId, String id,String name,String driverLicenseNumber,String contactNumber, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTruckDriverProperties(userContext,transportFleetId,id,name,driverLicenseNumber,contactNumber,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTruckDriverListList()
				.searchTruckDriverListWith(TruckDriver.ID_PROPERTY, tokens().is(), id).done();

		TransportFleet transportFleetToUpdate = loadTransportFleet(userContext, transportFleetId, options);

		if(transportFleetToUpdate.getTruckDriverList().isEmpty()){
			throw new TransportFleetManagerException("TruckDriver is NOT FOUND with id: '"+id+"'");
		}

		TruckDriver item = transportFleetToUpdate.getTruckDriverList().first();
		beforeUpdateTruckDriverProperties(userContext,item, transportFleetId,id,name,driverLicenseNumber,contactNumber,tokensExpr);
		item.updateName( name );
		item.updateDriverLicenseNumber( driverLicenseNumber );
		item.updateContactNumber( contactNumber );


		//checkParamsForAddingTruckDriver(userContext,transportFleetId,name, code, used,tokensExpr);
		TransportFleet transportFleet = saveTransportFleet(userContext, transportFleetToUpdate, tokens().withTruckDriverList().done());
		synchronized(transportFleet){
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateTruckDriverProperties(RetailscmUserContext userContext, TruckDriver item, String transportFleetId, String id,String name,String driverLicenseNumber,String contactNumber, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected TruckDriver createTruckDriver(RetailscmUserContext userContext, String name, String driverLicenseNumber, String contactNumber) throws Exception{

		TruckDriver truckDriver = new TruckDriver();
		
		
		truckDriver.setName(name);		
		truckDriver.setDriverLicenseNumber(driverLicenseNumber);		
		truckDriver.setContactNumber(contactNumber);
	
		
		return truckDriver;


	}

	protected TruckDriver createIndexedTruckDriver(String id, int version){

		TruckDriver truckDriver = new TruckDriver();
		truckDriver.setId(id);
		truckDriver.setVersion(version);
		return truckDriver;

	}

	protected void checkParamsForRemovingTruckDriverList(RetailscmUserContext userContext, String transportFleetId,
			String truckDriverIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfTransportFleet(transportFleetId);
		for(String truckDriverIdItem: truckDriverIds){
			checkerOf(userContext).checkIdOfTruckDriver(truckDriverIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);

	}
	public  TransportFleet removeTruckDriverList(RetailscmUserContext userContext, String transportFleetId,
			String truckDriverIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingTruckDriverList(userContext, transportFleetId,  truckDriverIds, tokensExpr);


			TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
			synchronized(transportFleet){
				//Will be good when the transportFleet loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				transportFleetDaoOf(userContext).planToRemoveTruckDriverList(transportFleet, truckDriverIds, allTokens());
				transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTruckDriverList().done());
				deleteRelationListInGraph(userContext, transportFleet.getTruckDriverList());
				return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingTruckDriver(RetailscmUserContext userContext, String transportFleetId,
		String truckDriverId, int truckDriverVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfTransportFleet( transportFleetId);
		checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);
		checkerOf(userContext).checkVersionOfTruckDriver(truckDriverVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);


	}
	public  TransportFleet removeTruckDriver(RetailscmUserContext userContext, String transportFleetId,
		String truckDriverId, int truckDriverVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingTruckDriver(userContext,transportFleetId, truckDriverId, truckDriverVersion,tokensExpr);

		TruckDriver truckDriver = createIndexedTruckDriver(truckDriverId, truckDriverVersion);
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.removeTruckDriver( truckDriver );
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTruckDriverList().done());
			deleteRelationInGraph(userContext, truckDriver);
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingTruckDriver(RetailscmUserContext userContext, String transportFleetId,
		String truckDriverId, int truckDriverVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfTransportFleet( transportFleetId);
		checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);
		checkerOf(userContext).checkVersionOfTruckDriver(truckDriverVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);


	}
	public  TransportFleet copyTruckDriverFrom(RetailscmUserContext userContext, String transportFleetId,
		String truckDriverId, int truckDriverVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingTruckDriver(userContext,transportFleetId, truckDriverId, truckDriverVersion,tokensExpr);

		TruckDriver truckDriver = createIndexedTruckDriver(truckDriverId, truckDriverVersion);
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			transportFleet.copyTruckDriverFrom( truckDriver );
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTruckDriverList().done());
			
			truckDriverManagerOf(userContext).onNewInstanceCreated(userContext, (TruckDriver)transportFleet.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingTruckDriver(RetailscmUserContext userContext, String transportFleetId, String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfTransportFleet(transportFleetId);
		checkerOf(userContext).checkIdOfTruckDriver(truckDriverId);
		checkerOf(userContext).checkVersionOfTruckDriver(truckDriverVersion);


		if(TruckDriver.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfTruckDriver(parseString(newValueExpr));
		}
		
		if(TruckDriver.DRIVER_LICENSE_NUMBER_PROPERTY.equals(property)){
			checkerOf(userContext).checkDriverLicenseNumberOfTruckDriver(parseString(newValueExpr));
		}
		
		if(TruckDriver.CONTACT_NUMBER_PROPERTY.equals(property)){
			checkerOf(userContext).checkContactNumberOfTruckDriver(parseString(newValueExpr));
		}
		


		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);


	}

	public  TransportFleet updateTruckDriver(RetailscmUserContext userContext, String transportFleetId, String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingTruckDriver(userContext, transportFleetId, truckDriverId, truckDriverVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withTruckDriverList().searchTruckDriverListWith(TruckDriver.ID_PROPERTY, tokens().equals(), truckDriverId).done();



		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, loadTokens);

		synchronized(transportFleet){
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transportFleet.removeTruckDriver( truckDriver );
			//make changes to AcceleraterAccount.
			TruckDriver truckDriverIdVersionKey = createIndexedTruckDriver(truckDriverId, truckDriverVersion);

			TruckDriver truckDriver = transportFleet.findTheTruckDriver(truckDriverIdVersionKey);
			if(truckDriver == null){
				throw new TransportFleetManagerException(truckDriverId+" is NOT FOUND" );
			}

			beforeUpdateTruckDriver(userContext, truckDriver, transportFleetId, truckDriverId, truckDriverVersion, property, newValueExpr,  tokensExpr);
			truckDriver.changeProperty(property, newValueExpr);
			
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTruckDriverList().done());
			truckDriverManagerOf(userContext).onUpdated(userContext, truckDriver, this, "updateTruckDriver");
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateTruckDriver(RetailscmUserContext userContext, TruckDriver existed, String transportFleetId, String truckDriverId, int truckDriverVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	protected void checkParamsForAddingTransportTask(RetailscmUserContext userContext, String transportFleetId, String name, String start, Date beginTime, String endId, String driverId, String truckId, BigDecimal latitude, BigDecimal longitude,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfTransportFleet(transportFleetId);


		checkerOf(userContext).checkNameOfTransportTask(name);

		checkerOf(userContext).checkStartOfTransportTask(start);

		checkerOf(userContext).checkBeginTimeOfTransportTask(beginTime);

		checkerOf(userContext).checkEndIdOfTransportTask(endId);

		checkerOf(userContext).checkDriverIdOfTransportTask(driverId);

		checkerOf(userContext).checkTruckIdOfTransportTask(truckId);

		checkerOf(userContext).checkLatitudeOfTransportTask(latitude);

		checkerOf(userContext).checkLongitudeOfTransportTask(longitude);


		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);



	}
	public  TransportFleet addTransportTask(RetailscmUserContext userContext, String transportFleetId, String name, String start, Date beginTime, String endId, String driverId, String truckId, BigDecimal latitude, BigDecimal longitude, String [] tokensExpr) throws Exception
	{
		checkParamsForAddingTransportTask(userContext,transportFleetId,name, start, beginTime, endId, driverId, truckId, latitude, longitude,tokensExpr);

		TransportTask transportTask = createTransportTask(userContext,name, start, beginTime, endId, driverId, truckId, latitude, longitude);

		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, emptyOptions());
		synchronized(transportFleet){
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.addTransportTask( transportTask );
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTaskList().done());
			
			transportTaskManagerOf(userContext).onNewInstanceCreated(userContext, transportTask);
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportTaskProperties(RetailscmUserContext userContext, String transportFleetId,String id,String name,String start,Date beginTime,BigDecimal latitude,BigDecimal longitude,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfTransportFleet(transportFleetId);
		checkerOf(userContext).checkIdOfTransportTask(id);

		checkerOf(userContext).checkNameOfTransportTask( name);
		checkerOf(userContext).checkStartOfTransportTask( start);
		checkerOf(userContext).checkBeginTimeOfTransportTask( beginTime);
		checkerOf(userContext).checkLatitudeOfTransportTask( latitude);
		checkerOf(userContext).checkLongitudeOfTransportTask( longitude);


		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);


	}
	public  TransportFleet updateTransportTaskProperties(RetailscmUserContext userContext, String transportFleetId, String id,String name,String start,Date beginTime,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTransportTaskProperties(userContext,transportFleetId,id,name,start,beginTime,latitude,longitude,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportTaskListList()
				.searchTransportTaskListWith(TransportTask.ID_PROPERTY, tokens().is(), id).done();

		TransportFleet transportFleetToUpdate = loadTransportFleet(userContext, transportFleetId, options);

		if(transportFleetToUpdate.getTransportTaskList().isEmpty()){
			throw new TransportFleetManagerException("TransportTask is NOT FOUND with id: '"+id+"'");
		}

		TransportTask item = transportFleetToUpdate.getTransportTaskList().first();
		beforeUpdateTransportTaskProperties(userContext,item, transportFleetId,id,name,start,beginTime,latitude,longitude,tokensExpr);
		item.updateName( name );
		item.updateStart( start );
		item.updateBeginTime( beginTime );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );


		//checkParamsForAddingTransportTask(userContext,transportFleetId,name, code, used,tokensExpr);
		TransportFleet transportFleet = saveTransportFleet(userContext, transportFleetToUpdate, tokens().withTransportTaskList().done());
		synchronized(transportFleet){
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateTransportTaskProperties(RetailscmUserContext userContext, TransportTask item, String transportFleetId, String id,String name,String start,Date beginTime,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
	}

	protected TransportTask createTransportTask(RetailscmUserContext userContext, String name, String start, Date beginTime, String endId, String driverId, String truckId, BigDecimal latitude, BigDecimal longitude) throws Exception{

		TransportTask transportTask = new TransportTask();
		
		
		transportTask.setName(name);		
		transportTask.setStart(start);		
		transportTask.setBeginTime(beginTime);		
		RetailStore  end = new RetailStore();
		end.setId(endId);		
		transportTask.setEnd(end);		
		TruckDriver  driver = new TruckDriver();
		driver.setId(driverId);		
		transportTask.setDriver(driver);		
		TransportTruck  truck = new TransportTruck();
		truck.setId(truckId);		
		transportTask.setTruck(truck);		
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

	protected void checkParamsForRemovingTransportTaskList(RetailscmUserContext userContext, String transportFleetId,
			String transportTaskIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfTransportFleet(transportFleetId);
		for(String transportTaskIdItem: transportTaskIds){
			checkerOf(userContext).checkIdOfTransportTask(transportTaskIdItem);
		}


		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);

	}
	public  TransportFleet removeTransportTaskList(RetailscmUserContext userContext, String transportFleetId,
			String transportTaskIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingTransportTaskList(userContext, transportFleetId,  transportTaskIds, tokensExpr);


			TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
			synchronized(transportFleet){
				//Will be good when the transportFleet loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				transportFleetDaoOf(userContext).planToRemoveTransportTaskList(transportFleet, transportTaskIds, allTokens());
				transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTaskList().done());
				deleteRelationListInGraph(userContext, transportFleet.getTransportTaskList());
				return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingTransportTask(RetailscmUserContext userContext, String transportFleetId,
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfTransportFleet( transportFleetId);
		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).checkVersionOfTransportTask(transportTaskVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);


	}
	public  TransportFleet removeTransportTask(RetailscmUserContext userContext, String transportFleetId,
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingTransportTask(userContext,transportFleetId, transportTaskId, transportTaskVersion,tokensExpr);

		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			transportFleet.removeTransportTask( transportTask );
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTaskList().done());
			deleteRelationInGraph(userContext, transportTask);
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingTransportTask(RetailscmUserContext userContext, String transportFleetId,
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfTransportFleet( transportFleetId);
		checkerOf(userContext).checkIdOfTransportTask(transportTaskId);
		checkerOf(userContext).checkVersionOfTransportTask(transportTaskVersion);

		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);


	}
	public  TransportFleet copyTransportTaskFrom(RetailscmUserContext userContext, String transportFleetId,
		String transportTaskId, int transportTaskVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingTransportTask(userContext,transportFleetId, transportTaskId, transportTaskVersion,tokensExpr);

		TransportTask transportTask = createIndexedTransportTask(transportTaskId, transportTaskVersion);
		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, allTokens());
		synchronized(transportFleet){
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			transportFleet.copyTransportTaskFrom( transportTask );
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTaskList().done());
			
			transportTaskManagerOf(userContext).onNewInstanceCreated(userContext, (TransportTask)transportFleet.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingTransportTask(RetailscmUserContext userContext, String transportFleetId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		


		checkerOf(userContext).checkIdOfTransportFleet(transportFleetId);
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
		


		checkerOf(userContext).throwExceptionIfHasErrors(TransportFleetManagerException.class);


	}

	public  TransportFleet updateTransportTask(RetailscmUserContext userContext, String transportFleetId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingTransportTask(userContext, transportFleetId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withTransportTaskList().searchTransportTaskListWith(TransportTask.ID_PROPERTY, tokens().equals(), transportTaskId).done();



		TransportFleet transportFleet = loadTransportFleet(userContext, transportFleetId, loadTokens);

		synchronized(transportFleet){
			//Will be good when the transportFleet loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//transportFleet.removeTransportTask( transportTask );
			//make changes to AcceleraterAccount.
			TransportTask transportTaskIdVersionKey = createIndexedTransportTask(transportTaskId, transportTaskVersion);

			TransportTask transportTask = transportFleet.findTheTransportTask(transportTaskIdVersionKey);
			if(transportTask == null){
				throw new TransportFleetManagerException(transportTaskId+" is NOT FOUND" );
			}

			beforeUpdateTransportTask(userContext, transportTask, transportFleetId, transportTaskId, transportTaskVersion, property, newValueExpr,  tokensExpr);
			transportTask.changeProperty(property, newValueExpr);
			
			transportFleet = saveTransportFleet(userContext, transportFleet, tokens().withTransportTaskList().done());
			transportTaskManagerOf(userContext).onUpdated(userContext, transportTask, this, "updateTransportTask");
			return present(userContext,transportFleet, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateTransportTask(RetailscmUserContext userContext, TransportTask existed, String transportFleetId, String transportTaskId, int transportTaskVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, TransportFleet newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    transportFleetDaoOf(ctx).loadAllAsStream().forEach(
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
		//   TransportFleet newTransportFleet = this.createTransportFleet(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newTransportFleet
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
    key.put(UserApp.APP_TYPE_PROPERTY, TransportFleet.INTERNAL_TYPE);
    SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
	// -----------------------------------\\  登录部分处理 //-----------------------------------



	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<TransportFleet> list) throws Exception {
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
		SmartList<TransportFleet> list = transportFleetDaoOf(userContext).findTransportFleetByOwner(ownerId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(TransportFleet.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(ownerId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("运输车队列表");
		page.setRequestName("listByOwner");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("document");
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
 	public Object wxappview(RetailscmUserContext userContext, String transportFleetId) throws Exception{
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
		TransportFleet merchantObj = (TransportFleet) this.view(userContext, transportFleetId);
    String merchantObjId = transportFleetId;
    String linkToUrl =	"transportFleetManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "运输车队"+"详情";
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
				MapUtil.put("id", "3-contactNumber")
				    .put("fieldName", "contactNumber")
				    .put("label", "联系电话")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("contactNumber", merchantObj.getContactNumber());

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

		propList.add(
				MapUtil.put("id", "5-contract")
				    .put("fieldName", "contract")
				    .put("label", "合同")
				    .put("type", "document")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("contract", merchantObj.getContract());

		propList.add(
				MapUtil.put("id", "6-lastUpdateTime")
				    .put("fieldName", "lastUpdateTime")
				    .put("label", "更新于")
				    .put("type", "datetime")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("lastUpdateTime", merchantObj.getLastUpdateTime());

		//处理 sectionList

		//处理Section：transportTruckListSection
		Map transportTruckListSection = ListofUtils.buildSection(
		    "transportTruckListSection",
		    "运输卡车列表",
		    null,
		    "",
		    "__no_group",
		    "transportTruckManager/listByOwner/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(transportTruckListSection);

		result.put("transportTruckListSection", ListofUtils.toShortList(merchantObj.getTransportTruckList(), "transportTruck"));

		//处理Section：truckDriverListSection
		Map truckDriverListSection = ListofUtils.buildSection(
		    "truckDriverListSection",
		    "卡车司机列表",
		    null,
		    "",
		    "__no_group",
		    "truckDriverManager/listByBelongsTo/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(truckDriverListSection);

		result.put("truckDriverListSection", ListofUtils.toShortList(merchantObj.getTruckDriverList(), "truckDriver"));

		//处理Section：transportTaskListSection
		Map transportTaskListSection = ListofUtils.buildSection(
		    "transportTaskListSection",
		    "运输任务列表",
		    null,
		    "",
		    "__no_group",
		    "transportTaskManager/listByBelongsTo/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(transportTaskListSection);

		result.put("transportTaskListSection", ListofUtils.toShortList(merchantObj.getTransportTaskList(), "transportTask"));

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




