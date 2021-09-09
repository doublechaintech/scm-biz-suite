
package com.doublechaintech.retailscm.candidatecontainer;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.candidateelement.CandidateElementTokens;





public class CandidateContainerTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="candidateContainer";

	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){

		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner?
			return false;
		}

 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.
 			return true;
 		}

 		return false;

	}
	protected CandidateContainerTokens(){
		//ensure not initialized outside the class
	}
	public  static  CandidateContainerTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		CandidateContainerTokens tokens = new CandidateContainerTokens(options);
		return tokens;

	}
	protected CandidateContainerTokens(Map<String,Object> options){
		this.options = options;
	}

	public CandidateContainerTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static CandidateContainerTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected CandidateContainerTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static CandidateContainerTokens start(){
		return new CandidateContainerTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public CandidateContainerTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static CandidateContainerTokens loadGroupTokens(String... groupNames){
    CandidateContainerTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    

  
     addToken(tokens, CANDIDATE_ELEMENT_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(CandidateContainerTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
    if (pGroupNames == null || fieldGroups == null){
      return;
    }

    for (String groupName: pGroupNames){
      for(String g: fieldGroups){
        if( Objects.equals(groupName, g)){
          pTokens.addSimpleOptions(pTokenName);
          break;
        }
      }
    }
  }

	public static CandidateContainerTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withCandidateElementListIfViewGroupInclude(viewGroups);

	}

	public static CandidateContainerTokens allTokens(){

		return start()
			.withCandidateElementList();

	}
	public static CandidateContainerTokens withoutListsTokens(){

		return start();

	}

	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	public CandidateContainerTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String CANDIDATE_ELEMENT_LIST = "candidateElementList";
	public String getCandidateElementList(){
		return CANDIDATE_ELEMENT_LIST;
	}



	public CandidateContainerTokens withCandidateElementListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(CANDIDATE_ELEMENT_LIST);
		}
		return this;
	}


	public CandidateContainerTokens withCandidateElementList(){
		addSimpleOptions(CANDIDATE_ELEMENT_LIST);
		return this;
	}

	public CandidateElementTokens withCandidateElementListTokens(){
		//addSimpleOptions(CANDIDATE_ELEMENT_LIST);
		return CandidateElementTokens.start();
	}

	public CandidateContainerTokens analyzeCandidateElementList(){
		addSimpleOptions(CANDIDATE_ELEMENT_LIST+".anaylze");
		return this;
	}
	public boolean analyzeCandidateElementListEnabled(){

		if(checkOptions(this.options(), CANDIDATE_ELEMENT_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public CandidateContainerTokens extractMoreFromCandidateElementList(String idsSeperatedWithComma){
		addSimpleOptions(CANDIDATE_ELEMENT_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int candidateElementListSortCounter = 0;
	public CandidateContainerTokens sortCandidateElementListWith(String field, String descOrAsc){
		addSortMoreOptions(CANDIDATE_ELEMENT_LIST,candidateElementListSortCounter++, field, descOrAsc);
		return this;
	}
	private int candidateElementListSearchCounter = 0;
	public CandidateContainerTokens searchCandidateElementListWith(String field, String verb, String value){

		withCandidateElementList();
		addSearchMoreOptions(CANDIDATE_ELEMENT_LIST,candidateElementListSearchCounter++, field, verb, value);
		return this;
	}



	public CandidateContainerTokens searchAllTextOfCandidateElementList(String verb, String value){
		String field = "id|name|type";
		addSearchMoreOptions(CANDIDATE_ELEMENT_LIST,candidateElementListSearchCounter++, field, verb, value);
		return this;
	}



	public CandidateContainerTokens rowsPerPageOfCandidateElementList(int rowsPerPage){
		addSimpleOptions(CANDIDATE_ELEMENT_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public CandidateContainerTokens currentPageNumberOfCandidateElementList(int currentPageNumber){
		addSimpleOptions(CANDIDATE_ELEMENT_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public CandidateContainerTokens retainColumnsOfCandidateElementList(String[] columns){
		addSimpleOptions(CANDIDATE_ELEMENT_LIST+"RetainColumns",columns);
		return this;
	}
	public CandidateContainerTokens excludeColumnsOfCandidateElementList(String[] columns){
		addSimpleOptions(CANDIDATE_ELEMENT_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  CandidateContainerTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfCandidateElementList(verb, value);
		return this;
	}
}

