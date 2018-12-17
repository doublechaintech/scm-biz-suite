
package com.doublechaintech.retailscm.cityevent;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
public class CityEventTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="cityEvent";
	
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
	protected CityEventTokens(){
		//ensure not initialized outside the class
	}
	
	public CityEventTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static CityEventTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected CityEventTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static CityEventTokens start(){
		return new CityEventTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static CityEventTokens allTokens(){
		
		return start()
			.withCityServiceCenter()
			.withEventAttendanceList();
	
	}
	public static CityEventTokens withoutListsTokens(){
		
		return start()
			.withCityServiceCenter();
	
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

	protected static final String CITYSERVICECENTER = "cityServiceCenter";
	public String getCityServiceCenter(){
		return CITYSERVICECENTER;
	}
	public CityEventTokens withCityServiceCenter(){		
		addSimpleOptions(CITYSERVICECENTER);
		return this;
	}
	
	
	protected static final String EVENT_ATTENDANCE_LIST = "eventAttendanceList";
	public String getEventAttendanceList(){
		return EVENT_ATTENDANCE_LIST;
	}
	public CityEventTokens withEventAttendanceList(){		
		addSimpleOptions(EVENT_ATTENDANCE_LIST);
		return this;
	}

	public CityEventTokens extractMoreFromEventAttendanceList(String idsSeperatedWithComma){		
		addSimpleOptions(EVENT_ATTENDANCE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int eventAttendanceListSortCounter = 0;
	public CityEventTokens sortEventAttendanceListWith(String field, String descOrAsc){		
		addSortMoreOptions(EVENT_ATTENDANCE_LIST,eventAttendanceListSortCounter++, field, descOrAsc);
		return this;
	}
	private int eventAttendanceListSearchCounter = 0;
	public CityEventTokens searchEventAttendanceListWith(String field, String verb, String value){		
		addSearchMoreOptions(EVENT_ATTENDANCE_LIST,eventAttendanceListSearchCounter++, field, verb, value);
		return this;
	}
	
	public CityEventTokens searchAllTextOfEventAttendanceList(String verb, String value){	
		String field = "id|name|description";
		addSearchMoreOptions(EVENT_ATTENDANCE_LIST,eventAttendanceListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public CityEventTokens rowsPerPageOfEventAttendanceList(int rowsPerPage){		
		addSimpleOptions(EVENT_ATTENDANCE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public CityEventTokens currentPageNumberOfEventAttendanceList(int currentPageNumber){		
		addSimpleOptions(EVENT_ATTENDANCE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public CityEventTokens retainColumnsOfEventAttendanceList(String[] columns){		
		addSimpleOptions(EVENT_ATTENDANCE_LIST+"RetainColumns",columns);
		return this;
	}
	public CityEventTokens excludeColumnsOfEventAttendanceList(String[] columns){		
		addSimpleOptions(EVENT_ATTENDANCE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  CityEventTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfEventAttendanceList(verb, value);	
		return this;
	}
}

