
package com.doublechaintech.retailscm.levelonedepartment;

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
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;

@JsonSerialize(using = LevelOneDepartmentSerializer.class)
public class LevelOneDepartment extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String BELONGS_TO_PROPERTY            = "belongsTo"         ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String MANAGER_PROPERTY               = "manager"           ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String LEVEL_TWO_DEPARTMENT_LIST                = "levelTwoDepartmentList";

	public static final String INTERNAL_TYPE="LevelOneDepartment";
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
	protected		RetailStoreCountryCenter	mBelongsTo          ;
	protected		String              	mName               ;
	protected		String              	mDescription        ;
	protected		String              	mManager            ;
	protected		Date                	mFounded            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<LevelTwoDepartment>	mLevelTwoDepartmentList;
	
		
	public 	LevelOneDepartment(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setBelongsTo( null );

		this.changed = true;
	}
	
	public 	LevelOneDepartment(RetailStoreCountryCenter belongsTo, String name, String description, String manager, Date founded)
	{
		setBelongsTo(belongsTo);
		setName(name);
		setDescription(description);
		setManager(manager);
		setFounded(founded);

		this.mLevelTwoDepartmentList = new SmartList<LevelTwoDepartment>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}
		if(MANAGER_PROPERTY.equals(property)){
			changeManagerProperty(newValueExpr);
		}
		if(FOUNDED_PROPERTY.equals(property)){
			changeFoundedProperty(newValueExpr);
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
			
			
			
	protected void changeDescriptionProperty(String newValueExpr){
		String oldValue = getDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDescription(newValue);
		this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeManagerProperty(String newValueExpr){
		String oldValue = getManager();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateManager(newValue);
		this.onChangeProperty(MANAGER_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeFoundedProperty(String newValueExpr){
		Date oldValue = getFounded();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateFounded(newValue);
		this.onChangeProperty(FOUNDED_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public LevelOneDepartment updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setBelongsTo(RetailStoreCountryCenter belongsTo){
		this.mBelongsTo = belongsTo;;
	}
	public RetailStoreCountryCenter getBelongsTo(){
		return this.mBelongsTo;
	}
	public LevelOneDepartment updateBelongsTo(RetailStoreCountryCenter belongsTo){
		this.mBelongsTo = belongsTo;;
		this.changed = true;
		return this;
	}
	
	
	public void clearBelongsTo(){
		setBelongsTo ( null );
		this.changed = true;
	}
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public LevelOneDepartment updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public LevelOneDepartment updateDescription(String description){
		this.mDescription = trimString(description);;
		this.changed = true;
		return this;
	}
	
	
	public void setManager(String manager){
		this.mManager = trimString(manager);;
	}
	public String getManager(){
		return this.mManager;
	}
	public LevelOneDepartment updateManager(String manager){
		this.mManager = trimString(manager);;
		this.changed = true;
		return this;
	}
	
	
	public void setFounded(Date founded){
		this.mFounded = founded;;
	}
	public Date getFounded(){
		return this.mFounded;
	}
	public LevelOneDepartment updateFounded(Date founded){
		this.mFounded = founded;;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public LevelOneDepartment updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<LevelTwoDepartment> getLevelTwoDepartmentList(){
		if(this.mLevelTwoDepartmentList == null){
			this.mLevelTwoDepartmentList = new SmartList<LevelTwoDepartment>();
			this.mLevelTwoDepartmentList.setListInternalName (LEVEL_TWO_DEPARTMENT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mLevelTwoDepartmentList;	
	}
	public  void setLevelTwoDepartmentList(SmartList<LevelTwoDepartment> levelTwoDepartmentList){
		for( LevelTwoDepartment levelTwoDepartment:levelTwoDepartmentList){
			levelTwoDepartment.setBelongsTo(this);
		}

		this.mLevelTwoDepartmentList = levelTwoDepartmentList;
		this.mLevelTwoDepartmentList.setListInternalName (LEVEL_TWO_DEPARTMENT_LIST );
		
	}
	
	public  void addLevelTwoDepartment(LevelTwoDepartment levelTwoDepartment){
		levelTwoDepartment.setBelongsTo(this);
		getLevelTwoDepartmentList().add(levelTwoDepartment);
	}
	public  void addLevelTwoDepartmentList(SmartList<LevelTwoDepartment> levelTwoDepartmentList){
		for( LevelTwoDepartment levelTwoDepartment:levelTwoDepartmentList){
			levelTwoDepartment.setBelongsTo(this);
		}
		getLevelTwoDepartmentList().addAll(levelTwoDepartmentList);
	}
	
	public  LevelTwoDepartment removeLevelTwoDepartment(LevelTwoDepartment levelTwoDepartmentIndex){
		
		int index = getLevelTwoDepartmentList().indexOf(levelTwoDepartmentIndex);
        if(index < 0){
        	String message = "LevelTwoDepartment("+levelTwoDepartmentIndex.getId()+") with version='"+levelTwoDepartmentIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        LevelTwoDepartment levelTwoDepartment = getLevelTwoDepartmentList().get(index);        
        // levelTwoDepartment.clearBelongsTo(); //disconnect with BelongsTo
        levelTwoDepartment.clearFromAll(); //disconnect with BelongsTo
		
		boolean result = getLevelTwoDepartmentList().planToRemove(levelTwoDepartment);
        if(!result){
        	String message = "LevelTwoDepartment("+levelTwoDepartmentIndex.getId()+") with version='"+levelTwoDepartmentIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return levelTwoDepartment;
        
	
	}
	//断舍离
	public  void breakWithLevelTwoDepartment(LevelTwoDepartment levelTwoDepartment){
		
		if(levelTwoDepartment == null){
			return;
		}
		levelTwoDepartment.setBelongsTo(null);
		//getLevelTwoDepartmentList().remove();
	
	}
	
	public  boolean hasLevelTwoDepartment(LevelTwoDepartment levelTwoDepartment){
	
		return getLevelTwoDepartmentList().contains(levelTwoDepartment);
  
	}
	
	public void copyLevelTwoDepartmentFrom(LevelTwoDepartment levelTwoDepartment) {

		LevelTwoDepartment levelTwoDepartmentInList = findTheLevelTwoDepartment(levelTwoDepartment);
		LevelTwoDepartment newLevelTwoDepartment = new LevelTwoDepartment();
		levelTwoDepartmentInList.copyTo(newLevelTwoDepartment);
		newLevelTwoDepartment.setVersion(0);//will trigger copy
		getLevelTwoDepartmentList().add(newLevelTwoDepartment);
		addItemToFlexiableObject(COPIED_CHILD, newLevelTwoDepartment);
	}
	
	public  LevelTwoDepartment findTheLevelTwoDepartment(LevelTwoDepartment levelTwoDepartment){
		
		int index =  getLevelTwoDepartmentList().indexOf(levelTwoDepartment);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "LevelTwoDepartment("+levelTwoDepartment.getId()+") with version='"+levelTwoDepartment.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getLevelTwoDepartmentList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLevelTwoDepartmentList(){
		getLevelTwoDepartmentList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getBelongsTo(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getLevelTwoDepartmentList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getLevelTwoDepartmentList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, BELONGS_TO_PROPERTY, getBelongsTo());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, MANAGER_PROPERTY, getManager());
		appendKeyValuePair(result, FOUNDED_PROPERTY, getFounded());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, LEVEL_TWO_DEPARTMENT_LIST, getLevelTwoDepartmentList());
		if(!getLevelTwoDepartmentList().isEmpty()){
			appendKeyValuePair(result, "levelTwoDepartmentCount", getLevelTwoDepartmentList().getTotalCount());
			appendKeyValuePair(result, "levelTwoDepartmentCurrentPageNumber", getLevelTwoDepartmentList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LevelOneDepartment){
		
		
			LevelOneDepartment dest =(LevelOneDepartment)baseDest;
		
			dest.setId(getId());
			dest.setBelongsTo(getBelongsTo());
			dest.setName(getName());
			dest.setDescription(getDescription());
			dest.setManager(getManager());
			dest.setFounded(getFounded());
			dest.setVersion(getVersion());
			dest.setLevelTwoDepartmentList(getLevelTwoDepartmentList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("LevelOneDepartment{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getBelongsTo() != null ){
 			stringBuilder.append("\tbelongsTo='RetailStoreCountryCenter("+getBelongsTo().getId()+")';");
 		}
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tmanager='"+getManager()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

