
package com.doublechaintech.retailscm.leveltwodepartment;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
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


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(BELONGS_TO_PROPERTY, "level_one_department", "属于")
        .withType("level_one_department", LevelOneDepartment.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(DESCRIPTION_PROPERTY, "description", "描述")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(FOUNDED_PROPERTY, "founded", "成立")
        .withType("date_past", "Date"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(LEVEL_THREE_DEPARTMENT_LIST, "belongsTo", "三级部门名单")
        .withType("level_three_department", LevelThreeDepartment.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,BELONGS_TO_PROPERTY ,NAME_PROPERTY ,DESCRIPTION_PROPERTY ,FOUNDED_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(LEVEL_THREE_DEPARTMENT_LIST, "belongsTo");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(LEVEL_THREE_DEPARTMENT_LIST, LevelThreeDepartment.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(BELONGS_TO_PROPERTY, LevelOneDepartment.class);

    return parents;
  }

  public LevelTwoDepartment want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public LevelTwoDepartment wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		LevelOneDepartment  	belongsTo           ;
	protected		String              	name                ;
	protected		String              	description         ;
	protected		Date                	founded             ;
	protected		int                 	version             ;

	
	protected		SmartList<LevelThreeDepartment>	mLevelThreeDepartmentList;



	public 	LevelTwoDepartment(){
		// lazy load for all the properties
	}
	public 	static LevelTwoDepartment withId(String id){
		LevelTwoDepartment levelTwoDepartment = new LevelTwoDepartment();
		levelTwoDepartment.setId(id);
		levelTwoDepartment.setVersion(Integer.MAX_VALUE);
		levelTwoDepartment.setChecked(true);
		return levelTwoDepartment;
	}
	public 	static LevelTwoDepartment refById(String id){
		return withId(id);
	}

  public LevelTwoDepartment limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public LevelTwoDepartment limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static LevelTwoDepartment searchExample(){
    LevelTwoDepartment levelTwoDepartment = new LevelTwoDepartment();
    		levelTwoDepartment.setVersion(UNSET_INT);

    return levelTwoDepartment;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setBelongsTo( null );

		this.changed = true;
		setChecked(false);
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

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public LevelTwoDepartment updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public LevelTwoDepartment orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public LevelTwoDepartment ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public LevelTwoDepartment addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setBelongsTo(LevelOneDepartment belongsTo){LevelOneDepartment oldBelongsTo = this.belongsTo;LevelOneDepartment newBelongsTo = belongsTo;this.belongsTo = newBelongsTo;}
	public LevelOneDepartment belongsTo(){
doLoad();
return getBelongsTo();
}
	public LevelOneDepartment getBelongsTo(){
		return this.belongsTo;
	}
	public LevelTwoDepartment updateBelongsTo(LevelOneDepartment belongsTo){LevelOneDepartment oldBelongsTo = this.belongsTo;LevelOneDepartment newBelongsTo = belongsTo;if(!shouldReplaceBy(newBelongsTo, oldBelongsTo)){return this;}this.belongsTo = newBelongsTo;addPropertyChange(BELONGS_TO_PROPERTY, oldBelongsTo, newBelongsTo);this.changed = true;setChecked(false);return this;}
	public LevelTwoDepartment orderByBelongsTo(boolean asc){
doAddOrderBy(BELONGS_TO_PROPERTY, asc);
return this;
}
	public SearchCriteria createBelongsToCriteria(QueryOperator operator, Object... parameters){
return createCriteria(BELONGS_TO_PROPERTY, operator, parameters);
}
	public LevelTwoDepartment ignoreBelongsToCriteria(){super.ignoreSearchProperty(BELONGS_TO_PROPERTY);
return this;
}
	public LevelTwoDepartment addBelongsToCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createBelongsToCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeBelongsTo(LevelOneDepartment belongsTo){
		if(belongsTo != null) { setBelongsTo(belongsTo);}
	}

	
	public void clearBelongsTo(){
		setBelongsTo ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setName(String name){String oldName = this.name;String newName = trimString(name);this.name = newName;}
	public String name(){
doLoad();
return getName();
}
	public String getName(){
		return this.name;
	}
	public LevelTwoDepartment updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public LevelTwoDepartment orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public LevelTwoDepartment ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public LevelTwoDepartment addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setDescription(String description){String oldDescription = this.description;String newDescription = trimString(description);this.description = newDescription;}
	public String description(){
doLoad();
return getDescription();
}
	public String getDescription(){
		return this.description;
	}
	public LevelTwoDepartment updateDescription(String description){String oldDescription = this.description;String newDescription = trimString(description);if(!shouldReplaceBy(newDescription, oldDescription)){return this;}this.description = newDescription;addPropertyChange(DESCRIPTION_PROPERTY, oldDescription, newDescription);this.changed = true;setChecked(false);return this;}
	public LevelTwoDepartment orderByDescription(boolean asc){
doAddOrderBy(DESCRIPTION_PROPERTY, asc);
return this;
}
	public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
}
	public LevelTwoDepartment ignoreDescriptionCriteria(){super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
return this;
}
	public LevelTwoDepartment addDescriptionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createDescriptionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}

	
	public void setFounded(Date founded){Date oldFounded = this.founded;Date newFounded = founded;this.founded = newFounded;}
	public Date founded(){
doLoad();
return getFounded();
}
	public Date getFounded(){
		return this.founded;
	}
	public LevelTwoDepartment updateFounded(Date founded){Date oldFounded = this.founded;Date newFounded = founded;if(!shouldReplaceBy(newFounded, oldFounded)){return this;}this.founded = newFounded;addPropertyChange(FOUNDED_PROPERTY, oldFounded, newFounded);this.changed = true;setChecked(false);return this;}
	public LevelTwoDepartment orderByFounded(boolean asc){
doAddOrderBy(FOUNDED_PROPERTY, asc);
return this;
}
	public SearchCriteria createFoundedCriteria(QueryOperator operator, Object... parameters){
return createCriteria(FOUNDED_PROPERTY, operator, parameters);
}
	public LevelTwoDepartment ignoreFoundedCriteria(){super.ignoreSearchProperty(FOUNDED_PROPERTY);
return this;
}
	public LevelTwoDepartment addFoundedCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createFoundedCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeFounded(Date founded){
		setFounded(founded);
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public LevelTwoDepartment updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public LevelTwoDepartment orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public LevelTwoDepartment ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public LevelTwoDepartment addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
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

  public  SmartList<LevelThreeDepartment> levelThreeDepartmentList(){
    
    doLoadChild(LEVEL_THREE_DEPARTMENT_LIST);
    
    return getLevelThreeDepartmentList();
  }


	public  void setLevelThreeDepartmentList(SmartList<LevelThreeDepartment> levelThreeDepartmentList){
		for( LevelThreeDepartment levelThreeDepartment:levelThreeDepartmentList){
			levelThreeDepartment.setBelongsTo(this);
		}

		this.mLevelThreeDepartmentList = levelThreeDepartmentList;
		this.mLevelThreeDepartmentList.setListInternalName (LEVEL_THREE_DEPARTMENT_LIST );

	}

	public  LevelTwoDepartment addLevelThreeDepartment(LevelThreeDepartment levelThreeDepartment){
		levelThreeDepartment.setBelongsTo(this);
		getLevelThreeDepartmentList().add(levelThreeDepartment);
		return this;
	}
	public  LevelTwoDepartment addLevelThreeDepartmentList(SmartList<LevelThreeDepartment> levelThreeDepartmentList){
		for( LevelThreeDepartment levelThreeDepartment:levelThreeDepartmentList){
			levelThreeDepartment.setBelongsTo(this);
		}
		getLevelThreeDepartmentList().addAll(levelThreeDepartmentList);
		return this;
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


	public static LevelTwoDepartment createWith(RetailscmUserContext userContext, ThrowingFunction<LevelTwoDepartment,LevelTwoDepartment,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<LevelTwoDepartment> customCreator = mapper.findCustomCreator(LevelTwoDepartment.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    LevelTwoDepartment result = new LevelTwoDepartment();
    result.setBelongsTo(mapper.tryToGet(LevelTwoDepartment.class, BELONGS_TO_PROPERTY, LevelOneDepartment.class,
        0, true, result.getBelongsTo(), params));
    result.setName(mapper.tryToGet(LevelTwoDepartment.class, NAME_PROPERTY, String.class,
        0, false, result.getName(), params));
    result.setDescription(mapper.tryToGet(LevelTwoDepartment.class, DESCRIPTION_PROPERTY, String.class,
        1, false, result.getDescription(), params));
    result.setFounded(mapper.tryToGet(LevelTwoDepartment.class, FOUNDED_PROPERTY, Date.class,
        0, true, result.getFounded(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixLevelTwoDepartment(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      LevelTwoDepartmentTokens tokens = mapper.findParamByClass(params, LevelTwoDepartmentTokens.class);
      if (tokens == null) {
        tokens = LevelTwoDepartmentTokens.start();
      }
      result = userContext.getManagerGroup().getLevelTwoDepartmentManager().internalSaveLevelTwoDepartment(userContext, result, tokens.done());
      
    }
    return result;
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

