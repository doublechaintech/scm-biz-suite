
package com.doublechaintech.retailscm.leveltwocategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;









@JsonSerialize(using = LevelTwoCategorySerializer.class)
public class LevelTwoCategory extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String PARENT_CATEGORY_PROPERTY       = "parentCategory"    ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String LEVEL_THREE_CATEGORY_LIST                = "levelThreeCategoryList";

	public static final String INTERNAL_TYPE="LevelTwoCategory";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		LevelOneCategory    	mParentCategory     ;
	protected		String              	mName               ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<LevelThreeCategory>	mLevelThreeCategoryList;

	
		
	public 	LevelTwoCategory(){
		// lazy load for all the properties
	}
	public 	static LevelTwoCategory withId(String id){
		LevelTwoCategory levelTwoCategory = new LevelTwoCategory();
		levelTwoCategory.setId(id);
		levelTwoCategory.setVersion(Integer.MAX_VALUE);
		return levelTwoCategory;
	}
	public 	static LevelTwoCategory refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setParentCategory( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
	
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(PARENT_CATEGORY_PROPERTY.equals(property)){
			return getParentCategory();
		}
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(LEVEL_THREE_CATEGORY_LIST.equals(property)){
			List<BaseEntity> list = getLevelThreeCategoryList().stream().map(item->item).collect(Collectors.toList());
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
	public LevelTwoCategory updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setParentCategory(LevelOneCategory parentCategory){
		this.mParentCategory = parentCategory;;
	}
	public LevelOneCategory getParentCategory(){
		return this.mParentCategory;
	}
	public LevelTwoCategory updateParentCategory(LevelOneCategory parentCategory){
		this.mParentCategory = parentCategory;;
		this.changed = true;
		return this;
	}
	public void mergeParentCategory(LevelOneCategory parentCategory){
		if(parentCategory != null) { setParentCategory(parentCategory);}
	}
	
	
	public void clearParentCategory(){
		setParentCategory ( null );
		this.changed = true;
	}
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public LevelTwoCategory updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public LevelTwoCategory updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<LevelThreeCategory> getLevelThreeCategoryList(){
		if(this.mLevelThreeCategoryList == null){
			this.mLevelThreeCategoryList = new SmartList<LevelThreeCategory>();
			this.mLevelThreeCategoryList.setListInternalName (LEVEL_THREE_CATEGORY_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mLevelThreeCategoryList;	
	}
	public  void setLevelThreeCategoryList(SmartList<LevelThreeCategory> levelThreeCategoryList){
		for( LevelThreeCategory levelThreeCategory:levelThreeCategoryList){
			levelThreeCategory.setParentCategory(this);
		}

		this.mLevelThreeCategoryList = levelThreeCategoryList;
		this.mLevelThreeCategoryList.setListInternalName (LEVEL_THREE_CATEGORY_LIST );
		
	}
	
	public  void addLevelThreeCategory(LevelThreeCategory levelThreeCategory){
		levelThreeCategory.setParentCategory(this);
		getLevelThreeCategoryList().add(levelThreeCategory);
	}
	public  void addLevelThreeCategoryList(SmartList<LevelThreeCategory> levelThreeCategoryList){
		for( LevelThreeCategory levelThreeCategory:levelThreeCategoryList){
			levelThreeCategory.setParentCategory(this);
		}
		getLevelThreeCategoryList().addAll(levelThreeCategoryList);
	}
	public  void mergeLevelThreeCategoryList(SmartList<LevelThreeCategory> levelThreeCategoryList){
		if(levelThreeCategoryList==null){
			return;
		}
		if(levelThreeCategoryList.isEmpty()){
			return;
		}
		addLevelThreeCategoryList( levelThreeCategoryList );
		
	}
	public  LevelThreeCategory removeLevelThreeCategory(LevelThreeCategory levelThreeCategoryIndex){
		
		int index = getLevelThreeCategoryList().indexOf(levelThreeCategoryIndex);
        if(index < 0){
        	String message = "LevelThreeCategory("+levelThreeCategoryIndex.getId()+") with version='"+levelThreeCategoryIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        LevelThreeCategory levelThreeCategory = getLevelThreeCategoryList().get(index);        
        // levelThreeCategory.clearParentCategory(); //disconnect with ParentCategory
        levelThreeCategory.clearFromAll(); //disconnect with ParentCategory
		
		boolean result = getLevelThreeCategoryList().planToRemove(levelThreeCategory);
        if(!result){
        	String message = "LevelThreeCategory("+levelThreeCategoryIndex.getId()+") with version='"+levelThreeCategoryIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return levelThreeCategory;
        
	
	}
	//断舍离
	public  void breakWithLevelThreeCategory(LevelThreeCategory levelThreeCategory){
		
		if(levelThreeCategory == null){
			return;
		}
		levelThreeCategory.setParentCategory(null);
		//getLevelThreeCategoryList().remove();
	
	}
	
	public  boolean hasLevelThreeCategory(LevelThreeCategory levelThreeCategory){
	
		return getLevelThreeCategoryList().contains(levelThreeCategory);
  
	}
	
	public void copyLevelThreeCategoryFrom(LevelThreeCategory levelThreeCategory) {

		LevelThreeCategory levelThreeCategoryInList = findTheLevelThreeCategory(levelThreeCategory);
		LevelThreeCategory newLevelThreeCategory = new LevelThreeCategory();
		levelThreeCategoryInList.copyTo(newLevelThreeCategory);
		newLevelThreeCategory.setVersion(0);//will trigger copy
		getLevelThreeCategoryList().add(newLevelThreeCategory);
		addItemToFlexiableObject(COPIED_CHILD, newLevelThreeCategory);
	}
	
	public  LevelThreeCategory findTheLevelThreeCategory(LevelThreeCategory levelThreeCategory){
		
		int index =  getLevelThreeCategoryList().indexOf(levelThreeCategory);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "LevelThreeCategory("+levelThreeCategory.getId()+") with version='"+levelThreeCategory.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getLevelThreeCategoryList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLevelThreeCategoryList(){
		getLevelThreeCategoryList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getParentCategory(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getLevelThreeCategoryList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getLevelThreeCategoryList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, PARENT_CATEGORY_PROPERTY, getParentCategory());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, LEVEL_THREE_CATEGORY_LIST, getLevelThreeCategoryList());
		if(!getLevelThreeCategoryList().isEmpty()){
			appendKeyValuePair(result, "levelThreeCategoryCount", getLevelThreeCategoryList().getTotalCount());
			appendKeyValuePair(result, "levelThreeCategoryCurrentPageNumber", getLevelThreeCategoryList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LevelTwoCategory){
		
		
			LevelTwoCategory dest =(LevelTwoCategory)baseDest;
		
			dest.setId(getId());
			dest.setParentCategory(getParentCategory());
			dest.setName(getName());
			dest.setVersion(getVersion());
			dest.setLevelThreeCategoryList(getLevelThreeCategoryList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LevelTwoCategory){
		
			
			LevelTwoCategory dest =(LevelTwoCategory)baseDest;
		
			dest.mergeId(getId());
			dest.mergeParentCategory(getParentCategory());
			dest.mergeName(getName());
			dest.mergeVersion(getVersion());
			dest.mergeLevelThreeCategoryList(getLevelThreeCategoryList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LevelTwoCategory){
		
			
			LevelTwoCategory dest =(LevelTwoCategory)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getParentCategory(), getName(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("LevelTwoCategory{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getParentCategory() != null ){
 			stringBuilder.append("\tparentCategory='LevelOneCategory("+getParentCategory().getId()+")';");
 		}
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

