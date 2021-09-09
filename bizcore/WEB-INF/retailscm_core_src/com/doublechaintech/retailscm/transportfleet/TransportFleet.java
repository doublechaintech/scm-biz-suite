
package com.doublechaintech.retailscm.transportfleet;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
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


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CONTACT_NUMBER_PROPERTY, "contact_number", "联系电话")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(OWNER_PROPERTY, "retail_store_country_center", "业主")
        .withType("retail_store_country_center", RetailStoreCountryCenter.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
        .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(TRANSPORT_TRUCK_LIST, "owner", "运输卡车列表")
        .withType("transport_truck", TransportTruck.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(TRUCK_DRIVER_LIST, "belongsTo", "卡车司机列表")
        .withType("truck_driver", TruckDriver.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(TRANSPORT_TASK_LIST, "belongsTo", "运输任务列表")
        .withType("transport_task", TransportTask.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,CONTACT_NUMBER_PROPERTY ,OWNER_PROPERTY ,LAST_UPDATE_TIME_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(TRANSPORT_TRUCK_LIST, "owner");
    	
    	    refers.put(TRUCK_DRIVER_LIST, "belongsTo");
    	
    	    refers.put(TRANSPORT_TASK_LIST, "belongsTo");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(TRANSPORT_TRUCK_LIST, TransportTruck.class);
        	
        	    refers.put(TRUCK_DRIVER_LIST, TruckDriver.class);
        	
        	    refers.put(TRANSPORT_TASK_LIST, TransportTask.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(OWNER_PROPERTY, RetailStoreCountryCenter.class);

    return parents;
  }

  public TransportFleet want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public TransportFleet wants(Class<? extends BaseEntity>... classes) {
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
	protected		String              	contactNumber       ;
	protected		RetailStoreCountryCenter	owner               ;
	protected		DateTime            	lastUpdateTime      ;
	protected		int                 	version             ;

	
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
		transportFleet.setChecked(true);
		return transportFleet;
	}
	public 	static TransportFleet refById(String id){
		return withId(id);
	}

  public TransportFleet limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public TransportFleet limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static TransportFleet searchExample(){
    TransportFleet transportFleet = new TransportFleet();
    		transportFleet.setVersion(UNSET_INT);

    return transportFleet;
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

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public TransportFleet updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public TransportFleet orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public TransportFleet ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public TransportFleet addIdCriteria(QueryOperator operator, Object... parameters){
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
	public TransportFleet updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public TransportFleet orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public TransportFleet ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public TransportFleet addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setContactNumber(String contactNumber){String oldContactNumber = this.contactNumber;String newContactNumber = trimString(contactNumber);this.contactNumber = newContactNumber;}
	public String contactNumber(){
doLoad();
return getContactNumber();
}
	public String getContactNumber(){
		return this.contactNumber;
	}
	public TransportFleet updateContactNumber(String contactNumber){String oldContactNumber = this.contactNumber;String newContactNumber = trimString(contactNumber);if(!shouldReplaceBy(newContactNumber, oldContactNumber)){return this;}this.contactNumber = newContactNumber;addPropertyChange(CONTACT_NUMBER_PROPERTY, oldContactNumber, newContactNumber);this.changed = true;setChecked(false);return this;}
	public TransportFleet orderByContactNumber(boolean asc){
doAddOrderBy(CONTACT_NUMBER_PROPERTY, asc);
return this;
}
	public SearchCriteria createContactNumberCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CONTACT_NUMBER_PROPERTY, operator, parameters);
}
	public TransportFleet ignoreContactNumberCriteria(){super.ignoreSearchProperty(CONTACT_NUMBER_PROPERTY);
return this;
}
	public TransportFleet addContactNumberCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createContactNumberCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeContactNumber(String contactNumber){
		if(contactNumber != null) { setContactNumber(contactNumber);}
	}

	
	public void setOwner(RetailStoreCountryCenter owner){RetailStoreCountryCenter oldOwner = this.owner;RetailStoreCountryCenter newOwner = owner;this.owner = newOwner;}
	public RetailStoreCountryCenter owner(){
doLoad();
return getOwner();
}
	public RetailStoreCountryCenter getOwner(){
		return this.owner;
	}
	public TransportFleet updateOwner(RetailStoreCountryCenter owner){RetailStoreCountryCenter oldOwner = this.owner;RetailStoreCountryCenter newOwner = owner;if(!shouldReplaceBy(newOwner, oldOwner)){return this;}this.owner = newOwner;addPropertyChange(OWNER_PROPERTY, oldOwner, newOwner);this.changed = true;setChecked(false);return this;}
	public TransportFleet orderByOwner(boolean asc){
doAddOrderBy(OWNER_PROPERTY, asc);
return this;
}
	public SearchCriteria createOwnerCriteria(QueryOperator operator, Object... parameters){
return createCriteria(OWNER_PROPERTY, operator, parameters);
}
	public TransportFleet ignoreOwnerCriteria(){super.ignoreSearchProperty(OWNER_PROPERTY);
return this;
}
	public TransportFleet addOwnerCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createOwnerCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeOwner(RetailStoreCountryCenter owner){
		if(owner != null) { setOwner(owner);}
	}

	
	public void clearOwner(){
		setOwner ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;this.lastUpdateTime = newLastUpdateTime;}
	public DateTime lastUpdateTime(){
doLoad();
return getLastUpdateTime();
}
	public DateTime getLastUpdateTime(){
		return this.lastUpdateTime;
	}
	public TransportFleet updateLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;if(!shouldReplaceBy(newLastUpdateTime, oldLastUpdateTime)){return this;}this.lastUpdateTime = newLastUpdateTime;addPropertyChange(LAST_UPDATE_TIME_PROPERTY, oldLastUpdateTime, newLastUpdateTime);this.changed = true;setChecked(false);return this;}
	public TransportFleet orderByLastUpdateTime(boolean asc){
doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
}
	public TransportFleet ignoreLastUpdateTimeCriteria(){super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
return this;
}
	public TransportFleet addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createLastUpdateTimeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeLastUpdateTime(DateTime lastUpdateTime){
		setLastUpdateTime(lastUpdateTime);
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public TransportFleet updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public TransportFleet orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public TransportFleet ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public TransportFleet addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
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

  public  SmartList<TransportTruck> transportTruckList(){
    
    doLoadChild(TRANSPORT_TRUCK_LIST);
    
    return getTransportTruckList();
  }


	public  void setTransportTruckList(SmartList<TransportTruck> transportTruckList){
		for( TransportTruck transportTruck:transportTruckList){
			transportTruck.setOwner(this);
		}

		this.mTransportTruckList = transportTruckList;
		this.mTransportTruckList.setListInternalName (TRANSPORT_TRUCK_LIST );

	}

	public  TransportFleet addTransportTruck(TransportTruck transportTruck){
		transportTruck.setOwner(this);
		getTransportTruckList().add(transportTruck);
		return this;
	}
	public  TransportFleet addTransportTruckList(SmartList<TransportTruck> transportTruckList){
		for( TransportTruck transportTruck:transportTruckList){
			transportTruck.setOwner(this);
		}
		getTransportTruckList().addAll(transportTruckList);
		return this;
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

  public  SmartList<TruckDriver> truckDriverList(){
    
    doLoadChild(TRUCK_DRIVER_LIST);
    
    return getTruckDriverList();
  }


	public  void setTruckDriverList(SmartList<TruckDriver> truckDriverList){
		for( TruckDriver truckDriver:truckDriverList){
			truckDriver.setBelongsTo(this);
		}

		this.mTruckDriverList = truckDriverList;
		this.mTruckDriverList.setListInternalName (TRUCK_DRIVER_LIST );

	}

	public  TransportFleet addTruckDriver(TruckDriver truckDriver){
		truckDriver.setBelongsTo(this);
		getTruckDriverList().add(truckDriver);
		return this;
	}
	public  TransportFleet addTruckDriverList(SmartList<TruckDriver> truckDriverList){
		for( TruckDriver truckDriver:truckDriverList){
			truckDriver.setBelongsTo(this);
		}
		getTruckDriverList().addAll(truckDriverList);
		return this;
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

  public  SmartList<TransportTask> transportTaskList(){
    
    doLoadChild(TRANSPORT_TASK_LIST);
    
    return getTransportTaskList();
  }


	public  void setTransportTaskList(SmartList<TransportTask> transportTaskList){
		for( TransportTask transportTask:transportTaskList){
			transportTask.setBelongsTo(this);
		}

		this.mTransportTaskList = transportTaskList;
		this.mTransportTaskList.setListInternalName (TRANSPORT_TASK_LIST );

	}

	public  TransportFleet addTransportTask(TransportTask transportTask){
		transportTask.setBelongsTo(this);
		getTransportTaskList().add(transportTask);
		return this;
	}
	public  TransportFleet addTransportTaskList(SmartList<TransportTask> transportTaskList){
		for( TransportTask transportTask:transportTaskList){
			transportTask.setBelongsTo(this);
		}
		getTransportTaskList().addAll(transportTaskList);
		return this;
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


	public static TransportFleet createWith(RetailscmUserContext userContext, ThrowingFunction<TransportFleet,TransportFleet,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<TransportFleet> customCreator = mapper.findCustomCreator(TransportFleet.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    TransportFleet result = new TransportFleet();
    result.setName(mapper.tryToGet(TransportFleet.class, NAME_PROPERTY, String.class,
        0, false, result.getName(), params));
    result.setContactNumber(mapper.tryToGet(TransportFleet.class, CONTACT_NUMBER_PROPERTY, String.class,
        1, false, result.getContactNumber(), params));
    result.setOwner(mapper.tryToGet(TransportFleet.class, OWNER_PROPERTY, RetailStoreCountryCenter.class,
        0, true, result.getOwner(), params));
     result.setLastUpdateTime(userContext.now());

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixTransportFleet(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      TransportFleetTokens tokens = mapper.findParamByClass(params, TransportFleetTokens.class);
      if (tokens == null) {
        tokens = TransportFleetTokens.start();
      }
      result = userContext.getManagerGroup().getTransportFleetManager().internalSaveTransportFleet(userContext, result, tokens.done());
      
    }
    return result;
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

