
package com.doublechaintech.retailscm.memberrewardpointredemption;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface MemberRewardPointRedemptionManager{

		

	public MemberRewardPointRedemption createMemberRewardPointRedemption(RetailscmUserContext userContext, String name, int point, String ownerId) throws Exception;	
	public MemberRewardPointRedemption updateMemberRewardPointRedemption(RetailscmUserContext userContext,String memberRewardPointRedemptionId, int memberRewardPointRedemptionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public MemberRewardPointRedemption loadMemberRewardPointRedemption(RetailscmUserContext userContext, String memberRewardPointRedemptionId, String [] tokensExpr) throws Exception;
	public MemberRewardPointRedemption internalSaveMemberRewardPointRedemption(RetailscmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption) throws Exception;
	public MemberRewardPointRedemption internalSaveMemberRewardPointRedemption(RetailscmUserContext userContext, MemberRewardPointRedemption memberRewardPointRedemption,Map<String,Object>option) throws Exception;
	
	public MemberRewardPointRedemption transferToAnotherOwner(RetailscmUserContext userContext, String memberRewardPointRedemptionId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String memberRewardPointRedemptionId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, MemberRewardPointRedemption newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


