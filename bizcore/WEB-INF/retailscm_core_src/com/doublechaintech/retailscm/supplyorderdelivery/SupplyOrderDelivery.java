
package com.doublechaintech.retailscm.supplyorderdelivery;

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
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;

@JsonSerialize(using = SupplyOrderDeliverySerializer.class)
public class SupplyOrderDelivery extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String DELIVERY_TIME_PROPERTY         = "deliveryTime"      ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String CONSUMER_ORDER_LIST                      = "consumerOrderList" ;
	public static final String SUPPLY_ORDER_LIST                        = "supplyOrderList"   ;

	public static final String INTERNAL_TYPE="SupplyOrderDelivery";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getWho();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mWho                ;
	protected		Date                	mDeliveryTime       ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ConsumerOrder>	mConsumerOrderList  ;
	protected		SmartList<SupplyOrder>	mSupplyOrderList    ;
	
		
	public 	SupplyOrderDelivery(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	SupplyOrderDelivery(String who, Date deliveryTime)
	{
		setWho(who);
		setDeliveryTime(deliveryTime);

		this.mConsumerOrderList = new SmartList<ConsumerOrder>();
		this.mSupplyOrderList = new SmartList<SupplyOrder>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(WHO_PROPERTY.equals(property)){
			changeWhoProperty(newValueExpr);
		}
		if(DELIVERY_TIME_PROPERTY.equals(property)){
			changeDeliveryTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeWhoProperty(String newValueExpr){
		String oldValue = getWho();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateWho(newValue);
		this.onChangeProperty(WHO_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeDeliveryTimeProperty(String newValueExpr){
		Date oldValue = getDeliveryTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDeliveryTime(newValue);
		this.onChangeProperty(DELIVERY_TIME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public SupplyOrderDelivery updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setWho(String who){
		this.mWho = trimString(who);;
	}
	public String getWho(){
		return this.mWho;
	}
	public SupplyOrderDelivery updateWho(String who){
		this.mWho = trimString(who);;
		this.changed = true;
		return this;
	}
	
	
	public void setDeliveryTime(Date deliveryTime){
		this.mDeliveryTime = deliveryTime;;
	}
	public Date getDeliveryTime(){
		return this.mDeliveryTime;
	}
	public SupplyOrderDelivery updateDeliveryTime(Date deliveryTime){
		this.mDeliveryTime = deliveryTime;;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public SupplyOrderDelivery updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<ConsumerOrder> getConsumerOrderList(){
		if(this.mConsumerOrderList == null){
			this.mConsumerOrderList = new SmartList<ConsumerOrder>();
			this.mConsumerOrderList.setListInternalName (CONSUMER_ORDER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mConsumerOrderList;	
	}
	public  void setConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList){
		for( ConsumerOrder consumerOrder:consumerOrderList){
			consumerOrder.setDelivery(this);
		}

		this.mConsumerOrderList = consumerOrderList;
		this.mConsumerOrderList.setListInternalName (CONSUMER_ORDER_LIST );
		
	}
	
	public  void addConsumerOrder(ConsumerOrder consumerOrder){
		consumerOrder.setDelivery(this);
		getConsumerOrderList().add(consumerOrder);
	}
	public  void addConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList){
		for( ConsumerOrder consumerOrder:consumerOrderList){
			consumerOrder.setDelivery(this);
		}
		getConsumerOrderList().addAll(consumerOrderList);
	}
	
	public  ConsumerOrder removeConsumerOrder(ConsumerOrder consumerOrderIndex){
		
		int index = getConsumerOrderList().indexOf(consumerOrderIndex);
        if(index < 0){
        	String message = "ConsumerOrder("+consumerOrderIndex.getId()+") with version='"+consumerOrderIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ConsumerOrder consumerOrder = getConsumerOrderList().get(index);        
        // consumerOrder.clearDelivery(); //disconnect with Delivery
        consumerOrder.clearFromAll(); //disconnect with Delivery
		
		boolean result = getConsumerOrderList().planToRemove(consumerOrder);
        if(!result){
        	String message = "ConsumerOrder("+consumerOrderIndex.getId()+") with version='"+consumerOrderIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return consumerOrder;
        
	
	}
	//断舍离
	public  void breakWithConsumerOrder(ConsumerOrder consumerOrder){
		
		if(consumerOrder == null){
			return;
		}
		consumerOrder.setDelivery(null);
		//getConsumerOrderList().remove();
	
	}
	
	public  boolean hasConsumerOrder(ConsumerOrder consumerOrder){
	
		return getConsumerOrderList().contains(consumerOrder);
  
	}
	
	public void copyConsumerOrderFrom(ConsumerOrder consumerOrder) {

		ConsumerOrder consumerOrderInList = findTheConsumerOrder(consumerOrder);
		ConsumerOrder newConsumerOrder = new ConsumerOrder();
		consumerOrderInList.copyTo(newConsumerOrder);
		newConsumerOrder.setVersion(0);//will trigger copy
		getConsumerOrderList().add(newConsumerOrder);
		addItemToFlexiableObject(COPIED_CHILD, newConsumerOrder);
	}
	
	public  ConsumerOrder findTheConsumerOrder(ConsumerOrder consumerOrder){
		
		int index =  getConsumerOrderList().indexOf(consumerOrder);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ConsumerOrder("+consumerOrder.getId()+") with version='"+consumerOrder.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getConsumerOrderList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpConsumerOrderList(){
		getConsumerOrderList().clear();
	}
	
	
	


	public  SmartList<SupplyOrder> getSupplyOrderList(){
		if(this.mSupplyOrderList == null){
			this.mSupplyOrderList = new SmartList<SupplyOrder>();
			this.mSupplyOrderList.setListInternalName (SUPPLY_ORDER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mSupplyOrderList;	
	}
	public  void setSupplyOrderList(SmartList<SupplyOrder> supplyOrderList){
		for( SupplyOrder supplyOrder:supplyOrderList){
			supplyOrder.setDelivery(this);
		}

		this.mSupplyOrderList = supplyOrderList;
		this.mSupplyOrderList.setListInternalName (SUPPLY_ORDER_LIST );
		
	}
	
	public  void addSupplyOrder(SupplyOrder supplyOrder){
		supplyOrder.setDelivery(this);
		getSupplyOrderList().add(supplyOrder);
	}
	public  void addSupplyOrderList(SmartList<SupplyOrder> supplyOrderList){
		for( SupplyOrder supplyOrder:supplyOrderList){
			supplyOrder.setDelivery(this);
		}
		getSupplyOrderList().addAll(supplyOrderList);
	}
	
	public  SupplyOrder removeSupplyOrder(SupplyOrder supplyOrderIndex){
		
		int index = getSupplyOrderList().indexOf(supplyOrderIndex);
        if(index < 0){
        	String message = "SupplyOrder("+supplyOrderIndex.getId()+") with version='"+supplyOrderIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        SupplyOrder supplyOrder = getSupplyOrderList().get(index);        
        // supplyOrder.clearDelivery(); //disconnect with Delivery
        supplyOrder.clearFromAll(); //disconnect with Delivery
		
		boolean result = getSupplyOrderList().planToRemove(supplyOrder);
        if(!result){
        	String message = "SupplyOrder("+supplyOrderIndex.getId()+") with version='"+supplyOrderIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return supplyOrder;
        
	
	}
	//断舍离
	public  void breakWithSupplyOrder(SupplyOrder supplyOrder){
		
		if(supplyOrder == null){
			return;
		}
		supplyOrder.setDelivery(null);
		//getSupplyOrderList().remove();
	
	}
	
	public  boolean hasSupplyOrder(SupplyOrder supplyOrder){
	
		return getSupplyOrderList().contains(supplyOrder);
  
	}
	
	public void copySupplyOrderFrom(SupplyOrder supplyOrder) {

		SupplyOrder supplyOrderInList = findTheSupplyOrder(supplyOrder);
		SupplyOrder newSupplyOrder = new SupplyOrder();
		supplyOrderInList.copyTo(newSupplyOrder);
		newSupplyOrder.setVersion(0);//will trigger copy
		getSupplyOrderList().add(newSupplyOrder);
		addItemToFlexiableObject(COPIED_CHILD, newSupplyOrder);
	}
	
	public  SupplyOrder findTheSupplyOrder(SupplyOrder supplyOrder){
		
		int index =  getSupplyOrderList().indexOf(supplyOrder);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "SupplyOrder("+supplyOrder.getId()+") with version='"+supplyOrder.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getSupplyOrderList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSupplyOrderList(){
		getSupplyOrderList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getConsumerOrderList(), internalType);
		collectFromList(this, entityList, getSupplyOrderList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getConsumerOrderList());
		listOfList.add( getSupplyOrderList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, WHO_PROPERTY, getWho());
		appendKeyValuePair(result, DELIVERY_TIME_PROPERTY, getDeliveryTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, CONSUMER_ORDER_LIST, getConsumerOrderList());
		if(!getConsumerOrderList().isEmpty()){
			appendKeyValuePair(result, "consumerOrderCount", getConsumerOrderList().getTotalCount());
			appendKeyValuePair(result, "consumerOrderCurrentPageNumber", getConsumerOrderList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, SUPPLY_ORDER_LIST, getSupplyOrderList());
		if(!getSupplyOrderList().isEmpty()){
			appendKeyValuePair(result, "supplyOrderCount", getSupplyOrderList().getTotalCount());
			appendKeyValuePair(result, "supplyOrderCurrentPageNumber", getSupplyOrderList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SupplyOrderDelivery){
		
		
			SupplyOrderDelivery dest =(SupplyOrderDelivery)baseDest;
		
			dest.setId(getId());
			dest.setWho(getWho());
			dest.setDeliveryTime(getDeliveryTime());
			dest.setVersion(getVersion());
			dest.setConsumerOrderList(getConsumerOrderList());
			dest.setSupplyOrderList(getSupplyOrderList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("SupplyOrderDelivery{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tdeliveryTime='"+getDeliveryTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

