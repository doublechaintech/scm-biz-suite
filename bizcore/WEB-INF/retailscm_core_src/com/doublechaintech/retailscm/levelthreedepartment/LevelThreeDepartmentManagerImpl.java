
package com.doublechaintech.retailscm.levelthreedepartment;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;


import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;
import com.doublechaintech.retailscm.employee.Employee;

import com.doublechaintech.retailscm.leveltwodepartment.CandidateLevelTwoDepartment;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;






public class LevelThreeDepartmentManagerImpl extends CustomRetailscmCheckerManager implements LevelThreeDepartmentManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = LevelThreeDepartmentTokens.start().withTokenFromListName(listName).done();
		LevelThreeDepartment  levelThreeDepartment = (LevelThreeDepartment) this.loadLevelThreeDepartment(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = levelThreeDepartment.collectRefercencesFromLists();
		levelThreeDepartmentDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, levelThreeDepartment, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new LevelThreeDepartmentGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "LevelThreeDepartment";
	@Override
	public LevelThreeDepartmentDAO daoOf(RetailscmUserContext userContext) {
		return levelThreeDepartmentDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws LevelThreeDepartmentManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new LevelThreeDepartmentManagerException(message);

	}



 	protected LevelThreeDepartment saveLevelThreeDepartment(RetailscmUserContext userContext, LevelThreeDepartment levelThreeDepartment, String [] tokensExpr) throws Exception{	
 		//return getLevelThreeDepartmentDAO().save(levelThreeDepartment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens);
 	}
 	
 	protected LevelThreeDepartment saveLevelThreeDepartmentDetail(RetailscmUserContext userContext, LevelThreeDepartment levelThreeDepartment) throws Exception{	

 		
 		return saveLevelThreeDepartment(userContext, levelThreeDepartment, allTokens());
 	}
 	
 	public LevelThreeDepartment loadLevelThreeDepartment(RetailscmUserContext userContext, String levelThreeDepartmentId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( LevelThreeDepartmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment( userContext, levelThreeDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelThreeDepartment, tokens);
 	}
 	
 	
 	 public LevelThreeDepartment searchLevelThreeDepartment(RetailscmUserContext userContext, String levelThreeDepartmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( LevelThreeDepartmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment( userContext, levelThreeDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,levelThreeDepartment, tokens);
 	}
 	
 	

 	protected LevelThreeDepartment present(RetailscmUserContext userContext, LevelThreeDepartment levelThreeDepartment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,levelThreeDepartment,tokens);
		
		
		LevelThreeDepartment  levelThreeDepartmentToPresent = levelThreeDepartmentDaoOf(userContext).present(levelThreeDepartment, tokens);
		
		List<BaseEntity> entityListToNaming = levelThreeDepartmentToPresent.collectRefercencesFromLists();
		levelThreeDepartmentDaoOf(userContext).alias(entityListToNaming);
		
		return  levelThreeDepartmentToPresent;
		
		
	}
 
 	
 	
 	public LevelThreeDepartment loadLevelThreeDepartmentDetail(RetailscmUserContext userContext, String levelThreeDepartmentId) throws Exception{	
 		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment( userContext, levelThreeDepartmentId, allTokens());
 		return present(userContext,levelThreeDepartment, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String levelThreeDepartmentId) throws Exception{	
 		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment( userContext, levelThreeDepartmentId, viewTokens());
 		return present(userContext,levelThreeDepartment, allTokens());
		
 	}
 	protected LevelThreeDepartment saveLevelThreeDepartment(RetailscmUserContext userContext, LevelThreeDepartment levelThreeDepartment, Map<String,Object>tokens) throws Exception{	
 		return levelThreeDepartmentDaoOf(userContext).save(levelThreeDepartment, tokens);
 	}
 	protected LevelThreeDepartment loadLevelThreeDepartment(RetailscmUserContext userContext, String levelThreeDepartmentId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( LevelThreeDepartmentManagerException.class);

 
 		return levelThreeDepartmentDaoOf(userContext).load(levelThreeDepartmentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LevelThreeDepartment levelThreeDepartment, Map<String, Object> tokens){
		super.addActions(userContext, levelThreeDepartment, tokens);
		
		addAction(userContext, levelThreeDepartment, tokens,"@create","createLevelThreeDepartment","createLevelThreeDepartment/","main","primary");
		addAction(userContext, levelThreeDepartment, tokens,"@update","updateLevelThreeDepartment","updateLevelThreeDepartment/"+levelThreeDepartment.getId()+"/","main","primary");
		addAction(userContext, levelThreeDepartment, tokens,"@copy","cloneLevelThreeDepartment","cloneLevelThreeDepartment/"+levelThreeDepartment.getId()+"/","main","primary");
		
		addAction(userContext, levelThreeDepartment, tokens,"level_three_department.transfer_to_belongs_to","transferToAnotherBelongsTo","transferToAnotherBelongsTo/"+levelThreeDepartment.getId()+"/","main","primary");
		addAction(userContext, levelThreeDepartment, tokens,"level_three_department.addEmployee","addEmployee","addEmployee/"+levelThreeDepartment.getId()+"/","employeeList","primary");
		addAction(userContext, levelThreeDepartment, tokens,"level_three_department.removeEmployee","removeEmployee","removeEmployee/"+levelThreeDepartment.getId()+"/","employeeList","primary");
		addAction(userContext, levelThreeDepartment, tokens,"level_three_department.updateEmployee","updateEmployee","updateEmployee/"+levelThreeDepartment.getId()+"/","employeeList","primary");
		addAction(userContext, levelThreeDepartment, tokens,"level_three_department.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+levelThreeDepartment.getId()+"/","employeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, LevelThreeDepartment levelThreeDepartment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public LevelThreeDepartment createLevelThreeDepartment(RetailscmUserContext userContext, String belongsToId,String name,String description,Date founded) throws Exception
	//public LevelThreeDepartment createLevelThreeDepartment(RetailscmUserContext userContext,String belongsToId, String name, String description, Date founded) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfLevelThreeDepartment(name);
		checkerOf(userContext).checkDescriptionOfLevelThreeDepartment(description);
		checkerOf(userContext).checkFoundedOfLevelThreeDepartment(founded);
	
		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);


		LevelThreeDepartment levelThreeDepartment=createNewLevelThreeDepartment();	

			
		LevelTwoDepartment belongsTo = loadLevelTwoDepartment(userContext, belongsToId,emptyOptions());
		levelThreeDepartment.setBelongsTo(belongsTo);
		
		
		levelThreeDepartment.setName(name);
		levelThreeDepartment.setDescription(description);
		levelThreeDepartment.setFounded(founded);

		levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, emptyOptions());
		
		onNewInstanceCreated(userContext, levelThreeDepartment);
		return levelThreeDepartment;


	}
	protected LevelThreeDepartment createNewLevelThreeDepartment()
	{

		return new LevelThreeDepartment();
	}

	protected void checkParamsForUpdatingLevelThreeDepartment(RetailscmUserContext userContext,String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		checkerOf(userContext).checkVersionOfLevelThreeDepartment( levelThreeDepartmentVersion);
		
		

		
		if(LevelThreeDepartment.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfLevelThreeDepartment(parseString(newValueExpr));
		
			
		}
		if(LevelThreeDepartment.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfLevelThreeDepartment(parseString(newValueExpr));
		
			
		}
		if(LevelThreeDepartment.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfLevelThreeDepartment(parseDate(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);


	}



	public LevelThreeDepartment clone(RetailscmUserContext userContext, String fromLevelThreeDepartmentId) throws Exception{

		return levelThreeDepartmentDaoOf(userContext).clone(fromLevelThreeDepartmentId, this.allTokens());
	}

	public LevelThreeDepartment internalSaveLevelThreeDepartment(RetailscmUserContext userContext, LevelThreeDepartment levelThreeDepartment) throws Exception
	{
		return internalSaveLevelThreeDepartment(userContext, levelThreeDepartment, allTokens());

	}
	public LevelThreeDepartment internalSaveLevelThreeDepartment(RetailscmUserContext userContext, LevelThreeDepartment levelThreeDepartment, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingLevelThreeDepartment(userContext, levelThreeDepartmentId, levelThreeDepartmentVersion, property, newValueExpr, tokensExpr);


		synchronized(levelThreeDepartment){
			//will be good when the levelThreeDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelThreeDepartment.
			if (levelThreeDepartment.isChanged()){
			
			}
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, options);
			return levelThreeDepartment;

		}

	}

	public LevelThreeDepartment updateLevelThreeDepartment(RetailscmUserContext userContext,String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLevelThreeDepartment(userContext, levelThreeDepartmentId, levelThreeDepartmentVersion, property, newValueExpr, tokensExpr);



		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
		if(levelThreeDepartment.getVersion() != levelThreeDepartmentVersion){
			String message = "The target version("+levelThreeDepartment.getVersion()+") is not equals to version("+levelThreeDepartmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelThreeDepartment){
			//will be good when the levelThreeDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelThreeDepartment.
			
			levelThreeDepartment.changeProperty(property, newValueExpr);
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().done());
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
			//return saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().done());
		}

	}

	public LevelThreeDepartment updateLevelThreeDepartmentProperty(RetailscmUserContext userContext,String levelThreeDepartmentId, int levelThreeDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLevelThreeDepartment(userContext, levelThreeDepartmentId, levelThreeDepartmentVersion, property, newValueExpr, tokensExpr);

		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
		if(levelThreeDepartment.getVersion() != levelThreeDepartmentVersion){
			String message = "The target version("+levelThreeDepartment.getVersion()+") is not equals to version("+levelThreeDepartmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(levelThreeDepartment){
			//will be good when the levelThreeDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LevelThreeDepartment.

			levelThreeDepartment.changeProperty(property, newValueExpr);
			
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().done());
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
			//return saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected LevelThreeDepartmentTokens tokens(){
		return LevelThreeDepartmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LevelThreeDepartmentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LevelThreeDepartmentTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherBelongsTo(RetailscmUserContext userContext, String levelThreeDepartmentId, String anotherBelongsToId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
 		checkerOf(userContext).checkIdOfLevelTwoDepartment(anotherBelongsToId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);

 	}
 	public LevelThreeDepartment transferToAnotherBelongsTo(RetailscmUserContext userContext, String levelThreeDepartmentId, String anotherBelongsToId) throws Exception
 	{
 		checkParamsForTransferingAnotherBelongsTo(userContext, levelThreeDepartmentId,anotherBelongsToId);
 
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());	
		synchronized(levelThreeDepartment){
			//will be good when the levelThreeDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			LevelTwoDepartment belongsTo = loadLevelTwoDepartment(userContext, anotherBelongsToId, emptyOptions());		
			levelThreeDepartment.updateBelongsTo(belongsTo);		
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, emptyOptions());
			
			return present(userContext,levelThreeDepartment, allTokens());
			
		}

 	}

	


	public CandidateLevelTwoDepartment requestCandidateBelongsTo(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateLevelTwoDepartment result = new CandidateLevelTwoDepartment();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("belongsTo");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<LevelTwoDepartment> candidateList = levelTwoDepartmentDaoOf(userContext).requestCandidateLevelTwoDepartmentForLevelThreeDepartment(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected LevelTwoDepartment loadLevelTwoDepartment(RetailscmUserContext userContext, String newBelongsToId, Map<String,Object> options) throws Exception
 	{

 		return levelTwoDepartmentDaoOf(userContext).load(newBelongsToId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String levelThreeDepartmentId, int levelThreeDepartmentVersion) throws Exception {
		//deleteInternal(userContext, levelThreeDepartmentId, levelThreeDepartmentVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String levelThreeDepartmentId, int levelThreeDepartmentVersion) throws Exception{

		levelThreeDepartmentDaoOf(userContext).delete(levelThreeDepartmentId, levelThreeDepartmentVersion);
	}

	public LevelThreeDepartment forgetByAll(RetailscmUserContext userContext, String levelThreeDepartmentId, int levelThreeDepartmentVersion) throws Exception {
		return forgetByAllInternal(userContext, levelThreeDepartmentId, levelThreeDepartmentVersion);
	}
	protected LevelThreeDepartment forgetByAllInternal(RetailscmUserContext userContext,
			String levelThreeDepartmentId, int levelThreeDepartmentVersion) throws Exception{

		return levelThreeDepartmentDaoOf(userContext).disconnectFromAll(levelThreeDepartmentId, levelThreeDepartmentVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LevelThreeDepartmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return levelThreeDepartmentDaoOf(userContext).deleteAll();
	}


	//disconnect LevelThreeDepartment with company in Employee
	protected LevelThreeDepartment breakWithEmployeeByCompany(RetailscmUserContext userContext, String levelThreeDepartmentId, String companyId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());

			synchronized(levelThreeDepartment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				levelThreeDepartmentDaoOf(userContext).planToRemoveEmployeeListWithCompany(levelThreeDepartment, companyId, this.emptyOptions());

				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				return levelThreeDepartment;
			}
	}
	//disconnect LevelThreeDepartment with occupation in Employee
	protected LevelThreeDepartment breakWithEmployeeByOccupation(RetailscmUserContext userContext, String levelThreeDepartmentId, String occupationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());

			synchronized(levelThreeDepartment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				levelThreeDepartmentDaoOf(userContext).planToRemoveEmployeeListWithOccupation(levelThreeDepartment, occupationId, this.emptyOptions());

				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				return levelThreeDepartment;
			}
	}
	//disconnect LevelThreeDepartment with responsible_for in Employee
	protected LevelThreeDepartment breakWithEmployeeByResponsibleFor(RetailscmUserContext userContext, String levelThreeDepartmentId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());

			synchronized(levelThreeDepartment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				levelThreeDepartmentDaoOf(userContext).planToRemoveEmployeeListWithResponsibleFor(levelThreeDepartment, responsibleForId, this.emptyOptions());

				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				return levelThreeDepartment;
			}
	}
	//disconnect LevelThreeDepartment with current_salary_grade in Employee
	protected LevelThreeDepartment breakWithEmployeeByCurrentSalaryGrade(RetailscmUserContext userContext, String levelThreeDepartmentId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());

			synchronized(levelThreeDepartment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				levelThreeDepartmentDaoOf(userContext).planToRemoveEmployeeListWithCurrentSalaryGrade(levelThreeDepartment, currentSalaryGradeId, this.emptyOptions());

				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				return levelThreeDepartment;
			}
	}






	protected void checkParamsForAddingEmployee(RetailscmUserContext userContext, String levelThreeDepartmentId, String companyId, String title, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);

		
		checkerOf(userContext).checkCompanyIdOfEmployee(companyId);
		
		checkerOf(userContext).checkTitleOfEmployee(title);
		
		checkerOf(userContext).checkFamilyNameOfEmployee(familyName);
		
		checkerOf(userContext).checkGivenNameOfEmployee(givenName);
		
		checkerOf(userContext).checkEmailOfEmployee(email);
		
		checkerOf(userContext).checkCityOfEmployee(city);
		
		checkerOf(userContext).checkAddressOfEmployee(address);
		
		checkerOf(userContext).checkCellPhoneOfEmployee(cellPhone);
		
		checkerOf(userContext).checkOccupationIdOfEmployee(occupationId);
		
		checkerOf(userContext).checkResponsibleForIdOfEmployee(responsibleForId);
		
		checkerOf(userContext).checkCurrentSalaryGradeIdOfEmployee(currentSalaryGradeId);
		
		checkerOf(userContext).checkSalaryAccountOfEmployee(salaryAccount);
	
		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);


	}
	public  LevelThreeDepartment addEmployee(RetailscmUserContext userContext, String levelThreeDepartmentId, String companyId, String title, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployee(userContext,levelThreeDepartmentId,companyId, title, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);

		Employee employee = createEmployee(userContext,companyId, title, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount);

		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, emptyOptions());
		synchronized(levelThreeDepartment){
			//Will be good when the levelThreeDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelThreeDepartment.addEmployee( employee );
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(RetailscmUserContext userContext, String levelThreeDepartmentId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		checkerOf(userContext).checkIdOfEmployee(id);

		checkerOf(userContext).checkTitleOfEmployee( title);
		checkerOf(userContext).checkFamilyNameOfEmployee( familyName);
		checkerOf(userContext).checkGivenNameOfEmployee( givenName);
		checkerOf(userContext).checkEmailOfEmployee( email);
		checkerOf(userContext).checkCityOfEmployee( city);
		checkerOf(userContext).checkAddressOfEmployee( address);
		checkerOf(userContext).checkCellPhoneOfEmployee( cellPhone);
		checkerOf(userContext).checkSalaryAccountOfEmployee( salaryAccount);

		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);

	}
	public  LevelThreeDepartment updateEmployeeProperties(RetailscmUserContext userContext, String levelThreeDepartmentId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeProperties(userContext,levelThreeDepartmentId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();

		LevelThreeDepartment levelThreeDepartmentToUpdate = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, options);

		if(levelThreeDepartmentToUpdate.getEmployeeList().isEmpty()){
			throw new LevelThreeDepartmentManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}

		Employee item = levelThreeDepartmentToUpdate.getEmployeeList().first();

		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );


		//checkParamsForAddingEmployee(userContext,levelThreeDepartmentId,name, code, used,tokensExpr);
		LevelThreeDepartment levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartmentToUpdate, tokens().withEmployeeList().done());
		synchronized(levelThreeDepartment){
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
		}
	}


	protected Employee createEmployee(RetailscmUserContext userContext, String companyId, String title, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount) throws Exception{

		Employee employee = new Employee();
		
		
		RetailStoreCountryCenter  company = new RetailStoreCountryCenter();
		company.setId(companyId);		
		employee.setCompany(company);		
		employee.setTitle(title);		
		employee.setFamilyName(familyName);		
		employee.setGivenName(givenName);		
		employee.setEmail(email);		
		employee.setCity(city);		
		employee.setAddress(address);		
		employee.setCellPhone(cellPhone);		
		OccupationType  occupation = new OccupationType();
		occupation.setId(occupationId);		
		employee.setOccupation(occupation);		
		ResponsibilityType  responsibleFor = new ResponsibilityType();
		responsibleFor.setId(responsibleForId);		
		employee.setResponsibleFor(responsibleFor);		
		SalaryGrade  currentSalaryGrade = new SalaryGrade();
		currentSalaryGrade.setId(currentSalaryGradeId);		
		employee.setCurrentSalaryGrade(currentSalaryGrade);		
		employee.setSalaryAccount(salaryAccount);		
		employee.setLastUpdateTime(userContext.now());
	
		
		return employee;


	}

	protected Employee createIndexedEmployee(String id, int version){

		Employee employee = new Employee();
		employee.setId(id);
		employee.setVersion(version);
		return employee;

	}

	protected void checkParamsForRemovingEmployeeList(RetailscmUserContext userContext, String levelThreeDepartmentId,
			String employeeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		for(String employeeIdItem: employeeIds){
			checkerOf(userContext).checkIdOfEmployee(employeeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);

	}
	public  LevelThreeDepartment removeEmployeeList(RetailscmUserContext userContext, String levelThreeDepartmentId,
			String employeeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeList(userContext, levelThreeDepartmentId,  employeeIds, tokensExpr);


			LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
			synchronized(levelThreeDepartment){
				//Will be good when the levelThreeDepartment loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				levelThreeDepartmentDaoOf(userContext).planToRemoveEmployeeList(levelThreeDepartment, employeeIds, allTokens());
				levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, levelThreeDepartment.getEmployeeList());
				return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployee(RetailscmUserContext userContext, String levelThreeDepartmentId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfLevelThreeDepartment( levelThreeDepartmentId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);

	}
	public  LevelThreeDepartment removeEmployee(RetailscmUserContext userContext, String levelThreeDepartmentId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingEmployee(userContext,levelThreeDepartmentId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
		synchronized(levelThreeDepartment){
			//Will be good when the levelThreeDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			levelThreeDepartment.removeEmployee( employee );
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingEmployee(RetailscmUserContext userContext, String levelThreeDepartmentId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfLevelThreeDepartment( levelThreeDepartmentId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);

	}
	public  LevelThreeDepartment copyEmployeeFrom(RetailscmUserContext userContext, String levelThreeDepartmentId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingEmployee(userContext,levelThreeDepartmentId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, allTokens());
		synchronized(levelThreeDepartment){
			//Will be good when the levelThreeDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			employee.updateLastUpdateTime(userContext.now());

			levelThreeDepartment.copyEmployeeFrom( employee );
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)levelThreeDepartment.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingEmployee(RetailscmUserContext userContext, String levelThreeDepartmentId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfLevelThreeDepartment(levelThreeDepartmentId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		

		if(Employee.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.FAMILY_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFamilyNameOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.GIVEN_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkGivenNameOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.EMAIL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEmailOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.CITY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCityOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.ADDRESS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAddressOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.CELL_PHONE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCellPhoneOfEmployee(parseString(newValueExpr));
		
		}
		
		if(Employee.SALARY_ACCOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSalaryAccountOfEmployee(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(LevelThreeDepartmentManagerException.class);

	}

	public  LevelThreeDepartment updateEmployee(RetailscmUserContext userContext, String levelThreeDepartmentId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingEmployee(userContext, levelThreeDepartmentId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();



		LevelThreeDepartment levelThreeDepartment = loadLevelThreeDepartment(userContext, levelThreeDepartmentId, loadTokens);

		synchronized(levelThreeDepartment){
			//Will be good when the levelThreeDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//levelThreeDepartment.removeEmployee( employee );
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);

			Employee employee = levelThreeDepartment.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new LevelThreeDepartmentManagerException(employee+" is NOT FOUND" );
			}

			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			levelThreeDepartment = saveLevelThreeDepartment(userContext, levelThreeDepartment, tokens().withEmployeeList().done());
			return present(userContext,levelThreeDepartment, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, LevelThreeDepartment newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

	// -----------------------------------//  登录部分处理 \\-----------------------------------
	// 手机号+短信验证码 登录
	public Object loginByMobile(RetailscmUserContextImpl userContext, String mobile, String verifyCode) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByMobile");
		LoginData loginData = new LoginData();
		loginData.setMobile(mobile);
		loginData.setVerifyCode(verifyCode);

		LoginContext loginContext = LoginContext.of(LoginMethod.MOBILE, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 账号+密码登录
	public Object loginByPassword(RetailscmUserContextImpl userContext, String loginId, Password password) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(), "loginByPassword");
		LoginData loginData = new LoginData();
		loginData.setLoginId(loginId);
		loginData.setPassword(password.getClearTextPassword());

		LoginContext loginContext = LoginContext.of(LoginMethod.PASSWORD, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 微信小程序登录
	public Object loginByWechatMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 企业微信小程序登录
	public Object loginByWechatWorkMiniProgram(RetailscmUserContextImpl userContext, String code) throws Exception {
		LoginChannel loginChannel = LoginChannel.of(RetailscmBaseUtils.getRequestAppType(userContext), this.getBeanName(),
				"loginByWechatWorkMiniProgram");
		LoginData loginData = new LoginData();
		loginData.setCode(code);

		LoginContext loginContext = LoginContext.of(LoginMethod.WECHAT_WORK_MINIPROGRAM, loginChannel, loginData);
		return processLoginRequest(userContext, loginContext);
	}
	// 调用登录处理
	protected Object processLoginRequest(RetailscmUserContextImpl userContext, LoginContext loginContext) throws Exception {
		IamService iamService = (IamService) userContext.getBean("iamService");
		LoginResult loginResult = iamService.doLogin(userContext, loginContext, this);
		// 根据登录结果
		if (!loginResult.isAuthenticated()) {
			throw new Exception(loginResult.getMessage());
		}
		if (loginResult.isSuccess()) {
			return onLoginSuccess(userContext, loginResult);
		}
		if (loginResult.isNewUser()) {
			throw new Exception("请联系你的上级,先为你创建账号,然后再来登录.");
		}
		return new LoginForm();
	}

	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		RetailscmUserContextImpl userContext = (RetailscmUserContextImpl)baseUserContext;
		IamService iamService = (IamService) userContext.getBean("iamService");
		Map<String, Object> loginInfo = iamService.getCachedLoginInfo(userContext);

		SecUser secUser = iamService.tryToLoadSecUser(userContext, loginInfo);
		UserApp userApp = iamService.tryToLoadUserApp(userContext, loginInfo);
		if (userApp != null) {
			userApp.setSecUser(secUser);
		}
		if (secUser == null) {
			iamService.onCheckAccessWhenAnonymousFound(userContext, loginInfo);
		}
		afterSecUserAppLoadedWhenCheckAccess(userContext, loginInfo, secUser, userApp);
		if (!isMethodNeedLogin(userContext, methodName, parameters)) {
			return accessOK();
		}

		return super.checkAccess(baseUserContext, methodName, parameters);
	}

	// 判断哪些接口需要登录后才能执行. 默认除了loginBy开头的,其他都要登录
	protected boolean isMethodNeedLogin(RetailscmUserContextImpl userContext, String methodName, Object[] parameters) {
		if (methodName.startsWith("loginBy")) {
			return false;
		}
		if (methodName.startsWith("logout")) {
			return false;
		}
		return true;
	}

	// 在checkAccess中加载了secUser和userApp后会调用此方法,用于定制化的用户数据加载. 默认什么也不做
	protected void afterSecUserAppLoadedWhenCheckAccess(RetailscmUserContextImpl userContext, Map<String, Object> loginInfo,
			SecUser secUser, UserApp userApp) throws IllegalAccessException{
	}



	protected Object onLoginSuccess(RetailscmUserContext userContext, LoginResult loginResult) throws Exception {
		// by default, return the view of this object
		UserApp userApp = loginResult.getLoginContext().getLoginTarget().getUserApp();
		return this.view(userContext, userApp.getObjectId());
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
		//   LevelThreeDepartment newLevelThreeDepartment = this.createLevelThreeDepartment(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newLevelThreeDepartment
		//   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(), ...
		// Also, set it into loginContext:
		//   loginContext.getLoginTarget().setUserApp(userApp);
		// Since many of detailed info were depending business requirement, So,
		throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
	}
	public void onAuthenticateUserLogged(RetailscmUserContext userContext, LoginContext loginContext,
			LoginResult loginResult, IdentificationHandler idHandler, BusinessHandler bizHandler)
			throws Exception {
		// by default, find the correct user-app
		SecUser secUser = loginResult.getLoginContext().getLoginTarget().getSecUser();
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_TYPE_PROPERTY, LevelThreeDepartment.INTERNAL_TYPE);
		SmartList<UserApp> userApps = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
		if (userApps == null || userApps.isEmpty()) {
			throw new Exception("您的账号未关联销售人员,请联系客服处理账号异常.");
		}
		UserApp userApp = userApps.first();
		userApp.setSecUser(secUser);
		loginResult.getLoginContext().getLoginTarget().setUserApp(userApp);
		BaseEntity app = userContext.getDAOGroup().loadBasicData(userApp.getObjectType(), userApp.getObjectId());
		((RetailscmBizUserContextImpl)userContext).setCurrentUserInfo(app);
	}
	// -----------------------------------\\  登录部分处理 //-----------------------------------


	// -----------------------------------// list-of-view 处理 \\-----------------------------------
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<LevelThreeDepartment> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<LevelTwoDepartment> belongsToList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, LevelTwoDepartment.class);
		userContext.getDAOGroup().enhanceList(belongsToList, LevelTwoDepartment.class);


    }
	
	public Object listByBelongsTo(RetailscmUserContext userContext,String belongsToId) throws Exception {
		return listPageByBelongsTo(userContext, belongsToId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByBelongsTo(RetailscmUserContext userContext,String belongsToId, int start, int count) throws Exception {
		SmartList<LevelThreeDepartment> list = levelThreeDepartmentDaoOf(userContext).findLevelThreeDepartmentByBelongsTo(belongsToId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(LevelThreeDepartment.class);
		page.setContainerObject(LevelTwoDepartment.withId(belongsToId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("三级部门列表");
		page.setRequestName("listByBelongsTo");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByBelongsTo/%s/",  getBeanName(), belongsToId)));

		page.assemblerContent(userContext, "listByBelongsTo");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String levelThreeDepartmentId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getLevelThreeDepartmentDetailScope().clone();
		LevelThreeDepartment merchantObj = (LevelThreeDepartment) this.view(userContext, levelThreeDepartmentId);
    String merchantObjId = levelThreeDepartmentId;
    String linkToUrl =	"levelThreeDepartmentManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "三级部门"+"详情";
		Map result = new HashMap();
		List propList = new ArrayList();
		List sections = new ArrayList();
 
		propList.add(
				MapUtil.put("id", "1-id")
				    .put("fieldName", "id")
				    .put("label", "序号")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("id", merchantObj.getId());

		propList.add(
				MapUtil.put("id", "2-belongsTo")
				    .put("fieldName", "belongsTo")
				    .put("label", "属于")
				    .put("type", "auto")
				    .put("linkToUrl", "levelTwoDepartmentManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("belongsTo", merchantObj.getBelongsTo());

		propList.add(
				MapUtil.put("id", "3-name")
				    .put("fieldName", "name")
				    .put("label", "名称")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("name", merchantObj.getName());

		propList.add(
				MapUtil.put("id", "4-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

		propList.add(
				MapUtil.put("id", "5-founded")
				    .put("fieldName", "founded")
				    .put("label", "成立")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("founded", merchantObj.getFounded());

		//处理 sectionList

		//处理Section：employeeListSection
		Map employeeListSection = ListofUtils.buildSection(
		    "employeeListSection",
		    "员工列表",
		    null,
		    "",
		    "__no_group",
		    "employeeManager/listByDepartment/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeeListSection);

		result.put("employeeListSection", ListofUtils.toShortList(merchantObj.getEmployeeList(), "employee"));
		vscope.field("employeeListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( Employee.class.getName(), null));

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


