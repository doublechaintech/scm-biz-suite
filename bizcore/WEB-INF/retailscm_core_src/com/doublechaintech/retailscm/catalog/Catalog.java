
package com.doublechaintech.retailscm.catalog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;

@JsonSerialize(using = CatalogSerializer.class)
public class Catalog extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String LEVEL_ONE_CATEGORY_LIST                  = "levelOneCategoryList";

	public static final String INTERNAL_TYPE="Catalog";
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
	protected		String              	mName               ;
	protected		RetailStoreCountryCenter	mOwner              ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<LevelOneCategory>	mLevelOneCategoryList;
	
		
	public 	Catalog(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setOwner( null );

		this.changed = true;
	}
	
	public 	Catalog(String name, RetailStoreCountryCenter owner)
	{
		setName(name);
		setOwner(owner);

		this.mLevelOneCategoryList = new SmartList<LevelOneCategory>();	
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
	public Catalog updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public Catalog updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setOwner(RetailStoreCountryCenter owner){
		this.mOwner = owner;;
	}
	public RetailStoreCountryCenter getOwner(){
		return this.mOwner;
	}
	public Catalog updateOwner(RetailStoreCountryCenter owner){
		this.mOwner = owner;;
		this.changed = true;
		return this;
	}
	
	
	public void clearOwner(){
		setOwner ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Catalog updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<LevelOneCategory> getLevelOneCategoryList(){
		if(this.mLevelOneCategoryList == null){
			this.mLevelOneCategoryList = new SmartList<LevelOneCategory>();
			this.mLevelOneCategoryList.setListInternalName (LEVEL_ONE_CATEGORY_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mLevelOneCategoryList;	
	}
	public  void setLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList){
		for( LevelOneCategory levelOneCategory:levelOneCategoryList){
			levelOneCategory.setCatalog(this);
		}

		this.mLevelOneCategoryList = levelOneCategoryList;
		this.mLevelOneCategoryList.setListInternalName (LEVEL_ONE_CATEGORY_LIST );
		
	}
	
	public  void addLevelOneCategory(LevelOneCategory levelOneCategory){
		levelOneCategory.setCatalog(this);
		getLevelOneCategoryList().add(levelOneCategory);
	}
	public  void addLevelOneCategoryList(SmartList<LevelOneCategory> levelOneCategoryList){
		for( LevelOneCategory levelOneCategory:levelOneCategoryList){
			levelOneCategory.setCatalog(this);
		}
		getLevelOneCategoryList().addAll(levelOneCategoryList);
	}
	
	public  LevelOneCategory removeLevelOneCategory(LevelOneCategory levelOneCategoryIndex){
		
		int index = getLevelOneCategoryList().indexOf(levelOneCategoryIndex);
        if(index < 0){
        	String message = "LevelOneCategory("+levelOneCategoryIndex.getId()+") with version='"+levelOneCategoryIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        LevelOneCategory levelOneCategory = getLevelOneCategoryList().get(index);        
        // levelOneCategory.clearCatalog(); //disconnect with Catalog
        levelOneCategory.clearFromAll(); //disconnect with Catalog
		
		boolean result = getLevelOneCategoryList().planToRemove(levelOneCategory);
        if(!result){
        	String message = "LevelOneCategory("+levelOneCategoryIndex.getId()+") with version='"+levelOneCategoryIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return levelOneCategory;
        
	
	}
	//断舍离
	public  void breakWithLevelOneCategory(LevelOneCategory levelOneCategory){
		
		if(levelOneCategory == null){
			return;
		}
		levelOneCategory.setCatalog(null);
		//getLevelOneCategoryList().remove();
	
	}
	
	public  boolean hasLevelOneCategory(LevelOneCategory levelOneCategory){
	
		return getLevelOneCategoryList().contains(levelOneCategory);
  
	}
	
	public void copyLevelOneCategoryFrom(LevelOneCategory levelOneCategory) {

		LevelOneCategory levelOneCategoryInList = findTheLevelOneCategory(levelOneCategory);
		LevelOneCategory newLevelOneCategory = new LevelOneCategory();
		levelOneCategoryInList.copyTo(newLevelOneCategory);
		newLevelOneCategory.setVersion(0);//will trigger copy
		getLevelOneCategoryList().add(newLevelOneCategory);
		addItemToFlexiableObject(COPIED_CHILD, newLevelOneCategory);
	}
	
	public  LevelOneCategory findTheLevelOneCategory(LevelOneCategory levelOneCategory){
		
		int index =  getLevelOneCategoryList().indexOf(levelOneCategory);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "LevelOneCategory("+levelOneCategory.getId()+") with version='"+levelOneCategory.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getLevelOneCategoryList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLevelOneCategoryList(){
		getLevelOneCategoryList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getOwner(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getLevelOneCategoryList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getLevelOneCategoryList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, OWNER_PROPERTY, getOwner());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, LEVEL_ONE_CATEGORY_LIST, getLevelOneCategoryList());
		if(!getLevelOneCategoryList().isEmpty()){
			appendKeyValuePair(result, "levelOneCategoryCount", getLevelOneCategoryList().getTotalCount());
			appendKeyValuePair(result, "levelOneCategoryCurrentPageNumber", getLevelOneCategoryList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Catalog){
		
		
			Catalog dest =(Catalog)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setOwner(getOwner());
			dest.setVersion(getVersion());
			dest.setLevelOneCategoryList(getLevelOneCategoryList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Catalog{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='RetailStoreCountryCenter("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

