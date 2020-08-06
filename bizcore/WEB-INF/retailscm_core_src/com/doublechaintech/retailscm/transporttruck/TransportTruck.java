
package com.doublechaintech.retailscm.transporttruck;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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









@JsonSerialize(using = TransportTruckSerializer.class)
public class TransportTruck extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String PLATE_NUMBER_PROPERTY          = "plateNumber"       ;
	public static final String CONTACT_NUMBER_PROPERTY        = "contactNumber"     ;
	public static final String VEHICLE_LICENSE_NUMBER_PROPERTY = "vehicleLicenseNumber";
	public static final String ENGINE_NUMBER_PROPERTY         = "engineNumber"      ;
	public static final String MAKE_DATE_PROPERTY             = "makeDate"          ;
	public static final String MILEAGE_PROPERTY               = "mileage"           ;
	public static final String BODY_COLOR_PROPERTY            = "bodyColor"         ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String TRANSPORT_TASK_LIST                      = "transportTaskList" ;

	public static final String INTERNAL_TYPE="TransportTruck";
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
	protected		String              	mPlateNumber        ;
	protected		String              	mContactNumber      ;
	protected		String              	mVehicleLicenseNumber;
	protected		String              	mEngineNumber       ;
	protected		Date                	mMakeDate           ;
	protected		String              	mMileage            ;
	protected		String              	mBodyColor          ;
	protected		TransportFleet      	mOwner              ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<TransportTask>	mTransportTaskList  ;

	
		
	public 	TransportTruck(){
		// lazy load for all the properties
	}
	public 	static TransportTruck withId(String id){
		TransportTruck transportTruck = new TransportTruck();
		transportTruck.setId(id);
		transportTruck.setVersion(Integer.MAX_VALUE);
		return transportTruck;
	}
	public 	static TransportTruck refById(String id){
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
		if(PLATE_NUMBER_PROPERTY.equals(property)){
			changePlateNumberProperty(newValueExpr);
		}
		if(CONTACT_NUMBER_PROPERTY.equals(property)){
			changeContactNumberProperty(newValueExpr);
		}
		if(VEHICLE_LICENSE_NUMBER_PROPERTY.equals(property)){
			changeVehicleLicenseNumberProperty(newValueExpr);
		}
		if(ENGINE_NUMBER_PROPERTY.equals(property)){
			changeEngineNumberProperty(newValueExpr);
		}
		if(MAKE_DATE_PROPERTY.equals(property)){
			changeMakeDateProperty(newValueExpr);
		}
		if(MILEAGE_PROPERTY.equals(property)){
			changeMileageProperty(newValueExpr);
		}
		if(BODY_COLOR_PROPERTY.equals(property)){
			changeBodyColorProperty(newValueExpr);
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
			
			
			
	protected void changePlateNumberProperty(String newValueExpr){
	
		String oldValue = getPlateNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePlateNumber(newValue);
		this.onChangeProperty(PLATE_NUMBER_PROPERTY, oldValue, newValue);
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
			
			
			
	protected void changeVehicleLicenseNumberProperty(String newValueExpr){
	
		String oldValue = getVehicleLicenseNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateVehicleLicenseNumber(newValue);
		this.onChangeProperty(VEHICLE_LICENSE_NUMBER_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeEngineNumberProperty(String newValueExpr){
	
		String oldValue = getEngineNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateEngineNumber(newValue);
		this.onChangeProperty(ENGINE_NUMBER_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeMakeDateProperty(String newValueExpr){
	
		Date oldValue = getMakeDate();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateMakeDate(newValue);
		this.onChangeProperty(MAKE_DATE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeMileageProperty(String newValueExpr){
	
		String oldValue = getMileage();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateMileage(newValue);
		this.onChangeProperty(MILEAGE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeBodyColorProperty(String newValueExpr){
	
		String oldValue = getBodyColor();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateBodyColor(newValue);
		this.onChangeProperty(BODY_COLOR_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(PLATE_NUMBER_PROPERTY.equals(property)){
			return getPlateNumber();
		}
		if(CONTACT_NUMBER_PROPERTY.equals(property)){
			return getContactNumber();
		}
		if(VEHICLE_LICENSE_NUMBER_PROPERTY.equals(property)){
			return getVehicleLicenseNumber();
		}
		if(ENGINE_NUMBER_PROPERTY.equals(property)){
			return getEngineNumber();
		}
		if(MAKE_DATE_PROPERTY.equals(property)){
			return getMakeDate();
		}
		if(MILEAGE_PROPERTY.equals(property)){
			return getMileage();
		}
		if(BODY_COLOR_PROPERTY.equals(property)){
			return getBodyColor();
		}
		if(OWNER_PROPERTY.equals(property)){
			return getOwner();
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
	public TransportTruck updateId(String id){
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
	public TransportTruck updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setPlateNumber(String plateNumber){
		this.mPlateNumber = trimString(plateNumber);;
	}
	public String getPlateNumber(){
		return this.mPlateNumber;
	}
	public TransportTruck updatePlateNumber(String plateNumber){
		this.mPlateNumber = trimString(plateNumber);;
		this.changed = true;
		return this;
	}
	public void mergePlateNumber(String plateNumber){
		if(plateNumber != null) { setPlateNumber(plateNumber);}
	}
	
	
	public void setContactNumber(String contactNumber){
		this.mContactNumber = trimString(contactNumber);;
	}
	public String getContactNumber(){
		return this.mContactNumber;
	}
	public TransportTruck updateContactNumber(String contactNumber){
		this.mContactNumber = trimString(contactNumber);;
		this.changed = true;
		return this;
	}
	public void mergeContactNumber(String contactNumber){
		if(contactNumber != null) { setContactNumber(contactNumber);}
	}
	
	
	public void setVehicleLicenseNumber(String vehicleLicenseNumber){
		this.mVehicleLicenseNumber = trimString(vehicleLicenseNumber);;
	}
	public String getVehicleLicenseNumber(){
		return this.mVehicleLicenseNumber;
	}
	public TransportTruck updateVehicleLicenseNumber(String vehicleLicenseNumber){
		this.mVehicleLicenseNumber = trimString(vehicleLicenseNumber);;
		this.changed = true;
		return this;
	}
	public void mergeVehicleLicenseNumber(String vehicleLicenseNumber){
		if(vehicleLicenseNumber != null) { setVehicleLicenseNumber(vehicleLicenseNumber);}
	}
	
	
	public void setEngineNumber(String engineNumber){
		this.mEngineNumber = trimString(engineNumber);;
	}
	public String getEngineNumber(){
		return this.mEngineNumber;
	}
	public TransportTruck updateEngineNumber(String engineNumber){
		this.mEngineNumber = trimString(engineNumber);;
		this.changed = true;
		return this;
	}
	public void mergeEngineNumber(String engineNumber){
		if(engineNumber != null) { setEngineNumber(engineNumber);}
	}
	
	
	public void setMakeDate(Date makeDate){
		this.mMakeDate = makeDate;;
	}
	public Date getMakeDate(){
		return this.mMakeDate;
	}
	public TransportTruck updateMakeDate(Date makeDate){
		this.mMakeDate = makeDate;;
		this.changed = true;
		return this;
	}
	public void mergeMakeDate(Date makeDate){
		setMakeDate(makeDate);
	}
	
	
	public void setMileage(String mileage){
		this.mMileage = trimString(mileage);;
	}
	public String getMileage(){
		return this.mMileage;
	}
	public TransportTruck updateMileage(String mileage){
		this.mMileage = trimString(mileage);;
		this.changed = true;
		return this;
	}
	public void mergeMileage(String mileage){
		if(mileage != null) { setMileage(mileage);}
	}
	
	
	public void setBodyColor(String bodyColor){
		this.mBodyColor = trimString(bodyColor);;
	}
	public String getBodyColor(){
		return this.mBodyColor;
	}
	public TransportTruck updateBodyColor(String bodyColor){
		this.mBodyColor = trimString(bodyColor);;
		this.changed = true;
		return this;
	}
	public void mergeBodyColor(String bodyColor){
		if(bodyColor != null) { setBodyColor(bodyColor);}
	}
	
	
	public void setOwner(TransportFleet owner){
		this.mOwner = owner;;
	}
	public TransportFleet getOwner(){
		return this.mOwner;
	}
	public TransportTruck updateOwner(TransportFleet owner){
		this.mOwner = owner;;
		this.changed = true;
		return this;
	}
	public void mergeOwner(TransportFleet owner){
		if(owner != null) { setOwner(owner);}
	}
	
	
	public void clearOwner(){
		setOwner ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public TransportTruck updateVersion(int version){
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
			transportTask.setTruck(this);
		}

		this.mTransportTaskList = transportTaskList;
		this.mTransportTaskList.setListInternalName (TRANSPORT_TASK_LIST );
		
	}
	
	public  void addTransportTask(TransportTask transportTask){
		transportTask.setTruck(this);
		getTransportTaskList().add(transportTask);
	}
	public  void addTransportTaskList(SmartList<TransportTask> transportTaskList){
		for( TransportTask transportTask:transportTaskList){
			transportTask.setTruck(this);
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
        // transportTask.clearTruck(); //disconnect with Truck
        transportTask.clearFromAll(); //disconnect with Truck
		
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
		transportTask.setTruck(null);
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
		appendKeyValuePair(result, PLATE_NUMBER_PROPERTY, getPlateNumber());
		appendKeyValuePair(result, CONTACT_NUMBER_PROPERTY, getContactNumber());
		appendKeyValuePair(result, VEHICLE_LICENSE_NUMBER_PROPERTY, getVehicleLicenseNumber());
		appendKeyValuePair(result, ENGINE_NUMBER_PROPERTY, getEngineNumber());
		appendKeyValuePair(result, MAKE_DATE_PROPERTY, getMakeDate());
		appendKeyValuePair(result, MILEAGE_PROPERTY, getMileage());
		appendKeyValuePair(result, BODY_COLOR_PROPERTY, getBodyColor());
		appendKeyValuePair(result, OWNER_PROPERTY, getOwner());
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
		
		
		if(baseDest instanceof TransportTruck){
		
		
			TransportTruck dest =(TransportTruck)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setPlateNumber(getPlateNumber());
			dest.setContactNumber(getContactNumber());
			dest.setVehicleLicenseNumber(getVehicleLicenseNumber());
			dest.setEngineNumber(getEngineNumber());
			dest.setMakeDate(getMakeDate());
			dest.setMileage(getMileage());
			dest.setBodyColor(getBodyColor());
			dest.setOwner(getOwner());
			dest.setVersion(getVersion());
			dest.setTransportTaskList(getTransportTaskList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TransportTruck){
		
			
			TransportTruck dest =(TransportTruck)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergePlateNumber(getPlateNumber());
			dest.mergeContactNumber(getContactNumber());
			dest.mergeVehicleLicenseNumber(getVehicleLicenseNumber());
			dest.mergeEngineNumber(getEngineNumber());
			dest.mergeMakeDate(getMakeDate());
			dest.mergeMileage(getMileage());
			dest.mergeBodyColor(getBodyColor());
			dest.mergeOwner(getOwner());
			dest.mergeVersion(getVersion());
			dest.mergeTransportTaskList(getTransportTaskList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TransportTruck){
		
			
			TransportTruck dest =(TransportTruck)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergePlateNumber(getPlateNumber());
			dest.mergeContactNumber(getContactNumber());
			dest.mergeVehicleLicenseNumber(getVehicleLicenseNumber());
			dest.mergeEngineNumber(getEngineNumber());
			dest.mergeMakeDate(getMakeDate());
			dest.mergeMileage(getMileage());
			dest.mergeBodyColor(getBodyColor());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getPlateNumber(), getContactNumber(), getVehicleLicenseNumber(), getEngineNumber(), getMakeDate(), getMileage(), getBodyColor(), getOwner(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("TransportTruck{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tplateNumber='"+getPlateNumber()+"';");
		stringBuilder.append("\tcontactNumber='"+getContactNumber()+"';");
		stringBuilder.append("\tvehicleLicenseNumber='"+getVehicleLicenseNumber()+"';");
		stringBuilder.append("\tengineNumber='"+getEngineNumber()+"';");
		stringBuilder.append("\tmakeDate='"+getMakeDate()+"';");
		stringBuilder.append("\tmileage='"+getMileage()+"';");
		stringBuilder.append("\tbodyColor='"+getBodyColor()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='TransportFleet("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

