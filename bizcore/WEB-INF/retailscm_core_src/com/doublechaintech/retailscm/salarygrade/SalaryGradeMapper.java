
package com.doublechaintech.retailscm.salarygrade;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

public class SalaryGradeMapper extends BaseRowMapper<SalaryGrade>{

	protected SalaryGrade internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		SalaryGrade salaryGrade = getSalaryGrade();
		
 		setId(salaryGrade, rs, rowNumber);
 		setCode(salaryGrade, rs, rowNumber);
 		setCompany(salaryGrade, rs, rowNumber);
 		setName(salaryGrade, rs, rowNumber);
 		setDetailDescription(salaryGrade, rs, rowNumber);
 		setVersion(salaryGrade, rs, rowNumber);

    
		return salaryGrade;
	}

	protected SalaryGrade getSalaryGrade(){
	  SalaryGrade entity = new SalaryGrade();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(SalaryGrade salaryGrade, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(SalaryGradeTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		salaryGrade.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setCode(SalaryGrade salaryGrade, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String code = rs.getString(SalaryGradeTable.COLUMN_CODE);
		
		if(code == null){
			//do nothing when nothing found in database
			return;
		}
		
		salaryGrade.setCode(code);
		}catch (SQLException e){

    }
	}
		
 	protected void setCompany(SalaryGrade salaryGrade, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId;
 		try{
 		  retailStoreCountryCenterId = rs.getString(SalaryGradeTable.COLUMN_COMPANY);
 		}catch(SQLException e){
 		  return;
 		}
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = salaryGrade.getCompany();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'salaryGrade' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);

 			return;
 		}
 		salaryGrade.setCompany(createEmptyCompany(retailStoreCountryCenterId));
 	}
 	
	protected void setName(SalaryGrade salaryGrade, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(SalaryGradeTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		salaryGrade.setName(name);
		}catch (SQLException e){

    }
	}
		
	protected void setDetailDescription(SalaryGrade salaryGrade, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String detailDescription = rs.getString(SalaryGradeTable.COLUMN_DETAIL_DESCRIPTION);
		
		if(detailDescription == null){
			//do nothing when nothing found in database
			return;
		}
		
		salaryGrade.setDetailDescription(detailDescription);
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(SalaryGrade salaryGrade, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(SalaryGradeTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		salaryGrade.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected RetailStoreCountryCenter  createEmptyCompany(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
}


