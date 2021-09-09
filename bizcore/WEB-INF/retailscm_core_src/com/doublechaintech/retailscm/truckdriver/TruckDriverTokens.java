
package com.doublechaintech.retailscm.truckdriver;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.transportfleet.TransportFleetTokens;
import com.doublechaintech.retailscm.transporttask.TransportTaskTokens;





public class TruckDriverTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="truckDriver";

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
	protected TruckDriverTokens(){
		//ensure not initialized outside the class
	}
	public  static  TruckDriverTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		TruckDriverTokens tokens = new TruckDriverTokens(options);
		return tokens;

	}
	protected TruckDriverTokens(Map<String,Object> options){
		this.options = options;
	}

	public TruckDriverTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static TruckDriverTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected TruckDriverTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static TruckDriverTokens start(){
		return new TruckDriverTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public TruckDriverTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static TruckDriverTokens loadGroupTokens(String... groupNames){
    TruckDriverTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, BELONGSTO, groupNames, new String[]{"default"});

  
     addToken(tokens, TRANSPORT_TASK_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(TruckDriverTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static TruckDriverTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withBelongsTo()
			.withTransportTaskListIfViewGroupInclude(viewGroups);

	}

	public static TruckDriverTokens allTokens(){

		return start()
			.withBelongsTo()
			.withTransportTaskList();

	}
	public static TruckDriverTokens withoutListsTokens(){

		return start()
			.withBelongsTo();

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

	public TruckDriverTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String BELONGSTO = "belongsTo";
	public String getBelongsTo(){
		return BELONGSTO;
	}
	//
	public TruckDriverTokens withBelongsTo(){
		addSimpleOptions(BELONGSTO);
		return this;
	}

	public TransportFleetTokens withBelongsToTokens(){
		//addSimpleOptions(BELONGSTO);
		return TransportFleetTokens.start();
	}

	
	protected static final String TRANSPORT_TASK_LIST = "transportTaskList";
	public String getTransportTaskList(){
		return TRANSPORT_TASK_LIST;
	}



	public TruckDriverTokens withTransportTaskListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(TRANSPORT_TASK_LIST);
		}
		return this;
	}


	public TruckDriverTokens withTransportTaskList(){
		addSimpleOptions(TRANSPORT_TASK_LIST);
		return this;
	}

	public TransportTaskTokens withTransportTaskListTokens(){
		//addSimpleOptions(TRANSPORT_TASK_LIST);
		return TransportTaskTokens.start();
	}

	public TruckDriverTokens analyzeTransportTaskList(){
		addSimpleOptions(TRANSPORT_TASK_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTransportTaskListEnabled(){

		if(checkOptions(this.options(), TRANSPORT_TASK_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public TruckDriverTokens extractMoreFromTransportTaskList(String idsSeperatedWithComma){
		addSimpleOptions(TRANSPORT_TASK_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int transportTaskListSortCounter = 0;
	public TruckDriverTokens sortTransportTaskListWith(String field, String descOrAsc){
		addSortMoreOptions(TRANSPORT_TASK_LIST,transportTaskListSortCounter++, field, descOrAsc);
		return this;
	}
	private int transportTaskListSearchCounter = 0;
	public TruckDriverTokens searchTransportTaskListWith(String field, String verb, String value){

		withTransportTaskList();
		addSearchMoreOptions(TRANSPORT_TASK_LIST,transportTaskListSearchCounter++, field, verb, value);
		return this;
	}



	public TruckDriverTokens searchAllTextOfTransportTaskList(String verb, String value){
		String field = "id|name|start";
		addSearchMoreOptions(TRANSPORT_TASK_LIST,transportTaskListSearchCounter++, field, verb, value);
		return this;
	}



	public TruckDriverTokens rowsPerPageOfTransportTaskList(int rowsPerPage){
		addSimpleOptions(TRANSPORT_TASK_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public TruckDriverTokens currentPageNumberOfTransportTaskList(int currentPageNumber){
		addSimpleOptions(TRANSPORT_TASK_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public TruckDriverTokens retainColumnsOfTransportTaskList(String[] columns){
		addSimpleOptions(TRANSPORT_TASK_LIST+"RetainColumns",columns);
		return this;
	}
	public TruckDriverTokens excludeColumnsOfTransportTaskList(String[] columns){
		addSimpleOptions(TRANSPORT_TASK_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  TruckDriverTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfTransportTaskList(verb, value);
		return this;
	}
}

