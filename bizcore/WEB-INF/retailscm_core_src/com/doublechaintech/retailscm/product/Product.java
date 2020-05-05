
package com.doublechaintech.retailscm.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
	protected		LevelThreeCategory  	mParentCategory     ;
	protected		String              	mOrigin             ;
	protected		String              	mRemark             ;
	protected		String              	mBrand              ;
	protected		String              	mPicture            ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Sku>      	mSkuList            ;

	
		
	public 	Product(){
		// lazy load for all the properties
	}
	public 	static Product withId(String id){
		Product product = new Product();
		product.setId(id);
		product.setVersion(Integer.MAX_VALUE);
		return product;
	}
	public 	static Product refById(String id){
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
    
    


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Product updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public Product updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setParentCategory(LevelThreeCategory parentCategory){
		this.mParentCategory = parentCategory;;
	}
	public LevelThreeCategory getParentCategory(){
		return this.mParentCategory;
	}
	public Product updateParentCategory(LevelThreeCategory parentCategory){
		this.mParentCategory = parentCategory;;
		this.changed = true;
		return this;
	}
	public void mergeParentCategory(LevelThreeCategory parentCategory){
		if(parentCategory != null) { setParentCategory(parentCategory);}
	}
	
	
	public void clearParentCategory(){
		setParentCategory ( null );
		this.changed = true;
	}
	
	public void setOrigin(String origin){
		this.mOrigin = trimString(origin);;
	}
	public String getOrigin(){
		return this.mOrigin;
	}
	public Product updateOrigin(String origin){
		this.mOrigin = trimString(origin);;
		this.changed = true;
		return this;
	}
	public void mergeOrigin(String origin){
		if(origin != null) { setOrigin(origin);}
	}
	
	
	public void setRemark(String remark){
		this.mRemark = trimString(remark);;
	}
	public String getRemark(){
		return this.mRemark;
	}
	public Product updateRemark(String remark){
		this.mRemark = trimString(remark);;
		this.changed = true;
		return this;
	}
	public void mergeRemark(String remark){
		if(remark != null) { setRemark(remark);}
	}
	
	
	public void setBrand(String brand){
		this.mBrand = trimString(brand);;
	}
	public String getBrand(){
		return this.mBrand;
	}
	public Product updateBrand(String brand){
		this.mBrand = trimString(brand);;
		this.changed = true;
		return this;
	}
	public void mergeBrand(String brand){
		if(brand != null) { setBrand(brand);}
	}
	
	
	public void setPicture(String picture){
		this.mPicture = trimString(encodeUrl(picture));;
	}
	public String getPicture(){
		return this.mPicture;
	}
	public Product updatePicture(String picture){
		this.mPicture = trimString(encodeUrl(picture));;
		this.changed = true;
		return this;
	}
	public void mergePicture(String picture){
		if(picture != null) { setPicture(picture);}
	}
	
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public Product updateLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
		this.changed = true;
		return this;
	}
	public void mergeLastUpdateTime(DateTime lastUpdateTime){
		setLastUpdateTime(lastUpdateTime);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Product updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
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
	public  void setSkuList(SmartList<Sku> skuList){
		for( Sku sku:skuList){
			sku.setProduct(this);
		}

		this.mSkuList = skuList;
		this.mSkuList.setListInternalName (SKU_LIST );
		
	}
	
	public  void addSku(Sku sku){
		sku.setProduct(this);
		getSkuList().add(sku);
	}
	public  void addSkuList(SmartList<Sku> skuList){
		for( Sku sku:skuList){
			sku.setProduct(this);
		}
		getSkuList().addAll(skuList);
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

