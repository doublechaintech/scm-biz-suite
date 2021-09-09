
package com.doublechaintech.retailscm.candidatecontainer;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.List;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;




public interface CandidateContainerManager extends BaseManager{

		

  List<CandidateContainer> searchCandidateContainerList(RetailscmUserContext ctx, CandidateContainerRequest pRequest);
  CandidateContainer searchCandidateContainer(RetailscmUserContext ctx, CandidateContainerRequest pRequest);
	public CandidateContainer createCandidateContainer(RetailscmUserContext userContext, String name) throws Exception;
	public CandidateContainer updateCandidateContainer(RetailscmUserContext userContext,String candidateContainerId, int candidateContainerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CandidateContainer loadCandidateContainer(RetailscmUserContext userContext, String candidateContainerId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public CandidateContainer internalSaveCandidateContainer(RetailscmUserContext userContext, CandidateContainer candidateContainer) throws Exception;
	public CandidateContainer internalSaveCandidateContainer(RetailscmUserContext userContext, CandidateContainer candidateContainer,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String candidateContainerId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, CandidateContainer newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, CandidateContainer updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  CandidateElementManager getCandidateElementManager(RetailscmUserContext userContext, String candidateContainerId, String name, String type, String image ,String [] tokensExpr)  throws Exception;

	public  CandidateContainer addCandidateElement(RetailscmUserContext userContext, String candidateContainerId, String name, String type, String image , String [] tokensExpr)  throws Exception;
	public  CandidateContainer removeCandidateElement(RetailscmUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion,String [] tokensExpr)  throws Exception;
	public  CandidateContainer updateCandidateElement(RetailscmUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/






}


