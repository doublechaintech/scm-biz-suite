
package com.doublechaintech.retailscm.supplierproduct;

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
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.productsupplyduration.ProductSupplyDuration;

@JsonSerialize(using = SupplierProductSerializer.class)
public class SupplierProduct extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String PRODUCT_NAME_PROPERTY          = "productName"       ;
	public static final String PRODUCT_DESCRIPTION_PROPERTY   = "productDescription";
	public static final String PRODUCT_UNIT_PROPERTY          = "productUnit"       ;
	public static final String SUPPLIER_PROPERTY              = "supplier"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String PRODUCT_SUPPLY_DURATION_LIST             = "productSupplyDurationList";

	public static final String INTERNAL_TYPE="SupplierProduct";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getProductName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mProductName        ;
	protected		String              	mProductDescription ;
	protected		String              	mProductUnit        ;
	protected		GoodsSupplier       	mSupplier           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ProductSupplyDuration>	mProductSupplyDurationList;

	
		
	public 	SupplierProduct(){
		// lazy load for all the properties
	}
	public 	static SupplierProduct withId(String id){
		SupplierProduct supplierProduct = new SupplierProduct();
		supplierProduct.setId(id);
		supplierProduct.setVersion(Integer.MAX_VALUE);
		return supplierProduct;
	}
	public 	static SupplierProduct refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setSupplier( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(PRODUCT_NAME_PROPERTY.equals(property)){
			changeProductNameProperty(newValueExpr);
		}
		if(PRODUCT_DESCRIPTION_PROPERTY.equals(property)){
			changeProductDescriptionProperty(newValueExpr);
		}
		if(PRODUCT_UNIT_PROPERTY.equals(property)){
			changeProductUnitProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeProductNameProperty(String newValueExpr){
	
		String oldValue = getProductName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateProductName(newValue);
		this.onChangeProperty(PRODUCT_NAME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeProductDescriptionProperty(String newValueExpr){
	
		String oldValue = getProductDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateProductDescription(newValue);
		this.onChangeProperty(PRODUCT_DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeProductUnitProperty(String newValueExpr){
	
		String oldValue = getProductUnit();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateProductUnit(newValue);
		this.onChangeProperty(PRODUCT_UNIT_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(PRODUCT_NAME_PROPERTY.equals(property)){
			return getProductName();
		}
		if(PRODUCT_DESCRIPTION_PROPERTY.equals(property)){
			return getProductDescription();
		}
		if(PRODUCT_UNIT_PROPERTY.equals(property)){
			return getProductUnit();
		}
		if(SUPPLIER_PROPERTY.equals(property)){
			return getSupplier();
		}
		if(PRODUCT_SUPPLY_DURATION_LIST.equals(property)){
			List<BaseEntity> list = getProductSupplyDurationList().stream().map(item->item).collect(Collectors.toList());
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
	public SupplierProduct updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setProductName(String productName){
		this.mProductName = trimString(productName);;
	}
	public String getProductName(){
		return this.mProductName;
	}
	public SupplierProduct updateProductName(String productName){
		this.mProductName = trimString(productName);;
		this.changed = true;
		return this;
	}
	public void mergeProductName(String productName){
		if(productName != null) { setProductName(productName);}
	}
	
	
	public void setProductDescription(String productDescription){
		this.mProductDescription = trimString(productDescription);;
	}
	public String getProductDescription(){
		return this.mProductDescription;
	}
	public SupplierProduct updateProductDescription(String productDescription){
		this.mProductDescription = trimString(productDescription);;
		this.changed = true;
		return this;
	}
	public void mergeProductDescription(String productDescription){
		if(productDescription != null) { setProductDescription(productDescription);}
	}
	
	
	public void setProductUnit(String productUnit){
		this.mProductUnit = trimString(productUnit);;
	}
	public String getProductUnit(){
		return this.mProductUnit;
	}
	public SupplierProduct updateProductUnit(String productUnit){
		this.mProductUnit = trimString(productUnit);;
		this.changed = true;
		return this;
	}
	public void mergeProductUnit(String productUnit){
		if(productUnit != null) { setProductUnit(productUnit);}
	}
	
	
	public void setSupplier(GoodsSupplier supplier){
		this.mSupplier = supplier;;
	}
	public GoodsSupplier getSupplier(){
		return this.mSupplier;
	}
	public SupplierProduct updateSupplier(GoodsSupplier supplier){
		this.mSupplier = supplier;;
		this.changed = true;
		return this;
	}
	public void mergeSupplier(GoodsSupplier supplier){
		if(supplier != null) { setSupplier(supplier);}
	}
	
	
	public void clearSupplier(){
		setSupplier ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public SupplierProduct updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<ProductSupplyDuration> getProductSupplyDurationList(){
		if(this.mProductSupplyDurationList == null){
			this.mProductSupplyDurationList = new SmartList<ProductSupplyDuration>();
			this.mProductSupplyDurationList.setListInternalName (PRODUCT_SUPPLY_DURATION_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mProductSupplyDurationList;	
	}
	public  void setProductSupplyDurationList(SmartList<ProductSupplyDuration> productSupplyDurationList){
		for( ProductSupplyDuration productSupplyDuration:productSupplyDurationList){
			productSupplyDuration.setProduct(this);
		}

		this.mProductSupplyDurationList = productSupplyDurationList;
		this.mProductSupplyDurationList.setListInternalName (PRODUCT_SUPPLY_DURATION_LIST );
		
	}
	
	public  void addProductSupplyDuration(ProductSupplyDuration productSupplyDuration){
		productSupplyDuration.setProduct(this);
		getProductSupplyDurationList().add(productSupplyDuration);
	}
	public  void addProductSupplyDurationList(SmartList<ProductSupplyDuration> productSupplyDurationList){
		for( ProductSupplyDuration productSupplyDuration:productSupplyDurationList){
			productSupplyDuration.setProduct(this);
		}
		getProductSupplyDurationList().addAll(productSupplyDurationList);
	}
	public  void mergeProductSupplyDurationList(SmartList<ProductSupplyDuration> productSupplyDurationList){
		if(productSupplyDurationList==null){
			return;
		}
		if(productSupplyDurationList.isEmpty()){
			return;
		}
		addProductSupplyDurationList( productSupplyDurationList );
		
	}
	public  ProductSupplyDuration removeProductSupplyDuration(ProductSupplyDuration productSupplyDurationIndex){
		
		int index = getProductSupplyDurationList().indexOf(productSupplyDurationIndex);
        if(index < 0){
        	String message = "ProductSupplyDuration("+productSupplyDurationIndex.getId()+") with version='"+productSupplyDurationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ProductSupplyDuration productSupplyDuration = getProductSupplyDurationList().get(index);        
        // productSupplyDuration.clearProduct(); //disconnect with Product
        productSupplyDuration.clearFromAll(); //disconnect with Product
		
		boolean result = getProductSupplyDurationList().planToRemove(productSupplyDuration);
        if(!result){
        	String message = "ProductSupplyDuration("+productSupplyDurationIndex.getId()+") with version='"+productSupplyDurationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return productSupplyDuration;
        
	
	}
	//断舍离
	public  void breakWithProductSupplyDuration(ProductSupplyDuration productSupplyDuration){
		
		if(productSupplyDuration == null){
			return;
		}
		productSupplyDuration.setProduct(null);
		//getProductSupplyDurationList().remove();
	
	}
	
	public  boolean hasProductSupplyDuration(ProductSupplyDuration productSupplyDuration){
	
		return getProductSupplyDurationList().contains(productSupplyDuration);
  
	}
	
	public void copyProductSupplyDurationFrom(ProductSupplyDuration productSupplyDuration) {

		ProductSupplyDuration productSupplyDurationInList = findTheProductSupplyDuration(productSupplyDuration);
		ProductSupplyDuration newProductSupplyDuration = new ProductSupplyDuration();
		productSupplyDurationInList.copyTo(newProductSupplyDuration);
		newProductSupplyDuration.setVersion(0);//will trigger copy
		getProductSupplyDurationList().add(newProductSupplyDuration);
		addItemToFlexiableObject(COPIED_CHILD, newProductSupplyDuration);
	}
	
	public  ProductSupplyDuration findTheProductSupplyDuration(ProductSupplyDuration productSupplyDuration){
		
		int index =  getProductSupplyDurationList().indexOf(productSupplyDuration);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ProductSupplyDuration("+productSupplyDuration.getId()+") with version='"+productSupplyDuration.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getProductSupplyDurationList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpProductSupplyDurationList(){
		getProductSupplyDurationList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getSupplier(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getProductSupplyDurationList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getProductSupplyDurationList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, PRODUCT_NAME_PROPERTY, getProductName());
		appendKeyValuePair(result, PRODUCT_DESCRIPTION_PROPERTY, getProductDescription());
		appendKeyValuePair(result, PRODUCT_UNIT_PROPERTY, getProductUnit());
		appendKeyValuePair(result, SUPPLIER_PROPERTY, getSupplier());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, PRODUCT_SUPPLY_DURATION_LIST, getProductSupplyDurationList());
		if(!getProductSupplyDurationList().isEmpty()){
			appendKeyValuePair(result, "productSupplyDurationCount", getProductSupplyDurationList().getTotalCount());
			appendKeyValuePair(result, "productSupplyDurationCurrentPageNumber", getProductSupplyDurationList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SupplierProduct){
		
		
			SupplierProduct dest =(SupplierProduct)baseDest;
		
			dest.setId(getId());
			dest.setProductName(getProductName());
			dest.setProductDescription(getProductDescription());
			dest.setProductUnit(getProductUnit());
			dest.setSupplier(getSupplier());
			dest.setVersion(getVersion());
			dest.setProductSupplyDurationList(getProductSupplyDurationList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SupplierProduct){
		
			
			SupplierProduct dest =(SupplierProduct)baseDest;
		
			dest.mergeId(getId());
			dest.mergeProductName(getProductName());
			dest.mergeProductDescription(getProductDescription());
			dest.mergeProductUnit(getProductUnit());
			dest.mergeSupplier(getSupplier());
			dest.mergeVersion(getVersion());
			dest.mergeProductSupplyDurationList(getProductSupplyDurationList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SupplierProduct){
		
			
			SupplierProduct dest =(SupplierProduct)baseDest;
		
			dest.mergeId(getId());
			dest.mergeProductName(getProductName());
			dest.mergeProductDescription(getProductDescription());
			dest.mergeProductUnit(getProductUnit());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getProductName(), getProductDescription(), getProductUnit(), getSupplier(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("SupplierProduct{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tproductName='"+getProductName()+"';");
		stringBuilder.append("\tproductDescription='"+getProductDescription()+"';");
		stringBuilder.append("\tproductUnit='"+getProductUnit()+"';");
		if(getSupplier() != null ){
 			stringBuilder.append("\tsupplier='GoodsSupplier("+getSupplier().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

