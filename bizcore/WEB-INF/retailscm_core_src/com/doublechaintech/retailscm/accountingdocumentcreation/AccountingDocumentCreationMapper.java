
package com.doublechaintech.retailscm.accountingdocumentcreation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class AccountingDocumentCreationMapper extends BaseRowMapper<AccountingDocumentCreation>{
	
	protected AccountingDocumentCreation internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		AccountingDocumentCreation accountingDocumentCreation = getAccountingDocumentCreation();		
		 		
 		setId(accountingDocumentCreation, rs, rowNumber); 		
 		setWho(accountingDocumentCreation, rs, rowNumber); 		
 		setComments(accountingDocumentCreation, rs, rowNumber); 		
 		setMakeDate(accountingDocumentCreation, rs, rowNumber); 		
 		setVersion(accountingDocumentCreation, rs, rowNumber);

		return accountingDocumentCreation;
	}
	
	protected AccountingDocumentCreation getAccountingDocumentCreation(){
		return new AccountingDocumentCreation();
	}		
		
	protected void setId(AccountingDocumentCreation accountingDocumentCreation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(AccountingDocumentCreationTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentCreation.setId(id);
	}
		
	protected void setWho(AccountingDocumentCreation accountingDocumentCreation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(AccountingDocumentCreationTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentCreation.setWho(who);
	}
		
	protected void setComments(AccountingDocumentCreation accountingDocumentCreation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String comments = rs.getString(AccountingDocumentCreationTable.COLUMN_COMMENTS);
		if(comments == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentCreation.setComments(comments);
	}
		
	protected void setMakeDate(AccountingDocumentCreation accountingDocumentCreation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date makeDate = rs.getDate(AccountingDocumentCreationTable.COLUMN_MAKE_DATE);
		if(makeDate == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentCreation.setMakeDate(makeDate);
	}
		
	protected void setVersion(AccountingDocumentCreation accountingDocumentCreation, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(AccountingDocumentCreationTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentCreation.setVersion(version);
	}
		
		

}


