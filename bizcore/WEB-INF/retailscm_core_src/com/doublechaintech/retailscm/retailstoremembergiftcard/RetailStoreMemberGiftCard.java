
package com.doublechaintech.retailscm.retailstoremembergiftcard;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;









@JsonSerialize(using = RetailStoreMemberGiftCardSerializer.class)
public class RetailStoreMemberGiftCard extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String NUMBER_PROPERTY                = "number"            ;
	public static final String REMAIN_PROPERTY                = "remain"            ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST = "retailStoreMemberGiftCardConsumeRecordList";

	public static final String INTERNAL_TYPE="RetailStoreMemberGiftCard";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(OWNER_PROPERTY, "retail_store_member", "业主")
        .withType("retail_store_member", RetailStoreMember.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NUMBER_PROPERTY, "number", "数")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(REMAIN_PROPERTY, "remain", "保持")
        .withType("money", "BigDecimal"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST, "owner", "零售会员礼品卡消费记录列表")
        .withType("retail_store_member_gift_card_consume_record", RetailStoreMemberGiftCardConsumeRecord.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,OWNER_PROPERTY ,NUMBER_PROPERTY ,REMAIN_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST, "owner");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST, RetailStoreMemberGiftCardConsumeRecord.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(OWNER_PROPERTY, RetailStoreMember.class);

    return parents;
  }

  public RetailStoreMemberGiftCard want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public RetailStoreMemberGiftCard wants(Class<? extends BaseEntity>... classes) {
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
	protected		RetailStoreMember   	owner               ;
	protected		String              	number              ;
	protected		BigDecimal          	remain              ;
	protected		int                 	version             ;

	
	protected		SmartList<RetailStoreMemberGiftCardConsumeRecord>	mRetailStoreMemberGiftCardConsumeRecordList;



	public 	RetailStoreMemberGiftCard(){
		// lazy load for all the properties
	}
	public 	static RetailStoreMemberGiftCard withId(String id){
		RetailStoreMemberGiftCard retailStoreMemberGiftCard = new RetailStoreMemberGiftCard();
		retailStoreMemberGiftCard.setId(id);
		retailStoreMemberGiftCard.setVersion(Integer.MAX_VALUE);
		retailStoreMemberGiftCard.setChecked(true);
		return retailStoreMemberGiftCard;
	}
	public 	static RetailStoreMemberGiftCard refById(String id){
		return withId(id);
	}

  public RetailStoreMemberGiftCard limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public RetailStoreMemberGiftCard limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static RetailStoreMemberGiftCard searchExample(){
    RetailStoreMemberGiftCard retailStoreMemberGiftCard = new RetailStoreMemberGiftCard();
    		retailStoreMemberGiftCard.setVersion(UNSET_INT);

    return retailStoreMemberGiftCard;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setOwner( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(NUMBER_PROPERTY.equals(property)){
			changeNumberProperty(newValueExpr);
		}
		if(REMAIN_PROPERTY.equals(property)){
			changeRemainProperty(newValueExpr);
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
			
			
			
	protected void changeRemainProperty(String newValueExpr){
	
		BigDecimal oldValue = getRemain();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateRemain(newValue);
		this.onChangeProperty(REMAIN_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {

		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(OWNER_PROPERTY.equals(property)){
			return getOwner();
		}
		if(NUMBER_PROPERTY.equals(property)){
			return getNumber();
		}
		if(REMAIN_PROPERTY.equals(property)){
			return getRemain();
		}
		if(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST.equals(property)){
			List<BaseEntity> list = getRetailStoreMemberGiftCardConsumeRecordList().stream().map(item->item).collect(Collectors.toList());
			return list;
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
	public RetailStoreMemberGiftCard updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public RetailStoreMemberGiftCard orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public RetailStoreMemberGiftCard ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public RetailStoreMemberGiftCard addIdCriteria(QueryOperator operator, Object... parameters){
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
	public RetailStoreMemberGiftCard updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public RetailStoreMemberGiftCard orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public RetailStoreMemberGiftCard ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public RetailStoreMemberGiftCard addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setOwner(RetailStoreMember owner){RetailStoreMember oldOwner = this.owner;RetailStoreMember newOwner = owner;this.owner = newOwner;}
	public RetailStoreMember owner(){
doLoad();
return getOwner();
}
	public RetailStoreMember getOwner(){
		return this.owner;
	}
	public RetailStoreMemberGiftCard updateOwner(RetailStoreMember owner){RetailStoreMember oldOwner = this.owner;RetailStoreMember newOwner = owner;if(!shouldReplaceBy(newOwner, oldOwner)){return this;}this.owner = newOwner;addPropertyChange(OWNER_PROPERTY, oldOwner, newOwner);this.changed = true;setChecked(false);return this;}
	public RetailStoreMemberGiftCard orderByOwner(boolean asc){
doAddOrderBy(OWNER_PROPERTY, asc);
return this;
}
	public SearchCriteria createOwnerCriteria(QueryOperator operator, Object... parameters){
return createCriteria(OWNER_PROPERTY, operator, parameters);
}
	public RetailStoreMemberGiftCard ignoreOwnerCriteria(){super.ignoreSearchProperty(OWNER_PROPERTY);
return this;
}
	public RetailStoreMemberGiftCard addOwnerCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createOwnerCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeOwner(RetailStoreMember owner){
		if(owner != null) { setOwner(owner);}
	}

	
	public void clearOwner(){
		setOwner ( null );
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
	public RetailStoreMemberGiftCard updateNumber(String number){String oldNumber = this.number;String newNumber = trimString(number);if(!shouldReplaceBy(newNumber, oldNumber)){return this;}this.number = newNumber;addPropertyChange(NUMBER_PROPERTY, oldNumber, newNumber);this.changed = true;setChecked(false);return this;}
	public RetailStoreMemberGiftCard orderByNumber(boolean asc){
doAddOrderBy(NUMBER_PROPERTY, asc);
return this;
}
	public SearchCriteria createNumberCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NUMBER_PROPERTY, operator, parameters);
}
	public RetailStoreMemberGiftCard ignoreNumberCriteria(){super.ignoreSearchProperty(NUMBER_PROPERTY);
return this;
}
	public RetailStoreMemberGiftCard addNumberCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNumberCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeNumber(String number){
		if(number != null) { setNumber(number);}
	}

	
	public void setRemain(BigDecimal remain){BigDecimal oldRemain = this.remain;BigDecimal newRemain = remain;this.remain = newRemain;}
	public BigDecimal remain(){
doLoad();
return getRemain();
}
	public BigDecimal getRemain(){
		return this.remain;
	}
	public RetailStoreMemberGiftCard updateRemain(BigDecimal remain){BigDecimal oldRemain = this.remain;BigDecimal newRemain = remain;if(!shouldReplaceBy(newRemain, oldRemain)){return this;}this.remain = newRemain;addPropertyChange(REMAIN_PROPERTY, oldRemain, newRemain);this.changed = true;setChecked(false);return this;}
	public RetailStoreMemberGiftCard orderByRemain(boolean asc){
doAddOrderBy(REMAIN_PROPERTY, asc);
return this;
}
	public SearchCriteria createRemainCriteria(QueryOperator operator, Object... parameters){
return createCriteria(REMAIN_PROPERTY, operator, parameters);
}
	public RetailStoreMemberGiftCard ignoreRemainCriteria(){super.ignoreSearchProperty(REMAIN_PROPERTY);
return this;
}
	public RetailStoreMemberGiftCard addRemainCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createRemainCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeRemain(BigDecimal remain){
		setRemain(remain);
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public RetailStoreMemberGiftCard updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public RetailStoreMemberGiftCard orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public RetailStoreMemberGiftCard ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public RetailStoreMemberGiftCard addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public  SmartList<RetailStoreMemberGiftCardConsumeRecord> getRetailStoreMemberGiftCardConsumeRecordList(){
		if(this.mRetailStoreMemberGiftCardConsumeRecordList == null){
			this.mRetailStoreMemberGiftCardConsumeRecordList = new SmartList<RetailStoreMemberGiftCardConsumeRecord>();
			this.mRetailStoreMemberGiftCardConsumeRecordList.setListInternalName (RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST );
			//有名字，便于做权限控制
		}

		return this.mRetailStoreMemberGiftCardConsumeRecordList;
	}

  public  SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList(){
    
    doLoadChild(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST);
    
    return getRetailStoreMemberGiftCardConsumeRecordList();
  }


	public  void setRetailStoreMemberGiftCardConsumeRecordList(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList){
		for( RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord:retailStoreMemberGiftCardConsumeRecordList){
			retailStoreMemberGiftCardConsumeRecord.setOwner(this);
		}

		this.mRetailStoreMemberGiftCardConsumeRecordList = retailStoreMemberGiftCardConsumeRecordList;
		this.mRetailStoreMemberGiftCardConsumeRecordList.setListInternalName (RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST );

	}

	public  RetailStoreMemberGiftCard addRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){
		retailStoreMemberGiftCardConsumeRecord.setOwner(this);
		getRetailStoreMemberGiftCardConsumeRecordList().add(retailStoreMemberGiftCardConsumeRecord);
		return this;
	}
	public  RetailStoreMemberGiftCard addRetailStoreMemberGiftCardConsumeRecordList(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList){
		for( RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord:retailStoreMemberGiftCardConsumeRecordList){
			retailStoreMemberGiftCardConsumeRecord.setOwner(this);
		}
		getRetailStoreMemberGiftCardConsumeRecordList().addAll(retailStoreMemberGiftCardConsumeRecordList);
		return this;
	}
	public  void mergeRetailStoreMemberGiftCardConsumeRecordList(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList){
		if(retailStoreMemberGiftCardConsumeRecordList==null){
			return;
		}
		if(retailStoreMemberGiftCardConsumeRecordList.isEmpty()){
			return;
		}
		addRetailStoreMemberGiftCardConsumeRecordList( retailStoreMemberGiftCardConsumeRecordList );

	}
	public  RetailStoreMemberGiftCardConsumeRecord removeRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecordIndex){

		int index = getRetailStoreMemberGiftCardConsumeRecordList().indexOf(retailStoreMemberGiftCardConsumeRecordIndex);
        if(index < 0){
        	String message = "RetailStoreMemberGiftCardConsumeRecord("+retailStoreMemberGiftCardConsumeRecordIndex.getId()+") with version='"+retailStoreMemberGiftCardConsumeRecordIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = getRetailStoreMemberGiftCardConsumeRecordList().get(index);
        // retailStoreMemberGiftCardConsumeRecord.clearOwner(); //disconnect with Owner
        retailStoreMemberGiftCardConsumeRecord.clearFromAll(); //disconnect with Owner

		boolean result = getRetailStoreMemberGiftCardConsumeRecordList().planToRemove(retailStoreMemberGiftCardConsumeRecord);
        if(!result){
        	String message = "RetailStoreMemberGiftCardConsumeRecord("+retailStoreMemberGiftCardConsumeRecordIndex.getId()+") with version='"+retailStoreMemberGiftCardConsumeRecordIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return retailStoreMemberGiftCardConsumeRecord;


	}
	//断舍离
	public  void breakWithRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){

		if(retailStoreMemberGiftCardConsumeRecord == null){
			return;
		}
		retailStoreMemberGiftCardConsumeRecord.setOwner(null);
		//getRetailStoreMemberGiftCardConsumeRecordList().remove();

	}

	public  boolean hasRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){

		return getRetailStoreMemberGiftCardConsumeRecordList().contains(retailStoreMemberGiftCardConsumeRecord);

	}

	public void copyRetailStoreMemberGiftCardConsumeRecordFrom(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord) {

		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecordInList = findTheRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecord);
		RetailStoreMemberGiftCardConsumeRecord newRetailStoreMemberGiftCardConsumeRecord = new RetailStoreMemberGiftCardConsumeRecord();
		retailStoreMemberGiftCardConsumeRecordInList.copyTo(newRetailStoreMemberGiftCardConsumeRecord);
		newRetailStoreMemberGiftCardConsumeRecord.setVersion(0);//will trigger copy
		getRetailStoreMemberGiftCardConsumeRecordList().add(newRetailStoreMemberGiftCardConsumeRecord);
		addItemToFlexiableObject(COPIED_CHILD, newRetailStoreMemberGiftCardConsumeRecord);
	}

	public  RetailStoreMemberGiftCardConsumeRecord findTheRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){

		int index =  getRetailStoreMemberGiftCardConsumeRecordList().indexOf(retailStoreMemberGiftCardConsumeRecord);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "RetailStoreMemberGiftCardConsumeRecord("+retailStoreMemberGiftCardConsumeRecord.getId()+") with version='"+retailStoreMemberGiftCardConsumeRecord.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getRetailStoreMemberGiftCardConsumeRecordList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpRetailStoreMemberGiftCardConsumeRecordList(){
		getRetailStoreMemberGiftCardConsumeRecordList().clear();
	}





	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getOwner(), internalType);


	}

	public List<BaseEntity>  collectRefercencesFromLists(String internalType){

		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getRetailStoreMemberGiftCardConsumeRecordList(), internalType);

		return entityList;
	}

	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

		listOfList.add( getRetailStoreMemberGiftCardConsumeRecordList());


		return listOfList;
	}


	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, OWNER_PROPERTY, getOwner());
		appendKeyValuePair(result, NUMBER_PROPERTY, getNumber());
		appendKeyValuePair(result, REMAIN_PROPERTY, getRemain());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST, getRetailStoreMemberGiftCardConsumeRecordList());
		if(!getRetailStoreMemberGiftCardConsumeRecordList().isEmpty()){
			appendKeyValuePair(result, "retailStoreMemberGiftCardConsumeRecordCount", getRetailStoreMemberGiftCardConsumeRecordList().getTotalCount());
			appendKeyValuePair(result, "retailStoreMemberGiftCardConsumeRecordCurrentPageNumber", getRetailStoreMemberGiftCardConsumeRecordList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof RetailStoreMemberGiftCard){


			RetailStoreMemberGiftCard dest =(RetailStoreMemberGiftCard)baseDest;

			dest.setId(getId());
			dest.setName(getName());
			dest.setOwner(getOwner());
			dest.setNumber(getNumber());
			dest.setRemain(getRemain());
			dest.setVersion(getVersion());
			dest.setRetailStoreMemberGiftCardConsumeRecordList(getRetailStoreMemberGiftCardConsumeRecordList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof RetailStoreMemberGiftCard){


			RetailStoreMemberGiftCard dest =(RetailStoreMemberGiftCard)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeOwner(getOwner());
			dest.mergeNumber(getNumber());
			dest.mergeRemain(getRemain());
			dest.mergeVersion(getVersion());
			dest.mergeRetailStoreMemberGiftCardConsumeRecordList(getRetailStoreMemberGiftCardConsumeRecordList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof RetailStoreMemberGiftCard){


			RetailStoreMemberGiftCard dest =(RetailStoreMemberGiftCard)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeNumber(getNumber());
			dest.mergeRemain(getRemain());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getOwner(), getNumber(), getRemain(), getVersion()};
	}


	public static RetailStoreMemberGiftCard createWith(RetailscmUserContext userContext, ThrowingFunction<RetailStoreMemberGiftCard,RetailStoreMemberGiftCard,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<RetailStoreMemberGiftCard> customCreator = mapper.findCustomCreator(RetailStoreMemberGiftCard.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    RetailStoreMemberGiftCard result = new RetailStoreMemberGiftCard();
    result.setName(mapper.tryToGet(RetailStoreMemberGiftCard.class, NAME_PROPERTY, String.class,
        0, false, result.getName(), params));
    result.setOwner(mapper.tryToGet(RetailStoreMemberGiftCard.class, OWNER_PROPERTY, RetailStoreMember.class,
        0, true, result.getOwner(), params));
    result.setNumber(mapper.tryToGet(RetailStoreMemberGiftCard.class, NUMBER_PROPERTY, String.class,
        1, false, result.getNumber(), params));
    result.setRemain(mapper.tryToGet(RetailStoreMemberGiftCard.class, REMAIN_PROPERTY, BigDecimal.class,
        0, true, result.getRemain(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixRetailStoreMemberGiftCard(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      RetailStoreMemberGiftCardTokens tokens = mapper.findParamByClass(params, RetailStoreMemberGiftCardTokens.class);
      if (tokens == null) {
        tokens = RetailStoreMemberGiftCardTokens.start();
      }
      result = userContext.getManagerGroup().getRetailStoreMemberGiftCardManager().internalSaveRetailStoreMemberGiftCard(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("RetailStoreMemberGiftCard{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='RetailStoreMember("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tnumber='"+getNumber()+"';");
		stringBuilder.append("\tremain='"+getRemain()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

