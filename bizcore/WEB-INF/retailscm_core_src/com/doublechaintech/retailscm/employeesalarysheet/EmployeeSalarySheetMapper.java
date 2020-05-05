
package com.doublechaintech.retailscm.employeesalarysheet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;

public class EmployeeSalarySheetMapper extends BaseRowMapper<EmployeeSalarySheet>{
	
	protected EmployeeSalarySheet internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		EmployeeSalarySheet employeeSalarySheet = getEmployeeSalarySheet();		
		 		
 		setId(employeeSalarySheet, rs, rowNumber); 		
 		setEmployee(employeeSalarySheet, rs, rowNumber); 		
 		setCurrentSalaryGrade(employeeSalarySheet, rs, rowNumber); 		
 		setBaseSalary(employeeSalarySheet, rs, rowNumber); 		
 		setBonus(employeeSalarySheet, rs, rowNumber); 		
 		setReward(employeeSalarySheet, rs, rowNumber); 		
 		setPersonalTax(employeeSalarySheet, rs, rowNumber); 		
 		setSocialSecurity(employeeSalarySheet, rs, rowNumber); 		
 		setHousingFound(employeeSalarySheet, rs, rowNumber); 		
 		setJobInsurance(employeeSalarySheet, rs, rowNumber); 		
 		setPayingOff(employeeSalarySheet, rs, rowNumber); 		
 		setVersion(employeeSalarySheet, rs, rowNumber);

		return employeeSalarySheet;
	}
	
	protected EmployeeSalarySheet getEmployeeSalarySheet(){
		return new EmployeeSalarySheet();
	}		
		
	protected void setId(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(EmployeeSalarySheetTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeSalarySheet.setId(id);
	}
		 		
 	protected void setEmployee(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
 		String employeeId = rs.getString(EmployeeSalarySheetTable.COLUMN_EMPLOYEE);
 		if( employeeId == null){
 			return;
 		}
 		if( employeeId.isEmpty()){
 			return;
 		}
 		Employee employee = employeeSalarySheet.getEmployee();
 		if( employee != null ){
 			//if the root object 'employeeSalarySheet' already have the property, just set the id for it;
 			employee.setId(employeeId);
 			
 			return;
 		}
 		employeeSalarySheet.setEmployee(createEmptyEmployee(employeeId));
 	}
 	 		
 	protected void setCurrentSalaryGrade(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
 		String salaryGradeId = rs.getString(EmployeeSalarySheetTable.COLUMN_CURRENT_SALARY_GRADE);
 		if( salaryGradeId == null){
 			return;
 		}
 		if( salaryGradeId.isEmpty()){
 			return;
 		}
 		SalaryGrade salaryGrade = employeeSalarySheet.getCurrentSalaryGrade();
 		if( salaryGrade != null ){
 			//if the root object 'employeeSalarySheet' already have the property, just set the id for it;
 			salaryGrade.setId(salaryGradeId);
 			
 			return;
 		}
 		employeeSalarySheet.setCurrentSalaryGrade(createEmptyCurrentSalaryGrade(salaryGradeId));
 	}
 	
	protected void setBaseSalary(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal baseSalary = rs.getBigDecimal(EmployeeSalarySheetTable.COLUMN_BASE_SALARY);
		
		if(baseSalary == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeSalarySheet.setBaseSalary(baseSalary);
	}
		
	protected void setBonus(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal bonus = rs.getBigDecimal(EmployeeSalarySheetTable.COLUMN_BONUS);
		
		if(bonus == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeSalarySheet.setBonus(bonus);
	}
		
	protected void setReward(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal reward = rs.getBigDecimal(EmployeeSalarySheetTable.COLUMN_REWARD);
		
		if(reward == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeSalarySheet.setReward(reward);
	}
		
	protected void setPersonalTax(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal personalTax = rs.getBigDecimal(EmployeeSalarySheetTable.COLUMN_PERSONAL_TAX);
		
		if(personalTax == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeSalarySheet.setPersonalTax(personalTax);
	}
		
	protected void setSocialSecurity(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal socialSecurity = rs.getBigDecimal(EmployeeSalarySheetTable.COLUMN_SOCIAL_SECURITY);
		
		if(socialSecurity == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeSalarySheet.setSocialSecurity(socialSecurity);
	}
		
	protected void setHousingFound(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal housingFound = rs.getBigDecimal(EmployeeSalarySheetTable.COLUMN_HOUSING_FOUND);
		
		if(housingFound == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeSalarySheet.setHousingFound(housingFound);
	}
		
	protected void setJobInsurance(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal jobInsurance = rs.getBigDecimal(EmployeeSalarySheetTable.COLUMN_JOB_INSURANCE);
		
		if(jobInsurance == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeSalarySheet.setJobInsurance(jobInsurance);
	}
		 		
 	protected void setPayingOff(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
 		String payingOffId = rs.getString(EmployeeSalarySheetTable.COLUMN_PAYING_OFF);
 		if( payingOffId == null){
 			return;
 		}
 		if( payingOffId.isEmpty()){
 			return;
 		}
 		PayingOff payingOff = employeeSalarySheet.getPayingOff();
 		if( payingOff != null ){
 			//if the root object 'employeeSalarySheet' already have the property, just set the id for it;
 			payingOff.setId(payingOffId);
 			
 			return;
 		}
 		employeeSalarySheet.setPayingOff(createEmptyPayingOff(payingOffId));
 	}
 	
	protected void setVersion(EmployeeSalarySheet employeeSalarySheet, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(EmployeeSalarySheetTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		employeeSalarySheet.setVersion(version);
	}
		
		

 	protected Employee  createEmptyEmployee(String employeeId){
 		Employee employee = new Employee();
 		employee.setId(employeeId);
 		employee.setVersion(Integer.MAX_VALUE);
 		return employee;
 	}
 	
 	protected SalaryGrade  createEmptyCurrentSalaryGrade(String salaryGradeId){
 		SalaryGrade salaryGrade = new SalaryGrade();
 		salaryGrade.setId(salaryGradeId);
 		salaryGrade.setVersion(Integer.MAX_VALUE);
 		return salaryGrade;
 	}
 	
 	protected PayingOff  createEmptyPayingOff(String payingOffId){
 		PayingOff payingOff = new PayingOff();
 		payingOff.setId(payingOffId);
 		payingOff.setVersion(Integer.MAX_VALUE);
 		return payingOff;
 	}
 	
}


