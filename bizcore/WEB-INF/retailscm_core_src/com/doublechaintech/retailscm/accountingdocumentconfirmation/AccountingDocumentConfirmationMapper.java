
package com.doublechaintech.retailscm.accountingdocumentconfirmation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class AccountingDocumentConfirmationMapper extends BaseRowMapper<AccountingDocumentConfirmation>{
	
	protected AccountingDocumentConfirmation internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		AccountingDocumentConfirmation accountingDocumentConfirmation = getAccountingDocumentConfirmation();		
		 		
 		setId(accountingDocumentConfirmation, rs, rowNumber); 		
 		setWho(accountingDocumentConfirmation, rs, rowNumber); 		
 		setComments(accountingDocumentConfirmation, rs, rowNumber); 		
 		setMakeDate(accountingDocumentConfirmation, rs, rowNumber); 		
 		setVersion(accountingDocumentConfirmation, rs, rowNumber);

		return accountingDocumentConfirmation;
	}
	
	protected AccountingDocumentConfirmation getAccountingDocumentConfirmation(){
		return new AccountingDocumentConfirmation();
	}		
		
	protected void setId(AccountingDocumentConfirmation accountingDocumentConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(AccountingDocumentConfirmationTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentConfirmation.setId(id);
	}
		
	protected void setWho(AccountingDocumentConfirmation accountingDocumentConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(AccountingDocumentConfirmationTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentConfirmation.setWho(who);
	}
		
	protected void setComments(AccountingDocumentConfirmation accountingDocumentConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String comments = rs.getString(AccountingDocumentConfirmationTable.COLUMN_COMMENTS);
		if(comments == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentConfirmation.setComments(comments);
	}
		
	protected void setMakeDate(AccountingDocumentConfirmation accountingDocumentConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date makeDate = rs.getDate(AccountingDocumentConfirmationTable.COLUMN_MAKE_DATE);
		if(makeDate == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentConfirmation.setMakeDate(makeDate);
	}
		
	protected void setVersion(AccountingDocumentConfirmation accountingDocumentConfirmation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(AccountingDocumentConfirmationTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentConfirmation.setVersion(version);
	}
		
		

}


