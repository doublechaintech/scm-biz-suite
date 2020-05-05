
package com.doublechaintech.retailscm.scoring;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class ScoringMapper extends BaseRowMapper<Scoring>{
	
	protected Scoring internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Scoring scoring = getScoring();		
		 		
 		setId(scoring, rs, rowNumber); 		
 		setScoredBy(scoring, rs, rowNumber); 		
 		setScore(scoring, rs, rowNumber); 		
 		setComment(scoring, rs, rowNumber); 		
 		setVersion(scoring, rs, rowNumber);

		return scoring;
	}
	
	protected Scoring getScoring(){
		return new Scoring();
	}		
		
	protected void setId(Scoring scoring, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(ScoringTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		scoring.setId(id);
	}
		
	protected void setScoredBy(Scoring scoring, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String scoredBy = rs.getString(ScoringTable.COLUMN_SCORED_BY);
		
		if(scoredBy == null){
			//do nothing when nothing found in database
			return;
		}
		
		scoring.setScoredBy(scoredBy);
	}
		
	protected void setScore(Scoring scoring, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer score = rs.getInt(ScoringTable.COLUMN_SCORE);
		
		if(score == null){
			//do nothing when nothing found in database
			return;
		}
		
		scoring.setScore(score);
	}
		
	protected void setComment(Scoring scoring, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String comment = rs.getString(ScoringTable.COLUMN_COMMENT);
		
		if(comment == null){
			//do nothing when nothing found in database
			return;
		}
		
		scoring.setComment(comment);
	}
		
	protected void setVersion(Scoring scoring, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(ScoringTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		scoring.setVersion(version);
	}
		
		

}


