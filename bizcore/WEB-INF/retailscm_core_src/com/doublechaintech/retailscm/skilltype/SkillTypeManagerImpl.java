
package com.doublechaintech.retailscm.skilltype;

import java.util.*;
import java.math.BigDecimal;
import com.terapico.caf.baseelement.PlainText;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.utils.MapUtil;
import com.terapico.utils.ListofUtils;
import com.terapico.utils.TextUtil;
import com.terapico.caf.BlobObject;
import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.BaseViewPage;
import com.terapico.uccaf.BaseUserContext;



import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkill;

import com.doublechaintech.retailscm.retailstorecountrycenter.CandidateRetailStoreCountryCenter;

import com.doublechaintech.retailscm.skilltype.SkillType;
import com.doublechaintech.retailscm.employee.Employee;






public class SkillTypeManagerImpl extends CustomRetailscmCheckerManager implements SkillTypeManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {

		Map<String,Object> tokens = SkillTypeTokens.start().withTokenFromListName(listName).done();
		SkillType  skillType = (SkillType) this.loadSkillType(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = skillType.collectRefercencesFromLists();
		skillTypeDaoOf(userContext).alias(entityListToNaming);

		return exportListToExcel(userContext, skillType, listName);

	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new SkillTypeGridViewGenerator();
	}
	




  


	private static final String SERVICE_TYPE = "SkillType";
	@Override
	public SkillTypeDAO daoOf(RetailscmUserContext userContext) {
		return skillTypeDaoOf(userContext);
	}

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
 
 		checkerOf(userContext).checkIdOfSkillType(skillTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( SkillTypeManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SkillType skillType = loadSkillType( userContext, skillTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,skillType, tokens);
 	}
 	
 	
 	 public SkillType searchSkillType(RetailscmUserContext userContext, String skillTypeId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSkillType(skillTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( SkillTypeManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText(tokens().startsWith(), textToSearch).initWithArray(tokensExpr);
 		
 		SkillType skillType = loadSkillType( userContext, skillTypeId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,skillType, tokens);
 	}
 	
 	

 	protected SkillType present(RetailscmUserContext userContext, SkillType skillType, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,skillType,tokens);
		
		
		SkillType  skillTypeToPresent = skillTypeDaoOf(userContext).present(skillType, tokens);
		
		List<BaseEntity> entityListToNaming = skillTypeToPresent.collectRefercencesFromLists();
		skillTypeDaoOf(userContext).alias(entityListToNaming);
		
		
		renderActionForList(userContext,skillType,tokens);
		
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
 		return skillTypeDaoOf(userContext).save(skillType, tokens);
 	}
 	protected SkillType loadSkillType(RetailscmUserContext userContext, String skillTypeId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfSkillType(skillTypeId);
		checkerOf(userContext).throwExceptionIfHasErrors( SkillTypeManagerException.class);

 
 		return skillTypeDaoOf(userContext).load(skillTypeId, tokens);
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
	
 	
 	
 
 	
 	

	public SkillType createSkillType(RetailscmUserContext userContext, String code,String companyId,String description) throws Exception
	//public SkillType createSkillType(RetailscmUserContext userContext,String code, String companyId, String description) throws Exception
	{

		

		

		checkerOf(userContext).checkCodeOfSkillType(code);
		checkerOf(userContext).checkDescriptionOfSkillType(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SkillTypeManagerException.class);


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
		

		
		
		checkerOf(userContext).checkIdOfSkillType(skillTypeId);
		checkerOf(userContext).checkVersionOfSkillType( skillTypeVersion);
		

		if(SkillType.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfSkillType(parseString(newValueExpr));
		
			
		}		

		
		if(SkillType.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfSkillType(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(SkillTypeManagerException.class);


	}



	public SkillType clone(RetailscmUserContext userContext, String fromSkillTypeId) throws Exception{

		return skillTypeDaoOf(userContext).clone(fromSkillTypeId, this.allTokens());
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
			if (skillType.isChanged()){
			
			}
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
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SkillTypeTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherCompany(RetailscmUserContext userContext, String skillTypeId, String anotherCompanyId) throws Exception
 	{

 		checkerOf(userContext).checkIdOfSkillType(skillTypeId);
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(anotherCompanyId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(SkillTypeManagerException.class);

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
		SmartList<RetailStoreCountryCenter> candidateList = retailStoreCountryCenterDaoOf(userContext).requestCandidateRetailStoreCountryCenterForSkillType(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}

 //--------------------------------------------------------------
	

 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String newCompanyId, Map<String,Object> options) throws Exception
 	{

 		return retailStoreCountryCenterDaoOf(userContext).load(newCompanyId, options);
 	}
 	


	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String skillTypeId, int skillTypeVersion) throws Exception {
		//deleteInternal(userContext, skillTypeId, skillTypeVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String skillTypeId, int skillTypeVersion) throws Exception{

		skillTypeDaoOf(userContext).delete(skillTypeId, skillTypeVersion);
	}

	public SkillType forgetByAll(RetailscmUserContext userContext, String skillTypeId, int skillTypeVersion) throws Exception {
		return forgetByAllInternal(userContext, skillTypeId, skillTypeVersion);
	}
	protected SkillType forgetByAllInternal(RetailscmUserContext userContext,
			String skillTypeId, int skillTypeVersion) throws Exception{

		return skillTypeDaoOf(userContext).disconnectFromAll(skillTypeId, skillTypeVersion);
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
		return skillTypeDaoOf(userContext).deleteAll();
	}


	//disconnect SkillType with employee in EmployeeSkill
	protected SkillType breakWithEmployeeSkillByEmployee(RetailscmUserContext userContext, String skillTypeId, String employeeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			SkillType skillType = loadSkillType(userContext, skillTypeId, allTokens());

			synchronized(skillType){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				skillTypeDaoOf(userContext).planToRemoveEmployeeSkillListWithEmployee(skillType, employeeId, this.emptyOptions());

				skillType = saveSkillType(userContext, skillType, tokens().withEmployeeSkillList().done());
				return skillType;
			}
	}






	protected void checkParamsForAddingEmployeeSkill(RetailscmUserContext userContext, String skillTypeId, String employeeId, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfSkillType(skillTypeId);

		
		checkerOf(userContext).checkEmployeeIdOfEmployeeSkill(employeeId);
		
		checkerOf(userContext).checkDescriptionOfEmployeeSkill(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SkillTypeManagerException.class);


	}
	public  SkillType addEmployeeSkill(RetailscmUserContext userContext, String skillTypeId, String employeeId, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployeeSkill(userContext,skillTypeId,employeeId, description,tokensExpr);

		EmployeeSkill employeeSkill = createEmployeeSkill(userContext,employeeId, description);

		SkillType skillType = loadSkillType(userContext, skillTypeId, emptyOptions());
		synchronized(skillType){
			//Will be good when the skillType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			skillType.addEmployeeSkill( employeeSkill );
			skillType = saveSkillType(userContext, skillType, tokens().withEmployeeSkillList().done());
			
			employeeSkillManagerOf(userContext).onNewInstanceCreated(userContext, employeeSkill);
			return present(userContext,skillType, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeSkillProperties(RetailscmUserContext userContext, String skillTypeId,String id,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfSkillType(skillTypeId);
		checkerOf(userContext).checkIdOfEmployeeSkill(id);

		checkerOf(userContext).checkDescriptionOfEmployeeSkill( description);

		checkerOf(userContext).throwExceptionIfHasErrors(SkillTypeManagerException.class);

	}
	public  SkillType updateEmployeeSkillProperties(RetailscmUserContext userContext, String skillTypeId, String id,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeSkillProperties(userContext,skillTypeId,id,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeSkillListList()
				.searchEmployeeSkillListWith(EmployeeSkill.ID_PROPERTY, tokens().is(), id).done();

		SkillType skillTypeToUpdate = loadSkillType(userContext, skillTypeId, options);

		if(skillTypeToUpdate.getEmployeeSkillList().isEmpty()){
			throw new SkillTypeManagerException("EmployeeSkill is NOT FOUND with id: '"+id+"'");
		}

		EmployeeSkill item = skillTypeToUpdate.getEmployeeSkillList().first();
		beforeUpdateEmployeeSkillProperties(userContext,item, skillTypeId,id,description,tokensExpr);
		item.updateDescription( description );


		//checkParamsForAddingEmployeeSkill(userContext,skillTypeId,name, code, used,tokensExpr);
		SkillType skillType = saveSkillType(userContext, skillTypeToUpdate, tokens().withEmployeeSkillList().done());
		synchronized(skillType){
			return present(userContext,skillType, mergedAllTokens(tokensExpr));
		}
	}

	protected  void beforeUpdateEmployeeSkillProperties(RetailscmUserContext userContext, EmployeeSkill item, String skillTypeId, String id,String description, String [] tokensExpr)
						throws Exception {
			// by default, nothing to do
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

		checkerOf(userContext).checkIdOfSkillType(skillTypeId);
		for(String employeeSkillIdItem: employeeSkillIds){
			checkerOf(userContext).checkIdOfEmployeeSkill(employeeSkillIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(SkillTypeManagerException.class);

	}
	public  SkillType removeEmployeeSkillList(RetailscmUserContext userContext, String skillTypeId,
			String employeeSkillIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeSkillList(userContext, skillTypeId,  employeeSkillIds, tokensExpr);


			SkillType skillType = loadSkillType(userContext, skillTypeId, allTokens());
			synchronized(skillType){
				//Will be good when the skillType loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				skillTypeDaoOf(userContext).planToRemoveEmployeeSkillList(skillType, employeeSkillIds, allTokens());
				skillType = saveSkillType(userContext, skillType, tokens().withEmployeeSkillList().done());
				deleteRelationListInGraph(userContext, skillType.getEmployeeSkillList());
				return present(userContext,skillType, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployeeSkill(RetailscmUserContext userContext, String skillTypeId,
		String employeeSkillId, int employeeSkillVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSkillType( skillTypeId);
		checkerOf(userContext).checkIdOfEmployeeSkill(employeeSkillId);
		checkerOf(userContext).checkVersionOfEmployeeSkill(employeeSkillVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SkillTypeManagerException.class);

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
		
		checkerOf(userContext).checkIdOfSkillType( skillTypeId);
		checkerOf(userContext).checkIdOfEmployeeSkill(employeeSkillId);
		checkerOf(userContext).checkVersionOfEmployeeSkill(employeeSkillVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SkillTypeManagerException.class);

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
			
			employeeSkillManagerOf(userContext).onNewInstanceCreated(userContext, (EmployeeSkill)skillType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,skillType, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingEmployeeSkill(RetailscmUserContext userContext, String skillTypeId, String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSkillType(skillTypeId);
		checkerOf(userContext).checkIdOfEmployeeSkill(employeeSkillId);
		checkerOf(userContext).checkVersionOfEmployeeSkill(employeeSkillVersion);


		if(EmployeeSkill.DESCRIPTION_PROPERTY.equals(property)){
			checkerOf(userContext).checkDescriptionOfEmployeeSkill(parseString(newValueExpr));
		}
		

		checkerOf(userContext).throwExceptionIfHasErrors(SkillTypeManagerException.class);

	}

	public  SkillType updateEmployeeSkill(RetailscmUserContext userContext, String skillTypeId, String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingEmployeeSkill(userContext, skillTypeId, employeeSkillId, employeeSkillVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withEmployeeSkillList().searchEmployeeSkillListWith(EmployeeSkill.ID_PROPERTY, tokens().equals(), employeeSkillId).done();



		SkillType skillType = loadSkillType(userContext, skillTypeId, loadTokens);

		synchronized(skillType){
			//Will be good when the skillType loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//skillType.removeEmployeeSkill( employeeSkill );
			//make changes to AcceleraterAccount.
			EmployeeSkill employeeSkillIdVersionKey = createIndexedEmployeeSkill(employeeSkillId, employeeSkillVersion);

			EmployeeSkill employeeSkill = skillType.findTheEmployeeSkill(employeeSkillIdVersionKey);
			if(employeeSkill == null){
				throw new SkillTypeManagerException(employeeSkillId+" is NOT FOUND" );
			}

			beforeUpdateEmployeeSkill(userContext, employeeSkill, skillTypeId, employeeSkillId, employeeSkillVersion, property, newValueExpr,  tokensExpr);
			employeeSkill.changeProperty(property, newValueExpr);
			
			skillType = saveSkillType(userContext, skillType, tokens().withEmployeeSkillList().done());
			return present(userContext,skillType, mergedAllTokens(tokensExpr));
		}

	}

	/** if you has something need to do before update data from DB, override this */
	protected void beforeUpdateEmployeeSkill(RetailscmUserContext userContext, EmployeeSkill existed, String skillTypeId, String employeeSkillId, int employeeSkillVersion, String property, String newValueExpr,String [] tokensExpr)
  			throws Exception{
  }
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, SkillType newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);

    
	}

  
  

  public void sendAllItems(RetailscmUserContext ctx) throws Exception{
    skillTypeDaoOf(ctx).loadAllAsStream().forEach(
          event -> sendInitEvent(ctx, event)
    );
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
		//   SkillType newSkillType = this.createSkillType(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newSkillType
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, SkillType.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<SkillType> list) throws Exception {
    	if (list == null || list.isEmpty()){
    		return;
    	}
		List<RetailStoreCountryCenter> companyList = RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, RetailStoreCountryCenter.class);
		userContext.getDAOGroup().enhanceList(companyList, RetailStoreCountryCenter.class);


    }
	
	public Object listByCompany(RetailscmUserContext userContext,String companyId) throws Exception {
		return listPageByCompany(userContext, companyId, 0, 20);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object listPageByCompany(RetailscmUserContext userContext,String companyId, int start, int count) throws Exception {
		SmartList<SkillType> list = skillTypeDaoOf(userContext).findSkillTypeByCompany(companyId, start, count, new HashMap<>());
		enhanceForListOfView(userContext, list);
		RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
		page.setClassOfList(SkillType.class);
		page.setContainerObject(RetailStoreCountryCenter.withId(companyId));
		page.setRequestBeanName(this.getBeanName());
		page.setDataList((SmartList)list);
		page.setPageTitle("技能类型列表");
		page.setRequestName("listByCompany");
		page.setRequestOffset(start);
		page.setRequestLimit(count);
		page.setDisplayMode("auto");
		page.setLinkToUrl(TextUtil.encodeUrl(String.format("%s/listByCompany/%s/",  getBeanName(), companyId)));

		page.assemblerContent(userContext, "listByCompany");
		return page.doRender(userContext);
	}
  
  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v
  
 	/**
	 * miniprogram调用返回固定的detail class
	 *
	 * @return
	 * @throws Exception
	 */
 	public Object wxappview(RetailscmUserContext userContext, String skillTypeId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getSkillTypeDetailScope().clone();
		SkillType merchantObj = (SkillType) this.view(userContext, skillTypeId);
    String merchantObjId = skillTypeId;
    String linkToUrl =	"skillTypeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "技能类型"+"详情";
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
				MapUtil.put("id", "2-code")
				    .put("fieldName", "code")
				    .put("label", "代码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("code", merchantObj.getCode());

		propList.add(
				MapUtil.put("id", "3-company")
				    .put("fieldName", "company")
				    .put("label", "公司")
				    .put("type", "auto")
				    .put("linkToUrl", "retailStoreCountryCenterManager/wxappview/:id/")
				    .put("displayMode", "{\"brief\":\"description\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
				    .into_map()
		);
		result.put("company", merchantObj.getCompany());

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

		//处理 sectionList

		//处理Section：employeeSkillListSection
		Map employeeSkillListSection = ListofUtils.buildSection(
		    "employeeSkillListSection",
		    "员工技能列表",
		    null,
		    "",
		    "__no_group",
		    "employeeSkillManager/listBySkillType/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeeSkillListSection);

		result.put("employeeSkillListSection", ListofUtils.toShortList(merchantObj.getEmployeeSkillList(), "employeeSkill"));
		vscope.field("employeeSkillListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( EmployeeSkill.class.getName(), null));

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


