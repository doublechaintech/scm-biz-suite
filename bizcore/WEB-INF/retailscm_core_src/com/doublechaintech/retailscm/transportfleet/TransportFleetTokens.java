
package com.doublechaintech.retailscm.transportfleet;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class TransportFleetTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="transportFleet";
	
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
	protected TransportFleetTokens(){
		//ensure not initialized outside the class
	}
	public  static  TransportFleetTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		TransportFleetTokens tokens = new TransportFleetTokens(options);
		return tokens;
		
	}
	protected TransportFleetTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public TransportFleetTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static TransportFleetTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected TransportFleetTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	
	
	public static TransportFleetTokens start(){
		return new TransportFleetTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	public TransportFleetTokens withTokenFromListName(String listName){		
		addSimpleOptions(listName);
		return this;
	}
	
	protected static TransportFleetTokens allTokens(){
		
		return start()
			.withOwner()
			.withTransportTruckList()
			.withTruckDriverList()
			.withTransportTaskList();
	
	}
	public static TransportFleetTokens withoutListsTokens(){
		
		return start()
			.withOwner();
	
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
	
	public TransportFleetTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String OWNER = "owner";
	public String getOwner(){
		return OWNER;
	}
	public TransportFleetTokens withOwner(){		
		addSimpleOptions(OWNER);
		return this;
	}
	
	
	protected static final String TRANSPORT_TRUCK_LIST = "transportTruckList";
	public String getTransportTruckList(){
		return TRANSPORT_TRUCK_LIST;
	}
	public TransportFleetTokens withTransportTruckList(){		
		addSimpleOptions(TRANSPORT_TRUCK_LIST);
		return this;
	}
	public TransportFleetTokens analyzeTransportTruckList(){		
		addSimpleOptions(TRANSPORT_TRUCK_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTransportTruckListEnabled(){		
		
		if(checkOptions(this.options(), TRANSPORT_TRUCK_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public TransportFleetTokens extractMoreFromTransportTruckList(String idsSeperatedWithComma){		
		addSimpleOptions(TRANSPORT_TRUCK_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int transportTruckListSortCounter = 0;
	public TransportFleetTokens sortTransportTruckListWith(String field, String descOrAsc){		
		addSortMoreOptions(TRANSPORT_TRUCK_LIST,transportTruckListSortCounter++, field, descOrAsc);
		return this;
	}
	private int transportTruckListSearchCounter = 0;
	public TransportFleetTokens searchTransportTruckListWith(String field, String verb, String value){		
		
		withTransportTruckList();
		addSearchMoreOptions(TRANSPORT_TRUCK_LIST,transportTruckListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public TransportFleetTokens searchAllTextOfTransportTruckList(String verb, String value){	
		String field = "id|name|plateNumber|contactNumber|vehicleLicenseNumber|engineNumber|mileage|bodyColor";
		addSearchMoreOptions(TRANSPORT_TRUCK_LIST,transportTruckListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public TransportFleetTokens rowsPerPageOfTransportTruckList(int rowsPerPage){		
		addSimpleOptions(TRANSPORT_TRUCK_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public TransportFleetTokens currentPageNumberOfTransportTruckList(int currentPageNumber){		
		addSimpleOptions(TRANSPORT_TRUCK_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public TransportFleetTokens retainColumnsOfTransportTruckList(String[] columns){		
		addSimpleOptions(TRANSPORT_TRUCK_LIST+"RetainColumns",columns);
		return this;
	}
	public TransportFleetTokens excludeColumnsOfTransportTruckList(String[] columns){		
		addSimpleOptions(TRANSPORT_TRUCK_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String TRUCK_DRIVER_LIST = "truckDriverList";
	public String getTruckDriverList(){
		return TRUCK_DRIVER_LIST;
	}
	public TransportFleetTokens withTruckDriverList(){		
		addSimpleOptions(TRUCK_DRIVER_LIST);
		return this;
	}
	public TransportFleetTokens analyzeTruckDriverList(){		
		addSimpleOptions(TRUCK_DRIVER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeTruckDriverListEnabled(){		
		
		if(checkOptions(this.options(), TRUCK_DRIVER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public TransportFleetTokens extractMoreFromTruckDriverList(String idsSeperatedWithComma){		
		addSimpleOptions(TRUCK_DRIVER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int truckDriverListSortCounter = 0;
	public TransportFleetTokens sortTruckDriverListWith(String field, String descOrAsc){		
		addSortMoreOptions(TRUCK_DRIVER_LIST,truckDriverListSortCounter++, field, descOrAsc);
		return this;
	}
	private int truckDriverListSearchCounter = 0;
	public TransportFleetTokens searchTruckDriverListWith(String field, String verb, String value){		
		
		withTruckDriverList();
		addSearchMoreOptions(TRUCK_DRIVER_LIST,truckDriverListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public TransportFleetTokens searchAllTextOfTruckDriverList(String verb, String value){	
		String field = "id|name|driverLicenseNumber|contactNumber";
		addSearchMoreOptions(TRUCK_DRIVER_LIST,truckDriverListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public TransportFleetTokens rowsPerPageOfTruckDriverList(int rowsPerPage){		
		addSimpleOptions(TRUCK_DRIVER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public TransportFleetTokens currentPageNumberOfTruckDriverList(int currentPageNumber){		
		addSimpleOptions(TRUCK_DRIVER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public TransportFleetTokens retainColumnsOfTruckDriverList(String[] columns){		
		addSimpleOptions(TRUCK_DRIVER_LIST+"RetainColumns",columns);
		return this;
	}
	public TransportFleetTokens excludeColumnsOfTruckDriverList(String[] columns){		
		addSimpleOptions(TRUCK_DRIVER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String TRANSPORT_TASK_LIST = "transportTaskList";
	public String getTransportTaskList(){
		return TRANSPORT_TASK_LIST;
	}
	public TransportFleetTokens withTransportTaskList(){		
		addSimpleOptions(TRANSPORT_TASK_LIST);
		return this;
	}
	public TransportFleetTokens analyzeTransportTaskList(){		
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
	public TransportFleetTokens extractMoreFromTransportTaskList(String idsSeperatedWithComma){		
		addSimpleOptions(TRANSPORT_TASK_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int transportTaskListSortCounter = 0;
	public TransportFleetTokens sortTransportTaskListWith(String field, String descOrAsc){		
		addSortMoreOptions(TRANSPORT_TASK_LIST,transportTaskListSortCounter++, field, descOrAsc);
		return this;
	}
	private int transportTaskListSearchCounter = 0;
	public TransportFleetTokens searchTransportTaskListWith(String field, String verb, String value){		
		
		withTransportTaskList();
		addSearchMoreOptions(TRANSPORT_TASK_LIST,transportTaskListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public TransportFleetTokens searchAllTextOfTransportTaskList(String verb, String value){	
		String field = "id|name|start";
		addSearchMoreOptions(TRANSPORT_TASK_LIST,transportTaskListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public TransportFleetTokens rowsPerPageOfTransportTaskList(int rowsPerPage){		
		addSimpleOptions(TRANSPORT_TASK_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public TransportFleetTokens currentPageNumberOfTransportTaskList(int currentPageNumber){		
		addSimpleOptions(TRANSPORT_TASK_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public TransportFleetTokens retainColumnsOfTransportTaskList(String[] columns){		
		addSimpleOptions(TRANSPORT_TASK_LIST+"RetainColumns",columns);
		return this;
	}
	public TransportFleetTokens excludeColumnsOfTransportTaskList(String[] columns){		
		addSimpleOptions(TRANSPORT_TASK_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  TransportFleetTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfTransportTruckList(verb, value);	
		searchAllTextOfTruckDriverList(verb, value);	
		searchAllTextOfTransportTaskList(verb, value);	
		return this;
	}
}

