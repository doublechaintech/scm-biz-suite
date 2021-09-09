
package com.doublechaintech.retailscm.transporttasktrack;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.transporttask.TransportTaskTokens;





public class TransportTaskTrackTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="transportTaskTrack";

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
	protected TransportTaskTrackTokens(){
		//ensure not initialized outside the class
	}
	public  static  TransportTaskTrackTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		TransportTaskTrackTokens tokens = new TransportTaskTrackTokens(options);
		return tokens;

	}
	protected TransportTaskTrackTokens(Map<String,Object> options){
		this.options = options;
	}

	public TransportTaskTrackTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static TransportTaskTrackTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected TransportTaskTrackTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static TransportTaskTrackTokens start(){
		return new TransportTaskTrackTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public TransportTaskTrackTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static TransportTaskTrackTokens loadGroupTokens(String... groupNames){
    TransportTaskTrackTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, MOVEMENT, groupNames, new String[]{"default"});

  
    return tokens;
  }

  private static void addToken(TransportTaskTrackTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
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

	public static TransportTaskTrackTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withMovement();

	}

	public static TransportTaskTrackTokens allTokens(){

		return start()
			.withMovement();

	}
	public static TransportTaskTrackTokens withoutListsTokens(){

		return start()
			.withMovement();

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

	public TransportTaskTrackTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String MOVEMENT = "movement";
	public String getMovement(){
		return MOVEMENT;
	}
	//
	public TransportTaskTrackTokens withMovement(){
		addSimpleOptions(MOVEMENT);
		return this;
	}

	public TransportTaskTokens withMovementTokens(){
		//addSimpleOptions(MOVEMENT);
		return TransportTaskTokens.start();
	}

	

	public  TransportTaskTrackTokens searchEntireObjectText(String verb, String value){
	
		return this;
	}
}

