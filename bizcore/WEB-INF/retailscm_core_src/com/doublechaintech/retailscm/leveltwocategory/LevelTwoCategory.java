
package com.doublechaintech.retailscm.leveltwocategory;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
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


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(PARENT_CATEGORY_PROPERTY, "level_one_category", "父类")
        .withType("level_one_category", LevelOneCategory.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(LEVEL_THREE_CATEGORY_LIST, "parentCategory", "三级类别表")
        .withType("level_three_category", LevelThreeCategory.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,PARENT_CATEGORY_PROPERTY ,NAME_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(LEVEL_THREE_CATEGORY_LIST, "parentCategory");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(LEVEL_THREE_CATEGORY_LIST, LevelThreeCategory.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(PARENT_CATEGORY_PROPERTY, LevelOneCategory.class);

    return parents;
  }

  public LevelTwoCategory want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public LevelTwoCategory wants(Class<? extends BaseEntity>... classes) {
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
	protected		LevelOneCategory    	parentCategory      ;
	protected		String              	name                ;
	protected		int                 	version             ;

	
	protected		SmartList<LevelThreeCategory>	mLevelThreeCategoryList;



	public 	LevelTwoCategory(){
		// lazy load for all the properties
	}
	public 	static LevelTwoCategory withId(String id){
		LevelTwoCategory levelTwoCategory = new LevelTwoCategory();
		levelTwoCategory.setId(id);
		levelTwoCategory.setVersion(Integer.MAX_VALUE);
		levelTwoCategory.setChecked(true);
		return levelTwoCategory;
	}
	public 	static LevelTwoCategory refById(String id){
		return withId(id);
	}

  public LevelTwoCategory limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public LevelTwoCategory limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static LevelTwoCategory searchExample(){
    LevelTwoCategory levelTwoCategory = new LevelTwoCategory();
    		levelTwoCategory.setVersion(UNSET_INT);

    return levelTwoCategory;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setParentCategory( null );

		this.changed = true;
		setChecked(false);
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

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public LevelTwoCategory updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public LevelTwoCategory orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public LevelTwoCategory ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public LevelTwoCategory addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setParentCategory(LevelOneCategory parentCategory){LevelOneCategory oldParentCategory = this.parentCategory;LevelOneCategory newParentCategory = parentCategory;this.parentCategory = newParentCategory;}
	public LevelOneCategory parentCategory(){
doLoad();
return getParentCategory();
}
	public LevelOneCategory getParentCategory(){
		return this.parentCategory;
	}
	public LevelTwoCategory updateParentCategory(LevelOneCategory parentCategory){LevelOneCategory oldParentCategory = this.parentCategory;LevelOneCategory newParentCategory = parentCategory;if(!shouldReplaceBy(newParentCategory, oldParentCategory)){return this;}this.parentCategory = newParentCategory;addPropertyChange(PARENT_CATEGORY_PROPERTY, oldParentCategory, newParentCategory);this.changed = true;setChecked(false);return this;}
	public LevelTwoCategory orderByParentCategory(boolean asc){
doAddOrderBy(PARENT_CATEGORY_PROPERTY, asc);
return this;
}
	public SearchCriteria createParentCategoryCriteria(QueryOperator operator, Object... parameters){
return createCriteria(PARENT_CATEGORY_PROPERTY, operator, parameters);
}
	public LevelTwoCategory ignoreParentCategoryCriteria(){super.ignoreSearchProperty(PARENT_CATEGORY_PROPERTY);
return this;
}
	public LevelTwoCategory addParentCategoryCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createParentCategoryCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeParentCategory(LevelOneCategory parentCategory){
		if(parentCategory != null) { setParentCategory(parentCategory);}
	}

	
	public void clearParentCategory(){
		setParentCategory ( null );
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
	public LevelTwoCategory updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public LevelTwoCategory orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public LevelTwoCategory ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public LevelTwoCategory addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public LevelTwoCategory updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public LevelTwoCategory orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public LevelTwoCategory ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public LevelTwoCategory addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
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

  public  SmartList<LevelThreeCategory> levelThreeCategoryList(){
    
    doLoadChild(LEVEL_THREE_CATEGORY_LIST);
    
    return getLevelThreeCategoryList();
  }


	public  void setLevelThreeCategoryList(SmartList<LevelThreeCategory> levelThreeCategoryList){
		for( LevelThreeCategory levelThreeCategory:levelThreeCategoryList){
			levelThreeCategory.setParentCategory(this);
		}

		this.mLevelThreeCategoryList = levelThreeCategoryList;
		this.mLevelThreeCategoryList.setListInternalName (LEVEL_THREE_CATEGORY_LIST );

	}

	public  LevelTwoCategory addLevelThreeCategory(LevelThreeCategory levelThreeCategory){
		levelThreeCategory.setParentCategory(this);
		getLevelThreeCategoryList().add(levelThreeCategory);
		return this;
	}
	public  LevelTwoCategory addLevelThreeCategoryList(SmartList<LevelThreeCategory> levelThreeCategoryList){
		for( LevelThreeCategory levelThreeCategory:levelThreeCategoryList){
			levelThreeCategory.setParentCategory(this);
		}
		getLevelThreeCategoryList().addAll(levelThreeCategoryList);
		return this;
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


	public static LevelTwoCategory createWith(RetailscmUserContext userContext, ThrowingFunction<LevelTwoCategory,LevelTwoCategory,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<LevelTwoCategory> customCreator = mapper.findCustomCreator(LevelTwoCategory.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    LevelTwoCategory result = new LevelTwoCategory();
    result.setParentCategory(mapper.tryToGet(LevelTwoCategory.class, PARENT_CATEGORY_PROPERTY, LevelOneCategory.class,
        0, true, result.getParentCategory(), params));
    result.setName(mapper.tryToGet(LevelTwoCategory.class, NAME_PROPERTY, String.class,
        0, true, result.getName(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixLevelTwoCategory(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      LevelTwoCategoryTokens tokens = mapper.findParamByClass(params, LevelTwoCategoryTokens.class);
      if (tokens == null) {
        tokens = LevelTwoCategoryTokens.start();
      }
      result = userContext.getManagerGroup().getLevelTwoCategoryManager().internalSaveLevelTwoCategory(userContext, result, tokens.done());
      
    }
    return result;
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

