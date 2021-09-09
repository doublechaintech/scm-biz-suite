
package com.doublechaintech.retailscm.supplyorderlineitem;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;









@JsonSerialize(using = SupplyOrderLineItemSerializer.class)
public class SupplyOrderLineItem extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String BIZ_ORDER_PROPERTY             = "bizOrder"          ;
	public static final String SKU_ID_PROPERTY                = "skuId"             ;
	public static final String SKU_NAME_PROPERTY              = "skuName"           ;
	public static final String AMOUNT_PROPERTY                = "amount"            ;
	public static final String QUANTITY_PROPERTY              = "quantity"          ;
	public static final String UNIT_OF_MEASUREMENT_PROPERTY   = "unitOfMeasurement" ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="SupplyOrderLineItem";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(BIZ_ORDER_PROPERTY, "supply_order", "订单")
        .withType("supply_order", SupplyOrder.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(SKU_ID_PROPERTY, "sku_id", "产品ID")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(SKU_NAME_PROPERTY, "sku_name", "产品名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(AMOUNT_PROPERTY, "amount", "金额")
        .withType("money", "BigDecimal"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(QUANTITY_PROPERTY, "quantity", "数量")
        .withType("int", "int"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(UNIT_OF_MEASUREMENT_PROPERTY, "unit_of_measurement", "测量单位")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,BIZ_ORDER_PROPERTY ,SKU_ID_PROPERTY ,SKU_NAME_PROPERTY ,AMOUNT_PROPERTY ,QUANTITY_PROPERTY ,UNIT_OF_MEASUREMENT_PROPERTY ,VERSION_PROPERTY};
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
    parents.put(BIZ_ORDER_PROPERTY, SupplyOrder.class);

    return parents;
  }

  public SupplyOrderLineItem want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public SupplyOrderLineItem wants(Class<? extends BaseEntity>... classes) {
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
	protected		SupplyOrder         	bizOrder            ;
	protected		String              	skuId               ;
	protected		String              	skuName             ;
	protected		BigDecimal          	amount              ;
	protected		int                 	quantity            ;
	protected		String              	unitOfMeasurement   ;
	protected		int                 	version             ;

	



	public 	SupplyOrderLineItem(){
		// lazy load for all the properties
	}
	public 	static SupplyOrderLineItem withId(String id){
		SupplyOrderLineItem supplyOrderLineItem = new SupplyOrderLineItem();
		supplyOrderLineItem.setId(id);
		supplyOrderLineItem.setVersion(Integer.MAX_VALUE);
		supplyOrderLineItem.setChecked(true);
		return supplyOrderLineItem;
	}
	public 	static SupplyOrderLineItem refById(String id){
		return withId(id);
	}

  public SupplyOrderLineItem limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public SupplyOrderLineItem limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static SupplyOrderLineItem searchExample(){
    SupplyOrderLineItem supplyOrderLineItem = new SupplyOrderLineItem();
    		supplyOrderLineItem.setQuantity(UNSET_INT);
		supplyOrderLineItem.setVersion(UNSET_INT);

    return supplyOrderLineItem;
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

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public SupplyOrderLineItem updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public SupplyOrderLineItem orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public SupplyOrderLineItem ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public SupplyOrderLineItem addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setBizOrder(SupplyOrder bizOrder){SupplyOrder oldBizOrder = this.bizOrder;SupplyOrder newBizOrder = bizOrder;this.bizOrder = newBizOrder;}
	public SupplyOrder bizOrder(){
doLoad();
return getBizOrder();
}
	public SupplyOrder getBizOrder(){
		return this.bizOrder;
	}
	public SupplyOrderLineItem updateBizOrder(SupplyOrder bizOrder){SupplyOrder oldBizOrder = this.bizOrder;SupplyOrder newBizOrder = bizOrder;if(!shouldReplaceBy(newBizOrder, oldBizOrder)){return this;}this.bizOrder = newBizOrder;addPropertyChange(BIZ_ORDER_PROPERTY, oldBizOrder, newBizOrder);this.changed = true;setChecked(false);return this;}
	public SupplyOrderLineItem orderByBizOrder(boolean asc){
doAddOrderBy(BIZ_ORDER_PROPERTY, asc);
return this;
}
	public SearchCriteria createBizOrderCriteria(QueryOperator operator, Object... parameters){
return createCriteria(BIZ_ORDER_PROPERTY, operator, parameters);
}
	public SupplyOrderLineItem ignoreBizOrderCriteria(){super.ignoreSearchProperty(BIZ_ORDER_PROPERTY);
return this;
}
	public SupplyOrderLineItem addBizOrderCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createBizOrderCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeBizOrder(SupplyOrder bizOrder){
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
	public SupplyOrderLineItem updateSkuId(String skuId){String oldSkuId = this.skuId;String newSkuId = trimString(skuId);if(!shouldReplaceBy(newSkuId, oldSkuId)){return this;}this.skuId = newSkuId;addPropertyChange(SKU_ID_PROPERTY, oldSkuId, newSkuId);this.changed = true;setChecked(false);return this;}
	public SupplyOrderLineItem orderBySkuId(boolean asc){
doAddOrderBy(SKU_ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createSkuIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(SKU_ID_PROPERTY, operator, parameters);
}
	public SupplyOrderLineItem ignoreSkuIdCriteria(){super.ignoreSearchProperty(SKU_ID_PROPERTY);
return this;
}
	public SupplyOrderLineItem addSkuIdCriteria(QueryOperator operator, Object... parameters){
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
	public SupplyOrderLineItem updateSkuName(String skuName){String oldSkuName = this.skuName;String newSkuName = trimString(skuName);if(!shouldReplaceBy(newSkuName, oldSkuName)){return this;}this.skuName = newSkuName;addPropertyChange(SKU_NAME_PROPERTY, oldSkuName, newSkuName);this.changed = true;setChecked(false);return this;}
	public SupplyOrderLineItem orderBySkuName(boolean asc){
doAddOrderBy(SKU_NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createSkuNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(SKU_NAME_PROPERTY, operator, parameters);
}
	public SupplyOrderLineItem ignoreSkuNameCriteria(){super.ignoreSearchProperty(SKU_NAME_PROPERTY);
return this;
}
	public SupplyOrderLineItem addSkuNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createSkuNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeSkuName(String skuName){
		if(skuName != null) { setSkuName(skuName);}
	}

	
	public void setAmount(BigDecimal amount){BigDecimal oldAmount = this.amount;BigDecimal newAmount = amount;this.amount = newAmount;}
	public BigDecimal amount(){
doLoad();
return getAmount();
}
	public BigDecimal getAmount(){
		return this.amount;
	}
	public SupplyOrderLineItem updateAmount(BigDecimal amount){BigDecimal oldAmount = this.amount;BigDecimal newAmount = amount;if(!shouldReplaceBy(newAmount, oldAmount)){return this;}this.amount = newAmount;addPropertyChange(AMOUNT_PROPERTY, oldAmount, newAmount);this.changed = true;setChecked(false);return this;}
	public SupplyOrderLineItem orderByAmount(boolean asc){
doAddOrderBy(AMOUNT_PROPERTY, asc);
return this;
}
	public SearchCriteria createAmountCriteria(QueryOperator operator, Object... parameters){
return createCriteria(AMOUNT_PROPERTY, operator, parameters);
}
	public SupplyOrderLineItem ignoreAmountCriteria(){super.ignoreSearchProperty(AMOUNT_PROPERTY);
return this;
}
	public SupplyOrderLineItem addAmountCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createAmountCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeAmount(BigDecimal amount){
		setAmount(amount);
	}

	
	public void setQuantity(int quantity){int oldQuantity = this.quantity;int newQuantity = quantity;this.quantity = newQuantity;}
	public int quantity(){
doLoad();
return getQuantity();
}
	public int getQuantity(){
		return this.quantity;
	}
	public SupplyOrderLineItem updateQuantity(int quantity){int oldQuantity = this.quantity;int newQuantity = quantity;if(!shouldReplaceBy(newQuantity, oldQuantity)){return this;}this.quantity = newQuantity;addPropertyChange(QUANTITY_PROPERTY, oldQuantity, newQuantity);this.changed = true;setChecked(false);return this;}
	public SupplyOrderLineItem orderByQuantity(boolean asc){
doAddOrderBy(QUANTITY_PROPERTY, asc);
return this;
}
	public SearchCriteria createQuantityCriteria(QueryOperator operator, Object... parameters){
return createCriteria(QUANTITY_PROPERTY, operator, parameters);
}
	public SupplyOrderLineItem ignoreQuantityCriteria(){super.ignoreSearchProperty(QUANTITY_PROPERTY);
return this;
}
	public SupplyOrderLineItem addQuantityCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createQuantityCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeQuantity(int quantity){
		setQuantity(quantity);
	}

	
	public void setUnitOfMeasurement(String unitOfMeasurement){String oldUnitOfMeasurement = this.unitOfMeasurement;String newUnitOfMeasurement = trimString(unitOfMeasurement);this.unitOfMeasurement = newUnitOfMeasurement;}
	public String unitOfMeasurement(){
doLoad();
return getUnitOfMeasurement();
}
	public String getUnitOfMeasurement(){
		return this.unitOfMeasurement;
	}
	public SupplyOrderLineItem updateUnitOfMeasurement(String unitOfMeasurement){String oldUnitOfMeasurement = this.unitOfMeasurement;String newUnitOfMeasurement = trimString(unitOfMeasurement);if(!shouldReplaceBy(newUnitOfMeasurement, oldUnitOfMeasurement)){return this;}this.unitOfMeasurement = newUnitOfMeasurement;addPropertyChange(UNIT_OF_MEASUREMENT_PROPERTY, oldUnitOfMeasurement, newUnitOfMeasurement);this.changed = true;setChecked(false);return this;}
	public SupplyOrderLineItem orderByUnitOfMeasurement(boolean asc){
doAddOrderBy(UNIT_OF_MEASUREMENT_PROPERTY, asc);
return this;
}
	public SearchCriteria createUnitOfMeasurementCriteria(QueryOperator operator, Object... parameters){
return createCriteria(UNIT_OF_MEASUREMENT_PROPERTY, operator, parameters);
}
	public SupplyOrderLineItem ignoreUnitOfMeasurementCriteria(){super.ignoreSearchProperty(UNIT_OF_MEASUREMENT_PROPERTY);
return this;
}
	public SupplyOrderLineItem addUnitOfMeasurementCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createUnitOfMeasurementCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeUnitOfMeasurement(String unitOfMeasurement){
		if(unitOfMeasurement != null) { setUnitOfMeasurement(unitOfMeasurement);}
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public SupplyOrderLineItem updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public SupplyOrderLineItem orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public SupplyOrderLineItem ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public SupplyOrderLineItem addVersionCriteria(QueryOperator operator, Object... parameters){
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


		if(baseDest instanceof SupplyOrderLineItem){


			SupplyOrderLineItem dest =(SupplyOrderLineItem)baseDest;

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


		if(baseDest instanceof SupplyOrderLineItem){


			SupplyOrderLineItem dest =(SupplyOrderLineItem)baseDest;

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


		if(baseDest instanceof SupplyOrderLineItem){


			SupplyOrderLineItem dest =(SupplyOrderLineItem)baseDest;

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


	public static SupplyOrderLineItem createWith(RetailscmUserContext userContext, ThrowingFunction<SupplyOrderLineItem,SupplyOrderLineItem,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<SupplyOrderLineItem> customCreator = mapper.findCustomCreator(SupplyOrderLineItem.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    SupplyOrderLineItem result = new SupplyOrderLineItem();
    result.setBizOrder(mapper.tryToGet(SupplyOrderLineItem.class, BIZ_ORDER_PROPERTY, SupplyOrder.class,
        0, true, result.getBizOrder(), params));
    result.setSkuId(mapper.tryToGet(SupplyOrderLineItem.class, SKU_ID_PROPERTY, String.class,
        0, false, result.getSkuId(), params));
    result.setSkuName(mapper.tryToGet(SupplyOrderLineItem.class, SKU_NAME_PROPERTY, String.class,
        1, false, result.getSkuName(), params));
    result.setAmount(mapper.tryToGet(SupplyOrderLineItem.class, AMOUNT_PROPERTY, BigDecimal.class,
        0, true, result.getAmount(), params));
    result.setQuantity(mapper.tryToGet(SupplyOrderLineItem.class, QUANTITY_PROPERTY, int.class,
        0, true, result.getQuantity(), params));
    result.setUnitOfMeasurement(mapper.tryToGet(SupplyOrderLineItem.class, UNIT_OF_MEASUREMENT_PROPERTY, String.class,
        2, false, result.getUnitOfMeasurement(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixSupplyOrderLineItem(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      SupplyOrderLineItemTokens tokens = mapper.findParamByClass(params, SupplyOrderLineItemTokens.class);
      if (tokens == null) {
        tokens = SupplyOrderLineItemTokens.start();
      }
      result = userContext.getManagerGroup().getSupplyOrderLineItemManager().internalSaveSupplyOrderLineItem(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("SupplyOrderLineItem{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getBizOrder() != null ){
 			stringBuilder.append("\tbizOrder='SupplyOrder("+getBizOrder().getId()+")';");
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
		updateQuantity(this.quantity +  incQuantity);
	}
	public void decreaseQuantity(int decQuantity){
		updateQuantity(this.quantity - decQuantity);
	}
	

}

