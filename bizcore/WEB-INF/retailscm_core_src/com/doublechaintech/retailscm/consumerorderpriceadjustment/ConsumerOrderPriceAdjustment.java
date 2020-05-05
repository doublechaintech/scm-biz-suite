
package com.doublechaintech.retailscm.consumerorderpriceadjustment;

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
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;

@JsonSerialize(using = ConsumerOrderPriceAdjustmentSerializer.class)
public class ConsumerOrderPriceAdjustment extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String BIZ_ORDER_PROPERTY             = "bizOrder"          ;
	public static final String AMOUNT_PROPERTY                = "amount"            ;
	public static final String PROVIDER_PROPERTY              = "provider"          ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="ConsumerOrderPriceAdjustment";
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
	protected		ConsumerOrder       	mBizOrder           ;
	protected		BigDecimal          	mAmount             ;
	protected		String              	mProvider           ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	ConsumerOrderPriceAdjustment(){
		// lazy load for all the properties
	}
	public 	static ConsumerOrderPriceAdjustment withId(String id){
		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = new ConsumerOrderPriceAdjustment();
		consumerOrderPriceAdjustment.setId(id);
		consumerOrderPriceAdjustment.setVersion(Integer.MAX_VALUE);
		return consumerOrderPriceAdjustment;
	}
	public 	static ConsumerOrderPriceAdjustment refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setBizOrder( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(AMOUNT_PROPERTY.equals(property)){
			changeAmountProperty(newValueExpr);
		}
		if(PROVIDER_PROPERTY.equals(property)){
			changeProviderProperty(newValueExpr);
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
			
			
			
	protected void changeProviderProperty(String newValueExpr){
	
		String oldValue = getProvider();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateProvider(newValue);
		this.onChangeProperty(PROVIDER_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(BIZ_ORDER_PROPERTY.equals(property)){
			return getBizOrder();
		}
		if(AMOUNT_PROPERTY.equals(property)){
			return getAmount();
		}
		if(PROVIDER_PROPERTY.equals(property)){
			return getProvider();
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
	public ConsumerOrderPriceAdjustment updateId(String id){
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
	public ConsumerOrderPriceAdjustment updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setBizOrder(ConsumerOrder bizOrder){
		this.mBizOrder = bizOrder;;
	}
	public ConsumerOrder getBizOrder(){
		return this.mBizOrder;
	}
	public ConsumerOrderPriceAdjustment updateBizOrder(ConsumerOrder bizOrder){
		this.mBizOrder = bizOrder;;
		this.changed = true;
		return this;
	}
	public void mergeBizOrder(ConsumerOrder bizOrder){
		if(bizOrder != null) { setBizOrder(bizOrder);}
	}
	
	
	public void clearBizOrder(){
		setBizOrder ( null );
		this.changed = true;
	}
	
	public void setAmount(BigDecimal amount){
		this.mAmount = amount;;
	}
	public BigDecimal getAmount(){
		return this.mAmount;
	}
	public ConsumerOrderPriceAdjustment updateAmount(BigDecimal amount){
		this.mAmount = amount;;
		this.changed = true;
		return this;
	}
	public void mergeAmount(BigDecimal amount){
		setAmount(amount);
	}
	
	
	public void setProvider(String provider){
		this.mProvider = trimString(provider);;
	}
	public String getProvider(){
		return this.mProvider;
	}
	public ConsumerOrderPriceAdjustment updateProvider(String provider){
		this.mProvider = trimString(provider);;
		this.changed = true;
		return this;
	}
	public void mergeProvider(String provider){
		if(provider != null) { setProvider(provider);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public ConsumerOrderPriceAdjustment updateVersion(int version){
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
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, BIZ_ORDER_PROPERTY, getBizOrder());
		appendKeyValuePair(result, AMOUNT_PROPERTY, getAmount());
		appendKeyValuePair(result, PROVIDER_PROPERTY, getProvider());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ConsumerOrderPriceAdjustment){
		
		
			ConsumerOrderPriceAdjustment dest =(ConsumerOrderPriceAdjustment)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setBizOrder(getBizOrder());
			dest.setAmount(getAmount());
			dest.setProvider(getProvider());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ConsumerOrderPriceAdjustment){
		
			
			ConsumerOrderPriceAdjustment dest =(ConsumerOrderPriceAdjustment)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeBizOrder(getBizOrder());
			dest.mergeAmount(getAmount());
			dest.mergeProvider(getProvider());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ConsumerOrderPriceAdjustment){
		
			
			ConsumerOrderPriceAdjustment dest =(ConsumerOrderPriceAdjustment)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeAmount(getAmount());
			dest.mergeProvider(getProvider());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getBizOrder(), getAmount(), getProvider(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ConsumerOrderPriceAdjustment{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getBizOrder() != null ){
 			stringBuilder.append("\tbizOrder='ConsumerOrder("+getBizOrder().getId()+")';");
 		}
		stringBuilder.append("\tamount='"+getAmount()+"';");
		stringBuilder.append("\tprovider='"+getProvider()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

