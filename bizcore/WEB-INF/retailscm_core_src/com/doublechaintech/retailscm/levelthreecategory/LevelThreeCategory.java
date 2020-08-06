
package com.doublechaintech.retailscm.levelthreecategory;

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
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		LevelTwoCategory    	mParentCategory     ;
	protected		String              	mName               ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Product>  	mProductList        ;

	
		
	public 	LevelThreeCategory(){
		// lazy load for all the properties
	}
	public 	static LevelThreeCategory withId(String id){
		LevelThreeCategory levelThreeCategory = new LevelThreeCategory();
		levelThreeCategory.setId(id);
		levelThreeCategory.setVersion(Integer.MAX_VALUE);
		return levelThreeCategory;
	}
	public 	static LevelThreeCategory refById(String id){
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
    
    


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public LevelThreeCategory updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setParentCategory(LevelTwoCategory parentCategory){
		this.mParentCategory = parentCategory;;
	}
	public LevelTwoCategory getParentCategory(){
		return this.mParentCategory;
	}
	public LevelThreeCategory updateParentCategory(LevelTwoCategory parentCategory){
		this.mParentCategory = parentCategory;;
		this.changed = true;
		return this;
	}
	public void mergeParentCategory(LevelTwoCategory parentCategory){
		if(parentCategory != null) { setParentCategory(parentCategory);}
	}
	
	
	public void clearParentCategory(){
		setParentCategory ( null );
		this.changed = true;
	}
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public LevelThreeCategory updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public LevelThreeCategory updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
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
	public  void setProductList(SmartList<Product> productList){
		for( Product product:productList){
			product.setParentCategory(this);
		}

		this.mProductList = productList;
		this.mProductList.setListInternalName (PRODUCT_LIST );
		
	}
	
	public  void addProduct(Product product){
		product.setParentCategory(this);
		getProductList().add(product);
	}
	public  void addProductList(SmartList<Product> productList){
		for( Product product:productList){
			product.setParentCategory(this);
		}
		getProductList().addAll(productList);
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

