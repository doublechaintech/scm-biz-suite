
package com.doublechaintech.retailscm.transporttask;

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
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrack;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;

@JsonSerialize(using = TransportTaskSerializer.class)
public class TransportTask extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String START_PROPERTY                 = "start"             ;
	public static final String BEGIN_TIME_PROPERTY            = "beginTime"         ;
	public static final String END_PROPERTY                   = "end"               ;
	public static final String DRIVER_PROPERTY                = "driver"            ;
	public static final String TRUCK_PROPERTY                 = "truck"             ;
	public static final String BELONGS_TO_PROPERTY            = "belongsTo"         ;
	public static final String LATITUDE_PROPERTY              = "latitude"          ;
	public static final String LONGITUDE_PROPERTY             = "longitude"         ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String GOODS_LIST                               = "goodsList"         ;
	public static final String TRANSPORT_TASK_TRACK_LIST                = "transportTaskTrackList";

	public static final String INTERNAL_TYPE="TransportTask";
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
	protected		String              	mStart              ;
	protected		Date                	mBeginTime          ;
	protected		RetailStore         	mEnd                ;
	protected		TruckDriver         	mDriver             ;
	protected		TransportTruck      	mTruck              ;
	protected		TransportFleet      	mBelongsTo          ;
	protected		BigDecimal          	mLatitude           ;
	protected		BigDecimal          	mLongitude          ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Goods>    	mGoodsList          ;
	protected		SmartList<TransportTaskTrack>	mTransportTaskTrackList;

	
		
	public 	TransportTask(){
		// lazy load for all the properties
	}
	public 	static TransportTask withId(String id){
		TransportTask transportTask = new TransportTask();
		transportTask.setId(id);
		transportTask.setVersion(Integer.MAX_VALUE);
		return transportTask;
	}
	public 	static TransportTask refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setEnd( null );
		setDriver( null );
		setTruck( null );
		setBelongsTo( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(START_PROPERTY.equals(property)){
			changeStartProperty(newValueExpr);
		}
		if(BEGIN_TIME_PROPERTY.equals(property)){
			changeBeginTimeProperty(newValueExpr);
		}
		if(LATITUDE_PROPERTY.equals(property)){
			changeLatitudeProperty(newValueExpr);
		}
		if(LONGITUDE_PROPERTY.equals(property)){
			changeLongitudeProperty(newValueExpr);
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
			
			
			
	protected void changeStartProperty(String newValueExpr){
	
		String oldValue = getStart();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateStart(newValue);
		this.onChangeProperty(START_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeBeginTimeProperty(String newValueExpr){
	
		Date oldValue = getBeginTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateBeginTime(newValue);
		this.onChangeProperty(BEGIN_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeLatitudeProperty(String newValueExpr){
	
		BigDecimal oldValue = getLatitude();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLatitude(newValue);
		this.onChangeProperty(LATITUDE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeLongitudeProperty(String newValueExpr){
	
		BigDecimal oldValue = getLongitude();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLongitude(newValue);
		this.onChangeProperty(LONGITUDE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(START_PROPERTY.equals(property)){
			return getStart();
		}
		if(BEGIN_TIME_PROPERTY.equals(property)){
			return getBeginTime();
		}
		if(END_PROPERTY.equals(property)){
			return getEnd();
		}
		if(DRIVER_PROPERTY.equals(property)){
			return getDriver();
		}
		if(TRUCK_PROPERTY.equals(property)){
			return getTruck();
		}
		if(BELONGS_TO_PROPERTY.equals(property)){
			return getBelongsTo();
		}
		if(LATITUDE_PROPERTY.equals(property)){
			return getLatitude();
		}
		if(LONGITUDE_PROPERTY.equals(property)){
			return getLongitude();
		}
		if(GOODS_LIST.equals(property)){
			List<BaseEntity> list = getGoodsList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(TRANSPORT_TASK_TRACK_LIST.equals(property)){
			List<BaseEntity> list = getTransportTaskTrackList().stream().map(item->item).collect(Collectors.toList());
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
	public TransportTask updateId(String id){
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
	public TransportTask updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setStart(String start){
		this.mStart = trimString(start);;
	}
	public String getStart(){
		return this.mStart;
	}
	public TransportTask updateStart(String start){
		this.mStart = trimString(start);;
		this.changed = true;
		return this;
	}
	public void mergeStart(String start){
		if(start != null) { setStart(start);}
	}
	
	
	public void setBeginTime(Date beginTime){
		this.mBeginTime = beginTime;;
	}
	public Date getBeginTime(){
		return this.mBeginTime;
	}
	public TransportTask updateBeginTime(Date beginTime){
		this.mBeginTime = beginTime;;
		this.changed = true;
		return this;
	}
	public void mergeBeginTime(Date beginTime){
		setBeginTime(beginTime);
	}
	
	
	public void setEnd(RetailStore end){
		this.mEnd = end;;
	}
	public RetailStore getEnd(){
		return this.mEnd;
	}
	public TransportTask updateEnd(RetailStore end){
		this.mEnd = end;;
		this.changed = true;
		return this;
	}
	public void mergeEnd(RetailStore end){
		if(end != null) { setEnd(end);}
	}
	
	
	public void clearEnd(){
		setEnd ( null );
		this.changed = true;
	}
	
	public void setDriver(TruckDriver driver){
		this.mDriver = driver;;
	}
	public TruckDriver getDriver(){
		return this.mDriver;
	}
	public TransportTask updateDriver(TruckDriver driver){
		this.mDriver = driver;;
		this.changed = true;
		return this;
	}
	public void mergeDriver(TruckDriver driver){
		if(driver != null) { setDriver(driver);}
	}
	
	
	public void clearDriver(){
		setDriver ( null );
		this.changed = true;
	}
	
	public void setTruck(TransportTruck truck){
		this.mTruck = truck;;
	}
	public TransportTruck getTruck(){
		return this.mTruck;
	}
	public TransportTask updateTruck(TransportTruck truck){
		this.mTruck = truck;;
		this.changed = true;
		return this;
	}
	public void mergeTruck(TransportTruck truck){
		if(truck != null) { setTruck(truck);}
	}
	
	
	public void clearTruck(){
		setTruck ( null );
		this.changed = true;
	}
	
	public void setBelongsTo(TransportFleet belongsTo){
		this.mBelongsTo = belongsTo;;
	}
	public TransportFleet getBelongsTo(){
		return this.mBelongsTo;
	}
	public TransportTask updateBelongsTo(TransportFleet belongsTo){
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
	
	public void setLatitude(BigDecimal latitude){
		this.mLatitude = latitude;;
	}
	public BigDecimal getLatitude(){
		return this.mLatitude;
	}
	public TransportTask updateLatitude(BigDecimal latitude){
		this.mLatitude = latitude;;
		this.changed = true;
		return this;
	}
	public void mergeLatitude(BigDecimal latitude){
		setLatitude(latitude);
	}
	
	
	public void setLongitude(BigDecimal longitude){
		this.mLongitude = longitude;;
	}
	public BigDecimal getLongitude(){
		return this.mLongitude;
	}
	public TransportTask updateLongitude(BigDecimal longitude){
		this.mLongitude = longitude;;
		this.changed = true;
		return this;
	}
	public void mergeLongitude(BigDecimal longitude){
		setLongitude(longitude);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public TransportTask updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<Goods> getGoodsList(){
		if(this.mGoodsList == null){
			this.mGoodsList = new SmartList<Goods>();
			this.mGoodsList.setListInternalName (GOODS_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mGoodsList;	
	}
	public  void setGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setTransportTask(this);
		}

		this.mGoodsList = goodsList;
		this.mGoodsList.setListInternalName (GOODS_LIST );
		
	}
	
	public  void addGoods(Goods goods){
		goods.setTransportTask(this);
		getGoodsList().add(goods);
	}
	public  void addGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setTransportTask(this);
		}
		getGoodsList().addAll(goodsList);
	}
	public  void mergeGoodsList(SmartList<Goods> goodsList){
		if(goodsList==null){
			return;
		}
		if(goodsList.isEmpty()){
			return;
		}
		addGoodsList( goodsList );
		
	}
	public  Goods removeGoods(Goods goodsIndex){
		
		int index = getGoodsList().indexOf(goodsIndex);
        if(index < 0){
        	String message = "Goods("+goodsIndex.getId()+") with version='"+goodsIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Goods goods = getGoodsList().get(index);        
        // goods.clearTransportTask(); //disconnect with TransportTask
        goods.clearFromAll(); //disconnect with TransportTask
		
		boolean result = getGoodsList().planToRemove(goods);
        if(!result){
        	String message = "Goods("+goodsIndex.getId()+") with version='"+goodsIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return goods;
        
	
	}
	//断舍离
	public  void breakWithGoods(Goods goods){
		
		if(goods == null){
			return;
		}
		goods.setTransportTask(null);
		//getGoodsList().remove();
	
	}
	
	public  boolean hasGoods(Goods goods){
	
		return getGoodsList().contains(goods);
  
	}
	
	public void copyGoodsFrom(Goods goods) {

		Goods goodsInList = findTheGoods(goods);
		Goods newGoods = new Goods();
		goodsInList.copyTo(newGoods);
		newGoods.setVersion(0);//will trigger copy
		getGoodsList().add(newGoods);
		addItemToFlexiableObject(COPIED_CHILD, newGoods);
	}
	
	public  Goods findTheGoods(Goods goods){
		
		int index =  getGoodsList().indexOf(goods);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Goods("+goods.getId()+") with version='"+goods.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getGoodsList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpGoodsList(){
		getGoodsList().clear();
	}
	
	
	


	public  SmartList<TransportTaskTrack> getTransportTaskTrackList(){
		if(this.mTransportTaskTrackList == null){
			this.mTransportTaskTrackList = new SmartList<TransportTaskTrack>();
			this.mTransportTaskTrackList.setListInternalName (TRANSPORT_TASK_TRACK_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTransportTaskTrackList;	
	}
	public  void setTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList){
		for( TransportTaskTrack transportTaskTrack:transportTaskTrackList){
			transportTaskTrack.setMovement(this);
		}

		this.mTransportTaskTrackList = transportTaskTrackList;
		this.mTransportTaskTrackList.setListInternalName (TRANSPORT_TASK_TRACK_LIST );
		
	}
	
	public  void addTransportTaskTrack(TransportTaskTrack transportTaskTrack){
		transportTaskTrack.setMovement(this);
		getTransportTaskTrackList().add(transportTaskTrack);
	}
	public  void addTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList){
		for( TransportTaskTrack transportTaskTrack:transportTaskTrackList){
			transportTaskTrack.setMovement(this);
		}
		getTransportTaskTrackList().addAll(transportTaskTrackList);
	}
	public  void mergeTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList){
		if(transportTaskTrackList==null){
			return;
		}
		if(transportTaskTrackList.isEmpty()){
			return;
		}
		addTransportTaskTrackList( transportTaskTrackList );
		
	}
	public  TransportTaskTrack removeTransportTaskTrack(TransportTaskTrack transportTaskTrackIndex){
		
		int index = getTransportTaskTrackList().indexOf(transportTaskTrackIndex);
        if(index < 0){
        	String message = "TransportTaskTrack("+transportTaskTrackIndex.getId()+") with version='"+transportTaskTrackIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TransportTaskTrack transportTaskTrack = getTransportTaskTrackList().get(index);        
        // transportTaskTrack.clearMovement(); //disconnect with Movement
        transportTaskTrack.clearFromAll(); //disconnect with Movement
		
		boolean result = getTransportTaskTrackList().planToRemove(transportTaskTrack);
        if(!result){
        	String message = "TransportTaskTrack("+transportTaskTrackIndex.getId()+") with version='"+transportTaskTrackIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return transportTaskTrack;
        
	
	}
	//断舍离
	public  void breakWithTransportTaskTrack(TransportTaskTrack transportTaskTrack){
		
		if(transportTaskTrack == null){
			return;
		}
		transportTaskTrack.setMovement(null);
		//getTransportTaskTrackList().remove();
	
	}
	
	public  boolean hasTransportTaskTrack(TransportTaskTrack transportTaskTrack){
	
		return getTransportTaskTrackList().contains(transportTaskTrack);
  
	}
	
	public void copyTransportTaskTrackFrom(TransportTaskTrack transportTaskTrack) {

		TransportTaskTrack transportTaskTrackInList = findTheTransportTaskTrack(transportTaskTrack);
		TransportTaskTrack newTransportTaskTrack = new TransportTaskTrack();
		transportTaskTrackInList.copyTo(newTransportTaskTrack);
		newTransportTaskTrack.setVersion(0);//will trigger copy
		getTransportTaskTrackList().add(newTransportTaskTrack);
		addItemToFlexiableObject(COPIED_CHILD, newTransportTaskTrack);
	}
	
	public  TransportTaskTrack findTheTransportTaskTrack(TransportTaskTrack transportTaskTrack){
		
		int index =  getTransportTaskTrackList().indexOf(transportTaskTrack);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TransportTaskTrack("+transportTaskTrack.getId()+") with version='"+transportTaskTrack.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTransportTaskTrackList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTransportTaskTrackList(){
		getTransportTaskTrackList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getEnd(), internalType);
		addToEntityList(this, entityList, getDriver(), internalType);
		addToEntityList(this, entityList, getTruck(), internalType);
		addToEntityList(this, entityList, getBelongsTo(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getGoodsList(), internalType);
		collectFromList(this, entityList, getTransportTaskTrackList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getGoodsList());
		listOfList.add( getTransportTaskTrackList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, START_PROPERTY, getStart());
		appendKeyValuePair(result, BEGIN_TIME_PROPERTY, getBeginTime());
		appendKeyValuePair(result, END_PROPERTY, getEnd());
		appendKeyValuePair(result, DRIVER_PROPERTY, getDriver());
		appendKeyValuePair(result, TRUCK_PROPERTY, getTruck());
		appendKeyValuePair(result, BELONGS_TO_PROPERTY, getBelongsTo());
		appendKeyValuePair(result, LATITUDE_PROPERTY, getLatitude());
		appendKeyValuePair(result, LONGITUDE_PROPERTY, getLongitude());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, GOODS_LIST, getGoodsList());
		if(!getGoodsList().isEmpty()){
			appendKeyValuePair(result, "goodsCount", getGoodsList().getTotalCount());
			appendKeyValuePair(result, "goodsCurrentPageNumber", getGoodsList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TRANSPORT_TASK_TRACK_LIST, getTransportTaskTrackList());
		if(!getTransportTaskTrackList().isEmpty()){
			appendKeyValuePair(result, "transportTaskTrackCount", getTransportTaskTrackList().getTotalCount());
			appendKeyValuePair(result, "transportTaskTrackCurrentPageNumber", getTransportTaskTrackList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TransportTask){
		
		
			TransportTask dest =(TransportTask)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setStart(getStart());
			dest.setBeginTime(getBeginTime());
			dest.setEnd(getEnd());
			dest.setDriver(getDriver());
			dest.setTruck(getTruck());
			dest.setBelongsTo(getBelongsTo());
			dest.setLatitude(getLatitude());
			dest.setLongitude(getLongitude());
			dest.setVersion(getVersion());
			dest.setGoodsList(getGoodsList());
			dest.setTransportTaskTrackList(getTransportTaskTrackList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TransportTask){
		
			
			TransportTask dest =(TransportTask)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeStart(getStart());
			dest.mergeBeginTime(getBeginTime());
			dest.mergeEnd(getEnd());
			dest.mergeDriver(getDriver());
			dest.mergeTruck(getTruck());
			dest.mergeBelongsTo(getBelongsTo());
			dest.mergeLatitude(getLatitude());
			dest.mergeLongitude(getLongitude());
			dest.mergeVersion(getVersion());
			dest.mergeGoodsList(getGoodsList());
			dest.mergeTransportTaskTrackList(getTransportTaskTrackList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TransportTask){
		
			
			TransportTask dest =(TransportTask)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeStart(getStart());
			dest.mergeBeginTime(getBeginTime());
			dest.mergeLatitude(getLatitude());
			dest.mergeLongitude(getLongitude());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getStart(), getBeginTime(), getEnd(), getDriver(), getTruck(), getBelongsTo(), getLatitude(), getLongitude(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("TransportTask{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tstart='"+getStart()+"';");
		stringBuilder.append("\tbeginTime='"+getBeginTime()+"';");
		if(getEnd() != null ){
 			stringBuilder.append("\tend='RetailStore("+getEnd().getId()+")';");
 		}
		if(getDriver() != null ){
 			stringBuilder.append("\tdriver='TruckDriver("+getDriver().getId()+")';");
 		}
		if(getTruck() != null ){
 			stringBuilder.append("\ttruck='TransportTruck("+getTruck().getId()+")';");
 		}
		if(getBelongsTo() != null ){
 			stringBuilder.append("\tbelongsTo='TransportFleet("+getBelongsTo().getId()+")';");
 		}
		stringBuilder.append("\tlatitude='"+getLatitude()+"';");
		stringBuilder.append("\tlongitude='"+getLongitude()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

