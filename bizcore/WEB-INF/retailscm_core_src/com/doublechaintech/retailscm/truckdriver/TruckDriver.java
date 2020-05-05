
package com.doublechaintech.retailscm.truckdriver;

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
import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.transporttask.TransportTask;

@JsonSerialize(using = TruckDriverSerializer.class)
public class TruckDriver extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String DRIVER_LICENSE_NUMBER_PROPERTY = "driverLicenseNumber";
	public static final String CONTACT_NUMBER_PROPERTY        = "contactNumber"     ;
	public static final String BELONGS_TO_PROPERTY            = "belongsTo"         ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String TRANSPORT_TASK_LIST                      = "transportTaskList" ;

	public static final String INTERNAL_TYPE="TruckDriver";
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
	protected		String              	mDriverLicenseNumber;
	protected		String              	mContactNumber      ;
	protected		TransportFleet      	mBelongsTo          ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<TransportTask>	mTransportTaskList  ;

	
		
	public 	TruckDriver(){
		// lazy load for all the properties
	}
	public 	static TruckDriver withId(String id){
		TruckDriver truckDriver = new TruckDriver();
		truckDriver.setId(id);
		truckDriver.setVersion(Integer.MAX_VALUE);
		return truckDriver;
	}
	public 	static TruckDriver refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setBelongsTo( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(DRIVER_LICENSE_NUMBER_PROPERTY.equals(property)){
			changeDriverLicenseNumberProperty(newValueExpr);
		}
		if(CONTACT_NUMBER_PROPERTY.equals(property)){
			changeContactNumberProperty(newValueExpr);
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
			
			
			
	protected void changeDriverLicenseNumberProperty(String newValueExpr){
	
		String oldValue = getDriverLicenseNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDriverLicenseNumber(newValue);
		this.onChangeProperty(DRIVER_LICENSE_NUMBER_PROPERTY, oldValue, newValue);
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
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(DRIVER_LICENSE_NUMBER_PROPERTY.equals(property)){
			return getDriverLicenseNumber();
		}
		if(CONTACT_NUMBER_PROPERTY.equals(property)){
			return getContactNumber();
		}
		if(BELONGS_TO_PROPERTY.equals(property)){
			return getBelongsTo();
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
	public TruckDriver updateId(String id){
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
	public TruckDriver updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setDriverLicenseNumber(String driverLicenseNumber){
		this.mDriverLicenseNumber = trimString(driverLicenseNumber);;
	}
	public String getDriverLicenseNumber(){
		return this.mDriverLicenseNumber;
	}
	public TruckDriver updateDriverLicenseNumber(String driverLicenseNumber){
		this.mDriverLicenseNumber = trimString(driverLicenseNumber);;
		this.changed = true;
		return this;
	}
	public void mergeDriverLicenseNumber(String driverLicenseNumber){
		if(driverLicenseNumber != null) { setDriverLicenseNumber(driverLicenseNumber);}
	}
	
	
	public void setContactNumber(String contactNumber){
		this.mContactNumber = trimString(contactNumber);;
	}
	public String getContactNumber(){
		return this.mContactNumber;
	}
	public TruckDriver updateContactNumber(String contactNumber){
		this.mContactNumber = trimString(contactNumber);;
		this.changed = true;
		return this;
	}
	public void mergeContactNumber(String contactNumber){
		if(contactNumber != null) { setContactNumber(contactNumber);}
	}
	
	
	
	public String getMaskedContactNumber(){
		String mobilePhoneNumber = getContactNumber();
		return maskChinaMobileNumber(mobilePhoneNumber);
	}
	
		
	public void setBelongsTo(TransportFleet belongsTo){
		this.mBelongsTo = belongsTo;;
	}
	public TransportFleet getBelongsTo(){
		return this.mBelongsTo;
	}
	public TruckDriver updateBelongsTo(TransportFleet belongsTo){
		this.mBelongsTo = belongsTo;;
		this.changed = true;
		return this;
	}
	public void mergeBelongsTo(TransportFleet belongsTo){
		if(belongsTo != null) { setBelongsTo(belongsTo);}
	}
	
	
	public void clearBelongsTo(){
		setBelongsTo ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public TruckDriver updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
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
			transportTask.setDriver(this);
		}

		this.mTransportTaskList = transportTaskList;
		this.mTransportTaskList.setListInternalName (TRANSPORT_TASK_LIST );
		
	}
	
	public  void addTransportTask(TransportTask transportTask){
		transportTask.setDriver(this);
		getTransportTaskList().add(transportTask);
	}
	public  void addTransportTaskList(SmartList<TransportTask> transportTaskList){
		for( TransportTask transportTask:transportTaskList){
			transportTask.setDriver(this);
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
        // transportTask.clearDriver(); //disconnect with Driver
        transportTask.clearFromAll(); //disconnect with Driver
		
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
		transportTask.setDriver(null);
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

		addToEntityList(this, entityList, getBelongsTo(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getTransportTaskList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getTransportTaskList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, DRIVER_LICENSE_NUMBER_PROPERTY, getDriverLicenseNumber());
		appendKeyValuePair(result, CONTACT_NUMBER_PROPERTY, getMaskedContactNumber());
		appendKeyValuePair(result, BELONGS_TO_PROPERTY, getBelongsTo());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
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
		
		
		if(baseDest instanceof TruckDriver){
		
		
			TruckDriver dest =(TruckDriver)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setDriverLicenseNumber(getDriverLicenseNumber());
			dest.setContactNumber(getContactNumber());
			dest.setBelongsTo(getBelongsTo());
			dest.setVersion(getVersion());
			dest.setTransportTaskList(getTransportTaskList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TruckDriver){
		
			
			TruckDriver dest =(TruckDriver)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeDriverLicenseNumber(getDriverLicenseNumber());
			dest.mergeContactNumber(getContactNumber());
			dest.mergeBelongsTo(getBelongsTo());
			dest.mergeVersion(getVersion());
			dest.mergeTransportTaskList(getTransportTaskList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TruckDriver){
		
			
			TruckDriver dest =(TruckDriver)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeDriverLicenseNumber(getDriverLicenseNumber());
			dest.mergeContactNumber(getContactNumber());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getDriverLicenseNumber(), getContactNumber(), getBelongsTo(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("TruckDriver{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tdriverLicenseNumber='"+getDriverLicenseNumber()+"';");
		stringBuilder.append("\tcontactNumber='"+getContactNumber()+"';");
		if(getBelongsTo() != null ){
 			stringBuilder.append("\tbelongsTo='TransportFleet("+getBelongsTo().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

