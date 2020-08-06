
package com.doublechaintech.retailscm.retailstorecountrycenter;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
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


public interface RetailStoreCountryCenterDAO extends BaseDAO{

	public SmartList<RetailStoreCountryCenter> loadAll();
	public Stream<RetailStoreCountryCenter> loadAllAsStream();
	public RetailStoreCountryCenter load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<RetailStoreCountryCenter> retailStoreCountryCenterList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public RetailStoreCountryCenter present(RetailStoreCountryCenter retailStoreCountryCenter,Map<String,Object> options) throws Exception;
	public RetailStoreCountryCenter clone(String id, Map<String,Object> options) throws Exception;

	

	public RetailStoreCountryCenter save(RetailStoreCountryCenter retailStoreCountryCenter,Map<String,Object> options);
	public SmartList<RetailStoreCountryCenter> saveRetailStoreCountryCenterList(SmartList<RetailStoreCountryCenter> retailStoreCountryCenterList,Map<String,Object> options);
	public SmartList<RetailStoreCountryCenter> removeRetailStoreCountryCenterList(SmartList<RetailStoreCountryCenter> retailStoreCountryCenterList,Map<String,Object> options);
	public SmartList<RetailStoreCountryCenter> findRetailStoreCountryCenterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRetailStoreCountryCenterWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRetailStoreCountryCenterWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String retailStoreCountryCenterId, int version) throws Exception;
	public RetailStoreCountryCenter disconnectFromAll(String retailStoreCountryCenterId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public CatalogDAO getCatalogDAO();
		
	public RetailStoreProvinceCenterDAO getRetailStoreProvinceCenterDAO();
		
	public RetailStoreDAO getRetailStoreDAO();
		
	public RetailStoreMemberDAO getRetailStoreMemberDAO();
		
	public GoodsSupplierDAO getGoodsSupplierDAO();
		
	public SupplyOrderDAO getSupplyOrderDAO();
		
	public RetailStoreOrderDAO getRetailStoreOrderDAO();
		
	public WarehouseDAO getWarehouseDAO();
		
	public TransportFleetDAO getTransportFleetDAO();
		
	public AccountSetDAO getAccountSetDAO();
		
	public LevelOneDepartmentDAO getLevelOneDepartmentDAO();
		
	public SkillTypeDAO getSkillTypeDAO();
		
	public ResponsibilityTypeDAO getResponsibilityTypeDAO();
		
	public TerminationReasonDAO getTerminationReasonDAO();
		
	public TerminationTypeDAO getTerminationTypeDAO();
		
	public OccupationTypeDAO getOccupationTypeDAO();
		
	public LeaveTypeDAO getLeaveTypeDAO();
		
	public SalaryGradeDAO getSalaryGradeDAO();
		
	public InterviewTypeDAO getInterviewTypeDAO();
		
	public TrainingCourseTypeDAO getTrainingCourseTypeDAO();
		
	public PublicHolidayDAO getPublicHolidayDAO();
		
	public EmployeeDAO getEmployeeDAO();
		
	public InstructorDAO getInstructorDAO();
		
	public CompanyTrainingDAO getCompanyTrainingDAO();
		
	
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForCatalog(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForRetailStoreProvinceCenter(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForRetailStore(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForRetailStoreMember(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForGoodsSupplier(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForSupplyOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForRetailStoreOrder(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForWarehouse(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForTransportFleet(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForAccountSet(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForLevelOneDepartment(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForSkillType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForResponsibilityType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForTerminationReason(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForTerminationType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForOccupationType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForLeaveType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForSalaryGrade(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForInterviewType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForTrainingCourseType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForPublicHoliday(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForInstructor(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<RetailStoreCountryCenter> requestCandidateRetailStoreCountryCenterForCompanyTraining(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public RetailStoreCountryCenter planToRemoveCatalogList(RetailStoreCountryCenter retailStoreCountryCenter, String catalogIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveRetailStoreProvinceCenterList(RetailStoreCountryCenter retailStoreCountryCenter, String retailStoreProvinceCenterIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveRetailStoreList(RetailStoreCountryCenter retailStoreCountryCenter, String retailStoreIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreCountryCenter with city_service_center in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithCityServiceCenter(RetailStoreCountryCenter retailStoreCountryCenter, String cityServiceCenterId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithCityServiceCenter(String retailStoreCountryCenterId, String cityServiceCenterId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with creation in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithCreation(RetailStoreCountryCenter retailStoreCountryCenter, String creationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithCreation(String retailStoreCountryCenterId, String creationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with investment_invitation in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithInvestmentInvitation(RetailStoreCountryCenter retailStoreCountryCenter, String investmentInvitationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithInvestmentInvitation(String retailStoreCountryCenterId, String investmentInvitationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with franchising in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithFranchising(RetailStoreCountryCenter retailStoreCountryCenter, String franchisingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithFranchising(String retailStoreCountryCenterId, String franchisingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with decoration in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithDecoration(RetailStoreCountryCenter retailStoreCountryCenter, String decorationId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithDecoration(String retailStoreCountryCenterId, String decorationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with opening in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithOpening(RetailStoreCountryCenter retailStoreCountryCenter, String openingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithOpening(String retailStoreCountryCenterId, String openingId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with closing in RetailStore
	public RetailStoreCountryCenter planToRemoveRetailStoreListWithClosing(RetailStoreCountryCenter retailStoreCountryCenter, String closingId, Map<String,Object> options)throws Exception;
	public int countRetailStoreListWithClosing(String retailStoreCountryCenterId, String closingId, Map<String,Object> options)throws Exception;
	
	public RetailStoreCountryCenter planToRemoveRetailStoreMemberList(RetailStoreCountryCenter retailStoreCountryCenter, String retailStoreMemberIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveGoodsSupplierList(RetailStoreCountryCenter retailStoreCountryCenter, String goodsSupplierIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveSupplyOrderList(RetailStoreCountryCenter retailStoreCountryCenter, String supplyOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreCountryCenter with seller in SupplyOrder
	public RetailStoreCountryCenter planToRemoveSupplyOrderListWithSeller(RetailStoreCountryCenter retailStoreCountryCenter, String sellerId, Map<String,Object> options)throws Exception;
	public int countSupplyOrderListWithSeller(String retailStoreCountryCenterId, String sellerId, Map<String,Object> options)throws Exception;
	
	public RetailStoreCountryCenter planToRemoveRetailStoreOrderList(RetailStoreCountryCenter retailStoreCountryCenter, String retailStoreOrderIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreCountryCenter with buyer in RetailStoreOrder
	public RetailStoreCountryCenter planToRemoveRetailStoreOrderListWithBuyer(RetailStoreCountryCenter retailStoreCountryCenter, String buyerId, Map<String,Object> options)throws Exception;
	public int countRetailStoreOrderListWithBuyer(String retailStoreCountryCenterId, String buyerId, Map<String,Object> options)throws Exception;
	
	public RetailStoreCountryCenter planToRemoveWarehouseList(RetailStoreCountryCenter retailStoreCountryCenter, String warehouseIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveTransportFleetList(RetailStoreCountryCenter retailStoreCountryCenter, String transportFleetIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveAccountSetList(RetailStoreCountryCenter retailStoreCountryCenter, String accountSetIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreCountryCenter with retail_store in AccountSet
	public RetailStoreCountryCenter planToRemoveAccountSetListWithRetailStore(RetailStoreCountryCenter retailStoreCountryCenter, String retailStoreId, Map<String,Object> options)throws Exception;
	public int countAccountSetListWithRetailStore(String retailStoreCountryCenterId, String retailStoreId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with goods_supplier in AccountSet
	public RetailStoreCountryCenter planToRemoveAccountSetListWithGoodsSupplier(RetailStoreCountryCenter retailStoreCountryCenter, String goodsSupplierId, Map<String,Object> options)throws Exception;
	public int countAccountSetListWithGoodsSupplier(String retailStoreCountryCenterId, String goodsSupplierId, Map<String,Object> options)throws Exception;
	
	public RetailStoreCountryCenter planToRemoveLevelOneDepartmentList(RetailStoreCountryCenter retailStoreCountryCenter, String levelOneDepartmentIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveSkillTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String skillTypeIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveResponsibilityTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String responsibilityTypeIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveTerminationReasonList(RetailStoreCountryCenter retailStoreCountryCenter, String terminationReasonIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveTerminationTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String terminationTypeIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveOccupationTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String occupationTypeIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveLeaveTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String leaveTypeIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveSalaryGradeList(RetailStoreCountryCenter retailStoreCountryCenter, String salaryGradeIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveInterviewTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String interviewTypeIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveTrainingCourseTypeList(RetailStoreCountryCenter retailStoreCountryCenter, String trainingCourseTypeIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemovePublicHolidayList(RetailStoreCountryCenter retailStoreCountryCenter, String publicHolidayIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveEmployeeList(RetailStoreCountryCenter retailStoreCountryCenter, String employeeIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreCountryCenter with department in Employee
	public RetailStoreCountryCenter planToRemoveEmployeeListWithDepartment(RetailStoreCountryCenter retailStoreCountryCenter, String departmentId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithDepartment(String retailStoreCountryCenterId, String departmentId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with occupation in Employee
	public RetailStoreCountryCenter planToRemoveEmployeeListWithOccupation(RetailStoreCountryCenter retailStoreCountryCenter, String occupationId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithOccupation(String retailStoreCountryCenterId, String occupationId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with responsible_for in Employee
	public RetailStoreCountryCenter planToRemoveEmployeeListWithResponsibleFor(RetailStoreCountryCenter retailStoreCountryCenter, String responsibleForId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithResponsibleFor(String retailStoreCountryCenterId, String responsibleForId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with current_salary_grade in Employee
	public RetailStoreCountryCenter planToRemoveEmployeeListWithCurrentSalaryGrade(RetailStoreCountryCenter retailStoreCountryCenter, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	public int countEmployeeListWithCurrentSalaryGrade(String retailStoreCountryCenterId, String currentSalaryGradeId, Map<String,Object> options)throws Exception;
	
	public RetailStoreCountryCenter planToRemoveInstructorList(RetailStoreCountryCenter retailStoreCountryCenter, String instructorIds[], Map<String,Object> options)throws Exception;


	public RetailStoreCountryCenter planToRemoveCompanyTrainingList(RetailStoreCountryCenter retailStoreCountryCenter, String companyTrainingIds[], Map<String,Object> options)throws Exception;


	//disconnect RetailStoreCountryCenter with instructor in CompanyTraining
	public RetailStoreCountryCenter planToRemoveCompanyTrainingListWithInstructor(RetailStoreCountryCenter retailStoreCountryCenter, String instructorId, Map<String,Object> options)throws Exception;
	public int countCompanyTrainingListWithInstructor(String retailStoreCountryCenterId, String instructorId, Map<String,Object> options)throws Exception;
	
	//disconnect RetailStoreCountryCenter with training_course_type in CompanyTraining
	public RetailStoreCountryCenter planToRemoveCompanyTrainingListWithTrainingCourseType(RetailStoreCountryCenter retailStoreCountryCenter, String trainingCourseTypeId, Map<String,Object> options)throws Exception;
	public int countCompanyTrainingListWithTrainingCourseType(String retailStoreCountryCenterId, String trainingCourseTypeId, Map<String,Object> options)throws Exception;
	

	public SmartList<RetailStoreCountryCenter> queryList(String sql, Object ... parmeters);
	public Stream<RetailStoreCountryCenter> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parmeters);
	public CandidateRetailStoreCountryCenter executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:Catalog的owner的CatalogList
	public SmartList<Catalog> loadOurCatalogList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreProvinceCenter的country的RetailStoreProvinceCenterList
	public SmartList<RetailStoreProvinceCenter> loadOurRetailStoreProvinceCenterList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:RetailStore的retailStoreCountryCenter的RetailStoreList
	public SmartList<RetailStore> loadOurRetailStoreList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreMember的owner的RetailStoreMemberList
	public SmartList<RetailStoreMember> loadOurRetailStoreMemberList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:GoodsSupplier的belongTo的GoodsSupplierList
	public SmartList<GoodsSupplier> loadOurGoodsSupplierList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:SupplyOrder的buyer的SupplyOrderList
	public SmartList<SupplyOrder> loadOurSupplyOrderList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreOrder的seller的RetailStoreOrderList
	public SmartList<RetailStoreOrder> loadOurRetailStoreOrderList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:Warehouse的owner的WarehouseList
	public SmartList<Warehouse> loadOurWarehouseList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:TransportFleet的owner的TransportFleetList
	public SmartList<TransportFleet> loadOurTransportFleetList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:AccountSet的countryCenter的AccountSetList
	public SmartList<AccountSet> loadOurAccountSetList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:LevelOneDepartment的belongsTo的LevelOneDepartmentList
	public SmartList<LevelOneDepartment> loadOurLevelOneDepartmentList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:SkillType的company的SkillTypeList
	public SmartList<SkillType> loadOurSkillTypeList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ResponsibilityType的company的ResponsibilityTypeList
	public SmartList<ResponsibilityType> loadOurResponsibilityTypeList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:TerminationReason的company的TerminationReasonList
	public SmartList<TerminationReason> loadOurTerminationReasonList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:TerminationType的company的TerminationTypeList
	public SmartList<TerminationType> loadOurTerminationTypeList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:OccupationType的company的OccupationTypeList
	public SmartList<OccupationType> loadOurOccupationTypeList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:LeaveType的company的LeaveTypeList
	public SmartList<LeaveType> loadOurLeaveTypeList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:SalaryGrade的company的SalaryGradeList
	public SmartList<SalaryGrade> loadOurSalaryGradeList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:InterviewType的company的InterviewTypeList
	public SmartList<InterviewType> loadOurInterviewTypeList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:TrainingCourseType的company的TrainingCourseTypeList
	public SmartList<TrainingCourseType> loadOurTrainingCourseTypeList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:PublicHoliday的company的PublicHolidayList
	public SmartList<PublicHoliday> loadOurPublicHolidayList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:Employee的company的EmployeeList
	public SmartList<Employee> loadOurEmployeeList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:Instructor的company的InstructorList
	public SmartList<Instructor> loadOurInstructorList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:CompanyTraining的company的CompanyTrainingList
	public SmartList<CompanyTraining> loadOurCompanyTrainingList(RetailscmUserContext userContext, List<RetailStoreCountryCenter> us, Map<String,Object> options) throws Exception;
	
}


