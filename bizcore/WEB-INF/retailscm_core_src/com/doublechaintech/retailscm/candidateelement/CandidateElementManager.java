
package com.doublechaintech.retailscm.candidateelement;
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




public interface CandidateElementManager extends BaseManager{

		

  List<CandidateElement> searchCandidateElementList(RetailscmUserContext ctx, CandidateElementRequest pRequest);
  CandidateElement searchCandidateElement(RetailscmUserContext ctx, CandidateElementRequest pRequest);
	public CandidateElement createCandidateElement(RetailscmUserContext userContext, String name,String type,String image,String containerId) throws Exception;
	public CandidateElement updateCandidateElement(RetailscmUserContext userContext,String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CandidateElement loadCandidateElement(RetailscmUserContext userContext, String candidateElementId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public CandidateElement internalSaveCandidateElement(RetailscmUserContext userContext, CandidateElement candidateElement) throws Exception;
	public CandidateElement internalSaveCandidateElement(RetailscmUserContext userContext, CandidateElement candidateElement,Map<String,Object>option) throws Exception;

	public CandidateElement transferToAnotherContainer(RetailscmUserContext userContext, String candidateElementId, String anotherContainerId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String candidateElementId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, CandidateElement newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, CandidateElement updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByContainer(RetailscmUserContext userContext,String containerId) throws Exception;
	public Object listPageByContainer(RetailscmUserContext userContext,String containerId, int start, int count) throws Exception;
  




}


