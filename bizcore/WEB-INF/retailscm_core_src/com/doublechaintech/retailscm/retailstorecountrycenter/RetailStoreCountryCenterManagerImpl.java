
package com.doublechaintech.retailscm.retailstorecountrycenter;

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


import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.leavetype.LeaveType;
import com.doublechaintech.retailscm.catalog.Catalog;
import com.doublechaintech.retailscm.publicholiday.PublicHoliday;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.skilltype.SkillType;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;
import com.doublechaintech.retailscm.interviewtype.InterviewType;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.accountset.AccountSet;


import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;






public class RetailStoreCountryCenterManagerImpl extends CustomRetailscmCheckerManager implements RetailStoreCountryCenterManager, BusinessHandler{

	// Only some of ods have such function
	
	// To test 
	public BlobObject exportExcelFromList(RetailscmUserContext userContext, String id, String listName) throws Exception {
		
		Map<String,Object> tokens = RetailStoreCountryCenterTokens.start().withTokenFromListName(listName).done();
		RetailStoreCountryCenter  retailStoreCountryCenter = (RetailStoreCountryCenter) this.loadRetailStoreCountryCenter(userContext, id, tokens);
		//to enrich reference object to let it show display name
		List<BaseEntity> entityListToNaming = retailStoreCountryCenter.collectRefercencesFromLists();
		retailStoreCountryCenterDaoOf(userContext).alias(entityListToNaming);
		
		return exportListToExcel(userContext, retailStoreCountryCenter, listName);
		
	}
	@Override
	public BaseGridViewGenerator gridViewGenerator() {
		return new RetailStoreCountryCenterGridViewGenerator();
	}
	
	



  


	private static final String SERVICE_TYPE = "RetailStoreCountryCenter";
	@Override
	public RetailStoreCountryCenterDAO daoOf(RetailscmUserContext userContext) {
		return retailStoreCountryCenterDaoOf(userContext);
	}

	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}


	protected void throwExceptionWithMessage(String value) throws RetailStoreCountryCenterManagerException{

		Message message = new Message();
		message.setBody(value);
		throw new RetailStoreCountryCenterManagerException(message);

	}



 	protected RetailStoreCountryCenter saveRetailStoreCountryCenter(RetailscmUserContext userContext, RetailStoreCountryCenter retailStoreCountryCenter, String [] tokensExpr) throws Exception{	
 		//return getRetailStoreCountryCenterDAO().save(retailStoreCountryCenter, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens);
 	}
 	
 	protected RetailStoreCountryCenter saveRetailStoreCountryCenterDetail(RetailscmUserContext userContext, RetailStoreCountryCenter retailStoreCountryCenter) throws Exception{	

 		
 		return saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, allTokens());
 	}
 	
 	public RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String retailStoreCountryCenterId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreCountryCenterManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter( userContext, retailStoreCountryCenterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreCountryCenter, tokens);
 	}
 	
 	
 	 public RetailStoreCountryCenter searchRetailStoreCountryCenter(RetailscmUserContext userContext, String retailStoreCountryCenterId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreCountryCenterManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter( userContext, retailStoreCountryCenterId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,retailStoreCountryCenter, tokens);
 	}
 	
 	

 	protected RetailStoreCountryCenter present(RetailscmUserContext userContext, RetailStoreCountryCenter retailStoreCountryCenter, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,retailStoreCountryCenter,tokens);
		
		
		RetailStoreCountryCenter  retailStoreCountryCenterToPresent = retailStoreCountryCenterDaoOf(userContext).present(retailStoreCountryCenter, tokens);
		
		List<BaseEntity> entityListToNaming = retailStoreCountryCenterToPresent.collectRefercencesFromLists();
		retailStoreCountryCenterDaoOf(userContext).alias(entityListToNaming);
		
		return  retailStoreCountryCenterToPresent;
		
		
	}
 
 	
 	
 	public RetailStoreCountryCenter loadRetailStoreCountryCenterDetail(RetailscmUserContext userContext, String retailStoreCountryCenterId) throws Exception{	
 		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter( userContext, retailStoreCountryCenterId, allTokens());
 		return present(userContext,retailStoreCountryCenter, allTokens());
		
 	}
 	
 	public Object view(RetailscmUserContext userContext, String retailStoreCountryCenterId) throws Exception{	
 		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter( userContext, retailStoreCountryCenterId, viewTokens());
 		return present(userContext,retailStoreCountryCenter, allTokens());
		
 	}
 	protected RetailStoreCountryCenter saveRetailStoreCountryCenter(RetailscmUserContext userContext, RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object>tokens) throws Exception{	
 		return retailStoreCountryCenterDaoOf(userContext).save(retailStoreCountryCenter, tokens);
 	}
 	protected RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String retailStoreCountryCenterId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).throwExceptionIfHasErrors( RetailStoreCountryCenterManagerException.class);

 
 		return retailStoreCountryCenterDaoOf(userContext).load(retailStoreCountryCenterId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreCountryCenter retailStoreCountryCenter, Map<String, Object> tokens){
		super.addActions(userContext, retailStoreCountryCenter, tokens);
		
		addAction(userContext, retailStoreCountryCenter, tokens,"@create","createRetailStoreCountryCenter","createRetailStoreCountryCenter/","main","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"@update","updateRetailStoreCountryCenter","updateRetailStoreCountryCenter/"+retailStoreCountryCenter.getId()+"/","main","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"@copy","cloneRetailStoreCountryCenter","cloneRetailStoreCountryCenter/"+retailStoreCountryCenter.getId()+"/","main","primary");
		
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addCatalog","addCatalog","addCatalog/"+retailStoreCountryCenter.getId()+"/","catalogList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeCatalog","removeCatalog","removeCatalog/"+retailStoreCountryCenter.getId()+"/","catalogList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateCatalog","updateCatalog","updateCatalog/"+retailStoreCountryCenter.getId()+"/","catalogList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyCatalogFrom","copyCatalogFrom","copyCatalogFrom/"+retailStoreCountryCenter.getId()+"/","catalogList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addRetailStoreProvinceCenter","addRetailStoreProvinceCenter","addRetailStoreProvinceCenter/"+retailStoreCountryCenter.getId()+"/","retailStoreProvinceCenterList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeRetailStoreProvinceCenter","removeRetailStoreProvinceCenter","removeRetailStoreProvinceCenter/"+retailStoreCountryCenter.getId()+"/","retailStoreProvinceCenterList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateRetailStoreProvinceCenter","updateRetailStoreProvinceCenter","updateRetailStoreProvinceCenter/"+retailStoreCountryCenter.getId()+"/","retailStoreProvinceCenterList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyRetailStoreProvinceCenterFrom","copyRetailStoreProvinceCenterFrom","copyRetailStoreProvinceCenterFrom/"+retailStoreCountryCenter.getId()+"/","retailStoreProvinceCenterList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addRetailStore","addRetailStore","addRetailStore/"+retailStoreCountryCenter.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeRetailStore","removeRetailStore","removeRetailStore/"+retailStoreCountryCenter.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateRetailStore","updateRetailStore","updateRetailStore/"+retailStoreCountryCenter.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyRetailStoreFrom","copyRetailStoreFrom","copyRetailStoreFrom/"+retailStoreCountryCenter.getId()+"/","retailStoreList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addRetailStoreMember","addRetailStoreMember","addRetailStoreMember/"+retailStoreCountryCenter.getId()+"/","retailStoreMemberList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeRetailStoreMember","removeRetailStoreMember","removeRetailStoreMember/"+retailStoreCountryCenter.getId()+"/","retailStoreMemberList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateRetailStoreMember","updateRetailStoreMember","updateRetailStoreMember/"+retailStoreCountryCenter.getId()+"/","retailStoreMemberList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyRetailStoreMemberFrom","copyRetailStoreMemberFrom","copyRetailStoreMemberFrom/"+retailStoreCountryCenter.getId()+"/","retailStoreMemberList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addGoodsSupplier","addGoodsSupplier","addGoodsSupplier/"+retailStoreCountryCenter.getId()+"/","goodsSupplierList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeGoodsSupplier","removeGoodsSupplier","removeGoodsSupplier/"+retailStoreCountryCenter.getId()+"/","goodsSupplierList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateGoodsSupplier","updateGoodsSupplier","updateGoodsSupplier/"+retailStoreCountryCenter.getId()+"/","goodsSupplierList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyGoodsSupplierFrom","copyGoodsSupplierFrom","copyGoodsSupplierFrom/"+retailStoreCountryCenter.getId()+"/","goodsSupplierList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addSupplyOrder","addSupplyOrder","addSupplyOrder/"+retailStoreCountryCenter.getId()+"/","supplyOrderList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeSupplyOrder","removeSupplyOrder","removeSupplyOrder/"+retailStoreCountryCenter.getId()+"/","supplyOrderList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateSupplyOrder","updateSupplyOrder","updateSupplyOrder/"+retailStoreCountryCenter.getId()+"/","supplyOrderList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copySupplyOrderFrom","copySupplyOrderFrom","copySupplyOrderFrom/"+retailStoreCountryCenter.getId()+"/","supplyOrderList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addRetailStoreOrder","addRetailStoreOrder","addRetailStoreOrder/"+retailStoreCountryCenter.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeRetailStoreOrder","removeRetailStoreOrder","removeRetailStoreOrder/"+retailStoreCountryCenter.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateRetailStoreOrder","updateRetailStoreOrder","updateRetailStoreOrder/"+retailStoreCountryCenter.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyRetailStoreOrderFrom","copyRetailStoreOrderFrom","copyRetailStoreOrderFrom/"+retailStoreCountryCenter.getId()+"/","retailStoreOrderList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addWarehouse","addWarehouse","addWarehouse/"+retailStoreCountryCenter.getId()+"/","warehouseList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeWarehouse","removeWarehouse","removeWarehouse/"+retailStoreCountryCenter.getId()+"/","warehouseList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateWarehouse","updateWarehouse","updateWarehouse/"+retailStoreCountryCenter.getId()+"/","warehouseList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyWarehouseFrom","copyWarehouseFrom","copyWarehouseFrom/"+retailStoreCountryCenter.getId()+"/","warehouseList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addTransportFleet","addTransportFleet","addTransportFleet/"+retailStoreCountryCenter.getId()+"/","transportFleetList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeTransportFleet","removeTransportFleet","removeTransportFleet/"+retailStoreCountryCenter.getId()+"/","transportFleetList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateTransportFleet","updateTransportFleet","updateTransportFleet/"+retailStoreCountryCenter.getId()+"/","transportFleetList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyTransportFleetFrom","copyTransportFleetFrom","copyTransportFleetFrom/"+retailStoreCountryCenter.getId()+"/","transportFleetList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addAccountSet","addAccountSet","addAccountSet/"+retailStoreCountryCenter.getId()+"/","accountSetList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeAccountSet","removeAccountSet","removeAccountSet/"+retailStoreCountryCenter.getId()+"/","accountSetList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateAccountSet","updateAccountSet","updateAccountSet/"+retailStoreCountryCenter.getId()+"/","accountSetList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyAccountSetFrom","copyAccountSetFrom","copyAccountSetFrom/"+retailStoreCountryCenter.getId()+"/","accountSetList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addLevelOneDepartment","addLevelOneDepartment","addLevelOneDepartment/"+retailStoreCountryCenter.getId()+"/","levelOneDepartmentList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeLevelOneDepartment","removeLevelOneDepartment","removeLevelOneDepartment/"+retailStoreCountryCenter.getId()+"/","levelOneDepartmentList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateLevelOneDepartment","updateLevelOneDepartment","updateLevelOneDepartment/"+retailStoreCountryCenter.getId()+"/","levelOneDepartmentList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyLevelOneDepartmentFrom","copyLevelOneDepartmentFrom","copyLevelOneDepartmentFrom/"+retailStoreCountryCenter.getId()+"/","levelOneDepartmentList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addSkillType","addSkillType","addSkillType/"+retailStoreCountryCenter.getId()+"/","skillTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeSkillType","removeSkillType","removeSkillType/"+retailStoreCountryCenter.getId()+"/","skillTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateSkillType","updateSkillType","updateSkillType/"+retailStoreCountryCenter.getId()+"/","skillTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copySkillTypeFrom","copySkillTypeFrom","copySkillTypeFrom/"+retailStoreCountryCenter.getId()+"/","skillTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addResponsibilityType","addResponsibilityType","addResponsibilityType/"+retailStoreCountryCenter.getId()+"/","responsibilityTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeResponsibilityType","removeResponsibilityType","removeResponsibilityType/"+retailStoreCountryCenter.getId()+"/","responsibilityTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateResponsibilityType","updateResponsibilityType","updateResponsibilityType/"+retailStoreCountryCenter.getId()+"/","responsibilityTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyResponsibilityTypeFrom","copyResponsibilityTypeFrom","copyResponsibilityTypeFrom/"+retailStoreCountryCenter.getId()+"/","responsibilityTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addTerminationReason","addTerminationReason","addTerminationReason/"+retailStoreCountryCenter.getId()+"/","terminationReasonList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeTerminationReason","removeTerminationReason","removeTerminationReason/"+retailStoreCountryCenter.getId()+"/","terminationReasonList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateTerminationReason","updateTerminationReason","updateTerminationReason/"+retailStoreCountryCenter.getId()+"/","terminationReasonList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyTerminationReasonFrom","copyTerminationReasonFrom","copyTerminationReasonFrom/"+retailStoreCountryCenter.getId()+"/","terminationReasonList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addTerminationType","addTerminationType","addTerminationType/"+retailStoreCountryCenter.getId()+"/","terminationTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeTerminationType","removeTerminationType","removeTerminationType/"+retailStoreCountryCenter.getId()+"/","terminationTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateTerminationType","updateTerminationType","updateTerminationType/"+retailStoreCountryCenter.getId()+"/","terminationTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyTerminationTypeFrom","copyTerminationTypeFrom","copyTerminationTypeFrom/"+retailStoreCountryCenter.getId()+"/","terminationTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addOccupationType","addOccupationType","addOccupationType/"+retailStoreCountryCenter.getId()+"/","occupationTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeOccupationType","removeOccupationType","removeOccupationType/"+retailStoreCountryCenter.getId()+"/","occupationTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateOccupationType","updateOccupationType","updateOccupationType/"+retailStoreCountryCenter.getId()+"/","occupationTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyOccupationTypeFrom","copyOccupationTypeFrom","copyOccupationTypeFrom/"+retailStoreCountryCenter.getId()+"/","occupationTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addLeaveType","addLeaveType","addLeaveType/"+retailStoreCountryCenter.getId()+"/","leaveTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeLeaveType","removeLeaveType","removeLeaveType/"+retailStoreCountryCenter.getId()+"/","leaveTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateLeaveType","updateLeaveType","updateLeaveType/"+retailStoreCountryCenter.getId()+"/","leaveTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyLeaveTypeFrom","copyLeaveTypeFrom","copyLeaveTypeFrom/"+retailStoreCountryCenter.getId()+"/","leaveTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addSalaryGrade","addSalaryGrade","addSalaryGrade/"+retailStoreCountryCenter.getId()+"/","salaryGradeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeSalaryGrade","removeSalaryGrade","removeSalaryGrade/"+retailStoreCountryCenter.getId()+"/","salaryGradeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateSalaryGrade","updateSalaryGrade","updateSalaryGrade/"+retailStoreCountryCenter.getId()+"/","salaryGradeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copySalaryGradeFrom","copySalaryGradeFrom","copySalaryGradeFrom/"+retailStoreCountryCenter.getId()+"/","salaryGradeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addInterviewType","addInterviewType","addInterviewType/"+retailStoreCountryCenter.getId()+"/","interviewTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeInterviewType","removeInterviewType","removeInterviewType/"+retailStoreCountryCenter.getId()+"/","interviewTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateInterviewType","updateInterviewType","updateInterviewType/"+retailStoreCountryCenter.getId()+"/","interviewTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyInterviewTypeFrom","copyInterviewTypeFrom","copyInterviewTypeFrom/"+retailStoreCountryCenter.getId()+"/","interviewTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addTrainingCourseType","addTrainingCourseType","addTrainingCourseType/"+retailStoreCountryCenter.getId()+"/","trainingCourseTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeTrainingCourseType","removeTrainingCourseType","removeTrainingCourseType/"+retailStoreCountryCenter.getId()+"/","trainingCourseTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateTrainingCourseType","updateTrainingCourseType","updateTrainingCourseType/"+retailStoreCountryCenter.getId()+"/","trainingCourseTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyTrainingCourseTypeFrom","copyTrainingCourseTypeFrom","copyTrainingCourseTypeFrom/"+retailStoreCountryCenter.getId()+"/","trainingCourseTypeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addPublicHoliday","addPublicHoliday","addPublicHoliday/"+retailStoreCountryCenter.getId()+"/","publicHolidayList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removePublicHoliday","removePublicHoliday","removePublicHoliday/"+retailStoreCountryCenter.getId()+"/","publicHolidayList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updatePublicHoliday","updatePublicHoliday","updatePublicHoliday/"+retailStoreCountryCenter.getId()+"/","publicHolidayList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyPublicHolidayFrom","copyPublicHolidayFrom","copyPublicHolidayFrom/"+retailStoreCountryCenter.getId()+"/","publicHolidayList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addEmployee","addEmployee","addEmployee/"+retailStoreCountryCenter.getId()+"/","employeeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeEmployee","removeEmployee","removeEmployee/"+retailStoreCountryCenter.getId()+"/","employeeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateEmployee","updateEmployee","updateEmployee/"+retailStoreCountryCenter.getId()+"/","employeeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyEmployeeFrom","copyEmployeeFrom","copyEmployeeFrom/"+retailStoreCountryCenter.getId()+"/","employeeList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addInstructor","addInstructor","addInstructor/"+retailStoreCountryCenter.getId()+"/","instructorList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeInstructor","removeInstructor","removeInstructor/"+retailStoreCountryCenter.getId()+"/","instructorList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateInstructor","updateInstructor","updateInstructor/"+retailStoreCountryCenter.getId()+"/","instructorList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyInstructorFrom","copyInstructorFrom","copyInstructorFrom/"+retailStoreCountryCenter.getId()+"/","instructorList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.addCompanyTraining","addCompanyTraining","addCompanyTraining/"+retailStoreCountryCenter.getId()+"/","companyTrainingList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.removeCompanyTraining","removeCompanyTraining","removeCompanyTraining/"+retailStoreCountryCenter.getId()+"/","companyTrainingList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.updateCompanyTraining","updateCompanyTraining","updateCompanyTraining/"+retailStoreCountryCenter.getId()+"/","companyTrainingList","primary");
		addAction(userContext, retailStoreCountryCenter, tokens,"retail_store_country_center.copyCompanyTrainingFrom","copyCompanyTrainingFrom","copyCompanyTrainingFrom/"+retailStoreCountryCenter.getId()+"/","companyTrainingList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext userContext, RetailStoreCountryCenter retailStoreCountryCenter, Map<String, Object> tokens){
	
 	
 	
 
 	
 	

	public RetailStoreCountryCenter createRetailStoreCountryCenter(RetailscmUserContext userContext, String name,String serviceNumber,Date founded,String webSite,String address,String operatedBy,String legalRepresentative,String description) throws Exception
	//public RetailStoreCountryCenter createRetailStoreCountryCenter(RetailscmUserContext userContext,String name, String serviceNumber, Date founded, String webSite, String address, String operatedBy, String legalRepresentative, String description) throws Exception
	{

		

		

		checkerOf(userContext).checkNameOfRetailStoreCountryCenter(name);
		checkerOf(userContext).checkServiceNumberOfRetailStoreCountryCenter(serviceNumber);
		checkerOf(userContext).checkFoundedOfRetailStoreCountryCenter(founded);
		checkerOf(userContext).checkWebSiteOfRetailStoreCountryCenter(webSite);
		checkerOf(userContext).checkAddressOfRetailStoreCountryCenter(address);
		checkerOf(userContext).checkOperatedByOfRetailStoreCountryCenter(operatedBy);
		checkerOf(userContext).checkLegalRepresentativeOfRetailStoreCountryCenter(legalRepresentative);
		checkerOf(userContext).checkDescriptionOfRetailStoreCountryCenter(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


		RetailStoreCountryCenter retailStoreCountryCenter=createNewRetailStoreCountryCenter();	

		retailStoreCountryCenter.setName(name);
		retailStoreCountryCenter.setServiceNumber(serviceNumber);
		retailStoreCountryCenter.setFounded(founded);
		retailStoreCountryCenter.setWebSite(webSite);
		retailStoreCountryCenter.setAddress(address);
		retailStoreCountryCenter.setOperatedBy(operatedBy);
		retailStoreCountryCenter.setLegalRepresentative(legalRepresentative);
		retailStoreCountryCenter.setDescription(description);

		retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, emptyOptions());
		
		onNewInstanceCreated(userContext, retailStoreCountryCenter);
		return retailStoreCountryCenter;


	}
	protected RetailStoreCountryCenter createNewRetailStoreCountryCenter()
	{

		return new RetailStoreCountryCenter();
	}

	protected void checkParamsForUpdatingRetailStoreCountryCenter(RetailscmUserContext userContext,String retailStoreCountryCenterId, int retailStoreCountryCenterVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkVersionOfRetailStoreCountryCenter( retailStoreCountryCenterVersion);
		

		if(RetailStoreCountryCenter.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfRetailStoreCountryCenter(parseString(newValueExpr));
		
			
		}
		if(RetailStoreCountryCenter.SERVICE_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkServiceNumberOfRetailStoreCountryCenter(parseString(newValueExpr));
		
			
		}
		if(RetailStoreCountryCenter.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfRetailStoreCountryCenter(parseDate(newValueExpr));
		
			
		}
		if(RetailStoreCountryCenter.WEB_SITE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkWebSiteOfRetailStoreCountryCenter(parseString(newValueExpr));
		
			
		}
		if(RetailStoreCountryCenter.ADDRESS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAddressOfRetailStoreCountryCenter(parseString(newValueExpr));
		
			
		}
		if(RetailStoreCountryCenter.OPERATED_BY_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkOperatedByOfRetailStoreCountryCenter(parseString(newValueExpr));
		
			
		}
		if(RetailStoreCountryCenter.LEGAL_REPRESENTATIVE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLegalRepresentativeOfRetailStoreCountryCenter(parseString(newValueExpr));
		
			
		}
		if(RetailStoreCountryCenter.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfRetailStoreCountryCenter(parseString(newValueExpr));
		
			
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}



	public RetailStoreCountryCenter clone(RetailscmUserContext userContext, String fromRetailStoreCountryCenterId) throws Exception{

		return retailStoreCountryCenterDaoOf(userContext).clone(fromRetailStoreCountryCenterId, this.allTokens());
	}

	public RetailStoreCountryCenter internalSaveRetailStoreCountryCenter(RetailscmUserContext userContext, RetailStoreCountryCenter retailStoreCountryCenter) throws Exception
	{
		return internalSaveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, allTokens());

	}
	public RetailStoreCountryCenter internalSaveRetailStoreCountryCenter(RetailscmUserContext userContext, RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options) throws Exception
	{
		//checkParamsForUpdatingRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, retailStoreCountryCenterVersion, property, newValueExpr, tokensExpr);


		synchronized(retailStoreCountryCenter){
			//will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreCountryCenter.
			if (retailStoreCountryCenter.isChanged()){
			
			}
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, options);
			return retailStoreCountryCenter;

		}

	}

	public RetailStoreCountryCenter updateRetailStoreCountryCenter(RetailscmUserContext userContext,String retailStoreCountryCenterId, int retailStoreCountryCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, retailStoreCountryCenterVersion, property, newValueExpr, tokensExpr);



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		if(retailStoreCountryCenter.getVersion() != retailStoreCountryCenterVersion){
			String message = "The target version("+retailStoreCountryCenter.getVersion()+") is not equals to version("+retailStoreCountryCenterVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreCountryCenter){
			//will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreCountryCenter.
			
			retailStoreCountryCenter.changeProperty(property, newValueExpr);
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			//return saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().done());
		}

	}

	public RetailStoreCountryCenter updateRetailStoreCountryCenterProperty(RetailscmUserContext userContext,String retailStoreCountryCenterId, int retailStoreCountryCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, retailStoreCountryCenterVersion, property, newValueExpr, tokensExpr);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		if(retailStoreCountryCenter.getVersion() != retailStoreCountryCenterVersion){
			String message = "The target version("+retailStoreCountryCenter.getVersion()+") is not equals to version("+retailStoreCountryCenterVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(retailStoreCountryCenter){
			//will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to RetailStoreCountryCenter.

			retailStoreCountryCenter.changeProperty(property, newValueExpr);
			
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			//return saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}

	protected RetailStoreCountryCenterTokens tokens(){
		return RetailStoreCountryCenterTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RetailStoreCountryCenterTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortCatalogListWith("id","desc")
		.sortRetailStoreProvinceCenterListWith("id","desc")
		.sortRetailStoreListWith("id","desc")
		.sortRetailStoreMemberListWith("id","desc")
		.sortGoodsSupplierListWith("id","desc")
		.sortSupplyOrderListWith("id","desc")
		.sortRetailStoreOrderListWith("id","desc")
		.sortWarehouseListWith("id","desc")
		.sortTransportFleetListWith("id","desc")
		.sortAccountSetListWith("id","desc")
		.sortLevelOneDepartmentListWith("id","desc")
		.sortSkillTypeListWith("id","desc")
		.sortResponsibilityTypeListWith("id","desc")
		.sortTerminationReasonListWith("id","desc")
		.sortTerminationTypeListWith("id","desc")
		.sortOccupationTypeListWith("id","desc")
		.sortLeaveTypeListWith("id","desc")
		.sortSalaryGradeListWith("id","desc")
		.sortInterviewTypeListWith("id","desc")
		.sortTrainingCourseTypeListWith("id","desc")
		.sortPublicHolidayListWith("id","desc")
		.sortEmployeeListWith("id","desc")
		.sortInstructorListWith("id","desc")
		.sortCompanyTrainingListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RetailStoreCountryCenterTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(RetailscmUserContext userContext, String retailStoreCountryCenterId, int retailStoreCountryCenterVersion) throws Exception {
		//deleteInternal(userContext, retailStoreCountryCenterId, retailStoreCountryCenterVersion);
	}
	protected void deleteInternal(RetailscmUserContext userContext,
			String retailStoreCountryCenterId, int retailStoreCountryCenterVersion) throws Exception{

		retailStoreCountryCenterDaoOf(userContext).delete(retailStoreCountryCenterId, retailStoreCountryCenterVersion);
	}

	public RetailStoreCountryCenter forgetByAll(RetailscmUserContext userContext, String retailStoreCountryCenterId, int retailStoreCountryCenterVersion) throws Exception {
		return forgetByAllInternal(userContext, retailStoreCountryCenterId, retailStoreCountryCenterVersion);
	}
	protected RetailStoreCountryCenter forgetByAllInternal(RetailscmUserContext userContext,
			String retailStoreCountryCenterId, int retailStoreCountryCenterVersion) throws Exception{

		return retailStoreCountryCenterDaoOf(userContext).disconnectFromAll(retailStoreCountryCenterId, retailStoreCountryCenterVersion);
	}




	public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RetailStoreCountryCenterManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}


	protected int deleteAllInternal(RetailscmUserContext userContext) throws Exception{
		return retailStoreCountryCenterDaoOf(userContext).deleteAll();
	}


	//disconnect RetailStoreCountryCenter with city_service_center in RetailStore
	protected RetailStoreCountryCenter breakWithRetailStoreByCityServiceCenter(RetailscmUserContext userContext, String retailStoreCountryCenterId, String cityServiceCenterId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());

			synchronized(retailStoreCountryCenter){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCountryCenterDaoOf(userContext).planToRemoveRetailStoreListWithCityServiceCenter(retailStoreCountryCenter, cityServiceCenterId, this.emptyOptions());

				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreList().done());
				return retailStoreCountryCenter;
			}
	}
	//disconnect RetailStoreCountryCenter with creation in RetailStore
	protected RetailStoreCountryCenter breakWithRetailStoreByCreation(RetailscmUserContext userContext, String retailStoreCountryCenterId, String creationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());

			synchronized(retailStoreCountryCenter){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCountryCenterDaoOf(userContext).planToRemoveRetailStoreListWithCreation(retailStoreCountryCenter, creationId, this.emptyOptions());

				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreList().done());
				return retailStoreCountryCenter;
			}
	}
	//disconnect RetailStoreCountryCenter with investment_invitation in RetailStore
	protected RetailStoreCountryCenter breakWithRetailStoreByInvestmentInvitation(RetailscmUserContext userContext, String retailStoreCountryCenterId, String investmentInvitationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());

			synchronized(retailStoreCountryCenter){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCountryCenterDaoOf(userContext).planToRemoveRetailStoreListWithInvestmentInvitation(retailStoreCountryCenter, investmentInvitationId, this.emptyOptions());

				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreList().done());
				return retailStoreCountryCenter;
			}
	}
	//disconnect RetailStoreCountryCenter with franchising in RetailStore
	protected RetailStoreCountryCenter breakWithRetailStoreByFranchising(RetailscmUserContext userContext, String retailStoreCountryCenterId, String franchisingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());

			synchronized(retailStoreCountryCenter){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCountryCenterDaoOf(userContext).planToRemoveRetailStoreListWithFranchising(retailStoreCountryCenter, franchisingId, this.emptyOptions());

				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreList().done());
				return retailStoreCountryCenter;
			}
	}
	//disconnect RetailStoreCountryCenter with decoration in RetailStore
	protected RetailStoreCountryCenter breakWithRetailStoreByDecoration(RetailscmUserContext userContext, String retailStoreCountryCenterId, String decorationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());

			synchronized(retailStoreCountryCenter){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCountryCenterDaoOf(userContext).planToRemoveRetailStoreListWithDecoration(retailStoreCountryCenter, decorationId, this.emptyOptions());

				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreList().done());
				return retailStoreCountryCenter;
			}
	}
	//disconnect RetailStoreCountryCenter with opening in RetailStore
	protected RetailStoreCountryCenter breakWithRetailStoreByOpening(RetailscmUserContext userContext, String retailStoreCountryCenterId, String openingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());

			synchronized(retailStoreCountryCenter){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCountryCenterDaoOf(userContext).planToRemoveRetailStoreListWithOpening(retailStoreCountryCenter, openingId, this.emptyOptions());

				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreList().done());
				return retailStoreCountryCenter;
			}
	}
	//disconnect RetailStoreCountryCenter with closing in RetailStore
	protected RetailStoreCountryCenter breakWithRetailStoreByClosing(RetailscmUserContext userContext, String retailStoreCountryCenterId, String closingId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());

			synchronized(retailStoreCountryCenter){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCountryCenterDaoOf(userContext).planToRemoveRetailStoreListWithClosing(retailStoreCountryCenter, closingId, this.emptyOptions());

				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreList().done());
				return retailStoreCountryCenter;
			}
	}
	//disconnect RetailStoreCountryCenter with seller in SupplyOrder
	protected RetailStoreCountryCenter breakWithSupplyOrderBySeller(RetailscmUserContext userContext, String retailStoreCountryCenterId, String sellerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());

			synchronized(retailStoreCountryCenter){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCountryCenterDaoOf(userContext).planToRemoveSupplyOrderListWithSeller(retailStoreCountryCenter, sellerId, this.emptyOptions());

				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSupplyOrderList().done());
				return retailStoreCountryCenter;
			}
	}
	//disconnect RetailStoreCountryCenter with buyer in RetailStoreOrder
	protected RetailStoreCountryCenter breakWithRetailStoreOrderByBuyer(RetailscmUserContext userContext, String retailStoreCountryCenterId, String buyerId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());

			synchronized(retailStoreCountryCenter){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCountryCenterDaoOf(userContext).planToRemoveRetailStoreOrderListWithBuyer(retailStoreCountryCenter, buyerId, this.emptyOptions());

				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreOrderList().done());
				return retailStoreCountryCenter;
			}
	}
	//disconnect RetailStoreCountryCenter with retail_store in AccountSet
	protected RetailStoreCountryCenter breakWithAccountSetByRetailStore(RetailscmUserContext userContext, String retailStoreCountryCenterId, String retailStoreId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());

			synchronized(retailStoreCountryCenter){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCountryCenterDaoOf(userContext).planToRemoveAccountSetListWithRetailStore(retailStoreCountryCenter, retailStoreId, this.emptyOptions());

				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withAccountSetList().done());
				return retailStoreCountryCenter;
			}
	}
	//disconnect RetailStoreCountryCenter with goods_supplier in AccountSet
	protected RetailStoreCountryCenter breakWithAccountSetByGoodsSupplier(RetailscmUserContext userContext, String retailStoreCountryCenterId, String goodsSupplierId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());

			synchronized(retailStoreCountryCenter){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCountryCenterDaoOf(userContext).planToRemoveAccountSetListWithGoodsSupplier(retailStoreCountryCenter, goodsSupplierId, this.emptyOptions());

				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withAccountSetList().done());
				return retailStoreCountryCenter;
			}
	}
	//disconnect RetailStoreCountryCenter with department in Employee
	protected RetailStoreCountryCenter breakWithEmployeeByDepartment(RetailscmUserContext userContext, String retailStoreCountryCenterId, String departmentId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());

			synchronized(retailStoreCountryCenter){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCountryCenterDaoOf(userContext).planToRemoveEmployeeListWithDepartment(retailStoreCountryCenter, departmentId, this.emptyOptions());

				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withEmployeeList().done());
				return retailStoreCountryCenter;
			}
	}
	//disconnect RetailStoreCountryCenter with occupation in Employee
	protected RetailStoreCountryCenter breakWithEmployeeByOccupation(RetailscmUserContext userContext, String retailStoreCountryCenterId, String occupationId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());

			synchronized(retailStoreCountryCenter){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCountryCenterDaoOf(userContext).planToRemoveEmployeeListWithOccupation(retailStoreCountryCenter, occupationId, this.emptyOptions());

				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withEmployeeList().done());
				return retailStoreCountryCenter;
			}
	}
	//disconnect RetailStoreCountryCenter with responsible_for in Employee
	protected RetailStoreCountryCenter breakWithEmployeeByResponsibleFor(RetailscmUserContext userContext, String retailStoreCountryCenterId, String responsibleForId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());

			synchronized(retailStoreCountryCenter){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCountryCenterDaoOf(userContext).planToRemoveEmployeeListWithResponsibleFor(retailStoreCountryCenter, responsibleForId, this.emptyOptions());

				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withEmployeeList().done());
				return retailStoreCountryCenter;
			}
	}
	//disconnect RetailStoreCountryCenter with current_salary_grade in Employee
	protected RetailStoreCountryCenter breakWithEmployeeByCurrentSalaryGrade(RetailscmUserContext userContext, String retailStoreCountryCenterId, String currentSalaryGradeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());

			synchronized(retailStoreCountryCenter){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCountryCenterDaoOf(userContext).planToRemoveEmployeeListWithCurrentSalaryGrade(retailStoreCountryCenter, currentSalaryGradeId, this.emptyOptions());

				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withEmployeeList().done());
				return retailStoreCountryCenter;
			}
	}
	//disconnect RetailStoreCountryCenter with instructor in CompanyTraining
	protected RetailStoreCountryCenter breakWithCompanyTrainingByInstructor(RetailscmUserContext userContext, String retailStoreCountryCenterId, String instructorId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());

			synchronized(retailStoreCountryCenter){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCountryCenterDaoOf(userContext).planToRemoveCompanyTrainingListWithInstructor(retailStoreCountryCenter, instructorId, this.emptyOptions());

				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withCompanyTrainingList().done());
				return retailStoreCountryCenter;
			}
	}
	//disconnect RetailStoreCountryCenter with training_course_type in CompanyTraining
	protected RetailStoreCountryCenter breakWithCompanyTrainingByTrainingCourseType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String trainingCourseTypeId,  String [] tokensExpr)
		 throws Exception{

			//TODO add check code here

			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());

			synchronized(retailStoreCountryCenter){
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation

				retailStoreCountryCenterDaoOf(userContext).planToRemoveCompanyTrainingListWithTrainingCourseType(retailStoreCountryCenter, trainingCourseTypeId, this.emptyOptions());

				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withCompanyTrainingList().done());
				return retailStoreCountryCenter;
			}
	}






	protected void checkParamsForAddingCatalog(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, int subCount, BigDecimal amount,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkNameOfCatalog(name);
		
		checkerOf(userContext).checkSubCountOfCatalog(subCount);
		
		checkerOf(userContext).checkAmountOfCatalog(amount);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addCatalog(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, int subCount, BigDecimal amount, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingCatalog(userContext,retailStoreCountryCenterId,name, subCount, amount,tokensExpr);

		Catalog catalog = createCatalog(userContext,name, subCount, amount);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addCatalog( catalog );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withCatalogList().done());
			
			userContext.getManagerGroup().getCatalogManager().onNewInstanceCreated(userContext, catalog);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingCatalogProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String name,int subCount,BigDecimal amount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfCatalog(id);

		checkerOf(userContext).checkNameOfCatalog( name);
		checkerOf(userContext).checkSubCountOfCatalog( subCount);
		checkerOf(userContext).checkAmountOfCatalog( amount);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateCatalogProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String name,int subCount,BigDecimal amount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCatalogProperties(userContext,retailStoreCountryCenterId,id,name,subCount,amount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withCatalogListList()
				.searchCatalogListWith(Catalog.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getCatalogList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("Catalog is NOT FOUND with id: '"+id+"'");
		}

		Catalog item = retailStoreCountryCenterToUpdate.getCatalogList().first();

		item.updateName( name );
		item.updateSubCount( subCount );
		item.updateAmount( amount );


		//checkParamsForAddingCatalog(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withCatalogList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected Catalog createCatalog(RetailscmUserContext userContext, String name, int subCount, BigDecimal amount) throws Exception{

		Catalog catalog = new Catalog();
		
		
		catalog.setName(name);		
		catalog.setSubCount(subCount);		
		catalog.setAmount(amount);
	
		
		return catalog;


	}

	protected Catalog createIndexedCatalog(String id, int version){

		Catalog catalog = new Catalog();
		catalog.setId(id);
		catalog.setVersion(version);
		return catalog;

	}

	protected void checkParamsForRemovingCatalogList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String catalogIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String catalogIdItem: catalogIds){
			checkerOf(userContext).checkIdOfCatalog(catalogIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeCatalogList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String catalogIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingCatalogList(userContext, retailStoreCountryCenterId,  catalogIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveCatalogList(retailStoreCountryCenter, catalogIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withCatalogList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getCatalogList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingCatalog(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfCatalog(catalogId);
		checkerOf(userContext).checkVersionOfCatalog(catalogVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeCatalog(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingCatalog(userContext,retailStoreCountryCenterId, catalogId, catalogVersion,tokensExpr);

		Catalog catalog = createIndexedCatalog(catalogId, catalogVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeCatalog( catalog );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withCatalogList().done());
			deleteRelationInGraph(userContext, catalog);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingCatalog(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfCatalog(catalogId);
		checkerOf(userContext).checkVersionOfCatalog(catalogVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyCatalogFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String catalogId, int catalogVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingCatalog(userContext,retailStoreCountryCenterId, catalogId, catalogVersion,tokensExpr);

		Catalog catalog = createIndexedCatalog(catalogId, catalogVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreCountryCenter.copyCatalogFrom( catalog );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withCatalogList().done());
			
			userContext.getManagerGroup().getCatalogManager().onNewInstanceCreated(userContext, (Catalog)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingCatalog(RetailscmUserContext userContext, String retailStoreCountryCenterId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfCatalog(catalogId);
		checkerOf(userContext).checkVersionOfCatalog(catalogVersion);
		

		if(Catalog.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfCatalog(parseString(newValueExpr));
		
		}
		
		if(Catalog.SUB_COUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSubCountOfCatalog(parseInt(newValueExpr));
		
		}
		
		if(Catalog.AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkAmountOfCatalog(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateCatalog(RetailscmUserContext userContext, String retailStoreCountryCenterId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingCatalog(userContext, retailStoreCountryCenterId, catalogId, catalogVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withCatalogList().searchCatalogListWith(Catalog.ID_PROPERTY, "eq", catalogId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeCatalog( catalog );
			//make changes to AcceleraterAccount.
			Catalog catalogIndex = createIndexedCatalog(catalogId, catalogVersion);

			Catalog catalog = retailStoreCountryCenter.findTheCatalog(catalogIndex);
			if(catalog == null){
				throw new RetailStoreCountryCenterManagerException(catalog+" is NOT FOUND" );
			}

			catalog.changeProperty(property, newValueExpr);
			
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withCatalogList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingRetailStoreProvinceCenter(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, Date founded,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkNameOfRetailStoreProvinceCenter(name);
		
		checkerOf(userContext).checkFoundedOfRetailStoreProvinceCenter(founded);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addRetailStoreProvinceCenter(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, Date founded, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStoreProvinceCenter(userContext,retailStoreCountryCenterId,name, founded,tokensExpr);

		RetailStoreProvinceCenter retailStoreProvinceCenter = createRetailStoreProvinceCenter(userContext,name, founded);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addRetailStoreProvinceCenter( retailStoreProvinceCenter );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreProvinceCenterList().done());
			
			userContext.getManagerGroup().getRetailStoreProvinceCenterManager().onNewInstanceCreated(userContext, retailStoreProvinceCenter);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreProvinceCenterProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String name,Date founded,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(id);

		checkerOf(userContext).checkNameOfRetailStoreProvinceCenter( name);
		checkerOf(userContext).checkFoundedOfRetailStoreProvinceCenter( founded);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateRetailStoreProvinceCenterProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String name,Date founded, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreProvinceCenterProperties(userContext,retailStoreCountryCenterId,id,name,founded,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreProvinceCenterListList()
				.searchRetailStoreProvinceCenterListWith(RetailStoreProvinceCenter.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getRetailStoreProvinceCenterList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("RetailStoreProvinceCenter is NOT FOUND with id: '"+id+"'");
		}

		RetailStoreProvinceCenter item = retailStoreCountryCenterToUpdate.getRetailStoreProvinceCenterList().first();

		item.updateName( name );
		item.updateFounded( founded );


		//checkParamsForAddingRetailStoreProvinceCenter(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withRetailStoreProvinceCenterList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected RetailStoreProvinceCenter createRetailStoreProvinceCenter(RetailscmUserContext userContext, String name, Date founded) throws Exception{

		RetailStoreProvinceCenter retailStoreProvinceCenter = new RetailStoreProvinceCenter();
		
		
		retailStoreProvinceCenter.setName(name);		
		retailStoreProvinceCenter.setFounded(founded);		
		retailStoreProvinceCenter.setLastUpdateTime(userContext.now());
	
		
		return retailStoreProvinceCenter;


	}

	protected RetailStoreProvinceCenter createIndexedRetailStoreProvinceCenter(String id, int version){

		RetailStoreProvinceCenter retailStoreProvinceCenter = new RetailStoreProvinceCenter();
		retailStoreProvinceCenter.setId(id);
		retailStoreProvinceCenter.setVersion(version);
		return retailStoreProvinceCenter;

	}

	protected void checkParamsForRemovingRetailStoreProvinceCenterList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String retailStoreProvinceCenterIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String retailStoreProvinceCenterIdItem: retailStoreProvinceCenterIds){
			checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeRetailStoreProvinceCenterList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String retailStoreProvinceCenterIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreProvinceCenterList(userContext, retailStoreCountryCenterId,  retailStoreProvinceCenterIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveRetailStoreProvinceCenterList(retailStoreCountryCenter, retailStoreProvinceCenterIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreProvinceCenterList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getRetailStoreProvinceCenterList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStoreProvinceCenter(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		checkerOf(userContext).checkVersionOfRetailStoreProvinceCenter(retailStoreProvinceCenterVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeRetailStoreProvinceCenter(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStoreProvinceCenter(userContext,retailStoreCountryCenterId, retailStoreProvinceCenterId, retailStoreProvinceCenterVersion,tokensExpr);

		RetailStoreProvinceCenter retailStoreProvinceCenter = createIndexedRetailStoreProvinceCenter(retailStoreProvinceCenterId, retailStoreProvinceCenterVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeRetailStoreProvinceCenter( retailStoreProvinceCenter );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreProvinceCenterList().done());
			deleteRelationInGraph(userContext, retailStoreProvinceCenter);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStoreProvinceCenter(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		checkerOf(userContext).checkVersionOfRetailStoreProvinceCenter(retailStoreProvinceCenterVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyRetailStoreProvinceCenterFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStoreProvinceCenter(userContext,retailStoreCountryCenterId, retailStoreProvinceCenterId, retailStoreProvinceCenterVersion,tokensExpr);

		RetailStoreProvinceCenter retailStoreProvinceCenter = createIndexedRetailStoreProvinceCenter(retailStoreProvinceCenterId, retailStoreProvinceCenterVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			retailStoreProvinceCenter.updateLastUpdateTime(userContext.now());

			retailStoreCountryCenter.copyRetailStoreProvinceCenterFrom( retailStoreProvinceCenter );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreProvinceCenterList().done());
			
			userContext.getManagerGroup().getRetailStoreProvinceCenterManager().onNewInstanceCreated(userContext, (RetailStoreProvinceCenter)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStoreProvinceCenter(RetailscmUserContext userContext, String retailStoreCountryCenterId, String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfRetailStoreProvinceCenter(retailStoreProvinceCenterId);
		checkerOf(userContext).checkVersionOfRetailStoreProvinceCenter(retailStoreProvinceCenterVersion);
		

		if(RetailStoreProvinceCenter.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfRetailStoreProvinceCenter(parseString(newValueExpr));
		
		}
		
		if(RetailStoreProvinceCenter.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfRetailStoreProvinceCenter(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateRetailStoreProvinceCenter(RetailscmUserContext userContext, String retailStoreCountryCenterId, String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStoreProvinceCenter(userContext, retailStoreCountryCenterId, retailStoreProvinceCenterId, retailStoreProvinceCenterVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreProvinceCenterList().searchRetailStoreProvinceCenterListWith(RetailStoreProvinceCenter.ID_PROPERTY, "eq", retailStoreProvinceCenterId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeRetailStoreProvinceCenter( retailStoreProvinceCenter );
			//make changes to AcceleraterAccount.
			RetailStoreProvinceCenter retailStoreProvinceCenterIndex = createIndexedRetailStoreProvinceCenter(retailStoreProvinceCenterId, retailStoreProvinceCenterVersion);

			RetailStoreProvinceCenter retailStoreProvinceCenter = retailStoreCountryCenter.findTheRetailStoreProvinceCenter(retailStoreProvinceCenterIndex);
			if(retailStoreProvinceCenter == null){
				throw new RetailStoreCountryCenterManagerException(retailStoreProvinceCenter+" is NOT FOUND" );
			}

			retailStoreProvinceCenter.changeProperty(property, newValueExpr);
			retailStoreProvinceCenter.updateLastUpdateTime(userContext.now());
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreProvinceCenterList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingRetailStore(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String telephone, String owner, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkNameOfRetailStore(name);
		
		checkerOf(userContext).checkTelephoneOfRetailStore(telephone);
		
		checkerOf(userContext).checkOwnerOfRetailStore(owner);
		
		checkerOf(userContext).checkCityServiceCenterIdOfRetailStore(cityServiceCenterId);
		
		checkerOf(userContext).checkCreationIdOfRetailStore(creationId);
		
		checkerOf(userContext).checkInvestmentInvitationIdOfRetailStore(investmentInvitationId);
		
		checkerOf(userContext).checkFranchisingIdOfRetailStore(franchisingId);
		
		checkerOf(userContext).checkDecorationIdOfRetailStore(decorationId);
		
		checkerOf(userContext).checkOpeningIdOfRetailStore(openingId);
		
		checkerOf(userContext).checkClosingIdOfRetailStore(closingId);
		
		checkerOf(userContext).checkFoundedOfRetailStore(founded);
		
		checkerOf(userContext).checkLatitudeOfRetailStore(latitude);
		
		checkerOf(userContext).checkLongitudeOfRetailStore(longitude);
		
		checkerOf(userContext).checkDescriptionOfRetailStore(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addRetailStore(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String telephone, String owner, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStore(userContext,retailStoreCountryCenterId,name, telephone, owner, cityServiceCenterId, creationId, investmentInvitationId, franchisingId, decorationId, openingId, closingId, founded, latitude, longitude, description,tokensExpr);

		RetailStore retailStore = createRetailStore(userContext,name, telephone, owner, cityServiceCenterId, creationId, investmentInvitationId, franchisingId, decorationId, openingId, closingId, founded, latitude, longitude, description);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addRetailStore( retailStore );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreList().done());
			
			userContext.getManagerGroup().getRetailStoreManager().onNewInstanceCreated(userContext, retailStore);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfRetailStore(id);

		checkerOf(userContext).checkNameOfRetailStore( name);
		checkerOf(userContext).checkTelephoneOfRetailStore( telephone);
		checkerOf(userContext).checkOwnerOfRetailStore( owner);
		checkerOf(userContext).checkFoundedOfRetailStore( founded);
		checkerOf(userContext).checkLatitudeOfRetailStore( latitude);
		checkerOf(userContext).checkLongitudeOfRetailStore( longitude);
		checkerOf(userContext).checkDescriptionOfRetailStore( description);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateRetailStoreProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String name,String telephone,String owner,Date founded,BigDecimal latitude,BigDecimal longitude,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreProperties(userContext,retailStoreCountryCenterId,id,name,telephone,owner,founded,latitude,longitude,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreListList()
				.searchRetailStoreListWith(RetailStore.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getRetailStoreList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("RetailStore is NOT FOUND with id: '"+id+"'");
		}

		RetailStore item = retailStoreCountryCenterToUpdate.getRetailStoreList().first();

		item.updateName( name );
		item.updateTelephone( telephone );
		item.updateOwner( owner );
		item.updateFounded( founded );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );
		item.updateDescription( description );


		//checkParamsForAddingRetailStore(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withRetailStoreList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected RetailStore createRetailStore(RetailscmUserContext userContext, String name, String telephone, String owner, String cityServiceCenterId, String creationId, String investmentInvitationId, String franchisingId, String decorationId, String openingId, String closingId, Date founded, BigDecimal latitude, BigDecimal longitude, String description) throws Exception{

		RetailStore retailStore = new RetailStore();
		
		
		retailStore.setName(name);		
		retailStore.setTelephone(telephone);		
		retailStore.setOwner(owner);		
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

	protected void checkParamsForRemovingRetailStoreList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String retailStoreIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String retailStoreIdItem: retailStoreIds){
			checkerOf(userContext).checkIdOfRetailStore(retailStoreIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeRetailStoreList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String retailStoreIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreList(userContext, retailStoreCountryCenterId,  retailStoreIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveRetailStoreList(retailStoreCountryCenter, retailStoreIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getRetailStoreList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStore(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeRetailStore(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStore(userContext,retailStoreCountryCenterId, retailStoreId, retailStoreVersion,tokensExpr);

		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeRetailStore( retailStore );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreList().done());
			deleteRelationInGraph(userContext, retailStore);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStore(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfRetailStore(retailStoreId);
		checkerOf(userContext).checkVersionOfRetailStore(retailStoreVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyRetailStoreFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String retailStoreId, int retailStoreVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStore(userContext,retailStoreCountryCenterId, retailStoreId, retailStoreVersion,tokensExpr);

		RetailStore retailStore = createIndexedRetailStore(retailStoreId, retailStoreVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			retailStore.updateLastUpdateTime(userContext.now());

			retailStoreCountryCenter.copyRetailStoreFrom( retailStore );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreList().done());
			
			userContext.getManagerGroup().getRetailStoreManager().onNewInstanceCreated(userContext, (RetailStore)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStore(RetailscmUserContext userContext, String retailStoreCountryCenterId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateRetailStore(RetailscmUserContext userContext, String retailStoreCountryCenterId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStore(userContext, retailStoreCountryCenterId, retailStoreId, retailStoreVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreList().searchRetailStoreListWith(RetailStore.ID_PROPERTY, "eq", retailStoreId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeRetailStore( retailStore );
			//make changes to AcceleraterAccount.
			RetailStore retailStoreIndex = createIndexedRetailStore(retailStoreId, retailStoreVersion);

			RetailStore retailStore = retailStoreCountryCenter.findTheRetailStore(retailStoreIndex);
			if(retailStore == null){
				throw new RetailStoreCountryCenterManagerException(retailStore+" is NOT FOUND" );
			}

			retailStore.changeProperty(property, newValueExpr);
			retailStore.updateLastUpdateTime(userContext.now());
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingRetailStoreMember(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String mobilePhone,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkNameOfRetailStoreMember(name);
		
		checkerOf(userContext).checkMobilePhoneOfRetailStoreMember(mobilePhone);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addRetailStoreMember(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String mobilePhone, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStoreMember(userContext,retailStoreCountryCenterId,name, mobilePhone,tokensExpr);

		RetailStoreMember retailStoreMember = createRetailStoreMember(userContext,name, mobilePhone);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addRetailStoreMember( retailStoreMember );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreMemberList().done());
			
			userContext.getManagerGroup().getRetailStoreMemberManager().onNewInstanceCreated(userContext, retailStoreMember);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreMemberProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String name,String mobilePhone,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfRetailStoreMember(id);

		checkerOf(userContext).checkNameOfRetailStoreMember( name);
		checkerOf(userContext).checkMobilePhoneOfRetailStoreMember( mobilePhone);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateRetailStoreMemberProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String name,String mobilePhone, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreMemberProperties(userContext,retailStoreCountryCenterId,id,name,mobilePhone,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreMemberListList()
				.searchRetailStoreMemberListWith(RetailStoreMember.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getRetailStoreMemberList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("RetailStoreMember is NOT FOUND with id: '"+id+"'");
		}

		RetailStoreMember item = retailStoreCountryCenterToUpdate.getRetailStoreMemberList().first();

		item.updateName( name );
		item.updateMobilePhone( mobilePhone );


		//checkParamsForAddingRetailStoreMember(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withRetailStoreMemberList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected RetailStoreMember createRetailStoreMember(RetailscmUserContext userContext, String name, String mobilePhone) throws Exception{

		RetailStoreMember retailStoreMember = new RetailStoreMember();
		
		
		retailStoreMember.setName(name);		
		retailStoreMember.setMobilePhone(mobilePhone);
	
		
		return retailStoreMember;


	}

	protected RetailStoreMember createIndexedRetailStoreMember(String id, int version){

		RetailStoreMember retailStoreMember = new RetailStoreMember();
		retailStoreMember.setId(id);
		retailStoreMember.setVersion(version);
		return retailStoreMember;

	}

	protected void checkParamsForRemovingRetailStoreMemberList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String retailStoreMemberIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String retailStoreMemberIdItem: retailStoreMemberIds){
			checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeRetailStoreMemberList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String retailStoreMemberIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreMemberList(userContext, retailStoreCountryCenterId,  retailStoreMemberIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveRetailStoreMemberList(retailStoreCountryCenter, retailStoreMemberIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreMemberList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getRetailStoreMemberList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStoreMember(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String retailStoreMemberId, int retailStoreMemberVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkVersionOfRetailStoreMember(retailStoreMemberVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeRetailStoreMember(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String retailStoreMemberId, int retailStoreMemberVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStoreMember(userContext,retailStoreCountryCenterId, retailStoreMemberId, retailStoreMemberVersion,tokensExpr);

		RetailStoreMember retailStoreMember = createIndexedRetailStoreMember(retailStoreMemberId, retailStoreMemberVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeRetailStoreMember( retailStoreMember );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreMemberList().done());
			deleteRelationInGraph(userContext, retailStoreMember);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStoreMember(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String retailStoreMemberId, int retailStoreMemberVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkVersionOfRetailStoreMember(retailStoreMemberVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyRetailStoreMemberFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String retailStoreMemberId, int retailStoreMemberVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStoreMember(userContext,retailStoreCountryCenterId, retailStoreMemberId, retailStoreMemberVersion,tokensExpr);

		RetailStoreMember retailStoreMember = createIndexedRetailStoreMember(retailStoreMemberId, retailStoreMemberVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreCountryCenter.copyRetailStoreMemberFrom( retailStoreMember );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreMemberList().done());
			
			userContext.getManagerGroup().getRetailStoreMemberManager().onNewInstanceCreated(userContext, (RetailStoreMember)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStoreMember(RetailscmUserContext userContext, String retailStoreCountryCenterId, String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfRetailStoreMember(retailStoreMemberId);
		checkerOf(userContext).checkVersionOfRetailStoreMember(retailStoreMemberVersion);
		

		if(RetailStoreMember.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfRetailStoreMember(parseString(newValueExpr));
		
		}
		
		if(RetailStoreMember.MOBILE_PHONE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkMobilePhoneOfRetailStoreMember(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateRetailStoreMember(RetailscmUserContext userContext, String retailStoreCountryCenterId, String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStoreMember(userContext, retailStoreCountryCenterId, retailStoreMemberId, retailStoreMemberVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreMemberList().searchRetailStoreMemberListWith(RetailStoreMember.ID_PROPERTY, "eq", retailStoreMemberId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeRetailStoreMember( retailStoreMember );
			//make changes to AcceleraterAccount.
			RetailStoreMember retailStoreMemberIndex = createIndexedRetailStoreMember(retailStoreMemberId, retailStoreMemberVersion);

			RetailStoreMember retailStoreMember = retailStoreCountryCenter.findTheRetailStoreMember(retailStoreMemberIndex);
			if(retailStoreMember == null){
				throw new RetailStoreCountryCenterManagerException(retailStoreMember+" is NOT FOUND" );
			}

			retailStoreMember.changeProperty(property, newValueExpr);
			
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreMemberList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingGoodsSupplier(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String supplyProduct, String contactNumber, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkNameOfGoodsSupplier(name);
		
		checkerOf(userContext).checkSupplyProductOfGoodsSupplier(supplyProduct);
		
		checkerOf(userContext).checkContactNumberOfGoodsSupplier(contactNumber);
		
		checkerOf(userContext).checkDescriptionOfGoodsSupplier(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addGoodsSupplier(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String supplyProduct, String contactNumber, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingGoodsSupplier(userContext,retailStoreCountryCenterId,name, supplyProduct, contactNumber, description,tokensExpr);

		GoodsSupplier goodsSupplier = createGoodsSupplier(userContext,name, supplyProduct, contactNumber, description);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addGoodsSupplier( goodsSupplier );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withGoodsSupplierList().done());
			
			userContext.getManagerGroup().getGoodsSupplierManager().onNewInstanceCreated(userContext, goodsSupplier);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingGoodsSupplierProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String name,String supplyProduct,String contactNumber,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfGoodsSupplier(id);

		checkerOf(userContext).checkNameOfGoodsSupplier( name);
		checkerOf(userContext).checkSupplyProductOfGoodsSupplier( supplyProduct);
		checkerOf(userContext).checkContactNumberOfGoodsSupplier( contactNumber);
		checkerOf(userContext).checkDescriptionOfGoodsSupplier( description);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateGoodsSupplierProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String name,String supplyProduct,String contactNumber,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingGoodsSupplierProperties(userContext,retailStoreCountryCenterId,id,name,supplyProduct,contactNumber,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withGoodsSupplierListList()
				.searchGoodsSupplierListWith(GoodsSupplier.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getGoodsSupplierList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("GoodsSupplier is NOT FOUND with id: '"+id+"'");
		}

		GoodsSupplier item = retailStoreCountryCenterToUpdate.getGoodsSupplierList().first();

		item.updateName( name );
		item.updateSupplyProduct( supplyProduct );
		item.updateContactNumber( contactNumber );
		item.updateDescription( description );


		//checkParamsForAddingGoodsSupplier(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withGoodsSupplierList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected GoodsSupplier createGoodsSupplier(RetailscmUserContext userContext, String name, String supplyProduct, String contactNumber, String description) throws Exception{

		GoodsSupplier goodsSupplier = new GoodsSupplier();
		
		
		goodsSupplier.setName(name);		
		goodsSupplier.setSupplyProduct(supplyProduct);		
		goodsSupplier.setContactNumber(contactNumber);		
		goodsSupplier.setDescription(description);		
		goodsSupplier.setLastUpdateTime(userContext.now());
	
		
		return goodsSupplier;


	}

	protected GoodsSupplier createIndexedGoodsSupplier(String id, int version){

		GoodsSupplier goodsSupplier = new GoodsSupplier();
		goodsSupplier.setId(id);
		goodsSupplier.setVersion(version);
		return goodsSupplier;

	}

	protected void checkParamsForRemovingGoodsSupplierList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String goodsSupplierIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String goodsSupplierIdItem: goodsSupplierIds){
			checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeGoodsSupplierList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String goodsSupplierIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingGoodsSupplierList(userContext, retailStoreCountryCenterId,  goodsSupplierIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveGoodsSupplierList(retailStoreCountryCenter, goodsSupplierIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withGoodsSupplierList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getGoodsSupplierList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingGoodsSupplier(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String goodsSupplierId, int goodsSupplierVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierId);
		checkerOf(userContext).checkVersionOfGoodsSupplier(goodsSupplierVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeGoodsSupplier(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String goodsSupplierId, int goodsSupplierVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingGoodsSupplier(userContext,retailStoreCountryCenterId, goodsSupplierId, goodsSupplierVersion,tokensExpr);

		GoodsSupplier goodsSupplier = createIndexedGoodsSupplier(goodsSupplierId, goodsSupplierVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeGoodsSupplier( goodsSupplier );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withGoodsSupplierList().done());
			deleteRelationInGraph(userContext, goodsSupplier);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingGoodsSupplier(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String goodsSupplierId, int goodsSupplierVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierId);
		checkerOf(userContext).checkVersionOfGoodsSupplier(goodsSupplierVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyGoodsSupplierFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String goodsSupplierId, int goodsSupplierVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingGoodsSupplier(userContext,retailStoreCountryCenterId, goodsSupplierId, goodsSupplierVersion,tokensExpr);

		GoodsSupplier goodsSupplier = createIndexedGoodsSupplier(goodsSupplierId, goodsSupplierVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			goodsSupplier.updateLastUpdateTime(userContext.now());

			retailStoreCountryCenter.copyGoodsSupplierFrom( goodsSupplier );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withGoodsSupplierList().done());
			
			userContext.getManagerGroup().getGoodsSupplierManager().onNewInstanceCreated(userContext, (GoodsSupplier)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingGoodsSupplier(RetailscmUserContext userContext, String retailStoreCountryCenterId, String goodsSupplierId, int goodsSupplierVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfGoodsSupplier(goodsSupplierId);
		checkerOf(userContext).checkVersionOfGoodsSupplier(goodsSupplierVersion);
		

		if(GoodsSupplier.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfGoodsSupplier(parseString(newValueExpr));
		
		}
		
		if(GoodsSupplier.SUPPLY_PRODUCT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkSupplyProductOfGoodsSupplier(parseString(newValueExpr));
		
		}
		
		if(GoodsSupplier.CONTACT_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkContactNumberOfGoodsSupplier(parseString(newValueExpr));
		
		}
		
		if(GoodsSupplier.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfGoodsSupplier(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateGoodsSupplier(RetailscmUserContext userContext, String retailStoreCountryCenterId, String goodsSupplierId, int goodsSupplierVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingGoodsSupplier(userContext, retailStoreCountryCenterId, goodsSupplierId, goodsSupplierVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withGoodsSupplierList().searchGoodsSupplierListWith(GoodsSupplier.ID_PROPERTY, "eq", goodsSupplierId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeGoodsSupplier( goodsSupplier );
			//make changes to AcceleraterAccount.
			GoodsSupplier goodsSupplierIndex = createIndexedGoodsSupplier(goodsSupplierId, goodsSupplierVersion);

			GoodsSupplier goodsSupplier = retailStoreCountryCenter.findTheGoodsSupplier(goodsSupplierIndex);
			if(goodsSupplier == null){
				throw new RetailStoreCountryCenterManagerException(goodsSupplier+" is NOT FOUND" );
			}

			goodsSupplier.changeProperty(property, newValueExpr);
			goodsSupplier.updateLastUpdateTime(userContext.now());
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withGoodsSupplierList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingSupplyOrder(RetailscmUserContext userContext, String retailStoreCountryCenterId, String sellerId, String title, BigDecimal totalAmount,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkSellerIdOfSupplyOrder(sellerId);
		
		checkerOf(userContext).checkTitleOfSupplyOrder(title);
		
		checkerOf(userContext).checkTotalAmountOfSupplyOrder(totalAmount);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addSupplyOrder(RetailscmUserContext userContext, String retailStoreCountryCenterId, String sellerId, String title, BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingSupplyOrder(userContext,retailStoreCountryCenterId,sellerId, title, totalAmount,tokensExpr);

		SupplyOrder supplyOrder = createSupplyOrder(userContext,sellerId, title, totalAmount);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addSupplyOrder( supplyOrder );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, supplyOrder);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSupplyOrderProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfSupplyOrder(id);

		checkerOf(userContext).checkTitleOfSupplyOrder( title);
		checkerOf(userContext).checkTotalAmountOfSupplyOrder( totalAmount);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateSupplyOrderProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSupplyOrderProperties(userContext,retailStoreCountryCenterId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSupplyOrderListList()
				.searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getSupplyOrderList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("SupplyOrder is NOT FOUND with id: '"+id+"'");
		}

		SupplyOrder item = retailStoreCountryCenterToUpdate.getSupplyOrderList().first();

		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );


		//checkParamsForAddingSupplyOrder(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withSupplyOrderList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected SupplyOrder createSupplyOrder(RetailscmUserContext userContext, String sellerId, String title, BigDecimal totalAmount) throws Exception{

		SupplyOrder supplyOrder = new SupplyOrder();
		
		
		GoodsSupplier  seller = new GoodsSupplier();
		seller.setId(sellerId);		
		supplyOrder.setSeller(seller);		
		supplyOrder.setTitle(title);		
		supplyOrder.setTotalAmount(totalAmount);		
		supplyOrder.setLastUpdateTime(userContext.now());
	
		
		return supplyOrder;


	}

	protected SupplyOrder createIndexedSupplyOrder(String id, int version){

		SupplyOrder supplyOrder = new SupplyOrder();
		supplyOrder.setId(id);
		supplyOrder.setVersion(version);
		return supplyOrder;

	}

	protected void checkParamsForRemovingSupplyOrderList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String supplyOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String supplyOrderIdItem: supplyOrderIds){
			checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeSupplyOrderList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String supplyOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingSupplyOrderList(userContext, retailStoreCountryCenterId,  supplyOrderIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveSupplyOrderList(retailStoreCountryCenter, supplyOrderIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSupplyOrderList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getSupplyOrderList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingSupplyOrder(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeSupplyOrder(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingSupplyOrder(userContext,retailStoreCountryCenterId, supplyOrderId, supplyOrderVersion,tokensExpr);

		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeSupplyOrder( supplyOrder );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSupplyOrderList().done());
			deleteRelationInGraph(userContext, supplyOrder);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingSupplyOrder(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copySupplyOrderFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String supplyOrderId, int supplyOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingSupplyOrder(userContext,retailStoreCountryCenterId, supplyOrderId, supplyOrderVersion,tokensExpr);

		SupplyOrder supplyOrder = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			supplyOrder.updateLastUpdateTime(userContext.now());

			retailStoreCountryCenter.copySupplyOrderFrom( supplyOrder );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSupplyOrderList().done());
			
			userContext.getManagerGroup().getSupplyOrderManager().onNewInstanceCreated(userContext, (SupplyOrder)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingSupplyOrder(RetailscmUserContext userContext, String retailStoreCountryCenterId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfSupplyOrder(supplyOrderId);
		checkerOf(userContext).checkVersionOfSupplyOrder(supplyOrderVersion);
		

		if(SupplyOrder.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfSupplyOrder(parseString(newValueExpr));
		
		}
		
		if(SupplyOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTotalAmountOfSupplyOrder(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateSupplyOrder(RetailscmUserContext userContext, String retailStoreCountryCenterId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingSupplyOrder(userContext, retailStoreCountryCenterId, supplyOrderId, supplyOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withSupplyOrderList().searchSupplyOrderListWith(SupplyOrder.ID_PROPERTY, "eq", supplyOrderId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeSupplyOrder( supplyOrder );
			//make changes to AcceleraterAccount.
			SupplyOrder supplyOrderIndex = createIndexedSupplyOrder(supplyOrderId, supplyOrderVersion);

			SupplyOrder supplyOrder = retailStoreCountryCenter.findTheSupplyOrder(supplyOrderIndex);
			if(supplyOrder == null){
				throw new RetailStoreCountryCenterManagerException(supplyOrder+" is NOT FOUND" );
			}

			supplyOrder.changeProperty(property, newValueExpr);
			supplyOrder.updateLastUpdateTime(userContext.now());
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSupplyOrderList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreCountryCenterId, String buyerId, String title, BigDecimal totalAmount,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkBuyerIdOfRetailStoreOrder(buyerId);
		
		checkerOf(userContext).checkTitleOfRetailStoreOrder(title);
		
		checkerOf(userContext).checkTotalAmountOfRetailStoreOrder(totalAmount);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreCountryCenterId, String buyerId, String title, BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingRetailStoreOrder(userContext,retailStoreCountryCenterId,buyerId, title, totalAmount,tokensExpr);

		RetailStoreOrder retailStoreOrder = createRetailStoreOrder(userContext,buyerId, title, totalAmount);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addRetailStoreOrder( retailStoreOrder );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, retailStoreOrder);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRetailStoreOrderProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String title,BigDecimal totalAmount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(id);

		checkerOf(userContext).checkTitleOfRetailStoreOrder( title);
		checkerOf(userContext).checkTotalAmountOfRetailStoreOrder( totalAmount);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateRetailStoreOrderProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String title,BigDecimal totalAmount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingRetailStoreOrderProperties(userContext,retailStoreCountryCenterId,id,title,totalAmount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRetailStoreOrderListList()
				.searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getRetailStoreOrderList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("RetailStoreOrder is NOT FOUND with id: '"+id+"'");
		}

		RetailStoreOrder item = retailStoreCountryCenterToUpdate.getRetailStoreOrderList().first();

		item.updateTitle( title );
		item.updateTotalAmount( totalAmount );


		//checkParamsForAddingRetailStoreOrder(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withRetailStoreOrderList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected RetailStoreOrder createRetailStoreOrder(RetailscmUserContext userContext, String buyerId, String title, BigDecimal totalAmount) throws Exception{

		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
		
		
		RetailStore  buyer = new RetailStore();
		buyer.setId(buyerId);		
		retailStoreOrder.setBuyer(buyer);		
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

	protected void checkParamsForRemovingRetailStoreOrderList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String retailStoreOrderIdItem: retailStoreOrderIds){
			checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeRetailStoreOrderList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String retailStoreOrderIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingRetailStoreOrderList(userContext, retailStoreCountryCenterId,  retailStoreOrderIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveRetailStoreOrderList(retailStoreCountryCenter, retailStoreOrderIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreOrderList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getRetailStoreOrderList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingRetailStoreOrder(userContext,retailStoreCountryCenterId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);

		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeRetailStoreOrder( retailStoreOrder );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreOrderList().done());
			deleteRelationInGraph(userContext, retailStoreOrder);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyRetailStoreOrderFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingRetailStoreOrder(userContext,retailStoreCountryCenterId, retailStoreOrderId, retailStoreOrderVersion,tokensExpr);

		RetailStoreOrder retailStoreOrder = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			retailStoreOrder.updateLastUpdateTime(userContext.now());

			retailStoreCountryCenter.copyRetailStoreOrderFrom( retailStoreOrder );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreOrderList().done());
			
			userContext.getManagerGroup().getRetailStoreOrderManager().onNewInstanceCreated(userContext, (RetailStoreOrder)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingRetailStoreOrder(RetailscmUserContext userContext, String retailStoreCountryCenterId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfRetailStoreOrder(retailStoreOrderId);
		checkerOf(userContext).checkVersionOfRetailStoreOrder(retailStoreOrderVersion);
		

		if(RetailStoreOrder.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfRetailStoreOrder(parseString(newValueExpr));
		
		}
		
		if(RetailStoreOrder.TOTAL_AMOUNT_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTotalAmountOfRetailStoreOrder(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreCountryCenterId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingRetailStoreOrder(userContext, retailStoreCountryCenterId, retailStoreOrderId, retailStoreOrderVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withRetailStoreOrderList().searchRetailStoreOrderListWith(RetailStoreOrder.ID_PROPERTY, "eq", retailStoreOrderId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeRetailStoreOrder( retailStoreOrder );
			//make changes to AcceleraterAccount.
			RetailStoreOrder retailStoreOrderIndex = createIndexedRetailStoreOrder(retailStoreOrderId, retailStoreOrderVersion);

			RetailStoreOrder retailStoreOrder = retailStoreCountryCenter.findTheRetailStoreOrder(retailStoreOrderIndex);
			if(retailStoreOrder == null){
				throw new RetailStoreCountryCenterManagerException(retailStoreOrder+" is NOT FOUND" );
			}

			retailStoreOrder.changeProperty(property, newValueExpr);
			retailStoreOrder.updateLastUpdateTime(userContext.now());
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withRetailStoreOrderList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingWarehouse(RetailscmUserContext userContext, String retailStoreCountryCenterId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkLocationOfWarehouse(location);
		
		checkerOf(userContext).checkContactNumberOfWarehouse(contactNumber);
		
		checkerOf(userContext).checkTotalAreaOfWarehouse(totalArea);
		
		checkerOf(userContext).checkLatitudeOfWarehouse(latitude);
		
		checkerOf(userContext).checkLongitudeOfWarehouse(longitude);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addWarehouse(RetailscmUserContext userContext, String retailStoreCountryCenterId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingWarehouse(userContext,retailStoreCountryCenterId,location, contactNumber, totalArea, latitude, longitude,tokensExpr);

		Warehouse warehouse = createWarehouse(userContext,location, contactNumber, totalArea, latitude, longitude);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addWarehouse( warehouse );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withWarehouseList().done());
			
			userContext.getManagerGroup().getWarehouseManager().onNewInstanceCreated(userContext, warehouse);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingWarehouseProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String location,String contactNumber,String totalArea,BigDecimal latitude,BigDecimal longitude,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfWarehouse(id);

		checkerOf(userContext).checkLocationOfWarehouse( location);
		checkerOf(userContext).checkContactNumberOfWarehouse( contactNumber);
		checkerOf(userContext).checkTotalAreaOfWarehouse( totalArea);
		checkerOf(userContext).checkLatitudeOfWarehouse( latitude);
		checkerOf(userContext).checkLongitudeOfWarehouse( longitude);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateWarehouseProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String location,String contactNumber,String totalArea,BigDecimal latitude,BigDecimal longitude, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingWarehouseProperties(userContext,retailStoreCountryCenterId,id,location,contactNumber,totalArea,latitude,longitude,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withWarehouseListList()
				.searchWarehouseListWith(Warehouse.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getWarehouseList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("Warehouse is NOT FOUND with id: '"+id+"'");
		}

		Warehouse item = retailStoreCountryCenterToUpdate.getWarehouseList().first();

		item.updateLocation( location );
		item.updateContactNumber( contactNumber );
		item.updateTotalArea( totalArea );
		item.updateLatitude( latitude );
		item.updateLongitude( longitude );


		//checkParamsForAddingWarehouse(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withWarehouseList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected Warehouse createWarehouse(RetailscmUserContext userContext, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude) throws Exception{

		Warehouse warehouse = new Warehouse();
		
		
		warehouse.setLocation(location);		
		warehouse.setContactNumber(contactNumber);		
		warehouse.setTotalArea(totalArea);		
		warehouse.setLatitude(latitude);		
		warehouse.setLongitude(longitude);		
		warehouse.setLastUpdateTime(userContext.now());
	
		
		return warehouse;


	}

	protected Warehouse createIndexedWarehouse(String id, int version){

		Warehouse warehouse = new Warehouse();
		warehouse.setId(id);
		warehouse.setVersion(version);
		return warehouse;

	}

	protected void checkParamsForRemovingWarehouseList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String warehouseIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String warehouseIdItem: warehouseIds){
			checkerOf(userContext).checkIdOfWarehouse(warehouseIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeWarehouseList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String warehouseIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingWarehouseList(userContext, retailStoreCountryCenterId,  warehouseIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveWarehouseList(retailStoreCountryCenter, warehouseIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withWarehouseList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getWarehouseList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingWarehouse(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String warehouseId, int warehouseVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfWarehouse(warehouseId);
		checkerOf(userContext).checkVersionOfWarehouse(warehouseVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeWarehouse(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String warehouseId, int warehouseVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingWarehouse(userContext,retailStoreCountryCenterId, warehouseId, warehouseVersion,tokensExpr);

		Warehouse warehouse = createIndexedWarehouse(warehouseId, warehouseVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeWarehouse( warehouse );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withWarehouseList().done());
			deleteRelationInGraph(userContext, warehouse);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingWarehouse(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String warehouseId, int warehouseVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfWarehouse(warehouseId);
		checkerOf(userContext).checkVersionOfWarehouse(warehouseVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyWarehouseFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String warehouseId, int warehouseVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingWarehouse(userContext,retailStoreCountryCenterId, warehouseId, warehouseVersion,tokensExpr);

		Warehouse warehouse = createIndexedWarehouse(warehouseId, warehouseVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			warehouse.updateLastUpdateTime(userContext.now());

			retailStoreCountryCenter.copyWarehouseFrom( warehouse );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withWarehouseList().done());
			
			userContext.getManagerGroup().getWarehouseManager().onNewInstanceCreated(userContext, (Warehouse)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingWarehouse(RetailscmUserContext userContext, String retailStoreCountryCenterId, String warehouseId, int warehouseVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfWarehouse(warehouseId);
		checkerOf(userContext).checkVersionOfWarehouse(warehouseVersion);
		

		if(Warehouse.LOCATION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLocationOfWarehouse(parseString(newValueExpr));
		
		}
		
		if(Warehouse.CONTACT_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkContactNumberOfWarehouse(parseString(newValueExpr));
		
		}
		
		if(Warehouse.TOTAL_AREA_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTotalAreaOfWarehouse(parseString(newValueExpr));
		
		}
		
		if(Warehouse.LATITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLatitudeOfWarehouse(parseBigDecimal(newValueExpr));
		
		}
		
		if(Warehouse.LONGITUDE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkLongitudeOfWarehouse(parseBigDecimal(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateWarehouse(RetailscmUserContext userContext, String retailStoreCountryCenterId, String warehouseId, int warehouseVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingWarehouse(userContext, retailStoreCountryCenterId, warehouseId, warehouseVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withWarehouseList().searchWarehouseListWith(Warehouse.ID_PROPERTY, "eq", warehouseId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeWarehouse( warehouse );
			//make changes to AcceleraterAccount.
			Warehouse warehouseIndex = createIndexedWarehouse(warehouseId, warehouseVersion);

			Warehouse warehouse = retailStoreCountryCenter.findTheWarehouse(warehouseIndex);
			if(warehouse == null){
				throw new RetailStoreCountryCenterManagerException(warehouse+" is NOT FOUND" );
			}

			warehouse.changeProperty(property, newValueExpr);
			warehouse.updateLastUpdateTime(userContext.now());
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withWarehouseList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingTransportFleet(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String contactNumber,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkNameOfTransportFleet(name);
		
		checkerOf(userContext).checkContactNumberOfTransportFleet(contactNumber);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addTransportFleet(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String contactNumber, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingTransportFleet(userContext,retailStoreCountryCenterId,name, contactNumber,tokensExpr);

		TransportFleet transportFleet = createTransportFleet(userContext,name, contactNumber);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addTransportFleet( transportFleet );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTransportFleetList().done());
			
			userContext.getManagerGroup().getTransportFleetManager().onNewInstanceCreated(userContext, transportFleet);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTransportFleetProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String name,String contactNumber,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfTransportFleet(id);

		checkerOf(userContext).checkNameOfTransportFleet( name);
		checkerOf(userContext).checkContactNumberOfTransportFleet( contactNumber);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateTransportFleetProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String name,String contactNumber, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTransportFleetProperties(userContext,retailStoreCountryCenterId,id,name,contactNumber,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTransportFleetListList()
				.searchTransportFleetListWith(TransportFleet.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getTransportFleetList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("TransportFleet is NOT FOUND with id: '"+id+"'");
		}

		TransportFleet item = retailStoreCountryCenterToUpdate.getTransportFleetList().first();

		item.updateName( name );
		item.updateContactNumber( contactNumber );


		//checkParamsForAddingTransportFleet(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withTransportFleetList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected TransportFleet createTransportFleet(RetailscmUserContext userContext, String name, String contactNumber) throws Exception{

		TransportFleet transportFleet = new TransportFleet();
		
		
		transportFleet.setName(name);		
		transportFleet.setContactNumber(contactNumber);		
		transportFleet.setLastUpdateTime(userContext.now());
	
		
		return transportFleet;


	}

	protected TransportFleet createIndexedTransportFleet(String id, int version){

		TransportFleet transportFleet = new TransportFleet();
		transportFleet.setId(id);
		transportFleet.setVersion(version);
		return transportFleet;

	}

	protected void checkParamsForRemovingTransportFleetList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String transportFleetIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String transportFleetIdItem: transportFleetIds){
			checkerOf(userContext).checkIdOfTransportFleet(transportFleetIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeTransportFleetList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String transportFleetIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingTransportFleetList(userContext, retailStoreCountryCenterId,  transportFleetIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveTransportFleetList(retailStoreCountryCenter, transportFleetIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTransportFleetList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getTransportFleetList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingTransportFleet(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String transportFleetId, int transportFleetVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfTransportFleet(transportFleetId);
		checkerOf(userContext).checkVersionOfTransportFleet(transportFleetVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeTransportFleet(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String transportFleetId, int transportFleetVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingTransportFleet(userContext,retailStoreCountryCenterId, transportFleetId, transportFleetVersion,tokensExpr);

		TransportFleet transportFleet = createIndexedTransportFleet(transportFleetId, transportFleetVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeTransportFleet( transportFleet );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTransportFleetList().done());
			deleteRelationInGraph(userContext, transportFleet);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingTransportFleet(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String transportFleetId, int transportFleetVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfTransportFleet(transportFleetId);
		checkerOf(userContext).checkVersionOfTransportFleet(transportFleetVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyTransportFleetFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String transportFleetId, int transportFleetVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingTransportFleet(userContext,retailStoreCountryCenterId, transportFleetId, transportFleetVersion,tokensExpr);

		TransportFleet transportFleet = createIndexedTransportFleet(transportFleetId, transportFleetVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			transportFleet.updateLastUpdateTime(userContext.now());

			retailStoreCountryCenter.copyTransportFleetFrom( transportFleet );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTransportFleetList().done());
			
			userContext.getManagerGroup().getTransportFleetManager().onNewInstanceCreated(userContext, (TransportFleet)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingTransportFleet(RetailscmUserContext userContext, String retailStoreCountryCenterId, String transportFleetId, int transportFleetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfTransportFleet(transportFleetId);
		checkerOf(userContext).checkVersionOfTransportFleet(transportFleetVersion);
		

		if(TransportFleet.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfTransportFleet(parseString(newValueExpr));
		
		}
		
		if(TransportFleet.CONTACT_NUMBER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkContactNumberOfTransportFleet(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateTransportFleet(RetailscmUserContext userContext, String retailStoreCountryCenterId, String transportFleetId, int transportFleetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingTransportFleet(userContext, retailStoreCountryCenterId, transportFleetId, transportFleetVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withTransportFleetList().searchTransportFleetListWith(TransportFleet.ID_PROPERTY, "eq", transportFleetId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeTransportFleet( transportFleet );
			//make changes to AcceleraterAccount.
			TransportFleet transportFleetIndex = createIndexedTransportFleet(transportFleetId, transportFleetVersion);

			TransportFleet transportFleet = retailStoreCountryCenter.findTheTransportFleet(transportFleetIndex);
			if(transportFleet == null){
				throw new RetailStoreCountryCenterManagerException(transportFleet+" is NOT FOUND" );
			}

			transportFleet.changeProperty(property, newValueExpr);
			transportFleet.updateLastUpdateTime(userContext.now());
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTransportFleetList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingAccountSet(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String retailStoreId, String goodsSupplierId,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkNameOfAccountSet(name);
		
		checkerOf(userContext).checkYearSetOfAccountSet(yearSet);
		
		checkerOf(userContext).checkEffectiveDateOfAccountSet(effectiveDate);
		
		checkerOf(userContext).checkAccountingSystemOfAccountSet(accountingSystem);
		
		checkerOf(userContext).checkDomesticCurrencyCodeOfAccountSet(domesticCurrencyCode);
		
		checkerOf(userContext).checkDomesticCurrencyNameOfAccountSet(domesticCurrencyName);
		
		checkerOf(userContext).checkOpeningBankOfAccountSet(openingBank);
		
		checkerOf(userContext).checkAccountNumberOfAccountSet(accountNumber);
		
		checkerOf(userContext).checkRetailStoreIdOfAccountSet(retailStoreId);
		
		checkerOf(userContext).checkGoodsSupplierIdOfAccountSet(goodsSupplierId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addAccountSet(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String retailStoreId, String goodsSupplierId, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingAccountSet(userContext,retailStoreCountryCenterId,name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, retailStoreId, goodsSupplierId,tokensExpr);

		AccountSet accountSet = createAccountSet(userContext,name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, retailStoreId, goodsSupplierId);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addAccountSet( accountSet );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withAccountSetList().done());
			
			userContext.getManagerGroup().getAccountSetManager().onNewInstanceCreated(userContext, accountSet);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAccountSetProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String name,String yearSet,Date effectiveDate,String accountingSystem,String domesticCurrencyCode,String domesticCurrencyName,String openingBank,String accountNumber,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfAccountSet(id);

		checkerOf(userContext).checkNameOfAccountSet( name);
		checkerOf(userContext).checkYearSetOfAccountSet( yearSet);
		checkerOf(userContext).checkEffectiveDateOfAccountSet( effectiveDate);
		checkerOf(userContext).checkAccountingSystemOfAccountSet( accountingSystem);
		checkerOf(userContext).checkDomesticCurrencyCodeOfAccountSet( domesticCurrencyCode);
		checkerOf(userContext).checkDomesticCurrencyNameOfAccountSet( domesticCurrencyName);
		checkerOf(userContext).checkOpeningBankOfAccountSet( openingBank);
		checkerOf(userContext).checkAccountNumberOfAccountSet( accountNumber);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateAccountSetProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String name,String yearSet,Date effectiveDate,String accountingSystem,String domesticCurrencyCode,String domesticCurrencyName,String openingBank,String accountNumber, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingAccountSetProperties(userContext,retailStoreCountryCenterId,id,name,yearSet,effectiveDate,accountingSystem,domesticCurrencyCode,domesticCurrencyName,openingBank,accountNumber,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAccountSetListList()
				.searchAccountSetListWith(AccountSet.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getAccountSetList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("AccountSet is NOT FOUND with id: '"+id+"'");
		}

		AccountSet item = retailStoreCountryCenterToUpdate.getAccountSetList().first();

		item.updateName( name );
		item.updateYearSet( yearSet );
		item.updateEffectiveDate( effectiveDate );
		item.updateAccountingSystem( accountingSystem );
		item.updateDomesticCurrencyCode( domesticCurrencyCode );
		item.updateDomesticCurrencyName( domesticCurrencyName );
		item.updateOpeningBank( openingBank );
		item.updateAccountNumber( accountNumber );


		//checkParamsForAddingAccountSet(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withAccountSetList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected AccountSet createAccountSet(RetailscmUserContext userContext, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String retailStoreId, String goodsSupplierId) throws Exception{

		AccountSet accountSet = new AccountSet();
		
		
		accountSet.setName(name);		
		accountSet.setYearSet(yearSet);		
		accountSet.setEffectiveDate(effectiveDate);		
		accountSet.setAccountingSystem(accountingSystem);		
		accountSet.setDomesticCurrencyCode(domesticCurrencyCode);		
		accountSet.setDomesticCurrencyName(domesticCurrencyName);		
		accountSet.setOpeningBank(openingBank);		
		accountSet.setAccountNumber(accountNumber);		
		RetailStore  retailStore = new RetailStore();
		retailStore.setId(retailStoreId);		
		accountSet.setRetailStore(retailStore);		
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

	protected void checkParamsForRemovingAccountSetList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String accountSetIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String accountSetIdItem: accountSetIds){
			checkerOf(userContext).checkIdOfAccountSet(accountSetIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeAccountSetList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String accountSetIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingAccountSetList(userContext, retailStoreCountryCenterId,  accountSetIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveAccountSetList(retailStoreCountryCenter, accountSetIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withAccountSetList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getAccountSetList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingAccountSet(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		checkerOf(userContext).checkVersionOfAccountSet(accountSetVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeAccountSet(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingAccountSet(userContext,retailStoreCountryCenterId, accountSetId, accountSetVersion,tokensExpr);

		AccountSet accountSet = createIndexedAccountSet(accountSetId, accountSetVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeAccountSet( accountSet );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withAccountSetList().done());
			deleteRelationInGraph(userContext, accountSet);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingAccountSet(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfAccountSet(accountSetId);
		checkerOf(userContext).checkVersionOfAccountSet(accountSetVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyAccountSetFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String accountSetId, int accountSetVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingAccountSet(userContext,retailStoreCountryCenterId, accountSetId, accountSetVersion,tokensExpr);

		AccountSet accountSet = createIndexedAccountSet(accountSetId, accountSetVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			accountSet.updateLastUpdateTime(userContext.now());

			retailStoreCountryCenter.copyAccountSetFrom( accountSet );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withAccountSetList().done());
			
			userContext.getManagerGroup().getAccountSetManager().onNewInstanceCreated(userContext, (AccountSet)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingAccountSet(RetailscmUserContext userContext, String retailStoreCountryCenterId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateAccountSet(RetailscmUserContext userContext, String retailStoreCountryCenterId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingAccountSet(userContext, retailStoreCountryCenterId, accountSetId, accountSetVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withAccountSetList().searchAccountSetListWith(AccountSet.ID_PROPERTY, "eq", accountSetId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeAccountSet( accountSet );
			//make changes to AcceleraterAccount.
			AccountSet accountSetIndex = createIndexedAccountSet(accountSetId, accountSetVersion);

			AccountSet accountSet = retailStoreCountryCenter.findTheAccountSet(accountSetIndex);
			if(accountSet == null){
				throw new RetailStoreCountryCenterManagerException(accountSet+" is NOT FOUND" );
			}

			accountSet.changeProperty(property, newValueExpr);
			accountSet.updateLastUpdateTime(userContext.now());
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withAccountSetList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingLevelOneDepartment(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String description, String manager, Date founded,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkNameOfLevelOneDepartment(name);
		
		checkerOf(userContext).checkDescriptionOfLevelOneDepartment(description);
		
		checkerOf(userContext).checkManagerOfLevelOneDepartment(manager);
		
		checkerOf(userContext).checkFoundedOfLevelOneDepartment(founded);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addLevelOneDepartment(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String description, String manager, Date founded, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingLevelOneDepartment(userContext,retailStoreCountryCenterId,name, description, manager, founded,tokensExpr);

		LevelOneDepartment levelOneDepartment = createLevelOneDepartment(userContext,name, description, manager, founded);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addLevelOneDepartment( levelOneDepartment );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withLevelOneDepartmentList().done());
			
			userContext.getManagerGroup().getLevelOneDepartmentManager().onNewInstanceCreated(userContext, levelOneDepartment);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLevelOneDepartmentProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String name,String description,String manager,Date founded,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfLevelOneDepartment(id);

		checkerOf(userContext).checkNameOfLevelOneDepartment( name);
		checkerOf(userContext).checkDescriptionOfLevelOneDepartment( description);
		checkerOf(userContext).checkManagerOfLevelOneDepartment( manager);
		checkerOf(userContext).checkFoundedOfLevelOneDepartment( founded);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateLevelOneDepartmentProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String name,String description,String manager,Date founded, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLevelOneDepartmentProperties(userContext,retailStoreCountryCenterId,id,name,description,manager,founded,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLevelOneDepartmentListList()
				.searchLevelOneDepartmentListWith(LevelOneDepartment.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getLevelOneDepartmentList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("LevelOneDepartment is NOT FOUND with id: '"+id+"'");
		}

		LevelOneDepartment item = retailStoreCountryCenterToUpdate.getLevelOneDepartmentList().first();

		item.updateName( name );
		item.updateDescription( description );
		item.updateManager( manager );
		item.updateFounded( founded );


		//checkParamsForAddingLevelOneDepartment(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withLevelOneDepartmentList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected LevelOneDepartment createLevelOneDepartment(RetailscmUserContext userContext, String name, String description, String manager, Date founded) throws Exception{

		LevelOneDepartment levelOneDepartment = new LevelOneDepartment();
		
		
		levelOneDepartment.setName(name);		
		levelOneDepartment.setDescription(description);		
		levelOneDepartment.setManager(manager);		
		levelOneDepartment.setFounded(founded);
	
		
		return levelOneDepartment;


	}

	protected LevelOneDepartment createIndexedLevelOneDepartment(String id, int version){

		LevelOneDepartment levelOneDepartment = new LevelOneDepartment();
		levelOneDepartment.setId(id);
		levelOneDepartment.setVersion(version);
		return levelOneDepartment;

	}

	protected void checkParamsForRemovingLevelOneDepartmentList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String levelOneDepartmentIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String levelOneDepartmentIdItem: levelOneDepartmentIds){
			checkerOf(userContext).checkIdOfLevelOneDepartment(levelOneDepartmentIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeLevelOneDepartmentList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String levelOneDepartmentIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingLevelOneDepartmentList(userContext, retailStoreCountryCenterId,  levelOneDepartmentIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveLevelOneDepartmentList(retailStoreCountryCenter, levelOneDepartmentIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withLevelOneDepartmentList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getLevelOneDepartmentList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingLevelOneDepartment(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String levelOneDepartmentId, int levelOneDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfLevelOneDepartment(levelOneDepartmentId);
		checkerOf(userContext).checkVersionOfLevelOneDepartment(levelOneDepartmentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeLevelOneDepartment(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String levelOneDepartmentId, int levelOneDepartmentVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingLevelOneDepartment(userContext,retailStoreCountryCenterId, levelOneDepartmentId, levelOneDepartmentVersion,tokensExpr);

		LevelOneDepartment levelOneDepartment = createIndexedLevelOneDepartment(levelOneDepartmentId, levelOneDepartmentVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeLevelOneDepartment( levelOneDepartment );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withLevelOneDepartmentList().done());
			deleteRelationInGraph(userContext, levelOneDepartment);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingLevelOneDepartment(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String levelOneDepartmentId, int levelOneDepartmentVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfLevelOneDepartment(levelOneDepartmentId);
		checkerOf(userContext).checkVersionOfLevelOneDepartment(levelOneDepartmentVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyLevelOneDepartmentFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String levelOneDepartmentId, int levelOneDepartmentVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingLevelOneDepartment(userContext,retailStoreCountryCenterId, levelOneDepartmentId, levelOneDepartmentVersion,tokensExpr);

		LevelOneDepartment levelOneDepartment = createIndexedLevelOneDepartment(levelOneDepartmentId, levelOneDepartmentVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreCountryCenter.copyLevelOneDepartmentFrom( levelOneDepartment );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withLevelOneDepartmentList().done());
			
			userContext.getManagerGroup().getLevelOneDepartmentManager().onNewInstanceCreated(userContext, (LevelOneDepartment)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingLevelOneDepartment(RetailscmUserContext userContext, String retailStoreCountryCenterId, String levelOneDepartmentId, int levelOneDepartmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfLevelOneDepartment(levelOneDepartmentId);
		checkerOf(userContext).checkVersionOfLevelOneDepartment(levelOneDepartmentVersion);
		

		if(LevelOneDepartment.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfLevelOneDepartment(parseString(newValueExpr));
		
		}
		
		if(LevelOneDepartment.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfLevelOneDepartment(parseString(newValueExpr));
		
		}
		
		if(LevelOneDepartment.MANAGER_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkManagerOfLevelOneDepartment(parseString(newValueExpr));
		
		}
		
		if(LevelOneDepartment.FOUNDED_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFoundedOfLevelOneDepartment(parseDate(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateLevelOneDepartment(RetailscmUserContext userContext, String retailStoreCountryCenterId, String levelOneDepartmentId, int levelOneDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingLevelOneDepartment(userContext, retailStoreCountryCenterId, levelOneDepartmentId, levelOneDepartmentVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withLevelOneDepartmentList().searchLevelOneDepartmentListWith(LevelOneDepartment.ID_PROPERTY, "eq", levelOneDepartmentId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeLevelOneDepartment( levelOneDepartment );
			//make changes to AcceleraterAccount.
			LevelOneDepartment levelOneDepartmentIndex = createIndexedLevelOneDepartment(levelOneDepartmentId, levelOneDepartmentVersion);

			LevelOneDepartment levelOneDepartment = retailStoreCountryCenter.findTheLevelOneDepartment(levelOneDepartmentIndex);
			if(levelOneDepartment == null){
				throw new RetailStoreCountryCenterManagerException(levelOneDepartment+" is NOT FOUND" );
			}

			levelOneDepartment.changeProperty(property, newValueExpr);
			
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withLevelOneDepartmentList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingSkillType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkCodeOfSkillType(code);
		
		checkerOf(userContext).checkDescriptionOfSkillType(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addSkillType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingSkillType(userContext,retailStoreCountryCenterId,code, description,tokensExpr);

		SkillType skillType = createSkillType(userContext,code, description);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addSkillType( skillType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSkillTypeList().done());
			
			userContext.getManagerGroup().getSkillTypeManager().onNewInstanceCreated(userContext, skillType);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSkillTypeProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String code,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfSkillType(id);

		checkerOf(userContext).checkCodeOfSkillType( code);
		checkerOf(userContext).checkDescriptionOfSkillType( description);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateSkillTypeProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String code,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSkillTypeProperties(userContext,retailStoreCountryCenterId,id,code,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSkillTypeListList()
				.searchSkillTypeListWith(SkillType.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getSkillTypeList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("SkillType is NOT FOUND with id: '"+id+"'");
		}

		SkillType item = retailStoreCountryCenterToUpdate.getSkillTypeList().first();

		item.updateCode( code );
		item.updateDescription( description );


		//checkParamsForAddingSkillType(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withSkillTypeList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected SkillType createSkillType(RetailscmUserContext userContext, String code, String description) throws Exception{

		SkillType skillType = new SkillType();
		
		
		skillType.setCode(code);		
		skillType.setDescription(description);
	
		
		return skillType;


	}

	protected SkillType createIndexedSkillType(String id, int version){

		SkillType skillType = new SkillType();
		skillType.setId(id);
		skillType.setVersion(version);
		return skillType;

	}

	protected void checkParamsForRemovingSkillTypeList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String skillTypeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String skillTypeIdItem: skillTypeIds){
			checkerOf(userContext).checkIdOfSkillType(skillTypeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeSkillTypeList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String skillTypeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingSkillTypeList(userContext, retailStoreCountryCenterId,  skillTypeIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveSkillTypeList(retailStoreCountryCenter, skillTypeIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSkillTypeList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getSkillTypeList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingSkillType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String skillTypeId, int skillTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfSkillType(skillTypeId);
		checkerOf(userContext).checkVersionOfSkillType(skillTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeSkillType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String skillTypeId, int skillTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingSkillType(userContext,retailStoreCountryCenterId, skillTypeId, skillTypeVersion,tokensExpr);

		SkillType skillType = createIndexedSkillType(skillTypeId, skillTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeSkillType( skillType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSkillTypeList().done());
			deleteRelationInGraph(userContext, skillType);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingSkillType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String skillTypeId, int skillTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfSkillType(skillTypeId);
		checkerOf(userContext).checkVersionOfSkillType(skillTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copySkillTypeFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String skillTypeId, int skillTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingSkillType(userContext,retailStoreCountryCenterId, skillTypeId, skillTypeVersion,tokensExpr);

		SkillType skillType = createIndexedSkillType(skillTypeId, skillTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreCountryCenter.copySkillTypeFrom( skillType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSkillTypeList().done());
			
			userContext.getManagerGroup().getSkillTypeManager().onNewInstanceCreated(userContext, (SkillType)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingSkillType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String skillTypeId, int skillTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfSkillType(skillTypeId);
		checkerOf(userContext).checkVersionOfSkillType(skillTypeVersion);
		

		if(SkillType.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfSkillType(parseString(newValueExpr));
		
		}
		
		if(SkillType.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfSkillType(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateSkillType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String skillTypeId, int skillTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingSkillType(userContext, retailStoreCountryCenterId, skillTypeId, skillTypeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withSkillTypeList().searchSkillTypeListWith(SkillType.ID_PROPERTY, "eq", skillTypeId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeSkillType( skillType );
			//make changes to AcceleraterAccount.
			SkillType skillTypeIndex = createIndexedSkillType(skillTypeId, skillTypeVersion);

			SkillType skillType = retailStoreCountryCenter.findTheSkillType(skillTypeIndex);
			if(skillType == null){
				throw new RetailStoreCountryCenterManagerException(skillType+" is NOT FOUND" );
			}

			skillType.changeProperty(property, newValueExpr);
			
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSkillTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingResponsibilityType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String baseDescription, String detailDescription,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkCodeOfResponsibilityType(code);
		
		checkerOf(userContext).checkBaseDescriptionOfResponsibilityType(baseDescription);
		
		checkerOf(userContext).checkDetailDescriptionOfResponsibilityType(detailDescription);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addResponsibilityType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String baseDescription, String detailDescription, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingResponsibilityType(userContext,retailStoreCountryCenterId,code, baseDescription, detailDescription,tokensExpr);

		ResponsibilityType responsibilityType = createResponsibilityType(userContext,code, baseDescription, detailDescription);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addResponsibilityType( responsibilityType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withResponsibilityTypeList().done());
			
			userContext.getManagerGroup().getResponsibilityTypeManager().onNewInstanceCreated(userContext, responsibilityType);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingResponsibilityTypeProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String code,String baseDescription,String detailDescription,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfResponsibilityType(id);

		checkerOf(userContext).checkCodeOfResponsibilityType( code);
		checkerOf(userContext).checkBaseDescriptionOfResponsibilityType( baseDescription);
		checkerOf(userContext).checkDetailDescriptionOfResponsibilityType( detailDescription);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateResponsibilityTypeProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String code,String baseDescription,String detailDescription, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingResponsibilityTypeProperties(userContext,retailStoreCountryCenterId,id,code,baseDescription,detailDescription,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withResponsibilityTypeListList()
				.searchResponsibilityTypeListWith(ResponsibilityType.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getResponsibilityTypeList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("ResponsibilityType is NOT FOUND with id: '"+id+"'");
		}

		ResponsibilityType item = retailStoreCountryCenterToUpdate.getResponsibilityTypeList().first();

		item.updateCode( code );
		item.updateBaseDescription( baseDescription );
		item.updateDetailDescription( detailDescription );


		//checkParamsForAddingResponsibilityType(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withResponsibilityTypeList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected ResponsibilityType createResponsibilityType(RetailscmUserContext userContext, String code, String baseDescription, String detailDescription) throws Exception{

		ResponsibilityType responsibilityType = new ResponsibilityType();
		
		
		responsibilityType.setCode(code);		
		responsibilityType.setBaseDescription(baseDescription);		
		responsibilityType.setDetailDescription(detailDescription);
	
		
		return responsibilityType;


	}

	protected ResponsibilityType createIndexedResponsibilityType(String id, int version){

		ResponsibilityType responsibilityType = new ResponsibilityType();
		responsibilityType.setId(id);
		responsibilityType.setVersion(version);
		return responsibilityType;

	}

	protected void checkParamsForRemovingResponsibilityTypeList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String responsibilityTypeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String responsibilityTypeIdItem: responsibilityTypeIds){
			checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeResponsibilityTypeList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String responsibilityTypeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingResponsibilityTypeList(userContext, retailStoreCountryCenterId,  responsibilityTypeIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveResponsibilityTypeList(retailStoreCountryCenter, responsibilityTypeIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withResponsibilityTypeList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getResponsibilityTypeList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingResponsibilityType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String responsibilityTypeId, int responsibilityTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);
		checkerOf(userContext).checkVersionOfResponsibilityType(responsibilityTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeResponsibilityType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String responsibilityTypeId, int responsibilityTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingResponsibilityType(userContext,retailStoreCountryCenterId, responsibilityTypeId, responsibilityTypeVersion,tokensExpr);

		ResponsibilityType responsibilityType = createIndexedResponsibilityType(responsibilityTypeId, responsibilityTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeResponsibilityType( responsibilityType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withResponsibilityTypeList().done());
			deleteRelationInGraph(userContext, responsibilityType);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingResponsibilityType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String responsibilityTypeId, int responsibilityTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);
		checkerOf(userContext).checkVersionOfResponsibilityType(responsibilityTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyResponsibilityTypeFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String responsibilityTypeId, int responsibilityTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingResponsibilityType(userContext,retailStoreCountryCenterId, responsibilityTypeId, responsibilityTypeVersion,tokensExpr);

		ResponsibilityType responsibilityType = createIndexedResponsibilityType(responsibilityTypeId, responsibilityTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreCountryCenter.copyResponsibilityTypeFrom( responsibilityType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withResponsibilityTypeList().done());
			
			userContext.getManagerGroup().getResponsibilityTypeManager().onNewInstanceCreated(userContext, (ResponsibilityType)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingResponsibilityType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String responsibilityTypeId, int responsibilityTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfResponsibilityType(responsibilityTypeId);
		checkerOf(userContext).checkVersionOfResponsibilityType(responsibilityTypeVersion);
		

		if(ResponsibilityType.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfResponsibilityType(parseString(newValueExpr));
		
		}
		
		if(ResponsibilityType.BASE_DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkBaseDescriptionOfResponsibilityType(parseString(newValueExpr));
		
		}
		
		if(ResponsibilityType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDetailDescriptionOfResponsibilityType(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateResponsibilityType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String responsibilityTypeId, int responsibilityTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingResponsibilityType(userContext, retailStoreCountryCenterId, responsibilityTypeId, responsibilityTypeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withResponsibilityTypeList().searchResponsibilityTypeListWith(ResponsibilityType.ID_PROPERTY, "eq", responsibilityTypeId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeResponsibilityType( responsibilityType );
			//make changes to AcceleraterAccount.
			ResponsibilityType responsibilityTypeIndex = createIndexedResponsibilityType(responsibilityTypeId, responsibilityTypeVersion);

			ResponsibilityType responsibilityType = retailStoreCountryCenter.findTheResponsibilityType(responsibilityTypeIndex);
			if(responsibilityType == null){
				throw new RetailStoreCountryCenterManagerException(responsibilityType+" is NOT FOUND" );
			}

			responsibilityType.changeProperty(property, newValueExpr);
			
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withResponsibilityTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingTerminationReason(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkCodeOfTerminationReason(code);
		
		checkerOf(userContext).checkDescriptionOfTerminationReason(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addTerminationReason(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingTerminationReason(userContext,retailStoreCountryCenterId,code, description,tokensExpr);

		TerminationReason terminationReason = createTerminationReason(userContext,code, description);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addTerminationReason( terminationReason );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTerminationReasonList().done());
			
			userContext.getManagerGroup().getTerminationReasonManager().onNewInstanceCreated(userContext, terminationReason);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTerminationReasonProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String code,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfTerminationReason(id);

		checkerOf(userContext).checkCodeOfTerminationReason( code);
		checkerOf(userContext).checkDescriptionOfTerminationReason( description);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateTerminationReasonProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String code,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTerminationReasonProperties(userContext,retailStoreCountryCenterId,id,code,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTerminationReasonListList()
				.searchTerminationReasonListWith(TerminationReason.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getTerminationReasonList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("TerminationReason is NOT FOUND with id: '"+id+"'");
		}

		TerminationReason item = retailStoreCountryCenterToUpdate.getTerminationReasonList().first();

		item.updateCode( code );
		item.updateDescription( description );


		//checkParamsForAddingTerminationReason(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withTerminationReasonList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected TerminationReason createTerminationReason(RetailscmUserContext userContext, String code, String description) throws Exception{

		TerminationReason terminationReason = new TerminationReason();
		
		
		terminationReason.setCode(code);		
		terminationReason.setDescription(description);
	
		
		return terminationReason;


	}

	protected TerminationReason createIndexedTerminationReason(String id, int version){

		TerminationReason terminationReason = new TerminationReason();
		terminationReason.setId(id);
		terminationReason.setVersion(version);
		return terminationReason;

	}

	protected void checkParamsForRemovingTerminationReasonList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String terminationReasonIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String terminationReasonIdItem: terminationReasonIds){
			checkerOf(userContext).checkIdOfTerminationReason(terminationReasonIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeTerminationReasonList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String terminationReasonIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingTerminationReasonList(userContext, retailStoreCountryCenterId,  terminationReasonIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveTerminationReasonList(retailStoreCountryCenter, terminationReasonIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTerminationReasonList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getTerminationReasonList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingTerminationReason(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String terminationReasonId, int terminationReasonVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfTerminationReason(terminationReasonId);
		checkerOf(userContext).checkVersionOfTerminationReason(terminationReasonVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeTerminationReason(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String terminationReasonId, int terminationReasonVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingTerminationReason(userContext,retailStoreCountryCenterId, terminationReasonId, terminationReasonVersion,tokensExpr);

		TerminationReason terminationReason = createIndexedTerminationReason(terminationReasonId, terminationReasonVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeTerminationReason( terminationReason );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTerminationReasonList().done());
			deleteRelationInGraph(userContext, terminationReason);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingTerminationReason(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String terminationReasonId, int terminationReasonVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfTerminationReason(terminationReasonId);
		checkerOf(userContext).checkVersionOfTerminationReason(terminationReasonVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyTerminationReasonFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String terminationReasonId, int terminationReasonVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingTerminationReason(userContext,retailStoreCountryCenterId, terminationReasonId, terminationReasonVersion,tokensExpr);

		TerminationReason terminationReason = createIndexedTerminationReason(terminationReasonId, terminationReasonVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreCountryCenter.copyTerminationReasonFrom( terminationReason );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTerminationReasonList().done());
			
			userContext.getManagerGroup().getTerminationReasonManager().onNewInstanceCreated(userContext, (TerminationReason)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingTerminationReason(RetailscmUserContext userContext, String retailStoreCountryCenterId, String terminationReasonId, int terminationReasonVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfTerminationReason(terminationReasonId);
		checkerOf(userContext).checkVersionOfTerminationReason(terminationReasonVersion);
		

		if(TerminationReason.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfTerminationReason(parseString(newValueExpr));
		
		}
		
		if(TerminationReason.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfTerminationReason(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateTerminationReason(RetailscmUserContext userContext, String retailStoreCountryCenterId, String terminationReasonId, int terminationReasonVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingTerminationReason(userContext, retailStoreCountryCenterId, terminationReasonId, terminationReasonVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withTerminationReasonList().searchTerminationReasonListWith(TerminationReason.ID_PROPERTY, "eq", terminationReasonId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeTerminationReason( terminationReason );
			//make changes to AcceleraterAccount.
			TerminationReason terminationReasonIndex = createIndexedTerminationReason(terminationReasonId, terminationReasonVersion);

			TerminationReason terminationReason = retailStoreCountryCenter.findTheTerminationReason(terminationReasonIndex);
			if(terminationReason == null){
				throw new RetailStoreCountryCenterManagerException(terminationReason+" is NOT FOUND" );
			}

			terminationReason.changeProperty(property, newValueExpr);
			
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTerminationReasonList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingTerminationType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String baseDescription, String detailDescription,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkCodeOfTerminationType(code);
		
		checkerOf(userContext).checkBaseDescriptionOfTerminationType(baseDescription);
		
		checkerOf(userContext).checkDetailDescriptionOfTerminationType(detailDescription);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addTerminationType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String baseDescription, String detailDescription, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingTerminationType(userContext,retailStoreCountryCenterId,code, baseDescription, detailDescription,tokensExpr);

		TerminationType terminationType = createTerminationType(userContext,code, baseDescription, detailDescription);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addTerminationType( terminationType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTerminationTypeList().done());
			
			userContext.getManagerGroup().getTerminationTypeManager().onNewInstanceCreated(userContext, terminationType);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTerminationTypeProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String code,String baseDescription,String detailDescription,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfTerminationType(id);

		checkerOf(userContext).checkCodeOfTerminationType( code);
		checkerOf(userContext).checkBaseDescriptionOfTerminationType( baseDescription);
		checkerOf(userContext).checkDetailDescriptionOfTerminationType( detailDescription);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateTerminationTypeProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String code,String baseDescription,String detailDescription, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTerminationTypeProperties(userContext,retailStoreCountryCenterId,id,code,baseDescription,detailDescription,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTerminationTypeListList()
				.searchTerminationTypeListWith(TerminationType.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getTerminationTypeList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("TerminationType is NOT FOUND with id: '"+id+"'");
		}

		TerminationType item = retailStoreCountryCenterToUpdate.getTerminationTypeList().first();

		item.updateCode( code );
		item.updateBaseDescription( baseDescription );
		item.updateDetailDescription( detailDescription );


		//checkParamsForAddingTerminationType(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withTerminationTypeList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected TerminationType createTerminationType(RetailscmUserContext userContext, String code, String baseDescription, String detailDescription) throws Exception{

		TerminationType terminationType = new TerminationType();
		
		
		terminationType.setCode(code);		
		terminationType.setBaseDescription(baseDescription);		
		terminationType.setDetailDescription(detailDescription);
	
		
		return terminationType;


	}

	protected TerminationType createIndexedTerminationType(String id, int version){

		TerminationType terminationType = new TerminationType();
		terminationType.setId(id);
		terminationType.setVersion(version);
		return terminationType;

	}

	protected void checkParamsForRemovingTerminationTypeList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String terminationTypeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String terminationTypeIdItem: terminationTypeIds){
			checkerOf(userContext).checkIdOfTerminationType(terminationTypeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeTerminationTypeList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String terminationTypeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingTerminationTypeList(userContext, retailStoreCountryCenterId,  terminationTypeIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveTerminationTypeList(retailStoreCountryCenter, terminationTypeIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTerminationTypeList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getTerminationTypeList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingTerminationType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String terminationTypeId, int terminationTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfTerminationType(terminationTypeId);
		checkerOf(userContext).checkVersionOfTerminationType(terminationTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeTerminationType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String terminationTypeId, int terminationTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingTerminationType(userContext,retailStoreCountryCenterId, terminationTypeId, terminationTypeVersion,tokensExpr);

		TerminationType terminationType = createIndexedTerminationType(terminationTypeId, terminationTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeTerminationType( terminationType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTerminationTypeList().done());
			deleteRelationInGraph(userContext, terminationType);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingTerminationType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String terminationTypeId, int terminationTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfTerminationType(terminationTypeId);
		checkerOf(userContext).checkVersionOfTerminationType(terminationTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyTerminationTypeFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String terminationTypeId, int terminationTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingTerminationType(userContext,retailStoreCountryCenterId, terminationTypeId, terminationTypeVersion,tokensExpr);

		TerminationType terminationType = createIndexedTerminationType(terminationTypeId, terminationTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreCountryCenter.copyTerminationTypeFrom( terminationType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTerminationTypeList().done());
			
			userContext.getManagerGroup().getTerminationTypeManager().onNewInstanceCreated(userContext, (TerminationType)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingTerminationType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String terminationTypeId, int terminationTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfTerminationType(terminationTypeId);
		checkerOf(userContext).checkVersionOfTerminationType(terminationTypeVersion);
		

		if(TerminationType.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfTerminationType(parseString(newValueExpr));
		
		}
		
		if(TerminationType.BASE_DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkBaseDescriptionOfTerminationType(parseString(newValueExpr));
		
		}
		
		if(TerminationType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDetailDescriptionOfTerminationType(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateTerminationType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String terminationTypeId, int terminationTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingTerminationType(userContext, retailStoreCountryCenterId, terminationTypeId, terminationTypeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withTerminationTypeList().searchTerminationTypeListWith(TerminationType.ID_PROPERTY, "eq", terminationTypeId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeTerminationType( terminationType );
			//make changes to AcceleraterAccount.
			TerminationType terminationTypeIndex = createIndexedTerminationType(terminationTypeId, terminationTypeVersion);

			TerminationType terminationType = retailStoreCountryCenter.findTheTerminationType(terminationTypeIndex);
			if(terminationType == null){
				throw new RetailStoreCountryCenterManagerException(terminationType+" is NOT FOUND" );
			}

			terminationType.changeProperty(property, newValueExpr);
			
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTerminationTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingOccupationType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkCodeOfOccupationType(code);
		
		checkerOf(userContext).checkDescriptionOfOccupationType(description);
		
		checkerOf(userContext).checkDetailDescriptionOfOccupationType(detailDescription);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addOccupationType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingOccupationType(userContext,retailStoreCountryCenterId,code, description, detailDescription,tokensExpr);

		OccupationType occupationType = createOccupationType(userContext,code, description, detailDescription);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addOccupationType( occupationType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withOccupationTypeList().done());
			
			userContext.getManagerGroup().getOccupationTypeManager().onNewInstanceCreated(userContext, occupationType);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingOccupationTypeProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String code,String description,String detailDescription,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfOccupationType(id);

		checkerOf(userContext).checkCodeOfOccupationType( code);
		checkerOf(userContext).checkDescriptionOfOccupationType( description);
		checkerOf(userContext).checkDetailDescriptionOfOccupationType( detailDescription);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateOccupationTypeProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String code,String description,String detailDescription, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingOccupationTypeProperties(userContext,retailStoreCountryCenterId,id,code,description,detailDescription,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withOccupationTypeListList()
				.searchOccupationTypeListWith(OccupationType.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getOccupationTypeList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("OccupationType is NOT FOUND with id: '"+id+"'");
		}

		OccupationType item = retailStoreCountryCenterToUpdate.getOccupationTypeList().first();

		item.updateCode( code );
		item.updateDescription( description );
		item.updateDetailDescription( detailDescription );


		//checkParamsForAddingOccupationType(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withOccupationTypeList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected OccupationType createOccupationType(RetailscmUserContext userContext, String code, String description, String detailDescription) throws Exception{

		OccupationType occupationType = new OccupationType();
		
		
		occupationType.setCode(code);		
		occupationType.setDescription(description);		
		occupationType.setDetailDescription(detailDescription);
	
		
		return occupationType;


	}

	protected OccupationType createIndexedOccupationType(String id, int version){

		OccupationType occupationType = new OccupationType();
		occupationType.setId(id);
		occupationType.setVersion(version);
		return occupationType;

	}

	protected void checkParamsForRemovingOccupationTypeList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String occupationTypeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String occupationTypeIdItem: occupationTypeIds){
			checkerOf(userContext).checkIdOfOccupationType(occupationTypeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeOccupationTypeList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String occupationTypeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingOccupationTypeList(userContext, retailStoreCountryCenterId,  occupationTypeIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveOccupationTypeList(retailStoreCountryCenter, occupationTypeIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withOccupationTypeList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getOccupationTypeList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingOccupationType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String occupationTypeId, int occupationTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfOccupationType(occupationTypeId);
		checkerOf(userContext).checkVersionOfOccupationType(occupationTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeOccupationType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String occupationTypeId, int occupationTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingOccupationType(userContext,retailStoreCountryCenterId, occupationTypeId, occupationTypeVersion,tokensExpr);

		OccupationType occupationType = createIndexedOccupationType(occupationTypeId, occupationTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeOccupationType( occupationType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withOccupationTypeList().done());
			deleteRelationInGraph(userContext, occupationType);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingOccupationType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String occupationTypeId, int occupationTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfOccupationType(occupationTypeId);
		checkerOf(userContext).checkVersionOfOccupationType(occupationTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyOccupationTypeFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String occupationTypeId, int occupationTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingOccupationType(userContext,retailStoreCountryCenterId, occupationTypeId, occupationTypeVersion,tokensExpr);

		OccupationType occupationType = createIndexedOccupationType(occupationTypeId, occupationTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreCountryCenter.copyOccupationTypeFrom( occupationType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withOccupationTypeList().done());
			
			userContext.getManagerGroup().getOccupationTypeManager().onNewInstanceCreated(userContext, (OccupationType)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingOccupationType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String occupationTypeId, int occupationTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfOccupationType(occupationTypeId);
		checkerOf(userContext).checkVersionOfOccupationType(occupationTypeVersion);
		

		if(OccupationType.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfOccupationType(parseString(newValueExpr));
		
		}
		
		if(OccupationType.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfOccupationType(parseString(newValueExpr));
		
		}
		
		if(OccupationType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDetailDescriptionOfOccupationType(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateOccupationType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String occupationTypeId, int occupationTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingOccupationType(userContext, retailStoreCountryCenterId, occupationTypeId, occupationTypeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withOccupationTypeList().searchOccupationTypeListWith(OccupationType.ID_PROPERTY, "eq", occupationTypeId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeOccupationType( occupationType );
			//make changes to AcceleraterAccount.
			OccupationType occupationTypeIndex = createIndexedOccupationType(occupationTypeId, occupationTypeVersion);

			OccupationType occupationType = retailStoreCountryCenter.findTheOccupationType(occupationTypeIndex);
			if(occupationType == null){
				throw new RetailStoreCountryCenterManagerException(occupationType+" is NOT FOUND" );
			}

			occupationType.changeProperty(property, newValueExpr);
			
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withOccupationTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingLeaveType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkCodeOfLeaveType(code);
		
		checkerOf(userContext).checkDescriptionOfLeaveType(description);
		
		checkerOf(userContext).checkDetailDescriptionOfLeaveType(detailDescription);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addLeaveType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingLeaveType(userContext,retailStoreCountryCenterId,code, description, detailDescription,tokensExpr);

		LeaveType leaveType = createLeaveType(userContext,code, description, detailDescription);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addLeaveType( leaveType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withLeaveTypeList().done());
			
			userContext.getManagerGroup().getLeaveTypeManager().onNewInstanceCreated(userContext, leaveType);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLeaveTypeProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String code,String description,String detailDescription,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfLeaveType(id);

		checkerOf(userContext).checkCodeOfLeaveType( code);
		checkerOf(userContext).checkDescriptionOfLeaveType( description);
		checkerOf(userContext).checkDetailDescriptionOfLeaveType( detailDescription);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateLeaveTypeProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String code,String description,String detailDescription, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingLeaveTypeProperties(userContext,retailStoreCountryCenterId,id,code,description,detailDescription,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLeaveTypeListList()
				.searchLeaveTypeListWith(LeaveType.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getLeaveTypeList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("LeaveType is NOT FOUND with id: '"+id+"'");
		}

		LeaveType item = retailStoreCountryCenterToUpdate.getLeaveTypeList().first();

		item.updateCode( code );
		item.updateDescription( description );
		item.updateDetailDescription( detailDescription );


		//checkParamsForAddingLeaveType(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withLeaveTypeList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected LeaveType createLeaveType(RetailscmUserContext userContext, String code, String description, String detailDescription) throws Exception{

		LeaveType leaveType = new LeaveType();
		
		
		leaveType.setCode(code);		
		leaveType.setDescription(description);		
		leaveType.setDetailDescription(detailDescription);
	
		
		return leaveType;


	}

	protected LeaveType createIndexedLeaveType(String id, int version){

		LeaveType leaveType = new LeaveType();
		leaveType.setId(id);
		leaveType.setVersion(version);
		return leaveType;

	}

	protected void checkParamsForRemovingLeaveTypeList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String leaveTypeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String leaveTypeIdItem: leaveTypeIds){
			checkerOf(userContext).checkIdOfLeaveType(leaveTypeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeLeaveTypeList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String leaveTypeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingLeaveTypeList(userContext, retailStoreCountryCenterId,  leaveTypeIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveLeaveTypeList(retailStoreCountryCenter, leaveTypeIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withLeaveTypeList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getLeaveTypeList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingLeaveType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String leaveTypeId, int leaveTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfLeaveType(leaveTypeId);
		checkerOf(userContext).checkVersionOfLeaveType(leaveTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeLeaveType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String leaveTypeId, int leaveTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingLeaveType(userContext,retailStoreCountryCenterId, leaveTypeId, leaveTypeVersion,tokensExpr);

		LeaveType leaveType = createIndexedLeaveType(leaveTypeId, leaveTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeLeaveType( leaveType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withLeaveTypeList().done());
			deleteRelationInGraph(userContext, leaveType);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingLeaveType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String leaveTypeId, int leaveTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfLeaveType(leaveTypeId);
		checkerOf(userContext).checkVersionOfLeaveType(leaveTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyLeaveTypeFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String leaveTypeId, int leaveTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingLeaveType(userContext,retailStoreCountryCenterId, leaveTypeId, leaveTypeVersion,tokensExpr);

		LeaveType leaveType = createIndexedLeaveType(leaveTypeId, leaveTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreCountryCenter.copyLeaveTypeFrom( leaveType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withLeaveTypeList().done());
			
			userContext.getManagerGroup().getLeaveTypeManager().onNewInstanceCreated(userContext, (LeaveType)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingLeaveType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String leaveTypeId, int leaveTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfLeaveType(leaveTypeId);
		checkerOf(userContext).checkVersionOfLeaveType(leaveTypeVersion);
		

		if(LeaveType.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfLeaveType(parseString(newValueExpr));
		
		}
		
		if(LeaveType.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfLeaveType(parseString(newValueExpr));
		
		}
		
		if(LeaveType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDetailDescriptionOfLeaveType(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateLeaveType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String leaveTypeId, int leaveTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingLeaveType(userContext, retailStoreCountryCenterId, leaveTypeId, leaveTypeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withLeaveTypeList().searchLeaveTypeListWith(LeaveType.ID_PROPERTY, "eq", leaveTypeId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeLeaveType( leaveType );
			//make changes to AcceleraterAccount.
			LeaveType leaveTypeIndex = createIndexedLeaveType(leaveTypeId, leaveTypeVersion);

			LeaveType leaveType = retailStoreCountryCenter.findTheLeaveType(leaveTypeIndex);
			if(leaveType == null){
				throw new RetailStoreCountryCenterManagerException(leaveType+" is NOT FOUND" );
			}

			leaveType.changeProperty(property, newValueExpr);
			
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withLeaveTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingSalaryGrade(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String detailDescription,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkCodeOfSalaryGrade(code);
		
		checkerOf(userContext).checkNameOfSalaryGrade(name);
		
		checkerOf(userContext).checkDetailDescriptionOfSalaryGrade(detailDescription);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addSalaryGrade(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String detailDescription, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingSalaryGrade(userContext,retailStoreCountryCenterId,code, name, detailDescription,tokensExpr);

		SalaryGrade salaryGrade = createSalaryGrade(userContext,code, name, detailDescription);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addSalaryGrade( salaryGrade );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSalaryGradeList().done());
			
			userContext.getManagerGroup().getSalaryGradeManager().onNewInstanceCreated(userContext, salaryGrade);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingSalaryGradeProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String code,String name,String detailDescription,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfSalaryGrade(id);

		checkerOf(userContext).checkCodeOfSalaryGrade( code);
		checkerOf(userContext).checkNameOfSalaryGrade( name);
		checkerOf(userContext).checkDetailDescriptionOfSalaryGrade( detailDescription);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateSalaryGradeProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String code,String name,String detailDescription, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingSalaryGradeProperties(userContext,retailStoreCountryCenterId,id,code,name,detailDescription,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withSalaryGradeListList()
				.searchSalaryGradeListWith(SalaryGrade.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getSalaryGradeList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("SalaryGrade is NOT FOUND with id: '"+id+"'");
		}

		SalaryGrade item = retailStoreCountryCenterToUpdate.getSalaryGradeList().first();

		item.updateCode( code );
		item.updateName( name );
		item.updateDetailDescription( detailDescription );


		//checkParamsForAddingSalaryGrade(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withSalaryGradeList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected SalaryGrade createSalaryGrade(RetailscmUserContext userContext, String code, String name, String detailDescription) throws Exception{

		SalaryGrade salaryGrade = new SalaryGrade();
		
		
		salaryGrade.setCode(code);		
		salaryGrade.setName(name);		
		salaryGrade.setDetailDescription(detailDescription);
	
		
		return salaryGrade;


	}

	protected SalaryGrade createIndexedSalaryGrade(String id, int version){

		SalaryGrade salaryGrade = new SalaryGrade();
		salaryGrade.setId(id);
		salaryGrade.setVersion(version);
		return salaryGrade;

	}

	protected void checkParamsForRemovingSalaryGradeList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String salaryGradeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String salaryGradeIdItem: salaryGradeIds){
			checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeSalaryGradeList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String salaryGradeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingSalaryGradeList(userContext, retailStoreCountryCenterId,  salaryGradeIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveSalaryGradeList(retailStoreCountryCenter, salaryGradeIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSalaryGradeList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getSalaryGradeList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingSalaryGrade(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String salaryGradeId, int salaryGradeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeId);
		checkerOf(userContext).checkVersionOfSalaryGrade(salaryGradeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeSalaryGrade(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String salaryGradeId, int salaryGradeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingSalaryGrade(userContext,retailStoreCountryCenterId, salaryGradeId, salaryGradeVersion,tokensExpr);

		SalaryGrade salaryGrade = createIndexedSalaryGrade(salaryGradeId, salaryGradeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeSalaryGrade( salaryGrade );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSalaryGradeList().done());
			deleteRelationInGraph(userContext, salaryGrade);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingSalaryGrade(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String salaryGradeId, int salaryGradeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeId);
		checkerOf(userContext).checkVersionOfSalaryGrade(salaryGradeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copySalaryGradeFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String salaryGradeId, int salaryGradeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingSalaryGrade(userContext,retailStoreCountryCenterId, salaryGradeId, salaryGradeVersion,tokensExpr);

		SalaryGrade salaryGrade = createIndexedSalaryGrade(salaryGradeId, salaryGradeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreCountryCenter.copySalaryGradeFrom( salaryGrade );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSalaryGradeList().done());
			
			userContext.getManagerGroup().getSalaryGradeManager().onNewInstanceCreated(userContext, (SalaryGrade)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingSalaryGrade(RetailscmUserContext userContext, String retailStoreCountryCenterId, String salaryGradeId, int salaryGradeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfSalaryGrade(salaryGradeId);
		checkerOf(userContext).checkVersionOfSalaryGrade(salaryGradeVersion);
		

		if(SalaryGrade.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfSalaryGrade(parseString(newValueExpr));
		
		}
		
		if(SalaryGrade.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfSalaryGrade(parseString(newValueExpr));
		
		}
		
		if(SalaryGrade.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDetailDescriptionOfSalaryGrade(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateSalaryGrade(RetailscmUserContext userContext, String retailStoreCountryCenterId, String salaryGradeId, int salaryGradeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingSalaryGrade(userContext, retailStoreCountryCenterId, salaryGradeId, salaryGradeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withSalaryGradeList().searchSalaryGradeListWith(SalaryGrade.ID_PROPERTY, "eq", salaryGradeId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeSalaryGrade( salaryGrade );
			//make changes to AcceleraterAccount.
			SalaryGrade salaryGradeIndex = createIndexedSalaryGrade(salaryGradeId, salaryGradeVersion);

			SalaryGrade salaryGrade = retailStoreCountryCenter.findTheSalaryGrade(salaryGradeIndex);
			if(salaryGrade == null){
				throw new RetailStoreCountryCenterManagerException(salaryGrade+" is NOT FOUND" );
			}

			salaryGrade.changeProperty(property, newValueExpr);
			
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withSalaryGradeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingInterviewType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkCodeOfInterviewType(code);
		
		checkerOf(userContext).checkDescriptionOfInterviewType(description);
		
		checkerOf(userContext).checkDetailDescriptionOfInterviewType(detailDescription);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addInterviewType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingInterviewType(userContext,retailStoreCountryCenterId,code, description, detailDescription,tokensExpr);

		InterviewType interviewType = createInterviewType(userContext,code, description, detailDescription);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addInterviewType( interviewType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withInterviewTypeList().done());
			
			userContext.getManagerGroup().getInterviewTypeManager().onNewInstanceCreated(userContext, interviewType);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingInterviewTypeProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String code,String description,String detailDescription,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfInterviewType(id);

		checkerOf(userContext).checkCodeOfInterviewType( code);
		checkerOf(userContext).checkDescriptionOfInterviewType( description);
		checkerOf(userContext).checkDetailDescriptionOfInterviewType( detailDescription);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateInterviewTypeProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String code,String description,String detailDescription, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingInterviewTypeProperties(userContext,retailStoreCountryCenterId,id,code,description,detailDescription,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withInterviewTypeListList()
				.searchInterviewTypeListWith(InterviewType.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getInterviewTypeList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("InterviewType is NOT FOUND with id: '"+id+"'");
		}

		InterviewType item = retailStoreCountryCenterToUpdate.getInterviewTypeList().first();

		item.updateCode( code );
		item.updateDescription( description );
		item.updateDetailDescription( detailDescription );


		//checkParamsForAddingInterviewType(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withInterviewTypeList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected InterviewType createInterviewType(RetailscmUserContext userContext, String code, String description, String detailDescription) throws Exception{

		InterviewType interviewType = new InterviewType();
		
		
		interviewType.setCode(code);		
		interviewType.setDescription(description);		
		interviewType.setDetailDescription(detailDescription);
	
		
		return interviewType;


	}

	protected InterviewType createIndexedInterviewType(String id, int version){

		InterviewType interviewType = new InterviewType();
		interviewType.setId(id);
		interviewType.setVersion(version);
		return interviewType;

	}

	protected void checkParamsForRemovingInterviewTypeList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String interviewTypeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String interviewTypeIdItem: interviewTypeIds){
			checkerOf(userContext).checkIdOfInterviewType(interviewTypeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeInterviewTypeList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String interviewTypeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingInterviewTypeList(userContext, retailStoreCountryCenterId,  interviewTypeIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveInterviewTypeList(retailStoreCountryCenter, interviewTypeIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withInterviewTypeList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getInterviewTypeList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingInterviewType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String interviewTypeId, int interviewTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfInterviewType(interviewTypeId);
		checkerOf(userContext).checkVersionOfInterviewType(interviewTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeInterviewType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String interviewTypeId, int interviewTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingInterviewType(userContext,retailStoreCountryCenterId, interviewTypeId, interviewTypeVersion,tokensExpr);

		InterviewType interviewType = createIndexedInterviewType(interviewTypeId, interviewTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeInterviewType( interviewType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withInterviewTypeList().done());
			deleteRelationInGraph(userContext, interviewType);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingInterviewType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String interviewTypeId, int interviewTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfInterviewType(interviewTypeId);
		checkerOf(userContext).checkVersionOfInterviewType(interviewTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyInterviewTypeFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String interviewTypeId, int interviewTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingInterviewType(userContext,retailStoreCountryCenterId, interviewTypeId, interviewTypeVersion,tokensExpr);

		InterviewType interviewType = createIndexedInterviewType(interviewTypeId, interviewTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreCountryCenter.copyInterviewTypeFrom( interviewType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withInterviewTypeList().done());
			
			userContext.getManagerGroup().getInterviewTypeManager().onNewInstanceCreated(userContext, (InterviewType)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingInterviewType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String interviewTypeId, int interviewTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfInterviewType(interviewTypeId);
		checkerOf(userContext).checkVersionOfInterviewType(interviewTypeVersion);
		

		if(InterviewType.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfInterviewType(parseString(newValueExpr));
		
		}
		
		if(InterviewType.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfInterviewType(parseString(newValueExpr));
		
		}
		
		if(InterviewType.DETAIL_DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDetailDescriptionOfInterviewType(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateInterviewType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String interviewTypeId, int interviewTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingInterviewType(userContext, retailStoreCountryCenterId, interviewTypeId, interviewTypeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withInterviewTypeList().searchInterviewTypeListWith(InterviewType.ID_PROPERTY, "eq", interviewTypeId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeInterviewType( interviewType );
			//make changes to AcceleraterAccount.
			InterviewType interviewTypeIndex = createIndexedInterviewType(interviewTypeId, interviewTypeVersion);

			InterviewType interviewType = retailStoreCountryCenter.findTheInterviewType(interviewTypeIndex);
			if(interviewType == null){
				throw new RetailStoreCountryCenterManagerException(interviewType+" is NOT FOUND" );
			}

			interviewType.changeProperty(property, newValueExpr);
			
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withInterviewTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingTrainingCourseType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkCodeOfTrainingCourseType(code);
		
		checkerOf(userContext).checkNameOfTrainingCourseType(name);
		
		checkerOf(userContext).checkDescriptionOfTrainingCourseType(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addTrainingCourseType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingTrainingCourseType(userContext,retailStoreCountryCenterId,code, name, description,tokensExpr);

		TrainingCourseType trainingCourseType = createTrainingCourseType(userContext,code, name, description);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addTrainingCourseType( trainingCourseType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTrainingCourseTypeList().done());
			
			userContext.getManagerGroup().getTrainingCourseTypeManager().onNewInstanceCreated(userContext, trainingCourseType);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingTrainingCourseTypeProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String code,String name,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfTrainingCourseType(id);

		checkerOf(userContext).checkCodeOfTrainingCourseType( code);
		checkerOf(userContext).checkNameOfTrainingCourseType( name);
		checkerOf(userContext).checkDescriptionOfTrainingCourseType( description);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateTrainingCourseTypeProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String code,String name,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingTrainingCourseTypeProperties(userContext,retailStoreCountryCenterId,id,code,name,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withTrainingCourseTypeListList()
				.searchTrainingCourseTypeListWith(TrainingCourseType.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getTrainingCourseTypeList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("TrainingCourseType is NOT FOUND with id: '"+id+"'");
		}

		TrainingCourseType item = retailStoreCountryCenterToUpdate.getTrainingCourseTypeList().first();

		item.updateCode( code );
		item.updateName( name );
		item.updateDescription( description );


		//checkParamsForAddingTrainingCourseType(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withTrainingCourseTypeList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected TrainingCourseType createTrainingCourseType(RetailscmUserContext userContext, String code, String name, String description) throws Exception{

		TrainingCourseType trainingCourseType = new TrainingCourseType();
		
		
		trainingCourseType.setCode(code);		
		trainingCourseType.setName(name);		
		trainingCourseType.setDescription(description);
	
		
		return trainingCourseType;


	}

	protected TrainingCourseType createIndexedTrainingCourseType(String id, int version){

		TrainingCourseType trainingCourseType = new TrainingCourseType();
		trainingCourseType.setId(id);
		trainingCourseType.setVersion(version);
		return trainingCourseType;

	}

	protected void checkParamsForRemovingTrainingCourseTypeList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String trainingCourseTypeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String trainingCourseTypeIdItem: trainingCourseTypeIds){
			checkerOf(userContext).checkIdOfTrainingCourseType(trainingCourseTypeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeTrainingCourseTypeList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String trainingCourseTypeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingTrainingCourseTypeList(userContext, retailStoreCountryCenterId,  trainingCourseTypeIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveTrainingCourseTypeList(retailStoreCountryCenter, trainingCourseTypeIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTrainingCourseTypeList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getTrainingCourseTypeList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingTrainingCourseType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String trainingCourseTypeId, int trainingCourseTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfTrainingCourseType(trainingCourseTypeId);
		checkerOf(userContext).checkVersionOfTrainingCourseType(trainingCourseTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeTrainingCourseType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String trainingCourseTypeId, int trainingCourseTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingTrainingCourseType(userContext,retailStoreCountryCenterId, trainingCourseTypeId, trainingCourseTypeVersion,tokensExpr);

		TrainingCourseType trainingCourseType = createIndexedTrainingCourseType(trainingCourseTypeId, trainingCourseTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeTrainingCourseType( trainingCourseType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTrainingCourseTypeList().done());
			deleteRelationInGraph(userContext, trainingCourseType);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingTrainingCourseType(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String trainingCourseTypeId, int trainingCourseTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfTrainingCourseType(trainingCourseTypeId);
		checkerOf(userContext).checkVersionOfTrainingCourseType(trainingCourseTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyTrainingCourseTypeFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String trainingCourseTypeId, int trainingCourseTypeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingTrainingCourseType(userContext,retailStoreCountryCenterId, trainingCourseTypeId, trainingCourseTypeVersion,tokensExpr);

		TrainingCourseType trainingCourseType = createIndexedTrainingCourseType(trainingCourseTypeId, trainingCourseTypeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreCountryCenter.copyTrainingCourseTypeFrom( trainingCourseType );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTrainingCourseTypeList().done());
			
			userContext.getManagerGroup().getTrainingCourseTypeManager().onNewInstanceCreated(userContext, (TrainingCourseType)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingTrainingCourseType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String trainingCourseTypeId, int trainingCourseTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfTrainingCourseType(trainingCourseTypeId);
		checkerOf(userContext).checkVersionOfTrainingCourseType(trainingCourseTypeVersion);
		

		if(TrainingCourseType.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfTrainingCourseType(parseString(newValueExpr));
		
		}
		
		if(TrainingCourseType.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfTrainingCourseType(parseString(newValueExpr));
		
		}
		
		if(TrainingCourseType.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfTrainingCourseType(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateTrainingCourseType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String trainingCourseTypeId, int trainingCourseTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingTrainingCourseType(userContext, retailStoreCountryCenterId, trainingCourseTypeId, trainingCourseTypeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withTrainingCourseTypeList().searchTrainingCourseTypeListWith(TrainingCourseType.ID_PROPERTY, "eq", trainingCourseTypeId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeTrainingCourseType( trainingCourseType );
			//make changes to AcceleraterAccount.
			TrainingCourseType trainingCourseTypeIndex = createIndexedTrainingCourseType(trainingCourseTypeId, trainingCourseTypeVersion);

			TrainingCourseType trainingCourseType = retailStoreCountryCenter.findTheTrainingCourseType(trainingCourseTypeIndex);
			if(trainingCourseType == null){
				throw new RetailStoreCountryCenterManagerException(trainingCourseType+" is NOT FOUND" );
			}

			trainingCourseType.changeProperty(property, newValueExpr);
			
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withTrainingCourseTypeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingPublicHoliday(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String description,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkCodeOfPublicHoliday(code);
		
		checkerOf(userContext).checkNameOfPublicHoliday(name);
		
		checkerOf(userContext).checkDescriptionOfPublicHoliday(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addPublicHoliday(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String description, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingPublicHoliday(userContext,retailStoreCountryCenterId,code, name, description,tokensExpr);

		PublicHoliday publicHoliday = createPublicHoliday(userContext,code, name, description);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addPublicHoliday( publicHoliday );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withPublicHolidayList().done());
			
			userContext.getManagerGroup().getPublicHolidayManager().onNewInstanceCreated(userContext, publicHoliday);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingPublicHolidayProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String code,String name,String description,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfPublicHoliday(id);

		checkerOf(userContext).checkCodeOfPublicHoliday( code);
		checkerOf(userContext).checkNameOfPublicHoliday( name);
		checkerOf(userContext).checkDescriptionOfPublicHoliday( description);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updatePublicHolidayProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String code,String name,String description, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingPublicHolidayProperties(userContext,retailStoreCountryCenterId,id,code,name,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withPublicHolidayListList()
				.searchPublicHolidayListWith(PublicHoliday.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getPublicHolidayList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("PublicHoliday is NOT FOUND with id: '"+id+"'");
		}

		PublicHoliday item = retailStoreCountryCenterToUpdate.getPublicHolidayList().first();

		item.updateCode( code );
		item.updateName( name );
		item.updateDescription( description );


		//checkParamsForAddingPublicHoliday(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withPublicHolidayList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected PublicHoliday createPublicHoliday(RetailscmUserContext userContext, String code, String name, String description) throws Exception{

		PublicHoliday publicHoliday = new PublicHoliday();
		
		
		publicHoliday.setCode(code);		
		publicHoliday.setName(name);		
		publicHoliday.setDescription(description);
	
		
		return publicHoliday;


	}

	protected PublicHoliday createIndexedPublicHoliday(String id, int version){

		PublicHoliday publicHoliday = new PublicHoliday();
		publicHoliday.setId(id);
		publicHoliday.setVersion(version);
		return publicHoliday;

	}

	protected void checkParamsForRemovingPublicHolidayList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String publicHolidayIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String publicHolidayIdItem: publicHolidayIds){
			checkerOf(userContext).checkIdOfPublicHoliday(publicHolidayIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removePublicHolidayList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String publicHolidayIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingPublicHolidayList(userContext, retailStoreCountryCenterId,  publicHolidayIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemovePublicHolidayList(retailStoreCountryCenter, publicHolidayIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withPublicHolidayList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getPublicHolidayList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingPublicHoliday(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String publicHolidayId, int publicHolidayVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfPublicHoliday(publicHolidayId);
		checkerOf(userContext).checkVersionOfPublicHoliday(publicHolidayVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removePublicHoliday(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String publicHolidayId, int publicHolidayVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingPublicHoliday(userContext,retailStoreCountryCenterId, publicHolidayId, publicHolidayVersion,tokensExpr);

		PublicHoliday publicHoliday = createIndexedPublicHoliday(publicHolidayId, publicHolidayVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removePublicHoliday( publicHoliday );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withPublicHolidayList().done());
			deleteRelationInGraph(userContext, publicHoliday);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingPublicHoliday(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String publicHolidayId, int publicHolidayVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfPublicHoliday(publicHolidayId);
		checkerOf(userContext).checkVersionOfPublicHoliday(publicHolidayVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyPublicHolidayFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String publicHolidayId, int publicHolidayVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingPublicHoliday(userContext,retailStoreCountryCenterId, publicHolidayId, publicHolidayVersion,tokensExpr);

		PublicHoliday publicHoliday = createIndexedPublicHoliday(publicHolidayId, publicHolidayVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			

			retailStoreCountryCenter.copyPublicHolidayFrom( publicHoliday );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withPublicHolidayList().done());
			
			userContext.getManagerGroup().getPublicHolidayManager().onNewInstanceCreated(userContext, (PublicHoliday)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingPublicHoliday(RetailscmUserContext userContext, String retailStoreCountryCenterId, String publicHolidayId, int publicHolidayVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfPublicHoliday(publicHolidayId);
		checkerOf(userContext).checkVersionOfPublicHoliday(publicHolidayVersion);
		

		if(PublicHoliday.CODE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCodeOfPublicHoliday(parseString(newValueExpr));
		
		}
		
		if(PublicHoliday.NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkNameOfPublicHoliday(parseString(newValueExpr));
		
		}
		
		if(PublicHoliday.DESCRIPTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDescriptionOfPublicHoliday(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updatePublicHoliday(RetailscmUserContext userContext, String retailStoreCountryCenterId, String publicHolidayId, int publicHolidayVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingPublicHoliday(userContext, retailStoreCountryCenterId, publicHolidayId, publicHolidayVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withPublicHolidayList().searchPublicHolidayListWith(PublicHoliday.ID_PROPERTY, "eq", publicHolidayId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removePublicHoliday( publicHoliday );
			//make changes to AcceleraterAccount.
			PublicHoliday publicHolidayIndex = createIndexedPublicHoliday(publicHolidayId, publicHolidayVersion);

			PublicHoliday publicHoliday = retailStoreCountryCenter.findThePublicHoliday(publicHolidayIndex);
			if(publicHoliday == null){
				throw new RetailStoreCountryCenterManagerException(publicHoliday+" is NOT FOUND" );
			}

			publicHoliday.changeProperty(property, newValueExpr);
			
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withPublicHolidayList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingEmployee(RetailscmUserContext userContext, String retailStoreCountryCenterId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkTitleOfEmployee(title);
		
		checkerOf(userContext).checkDepartmentIdOfEmployee(departmentId);
		
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
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addEmployee(RetailscmUserContext userContext, String retailStoreCountryCenterId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingEmployee(userContext,retailStoreCountryCenterId,title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount,tokensExpr);

		Employee employee = createEmployee(userContext,title, departmentId, familyName, givenName, email, city, address, cellPhone, occupationId, responsibleForId, currentSalaryGradeId, salaryAccount);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addEmployee( employee );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, employee);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingEmployeeProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfEmployee(id);

		checkerOf(userContext).checkTitleOfEmployee( title);
		checkerOf(userContext).checkFamilyNameOfEmployee( familyName);
		checkerOf(userContext).checkGivenNameOfEmployee( givenName);
		checkerOf(userContext).checkEmailOfEmployee( email);
		checkerOf(userContext).checkCityOfEmployee( city);
		checkerOf(userContext).checkAddressOfEmployee( address);
		checkerOf(userContext).checkCellPhoneOfEmployee( cellPhone);
		checkerOf(userContext).checkSalaryAccountOfEmployee( salaryAccount);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateEmployeeProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String title,String familyName,String givenName,String email,String city,String address,String cellPhone,String salaryAccount, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingEmployeeProperties(userContext,retailStoreCountryCenterId,id,title,familyName,givenName,email,city,address,cellPhone,salaryAccount,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withEmployeeListList()
				.searchEmployeeListWith(Employee.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getEmployeeList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("Employee is NOT FOUND with id: '"+id+"'");
		}

		Employee item = retailStoreCountryCenterToUpdate.getEmployeeList().first();

		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateEmail( email );
		item.updateCity( city );
		item.updateAddress( address );
		item.updateCellPhone( cellPhone );
		item.updateSalaryAccount( salaryAccount );


		//checkParamsForAddingEmployee(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withEmployeeList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected Employee createEmployee(RetailscmUserContext userContext, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount) throws Exception{

		Employee employee = new Employee();
		
		
		employee.setTitle(title);		
		LevelThreeDepartment  department = new LevelThreeDepartment();
		department.setId(departmentId);		
		employee.setDepartment(department);		
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

	protected void checkParamsForRemovingEmployeeList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String employeeIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String employeeIdItem: employeeIds){
			checkerOf(userContext).checkIdOfEmployee(employeeIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeEmployeeList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String employeeIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingEmployeeList(userContext, retailStoreCountryCenterId,  employeeIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveEmployeeList(retailStoreCountryCenter, employeeIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withEmployeeList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getEmployeeList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingEmployee(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeEmployee(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingEmployee(userContext,retailStoreCountryCenterId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeEmployee( employee );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withEmployeeList().done());
			deleteRelationInGraph(userContext, employee);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingEmployee(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfEmployee(employeeId);
		checkerOf(userContext).checkVersionOfEmployee(employeeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyEmployeeFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String employeeId, int employeeVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingEmployee(userContext,retailStoreCountryCenterId, employeeId, employeeVersion,tokensExpr);

		Employee employee = createIndexedEmployee(employeeId, employeeVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			employee.updateLastUpdateTime(userContext.now());

			retailStoreCountryCenter.copyEmployeeFrom( employee );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withEmployeeList().done());
			
			userContext.getManagerGroup().getEmployeeManager().onNewInstanceCreated(userContext, (Employee)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingEmployee(RetailscmUserContext userContext, String retailStoreCountryCenterId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateEmployee(RetailscmUserContext userContext, String retailStoreCountryCenterId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingEmployee(userContext, retailStoreCountryCenterId, employeeId, employeeVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withEmployeeList().searchEmployeeListWith(Employee.ID_PROPERTY, "eq", employeeId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeEmployee( employee );
			//make changes to AcceleraterAccount.
			Employee employeeIndex = createIndexedEmployee(employeeId, employeeVersion);

			Employee employee = retailStoreCountryCenter.findTheEmployee(employeeIndex);
			if(employee == null){
				throw new RetailStoreCountryCenterManagerException(employee+" is NOT FOUND" );
			}

			employee.changeProperty(property, newValueExpr);
			employee.updateLastUpdateTime(userContext.now());
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withEmployeeList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingInstructor(RetailscmUserContext userContext, String retailStoreCountryCenterId, String title, String familyName, String givenName, String cellPhone, String email, String introduction,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkTitleOfInstructor(title);
		
		checkerOf(userContext).checkFamilyNameOfInstructor(familyName);
		
		checkerOf(userContext).checkGivenNameOfInstructor(givenName);
		
		checkerOf(userContext).checkCellPhoneOfInstructor(cellPhone);
		
		checkerOf(userContext).checkEmailOfInstructor(email);
		
		checkerOf(userContext).checkIntroductionOfInstructor(introduction);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addInstructor(RetailscmUserContext userContext, String retailStoreCountryCenterId, String title, String familyName, String givenName, String cellPhone, String email, String introduction, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingInstructor(userContext,retailStoreCountryCenterId,title, familyName, givenName, cellPhone, email, introduction,tokensExpr);

		Instructor instructor = createInstructor(userContext,title, familyName, givenName, cellPhone, email, introduction);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addInstructor( instructor );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withInstructorList().done());
			
			userContext.getManagerGroup().getInstructorManager().onNewInstanceCreated(userContext, instructor);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingInstructorProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String title,String familyName,String givenName,String cellPhone,String email,String introduction,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfInstructor(id);

		checkerOf(userContext).checkTitleOfInstructor( title);
		checkerOf(userContext).checkFamilyNameOfInstructor( familyName);
		checkerOf(userContext).checkGivenNameOfInstructor( givenName);
		checkerOf(userContext).checkCellPhoneOfInstructor( cellPhone);
		checkerOf(userContext).checkEmailOfInstructor( email);
		checkerOf(userContext).checkIntroductionOfInstructor( introduction);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateInstructorProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String title,String familyName,String givenName,String cellPhone,String email,String introduction, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingInstructorProperties(userContext,retailStoreCountryCenterId,id,title,familyName,givenName,cellPhone,email,introduction,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withInstructorListList()
				.searchInstructorListWith(Instructor.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getInstructorList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("Instructor is NOT FOUND with id: '"+id+"'");
		}

		Instructor item = retailStoreCountryCenterToUpdate.getInstructorList().first();

		item.updateTitle( title );
		item.updateFamilyName( familyName );
		item.updateGivenName( givenName );
		item.updateCellPhone( cellPhone );
		item.updateEmail( email );
		item.updateIntroduction( introduction );


		//checkParamsForAddingInstructor(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withInstructorList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected Instructor createInstructor(RetailscmUserContext userContext, String title, String familyName, String givenName, String cellPhone, String email, String introduction) throws Exception{

		Instructor instructor = new Instructor();
		
		
		instructor.setTitle(title);		
		instructor.setFamilyName(familyName);		
		instructor.setGivenName(givenName);		
		instructor.setCellPhone(cellPhone);		
		instructor.setEmail(email);		
		instructor.setIntroduction(introduction);		
		instructor.setLastUpdateTime(userContext.now());
	
		
		return instructor;


	}

	protected Instructor createIndexedInstructor(String id, int version){

		Instructor instructor = new Instructor();
		instructor.setId(id);
		instructor.setVersion(version);
		return instructor;

	}

	protected void checkParamsForRemovingInstructorList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String instructorIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String instructorIdItem: instructorIds){
			checkerOf(userContext).checkIdOfInstructor(instructorIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeInstructorList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String instructorIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingInstructorList(userContext, retailStoreCountryCenterId,  instructorIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveInstructorList(retailStoreCountryCenter, instructorIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withInstructorList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getInstructorList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingInstructor(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String instructorId, int instructorVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfInstructor(instructorId);
		checkerOf(userContext).checkVersionOfInstructor(instructorVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeInstructor(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String instructorId, int instructorVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingInstructor(userContext,retailStoreCountryCenterId, instructorId, instructorVersion,tokensExpr);

		Instructor instructor = createIndexedInstructor(instructorId, instructorVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeInstructor( instructor );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withInstructorList().done());
			deleteRelationInGraph(userContext, instructor);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingInstructor(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String instructorId, int instructorVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfInstructor(instructorId);
		checkerOf(userContext).checkVersionOfInstructor(instructorVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyInstructorFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String instructorId, int instructorVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingInstructor(userContext,retailStoreCountryCenterId, instructorId, instructorVersion,tokensExpr);

		Instructor instructor = createIndexedInstructor(instructorId, instructorVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			instructor.updateLastUpdateTime(userContext.now());

			retailStoreCountryCenter.copyInstructorFrom( instructor );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withInstructorList().done());
			
			userContext.getManagerGroup().getInstructorManager().onNewInstanceCreated(userContext, (Instructor)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingInstructor(RetailscmUserContext userContext, String retailStoreCountryCenterId, String instructorId, int instructorVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfInstructor(instructorId);
		checkerOf(userContext).checkVersionOfInstructor(instructorVersion);
		

		if(Instructor.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfInstructor(parseString(newValueExpr));
		
		}
		
		if(Instructor.FAMILY_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkFamilyNameOfInstructor(parseString(newValueExpr));
		
		}
		
		if(Instructor.GIVEN_NAME_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkGivenNameOfInstructor(parseString(newValueExpr));
		
		}
		
		if(Instructor.CELL_PHONE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkCellPhoneOfInstructor(parseString(newValueExpr));
		
		}
		
		if(Instructor.EMAIL_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkEmailOfInstructor(parseString(newValueExpr));
		
		}
		
		if(Instructor.INTRODUCTION_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkIntroductionOfInstructor(parseString(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateInstructor(RetailscmUserContext userContext, String retailStoreCountryCenterId, String instructorId, int instructorVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingInstructor(userContext, retailStoreCountryCenterId, instructorId, instructorVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withInstructorList().searchInstructorListWith(Instructor.ID_PROPERTY, "eq", instructorId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeInstructor( instructor );
			//make changes to AcceleraterAccount.
			Instructor instructorIndex = createIndexedInstructor(instructorId, instructorVersion);

			Instructor instructor = retailStoreCountryCenter.findTheInstructor(instructorIndex);
			if(instructor == null){
				throw new RetailStoreCountryCenterManagerException(instructor+" is NOT FOUND" );
			}

			instructor.changeProperty(property, newValueExpr);
			instructor.updateLastUpdateTime(userContext.now());
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withInstructorList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	protected void checkParamsForAddingCompanyTraining(RetailscmUserContext userContext, String retailStoreCountryCenterId, String title, String instructorId, String trainingCourseTypeId, Date timeStart, int durationHours,String [] tokensExpr) throws Exception{

				checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);

		
		checkerOf(userContext).checkTitleOfCompanyTraining(title);
		
		checkerOf(userContext).checkInstructorIdOfCompanyTraining(instructorId);
		
		checkerOf(userContext).checkTrainingCourseTypeIdOfCompanyTraining(trainingCourseTypeId);
		
		checkerOf(userContext).checkTimeStartOfCompanyTraining(timeStart);
		
		checkerOf(userContext).checkDurationHoursOfCompanyTraining(durationHours);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);


	}
	public  RetailStoreCountryCenter addCompanyTraining(RetailscmUserContext userContext, String retailStoreCountryCenterId, String title, String instructorId, String trainingCourseTypeId, Date timeStart, int durationHours, String [] tokensExpr) throws Exception
	{

		checkParamsForAddingCompanyTraining(userContext,retailStoreCountryCenterId,title, instructorId, trainingCourseTypeId, timeStart, durationHours,tokensExpr);

		CompanyTraining companyTraining = createCompanyTraining(userContext,title, instructorId, trainingCourseTypeId, timeStart, durationHours);

		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, emptyOptions());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.addCompanyTraining( companyTraining );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withCompanyTrainingList().done());
			
			userContext.getManagerGroup().getCompanyTrainingManager().onNewInstanceCreated(userContext, companyTraining);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingCompanyTrainingProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId,String id,String title,Date timeStart,int durationHours,String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfCompanyTraining(id);

		checkerOf(userContext).checkTitleOfCompanyTraining( title);
		checkerOf(userContext).checkTimeStartOfCompanyTraining( timeStart);
		checkerOf(userContext).checkDurationHoursOfCompanyTraining( durationHours);

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter updateCompanyTrainingProperties(RetailscmUserContext userContext, String retailStoreCountryCenterId, String id,String title,Date timeStart,int durationHours, String [] tokensExpr) throws Exception
	{
		checkParamsForUpdatingCompanyTrainingProperties(userContext,retailStoreCountryCenterId,id,title,timeStart,durationHours,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withCompanyTrainingListList()
				.searchCompanyTrainingListWith(CompanyTraining.ID_PROPERTY, "is", id).done();

		RetailStoreCountryCenter retailStoreCountryCenterToUpdate = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, options);

		if(retailStoreCountryCenterToUpdate.getCompanyTrainingList().isEmpty()){
			throw new RetailStoreCountryCenterManagerException("CompanyTraining is NOT FOUND with id: '"+id+"'");
		}

		CompanyTraining item = retailStoreCountryCenterToUpdate.getCompanyTrainingList().first();

		item.updateTitle( title );
		item.updateTimeStart( timeStart );
		item.updateDurationHours( durationHours );


		//checkParamsForAddingCompanyTraining(userContext,retailStoreCountryCenterId,name, code, used,tokensExpr);
		RetailStoreCountryCenter retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenterToUpdate, tokens().withCompanyTrainingList().done());
		synchronized(retailStoreCountryCenter){
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}
	}


	protected CompanyTraining createCompanyTraining(RetailscmUserContext userContext, String title, String instructorId, String trainingCourseTypeId, Date timeStart, int durationHours) throws Exception{

		CompanyTraining companyTraining = new CompanyTraining();
		
		
		companyTraining.setTitle(title);		
		Instructor  instructor = new Instructor();
		instructor.setId(instructorId);		
		companyTraining.setInstructor(instructor);		
		TrainingCourseType  trainingCourseType = new TrainingCourseType();
		trainingCourseType.setId(trainingCourseTypeId);		
		companyTraining.setTrainingCourseType(trainingCourseType);		
		companyTraining.setTimeStart(timeStart);		
		companyTraining.setDurationHours(durationHours);		
		companyTraining.setLastUpdateTime(userContext.now());
	
		
		return companyTraining;


	}

	protected CompanyTraining createIndexedCompanyTraining(String id, int version){

		CompanyTraining companyTraining = new CompanyTraining();
		companyTraining.setId(id);
		companyTraining.setVersion(version);
		return companyTraining;

	}

	protected void checkParamsForRemovingCompanyTrainingList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String companyTrainingIds[],String [] tokensExpr) throws Exception {

		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		for(String companyTrainingIdItem: companyTrainingIds){
			checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingIdItem);
		}

		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeCompanyTrainingList(RetailscmUserContext userContext, String retailStoreCountryCenterId,
			String companyTrainingIds[],String [] tokensExpr) throws Exception{

			checkParamsForRemovingCompanyTrainingList(userContext, retailStoreCountryCenterId,  companyTrainingIds, tokensExpr);


			RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
			synchronized(retailStoreCountryCenter){
				//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				retailStoreCountryCenterDaoOf(userContext).planToRemoveCompanyTrainingList(retailStoreCountryCenter, companyTrainingIds, allTokens());
				retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withCompanyTrainingList().done());
				deleteRelationListInGraph(userContext, retailStoreCountryCenter.getCompanyTrainingList());
				return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
			}
	}

	protected void checkParamsForRemovingCompanyTraining(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingId);
		checkerOf(userContext).checkVersionOfCompanyTraining(companyTrainingVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter removeCompanyTraining(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{

		checkParamsForRemovingCompanyTraining(userContext,retailStoreCountryCenterId, companyTrainingId, companyTrainingVersion,tokensExpr);

		CompanyTraining companyTraining = createIndexedCompanyTraining(companyTrainingId, companyTrainingVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			retailStoreCountryCenter.removeCompanyTraining( companyTraining );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withCompanyTrainingList().done());
			deleteRelationInGraph(userContext, companyTraining);
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}


	}
	protected void checkParamsForCopyingCompanyTraining(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter( retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingId);
		checkerOf(userContext).checkVersionOfCompanyTraining(companyTrainingVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}
	public  RetailStoreCountryCenter copyCompanyTrainingFrom(RetailscmUserContext userContext, String retailStoreCountryCenterId,
		String companyTrainingId, int companyTrainingVersion,String [] tokensExpr) throws Exception{

		checkParamsForCopyingCompanyTraining(userContext,retailStoreCountryCenterId, companyTrainingId, companyTrainingVersion,tokensExpr);

		CompanyTraining companyTraining = createIndexedCompanyTraining(companyTrainingId, companyTrainingVersion);
		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, allTokens());
		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation

			companyTraining.updateLastUpdateTime(userContext.now());

			retailStoreCountryCenter.copyCompanyTrainingFrom( companyTraining );
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withCompanyTrainingList().done());
			
			userContext.getManagerGroup().getCompanyTrainingManager().onNewInstanceCreated(userContext, (CompanyTraining)retailStoreCountryCenter.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}

	protected void checkParamsForUpdatingCompanyTraining(RetailscmUserContext userContext, String retailStoreCountryCenterId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfRetailStoreCountryCenter(retailStoreCountryCenterId);
		checkerOf(userContext).checkIdOfCompanyTraining(companyTrainingId);
		checkerOf(userContext).checkVersionOfCompanyTraining(companyTrainingVersion);
		

		if(CompanyTraining.TITLE_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTitleOfCompanyTraining(parseString(newValueExpr));
		
		}
		
		if(CompanyTraining.TIME_START_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkTimeStartOfCompanyTraining(parseDate(newValueExpr));
		
		}
		
		if(CompanyTraining.DURATION_HOURS_PROPERTY.equals(property)){
		
			checkerOf(userContext).checkDurationHoursOfCompanyTraining(parseInt(newValueExpr));
		
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RetailStoreCountryCenterManagerException.class);

	}

	public  RetailStoreCountryCenter updateCompanyTraining(RetailscmUserContext userContext, String retailStoreCountryCenterId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{

		checkParamsForUpdatingCompanyTraining(userContext, retailStoreCountryCenterId, companyTrainingId, companyTrainingVersion, property, newValueExpr,  tokensExpr);

		Map<String,Object> loadTokens = this.tokens().withCompanyTrainingList().searchCompanyTrainingListWith(CompanyTraining.ID_PROPERTY, "eq", companyTrainingId).done();



		RetailStoreCountryCenter retailStoreCountryCenter = loadRetailStoreCountryCenter(userContext, retailStoreCountryCenterId, loadTokens);

		synchronized(retailStoreCountryCenter){
			//Will be good when the retailStoreCountryCenter loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//retailStoreCountryCenter.removeCompanyTraining( companyTraining );
			//make changes to AcceleraterAccount.
			CompanyTraining companyTrainingIndex = createIndexedCompanyTraining(companyTrainingId, companyTrainingVersion);

			CompanyTraining companyTraining = retailStoreCountryCenter.findTheCompanyTraining(companyTrainingIndex);
			if(companyTraining == null){
				throw new RetailStoreCountryCenterManagerException(companyTraining+" is NOT FOUND" );
			}

			companyTraining.changeProperty(property, newValueExpr);
			companyTraining.updateLastUpdateTime(userContext.now());
			retailStoreCountryCenter = saveRetailStoreCountryCenter(userContext, retailStoreCountryCenter, tokens().withCompanyTrainingList().done());
			return present(userContext,retailStoreCountryCenter, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/




	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreCountryCenter newCreated) throws Exception{
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
		//   RetailStoreCountryCenter newRetailStoreCountryCenter = this.createRetailStoreCountryCenter(userContext, ...
		// Next, create a sec-user in your business way:
		//   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile ...
		// And set it into loginContext:
		//   loginContext.getLoginTarget().setSecUser(secUser);
		// Next, create an user-app to connect secUser and newRetailStoreCountryCenter
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
		key.put(UserApp.OBJECT_TYPE_PROPERTY, RetailStoreCountryCenter.INTERNAL_TYPE);
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
    protected void enhanceForListOfView(RetailscmUserContext userContext,SmartList<RetailStoreCountryCenter> list) throws Exception {
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
 	public Object wxappview(RetailscmUserContext userContext, String retailStoreCountryCenterId) throws Exception{
	  SerializeScope vscope = RetailscmViewScope.getInstance().getRetailStoreCountryCenterDetailScope().clone();
		RetailStoreCountryCenter merchantObj = (RetailStoreCountryCenter) this.view(userContext, retailStoreCountryCenterId);
    String merchantObjId = retailStoreCountryCenterId;
    String linkToUrl =	"retailStoreCountryCenterManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "双链小超全国运营中心"+"详情";
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
				MapUtil.put("id", "3-serviceNumber")
				    .put("fieldName", "serviceNumber")
				    .put("label", "服务号码")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("serviceNumber", merchantObj.getServiceNumber());

		propList.add(
				MapUtil.put("id", "4-founded")
				    .put("fieldName", "founded")
				    .put("label", "成立")
				    .put("type", "date")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("founded", merchantObj.getFounded());

		propList.add(
				MapUtil.put("id", "5-webSite")
				    .put("fieldName", "webSite")
				    .put("label", "网站")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("webSite", merchantObj.getWebSite());

		propList.add(
				MapUtil.put("id", "6-address")
				    .put("fieldName", "address")
				    .put("label", "地址")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("address", merchantObj.getAddress());

		propList.add(
				MapUtil.put("id", "7-operatedBy")
				    .put("fieldName", "operatedBy")
				    .put("label", "由")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("operatedBy", merchantObj.getOperatedBy());

		propList.add(
				MapUtil.put("id", "8-legalRepresentative")
				    .put("fieldName", "legalRepresentative")
				    .put("label", "法定代表人")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("legalRepresentative", merchantObj.getLegalRepresentative());

		propList.add(
				MapUtil.put("id", "9-description")
				    .put("fieldName", "description")
				    .put("label", "描述")
				    .put("type", "text")
				    .put("linkToUrl", "")
				    .put("displayMode", "{}")
				    .into_map()
		);
		result.put("description", merchantObj.getDescription());

		//处理 sectionList

		//处理Section：catalogListSection
		Map catalogListSection = ListofUtils.buildSection(
		    "catalogListSection",
		    "目录列表",
		    null,
		    "",
		    "产品管理",
		    "catalogManager/listByOwner/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(catalogListSection);

		result.put("catalogListSection", ListofUtils.toShortList(merchantObj.getCatalogList(), "catalog"));
		vscope.field("catalogListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( Catalog.class.getName(), null));

		//处理Section：retailStoreProvinceCenterListSection
		Map retailStoreProvinceCenterListSection = ListofUtils.buildSection(
		    "retailStoreProvinceCenterListSection",
		    "零售门店省中心名单",
		    null,
		    "",
		    "组织机构",
		    "retailStoreProvinceCenterManager/listByCountry/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(retailStoreProvinceCenterListSection);

		result.put("retailStoreProvinceCenterListSection", ListofUtils.toShortList(merchantObj.getRetailStoreProvinceCenterList(), "retailStoreProvinceCenter"));
		vscope.field("retailStoreProvinceCenterListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( RetailStoreProvinceCenter.class.getName(), null));

		//处理Section：retailStoreListSection
		Map retailStoreListSection = ListofUtils.buildSection(
		    "retailStoreListSection",
		    "零售门店列表",
		    null,
		    "",
		    "加盟管理",
		    "retailStoreManager/listByRetailStoreCountryCenter/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(retailStoreListSection);

		result.put("retailStoreListSection", ListofUtils.toShortList(merchantObj.getRetailStoreList(), "retailStore"));
		vscope.field("retailStoreListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( RetailStore.class.getName(), null));

		//处理Section：retailStoreMemberListSection
		Map retailStoreMemberListSection = ListofUtils.buildSection(
		    "retailStoreMemberListSection",
		    "零售店会员名单",
		    null,
		    "",
		    "会员管理",
		    "retailStoreMemberManager/listByOwner/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(retailStoreMemberListSection);

		result.put("retailStoreMemberListSection", ListofUtils.toShortList(merchantObj.getRetailStoreMemberList(), "retailStoreMember"));
		vscope.field("retailStoreMemberListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( RetailStoreMember.class.getName(), null));

		//处理Section：goodsSupplierListSection
		Map goodsSupplierListSection = ListofUtils.buildSection(
		    "goodsSupplierListSection",
		    "货物供应商列表",
		    null,
		    "",
		    "供应管理",
		    "goodsSupplierManager/listByBelongTo/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(goodsSupplierListSection);

		result.put("goodsSupplierListSection", ListofUtils.toShortList(merchantObj.getGoodsSupplierList(), "goodsSupplier"));
		vscope.field("goodsSupplierListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( GoodsSupplier.class.getName(), null));

		//处理Section：supplyOrderListSection
		Map supplyOrderListSection = ListofUtils.buildSection(
		    "supplyOrderListSection",
		    "供应订单列表",
		    null,
		    "",
		    "供应管理",
		    "supplyOrderManager/listByBuyer/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(supplyOrderListSection);

		result.put("supplyOrderListSection", ListofUtils.toShortList(merchantObj.getSupplyOrderList(), "supplyOrder"));
		vscope.field("supplyOrderListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( SupplyOrder.class.getName(), null));

		//处理Section：retailStoreOrderListSection
		Map retailStoreOrderListSection = ListofUtils.buildSection(
		    "retailStoreOrderListSection",
		    "零售店订购单",
		    null,
		    "",
		    "销售管理",
		    "retailStoreOrderManager/listBySeller/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(retailStoreOrderListSection);

		result.put("retailStoreOrderListSection", ListofUtils.toShortList(merchantObj.getRetailStoreOrderList(), "retailStoreOrder"));
		vscope.field("retailStoreOrderListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( RetailStoreOrder.class.getName(), null));

		//处理Section：warehouseListSection
		Map warehouseListSection = ListofUtils.buildSection(
		    "warehouseListSection",
		    "仓库列表",
		    null,
		    "",
		    "仓配运一体化",
		    "warehouseManager/listByOwner/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(warehouseListSection);

		result.put("warehouseListSection", ListofUtils.toShortList(merchantObj.getWarehouseList(), "warehouse"));
		vscope.field("warehouseListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( Warehouse.class.getName(), null));

		//处理Section：transportFleetListSection
		Map transportFleetListSection = ListofUtils.buildSection(
		    "transportFleetListSection",
		    "运输舰队列表",
		    null,
		    "",
		    "仓配运一体化",
		    "transportFleetManager/listByOwner/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(transportFleetListSection);

		result.put("transportFleetListSection", ListofUtils.toShortList(merchantObj.getTransportFleetList(), "transportFleet"));
		vscope.field("transportFleetListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( TransportFleet.class.getName(), null));

		//处理Section：accountSetListSection
		Map accountSetListSection = ListofUtils.buildSection(
		    "accountSetListSection",
		    "帐户设置列表",
		    null,
		    "",
		    "财务管理",
		    "accountSetManager/listByCountryCenter/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(accountSetListSection);

		result.put("accountSetListSection", ListofUtils.toShortList(merchantObj.getAccountSetList(), "accountSet"));
		vscope.field("accountSetListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( AccountSet.class.getName(), null));

		//处理Section：levelOneDepartmentListSection
		Map levelOneDepartmentListSection = ListofUtils.buildSection(
		    "levelOneDepartmentListSection",
		    "一级部门名单",
		    null,
		    "",
		    "组织机构",
		    "levelOneDepartmentManager/listByBelongsTo/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(levelOneDepartmentListSection);

		result.put("levelOneDepartmentListSection", ListofUtils.toShortList(merchantObj.getLevelOneDepartmentList(), "levelOneDepartment"));
		vscope.field("levelOneDepartmentListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( LevelOneDepartment.class.getName(), null));

		//处理Section：employeeListSection
		Map employeeListSection = ListofUtils.buildSection(
		    "employeeListSection",
		    "员工列表",
		    null,
		    "",
		    "人力资源",
		    "employeeManager/listByCompany/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(employeeListSection);

		result.put("employeeListSection", ListofUtils.toShortList(merchantObj.getEmployeeList(), "employee"));
		vscope.field("employeeListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( Employee.class.getName(), null));

		//处理Section：instructorListSection
		Map instructorListSection = ListofUtils.buildSection(
		    "instructorListSection",
		    "导师名单",
		    null,
		    "",
		    "人力资源",
		    "instructorManager/listByCompany/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(instructorListSection);

		result.put("instructorListSection", ListofUtils.toShortList(merchantObj.getInstructorList(), "instructor"));
		vscope.field("instructorListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( Instructor.class.getName(), null));

		//处理Section：companyTrainingListSection
		Map companyTrainingListSection = ListofUtils.buildSection(
		    "companyTrainingListSection",
		    "公司培训名单",
		    null,
		    "",
		    "人力资源",
		    "companyTrainingManager/listByCompany/"+merchantObjId+"/",
		    "auto"
		);
		sections.add(companyTrainingListSection);

		result.put("companyTrainingListSection", ListofUtils.toShortList(merchantObj.getCompanyTrainingList(), "companyTraining"));
		vscope.field("companyTrainingListSection", RetailscmListOfViewScope.getInstance()
					.getListOfViewScope( CompanyTraining.class.getName(), null));

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


