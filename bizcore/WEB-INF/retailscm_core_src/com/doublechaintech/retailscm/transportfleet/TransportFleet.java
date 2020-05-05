
package com.doublechaintech.retailscm.transportfleet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.transporttask.TransportTask;

@JsonSerialize(using = TransportFleetSerializer.class)
public class TransportFleet extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CONTACT_NUMBER_PROPERTY        = "contactNumber"     ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String TRANSPORT_TRUCK_LIST                     = "transportTruckList";
	public static final String TRUCK_DRIVER_LIST                        = "truckDriverList"   ;
	public static final String TRANSPORT_TASK_LIST                      = "transportTaskList" ;

	public static final String INTERNAL_TYPE="TransportFleet";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mContactNumber      ;
	protected		RetailStoreCountryCenter	mOwner              ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<TransportTruck>	mTransportTruckList ;
	protected		SmartList<TruckDriver>	mTruckDriverList    ;
	protected		SmartList<TransportTask>	mTransportTaskList  ;

	
		
	public 	TransportFleet(){
		// lazy load for all the properties
	}
	public 	static TransportFleet withId(String id){
		TransportFleet transportFleet = new TransportFleet();
		transportFleet.setId(id);
		transportFleet.setVersion(Integer.MAX_VALUE);
		return transportFleet;
	}
	public 	static TransportFleet refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setOwner( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(CONTACT_NUMBER_PROPERTY.equals(property)){
			changeContactNumberProperty(newValueExpr);
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			changeLastUpdateTimeProperty(newValueExpr);
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
			
			
			
	protected void changeContactNumberProperty(String newValueExpr){
	
		String oldValue = getContactNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateContactNumber(newValue);
		this.onChangeProperty(CONTACT_NUMBER_PROPERTY, oldValue, newValue);
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
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(CONTACT_NUMBER_PROPERTY.equals(property)){
			return getContactNumber();
		}
		if(OWNER_PROPERTY.equals(property)){
			return getOwner();
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			return getLastUpdateTime();
		}
		if(TRANSPORT_TRUCK_LIST.equals(property)){
			List<BaseEntity> list = getTransportTruckList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(TRUCK_DRIVER_LIST.equals(property)){
			List<BaseEntity> list = getTruckDriverList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(TRANSPORT_TASK_LIST.equals(property)){
			List<BaseEntity> list = getTransportTaskList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}

    		//other property not include here
		return super.propertyOf(property);
	}
    
    


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public TransportFleet updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public TransportFleet updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setContactNumber(String contactNumber){
		this.mContactNumber = trimString(contactNumber);;
	}
	public String getContactNumber(){
		return this.mContactNumber;
	}
	public TransportFleet updateContactNumber(String contactNumber){
		this.mContactNumber = trimString(contactNumber);;
		this.changed = true;
		return this;
	}
	public void mergeContactNumber(String contactNumber){
		if(contactNumber != null) { setContactNumber(contactNumber);}
	}
	
	
	public void setOwner(RetailStoreCountryCenter owner){
		this.mOwner = owner;;
	}
	public RetailStoreCountryCenter getOwner(){
		return this.mOwner;
	}
	public TransportFleet updateOwner(RetailStoreCountryCenter owner){
		this.mOwner = owner;;
		this.changed = true;
		return this;
	}
	public void mergeOwner(RetailStoreCountryCenter owner){
		if(owner != null) { setOwner(owner);}
	}
	
	
	public void clearOwner(){
		setOwner ( null );
		this.changed = true;
	}
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public TransportFleet updateLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
		this.changed = true;
		return this;
	}
	public void mergeLastUpdateTime(DateTime lastUpdateTime){
		setLastUpdateTime(lastUpdateTime);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public TransportFleet updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<TransportTruck> getTransportTruckList(){
		if(this.mTransportTruckList == null){
			this.mTransportTruckList = new SmartList<TransportTruck>();
			this.mTransportTruckList.setListInternalName (TRANSPORT_TRUCK_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTransportTruckList;	
	}
	public  void setTransportTruckList(SmartList<TransportTruck> transportTruckList){
		for( TransportTruck transportTruck:transportTruckList){
			transportTruck.setOwner(this);
		}

		this.mTransportTruckList = transportTruckList;
		this.mTransportTruckList.setListInternalName (TRANSPORT_TRUCK_LIST );
		
	}
	
	public  void addTransportTruck(TransportTruck transportTruck){
		transportTruck.setOwner(this);
		getTransportTruckList().add(transportTruck);
	}
	public  void addTransportTruckList(SmartList<TransportTruck> transportTruckList){
		for( TransportTruck transportTruck:transportTruckList){
			transportTruck.setOwner(this);
		}
		getTransportTruckList().addAll(transportTruckList);
	}
	public  void mergeTransportTruckList(SmartList<TransportTruck> transportTruckList){
		if(transportTruckList==null){
			return;
		}
		if(transportTruckList.isEmpty()){
			return;
		}
		addTransportTruckList( transportTruckList );
		
	}
	public  TransportTruck removeTransportTruck(TransportTruck transportTruckIndex){
		
		int index = getTransportTruckList().indexOf(transportTruckIndex);
        if(index < 0){
        	String message = "TransportTruck("+transportTruckIndex.getId()+") with version='"+transportTruckIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TransportTruck transportTruck = getTransportTruckList().get(index);        
        // transportTruck.clearOwner(); //disconnect with Owner
        transportTruck.clearFromAll(); //disconnect with Owner
		
		boolean result = getTransportTruckList().planToRemove(transportTruck);
        if(!result){
        	String message = "TransportTruck("+transportTruckIndex.getId()+") with version='"+transportTruckIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return transportTruck;
        
	
	}
	//断舍离
	public  void breakWithTransportTruck(TransportTruck transportTruck){
		
		if(transportTruck == null){
			return;
		}
		transportTruck.setOwner(null);
		//getTransportTruckList().remove();
	
	}
	
	public  boolean hasTransportTruck(TransportTruck transportTruck){
	
		return getTransportTruckList().contains(transportTruck);
  
	}
	
	public void copyTransportTruckFrom(TransportTruck transportTruck) {

		TransportTruck transportTruckInList = findTheTransportTruck(transportTruck);
		TransportTruck newTransportTruck = new TransportTruck();
		transportTruckInList.copyTo(newTransportTruck);
		newTransportTruck.setVersion(0);//will trigger copy
		getTransportTruckList().add(newTransportTruck);
		addItemToFlexiableObject(COPIED_CHILD, newTransportTruck);
	}
	
	public  TransportTruck findTheTransportTruck(TransportTruck transportTruck){
		
		int index =  getTransportTruckList().indexOf(transportTruck);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TransportTruck("+transportTruck.getId()+") with version='"+transportTruck.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTransportTruckList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTransportTruckList(){
		getTransportTruckList().clear();
	}
	
	
	


	public  SmartList<TruckDriver> getTruckDriverList(){
		if(this.mTruckDriverList == null){
			this.mTruckDriverList = new SmartList<TruckDriver>();
			this.mTruckDriverList.setListInternalName (TRUCK_DRIVER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTruckDriverList;	
	}
	public  void setTruckDriverList(SmartList<TruckDriver> truckDriverList){
		for( TruckDriver truckDriver:truckDriverList){
			truckDriver.setBelongsTo(this);
		}

		this.mTruckDriverList = truckDriverList;
		this.mTruckDriverList.setListInternalName (TRUCK_DRIVER_LIST );
		
	}
	
	public  void addTruckDriver(TruckDriver truckDriver){
		truckDriver.setBelongsTo(this);
		getTruckDriverList().add(truckDriver);
	}
	public  void addTruckDriverList(SmartList<TruckDriver> truckDriverList){
		for( TruckDriver truckDriver:truckDriverList){
			truckDriver.setBelongsTo(this);
		}
		getTruckDriverList().addAll(truckDriverList);
	}
	public  void mergeTruckDriverList(SmartList<TruckDriver> truckDriverList){
		if(truckDriverList==null){
			return;
		}
		if(truckDriverList.isEmpty()){
			return;
		}
		addTruckDriverList( truckDriverList );
		
	}
	public  TruckDriver removeTruckDriver(TruckDriver truckDriverIndex){
		
		int index = getTruckDriverList().indexOf(truckDriverIndex);
        if(index < 0){
        	String message = "TruckDriver("+truckDriverIndex.getId()+") with version='"+truckDriverIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TruckDriver truckDriver = getTruckDriverList().get(index);        
        // truckDriver.clearBelongsTo(); //disconnect with BelongsTo
        truckDriver.clearFromAll(); //disconnect with BelongsTo
		
		boolean result = getTruckDriverList().planToRemove(truckDriver);
        if(!result){
        	String message = "TruckDriver("+truckDriverIndex.getId()+") with version='"+truckDriverIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return truckDriver;
        
	
	}
	//断舍离
	public  void breakWithTruckDriver(TruckDriver truckDriver){
		
		if(truckDriver == null){
			return;
		}
		truckDriver.setBelongsTo(null);
		//getTruckDriverList().remove();
	
	}
	
	public  boolean hasTruckDriver(TruckDriver truckDriver){
	
		return getTruckDriverList().contains(truckDriver);
  
	}
	
	public void copyTruckDriverFrom(TruckDriver truckDriver) {

		TruckDriver truckDriverInList = findTheTruckDriver(truckDriver);
		TruckDriver newTruckDriver = new TruckDriver();
		truckDriverInList.copyTo(newTruckDriver);
		newTruckDriver.setVersion(0);//will trigger copy
		getTruckDriverList().add(newTruckDriver);
		addItemToFlexiableObject(COPIED_CHILD, newTruckDriver);
	}
	
	public  TruckDriver findTheTruckDriver(TruckDriver truckDriver){
		
		int index =  getTruckDriverList().indexOf(truckDriver);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TruckDriver("+truckDriver.getId()+") with version='"+truckDriver.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTruckDriverList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTruckDriverList(){
		getTruckDriverList().clear();
	}
	
	
	


	public  SmartList<TransportTask> getTransportTaskList(){
		if(this.mTransportTaskList == null){
			this.mTransportTaskList = new SmartList<TransportTask>();
			this.mTransportTaskList.setListInternalName (TRANSPORT_TASK_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTransportTaskList;	
	}
	public  void setTransportTaskList(SmartList<TransportTask> transportTaskList){
		for( TransportTask transportTask:transportTaskList){
			transportTask.setBelongsTo(this);
		}

		this.mTransportTaskList = transportTaskList;
		this.mTransportTaskList.setListInternalName (TRANSPORT_TASK_LIST );
		
	}
	
	public  void addTransportTask(TransportTask transportTask){
		transportTask.setBelongsTo(this);
		getTransportTaskList().add(transportTask);
	}
	public  void addTransportTaskList(SmartList<TransportTask> transportTaskList){
		for( TransportTask transportTask:transportTaskList){
			transportTask.setBelongsTo(this);
		}
		getTransportTaskList().addAll(transportTaskList);
	}
	public  void mergeTransportTaskList(SmartList<TransportTask> transportTaskList){
		if(transportTaskList==null){
			return;
		}
		if(transportTaskList.isEmpty()){
			return;
		}
		addTransportTaskList( transportTaskList );
		
	}
	public  TransportTask removeTransportTask(TransportTask transportTaskIndex){
		
		int index = getTransportTaskList().indexOf(transportTaskIndex);
        if(index < 0){
        	String message = "TransportTask("+transportTaskIndex.getId()+") with version='"+transportTaskIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TransportTask transportTask = getTransportTaskList().get(index);        
        // transportTask.clearBelongsTo(); //disconnect with BelongsTo
        transportTask.clearFromAll(); //disconnect with BelongsTo
		
		boolean result = getTransportTaskList().planToRemove(transportTask);
        if(!result){
        	String message = "TransportTask("+transportTaskIndex.getId()+") with version='"+transportTaskIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return transportTask;
        
	
	}
	//断舍离
	public  void breakWithTransportTask(TransportTask transportTask){
		
		if(transportTask == null){
			return;
		}
		transportTask.setBelongsTo(null);
		//getTransportTaskList().remove();
	
	}
	
	public  boolean hasTransportTask(TransportTask transportTask){
	
		return getTransportTaskList().contains(transportTask);
  
	}
	
	public void copyTransportTaskFrom(TransportTask transportTask) {

		TransportTask transportTaskInList = findTheTransportTask(transportTask);
		TransportTask newTransportTask = new TransportTask();
		transportTaskInList.copyTo(newTransportTask);
		newTransportTask.setVersion(0);//will trigger copy
		getTransportTaskList().add(newTransportTask);
		addItemToFlexiableObject(COPIED_CHILD, newTransportTask);
	}
	
	public  TransportTask findTheTransportTask(TransportTask transportTask){
		
		int index =  getTransportTaskList().indexOf(transportTask);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TransportTask("+transportTask.getId()+") with version='"+transportTask.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTransportTaskList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTransportTaskList(){
		getTransportTaskList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getOwner(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getTransportTruckList(), internalType);
		collectFromList(this, entityList, getTruckDriverList(), internalType);
		collectFromList(this, entityList, getTransportTaskList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getTransportTruckList());
		listOfList.add( getTruckDriverList());
		listOfList.add( getTransportTaskList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, CONTACT_NUMBER_PROPERTY, getContactNumber());
		appendKeyValuePair(result, OWNER_PROPERTY, getOwner());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, TRANSPORT_TRUCK_LIST, getTransportTruckList());
		if(!getTransportTruckList().isEmpty()){
			appendKeyValuePair(result, "transportTruckCount", getTransportTruckList().getTotalCount());
			appendKeyValuePair(result, "transportTruckCurrentPageNumber", getTransportTruckList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TRUCK_DRIVER_LIST, getTruckDriverList());
		if(!getTruckDriverList().isEmpty()){
			appendKeyValuePair(result, "truckDriverCount", getTruckDriverList().getTotalCount());
			appendKeyValuePair(result, "truckDriverCurrentPageNumber", getTruckDriverList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TRANSPORT_TASK_LIST, getTransportTaskList());
		if(!getTransportTaskList().isEmpty()){
			appendKeyValuePair(result, "transportTaskCount", getTransportTaskList().getTotalCount());
			appendKeyValuePair(result, "transportTaskCurrentPageNumber", getTransportTaskList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TransportFleet){
		
		
			TransportFleet dest =(TransportFleet)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setContactNumber(getContactNumber());
			dest.setOwner(getOwner());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setTransportTruckList(getTransportTruckList());
			dest.setTruckDriverList(getTruckDriverList());
			dest.setTransportTaskList(getTransportTaskList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TransportFleet){
		
			
			TransportFleet dest =(TransportFleet)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeContactNumber(getContactNumber());
			dest.mergeOwner(getOwner());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());
			dest.mergeTransportTruckList(getTransportTruckList());
			dest.mergeTruckDriverList(getTruckDriverList());
			dest.mergeTransportTaskList(getTransportTaskList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TransportFleet){
		
			
			TransportFleet dest =(TransportFleet)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeContactNumber(getContactNumber());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getContactNumber(), getOwner(), getLastUpdateTime(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("TransportFleet{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcontactNumber='"+getContactNumber()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='RetailStoreCountryCenter("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

