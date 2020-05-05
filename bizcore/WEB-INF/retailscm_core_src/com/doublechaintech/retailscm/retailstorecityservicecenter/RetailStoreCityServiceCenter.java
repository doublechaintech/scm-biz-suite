
package com.doublechaintech.retailscm.retailstorecityservicecenter;

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
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.cityevent.CityEvent;
import com.doublechaintech.retailscm.citypartner.CityPartner;

@JsonSerialize(using = RetailStoreCityServiceCenterSerializer.class)
public class RetailStoreCityServiceCenter extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String BELONGS_TO_PROPERTY            = "belongsTo"         ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String CITY_PARTNER_LIST                        = "cityPartnerList"   ;
	public static final String POTENTIAL_CUSTOMER_LIST                  = "potentialCustomerList";
	public static final String CITY_EVENT_LIST                          = "cityEventList"     ;
	public static final String RETAIL_STORE_LIST                        = "retailStoreList"   ;

	public static final String INTERNAL_TYPE="RetailStoreCityServiceCenter";
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
	protected		Date                	mFounded            ;
	protected		RetailStoreProvinceCenter	mBelongsTo          ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<CityPartner>	mCityPartnerList    ;
	protected		SmartList<PotentialCustomer>	mPotentialCustomerList;
	protected		SmartList<CityEvent>	mCityEventList      ;
	protected		SmartList<RetailStore>	mRetailStoreList    ;

	
		
	public 	RetailStoreCityServiceCenter(){
		// lazy load for all the properties
	}
	public 	static RetailStoreCityServiceCenter withId(String id){
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = new RetailStoreCityServiceCenter();
		retailStoreCityServiceCenter.setId(id);
		retailStoreCityServiceCenter.setVersion(Integer.MAX_VALUE);
		return retailStoreCityServiceCenter;
	}
	public 	static RetailStoreCityServiceCenter refById(String id){
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
		if(FOUNDED_PROPERTY.equals(property)){
			changeFoundedProperty(newValueExpr);
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
			
			
			
	protected void changeFoundedProperty(String newValueExpr){
	
		Date oldValue = getFounded();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateFounded(newValue);
		this.onChangeProperty(FOUNDED_PROPERTY, oldValue, newValue);
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
		if(FOUNDED_PROPERTY.equals(property)){
			return getFounded();
		}
		if(BELONGS_TO_PROPERTY.equals(property)){
			return getBelongsTo();
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			return getLastUpdateTime();
		}
		if(CITY_PARTNER_LIST.equals(property)){
			List<BaseEntity> list = getCityPartnerList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(POTENTIAL_CUSTOMER_LIST.equals(property)){
			List<BaseEntity> list = getPotentialCustomerList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(CITY_EVENT_LIST.equals(property)){
			List<BaseEntity> list = getCityEventList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(RETAIL_STORE_LIST.equals(property)){
			List<BaseEntity> list = getRetailStoreList().stream().map(item->item).collect(Collectors.toList());
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
	public RetailStoreCityServiceCenter updateId(String id){
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
	public RetailStoreCityServiceCenter updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setFounded(Date founded){
		this.mFounded = founded;;
	}
	public Date getFounded(){
		return this.mFounded;
	}
	public RetailStoreCityServiceCenter updateFounded(Date founded){
		this.mFounded = founded;;
		this.changed = true;
		return this;
	}
	public void mergeFounded(Date founded){
		setFounded(founded);
	}
	
	
	public void setBelongsTo(RetailStoreProvinceCenter belongsTo){
		this.mBelongsTo = belongsTo;;
	}
	public RetailStoreProvinceCenter getBelongsTo(){
		return this.mBelongsTo;
	}
	public RetailStoreCityServiceCenter updateBelongsTo(RetailStoreProvinceCenter belongsTo){
		this.mBelongsTo = belongsTo;;
		this.changed = true;
		return this;
	}
	public void mergeBelongsTo(RetailStoreProvinceCenter belongsTo){
		if(belongsTo != null) { setBelongsTo(belongsTo);}
	}
	
	
	public void clearBelongsTo(){
		setBelongsTo ( null );
		this.changed = true;
	}
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public RetailStoreCityServiceCenter updateLastUpdateTime(DateTime lastUpdateTime){
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
	public RetailStoreCityServiceCenter updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<CityPartner> getCityPartnerList(){
		if(this.mCityPartnerList == null){
			this.mCityPartnerList = new SmartList<CityPartner>();
			this.mCityPartnerList.setListInternalName (CITY_PARTNER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mCityPartnerList;	
	}
	public  void setCityPartnerList(SmartList<CityPartner> cityPartnerList){
		for( CityPartner cityPartner:cityPartnerList){
			cityPartner.setCityServiceCenter(this);
		}

		this.mCityPartnerList = cityPartnerList;
		this.mCityPartnerList.setListInternalName (CITY_PARTNER_LIST );
		
	}
	
	public  void addCityPartner(CityPartner cityPartner){
		cityPartner.setCityServiceCenter(this);
		getCityPartnerList().add(cityPartner);
	}
	public  void addCityPartnerList(SmartList<CityPartner> cityPartnerList){
		for( CityPartner cityPartner:cityPartnerList){
			cityPartner.setCityServiceCenter(this);
		}
		getCityPartnerList().addAll(cityPartnerList);
	}
	public  void mergeCityPartnerList(SmartList<CityPartner> cityPartnerList){
		if(cityPartnerList==null){
			return;
		}
		if(cityPartnerList.isEmpty()){
			return;
		}
		addCityPartnerList( cityPartnerList );
		
	}
	public  CityPartner removeCityPartner(CityPartner cityPartnerIndex){
		
		int index = getCityPartnerList().indexOf(cityPartnerIndex);
        if(index < 0){
        	String message = "CityPartner("+cityPartnerIndex.getId()+") with version='"+cityPartnerIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        CityPartner cityPartner = getCityPartnerList().get(index);        
        // cityPartner.clearCityServiceCenter(); //disconnect with CityServiceCenter
        cityPartner.clearFromAll(); //disconnect with CityServiceCenter
		
		boolean result = getCityPartnerList().planToRemove(cityPartner);
        if(!result){
        	String message = "CityPartner("+cityPartnerIndex.getId()+") with version='"+cityPartnerIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return cityPartner;
        
	
	}
	//断舍离
	public  void breakWithCityPartner(CityPartner cityPartner){
		
		if(cityPartner == null){
			return;
		}
		cityPartner.setCityServiceCenter(null);
		//getCityPartnerList().remove();
	
	}
	
	public  boolean hasCityPartner(CityPartner cityPartner){
	
		return getCityPartnerList().contains(cityPartner);
  
	}
	
	public void copyCityPartnerFrom(CityPartner cityPartner) {

		CityPartner cityPartnerInList = findTheCityPartner(cityPartner);
		CityPartner newCityPartner = new CityPartner();
		cityPartnerInList.copyTo(newCityPartner);
		newCityPartner.setVersion(0);//will trigger copy
		getCityPartnerList().add(newCityPartner);
		addItemToFlexiableObject(COPIED_CHILD, newCityPartner);
	}
	
	public  CityPartner findTheCityPartner(CityPartner cityPartner){
		
		int index =  getCityPartnerList().indexOf(cityPartner);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "CityPartner("+cityPartner.getId()+") with version='"+cityPartner.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getCityPartnerList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpCityPartnerList(){
		getCityPartnerList().clear();
	}
	
	
	


	public  SmartList<PotentialCustomer> getPotentialCustomerList(){
		if(this.mPotentialCustomerList == null){
			this.mPotentialCustomerList = new SmartList<PotentialCustomer>();
			this.mPotentialCustomerList.setListInternalName (POTENTIAL_CUSTOMER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mPotentialCustomerList;	
	}
	public  void setPotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList){
		for( PotentialCustomer potentialCustomer:potentialCustomerList){
			potentialCustomer.setCityServiceCenter(this);
		}

		this.mPotentialCustomerList = potentialCustomerList;
		this.mPotentialCustomerList.setListInternalName (POTENTIAL_CUSTOMER_LIST );
		
	}
	
	public  void addPotentialCustomer(PotentialCustomer potentialCustomer){
		potentialCustomer.setCityServiceCenter(this);
		getPotentialCustomerList().add(potentialCustomer);
	}
	public  void addPotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList){
		for( PotentialCustomer potentialCustomer:potentialCustomerList){
			potentialCustomer.setCityServiceCenter(this);
		}
		getPotentialCustomerList().addAll(potentialCustomerList);
	}
	public  void mergePotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList){
		if(potentialCustomerList==null){
			return;
		}
		if(potentialCustomerList.isEmpty()){
			return;
		}
		addPotentialCustomerList( potentialCustomerList );
		
	}
	public  PotentialCustomer removePotentialCustomer(PotentialCustomer potentialCustomerIndex){
		
		int index = getPotentialCustomerList().indexOf(potentialCustomerIndex);
        if(index < 0){
        	String message = "PotentialCustomer("+potentialCustomerIndex.getId()+") with version='"+potentialCustomerIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        PotentialCustomer potentialCustomer = getPotentialCustomerList().get(index);        
        // potentialCustomer.clearCityServiceCenter(); //disconnect with CityServiceCenter
        potentialCustomer.clearFromAll(); //disconnect with CityServiceCenter
		
		boolean result = getPotentialCustomerList().planToRemove(potentialCustomer);
        if(!result){
        	String message = "PotentialCustomer("+potentialCustomerIndex.getId()+") with version='"+potentialCustomerIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return potentialCustomer;
        
	
	}
	//断舍离
	public  void breakWithPotentialCustomer(PotentialCustomer potentialCustomer){
		
		if(potentialCustomer == null){
			return;
		}
		potentialCustomer.setCityServiceCenter(null);
		//getPotentialCustomerList().remove();
	
	}
	
	public  boolean hasPotentialCustomer(PotentialCustomer potentialCustomer){
	
		return getPotentialCustomerList().contains(potentialCustomer);
  
	}
	
	public void copyPotentialCustomerFrom(PotentialCustomer potentialCustomer) {

		PotentialCustomer potentialCustomerInList = findThePotentialCustomer(potentialCustomer);
		PotentialCustomer newPotentialCustomer = new PotentialCustomer();
		potentialCustomerInList.copyTo(newPotentialCustomer);
		newPotentialCustomer.setVersion(0);//will trigger copy
		getPotentialCustomerList().add(newPotentialCustomer);
		addItemToFlexiableObject(COPIED_CHILD, newPotentialCustomer);
	}
	
	public  PotentialCustomer findThePotentialCustomer(PotentialCustomer potentialCustomer){
		
		int index =  getPotentialCustomerList().indexOf(potentialCustomer);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "PotentialCustomer("+potentialCustomer.getId()+") with version='"+potentialCustomer.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getPotentialCustomerList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpPotentialCustomerList(){
		getPotentialCustomerList().clear();
	}
	
	
	


	public  SmartList<CityEvent> getCityEventList(){
		if(this.mCityEventList == null){
			this.mCityEventList = new SmartList<CityEvent>();
			this.mCityEventList.setListInternalName (CITY_EVENT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mCityEventList;	
	}
	public  void setCityEventList(SmartList<CityEvent> cityEventList){
		for( CityEvent cityEvent:cityEventList){
			cityEvent.setCityServiceCenter(this);
		}

		this.mCityEventList = cityEventList;
		this.mCityEventList.setListInternalName (CITY_EVENT_LIST );
		
	}
	
	public  void addCityEvent(CityEvent cityEvent){
		cityEvent.setCityServiceCenter(this);
		getCityEventList().add(cityEvent);
	}
	public  void addCityEventList(SmartList<CityEvent> cityEventList){
		for( CityEvent cityEvent:cityEventList){
			cityEvent.setCityServiceCenter(this);
		}
		getCityEventList().addAll(cityEventList);
	}
	public  void mergeCityEventList(SmartList<CityEvent> cityEventList){
		if(cityEventList==null){
			return;
		}
		if(cityEventList.isEmpty()){
			return;
		}
		addCityEventList( cityEventList );
		
	}
	public  CityEvent removeCityEvent(CityEvent cityEventIndex){
		
		int index = getCityEventList().indexOf(cityEventIndex);
        if(index < 0){
        	String message = "CityEvent("+cityEventIndex.getId()+") with version='"+cityEventIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        CityEvent cityEvent = getCityEventList().get(index);        
        // cityEvent.clearCityServiceCenter(); //disconnect with CityServiceCenter
        cityEvent.clearFromAll(); //disconnect with CityServiceCenter
		
		boolean result = getCityEventList().planToRemove(cityEvent);
        if(!result){
        	String message = "CityEvent("+cityEventIndex.getId()+") with version='"+cityEventIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return cityEvent;
        
	
	}
	//断舍离
	public  void breakWithCityEvent(CityEvent cityEvent){
		
		if(cityEvent == null){
			return;
		}
		cityEvent.setCityServiceCenter(null);
		//getCityEventList().remove();
	
	}
	
	public  boolean hasCityEvent(CityEvent cityEvent){
	
		return getCityEventList().contains(cityEvent);
  
	}
	
	public void copyCityEventFrom(CityEvent cityEvent) {

		CityEvent cityEventInList = findTheCityEvent(cityEvent);
		CityEvent newCityEvent = new CityEvent();
		cityEventInList.copyTo(newCityEvent);
		newCityEvent.setVersion(0);//will trigger copy
		getCityEventList().add(newCityEvent);
		addItemToFlexiableObject(COPIED_CHILD, newCityEvent);
	}
	
	public  CityEvent findTheCityEvent(CityEvent cityEvent){
		
		int index =  getCityEventList().indexOf(cityEvent);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "CityEvent("+cityEvent.getId()+") with version='"+cityEvent.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getCityEventList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpCityEventList(){
		getCityEventList().clear();
	}
	
	
	


	public  SmartList<RetailStore> getRetailStoreList(){
		if(this.mRetailStoreList == null){
			this.mRetailStoreList = new SmartList<RetailStore>();
			this.mRetailStoreList.setListInternalName (RETAIL_STORE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mRetailStoreList;	
	}
	public  void setRetailStoreList(SmartList<RetailStore> retailStoreList){
		for( RetailStore retailStore:retailStoreList){
			retailStore.setCityServiceCenter(this);
		}

		this.mRetailStoreList = retailStoreList;
		this.mRetailStoreList.setListInternalName (RETAIL_STORE_LIST );
		
	}
	
	public  void addRetailStore(RetailStore retailStore){
		retailStore.setCityServiceCenter(this);
		getRetailStoreList().add(retailStore);
	}
	public  void addRetailStoreList(SmartList<RetailStore> retailStoreList){
		for( RetailStore retailStore:retailStoreList){
			retailStore.setCityServiceCenter(this);
		}
		getRetailStoreList().addAll(retailStoreList);
	}
	public  void mergeRetailStoreList(SmartList<RetailStore> retailStoreList){
		if(retailStoreList==null){
			return;
		}
		if(retailStoreList.isEmpty()){
			return;
		}
		addRetailStoreList( retailStoreList );
		
	}
	public  RetailStore removeRetailStore(RetailStore retailStoreIndex){
		
		int index = getRetailStoreList().indexOf(retailStoreIndex);
        if(index < 0){
        	String message = "RetailStore("+retailStoreIndex.getId()+") with version='"+retailStoreIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RetailStore retailStore = getRetailStoreList().get(index);        
        // retailStore.clearCityServiceCenter(); //disconnect with CityServiceCenter
        retailStore.clearFromAll(); //disconnect with CityServiceCenter
		
		boolean result = getRetailStoreList().planToRemove(retailStore);
        if(!result){
        	String message = "RetailStore("+retailStoreIndex.getId()+") with version='"+retailStoreIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return retailStore;
        
	
	}
	//断舍离
	public  void breakWithRetailStore(RetailStore retailStore){
		
		if(retailStore == null){
			return;
		}
		retailStore.setCityServiceCenter(null);
		//getRetailStoreList().remove();
	
	}
	
	public  boolean hasRetailStore(RetailStore retailStore){
	
		return getRetailStoreList().contains(retailStore);
  
	}
	
	public void copyRetailStoreFrom(RetailStore retailStore) {

		RetailStore retailStoreInList = findTheRetailStore(retailStore);
		RetailStore newRetailStore = new RetailStore();
		retailStoreInList.copyTo(newRetailStore);
		newRetailStore.setVersion(0);//will trigger copy
		getRetailStoreList().add(newRetailStore);
		addItemToFlexiableObject(COPIED_CHILD, newRetailStore);
	}
	
	public  RetailStore findTheRetailStore(RetailStore retailStore){
		
		int index =  getRetailStoreList().indexOf(retailStore);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "RetailStore("+retailStore.getId()+") with version='"+retailStore.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRetailStoreList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreList(){
		getRetailStoreList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getBelongsTo(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getCityPartnerList(), internalType);
		collectFromList(this, entityList, getPotentialCustomerList(), internalType);
		collectFromList(this, entityList, getCityEventList(), internalType);
		collectFromList(this, entityList, getRetailStoreList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getCityPartnerList());
		listOfList.add( getPotentialCustomerList());
		listOfList.add( getCityEventList());
		listOfList.add( getRetailStoreList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, FOUNDED_PROPERTY, getFounded());
		appendKeyValuePair(result, BELONGS_TO_PROPERTY, getBelongsTo());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, CITY_PARTNER_LIST, getCityPartnerList());
		if(!getCityPartnerList().isEmpty()){
			appendKeyValuePair(result, "cityPartnerCount", getCityPartnerList().getTotalCount());
			appendKeyValuePair(result, "cityPartnerCurrentPageNumber", getCityPartnerList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, POTENTIAL_CUSTOMER_LIST, getPotentialCustomerList());
		if(!getPotentialCustomerList().isEmpty()){
			appendKeyValuePair(result, "potentialCustomerCount", getPotentialCustomerList().getTotalCount());
			appendKeyValuePair(result, "potentialCustomerCurrentPageNumber", getPotentialCustomerList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, CITY_EVENT_LIST, getCityEventList());
		if(!getCityEventList().isEmpty()){
			appendKeyValuePair(result, "cityEventCount", getCityEventList().getTotalCount());
			appendKeyValuePair(result, "cityEventCurrentPageNumber", getCityEventList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, RETAIL_STORE_LIST, getRetailStoreList());
		if(!getRetailStoreList().isEmpty()){
			appendKeyValuePair(result, "retailStoreCount", getRetailStoreList().getTotalCount());
			appendKeyValuePair(result, "retailStoreCurrentPageNumber", getRetailStoreList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreCityServiceCenter){
		
		
			RetailStoreCityServiceCenter dest =(RetailStoreCityServiceCenter)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setFounded(getFounded());
			dest.setBelongsTo(getBelongsTo());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setCityPartnerList(getCityPartnerList());
			dest.setPotentialCustomerList(getPotentialCustomerList());
			dest.setCityEventList(getCityEventList());
			dest.setRetailStoreList(getRetailStoreList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreCityServiceCenter){
		
			
			RetailStoreCityServiceCenter dest =(RetailStoreCityServiceCenter)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeFounded(getFounded());
			dest.mergeBelongsTo(getBelongsTo());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());
			dest.mergeCityPartnerList(getCityPartnerList());
			dest.mergePotentialCustomerList(getPotentialCustomerList());
			dest.mergeCityEventList(getCityEventList());
			dest.mergeRetailStoreList(getRetailStoreList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreCityServiceCenter){
		
			
			RetailStoreCityServiceCenter dest =(RetailStoreCityServiceCenter)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeFounded(getFounded());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getFounded(), getBelongsTo(), getLastUpdateTime(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("RetailStoreCityServiceCenter{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		if(getBelongsTo() != null ){
 			stringBuilder.append("\tbelongsTo='RetailStoreProvinceCenter("+getBelongsTo().getId()+")';");
 		}
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

