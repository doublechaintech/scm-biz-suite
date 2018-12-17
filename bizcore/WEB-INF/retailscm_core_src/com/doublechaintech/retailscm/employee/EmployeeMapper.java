
package com.doublechaintech.retailscm.employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.hrinterview.HrInterview;
import com.doublechaintech.retailscm.termination.Termination;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.jobapplication.JobApplication;
import com.doublechaintech.retailscm.professioninterview.ProfessionInterview;
import com.doublechaintech.retailscm.offeracceptance.OfferAcceptance;
import com.doublechaintech.retailscm.employeeboarding.EmployeeBoarding;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.offerapproval.OfferApproval;

public class EmployeeMapper extends BaseRowMapper<Employee>{
	
	protected Employee internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Employee employee = getEmployee();		
		 		
 		setId(employee, rs, rowNumber); 		
 		setCompany(employee, rs, rowNumber); 		
 		setTitle(employee, rs, rowNumber); 		
 		setDepartment(employee, rs, rowNumber); 		
 		setFamilyName(employee, rs, rowNumber); 		
 		setGivenName(employee, rs, rowNumber); 		
 		setEmail(employee, rs, rowNumber); 		
 		setCity(employee, rs, rowNumber); 		
 		setAddress(employee, rs, rowNumber); 		
 		setCellPhone(employee, rs, rowNumber); 		
 		setOccupation(employee, rs, rowNumber); 		
 		setResponsibleFor(employee, rs, rowNumber); 		
 		setCurrentSalaryGrade(employee, rs, rowNumber); 		
 		setSalaryAccount(employee, rs, rowNumber); 		
 		setJobApplication(employee, rs, rowNumber); 		
 		setProfessionInterview(employee, rs, rowNumber); 		
 		setHrInterview(employee, rs, rowNumber); 		
 		setOfferApproval(employee, rs, rowNumber); 		
 		setOfferAcceptance(employee, rs, rowNumber); 		
 		setEmployeeBoarding(employee, rs, rowNumber); 		
 		setTermination(employee, rs, rowNumber); 		
 		setLastUpdateTime(employee, rs, rowNumber); 		
 		setCurrentStatus(employee, rs, rowNumber); 		
 		setVersion(employee, rs, rowNumber);

		return employee;
	}
	
	protected Employee getEmployee(){
		return new Employee();
	}		
		
	protected void setId(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(EmployeeTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setId(id);
	}
		 		
 	protected void setCompany(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId = rs.getString(EmployeeTable.COLUMN_COMPANY);
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = employee.getCompany();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'employee' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 			
 			return;
 		}
 		employee.setCompany(createEmptyCompany(retailStoreCountryCenterId));
 	}
 	
	protected void setTitle(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String title = rs.getString(EmployeeTable.COLUMN_TITLE);
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setTitle(title);
	}
		 		
 	protected void setDepartment(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
 		String levelThreeDepartmentId = rs.getString(EmployeeTable.COLUMN_DEPARTMENT);
 		if( levelThreeDepartmentId == null){
 			return;
 		}
 		if( levelThreeDepartmentId.isEmpty()){
 			return;
 		}
 		LevelThreeDepartment levelThreeDepartment = employee.getDepartment();
 		if( levelThreeDepartment != null ){
 			//if the root object 'employee' already have the property, just set the id for it;
 			levelThreeDepartment.setId(levelThreeDepartmentId);
 			
 			return;
 		}
 		employee.setDepartment(createEmptyDepartment(levelThreeDepartmentId));
 	}
 	
	protected void setFamilyName(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String familyName = rs.getString(EmployeeTable.COLUMN_FAMILY_NAME);
		if(familyName == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setFamilyName(familyName);
	}
		
	protected void setGivenName(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String givenName = rs.getString(EmployeeTable.COLUMN_GIVEN_NAME);
		if(givenName == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setGivenName(givenName);
	}
		
	protected void setEmail(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String email = rs.getString(EmployeeTable.COLUMN_EMAIL);
		if(email == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setEmail(email);
	}
		
	protected void setCity(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String city = rs.getString(EmployeeTable.COLUMN_CITY);
		if(city == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setCity(city);
	}
		
	protected void setAddress(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String address = rs.getString(EmployeeTable.COLUMN_ADDRESS);
		if(address == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setAddress(address);
	}
		
	protected void setCellPhone(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String cellPhone = rs.getString(EmployeeTable.COLUMN_CELL_PHONE);
		if(cellPhone == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setCellPhone(cellPhone);
	}
		 		
 	protected void setOccupation(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
 		String occupationTypeId = rs.getString(EmployeeTable.COLUMN_OCCUPATION);
 		if( occupationTypeId == null){
 			return;
 		}
 		if( occupationTypeId.isEmpty()){
 			return;
 		}
 		OccupationType occupationType = employee.getOccupation();
 		if( occupationType != null ){
 			//if the root object 'employee' already have the property, just set the id for it;
 			occupationType.setId(occupationTypeId);
 			
 			return;
 		}
 		employee.setOccupation(createEmptyOccupation(occupationTypeId));
 	}
 	 		
 	protected void setResponsibleFor(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
 		String responsibilityTypeId = rs.getString(EmployeeTable.COLUMN_RESPONSIBLE_FOR);
 		if( responsibilityTypeId == null){
 			return;
 		}
 		if( responsibilityTypeId.isEmpty()){
 			return;
 		}
 		ResponsibilityType responsibilityType = employee.getResponsibleFor();
 		if( responsibilityType != null ){
 			//if the root object 'employee' already have the property, just set the id for it;
 			responsibilityType.setId(responsibilityTypeId);
 			
 			return;
 		}
 		employee.setResponsibleFor(createEmptyResponsibleFor(responsibilityTypeId));
 	}
 	 		
 	protected void setCurrentSalaryGrade(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
 		String salaryGradeId = rs.getString(EmployeeTable.COLUMN_CURRENT_SALARY_GRADE);
 		if( salaryGradeId == null){
 			return;
 		}
 		if( salaryGradeId.isEmpty()){
 			return;
 		}
 		SalaryGrade salaryGrade = employee.getCurrentSalaryGrade();
 		if( salaryGrade != null ){
 			//if the root object 'employee' already have the property, just set the id for it;
 			salaryGrade.setId(salaryGradeId);
 			
 			return;
 		}
 		employee.setCurrentSalaryGrade(createEmptyCurrentSalaryGrade(salaryGradeId));
 	}
 	
	protected void setSalaryAccount(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String salaryAccount = rs.getString(EmployeeTable.COLUMN_SALARY_ACCOUNT);
		if(salaryAccount == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setSalaryAccount(salaryAccount);
	}
		 		
 	protected void setJobApplication(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
 		String jobApplicationId = rs.getString(EmployeeTable.COLUMN_JOB_APPLICATION);
 		if( jobApplicationId == null){
 			return;
 		}
 		if( jobApplicationId.isEmpty()){
 			return;
 		}
 		JobApplication jobApplication = employee.getJobApplication();
 		if( jobApplication != null ){
 			//if the root object 'employee' already have the property, just set the id for it;
 			jobApplication.setId(jobApplicationId);
 			
 			return;
 		}
 		employee.setJobApplication(createEmptyJobApplication(jobApplicationId));
 	}
 	 		
 	protected void setProfessionInterview(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
 		String professionInterviewId = rs.getString(EmployeeTable.COLUMN_PROFESSION_INTERVIEW);
 		if( professionInterviewId == null){
 			return;
 		}
 		if( professionInterviewId.isEmpty()){
 			return;
 		}
 		ProfessionInterview professionInterview = employee.getProfessionInterview();
 		if( professionInterview != null ){
 			//if the root object 'employee' already have the property, just set the id for it;
 			professionInterview.setId(professionInterviewId);
 			
 			return;
 		}
 		employee.setProfessionInterview(createEmptyProfessionInterview(professionInterviewId));
 	}
 	 		
 	protected void setHrInterview(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
 		String hrInterviewId = rs.getString(EmployeeTable.COLUMN_HR_INTERVIEW);
 		if( hrInterviewId == null){
 			return;
 		}
 		if( hrInterviewId.isEmpty()){
 			return;
 		}
 		HrInterview hrInterview = employee.getHrInterview();
 		if( hrInterview != null ){
 			//if the root object 'employee' already have the property, just set the id for it;
 			hrInterview.setId(hrInterviewId);
 			
 			return;
 		}
 		employee.setHrInterview(createEmptyHrInterview(hrInterviewId));
 	}
 	 		
 	protected void setOfferApproval(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
 		String offerApprovalId = rs.getString(EmployeeTable.COLUMN_OFFER_APPROVAL);
 		if( offerApprovalId == null){
 			return;
 		}
 		if( offerApprovalId.isEmpty()){
 			return;
 		}
 		OfferApproval offerApproval = employee.getOfferApproval();
 		if( offerApproval != null ){
 			//if the root object 'employee' already have the property, just set the id for it;
 			offerApproval.setId(offerApprovalId);
 			
 			return;
 		}
 		employee.setOfferApproval(createEmptyOfferApproval(offerApprovalId));
 	}
 	 		
 	protected void setOfferAcceptance(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
 		String offerAcceptanceId = rs.getString(EmployeeTable.COLUMN_OFFER_ACCEPTANCE);
 		if( offerAcceptanceId == null){
 			return;
 		}
 		if( offerAcceptanceId.isEmpty()){
 			return;
 		}
 		OfferAcceptance offerAcceptance = employee.getOfferAcceptance();
 		if( offerAcceptance != null ){
 			//if the root object 'employee' already have the property, just set the id for it;
 			offerAcceptance.setId(offerAcceptanceId);
 			
 			return;
 		}
 		employee.setOfferAcceptance(createEmptyOfferAcceptance(offerAcceptanceId));
 	}
 	 		
 	protected void setEmployeeBoarding(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
 		String employeeBoardingId = rs.getString(EmployeeTable.COLUMN_EMPLOYEE_BOARDING);
 		if( employeeBoardingId == null){
 			return;
 		}
 		if( employeeBoardingId.isEmpty()){
 			return;
 		}
 		EmployeeBoarding employeeBoarding = employee.getEmployeeBoarding();
 		if( employeeBoarding != null ){
 			//if the root object 'employee' already have the property, just set the id for it;
 			employeeBoarding.setId(employeeBoardingId);
 			
 			return;
 		}
 		employee.setEmployeeBoarding(createEmptyEmployeeBoarding(employeeBoardingId));
 	}
 	 		
 	protected void setTermination(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
 		String terminationId = rs.getString(EmployeeTable.COLUMN_TERMINATION);
 		if( terminationId == null){
 			return;
 		}
 		if( terminationId.isEmpty()){
 			return;
 		}
 		Termination termination = employee.getTermination();
 		if( termination != null ){
 			//if the root object 'employee' already have the property, just set the id for it;
 			termination.setId(terminationId);
 			
 			return;
 		}
 		employee.setTermination(createEmptyTermination(terminationId));
 	}
 	
	protected void setLastUpdateTime(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date lastUpdateTime = rs.getTimestamp(EmployeeTable.COLUMN_LAST_UPDATE_TIME);
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		
	protected void setCurrentStatus(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String currentStatus = rs.getString(EmployeeTable.COLUMN_CURRENT_STATUS);
		if(currentStatus == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setCurrentStatus(currentStatus);
	}
		
	protected void setVersion(Employee employee, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(EmployeeTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		employee.setVersion(version);
	}
		
		

 	protected RetailStoreCountryCenter  createEmptyCompany(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
 	protected LevelThreeDepartment  createEmptyDepartment(String levelThreeDepartmentId){
 		LevelThreeDepartment levelThreeDepartment = new LevelThreeDepartment();
 		levelThreeDepartment.setId(levelThreeDepartmentId);
 		levelThreeDepartment.setVersion(Integer.MAX_VALUE);
 		return levelThreeDepartment;
 	}
 	
 	protected OccupationType  createEmptyOccupation(String occupationTypeId){
 		OccupationType occupationType = new OccupationType();
 		occupationType.setId(occupationTypeId);
 		occupationType.setVersion(Integer.MAX_VALUE);
 		return occupationType;
 	}
 	
 	protected ResponsibilityType  createEmptyResponsibleFor(String responsibilityTypeId){
 		ResponsibilityType responsibilityType = new ResponsibilityType();
 		responsibilityType.setId(responsibilityTypeId);
 		responsibilityType.setVersion(Integer.MAX_VALUE);
 		return responsibilityType;
 	}
 	
 	protected SalaryGrade  createEmptyCurrentSalaryGrade(String salaryGradeId){
 		SalaryGrade salaryGrade = new SalaryGrade();
 		salaryGrade.setId(salaryGradeId);
 		salaryGrade.setVersion(Integer.MAX_VALUE);
 		return salaryGrade;
 	}
 	
 	protected JobApplication  createEmptyJobApplication(String jobApplicationId){
 		JobApplication jobApplication = new JobApplication();
 		jobApplication.setId(jobApplicationId);
 		jobApplication.setVersion(Integer.MAX_VALUE);
 		return jobApplication;
 	}
 	
 	protected ProfessionInterview  createEmptyProfessionInterview(String professionInterviewId){
 		ProfessionInterview professionInterview = new ProfessionInterview();
 		professionInterview.setId(professionInterviewId);
 		professionInterview.setVersion(Integer.MAX_VALUE);
 		return professionInterview;
 	}
 	
 	protected HrInterview  createEmptyHrInterview(String hrInterviewId){
 		HrInterview hrInterview = new HrInterview();
 		hrInterview.setId(hrInterviewId);
 		hrInterview.setVersion(Integer.MAX_VALUE);
 		return hrInterview;
 	}
 	
 	protected OfferApproval  createEmptyOfferApproval(String offerApprovalId){
 		OfferApproval offerApproval = new OfferApproval();
 		offerApproval.setId(offerApprovalId);
 		offerApproval.setVersion(Integer.MAX_VALUE);
 		return offerApproval;
 	}
 	
 	protected OfferAcceptance  createEmptyOfferAcceptance(String offerAcceptanceId){
 		OfferAcceptance offerAcceptance = new OfferAcceptance();
 		offerAcceptance.setId(offerAcceptanceId);
 		offerAcceptance.setVersion(Integer.MAX_VALUE);
 		return offerAcceptance;
 	}
 	
 	protected EmployeeBoarding  createEmptyEmployeeBoarding(String employeeBoardingId){
 		EmployeeBoarding employeeBoarding = new EmployeeBoarding();
 		employeeBoarding.setId(employeeBoardingId);
 		employeeBoarding.setVersion(Integer.MAX_VALUE);
 		return employeeBoarding;
 	}
 	
 	protected Termination  createEmptyTermination(String terminationId){
 		Termination termination = new Termination();
 		termination.setId(terminationId);
 		termination.setVersion(Integer.MAX_VALUE);
 		return termination;
 	}
 	
}


