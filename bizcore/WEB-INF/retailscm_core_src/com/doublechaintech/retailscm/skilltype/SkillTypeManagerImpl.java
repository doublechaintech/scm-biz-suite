
package com.doublechaintech.retailscm.skilltype;

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

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkill;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.doublechaintech.retailscm.skilltype.SkillType;
import com.doublechaintech.retailscm.employee.Employee;






public class SkillTypeManagerImpl extends CustomRetailscmCheckerManager implements SkillTypeManager {
	
	private static final String SERVICE_TYPE = "SkillType";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SkillTypeManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SkillTypeManagerException(message);

	}
	
	

 	protected SkillType saveSkillType(RetailscmUserContext userContext, SkillType skillType, String [] tokensExpr) throws Exception{	
 		//return getSkillTypeDAO().save(skillType, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSkillType(userContext, skillType, tokens);
 	}
 	
 	protected SkillType saveSkillTypeDetail(RetailscmUserContext userContext, SkillType skillType) throws Exception{	

 		
 		return saveSkillType(userContext, skillType, allTokens());
 	}
 	
 	public SkillType loadSkillType(RetailscmUserContext userContext, String skillTypeId, String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSkillType(skillTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( SkillTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SkillType skillType = loadSkillType( userContext, skillTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,skillType, tokens);
 	}
 	
 	
 	 public SkillType searchSkillType(RetailscmUserContext userContext, String skillTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		userContext.getChecker().checkIdOfSkillType(skillTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( SkillTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SkillType skillType = loadSkillType( userContext, skillTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,skillType, tokens);
 	}
 	
 	

 	protected SkillType present(RetailscmUserContext userContext, SkillType skillType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,skillType,tokens);
		
		
		SkillType  skillTypeToPresent = userContext.getDAOGroup().getSkillTypeDAO().present(skillType, tokens);
		
		List<BaseEntity> entityListToNaming = skillTypeToPresent.collectRefercencesFromLists();
		userContext.getDAOGroup().getSkillTypeDAO().alias(entityListToNaming);
		
		return  skillTypeToPresent;
		
		
	}
 
 	
 	
 	public SkillType loadSkillTypeDetail(RetailscmUserContext userContext, String skillTypeId) throws Exception{	
 		SkillType skillType = loadSkillType( userContext, skillTypeId, allTokens());
 		return present(userContext,skillType, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String skillTypeId) throws Exception{	
 		SkillType skillType = loadSkillType( userContext, skillTypeId, viewTokens());
 		return present(userContext,skillType, allTokens());
		
 	}
 	protected SkillType saveSkillType(RetailscmUserContext userContext, SkillType skillType, Map<String,Object>tokens) throws Exception{	
 		return userContext.getDAOGroup().getSkillTypeDAO().save(skillType, tokens);
 	}
 	protected SkillType loadSkillType(RetailscmUserContext userContext, String skillTypeId, Map<String,Object>tokens) throws Exception{	
		userContext.getChecker().checkIdOfSkillType(skillTypeId);
		userContext.getChecker().throwExceptionIfHasErrors( SkillTypeManagerException.class);

 
 		return userContext.getDAOGroup().getSkillTypeDAO().load(skillTypeId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SkillType skillType, Map<String, Object> tokens){
		super.addActions(userContext, skillType, tokens);
		
		addAction(userContext, skillType, tokens,"@create","createSkillType","createSkillType/","main","primary");
		addAction(userContext, skillType, tokens,"@update","updateSkillType","updateSkillType/"+skillType.getId()+"/","main","primary");
		addAction(userContext, skillType, tokens,"@copy","cloneSkillType","cloneSkillType/"+skillType.getId()+"/","main","primary");
		
		addAction(userContext, skillType, tokens,"skill_type.transfer_to_company","transferToAnotherCompany","transferToAnotherCompany/"+skillType.getId()+"/","main","primary");
		addAction(userContext, skillType, tokens,"skill_type.addEmployeeSkill","addEmployeeSkill","addEmployeeSkill/"+skillType.getId()+"/","employeeSkillList","primary");
		addAction(userContext, skillType, tokens,"skill_type.removeEmployeeSkill","removeEmployeeSkill","removeEmployeeSkill/"+skillType.getId()+"/","employeeSkillList","primary");
		addAction(userContext, skillType, tokens,"skill_type.updateEmployeeSkill","updateEmployeeSkill","updateEmployeeSkill/"+skillType.getId()+"/","employeeSkillList","primary");
		addAction(userContext, skillType, tokens,"skill_type.copyEmployeeSkillFrom","copyEmployeeSkillFrom","copyEmployeeSkillFrom/"+skillType.getId()+"/","employeeSkillList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, SkillType skillType, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SkillType createSkillType(RetailscmUserContext userContext,String code, String companyId, String description) throws Exception
	{
		
		

		

		userContext.getChecker().checkCodeOfSkillType(code);
		userContext.getChecker().checkDescriptionOfSkillType(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(SkillTypeManagerException.class);


		SkillType skillType=createNewSkillType();	

		skillType.setCode(code);
			
		RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, companyId,emptyOptions());
		skillType.setCompany(company);
		
		
		skillType.setDescription(description);

		skillType = saveSkillType(userContext, skillType, emptyOptions());
		
		onNewInstanceCreated(userContext, skillType);
		return skillType;

		
	}
	protected SkillType createNewSkillType() 
	{
		
		return new SkillType();		
	}
	
	protected void checkParamsForUpdatingSkillType(RetailscmUserContext userContext,String skillTypeId, int skillTypeVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		userContext.getChecker().checkIdOfSkillType(skillTypeId);
		userContext.getChecker().checkVersionOfSkillType( skillTypeVersion);
		

		if(SkillType.CODE_PROPERTY.equals(property)){
			userContext.getChecker().checkCodeOfSkillType(parseString(newValueExpr));
		}		

		
		if(SkillType.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfSkillType(parseString(newValueExpr));
		}
	
		userContext.getChecker().throwExceptionIfHasErrors(SkillTypeManagerException.class);
	
		
	}
	
	
	
	public SkillType clone(RetailscmUserContext userContext, String fromSkillTypeId) throws Exception{
		
		return userContext.getDAOGroup().getSkillTypeDAO().clone(fromSkillTypeId, this.allTokens());
	}
	
	public SkillType internalSaveSkillType(RetailscmUserContext userContext, SkillType skillType) throws Exception 
	{
		return internalSaveSkillType(userContext, skillType, allTokens());

	}
	public SkillType internalSaveSkillType(RetailscmUserContext userContext, SkillType skillType, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSkillType(userContext, skillTypeId, skillTypeVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(skillType){ 
			//will be good when the skillType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SkillType.
			
			
			skillType = saveSkillType(userContext, skillType, options);
			return skillType;
			
		}

	}
	
	public SkillType updateSkillType(RetailscmUserContext userContext,String skillTypeId, int skillTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSkillType(userContext, skillTypeId, skillTypeVersion, property, newValueExpr, tokensExpr);
		
		
		
		SkillType skillType = loadSkillType(userContext, skillTypeId, allTokens());
		if(skillType.getVersion() != skillTypeVersion){
			String message = "The target version("+skillType.getVersion()+") is not equals to version("+skillTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(skillType){ 
			//will be good when the skillType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SkillType.
			
			skillType.changeProperty(property, newValueExpr);
			skillType = saveSkillType(userContext, skillType, tokens().done());
			return present(userContext,skillType, mergedAllTokens(tokensExpr));
			//return saveSkillType(userContext, skillType, tokens().done());
		}

	}
	
	public SkillType updateSkillTypeProperty(RetailscmUserContext userContext,String skillTypeId, int skillTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSkillType(userContext, skillTypeId, skillTypeVersion, property, newValueExpr, tokensExpr);
		
		SkillType skillType = loadSkillType(userContext, skillTypeId, allTokens());
		if(skillType.getVersion() != skillTypeVersion){
			String message = "The target version("+skillType.getVersion()+") is not equals to version("+skillTypeVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(skillType){ 
			//will be good when the skillType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SkillType.
			
			skillType.changeProperty(property, newValueExpr);
			
			skillType = saveSkillType(userContext, skillType, tokens().done());
			return present(userContext,skillType, mergedAllTokens(tokensExpr));
			//return saveSkillType(userContext, skillType, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SkillTypeTokens tokens(){
		return SkillTypeTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SkillTypeTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortEmployeeSkillListWith("id","desc")
		.done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SkillTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String skillTypeId, String anotherCompanyId) throws Exception
 	{
 		
 		userContext.getChecker().checkIdOfSkillType(skillTypeId);
 		userContext.getChecker().checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		userContext.getChecker().throwExceptionIfHasErrors(SkillTypeManagerException.class);
 		
 	}
 	public SkillType transferToAnotherCompany(RetailscmUserContext userContext, String skillTypeId, String anotherCompanyId) throws Exception
 	{
 		checkParamsForTransferingAnotherCompany(userContext, skillTypeId,anotherCompanyId);
 
		SkillType skillType = loadSkillType(userContext, skillTypeId, allTokens());	
		synchronized(skillType){
			//will be good when the skillType loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			RetailStoreCountryCenter company = loadRetailStoreCountryCenter(userContext, anotherCompanyId, emptyOptions());		
			skillType.updateCompany(company);		
			skillType = saveSkillType(userContext, skillType, emptyOptions());
			
			return present(userContext,skillType, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateRetailStoreCountryCenter requestCandidateCompany(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<RetailStoreCountryCenter> candidateList = userContext.getDAOGroup().getRetailStoreCountryCenterDAO().requestCandidateRetailStoreCountryCenterForSkillType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newCompanyId, Map<String,Object> options) throws Exception
 	{
		
 		return userContext.getDAOGroup().getRetailStoreCountryCenterDAO().load(newCompanyId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String skillTypeId, int skillTypeVersion) throws Exception {
		//deleteInternal(userContext, skillTypeId, skillTypeVersion);		
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String skillTypeId, int skillTypeVersion) throws Exception{
			
		userContext.getDAOGroup().getSkillTypeDAO().delete(skillTypeId, skillTypeVersion);
	}
	
	public SkillType forgetByAll(RetailscmUserContext userContext, String skillTypeId, int skillTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, skillTypeId, skillTypeVersion);		
	}
	protected SkillType forgetByAllInternal(RetailscmUserContext userContext,
			String skillTypeId, int skillTypeVersion) throws Exception{
			
		return userContext.getDAOGroup().getSkillTypeDAO().disconnectFromAll(skillTypeId, skillTypeVersion);
	}
	

	
	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SkillTypeManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return userContext.getDAOGroup().getSkillTypeDAO().deleteAll();
	}


	//disconnect SkillType with employee in EmployeeSkill
	protected SkillType breakWithEmployeeSkillByEmployee(RetailscmUserContext userContext, String skillTypeId, String employeeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SkillType skillType = loadSkillType(userContext, skillTypeId, allTokens());

			synchronized(skillType){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				userContext.getDAOGroup().getSkillTypeDAO().planToRemoveEmployeeSkillListWithEmployee(skillType, employeeId, this.emptyOptions());

				skillType = saveSkillType(userContext, skillType, tokens().withEmployeeSkillList().done());
				return skillType;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingEmployeeSkill(RetailscmUserContext userContext, String skillTypeId, String employeeId, String description,String [] tokensExpr) throws Exception{
		
		

		
		
		userContext.getChecker().checkIdOfSkillType(skillTypeId);

		
		userContext.getChecker().checkEmployeeIdOfEmployeeSkill(employeeId);
		
		userContext.getChecker().checkDescriptionOfEmployeeSkill(description);
	
		userContext.getChecker().throwExceptionIfHasErrors(SkillTypeManagerException.class);

	
	}
	public  SkillType addEmployeeSkill(RetailscmUserContext userContext, String skillTypeId, String employeeId, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingEmployeeSkill(userContext,skillTypeId,employeeId, description,tokensExpr);
		
		EmployeeSkill employeeSkill = createEmployeeSkill(userContext,employeeId, description);
		
		SkillType skillType = loadSkillType(userContext, skillTypeId, allTokens());
		synchronized(skillType){ 
			//Will be good when the skillType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			skillType.addEmployeeSkill( employeeSkill );		
			skillType = saveSkillType(userContext, skillType, tokens().withEmployeeSkillList().done());
			
			userContext.getManagerGroup().getEmployeeSkillManager().onNewInstanceCreated(userContext, employeeSkill);
			return present(userContext,skillType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeSkillProperties(RetailscmUserContext userContext, String skillTypeId,String id,String description,String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSkillType(skillTypeId);
		userContext.getChecker().checkIdOfEmployeeSkill(id);
		
		userContext.getChecker().checkDescriptionOfEmployeeSkill( description);

		userContext.getChecker().throwExceptionIfHasErrors(SkillTypeManagerException.class);
		
	}
	public  SkillType updateEmployeeSkillProperties(RetailscmUserContext userContext, String skillTypeId, String id,String description, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingEmployeeSkillProperties(userContext,skillTypeId,id,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeSkillListList()
				.searchEmployeeSkillListWith(EmployeeSkill.ID_PROPERTY, "is", id).done();
		
		SkillType skillTypeToUpdate = loadSkillType(userContext, skillTypeId, options);
		
		if(skillTypeToUpdate.getEmployeeSkillList().isEmpty()){
			throw new SkillTypeManagerException("EmployeeSkill is NOT FOUND with id: '"+id+"'");
		}
		
		EmployeeSkill item = skillTypeToUpdate.getEmployeeSkillList().first();
		
		item.updateDescription( description );

		
		//checkParamsForAddingEmployeeSkill(userContext,skillTypeId,name, code, used,tokensExpr);
		SkillType skillType = saveSkillType(userContext, skillTypeToUpdate, tokens().withEmployeeSkillList().done());
		synchronized(skillType){ 
			return present(userContext,skillType, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected EmployeeSkill createEmployeeSkill(RetailscmUserContext userContext, String employeeId, String description) throws Exception{

		EmployeeSkill employeeSkill = new EmployeeSkill();
		
		
		Employee  employee = new Employee();
		employee.setId(employeeId);		
		employeeSkill.setEmployee(employee);		
		employeeSkill.setDescription(description);
	
		
		return employeeSkill;
	
		
	}
	
	protected EmployeeSkill createIndexedEmployeeSkill(String id, int version){

		EmployeeSkill employeeSkill = new EmployeeSkill();
		employeeSkill.setId(id);
		employeeSkill.setVersion(version);
		return employeeSkill;			
		
	}
	
	protected void checkParamsForRemovingEmployeeSkillList(RetailscmUserContext userContext, String skillTypeId, 
			String employeeSkillIds[],String [] tokensExpr) throws Exception {
		
		userContext.getChecker().checkIdOfSkillType(skillTypeId);
		for(String employeeSkillId: employeeSkillIds){
			userContext.getChecker().checkIdOfEmployeeSkill(employeeSkillId);
		}
		
		userContext.getChecker().throwExceptionIfHasErrors(SkillTypeManagerException.class);
		
	}
	public  SkillType removeEmployeeSkillList(RetailscmUserContext userContext, String skillTypeId, 
			String employeeSkillIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingEmployeeSkillList(userContext, skillTypeId,  employeeSkillIds, tokensExpr);
			
			
			SkillType skillType = loadSkillType(userContext, skillTypeId, allTokens());
			synchronized(skillType){ 
				//Will be good when the skillType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				userContext.getDAOGroup().getSkillTypeDAO().planToRemoveEmployeeSkillList(skillType, employeeSkillIds, allTokens());
				skillType = saveSkillType(userContext, skillType, tokens().withEmployeeSkillList().done());
				deleteRelationListInGraph(userContext, skillType.getEmployeeSkillList());
				return present(userContext,skillType, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingEmployeeSkill(RetailscmUserContext userContext, String skillTypeId, 
		String employeeSkillId, int employeeSkillVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSkillType( skillTypeId);
		userContext.getChecker().checkIdOfEmployeeSkill(employeeSkillId);
		userContext.getChecker().checkVersionOfEmployeeSkill(employeeSkillVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SkillTypeManagerException.class);
	
	}
	public  SkillType removeEmployeeSkill(RetailscmUserContext userContext, String skillTypeId, 
		String employeeSkillId, int employeeSkillVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingEmployeeSkill(userContext,skillTypeId, employeeSkillId, employeeSkillVersion,tokensExpr);
		
		EmployeeSkill employeeSkill = createIndexedEmployeeSkill(employeeSkillId, employeeSkillVersion);
		SkillType skillType = loadSkillType(userContext, skillTypeId, allTokens());
		synchronized(skillType){ 
			//Will be good when the skillType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			skillType.removeEmployeeSkill( employeeSkill );		
			skillType = saveSkillType(userContext, skillType, tokens().withEmployeeSkillList().done());
			deleteRelationInGraph(userContext, employeeSkill);
			return present(userContext,skillType, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingEmployeeSkill(RetailscmUserContext userContext, String skillTypeId, 
		String employeeSkillId, int employeeSkillVersion,String [] tokensExpr) throws Exception{
		
		userContext.getChecker().checkIdOfSkillType( skillTypeId);
		userContext.getChecker().checkIdOfEmployeeSkill(employeeSkillId);
		userContext.getChecker().checkVersionOfEmployeeSkill(employeeSkillVersion);
		userContext.getChecker().throwExceptionIfHasErrors(SkillTypeManagerException.class);
	
	}
	public  SkillType copyEmployeeSkillFrom(RetailscmUserContext userContext, String skillTypeId, 
		String employeeSkillId, int employeeSkillVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingEmployeeSkill(userContext,skillTypeId, employeeSkillId, employeeSkillVersion,tokensExpr);
		
		EmployeeSkill employeeSkill = createIndexedEmployeeSkill(employeeSkillId, employeeSkillVersion);
		SkillType skillType = loadSkillType(userContext, skillTypeId, allTokens());
		synchronized(skillType){ 
			//Will be good when the skillType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			skillType.copyEmployeeSkillFrom( employeeSkill );		
			skillType = saveSkillType(userContext, skillType, tokens().withEmployeeSkillList().done());
			
			userContext.getManagerGroup().getEmployeeSkillManager().onNewInstanceCreated(userContext, (EmployeeSkill)skillType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,skillType, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingEmployeeSkill(RetailscmUserContext userContext, String skillTypeId, String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		userContext.getChecker().checkIdOfSkillType(skillTypeId);
		userContext.getChecker().checkIdOfEmployeeSkill(employeeSkillId);
		userContext.getChecker().checkVersionOfEmployeeSkill(employeeSkillVersion);
		

		if(EmployeeSkill.DESCRIPTION_PROPERTY.equals(property)){
			userContext.getChecker().checkDescriptionOfEmployeeSkill(parseString(newValueExpr));
		}
		
	
		userContext.getChecker().throwExceptionIfHasErrors(SkillTypeManagerException.class);
	
	}
	
	public  SkillType updateEmployeeSkill(RetailscmUserContext userContext, String skillTypeId, String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingEmployeeSkill(userContext, skillTypeId, employeeSkillId, employeeSkillVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withEmployeeSkillList().searchEmployeeSkillListWith(EmployeeSkill.ID_PROPERTY, "eq", employeeSkillId).done();
		
		
		
		SkillType skillType = loadSkillType(userContext, skillTypeId, loadTokens);
		
		synchronized(skillType){ 
			//Will be good when the skillType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//skillType.removeEmployeeSkill( employeeSkill );	
			//make changes to AcceleraterAccount.
			EmployeeSkill employeeSkillIndex = createIndexedEmployeeSkill(employeeSkillId, employeeSkillVersion);
		
			EmployeeSkill employeeSkill = skillType.findTheEmployeeSkill(employeeSkillIndex);
			if(employeeSkill == null){
				throw new SkillTypeManagerException(employeeSkill+" is NOT FOUND" );
			}
			
			employeeSkill.changeProperty(property, newValueExpr);
			
			skillType = saveSkillType(userContext, skillType, tokens().withEmployeeSkillList().done());
			return present(userContext,skillType, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(RetailscmUserContext userContext, SkillType newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


