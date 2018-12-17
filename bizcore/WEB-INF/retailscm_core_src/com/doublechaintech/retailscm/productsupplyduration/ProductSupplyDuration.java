
package com.doublechaintech.retailscm.productsupplyduration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;

@JsonSerialize(using = ProductSupplyDurationSerializer.class)
public class ProductSupplyDuration extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String QUANTITY_PROPERTY              = "quantity"          ;
	public static final String DURATION_PROPERTY              = "duration"          ;
	public static final String PRICE_PROPERTY                 = "price"             ;
	public static final String PRODUCT_PROPERTY               = "product"           ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="ProductSupplyDuration";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getDuration();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		int                 	mQuantity           ;
	protected		String              	mDuration           ;
	protected		BigDecimal          	mPrice              ;
	protected		SupplierProduct     	mProduct            ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	ProductSupplyDuration(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setProduct( null );

		this.changed = true;
	}
	
	public 	ProductSupplyDuration(int quantity, String duration, BigDecimal price, SupplierProduct product)
	{
		setQuantity(quantity);
		setDuration(duration);
		setPrice(price);
		setProduct(product);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(QUANTITY_PROPERTY.equals(property)){
			changeQuantityProperty(newValueExpr);
		}
		if(DURATION_PROPERTY.equals(property)){
			changeDurationProperty(newValueExpr);
		}
		if(PRICE_PROPERTY.equals(property)){
			changePriceProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeQuantityProperty(String newValueExpr){
		int oldValue = getQuantity();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateQuantity(newValue);
		this.onChangeProperty(QUANTITY_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeDurationProperty(String newValueExpr){
		String oldValue = getDuration();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDuration(newValue);
		this.onChangeProperty(DURATION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changePriceProperty(String newValueExpr){
		BigDecimal oldValue = getPrice();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePrice(newValue);
		this.onChangeProperty(PRICE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public ProductSupplyDuration updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setQuantity(int quantity){
		this.mQuantity = quantity;;
	}
	public int getQuantity(){
		return this.mQuantity;
	}
	public ProductSupplyDuration updateQuantity(int quantity){
		this.mQuantity = quantity;;
		this.changed = true;
		return this;
	}
	
	
	public void setDuration(String duration){
		this.mDuration = trimString(duration);;
	}
	public String getDuration(){
		return this.mDuration;
	}
	public ProductSupplyDuration updateDuration(String duration){
		this.mDuration = trimString(duration);;
		this.changed = true;
		return this;
	}
	
	
	public void setPrice(BigDecimal price){
		this.mPrice = price;;
	}
	public BigDecimal getPrice(){
		return this.mPrice;
	}
	public ProductSupplyDuration updatePrice(BigDecimal price){
		this.mPrice = price;;
		this.changed = true;
		return this;
	}
	
	
	public void setProduct(SupplierProduct product){
		this.mProduct = product;;
	}
	public SupplierProduct getProduct(){
		return this.mProduct;
	}
	public ProductSupplyDuration updateProduct(SupplierProduct product){
		this.mProduct = product;;
		this.changed = true;
		return this;
	}
	
	
	public void clearProduct(){
		setProduct ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public ProductSupplyDuration updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getProduct(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, QUANTITY_PROPERTY, getQuantity());
		appendKeyValuePair(result, DURATION_PROPERTY, getDuration());
		appendKeyValuePair(result, PRICE_PROPERTY, getPrice());
		appendKeyValuePair(result, PRODUCT_PROPERTY, getProduct());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ProductSupplyDuration){
		
		
			ProductSupplyDuration dest =(ProductSupplyDuration)baseDest;
		
			dest.setId(getId());
			dest.setQuantity(getQuantity());
			dest.setDuration(getDuration());
			dest.setPrice(getPrice());
			dest.setProduct(getProduct());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ProductSupplyDuration{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tquantity='"+getQuantity()+"';");
		stringBuilder.append("\tduration='"+getDuration()+"';");
		stringBuilder.append("\tprice='"+getPrice()+"';");
		if(getProduct() != null ){
 			stringBuilder.append("\tproduct='SupplierProduct("+getProduct().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseQuantity(int incQuantity){
		updateQuantity(this.mQuantity +  incQuantity);
	}
	public void decreaseQuantity(int decQuantity){
		updateQuantity(this.mQuantity - decQuantity);
	}
	

}

