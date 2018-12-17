
package com.doublechaintech.retailscm.supplyorderconfirmation;

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

@JsonSerialize(using = SupplyOrderConfirmationSerializer.class)
public class SupplyOrderConfirmation extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String CONFIRM_TIME_PROPERTY          = "confirmTime"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String CONSUMER_ORDER_LIST                      = "consumerOrderList" ;
	public static final String SUPPLY_ORDER_LIST                        = "supplyOrderList"   ;

	public static final String INTERNAL_TYPE="SupplyOrderConfirmation";
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
	protected		Date                	mConfirmTime        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ConsumerOrder>	mConsumerOrderList  ;
	protected		SmartList<SupplyOrder>	mSupplyOrderList    ;
	
		
	public 	SupplyOrderConfirmation(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	SupplyOrderConfirmation(String who, Date confirmTime)
	{
		setWho(who);
		setConfirmTime(confirmTime);

		this.mConsumerOrderList = new SmartList<ConsumerOrder>();
		this.mSupplyOrderList = new SmartList<SupplyOrder>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(WHO_PROPERTY.equals(property)){
			changeWhoProperty(newValueExpr);
		}
		if(CONFIRM_TIME_PROPERTY.equals(property)){
			changeConfirmTimeProperty(newValueExpr);
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
			
			
			
	protected void changeConfirmTimeProperty(String newValueExpr){
		Date oldValue = getConfirmTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateConfirmTime(newValue);
		this.onChangeProperty(CONFIRM_TIME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public SupplyOrderConfirmation updateId(String id){
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
	public SupplyOrderConfirmation updateWho(String who){
		this.mWho = trimString(who);;
		this.changed = true;
		return this;
	}
	
	
	public void setConfirmTime(Date confirmTime){
		this.mConfirmTime = confirmTime;;
	}
	public Date getConfirmTime(){
		return this.mConfirmTime;
	}
	public SupplyOrderConfirmation updateConfirmTime(Date confirmTime){
		this.mConfirmTime = confirmTime;;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public SupplyOrderConfirmation updateVersion(int version){
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
			consumerOrder.setConfirmation(this);
		}

		this.mConsumerOrderList = consumerOrderList;
		this.mConsumerOrderList.setListInternalName (CONSUMER_ORDER_LIST );
		
	}
	
	public  void addConsumerOrder(ConsumerOrder consumerOrder){
		consumerOrder.setConfirmation(this);
		getConsumerOrderList().add(consumerOrder);
	}
	public  void addConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList){
		for( ConsumerOrder consumerOrder:consumerOrderList){
			consumerOrder.setConfirmation(this);
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
        // consumerOrder.clearConfirmation(); //disconnect with Confirmation
        consumerOrder.clearFromAll(); //disconnect with Confirmation
		
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
		consumerOrder.setConfirmation(null);
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
			supplyOrder.setConfirmation(this);
		}

		this.mSupplyOrderList = supplyOrderList;
		this.mSupplyOrderList.setListInternalName (SUPPLY_ORDER_LIST );
		
	}
	
	public  void addSupplyOrder(SupplyOrder supplyOrder){
		supplyOrder.setConfirmation(this);
		getSupplyOrderList().add(supplyOrder);
	}
	public  void addSupplyOrderList(SmartList<SupplyOrder> supplyOrderList){
		for( SupplyOrder supplyOrder:supplyOrderList){
			supplyOrder.setConfirmation(this);
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
        // supplyOrder.clearConfirmation(); //disconnect with Confirmation
        supplyOrder.clearFromAll(); //disconnect with Confirmation
		
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
		supplyOrder.setConfirmation(null);
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
		appendKeyValuePair(result, CONFIRM_TIME_PROPERTY, getConfirmTime());
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
		
		
		if(baseDest instanceof SupplyOrderConfirmation){
		
		
			SupplyOrderConfirmation dest =(SupplyOrderConfirmation)baseDest;
		
			dest.setId(getId());
			dest.setWho(getWho());
			dest.setConfirmTime(getConfirmTime());
			dest.setVersion(getVersion());
			dest.setConsumerOrderList(getConsumerOrderList());
			dest.setSupplyOrderList(getSupplyOrderList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("SupplyOrderConfirmation{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tconfirmTime='"+getConfirmTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

