
package com.doublechaintech.retailscm.accountingdocumentauditing;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class AccountingDocumentAuditingMapper extends BaseRowMapper<AccountingDocumentAuditing>{
	
	protected AccountingDocumentAuditing internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		AccountingDocumentAuditing accountingDocumentAuditing = getAccountingDocumentAuditing();		
		 		
 		setId(accountingDocumentAuditing, rs, rowNumber); 		
 		setWho(accountingDocumentAuditing, rs, rowNumber); 		
 		setComments(accountingDocumentAuditing, rs, rowNumber); 		
 		setMakeDate(accountingDocumentAuditing, rs, rowNumber); 		
 		setVersion(accountingDocumentAuditing, rs, rowNumber);

		return accountingDocumentAuditing;
	}
	
	protected AccountingDocumentAuditing getAccountingDocumentAuditing(){
		return new AccountingDocumentAuditing();
	}		
		
	protected void setId(AccountingDocumentAuditing accountingDocumentAuditing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(AccountingDocumentAuditingTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentAuditing.setId(id);
	}
		
	protected void setWho(AccountingDocumentAuditing accountingDocumentAuditing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(AccountingDocumentAuditingTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentAuditing.setWho(who);
	}
		
	protected void setComments(AccountingDocumentAuditing accountingDocumentAuditing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String comments = rs.getString(AccountingDocumentAuditingTable.COLUMN_COMMENTS);
		if(comments == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentAuditing.setComments(comments);
	}
		
	protected void setMakeDate(AccountingDocumentAuditing accountingDocumentAuditing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date makeDate = rs.getDate(AccountingDocumentAuditingTable.COLUMN_MAKE_DATE);
		if(makeDate == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentAuditing.setMakeDate(makeDate);
	}
		
	protected void setVersion(AccountingDocumentAuditing accountingDocumentAuditing, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(AccountingDocumentAuditingTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentAuditing.setVersion(version);
	}
		
		

}


