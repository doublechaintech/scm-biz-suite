
package com.doublechaintech.retailscm.accountingsubject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.accountset.AccountSet;

public class AccountingSubjectMapper extends BaseRowMapper<AccountingSubject>{
	
	protected AccountingSubject internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		AccountingSubject accountingSubject = getAccountingSubject();		
		 		
 		setId(accountingSubject, rs, rowNumber); 		
 		setAccountingSubjectCode(accountingSubject, rs, rowNumber); 		
 		setAccountingSubjectName(accountingSubject, rs, rowNumber); 		
 		setAccountingSubjectClassCode(accountingSubject, rs, rowNumber); 		
 		setAccountingSubjectClassName(accountingSubject, rs, rowNumber); 		
 		setAccountSet(accountingSubject, rs, rowNumber); 		
 		setVersion(accountingSubject, rs, rowNumber);

		return accountingSubject;
	}
	
	protected AccountingSubject getAccountingSubject(){
		return new AccountingSubject();
	}		
		
	protected void setId(AccountingSubject accountingSubject, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(AccountingSubjectTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingSubject.setId(id);
	}
		
	protected void setAccountingSubjectCode(AccountingSubject accountingSubject, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String accountingSubjectCode = rs.getString(AccountingSubjectTable.COLUMN_ACCOUNTING_SUBJECT_CODE);
		
		if(accountingSubjectCode == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingSubject.setAccountingSubjectCode(accountingSubjectCode);
	}
		
	protected void setAccountingSubjectName(AccountingSubject accountingSubject, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String accountingSubjectName = rs.getString(AccountingSubjectTable.COLUMN_ACCOUNTING_SUBJECT_NAME);
		
		if(accountingSubjectName == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingSubject.setAccountingSubjectName(accountingSubjectName);
	}
		
	protected void setAccountingSubjectClassCode(AccountingSubject accountingSubject, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer accountingSubjectClassCode = rs.getInt(AccountingSubjectTable.COLUMN_ACCOUNTING_SUBJECT_CLASS_CODE);
		
		if(accountingSubjectClassCode == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingSubject.setAccountingSubjectClassCode(accountingSubjectClassCode);
	}
		
	protected void setAccountingSubjectClassName(AccountingSubject accountingSubject, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String accountingSubjectClassName = rs.getString(AccountingSubjectTable.COLUMN_ACCOUNTING_SUBJECT_CLASS_NAME);
		
		if(accountingSubjectClassName == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingSubject.setAccountingSubjectClassName(accountingSubjectClassName);
	}
		 		
 	protected void setAccountSet(AccountingSubject accountingSubject, ResultSet rs, int rowNumber) throws SQLException{
 		String accountSetId = rs.getString(AccountingSubjectTable.COLUMN_ACCOUNT_SET);
 		if( accountSetId == null){
 			return;
 		}
 		if( accountSetId.isEmpty()){
 			return;
 		}
 		AccountSet accountSet = accountingSubject.getAccountSet();
 		if( accountSet != null ){
 			//if the root object 'accountingSubject' already have the property, just set the id for it;
 			accountSet.setId(accountSetId);
 			
 			return;
 		}
 		accountingSubject.setAccountSet(createEmptyAccountSet(accountSetId));
 	}
 	
	protected void setVersion(AccountingSubject accountingSubject, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(AccountingSubjectTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingSubject.setVersion(version);
	}
		
		

 	protected AccountSet  createEmptyAccountSet(String accountSetId){
 		AccountSet accountSet = new AccountSet();
 		accountSet.setId(accountSetId);
 		accountSet.setVersion(Integer.MAX_VALUE);
 		return accountSet;
 	}
 	
}


