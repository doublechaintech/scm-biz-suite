
package com.doublechaintech.retailscm.offeracceptance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class OfferAcceptanceMapper extends BaseRowMapper<OfferAcceptance>{
	
	protected OfferAcceptance internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		OfferAcceptance offerAcceptance = getOfferAcceptance();		
		 		
 		setId(offerAcceptance, rs, rowNumber); 		
 		setWho(offerAcceptance, rs, rowNumber); 		
 		setAcceptTime(offerAcceptance, rs, rowNumber); 		
 		setComments(offerAcceptance, rs, rowNumber); 		
 		setVersion(offerAcceptance, rs, rowNumber);

		return offerAcceptance;
	}
	
	protected OfferAcceptance getOfferAcceptance(){
		return new OfferAcceptance();
	}		
		
	protected void setId(OfferAcceptance offerAcceptance, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(OfferAcceptanceTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		offerAcceptance.setId(id);
	}
		
	protected void setWho(OfferAcceptance offerAcceptance, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(OfferAcceptanceTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		offerAcceptance.setWho(who);
	}
		
	protected void setAcceptTime(OfferAcceptance offerAcceptance, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date acceptTime = rs.getDate(OfferAcceptanceTable.COLUMN_ACCEPT_TIME);
		if(acceptTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		offerAcceptance.setAcceptTime(acceptTime);
	}
		
	protected void setComments(OfferAcceptance offerAcceptance, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String comments = rs.getString(OfferAcceptanceTable.COLUMN_COMMENTS);
		if(comments == null){
			//do nothing when nothing found in database
			return;
		}
		
		offerAcceptance.setComments(comments);
	}
		
	protected void setVersion(OfferAcceptance offerAcceptance, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(OfferAcceptanceTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		offerAcceptance.setVersion(version);
	}
		
		

}


