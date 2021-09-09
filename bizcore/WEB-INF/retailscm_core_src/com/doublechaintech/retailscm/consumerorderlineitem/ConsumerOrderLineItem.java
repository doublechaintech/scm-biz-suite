
package com.doublechaintech.retailscm.consumerorderlineitem;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
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
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="ConsumerOrderLineItem";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(BIZ_ORDER_PROPERTY, "consumer_order", "订单")
        .withType("consumer_order", ConsumerOrder.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(SKU_ID_PROPERTY, "sku_id", "产品ID")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(SKU_NAME_PROPERTY, "sku_name", "产品名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(PRICE_PROPERTY, "price", "价格")
        .withType("money", "BigDecimal"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(QUANTITY_PROPERTY, "quantity", "数量")
        .withType("double", "BigDecimal"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(AMOUNT_PROPERTY, "amount", "金额")
        .withType("money", "BigDecimal"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
        .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,BIZ_ORDER_PROPERTY ,SKU_ID_PROPERTY ,SKU_NAME_PROPERTY ,PRICE_PROPERTY ,QUANTITY_PROPERTY ,AMOUNT_PROPERTY ,LAST_UPDATE_TIME_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(BIZ_ORDER_PROPERTY, ConsumerOrder.class);

    return parents;
  }

  public ConsumerOrderLineItem want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public ConsumerOrderLineItem wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getSkuId();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		ConsumerOrder       	bizOrder            ;
	protected		String              	skuId               ;
	protected		String              	skuName             ;
	protected		BigDecimal          	price               ;
	protected		BigDecimal          	quantity            ;
	protected		BigDecimal          	amount              ;
	protected		DateTime            	lastUpdateTime      ;
	protected		int                 	version             ;

	



	public 	ConsumerOrderLineItem(){
		// lazy load for all the properties
	}
	public 	static ConsumerOrderLineItem withId(String id){
		ConsumerOrderLineItem consumerOrderLineItem = new ConsumerOrderLineItem();
		consumerOrderLineItem.setId(id);
		consumerOrderLineItem.setVersion(Integer.MAX_VALUE);
		consumerOrderLineItem.setChecked(true);
		return consumerOrderLineItem;
	}
	public 	static ConsumerOrderLineItem refById(String id){
		return withId(id);
	}

  public ConsumerOrderLineItem limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public ConsumerOrderLineItem limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static ConsumerOrderLineItem searchExample(){
    ConsumerOrderLineItem consumerOrderLineItem = new ConsumerOrderLineItem();
    		consumerOrderLineItem.setVersion(UNSET_INT);

    return consumerOrderLineItem;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setBizOrder( null );

		this.changed = true;
		setChecked(false);
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
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			changeLastUpdateTimeProperty(newValueExpr);
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

		if(BIZ_ORDER_PROPERTY.equals(property)){
			return getBizOrder();
		}
		if(SKU_ID_PROPERTY.equals(property)){
			return getSkuId();
		}
		if(SKU_NAME_PROPERTY.equals(property)){
			return getSkuName();
		}
		if(PRICE_PROPERTY.equals(property)){
			return getPrice();
		}
		if(QUANTITY_PROPERTY.equals(property)){
			return getQuantity();
		}
		if(AMOUNT_PROPERTY.equals(property)){
			return getAmount();
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			return getLastUpdateTime();
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
	public ConsumerOrderLineItem updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public ConsumerOrderLineItem orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public ConsumerOrderLineItem ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public ConsumerOrderLineItem addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setBizOrder(ConsumerOrder bizOrder){ConsumerOrder oldBizOrder = this.bizOrder;ConsumerOrder newBizOrder = bizOrder;this.bizOrder = newBizOrder;}
	public ConsumerOrder bizOrder(){
doLoad();
return getBizOrder();
}
	public ConsumerOrder getBizOrder(){
		return this.bizOrder;
	}
	public ConsumerOrderLineItem updateBizOrder(ConsumerOrder bizOrder){ConsumerOrder oldBizOrder = this.bizOrder;ConsumerOrder newBizOrder = bizOrder;if(!shouldReplaceBy(newBizOrder, oldBizOrder)){return this;}this.bizOrder = newBizOrder;addPropertyChange(BIZ_ORDER_PROPERTY, oldBizOrder, newBizOrder);this.changed = true;setChecked(false);return this;}
	public ConsumerOrderLineItem orderByBizOrder(boolean asc){
doAddOrderBy(BIZ_ORDER_PROPERTY, asc);
return this;
}
	public SearchCriteria createBizOrderCriteria(QueryOperator operator, Object... parameters){
return createCriteria(BIZ_ORDER_PROPERTY, operator, parameters);
}
	public ConsumerOrderLineItem ignoreBizOrderCriteria(){super.ignoreSearchProperty(BIZ_ORDER_PROPERTY);
return this;
}
	public ConsumerOrderLineItem addBizOrderCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createBizOrderCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeBizOrder(ConsumerOrder bizOrder){
		if(bizOrder != null) { setBizOrder(bizOrder);}
	}

	
	public void clearBizOrder(){
		setBizOrder ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setSkuId(String skuId){String oldSkuId = this.skuId;String newSkuId = trimString(skuId);this.skuId = newSkuId;}
	public String skuId(){
doLoad();
return getSkuId();
}
	public String getSkuId(){
		return this.skuId;
	}
	public ConsumerOrderLineItem updateSkuId(String skuId){String oldSkuId = this.skuId;String newSkuId = trimString(skuId);if(!shouldReplaceBy(newSkuId, oldSkuId)){return this;}this.skuId = newSkuId;addPropertyChange(SKU_ID_PROPERTY, oldSkuId, newSkuId);this.changed = true;setChecked(false);return this;}
	public ConsumerOrderLineItem orderBySkuId(boolean asc){
doAddOrderBy(SKU_ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createSkuIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(SKU_ID_PROPERTY, operator, parameters);
}
	public ConsumerOrderLineItem ignoreSkuIdCriteria(){super.ignoreSearchProperty(SKU_ID_PROPERTY);
return this;
}
	public ConsumerOrderLineItem addSkuIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createSkuIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeSkuId(String skuId){
		if(skuId != null) { setSkuId(skuId);}
	}

	
	public void setSkuName(String skuName){String oldSkuName = this.skuName;String newSkuName = trimString(skuName);this.skuName = newSkuName;}
	public String skuName(){
doLoad();
return getSkuName();
}
	public String getSkuName(){
		return this.skuName;
	}
	public ConsumerOrderLineItem updateSkuName(String skuName){String oldSkuName = this.skuName;String newSkuName = trimString(skuName);if(!shouldReplaceBy(newSkuName, oldSkuName)){return this;}this.skuName = newSkuName;addPropertyChange(SKU_NAME_PROPERTY, oldSkuName, newSkuName);this.changed = true;setChecked(false);return this;}
	public ConsumerOrderLineItem orderBySkuName(boolean asc){
doAddOrderBy(SKU_NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createSkuNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(SKU_NAME_PROPERTY, operator, parameters);
}
	public ConsumerOrderLineItem ignoreSkuNameCriteria(){super.ignoreSearchProperty(SKU_NAME_PROPERTY);
return this;
}
	public ConsumerOrderLineItem addSkuNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createSkuNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeSkuName(String skuName){
		if(skuName != null) { setSkuName(skuName);}
	}

	
	public void setPrice(BigDecimal price){BigDecimal oldPrice = this.price;BigDecimal newPrice = price;this.price = newPrice;}
	public BigDecimal price(){
doLoad();
return getPrice();
}
	public BigDecimal getPrice(){
		return this.price;
	}
	public ConsumerOrderLineItem updatePrice(BigDecimal price){BigDecimal oldPrice = this.price;BigDecimal newPrice = price;if(!shouldReplaceBy(newPrice, oldPrice)){return this;}this.price = newPrice;addPropertyChange(PRICE_PROPERTY, oldPrice, newPrice);this.changed = true;setChecked(false);return this;}
	public ConsumerOrderLineItem orderByPrice(boolean asc){
doAddOrderBy(PRICE_PROPERTY, asc);
return this;
}
	public SearchCriteria createPriceCriteria(QueryOperator operator, Object... parameters){
return createCriteria(PRICE_PROPERTY, operator, parameters);
}
	public ConsumerOrderLineItem ignorePriceCriteria(){super.ignoreSearchProperty(PRICE_PROPERTY);
return this;
}
	public ConsumerOrderLineItem addPriceCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createPriceCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergePrice(BigDecimal price){
		setPrice(price);
	}

	
	public void setQuantity(BigDecimal quantity){BigDecimal oldQuantity = this.quantity;BigDecimal newQuantity = quantity;this.quantity = newQuantity;}
	public BigDecimal quantity(){
doLoad();
return getQuantity();
}
	public BigDecimal getQuantity(){
		return this.quantity;
	}
	public ConsumerOrderLineItem updateQuantity(BigDecimal quantity){BigDecimal oldQuantity = this.quantity;BigDecimal newQuantity = quantity;if(!shouldReplaceBy(newQuantity, oldQuantity)){return this;}this.quantity = newQuantity;addPropertyChange(QUANTITY_PROPERTY, oldQuantity, newQuantity);this.changed = true;setChecked(false);return this;}
	public ConsumerOrderLineItem orderByQuantity(boolean asc){
doAddOrderBy(QUANTITY_PROPERTY, asc);
return this;
}
	public SearchCriteria createQuantityCriteria(QueryOperator operator, Object... parameters){
return createCriteria(QUANTITY_PROPERTY, operator, parameters);
}
	public ConsumerOrderLineItem ignoreQuantityCriteria(){super.ignoreSearchProperty(QUANTITY_PROPERTY);
return this;
}
	public ConsumerOrderLineItem addQuantityCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createQuantityCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeQuantity(BigDecimal quantity){
		setQuantity(quantity);
	}

	
	public void setAmount(BigDecimal amount){BigDecimal oldAmount = this.amount;BigDecimal newAmount = amount;this.amount = newAmount;}
	public BigDecimal amount(){
doLoad();
return getAmount();
}
	public BigDecimal getAmount(){
		return this.amount;
	}
	public ConsumerOrderLineItem updateAmount(BigDecimal amount){BigDecimal oldAmount = this.amount;BigDecimal newAmount = amount;if(!shouldReplaceBy(newAmount, oldAmount)){return this;}this.amount = newAmount;addPropertyChange(AMOUNT_PROPERTY, oldAmount, newAmount);this.changed = true;setChecked(false);return this;}
	public ConsumerOrderLineItem orderByAmount(boolean asc){
doAddOrderBy(AMOUNT_PROPERTY, asc);
return this;
}
	public SearchCriteria createAmountCriteria(QueryOperator operator, Object... parameters){
return createCriteria(AMOUNT_PROPERTY, operator, parameters);
}
	public ConsumerOrderLineItem ignoreAmountCriteria(){super.ignoreSearchProperty(AMOUNT_PROPERTY);
return this;
}
	public ConsumerOrderLineItem addAmountCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createAmountCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeAmount(BigDecimal amount){
		setAmount(amount);
	}

	
	public void setLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;this.lastUpdateTime = newLastUpdateTime;}
	public DateTime lastUpdateTime(){
doLoad();
return getLastUpdateTime();
}
	public DateTime getLastUpdateTime(){
		return this.lastUpdateTime;
	}
	public ConsumerOrderLineItem updateLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;if(!shouldReplaceBy(newLastUpdateTime, oldLastUpdateTime)){return this;}this.lastUpdateTime = newLastUpdateTime;addPropertyChange(LAST_UPDATE_TIME_PROPERTY, oldLastUpdateTime, newLastUpdateTime);this.changed = true;setChecked(false);return this;}
	public ConsumerOrderLineItem orderByLastUpdateTime(boolean asc){
doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
}
	public ConsumerOrderLineItem ignoreLastUpdateTimeCriteria(){super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
return this;
}
	public ConsumerOrderLineItem addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
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
	public ConsumerOrderLineItem updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public ConsumerOrderLineItem orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public ConsumerOrderLineItem ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public ConsumerOrderLineItem addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
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
		appendKeyValuePair(result, PRICE_PROPERTY, getPrice());
		appendKeyValuePair(result, QUANTITY_PROPERTY, getQuantity());
		appendKeyValuePair(result, AMOUNT_PROPERTY, getAmount());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
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
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof ConsumerOrderLineItem){


			ConsumerOrderLineItem dest =(ConsumerOrderLineItem)baseDest;

			dest.mergeId(getId());
			dest.mergeBizOrder(getBizOrder());
			dest.mergeSkuId(getSkuId());
			dest.mergeSkuName(getSkuName());
			dest.mergePrice(getPrice());
			dest.mergeQuantity(getQuantity());
			dest.mergeAmount(getAmount());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof ConsumerOrderLineItem){


			ConsumerOrderLineItem dest =(ConsumerOrderLineItem)baseDest;

			dest.mergeId(getId());
			dest.mergeSkuId(getSkuId());
			dest.mergeSkuName(getSkuName());
			dest.mergePrice(getPrice());
			dest.mergeQuantity(getQuantity());
			dest.mergeAmount(getAmount());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getBizOrder(), getSkuId(), getSkuName(), getPrice(), getQuantity(), getAmount(), getLastUpdateTime(), getVersion()};
	}


	public static ConsumerOrderLineItem createWith(RetailscmUserContext userContext, ThrowingFunction<ConsumerOrderLineItem,ConsumerOrderLineItem,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<ConsumerOrderLineItem> customCreator = mapper.findCustomCreator(ConsumerOrderLineItem.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    ConsumerOrderLineItem result = new ConsumerOrderLineItem();
    result.setBizOrder(mapper.tryToGet(ConsumerOrderLineItem.class, BIZ_ORDER_PROPERTY, ConsumerOrder.class,
        0, true, result.getBizOrder(), params));
    result.setSkuId(mapper.tryToGet(ConsumerOrderLineItem.class, SKU_ID_PROPERTY, String.class,
        0, false, result.getSkuId(), params));
    result.setSkuName(mapper.tryToGet(ConsumerOrderLineItem.class, SKU_NAME_PROPERTY, String.class,
        1, false, result.getSkuName(), params));
    result.setPrice(mapper.tryToGet(ConsumerOrderLineItem.class, PRICE_PROPERTY, BigDecimal.class,
        0, false, result.getPrice(), params));
    result.setQuantity(mapper.tryToGet(ConsumerOrderLineItem.class, QUANTITY_PROPERTY, BigDecimal.class,
        1, false, result.getQuantity(), params));
    result.setAmount(mapper.tryToGet(ConsumerOrderLineItem.class, AMOUNT_PROPERTY, BigDecimal.class,
        2, false, result.getAmount(), params));
     result.setLastUpdateTime(userContext.now());

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixConsumerOrderLineItem(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      ConsumerOrderLineItemTokens tokens = mapper.findParamByClass(params, ConsumerOrderLineItemTokens.class);
      if (tokens == null) {
        tokens = ConsumerOrderLineItemTokens.start();
      }
      result = userContext.getManagerGroup().getConsumerOrderLineItemManager().internalSaveConsumerOrderLineItem(userContext, result, tokens.done());
      
    }
    return result;
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
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

