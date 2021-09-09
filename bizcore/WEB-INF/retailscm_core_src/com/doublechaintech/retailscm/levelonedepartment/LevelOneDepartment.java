
package com.doublechaintech.retailscm.levelonedepartment;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
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


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(BELONGS_TO_PROPERTY, "retail_store_country_center", "属于")
        .withType("retail_store_country_center", RetailStoreCountryCenter.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(DESCRIPTION_PROPERTY, "description", "描述")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(MANAGER_PROPERTY, "manager", "经理")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(FOUNDED_PROPERTY, "founded", "成立")
        .withType("date_past", "Date"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(LEVEL_TWO_DEPARTMENT_LIST, "belongsTo", "二级部门名单")
        .withType("level_two_department", LevelTwoDepartment.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,BELONGS_TO_PROPERTY ,NAME_PROPERTY ,DESCRIPTION_PROPERTY ,MANAGER_PROPERTY ,FOUNDED_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(LEVEL_TWO_DEPARTMENT_LIST, "belongsTo");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(LEVEL_TWO_DEPARTMENT_LIST, LevelTwoDepartment.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(BELONGS_TO_PROPERTY, RetailStoreCountryCenter.class);

    return parents;
  }

  public LevelOneDepartment want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public LevelOneDepartment wants(Class<? extends BaseEntity>... classes) {
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
	protected		RetailStoreCountryCenter	belongsTo           ;
	protected		String              	name                ;
	protected		String              	description         ;
	protected		String              	manager             ;
	protected		Date                	founded             ;
	protected		int                 	version             ;

	
	protected		SmartList<LevelTwoDepartment>	mLevelTwoDepartmentList;



	public 	LevelOneDepartment(){
		// lazy load for all the properties
	}
	public 	static LevelOneDepartment withId(String id){
		LevelOneDepartment levelOneDepartment = new LevelOneDepartment();
		levelOneDepartment.setId(id);
		levelOneDepartment.setVersion(Integer.MAX_VALUE);
		levelOneDepartment.setChecked(true);
		return levelOneDepartment;
	}
	public 	static LevelOneDepartment refById(String id){
		return withId(id);
	}

  public LevelOneDepartment limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public LevelOneDepartment limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static LevelOneDepartment searchExample(){
    LevelOneDepartment levelOneDepartment = new LevelOneDepartment();
    		levelOneDepartment.setVersion(UNSET_INT);

    return levelOneDepartment;
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
		if(MANAGER_PROPERTY.equals(property)){
			return getManager();
		}
		if(FOUNDED_PROPERTY.equals(property)){
			return getFounded();
		}
		if(LEVEL_TWO_DEPARTMENT_LIST.equals(property)){
			List<BaseEntity> list = getLevelTwoDepartmentList().stream().map(item->item).collect(Collectors.toList());
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
	public LevelOneDepartment updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public LevelOneDepartment orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public LevelOneDepartment ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public LevelOneDepartment addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setBelongsTo(RetailStoreCountryCenter belongsTo){RetailStoreCountryCenter oldBelongsTo = this.belongsTo;RetailStoreCountryCenter newBelongsTo = belongsTo;this.belongsTo = newBelongsTo;}
	public RetailStoreCountryCenter belongsTo(){
doLoad();
return getBelongsTo();
}
	public RetailStoreCountryCenter getBelongsTo(){
		return this.belongsTo;
	}
	public LevelOneDepartment updateBelongsTo(RetailStoreCountryCenter belongsTo){RetailStoreCountryCenter oldBelongsTo = this.belongsTo;RetailStoreCountryCenter newBelongsTo = belongsTo;if(!shouldReplaceBy(newBelongsTo, oldBelongsTo)){return this;}this.belongsTo = newBelongsTo;addPropertyChange(BELONGS_TO_PROPERTY, oldBelongsTo, newBelongsTo);this.changed = true;setChecked(false);return this;}
	public LevelOneDepartment orderByBelongsTo(boolean asc){
doAddOrderBy(BELONGS_TO_PROPERTY, asc);
return this;
}
	public SearchCriteria createBelongsToCriteria(QueryOperator operator, Object... parameters){
return createCriteria(BELONGS_TO_PROPERTY, operator, parameters);
}
	public LevelOneDepartment ignoreBelongsToCriteria(){super.ignoreSearchProperty(BELONGS_TO_PROPERTY);
return this;
}
	public LevelOneDepartment addBelongsToCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createBelongsToCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeBelongsTo(RetailStoreCountryCenter belongsTo){
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
	public LevelOneDepartment updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public LevelOneDepartment orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public LevelOneDepartment ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public LevelOneDepartment addNameCriteria(QueryOperator operator, Object... parameters){
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
	public LevelOneDepartment updateDescription(String description){String oldDescription = this.description;String newDescription = trimString(description);if(!shouldReplaceBy(newDescription, oldDescription)){return this;}this.description = newDescription;addPropertyChange(DESCRIPTION_PROPERTY, oldDescription, newDescription);this.changed = true;setChecked(false);return this;}
	public LevelOneDepartment orderByDescription(boolean asc){
doAddOrderBy(DESCRIPTION_PROPERTY, asc);
return this;
}
	public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
}
	public LevelOneDepartment ignoreDescriptionCriteria(){super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
return this;
}
	public LevelOneDepartment addDescriptionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createDescriptionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}

	
	public void setManager(String manager){String oldManager = this.manager;String newManager = trimString(manager);this.manager = newManager;}
	public String manager(){
doLoad();
return getManager();
}
	public String getManager(){
		return this.manager;
	}
	public LevelOneDepartment updateManager(String manager){String oldManager = this.manager;String newManager = trimString(manager);if(!shouldReplaceBy(newManager, oldManager)){return this;}this.manager = newManager;addPropertyChange(MANAGER_PROPERTY, oldManager, newManager);this.changed = true;setChecked(false);return this;}
	public LevelOneDepartment orderByManager(boolean asc){
doAddOrderBy(MANAGER_PROPERTY, asc);
return this;
}
	public SearchCriteria createManagerCriteria(QueryOperator operator, Object... parameters){
return createCriteria(MANAGER_PROPERTY, operator, parameters);
}
	public LevelOneDepartment ignoreManagerCriteria(){super.ignoreSearchProperty(MANAGER_PROPERTY);
return this;
}
	public LevelOneDepartment addManagerCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createManagerCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeManager(String manager){
		if(manager != null) { setManager(manager);}
	}

	
	public void setFounded(Date founded){Date oldFounded = this.founded;Date newFounded = founded;this.founded = newFounded;}
	public Date founded(){
doLoad();
return getFounded();
}
	public Date getFounded(){
		return this.founded;
	}
	public LevelOneDepartment updateFounded(Date founded){Date oldFounded = this.founded;Date newFounded = founded;if(!shouldReplaceBy(newFounded, oldFounded)){return this;}this.founded = newFounded;addPropertyChange(FOUNDED_PROPERTY, oldFounded, newFounded);this.changed = true;setChecked(false);return this;}
	public LevelOneDepartment orderByFounded(boolean asc){
doAddOrderBy(FOUNDED_PROPERTY, asc);
return this;
}
	public SearchCriteria createFoundedCriteria(QueryOperator operator, Object... parameters){
return createCriteria(FOUNDED_PROPERTY, operator, parameters);
}
	public LevelOneDepartment ignoreFoundedCriteria(){super.ignoreSearchProperty(FOUNDED_PROPERTY);
return this;
}
	public LevelOneDepartment addFoundedCriteria(QueryOperator operator, Object... parameters){
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
	public LevelOneDepartment updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public LevelOneDepartment orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public LevelOneDepartment ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public LevelOneDepartment addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public  SmartList<LevelTwoDepartment> getLevelTwoDepartmentList(){
		if(this.mLevelTwoDepartmentList == null){
			this.mLevelTwoDepartmentList = new SmartList<LevelTwoDepartment>();
			this.mLevelTwoDepartmentList.setListInternalName (LEVEL_TWO_DEPARTMENT_LIST );
			//有名字，便于做权限控制
		}

		return this.mLevelTwoDepartmentList;
	}

  public  SmartList<LevelTwoDepartment> levelTwoDepartmentList(){
    
    doLoadChild(LEVEL_TWO_DEPARTMENT_LIST);
    
    return getLevelTwoDepartmentList();
  }


	public  void setLevelTwoDepartmentList(SmartList<LevelTwoDepartment> levelTwoDepartmentList){
		for( LevelTwoDepartment levelTwoDepartment:levelTwoDepartmentList){
			levelTwoDepartment.setBelongsTo(this);
		}

		this.mLevelTwoDepartmentList = levelTwoDepartmentList;
		this.mLevelTwoDepartmentList.setListInternalName (LEVEL_TWO_DEPARTMENT_LIST );

	}

	public  LevelOneDepartment addLevelTwoDepartment(LevelTwoDepartment levelTwoDepartment){
		levelTwoDepartment.setBelongsTo(this);
		getLevelTwoDepartmentList().add(levelTwoDepartment);
		return this;
	}
	public  LevelOneDepartment addLevelTwoDepartmentList(SmartList<LevelTwoDepartment> levelTwoDepartmentList){
		for( LevelTwoDepartment levelTwoDepartment:levelTwoDepartmentList){
			levelTwoDepartment.setBelongsTo(this);
		}
		getLevelTwoDepartmentList().addAll(levelTwoDepartmentList);
		return this;
	}
	public  void mergeLevelTwoDepartmentList(SmartList<LevelTwoDepartment> levelTwoDepartmentList){
		if(levelTwoDepartmentList==null){
			return;
		}
		if(levelTwoDepartmentList.isEmpty()){
			return;
		}
		addLevelTwoDepartmentList( levelTwoDepartmentList );

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

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
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
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof LevelOneDepartment){


			LevelOneDepartment dest =(LevelOneDepartment)baseDest;

			dest.mergeId(getId());
			dest.mergeBelongsTo(getBelongsTo());
			dest.mergeName(getName());
			dest.mergeDescription(getDescription());
			dest.mergeManager(getManager());
			dest.mergeFounded(getFounded());
			dest.mergeVersion(getVersion());
			dest.mergeLevelTwoDepartmentList(getLevelTwoDepartmentList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof LevelOneDepartment){


			LevelOneDepartment dest =(LevelOneDepartment)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeDescription(getDescription());
			dest.mergeManager(getManager());
			dest.mergeFounded(getFounded());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getBelongsTo(), getName(), getDescription(), getManager(), getFounded(), getVersion()};
	}


	public static LevelOneDepartment createWith(RetailscmUserContext userContext, ThrowingFunction<LevelOneDepartment,LevelOneDepartment,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<LevelOneDepartment> customCreator = mapper.findCustomCreator(LevelOneDepartment.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    LevelOneDepartment result = new LevelOneDepartment();
    result.setBelongsTo(mapper.tryToGet(LevelOneDepartment.class, BELONGS_TO_PROPERTY, RetailStoreCountryCenter.class,
        0, true, result.getBelongsTo(), params));
    result.setName(mapper.tryToGet(LevelOneDepartment.class, NAME_PROPERTY, String.class,
        0, false, result.getName(), params));
    result.setDescription(mapper.tryToGet(LevelOneDepartment.class, DESCRIPTION_PROPERTY, String.class,
        1, false, result.getDescription(), params));
    result.setManager(mapper.tryToGet(LevelOneDepartment.class, MANAGER_PROPERTY, String.class,
        2, false, result.getManager(), params));
    result.setFounded(mapper.tryToGet(LevelOneDepartment.class, FOUNDED_PROPERTY, Date.class,
        0, true, result.getFounded(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixLevelOneDepartment(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      LevelOneDepartmentTokens tokens = mapper.findParamByClass(params, LevelOneDepartmentTokens.class);
      if (tokens == null) {
        tokens = LevelOneDepartmentTokens.start();
      }
      result = userContext.getManagerGroup().getLevelOneDepartmentManager().internalSaveLevelOneDepartment(userContext, result, tokens.done());
      
    }
    return result;
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

