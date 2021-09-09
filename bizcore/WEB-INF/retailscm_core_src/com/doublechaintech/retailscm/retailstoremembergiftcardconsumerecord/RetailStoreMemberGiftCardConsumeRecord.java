
package com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord;

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
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;









@JsonSerialize(using = RetailStoreMemberGiftCardConsumeRecordSerializer.class)
public class RetailStoreMemberGiftCardConsumeRecord extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String OCCURE_TIME_PROPERTY           = "occureTime"        ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String BIZ_ORDER_PROPERTY             = "bizOrder"          ;
	public static final String NUMBER_PROPERTY                = "number"            ;
	public static final String AMOUNT_PROPERTY                = "amount"            ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="RetailStoreMemberGiftCardConsumeRecord";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(OCCURE_TIME_PROPERTY, "occure_time", "发生时间")
        .withType("date_past", "Date"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(OWNER_PROPERTY, "retail_store_member_gift_card", "业主")
        .withType("retail_store_member_gift_card", RetailStoreMemberGiftCard.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(BIZ_ORDER_PROPERTY, "consumer_order", "订单")
        .withType("consumer_order", ConsumerOrder.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NUMBER_PROPERTY, "number", "数")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(AMOUNT_PROPERTY, "amount", "金额")
        .withType("money", "BigDecimal"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,OCCURE_TIME_PROPERTY ,OWNER_PROPERTY ,BIZ_ORDER_PROPERTY ,NUMBER_PROPERTY ,AMOUNT_PROPERTY ,VERSION_PROPERTY};
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
    parents.put(OWNER_PROPERTY, RetailStoreMemberGiftCard.class);
parents.put(BIZ_ORDER_PROPERTY, ConsumerOrder.class);

    return parents;
  }

  public RetailStoreMemberGiftCardConsumeRecord want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public RetailStoreMemberGiftCardConsumeRecord wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getNumber();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		Date                	occureTime          ;
	protected		RetailStoreMemberGiftCard	owner               ;
	protected		ConsumerOrder       	bizOrder            ;
	protected		String              	number              ;
	protected		BigDecimal          	amount              ;
	protected		int                 	version             ;

	



	public 	RetailStoreMemberGiftCardConsumeRecord(){
		// lazy load for all the properties
	}
	public 	static RetailStoreMemberGiftCardConsumeRecord withId(String id){
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = new RetailStoreMemberGiftCardConsumeRecord();
		retailStoreMemberGiftCardConsumeRecord.setId(id);
		retailStoreMemberGiftCardConsumeRecord.setVersion(Integer.MAX_VALUE);
		retailStoreMemberGiftCardConsumeRecord.setChecked(true);
		return retailStoreMemberGiftCardConsumeRecord;
	}
	public 	static RetailStoreMemberGiftCardConsumeRecord refById(String id){
		return withId(id);
	}

  public RetailStoreMemberGiftCardConsumeRecord limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecord limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static RetailStoreMemberGiftCardConsumeRecord searchExample(){
    RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = new RetailStoreMemberGiftCardConsumeRecord();
    		retailStoreMemberGiftCardConsumeRecord.setVersion(UNSET_INT);

    return retailStoreMemberGiftCardConsumeRecord;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setOwner( null );
		setBizOrder( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(OCCURE_TIME_PROPERTY.equals(property)){
			changeOccureTimeProperty(newValueExpr);
		}
		if(NUMBER_PROPERTY.equals(property)){
			changeNumberProperty(newValueExpr);
		}
		if(AMOUNT_PROPERTY.equals(property)){
			changeAmountProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeOccureTimeProperty(String newValueExpr){
	
		Date oldValue = getOccureTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateOccureTime(newValue);
		this.onChangeProperty(OCCURE_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeNumberProperty(String newValueExpr){
	
		String oldValue = getNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateNumber(newValue);
		this.onChangeProperty(NUMBER_PROPERTY, oldValue, newValue);
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
			
			
			


	
	public Object propertyOf(String property) {

		if(OCCURE_TIME_PROPERTY.equals(property)){
			return getOccureTime();
		}
		if(OWNER_PROPERTY.equals(property)){
			return getOwner();
		}
		if(BIZ_ORDER_PROPERTY.equals(property)){
			return getBizOrder();
		}
		if(NUMBER_PROPERTY.equals(property)){
			return getNumber();
		}
		if(AMOUNT_PROPERTY.equals(property)){
			return getAmount();
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
	public RetailStoreMemberGiftCardConsumeRecord updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public RetailStoreMemberGiftCardConsumeRecord orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public RetailStoreMemberGiftCardConsumeRecord ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public RetailStoreMemberGiftCardConsumeRecord addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setOccureTime(Date occureTime){Date oldOccureTime = this.occureTime;Date newOccureTime = occureTime;this.occureTime = newOccureTime;}
	public Date occureTime(){
doLoad();
return getOccureTime();
}
	public Date getOccureTime(){
		return this.occureTime;
	}
	public RetailStoreMemberGiftCardConsumeRecord updateOccureTime(Date occureTime){Date oldOccureTime = this.occureTime;Date newOccureTime = occureTime;if(!shouldReplaceBy(newOccureTime, oldOccureTime)){return this;}this.occureTime = newOccureTime;addPropertyChange(OCCURE_TIME_PROPERTY, oldOccureTime, newOccureTime);this.changed = true;setChecked(false);return this;}
	public RetailStoreMemberGiftCardConsumeRecord orderByOccureTime(boolean asc){
doAddOrderBy(OCCURE_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createOccureTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(OCCURE_TIME_PROPERTY, operator, parameters);
}
	public RetailStoreMemberGiftCardConsumeRecord ignoreOccureTimeCriteria(){super.ignoreSearchProperty(OCCURE_TIME_PROPERTY);
return this;
}
	public RetailStoreMemberGiftCardConsumeRecord addOccureTimeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createOccureTimeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeOccureTime(Date occureTime){
		setOccureTime(occureTime);
	}

	
	public void setOwner(RetailStoreMemberGiftCard owner){RetailStoreMemberGiftCard oldOwner = this.owner;RetailStoreMemberGiftCard newOwner = owner;this.owner = newOwner;}
	public RetailStoreMemberGiftCard owner(){
doLoad();
return getOwner();
}
	public RetailStoreMemberGiftCard getOwner(){
		return this.owner;
	}
	public RetailStoreMemberGiftCardConsumeRecord updateOwner(RetailStoreMemberGiftCard owner){RetailStoreMemberGiftCard oldOwner = this.owner;RetailStoreMemberGiftCard newOwner = owner;if(!shouldReplaceBy(newOwner, oldOwner)){return this;}this.owner = newOwner;addPropertyChange(OWNER_PROPERTY, oldOwner, newOwner);this.changed = true;setChecked(false);return this;}
	public RetailStoreMemberGiftCardConsumeRecord orderByOwner(boolean asc){
doAddOrderBy(OWNER_PROPERTY, asc);
return this;
}
	public SearchCriteria createOwnerCriteria(QueryOperator operator, Object... parameters){
return createCriteria(OWNER_PROPERTY, operator, parameters);
}
	public RetailStoreMemberGiftCardConsumeRecord ignoreOwnerCriteria(){super.ignoreSearchProperty(OWNER_PROPERTY);
return this;
}
	public RetailStoreMemberGiftCardConsumeRecord addOwnerCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createOwnerCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeOwner(RetailStoreMemberGiftCard owner){
		if(owner != null) { setOwner(owner);}
	}

	
	public void clearOwner(){
		setOwner ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setBizOrder(ConsumerOrder bizOrder){ConsumerOrder oldBizOrder = this.bizOrder;ConsumerOrder newBizOrder = bizOrder;this.bizOrder = newBizOrder;}
	public ConsumerOrder bizOrder(){
doLoad();
return getBizOrder();
}
	public ConsumerOrder getBizOrder(){
		return this.bizOrder;
	}
	public RetailStoreMemberGiftCardConsumeRecord updateBizOrder(ConsumerOrder bizOrder){ConsumerOrder oldBizOrder = this.bizOrder;ConsumerOrder newBizOrder = bizOrder;if(!shouldReplaceBy(newBizOrder, oldBizOrder)){return this;}this.bizOrder = newBizOrder;addPropertyChange(BIZ_ORDER_PROPERTY, oldBizOrder, newBizOrder);this.changed = true;setChecked(false);return this;}
	public RetailStoreMemberGiftCardConsumeRecord orderByBizOrder(boolean asc){
doAddOrderBy(BIZ_ORDER_PROPERTY, asc);
return this;
}
	public SearchCriteria createBizOrderCriteria(QueryOperator operator, Object... parameters){
return createCriteria(BIZ_ORDER_PROPERTY, operator, parameters);
}
	public RetailStoreMemberGiftCardConsumeRecord ignoreBizOrderCriteria(){super.ignoreSearchProperty(BIZ_ORDER_PROPERTY);
return this;
}
	public RetailStoreMemberGiftCardConsumeRecord addBizOrderCriteria(QueryOperator operator, Object... parameters){
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
	
	public void setNumber(String number){String oldNumber = this.number;String newNumber = trimString(number);this.number = newNumber;}
	public String number(){
doLoad();
return getNumber();
}
	public String getNumber(){
		return this.number;
	}
	public RetailStoreMemberGiftCardConsumeRecord updateNumber(String number){String oldNumber = this.number;String newNumber = trimString(number);if(!shouldReplaceBy(newNumber, oldNumber)){return this;}this.number = newNumber;addPropertyChange(NUMBER_PROPERTY, oldNumber, newNumber);this.changed = true;setChecked(false);return this;}
	public RetailStoreMemberGiftCardConsumeRecord orderByNumber(boolean asc){
doAddOrderBy(NUMBER_PROPERTY, asc);
return this;
}
	public SearchCriteria createNumberCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NUMBER_PROPERTY, operator, parameters);
}
	public RetailStoreMemberGiftCardConsumeRecord ignoreNumberCriteria(){super.ignoreSearchProperty(NUMBER_PROPERTY);
return this;
}
	public RetailStoreMemberGiftCardConsumeRecord addNumberCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNumberCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeNumber(String number){
		if(number != null) { setNumber(number);}
	}

	
	public void setAmount(BigDecimal amount){BigDecimal oldAmount = this.amount;BigDecimal newAmount = amount;this.amount = newAmount;}
	public BigDecimal amount(){
doLoad();
return getAmount();
}
	public BigDecimal getAmount(){
		return this.amount;
	}
	public RetailStoreMemberGiftCardConsumeRecord updateAmount(BigDecimal amount){BigDecimal oldAmount = this.amount;BigDecimal newAmount = amount;if(!shouldReplaceBy(newAmount, oldAmount)){return this;}this.amount = newAmount;addPropertyChange(AMOUNT_PROPERTY, oldAmount, newAmount);this.changed = true;setChecked(false);return this;}
	public RetailStoreMemberGiftCardConsumeRecord orderByAmount(boolean asc){
doAddOrderBy(AMOUNT_PROPERTY, asc);
return this;
}
	public SearchCriteria createAmountCriteria(QueryOperator operator, Object... parameters){
return createCriteria(AMOUNT_PROPERTY, operator, parameters);
}
	public RetailStoreMemberGiftCardConsumeRecord ignoreAmountCriteria(){super.ignoreSearchProperty(AMOUNT_PROPERTY);
return this;
}
	public RetailStoreMemberGiftCardConsumeRecord addAmountCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createAmountCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeAmount(BigDecimal amount){
		setAmount(amount);
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public RetailStoreMemberGiftCardConsumeRecord updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public RetailStoreMemberGiftCardConsumeRecord orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public RetailStoreMemberGiftCardConsumeRecord ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public RetailStoreMemberGiftCardConsumeRecord addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getOwner(), internalType);
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
		appendKeyValuePair(result, OCCURE_TIME_PROPERTY, getOccureTime());
		appendKeyValuePair(result, OWNER_PROPERTY, getOwner());
		appendKeyValuePair(result, BIZ_ORDER_PROPERTY, getBizOrder());
		appendKeyValuePair(result, NUMBER_PROPERTY, getNumber());
		appendKeyValuePair(result, AMOUNT_PROPERTY, getAmount());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof RetailStoreMemberGiftCardConsumeRecord){


			RetailStoreMemberGiftCardConsumeRecord dest =(RetailStoreMemberGiftCardConsumeRecord)baseDest;

			dest.setId(getId());
			dest.setOccureTime(getOccureTime());
			dest.setOwner(getOwner());
			dest.setBizOrder(getBizOrder());
			dest.setNumber(getNumber());
			dest.setAmount(getAmount());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof RetailStoreMemberGiftCardConsumeRecord){


			RetailStoreMemberGiftCardConsumeRecord dest =(RetailStoreMemberGiftCardConsumeRecord)baseDest;

			dest.mergeId(getId());
			dest.mergeOccureTime(getOccureTime());
			dest.mergeOwner(getOwner());
			dest.mergeBizOrder(getBizOrder());
			dest.mergeNumber(getNumber());
			dest.mergeAmount(getAmount());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof RetailStoreMemberGiftCardConsumeRecord){


			RetailStoreMemberGiftCardConsumeRecord dest =(RetailStoreMemberGiftCardConsumeRecord)baseDest;

			dest.mergeId(getId());
			dest.mergeOccureTime(getOccureTime());
			dest.mergeNumber(getNumber());
			dest.mergeAmount(getAmount());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getOccureTime(), getOwner(), getBizOrder(), getNumber(), getAmount(), getVersion()};
	}


	public static RetailStoreMemberGiftCardConsumeRecord createWith(RetailscmUserContext userContext, ThrowingFunction<RetailStoreMemberGiftCardConsumeRecord,RetailStoreMemberGiftCardConsumeRecord,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<RetailStoreMemberGiftCardConsumeRecord> customCreator = mapper.findCustomCreator(RetailStoreMemberGiftCardConsumeRecord.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    RetailStoreMemberGiftCardConsumeRecord result = new RetailStoreMemberGiftCardConsumeRecord();
    result.setOccureTime(mapper.tryToGet(RetailStoreMemberGiftCardConsumeRecord.class, OCCURE_TIME_PROPERTY, Date.class,
        0, true, result.getOccureTime(), params));
    result.setOwner(mapper.tryToGet(RetailStoreMemberGiftCardConsumeRecord.class, OWNER_PROPERTY, RetailStoreMemberGiftCard.class,
        0, true, result.getOwner(), params));
    result.setBizOrder(mapper.tryToGet(RetailStoreMemberGiftCardConsumeRecord.class, BIZ_ORDER_PROPERTY, ConsumerOrder.class,
        0, true, result.getBizOrder(), params));
    result.setNumber(mapper.tryToGet(RetailStoreMemberGiftCardConsumeRecord.class, NUMBER_PROPERTY, String.class,
        0, true, result.getNumber(), params));
    result.setAmount(mapper.tryToGet(RetailStoreMemberGiftCardConsumeRecord.class, AMOUNT_PROPERTY, BigDecimal.class,
        0, true, result.getAmount(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixRetailStoreMemberGiftCardConsumeRecord(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      RetailStoreMemberGiftCardConsumeRecordTokens tokens = mapper.findParamByClass(params, RetailStoreMemberGiftCardConsumeRecordTokens.class);
      if (tokens == null) {
        tokens = RetailStoreMemberGiftCardConsumeRecordTokens.start();
      }
      result = userContext.getManagerGroup().getRetailStoreMemberGiftCardConsumeRecordManager().internalSaveRetailStoreMemberGiftCardConsumeRecord(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("RetailStoreMemberGiftCardConsumeRecord{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\toccureTime='"+getOccureTime()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='RetailStoreMemberGiftCard("+getOwner().getId()+")';");
 		}
		if(getBizOrder() != null ){
 			stringBuilder.append("\tbizOrder='ConsumerOrder("+getBizOrder().getId()+")';");
 		}
		stringBuilder.append("\tnumber='"+getNumber()+"';");
		stringBuilder.append("\tamount='"+getAmount()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

