
package com.doublechaintech.retailscm.accountingdocumentposting;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class AccountingDocumentPostingMapper extends BaseRowMapper<AccountingDocumentPosting>{
	
	protected AccountingDocumentPosting internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		AccountingDocumentPosting accountingDocumentPosting = getAccountingDocumentPosting();		
		 		
 		setId(accountingDocumentPosting, rs, rowNumber); 		
 		setWho(accountingDocumentPosting, rs, rowNumber); 		
 		setComments(accountingDocumentPosting, rs, rowNumber); 		
 		setMakeDate(accountingDocumentPosting, rs, rowNumber); 		
 		setVersion(accountingDocumentPosting, rs, rowNumber);

		return accountingDocumentPosting;
	}
	
	protected AccountingDocumentPosting getAccountingDocumentPosting(){
		return new AccountingDocumentPosting();
	}		
		
	protected void setId(AccountingDocumentPosting accountingDocumentPosting, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(AccountingDocumentPostingTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentPosting.setId(id);
	}
		
	protected void setWho(AccountingDocumentPosting accountingDocumentPosting, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(AccountingDocumentPostingTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentPosting.setWho(who);
	}
		
	protected void setComments(AccountingDocumentPosting accountingDocumentPosting, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String comments = rs.getString(AccountingDocumentPostingTable.COLUMN_COMMENTS);
		if(comments == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentPosting.setComments(comments);
	}
		
	protected void setMakeDate(AccountingDocumentPosting accountingDocumentPosting, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date makeDate = rs.getDate(AccountingDocumentPostingTable.COLUMN_MAKE_DATE);
		if(makeDate == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentPosting.setMakeDate(makeDate);
	}
		
	protected void setVersion(AccountingDocumentPosting accountingDocumentPosting, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(AccountingDocumentPostingTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentPosting.setVersion(version);
	}
		
		

}


