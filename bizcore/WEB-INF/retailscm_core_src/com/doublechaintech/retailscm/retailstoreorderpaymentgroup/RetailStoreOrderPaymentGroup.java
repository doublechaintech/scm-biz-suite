
package com.doublechaintech.retailscm.retailstoreorderpaymentgroup;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;









@JsonSerialize(using = RetailStoreOrderPaymentGroupSerializer.class)
public class RetailStoreOrderPaymentGroup extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String BIZ_ORDER_PROPERTY             = "bizOrder"          ;
	public static final String CARD_NUMBER_PROPERTY           = "cardNumber"        ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="RetailStoreOrderPaymentGroup";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(BIZ_ORDER_PROPERTY, "retail_store_order", "订单")
        .withType("retail_store_order", RetailStoreOrder.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CARD_NUMBER_PROPERTY, "card_number", "卡号码")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,BIZ_ORDER_PROPERTY ,CARD_NUMBER_PROPERTY ,VERSION_PROPERTY};
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
    parents.put(BIZ_ORDER_PROPERTY, RetailStoreOrder.class);

    return parents;
  }

  public RetailStoreOrderPaymentGroup want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public RetailStoreOrderPaymentGroup wants(Class<? extends BaseEntity>... classes) {
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
	protected		RetailStoreOrder    	bizOrder            ;
	protected		String              	cardNumber          ;
	protected		int                 	version             ;

	



	public 	RetailStoreOrderPaymentGroup(){
		// lazy load for all the properties
	}
	public 	static RetailStoreOrderPaymentGroup withId(String id){
		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = new RetailStoreOrderPaymentGroup();
		retailStoreOrderPaymentGroup.setId(id);
		retailStoreOrderPaymentGroup.setVersion(Integer.MAX_VALUE);
		retailStoreOrderPaymentGroup.setChecked(true);
		return retailStoreOrderPaymentGroup;
	}
	public 	static RetailStoreOrderPaymentGroup refById(String id){
		return withId(id);
	}

  public RetailStoreOrderPaymentGroup limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public RetailStoreOrderPaymentGroup limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static RetailStoreOrderPaymentGroup searchExample(){
    RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = new RetailStoreOrderPaymentGroup();
    		retailStoreOrderPaymentGroup.setVersion(UNSET_INT);

    return retailStoreOrderPaymentGroup;
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
		if(CARD_NUMBER_PROPERTY.equals(property)){
			changeCardNumberProperty(newValueExpr);
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
			
			
			
	protected void changeCardNumberProperty(String newValueExpr){
	
		String oldValue = getCardNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCardNumber(newValue);
		this.onChangeProperty(CARD_NUMBER_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {

		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(BIZ_ORDER_PROPERTY.equals(property)){
			return getBizOrder();
		}
		if(CARD_NUMBER_PROPERTY.equals(property)){
			return getCardNumber();
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
	public RetailStoreOrderPaymentGroup updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public RetailStoreOrderPaymentGroup orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public RetailStoreOrderPaymentGroup ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public RetailStoreOrderPaymentGroup addIdCriteria(QueryOperator operator, Object... parameters){
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
	public RetailStoreOrderPaymentGroup updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public RetailStoreOrderPaymentGroup orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public RetailStoreOrderPaymentGroup ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public RetailStoreOrderPaymentGroup addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setBizOrder(RetailStoreOrder bizOrder){RetailStoreOrder oldBizOrder = this.bizOrder;RetailStoreOrder newBizOrder = bizOrder;this.bizOrder = newBizOrder;}
	public RetailStoreOrder bizOrder(){
doLoad();
return getBizOrder();
}
	public RetailStoreOrder getBizOrder(){
		return this.bizOrder;
	}
	public RetailStoreOrderPaymentGroup updateBizOrder(RetailStoreOrder bizOrder){RetailStoreOrder oldBizOrder = this.bizOrder;RetailStoreOrder newBizOrder = bizOrder;if(!shouldReplaceBy(newBizOrder, oldBizOrder)){return this;}this.bizOrder = newBizOrder;addPropertyChange(BIZ_ORDER_PROPERTY, oldBizOrder, newBizOrder);this.changed = true;setChecked(false);return this;}
	public RetailStoreOrderPaymentGroup orderByBizOrder(boolean asc){
doAddOrderBy(BIZ_ORDER_PROPERTY, asc);
return this;
}
	public SearchCriteria createBizOrderCriteria(QueryOperator operator, Object... parameters){
return createCriteria(BIZ_ORDER_PROPERTY, operator, parameters);
}
	public RetailStoreOrderPaymentGroup ignoreBizOrderCriteria(){super.ignoreSearchProperty(BIZ_ORDER_PROPERTY);
return this;
}
	public RetailStoreOrderPaymentGroup addBizOrderCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createBizOrderCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeBizOrder(RetailStoreOrder bizOrder){
		if(bizOrder != null) { setBizOrder(bizOrder);}
	}

	
	public void clearBizOrder(){
		setBizOrder ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setCardNumber(String cardNumber){String oldCardNumber = this.cardNumber;String newCardNumber = trimString(cardNumber);this.cardNumber = newCardNumber;}
	public String cardNumber(){
doLoad();
return getCardNumber();
}
	public String getCardNumber(){
		return this.cardNumber;
	}
	public RetailStoreOrderPaymentGroup updateCardNumber(String cardNumber){String oldCardNumber = this.cardNumber;String newCardNumber = trimString(cardNumber);if(!shouldReplaceBy(newCardNumber, oldCardNumber)){return this;}this.cardNumber = newCardNumber;addPropertyChange(CARD_NUMBER_PROPERTY, oldCardNumber, newCardNumber);this.changed = true;setChecked(false);return this;}
	public RetailStoreOrderPaymentGroup orderByCardNumber(boolean asc){
doAddOrderBy(CARD_NUMBER_PROPERTY, asc);
return this;
}
	public SearchCriteria createCardNumberCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CARD_NUMBER_PROPERTY, operator, parameters);
}
	public RetailStoreOrderPaymentGroup ignoreCardNumberCriteria(){super.ignoreSearchProperty(CARD_NUMBER_PROPERTY);
return this;
}
	public RetailStoreOrderPaymentGroup addCardNumberCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCardNumberCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCardNumber(String cardNumber){
		if(cardNumber != null) { setCardNumber(cardNumber);}
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public RetailStoreOrderPaymentGroup updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public RetailStoreOrderPaymentGroup orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public RetailStoreOrderPaymentGroup ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public RetailStoreOrderPaymentGroup addVersionCriteria(QueryOperator operator, Object... parameters){
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
		appendKeyValuePair(result, CARD_NUMBER_PROPERTY, getCardNumber());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof RetailStoreOrderPaymentGroup){


			RetailStoreOrderPaymentGroup dest =(RetailStoreOrderPaymentGroup)baseDest;

			dest.setId(getId());
			dest.setName(getName());
			dest.setBizOrder(getBizOrder());
			dest.setCardNumber(getCardNumber());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof RetailStoreOrderPaymentGroup){


			RetailStoreOrderPaymentGroup dest =(RetailStoreOrderPaymentGroup)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeBizOrder(getBizOrder());
			dest.mergeCardNumber(getCardNumber());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof RetailStoreOrderPaymentGroup){


			RetailStoreOrderPaymentGroup dest =(RetailStoreOrderPaymentGroup)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCardNumber(getCardNumber());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getBizOrder(), getCardNumber(), getVersion()};
	}


	public static RetailStoreOrderPaymentGroup createWith(RetailscmUserContext userContext, ThrowingFunction<RetailStoreOrderPaymentGroup,RetailStoreOrderPaymentGroup,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<RetailStoreOrderPaymentGroup> customCreator = mapper.findCustomCreator(RetailStoreOrderPaymentGroup.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    RetailStoreOrderPaymentGroup result = new RetailStoreOrderPaymentGroup();
    result.setName(mapper.tryToGet(RetailStoreOrderPaymentGroup.class, NAME_PROPERTY, String.class,
        0, false, result.getName(), params));
    result.setBizOrder(mapper.tryToGet(RetailStoreOrderPaymentGroup.class, BIZ_ORDER_PROPERTY, RetailStoreOrder.class,
        0, true, result.getBizOrder(), params));
    result.setCardNumber(mapper.tryToGet(RetailStoreOrderPaymentGroup.class, CARD_NUMBER_PROPERTY, String.class,
        1, false, result.getCardNumber(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixRetailStoreOrderPaymentGroup(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      RetailStoreOrderPaymentGroupTokens tokens = mapper.findParamByClass(params, RetailStoreOrderPaymentGroupTokens.class);
      if (tokens == null) {
        tokens = RetailStoreOrderPaymentGroupTokens.start();
      }
      result = userContext.getManagerGroup().getRetailStoreOrderPaymentGroupManager().internalSaveRetailStoreOrderPaymentGroup(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("RetailStoreOrderPaymentGroup{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getBizOrder() != null ){
 			stringBuilder.append("\tbizOrder='RetailStoreOrder("+getBizOrder().getId()+")';");
 		}
		stringBuilder.append("\tcardNumber='"+getCardNumber()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

