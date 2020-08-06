
package com.doublechaintech.retailscm.leveltwodepartment;

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
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;









@JsonSerialize(using = LevelTwoDepartmentSerializer.class)
public class LevelTwoDepartment extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String BELONGS_TO_PROPERTY            = "belongsTo"         ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String LEVEL_THREE_DEPARTMENT_LIST              = "levelThreeDepartmentList";

	public static final String INTERNAL_TYPE="LevelTwoDepartment";
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
	protected		LevelOneDepartment  	mBelongsTo          ;
	protected		String              	mName               ;
	protected		String              	mDescription        ;
	protected		Date                	mFounded            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<LevelThreeDepartment>	mLevelThreeDepartmentList;

	
		
	public 	LevelTwoDepartment(){
		// lazy load for all the properties
	}
	public 	static LevelTwoDepartment withId(String id){
		LevelTwoDepartment levelTwoDepartment = new LevelTwoDepartment();
		levelTwoDepartment.setId(id);
		levelTwoDepartment.setVersion(Integer.MAX_VALUE);
		return levelTwoDepartment;
	}
	public 	static LevelTwoDepartment refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setBelongsTo( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
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
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(BELONGS_TO_PROPERTY.equals(property)){
			return getBelongsTo();
		}
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			return getDescription();
		}
		if(FOUNDED_PROPERTY.equals(property)){
			return getFounded();
		}
		if(LEVEL_THREE_DEPARTMENT_LIST.equals(property)){
			List<BaseEntity> list = getLevelThreeDepartmentList().stream().map(item->item).collect(Collectors.toList());
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
	public LevelTwoDepartment updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setBelongsTo(LevelOneDepartment belongsTo){
		this.mBelongsTo = belongsTo;;
	}
	public LevelOneDepartment getBelongsTo(){
		return this.mBelongsTo;
	}
	public LevelTwoDepartment updateBelongsTo(LevelOneDepartment belongsTo){
		this.mBelongsTo = belongsTo;;
		this.changed = true;
		return this;
	}
	public void mergeBelongsTo(LevelOneDepartment belongsTo){
		if(belongsTo != null) { setBelongsTo(belongsTo);}
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
	public LevelTwoDepartment updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public LevelTwoDepartment updateDescription(String description){
		this.mDescription = trimString(description);;
		this.changed = true;
		return this;
	}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}
	
	
	public void setFounded(Date founded){
		this.mFounded = founded;;
	}
	public Date getFounded(){
		return this.mFounded;
	}
	public LevelTwoDepartment updateFounded(Date founded){
		this.mFounded = founded;;
		this.changed = true;
		return this;
	}
	public void mergeFounded(Date founded){
		setFounded(founded);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public LevelTwoDepartment updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<LevelThreeDepartment> getLevelThreeDepartmentList(){
		if(this.mLevelThreeDepartmentList == null){
			this.mLevelThreeDepartmentList = new SmartList<LevelThreeDepartment>();
			this.mLevelThreeDepartmentList.setListInternalName (LEVEL_THREE_DEPARTMENT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mLevelThreeDepartmentList;	
	}
	public  void setLevelThreeDepartmentList(SmartList<LevelThreeDepartment> levelThreeDepartmentList){
		for( LevelThreeDepartment levelThreeDepartment:levelThreeDepartmentList){
			levelThreeDepartment.setBelongsTo(this);
		}

		this.mLevelThreeDepartmentList = levelThreeDepartmentList;
		this.mLevelThreeDepartmentList.setListInternalName (LEVEL_THREE_DEPARTMENT_LIST );
		
	}
	
	public  void addLevelThreeDepartment(LevelThreeDepartment levelThreeDepartment){
		levelThreeDepartment.setBelongsTo(this);
		getLevelThreeDepartmentList().add(levelThreeDepartment);
	}
	public  void addLevelThreeDepartmentList(SmartList<LevelThreeDepartment> levelThreeDepartmentList){
		for( LevelThreeDepartment levelThreeDepartment:levelThreeDepartmentList){
			levelThreeDepartment.setBelongsTo(this);
		}
		getLevelThreeDepartmentList().addAll(levelThreeDepartmentList);
	}
	public  void mergeLevelThreeDepartmentList(SmartList<LevelThreeDepartment> levelThreeDepartmentList){
		if(levelThreeDepartmentList==null){
			return;
		}
		if(levelThreeDepartmentList.isEmpty()){
			return;
		}
		addLevelThreeDepartmentList( levelThreeDepartmentList );
		
	}
	public  LevelThreeDepartment removeLevelThreeDepartment(LevelThreeDepartment levelThreeDepartmentIndex){
		
		int index = getLevelThreeDepartmentList().indexOf(levelThreeDepartmentIndex);
        if(index < 0){
        	String message = "LevelThreeDepartment("+levelThreeDepartmentIndex.getId()+") with version='"+levelThreeDepartmentIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        LevelThreeDepartment levelThreeDepartment = getLevelThreeDepartmentList().get(index);        
        // levelThreeDepartment.clearBelongsTo(); //disconnect with BelongsTo
        levelThreeDepartment.clearFromAll(); //disconnect with BelongsTo
		
		boolean result = getLevelThreeDepartmentList().planToRemove(levelThreeDepartment);
        if(!result){
        	String message = "LevelThreeDepartment("+levelThreeDepartmentIndex.getId()+") with version='"+levelThreeDepartmentIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return levelThreeDepartment;
        
	
	}
	//断舍离
	public  void breakWithLevelThreeDepartment(LevelThreeDepartment levelThreeDepartment){
		
		if(levelThreeDepartment == null){
			return;
		}
		levelThreeDepartment.setBelongsTo(null);
		//getLevelThreeDepartmentList().remove();
	
	}
	
	public  boolean hasLevelThreeDepartment(LevelThreeDepartment levelThreeDepartment){
	
		return getLevelThreeDepartmentList().contains(levelThreeDepartment);
  
	}
	
	public void copyLevelThreeDepartmentFrom(LevelThreeDepartment levelThreeDepartment) {

		LevelThreeDepartment levelThreeDepartmentInList = findTheLevelThreeDepartment(levelThreeDepartment);
		LevelThreeDepartment newLevelThreeDepartment = new LevelThreeDepartment();
		levelThreeDepartmentInList.copyTo(newLevelThreeDepartment);
		newLevelThreeDepartment.setVersion(0);//will trigger copy
		getLevelThreeDepartmentList().add(newLevelThreeDepartment);
		addItemToFlexiableObject(COPIED_CHILD, newLevelThreeDepartment);
	}
	
	public  LevelThreeDepartment findTheLevelThreeDepartment(LevelThreeDepartment levelThreeDepartment){
		
		int index =  getLevelThreeDepartmentList().indexOf(levelThreeDepartment);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "LevelThreeDepartment("+levelThreeDepartment.getId()+") with version='"+levelThreeDepartment.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getLevelThreeDepartmentList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLevelThreeDepartmentList(){
		getLevelThreeDepartmentList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getBelongsTo(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getLevelThreeDepartmentList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getLevelThreeDepartmentList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, BELONGS_TO_PROPERTY, getBelongsTo());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, FOUNDED_PROPERTY, getFounded());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, LEVEL_THREE_DEPARTMENT_LIST, getLevelThreeDepartmentList());
		if(!getLevelThreeDepartmentList().isEmpty()){
			appendKeyValuePair(result, "levelThreeDepartmentCount", getLevelThreeDepartmentList().getTotalCount());
			appendKeyValuePair(result, "levelThreeDepartmentCurrentPageNumber", getLevelThreeDepartmentList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LevelTwoDepartment){
		
		
			LevelTwoDepartment dest =(LevelTwoDepartment)baseDest;
		
			dest.setId(getId());
			dest.setBelongsTo(getBelongsTo());
			dest.setName(getName());
			dest.setDescription(getDescription());
			dest.setFounded(getFounded());
			dest.setVersion(getVersion());
			dest.setLevelThreeDepartmentList(getLevelThreeDepartmentList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LevelTwoDepartment){
		
			
			LevelTwoDepartment dest =(LevelTwoDepartment)baseDest;
		
			dest.mergeId(getId());
			dest.mergeBelongsTo(getBelongsTo());
			dest.mergeName(getName());
			dest.mergeDescription(getDescription());
			dest.mergeFounded(getFounded());
			dest.mergeVersion(getVersion());
			dest.mergeLevelThreeDepartmentList(getLevelThreeDepartmentList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LevelTwoDepartment){
		
			
			LevelTwoDepartment dest =(LevelTwoDepartment)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeDescription(getDescription());
			dest.mergeFounded(getFounded());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getBelongsTo(), getName(), getDescription(), getFounded(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("LevelTwoDepartment{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getBelongsTo() != null ){
 			stringBuilder.append("\tbelongsTo='LevelOneDepartment("+getBelongsTo().getId()+")';");
 		}
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

