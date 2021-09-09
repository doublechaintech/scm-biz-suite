
package com.doublechaintech.retailscm.levelthreecategory;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory;
import com.doublechaintech.retailscm.product.Product;









@JsonSerialize(using = LevelThreeCategorySerializer.class)
public class LevelThreeCategory extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String PARENT_CATEGORY_PROPERTY       = "parentCategory"    ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String PRODUCT_LIST                             = "productList"       ;

	public static final String INTERNAL_TYPE="LevelThreeCategory";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(PARENT_CATEGORY_PROPERTY, "level_two_category", "父类")
        .withType("level_two_category", LevelTwoCategory.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(PRODUCT_LIST, "parentCategory", "产品列表")
        .withType("product", Product.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,PARENT_CATEGORY_PROPERTY ,NAME_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(PRODUCT_LIST, "parentCategory");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(PRODUCT_LIST, Product.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(PARENT_CATEGORY_PROPERTY, LevelTwoCategory.class);

    return parents;
  }

  public LevelThreeCategory want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public LevelThreeCategory wants(Class<? extends BaseEntity>... classes) {
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
	protected		LevelTwoCategory    	parentCategory      ;
	protected		String              	name                ;
	protected		int                 	version             ;

	
	protected		SmartList<Product>  	mProductList        ;



	public 	LevelThreeCategory(){
		// lazy load for all the properties
	}
	public 	static LevelThreeCategory withId(String id){
		LevelThreeCategory levelThreeCategory = new LevelThreeCategory();
		levelThreeCategory.setId(id);
		levelThreeCategory.setVersion(Integer.MAX_VALUE);
		levelThreeCategory.setChecked(true);
		return levelThreeCategory;
	}
	public 	static LevelThreeCategory refById(String id){
		return withId(id);
	}

  public LevelThreeCategory limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public LevelThreeCategory limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static LevelThreeCategory searchExample(){
    LevelThreeCategory levelThreeCategory = new LevelThreeCategory();
    		levelThreeCategory.setVersion(UNSET_INT);

    return levelThreeCategory;
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
		if(PRODUCT_LIST.equals(property)){
			List<BaseEntity> list = getProductList().stream().map(item->item).collect(Collectors.toList());
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
	public LevelThreeCategory updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public LevelThreeCategory orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public LevelThreeCategory ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public LevelThreeCategory addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setParentCategory(LevelTwoCategory parentCategory){LevelTwoCategory oldParentCategory = this.parentCategory;LevelTwoCategory newParentCategory = parentCategory;this.parentCategory = newParentCategory;}
	public LevelTwoCategory parentCategory(){
doLoad();
return getParentCategory();
}
	public LevelTwoCategory getParentCategory(){
		return this.parentCategory;
	}
	public LevelThreeCategory updateParentCategory(LevelTwoCategory parentCategory){LevelTwoCategory oldParentCategory = this.parentCategory;LevelTwoCategory newParentCategory = parentCategory;if(!shouldReplaceBy(newParentCategory, oldParentCategory)){return this;}this.parentCategory = newParentCategory;addPropertyChange(PARENT_CATEGORY_PROPERTY, oldParentCategory, newParentCategory);this.changed = true;setChecked(false);return this;}
	public LevelThreeCategory orderByParentCategory(boolean asc){
doAddOrderBy(PARENT_CATEGORY_PROPERTY, asc);
return this;
}
	public SearchCriteria createParentCategoryCriteria(QueryOperator operator, Object... parameters){
return createCriteria(PARENT_CATEGORY_PROPERTY, operator, parameters);
}
	public LevelThreeCategory ignoreParentCategoryCriteria(){super.ignoreSearchProperty(PARENT_CATEGORY_PROPERTY);
return this;
}
	public LevelThreeCategory addParentCategoryCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createParentCategoryCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeParentCategory(LevelTwoCategory parentCategory){
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
	public LevelThreeCategory updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public LevelThreeCategory orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public LevelThreeCategory ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public LevelThreeCategory addNameCriteria(QueryOperator operator, Object... parameters){
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
	public LevelThreeCategory updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public LevelThreeCategory orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public LevelThreeCategory ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public LevelThreeCategory addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public  SmartList<Product> getProductList(){
		if(this.mProductList == null){
			this.mProductList = new SmartList<Product>();
			this.mProductList.setListInternalName (PRODUCT_LIST );
			//有名字，便于做权限控制
		}

		return this.mProductList;
	}

  public  SmartList<Product> productList(){
    
    doLoadChild(PRODUCT_LIST);
    
    return getProductList();
  }


	public  void setProductList(SmartList<Product> productList){
		for( Product product:productList){
			product.setParentCategory(this);
		}

		this.mProductList = productList;
		this.mProductList.setListInternalName (PRODUCT_LIST );

	}

	public  LevelThreeCategory addProduct(Product product){
		product.setParentCategory(this);
		getProductList().add(product);
		return this;
	}
	public  LevelThreeCategory addProductList(SmartList<Product> productList){
		for( Product product:productList){
			product.setParentCategory(this);
		}
		getProductList().addAll(productList);
		return this;
	}
	public  void mergeProductList(SmartList<Product> productList){
		if(productList==null){
			return;
		}
		if(productList.isEmpty()){
			return;
		}
		addProductList( productList );

	}
	public  Product removeProduct(Product productIndex){

		int index = getProductList().indexOf(productIndex);
        if(index < 0){
        	String message = "Product("+productIndex.getId()+") with version='"+productIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Product product = getProductList().get(index);
        // product.clearParentCategory(); //disconnect with ParentCategory
        product.clearFromAll(); //disconnect with ParentCategory

		boolean result = getProductList().planToRemove(product);
        if(!result){
        	String message = "Product("+productIndex.getId()+") with version='"+productIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return product;


	}
	//断舍离
	public  void breakWithProduct(Product product){

		if(product == null){
			return;
		}
		product.setParentCategory(null);
		//getProductList().remove();

	}

	public  boolean hasProduct(Product product){

		return getProductList().contains(product);

	}

	public void copyProductFrom(Product product) {

		Product productInList = findTheProduct(product);
		Product newProduct = new Product();
		productInList.copyTo(newProduct);
		newProduct.setVersion(0);//will trigger copy
		getProductList().add(newProduct);
		addItemToFlexiableObject(COPIED_CHILD, newProduct);
	}

	public  Product findTheProduct(Product product){

		int index =  getProductList().indexOf(product);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Product("+product.getId()+") with version='"+product.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpProductList(){
		getProductList().clear();
	}





	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getParentCategory(), internalType);


	}

	public List<BaseEntity>  collectRefercencesFromLists(String internalType){

		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getProductList(), internalType);

		return entityList;
	}

	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

		listOfList.add( getProductList());


		return listOfList;
	}


	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, PARENT_CATEGORY_PROPERTY, getParentCategory());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, PRODUCT_LIST, getProductList());
		if(!getProductList().isEmpty()){
			appendKeyValuePair(result, "productCount", getProductList().getTotalCount());
			appendKeyValuePair(result, "productCurrentPageNumber", getProductList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof LevelThreeCategory){


			LevelThreeCategory dest =(LevelThreeCategory)baseDest;

			dest.setId(getId());
			dest.setParentCategory(getParentCategory());
			dest.setName(getName());
			dest.setVersion(getVersion());
			dest.setProductList(getProductList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof LevelThreeCategory){


			LevelThreeCategory dest =(LevelThreeCategory)baseDest;

			dest.mergeId(getId());
			dest.mergeParentCategory(getParentCategory());
			dest.mergeName(getName());
			dest.mergeVersion(getVersion());
			dest.mergeProductList(getProductList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof LevelThreeCategory){


			LevelThreeCategory dest =(LevelThreeCategory)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getParentCategory(), getName(), getVersion()};
	}


	public static LevelThreeCategory createWith(RetailscmUserContext userContext, ThrowingFunction<LevelThreeCategory,LevelThreeCategory,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<LevelThreeCategory> customCreator = mapper.findCustomCreator(LevelThreeCategory.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    LevelThreeCategory result = new LevelThreeCategory();
    result.setParentCategory(mapper.tryToGet(LevelThreeCategory.class, PARENT_CATEGORY_PROPERTY, LevelTwoCategory.class,
        0, true, result.getParentCategory(), params));
    result.setName(mapper.tryToGet(LevelThreeCategory.class, NAME_PROPERTY, String.class,
        0, true, result.getName(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixLevelThreeCategory(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      LevelThreeCategoryTokens tokens = mapper.findParamByClass(params, LevelThreeCategoryTokens.class);
      if (tokens == null) {
        tokens = LevelThreeCategoryTokens.start();
      }
      result = userContext.getManagerGroup().getLevelThreeCategoryManager().internalSaveLevelThreeCategory(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("LevelThreeCategory{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getParentCategory() != null ){
 			stringBuilder.append("\tparentCategory='LevelTwoCategory("+getParentCategory().getId()+")';");
 		}
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

