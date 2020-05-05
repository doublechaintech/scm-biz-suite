
package com.doublechaintech.retailscm.retailstoredecoration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.retailstore.RetailStore;

@JsonSerialize(using = RetailStoreDecorationSerializer.class)
public class RetailStoreDecoration extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String COMMENT_PROPERTY               = "comment"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String RETAIL_STORE_LIST                        = "retailStoreList"   ;

	public static final String INTERNAL_TYPE="RetailStoreDecoration";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getComment();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mComment            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<RetailStore>	mRetailStoreList    ;

	
		
	public 	RetailStoreDecoration(){
		// lazy load for all the properties
	}
	public 	static RetailStoreDecoration withId(String id){
		RetailStoreDecoration retailStoreDecoration = new RetailStoreDecoration();
		retailStoreDecoration.setId(id);
		retailStoreDecoration.setVersion(Integer.MAX_VALUE);
		return retailStoreDecoration;
	}
	public 	static RetailStoreDecoration refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(COMMENT_PROPERTY.equals(property)){
			changeCommentProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeCommentProperty(String newValueExpr){
	
		String oldValue = getComment();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateComment(newValue);
		this.onChangeProperty(COMMENT_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(COMMENT_PROPERTY.equals(property)){
			return getComment();
		}
		if(RETAIL_STORE_LIST.equals(property)){
			List<BaseEntity> list = getRetailStoreList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}

    		//other property not include here
		return super.propertyOf(property);
	}
    
    


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public RetailStoreDecoration updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setComment(String comment){
		this.mComment = trimString(comment);;
	}
	public String getComment(){
		return this.mComment;
	}
	public RetailStoreDecoration updateComment(String comment){
		this.mComment = trimString(comment);;
		this.changed = true;
		return this;
	}
	public void mergeComment(String comment){
		if(comment != null) { setComment(comment);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public RetailStoreDecoration updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<RetailStore> getRetailStoreList(){
		if(this.mRetailStoreList == null){
			this.mRetailStoreList = new SmartList<RetailStore>();
			this.mRetailStoreList.setListInternalName (RETAIL_STORE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mRetailStoreList;	
	}
	public  void setRetailStoreList(SmartList<RetailStore> retailStoreList){
		for( RetailStore retailStore:retailStoreList){
			retailStore.setDecoration(this);
		}

		this.mRetailStoreList = retailStoreList;
		this.mRetailStoreList.setListInternalName (RETAIL_STORE_LIST );
		
	}
	
	public  void addRetailStore(RetailStore retailStore){
		retailStore.setDecoration(this);
		getRetailStoreList().add(retailStore);
	}
	public  void addRetailStoreList(SmartList<RetailStore> retailStoreList){
		for( RetailStore retailStore:retailStoreList){
			retailStore.setDecoration(this);
		}
		getRetailStoreList().addAll(retailStoreList);
	}
	public  void mergeRetailStoreList(SmartList<RetailStore> retailStoreList){
		if(retailStoreList==null){
			return;
		}
		if(retailStoreList.isEmpty()){
			return;
		}
		addRetailStoreList( retailStoreList );
		
	}
	public  RetailStore removeRetailStore(RetailStore retailStoreIndex){
		
		int index = getRetailStoreList().indexOf(retailStoreIndex);
        if(index < 0){
        	String message = "RetailStore("+retailStoreIndex.getId()+") with version='"+retailStoreIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RetailStore retailStore = getRetailStoreList().get(index);        
        // retailStore.clearDecoration(); //disconnect with Decoration
        retailStore.clearFromAll(); //disconnect with Decoration
		
		boolean result = getRetailStoreList().planToRemove(retailStore);
        if(!result){
        	String message = "RetailStore("+retailStoreIndex.getId()+") with version='"+retailStoreIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return retailStore;
        
	
	}
	//断舍离
	public  void breakWithRetailStore(RetailStore retailStore){
		
		if(retailStore == null){
			return;
		}
		retailStore.setDecoration(null);
		//getRetailStoreList().remove();
	
	}
	
	public  boolean hasRetailStore(RetailStore retailStore){
	
		return getRetailStoreList().contains(retailStore);
  
	}
	
	public void copyRetailStoreFrom(RetailStore retailStore) {

		RetailStore retailStoreInList = findTheRetailStore(retailStore);
		RetailStore newRetailStore = new RetailStore();
		retailStoreInList.copyTo(newRetailStore);
		newRetailStore.setVersion(0);//will trigger copy
		getRetailStoreList().add(newRetailStore);
		addItemToFlexiableObject(COPIED_CHILD, newRetailStore);
	}
	
	public  RetailStore findTheRetailStore(RetailStore retailStore){
		
		int index =  getRetailStoreList().indexOf(retailStore);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "RetailStore("+retailStore.getId()+") with version='"+retailStore.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRetailStoreList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreList(){
		getRetailStoreList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getRetailStoreList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getRetailStoreList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, COMMENT_PROPERTY, getComment());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, RETAIL_STORE_LIST, getRetailStoreList());
		if(!getRetailStoreList().isEmpty()){
			appendKeyValuePair(result, "retailStoreCount", getRetailStoreList().getTotalCount());
			appendKeyValuePair(result, "retailStoreCurrentPageNumber", getRetailStoreList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreDecoration){
		
		
			RetailStoreDecoration dest =(RetailStoreDecoration)baseDest;
		
			dest.setId(getId());
			dest.setComment(getComment());
			dest.setVersion(getVersion());
			dest.setRetailStoreList(getRetailStoreList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreDecoration){
		
			
			RetailStoreDecoration dest =(RetailStoreDecoration)baseDest;
		
			dest.mergeId(getId());
			dest.mergeComment(getComment());
			dest.mergeVersion(getVersion());
			dest.mergeRetailStoreList(getRetailStoreList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreDecoration){
		
			
			RetailStoreDecoration dest =(RetailStoreDecoration)baseDest;
		
			dest.mergeId(getId());
			dest.mergeComment(getComment());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getComment(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("RetailStoreDecoration{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tcomment='"+getComment()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

