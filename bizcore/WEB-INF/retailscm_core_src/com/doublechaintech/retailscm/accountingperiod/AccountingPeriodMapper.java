
package com.doublechaintech.retailscm.accountingperiod;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.accountset.AccountSet;

public class AccountingPeriodMapper extends BaseRowMapper<AccountingPeriod>{

	protected AccountingPeriod internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		AccountingPeriod accountingPeriod = getAccountingPeriod();
		
 		setId(accountingPeriod, rs, rowNumber);
 		setName(accountingPeriod, rs, rowNumber);
 		setStartDate(accountingPeriod, rs, rowNumber);
 		setEndDate(accountingPeriod, rs, rowNumber);
 		setAccountSet(accountingPeriod, rs, rowNumber);
 		setVersion(accountingPeriod, rs, rowNumber);

    
		return accountingPeriod;
	}

	protected AccountingPeriod getAccountingPeriod(){
	  AccountingPeriod entity = new AccountingPeriod();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(AccountingPeriod accountingPeriod, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(AccountingPeriodTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingPeriod.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setName(AccountingPeriod accountingPeriod, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(AccountingPeriodTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingPeriod.setName(name);
		}catch (SQLException e){

    }
	}
		
	protected void setStartDate(AccountingPeriod accountingPeriod, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date startDate = rs.getDate(AccountingPeriodTable.COLUMN_START_DATE);
		
		if(startDate == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingPeriod.setStartDate(startDate);
		}catch (SQLException e){

    }
	}
		
	protected void setEndDate(AccountingPeriod accountingPeriod, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date endDate = rs.getDate(AccountingPeriodTable.COLUMN_END_DATE);
		
		if(endDate == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingPeriod.setEndDate(endDate);
		}catch (SQLException e){

    }
	}
		
 	protected void setAccountSet(AccountingPeriod accountingPeriod, ResultSet rs, int rowNumber) throws SQLException{
 		String accountSetId;
 		try{
 		  accountSetId = rs.getString(AccountingPeriodTable.COLUMN_ACCOUNT_SET);
 		}catch(SQLException e){
 		  return;
 		}
 		if( accountSetId == null){
 			return;
 		}
 		if( accountSetId.isEmpty()){
 			return;
 		}
 		AccountSet accountSet = accountingPeriod.getAccountSet();
 		if( accountSet != null ){
 			//if the root object 'accountingPeriod' already have the property, just set the id for it;
 			accountSet.setId(accountSetId);

 			return;
 		}
 		accountingPeriod.setAccountSet(createEmptyAccountSet(accountSetId));
 	}
 	
	protected void setVersion(AccountingPeriod accountingPeriod, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(AccountingPeriodTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingPeriod.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected AccountSet  createEmptyAccountSet(String accountSetId){
 		AccountSet accountSet = new AccountSet();
 		accountSet.setId(accountSetId);
 		accountSet.setVersion(Integer.MAX_VALUE);
 		return accountSet;
 	}
 	
}


