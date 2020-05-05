
package com.doublechaintech.retailscm.retailstoreorderlineitem;

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
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

@JsonSerialize(using = RetailStoreOrderLineItemSerializer.class)
public class RetailStoreOrderLineItem extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String BIZ_ORDER_PROPERTY             = "bizOrder"          ;
	public static final String SKU_ID_PROPERTY                = "skuId"             ;
	public static final String SKU_NAME_PROPERTY              = "skuName"           ;
	public static final String AMOUNT_PROPERTY                = "amount"            ;
	public static final String QUANTITY_PROPERTY              = "quantity"          ;
	public static final String UNIT_OF_MEASUREMENT_PROPERTY   = "unitOfMeasurement" ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="RetailStoreOrderLineItem";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getSkuId();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		RetailStoreOrder    	mBizOrder           ;
	protected		String              	mSkuId              ;
	protected		String              	mSkuName            ;
	protected		BigDecimal          	mAmount             ;
	protected		int                 	mQuantity           ;
	protected		String              	mUnitOfMeasurement  ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	RetailStoreOrderLineItem(){
		// lazy load for all the properties
	}
	public 	static RetailStoreOrderLineItem withId(String id){
		RetailStoreOrderLineItem retailStoreOrderLineItem = new RetailStoreOrderLineItem();
		retailStoreOrderLineItem.setId(id);
		retailStoreOrderLineItem.setVersion(Integer.MAX_VALUE);
		return retailStoreOrderLineItem;
	}
	public 	static RetailStoreOrderLineItem refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setBizOrder( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(SKU_ID_PROPERTY.equals(property)){
			changeSkuIdProperty(newValueExpr);
		}
		if(SKU_NAME_PROPERTY.equals(property)){
			changeSkuNameProperty(newValueExpr);
		}
		if(AMOUNT_PROPERTY.equals(property)){
			changeAmountProperty(newValueExpr);
		}
		if(QUANTITY_PROPERTY.equals(property)){
			changeQuantityProperty(newValueExpr);
		}
		if(UNIT_OF_MEASUREMENT_PROPERTY.equals(property)){
			changeUnitOfMeasurementProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeSkuIdProperty(String newValueExpr){
	
		String oldValue = getSkuId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateSkuId(newValue);
		this.onChangeProperty(SKU_ID_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeSkuNameProperty(String newValueExpr){
	
		String oldValue = getSkuName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateSkuName(newValue);
		this.onChangeProperty(SKU_NAME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeAmountProperty(String newValueExpr){
	
		BigDecimal oldValue = getAmount();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAmount(newValue);
		this.onChangeProperty(AMOUNT_PROPERTY, oldValue, newValue);
		return;
   
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
			
			
			
	protected void changeUnitOfMeasurementProperty(String newValueExpr){
	
		String oldValue = getUnitOfMeasurement();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateUnitOfMeasurement(newValue);
		this.onChangeProperty(UNIT_OF_MEASUREMENT_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(BIZ_ORDER_PROPERTY.equals(property)){
			return getBizOrder();
		}
		if(SKU_ID_PROPERTY.equals(property)){
			return getSkuId();
		}
		if(SKU_NAME_PROPERTY.equals(property)){
			return getSkuName();
		}
		if(AMOUNT_PROPERTY.equals(property)){
			return getAmount();
		}
		if(QUANTITY_PROPERTY.equals(property)){
			return getQuantity();
		}
		if(UNIT_OF_MEASUREMENT_PROPERTY.equals(property)){
			return getUnitOfMeasurement();
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
	public RetailStoreOrderLineItem updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setBizOrder(RetailStoreOrder bizOrder){
		this.mBizOrder = bizOrder;;
	}
	public RetailStoreOrder getBizOrder(){
		return this.mBizOrder;
	}
	public RetailStoreOrderLineItem updateBizOrder(RetailStoreOrder bizOrder){
		this.mBizOrder = bizOrder;;
		this.changed = true;
		return this;
	}
	public void mergeBizOrder(RetailStoreOrder bizOrder){
		if(bizOrder != null) { setBizOrder(bizOrder);}
	}
	
	
	public void clearBizOrder(){
		setBizOrder ( null );
		this.changed = true;
	}
	
	public void setSkuId(String skuId){
		this.mSkuId = trimString(skuId);;
	}
	public String getSkuId(){
		return this.mSkuId;
	}
	public RetailStoreOrderLineItem updateSkuId(String skuId){
		this.mSkuId = trimString(skuId);;
		this.changed = true;
		return this;
	}
	public void mergeSkuId(String skuId){
		if(skuId != null) { setSkuId(skuId);}
	}
	
	
	public void clearSkuId(){
		setSkuId ( null );
		this.changed = true;
	}
	
	public void setSkuName(String skuName){
		this.mSkuName = trimString(skuName);;
	}
	public String getSkuName(){
		return this.mSkuName;
	}
	public RetailStoreOrderLineItem updateSkuName(String skuName){
		this.mSkuName = trimString(skuName);;
		this.changed = true;
		return this;
	}
	public void mergeSkuName(String skuName){
		if(skuName != null) { setSkuName(skuName);}
	}
	
	
	public void setAmount(BigDecimal amount){
		this.mAmount = amount;;
	}
	public BigDecimal getAmount(){
		return this.mAmount;
	}
	public RetailStoreOrderLineItem updateAmount(BigDecimal amount){
		this.mAmount = amount;;
		this.changed = true;
		return this;
	}
	public void mergeAmount(BigDecimal amount){
		setAmount(amount);
	}
	
	
	public void setQuantity(int quantity){
		this.mQuantity = quantity;;
	}
	public int getQuantity(){
		return this.mQuantity;
	}
	public RetailStoreOrderLineItem updateQuantity(int quantity){
		this.mQuantity = quantity;;
		this.changed = true;
		return this;
	}
	public void mergeQuantity(int quantity){
		setQuantity(quantity);
	}
	
	
	public void setUnitOfMeasurement(String unitOfMeasurement){
		this.mUnitOfMeasurement = trimString(unitOfMeasurement);;
	}
	public String getUnitOfMeasurement(){
		return this.mUnitOfMeasurement;
	}
	public RetailStoreOrderLineItem updateUnitOfMeasurement(String unitOfMeasurement){
		this.mUnitOfMeasurement = trimString(unitOfMeasurement);;
		this.changed = true;
		return this;
	}
	public void mergeUnitOfMeasurement(String unitOfMeasurement){
		if(unitOfMeasurement != null) { setUnitOfMeasurement(unitOfMeasurement);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public RetailStoreOrderLineItem updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getBizOrder(), internalType);

		
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
		appendKeyValuePair(result, BIZ_ORDER_PROPERTY, getBizOrder());
		appendKeyValuePair(result, SKU_ID_PROPERTY, getSkuId());
		appendKeyValuePair(result, SKU_NAME_PROPERTY, getSkuName());
		appendKeyValuePair(result, AMOUNT_PROPERTY, getAmount());
		appendKeyValuePair(result, QUANTITY_PROPERTY, getQuantity());
		appendKeyValuePair(result, UNIT_OF_MEASUREMENT_PROPERTY, getUnitOfMeasurement());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreOrderLineItem){
		
		
			RetailStoreOrderLineItem dest =(RetailStoreOrderLineItem)baseDest;
		
			dest.setId(getId());
			dest.setBizOrder(getBizOrder());
			dest.setSkuId(getSkuId());
			dest.setSkuName(getSkuName());
			dest.setAmount(getAmount());
			dest.setQuantity(getQuantity());
			dest.setUnitOfMeasurement(getUnitOfMeasurement());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreOrderLineItem){
		
			
			RetailStoreOrderLineItem dest =(RetailStoreOrderLineItem)baseDest;
		
			dest.mergeId(getId());
			dest.mergeBizOrder(getBizOrder());
			dest.mergeSkuId(getSkuId());
			dest.mergeSkuName(getSkuName());
			dest.mergeAmount(getAmount());
			dest.mergeQuantity(getQuantity());
			dest.mergeUnitOfMeasurement(getUnitOfMeasurement());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreOrderLineItem){
		
			
			RetailStoreOrderLineItem dest =(RetailStoreOrderLineItem)baseDest;
		
			dest.mergeId(getId());
			dest.mergeSkuId(getSkuId());
			dest.mergeSkuName(getSkuName());
			dest.mergeAmount(getAmount());
			dest.mergeQuantity(getQuantity());
			dest.mergeUnitOfMeasurement(getUnitOfMeasurement());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getBizOrder(), getSkuId(), getSkuName(), getAmount(), getQuantity(), getUnitOfMeasurement(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("RetailStoreOrderLineItem{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getBizOrder() != null ){
 			stringBuilder.append("\tbizOrder='RetailStoreOrder("+getBizOrder().getId()+")';");
 		}
		stringBuilder.append("\tskuId='"+getSkuId()+"';");
		stringBuilder.append("\tskuName='"+getSkuName()+"';");
		stringBuilder.append("\tamount='"+getAmount()+"';");
		stringBuilder.append("\tquantity='"+getQuantity()+"';");
		stringBuilder.append("\tunitOfMeasurement='"+getUnitOfMeasurement()+"';");
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

