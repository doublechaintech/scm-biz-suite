
package com.doublechaintech.retailscm.consumerorderlineitem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;

@JsonSerialize(using = ConsumerOrderLineItemSerializer.class)
public class ConsumerOrderLineItem extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String BIZ_ORDER_PROPERTY             = "bizOrder"          ;
	public static final String SKU_ID_PROPERTY                = "skuId"             ;
	public static final String SKU_NAME_PROPERTY              = "skuName"           ;
	public static final String PRICE_PROPERTY                 = "price"             ;
	public static final String QUANTITY_PROPERTY              = "quantity"          ;
	public static final String AMOUNT_PROPERTY                = "amount"            ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="ConsumerOrderLineItem";
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
	protected		ConsumerOrder       	mBizOrder           ;
	protected		String              	mSkuId              ;
	protected		String              	mSkuName            ;
	protected		BigDecimal          	mPrice              ;
	protected		BigDecimal          	mQuantity           ;
	protected		BigDecimal          	mAmount             ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	ConsumerOrderLineItem(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setBizOrder( null );

		this.changed = true;
	}
	
	public 	ConsumerOrderLineItem(ConsumerOrder bizOrder, String skuId, String skuName, BigDecimal price, BigDecimal quantity, BigDecimal amount)
	{
		setBizOrder(bizOrder);
		setSkuId(skuId);
		setSkuName(skuName);
		setPrice(price);
		setQuantity(quantity);
		setAmount(amount);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(SKU_ID_PROPERTY.equals(property)){
			changeSkuIdProperty(newValueExpr);
		}
		if(SKU_NAME_PROPERTY.equals(property)){
			changeSkuNameProperty(newValueExpr);
		}
		if(PRICE_PROPERTY.equals(property)){
			changePriceProperty(newValueExpr);
		}
		if(QUANTITY_PROPERTY.equals(property)){
			changeQuantityProperty(newValueExpr);
		}
		if(AMOUNT_PROPERTY.equals(property)){
			changeAmountProperty(newValueExpr);
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
			
			
			
	protected void changeQuantityProperty(String newValueExpr){
		BigDecimal oldValue = getQuantity();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateQuantity(newValue);
		this.onChangeProperty(QUANTITY_PROPERTY, oldValue, newValue);
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
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public ConsumerOrderLineItem updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setBizOrder(ConsumerOrder bizOrder){
		this.mBizOrder = bizOrder;;
	}
	public ConsumerOrder getBizOrder(){
		return this.mBizOrder;
	}
	public ConsumerOrderLineItem updateBizOrder(ConsumerOrder bizOrder){
		this.mBizOrder = bizOrder;;
		this.changed = true;
		return this;
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
	public ConsumerOrderLineItem updateSkuId(String skuId){
		this.mSkuId = trimString(skuId);;
		this.changed = true;
		return this;
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
	public ConsumerOrderLineItem updateSkuName(String skuName){
		this.mSkuName = trimString(skuName);;
		this.changed = true;
		return this;
	}
	
	
	public void setPrice(BigDecimal price){
		this.mPrice = price;;
	}
	public BigDecimal getPrice(){
		return this.mPrice;
	}
	public ConsumerOrderLineItem updatePrice(BigDecimal price){
		this.mPrice = price;;
		this.changed = true;
		return this;
	}
	
	
	public void setQuantity(BigDecimal quantity){
		this.mQuantity = quantity;;
	}
	public BigDecimal getQuantity(){
		return this.mQuantity;
	}
	public ConsumerOrderLineItem updateQuantity(BigDecimal quantity){
		this.mQuantity = quantity;;
		this.changed = true;
		return this;
	}
	
	
	public void setAmount(BigDecimal amount){
		this.mAmount = amount;;
	}
	public BigDecimal getAmount(){
		return this.mAmount;
	}
	public ConsumerOrderLineItem updateAmount(BigDecimal amount){
		this.mAmount = amount;;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public ConsumerOrderLineItem updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
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
		appendKeyValuePair(result, PRICE_PROPERTY, getPrice());
		appendKeyValuePair(result, QUANTITY_PROPERTY, getQuantity());
		appendKeyValuePair(result, AMOUNT_PROPERTY, getAmount());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ConsumerOrderLineItem){
		
		
			ConsumerOrderLineItem dest =(ConsumerOrderLineItem)baseDest;
		
			dest.setId(getId());
			dest.setBizOrder(getBizOrder());
			dest.setSkuId(getSkuId());
			dest.setSkuName(getSkuName());
			dest.setPrice(getPrice());
			dest.setQuantity(getQuantity());
			dest.setAmount(getAmount());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ConsumerOrderLineItem{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getBizOrder() != null ){
 			stringBuilder.append("\tbizOrder='ConsumerOrder("+getBizOrder().getId()+")';");
 		}
		stringBuilder.append("\tskuId='"+getSkuId()+"';");
		stringBuilder.append("\tskuName='"+getSkuName()+"';");
		stringBuilder.append("\tprice='"+getPrice()+"';");
		stringBuilder.append("\tquantity='"+getQuantity()+"';");
		stringBuilder.append("\tamount='"+getAmount()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

