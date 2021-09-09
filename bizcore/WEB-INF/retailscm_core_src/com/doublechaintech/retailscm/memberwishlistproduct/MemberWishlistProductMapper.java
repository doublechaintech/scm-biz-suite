
package com.doublechaintech.retailscm.memberwishlistproduct;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.memberwishlist.MemberWishlist;

public class MemberWishlistProductMapper extends BaseRowMapper<MemberWishlistProduct>{

	protected MemberWishlistProduct internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		MemberWishlistProduct memberWishlistProduct = getMemberWishlistProduct();
		
 		setId(memberWishlistProduct, rs, rowNumber);
 		setName(memberWishlistProduct, rs, rowNumber);
 		setOwner(memberWishlistProduct, rs, rowNumber);
 		setVersion(memberWishlistProduct, rs, rowNumber);

    
		return memberWishlistProduct;
	}

	protected MemberWishlistProduct getMemberWishlistProduct(){
	  MemberWishlistProduct entity = new MemberWishlistProduct();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(MemberWishlistProduct memberWishlistProduct, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(MemberWishlistProductTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		memberWishlistProduct.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setName(MemberWishlistProduct memberWishlistProduct, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(MemberWishlistProductTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		memberWishlistProduct.setName(name);
		}catch (SQLException e){

    }
	}
		
 	protected void setOwner(MemberWishlistProduct memberWishlistProduct, ResultSet rs, int rowNumber) throws SQLException{
 		String memberWishlistId;
 		try{
 		  memberWishlistId = rs.getString(MemberWishlistProductTable.COLUMN_OWNER);
 		}catch(SQLException e){
 		  return;
 		}
 		if( memberWishlistId == null){
 			return;
 		}
 		if( memberWishlistId.isEmpty()){
 			return;
 		}
 		MemberWishlist memberWishlist = memberWishlistProduct.getOwner();
 		if( memberWishlist != null ){
 			//if the root object 'memberWishlistProduct' already have the property, just set the id for it;
 			memberWishlist.setId(memberWishlistId);

 			return;
 		}
 		memberWishlistProduct.setOwner(createEmptyOwner(memberWishlistId));
 	}
 	
	protected void setVersion(MemberWishlistProduct memberWishlistProduct, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(MemberWishlistProductTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		memberWishlistProduct.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected MemberWishlist  createEmptyOwner(String memberWishlistId){
 		MemberWishlist memberWishlist = new MemberWishlist();
 		memberWishlist.setId(memberWishlistId);
 		memberWishlist.setVersion(Integer.MAX_VALUE);
 		return memberWishlist;
 	}
 	
}


