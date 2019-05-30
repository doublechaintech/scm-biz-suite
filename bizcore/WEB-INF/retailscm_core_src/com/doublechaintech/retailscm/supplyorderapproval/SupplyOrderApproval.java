
package com.doublechaintech.retailscm.supplyorderapproval;

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

@JsonSerialize(using = SupplyOrderApprovalSerializer.class)
public class SupplyOrderApproval extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String APPROVE_TIME_PROPERTY          = "approveTime"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String CONSUMER_ORDER_LIST                      = "consumerOrderList" ;
	public static final String SUPPLY_ORDER_LIST                        = "supplyOrderList"   ;

	public static final String INTERNAL_TYPE="SupplyOrderApproval";
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
	protected		Date                	mApproveTime        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ConsumerOrder>	mConsumerOrderList  ;
	protected		SmartList<SupplyOrder>	mSupplyOrderList    ;
	
		
	public 	SupplyOrderApproval(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	SupplyOrderApproval(String who, Date approveTime)
	{
		setWho(who);
		setApproveTime(approveTime);

		this.mConsumerOrderList = new SmartList<ConsumerOrder>();
		this.mSupplyOrderList = new SmartList<SupplyOrder>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(WHO_PROPERTY.equals(property)){
			changeWhoProperty(newValueExpr);
		}
		if(APPROVE_TIME_PROPERTY.equals(property)){
			changeApproveTimeProperty(newValueExpr);
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
			
			
			
	protected void changeApproveTimeProperty(String newValueExpr){
		Date oldValue = getApproveTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateApproveTime(newValue);
		this.onChangeProperty(APPROVE_TIME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public SupplyOrderApproval updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setWho(String who){
		this.mWho = trimString(who);;
	}
	public String getWho(){
		return this.mWho;
	}
	public SupplyOrderApproval updateWho(String who){
		this.mWho = trimString(who);;
		this.changed = true;
		return this;
	}
	public void mergeWho(String who){
		if(who != null) { setWho(who);}
	}
	
	
	public void setApproveTime(Date approveTime){
		this.mApproveTime = approveTime;;
	}
	public Date getApproveTime(){
		return this.mApproveTime;
	}
	public SupplyOrderApproval updateApproveTime(Date approveTime){
		this.mApproveTime = approveTime;;
		this.changed = true;
		return this;
	}
	public void mergeApproveTime(Date approveTime){
		setApproveTime(approveTime);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public SupplyOrderApproval updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
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
			consumerOrder.setApproval(this);
		}

		this.mConsumerOrderList = consumerOrderList;
		this.mConsumerOrderList.setListInternalName (CONSUMER_ORDER_LIST );
		
	}
	
	public  void addConsumerOrder(ConsumerOrder consumerOrder){
		consumerOrder.setApproval(this);
		getConsumerOrderList().add(consumerOrder);
	}
	public  void addConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList){
		for( ConsumerOrder consumerOrder:consumerOrderList){
			consumerOrder.setApproval(this);
		}
		getConsumerOrderList().addAll(consumerOrderList);
	}
	public  void mergeConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList){
		if(consumerOrderList==null){
			return;
		}
		if(consumerOrderList.isEmpty()){
			return;
		}
		addConsumerOrderList( consumerOrderList );
		
	}
	public  ConsumerOrder removeConsumerOrder(ConsumerOrder consumerOrderIndex){
		
		int index = getConsumerOrderList().indexOf(consumerOrderIndex);
        if(index < 0){
        	String message = "ConsumerOrder("+consumerOrderIndex.getId()+") with version='"+consumerOrderIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ConsumerOrder consumerOrder = getConsumerOrderList().get(index);        
        // consumerOrder.clearApproval(); //disconnect with Approval
        consumerOrder.clearFromAll(); //disconnect with Approval
		
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
		consumerOrder.setApproval(null);
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
			supplyOrder.setApproval(this);
		}

		this.mSupplyOrderList = supplyOrderList;
		this.mSupplyOrderList.setListInternalName (SUPPLY_ORDER_LIST );
		
	}
	
	public  void addSupplyOrder(SupplyOrder supplyOrder){
		supplyOrder.setApproval(this);
		getSupplyOrderList().add(supplyOrder);
	}
	public  void addSupplyOrderList(SmartList<SupplyOrder> supplyOrderList){
		for( SupplyOrder supplyOrder:supplyOrderList){
			supplyOrder.setApproval(this);
		}
		getSupplyOrderList().addAll(supplyOrderList);
	}
	public  void mergeSupplyOrderList(SmartList<SupplyOrder> supplyOrderList){
		if(supplyOrderList==null){
			return;
		}
		if(supplyOrderList.isEmpty()){
			return;
		}
		addSupplyOrderList( supplyOrderList );
		
	}
	public  SupplyOrder removeSupplyOrder(SupplyOrder supplyOrderIndex){
		
		int index = getSupplyOrderList().indexOf(supplyOrderIndex);
        if(index < 0){
        	String message = "SupplyOrder("+supplyOrderIndex.getId()+") with version='"+supplyOrderIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        SupplyOrder supplyOrder = getSupplyOrderList().get(index);        
        // supplyOrder.clearApproval(); //disconnect with Approval
        supplyOrder.clearFromAll(); //disconnect with Approval
		
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
		supplyOrder.setApproval(null);
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
		appendKeyValuePair(result, APPROVE_TIME_PROPERTY, getApproveTime());
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
		
		
		if(baseDest instanceof SupplyOrderApproval){
		
		
			SupplyOrderApproval dest =(SupplyOrderApproval)baseDest;
		
			dest.setId(getId());
			dest.setWho(getWho());
			dest.setApproveTime(getApproveTime());
			dest.setVersion(getVersion());
			dest.setConsumerOrderList(getConsumerOrderList());
			dest.setSupplyOrderList(getSupplyOrderList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SupplyOrderApproval){
		
			
			SupplyOrderApproval dest =(SupplyOrderApproval)baseDest;
		
			dest.mergeId(getId());
			dest.mergeWho(getWho());
			dest.mergeApproveTime(getApproveTime());
			dest.mergeVersion(getVersion());
			dest.mergeConsumerOrderList(getConsumerOrderList());
			dest.mergeSupplyOrderList(getSupplyOrderList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("SupplyOrderApproval{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tapproveTime='"+getApproveTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}
