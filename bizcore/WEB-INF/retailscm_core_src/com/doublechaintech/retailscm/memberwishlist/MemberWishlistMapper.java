
package com.doublechaintech.retailscm.memberwishlist;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;

public class MemberWishlistMapper extends BaseRowMapper<MemberWishlist>{

	protected MemberWishlist internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		MemberWishlist memberWishlist = getMemberWishlist();
		
 		setId(memberWishlist, rs, rowNumber);
 		setName(memberWishlist, rs, rowNumber);
 		setOwner(memberWishlist, rs, rowNumber);
 		setVersion(memberWishlist, rs, rowNumber);

    
		return memberWishlist;
	}

	protected MemberWishlist getMemberWishlist(){
	  MemberWishlist entity = new MemberWishlist();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(MemberWishlist memberWishlist, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(MemberWishlistTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		memberWishlist.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setName(MemberWishlist memberWishlist, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(MemberWishlistTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		memberWishlist.setName(name);
		}catch (SQLException e){

    }
	}
		
 	protected void setOwner(MemberWishlist memberWishlist, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreMemberId;
 		try{
 		  retailStoreMemberId = rs.getString(MemberWishlistTable.COLUMN_OWNER);
 		}catch(SQLException e){
 		  return;
 		}
 		if( retailStoreMemberId == null){
 			return;
 		}
 		if( retailStoreMemberId.isEmpty()){
 			return;
 		}
 		RetailStoreMember retailStoreMember = memberWishlist.getOwner();
 		if( retailStoreMember != null ){
 			//if the root object 'memberWishlist' already have the property, just set the id for it;
 			retailStoreMember.setId(retailStoreMemberId);

 			return;
 		}
 		memberWishlist.setOwner(createEmptyOwner(retailStoreMemberId));
 	}
 	
	protected void setVersion(MemberWishlist memberWishlist, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(MemberWishlistTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		memberWishlist.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected RetailStoreMember  createEmptyOwner(String retailStoreMemberId){
 		RetailStoreMember retailStoreMember = new RetailStoreMember();
 		retailStoreMember.setId(retailStoreMemberId);
 		retailStoreMember.setVersion(Integer.MAX_VALUE);
 		return retailStoreMember;
 	}
 	
}


