
package com.doublechaintech.retailscm.retailstoreorderapproval;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;

@JsonSerialize(using = RetailStoreOrderApprovalSerializer.class)
public class RetailStoreOrderApproval extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String APPROVE_TIME_PROPERTY          = "approveTime"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String RETAIL_STORE_ORDER_LIST                  = "retailStoreOrderList";

	public static final String INTERNAL_TYPE="RetailStoreOrderApproval";
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
	
	
	protected		SmartList<RetailStoreOrder>	mRetailStoreOrderList;
	
		
	public 	RetailStoreOrderApproval(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	RetailStoreOrderApproval(String who, Date approveTime)
	{
		setWho(who);
		setApproveTime(approveTime);

		this.mRetailStoreOrderList = new SmartList<RetailStoreOrder>();	
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
	public RetailStoreOrderApproval updateId(String id){
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
	public RetailStoreOrderApproval updateWho(String who){
		this.mWho = trimString(who);;
		this.changed = true;
		return this;
	}
	
	
	public void setApproveTime(Date approveTime){
		this.mApproveTime = approveTime;;
	}
	public Date getApproveTime(){
		return this.mApproveTime;
	}
	public RetailStoreOrderApproval updateApproveTime(Date approveTime){
		this.mApproveTime = approveTime;;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public RetailStoreOrderApproval updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<RetailStoreOrder> getRetailStoreOrderList(){
		if(this.mRetailStoreOrderList == null){
			this.mRetailStoreOrderList = new SmartList<RetailStoreOrder>();
			this.mRetailStoreOrderList.setListInternalName (RETAIL_STORE_ORDER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mRetailStoreOrderList;	
	}
	public  void setRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList){
		for( RetailStoreOrder retailStoreOrder:retailStoreOrderList){
			retailStoreOrder.setApproval(this);
		}

		this.mRetailStoreOrderList = retailStoreOrderList;
		this.mRetailStoreOrderList.setListInternalName (RETAIL_STORE_ORDER_LIST );
		
	}
	
	public  void addRetailStoreOrder(RetailStoreOrder retailStoreOrder){
		retailStoreOrder.setApproval(this);
		getRetailStoreOrderList().add(retailStoreOrder);
	}
	public  void addRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList){
		for( RetailStoreOrder retailStoreOrder:retailStoreOrderList){
			retailStoreOrder.setApproval(this);
		}
		getRetailStoreOrderList().addAll(retailStoreOrderList);
	}
	
	public  RetailStoreOrder removeRetailStoreOrder(RetailStoreOrder retailStoreOrderIndex){
		
		int index = getRetailStoreOrderList().indexOf(retailStoreOrderIndex);
        if(index < 0){
        	String message = "RetailStoreOrder("+retailStoreOrderIndex.getId()+") with version='"+retailStoreOrderIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RetailStoreOrder retailStoreOrder = getRetailStoreOrderList().get(index);        
        // retailStoreOrder.clearApproval(); //disconnect with Approval
        retailStoreOrder.clearFromAll(); //disconnect with Approval
		
		boolean result = getRetailStoreOrderList().planToRemove(retailStoreOrder);
        if(!result){
        	String message = "RetailStoreOrder("+retailStoreOrderIndex.getId()+") with version='"+retailStoreOrderIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return retailStoreOrder;
        
	
	}
	//断舍离
	public  void breakWithRetailStoreOrder(RetailStoreOrder retailStoreOrder){
		
		if(retailStoreOrder == null){
			return;
		}
		retailStoreOrder.setApproval(null);
		//getRetailStoreOrderList().remove();
	
	}
	
	public  boolean hasRetailStoreOrder(RetailStoreOrder retailStoreOrder){
	
		return getRetailStoreOrderList().contains(retailStoreOrder);
  
	}
	
	public void copyRetailStoreOrderFrom(RetailStoreOrder retailStoreOrder) {

		RetailStoreOrder retailStoreOrderInList = findTheRetailStoreOrder(retailStoreOrder);
		RetailStoreOrder newRetailStoreOrder = new RetailStoreOrder();
		retailStoreOrderInList.copyTo(newRetailStoreOrder);
		newRetailStoreOrder.setVersion(0);//will trigger copy
		getRetailStoreOrderList().add(newRetailStoreOrder);
		addItemToFlexiableObject(COPIED_CHILD, newRetailStoreOrder);
	}
	
	public  RetailStoreOrder findTheRetailStoreOrder(RetailStoreOrder retailStoreOrder){
		
		int index =  getRetailStoreOrderList().indexOf(retailStoreOrder);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "RetailStoreOrder("+retailStoreOrder.getId()+") with version='"+retailStoreOrder.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRetailStoreOrderList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreOrderList(){
		getRetailStoreOrderList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getRetailStoreOrderList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getRetailStoreOrderList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, WHO_PROPERTY, getWho());
		appendKeyValuePair(result, APPROVE_TIME_PROPERTY, getApproveTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, RETAIL_STORE_ORDER_LIST, getRetailStoreOrderList());
		if(!getRetailStoreOrderList().isEmpty()){
			appendKeyValuePair(result, "retailStoreOrderCount", getRetailStoreOrderList().getTotalCount());
			appendKeyValuePair(result, "retailStoreOrderCurrentPageNumber", getRetailStoreOrderList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreOrderApproval){
		
		
			RetailStoreOrderApproval dest =(RetailStoreOrderApproval)baseDest;
		
			dest.setId(getId());
			dest.setWho(getWho());
			dest.setApproveTime(getApproveTime());
			dest.setVersion(getVersion());
			dest.setRetailStoreOrderList(getRetailStoreOrderList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("RetailStoreOrderApproval{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tapproveTime='"+getApproveTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

