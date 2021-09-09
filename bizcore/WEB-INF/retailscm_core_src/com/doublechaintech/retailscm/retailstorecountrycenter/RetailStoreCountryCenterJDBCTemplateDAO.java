
package com.doublechaintech.retailscm.retailstorecountrycenter;

import com.doublechaintech.retailscm.Beans;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.TextUtil;

import com.doublechaintech.retailscm.RetailscmBaseDAOImpl;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.DateKey;
import com.doublechaintech.retailscm.StatsInfo;
import com.doublechaintech.retailscm.StatsItem;

import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;


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

import com.doublechaintech.retailscm.salarygrade.SalaryGradeDAO;
import com.doublechaintech.retailscm.publicholiday.PublicHolidayDAO;
import com.doublechaintech.retailscm.companytraining.CompanyTrainingDAO;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderDAO;
import com.doublechaintech.retailscm.terminationreason.TerminationReasonDAO;
import com.doublechaintech.retailscm.accountset.AccountSetDAO;
import com.doublechaintech.retailscm.skilltype.SkillTypeDAO;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeDAO;
import com.doublechaintech.retailscm.catalog.CatalogDAO;
import com.doublechaintech.retailscm.employee.EmployeeDAO;
import com.doublechaintech.retailscm.instructor.InstructorDAO;
import com.doublechaintech.retailscm.warehouse.WarehouseDAO;
import com.doublechaintech.retailscm.leavetype.LeaveTypeDAO;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierDAO;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderDAO;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentDAO;
import com.doublechaintech.retailscm.occupationtype.OccupationTypeDAO;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeDAO;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterDAO;
import com.doublechaintech.retailscm.transportfleet.TransportFleetDAO;
import com.doublechaintech.retailscm.terminationtype.TerminationTypeDAO;
import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;
import com.doublechaintech.retailscm.interviewtype.InterviewTypeDAO;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class RetailStoreCountryCenterJDBCTemplateDAO extends RetailscmBaseDAOImpl implements RetailStoreCountryCenterDAO{

	protected CatalogDAO catalogDAO;
	public void setCatalogDAO(CatalogDAO catalogDAO){

 		if(catalogDAO == null){
 			throw new IllegalStateException("Do not try to set catalogDAO to null.");
 		}
	 	this.catalogDAO = catalogDAO;
 	}
 	public CatalogDAO getCatalogDAO(){
 		if(this.catalogDAO == null){
 			throw new IllegalStateException("The catalogDAO is not configured yet, please config it some where.");
 		}

	 	return this.catalogDAO;
 	}

	protected RetailStoreProvinceCenterDAO retailStoreProvinceCenterDAO;
	public void setRetailStoreProvinceCenterDAO(RetailStoreProvinceCenterDAO retailStoreProvinceCenterDAO){

 		if(retailStoreProvinceCenterDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreProvinceCenterDAO to null.");
 		}
	 	this.retailStoreProvinceCenterDAO = retailStoreProvinceCenterDAO;
 	}
 	public RetailStoreProvinceCenterDAO getRetailStoreProvinceCenterDAO(){
 		if(this.retailStoreProvinceCenterDAO == null){
 			throw new IllegalStateException("The retailStoreProvinceCenterDAO is not configured yet, please config it some where.");
 		}

	 	return this.retailStoreProvinceCenterDAO;
 	}

	protected RetailStoreDAO retailStoreDAO;
	public void setRetailStoreDAO(RetailStoreDAO retailStoreDAO){

 		if(retailStoreDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreDAO to null.");
 		}
	 	this.retailStoreDAO = retailStoreDAO;
 	}
 	public RetailStoreDAO getRetailStoreDAO(){
 		if(this.retailStoreDAO == null){
 			throw new IllegalStateException("The retailStoreDAO is not configured yet, please config it some where.");
 		}

	 	return this.retailStoreDAO;
 	}

	protected RetailStoreMemberDAO retailStoreMemberDAO;
	public void setRetailStoreMemberDAO(RetailStoreMemberDAO retailStoreMemberDAO){

 		if(retailStoreMemberDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreMemberDAO to null.");
 		}
	 	this.retailStoreMemberDAO = retailStoreMemberDAO;
 	}
 	public RetailStoreMemberDAO getRetailStoreMemberDAO(){
 		if(this.retailStoreMemberDAO == null){
 			throw new IllegalStateException("The retailStoreMemberDAO is not configured yet, please config it some where.");
 		}

	 	return this.retailStoreMemberDAO;
 	}

	protected GoodsSupplierDAO goodsSupplierDAO;
	public void setGoodsSupplierDAO(GoodsSupplierDAO goodsSupplierDAO){

 		if(goodsSupplierDAO == null){
 			throw new IllegalStateException("Do not try to set goodsSupplierDAO to null.");
 		}
	 	this.goodsSupplierDAO = goodsSupplierDAO;
 	}
 	public GoodsSupplierDAO getGoodsSupplierDAO(){
 		if(this.goodsSupplierDAO == null){
 			throw new IllegalStateException("The goodsSupplierDAO is not configured yet, please config it some where.");
 		}

	 	return this.goodsSupplierDAO;
 	}

	protected SupplyOrderDAO supplyOrderDAO;
	public void setSupplyOrderDAO(SupplyOrderDAO supplyOrderDAO){

 		if(supplyOrderDAO == null){
 			throw new IllegalStateException("Do not try to set supplyOrderDAO to null.");
 		}
	 	this.supplyOrderDAO = supplyOrderDAO;
 	}
 	public SupplyOrderDAO getSupplyOrderDAO(){
 		if(this.supplyOrderDAO == null){
 			throw new IllegalStateException("The supplyOrderDAO is not configured yet, please config it some where.");
 		}

	 	return this.supplyOrderDAO;
 	}

	protected RetailStoreOrderDAO retailStoreOrderDAO;
	public void setRetailStoreOrderDAO(RetailStoreOrderDAO retailStoreOrderDAO){

 		if(retailStoreOrderDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreOrderDAO to null.");
 		}
	 	this.retailStoreOrderDAO = retailStoreOrderDAO;
 	}
 	public RetailStoreOrderDAO getRetailStoreOrderDAO(){
 		if(this.retailStoreOrderDAO == null){
 			throw new IllegalStateException("The retailStoreOrderDAO is not configured yet, please config it some where.");
 		}

	 	return this.retailStoreOrderDAO;
 	}

	protected WarehouseDAO warehouseDAO;
	public void setWarehouseDAO(WarehouseDAO warehouseDAO){

 		if(warehouseDAO == null){
 			throw new IllegalStateException("Do not try to set warehouseDAO to null.");
 		}
	 	this.warehouseDAO = warehouseDAO;
 	}
 	public WarehouseDAO getWarehouseDAO(){
 		if(this.warehouseDAO == null){
 			throw new IllegalStateException("The warehouseDAO is not configured yet, please config it some where.");
 		}

	 	return this.warehouseDAO;
 	}

	protected TransportFleetDAO transportFleetDAO;
	public void setTransportFleetDAO(TransportFleetDAO transportFleetDAO){

 		if(transportFleetDAO == null){
 			throw new IllegalStateException("Do not try to set transportFleetDAO to null.");
 		}
	 	this.transportFleetDAO = transportFleetDAO;
 	}
 	public TransportFleetDAO getTransportFleetDAO(){
 		if(this.transportFleetDAO == null){
 			throw new IllegalStateException("The transportFleetDAO is not configured yet, please config it some where.");
 		}

	 	return this.transportFleetDAO;
 	}

	protected AccountSetDAO accountSetDAO;
	public void setAccountSetDAO(AccountSetDAO accountSetDAO){

 		if(accountSetDAO == null){
 			throw new IllegalStateException("Do not try to set accountSetDAO to null.");
 		}
	 	this.accountSetDAO = accountSetDAO;
 	}
 	public AccountSetDAO getAccountSetDAO(){
 		if(this.accountSetDAO == null){
 			throw new IllegalStateException("The accountSetDAO is not configured yet, please config it some where.");
 		}

	 	return this.accountSetDAO;
 	}

	protected LevelOneDepartmentDAO levelOneDepartmentDAO;
	public void setLevelOneDepartmentDAO(LevelOneDepartmentDAO levelOneDepartmentDAO){

 		if(levelOneDepartmentDAO == null){
 			throw new IllegalStateException("Do not try to set levelOneDepartmentDAO to null.");
 		}
	 	this.levelOneDepartmentDAO = levelOneDepartmentDAO;
 	}
 	public LevelOneDepartmentDAO getLevelOneDepartmentDAO(){
 		if(this.levelOneDepartmentDAO == null){
 			throw new IllegalStateException("The levelOneDepartmentDAO is not configured yet, please config it some where.");
 		}

	 	return this.levelOneDepartmentDAO;
 	}

	protected SkillTypeDAO skillTypeDAO;
	public void setSkillTypeDAO(SkillTypeDAO skillTypeDAO){

 		if(skillTypeDAO == null){
 			throw new IllegalStateException("Do not try to set skillTypeDAO to null.");
 		}
	 	this.skillTypeDAO = skillTypeDAO;
 	}
 	public SkillTypeDAO getSkillTypeDAO(){
 		if(this.skillTypeDAO == null){
 			throw new IllegalStateException("The skillTypeDAO is not configured yet, please config it some where.");
 		}

	 	return this.skillTypeDAO;
 	}

	protected ResponsibilityTypeDAO responsibilityTypeDAO;
	public void setResponsibilityTypeDAO(ResponsibilityTypeDAO responsibilityTypeDAO){

 		if(responsibilityTypeDAO == null){
 			throw new IllegalStateException("Do not try to set responsibilityTypeDAO to null.");
 		}
	 	this.responsibilityTypeDAO = responsibilityTypeDAO;
 	}
 	public ResponsibilityTypeDAO getResponsibilityTypeDAO(){
 		if(this.responsibilityTypeDAO == null){
 			throw new IllegalStateException("The responsibilityTypeDAO is not configured yet, please config it some where.");
 		}

	 	return this.responsibilityTypeDAO;
 	}

	protected TerminationReasonDAO terminationReasonDAO;
	public void setTerminationReasonDAO(TerminationReasonDAO terminationReasonDAO){

 		if(terminationReasonDAO == null){
 			throw new IllegalStateException("Do not try to set terminationReasonDAO to null.");
 		}
	 	this.terminationReasonDAO = terminationReasonDAO;
 	}
 	public TerminationReasonDAO getTerminationReasonDAO(){
 		if(this.terminationReasonDAO == null){
 			throw new IllegalStateException("The terminationReasonDAO is not configured yet, please config it some where.");
 		}

	 	return this.terminationReasonDAO;
 	}

	protected TerminationTypeDAO terminationTypeDAO;
	public void setTerminationTypeDAO(TerminationTypeDAO terminationTypeDAO){

 		if(terminationTypeDAO == null){
 			throw new IllegalStateException("Do not try to set terminationTypeDAO to null.");
 		}
	 	this.terminationTypeDAO = terminationTypeDAO;
 	}
 	public TerminationTypeDAO getTerminationTypeDAO(){
 		if(this.terminationTypeDAO == null){
 			throw new IllegalStateException("The terminationTypeDAO is not configured yet, please config it some where.");
 		}

	 	return this.terminationTypeDAO;
 	}

	protected OccupationTypeDAO occupationTypeDAO;
	public void setOccupationTypeDAO(OccupationTypeDAO occupationTypeDAO){

 		if(occupationTypeDAO == null){
 			throw new IllegalStateException("Do not try to set occupationTypeDAO to null.");
 		}
	 	this.occupationTypeDAO = occupationTypeDAO;
 	}
 	public OccupationTypeDAO getOccupationTypeDAO(){
 		if(this.occupationTypeDAO == null){
 			throw new IllegalStateException("The occupationTypeDAO is not configured yet, please config it some where.");
 		}

	 	return this.occupationTypeDAO;
 	}

	protected LeaveTypeDAO leaveTypeDAO;
	public void setLeaveTypeDAO(LeaveTypeDAO leaveTypeDAO){

 		if(leaveTypeDAO == null){
 			throw new IllegalStateException("Do not try to set leaveTypeDAO to null.");
 		}
	 	this.leaveTypeDAO = leaveTypeDAO;
 	}
 	public LeaveTypeDAO getLeaveTypeDAO(){
 		if(this.leaveTypeDAO == null){
 			throw new IllegalStateException("The leaveTypeDAO is not configured yet, please config it some where.");
 		}

	 	return this.leaveTypeDAO;
 	}

	protected SalaryGradeDAO salaryGradeDAO;
	public void setSalaryGradeDAO(SalaryGradeDAO salaryGradeDAO){

 		if(salaryGradeDAO == null){
 			throw new IllegalStateException("Do not try to set salaryGradeDAO to null.");
 		}
	 	this.salaryGradeDAO = salaryGradeDAO;
 	}
 	public SalaryGradeDAO getSalaryGradeDAO(){
 		if(this.salaryGradeDAO == null){
 			throw new IllegalStateException("The salaryGradeDAO is not configured yet, please config it some where.");
 		}

	 	return this.salaryGradeDAO;
 	}

	protected InterviewTypeDAO interviewTypeDAO;
	public void setInterviewTypeDAO(InterviewTypeDAO interviewTypeDAO){

 		if(interviewTypeDAO == null){
 			throw new IllegalStateException("Do not try to set interviewTypeDAO to null.");
 		}
	 	this.interviewTypeDAO = interviewTypeDAO;
 	}
 	public InterviewTypeDAO getInterviewTypeDAO(){
 		if(this.interviewTypeDAO == null){
 			throw new IllegalStateException("The interviewTypeDAO is not configured yet, please config it some where.");
 		}

	 	return this.interviewTypeDAO;
 	}

	protected TrainingCourseTypeDAO trainingCourseTypeDAO;
	public void setTrainingCourseTypeDAO(TrainingCourseTypeDAO trainingCourseTypeDAO){

 		if(trainingCourseTypeDAO == null){
 			throw new IllegalStateException("Do not try to set trainingCourseTypeDAO to null.");
 		}
	 	this.trainingCourseTypeDAO = trainingCourseTypeDAO;
 	}
 	public TrainingCourseTypeDAO getTrainingCourseTypeDAO(){
 		if(this.trainingCourseTypeDAO == null){
 			throw new IllegalStateException("The trainingCourseTypeDAO is not configured yet, please config it some where.");
 		}

	 	return this.trainingCourseTypeDAO;
 	}

	protected PublicHolidayDAO publicHolidayDAO;
	public void setPublicHolidayDAO(PublicHolidayDAO publicHolidayDAO){

 		if(publicHolidayDAO == null){
 			throw new IllegalStateException("Do not try to set publicHolidayDAO to null.");
 		}
	 	this.publicHolidayDAO = publicHolidayDAO;
 	}
 	public PublicHolidayDAO getPublicHolidayDAO(){
 		if(this.publicHolidayDAO == null){
 			throw new IllegalStateException("The publicHolidayDAO is not configured yet, please config it some where.");
 		}

	 	return this.publicHolidayDAO;
 	}

	protected EmployeeDAO employeeDAO;
	public void setEmployeeDAO(EmployeeDAO employeeDAO){

 		if(employeeDAO == null){
 			throw new IllegalStateException("Do not try to set employeeDAO to null.");
 		}
	 	this.employeeDAO = employeeDAO;
 	}
 	public EmployeeDAO getEmployeeDAO(){
 		if(this.employeeDAO == null){
 			throw new IllegalStateException("The employeeDAO is not configured yet, please config it some where.");
 		}

	 	return this.employeeDAO;
 	}

	protected InstructorDAO instructorDAO;
	public void setInstructorDAO(InstructorDAO instructorDAO){

 		if(instructorDAO == null){
 			throw new IllegalStateException("Do not try to set instructorDAO to null.");
 		}
	 	this.instructorDAO = instructorDAO;
 	}
 	public InstructorDAO getInstructorDAO(){
 		if(this.instructorDAO == null){
 			throw new IllegalStateException("The instructorDAO is not configured yet, please config it some where.");
 		}

	 	return this.instructorDAO;
 	}

	protected CompanyTrainingDAO companyTrainingDAO;
	public void setCompanyTrainingDAO(CompanyTrainingDAO companyTrainingDAO){

 		if(companyTrainingDAO == null){
 			throw new IllegalStateException("Do not try to set companyTrainingDAO to null.");
 		}
	 	this.companyTrainingDAO = companyTrainingDAO;
 	}
 	public CompanyTrainingDAO getCompanyTrainingDAO(){
 		if(this.companyTrainingDAO == null){
 			throw new IllegalStateException("The companyTrainingDAO is not configured yet, please config it some where.");
 		}

	 	return this.companyTrainingDAO;
 	}



	/*
	protected RetailStoreCountryCenter load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreCountryCenter(accessKey, options);
	}
	*/

	public SmartList<RetailStoreCountryCenter> loadAll() {
	    return this.loadAll(getRetailStoreCountryCenterMapper());
	}

  public Stream<RetailStoreCountryCenter> loadAllAsStream() {
      return this.loadAllAsStream(getRetailStoreCountryCenterMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public RetailStoreCountryCenter load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreCountryCenter(RetailStoreCountryCenterTable.withId(id), options);
	}

	

	public RetailStoreCountryCenter save(RetailStoreCountryCenter retailStoreCountryCenter,Map<String,Object> options){

		String methodName="save(RetailStoreCountryCenter retailStoreCountryCenter,Map<String,Object> options)";

		assertMethodArgumentNotNull(retailStoreCountryCenter, methodName, "retailStoreCountryCenter");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalRetailStoreCountryCenter(retailStoreCountryCenter,options);
	}
	public RetailStoreCountryCenter clone(String retailStoreCountryCenterId, Map<String,Object> options) throws Exception{

		return clone(RetailStoreCountryCenterTable.withId(retailStoreCountryCenterId),options);
	}

	protected RetailStoreCountryCenter clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String retailStoreCountryCenterId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		RetailStoreCountryCenter newRetailStoreCountryCenter = loadInternalRetailStoreCountryCenter(accessKey, options);
		newRetailStoreCountryCenter.setVersion(0);
		
		

 		if(isSaveCatalogListEnabled(options)){
 			for(Catalog item: newRetailStoreCountryCenter.getCatalogList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveRetailStoreProvinceCenterListEnabled(options)){
 			for(RetailStoreProvinceCenter item: newRetailStoreCountryCenter.getRetailStoreProvinceCenterList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveRetailStoreListEnabled(options)){
 			for(RetailStore item: newRetailStoreCountryCenter.getRetailStoreList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveRetailStoreMemberListEnabled(options)){
 			for(RetailStoreMember item: newRetailStoreCountryCenter.getRetailStoreMemberList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveGoodsSupplierListEnabled(options)){
 			for(GoodsSupplier item: newRetailStoreCountryCenter.getGoodsSupplierList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveSupplyOrderListEnabled(options)){
 			for(SupplyOrder item: newRetailStoreCountryCenter.getSupplyOrderList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveRetailStoreOrderListEnabled(options)){
 			for(RetailStoreOrder item: newRetailStoreCountryCenter.getRetailStoreOrderList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveWarehouseListEnabled(options)){
 			for(Warehouse item: newRetailStoreCountryCenter.getWarehouseList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveTransportFleetListEnabled(options)){
 			for(TransportFleet item: newRetailStoreCountryCenter.getTransportFleetList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveAccountSetListEnabled(options)){
 			for(AccountSet item: newRetailStoreCountryCenter.getAccountSetList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveLevelOneDepartmentListEnabled(options)){
 			for(LevelOneDepartment item: newRetailStoreCountryCenter.getLevelOneDepartmentList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveSkillTypeListEnabled(options)){
 			for(SkillType item: newRetailStoreCountryCenter.getSkillTypeList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveResponsibilityTypeListEnabled(options)){
 			for(ResponsibilityType item: newRetailStoreCountryCenter.getResponsibilityTypeList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveTerminationReasonListEnabled(options)){
 			for(TerminationReason item: newRetailStoreCountryCenter.getTerminationReasonList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveTerminationTypeListEnabled(options)){
 			for(TerminationType item: newRetailStoreCountryCenter.getTerminationTypeList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveOccupationTypeListEnabled(options)){
 			for(OccupationType item: newRetailStoreCountryCenter.getOccupationTypeList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveLeaveTypeListEnabled(options)){
 			for(LeaveType item: newRetailStoreCountryCenter.getLeaveTypeList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveSalaryGradeListEnabled(options)){
 			for(SalaryGrade item: newRetailStoreCountryCenter.getSalaryGradeList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveInterviewTypeListEnabled(options)){
 			for(InterviewType item: newRetailStoreCountryCenter.getInterviewTypeList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveTrainingCourseTypeListEnabled(options)){
 			for(TrainingCourseType item: newRetailStoreCountryCenter.getTrainingCourseTypeList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSavePublicHolidayListEnabled(options)){
 			for(PublicHoliday item: newRetailStoreCountryCenter.getPublicHolidayList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveEmployeeListEnabled(options)){
 			for(Employee item: newRetailStoreCountryCenter.getEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveInstructorListEnabled(options)){
 			for(Instructor item: newRetailStoreCountryCenter.getInstructorList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSaveCompanyTrainingListEnabled(options)){
 			for(CompanyTraining item: newRetailStoreCountryCenter.getCompanyTrainingList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalRetailStoreCountryCenter(newRetailStoreCountryCenter,options);

		return newRetailStoreCountryCenter;
	}

	



	protected void throwIfHasException(String retailStoreCountryCenterId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RetailStoreCountryCenterVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreCountryCenterNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreCountryCenterId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String retailStoreCountryCenterId, int version) throws Exception{

		String methodName="delete(String retailStoreCountryCenterId, int version)";
		assertMethodArgumentNotNull(retailStoreCountryCenterId, methodName, "retailStoreCountryCenterId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreCountryCenterId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreCountryCenterId,version);
		}


	}






	public RetailStoreCountryCenter disconnectFromAll(String retailStoreCountryCenterId, int version) throws Exception{


		RetailStoreCountryCenter retailStoreCountryCenter = loadInternalRetailStoreCountryCenter(RetailStoreCountryCenterTable.withId(retailStoreCountryCenterId), emptyOptions());
		retailStoreCountryCenter.clearFromAll();
		this.saveRetailStoreCountryCenter(retailStoreCountryCenter);
		return retailStoreCountryCenter;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return RetailStoreCountryCenterTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "retail_store_country_center";
	}
	@Override
	protected String getBeanName() {

		return "retailStoreCountryCenter";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return RetailStoreCountryCenterTokens.checkOptions(options, optionToCheck);

	}


		

	protected boolean isExtractCatalogListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.CATALOG_LIST);
 	}
 	protected boolean isAnalyzeCatalogListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeCatalogListEnabled();
 	}

	protected boolean isSaveCatalogListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.CATALOG_LIST);

 	}

		

	protected boolean isExtractRetailStoreProvinceCenterListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.RETAIL_STORE_PROVINCE_CENTER_LIST);
 	}
 	protected boolean isAnalyzeRetailStoreProvinceCenterListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeRetailStoreProvinceCenterListEnabled();
 	}

	protected boolean isSaveRetailStoreProvinceCenterListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.RETAIL_STORE_PROVINCE_CENTER_LIST);

 	}

		

	protected boolean isExtractRetailStoreListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.RETAIL_STORE_LIST);
 	}
 	protected boolean isAnalyzeRetailStoreListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeRetailStoreListEnabled();
 	}

	protected boolean isSaveRetailStoreListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.RETAIL_STORE_LIST);

 	}

		

	protected boolean isExtractRetailStoreMemberListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.RETAIL_STORE_MEMBER_LIST);
 	}
 	protected boolean isAnalyzeRetailStoreMemberListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeRetailStoreMemberListEnabled();
 	}

	protected boolean isSaveRetailStoreMemberListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.RETAIL_STORE_MEMBER_LIST);

 	}

		

	protected boolean isExtractGoodsSupplierListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.GOODS_SUPPLIER_LIST);
 	}
 	protected boolean isAnalyzeGoodsSupplierListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeGoodsSupplierListEnabled();
 	}

	protected boolean isSaveGoodsSupplierListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.GOODS_SUPPLIER_LIST);

 	}

		

	protected boolean isExtractSupplyOrderListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.SUPPLY_ORDER_LIST);
 	}
 	protected boolean isAnalyzeSupplyOrderListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeSupplyOrderListEnabled();
 	}

	protected boolean isSaveSupplyOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.SUPPLY_ORDER_LIST);

 	}

		

	protected boolean isExtractRetailStoreOrderListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.RETAIL_STORE_ORDER_LIST);
 	}
 	protected boolean isAnalyzeRetailStoreOrderListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeRetailStoreOrderListEnabled();
 	}

	protected boolean isSaveRetailStoreOrderListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.RETAIL_STORE_ORDER_LIST);

 	}

		

	protected boolean isExtractWarehouseListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.WAREHOUSE_LIST);
 	}
 	protected boolean isAnalyzeWarehouseListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeWarehouseListEnabled();
 	}

	protected boolean isSaveWarehouseListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.WAREHOUSE_LIST);

 	}

		

	protected boolean isExtractTransportFleetListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.TRANSPORT_FLEET_LIST);
 	}
 	protected boolean isAnalyzeTransportFleetListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeTransportFleetListEnabled();
 	}

	protected boolean isSaveTransportFleetListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.TRANSPORT_FLEET_LIST);

 	}

		

	protected boolean isExtractAccountSetListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.ACCOUNT_SET_LIST);
 	}
 	protected boolean isAnalyzeAccountSetListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeAccountSetListEnabled();
 	}

	protected boolean isSaveAccountSetListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.ACCOUNT_SET_LIST);

 	}

		

	protected boolean isExtractLevelOneDepartmentListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.LEVEL_ONE_DEPARTMENT_LIST);
 	}
 	protected boolean isAnalyzeLevelOneDepartmentListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeLevelOneDepartmentListEnabled();
 	}

	protected boolean isSaveLevelOneDepartmentListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.LEVEL_ONE_DEPARTMENT_LIST);

 	}

		

	protected boolean isExtractSkillTypeListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.SKILL_TYPE_LIST);
 	}
 	protected boolean isAnalyzeSkillTypeListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeSkillTypeListEnabled();
 	}

	protected boolean isSaveSkillTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.SKILL_TYPE_LIST);

 	}

		

	protected boolean isExtractResponsibilityTypeListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.RESPONSIBILITY_TYPE_LIST);
 	}
 	protected boolean isAnalyzeResponsibilityTypeListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeResponsibilityTypeListEnabled();
 	}

	protected boolean isSaveResponsibilityTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.RESPONSIBILITY_TYPE_LIST);

 	}

		

	protected boolean isExtractTerminationReasonListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.TERMINATION_REASON_LIST);
 	}
 	protected boolean isAnalyzeTerminationReasonListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeTerminationReasonListEnabled();
 	}

	protected boolean isSaveTerminationReasonListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.TERMINATION_REASON_LIST);

 	}

		

	protected boolean isExtractTerminationTypeListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.TERMINATION_TYPE_LIST);
 	}
 	protected boolean isAnalyzeTerminationTypeListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeTerminationTypeListEnabled();
 	}

	protected boolean isSaveTerminationTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.TERMINATION_TYPE_LIST);

 	}

		

	protected boolean isExtractOccupationTypeListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.OCCUPATION_TYPE_LIST);
 	}
 	protected boolean isAnalyzeOccupationTypeListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeOccupationTypeListEnabled();
 	}

	protected boolean isSaveOccupationTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.OCCUPATION_TYPE_LIST);

 	}

		

	protected boolean isExtractLeaveTypeListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.LEAVE_TYPE_LIST);
 	}
 	protected boolean isAnalyzeLeaveTypeListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeLeaveTypeListEnabled();
 	}

	protected boolean isSaveLeaveTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.LEAVE_TYPE_LIST);

 	}

		

	protected boolean isExtractSalaryGradeListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.SALARY_GRADE_LIST);
 	}
 	protected boolean isAnalyzeSalaryGradeListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeSalaryGradeListEnabled();
 	}

	protected boolean isSaveSalaryGradeListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.SALARY_GRADE_LIST);

 	}

		

	protected boolean isExtractInterviewTypeListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.INTERVIEW_TYPE_LIST);
 	}
 	protected boolean isAnalyzeInterviewTypeListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeInterviewTypeListEnabled();
 	}

	protected boolean isSaveInterviewTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.INTERVIEW_TYPE_LIST);

 	}

		

	protected boolean isExtractTrainingCourseTypeListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.TRAINING_COURSE_TYPE_LIST);
 	}
 	protected boolean isAnalyzeTrainingCourseTypeListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeTrainingCourseTypeListEnabled();
 	}

	protected boolean isSaveTrainingCourseTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.TRAINING_COURSE_TYPE_LIST);

 	}

		

	protected boolean isExtractPublicHolidayListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.PUBLIC_HOLIDAY_LIST);
 	}
 	protected boolean isAnalyzePublicHolidayListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzePublicHolidayListEnabled();
 	}

	protected boolean isSavePublicHolidayListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.PUBLIC_HOLIDAY_LIST);

 	}

		

	protected boolean isExtractEmployeeListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.EMPLOYEE_LIST);
 	}
 	protected boolean isAnalyzeEmployeeListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeEmployeeListEnabled();
 	}

	protected boolean isSaveEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.EMPLOYEE_LIST);

 	}

		

	protected boolean isExtractInstructorListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.INSTRUCTOR_LIST);
 	}
 	protected boolean isAnalyzeInstructorListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeInstructorListEnabled();
 	}

	protected boolean isSaveInstructorListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.INSTRUCTOR_LIST);

 	}

		

	protected boolean isExtractCompanyTrainingListEnabled(Map<String,Object> options){
 		return checkOptions(options,RetailStoreCountryCenterTokens.COMPANY_TRAINING_LIST);
 	}
 	protected boolean isAnalyzeCompanyTrainingListEnabled(Map<String,Object> options){
 		return RetailStoreCountryCenterTokens.of(options).analyzeCompanyTrainingListEnabled();
 	}

	protected boolean isSaveCompanyTrainingListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCountryCenterTokens.COMPANY_TRAINING_LIST);

 	}

		

	

	protected RetailStoreCountryCenterMapper getRetailStoreCountryCenterMapper(){
		return new RetailStoreCountryCenterMapper();
	}



	protected RetailStoreCountryCenter extractRetailStoreCountryCenter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RetailStoreCountryCenter retailStoreCountryCenter = loadSingleObject(accessKey, getRetailStoreCountryCenterMapper());
			return retailStoreCountryCenter;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreCountryCenterNotFoundException("RetailStoreCountryCenter("+accessKey+") is not found!");
		}

	}




	protected RetailStoreCountryCenter loadInternalRetailStoreCountryCenter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		RetailStoreCountryCenter retailStoreCountryCenter = extractRetailStoreCountryCenter(accessKey, loadOptions);

		
		if(isExtractCatalogListEnabled(loadOptions)){
	 		extractCatalogList(retailStoreCountryCenter, loadOptions);
 		}

 		
 		if(isAnalyzeCatalogListEnabled(loadOptions)){
	 		analyzeCatalogList(retailStoreCountryCenter, loadOptions);
 		}
 		
		
		if(isExtractRetailStoreProvinceCenterListEnabled(loadOptions)){
	 		extractRetailStoreProvinceCenterList(retailStoreCountryCenter, loadOptions);
 		}

 		
 		if(isAnalyzeRetailStoreProvinceCenterListEnabled(loadOptions)){
	 		analyzeRetailStoreProvinceCenterList(retailStoreCountryCenter, loadOptions);
 		}
 		
		
		if(isExtractRetailStoreListEnabled(loadOptions)){
	 		extractRetailStoreList(retailStoreCountryCenter, loadOptions);
 		}

 		
 		if(isAnalyzeRetailStoreListEnabled(loadOptions)){
	 		analyzeRetailStoreList(retailStoreCountryCenter, loadOptions);
 		}
 		
		
		if(isExtractRetailStoreMemberListEnabled(loadOptions)){
	 		extractRetailStoreMemberList(retailStoreCountryCenter, loadOptions);
 		}

 		
 		if(isAnalyzeRetailStoreMemberListEnabled(loadOptions)){
	 		analyzeRetailStoreMemberList(retailStoreCountryCenter, loadOptions);
 		}
 		
		
		if(isExtractGoodsSupplierListEnabled(loadOptions)){
	 		extractGoodsSupplierList(retailStoreCountryCenter, loadOptions);
 		}

 		
 		if(isAnalyzeGoodsSupplierListEnabled(loadOptions)){
	 		analyzeGoodsSupplierList(retailStoreCountryCenter, loadOptions);
 		}
 		
		
		if(isExtractSupplyOrderListEnabled(loadOptions)){
	 		extractSupplyOrderList(retailStoreCountryCenter, loadOptions);
 		}

 		
 		if(isAnalyzeSupplyOrderListEnabled(loadOptions)){
	 		analyzeSupplyOrderList(retailStoreCountryCenter, loadOptions);
 		}
 		
		
		if(isExtractRetailStoreOrderListEnabled(loadOptions)){
	 		extractRetailStoreOrderList(retailStoreCountryCenter, loadOptions);
 		}

 		
 		if(isAnalyzeRetailStoreOrderListEnabled(loadOptions)){
	 		analyzeRetailStoreOrderList(retailStoreCountryCenter, loadOptions);
 		}
 		
		
		if(isExtractWarehouseListEnabled(loadOptions)){
	 		extractWarehouseList(retailStoreCountryCenter, loadOptions);
 		}

 		
 		if(isAnalyzeWarehouseListEnabled(loadOptions)){
	 		analyzeWarehouseList(retailStoreCountryCenter, loadOptions);
 		}
 		
		
		if(isExtractTransportFleetListEnabled(loadOptions)){
	 		extractTransportFleetList(retailStoreCountryCenter, loadOptions);
 		}

 		
 		if(isAnalyzeTransportFleetListEnabled(loadOptions)){
	 		analyzeTransportFleetList(retailStoreCountryCenter, loadOptions);
 		}
 		
		
		if(isExtractAccountSetListEnabled(loadOptions)){
	 		extractAccountSetList(retailStoreCountryCenter, loadOptions);
 		}

 		
 		if(isAnalyzeAccountSetListEnabled(loadOptions)){
	 		analyzeAccountSetList(retailStoreCountryCenter, loadOptions);
 		}
 		
		
		if(isExtractLevelOneDepartmentListEnabled(loadOptions)){
	 		extractLevelOneDepartmentList(retailStoreCountryCenter, loadOptions);
 		}

 		
 		if(isAnalyzeLevelOneDepartmentListEnabled(loadOptions)){
	 		analyzeLevelOneDepartmentList(retailStoreCountryCenter, loadOptions);
 		}
 		
		
		if(isExtractSkillTypeListEnabled(loadOptions)){
	 		extractSkillTypeList(retailStoreCountryCenter, loadOptions);
 		}

 		
		
		if(isExtractResponsibilityTypeListEnabled(loadOptions)){
	 		extractResponsibilityTypeList(retailStoreCountryCenter, loadOptions);
 		}

 		
		
		if(isExtractTerminationReasonListEnabled(loadOptions)){
	 		extractTerminationReasonList(retailStoreCountryCenter, loadOptions);
 		}

 		
		
		if(isExtractTerminationTypeListEnabled(loadOptions)){
	 		extractTerminationTypeList(retailStoreCountryCenter, loadOptions);
 		}

 		
		
		if(isExtractOccupationTypeListEnabled(loadOptions)){
	 		extractOccupationTypeList(retailStoreCountryCenter, loadOptions);
 		}

 		
		
		if(isExtractLeaveTypeListEnabled(loadOptions)){
	 		extractLeaveTypeList(retailStoreCountryCenter, loadOptions);
 		}

 		
		
		if(isExtractSalaryGradeListEnabled(loadOptions)){
	 		extractSalaryGradeList(retailStoreCountryCenter, loadOptions);
 		}

 		
		
		if(isExtractInterviewTypeListEnabled(loadOptions)){
	 		extractInterviewTypeList(retailStoreCountryCenter, loadOptions);
 		}

 		
		
		if(isExtractTrainingCourseTypeListEnabled(loadOptions)){
	 		extractTrainingCourseTypeList(retailStoreCountryCenter, loadOptions);
 		}

 		
		
		if(isExtractPublicHolidayListEnabled(loadOptions)){
	 		extractPublicHolidayList(retailStoreCountryCenter, loadOptions);
 		}

 		
		
		if(isExtractEmployeeListEnabled(loadOptions)){
	 		extractEmployeeList(retailStoreCountryCenter, loadOptions);
 		}

 		
 		if(isAnalyzeEmployeeListEnabled(loadOptions)){
	 		analyzeEmployeeList(retailStoreCountryCenter, loadOptions);
 		}
 		
		
		if(isExtractInstructorListEnabled(loadOptions)){
	 		extractInstructorList(retailStoreCountryCenter, loadOptions);
 		}

 		
 		if(isAnalyzeInstructorListEnabled(loadOptions)){
	 		analyzeInstructorList(retailStoreCountryCenter, loadOptions);
 		}
 		
		
		if(isExtractCompanyTrainingListEnabled(loadOptions)){
	 		extractCompanyTrainingList(retailStoreCountryCenter, loadOptions);
 		}

 		
 		if(isAnalyzeCompanyTrainingListEnabled(loadOptions)){
	 		analyzeCompanyTrainingList(retailStoreCountryCenter, loadOptions);
 		}
 		
		
		return retailStoreCountryCenter;

	}

	
		
	protected void enhanceCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractCatalogList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<Catalog> catalogList = getCatalogDAO().findCatalogByOwner(retailStoreCountryCenter.getId(),options);
		if(catalogList != null){
			enhanceCatalogList(catalogList,options);
			retailStoreCountryCenter.setCatalogList(catalogList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeCatalogList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<Catalog> catalogList = retailStoreCountryCenter.getCatalogList();
		if(catalogList != null){
			getCatalogDAO().analyzeCatalogByOwner(catalogList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceRetailStoreProvinceCenterList(SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractRetailStoreProvinceCenterList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList = getRetailStoreProvinceCenterDAO().findRetailStoreProvinceCenterByCountry(retailStoreCountryCenter.getId(),options);
		if(retailStoreProvinceCenterList != null){
			enhanceRetailStoreProvinceCenterList(retailStoreProvinceCenterList,options);
			retailStoreCountryCenter.setRetailStoreProvinceCenterList(retailStoreProvinceCenterList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeRetailStoreProvinceCenterList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList = retailStoreCountryCenter.getRetailStoreProvinceCenterList();
		if(retailStoreProvinceCenterList != null){
			getRetailStoreProvinceCenterDAO().analyzeRetailStoreProvinceCenterByCountry(retailStoreProvinceCenterList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceRetailStoreList(SmartList<RetailStore> retailStoreList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractRetailStoreList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<RetailStore> retailStoreList = getRetailStoreDAO().findRetailStoreByRetailStoreCountryCenter(retailStoreCountryCenter.getId(),options);
		if(retailStoreList != null){
			enhanceRetailStoreList(retailStoreList,options);
			retailStoreCountryCenter.setRetailStoreList(retailStoreList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeRetailStoreList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<RetailStore> retailStoreList = retailStoreCountryCenter.getRetailStoreList();
		if(retailStoreList != null){
			getRetailStoreDAO().analyzeRetailStoreByRetailStoreCountryCenter(retailStoreList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceRetailStoreMemberList(SmartList<RetailStoreMember> retailStoreMemberList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractRetailStoreMemberList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<RetailStoreMember> retailStoreMemberList = getRetailStoreMemberDAO().findRetailStoreMemberByOwner(retailStoreCountryCenter.getId(),options);
		if(retailStoreMemberList != null){
			enhanceRetailStoreMemberList(retailStoreMemberList,options);
			retailStoreCountryCenter.setRetailStoreMemberList(retailStoreMemberList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeRetailStoreMemberList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<RetailStoreMember> retailStoreMemberList = retailStoreCountryCenter.getRetailStoreMemberList();
		if(retailStoreMemberList != null){
			getRetailStoreMemberDAO().analyzeRetailStoreMemberByOwner(retailStoreMemberList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceGoodsSupplierList(SmartList<GoodsSupplier> goodsSupplierList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractGoodsSupplierList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<GoodsSupplier> goodsSupplierList = getGoodsSupplierDAO().findGoodsSupplierByBelongTo(retailStoreCountryCenter.getId(),options);
		if(goodsSupplierList != null){
			enhanceGoodsSupplierList(goodsSupplierList,options);
			retailStoreCountryCenter.setGoodsSupplierList(goodsSupplierList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeGoodsSupplierList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<GoodsSupplier> goodsSupplierList = retailStoreCountryCenter.getGoodsSupplierList();
		if(goodsSupplierList != null){
			getGoodsSupplierDAO().analyzeGoodsSupplierByBelongTo(goodsSupplierList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceSupplyOrderList(SmartList<SupplyOrder> supplyOrderList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractSupplyOrderList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<SupplyOrder> supplyOrderList = getSupplyOrderDAO().findSupplyOrderByBuyer(retailStoreCountryCenter.getId(),options);
		if(supplyOrderList != null){
			enhanceSupplyOrderList(supplyOrderList,options);
			retailStoreCountryCenter.setSupplyOrderList(supplyOrderList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeSupplyOrderList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<SupplyOrder> supplyOrderList = retailStoreCountryCenter.getSupplyOrderList();
		if(supplyOrderList != null){
			getSupplyOrderDAO().analyzeSupplyOrderByBuyer(supplyOrderList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractRetailStoreOrderList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<RetailStoreOrder> retailStoreOrderList = getRetailStoreOrderDAO().findRetailStoreOrderBySeller(retailStoreCountryCenter.getId(),options);
		if(retailStoreOrderList != null){
			enhanceRetailStoreOrderList(retailStoreOrderList,options);
			retailStoreCountryCenter.setRetailStoreOrderList(retailStoreOrderList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeRetailStoreOrderList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreCountryCenter.getRetailStoreOrderList();
		if(retailStoreOrderList != null){
			getRetailStoreOrderDAO().analyzeRetailStoreOrderBySeller(retailStoreOrderList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceWarehouseList(SmartList<Warehouse> warehouseList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractWarehouseList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<Warehouse> warehouseList = getWarehouseDAO().findWarehouseByOwner(retailStoreCountryCenter.getId(),options);
		if(warehouseList != null){
			enhanceWarehouseList(warehouseList,options);
			retailStoreCountryCenter.setWarehouseList(warehouseList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeWarehouseList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<Warehouse> warehouseList = retailStoreCountryCenter.getWarehouseList();
		if(warehouseList != null){
			getWarehouseDAO().analyzeWarehouseByOwner(warehouseList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceTransportFleetList(SmartList<TransportFleet> transportFleetList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractTransportFleetList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<TransportFleet> transportFleetList = getTransportFleetDAO().findTransportFleetByOwner(retailStoreCountryCenter.getId(),options);
		if(transportFleetList != null){
			enhanceTransportFleetList(transportFleetList,options);
			retailStoreCountryCenter.setTransportFleetList(transportFleetList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeTransportFleetList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<TransportFleet> transportFleetList = retailStoreCountryCenter.getTransportFleetList();
		if(transportFleetList != null){
			getTransportFleetDAO().analyzeTransportFleetByOwner(transportFleetList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceAccountSetList(SmartList<AccountSet> accountSetList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractAccountSetList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<AccountSet> accountSetList = getAccountSetDAO().findAccountSetByCountryCenter(retailStoreCountryCenter.getId(),options);
		if(accountSetList != null){
			enhanceAccountSetList(accountSetList,options);
			retailStoreCountryCenter.setAccountSetList(accountSetList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeAccountSetList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<AccountSet> accountSetList = retailStoreCountryCenter.getAccountSetList();
		if(accountSetList != null){
			getAccountSetDAO().analyzeAccountSetByCountryCenter(accountSetList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceLevelOneDepartmentList(SmartList<LevelOneDepartment> levelOneDepartmentList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractLevelOneDepartmentList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<LevelOneDepartment> levelOneDepartmentList = getLevelOneDepartmentDAO().findLevelOneDepartmentByBelongsTo(retailStoreCountryCenter.getId(),options);
		if(levelOneDepartmentList != null){
			enhanceLevelOneDepartmentList(levelOneDepartmentList,options);
			retailStoreCountryCenter.setLevelOneDepartmentList(levelOneDepartmentList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeLevelOneDepartmentList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<LevelOneDepartment> levelOneDepartmentList = retailStoreCountryCenter.getLevelOneDepartmentList();
		if(levelOneDepartmentList != null){
			getLevelOneDepartmentDAO().analyzeLevelOneDepartmentByBelongsTo(levelOneDepartmentList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceSkillTypeList(SmartList<SkillType> skillTypeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractSkillTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<SkillType> skillTypeList = getSkillTypeDAO().findSkillTypeByCompany(retailStoreCountryCenter.getId(),options);
		if(skillTypeList != null){
			enhanceSkillTypeList(skillTypeList,options);
			retailStoreCountryCenter.setSkillTypeList(skillTypeList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeSkillTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<SkillType> skillTypeList = retailStoreCountryCenter.getSkillTypeList();
		if(skillTypeList != null){
			getSkillTypeDAO().analyzeSkillTypeByCompany(skillTypeList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceResponsibilityTypeList(SmartList<ResponsibilityType> responsibilityTypeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractResponsibilityTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<ResponsibilityType> responsibilityTypeList = getResponsibilityTypeDAO().findResponsibilityTypeByCompany(retailStoreCountryCenter.getId(),options);
		if(responsibilityTypeList != null){
			enhanceResponsibilityTypeList(responsibilityTypeList,options);
			retailStoreCountryCenter.setResponsibilityTypeList(responsibilityTypeList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeResponsibilityTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<ResponsibilityType> responsibilityTypeList = retailStoreCountryCenter.getResponsibilityTypeList();
		if(responsibilityTypeList != null){
			getResponsibilityTypeDAO().analyzeResponsibilityTypeByCompany(responsibilityTypeList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceTerminationReasonList(SmartList<TerminationReason> terminationReasonList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractTerminationReasonList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<TerminationReason> terminationReasonList = getTerminationReasonDAO().findTerminationReasonByCompany(retailStoreCountryCenter.getId(),options);
		if(terminationReasonList != null){
			enhanceTerminationReasonList(terminationReasonList,options);
			retailStoreCountryCenter.setTerminationReasonList(terminationReasonList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeTerminationReasonList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<TerminationReason> terminationReasonList = retailStoreCountryCenter.getTerminationReasonList();
		if(terminationReasonList != null){
			getTerminationReasonDAO().analyzeTerminationReasonByCompany(terminationReasonList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceTerminationTypeList(SmartList<TerminationType> terminationTypeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractTerminationTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<TerminationType> terminationTypeList = getTerminationTypeDAO().findTerminationTypeByCompany(retailStoreCountryCenter.getId(),options);
		if(terminationTypeList != null){
			enhanceTerminationTypeList(terminationTypeList,options);
			retailStoreCountryCenter.setTerminationTypeList(terminationTypeList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeTerminationTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<TerminationType> terminationTypeList = retailStoreCountryCenter.getTerminationTypeList();
		if(terminationTypeList != null){
			getTerminationTypeDAO().analyzeTerminationTypeByCompany(terminationTypeList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceOccupationTypeList(SmartList<OccupationType> occupationTypeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractOccupationTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<OccupationType> occupationTypeList = getOccupationTypeDAO().findOccupationTypeByCompany(retailStoreCountryCenter.getId(),options);
		if(occupationTypeList != null){
			enhanceOccupationTypeList(occupationTypeList,options);
			retailStoreCountryCenter.setOccupationTypeList(occupationTypeList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeOccupationTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<OccupationType> occupationTypeList = retailStoreCountryCenter.getOccupationTypeList();
		if(occupationTypeList != null){
			getOccupationTypeDAO().analyzeOccupationTypeByCompany(occupationTypeList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceLeaveTypeList(SmartList<LeaveType> leaveTypeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractLeaveTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<LeaveType> leaveTypeList = getLeaveTypeDAO().findLeaveTypeByCompany(retailStoreCountryCenter.getId(),options);
		if(leaveTypeList != null){
			enhanceLeaveTypeList(leaveTypeList,options);
			retailStoreCountryCenter.setLeaveTypeList(leaveTypeList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeLeaveTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<LeaveType> leaveTypeList = retailStoreCountryCenter.getLeaveTypeList();
		if(leaveTypeList != null){
			getLeaveTypeDAO().analyzeLeaveTypeByCompany(leaveTypeList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceSalaryGradeList(SmartList<SalaryGrade> salaryGradeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractSalaryGradeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<SalaryGrade> salaryGradeList = getSalaryGradeDAO().findSalaryGradeByCompany(retailStoreCountryCenter.getId(),options);
		if(salaryGradeList != null){
			enhanceSalaryGradeList(salaryGradeList,options);
			retailStoreCountryCenter.setSalaryGradeList(salaryGradeList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeSalaryGradeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<SalaryGrade> salaryGradeList = retailStoreCountryCenter.getSalaryGradeList();
		if(salaryGradeList != null){
			getSalaryGradeDAO().analyzeSalaryGradeByCompany(salaryGradeList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceInterviewTypeList(SmartList<InterviewType> interviewTypeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractInterviewTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<InterviewType> interviewTypeList = getInterviewTypeDAO().findInterviewTypeByCompany(retailStoreCountryCenter.getId(),options);
		if(interviewTypeList != null){
			enhanceInterviewTypeList(interviewTypeList,options);
			retailStoreCountryCenter.setInterviewTypeList(interviewTypeList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeInterviewTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<InterviewType> interviewTypeList = retailStoreCountryCenter.getInterviewTypeList();
		if(interviewTypeList != null){
			getInterviewTypeDAO().analyzeInterviewTypeByCompany(interviewTypeList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceTrainingCourseTypeList(SmartList<TrainingCourseType> trainingCourseTypeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractTrainingCourseTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<TrainingCourseType> trainingCourseTypeList = getTrainingCourseTypeDAO().findTrainingCourseTypeByCompany(retailStoreCountryCenter.getId(),options);
		if(trainingCourseTypeList != null){
			enhanceTrainingCourseTypeList(trainingCourseTypeList,options);
			retailStoreCountryCenter.setTrainingCourseTypeList(trainingCourseTypeList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeTrainingCourseTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<TrainingCourseType> trainingCourseTypeList = retailStoreCountryCenter.getTrainingCourseTypeList();
		if(trainingCourseTypeList != null){
			getTrainingCourseTypeDAO().analyzeTrainingCourseTypeByCompany(trainingCourseTypeList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhancePublicHolidayList(SmartList<PublicHoliday> publicHolidayList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractPublicHolidayList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<PublicHoliday> publicHolidayList = getPublicHolidayDAO().findPublicHolidayByCompany(retailStoreCountryCenter.getId(),options);
		if(publicHolidayList != null){
			enhancePublicHolidayList(publicHolidayList,options);
			retailStoreCountryCenter.setPublicHolidayList(publicHolidayList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzePublicHolidayList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<PublicHoliday> publicHolidayList = retailStoreCountryCenter.getPublicHolidayList();
		if(publicHolidayList != null){
			getPublicHolidayDAO().analyzePublicHolidayByCompany(publicHolidayList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceEmployeeList(SmartList<Employee> employeeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractEmployeeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<Employee> employeeList = getEmployeeDAO().findEmployeeByCompany(retailStoreCountryCenter.getId(),options);
		if(employeeList != null){
			enhanceEmployeeList(employeeList,options);
			retailStoreCountryCenter.setEmployeeList(employeeList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeEmployeeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<Employee> employeeList = retailStoreCountryCenter.getEmployeeList();
		if(employeeList != null){
			getEmployeeDAO().analyzeEmployeeByCompany(employeeList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceInstructorList(SmartList<Instructor> instructorList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractInstructorList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<Instructor> instructorList = getInstructorDAO().findInstructorByCompany(retailStoreCountryCenter.getId(),options);
		if(instructorList != null){
			enhanceInstructorList(instructorList,options);
			retailStoreCountryCenter.setInstructorList(instructorList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeInstructorList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<Instructor> instructorList = retailStoreCountryCenter.getInstructorList();
		if(instructorList != null){
			getInstructorDAO().analyzeInstructorByCompany(instructorList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		
	protected void enhanceCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected RetailStoreCountryCenter extractCompanyTrainingList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    

		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<CompanyTraining> companyTrainingList = getCompanyTrainingDAO().findCompanyTrainingByCompany(retailStoreCountryCenter.getId(),options);
		if(companyTrainingList != null){
			enhanceCompanyTrainingList(companyTrainingList,options);
			retailStoreCountryCenter.setCompanyTrainingList(companyTrainingList);
		}

		return retailStoreCountryCenter;
  
	}

	protected RetailStoreCountryCenter analyzeCompanyTrainingList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
     
		if(retailStoreCountryCenter == null){
			return null;
		}
		if(retailStoreCountryCenter.getId() == null){
			return retailStoreCountryCenter;
		}



		SmartList<CompanyTraining> companyTrainingList = retailStoreCountryCenter.getCompanyTrainingList();
		if(companyTrainingList != null){
			getCompanyTrainingDAO().analyzeCompanyTrainingByCompany(companyTrainingList, retailStoreCountryCenter.getId(), options);

		}

		return retailStoreCountryCenter;
    
	}

		

 




	

	protected RetailStoreCountryCenter saveRetailStoreCountryCenter(RetailStoreCountryCenter  retailStoreCountryCenter){
    

		
		if(!retailStoreCountryCenter.isChanged()){
			return retailStoreCountryCenter;
		}
		

    Beans.dbUtil().cacheCleanUp(retailStoreCountryCenter);
		String SQL=this.getSaveRetailStoreCountryCenterSQL(retailStoreCountryCenter);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreCountryCenterParameters(retailStoreCountryCenter);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		retailStoreCountryCenter.incVersion();
		retailStoreCountryCenter.afterSave();
		return retailStoreCountryCenter;

	}
	public SmartList<RetailStoreCountryCenter> saveRetailStoreCountryCenterList(SmartList<RetailStoreCountryCenter> retailStoreCountryCenterList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreCountryCenterList(retailStoreCountryCenterList);

		batchRetailStoreCountryCenterCreate((List<RetailStoreCountryCenter>)lists[CREATE_LIST_INDEX]);

		batchRetailStoreCountryCenterUpdate((List<RetailStoreCountryCenter>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(RetailStoreCountryCenter retailStoreCountryCenter:retailStoreCountryCenterList){
			if(retailStoreCountryCenter.isChanged()){
				retailStoreCountryCenter.incVersion();
				retailStoreCountryCenter.afterSave();
			}


		}


		return retailStoreCountryCenterList;
	}

	public SmartList<RetailStoreCountryCenter> removeRetailStoreCountryCenterList(SmartList<RetailStoreCountryCenter> retailStoreCountryCenterList,Map<String,Object> options){


		super.removeList(retailStoreCountryCenterList, options);

		return retailStoreCountryCenterList;


	}

	protected List<Object[]> prepareRetailStoreCountryCenterBatchCreateArgs(List<RetailStoreCountryCenter> retailStoreCountryCenterList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreCountryCenter retailStoreCountryCenter:retailStoreCountryCenterList ){
			Object [] parameters = prepareRetailStoreCountryCenterCreateParameters(retailStoreCountryCenter);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareRetailStoreCountryCenterBatchUpdateArgs(List<RetailStoreCountryCenter> retailStoreCountryCenterList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreCountryCenter retailStoreCountryCenter:retailStoreCountryCenterList ){
			if(!retailStoreCountryCenter.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreCountryCenterUpdateParameters(retailStoreCountryCenter);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchRetailStoreCountryCenterCreate(List<RetailStoreCountryCenter> retailStoreCountryCenterList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreCountryCenterBatchCreateArgs(retailStoreCountryCenterList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchRetailStoreCountryCenterUpdate(List<RetailStoreCountryCenter> retailStoreCountryCenterList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreCountryCenterBatchUpdateArgs(retailStoreCountryCenterList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitRetailStoreCountryCenterList(List<RetailStoreCountryCenter> retailStoreCountryCenterList){

		List<RetailStoreCountryCenter> retailStoreCountryCenterCreateList=new ArrayList<RetailStoreCountryCenter>();
		List<RetailStoreCountryCenter> retailStoreCountryCenterUpdateList=new ArrayList<RetailStoreCountryCenter>();

		for(RetailStoreCountryCenter retailStoreCountryCenter: retailStoreCountryCenterList){
			if(isUpdateRequest(retailStoreCountryCenter)){
				retailStoreCountryCenterUpdateList.add( retailStoreCountryCenter);
				continue;
			}
			retailStoreCountryCenterCreateList.add(retailStoreCountryCenter);
		}

		return new Object[]{retailStoreCountryCenterCreateList,retailStoreCountryCenterUpdateList};
	}

	protected boolean isUpdateRequest(RetailStoreCountryCenter retailStoreCountryCenter){
 		return retailStoreCountryCenter.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreCountryCenterSQL(RetailStoreCountryCenter retailStoreCountryCenter){
 		if(isUpdateRequest(retailStoreCountryCenter)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveRetailStoreCountryCenterParameters(RetailStoreCountryCenter retailStoreCountryCenter){
 		if(isUpdateRequest(retailStoreCountryCenter) ){
 			return prepareRetailStoreCountryCenterUpdateParameters(retailStoreCountryCenter);
 		}
 		return prepareRetailStoreCountryCenterCreateParameters(retailStoreCountryCenter);
 	}
 	protected Object[] prepareRetailStoreCountryCenterUpdateParameters(RetailStoreCountryCenter retailStoreCountryCenter){
 		Object[] parameters = new Object[11];
 
 		parameters[0] = retailStoreCountryCenter.getName();
 		
 		parameters[1] = retailStoreCountryCenter.getServiceNumber();
 		
 		parameters[2] = retailStoreCountryCenter.getFounded();
 		
 		parameters[3] = retailStoreCountryCenter.getWebSite();
 		
 		parameters[4] = retailStoreCountryCenter.getAddress();
 		
 		parameters[5] = retailStoreCountryCenter.getOperatedBy();
 		
 		parameters[6] = retailStoreCountryCenter.getLegalRepresentative();
 		
 		parameters[7] = retailStoreCountryCenter.getDescription();
 		
 		parameters[8] = retailStoreCountryCenter.nextVersion();
 		parameters[9] = retailStoreCountryCenter.getId();
 		parameters[10] = retailStoreCountryCenter.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareRetailStoreCountryCenterCreateParameters(RetailStoreCountryCenter retailStoreCountryCenter){
		Object[] parameters = new Object[9];
        if(retailStoreCountryCenter.getId() == null){
          String newRetailStoreCountryCenterId=getNextId();
          retailStoreCountryCenter.setId(newRetailStoreCountryCenterId);
        }
		parameters[0] =  retailStoreCountryCenter.getId();
 
 		parameters[1] = retailStoreCountryCenter.getName();
 		
 		parameters[2] = retailStoreCountryCenter.getServiceNumber();
 		
 		parameters[3] = retailStoreCountryCenter.getFounded();
 		
 		parameters[4] = retailStoreCountryCenter.getWebSite();
 		
 		parameters[5] = retailStoreCountryCenter.getAddress();
 		
 		parameters[6] = retailStoreCountryCenter.getOperatedBy();
 		
 		parameters[7] = retailStoreCountryCenter.getLegalRepresentative();
 		
 		parameters[8] = retailStoreCountryCenter.getDescription();
 		

 		return parameters;
 	}

	protected RetailStoreCountryCenter saveInternalRetailStoreCountryCenter(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){

   saveRetailStoreCountryCenter(retailStoreCountryCenter);
		
		if(isSaveCatalogListEnabled(options)){
	 		saveCatalogList(retailStoreCountryCenter, options);
	 		//removeCatalogList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveRetailStoreProvinceCenterListEnabled(options)){
	 		saveRetailStoreProvinceCenterList(retailStoreCountryCenter, options);
	 		//removeRetailStoreProvinceCenterList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveRetailStoreListEnabled(options)){
	 		saveRetailStoreList(retailStoreCountryCenter, options);
	 		//removeRetailStoreList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveRetailStoreMemberListEnabled(options)){
	 		saveRetailStoreMemberList(retailStoreCountryCenter, options);
	 		//removeRetailStoreMemberList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveGoodsSupplierListEnabled(options)){
	 		saveGoodsSupplierList(retailStoreCountryCenter, options);
	 		//removeGoodsSupplierList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveSupplyOrderListEnabled(options)){
	 		saveSupplyOrderList(retailStoreCountryCenter, options);
	 		//removeSupplyOrderList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveRetailStoreOrderListEnabled(options)){
	 		saveRetailStoreOrderList(retailStoreCountryCenter, options);
	 		//removeRetailStoreOrderList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveWarehouseListEnabled(options)){
	 		saveWarehouseList(retailStoreCountryCenter, options);
	 		//removeWarehouseList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveTransportFleetListEnabled(options)){
	 		saveTransportFleetList(retailStoreCountryCenter, options);
	 		//removeTransportFleetList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveAccountSetListEnabled(options)){
	 		saveAccountSetList(retailStoreCountryCenter, options);
	 		//removeAccountSetList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveLevelOneDepartmentListEnabled(options)){
	 		saveLevelOneDepartmentList(retailStoreCountryCenter, options);
	 		//removeLevelOneDepartmentList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveSkillTypeListEnabled(options)){
	 		saveSkillTypeList(retailStoreCountryCenter, options);
	 		//removeSkillTypeList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveResponsibilityTypeListEnabled(options)){
	 		saveResponsibilityTypeList(retailStoreCountryCenter, options);
	 		//removeResponsibilityTypeList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveTerminationReasonListEnabled(options)){
	 		saveTerminationReasonList(retailStoreCountryCenter, options);
	 		//removeTerminationReasonList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveTerminationTypeListEnabled(options)){
	 		saveTerminationTypeList(retailStoreCountryCenter, options);
	 		//removeTerminationTypeList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveOccupationTypeListEnabled(options)){
	 		saveOccupationTypeList(retailStoreCountryCenter, options);
	 		//removeOccupationTypeList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveLeaveTypeListEnabled(options)){
	 		saveLeaveTypeList(retailStoreCountryCenter, options);
	 		//removeLeaveTypeList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveSalaryGradeListEnabled(options)){
	 		saveSalaryGradeList(retailStoreCountryCenter, options);
	 		//removeSalaryGradeList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveInterviewTypeListEnabled(options)){
	 		saveInterviewTypeList(retailStoreCountryCenter, options);
	 		//removeInterviewTypeList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveTrainingCourseTypeListEnabled(options)){
	 		saveTrainingCourseTypeList(retailStoreCountryCenter, options);
	 		//removeTrainingCourseTypeList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSavePublicHolidayListEnabled(options)){
	 		savePublicHolidayList(retailStoreCountryCenter, options);
	 		//removePublicHolidayList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveEmployeeListEnabled(options)){
	 		saveEmployeeList(retailStoreCountryCenter, options);
	 		//removeEmployeeList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveInstructorListEnabled(options)){
	 		saveInstructorList(retailStoreCountryCenter, options);
	 		//removeInstructorList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		if(isSaveCompanyTrainingListEnabled(options)){
	 		saveCompanyTrainingList(retailStoreCountryCenter, options);
	 		//removeCompanyTrainingList(retailStoreCountryCenter, options);
	 		//Not delete the record

 		}
		
		return retailStoreCountryCenter;

	}



	//======================================================================================
	

	
	public RetailStoreCountryCenter planToRemoveCatalogList(RetailStoreCountryCenter retailStoreCountryCenter, String catalogIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Catalog.OWNER_PROPERTY, retailStoreCountryCenter.getId());
		key.put(Catalog.ID_PROPERTY, catalogIds);

		SmartList<Catalog> externalCatalogList = getCatalogDAO().
				findCatalogWithKey(key, options);
		if(externalCatalogList == null){
			return retailStoreCountryCenter;
		}
		if(externalCatalogList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(Catalog catalogItem: externalCatalogList){

			catalogItem.clearFromAll();
		}


		SmartList<Catalog> catalogList = retailStoreCountryCenter.getCatalogList();
		catalogList.addAllToRemoveList(externalCatalogList);
		return retailStoreCountryCenter;

	}


	public RetailStoreCountryCenter planToRemoveRetailStoreProvinceCenterList(RetailStoreCountryCenter retailStoreCountryCenter, String retailStoreProvinceCenterIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreProvinceCenter.COUNTRY_PROPERTY, retailStoreCountryCenter.getId());
		key.put(RetailStoreProvinceCenter.ID_PROPERTY, retailStoreProvinceCenterIds);

		SmartList<RetailStoreProvinceCenter> externalRetailStoreProvinceCenterList = getRetailStoreProvinceCenterDAO().
				findRetailStoreProvinceCenterWithKey(key, options);
		if(externalRetailStoreProvinceCenterList == null){
			return retailStoreCountryCenter;
		}
		if(externalRetailStoreProvinceCenterList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(RetailStoreProvinceCenter retailStoreProvinceCenterItem: externalRetailStoreProvinceCenterList){

			retailStoreProvinceCenterItem.clearFromAll();
		}


		SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList = retailStoreCountryCenter.getRetailStoreProvinceCenterList();
		retailStoreProvinceCenterList.addAllToRemoveList(externalRetailStoreProvinceCenterList);
		return retailStoreCountryCenter;

	}


	public RetailStoreCountryCenter planToRemoveRetailStoreList(RetailStoreCountryCenter retailStoreCountryCenter, String retailStoreIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenter.getId());
		key.put(RetailStore.ID_PROPERTY, retailStoreIds);

		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreCountryCenter;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(RetailStore retailStoreItem: externalRetailStoreList){

			retailStoreItem.clearFromAll();
		}


		SmartList<RetailStore> retailStoreList = retailStoreCountryCenter.getRetailStoreList();
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreCountryCenter;

	}


	//disconnect RetailStoreCountryCenter with city_service_center in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithCityServiceCenter(RetailStoreCountryCenter retailStoreCountryCenter, String cityServiceCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenter.getId());
		key.put(RetailStore.CITY_SERVICE_CENTER_PROPERTY, cityServiceCenterId);

		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreCountryCenter;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearCityServiceCenter();
			retailStoreItem.clearRetailStoreCountryCenter();

		}


		SmartList<RetailStore> retailStoreList = retailStoreCountryCenter.getRetailStoreList();
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreCountryCenter;
	}

	public int countRetailStoreListWithCityServiceCenter(String retailStoreCountryCenterId, String cityServiceCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);
		key.put(RetailStore.CITY_SERVICE_CENTER_PROPERTY, cityServiceCenterId);

		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreCountryCenter with creation in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithCreation(RetailStoreCountryCenter retailStoreCountryCenter, String creationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenter.getId());
		key.put(RetailStore.CREATION_PROPERTY, creationId);

		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreCountryCenter;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearCreation();
			retailStoreItem.clearRetailStoreCountryCenter();

		}


		SmartList<RetailStore> retailStoreList = retailStoreCountryCenter.getRetailStoreList();
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreCountryCenter;
	}

	public int countRetailStoreListWithCreation(String retailStoreCountryCenterId, String creationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);
		key.put(RetailStore.CREATION_PROPERTY, creationId);

		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreCountryCenter with investment_invitation in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithInvestmentInvitation(RetailStoreCountryCenter retailStoreCountryCenter, String investmentInvitationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenter.getId());
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, investmentInvitationId);

		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreCountryCenter;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearInvestmentInvitation();
			retailStoreItem.clearRetailStoreCountryCenter();

		}


		SmartList<RetailStore> retailStoreList = retailStoreCountryCenter.getRetailStoreList();
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreCountryCenter;
	}

	public int countRetailStoreListWithInvestmentInvitation(String retailStoreCountryCenterId, String investmentInvitationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);
		key.put(RetailStore.INVESTMENT_INVITATION_PROPERTY, investmentInvitationId);

		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreCountryCenter with franchising in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithFranchising(RetailStoreCountryCenter retailStoreCountryCenter, String franchisingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenter.getId());
		key.put(RetailStore.FRANCHISING_PROPERTY, franchisingId);

		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreCountryCenter;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearFranchising();
			retailStoreItem.clearRetailStoreCountryCenter();

		}


		SmartList<RetailStore> retailStoreList = retailStoreCountryCenter.getRetailStoreList();
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreCountryCenter;
	}

	public int countRetailStoreListWithFranchising(String retailStoreCountryCenterId, String franchisingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);
		key.put(RetailStore.FRANCHISING_PROPERTY, franchisingId);

		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreCountryCenter with decoration in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithDecoration(RetailStoreCountryCenter retailStoreCountryCenter, String decorationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenter.getId());
		key.put(RetailStore.DECORATION_PROPERTY, decorationId);

		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreCountryCenter;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearDecoration();
			retailStoreItem.clearRetailStoreCountryCenter();

		}


		SmartList<RetailStore> retailStoreList = retailStoreCountryCenter.getRetailStoreList();
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreCountryCenter;
	}

	public int countRetailStoreListWithDecoration(String retailStoreCountryCenterId, String decorationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);
		key.put(RetailStore.DECORATION_PROPERTY, decorationId);

		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreCountryCenter with opening in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithOpening(RetailStoreCountryCenter retailStoreCountryCenter, String openingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenter.getId());
		key.put(RetailStore.OPENING_PROPERTY, openingId);

		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreCountryCenter;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearOpening();
			retailStoreItem.clearRetailStoreCountryCenter();

		}


		SmartList<RetailStore> retailStoreList = retailStoreCountryCenter.getRetailStoreList();
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreCountryCenter;
	}

	public int countRetailStoreListWithOpening(String retailStoreCountryCenterId, String openingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);
		key.put(RetailStore.OPENING_PROPERTY, openingId);

		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreCountryCenter with closing in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithClosing(RetailStoreCountryCenter retailStoreCountryCenter, String closingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenter.getId());
		key.put(RetailStore.CLOSING_PROPERTY, closingId);

		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreCountryCenter;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(RetailStore retailStoreItem: externalRetailStoreList){
			retailStoreItem.clearClosing();
			retailStoreItem.clearRetailStoreCountryCenter();

		}


		SmartList<RetailStore> retailStoreList = retailStoreCountryCenter.getRetailStoreList();
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreCountryCenter;
	}

	public int countRetailStoreListWithClosing(String retailStoreCountryCenterId, String closingId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);
		key.put(RetailStore.CLOSING_PROPERTY, closingId);

		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	
	public RetailStoreCountryCenter planToRemoveRetailStoreMemberList(RetailStoreCountryCenter retailStoreCountryCenter, String retailStoreMemberIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreMember.OWNER_PROPERTY, retailStoreCountryCenter.getId());
		key.put(RetailStoreMember.ID_PROPERTY, retailStoreMemberIds);

		SmartList<RetailStoreMember> externalRetailStoreMemberList = getRetailStoreMemberDAO().
				findRetailStoreMemberWithKey(key, options);
		if(externalRetailStoreMemberList == null){
			return retailStoreCountryCenter;
		}
		if(externalRetailStoreMemberList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(RetailStoreMember retailStoreMemberItem: externalRetailStoreMemberList){

			retailStoreMemberItem.clearFromAll();
		}


		SmartList<RetailStoreMember> retailStoreMemberList = retailStoreCountryCenter.getRetailStoreMemberList();
		retailStoreMemberList.addAllToRemoveList(externalRetailStoreMemberList);
		return retailStoreCountryCenter;

	}


	public RetailStoreCountryCenter planToRemoveGoodsSupplierList(RetailStoreCountryCenter retailStoreCountryCenter, String goodsSupplierIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(GoodsSupplier.BELONG_TO_PROPERTY, retailStoreCountryCenter.getId());
		key.put(GoodsSupplier.ID_PROPERTY, goodsSupplierIds);

		SmartList<GoodsSupplier> externalGoodsSupplierList = getGoodsSupplierDAO().
				findGoodsSupplierWithKey(key, options);
		if(externalGoodsSupplierList == null){
			return retailStoreCountryCenter;
		}
		if(externalGoodsSupplierList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(GoodsSupplier goodsSupplierItem: externalGoodsSupplierList){

			goodsSupplierItem.clearFromAll();
		}


		SmartList<GoodsSupplier> goodsSupplierList = retailStoreCountryCenter.getGoodsSupplierList();
		goodsSupplierList.addAllToRemoveList(externalGoodsSupplierList);
		return retailStoreCountryCenter;

	}


	public RetailStoreCountryCenter planToRemoveSupplyOrderList(RetailStoreCountryCenter retailStoreCountryCenter, String supplyOrderIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.BUYER_PROPERTY, retailStoreCountryCenter.getId());
		key.put(SupplyOrder.ID_PROPERTY, supplyOrderIds);

		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return retailStoreCountryCenter;
		}
		if(externalSupplyOrderList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(SupplyOrder supplyOrderItem: externalSupplyOrderList){

			supplyOrderItem.clearFromAll();
		}


		SmartList<SupplyOrder> supplyOrderList = retailStoreCountryCenter.getSupplyOrderList();
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return retailStoreCountryCenter;

	}


	//disconnect RetailStoreCountryCenter with seller in SupplyOrder
	public RetailStoreCountryCenter planToRemoveSupplyOrderListWithSeller(RetailStoreCountryCenter retailStoreCountryCenter, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.BUYER_PROPERTY, retailStoreCountryCenter.getId());
		key.put(SupplyOrder.SELLER_PROPERTY, sellerId);

		SmartList<SupplyOrder> externalSupplyOrderList = getSupplyOrderDAO().
				findSupplyOrderWithKey(key, options);
		if(externalSupplyOrderList == null){
			return retailStoreCountryCenter;
		}
		if(externalSupplyOrderList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(SupplyOrder supplyOrderItem: externalSupplyOrderList){
			supplyOrderItem.clearSeller();
			supplyOrderItem.clearBuyer();

		}


		SmartList<SupplyOrder> supplyOrderList = retailStoreCountryCenter.getSupplyOrderList();
		supplyOrderList.addAllToRemoveList(externalSupplyOrderList);
		return retailStoreCountryCenter;
	}

	public int countSupplyOrderListWithSeller(String retailStoreCountryCenterId, String sellerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.BUYER_PROPERTY, retailStoreCountryCenterId);
		key.put(SupplyOrder.SELLER_PROPERTY, sellerId);

		int count = getSupplyOrderDAO().countSupplyOrderWithKey(key, options);
		return count;
	}
	
	public RetailStoreCountryCenter planToRemoveRetailStoreOrderList(RetailStoreCountryCenter retailStoreCountryCenter, String retailStoreOrderIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.SELLER_PROPERTY, retailStoreCountryCenter.getId());
		key.put(RetailStoreOrder.ID_PROPERTY, retailStoreOrderIds);

		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStoreCountryCenter;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(RetailStoreOrder retailStoreOrderItem: externalRetailStoreOrderList){

			retailStoreOrderItem.clearFromAll();
		}


		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreCountryCenter.getRetailStoreOrderList();
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStoreCountryCenter;

	}


	//disconnect RetailStoreCountryCenter with buyer in RetailStoreOrder
	public RetailStoreCountryCenter planToRemoveRetailStoreOrderListWithBuyer(RetailStoreCountryCenter retailStoreCountryCenter, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.SELLER_PROPERTY, retailStoreCountryCenter.getId());
		key.put(RetailStoreOrder.BUYER_PROPERTY, buyerId);

		SmartList<RetailStoreOrder> externalRetailStoreOrderList = getRetailStoreOrderDAO().
				findRetailStoreOrderWithKey(key, options);
		if(externalRetailStoreOrderList == null){
			return retailStoreCountryCenter;
		}
		if(externalRetailStoreOrderList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(RetailStoreOrder retailStoreOrderItem: externalRetailStoreOrderList){
			retailStoreOrderItem.clearBuyer();
			retailStoreOrderItem.clearSeller();

		}


		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreCountryCenter.getRetailStoreOrderList();
		retailStoreOrderList.addAllToRemoveList(externalRetailStoreOrderList);
		return retailStoreCountryCenter;
	}

	public int countRetailStoreOrderListWithBuyer(String retailStoreCountryCenterId, String buyerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.SELLER_PROPERTY, retailStoreCountryCenterId);
		key.put(RetailStoreOrder.BUYER_PROPERTY, buyerId);

		int count = getRetailStoreOrderDAO().countRetailStoreOrderWithKey(key, options);
		return count;
	}
	
	public RetailStoreCountryCenter planToRemoveWarehouseList(RetailStoreCountryCenter retailStoreCountryCenter, String warehouseIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Warehouse.OWNER_PROPERTY, retailStoreCountryCenter.getId());
		key.put(Warehouse.ID_PROPERTY, warehouseIds);

		SmartList<Warehouse> externalWarehouseList = getWarehouseDAO().
				findWarehouseWithKey(key, options);
		if(externalWarehouseList == null){
			return retailStoreCountryCenter;
		}
		if(externalWarehouseList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(Warehouse warehouseItem: externalWarehouseList){

			warehouseItem.clearFromAll();
		}


		SmartList<Warehouse> warehouseList = retailStoreCountryCenter.getWarehouseList();
		warehouseList.addAllToRemoveList(externalWarehouseList);
		return retailStoreCountryCenter;

	}


	public RetailStoreCountryCenter planToRemoveTransportFleetList(RetailStoreCountryCenter retailStoreCountryCenter, String transportFleetIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportFleet.OWNER_PROPERTY, retailStoreCountryCenter.getId());
		key.put(TransportFleet.ID_PROPERTY, transportFleetIds);

		SmartList<TransportFleet> externalTransportFleetList = getTransportFleetDAO().
				findTransportFleetWithKey(key, options);
		if(externalTransportFleetList == null){
			return retailStoreCountryCenter;
		}
		if(externalTransportFleetList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(TransportFleet transportFleetItem: externalTransportFleetList){

			transportFleetItem.clearFromAll();
		}


		SmartList<TransportFleet> transportFleetList = retailStoreCountryCenter.getTransportFleetList();
		transportFleetList.addAllToRemoveList(externalTransportFleetList);
		return retailStoreCountryCenter;

	}


	public RetailStoreCountryCenter planToRemoveAccountSetList(RetailStoreCountryCenter retailStoreCountryCenter, String accountSetIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountSet.COUNTRY_CENTER_PROPERTY, retailStoreCountryCenter.getId());
		key.put(AccountSet.ID_PROPERTY, accountSetIds);

		SmartList<AccountSet> externalAccountSetList = getAccountSetDAO().
				findAccountSetWithKey(key, options);
		if(externalAccountSetList == null){
			return retailStoreCountryCenter;
		}
		if(externalAccountSetList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(AccountSet accountSetItem: externalAccountSetList){

			accountSetItem.clearFromAll();
		}


		SmartList<AccountSet> accountSetList = retailStoreCountryCenter.getAccountSetList();
		accountSetList.addAllToRemoveList(externalAccountSetList);
		return retailStoreCountryCenter;

	}


	//disconnect RetailStoreCountryCenter with retail_store in AccountSet
	public RetailStoreCountryCenter planToRemoveAccountSetListWithRetailStore(RetailStoreCountryCenter retailStoreCountryCenter, String retailStoreId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountSet.COUNTRY_CENTER_PROPERTY, retailStoreCountryCenter.getId());
		key.put(AccountSet.RETAIL_STORE_PROPERTY, retailStoreId);

		SmartList<AccountSet> externalAccountSetList = getAccountSetDAO().
				findAccountSetWithKey(key, options);
		if(externalAccountSetList == null){
			return retailStoreCountryCenter;
		}
		if(externalAccountSetList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(AccountSet accountSetItem: externalAccountSetList){
			accountSetItem.clearRetailStore();
			accountSetItem.clearCountryCenter();

		}


		SmartList<AccountSet> accountSetList = retailStoreCountryCenter.getAccountSetList();
		accountSetList.addAllToRemoveList(externalAccountSetList);
		return retailStoreCountryCenter;
	}

	public int countAccountSetListWithRetailStore(String retailStoreCountryCenterId, String retailStoreId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountSet.COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);
		key.put(AccountSet.RETAIL_STORE_PROPERTY, retailStoreId);

		int count = getAccountSetDAO().countAccountSetWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreCountryCenter with goods_supplier in AccountSet
	public RetailStoreCountryCenter planToRemoveAccountSetListWithGoodsSupplier(RetailStoreCountryCenter retailStoreCountryCenter, String goodsSupplierId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountSet.COUNTRY_CENTER_PROPERTY, retailStoreCountryCenter.getId());
		key.put(AccountSet.GOODS_SUPPLIER_PROPERTY, goodsSupplierId);

		SmartList<AccountSet> externalAccountSetList = getAccountSetDAO().
				findAccountSetWithKey(key, options);
		if(externalAccountSetList == null){
			return retailStoreCountryCenter;
		}
		if(externalAccountSetList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(AccountSet accountSetItem: externalAccountSetList){
			accountSetItem.clearGoodsSupplier();
			accountSetItem.clearCountryCenter();

		}


		SmartList<AccountSet> accountSetList = retailStoreCountryCenter.getAccountSetList();
		accountSetList.addAllToRemoveList(externalAccountSetList);
		return retailStoreCountryCenter;
	}

	public int countAccountSetListWithGoodsSupplier(String retailStoreCountryCenterId, String goodsSupplierId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountSet.COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);
		key.put(AccountSet.GOODS_SUPPLIER_PROPERTY, goodsSupplierId);

		int count = getAccountSetDAO().countAccountSetWithKey(key, options);
		return count;
	}
	
	public RetailStoreCountryCenter planToRemoveLevelOneDepartmentList(RetailStoreCountryCenter retailStoreCountryCenter, String levelOneDepartmentIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LevelOneDepartment.BELONGS_TO_PROPERTY, retailStoreCountryCenter.getId());
		key.put(LevelOneDepartment.ID_PROPERTY, levelOneDepartmentIds);

		SmartList<LevelOneDepartment> externalLevelOneDepartmentList = getLevelOneDepartmentDAO().
				findLevelOneDepartmentWithKey(key, options);
		if(externalLevelOneDepartmentList == null){
			return retailStoreCountryCenter;
		}
		if(externalLevelOneDepartmentList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(LevelOneDepartment levelOneDepartmentItem: externalLevelOneDepartmentList){

			levelOneDepartmentItem.clearFromAll();
		}


		SmartList<LevelOneDepartment> levelOneDepartmentList = retailStoreCountryCenter.getLevelOneDepartmentList();
		levelOneDepartmentList.addAllToRemoveList(externalLevelOneDepartmentList);
		return retailStoreCountryCenter;

	}


	public RetailStoreCountryCenter planToRemoveSkillTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String skillTypeIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SkillType.COMPANY_PROPERTY, retailStoreCountryCenter.getId());
		key.put(SkillType.ID_PROPERTY, skillTypeIds);

		SmartList<SkillType> externalSkillTypeList = getSkillTypeDAO().
				findSkillTypeWithKey(key, options);
		if(externalSkillTypeList == null){
			return retailStoreCountryCenter;
		}
		if(externalSkillTypeList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(SkillType skillTypeItem: externalSkillTypeList){

			skillTypeItem.clearFromAll();
		}


		SmartList<SkillType> skillTypeList = retailStoreCountryCenter.getSkillTypeList();
		skillTypeList.addAllToRemoveList(externalSkillTypeList);
		return retailStoreCountryCenter;

	}


	public RetailStoreCountryCenter planToRemoveResponsibilityTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String responsibilityTypeIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ResponsibilityType.COMPANY_PROPERTY, retailStoreCountryCenter.getId());
		key.put(ResponsibilityType.ID_PROPERTY, responsibilityTypeIds);

		SmartList<ResponsibilityType> externalResponsibilityTypeList = getResponsibilityTypeDAO().
				findResponsibilityTypeWithKey(key, options);
		if(externalResponsibilityTypeList == null){
			return retailStoreCountryCenter;
		}
		if(externalResponsibilityTypeList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(ResponsibilityType responsibilityTypeItem: externalResponsibilityTypeList){

			responsibilityTypeItem.clearFromAll();
		}


		SmartList<ResponsibilityType> responsibilityTypeList = retailStoreCountryCenter.getResponsibilityTypeList();
		responsibilityTypeList.addAllToRemoveList(externalResponsibilityTypeList);
		return retailStoreCountryCenter;

	}


	public RetailStoreCountryCenter planToRemoveTerminationReasonList(RetailStoreCountryCenter retailStoreCountryCenter, String terminationReasonIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TerminationReason.COMPANY_PROPERTY, retailStoreCountryCenter.getId());
		key.put(TerminationReason.ID_PROPERTY, terminationReasonIds);

		SmartList<TerminationReason> externalTerminationReasonList = getTerminationReasonDAO().
				findTerminationReasonWithKey(key, options);
		if(externalTerminationReasonList == null){
			return retailStoreCountryCenter;
		}
		if(externalTerminationReasonList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(TerminationReason terminationReasonItem: externalTerminationReasonList){

			terminationReasonItem.clearFromAll();
		}


		SmartList<TerminationReason> terminationReasonList = retailStoreCountryCenter.getTerminationReasonList();
		terminationReasonList.addAllToRemoveList(externalTerminationReasonList);
		return retailStoreCountryCenter;

	}


	public RetailStoreCountryCenter planToRemoveTerminationTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String terminationTypeIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TerminationType.COMPANY_PROPERTY, retailStoreCountryCenter.getId());
		key.put(TerminationType.ID_PROPERTY, terminationTypeIds);

		SmartList<TerminationType> externalTerminationTypeList = getTerminationTypeDAO().
				findTerminationTypeWithKey(key, options);
		if(externalTerminationTypeList == null){
			return retailStoreCountryCenter;
		}
		if(externalTerminationTypeList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(TerminationType terminationTypeItem: externalTerminationTypeList){

			terminationTypeItem.clearFromAll();
		}


		SmartList<TerminationType> terminationTypeList = retailStoreCountryCenter.getTerminationTypeList();
		terminationTypeList.addAllToRemoveList(externalTerminationTypeList);
		return retailStoreCountryCenter;

	}


	public RetailStoreCountryCenter planToRemoveOccupationTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String occupationTypeIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(OccupationType.COMPANY_PROPERTY, retailStoreCountryCenter.getId());
		key.put(OccupationType.ID_PROPERTY, occupationTypeIds);

		SmartList<OccupationType> externalOccupationTypeList = getOccupationTypeDAO().
				findOccupationTypeWithKey(key, options);
		if(externalOccupationTypeList == null){
			return retailStoreCountryCenter;
		}
		if(externalOccupationTypeList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(OccupationType occupationTypeItem: externalOccupationTypeList){

			occupationTypeItem.clearFromAll();
		}


		SmartList<OccupationType> occupationTypeList = retailStoreCountryCenter.getOccupationTypeList();
		occupationTypeList.addAllToRemoveList(externalOccupationTypeList);
		return retailStoreCountryCenter;

	}


	public RetailStoreCountryCenter planToRemoveLeaveTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String leaveTypeIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LeaveType.COMPANY_PROPERTY, retailStoreCountryCenter.getId());
		key.put(LeaveType.ID_PROPERTY, leaveTypeIds);

		SmartList<LeaveType> externalLeaveTypeList = getLeaveTypeDAO().
				findLeaveTypeWithKey(key, options);
		if(externalLeaveTypeList == null){
			return retailStoreCountryCenter;
		}
		if(externalLeaveTypeList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(LeaveType leaveTypeItem: externalLeaveTypeList){

			leaveTypeItem.clearFromAll();
		}


		SmartList<LeaveType> leaveTypeList = retailStoreCountryCenter.getLeaveTypeList();
		leaveTypeList.addAllToRemoveList(externalLeaveTypeList);
		return retailStoreCountryCenter;

	}


	public RetailStoreCountryCenter planToRemoveSalaryGradeList(RetailStoreCountryCenter retailStoreCountryCenter, String salaryGradeIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SalaryGrade.COMPANY_PROPERTY, retailStoreCountryCenter.getId());
		key.put(SalaryGrade.ID_PROPERTY, salaryGradeIds);

		SmartList<SalaryGrade> externalSalaryGradeList = getSalaryGradeDAO().
				findSalaryGradeWithKey(key, options);
		if(externalSalaryGradeList == null){
			return retailStoreCountryCenter;
		}
		if(externalSalaryGradeList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(SalaryGrade salaryGradeItem: externalSalaryGradeList){

			salaryGradeItem.clearFromAll();
		}


		SmartList<SalaryGrade> salaryGradeList = retailStoreCountryCenter.getSalaryGradeList();
		salaryGradeList.addAllToRemoveList(externalSalaryGradeList);
		return retailStoreCountryCenter;

	}


	public RetailStoreCountryCenter planToRemoveInterviewTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String interviewTypeIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(InterviewType.COMPANY_PROPERTY, retailStoreCountryCenter.getId());
		key.put(InterviewType.ID_PROPERTY, interviewTypeIds);

		SmartList<InterviewType> externalInterviewTypeList = getInterviewTypeDAO().
				findInterviewTypeWithKey(key, options);
		if(externalInterviewTypeList == null){
			return retailStoreCountryCenter;
		}
		if(externalInterviewTypeList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(InterviewType interviewTypeItem: externalInterviewTypeList){

			interviewTypeItem.clearFromAll();
		}


		SmartList<InterviewType> interviewTypeList = retailStoreCountryCenter.getInterviewTypeList();
		interviewTypeList.addAllToRemoveList(externalInterviewTypeList);
		return retailStoreCountryCenter;

	}


	public RetailStoreCountryCenter planToRemoveTrainingCourseTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String trainingCourseTypeIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TrainingCourseType.COMPANY_PROPERTY, retailStoreCountryCenter.getId());
		key.put(TrainingCourseType.ID_PROPERTY, trainingCourseTypeIds);

		SmartList<TrainingCourseType> externalTrainingCourseTypeList = getTrainingCourseTypeDAO().
				findTrainingCourseTypeWithKey(key, options);
		if(externalTrainingCourseTypeList == null){
			return retailStoreCountryCenter;
		}
		if(externalTrainingCourseTypeList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(TrainingCourseType trainingCourseTypeItem: externalTrainingCourseTypeList){

			trainingCourseTypeItem.clearFromAll();
		}


		SmartList<TrainingCourseType> trainingCourseTypeList = retailStoreCountryCenter.getTrainingCourseTypeList();
		trainingCourseTypeList.addAllToRemoveList(externalTrainingCourseTypeList);
		return retailStoreCountryCenter;

	}


	public RetailStoreCountryCenter planToRemovePublicHolidayList(RetailStoreCountryCenter retailStoreCountryCenter, String publicHolidayIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PublicHoliday.COMPANY_PROPERTY, retailStoreCountryCenter.getId());
		key.put(PublicHoliday.ID_PROPERTY, publicHolidayIds);

		SmartList<PublicHoliday> externalPublicHolidayList = getPublicHolidayDAO().
				findPublicHolidayWithKey(key, options);
		if(externalPublicHolidayList == null){
			return retailStoreCountryCenter;
		}
		if(externalPublicHolidayList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(PublicHoliday publicHolidayItem: externalPublicHolidayList){

			publicHolidayItem.clearFromAll();
		}


		SmartList<PublicHoliday> publicHolidayList = retailStoreCountryCenter.getPublicHolidayList();
		publicHolidayList.addAllToRemoveList(externalPublicHolidayList);
		return retailStoreCountryCenter;

	}


	public RetailStoreCountryCenter planToRemoveEmployeeList(RetailStoreCountryCenter retailStoreCountryCenter, String employeeIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.COMPANY_PROPERTY, retailStoreCountryCenter.getId());
		key.put(Employee.ID_PROPERTY, employeeIds);

		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return retailStoreCountryCenter;
		}
		if(externalEmployeeList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(Employee employeeItem: externalEmployeeList){

			employeeItem.clearFromAll();
		}


		SmartList<Employee> employeeList = retailStoreCountryCenter.getEmployeeList();
		employeeList.addAllToRemoveList(externalEmployeeList);
		return retailStoreCountryCenter;

	}


	//disconnect RetailStoreCountryCenter with department in Employee
	public RetailStoreCountryCenter planToRemoveEmployeeListWithDepartment(RetailStoreCountryCenter retailStoreCountryCenter, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.COMPANY_PROPERTY, retailStoreCountryCenter.getId());
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);

		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return retailStoreCountryCenter;
		}
		if(externalEmployeeList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearDepartment();
			employeeItem.clearCompany();

		}


		SmartList<Employee> employeeList = retailStoreCountryCenter.getEmployeeList();
		employeeList.addAllToRemoveList(externalEmployeeList);
		return retailStoreCountryCenter;
	}

	public int countEmployeeListWithDepartment(String retailStoreCountryCenterId, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.COMPANY_PROPERTY, retailStoreCountryCenterId);
		key.put(Employee.DEPARTMENT_PROPERTY, departmentId);

		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreCountryCenter with occupation in Employee
	public RetailStoreCountryCenter planToRemoveEmployeeListWithOccupation(RetailStoreCountryCenter retailStoreCountryCenter, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.COMPANY_PROPERTY, retailStoreCountryCenter.getId());
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);

		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return retailStoreCountryCenter;
		}
		if(externalEmployeeList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearOccupation();
			employeeItem.clearCompany();

		}


		SmartList<Employee> employeeList = retailStoreCountryCenter.getEmployeeList();
		employeeList.addAllToRemoveList(externalEmployeeList);
		return retailStoreCountryCenter;
	}

	public int countEmployeeListWithOccupation(String retailStoreCountryCenterId, String occupationId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.COMPANY_PROPERTY, retailStoreCountryCenterId);
		key.put(Employee.OCCUPATION_PROPERTY, occupationId);

		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreCountryCenter with responsible_for in Employee
	public RetailStoreCountryCenter planToRemoveEmployeeListWithResponsibleFor(RetailStoreCountryCenter retailStoreCountryCenter, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.COMPANY_PROPERTY, retailStoreCountryCenter.getId());
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);

		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return retailStoreCountryCenter;
		}
		if(externalEmployeeList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearResponsibleFor();
			employeeItem.clearCompany();

		}


		SmartList<Employee> employeeList = retailStoreCountryCenter.getEmployeeList();
		employeeList.addAllToRemoveList(externalEmployeeList);
		return retailStoreCountryCenter;
	}

	public int countEmployeeListWithResponsibleFor(String retailStoreCountryCenterId, String responsibleForId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.COMPANY_PROPERTY, retailStoreCountryCenterId);
		key.put(Employee.RESPONSIBLE_FOR_PROPERTY, responsibleForId);

		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreCountryCenter with current_salary_grade in Employee
	public RetailStoreCountryCenter planToRemoveEmployeeListWithCurrentSalaryGrade(RetailStoreCountryCenter retailStoreCountryCenter, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.COMPANY_PROPERTY, retailStoreCountryCenter.getId());
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);

		SmartList<Employee> externalEmployeeList = getEmployeeDAO().
				findEmployeeWithKey(key, options);
		if(externalEmployeeList == null){
			return retailStoreCountryCenter;
		}
		if(externalEmployeeList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(Employee employeeItem: externalEmployeeList){
			employeeItem.clearCurrentSalaryGrade();
			employeeItem.clearCompany();

		}


		SmartList<Employee> employeeList = retailStoreCountryCenter.getEmployeeList();
		employeeList.addAllToRemoveList(externalEmployeeList);
		return retailStoreCountryCenter;
	}

	public int countEmployeeListWithCurrentSalaryGrade(String retailStoreCountryCenterId, String currentSalaryGradeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.COMPANY_PROPERTY, retailStoreCountryCenterId);
		key.put(Employee.CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGradeId);

		int count = getEmployeeDAO().countEmployeeWithKey(key, options);
		return count;
	}
	
	public RetailStoreCountryCenter planToRemoveInstructorList(RetailStoreCountryCenter retailStoreCountryCenter, String instructorIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Instructor.COMPANY_PROPERTY, retailStoreCountryCenter.getId());
		key.put(Instructor.ID_PROPERTY, instructorIds);

		SmartList<Instructor> externalInstructorList = getInstructorDAO().
				findInstructorWithKey(key, options);
		if(externalInstructorList == null){
			return retailStoreCountryCenter;
		}
		if(externalInstructorList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(Instructor instructorItem: externalInstructorList){

			instructorItem.clearFromAll();
		}


		SmartList<Instructor> instructorList = retailStoreCountryCenter.getInstructorList();
		instructorList.addAllToRemoveList(externalInstructorList);
		return retailStoreCountryCenter;

	}


	public RetailStoreCountryCenter planToRemoveCompanyTrainingList(RetailStoreCountryCenter retailStoreCountryCenter, String companyTrainingIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CompanyTraining.COMPANY_PROPERTY, retailStoreCountryCenter.getId());
		key.put(CompanyTraining.ID_PROPERTY, companyTrainingIds);

		SmartList<CompanyTraining> externalCompanyTrainingList = getCompanyTrainingDAO().
				findCompanyTrainingWithKey(key, options);
		if(externalCompanyTrainingList == null){
			return retailStoreCountryCenter;
		}
		if(externalCompanyTrainingList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(CompanyTraining companyTrainingItem: externalCompanyTrainingList){

			companyTrainingItem.clearFromAll();
		}


		SmartList<CompanyTraining> companyTrainingList = retailStoreCountryCenter.getCompanyTrainingList();
		companyTrainingList.addAllToRemoveList(externalCompanyTrainingList);
		return retailStoreCountryCenter;

	}


	//disconnect RetailStoreCountryCenter with instructor in CompanyTraining
	public RetailStoreCountryCenter planToRemoveCompanyTrainingListWithInstructor(RetailStoreCountryCenter retailStoreCountryCenter, String instructorId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CompanyTraining.COMPANY_PROPERTY, retailStoreCountryCenter.getId());
		key.put(CompanyTraining.INSTRUCTOR_PROPERTY, instructorId);

		SmartList<CompanyTraining> externalCompanyTrainingList = getCompanyTrainingDAO().
				findCompanyTrainingWithKey(key, options);
		if(externalCompanyTrainingList == null){
			return retailStoreCountryCenter;
		}
		if(externalCompanyTrainingList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(CompanyTraining companyTrainingItem: externalCompanyTrainingList){
			companyTrainingItem.clearInstructor();
			companyTrainingItem.clearCompany();

		}


		SmartList<CompanyTraining> companyTrainingList = retailStoreCountryCenter.getCompanyTrainingList();
		companyTrainingList.addAllToRemoveList(externalCompanyTrainingList);
		return retailStoreCountryCenter;
	}

	public int countCompanyTrainingListWithInstructor(String retailStoreCountryCenterId, String instructorId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CompanyTraining.COMPANY_PROPERTY, retailStoreCountryCenterId);
		key.put(CompanyTraining.INSTRUCTOR_PROPERTY, instructorId);

		int count = getCompanyTrainingDAO().countCompanyTrainingWithKey(key, options);
		return count;
	}
	
	//disconnect RetailStoreCountryCenter with training_course_type in CompanyTraining
	public RetailStoreCountryCenter planToRemoveCompanyTrainingListWithTrainingCourseType(RetailStoreCountryCenter retailStoreCountryCenter, String trainingCourseTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CompanyTraining.COMPANY_PROPERTY, retailStoreCountryCenter.getId());
		key.put(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, trainingCourseTypeId);

		SmartList<CompanyTraining> externalCompanyTrainingList = getCompanyTrainingDAO().
				findCompanyTrainingWithKey(key, options);
		if(externalCompanyTrainingList == null){
			return retailStoreCountryCenter;
		}
		if(externalCompanyTrainingList.isEmpty()){
			return retailStoreCountryCenter;
		}

		for(CompanyTraining companyTrainingItem: externalCompanyTrainingList){
			companyTrainingItem.clearTrainingCourseType();
			companyTrainingItem.clearCompany();

		}


		SmartList<CompanyTraining> companyTrainingList = retailStoreCountryCenter.getCompanyTrainingList();
		companyTrainingList.addAllToRemoveList(externalCompanyTrainingList);
		return retailStoreCountryCenter;
	}

	public int countCompanyTrainingListWithTrainingCourseType(String retailStoreCountryCenterId, String trainingCourseTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CompanyTraining.COMPANY_PROPERTY, retailStoreCountryCenterId);
		key.put(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, trainingCourseTypeId);

		int count = getCompanyTrainingDAO().countCompanyTrainingWithKey(key, options);
		return count;
	}
	

		
	protected RetailStoreCountryCenter saveCatalogList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<Catalog> catalogList = retailStoreCountryCenter.getCatalogList();
		if(catalogList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<Catalog> mergedUpdateCatalogList = new SmartList<Catalog>();


		mergedUpdateCatalogList.addAll(catalogList);
		if(catalogList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateCatalogList.addAll(catalogList.getToRemoveList());
			catalogList.removeAll(catalogList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getCatalogDAO().saveCatalogList(mergedUpdateCatalogList,options);

		if(catalogList.getToRemoveList() != null){
			catalogList.removeAll(catalogList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeCatalogList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<Catalog> catalogList = retailStoreCountryCenter.getCatalogList();
		if(catalogList == null){
			return retailStoreCountryCenter;
		}

		SmartList<Catalog> toRemoveCatalogList = catalogList.getToRemoveList();

		if(toRemoveCatalogList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveCatalogList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getCatalogDAO().removeCatalogList(toRemoveCatalogList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveRetailStoreProvinceCenterList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList = retailStoreCountryCenter.getRetailStoreProvinceCenterList();
		if(retailStoreProvinceCenterList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<RetailStoreProvinceCenter> mergedUpdateRetailStoreProvinceCenterList = new SmartList<RetailStoreProvinceCenter>();


		mergedUpdateRetailStoreProvinceCenterList.addAll(retailStoreProvinceCenterList);
		if(retailStoreProvinceCenterList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRetailStoreProvinceCenterList.addAll(retailStoreProvinceCenterList.getToRemoveList());
			retailStoreProvinceCenterList.removeAll(retailStoreProvinceCenterList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getRetailStoreProvinceCenterDAO().saveRetailStoreProvinceCenterList(mergedUpdateRetailStoreProvinceCenterList,options);

		if(retailStoreProvinceCenterList.getToRemoveList() != null){
			retailStoreProvinceCenterList.removeAll(retailStoreProvinceCenterList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeRetailStoreProvinceCenterList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList = retailStoreCountryCenter.getRetailStoreProvinceCenterList();
		if(retailStoreProvinceCenterList == null){
			return retailStoreCountryCenter;
		}

		SmartList<RetailStoreProvinceCenter> toRemoveRetailStoreProvinceCenterList = retailStoreProvinceCenterList.getToRemoveList();

		if(toRemoveRetailStoreProvinceCenterList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveRetailStoreProvinceCenterList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getRetailStoreProvinceCenterDAO().removeRetailStoreProvinceCenterList(toRemoveRetailStoreProvinceCenterList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveRetailStoreList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<RetailStore> retailStoreList = retailStoreCountryCenter.getRetailStoreList();
		if(retailStoreList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<RetailStore> mergedUpdateRetailStoreList = new SmartList<RetailStore>();


		mergedUpdateRetailStoreList.addAll(retailStoreList);
		if(retailStoreList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRetailStoreList.addAll(retailStoreList.getToRemoveList());
			retailStoreList.removeAll(retailStoreList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getRetailStoreDAO().saveRetailStoreList(mergedUpdateRetailStoreList,options);

		if(retailStoreList.getToRemoveList() != null){
			retailStoreList.removeAll(retailStoreList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeRetailStoreList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<RetailStore> retailStoreList = retailStoreCountryCenter.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreCountryCenter;
		}

		SmartList<RetailStore> toRemoveRetailStoreList = retailStoreList.getToRemoveList();

		if(toRemoveRetailStoreList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveRetailStoreList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getRetailStoreDAO().removeRetailStoreList(toRemoveRetailStoreList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveRetailStoreMemberList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<RetailStoreMember> retailStoreMemberList = retailStoreCountryCenter.getRetailStoreMemberList();
		if(retailStoreMemberList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<RetailStoreMember> mergedUpdateRetailStoreMemberList = new SmartList<RetailStoreMember>();


		mergedUpdateRetailStoreMemberList.addAll(retailStoreMemberList);
		if(retailStoreMemberList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRetailStoreMemberList.addAll(retailStoreMemberList.getToRemoveList());
			retailStoreMemberList.removeAll(retailStoreMemberList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getRetailStoreMemberDAO().saveRetailStoreMemberList(mergedUpdateRetailStoreMemberList,options);

		if(retailStoreMemberList.getToRemoveList() != null){
			retailStoreMemberList.removeAll(retailStoreMemberList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeRetailStoreMemberList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<RetailStoreMember> retailStoreMemberList = retailStoreCountryCenter.getRetailStoreMemberList();
		if(retailStoreMemberList == null){
			return retailStoreCountryCenter;
		}

		SmartList<RetailStoreMember> toRemoveRetailStoreMemberList = retailStoreMemberList.getToRemoveList();

		if(toRemoveRetailStoreMemberList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveRetailStoreMemberList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getRetailStoreMemberDAO().removeRetailStoreMemberList(toRemoveRetailStoreMemberList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveGoodsSupplierList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<GoodsSupplier> goodsSupplierList = retailStoreCountryCenter.getGoodsSupplierList();
		if(goodsSupplierList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<GoodsSupplier> mergedUpdateGoodsSupplierList = new SmartList<GoodsSupplier>();


		mergedUpdateGoodsSupplierList.addAll(goodsSupplierList);
		if(goodsSupplierList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateGoodsSupplierList.addAll(goodsSupplierList.getToRemoveList());
			goodsSupplierList.removeAll(goodsSupplierList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getGoodsSupplierDAO().saveGoodsSupplierList(mergedUpdateGoodsSupplierList,options);

		if(goodsSupplierList.getToRemoveList() != null){
			goodsSupplierList.removeAll(goodsSupplierList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeGoodsSupplierList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<GoodsSupplier> goodsSupplierList = retailStoreCountryCenter.getGoodsSupplierList();
		if(goodsSupplierList == null){
			return retailStoreCountryCenter;
		}

		SmartList<GoodsSupplier> toRemoveGoodsSupplierList = goodsSupplierList.getToRemoveList();

		if(toRemoveGoodsSupplierList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveGoodsSupplierList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getGoodsSupplierDAO().removeGoodsSupplierList(toRemoveGoodsSupplierList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveSupplyOrderList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<SupplyOrder> supplyOrderList = retailStoreCountryCenter.getSupplyOrderList();
		if(supplyOrderList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<SupplyOrder> mergedUpdateSupplyOrderList = new SmartList<SupplyOrder>();


		mergedUpdateSupplyOrderList.addAll(supplyOrderList);
		if(supplyOrderList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateSupplyOrderList.addAll(supplyOrderList.getToRemoveList());
			supplyOrderList.removeAll(supplyOrderList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getSupplyOrderDAO().saveSupplyOrderList(mergedUpdateSupplyOrderList,options);

		if(supplyOrderList.getToRemoveList() != null){
			supplyOrderList.removeAll(supplyOrderList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeSupplyOrderList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<SupplyOrder> supplyOrderList = retailStoreCountryCenter.getSupplyOrderList();
		if(supplyOrderList == null){
			return retailStoreCountryCenter;
		}

		SmartList<SupplyOrder> toRemoveSupplyOrderList = supplyOrderList.getToRemoveList();

		if(toRemoveSupplyOrderList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveSupplyOrderList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getSupplyOrderDAO().removeSupplyOrderList(toRemoveSupplyOrderList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveRetailStoreOrderList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreCountryCenter.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<RetailStoreOrder> mergedUpdateRetailStoreOrderList = new SmartList<RetailStoreOrder>();


		mergedUpdateRetailStoreOrderList.addAll(retailStoreOrderList);
		if(retailStoreOrderList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRetailStoreOrderList.addAll(retailStoreOrderList.getToRemoveList());
			retailStoreOrderList.removeAll(retailStoreOrderList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getRetailStoreOrderDAO().saveRetailStoreOrderList(mergedUpdateRetailStoreOrderList,options);

		if(retailStoreOrderList.getToRemoveList() != null){
			retailStoreOrderList.removeAll(retailStoreOrderList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeRetailStoreOrderList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreCountryCenter.getRetailStoreOrderList();
		if(retailStoreOrderList == null){
			return retailStoreCountryCenter;
		}

		SmartList<RetailStoreOrder> toRemoveRetailStoreOrderList = retailStoreOrderList.getToRemoveList();

		if(toRemoveRetailStoreOrderList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveRetailStoreOrderList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getRetailStoreOrderDAO().removeRetailStoreOrderList(toRemoveRetailStoreOrderList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveWarehouseList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<Warehouse> warehouseList = retailStoreCountryCenter.getWarehouseList();
		if(warehouseList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<Warehouse> mergedUpdateWarehouseList = new SmartList<Warehouse>();


		mergedUpdateWarehouseList.addAll(warehouseList);
		if(warehouseList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateWarehouseList.addAll(warehouseList.getToRemoveList());
			warehouseList.removeAll(warehouseList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getWarehouseDAO().saveWarehouseList(mergedUpdateWarehouseList,options);

		if(warehouseList.getToRemoveList() != null){
			warehouseList.removeAll(warehouseList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeWarehouseList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<Warehouse> warehouseList = retailStoreCountryCenter.getWarehouseList();
		if(warehouseList == null){
			return retailStoreCountryCenter;
		}

		SmartList<Warehouse> toRemoveWarehouseList = warehouseList.getToRemoveList();

		if(toRemoveWarehouseList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveWarehouseList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getWarehouseDAO().removeWarehouseList(toRemoveWarehouseList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveTransportFleetList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<TransportFleet> transportFleetList = retailStoreCountryCenter.getTransportFleetList();
		if(transportFleetList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<TransportFleet> mergedUpdateTransportFleetList = new SmartList<TransportFleet>();


		mergedUpdateTransportFleetList.addAll(transportFleetList);
		if(transportFleetList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTransportFleetList.addAll(transportFleetList.getToRemoveList());
			transportFleetList.removeAll(transportFleetList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getTransportFleetDAO().saveTransportFleetList(mergedUpdateTransportFleetList,options);

		if(transportFleetList.getToRemoveList() != null){
			transportFleetList.removeAll(transportFleetList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeTransportFleetList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<TransportFleet> transportFleetList = retailStoreCountryCenter.getTransportFleetList();
		if(transportFleetList == null){
			return retailStoreCountryCenter;
		}

		SmartList<TransportFleet> toRemoveTransportFleetList = transportFleetList.getToRemoveList();

		if(toRemoveTransportFleetList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveTransportFleetList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getTransportFleetDAO().removeTransportFleetList(toRemoveTransportFleetList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveAccountSetList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<AccountSet> accountSetList = retailStoreCountryCenter.getAccountSetList();
		if(accountSetList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<AccountSet> mergedUpdateAccountSetList = new SmartList<AccountSet>();


		mergedUpdateAccountSetList.addAll(accountSetList);
		if(accountSetList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateAccountSetList.addAll(accountSetList.getToRemoveList());
			accountSetList.removeAll(accountSetList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getAccountSetDAO().saveAccountSetList(mergedUpdateAccountSetList,options);

		if(accountSetList.getToRemoveList() != null){
			accountSetList.removeAll(accountSetList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeAccountSetList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<AccountSet> accountSetList = retailStoreCountryCenter.getAccountSetList();
		if(accountSetList == null){
			return retailStoreCountryCenter;
		}

		SmartList<AccountSet> toRemoveAccountSetList = accountSetList.getToRemoveList();

		if(toRemoveAccountSetList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveAccountSetList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getAccountSetDAO().removeAccountSetList(toRemoveAccountSetList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveLevelOneDepartmentList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<LevelOneDepartment> levelOneDepartmentList = retailStoreCountryCenter.getLevelOneDepartmentList();
		if(levelOneDepartmentList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<LevelOneDepartment> mergedUpdateLevelOneDepartmentList = new SmartList<LevelOneDepartment>();


		mergedUpdateLevelOneDepartmentList.addAll(levelOneDepartmentList);
		if(levelOneDepartmentList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateLevelOneDepartmentList.addAll(levelOneDepartmentList.getToRemoveList());
			levelOneDepartmentList.removeAll(levelOneDepartmentList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getLevelOneDepartmentDAO().saveLevelOneDepartmentList(mergedUpdateLevelOneDepartmentList,options);

		if(levelOneDepartmentList.getToRemoveList() != null){
			levelOneDepartmentList.removeAll(levelOneDepartmentList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeLevelOneDepartmentList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<LevelOneDepartment> levelOneDepartmentList = retailStoreCountryCenter.getLevelOneDepartmentList();
		if(levelOneDepartmentList == null){
			return retailStoreCountryCenter;
		}

		SmartList<LevelOneDepartment> toRemoveLevelOneDepartmentList = levelOneDepartmentList.getToRemoveList();

		if(toRemoveLevelOneDepartmentList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveLevelOneDepartmentList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getLevelOneDepartmentDAO().removeLevelOneDepartmentList(toRemoveLevelOneDepartmentList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveSkillTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<SkillType> skillTypeList = retailStoreCountryCenter.getSkillTypeList();
		if(skillTypeList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<SkillType> mergedUpdateSkillTypeList = new SmartList<SkillType>();


		mergedUpdateSkillTypeList.addAll(skillTypeList);
		if(skillTypeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateSkillTypeList.addAll(skillTypeList.getToRemoveList());
			skillTypeList.removeAll(skillTypeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getSkillTypeDAO().saveSkillTypeList(mergedUpdateSkillTypeList,options);

		if(skillTypeList.getToRemoveList() != null){
			skillTypeList.removeAll(skillTypeList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeSkillTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<SkillType> skillTypeList = retailStoreCountryCenter.getSkillTypeList();
		if(skillTypeList == null){
			return retailStoreCountryCenter;
		}

		SmartList<SkillType> toRemoveSkillTypeList = skillTypeList.getToRemoveList();

		if(toRemoveSkillTypeList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveSkillTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getSkillTypeDAO().removeSkillTypeList(toRemoveSkillTypeList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveResponsibilityTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<ResponsibilityType> responsibilityTypeList = retailStoreCountryCenter.getResponsibilityTypeList();
		if(responsibilityTypeList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<ResponsibilityType> mergedUpdateResponsibilityTypeList = new SmartList<ResponsibilityType>();


		mergedUpdateResponsibilityTypeList.addAll(responsibilityTypeList);
		if(responsibilityTypeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateResponsibilityTypeList.addAll(responsibilityTypeList.getToRemoveList());
			responsibilityTypeList.removeAll(responsibilityTypeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getResponsibilityTypeDAO().saveResponsibilityTypeList(mergedUpdateResponsibilityTypeList,options);

		if(responsibilityTypeList.getToRemoveList() != null){
			responsibilityTypeList.removeAll(responsibilityTypeList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeResponsibilityTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<ResponsibilityType> responsibilityTypeList = retailStoreCountryCenter.getResponsibilityTypeList();
		if(responsibilityTypeList == null){
			return retailStoreCountryCenter;
		}

		SmartList<ResponsibilityType> toRemoveResponsibilityTypeList = responsibilityTypeList.getToRemoveList();

		if(toRemoveResponsibilityTypeList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveResponsibilityTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getResponsibilityTypeDAO().removeResponsibilityTypeList(toRemoveResponsibilityTypeList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveTerminationReasonList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<TerminationReason> terminationReasonList = retailStoreCountryCenter.getTerminationReasonList();
		if(terminationReasonList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<TerminationReason> mergedUpdateTerminationReasonList = new SmartList<TerminationReason>();


		mergedUpdateTerminationReasonList.addAll(terminationReasonList);
		if(terminationReasonList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTerminationReasonList.addAll(terminationReasonList.getToRemoveList());
			terminationReasonList.removeAll(terminationReasonList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getTerminationReasonDAO().saveTerminationReasonList(mergedUpdateTerminationReasonList,options);

		if(terminationReasonList.getToRemoveList() != null){
			terminationReasonList.removeAll(terminationReasonList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeTerminationReasonList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<TerminationReason> terminationReasonList = retailStoreCountryCenter.getTerminationReasonList();
		if(terminationReasonList == null){
			return retailStoreCountryCenter;
		}

		SmartList<TerminationReason> toRemoveTerminationReasonList = terminationReasonList.getToRemoveList();

		if(toRemoveTerminationReasonList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveTerminationReasonList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getTerminationReasonDAO().removeTerminationReasonList(toRemoveTerminationReasonList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveTerminationTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<TerminationType> terminationTypeList = retailStoreCountryCenter.getTerminationTypeList();
		if(terminationTypeList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<TerminationType> mergedUpdateTerminationTypeList = new SmartList<TerminationType>();


		mergedUpdateTerminationTypeList.addAll(terminationTypeList);
		if(terminationTypeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTerminationTypeList.addAll(terminationTypeList.getToRemoveList());
			terminationTypeList.removeAll(terminationTypeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getTerminationTypeDAO().saveTerminationTypeList(mergedUpdateTerminationTypeList,options);

		if(terminationTypeList.getToRemoveList() != null){
			terminationTypeList.removeAll(terminationTypeList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeTerminationTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<TerminationType> terminationTypeList = retailStoreCountryCenter.getTerminationTypeList();
		if(terminationTypeList == null){
			return retailStoreCountryCenter;
		}

		SmartList<TerminationType> toRemoveTerminationTypeList = terminationTypeList.getToRemoveList();

		if(toRemoveTerminationTypeList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveTerminationTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getTerminationTypeDAO().removeTerminationTypeList(toRemoveTerminationTypeList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveOccupationTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<OccupationType> occupationTypeList = retailStoreCountryCenter.getOccupationTypeList();
		if(occupationTypeList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<OccupationType> mergedUpdateOccupationTypeList = new SmartList<OccupationType>();


		mergedUpdateOccupationTypeList.addAll(occupationTypeList);
		if(occupationTypeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateOccupationTypeList.addAll(occupationTypeList.getToRemoveList());
			occupationTypeList.removeAll(occupationTypeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getOccupationTypeDAO().saveOccupationTypeList(mergedUpdateOccupationTypeList,options);

		if(occupationTypeList.getToRemoveList() != null){
			occupationTypeList.removeAll(occupationTypeList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeOccupationTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<OccupationType> occupationTypeList = retailStoreCountryCenter.getOccupationTypeList();
		if(occupationTypeList == null){
			return retailStoreCountryCenter;
		}

		SmartList<OccupationType> toRemoveOccupationTypeList = occupationTypeList.getToRemoveList();

		if(toRemoveOccupationTypeList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveOccupationTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getOccupationTypeDAO().removeOccupationTypeList(toRemoveOccupationTypeList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveLeaveTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<LeaveType> leaveTypeList = retailStoreCountryCenter.getLeaveTypeList();
		if(leaveTypeList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<LeaveType> mergedUpdateLeaveTypeList = new SmartList<LeaveType>();


		mergedUpdateLeaveTypeList.addAll(leaveTypeList);
		if(leaveTypeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateLeaveTypeList.addAll(leaveTypeList.getToRemoveList());
			leaveTypeList.removeAll(leaveTypeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getLeaveTypeDAO().saveLeaveTypeList(mergedUpdateLeaveTypeList,options);

		if(leaveTypeList.getToRemoveList() != null){
			leaveTypeList.removeAll(leaveTypeList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeLeaveTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<LeaveType> leaveTypeList = retailStoreCountryCenter.getLeaveTypeList();
		if(leaveTypeList == null){
			return retailStoreCountryCenter;
		}

		SmartList<LeaveType> toRemoveLeaveTypeList = leaveTypeList.getToRemoveList();

		if(toRemoveLeaveTypeList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveLeaveTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getLeaveTypeDAO().removeLeaveTypeList(toRemoveLeaveTypeList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveSalaryGradeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<SalaryGrade> salaryGradeList = retailStoreCountryCenter.getSalaryGradeList();
		if(salaryGradeList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<SalaryGrade> mergedUpdateSalaryGradeList = new SmartList<SalaryGrade>();


		mergedUpdateSalaryGradeList.addAll(salaryGradeList);
		if(salaryGradeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateSalaryGradeList.addAll(salaryGradeList.getToRemoveList());
			salaryGradeList.removeAll(salaryGradeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getSalaryGradeDAO().saveSalaryGradeList(mergedUpdateSalaryGradeList,options);

		if(salaryGradeList.getToRemoveList() != null){
			salaryGradeList.removeAll(salaryGradeList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeSalaryGradeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<SalaryGrade> salaryGradeList = retailStoreCountryCenter.getSalaryGradeList();
		if(salaryGradeList == null){
			return retailStoreCountryCenter;
		}

		SmartList<SalaryGrade> toRemoveSalaryGradeList = salaryGradeList.getToRemoveList();

		if(toRemoveSalaryGradeList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveSalaryGradeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getSalaryGradeDAO().removeSalaryGradeList(toRemoveSalaryGradeList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveInterviewTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<InterviewType> interviewTypeList = retailStoreCountryCenter.getInterviewTypeList();
		if(interviewTypeList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<InterviewType> mergedUpdateInterviewTypeList = new SmartList<InterviewType>();


		mergedUpdateInterviewTypeList.addAll(interviewTypeList);
		if(interviewTypeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateInterviewTypeList.addAll(interviewTypeList.getToRemoveList());
			interviewTypeList.removeAll(interviewTypeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getInterviewTypeDAO().saveInterviewTypeList(mergedUpdateInterviewTypeList,options);

		if(interviewTypeList.getToRemoveList() != null){
			interviewTypeList.removeAll(interviewTypeList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeInterviewTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<InterviewType> interviewTypeList = retailStoreCountryCenter.getInterviewTypeList();
		if(interviewTypeList == null){
			return retailStoreCountryCenter;
		}

		SmartList<InterviewType> toRemoveInterviewTypeList = interviewTypeList.getToRemoveList();

		if(toRemoveInterviewTypeList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveInterviewTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getInterviewTypeDAO().removeInterviewTypeList(toRemoveInterviewTypeList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveTrainingCourseTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<TrainingCourseType> trainingCourseTypeList = retailStoreCountryCenter.getTrainingCourseTypeList();
		if(trainingCourseTypeList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<TrainingCourseType> mergedUpdateTrainingCourseTypeList = new SmartList<TrainingCourseType>();


		mergedUpdateTrainingCourseTypeList.addAll(trainingCourseTypeList);
		if(trainingCourseTypeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateTrainingCourseTypeList.addAll(trainingCourseTypeList.getToRemoveList());
			trainingCourseTypeList.removeAll(trainingCourseTypeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getTrainingCourseTypeDAO().saveTrainingCourseTypeList(mergedUpdateTrainingCourseTypeList,options);

		if(trainingCourseTypeList.getToRemoveList() != null){
			trainingCourseTypeList.removeAll(trainingCourseTypeList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeTrainingCourseTypeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<TrainingCourseType> trainingCourseTypeList = retailStoreCountryCenter.getTrainingCourseTypeList();
		if(trainingCourseTypeList == null){
			return retailStoreCountryCenter;
		}

		SmartList<TrainingCourseType> toRemoveTrainingCourseTypeList = trainingCourseTypeList.getToRemoveList();

		if(toRemoveTrainingCourseTypeList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveTrainingCourseTypeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getTrainingCourseTypeDAO().removeTrainingCourseTypeList(toRemoveTrainingCourseTypeList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter savePublicHolidayList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<PublicHoliday> publicHolidayList = retailStoreCountryCenter.getPublicHolidayList();
		if(publicHolidayList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<PublicHoliday> mergedUpdatePublicHolidayList = new SmartList<PublicHoliday>();


		mergedUpdatePublicHolidayList.addAll(publicHolidayList);
		if(publicHolidayList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdatePublicHolidayList.addAll(publicHolidayList.getToRemoveList());
			publicHolidayList.removeAll(publicHolidayList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getPublicHolidayDAO().savePublicHolidayList(mergedUpdatePublicHolidayList,options);

		if(publicHolidayList.getToRemoveList() != null){
			publicHolidayList.removeAll(publicHolidayList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removePublicHolidayList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<PublicHoliday> publicHolidayList = retailStoreCountryCenter.getPublicHolidayList();
		if(publicHolidayList == null){
			return retailStoreCountryCenter;
		}

		SmartList<PublicHoliday> toRemovePublicHolidayList = publicHolidayList.getToRemoveList();

		if(toRemovePublicHolidayList == null){
			return retailStoreCountryCenter;
		}
		if(toRemovePublicHolidayList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getPublicHolidayDAO().removePublicHolidayList(toRemovePublicHolidayList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveEmployeeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<Employee> employeeList = retailStoreCountryCenter.getEmployeeList();
		if(employeeList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<Employee> mergedUpdateEmployeeList = new SmartList<Employee>();


		mergedUpdateEmployeeList.addAll(employeeList);
		if(employeeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateEmployeeList.addAll(employeeList.getToRemoveList());
			employeeList.removeAll(employeeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getEmployeeDAO().saveEmployeeList(mergedUpdateEmployeeList,options);

		if(employeeList.getToRemoveList() != null){
			employeeList.removeAll(employeeList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeEmployeeList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<Employee> employeeList = retailStoreCountryCenter.getEmployeeList();
		if(employeeList == null){
			return retailStoreCountryCenter;
		}

		SmartList<Employee> toRemoveEmployeeList = employeeList.getToRemoveList();

		if(toRemoveEmployeeList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveEmployeeList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getEmployeeDAO().removeEmployeeList(toRemoveEmployeeList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveInstructorList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<Instructor> instructorList = retailStoreCountryCenter.getInstructorList();
		if(instructorList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<Instructor> mergedUpdateInstructorList = new SmartList<Instructor>();


		mergedUpdateInstructorList.addAll(instructorList);
		if(instructorList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateInstructorList.addAll(instructorList.getToRemoveList());
			instructorList.removeAll(instructorList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getInstructorDAO().saveInstructorList(mergedUpdateInstructorList,options);

		if(instructorList.getToRemoveList() != null){
			instructorList.removeAll(instructorList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeInstructorList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<Instructor> instructorList = retailStoreCountryCenter.getInstructorList();
		if(instructorList == null){
			return retailStoreCountryCenter;
		}

		SmartList<Instructor> toRemoveInstructorList = instructorList.getToRemoveList();

		if(toRemoveInstructorList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveInstructorList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getInstructorDAO().removeInstructorList(toRemoveInstructorList,options);

		return retailStoreCountryCenter;

	}








		
	protected RetailStoreCountryCenter saveCompanyTrainingList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){
    



		SmartList<CompanyTraining> companyTrainingList = retailStoreCountryCenter.getCompanyTrainingList();
		if(companyTrainingList == null){
			//null list means nothing
			return retailStoreCountryCenter;
		}
		SmartList<CompanyTraining> mergedUpdateCompanyTrainingList = new SmartList<CompanyTraining>();


		mergedUpdateCompanyTrainingList.addAll(companyTrainingList);
		if(companyTrainingList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateCompanyTrainingList.addAll(companyTrainingList.getToRemoveList());
			companyTrainingList.removeAll(companyTrainingList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getCompanyTrainingDAO().saveCompanyTrainingList(mergedUpdateCompanyTrainingList,options);

		if(companyTrainingList.getToRemoveList() != null){
			companyTrainingList.removeAll(companyTrainingList.getToRemoveList());
		}


		return retailStoreCountryCenter;

	}

	protected RetailStoreCountryCenter removeCompanyTrainingList(RetailStoreCountryCenter retailStoreCountryCenter, Map<String,Object> options){


		SmartList<CompanyTraining> companyTrainingList = retailStoreCountryCenter.getCompanyTrainingList();
		if(companyTrainingList == null){
			return retailStoreCountryCenter;
		}

		SmartList<CompanyTraining> toRemoveCompanyTrainingList = companyTrainingList.getToRemoveList();

		if(toRemoveCompanyTrainingList == null){
			return retailStoreCountryCenter;
		}
		if(toRemoveCompanyTrainingList.isEmpty()){
			return retailStoreCountryCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getCompanyTrainingDAO().removeCompanyTrainingList(toRemoveCompanyTrainingList,options);

		return retailStoreCountryCenter;

	}








		

	public RetailStoreCountryCenter present(RetailStoreCountryCenter retailStoreCountryCenter,Map<String, Object> options){

		presentCatalogList(retailStoreCountryCenter,options);
		presentRetailStoreProvinceCenterList(retailStoreCountryCenter,options);
		presentRetailStoreList(retailStoreCountryCenter,options);
		presentRetailStoreMemberList(retailStoreCountryCenter,options);
		presentGoodsSupplierList(retailStoreCountryCenter,options);
		presentSupplyOrderList(retailStoreCountryCenter,options);
		presentRetailStoreOrderList(retailStoreCountryCenter,options);
		presentWarehouseList(retailStoreCountryCenter,options);
		presentTransportFleetList(retailStoreCountryCenter,options);
		presentAccountSetList(retailStoreCountryCenter,options);
		presentLevelOneDepartmentList(retailStoreCountryCenter,options);
		presentSkillTypeList(retailStoreCountryCenter,options);
		presentResponsibilityTypeList(retailStoreCountryCenter,options);
		presentTerminationReasonList(retailStoreCountryCenter,options);
		presentTerminationTypeList(retailStoreCountryCenter,options);
		presentOccupationTypeList(retailStoreCountryCenter,options);
		presentLeaveTypeList(retailStoreCountryCenter,options);
		presentSalaryGradeList(retailStoreCountryCenter,options);
		presentInterviewTypeList(retailStoreCountryCenter,options);
		presentTrainingCourseTypeList(retailStoreCountryCenter,options);
		presentPublicHolidayList(retailStoreCountryCenter,options);
		presentEmployeeList(retailStoreCountryCenter,options);
		presentInstructorList(retailStoreCountryCenter,options);
		presentCompanyTrainingList(retailStoreCountryCenter,options);

		return retailStoreCountryCenter;

	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentCatalogList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<Catalog> catalogList = retailStoreCountryCenter.getCatalogList();
				SmartList<Catalog> newList= presentSubList(retailStoreCountryCenter.getId(),
				catalogList,
				options,
				getCatalogDAO()::countCatalogByOwner,
				getCatalogDAO()::findCatalogByOwner
				);


		retailStoreCountryCenter.setCatalogList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentRetailStoreProvinceCenterList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList = retailStoreCountryCenter.getRetailStoreProvinceCenterList();
				SmartList<RetailStoreProvinceCenter> newList= presentSubList(retailStoreCountryCenter.getId(),
				retailStoreProvinceCenterList,
				options,
				getRetailStoreProvinceCenterDAO()::countRetailStoreProvinceCenterByCountry,
				getRetailStoreProvinceCenterDAO()::findRetailStoreProvinceCenterByCountry
				);


		retailStoreCountryCenter.setRetailStoreProvinceCenterList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentRetailStoreList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<RetailStore> retailStoreList = retailStoreCountryCenter.getRetailStoreList();
				SmartList<RetailStore> newList= presentSubList(retailStoreCountryCenter.getId(),
				retailStoreList,
				options,
				getRetailStoreDAO()::countRetailStoreByRetailStoreCountryCenter,
				getRetailStoreDAO()::findRetailStoreByRetailStoreCountryCenter
				);


		retailStoreCountryCenter.setRetailStoreList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentRetailStoreMemberList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<RetailStoreMember> retailStoreMemberList = retailStoreCountryCenter.getRetailStoreMemberList();
				SmartList<RetailStoreMember> newList= presentSubList(retailStoreCountryCenter.getId(),
				retailStoreMemberList,
				options,
				getRetailStoreMemberDAO()::countRetailStoreMemberByOwner,
				getRetailStoreMemberDAO()::findRetailStoreMemberByOwner
				);


		retailStoreCountryCenter.setRetailStoreMemberList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentGoodsSupplierList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<GoodsSupplier> goodsSupplierList = retailStoreCountryCenter.getGoodsSupplierList();
				SmartList<GoodsSupplier> newList= presentSubList(retailStoreCountryCenter.getId(),
				goodsSupplierList,
				options,
				getGoodsSupplierDAO()::countGoodsSupplierByBelongTo,
				getGoodsSupplierDAO()::findGoodsSupplierByBelongTo
				);


		retailStoreCountryCenter.setGoodsSupplierList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentSupplyOrderList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<SupplyOrder> supplyOrderList = retailStoreCountryCenter.getSupplyOrderList();
				SmartList<SupplyOrder> newList= presentSubList(retailStoreCountryCenter.getId(),
				supplyOrderList,
				options,
				getSupplyOrderDAO()::countSupplyOrderByBuyer,
				getSupplyOrderDAO()::findSupplyOrderByBuyer
				);


		retailStoreCountryCenter.setSupplyOrderList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentRetailStoreOrderList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<RetailStoreOrder> retailStoreOrderList = retailStoreCountryCenter.getRetailStoreOrderList();
				SmartList<RetailStoreOrder> newList= presentSubList(retailStoreCountryCenter.getId(),
				retailStoreOrderList,
				options,
				getRetailStoreOrderDAO()::countRetailStoreOrderBySeller,
				getRetailStoreOrderDAO()::findRetailStoreOrderBySeller
				);


		retailStoreCountryCenter.setRetailStoreOrderList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentWarehouseList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<Warehouse> warehouseList = retailStoreCountryCenter.getWarehouseList();
				SmartList<Warehouse> newList= presentSubList(retailStoreCountryCenter.getId(),
				warehouseList,
				options,
				getWarehouseDAO()::countWarehouseByOwner,
				getWarehouseDAO()::findWarehouseByOwner
				);


		retailStoreCountryCenter.setWarehouseList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentTransportFleetList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<TransportFleet> transportFleetList = retailStoreCountryCenter.getTransportFleetList();
				SmartList<TransportFleet> newList= presentSubList(retailStoreCountryCenter.getId(),
				transportFleetList,
				options,
				getTransportFleetDAO()::countTransportFleetByOwner,
				getTransportFleetDAO()::findTransportFleetByOwner
				);


		retailStoreCountryCenter.setTransportFleetList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentAccountSetList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<AccountSet> accountSetList = retailStoreCountryCenter.getAccountSetList();
				SmartList<AccountSet> newList= presentSubList(retailStoreCountryCenter.getId(),
				accountSetList,
				options,
				getAccountSetDAO()::countAccountSetByCountryCenter,
				getAccountSetDAO()::findAccountSetByCountryCenter
				);


		retailStoreCountryCenter.setAccountSetList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentLevelOneDepartmentList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<LevelOneDepartment> levelOneDepartmentList = retailStoreCountryCenter.getLevelOneDepartmentList();
				SmartList<LevelOneDepartment> newList= presentSubList(retailStoreCountryCenter.getId(),
				levelOneDepartmentList,
				options,
				getLevelOneDepartmentDAO()::countLevelOneDepartmentByBelongsTo,
				getLevelOneDepartmentDAO()::findLevelOneDepartmentByBelongsTo
				);


		retailStoreCountryCenter.setLevelOneDepartmentList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentSkillTypeList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<SkillType> skillTypeList = retailStoreCountryCenter.getSkillTypeList();
				SmartList<SkillType> newList= presentSubList(retailStoreCountryCenter.getId(),
				skillTypeList,
				options,
				getSkillTypeDAO()::countSkillTypeByCompany,
				getSkillTypeDAO()::findSkillTypeByCompany
				);


		retailStoreCountryCenter.setSkillTypeList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentResponsibilityTypeList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<ResponsibilityType> responsibilityTypeList = retailStoreCountryCenter.getResponsibilityTypeList();
				SmartList<ResponsibilityType> newList= presentSubList(retailStoreCountryCenter.getId(),
				responsibilityTypeList,
				options,
				getResponsibilityTypeDAO()::countResponsibilityTypeByCompany,
				getResponsibilityTypeDAO()::findResponsibilityTypeByCompany
				);


		retailStoreCountryCenter.setResponsibilityTypeList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentTerminationReasonList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<TerminationReason> terminationReasonList = retailStoreCountryCenter.getTerminationReasonList();
				SmartList<TerminationReason> newList= presentSubList(retailStoreCountryCenter.getId(),
				terminationReasonList,
				options,
				getTerminationReasonDAO()::countTerminationReasonByCompany,
				getTerminationReasonDAO()::findTerminationReasonByCompany
				);


		retailStoreCountryCenter.setTerminationReasonList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentTerminationTypeList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<TerminationType> terminationTypeList = retailStoreCountryCenter.getTerminationTypeList();
				SmartList<TerminationType> newList= presentSubList(retailStoreCountryCenter.getId(),
				terminationTypeList,
				options,
				getTerminationTypeDAO()::countTerminationTypeByCompany,
				getTerminationTypeDAO()::findTerminationTypeByCompany
				);


		retailStoreCountryCenter.setTerminationTypeList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentOccupationTypeList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<OccupationType> occupationTypeList = retailStoreCountryCenter.getOccupationTypeList();
				SmartList<OccupationType> newList= presentSubList(retailStoreCountryCenter.getId(),
				occupationTypeList,
				options,
				getOccupationTypeDAO()::countOccupationTypeByCompany,
				getOccupationTypeDAO()::findOccupationTypeByCompany
				);


		retailStoreCountryCenter.setOccupationTypeList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentLeaveTypeList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<LeaveType> leaveTypeList = retailStoreCountryCenter.getLeaveTypeList();
				SmartList<LeaveType> newList= presentSubList(retailStoreCountryCenter.getId(),
				leaveTypeList,
				options,
				getLeaveTypeDAO()::countLeaveTypeByCompany,
				getLeaveTypeDAO()::findLeaveTypeByCompany
				);


		retailStoreCountryCenter.setLeaveTypeList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentSalaryGradeList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<SalaryGrade> salaryGradeList = retailStoreCountryCenter.getSalaryGradeList();
				SmartList<SalaryGrade> newList= presentSubList(retailStoreCountryCenter.getId(),
				salaryGradeList,
				options,
				getSalaryGradeDAO()::countSalaryGradeByCompany,
				getSalaryGradeDAO()::findSalaryGradeByCompany
				);


		retailStoreCountryCenter.setSalaryGradeList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentInterviewTypeList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<InterviewType> interviewTypeList = retailStoreCountryCenter.getInterviewTypeList();
				SmartList<InterviewType> newList= presentSubList(retailStoreCountryCenter.getId(),
				interviewTypeList,
				options,
				getInterviewTypeDAO()::countInterviewTypeByCompany,
				getInterviewTypeDAO()::findInterviewTypeByCompany
				);


		retailStoreCountryCenter.setInterviewTypeList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentTrainingCourseTypeList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<TrainingCourseType> trainingCourseTypeList = retailStoreCountryCenter.getTrainingCourseTypeList();
				SmartList<TrainingCourseType> newList= presentSubList(retailStoreCountryCenter.getId(),
				trainingCourseTypeList,
				options,
				getTrainingCourseTypeDAO()::countTrainingCourseTypeByCompany,
				getTrainingCourseTypeDAO()::findTrainingCourseTypeByCompany
				);


		retailStoreCountryCenter.setTrainingCourseTypeList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentPublicHolidayList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<PublicHoliday> publicHolidayList = retailStoreCountryCenter.getPublicHolidayList();
				SmartList<PublicHoliday> newList= presentSubList(retailStoreCountryCenter.getId(),
				publicHolidayList,
				options,
				getPublicHolidayDAO()::countPublicHolidayByCompany,
				getPublicHolidayDAO()::findPublicHolidayByCompany
				);


		retailStoreCountryCenter.setPublicHolidayList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentEmployeeList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<Employee> employeeList = retailStoreCountryCenter.getEmployeeList();
				SmartList<Employee> newList= presentSubList(retailStoreCountryCenter.getId(),
				employeeList,
				options,
				getEmployeeDAO()::countEmployeeByCompany,
				getEmployeeDAO()::findEmployeeByCompany
				);


		retailStoreCountryCenter.setEmployeeList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentInstructorList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<Instructor> instructorList = retailStoreCountryCenter.getInstructorList();
				SmartList<Instructor> newList= presentSubList(retailStoreCountryCenter.getId(),
				instructorList,
				options,
				getInstructorDAO()::countInstructorByCompany,
				getInstructorDAO()::findInstructorByCompany
				);


		retailStoreCountryCenter.setInstructorList(newList);


		return retailStoreCountryCenter;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCountryCenter presentCompanyTrainingList(
			RetailStoreCountryCenter retailStoreCountryCenter,
			Map<String, Object> options) {
    
		SmartList<CompanyTraining> companyTrainingList = retailStoreCountryCenter.getCompanyTrainingList();
				SmartList<CompanyTraining> newList= presentSubList(retailStoreCountryCenter.getId(),
				companyTrainingList,
				options,
				getCompanyTrainingDAO()::countCompanyTrainingByCompany,
				getCompanyTrainingDAO()::findCompanyTrainingByCompany
				);


		retailStoreCountryCenter.setCompanyTrainingList(newList);


		return retailStoreCountryCenter;
	}
		

	
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForCatalog(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForRetailStoreProvinceCenter(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForRetailStore(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForRetailStoreMember(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForGoodsSupplier(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForSupplyOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForRetailStoreOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForWarehouse(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForTransportFleet(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForAccountSet(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForLevelOneDepartment(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForSkillType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForResponsibilityType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForTerminationReason(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForTerminationType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForOccupationType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForLeaveType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForSalaryGrade(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForInterviewType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForTrainingCourseType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForPublicHoliday(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForInstructor(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		
    public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForCompanyTraining(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCountryCenterTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getRetailStoreCountryCenterMapper());
    }
		

	protected String getTableName(){
		return RetailStoreCountryCenterTable.TABLE_NAME;
	}



	public void enhanceList(List<RetailStoreCountryCenter> retailStoreCountryCenterList) {
		this.enhanceListInternal(retailStoreCountryCenterList, this.getRetailStoreCountryCenterMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:Catalog的owner的CatalogList
	public SmartList<Catalog> loadOurCatalogList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Catalog.OWNER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Catalog> loadedObjs = userContext.getDAOGroup().getCatalogDAO().findCatalogWithKey(key, options);
		Map<String, List<Catalog>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getOwner().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Catalog> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Catalog> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setCatalogList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreProvinceCenter的country的RetailStoreProvinceCenterList
	public SmartList<RetailStoreProvinceCenter> loadOurRetailStoreProvinceCenterList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreProvinceCenter.COUNTRY_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<RetailStoreProvinceCenter> loadedObjs = userContext.getDAOGroup().getRetailStoreProvinceCenterDAO().findRetailStoreProvinceCenterWithKey(key, options);
		Map<String, List<RetailStoreProvinceCenter>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCountry().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<RetailStoreProvinceCenter> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<RetailStoreProvinceCenter> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setRetailStoreProvinceCenterList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:RetailStore的retailStoreCountryCenter的RetailStoreList
	public SmartList<RetailStore> loadOurRetailStoreList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<RetailStore> loadedObjs = userContext.getDAOGroup().getRetailStoreDAO().findRetailStoreWithKey(key, options);
		Map<String, List<RetailStore>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getRetailStoreCountryCenter().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<RetailStore> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<RetailStore> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setRetailStoreList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreMember的owner的RetailStoreMemberList
	public SmartList<RetailStoreMember> loadOurRetailStoreMemberList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreMember.OWNER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<RetailStoreMember> loadedObjs = userContext.getDAOGroup().getRetailStoreMemberDAO().findRetailStoreMemberWithKey(key, options);
		Map<String, List<RetailStoreMember>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getOwner().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<RetailStoreMember> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<RetailStoreMember> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setRetailStoreMemberList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:GoodsSupplier的belongTo的GoodsSupplierList
	public SmartList<GoodsSupplier> loadOurGoodsSupplierList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(GoodsSupplier.BELONG_TO_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<GoodsSupplier> loadedObjs = userContext.getDAOGroup().getGoodsSupplierDAO().findGoodsSupplierWithKey(key, options);
		Map<String, List<GoodsSupplier>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getBelongTo().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<GoodsSupplier> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<GoodsSupplier> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setGoodsSupplierList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:SupplyOrder的buyer的SupplyOrderList
	public SmartList<SupplyOrder> loadOurSupplyOrderList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SupplyOrder.BUYER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<SupplyOrder> loadedObjs = userContext.getDAOGroup().getSupplyOrderDAO().findSupplyOrderWithKey(key, options);
		Map<String, List<SupplyOrder>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getBuyer().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<SupplyOrder> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<SupplyOrder> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setSupplyOrderList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreOrder的seller的RetailStoreOrderList
	public SmartList<RetailStoreOrder> loadOurRetailStoreOrderList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreOrder.SELLER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<RetailStoreOrder> loadedObjs = userContext.getDAOGroup().getRetailStoreOrderDAO().findRetailStoreOrderWithKey(key, options);
		Map<String, List<RetailStoreOrder>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getSeller().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<RetailStoreOrder> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<RetailStoreOrder> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setRetailStoreOrderList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:Warehouse的owner的WarehouseList
	public SmartList<Warehouse> loadOurWarehouseList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Warehouse.OWNER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Warehouse> loadedObjs = userContext.getDAOGroup().getWarehouseDAO().findWarehouseWithKey(key, options);
		Map<String, List<Warehouse>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getOwner().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Warehouse> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Warehouse> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setWarehouseList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:TransportFleet的owner的TransportFleetList
	public SmartList<TransportFleet> loadOurTransportFleetList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TransportFleet.OWNER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<TransportFleet> loadedObjs = userContext.getDAOGroup().getTransportFleetDAO().findTransportFleetWithKey(key, options);
		Map<String, List<TransportFleet>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getOwner().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<TransportFleet> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<TransportFleet> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setTransportFleetList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:AccountSet的countryCenter的AccountSetList
	public SmartList<AccountSet> loadOurAccountSetList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AccountSet.COUNTRY_CENTER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<AccountSet> loadedObjs = userContext.getDAOGroup().getAccountSetDAO().findAccountSetWithKey(key, options);
		Map<String, List<AccountSet>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCountryCenter().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<AccountSet> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<AccountSet> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setAccountSetList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:LevelOneDepartment的belongsTo的LevelOneDepartmentList
	public SmartList<LevelOneDepartment> loadOurLevelOneDepartmentList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LevelOneDepartment.BELONGS_TO_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<LevelOneDepartment> loadedObjs = userContext.getDAOGroup().getLevelOneDepartmentDAO().findLevelOneDepartmentWithKey(key, options);
		Map<String, List<LevelOneDepartment>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getBelongsTo().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<LevelOneDepartment> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<LevelOneDepartment> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setLevelOneDepartmentList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:SkillType的company的SkillTypeList
	public SmartList<SkillType> loadOurSkillTypeList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SkillType.COMPANY_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<SkillType> loadedObjs = userContext.getDAOGroup().getSkillTypeDAO().findSkillTypeWithKey(key, options);
		Map<String, List<SkillType>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCompany().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<SkillType> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<SkillType> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setSkillTypeList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:ResponsibilityType的company的ResponsibilityTypeList
	public SmartList<ResponsibilityType> loadOurResponsibilityTypeList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ResponsibilityType.COMPANY_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ResponsibilityType> loadedObjs = userContext.getDAOGroup().getResponsibilityTypeDAO().findResponsibilityTypeWithKey(key, options);
		Map<String, List<ResponsibilityType>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCompany().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ResponsibilityType> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ResponsibilityType> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setResponsibilityTypeList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:TerminationReason的company的TerminationReasonList
	public SmartList<TerminationReason> loadOurTerminationReasonList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TerminationReason.COMPANY_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<TerminationReason> loadedObjs = userContext.getDAOGroup().getTerminationReasonDAO().findTerminationReasonWithKey(key, options);
		Map<String, List<TerminationReason>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCompany().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<TerminationReason> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<TerminationReason> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setTerminationReasonList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:TerminationType的company的TerminationTypeList
	public SmartList<TerminationType> loadOurTerminationTypeList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TerminationType.COMPANY_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<TerminationType> loadedObjs = userContext.getDAOGroup().getTerminationTypeDAO().findTerminationTypeWithKey(key, options);
		Map<String, List<TerminationType>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCompany().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<TerminationType> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<TerminationType> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setTerminationTypeList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:OccupationType的company的OccupationTypeList
	public SmartList<OccupationType> loadOurOccupationTypeList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(OccupationType.COMPANY_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<OccupationType> loadedObjs = userContext.getDAOGroup().getOccupationTypeDAO().findOccupationTypeWithKey(key, options);
		Map<String, List<OccupationType>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCompany().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<OccupationType> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<OccupationType> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setOccupationTypeList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:LeaveType的company的LeaveTypeList
	public SmartList<LeaveType> loadOurLeaveTypeList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LeaveType.COMPANY_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<LeaveType> loadedObjs = userContext.getDAOGroup().getLeaveTypeDAO().findLeaveTypeWithKey(key, options);
		Map<String, List<LeaveType>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCompany().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<LeaveType> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<LeaveType> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setLeaveTypeList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:SalaryGrade的company的SalaryGradeList
	public SmartList<SalaryGrade> loadOurSalaryGradeList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(SalaryGrade.COMPANY_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<SalaryGrade> loadedObjs = userContext.getDAOGroup().getSalaryGradeDAO().findSalaryGradeWithKey(key, options);
		Map<String, List<SalaryGrade>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCompany().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<SalaryGrade> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<SalaryGrade> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setSalaryGradeList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:InterviewType的company的InterviewTypeList
	public SmartList<InterviewType> loadOurInterviewTypeList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(InterviewType.COMPANY_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<InterviewType> loadedObjs = userContext.getDAOGroup().getInterviewTypeDAO().findInterviewTypeWithKey(key, options);
		Map<String, List<InterviewType>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCompany().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<InterviewType> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<InterviewType> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setInterviewTypeList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:TrainingCourseType的company的TrainingCourseTypeList
	public SmartList<TrainingCourseType> loadOurTrainingCourseTypeList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(TrainingCourseType.COMPANY_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<TrainingCourseType> loadedObjs = userContext.getDAOGroup().getTrainingCourseTypeDAO().findTrainingCourseTypeWithKey(key, options);
		Map<String, List<TrainingCourseType>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCompany().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<TrainingCourseType> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<TrainingCourseType> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setTrainingCourseTypeList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:PublicHoliday的company的PublicHolidayList
	public SmartList<PublicHoliday> loadOurPublicHolidayList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PublicHoliday.COMPANY_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<PublicHoliday> loadedObjs = userContext.getDAOGroup().getPublicHolidayDAO().findPublicHolidayWithKey(key, options);
		Map<String, List<PublicHoliday>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCompany().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<PublicHoliday> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<PublicHoliday> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setPublicHolidayList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:Employee的company的EmployeeList
	public SmartList<Employee> loadOurEmployeeList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Employee.COMPANY_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Employee> loadedObjs = userContext.getDAOGroup().getEmployeeDAO().findEmployeeWithKey(key, options);
		Map<String, List<Employee>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCompany().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Employee> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Employee> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setEmployeeList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:Instructor的company的InstructorList
	public SmartList<Instructor> loadOurInstructorList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Instructor.COMPANY_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Instructor> loadedObjs = userContext.getDAOGroup().getInstructorDAO().findInstructorWithKey(key, options);
		Map<String, List<Instructor>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCompany().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Instructor> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Instructor> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setInstructorList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:CompanyTraining的company的CompanyTrainingList
	public SmartList<CompanyTraining> loadOurCompanyTrainingList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CompanyTraining.COMPANY_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<CompanyTraining> loadedObjs = userContext.getDAOGroup().getCompanyTrainingDAO().findCompanyTrainingWithKey(key, options);
		Map<String, List<CompanyTraining>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCompany().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<CompanyTraining> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<CompanyTraining> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setCompanyTrainingList(loadedSmartList);
		});
		return loadedObjs;
	}
	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<RetailStoreCountryCenter> retailStoreCountryCenterList = ownerEntity.collectRefsWithType(RetailStoreCountryCenter.INTERNAL_TYPE);
		this.enhanceList(retailStoreCountryCenterList);

	}

	@Override
	public SmartList<RetailStoreCountryCenter> findRetailStoreCountryCenterWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getRetailStoreCountryCenterMapper());

	}
	@Override
	public int countRetailStoreCountryCenterWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countRetailStoreCountryCenterWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<RetailStoreCountryCenter> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRetailStoreCountryCenterMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<RetailStoreCountryCenter> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getRetailStoreCountryCenterMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateRetailStoreCountryCenter executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateRetailStoreCountryCenter result = new CandidateRetailStoreCountryCenter();
		int pageNo = Math.max(1, query.getPageNo());
		result.setOwnerClass(TextUtil.toCamelCase(query.getOwnerType()));
		result.setOwnerId(query.getOwnerId());
		result.setFilterKey(query.getFilterKey());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase("displayName")));
		result.setGroupByFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase(query.getGroupBy())));

		SmartList candidateList = queryList(sql, parmeters);
		this.alias(candidateList);
		result.setCandidates(candidateList);
		int offSet = (pageNo - 1 ) * query.getPageSize();
		if (candidateList.size() > query.getPageSize()) {
			result.setTotalPage(pageNo+1);
		}else {
			result.setTotalPage(pageNo);
		}
		return result;
	}

	
    
	public Map<String, Integer> countBySql(String sql, Object[] params) {
		if (params == null || params.length == 0) {
			return new HashMap<>();
		}
		List<Map<String, Object>> result = this.getJdbcTemplate().queryForList(sql, params);
		if (result == null || result.isEmpty()) {
			return new HashMap<>();
		}
		Map<String, Integer> cntMap = new HashMap<>();
		for (Map<String, Object> data : result) {
			String key = String.valueOf(data.get("id"));
			Number value = (Number) data.get("count");
			cntMap.put(key, value.intValue());
		}
		this.logSQLAndParameters("countBySql", sql, params, cntMap.size() + " Counts");
		return cntMap;
	}

	public Integer singleCountBySql(String sql, Object[] params) {
		Integer cnt = this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
		logSQLAndParameters("singleCountBySql", sql, params, cnt + "");
		return cnt;
	}

	public BigDecimal summaryBySql(String sql, Object[] params) {
		BigDecimal cnt = this.getJdbcTemplate().queryForObject(sql, params, BigDecimal.class);
		logSQLAndParameters("summaryBySql", sql, params, cnt + "");
		return cnt == null ? BigDecimal.ZERO : cnt;
	}

	public <T> List<T> queryForList(String sql, Object[] params, Class<T> claxx) {
		List<T> result = this.getJdbcTemplate().queryForList(sql, params, claxx);
		logSQLAndParameters("queryForList", sql, params, result.size() + " items");
		return result;
	}

	public Map<String, Object> queryForMap(String sql, Object[] params) throws DataAccessException {
		Map<String, Object> result = null;
		try {
			result = this.getJdbcTemplate().queryForMap(sql, params);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public <T> T queryForObject(String sql, Object[] params, Class<T> claxx) throws DataAccessException {
		T result = null;
		try {
			result = this.getJdbcTemplate().queryForObject(sql, params, claxx);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public List<Map<String, Object>> queryAsMapList(String sql, Object[] params) {
		List<Map<String, Object>> result = getJdbcTemplate().queryForList(sql, params);
		logSQLAndParameters("queryAsMapList", sql, params, result.size() + " items");
		return result;
	}

	public synchronized int updateBySql(String sql, Object[] params) {
		int result = getJdbcTemplate().update(sql, params);
		logSQLAndParameters("updateBySql", sql, params, result + " items");
		return result;
	}

	public void execSqlWithRowCallback(String sql, Object[] args, RowCallbackHandler callback) {
		getJdbcTemplate().query(sql, args, callback);
	}

	public void executeSql(String sql) {
		logSQLAndParameters("executeSql", sql, new Object[] {}, "");
		getJdbcTemplate().execute(sql);
	}


  @Override
  public List<RetailStoreCountryCenter> search(RetailStoreCountryCenterRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected RetailStoreCountryCenterMapper mapper() {
    return getRetailStoreCountryCenterMapper();
  }
}


