
package com.doublechaintech.retailscm.payingoff;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.employee.Employee;

public class PayingOffMapper extends BaseRowMapper<PayingOff>{
	
	protected PayingOff internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		PayingOff payingOff = getPayingOff();		
		 		
 		setId(payingOff, rs, rowNumber); 		
 		setWho(payingOff, rs, rowNumber); 		
 		setPaidFor(payingOff, rs, rowNumber); 		
 		setPaidTime(payingOff, rs, rowNumber); 		
 		setAmount(payingOff, rs, rowNumber); 		
 		setVersion(payingOff, rs, rowNumber);

		return payingOff;
	}
	
	protected PayingOff getPayingOff(){
		return new PayingOff();
	}		
		
	protected void setId(PayingOff payingOff, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(PayingOffTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		payingOff.setId(id);
	}
		
	protected void setWho(PayingOff payingOff, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String who = rs.getString(PayingOffTable.COLUMN_WHO);
		
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		payingOff.setWho(who);
	}
		 		
 	protected void setPaidFor(PayingOff payingOff, ResultSet rs, int rowNumber) throws SQLException{
 		String employeeId = rs.getString(PayingOffTable.COLUMN_PAID_FOR);
 		if( employeeId == null){
 			return;
 		}
 		if( employeeId.isEmpty()){
 			return;
 		}
 		Employee employee = payingOff.getPaidFor();
 		if( employee != null ){
 			//if the root object 'payingOff' already have the property, just set the id for it;
 			employee.setId(employeeId);
 			
 			return;
 		}
 		payingOff.setPaidFor(createEmptyPaidFor(employeeId));
 	}
 	
	protected void setPaidTime(PayingOff payingOff, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date paidTime = rs.getDate(PayingOffTable.COLUMN_PAID_TIME);
		
		if(paidTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		payingOff.setPaidTime(paidTime);
	}
		
	protected void setAmount(PayingOff payingOff, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal amount = rs.getBigDecimal(PayingOffTable.COLUMN_AMOUNT);
		
		if(amount == null){
			//do nothing when nothing found in database
			return;
		}
		
		payingOff.setAmount(amount);
	}
		
	protected void setVersion(PayingOff payingOff, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(PayingOffTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		payingOff.setVersion(version);
	}
		
		

 	protected Employee  createEmptyPaidFor(String employeeId){
 		Employee employee = new Employee();
 		employee.setId(employeeId);
 		employee.setVersion(Integer.MAX_VALUE);
 		return employee;
 	}
 	
}


