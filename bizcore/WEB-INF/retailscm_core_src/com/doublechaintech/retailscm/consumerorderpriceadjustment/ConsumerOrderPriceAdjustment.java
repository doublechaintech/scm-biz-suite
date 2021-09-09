
package com.doublechaintech.retailscm.consumerorderpriceadjustment;

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


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(BIZ_ORDER_PROPERTY, "consumer_order", "订单")
        .withType("consumer_order", ConsumerOrder.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(AMOUNT_PROPERTY, "amount", "金额")
        .withType("money", "BigDecimal"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(PROVIDER_PROPERTY, "provider", "供应商")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,BIZ_ORDER_PROPERTY ,AMOUNT_PROPERTY ,PROVIDER_PROPERTY ,VERSION_PROPERTY};
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

  public ConsumerOrderPriceAdjustment want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public ConsumerOrderPriceAdjustment wants(Class<? extends BaseEntity>... classes) {
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
	protected		ConsumerOrder       	bizOrder            ;
	protected		BigDecimal          	amount              ;
	protected		String              	provider            ;
	protected		int                 	version             ;

	



	public 	ConsumerOrderPriceAdjustment(){
		// lazy load for all the properties
	}
	public 	static ConsumerOrderPriceAdjustment withId(String id){
		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = new ConsumerOrderPriceAdjustment();
		consumerOrderPriceAdjustment.setId(id);
		consumerOrderPriceAdjustment.setVersion(Integer.MAX_VALUE);
		consumerOrderPriceAdjustment.setChecked(true);
		return consumerOrderPriceAdjustment;
	}
	public 	static ConsumerOrderPriceAdjustment refById(String id){
		return withId(id);
	}

  public ConsumerOrderPriceAdjustment limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public ConsumerOrderPriceAdjustment limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static ConsumerOrderPriceAdjustment searchExample(){
    ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = new ConsumerOrderPriceAdjustment();
    		consumerOrderPriceAdjustment.setVersion(UNSET_INT);

    return consumerOrderPriceAdjustment;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setBizOrder( null );

		this.changed = true;
		setChecked(false);
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

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public ConsumerOrderPriceAdjustment updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public ConsumerOrderPriceAdjustment orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public ConsumerOrderPriceAdjustment ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public ConsumerOrderPriceAdjustment addIdCriteria(QueryOperator operator, Object... parameters){
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
	public ConsumerOrderPriceAdjustment updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public ConsumerOrderPriceAdjustment orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public ConsumerOrderPriceAdjustment ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public ConsumerOrderPriceAdjustment addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setBizOrder(ConsumerOrder bizOrder){ConsumerOrder oldBizOrder = this.bizOrder;ConsumerOrder newBizOrder = bizOrder;this.bizOrder = newBizOrder;}
	public ConsumerOrder bizOrder(){
doLoad();
return getBizOrder();
}
	public ConsumerOrder getBizOrder(){
		return this.bizOrder;
	}
	public ConsumerOrderPriceAdjustment updateBizOrder(ConsumerOrder bizOrder){ConsumerOrder oldBizOrder = this.bizOrder;ConsumerOrder newBizOrder = bizOrder;if(!shouldReplaceBy(newBizOrder, oldBizOrder)){return this;}this.bizOrder = newBizOrder;addPropertyChange(BIZ_ORDER_PROPERTY, oldBizOrder, newBizOrder);this.changed = true;setChecked(false);return this;}
	public ConsumerOrderPriceAdjustment orderByBizOrder(boolean asc){
doAddOrderBy(BIZ_ORDER_PROPERTY, asc);
return this;
}
	public SearchCriteria createBizOrderCriteria(QueryOperator operator, Object... parameters){
return createCriteria(BIZ_ORDER_PROPERTY, operator, parameters);
}
	public ConsumerOrderPriceAdjustment ignoreBizOrderCriteria(){super.ignoreSearchProperty(BIZ_ORDER_PROPERTY);
return this;
}
	public ConsumerOrderPriceAdjustment addBizOrderCriteria(QueryOperator operator, Object... parameters){
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
	
	public void setAmount(BigDecimal amount){BigDecimal oldAmount = this.amount;BigDecimal newAmount = amount;this.amount = newAmount;}
	public BigDecimal amount(){
doLoad();
return getAmount();
}
	public BigDecimal getAmount(){
		return this.amount;
	}
	public ConsumerOrderPriceAdjustment updateAmount(BigDecimal amount){BigDecimal oldAmount = this.amount;BigDecimal newAmount = amount;if(!shouldReplaceBy(newAmount, oldAmount)){return this;}this.amount = newAmount;addPropertyChange(AMOUNT_PROPERTY, oldAmount, newAmount);this.changed = true;setChecked(false);return this;}
	public ConsumerOrderPriceAdjustment orderByAmount(boolean asc){
doAddOrderBy(AMOUNT_PROPERTY, asc);
return this;
}
	public SearchCriteria createAmountCriteria(QueryOperator operator, Object... parameters){
return createCriteria(AMOUNT_PROPERTY, operator, parameters);
}
	public ConsumerOrderPriceAdjustment ignoreAmountCriteria(){super.ignoreSearchProperty(AMOUNT_PROPERTY);
return this;
}
	public ConsumerOrderPriceAdjustment addAmountCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createAmountCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeAmount(BigDecimal amount){
		setAmount(amount);
	}

	
	public void setProvider(String provider){String oldProvider = this.provider;String newProvider = trimString(provider);this.provider = newProvider;}
	public String provider(){
doLoad();
return getProvider();
}
	public String getProvider(){
		return this.provider;
	}
	public ConsumerOrderPriceAdjustment updateProvider(String provider){String oldProvider = this.provider;String newProvider = trimString(provider);if(!shouldReplaceBy(newProvider, oldProvider)){return this;}this.provider = newProvider;addPropertyChange(PROVIDER_PROPERTY, oldProvider, newProvider);this.changed = true;setChecked(false);return this;}
	public ConsumerOrderPriceAdjustment orderByProvider(boolean asc){
doAddOrderBy(PROVIDER_PROPERTY, asc);
return this;
}
	public SearchCriteria createProviderCriteria(QueryOperator operator, Object... parameters){
return createCriteria(PROVIDER_PROPERTY, operator, parameters);
}
	public ConsumerOrderPriceAdjustment ignoreProviderCriteria(){super.ignoreSearchProperty(PROVIDER_PROPERTY);
return this;
}
	public ConsumerOrderPriceAdjustment addProviderCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createProviderCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeProvider(String provider){
		if(provider != null) { setProvider(provider);}
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public ConsumerOrderPriceAdjustment updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public ConsumerOrderPriceAdjustment orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public ConsumerOrderPriceAdjustment ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public ConsumerOrderPriceAdjustment addVersionCriteria(QueryOperator operator, Object... parameters){
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


	public static ConsumerOrderPriceAdjustment createWith(RetailscmUserContext userContext, ThrowingFunction<ConsumerOrderPriceAdjustment,ConsumerOrderPriceAdjustment,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<ConsumerOrderPriceAdjustment> customCreator = mapper.findCustomCreator(ConsumerOrderPriceAdjustment.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    ConsumerOrderPriceAdjustment result = new ConsumerOrderPriceAdjustment();
    result.setName(mapper.tryToGet(ConsumerOrderPriceAdjustment.class, NAME_PROPERTY, String.class,
        0, false, result.getName(), params));
    result.setBizOrder(mapper.tryToGet(ConsumerOrderPriceAdjustment.class, BIZ_ORDER_PROPERTY, ConsumerOrder.class,
        0, true, result.getBizOrder(), params));
    result.setAmount(mapper.tryToGet(ConsumerOrderPriceAdjustment.class, AMOUNT_PROPERTY, BigDecimal.class,
        0, true, result.getAmount(), params));
    result.setProvider(mapper.tryToGet(ConsumerOrderPriceAdjustment.class, PROVIDER_PROPERTY, String.class,
        1, false, result.getProvider(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixConsumerOrderPriceAdjustment(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      ConsumerOrderPriceAdjustmentTokens tokens = mapper.findParamByClass(params, ConsumerOrderPriceAdjustmentTokens.class);
      if (tokens == null) {
        tokens = ConsumerOrderPriceAdjustmentTokens.start();
      }
      result = userContext.getManagerGroup().getConsumerOrderPriceAdjustmentManager().internalSaveConsumerOrderPriceAdjustment(userContext, result, tokens.done());
      
    }
    return result;
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

