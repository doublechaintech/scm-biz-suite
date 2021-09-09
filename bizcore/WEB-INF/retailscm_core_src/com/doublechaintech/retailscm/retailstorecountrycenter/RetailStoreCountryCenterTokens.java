
package com.doublechaintech.retailscm.retailstorecountrycenter;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.catalog.CatalogTokens;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterTokens;
import com.doublechaintech.retailscm.retailstore.RetailStoreTokens;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberTokens;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierTokens;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderTokens;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderTokens;
import com.doublechaintech.retailscm.warehouse.WarehouseTokens;
import com.doublechaintech.retailscm.transportfleet.TransportFleetTokens;
import com.doublechaintech.retailscm.accountset.AccountSetTokens;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentTokens;
import com.doublechaintech.retailscm.skilltype.SkillTypeTokens;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeTokens;
import com.doublechaintech.retailscm.terminationreason.TerminationReasonTokens;
import com.doublechaintech.retailscm.terminationtype.TerminationTypeTokens;
import com.doublechaintech.retailscm.occupationtype.OccupationTypeTokens;
import com.doublechaintech.retailscm.leavetype.LeaveTypeTokens;
import com.doublechaintech.retailscm.salarygrade.SalaryGradeTokens;
import com.doublechaintech.retailscm.interviewtype.InterviewTypeTokens;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeTokens;
import com.doublechaintech.retailscm.publicholiday.PublicHolidayTokens;
import com.doublechaintech.retailscm.employee.EmployeeTokens;
import com.doublechaintech.retailscm.instructor.InstructorTokens;
import com.doublechaintech.retailscm.companytraining.CompanyTrainingTokens;





public class RetailStoreCountryCenterTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="retailStoreCountryCenter";

	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){

		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner?
			return false;
		}

 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.
 			return true;
 		}

 		return false;

	}
	protected RetailStoreCountryCenterTokens(){
		//ensure not initialized outside the class
	}
	public  static  RetailStoreCountryCenterTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		RetailStoreCountryCenterTokens tokens = new RetailStoreCountryCenterTokens(options);
		return tokens;

	}
	protected RetailStoreCountryCenterTokens(Map<String,Object> options){
		this.options = options;
	}

	public RetailStoreCountryCenterTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static RetailStoreCountryCenterTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected RetailStoreCountryCenterTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static RetailStoreCountryCenterTokens start(){
		return new RetailStoreCountryCenterTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public RetailStoreCountryCenterTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static RetailStoreCountryCenterTokens loadGroupTokens(String... groupNames){
    RetailStoreCountryCenterTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    

  
     addToken(tokens, CATALOG_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, RETAIL_STORE_PROVINCE_CENTER_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, RETAIL_STORE_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, RETAIL_STORE_MEMBER_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, GOODS_SUPPLIER_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, SUPPLY_ORDER_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, RETAIL_STORE_ORDER_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, WAREHOUSE_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, TRANSPORT_FLEET_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, ACCOUNT_SET_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, LEVEL_ONE_DEPARTMENT_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, SKILL_TYPE_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, RESPONSIBILITY_TYPE_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, TERMINATION_REASON_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, TERMINATION_TYPE_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, OCCUPATION_TYPE_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, LEAVE_TYPE_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, SALARY_GRADE_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, INTERVIEW_TYPE_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, TRAINING_COURSE_TYPE_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, PUBLIC_HOLIDAY_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, EMPLOYEE_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, INSTRUCTOR_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, COMPANY_TRAINING_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(RetailStoreCountryCenterTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
    if (pGroupNames == null || fieldGroups == null){
      return;
    }

    for (String groupName: pGroupNames){
      for(String g: fieldGroups){
        if( Objects.equals(groupName, g)){
          pTokens.addSimpleOptions(pTokenName);
          break;
        }
      }
    }
  }

	public static RetailStoreCountryCenterTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withCatalogListIfViewGroupInclude(viewGroups)
			.withRetailStoreProvinceCenterListIfViewGroupInclude(viewGroups)
			.withRetailStoreListIfViewGroupInclude(viewGroups)
			.withRetailStoreMemberListIfViewGroupInclude(viewGroups)
			.withGoodsSupplierListIfViewGroupInclude(viewGroups)
			.withSupplyOrderListIfViewGroupInclude(viewGroups)
			.withRetailStoreOrderListIfViewGroupInclude(viewGroups)
			.withWarehouseListIfViewGroupInclude(viewGroups)
			.withTransportFleetListIfViewGroupInclude(viewGroups)
			.withAccountSetListIfViewGroupInclude(viewGroups)
			.withLevelOneDepartmentListIfViewGroupInclude(viewGroups)
			.withSkillTypeListIfViewGroupInclude(viewGroups)
			.withResponsibilityTypeListIfViewGroupInclude(viewGroups)
			.withTerminationReasonListIfViewGroupInclude(viewGroups)
			.withTerminationTypeListIfViewGroupInclude(viewGroups)
			.withOccupationTypeListIfViewGroupInclude(viewGroups)
			.withLeaveTypeListIfViewGroupInclude(viewGroups)
			.withSalaryGradeListIfViewGroupInclude(viewGroups)
			.withInterviewTypeListIfViewGroupInclude(viewGroups)
			.withTrainingCourseTypeListIfViewGroupInclude(viewGroups)
			.withPublicHolidayListIfViewGroupInclude(viewGroups)
			.withEmployeeListIfViewGroupInclude(viewGroups)
			.withInstructorListIfViewGroupInclude(viewGroups)
			.withCompanyTrainingListIfViewGroupInclude(viewGroups);

	}

	public static RetailStoreCountryCenterTokens allTokens(){

		return start()
			.withCatalogList()
			.withRetailStoreProvinceCenterList()
			.withRetailStoreList()
			.withRetailStoreMemberList()
			.withGoodsSupplierList()
			.withSupplyOrderList()
			.withRetailStoreOrderList()
			.withWarehouseList()
			.withTransportFleetList()
			.withAccountSetList()
			.withLevelOneDepartmentList()
			.withSkillTypeList()
			.withResponsibilityTypeList()
			.withTerminationReasonList()
			.withTerminationTypeList()
			.withOccupationTypeList()
			.withLeaveTypeList()
			.withSalaryGradeList()
			.withInterviewTypeList()
			.withTrainingCourseTypeList()
			.withPublicHolidayList()
			.withEmployeeList()
			.withInstructorList()
			.withCompanyTrainingList();

	}
	public static RetailStoreCountryCenterTokens withoutListsTokens(){

		return start();

	}

	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	public RetailStoreCountryCenterTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String CATALOG_LIST = "catalogList";
	public String getCatalogList(){
		return CATALOG_LIST;
	}



	public RetailStoreCountryCenterTokens withCatalogListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("产品管理",viewGroups)){
			addSimpleOptions(CATALOG_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withCatalogList(){
		addSimpleOptions(CATALOG_LIST);
		return this;
	}

	public CatalogTokens withCatalogListTokens(){
		//addSimpleOptions(CATALOG_LIST);
		return CatalogTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeCatalogList(){
		addSimpleOptions(CATALOG_LIST+".anaylze");
		return this;
	}
	public boolean analyzeCatalogListEnabled(){

		if(checkOptions(this.options(), CATALOG_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromCatalogList(String idsSeperatedWithComma){
		addSimpleOptions(CATALOG_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int catalogListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortCatalogListWith(String field, String descOrAsc){
		addSortMoreOptions(CATALOG_LIST,catalogListSortCounter++, field, descOrAsc);
		return this;
	}
	private int catalogListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchCatalogListWith(String field, String verb, String value){

		withCatalogList();
		addSearchMoreOptions(CATALOG_LIST,catalogListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfCatalogList(String verb, String value){
		String field = "id|name";
		addSearchMoreOptions(CATALOG_LIST,catalogListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfCatalogList(int rowsPerPage){
		addSimpleOptions(CATALOG_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfCatalogList(int currentPageNumber){
		addSimpleOptions(CATALOG_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfCatalogList(String[] columns){
		addSimpleOptions(CATALOG_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfCatalogList(String[] columns){
		addSimpleOptions(CATALOG_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String RETAIL_STORE_PROVINCE_CENTER_LIST = "retailStoreProvinceCenterList";
	public String getRetailStoreProvinceCenterList(){
		return RETAIL_STORE_PROVINCE_CENTER_LIST;
	}



	public RetailStoreCountryCenterTokens withRetailStoreProvinceCenterListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("组织机构",viewGroups)){
			addSimpleOptions(RETAIL_STORE_PROVINCE_CENTER_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withRetailStoreProvinceCenterList(){
		addSimpleOptions(RETAIL_STORE_PROVINCE_CENTER_LIST);
		return this;
	}

	public RetailStoreProvinceCenterTokens withRetailStoreProvinceCenterListTokens(){
		//addSimpleOptions(RETAIL_STORE_PROVINCE_CENTER_LIST);
		return RetailStoreProvinceCenterTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeRetailStoreProvinceCenterList(){
		addSimpleOptions(RETAIL_STORE_PROVINCE_CENTER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRetailStoreProvinceCenterListEnabled(){

		if(checkOptions(this.options(), RETAIL_STORE_PROVINCE_CENTER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromRetailStoreProvinceCenterList(String idsSeperatedWithComma){
		addSimpleOptions(RETAIL_STORE_PROVINCE_CENTER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int retailStoreProvinceCenterListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortRetailStoreProvinceCenterListWith(String field, String descOrAsc){
		addSortMoreOptions(RETAIL_STORE_PROVINCE_CENTER_LIST,retailStoreProvinceCenterListSortCounter++, field, descOrAsc);
		return this;
	}
	private int retailStoreProvinceCenterListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchRetailStoreProvinceCenterListWith(String field, String verb, String value){

		withRetailStoreProvinceCenterList();
		addSearchMoreOptions(RETAIL_STORE_PROVINCE_CENTER_LIST,retailStoreProvinceCenterListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfRetailStoreProvinceCenterList(String verb, String value){
		String field = "id|name";
		addSearchMoreOptions(RETAIL_STORE_PROVINCE_CENTER_LIST,retailStoreProvinceCenterListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfRetailStoreProvinceCenterList(int rowsPerPage){
		addSimpleOptions(RETAIL_STORE_PROVINCE_CENTER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfRetailStoreProvinceCenterList(int currentPageNumber){
		addSimpleOptions(RETAIL_STORE_PROVINCE_CENTER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfRetailStoreProvinceCenterList(String[] columns){
		addSimpleOptions(RETAIL_STORE_PROVINCE_CENTER_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfRetailStoreProvinceCenterList(String[] columns){
		addSimpleOptions(RETAIL_STORE_PROVINCE_CENTER_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String RETAIL_STORE_LIST = "retailStoreList";
	public String getRetailStoreList(){
		return RETAIL_STORE_LIST;
	}



	public RetailStoreCountryCenterTokens withRetailStoreListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("加盟管理",viewGroups)){
			addSimpleOptions(RETAIL_STORE_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withRetailStoreList(){
		addSimpleOptions(RETAIL_STORE_LIST);
		return this;
	}

	public RetailStoreTokens withRetailStoreListTokens(){
		//addSimpleOptions(RETAIL_STORE_LIST);
		return RetailStoreTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeRetailStoreList(){
		addSimpleOptions(RETAIL_STORE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRetailStoreListEnabled(){

		if(checkOptions(this.options(), RETAIL_STORE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromRetailStoreList(String idsSeperatedWithComma){
		addSimpleOptions(RETAIL_STORE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int retailStoreListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortRetailStoreListWith(String field, String descOrAsc){
		addSortMoreOptions(RETAIL_STORE_LIST,retailStoreListSortCounter++, field, descOrAsc);
		return this;
	}
	private int retailStoreListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchRetailStoreListWith(String field, String verb, String value){

		withRetailStoreList();
		addSearchMoreOptions(RETAIL_STORE_LIST,retailStoreListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfRetailStoreList(String verb, String value){
		String field = "id|name|telephone|owner|description";
		addSearchMoreOptions(RETAIL_STORE_LIST,retailStoreListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfRetailStoreList(int rowsPerPage){
		addSimpleOptions(RETAIL_STORE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfRetailStoreList(int currentPageNumber){
		addSimpleOptions(RETAIL_STORE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfRetailStoreList(String[] columns){
		addSimpleOptions(RETAIL_STORE_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfRetailStoreList(String[] columns){
		addSimpleOptions(RETAIL_STORE_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String RETAIL_STORE_MEMBER_LIST = "retailStoreMemberList";
	public String getRetailStoreMemberList(){
		return RETAIL_STORE_MEMBER_LIST;
	}



	public RetailStoreCountryCenterTokens withRetailStoreMemberListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("会员管理",viewGroups)){
			addSimpleOptions(RETAIL_STORE_MEMBER_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withRetailStoreMemberList(){
		addSimpleOptions(RETAIL_STORE_MEMBER_LIST);
		return this;
	}

	public RetailStoreMemberTokens withRetailStoreMemberListTokens(){
		//addSimpleOptions(RETAIL_STORE_MEMBER_LIST);
		return RetailStoreMemberTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeRetailStoreMemberList(){
		addSimpleOptions(RETAIL_STORE_MEMBER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRetailStoreMemberListEnabled(){

		if(checkOptions(this.options(), RETAIL_STORE_MEMBER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromRetailStoreMemberList(String idsSeperatedWithComma){
		addSimpleOptions(RETAIL_STORE_MEMBER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int retailStoreMemberListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortRetailStoreMemberListWith(String field, String descOrAsc){
		addSortMoreOptions(RETAIL_STORE_MEMBER_LIST,retailStoreMemberListSortCounter++, field, descOrAsc);
		return this;
	}
	private int retailStoreMemberListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchRetailStoreMemberListWith(String field, String verb, String value){

		withRetailStoreMemberList();
		addSearchMoreOptions(RETAIL_STORE_MEMBER_LIST,retailStoreMemberListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfRetailStoreMemberList(String verb, String value){
		String field = "id|name|mobilePhone";
		addSearchMoreOptions(RETAIL_STORE_MEMBER_LIST,retailStoreMemberListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfRetailStoreMemberList(int rowsPerPage){
		addSimpleOptions(RETAIL_STORE_MEMBER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfRetailStoreMemberList(int currentPageNumber){
		addSimpleOptions(RETAIL_STORE_MEMBER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfRetailStoreMemberList(String[] columns){
		addSimpleOptions(RETAIL_STORE_MEMBER_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfRetailStoreMemberList(String[] columns){
		addSimpleOptions(RETAIL_STORE_MEMBER_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String GOODS_SUPPLIER_LIST = "goodsSupplierList";
	public String getGoodsSupplierList(){
		return GOODS_SUPPLIER_LIST;
	}



	public RetailStoreCountryCenterTokens withGoodsSupplierListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("供应管理",viewGroups)){
			addSimpleOptions(GOODS_SUPPLIER_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withGoodsSupplierList(){
		addSimpleOptions(GOODS_SUPPLIER_LIST);
		return this;
	}

	public GoodsSupplierTokens withGoodsSupplierListTokens(){
		//addSimpleOptions(GOODS_SUPPLIER_LIST);
		return GoodsSupplierTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeGoodsSupplierList(){
		addSimpleOptions(GOODS_SUPPLIER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeGoodsSupplierListEnabled(){

		if(checkOptions(this.options(), GOODS_SUPPLIER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromGoodsSupplierList(String idsSeperatedWithComma){
		addSimpleOptions(GOODS_SUPPLIER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int goodsSupplierListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortGoodsSupplierListWith(String field, String descOrAsc){
		addSortMoreOptions(GOODS_SUPPLIER_LIST,goodsSupplierListSortCounter++, field, descOrAsc);
		return this;
	}
	private int goodsSupplierListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchGoodsSupplierListWith(String field, String verb, String value){

		withGoodsSupplierList();
		addSearchMoreOptions(GOODS_SUPPLIER_LIST,goodsSupplierListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfGoodsSupplierList(String verb, String value){
		String field = "id|name|supplyProduct|contactNumber|description";
		addSearchMoreOptions(GOODS_SUPPLIER_LIST,goodsSupplierListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfGoodsSupplierList(int rowsPerPage){
		addSimpleOptions(GOODS_SUPPLIER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfGoodsSupplierList(int currentPageNumber){
		addSimpleOptions(GOODS_SUPPLIER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfGoodsSupplierList(String[] columns){
		addSimpleOptions(GOODS_SUPPLIER_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfGoodsSupplierList(String[] columns){
		addSimpleOptions(GOODS_SUPPLIER_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String SUPPLY_ORDER_LIST = "supplyOrderList";
	public String getSupplyOrderList(){
		return SUPPLY_ORDER_LIST;
	}



	public RetailStoreCountryCenterTokens withSupplyOrderListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("供应管理",viewGroups)){
			addSimpleOptions(SUPPLY_ORDER_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withSupplyOrderList(){
		addSimpleOptions(SUPPLY_ORDER_LIST);
		return this;
	}

	public SupplyOrderTokens withSupplyOrderListTokens(){
		//addSimpleOptions(SUPPLY_ORDER_LIST);
		return SupplyOrderTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeSupplyOrderList(){
		addSimpleOptions(SUPPLY_ORDER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeSupplyOrderListEnabled(){

		if(checkOptions(this.options(), SUPPLY_ORDER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromSupplyOrderList(String idsSeperatedWithComma){
		addSimpleOptions(SUPPLY_ORDER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int supplyOrderListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortSupplyOrderListWith(String field, String descOrAsc){
		addSortMoreOptions(SUPPLY_ORDER_LIST,supplyOrderListSortCounter++, field, descOrAsc);
		return this;
	}
	private int supplyOrderListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchSupplyOrderListWith(String field, String verb, String value){

		withSupplyOrderList();
		addSearchMoreOptions(SUPPLY_ORDER_LIST,supplyOrderListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfSupplyOrderList(String verb, String value){
		String field = "id|title";
		addSearchMoreOptions(SUPPLY_ORDER_LIST,supplyOrderListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfSupplyOrderList(int rowsPerPage){
		addSimpleOptions(SUPPLY_ORDER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfSupplyOrderList(int currentPageNumber){
		addSimpleOptions(SUPPLY_ORDER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfSupplyOrderList(String[] columns){
		addSimpleOptions(SUPPLY_ORDER_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfSupplyOrderList(String[] columns){
		addSimpleOptions(SUPPLY_ORDER_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String RETAIL_STORE_ORDER_LIST = "retailStoreOrderList";
	public String getRetailStoreOrderList(){
		return RETAIL_STORE_ORDER_LIST;
	}



	public RetailStoreCountryCenterTokens withRetailStoreOrderListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("销售管理",viewGroups)){
			addSimpleOptions(RETAIL_STORE_ORDER_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withRetailStoreOrderList(){
		addSimpleOptions(RETAIL_STORE_ORDER_LIST);
		return this;
	}

	public RetailStoreOrderTokens withRetailStoreOrderListTokens(){
		//addSimpleOptions(RETAIL_STORE_ORDER_LIST);
		return RetailStoreOrderTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeRetailStoreOrderList(){
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRetailStoreOrderListEnabled(){

		if(checkOptions(this.options(), RETAIL_STORE_ORDER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromRetailStoreOrderList(String idsSeperatedWithComma){
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int retailStoreOrderListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortRetailStoreOrderListWith(String field, String descOrAsc){
		addSortMoreOptions(RETAIL_STORE_ORDER_LIST,retailStoreOrderListSortCounter++, field, descOrAsc);
		return this;
	}
	private int retailStoreOrderListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchRetailStoreOrderListWith(String field, String verb, String value){

		withRetailStoreOrderList();
		addSearchMoreOptions(RETAIL_STORE_ORDER_LIST,retailStoreOrderListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfRetailStoreOrderList(String verb, String value){
		String field = "id|title";
		addSearchMoreOptions(RETAIL_STORE_ORDER_LIST,retailStoreOrderListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfRetailStoreOrderList(int rowsPerPage){
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfRetailStoreOrderList(int currentPageNumber){
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfRetailStoreOrderList(String[] columns){
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfRetailStoreOrderList(String[] columns){
		addSimpleOptions(RETAIL_STORE_ORDER_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String WAREHOUSE_LIST = "warehouseList";
	public String getWarehouseList(){
		return WAREHOUSE_LIST;
	}



	public RetailStoreCountryCenterTokens withWarehouseListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("仓配运一体化",viewGroups)){
			addSimpleOptions(WAREHOUSE_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withWarehouseList(){
		addSimpleOptions(WAREHOUSE_LIST);
		return this;
	}

	public WarehouseTokens withWarehouseListTokens(){
		//addSimpleOptions(WAREHOUSE_LIST);
		return WarehouseTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeWarehouseList(){
		addSimpleOptions(WAREHOUSE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeWarehouseListEnabled(){

		if(checkOptions(this.options(), WAREHOUSE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromWarehouseList(String idsSeperatedWithComma){
		addSimpleOptions(WAREHOUSE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int warehouseListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortWarehouseListWith(String field, String descOrAsc){
		addSortMoreOptions(WAREHOUSE_LIST,warehouseListSortCounter++, field, descOrAsc);
		return this;
	}
	private int warehouseListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchWarehouseListWith(String field, String verb, String value){

		withWarehouseList();
		addSearchMoreOptions(WAREHOUSE_LIST,warehouseListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfWarehouseList(String verb, String value){
		String field = "id|location|contactNumber|totalArea";
		addSearchMoreOptions(WAREHOUSE_LIST,warehouseListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfWarehouseList(int rowsPerPage){
		addSimpleOptions(WAREHOUSE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfWarehouseList(int currentPageNumber){
		addSimpleOptions(WAREHOUSE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfWarehouseList(String[] columns){
		addSimpleOptions(WAREHOUSE_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfWarehouseList(String[] columns){
		addSimpleOptions(WAREHOUSE_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String TRANSPORT_FLEET_LIST = "transportFleetList";
	public String getTransportFleetList(){
		return TRANSPORT_FLEET_LIST;
	}



	public RetailStoreCountryCenterTokens withTransportFleetListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("仓配运一体化",viewGroups)){
			addSimpleOptions(TRANSPORT_FLEET_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withTransportFleetList(){
		addSimpleOptions(TRANSPORT_FLEET_LIST);
		return this;
	}

	public TransportFleetTokens withTransportFleetListTokens(){
		//addSimpleOptions(TRANSPORT_FLEET_LIST);
		return TransportFleetTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeTransportFleetList(){
		addSimpleOptions(TRANSPORT_FLEET_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTransportFleetListEnabled(){

		if(checkOptions(this.options(), TRANSPORT_FLEET_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromTransportFleetList(String idsSeperatedWithComma){
		addSimpleOptions(TRANSPORT_FLEET_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int transportFleetListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortTransportFleetListWith(String field, String descOrAsc){
		addSortMoreOptions(TRANSPORT_FLEET_LIST,transportFleetListSortCounter++, field, descOrAsc);
		return this;
	}
	private int transportFleetListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchTransportFleetListWith(String field, String verb, String value){

		withTransportFleetList();
		addSearchMoreOptions(TRANSPORT_FLEET_LIST,transportFleetListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfTransportFleetList(String verb, String value){
		String field = "id|name|contactNumber";
		addSearchMoreOptions(TRANSPORT_FLEET_LIST,transportFleetListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfTransportFleetList(int rowsPerPage){
		addSimpleOptions(TRANSPORT_FLEET_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfTransportFleetList(int currentPageNumber){
		addSimpleOptions(TRANSPORT_FLEET_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfTransportFleetList(String[] columns){
		addSimpleOptions(TRANSPORT_FLEET_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfTransportFleetList(String[] columns){
		addSimpleOptions(TRANSPORT_FLEET_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String ACCOUNT_SET_LIST = "accountSetList";
	public String getAccountSetList(){
		return ACCOUNT_SET_LIST;
	}



	public RetailStoreCountryCenterTokens withAccountSetListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("财务管理",viewGroups)){
			addSimpleOptions(ACCOUNT_SET_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withAccountSetList(){
		addSimpleOptions(ACCOUNT_SET_LIST);
		return this;
	}

	public AccountSetTokens withAccountSetListTokens(){
		//addSimpleOptions(ACCOUNT_SET_LIST);
		return AccountSetTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeAccountSetList(){
		addSimpleOptions(ACCOUNT_SET_LIST+".anaylze");
		return this;
	}
	public boolean analyzeAccountSetListEnabled(){

		if(checkOptions(this.options(), ACCOUNT_SET_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromAccountSetList(String idsSeperatedWithComma){
		addSimpleOptions(ACCOUNT_SET_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int accountSetListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortAccountSetListWith(String field, String descOrAsc){
		addSortMoreOptions(ACCOUNT_SET_LIST,accountSetListSortCounter++, field, descOrAsc);
		return this;
	}
	private int accountSetListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchAccountSetListWith(String field, String verb, String value){

		withAccountSetList();
		addSearchMoreOptions(ACCOUNT_SET_LIST,accountSetListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfAccountSetList(String verb, String value){
		String field = "id|name|yearSet|accountingSystem|domesticCurrencyCode|domesticCurrencyName|openingBank|accountNumber";
		addSearchMoreOptions(ACCOUNT_SET_LIST,accountSetListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfAccountSetList(int rowsPerPage){
		addSimpleOptions(ACCOUNT_SET_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfAccountSetList(int currentPageNumber){
		addSimpleOptions(ACCOUNT_SET_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfAccountSetList(String[] columns){
		addSimpleOptions(ACCOUNT_SET_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfAccountSetList(String[] columns){
		addSimpleOptions(ACCOUNT_SET_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String LEVEL_ONE_DEPARTMENT_LIST = "levelOneDepartmentList";
	public String getLevelOneDepartmentList(){
		return LEVEL_ONE_DEPARTMENT_LIST;
	}



	public RetailStoreCountryCenterTokens withLevelOneDepartmentListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("组织机构",viewGroups)){
			addSimpleOptions(LEVEL_ONE_DEPARTMENT_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withLevelOneDepartmentList(){
		addSimpleOptions(LEVEL_ONE_DEPARTMENT_LIST);
		return this;
	}

	public LevelOneDepartmentTokens withLevelOneDepartmentListTokens(){
		//addSimpleOptions(LEVEL_ONE_DEPARTMENT_LIST);
		return LevelOneDepartmentTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeLevelOneDepartmentList(){
		addSimpleOptions(LEVEL_ONE_DEPARTMENT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeLevelOneDepartmentListEnabled(){

		if(checkOptions(this.options(), LEVEL_ONE_DEPARTMENT_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromLevelOneDepartmentList(String idsSeperatedWithComma){
		addSimpleOptions(LEVEL_ONE_DEPARTMENT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int levelOneDepartmentListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortLevelOneDepartmentListWith(String field, String descOrAsc){
		addSortMoreOptions(LEVEL_ONE_DEPARTMENT_LIST,levelOneDepartmentListSortCounter++, field, descOrAsc);
		return this;
	}
	private int levelOneDepartmentListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchLevelOneDepartmentListWith(String field, String verb, String value){

		withLevelOneDepartmentList();
		addSearchMoreOptions(LEVEL_ONE_DEPARTMENT_LIST,levelOneDepartmentListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfLevelOneDepartmentList(String verb, String value){
		String field = "id|name|description|manager";
		addSearchMoreOptions(LEVEL_ONE_DEPARTMENT_LIST,levelOneDepartmentListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfLevelOneDepartmentList(int rowsPerPage){
		addSimpleOptions(LEVEL_ONE_DEPARTMENT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfLevelOneDepartmentList(int currentPageNumber){
		addSimpleOptions(LEVEL_ONE_DEPARTMENT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfLevelOneDepartmentList(String[] columns){
		addSimpleOptions(LEVEL_ONE_DEPARTMENT_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfLevelOneDepartmentList(String[] columns){
		addSimpleOptions(LEVEL_ONE_DEPARTMENT_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String SKILL_TYPE_LIST = "skillTypeList";
	public String getSkillTypeList(){
		return SKILL_TYPE_LIST;
	}



	public RetailStoreCountryCenterTokens withSkillTypeListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("人力资源",viewGroups)){
			addSimpleOptions(SKILL_TYPE_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withSkillTypeList(){
		addSimpleOptions(SKILL_TYPE_LIST);
		return this;
	}

	public SkillTypeTokens withSkillTypeListTokens(){
		//addSimpleOptions(SKILL_TYPE_LIST);
		return SkillTypeTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeSkillTypeList(){
		addSimpleOptions(SKILL_TYPE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeSkillTypeListEnabled(){

		if(checkOptions(this.options(), SKILL_TYPE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromSkillTypeList(String idsSeperatedWithComma){
		addSimpleOptions(SKILL_TYPE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int skillTypeListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortSkillTypeListWith(String field, String descOrAsc){
		addSortMoreOptions(SKILL_TYPE_LIST,skillTypeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int skillTypeListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchSkillTypeListWith(String field, String verb, String value){

		withSkillTypeList();
		addSearchMoreOptions(SKILL_TYPE_LIST,skillTypeListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfSkillTypeList(String verb, String value){
		String field = "id|code|description";
		addSearchMoreOptions(SKILL_TYPE_LIST,skillTypeListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfSkillTypeList(int rowsPerPage){
		addSimpleOptions(SKILL_TYPE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfSkillTypeList(int currentPageNumber){
		addSimpleOptions(SKILL_TYPE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfSkillTypeList(String[] columns){
		addSimpleOptions(SKILL_TYPE_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfSkillTypeList(String[] columns){
		addSimpleOptions(SKILL_TYPE_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String RESPONSIBILITY_TYPE_LIST = "responsibilityTypeList";
	public String getResponsibilityTypeList(){
		return RESPONSIBILITY_TYPE_LIST;
	}



	public RetailStoreCountryCenterTokens withResponsibilityTypeListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("人力资源",viewGroups)){
			addSimpleOptions(RESPONSIBILITY_TYPE_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withResponsibilityTypeList(){
		addSimpleOptions(RESPONSIBILITY_TYPE_LIST);
		return this;
	}

	public ResponsibilityTypeTokens withResponsibilityTypeListTokens(){
		//addSimpleOptions(RESPONSIBILITY_TYPE_LIST);
		return ResponsibilityTypeTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeResponsibilityTypeList(){
		addSimpleOptions(RESPONSIBILITY_TYPE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeResponsibilityTypeListEnabled(){

		if(checkOptions(this.options(), RESPONSIBILITY_TYPE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromResponsibilityTypeList(String idsSeperatedWithComma){
		addSimpleOptions(RESPONSIBILITY_TYPE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int responsibilityTypeListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortResponsibilityTypeListWith(String field, String descOrAsc){
		addSortMoreOptions(RESPONSIBILITY_TYPE_LIST,responsibilityTypeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int responsibilityTypeListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchResponsibilityTypeListWith(String field, String verb, String value){

		withResponsibilityTypeList();
		addSearchMoreOptions(RESPONSIBILITY_TYPE_LIST,responsibilityTypeListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfResponsibilityTypeList(String verb, String value){
		String field = "id|code|baseDescription|detailDescription";
		addSearchMoreOptions(RESPONSIBILITY_TYPE_LIST,responsibilityTypeListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfResponsibilityTypeList(int rowsPerPage){
		addSimpleOptions(RESPONSIBILITY_TYPE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfResponsibilityTypeList(int currentPageNumber){
		addSimpleOptions(RESPONSIBILITY_TYPE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfResponsibilityTypeList(String[] columns){
		addSimpleOptions(RESPONSIBILITY_TYPE_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfResponsibilityTypeList(String[] columns){
		addSimpleOptions(RESPONSIBILITY_TYPE_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String TERMINATION_REASON_LIST = "terminationReasonList";
	public String getTerminationReasonList(){
		return TERMINATION_REASON_LIST;
	}



	public RetailStoreCountryCenterTokens withTerminationReasonListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("人力资源",viewGroups)){
			addSimpleOptions(TERMINATION_REASON_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withTerminationReasonList(){
		addSimpleOptions(TERMINATION_REASON_LIST);
		return this;
	}

	public TerminationReasonTokens withTerminationReasonListTokens(){
		//addSimpleOptions(TERMINATION_REASON_LIST);
		return TerminationReasonTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeTerminationReasonList(){
		addSimpleOptions(TERMINATION_REASON_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTerminationReasonListEnabled(){

		if(checkOptions(this.options(), TERMINATION_REASON_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromTerminationReasonList(String idsSeperatedWithComma){
		addSimpleOptions(TERMINATION_REASON_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int terminationReasonListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortTerminationReasonListWith(String field, String descOrAsc){
		addSortMoreOptions(TERMINATION_REASON_LIST,terminationReasonListSortCounter++, field, descOrAsc);
		return this;
	}
	private int terminationReasonListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchTerminationReasonListWith(String field, String verb, String value){

		withTerminationReasonList();
		addSearchMoreOptions(TERMINATION_REASON_LIST,terminationReasonListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfTerminationReasonList(String verb, String value){
		String field = "id|code|description";
		addSearchMoreOptions(TERMINATION_REASON_LIST,terminationReasonListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfTerminationReasonList(int rowsPerPage){
		addSimpleOptions(TERMINATION_REASON_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfTerminationReasonList(int currentPageNumber){
		addSimpleOptions(TERMINATION_REASON_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfTerminationReasonList(String[] columns){
		addSimpleOptions(TERMINATION_REASON_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfTerminationReasonList(String[] columns){
		addSimpleOptions(TERMINATION_REASON_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String TERMINATION_TYPE_LIST = "terminationTypeList";
	public String getTerminationTypeList(){
		return TERMINATION_TYPE_LIST;
	}



	public RetailStoreCountryCenterTokens withTerminationTypeListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("人力资源",viewGroups)){
			addSimpleOptions(TERMINATION_TYPE_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withTerminationTypeList(){
		addSimpleOptions(TERMINATION_TYPE_LIST);
		return this;
	}

	public TerminationTypeTokens withTerminationTypeListTokens(){
		//addSimpleOptions(TERMINATION_TYPE_LIST);
		return TerminationTypeTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeTerminationTypeList(){
		addSimpleOptions(TERMINATION_TYPE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTerminationTypeListEnabled(){

		if(checkOptions(this.options(), TERMINATION_TYPE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromTerminationTypeList(String idsSeperatedWithComma){
		addSimpleOptions(TERMINATION_TYPE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int terminationTypeListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortTerminationTypeListWith(String field, String descOrAsc){
		addSortMoreOptions(TERMINATION_TYPE_LIST,terminationTypeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int terminationTypeListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchTerminationTypeListWith(String field, String verb, String value){

		withTerminationTypeList();
		addSearchMoreOptions(TERMINATION_TYPE_LIST,terminationTypeListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfTerminationTypeList(String verb, String value){
		String field = "id|code|baseDescription|detailDescription";
		addSearchMoreOptions(TERMINATION_TYPE_LIST,terminationTypeListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfTerminationTypeList(int rowsPerPage){
		addSimpleOptions(TERMINATION_TYPE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfTerminationTypeList(int currentPageNumber){
		addSimpleOptions(TERMINATION_TYPE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfTerminationTypeList(String[] columns){
		addSimpleOptions(TERMINATION_TYPE_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfTerminationTypeList(String[] columns){
		addSimpleOptions(TERMINATION_TYPE_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String OCCUPATION_TYPE_LIST = "occupationTypeList";
	public String getOccupationTypeList(){
		return OCCUPATION_TYPE_LIST;
	}



	public RetailStoreCountryCenterTokens withOccupationTypeListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("人力资源",viewGroups)){
			addSimpleOptions(OCCUPATION_TYPE_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withOccupationTypeList(){
		addSimpleOptions(OCCUPATION_TYPE_LIST);
		return this;
	}

	public OccupationTypeTokens withOccupationTypeListTokens(){
		//addSimpleOptions(OCCUPATION_TYPE_LIST);
		return OccupationTypeTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeOccupationTypeList(){
		addSimpleOptions(OCCUPATION_TYPE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeOccupationTypeListEnabled(){

		if(checkOptions(this.options(), OCCUPATION_TYPE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromOccupationTypeList(String idsSeperatedWithComma){
		addSimpleOptions(OCCUPATION_TYPE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int occupationTypeListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortOccupationTypeListWith(String field, String descOrAsc){
		addSortMoreOptions(OCCUPATION_TYPE_LIST,occupationTypeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int occupationTypeListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchOccupationTypeListWith(String field, String verb, String value){

		withOccupationTypeList();
		addSearchMoreOptions(OCCUPATION_TYPE_LIST,occupationTypeListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfOccupationTypeList(String verb, String value){
		String field = "id|code|description|detailDescription";
		addSearchMoreOptions(OCCUPATION_TYPE_LIST,occupationTypeListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfOccupationTypeList(int rowsPerPage){
		addSimpleOptions(OCCUPATION_TYPE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfOccupationTypeList(int currentPageNumber){
		addSimpleOptions(OCCUPATION_TYPE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfOccupationTypeList(String[] columns){
		addSimpleOptions(OCCUPATION_TYPE_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfOccupationTypeList(String[] columns){
		addSimpleOptions(OCCUPATION_TYPE_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String LEAVE_TYPE_LIST = "leaveTypeList";
	public String getLeaveTypeList(){
		return LEAVE_TYPE_LIST;
	}



	public RetailStoreCountryCenterTokens withLeaveTypeListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("人力资源",viewGroups)){
			addSimpleOptions(LEAVE_TYPE_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withLeaveTypeList(){
		addSimpleOptions(LEAVE_TYPE_LIST);
		return this;
	}

	public LeaveTypeTokens withLeaveTypeListTokens(){
		//addSimpleOptions(LEAVE_TYPE_LIST);
		return LeaveTypeTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeLeaveTypeList(){
		addSimpleOptions(LEAVE_TYPE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeLeaveTypeListEnabled(){

		if(checkOptions(this.options(), LEAVE_TYPE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromLeaveTypeList(String idsSeperatedWithComma){
		addSimpleOptions(LEAVE_TYPE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int leaveTypeListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortLeaveTypeListWith(String field, String descOrAsc){
		addSortMoreOptions(LEAVE_TYPE_LIST,leaveTypeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int leaveTypeListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchLeaveTypeListWith(String field, String verb, String value){

		withLeaveTypeList();
		addSearchMoreOptions(LEAVE_TYPE_LIST,leaveTypeListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfLeaveTypeList(String verb, String value){
		String field = "id|code|description|detailDescription";
		addSearchMoreOptions(LEAVE_TYPE_LIST,leaveTypeListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfLeaveTypeList(int rowsPerPage){
		addSimpleOptions(LEAVE_TYPE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfLeaveTypeList(int currentPageNumber){
		addSimpleOptions(LEAVE_TYPE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfLeaveTypeList(String[] columns){
		addSimpleOptions(LEAVE_TYPE_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfLeaveTypeList(String[] columns){
		addSimpleOptions(LEAVE_TYPE_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String SALARY_GRADE_LIST = "salaryGradeList";
	public String getSalaryGradeList(){
		return SALARY_GRADE_LIST;
	}



	public RetailStoreCountryCenterTokens withSalaryGradeListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("人力资源",viewGroups)){
			addSimpleOptions(SALARY_GRADE_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withSalaryGradeList(){
		addSimpleOptions(SALARY_GRADE_LIST);
		return this;
	}

	public SalaryGradeTokens withSalaryGradeListTokens(){
		//addSimpleOptions(SALARY_GRADE_LIST);
		return SalaryGradeTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeSalaryGradeList(){
		addSimpleOptions(SALARY_GRADE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeSalaryGradeListEnabled(){

		if(checkOptions(this.options(), SALARY_GRADE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromSalaryGradeList(String idsSeperatedWithComma){
		addSimpleOptions(SALARY_GRADE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int salaryGradeListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortSalaryGradeListWith(String field, String descOrAsc){
		addSortMoreOptions(SALARY_GRADE_LIST,salaryGradeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int salaryGradeListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchSalaryGradeListWith(String field, String verb, String value){

		withSalaryGradeList();
		addSearchMoreOptions(SALARY_GRADE_LIST,salaryGradeListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfSalaryGradeList(String verb, String value){
		String field = "id|code|name|detailDescription";
		addSearchMoreOptions(SALARY_GRADE_LIST,salaryGradeListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfSalaryGradeList(int rowsPerPage){
		addSimpleOptions(SALARY_GRADE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfSalaryGradeList(int currentPageNumber){
		addSimpleOptions(SALARY_GRADE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfSalaryGradeList(String[] columns){
		addSimpleOptions(SALARY_GRADE_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfSalaryGradeList(String[] columns){
		addSimpleOptions(SALARY_GRADE_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String INTERVIEW_TYPE_LIST = "interviewTypeList";
	public String getInterviewTypeList(){
		return INTERVIEW_TYPE_LIST;
	}



	public RetailStoreCountryCenterTokens withInterviewTypeListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("人力资源",viewGroups)){
			addSimpleOptions(INTERVIEW_TYPE_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withInterviewTypeList(){
		addSimpleOptions(INTERVIEW_TYPE_LIST);
		return this;
	}

	public InterviewTypeTokens withInterviewTypeListTokens(){
		//addSimpleOptions(INTERVIEW_TYPE_LIST);
		return InterviewTypeTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeInterviewTypeList(){
		addSimpleOptions(INTERVIEW_TYPE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeInterviewTypeListEnabled(){

		if(checkOptions(this.options(), INTERVIEW_TYPE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromInterviewTypeList(String idsSeperatedWithComma){
		addSimpleOptions(INTERVIEW_TYPE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int interviewTypeListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortInterviewTypeListWith(String field, String descOrAsc){
		addSortMoreOptions(INTERVIEW_TYPE_LIST,interviewTypeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int interviewTypeListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchInterviewTypeListWith(String field, String verb, String value){

		withInterviewTypeList();
		addSearchMoreOptions(INTERVIEW_TYPE_LIST,interviewTypeListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfInterviewTypeList(String verb, String value){
		String field = "id|code|description|detailDescription";
		addSearchMoreOptions(INTERVIEW_TYPE_LIST,interviewTypeListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfInterviewTypeList(int rowsPerPage){
		addSimpleOptions(INTERVIEW_TYPE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfInterviewTypeList(int currentPageNumber){
		addSimpleOptions(INTERVIEW_TYPE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfInterviewTypeList(String[] columns){
		addSimpleOptions(INTERVIEW_TYPE_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfInterviewTypeList(String[] columns){
		addSimpleOptions(INTERVIEW_TYPE_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String TRAINING_COURSE_TYPE_LIST = "trainingCourseTypeList";
	public String getTrainingCourseTypeList(){
		return TRAINING_COURSE_TYPE_LIST;
	}



	public RetailStoreCountryCenterTokens withTrainingCourseTypeListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("人力资源",viewGroups)){
			addSimpleOptions(TRAINING_COURSE_TYPE_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withTrainingCourseTypeList(){
		addSimpleOptions(TRAINING_COURSE_TYPE_LIST);
		return this;
	}

	public TrainingCourseTypeTokens withTrainingCourseTypeListTokens(){
		//addSimpleOptions(TRAINING_COURSE_TYPE_LIST);
		return TrainingCourseTypeTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeTrainingCourseTypeList(){
		addSimpleOptions(TRAINING_COURSE_TYPE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTrainingCourseTypeListEnabled(){

		if(checkOptions(this.options(), TRAINING_COURSE_TYPE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromTrainingCourseTypeList(String idsSeperatedWithComma){
		addSimpleOptions(TRAINING_COURSE_TYPE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int trainingCourseTypeListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortTrainingCourseTypeListWith(String field, String descOrAsc){
		addSortMoreOptions(TRAINING_COURSE_TYPE_LIST,trainingCourseTypeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int trainingCourseTypeListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchTrainingCourseTypeListWith(String field, String verb, String value){

		withTrainingCourseTypeList();
		addSearchMoreOptions(TRAINING_COURSE_TYPE_LIST,trainingCourseTypeListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfTrainingCourseTypeList(String verb, String value){
		String field = "id|code|name|description";
		addSearchMoreOptions(TRAINING_COURSE_TYPE_LIST,trainingCourseTypeListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfTrainingCourseTypeList(int rowsPerPage){
		addSimpleOptions(TRAINING_COURSE_TYPE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfTrainingCourseTypeList(int currentPageNumber){
		addSimpleOptions(TRAINING_COURSE_TYPE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfTrainingCourseTypeList(String[] columns){
		addSimpleOptions(TRAINING_COURSE_TYPE_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfTrainingCourseTypeList(String[] columns){
		addSimpleOptions(TRAINING_COURSE_TYPE_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String PUBLIC_HOLIDAY_LIST = "publicHolidayList";
	public String getPublicHolidayList(){
		return PUBLIC_HOLIDAY_LIST;
	}



	public RetailStoreCountryCenterTokens withPublicHolidayListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("人力资源",viewGroups)){
			addSimpleOptions(PUBLIC_HOLIDAY_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withPublicHolidayList(){
		addSimpleOptions(PUBLIC_HOLIDAY_LIST);
		return this;
	}

	public PublicHolidayTokens withPublicHolidayListTokens(){
		//addSimpleOptions(PUBLIC_HOLIDAY_LIST);
		return PublicHolidayTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzePublicHolidayList(){
		addSimpleOptions(PUBLIC_HOLIDAY_LIST+".anaylze");
		return this;
	}
	public boolean analyzePublicHolidayListEnabled(){

		if(checkOptions(this.options(), PUBLIC_HOLIDAY_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromPublicHolidayList(String idsSeperatedWithComma){
		addSimpleOptions(PUBLIC_HOLIDAY_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int publicHolidayListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortPublicHolidayListWith(String field, String descOrAsc){
		addSortMoreOptions(PUBLIC_HOLIDAY_LIST,publicHolidayListSortCounter++, field, descOrAsc);
		return this;
	}
	private int publicHolidayListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchPublicHolidayListWith(String field, String verb, String value){

		withPublicHolidayList();
		addSearchMoreOptions(PUBLIC_HOLIDAY_LIST,publicHolidayListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfPublicHolidayList(String verb, String value){
		String field = "id|code|name|description";
		addSearchMoreOptions(PUBLIC_HOLIDAY_LIST,publicHolidayListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfPublicHolidayList(int rowsPerPage){
		addSimpleOptions(PUBLIC_HOLIDAY_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfPublicHolidayList(int currentPageNumber){
		addSimpleOptions(PUBLIC_HOLIDAY_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfPublicHolidayList(String[] columns){
		addSimpleOptions(PUBLIC_HOLIDAY_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfPublicHolidayList(String[] columns){
		addSimpleOptions(PUBLIC_HOLIDAY_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String EMPLOYEE_LIST = "employeeList";
	public String getEmployeeList(){
		return EMPLOYEE_LIST;
	}



	public RetailStoreCountryCenterTokens withEmployeeListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("人力资源",viewGroups)){
			addSimpleOptions(EMPLOYEE_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withEmployeeList(){
		addSimpleOptions(EMPLOYEE_LIST);
		return this;
	}

	public EmployeeTokens withEmployeeListTokens(){
		//addSimpleOptions(EMPLOYEE_LIST);
		return EmployeeTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeEmployeeList(){
		addSimpleOptions(EMPLOYEE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeEmployeeListEnabled(){

		if(checkOptions(this.options(), EMPLOYEE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromEmployeeList(String idsSeperatedWithComma){
		addSimpleOptions(EMPLOYEE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int employeeListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortEmployeeListWith(String field, String descOrAsc){
		addSortMoreOptions(EMPLOYEE_LIST,employeeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int employeeListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchEmployeeListWith(String field, String verb, String value){

		withEmployeeList();
		addSearchMoreOptions(EMPLOYEE_LIST,employeeListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfEmployeeList(String verb, String value){
		String field = "id|title|familyName|givenName|email|city|address|cellPhone|salaryAccount";
		addSearchMoreOptions(EMPLOYEE_LIST,employeeListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfEmployeeList(int rowsPerPage){
		addSimpleOptions(EMPLOYEE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfEmployeeList(int currentPageNumber){
		addSimpleOptions(EMPLOYEE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfEmployeeList(String[] columns){
		addSimpleOptions(EMPLOYEE_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfEmployeeList(String[] columns){
		addSimpleOptions(EMPLOYEE_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String INSTRUCTOR_LIST = "instructorList";
	public String getInstructorList(){
		return INSTRUCTOR_LIST;
	}



	public RetailStoreCountryCenterTokens withInstructorListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("人力资源",viewGroups)){
			addSimpleOptions(INSTRUCTOR_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withInstructorList(){
		addSimpleOptions(INSTRUCTOR_LIST);
		return this;
	}

	public InstructorTokens withInstructorListTokens(){
		//addSimpleOptions(INSTRUCTOR_LIST);
		return InstructorTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeInstructorList(){
		addSimpleOptions(INSTRUCTOR_LIST+".anaylze");
		return this;
	}
	public boolean analyzeInstructorListEnabled(){

		if(checkOptions(this.options(), INSTRUCTOR_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromInstructorList(String idsSeperatedWithComma){
		addSimpleOptions(INSTRUCTOR_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int instructorListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortInstructorListWith(String field, String descOrAsc){
		addSortMoreOptions(INSTRUCTOR_LIST,instructorListSortCounter++, field, descOrAsc);
		return this;
	}
	private int instructorListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchInstructorListWith(String field, String verb, String value){

		withInstructorList();
		addSearchMoreOptions(INSTRUCTOR_LIST,instructorListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfInstructorList(String verb, String value){
		String field = "id|title|familyName|givenName|cellPhone|email|introduction";
		addSearchMoreOptions(INSTRUCTOR_LIST,instructorListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfInstructorList(int rowsPerPage){
		addSimpleOptions(INSTRUCTOR_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfInstructorList(int currentPageNumber){
		addSimpleOptions(INSTRUCTOR_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfInstructorList(String[] columns){
		addSimpleOptions(INSTRUCTOR_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfInstructorList(String[] columns){
		addSimpleOptions(INSTRUCTOR_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String COMPANY_TRAINING_LIST = "companyTrainingList";
	public String getCompanyTrainingList(){
		return COMPANY_TRAINING_LIST;
	}



	public RetailStoreCountryCenterTokens withCompanyTrainingListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("人力资源",viewGroups)){
			addSimpleOptions(COMPANY_TRAINING_LIST);
		}
		return this;
	}


	public RetailStoreCountryCenterTokens withCompanyTrainingList(){
		addSimpleOptions(COMPANY_TRAINING_LIST);
		return this;
	}

	public CompanyTrainingTokens withCompanyTrainingListTokens(){
		//addSimpleOptions(COMPANY_TRAINING_LIST);
		return CompanyTrainingTokens.start();
	}

	public RetailStoreCountryCenterTokens analyzeCompanyTrainingList(){
		addSimpleOptions(COMPANY_TRAINING_LIST+".anaylze");
		return this;
	}
	public boolean analyzeCompanyTrainingListEnabled(){

		if(checkOptions(this.options(), COMPANY_TRAINING_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public RetailStoreCountryCenterTokens extractMoreFromCompanyTrainingList(String idsSeperatedWithComma){
		addSimpleOptions(COMPANY_TRAINING_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int companyTrainingListSortCounter = 0;
	public RetailStoreCountryCenterTokens sortCompanyTrainingListWith(String field, String descOrAsc){
		addSortMoreOptions(COMPANY_TRAINING_LIST,companyTrainingListSortCounter++, field, descOrAsc);
		return this;
	}
	private int companyTrainingListSearchCounter = 0;
	public RetailStoreCountryCenterTokens searchCompanyTrainingListWith(String field, String verb, String value){

		withCompanyTrainingList();
		addSearchMoreOptions(COMPANY_TRAINING_LIST,companyTrainingListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens searchAllTextOfCompanyTrainingList(String verb, String value){
		String field = "id|title";
		addSearchMoreOptions(COMPANY_TRAINING_LIST,companyTrainingListSearchCounter++, field, verb, value);
		return this;
	}



	public RetailStoreCountryCenterTokens rowsPerPageOfCompanyTrainingList(int rowsPerPage){
		addSimpleOptions(COMPANY_TRAINING_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public RetailStoreCountryCenterTokens currentPageNumberOfCompanyTrainingList(int currentPageNumber){
		addSimpleOptions(COMPANY_TRAINING_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public RetailStoreCountryCenterTokens retainColumnsOfCompanyTrainingList(String[] columns){
		addSimpleOptions(COMPANY_TRAINING_LIST+"RetainColumns",columns);
		return this;
	}
	public RetailStoreCountryCenterTokens excludeColumnsOfCompanyTrainingList(String[] columns){
		addSimpleOptions(COMPANY_TRAINING_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  RetailStoreCountryCenterTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfCatalogList(verb, value);
		searchAllTextOfRetailStoreProvinceCenterList(verb, value);
		searchAllTextOfRetailStoreList(verb, value);
		searchAllTextOfRetailStoreMemberList(verb, value);
		searchAllTextOfGoodsSupplierList(verb, value);
		searchAllTextOfSupplyOrderList(verb, value);
		searchAllTextOfRetailStoreOrderList(verb, value);
		searchAllTextOfWarehouseList(verb, value);
		searchAllTextOfTransportFleetList(verb, value);
		searchAllTextOfAccountSetList(verb, value);
		searchAllTextOfLevelOneDepartmentList(verb, value);
		searchAllTextOfSkillTypeList(verb, value);
		searchAllTextOfResponsibilityTypeList(verb, value);
		searchAllTextOfTerminationReasonList(verb, value);
		searchAllTextOfTerminationTypeList(verb, value);
		searchAllTextOfOccupationTypeList(verb, value);
		searchAllTextOfLeaveTypeList(verb, value);
		searchAllTextOfSalaryGradeList(verb, value);
		searchAllTextOfInterviewTypeList(verb, value);
		searchAllTextOfTrainingCourseTypeList(verb, value);
		searchAllTextOfPublicHolidayList(verb, value);
		searchAllTextOfEmployeeList(verb, value);
		searchAllTextOfInstructorList(verb, value);
		searchAllTextOfCompanyTrainingList(verb, value);
		return this;
	}
}

