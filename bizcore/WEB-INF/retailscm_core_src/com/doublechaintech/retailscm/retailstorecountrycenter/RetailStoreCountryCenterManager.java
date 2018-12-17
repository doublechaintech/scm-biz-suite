
package com.doublechaintech.retailscm.retailstorecountrycenter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreCountryCenterManager{

		

	public RetailStoreCountryCenter createRetailStoreCountryCenter(RetailscmUserContext userContext, String name, String serviceNumber, Date founded, String webSite, String address, String operatedBy, String legalRepresentative, String description) throws Exception;	
	public RetailStoreCountryCenter updateRetailStoreCountryCenter(RetailscmUserContext userContext,String retailStoreCountryCenterId, int retailStoreCountryCenterVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreCountryCenter loadRetailStoreCountryCenter(RetailscmUserContext userContext, String retailStoreCountryCenterId, String [] tokensExpr) throws Exception;
	public RetailStoreCountryCenter internalSaveRetailStoreCountryCenter(RetailscmUserContext userContext, RetailStoreCountryCenter retailStoreCountryCenter) throws Exception;
	public RetailStoreCountryCenter internalSaveRetailStoreCountryCenter(RetailscmUserContext userContext, RetailStoreCountryCenter retailStoreCountryCenter,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String retailStoreCountryCenterId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreCountryCenter newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  CatalogManager getCatalogManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addCatalog(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeCatalog(RetailscmUserContext userContext, String retailStoreCountryCenterId, String catalogId, int catalogVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateCatalog(RetailscmUserContext userContext, String retailStoreCountryCenterId, String catalogId, int catalogVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreProvinceCenterManager getRetailStoreProvinceCenterManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, Date founded ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addRetailStoreProvinceCenter(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, Date founded , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeRetailStoreProvinceCenter(RetailscmUserContext userContext, String retailStoreCountryCenterId, String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateRetailStoreProvinceCenter(RetailscmUserContext userContext, String retailStoreCountryCenterId, String retailStoreProvinceCenterId, int retailStoreProvinceCenterVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  RetailStoreManager getRetailStoreManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String telephone, String owner, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addRetailStore(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String telephone, String owner, String cityServiceCenterId, Date founded, BigDecimal latitude, BigDecimal longitude, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeRetailStore(RetailscmUserContext userContext, String retailStoreCountryCenterId, String retailStoreId, int retailStoreVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateRetailStore(RetailscmUserContext userContext, String retailStoreCountryCenterId, String retailStoreId, int retailStoreVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  RetailStoreCountryCenter associateRetailStoreListToNewCreation(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreListToCreation(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreIds[],String creationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreListToNewInvestmentInvitation(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreListToInvestmentInvitation(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreIds[],String investmentInvitationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreListToNewFranchising(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreListToFranchising(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreIds[],String franchisingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreListToNewDecoration(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreListToDecoration(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreIds[],String decorationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreListToNewOpening(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreListToOpening(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreIds[],String openingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreListToNewClosing(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreIds[], String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreListToClosing(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreIds[],String closingId, String [] tokensExpr) throws Exception ;

	*/

	//public  RetailStoreMemberManager getRetailStoreMemberManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String mobilePhone ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addRetailStoreMember(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String mobilePhone , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeRetailStoreMember(RetailscmUserContext userContext, String retailStoreCountryCenterId, String retailStoreMemberId, int retailStoreMemberVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateRetailStoreMember(RetailscmUserContext userContext, String retailStoreCountryCenterId, String retailStoreMemberId, int retailStoreMemberVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  GoodsSupplierManager getGoodsSupplierManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String supplyProduct, String contactNumber, String description ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addGoodsSupplier(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String supplyProduct, String contactNumber, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeGoodsSupplier(RetailscmUserContext userContext, String retailStoreCountryCenterId, String goodsSupplierId, int goodsSupplierVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateGoodsSupplier(RetailscmUserContext userContext, String retailStoreCountryCenterId, String goodsSupplierId, int goodsSupplierVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SupplyOrderManager getSupplyOrderManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String sellerId, String title, BigDecimal totalAmount ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addSupplyOrder(RetailscmUserContext userContext, String retailStoreCountryCenterId, String sellerId, String title, BigDecimal totalAmount , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeSupplyOrder(RetailscmUserContext userContext, String retailStoreCountryCenterId, String supplyOrderId, int supplyOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateSupplyOrder(RetailscmUserContext userContext, String retailStoreCountryCenterId, String supplyOrderId, int supplyOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  RetailStoreCountryCenter associateSupplyOrderListToNewConfirmation(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  supplyOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateSupplyOrderListToConfirmation(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  supplyOrderIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateSupplyOrderListToNewApproval(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  supplyOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateSupplyOrderListToApproval(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  supplyOrderIds[],String approvalId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateSupplyOrderListToNewProcessing(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateSupplyOrderListToProcessing(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  supplyOrderIds[],String processingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateSupplyOrderListToNewPicking(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  supplyOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateSupplyOrderListToPicking(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  supplyOrderIds[],String pickingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateSupplyOrderListToNewShipment(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  supplyOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateSupplyOrderListToShipment(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  supplyOrderIds[],String shipmentId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateSupplyOrderListToNewDelivery(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  supplyOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateSupplyOrderListToDelivery(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  supplyOrderIds[],String deliveryId, String [] tokensExpr) throws Exception ;

	*/

	//public  RetailStoreOrderManager getRetailStoreOrderManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String buyerId, String title, BigDecimal totalAmount ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addRetailStoreOrder(RetailscmUserContext userContext, String retailStoreCountryCenterId, String buyerId, String title, BigDecimal totalAmount , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeRetailStoreOrder(RetailscmUserContext userContext, String retailStoreCountryCenterId, String retailStoreOrderId, int retailStoreOrderVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateRetailStoreOrder(RetailscmUserContext userContext, String retailStoreCountryCenterId, String retailStoreOrderId, int retailStoreOrderVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  RetailStoreCountryCenter associateRetailStoreOrderListToNewConfirmation(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreOrderIds[], String who, Date confirmTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreOrderListToConfirmation(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreOrderIds[],String confirmationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreOrderListToNewApproval(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreOrderIds[], String who, Date approveTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreOrderListToApproval(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreOrderIds[],String approvalId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreOrderListToNewProcessing(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreOrderListToProcessing(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreOrderIds[],String processingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreOrderListToNewPicking(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreOrderIds[], String who, Date processTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreOrderListToPicking(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreOrderIds[],String pickingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreOrderListToNewShipment(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreOrderIds[], String who, Date shipTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreOrderListToShipment(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreOrderIds[],String shipmentId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreOrderListToNewDelivery(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreOrderIds[], String who, Date deliveryTime, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateRetailStoreOrderListToDelivery(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  retailStoreOrderIds[],String deliveryId, String [] tokensExpr) throws Exception ;

	*/

	//public  WarehouseManager getWarehouseManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addWarehouse(RetailscmUserContext userContext, String retailStoreCountryCenterId, String location, String contactNumber, String totalArea, BigDecimal latitude, BigDecimal longitude , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeWarehouse(RetailscmUserContext userContext, String retailStoreCountryCenterId, String warehouseId, int warehouseVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateWarehouse(RetailscmUserContext userContext, String retailStoreCountryCenterId, String warehouseId, int warehouseVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TransportFleetManager getTransportFleetManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String contactNumber ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addTransportFleet(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String contactNumber , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeTransportFleet(RetailscmUserContext userContext, String retailStoreCountryCenterId, String transportFleetId, int transportFleetVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateTransportFleet(RetailscmUserContext userContext, String retailStoreCountryCenterId, String transportFleetId, int transportFleetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  AccountSetManager getAccountSetManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String retailStoreId, String goodsSupplierId ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addAccountSet(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String yearSet, Date effectiveDate, String accountingSystem, String domesticCurrencyCode, String domesticCurrencyName, String openingBank, String accountNumber, String retailStoreId, String goodsSupplierId , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeAccountSet(RetailscmUserContext userContext, String retailStoreCountryCenterId, String accountSetId, int accountSetVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateAccountSet(RetailscmUserContext userContext, String retailStoreCountryCenterId, String accountSetId, int accountSetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  LevelOneDepartmentManager getLevelOneDepartmentManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String description, String manager, Date founded ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addLevelOneDepartment(RetailscmUserContext userContext, String retailStoreCountryCenterId, String name, String description, String manager, Date founded , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeLevelOneDepartment(RetailscmUserContext userContext, String retailStoreCountryCenterId, String levelOneDepartmentId, int levelOneDepartmentVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateLevelOneDepartment(RetailscmUserContext userContext, String retailStoreCountryCenterId, String levelOneDepartmentId, int levelOneDepartmentVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SkillTypeManager getSkillTypeManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String description ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addSkillType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeSkillType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String skillTypeId, int skillTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateSkillType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String skillTypeId, int skillTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ResponsibilityTypeManager getResponsibilityTypeManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String baseDescription, String detailDescription ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addResponsibilityType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String baseDescription, String detailDescription , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeResponsibilityType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String responsibilityTypeId, int responsibilityTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateResponsibilityType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String responsibilityTypeId, int responsibilityTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TerminationReasonManager getTerminationReasonManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String description ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addTerminationReason(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeTerminationReason(RetailscmUserContext userContext, String retailStoreCountryCenterId, String terminationReasonId, int terminationReasonVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateTerminationReason(RetailscmUserContext userContext, String retailStoreCountryCenterId, String terminationReasonId, int terminationReasonVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TerminationTypeManager getTerminationTypeManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String baseDescription, String detailDescription ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addTerminationType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String baseDescription, String detailDescription , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeTerminationType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String terminationTypeId, int terminationTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateTerminationType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String terminationTypeId, int terminationTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  OccupationTypeManager getOccupationTypeManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addOccupationType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeOccupationType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String occupationTypeId, int occupationTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateOccupationType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String occupationTypeId, int occupationTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  LeaveTypeManager getLeaveTypeManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addLeaveType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeLeaveType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String leaveTypeId, int leaveTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateLeaveType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String leaveTypeId, int leaveTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  SalaryGradeManager getSalaryGradeManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String detailDescription ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addSalaryGrade(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String detailDescription , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeSalaryGrade(RetailscmUserContext userContext, String retailStoreCountryCenterId, String salaryGradeId, int salaryGradeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateSalaryGrade(RetailscmUserContext userContext, String retailStoreCountryCenterId, String salaryGradeId, int salaryGradeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  InterviewTypeManager getInterviewTypeManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addInterviewType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String description, String detailDescription , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeInterviewType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String interviewTypeId, int interviewTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateInterviewType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String interviewTypeId, int interviewTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  TrainingCourseTypeManager getTrainingCourseTypeManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String description ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addTrainingCourseType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeTrainingCourseType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String trainingCourseTypeId, int trainingCourseTypeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateTrainingCourseType(RetailscmUserContext userContext, String retailStoreCountryCenterId, String trainingCourseTypeId, int trainingCourseTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PublicHolidayManager getPublicHolidayManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String description ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addPublicHoliday(RetailscmUserContext userContext, String retailStoreCountryCenterId, String code, String name, String description , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removePublicHoliday(RetailscmUserContext userContext, String retailStoreCountryCenterId, String publicHolidayId, int publicHolidayVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updatePublicHoliday(RetailscmUserContext userContext, String retailStoreCountryCenterId, String publicHolidayId, int publicHolidayVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EmployeeManager getEmployeeManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addEmployee(RetailscmUserContext userContext, String retailStoreCountryCenterId, String title, String departmentId, String familyName, String givenName, String email, String city, String address, String cellPhone, String occupationId, String responsibleForId, String currentSalaryGradeId, String salaryAccount , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeEmployee(RetailscmUserContext userContext, String retailStoreCountryCenterId, String employeeId, int employeeVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateEmployee(RetailscmUserContext userContext, String retailStoreCountryCenterId, String employeeId, int employeeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*
	public  RetailStoreCountryCenter associateEmployeeListToNewJobApplication(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  employeeIds[], Date applicationTime, String who, String comments, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateEmployeeListToJobApplication(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  employeeIds[],String jobApplicationId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateEmployeeListToNewProfessionInterview(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateEmployeeListToProfessionInterview(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  employeeIds[],String professionInterviewId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateEmployeeListToNewHrInterview(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  employeeIds[], String who, Date interviewTime, String comments, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateEmployeeListToHrInterview(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  employeeIds[],String hrInterviewId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateEmployeeListToNewOfferApproval(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  employeeIds[], String who, Date approveTime, String comments, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateEmployeeListToOfferApproval(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  employeeIds[],String offerApprovalId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateEmployeeListToNewOfferAcceptance(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  employeeIds[], String who, Date acceptTime, String comments, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateEmployeeListToOfferAcceptance(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  employeeIds[],String offerAcceptanceId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateEmployeeListToNewEmployeeBoarding(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  employeeIds[], String who, Date employTime, String comments, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateEmployeeListToEmployeeBoarding(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  employeeIds[],String employeeBoardingId, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateEmployeeListToNewTermination(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  employeeIds[], String reasonId, String typeId, String comment, String [] tokensExpr) throws Exception ;
	public  RetailStoreCountryCenter associateEmployeeListToTermination(RetailscmUserContext userContext, String retailStoreCountryCenterId, String  employeeIds[],String terminationId, String [] tokensExpr) throws Exception ;

	*/

	//public  InstructorManager getInstructorManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String title, String familyName, String givenName, String cellPhone, String email, String introduction ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addInstructor(RetailscmUserContext userContext, String retailStoreCountryCenterId, String title, String familyName, String givenName, String cellPhone, String email, String introduction , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeInstructor(RetailscmUserContext userContext, String retailStoreCountryCenterId, String instructorId, int instructorVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateInstructor(RetailscmUserContext userContext, String retailStoreCountryCenterId, String instructorId, int instructorVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  CompanyTrainingManager getCompanyTrainingManager(RetailscmUserContext userContext, String retailStoreCountryCenterId, String title, String instructorId, String trainingCourseTypeId, Date timeStart, int durationHours ,String [] tokensExpr)  throws Exception;
	
	public  RetailStoreCountryCenter addCompanyTraining(RetailscmUserContext userContext, String retailStoreCountryCenterId, String title, String instructorId, String trainingCourseTypeId, Date timeStart, int durationHours , String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter removeCompanyTraining(RetailscmUserContext userContext, String retailStoreCountryCenterId, String companyTrainingId, int companyTrainingVersion,String [] tokensExpr)  throws Exception;
	public  RetailStoreCountryCenter updateCompanyTraining(RetailscmUserContext userContext, String retailStoreCountryCenterId, String companyTrainingId, int companyTrainingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


