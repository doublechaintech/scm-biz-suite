
package com.doublechaintech.retailscm.provincecenterdepartment;

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


import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;

import com.doublechaintech.retailscm.retailstoreprovincecenter.CandidateRetailStoreProvinceCenter;

import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;






public class ProvinceCenterDepartmentManagerImpl extends CustomRetailscmCheckerManager implements ProvinceCenterDepartmentManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = ProvinceCenterDepartmentTokens.start().withTokenFromListName(listName).done();
		ProvinceCenterDepartment  provinceCenterDepartment = (ProvinceCenterDepartment) this.loadProvinceCenterDepartment(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = provinceCenterDepartment.collectRefercencesFromLists();
		provinceCenterDepartmentDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, provinceCenterDepartment, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new ProvinceCenterDepartmentGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "ProvinceCenterDepartment";
	@Override
	public ProvinceCenterDepartmentDAO daoOf(RetailscmUserContext userContext) {
		return provinceCenterDepartmentDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws ProvinceCenterDepartmentManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new ProvinceCenterDepartmentManagerException(message);

	}



 	protected ProvinceCenterDepartment saveProvinceCenterDepartment(RetailscmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment, String [] tokensExpr) throws Exception{	
 		//return getProvinceCenterDepartmentDAO().save(provinceCenterDepartment, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens);
 	}
 	
 	protected ProvinceCenterDepartment saveProvinceCenterDepartmentDetail(RetailscmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment) throws Exception{	

 		
 		return saveProvinceCenterDepartment(userContext, provinceCenterDepartment, allTokens());
 	}
 	
 	public ProvinceCenterDepartment loadProvinceCenterDepartment(RetailscmUserContext userContext, String provinceCenterDepartmentId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( ProvinceCenterDepartmentManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment( userContext, provinceCenterDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,provinceCenterDepartment, tokens);
 	}
 	
 	
 	 public ProvinceCenterDepartment searchProvinceCenterDepartment(RetailscmUserContext userContext, String provinceCenterDepartmentId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( ProvinceCenterDepartmentManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment( userContext, provinceCenterDepartmentId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,provinceCenterDepartment, tokens);
 	}
 	
 	

 	protected ProvinceCenterDepartment present(RetailscmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,provinceCenterDepartment,tokens);
		
		
		ProvinceCenterDepartment  provinceCenterDepartmentToPresent = provinceCenterDepartmentDaoOf(userContext).present(provinceCenterDepartment, tokens);
		
		List<BaseEntity> entityListToNaming = provinceCenterDepartmentToPresent.collectRefercencesFromLists();
		provinceCenterDepartmentDaoOf(userContext).alias(entityListToNaming);
		
		return  provinceCenterDepartmentToPresent;
		
		
	}
 
 	
 	
 	public ProvinceCenterDepartment loadProvinceCenterDepartmentDetail(RetailscmUserContext userContext, String provinceCenterDepartmentId) throws Exception{	
 		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment( userContext, provinceCenterDepartmentId, allTokens());
 		return present(userContext,provinceCenterDepartment, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String provinceCenterDepartmentId) throws Exception{	
 		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment( userContext, provinceCenterDepartmentId, viewTokens());
 		return present(userContext,provinceCenterDepartment, allTokens());
		
 	}
 	protected ProvinceCenterDepartment saveProvinceCenterDepartment(RetailscmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment, Map<String,Object>tokens) throws Exception{	
 		return provinceCenterDepartmentDaoOf(userContext).save(provinceCenterDepartment, tokens);
 	}
 	protected ProvinceCenterDepartment loadProvinceCenterDepartment(RetailscmUserContext userContext, String provinceCenterDepartmentId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
		checkerOf(userContext).throwExceptionIfHasErrors( ProvinceCenterDepartmentManagerException.class);

 
 		return provinceCenterDepartmentDaoOf(userContext).load(provinceCenterDepartmentId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment, Map<String, Object> tokens){
		super.addActions(userContext, provinceCenterDepartment, tokens);
		
		addAction(userContext, provinceCenterDepartment, tokens,"@create","createProvinceCenterDepartment","createProvinceCenterDepartment/","main","primary");
		addAction(userContext, provinceCenterDepartment, tokens,"@update","updateProvinceCenterDepartment","updateProvinceCenterDepartment/"+provinceCenterDepartment.getId()+"/","main","primary");
		addAction(userContext, provinceCenterDepartment, tokens,"@copy","cloneProvinceCenterDepartment","cloneProvinceCenterDepartment/"+provinceCenterDepartment.getId()+"/","main","primary");
		
		addAction(userContext, provinceCenterDepartment, tokens,"province_center_department.transfer_to_province_center","transferToAnotherProvinceCenter","transferToAnotherProvinceCenter/"+provinceCenterDepartment.getId()+"/","main","primary");
		addAction(userContext, provinceCenterDepartment, tokens,"province_center_department.addProvinceCenterEmployee","addProvinceCenterEmployee","addProvinceCenterEmployee/"+provinceCenterDepartment.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, provinceCenterDepartment, tokens,"province_center_department.removeProvinceCenterEmployee","removeProvinceCenterEmployee","removeProvinceCenterEmployee/"+provinceCenterDepartment.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, provinceCenterDepartment, tokens,"province_center_department.updateProvinceCenterEmployee","updateProvinceCenterEmployee","updateProvinceCenterEmployee/"+provinceCenterDepartment.getId()+"/","provinceCenterEmployeeList","primary");
		addAction(userContext, provinceCenterDepartment, tokens,"province_center_department.copyProvinceCenterEmployeeFrom","copyProvinceCenterEmployeeFrom","copyProvinceCenterEmployeeFrom/"+provinceCenterDepartment.getId()+"/","provinceCenterEmployeeList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public ProvinceCenterDepartment createProvinceCenterDepartment(RetailscmUserContext userContext, String name,Date founded,String provinceCenterId,String manager) throws Exception
	//public ProvinceCenterDepartment createProvinceCenterDepartment(RetailscmUserContext userContext,String name, Date founded, String provinceCenterId, String manager) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfProvinceCenterDepartment(name);
		checkerOf(userContext).checkFoundedOfProvinceCenterDepartment(founded);
		checkerOf(userContext).checkManagerOfProvinceCenterDepartment(manager);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);


		ProvinceCenterDepartment provinceCenterDepartment=createNewProvinceCenterDepartment();	

		provinceCenterDepartment.setName(name);
		provinceCenterDepartment.setFounded(founded);
			
		RetailStoreProvinceCenter provinceCenter = loadRetailStoreProvinceCenter(userContext, provinceCenterId,emptyOptions());
		provinceCenterDepartment.setProvinceCenter(provinceCenter);
		
		
		provinceCenterDepartment.setManager(manager);

		provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, emptyOptions());
		
		onNewInstanceCreated(userContext, provinceCenterDepartment);
		return provinceCenterDepartment;


	}
	protected ProvinceCenterDepartment createNewProvinceCenterDepartment()
	{

		return new ProvinceCenterDepartment();
	}

	protected void checkParamsForUpdatingProvinceCenterDepartment(RetailscmUserContext userContext,String provinceCenterDepartmentId, int provinceCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
		checkerOf(userContext).checkVersionOfProvinceCenterDepartment( provinceCenterDepartmentVersion);
		

		if(ProvinceCenterDepartment.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfProvinceCenterDepartment(parseString(newValueExpr));
		
			
		}
		if(ProvinceCenterDepartment.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfProvinceCenterDepartment(parseDate(newValueExpr));
		
			
		}		

		
		if(ProvinceCenterDepartment.MANAGER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkManagerOfProvinceCenterDepartment(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);


	}



	public ProvinceCenterDepartment clone(RetailscmUserContext userContext, String fromProvinceCenterDepartmentId) throws Exception{

		return provinceCenterDepartmentDaoOf(userContext).clone(fromProvinceCenterDepartmentId, this.allTokens());
	}

	public ProvinceCenterDepartment internalSaveProvinceCenterDepartment(RetailscmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment) throws Exception
	{
		return internalSaveProvinceCenterDepartment(userContext, provinceCenterDepartment, allTokens());

	}
	public ProvinceCenterDepartment internalSaveProvinceCenterDepartment(RetailscmUserContext userContext, ProvinceCenterDepartment provinceCenterDepartment, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingProvinceCenterDepartment(userContext, provinceCenterDepartmentId, provinceCenterDepartmentVersion, property, newValueExpr, tokensExpr);


		synchronized(provinceCenterDepartment){
			//will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProvinceCenterDepartment.
			if (provinceCenterDepartment.isChanged()){
			
			}
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, options);
			return provinceCenterDepartment;

		}

	}

	public ProvinceCenterDepartment updateProvinceCenterDepartment(RetailscmUserContext userContext,String provinceCenterDepartmentId, int provinceCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingProvinceCenterDepartment(userContext, provinceCenterDepartmentId, provinceCenterDepartmentVersion, property, newValueExpr, tokensExpr);



		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
		if(provinceCenterDepartment.getVersion() != provinceCenterDepartmentVersion){
			String message = "The target version("+provinceCenterDepartment.getVersion()+") is not equals to version("+provinceCenterDepartmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(provinceCenterDepartment){
			//will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProvinceCenterDepartment.
			
			provinceCenterDepartment.changeProperty(property, newValueExpr);
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().done());
			return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
			//return saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().done());
		}

	}

	public ProvinceCenterDepartment updateProvinceCenterDepartmentProperty(RetailscmUserContext userContext,String provinceCenterDepartmentId, int provinceCenterDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingProvinceCenterDepartment(userContext, provinceCenterDepartmentId, provinceCenterDepartmentVersion, property, newValueExpr, tokensExpr);

		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
		if(provinceCenterDepartment.getVersion() != provinceCenterDepartmentVersion){
			String message = "The target version("+provinceCenterDepartment.getVersion()+") is not equals to version("+provinceCenterDepartmentVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(provinceCenterDepartment){
			//will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ProvinceCenterDepartment.

			provinceCenterDepartment.changeProperty(property, newValueExpr);
			
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().done());
			return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
			//return saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected ProvinceCenterDepartmentTokens tokens(){
		return ProvinceCenterDepartmentTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ProvinceCenterDepartmentTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortProvinceCenterEmployeeListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ProvinceCenterDepartmentTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherProvinceCenter(RetailscmUserContext userContext, String provinceCenterDepartmentId, String anotherProvinceCenterId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
 		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(anotherProvinceCenterId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);

 	}
 	public ProvinceCenterDepartment transferToAnotherProvinceCenter(RetailscmUserContext userContext, String provinceCenterDepartmentId, String anotherProvinceCenterId) throws Exception
 	{
 		checkParamsForTransferingAnotherProvinceCenter(userContext, provinceCenterDepartmentId,anotherProvinceCenterId);
 
		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());	
		synchronized(provinceCenterDepartment){
			//will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreProvinceCenter provinceCenter = loadRetailStoreProvinceCenter(userContext, anotherProvinceCenterId, emptyOptions());		
			provinceCenterDepartment.updateProvinceCenter(provinceCenter);		
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, emptyOptions());
			
			return present(userContext,provinceCenterDepartment, allTokens());
			
		}

 	}

	


	public CandidateRetailStoreProvinceCenter requestCandidateProvinceCenter(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateRetailStoreProvinceCenter result = new CandidateRetailStoreProvinceCenter();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");

		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<RetailStoreProvinceCenter> candidateList = retailStoreProvinceCenterDaoOf(userContext).requestCandidateRetailStoreProvinceCenterForProvinceCenterDepartment(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreProvinceCenter loadRetailStoreProvinceCenter(RetailscmUserContext userContext, String newProvinceCenterId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreProvinceCenterDaoOf(userContext).load(newProvinceCenterId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String provinceCenterDepartmentId, int provinceCenterDepartmentVersion) throws Exception {
		//deleteInternal(userContext, provinceCenterDepartmentId, provinceCenterDepartmentVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String provinceCenterDepartmentId, int provinceCenterDepartmentVersion) throws Exception{

		provinceCenterDepartmentDaoOf(userContext).delete(provinceCenterDepartmentId, provinceCenterDepartmentVersion);
	}

	public ProvinceCenterDepartment forgetByAll(RetailscmUserContext userContext, String provinceCenterDepartmentId, int provinceCenterDepartmentVersion) throws Exception {
		return forgetByAllInternal(userContext, provinceCenterDepartmentId, provinceCenterDepartmentVersion);
	}
	protected ProvinceCenterDepartment forgetByAllInternal(RetailscmUserContext userContext,
			String provinceCenterDepartmentId, int provinceCenterDepartmentVersion) throws Exception{

		return provinceCenterDepartmentDaoOf(userContext).disconnectFromAll(provinceCenterDepartmentId, provinceCenterDepartmentVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ProvinceCenterDepartmentManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return provinceCenterDepartmentDaoOf(userContext).deleteAll();
	}


	//disconnect ProvinceCenterDepartment with province_center in ProvinceCenterEmployee
	protected ProvinceCenterDepartment breakWithProvinceCenterEmployeeByProvinceCenter(RetailscmUserContext userContext, String provinceCenterDepartmentId, String provinceCenterId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());

			synchronized(provinceCenterDepartment){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				provinceCenterDepartmentDaoOf(userContext).planToRemoveProvinceCenterEmployeeListWithProvinceCenter(provinceCenterDepartment, provinceCenterId, this.emptyOptions());

				provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().withProvinceCenterEmployeeList().done());
				return provinceCenterDepartment;
			}
	}






	protected void checkParamsForAddingProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterDepartmentId, String name, String mobile, String email, Date founded, String provinceCenterId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);

		
		checkerOf(userContext).checkNameOfProvinceCenterEmployee(name);
		
		checkerOf(userContext).checkMobileOfProvinceCenterEmployee(mobile);
		
		checkerOf(userContext).checkEmailOfProvinceCenterEmployee(email);
		
		checkerOf(userContext).checkFoundedOfProvinceCenterEmployee(founded);
		
		checkerOf(userContext).checkProvinceCenterIdOfProvinceCenterEmployee(provinceCenterId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);


	}
	public  ProvinceCenterDepartment addProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterDepartmentId, String name, String mobile, String email, Date founded, String provinceCenterId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingProvinceCenterEmployee(userContext,provinceCenterDepartmentId,name, mobile, email, founded, provinceCenterId,tokensExpr);

		ProvinceCenterEmployee provinceCenterEmployee = createProvinceCenterEmployee(userContext,name, mobile, email, founded, provinceCenterId);

		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, emptyOptions());
		synchronized(provinceCenterDepartment){
			//Will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			provinceCenterDepartment.addProvinceCenterEmployee( provinceCenterEmployee );
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().withProvinceCenterEmployeeList().done());
			
			userContext.getManagerGroup().getProvinceCenterEmployeeManager().onNewInstanceCreated(userContext, provinceCenterEmployee);
			return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingProvinceCenterEmployeeProperties(RetailscmUserContext userContext, String provinceCenterDepartmentId,String id,String name,String mobile,String email,Date founded,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
		checkerOf(userContext).checkIdOfProvinceCenterEmployee(id);

		checkerOf(userContext).checkNameOfProvinceCenterEmployee( name);
		checkerOf(userContext).checkMobileOfProvinceCenterEmployee( mobile);
		checkerOf(userContext).checkEmailOfProvinceCenterEmployee( email);
		checkerOf(userContext).checkFoundedOfProvinceCenterEmployee( founded);

		checkerOf(userContext).throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);

	}
	public  ProvinceCenterDepartment updateProvinceCenterEmployeeProperties(RetailscmUserContext userContext, String provinceCenterDepartmentId, String id,String name,String mobile,String email,Date founded, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingProvinceCenterEmployeeProperties(userContext,provinceCenterDepartmentId,id,name,mobile,email,founded,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withProvinceCenterEmployeeListList()
				.searchProvinceCenterEmployeeListWith(ProvinceCenterEmployee.ID_PROPERTY, "is", id).done();

		ProvinceCenterDepartment provinceCenterDepartmentToUpdate = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, options);

		if(provinceCenterDepartmentToUpdate.getProvinceCenterEmployeeList().isEmpty()){
			throw new ProvinceCenterDepartmentManagerException("ProvinceCenterEmployee is NOT FOUND with id: '"+id+"'");
		}

		ProvinceCenterEmployee item = provinceCenterDepartmentToUpdate.getProvinceCenterEmployeeList().first();

		item.updateName( name );
		item.updateMobile( mobile );
		item.updateEmail( email );
		item.updateFounded( founded );


		//checkParamsForAddingProvinceCenterEmployee(userContext,provinceCenterDepartmentId,name, code, used,tokensExpr);
		ProvinceCenterDepartment provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartmentToUpdate, tokens().withProvinceCenterEmployeeList().done());
		synchronized(provinceCenterDepartment){
			return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
		}
	}


	protected ProvinceCenterEmployee createProvinceCenterEmployee(RetailscmUserContext userContext, String name, String mobile, String email, Date founded, String provinceCenterId) throws Exception{

		ProvinceCenterEmployee provinceCenterEmployee = new ProvinceCenterEmployee();
		
		
		provinceCenterEmployee.setName(name);		
		provinceCenterEmployee.setMobile(mobile);		
		provinceCenterEmployee.setEmail(email);		
		provinceCenterEmployee.setFounded(founded);		
		RetailStoreProvinceCenter  provinceCenter = new RetailStoreProvinceCenter();
		provinceCenter.setId(provinceCenterId);		
		provinceCenterEmployee.setProvinceCenter(provinceCenter);
	
		
		return provinceCenterEmployee;


	}

	protected ProvinceCenterEmployee createIndexedProvinceCenterEmployee(String id, int version){

		ProvinceCenterEmployee provinceCenterEmployee = new ProvinceCenterEmployee();
		provinceCenterEmployee.setId(id);
		provinceCenterEmployee.setVersion(version);
		return provinceCenterEmployee;

	}

	protected void checkParamsForRemovingProvinceCenterEmployeeList(RetailscmUserContext userContext, String provinceCenterDepartmentId,
			String provinceCenterEmployeeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
		for(String provinceCenterEmployeeIdItem: provinceCenterEmployeeIds){
			checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);

	}
	public  ProvinceCenterDepartment removeProvinceCenterEmployeeList(RetailscmUserContext userContext, String provinceCenterDepartmentId,
			String provinceCenterEmployeeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingProvinceCenterEmployeeList(userContext, provinceCenterDepartmentId,  provinceCenterEmployeeIds, tokensExpr);


			ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
			synchronized(provinceCenterDepartment){
				//Will be good when the provinceCenterDepartment loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				provinceCenterDepartmentDaoOf(userContext).planToRemoveProvinceCenterEmployeeList(provinceCenterDepartment, provinceCenterEmployeeIds, allTokens());
				provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().withProvinceCenterEmployeeList().done());
				deleteRelationListInGraph(userContext, provinceCenterDepartment.getProvinceCenterEmployeeList());
				return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterDepartmentId,
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfProvinceCenterDepartment( provinceCenterDepartmentId);
		checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		checkerOf(userContext).checkVersionOfProvinceCenterEmployee(provinceCenterEmployeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);

	}
	public  ProvinceCenterDepartment removeProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterDepartmentId,
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingProvinceCenterEmployee(userContext,provinceCenterDepartmentId, provinceCenterEmployeeId, provinceCenterEmployeeVersion,tokensExpr);

		ProvinceCenterEmployee provinceCenterEmployee = createIndexedProvinceCenterEmployee(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
		synchronized(provinceCenterDepartment){
			//Will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			provinceCenterDepartment.removeProvinceCenterEmployee( provinceCenterEmployee );
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().withProvinceCenterEmployeeList().done());
			deleteRelationInGraph(userContext, provinceCenterEmployee);
			return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterDepartmentId,
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfProvinceCenterDepartment( provinceCenterDepartmentId);
		checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		checkerOf(userContext).checkVersionOfProvinceCenterEmployee(provinceCenterEmployeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);

	}
	public  ProvinceCenterDepartment copyProvinceCenterEmployeeFrom(RetailscmUserContext userContext, String provinceCenterDepartmentId,
		String provinceCenterEmployeeId, int provinceCenterEmployeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingProvinceCenterEmployee(userContext,provinceCenterDepartmentId, provinceCenterEmployeeId, provinceCenterEmployeeVersion,tokensExpr);

		ProvinceCenterEmployee provinceCenterEmployee = createIndexedProvinceCenterEmployee(provinceCenterEmployeeId, provinceCenterEmployeeVersion);
		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, allTokens());
		synchronized(provinceCenterDepartment){
			//Will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			provinceCenterDepartment.copyProvinceCenterEmployeeFrom( provinceCenterEmployee );
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().withProvinceCenterEmployeeList().done());
			
			userContext.getManagerGroup().getProvinceCenterEmployeeManager().onNewInstanceCreated(userContext, (ProvinceCenterEmployee)provinceCenterDepartment.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterDepartmentId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfProvinceCenterDepartment(provinceCenterDepartmentId);
		checkerOf(userContext).checkIdOfProvinceCenterEmployee(provinceCenterEmployeeId);
		checkerOf(userContext).checkVersionOfProvinceCenterEmployee(provinceCenterEmployeeVersion);
		

		if(ProvinceCenterEmployee.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfProvinceCenterEmployee(parseString(newValueExpr));
		
		}
		
		if(ProvinceCenterEmployee.MOBILE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMobileOfProvinceCenterEmployee(parseString(newValueExpr));
		
		}
		
		if(ProvinceCenterEmployee.EMAIL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEmailOfProvinceCenterEmployee(parseString(newValueExpr));
		
		}
		
		if(ProvinceCenterEmployee.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfProvinceCenterEmployee(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ProvinceCenterDepartmentManagerException.class);

	}

	public  ProvinceCenterDepartment updateProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterDepartmentId, String provinceCenterEmployeeId, int provinceCenterEmployeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingProvinceCenterEmployee(userContext, provinceCenterDepartmentId, provinceCenterEmployeeId, provinceCenterEmployeeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withProvinceCenterEmployeeList().searchProvinceCenterEmployeeListWith(ProvinceCenterEmployee.ID_PROPERTY, "eq", provinceCenterEmployeeId).done();



		ProvinceCenterDepartment provinceCenterDepartment = loadProvinceCenterDepartment(userContext, provinceCenterDepartmentId, loadTokens);

		synchronized(provinceCenterDepartment){
			//Will be good when the provinceCenterDepartment loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//provinceCenterDepartment.removeProvinceCenterEmployee( provinceCenterEmployee );
			//make changes to AcceleraterAccount.
			ProvinceCenterEmployee provinceCenterEmployeeIndex = createIndexedProvinceCenterEmployee(provinceCenterEmployeeId, provinceCenterEmployeeVersion);

			ProvinceCenterEmployee provinceCenterEmployee = provinceCenterDepartment.findTheProvinceCenterEmployee(provinceCenterEmployeeIndex);
			if(provinceCenterEmployee == null){
				throw new ProvinceCenterDepartmentManagerException(provinceCenterEmployee+" is NOT FOUND" );
			}

			provinceCenterEmployee.changeProperty(property, newValueExpr);
			
			provinceCenterDepartment = saveProvinceCenterDepartment(userContext, provinceCenterDepartment, tokens().withProvinceCenterEmployeeList().done());
			return present(userContext,provinceCenterDepartment, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, ProvinceCenterDepartment newCreated) throws Exception{
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
		//   ProvinceCenterDepartment newProvinceCenterDepartment = this.createProvinceCenterDepartment(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newProvinceCenterDepartment
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, ProvinceCenterDepartment.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<ProvinceCenterDepartment> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreProvinceCenter> provinceCenterList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreProvinceCenter.class);
		userContext.getDAOGroup().enhanceList(provinceCenterList, RetailStoreProvinceCenter.class);


    }
	
	public Object listByProvinceCenter(RetailscmUserContext userContext,String provinceCenterId) throws Exception {
		return listPageByProvinceCenter(userContext, provinceCenterId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByProvinceCenter(RetailscmUserContext userContext,String provinceCenterId, int start, int count) throws Exception {
		SmartList<ProvinceCenterDepartment> list = provinceCenterDepartmentDaoOf(userContext).findProvinceCenterDepartmentByProvinceCenter(provinceCenterId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(ProvinceCenterDepartment.class);
		page.setContainerObject(RetailStoreProvinceCenter.withId(provinceCenterId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("省中心列表");
		page.setRequestName("listByProvinceCenter");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByProvinceCenter/%s/",  getBeanName(), provinceCenterId)));

		page.assemblerContent(userContext, "listByProvinceCenter");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String provinceCenterDepartmentId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getProvinceCenterDepartmentDetailScope().clone();
		ProvinceCenterDepartment merchantObj = (ProvinceCenterDepartment) this.view(userContext, provinceCenterDepartmentId);
    String merchantObjId = provinceCenterDepartmentId;
    String linkToUrl =	"provinceCenterDepartmentManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "省中心"+"详情";
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
				MapUtil.put("id", "3-founded")
				    .put("fieldName", "founded")
				    .put("label", "成立")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("founded", merchantObj.getFounded());

		propList.add(
				MapUtil.put("id", "4-provinceCenter")
				    .put("fieldName", "provinceCenter")
				    .put("label", "省中心")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreProvinceCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"founded\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("provinceCenter", merchantObj.getProvinceCenter());

		propList.add(
				MapUtil.put("id", "5-manager")
				    .put("fieldName", "manager")
				    .put("label", "经理")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("manager", merchantObj.getManager());

		//处理 sectionList

		//处理Section：provinceCenterEmployeeListSection
		Map provinceCenterEmployeeListSection = ListofUtils.buildSection(
		    "provinceCenterEmployeeListSection",
		    "省中心员工名单",
		    null,
		    "",
		    "__no_group",
		    "provinceCenterEmployeeManager/listByDepartment/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(provinceCenterEmployeeListSection);

		result.put("provinceCenterEmployeeListSection", ListofUtils.toShortList(merchantObj.getProvinceCenterEmployeeList(), "provinceCenterEmployee"));
		vscope.field("provinceCenterEmployeeListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( ProvinceCenterEmployee.class.getName(), null));

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


