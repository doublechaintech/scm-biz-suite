
package  com.doublechaintech.retailscm;

import com.terapico.caf.baseelement.CandidateQuery;

public interface BaseManager{
	<D> D daoOf(RetailscmUserContext userContext);
	
	Object queryCandidates(RetailscmUserContext userContext, CandidateQuery query) throws Exception;
	
	Object queryCandidatesForAssign(RetailscmUserContext userContext, CandidateQuery query) throws Exception;

	Object queryCandidatesForSearch(RetailscmUserContext userContext, CandidateQuery query) throws Exception;
}
















