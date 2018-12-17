
package com.doublechaintech.retailscm.secuserblocking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.secuser.SecUser;

@JsonSerialize(using = SecUserBlockingSerializer.class)
public class SecUserBlocking extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String BLOCK_TIME_PROPERTY            = "blockTime"         ;
	public static final String COMMENTS_PROPERTY              = "comments"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String SEC_USER_LIST                            = "secUserList"       ;

	public static final String INTERNAL_TYPE="SecUserBlocking";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getWho();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mWho                ;
	protected		DateTime            	mBlockTime          ;
	protected		String              	mComments           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<SecUser>  	mSecUserList        ;
	
		
	public 	SecUserBlocking(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	SecUserBlocking(String who, DateTime blockTime, String comments)
	{
		setWho(who);
		setBlockTime(blockTime);
		setComments(comments);

		this.mSecUserList = new SmartList<SecUser>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(WHO_PROPERTY.equals(property)){
			changeWhoProperty(newValueExpr);
		}
		if(BLOCK_TIME_PROPERTY.equals(property)){
			changeBlockTimeProperty(newValueExpr);
		}
		if(COMMENTS_PROPERTY.equals(property)){
			changeCommentsProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeWhoProperty(String newValueExpr){
		String oldValue = getWho();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateWho(newValue);
		this.onChangeProperty(WHO_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeBlockTimeProperty(String newValueExpr){
		DateTime oldValue = getBlockTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateBlockTime(newValue);
		this.onChangeProperty(BLOCK_TIME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCommentsProperty(String newValueExpr){
		String oldValue = getComments();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateComments(newValue);
		this.onChangeProperty(COMMENTS_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public SecUserBlocking updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setWho(String who){
		this.mWho = trimString(who);;
	}
	public String getWho(){
		return this.mWho;
	}
	public SecUserBlocking updateWho(String who){
		this.mWho = trimString(who);;
		this.changed = true;
		return this;
	}
	
	
	public void setBlockTime(DateTime blockTime){
		this.mBlockTime = blockTime;;
	}
	public DateTime getBlockTime(){
		return this.mBlockTime;
	}
	public SecUserBlocking updateBlockTime(DateTime blockTime){
		this.mBlockTime = blockTime;;
		this.changed = true;
		return this;
	}
	
	
	public void setComments(String comments){
		this.mComments = trimString(comments);;
	}
	public String getComments(){
		return this.mComments;
	}
	public SecUserBlocking updateComments(String comments){
		this.mComments = trimString(comments);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public SecUserBlocking updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<SecUser> getSecUserList(){
		if(this.mSecUserList == null){
			this.mSecUserList = new SmartList<SecUser>();
			this.mSecUserList.setListInternalName (SEC_USER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mSecUserList;	
	}
	public  void setSecUserList(SmartList<SecUser> secUserList){
		for( SecUser secUser:secUserList){
			secUser.setBlocking(this);
		}

		this.mSecUserList = secUserList;
		this.mSecUserList.setListInternalName (SEC_USER_LIST );
		
	}
	
	public  void addSecUser(SecUser secUser){
		secUser.setBlocking(this);
		getSecUserList().add(secUser);
	}
	public  void addSecUserList(SmartList<SecUser> secUserList){
		for( SecUser secUser:secUserList){
			secUser.setBlocking(this);
		}
		getSecUserList().addAll(secUserList);
	}
	
	public  SecUser removeSecUser(SecUser secUserIndex){
		
		int index = getSecUserList().indexOf(secUserIndex);
        if(index < 0){
        	String message = "SecUser("+secUserIndex.getId()+") with version='"+secUserIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        SecUser secUser = getSecUserList().get(index);        
        // secUser.clearBlocking(); //disconnect with Blocking
        secUser.clearFromAll(); //disconnect with Blocking
		
		boolean result = getSecUserList().planToRemove(secUser);
        if(!result){
        	String message = "SecUser("+secUserIndex.getId()+") with version='"+secUserIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return secUser;
        
	
	}
	//断舍离
	public  void breakWithSecUser(SecUser secUser){
		
		if(secUser == null){
			return;
		}
		secUser.setBlocking(null);
		//getSecUserList().remove();
	
	}
	
	public  boolean hasSecUser(SecUser secUser){
	
		return getSecUserList().contains(secUser);
  
	}
	
	public void copySecUserFrom(SecUser secUser) {

		SecUser secUserInList = findTheSecUser(secUser);
		SecUser newSecUser = new SecUser();
		secUserInList.copyTo(newSecUser);
		newSecUser.setVersion(0);//will trigger copy
		getSecUserList().add(newSecUser);
		addItemToFlexiableObject(COPIED_CHILD, newSecUser);
	}
	
	public  SecUser findTheSecUser(SecUser secUser){
		
		int index =  getSecUserList().indexOf(secUser);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "SecUser("+secUser.getId()+") with version='"+secUser.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getSecUserList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSecUserList(){
		getSecUserList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getSecUserList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getSecUserList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, WHO_PROPERTY, getWho());
		appendKeyValuePair(result, BLOCK_TIME_PROPERTY, getBlockTime());
		appendKeyValuePair(result, COMMENTS_PROPERTY, getComments());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, SEC_USER_LIST, getSecUserList());
		if(!getSecUserList().isEmpty()){
			appendKeyValuePair(result, "secUserCount", getSecUserList().getTotalCount());
			appendKeyValuePair(result, "secUserCurrentPageNumber", getSecUserList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SecUserBlocking){
		
		
			SecUserBlocking dest =(SecUserBlocking)baseDest;
		
			dest.setId(getId());
			dest.setWho(getWho());
			dest.setBlockTime(getBlockTime());
			dest.setComments(getComments());
			dest.setVersion(getVersion());
			dest.setSecUserList(getSecUserList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("SecUserBlocking{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tblockTime='"+getBlockTime()+"';");
		stringBuilder.append("\tcomments='"+getComments()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

