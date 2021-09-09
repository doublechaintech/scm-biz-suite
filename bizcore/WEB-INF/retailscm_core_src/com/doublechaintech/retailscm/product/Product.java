
package com.doublechaintech.retailscm.product;

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
import com.doublechaintech.retailscm.sku.Sku;









@JsonSerialize(using = ProductSerializer.class)
public class Product extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String PARENT_CATEGORY_PROPERTY       = "parentCategory"    ;
	public static final String ORIGIN_PROPERTY                = "origin"            ;
	public static final String REMARK_PROPERTY                = "remark"            ;
	public static final String BRAND_PROPERTY                 = "brand"             ;
	public static final String PICTURE_PROPERTY               = "picture"           ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String SKU_LIST                                 = "skuList"           ;

	public static final String INTERNAL_TYPE="Product";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(PARENT_CATEGORY_PROPERTY, "level_three_category", "父类")
        .withType("level_three_category", LevelThreeCategory.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ORIGIN_PROPERTY, "origin", "产地")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(REMARK_PROPERTY, "remark", "备注")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(BRAND_PROPERTY, "brand", "品牌")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(PICTURE_PROPERTY, "picture", "图片")
        .withType("string_image", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
        .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(SKU_LIST, "product", "Sku列表")
        .withType("sku", Sku.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,PARENT_CATEGORY_PROPERTY ,ORIGIN_PROPERTY ,REMARK_PROPERTY ,BRAND_PROPERTY ,PICTURE_PROPERTY ,LAST_UPDATE_TIME_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(SKU_LIST, "product");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(SKU_LIST, Sku.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(PARENT_CATEGORY_PROPERTY, LevelThreeCategory.class);

    return parents;
  }

  public Product want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public Product wants(Class<? extends BaseEntity>... classes) {
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
	protected		String              	name                ;
	protected		LevelThreeCategory  	parentCategory      ;
	protected		String              	origin              ;
	protected		String              	remark              ;
	protected		String              	brand               ;
	protected		String              	picture             ;
	protected		DateTime            	lastUpdateTime      ;
	protected		int                 	version             ;

	
	protected		SmartList<Sku>      	mSkuList            ;



	public 	Product(){
		// lazy load for all the properties
	}
	public 	static Product withId(String id){
		Product product = new Product();
		product.setId(id);
		product.setVersion(Integer.MAX_VALUE);
		product.setChecked(true);
		return product;
	}
	public 	static Product refById(String id){
		return withId(id);
	}

  public Product limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public Product limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static Product searchExample(){
    Product product = new Product();
    		product.setVersion(UNSET_INT);

    return product;
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
		if(ORIGIN_PROPERTY.equals(property)){
			changeOriginProperty(newValueExpr);
		}
		if(REMARK_PROPERTY.equals(property)){
			changeRemarkProperty(newValueExpr);
		}
		if(BRAND_PROPERTY.equals(property)){
			changeBrandProperty(newValueExpr);
		}
		if(PICTURE_PROPERTY.equals(property)){
			changePictureProperty(newValueExpr);
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			changeLastUpdateTimeProperty(newValueExpr);
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
			
			
			
	protected void changeOriginProperty(String newValueExpr){
	
		String oldValue = getOrigin();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateOrigin(newValue);
		this.onChangeProperty(ORIGIN_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeRemarkProperty(String newValueExpr){
	
		String oldValue = getRemark();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateRemark(newValue);
		this.onChangeProperty(REMARK_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeBrandProperty(String newValueExpr){
	
		String oldValue = getBrand();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateBrand(newValue);
		this.onChangeProperty(BRAND_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changePictureProperty(String newValueExpr){
	
		String oldValue = getPicture();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePicture(newValue);
		this.onChangeProperty(PICTURE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeLastUpdateTimeProperty(String newValueExpr){
	
		DateTime oldValue = getLastUpdateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLastUpdateTime(newValue);
		this.onChangeProperty(LAST_UPDATE_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {

		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(PARENT_CATEGORY_PROPERTY.equals(property)){
			return getParentCategory();
		}
		if(ORIGIN_PROPERTY.equals(property)){
			return getOrigin();
		}
		if(REMARK_PROPERTY.equals(property)){
			return getRemark();
		}
		if(BRAND_PROPERTY.equals(property)){
			return getBrand();
		}
		if(PICTURE_PROPERTY.equals(property)){
			return getPicture();
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			return getLastUpdateTime();
		}
		if(SKU_LIST.equals(property)){
			List<BaseEntity> list = getSkuList().stream().map(item->item).collect(Collectors.toList());
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
	public Product updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public Product orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public Product ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public Product addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setName(String name){String oldName = this.name;String newName = trimString(name);this.name = newName;}
	public String name(){
doLoad();
return getName();
}
	public String getName(){
		return this.name;
	}
	public Product updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public Product orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public Product ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public Product addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setParentCategory(LevelThreeCategory parentCategory){LevelThreeCategory oldParentCategory = this.parentCategory;LevelThreeCategory newParentCategory = parentCategory;this.parentCategory = newParentCategory;}
	public LevelThreeCategory parentCategory(){
doLoad();
return getParentCategory();
}
	public LevelThreeCategory getParentCategory(){
		return this.parentCategory;
	}
	public Product updateParentCategory(LevelThreeCategory parentCategory){LevelThreeCategory oldParentCategory = this.parentCategory;LevelThreeCategory newParentCategory = parentCategory;if(!shouldReplaceBy(newParentCategory, oldParentCategory)){return this;}this.parentCategory = newParentCategory;addPropertyChange(PARENT_CATEGORY_PROPERTY, oldParentCategory, newParentCategory);this.changed = true;setChecked(false);return this;}
	public Product orderByParentCategory(boolean asc){
doAddOrderBy(PARENT_CATEGORY_PROPERTY, asc);
return this;
}
	public SearchCriteria createParentCategoryCriteria(QueryOperator operator, Object... parameters){
return createCriteria(PARENT_CATEGORY_PROPERTY, operator, parameters);
}
	public Product ignoreParentCategoryCriteria(){super.ignoreSearchProperty(PARENT_CATEGORY_PROPERTY);
return this;
}
	public Product addParentCategoryCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createParentCategoryCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeParentCategory(LevelThreeCategory parentCategory){
		if(parentCategory != null) { setParentCategory(parentCategory);}
	}

	
	public void clearParentCategory(){
		setParentCategory ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setOrigin(String origin){String oldOrigin = this.origin;String newOrigin = trimString(origin);this.origin = newOrigin;}
	public String origin(){
doLoad();
return getOrigin();
}
	public String getOrigin(){
		return this.origin;
	}
	public Product updateOrigin(String origin){String oldOrigin = this.origin;String newOrigin = trimString(origin);if(!shouldReplaceBy(newOrigin, oldOrigin)){return this;}this.origin = newOrigin;addPropertyChange(ORIGIN_PROPERTY, oldOrigin, newOrigin);this.changed = true;setChecked(false);return this;}
	public Product orderByOrigin(boolean asc){
doAddOrderBy(ORIGIN_PROPERTY, asc);
return this;
}
	public SearchCriteria createOriginCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ORIGIN_PROPERTY, operator, parameters);
}
	public Product ignoreOriginCriteria(){super.ignoreSearchProperty(ORIGIN_PROPERTY);
return this;
}
	public Product addOriginCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createOriginCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeOrigin(String origin){
		if(origin != null) { setOrigin(origin);}
	}

	
	public void setRemark(String remark){String oldRemark = this.remark;String newRemark = trimString(remark);this.remark = newRemark;}
	public String remark(){
doLoad();
return getRemark();
}
	public String getRemark(){
		return this.remark;
	}
	public Product updateRemark(String remark){String oldRemark = this.remark;String newRemark = trimString(remark);if(!shouldReplaceBy(newRemark, oldRemark)){return this;}this.remark = newRemark;addPropertyChange(REMARK_PROPERTY, oldRemark, newRemark);this.changed = true;setChecked(false);return this;}
	public Product orderByRemark(boolean asc){
doAddOrderBy(REMARK_PROPERTY, asc);
return this;
}
	public SearchCriteria createRemarkCriteria(QueryOperator operator, Object... parameters){
return createCriteria(REMARK_PROPERTY, operator, parameters);
}
	public Product ignoreRemarkCriteria(){super.ignoreSearchProperty(REMARK_PROPERTY);
return this;
}
	public Product addRemarkCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createRemarkCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeRemark(String remark){
		if(remark != null) { setRemark(remark);}
	}

	
	public void setBrand(String brand){String oldBrand = this.brand;String newBrand = trimString(brand);this.brand = newBrand;}
	public String brand(){
doLoad();
return getBrand();
}
	public String getBrand(){
		return this.brand;
	}
	public Product updateBrand(String brand){String oldBrand = this.brand;String newBrand = trimString(brand);if(!shouldReplaceBy(newBrand, oldBrand)){return this;}this.brand = newBrand;addPropertyChange(BRAND_PROPERTY, oldBrand, newBrand);this.changed = true;setChecked(false);return this;}
	public Product orderByBrand(boolean asc){
doAddOrderBy(BRAND_PROPERTY, asc);
return this;
}
	public SearchCriteria createBrandCriteria(QueryOperator operator, Object... parameters){
return createCriteria(BRAND_PROPERTY, operator, parameters);
}
	public Product ignoreBrandCriteria(){super.ignoreSearchProperty(BRAND_PROPERTY);
return this;
}
	public Product addBrandCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createBrandCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeBrand(String brand){
		if(brand != null) { setBrand(brand);}
	}

	
	public void setPicture(String picture){String oldPicture = this.picture;String newPicture = trimString(encodeUrl(picture));;this.picture = newPicture;}
	public String picture(){
doLoad();
return getPicture();
}
	public String getPicture(){
		return this.picture;
	}
	public Product updatePicture(String picture){String oldPicture = this.picture;String newPicture = trimString(encodeUrl(picture));;if(!shouldReplaceBy(newPicture, oldPicture)){return this;}this.picture = newPicture;addPropertyChange(PICTURE_PROPERTY, oldPicture, newPicture);this.changed = true;setChecked(false);return this;}
	public Product orderByPicture(boolean asc){
doAddOrderBy(PICTURE_PROPERTY, asc);
return this;
}
	public SearchCriteria createPictureCriteria(QueryOperator operator, Object... parameters){
return createCriteria(PICTURE_PROPERTY, operator, parameters);
}
	public Product ignorePictureCriteria(){super.ignoreSearchProperty(PICTURE_PROPERTY);
return this;
}
	public Product addPictureCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createPictureCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergePicture(String picture){
		if(picture != null) { setPicture(picture);}
	}

	
	public void setLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;this.lastUpdateTime = newLastUpdateTime;}
	public DateTime lastUpdateTime(){
doLoad();
return getLastUpdateTime();
}
	public DateTime getLastUpdateTime(){
		return this.lastUpdateTime;
	}
	public Product updateLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;if(!shouldReplaceBy(newLastUpdateTime, oldLastUpdateTime)){return this;}this.lastUpdateTime = newLastUpdateTime;addPropertyChange(LAST_UPDATE_TIME_PROPERTY, oldLastUpdateTime, newLastUpdateTime);this.changed = true;setChecked(false);return this;}
	public Product orderByLastUpdateTime(boolean asc){
doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
}
	public Product ignoreLastUpdateTimeCriteria(){super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
return this;
}
	public Product addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createLastUpdateTimeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeLastUpdateTime(DateTime lastUpdateTime){
		setLastUpdateTime(lastUpdateTime);
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public Product updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public Product orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public Product ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public Product addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public  SmartList<Sku> getSkuList(){
		if(this.mSkuList == null){
			this.mSkuList = new SmartList<Sku>();
			this.mSkuList.setListInternalName (SKU_LIST );
			//有名字，便于做权限控制
		}

		return this.mSkuList;
	}

  public  SmartList<Sku> skuList(){
    
    doLoadChild(SKU_LIST);
    
    return getSkuList();
  }


	public  void setSkuList(SmartList<Sku> skuList){
		for( Sku sku:skuList){
			sku.setProduct(this);
		}

		this.mSkuList = skuList;
		this.mSkuList.setListInternalName (SKU_LIST );

	}

	public  Product addSku(Sku sku){
		sku.setProduct(this);
		getSkuList().add(sku);
		return this;
	}
	public  Product addSkuList(SmartList<Sku> skuList){
		for( Sku sku:skuList){
			sku.setProduct(this);
		}
		getSkuList().addAll(skuList);
		return this;
	}
	public  void mergeSkuList(SmartList<Sku> skuList){
		if(skuList==null){
			return;
		}
		if(skuList.isEmpty()){
			return;
		}
		addSkuList( skuList );

	}
	public  Sku removeSku(Sku skuIndex){

		int index = getSkuList().indexOf(skuIndex);
        if(index < 0){
        	String message = "Sku("+skuIndex.getId()+") with version='"+skuIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Sku sku = getSkuList().get(index);
        // sku.clearProduct(); //disconnect with Product
        sku.clearFromAll(); //disconnect with Product

		boolean result = getSkuList().planToRemove(sku);
        if(!result){
        	String message = "Sku("+skuIndex.getId()+") with version='"+skuIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return sku;


	}
	//断舍离
	public  void breakWithSku(Sku sku){

		if(sku == null){
			return;
		}
		sku.setProduct(null);
		//getSkuList().remove();

	}

	public  boolean hasSku(Sku sku){

		return getSkuList().contains(sku);

	}

	public void copySkuFrom(Sku sku) {

		Sku skuInList = findTheSku(sku);
		Sku newSku = new Sku();
		skuInList.copyTo(newSku);
		newSku.setVersion(0);//will trigger copy
		getSkuList().add(newSku);
		addItemToFlexiableObject(COPIED_CHILD, newSku);
	}

	public  Sku findTheSku(Sku sku){

		int index =  getSkuList().indexOf(sku);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Sku("+sku.getId()+") with version='"+sku.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getSkuList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpSkuList(){
		getSkuList().clear();
	}





	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getParentCategory(), internalType);


	}

	public List<BaseEntity>  collectRefercencesFromLists(String internalType){

		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getSkuList(), internalType);

		return entityList;
	}

	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

		listOfList.add( getSkuList());


		return listOfList;
	}


	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, PARENT_CATEGORY_PROPERTY, getParentCategory());
		appendKeyValuePair(result, ORIGIN_PROPERTY, getOrigin());
		appendKeyValuePair(result, REMARK_PROPERTY, getRemark());
		appendKeyValuePair(result, BRAND_PROPERTY, getBrand());
		appendKeyValuePair(result, PICTURE_PROPERTY, getPicture());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, SKU_LIST, getSkuList());
		if(!getSkuList().isEmpty()){
			appendKeyValuePair(result, "skuCount", getSkuList().getTotalCount());
			appendKeyValuePair(result, "skuCurrentPageNumber", getSkuList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof Product){


			Product dest =(Product)baseDest;

			dest.setId(getId());
			dest.setName(getName());
			dest.setParentCategory(getParentCategory());
			dest.setOrigin(getOrigin());
			dest.setRemark(getRemark());
			dest.setBrand(getBrand());
			dest.setPicture(getPicture());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setSkuList(getSkuList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof Product){


			Product dest =(Product)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeParentCategory(getParentCategory());
			dest.mergeOrigin(getOrigin());
			dest.mergeRemark(getRemark());
			dest.mergeBrand(getBrand());
			dest.mergePicture(getPicture());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());
			dest.mergeSkuList(getSkuList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof Product){


			Product dest =(Product)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeOrigin(getOrigin());
			dest.mergeRemark(getRemark());
			dest.mergeBrand(getBrand());
			dest.mergePicture(getPicture());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getParentCategory(), getOrigin(), getRemark(), getBrand(), getPicture(), getLastUpdateTime(), getVersion()};
	}


	public static Product createWith(RetailscmUserContext userContext, ThrowingFunction<Product,Product,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<Product> customCreator = mapper.findCustomCreator(Product.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    Product result = new Product();
    result.setName(mapper.tryToGet(Product.class, NAME_PROPERTY, String.class,
        0, false, result.getName(), params));
    result.setParentCategory(mapper.tryToGet(Product.class, PARENT_CATEGORY_PROPERTY, LevelThreeCategory.class,
        0, true, result.getParentCategory(), params));
    result.setOrigin(mapper.tryToGet(Product.class, ORIGIN_PROPERTY, String.class,
        1, false, result.getOrigin(), params));
    result.setRemark(mapper.tryToGet(Product.class, REMARK_PROPERTY, String.class,
        2, false, result.getRemark(), params));
    result.setBrand(mapper.tryToGet(Product.class, BRAND_PROPERTY, String.class,
        3, false, result.getBrand(), params));
    result.setPicture(mapper.tryToGet(Product.class, PICTURE_PROPERTY, String.class,
        4, false, result.getPicture(), params));
     result.setLastUpdateTime(userContext.now());

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixProduct(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      ProductTokens tokens = mapper.findParamByClass(params, ProductTokens.class);
      if (tokens == null) {
        tokens = ProductTokens.start();
      }
      result = userContext.getManagerGroup().getProductManager().internalSaveProduct(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Product{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getParentCategory() != null ){
 			stringBuilder.append("\tparentCategory='LevelThreeCategory("+getParentCategory().getId()+")';");
 		}
		stringBuilder.append("\torigin='"+getOrigin()+"';");
		stringBuilder.append("\tremark='"+getRemark()+"';");
		stringBuilder.append("\tbrand='"+getBrand()+"';");
		stringBuilder.append("\tpicture='"+getPicture()+"';");
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

