
package com.doublechaintech.retailscm.levelonecategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.retailscm.catalog.Catalog;

@JsonSerialize(using = LevelOneCategorySerializer.class)
public class LevelOneCategory extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CATALOG_PROPERTY               = "catalog"           ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String LEVEL_TWO_CATEGORY_LIST                  = "levelTwoCategoryList";

	public static final String INTERNAL_TYPE="LevelOneCategory";
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
	protected		Catalog             	mCatalog            ;
	protected		String              	mName               ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<LevelTwoCategory>	mLevelTwoCategoryList;
	
		
	public 	LevelOneCategory(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setCatalog( null );

		this.changed = true;
	}
	
	public 	LevelOneCategory(Catalog catalog, String name)
	{
		setCatalog(catalog);
		setName(name);

		this.mLevelTwoCategoryList = new SmartList<LevelTwoCategory>();	
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
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public LevelOneCategory updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setCatalog(Catalog catalog){
		this.mCatalog = catalog;;
	}
	public Catalog getCatalog(){
		return this.mCatalog;
	}
	public LevelOneCategory updateCatalog(Catalog catalog){
		this.mCatalog = catalog;;
		this.changed = true;
		return this;
	}
	
	
	public void clearCatalog(){
		setCatalog ( null );
		this.changed = true;
	}
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public LevelOneCategory updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public LevelOneCategory updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<LevelTwoCategory> getLevelTwoCategoryList(){
		if(this.mLevelTwoCategoryList == null){
			this.mLevelTwoCategoryList = new SmartList<LevelTwoCategory>();
			this.mLevelTwoCategoryList.setListInternalName (LEVEL_TWO_CATEGORY_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mLevelTwoCategoryList;	
	}
	public  void setLevelTwoCategoryList(SmartList<LevelTwoCategory> levelTwoCategoryList){
		for( LevelTwoCategory levelTwoCategory:levelTwoCategoryList){
			levelTwoCategory.setParentCategory(this);
		}

		this.mLevelTwoCategoryList = levelTwoCategoryList;
		this.mLevelTwoCategoryList.setListInternalName (LEVEL_TWO_CATEGORY_LIST );
		
	}
	
	public  void addLevelTwoCategory(LevelTwoCategory levelTwoCategory){
		levelTwoCategory.setParentCategory(this);
		getLevelTwoCategoryList().add(levelTwoCategory);
	}
	public  void addLevelTwoCategoryList(SmartList<LevelTwoCategory> levelTwoCategoryList){
		for( LevelTwoCategory levelTwoCategory:levelTwoCategoryList){
			levelTwoCategory.setParentCategory(this);
		}
		getLevelTwoCategoryList().addAll(levelTwoCategoryList);
	}
	
	public  LevelTwoCategory removeLevelTwoCategory(LevelTwoCategory levelTwoCategoryIndex){
		
		int index = getLevelTwoCategoryList().indexOf(levelTwoCategoryIndex);
        if(index < 0){
        	String message = "LevelTwoCategory("+levelTwoCategoryIndex.getId()+") with version='"+levelTwoCategoryIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        LevelTwoCategory levelTwoCategory = getLevelTwoCategoryList().get(index);        
        // levelTwoCategory.clearParentCategory(); //disconnect with ParentCategory
        levelTwoCategory.clearFromAll(); //disconnect with ParentCategory
		
		boolean result = getLevelTwoCategoryList().planToRemove(levelTwoCategory);
        if(!result){
        	String message = "LevelTwoCategory("+levelTwoCategoryIndex.getId()+") with version='"+levelTwoCategoryIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return levelTwoCategory;
        
	
	}
	//断舍离
	public  void breakWithLevelTwoCategory(LevelTwoCategory levelTwoCategory){
		
		if(levelTwoCategory == null){
			return;
		}
		levelTwoCategory.setParentCategory(null);
		//getLevelTwoCategoryList().remove();
	
	}
	
	public  boolean hasLevelTwoCategory(LevelTwoCategory levelTwoCategory){
	
		return getLevelTwoCategoryList().contains(levelTwoCategory);
  
	}
	
	public void copyLevelTwoCategoryFrom(LevelTwoCategory levelTwoCategory) {

		LevelTwoCategory levelTwoCategoryInList = findTheLevelTwoCategory(levelTwoCategory);
		LevelTwoCategory newLevelTwoCategory = new LevelTwoCategory();
		levelTwoCategoryInList.copyTo(newLevelTwoCategory);
		newLevelTwoCategory.setVersion(0);//will trigger copy
		getLevelTwoCategoryList().add(newLevelTwoCategory);
		addItemToFlexiableObject(COPIED_CHILD, newLevelTwoCategory);
	}
	
	public  LevelTwoCategory findTheLevelTwoCategory(LevelTwoCategory levelTwoCategory){
		
		int index =  getLevelTwoCategoryList().indexOf(levelTwoCategory);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "LevelTwoCategory("+levelTwoCategory.getId()+") with version='"+levelTwoCategory.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getLevelTwoCategoryList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLevelTwoCategoryList(){
		getLevelTwoCategoryList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getCatalog(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getLevelTwoCategoryList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getLevelTwoCategoryList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, CATALOG_PROPERTY, getCatalog());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, LEVEL_TWO_CATEGORY_LIST, getLevelTwoCategoryList());
		if(!getLevelTwoCategoryList().isEmpty()){
			appendKeyValuePair(result, "levelTwoCategoryCount", getLevelTwoCategoryList().getTotalCount());
			appendKeyValuePair(result, "levelTwoCategoryCurrentPageNumber", getLevelTwoCategoryList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LevelOneCategory){
		
		
			LevelOneCategory dest =(LevelOneCategory)baseDest;
		
			dest.setId(getId());
			dest.setCatalog(getCatalog());
			dest.setName(getName());
			dest.setVersion(getVersion());
			dest.setLevelTwoCategoryList(getLevelTwoCategoryList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("LevelOneCategory{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getCatalog() != null ){
 			stringBuilder.append("\tcatalog='Catalog("+getCatalog().getId()+")';");
 		}
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

