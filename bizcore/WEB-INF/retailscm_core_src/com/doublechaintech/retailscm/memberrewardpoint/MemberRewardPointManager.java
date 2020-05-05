
package com.doublechaintech.retailscm.memberrewardpoint;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface MemberRewardPointManager extends BaseManager{

		

	public MemberRewardPoint createMemberRewardPoint(RetailscmUserContext userContext, String name,int point,String ownerId) throws Exception;
	public MemberRewardPoint updateMemberRewardPoint(RetailscmUserContext userContext,String memberRewardPointId, int memberRewardPointVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public MemberRewardPoint loadMemberRewardPoint(RetailscmUserContext userContext, String memberRewardPointId, String [] tokensExpr) throws Exception;
	public MemberRewardPoint internalSaveMemberRewardPoint(RetailscmUserContext userContext, MemberRewardPoint memberRewardPoint) throws Exception;
	public MemberRewardPoint internalSaveMemberRewardPoint(RetailscmUserContext userContext, MemberRewardPoint memberRewardPoint,Map<String,Object>option) throws Exception;

	public MemberRewardPoint transferToAnotherOwner(RetailscmUserContext userContext, String memberRewardPointId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String memberRewardPointId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, MemberRewardPoint newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByOwner(RetailscmUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(RetailscmUserContext userContext,String ownerId, int start, int count) throws Exception;
  

}


