
package com.doublechaintech.retailscm.retailstore;

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
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;
import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

@JsonSerialize(using = RetailStoreSerializer.class)
public class RetailStore extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String TELEPHONE_PROPERTY             = "telephone"         ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String RETAIL_STORE_COUNTRY_CENTER_PROPERTY = "retailStoreCountryCenter";
	public static final String CITY_SERVICE_CENTER_PROPERTY   = "cityServiceCenter" ;
	public static final String CREATION_PROPERTY              = "creation"          ;
	public static final String INVESTMENT_INVITATION_PROPERTY = "investmentInvitation";
	public static final String FRANCHISING_PROPERTY           = "franchising"       ;
	public static final String DECORATION_PROPERTY            = "decoration"        ;
	public static final String OPENING_PROPERTY               = "opening"           ;
	public static final String CLOSING_PROPERTY               = "closing"           ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String LATITUDE_PROPERTY              = "latitude"          ;
	public static final String LONGITUDE_PROPERTY             = "longitude"         ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String CONSUMER_ORDER_LIST                      = "consumerOrderList" ;
	public static final String RETAIL_STORE_ORDER_LIST                  = "retailStoreOrderList";
	public static final String GOODS_LIST                               = "goodsList"         ;
	public static final String TRANSPORT_TASK_LIST                      = "transportTaskList" ;
	public static final String ACCOUNT_SET_LIST                         = "accountSetList"    ;

	public static final String INTERNAL_TYPE="RetailStore";
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
	protected		String              	mTelephone          ;
	protected		String              	mOwner              ;
	protected		RetailStoreCountryCenter	mRetailStoreCountryCenter;
	protected		RetailStoreCityServiceCenter	mCityServiceCenter  ;
	protected		RetailStoreCreation 	mCreation           ;
	protected		RetailStoreInvestmentInvitation	mInvestmentInvitation;
	protected		RetailStoreFranchising	mFranchising        ;
	protected		RetailStoreDecoration	mDecoration         ;
	protected		RetailStoreOpening  	mOpening            ;
	protected		RetailStoreClosing  	mClosing            ;
	protected		Date                	mFounded            ;
	protected		BigDecimal          	mLatitude           ;
	protected		BigDecimal          	mLongitude          ;
	protected		String              	mDescription        ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ConsumerOrder>	mConsumerOrderList  ;
	protected		SmartList<RetailStoreOrder>	mRetailStoreOrderList;
	protected		SmartList<Goods>    	mGoodsList          ;
	protected		SmartList<TransportTask>	mTransportTaskList  ;
	protected		SmartList<AccountSet>	mAccountSetList     ;

	
		
	public 	RetailStore(){
		// lazy load for all the properties
	}
	public 	static RetailStore withId(String id){
		RetailStore retailStore = new RetailStore();
		retailStore.setId(id);
		retailStore.setVersion(Integer.MAX_VALUE);
		return retailStore;
	}
	public 	static RetailStore refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setRetailStoreCountryCenter( null );
		setCityServiceCenter( null );
		setCreation( null );
		setInvestmentInvitation( null );
		setFranchising( null );
		setDecoration( null );
		setOpening( null );
		setClosing( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(TELEPHONE_PROPERTY.equals(property)){
			changeTelephoneProperty(newValueExpr);
		}
		if(OWNER_PROPERTY.equals(property)){
			changeOwnerProperty(newValueExpr);
		}
		if(FOUNDED_PROPERTY.equals(property)){
			changeFoundedProperty(newValueExpr);
		}
		if(LATITUDE_PROPERTY.equals(property)){
			changeLatitudeProperty(newValueExpr);
		}
		if(LONGITUDE_PROPERTY.equals(property)){
			changeLongitudeProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
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
			
			
			
	protected void changeTelephoneProperty(String newValueExpr){
	
		String oldValue = getTelephone();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTelephone(newValue);
		this.onChangeProperty(TELEPHONE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeOwnerProperty(String newValueExpr){
	
		String oldValue = getOwner();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateOwner(newValue);
		this.onChangeProperty(OWNER_PROPERTY, oldValue, newValue);
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
			
			
			
	protected void changeDescriptionProperty(String newValueExpr){
	
		String oldValue = getDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDescription(newValue);
		this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
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
		if(TELEPHONE_PROPERTY.equals(property)){
			return getTelephone();
		}
		if(OWNER_PROPERTY.equals(property)){
			return getOwner();
		}
		if(RETAIL_STORE_COUNTRY_CENTER_PROPERTY.equals(property)){
			return getRetailStoreCountryCenter();
		}
		if(CITY_SERVICE_CENTER_PROPERTY.equals(property)){
			return getCityServiceCenter();
		}
		if(CREATION_PROPERTY.equals(property)){
			return getCreation();
		}
		if(INVESTMENT_INVITATION_PROPERTY.equals(property)){
			return getInvestmentInvitation();
		}
		if(FRANCHISING_PROPERTY.equals(property)){
			return getFranchising();
		}
		if(DECORATION_PROPERTY.equals(property)){
			return getDecoration();
		}
		if(OPENING_PROPERTY.equals(property)){
			return getOpening();
		}
		if(CLOSING_PROPERTY.equals(property)){
			return getClosing();
		}
		if(FOUNDED_PROPERTY.equals(property)){
			return getFounded();
		}
		if(LATITUDE_PROPERTY.equals(property)){
			return getLatitude();
		}
		if(LONGITUDE_PROPERTY.equals(property)){
			return getLongitude();
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			return getDescription();
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			return getLastUpdateTime();
		}
		if(CONSUMER_ORDER_LIST.equals(property)){
			List<BaseEntity> list = getConsumerOrderList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(RETAIL_STORE_ORDER_LIST.equals(property)){
			List<BaseEntity> list = getRetailStoreOrderList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(GOODS_LIST.equals(property)){
			List<BaseEntity> list = getGoodsList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(TRANSPORT_TASK_LIST.equals(property)){
			List<BaseEntity> list = getTransportTaskList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(ACCOUNT_SET_LIST.equals(property)){
			List<BaseEntity> list = getAccountSetList().stream().map(item->item).collect(Collectors.toList());
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
	public RetailStore updateId(String id){
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
	public RetailStore updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setTelephone(String telephone){
		this.mTelephone = trimString(telephone);;
	}
	public String getTelephone(){
		return this.mTelephone;
	}
	public RetailStore updateTelephone(String telephone){
		this.mTelephone = trimString(telephone);;
		this.changed = true;
		return this;
	}
	public void mergeTelephone(String telephone){
		if(telephone != null) { setTelephone(telephone);}
	}
	
	
	public void setOwner(String owner){
		this.mOwner = trimString(owner);;
	}
	public String getOwner(){
		return this.mOwner;
	}
	public RetailStore updateOwner(String owner){
		this.mOwner = trimString(owner);;
		this.changed = true;
		return this;
	}
	public void mergeOwner(String owner){
		if(owner != null) { setOwner(owner);}
	}
	
	
	public void setRetailStoreCountryCenter(RetailStoreCountryCenter retailStoreCountryCenter){
		this.mRetailStoreCountryCenter = retailStoreCountryCenter;;
	}
	public RetailStoreCountryCenter getRetailStoreCountryCenter(){
		return this.mRetailStoreCountryCenter;
	}
	public RetailStore updateRetailStoreCountryCenter(RetailStoreCountryCenter retailStoreCountryCenter){
		this.mRetailStoreCountryCenter = retailStoreCountryCenter;;
		this.changed = true;
		return this;
	}
	public void mergeRetailStoreCountryCenter(RetailStoreCountryCenter retailStoreCountryCenter){
		if(retailStoreCountryCenter != null) { setRetailStoreCountryCenter(retailStoreCountryCenter);}
	}
	
	
	public void clearRetailStoreCountryCenter(){
		setRetailStoreCountryCenter ( null );
		this.changed = true;
	}
	
	public void setCityServiceCenter(RetailStoreCityServiceCenter cityServiceCenter){
		this.mCityServiceCenter = cityServiceCenter;;
	}
	public RetailStoreCityServiceCenter getCityServiceCenter(){
		return this.mCityServiceCenter;
	}
	public RetailStore updateCityServiceCenter(RetailStoreCityServiceCenter cityServiceCenter){
		this.mCityServiceCenter = cityServiceCenter;;
		this.changed = true;
		return this;
	}
	public void mergeCityServiceCenter(RetailStoreCityServiceCenter cityServiceCenter){
		if(cityServiceCenter != null) { setCityServiceCenter(cityServiceCenter);}
	}
	
	
	public void clearCityServiceCenter(){
		setCityServiceCenter ( null );
		this.changed = true;
	}
	
	public void setCreation(RetailStoreCreation creation){
		this.mCreation = creation;;
	}
	public RetailStoreCreation getCreation(){
		return this.mCreation;
	}
	public RetailStore updateCreation(RetailStoreCreation creation){
		this.mCreation = creation;;
		this.changed = true;
		return this;
	}
	public void mergeCreation(RetailStoreCreation creation){
		if(creation != null) { setCreation(creation);}
	}
	
	
	public void clearCreation(){
		setCreation ( null );
		this.changed = true;
	}
	
	public void setInvestmentInvitation(RetailStoreInvestmentInvitation investmentInvitation){
		this.mInvestmentInvitation = investmentInvitation;;
	}
	public RetailStoreInvestmentInvitation getInvestmentInvitation(){
		return this.mInvestmentInvitation;
	}
	public RetailStore updateInvestmentInvitation(RetailStoreInvestmentInvitation investmentInvitation){
		this.mInvestmentInvitation = investmentInvitation;;
		this.changed = true;
		return this;
	}
	public void mergeInvestmentInvitation(RetailStoreInvestmentInvitation investmentInvitation){
		if(investmentInvitation != null) { setInvestmentInvitation(investmentInvitation);}
	}
	
	
	public void clearInvestmentInvitation(){
		setInvestmentInvitation ( null );
		this.changed = true;
	}
	
	public void setFranchising(RetailStoreFranchising franchising){
		this.mFranchising = franchising;;
	}
	public RetailStoreFranchising getFranchising(){
		return this.mFranchising;
	}
	public RetailStore updateFranchising(RetailStoreFranchising franchising){
		this.mFranchising = franchising;;
		this.changed = true;
		return this;
	}
	public void mergeFranchising(RetailStoreFranchising franchising){
		if(franchising != null) { setFranchising(franchising);}
	}
	
	
	public void clearFranchising(){
		setFranchising ( null );
		this.changed = true;
	}
	
	public void setDecoration(RetailStoreDecoration decoration){
		this.mDecoration = decoration;;
	}
	public RetailStoreDecoration getDecoration(){
		return this.mDecoration;
	}
	public RetailStore updateDecoration(RetailStoreDecoration decoration){
		this.mDecoration = decoration;;
		this.changed = true;
		return this;
	}
	public void mergeDecoration(RetailStoreDecoration decoration){
		if(decoration != null) { setDecoration(decoration);}
	}
	
	
	public void clearDecoration(){
		setDecoration ( null );
		this.changed = true;
	}
	
	public void setOpening(RetailStoreOpening opening){
		this.mOpening = opening;;
	}
	public RetailStoreOpening getOpening(){
		return this.mOpening;
	}
	public RetailStore updateOpening(RetailStoreOpening opening){
		this.mOpening = opening;;
		this.changed = true;
		return this;
	}
	public void mergeOpening(RetailStoreOpening opening){
		if(opening != null) { setOpening(opening);}
	}
	
	
	public void clearOpening(){
		setOpening ( null );
		this.changed = true;
	}
	
	public void setClosing(RetailStoreClosing closing){
		this.mClosing = closing;;
	}
	public RetailStoreClosing getClosing(){
		return this.mClosing;
	}
	public RetailStore updateClosing(RetailStoreClosing closing){
		this.mClosing = closing;;
		this.changed = true;
		return this;
	}
	public void mergeClosing(RetailStoreClosing closing){
		if(closing != null) { setClosing(closing);}
	}
	
	
	public void clearClosing(){
		setClosing ( null );
		this.changed = true;
	}
	
	public void setFounded(Date founded){
		this.mFounded = founded;;
	}
	public Date getFounded(){
		return this.mFounded;
	}
	public RetailStore updateFounded(Date founded){
		this.mFounded = founded;;
		this.changed = true;
		return this;
	}
	public void mergeFounded(Date founded){
		setFounded(founded);
	}
	
	
	public void setLatitude(BigDecimal latitude){
		this.mLatitude = latitude;;
	}
	public BigDecimal getLatitude(){
		return this.mLatitude;
	}
	public RetailStore updateLatitude(BigDecimal latitude){
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
	public RetailStore updateLongitude(BigDecimal longitude){
		this.mLongitude = longitude;;
		this.changed = true;
		return this;
	}
	public void mergeLongitude(BigDecimal longitude){
		setLongitude(longitude);
	}
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public RetailStore updateDescription(String description){
		this.mDescription = trimString(description);;
		this.changed = true;
		return this;
	}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}
	
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public RetailStore updateLastUpdateTime(DateTime lastUpdateTime){
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
	public RetailStore updateVersion(int version){
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
			consumerOrder.setStore(this);
		}

		this.mConsumerOrderList = consumerOrderList;
		this.mConsumerOrderList.setListInternalName (CONSUMER_ORDER_LIST );
		
	}
	
	public  void addConsumerOrder(ConsumerOrder consumerOrder){
		consumerOrder.setStore(this);
		getConsumerOrderList().add(consumerOrder);
	}
	public  void addConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList){
		for( ConsumerOrder consumerOrder:consumerOrderList){
			consumerOrder.setStore(this);
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
        // consumerOrder.clearStore(); //disconnect with Store
        consumerOrder.clearFromAll(); //disconnect with Store
		
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
		consumerOrder.setStore(null);
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
			retailStoreOrder.setBuyer(this);
		}

		this.mRetailStoreOrderList = retailStoreOrderList;
		this.mRetailStoreOrderList.setListInternalName (RETAIL_STORE_ORDER_LIST );
		
	}
	
	public  void addRetailStoreOrder(RetailStoreOrder retailStoreOrder){
		retailStoreOrder.setBuyer(this);
		getRetailStoreOrderList().add(retailStoreOrder);
	}
	public  void addRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList){
		for( RetailStoreOrder retailStoreOrder:retailStoreOrderList){
			retailStoreOrder.setBuyer(this);
		}
		getRetailStoreOrderList().addAll(retailStoreOrderList);
	}
	public  void mergeRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList){
		if(retailStoreOrderList==null){
			return;
		}
		if(retailStoreOrderList.isEmpty()){
			return;
		}
		addRetailStoreOrderList( retailStoreOrderList );
		
	}
	public  RetailStoreOrder removeRetailStoreOrder(RetailStoreOrder retailStoreOrderIndex){
		
		int index = getRetailStoreOrderList().indexOf(retailStoreOrderIndex);
        if(index < 0){
        	String message = "RetailStoreOrder("+retailStoreOrderIndex.getId()+") with version='"+retailStoreOrderIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RetailStoreOrder retailStoreOrder = getRetailStoreOrderList().get(index);        
        // retailStoreOrder.clearBuyer(); //disconnect with Buyer
        retailStoreOrder.clearFromAll(); //disconnect with Buyer
		
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
		retailStoreOrder.setBuyer(null);
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
			goods.setRetailStore(this);
		}

		this.mGoodsList = goodsList;
		this.mGoodsList.setListInternalName (GOODS_LIST );
		
	}
	
	public  void addGoods(Goods goods){
		goods.setRetailStore(this);
		getGoodsList().add(goods);
	}
	public  void addGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setRetailStore(this);
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
        // goods.clearRetailStore(); //disconnect with RetailStore
        goods.clearFromAll(); //disconnect with RetailStore
		
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
		goods.setRetailStore(null);
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
			transportTask.setEnd(this);
		}

		this.mTransportTaskList = transportTaskList;
		this.mTransportTaskList.setListInternalName (TRANSPORT_TASK_LIST );
		
	}
	
	public  void addTransportTask(TransportTask transportTask){
		transportTask.setEnd(this);
		getTransportTaskList().add(transportTask);
	}
	public  void addTransportTaskList(SmartList<TransportTask> transportTaskList){
		for( TransportTask transportTask:transportTaskList){
			transportTask.setEnd(this);
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
        // transportTask.clearEnd(); //disconnect with End
        transportTask.clearFromAll(); //disconnect with End
		
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
		transportTask.setEnd(null);
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
	
	
	


	public  SmartList<AccountSet> getAccountSetList(){
		if(this.mAccountSetList == null){
			this.mAccountSetList = new SmartList<AccountSet>();
			this.mAccountSetList.setListInternalName (ACCOUNT_SET_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mAccountSetList;	
	}
	public  void setAccountSetList(SmartList<AccountSet> accountSetList){
		for( AccountSet accountSet:accountSetList){
			accountSet.setRetailStore(this);
		}

		this.mAccountSetList = accountSetList;
		this.mAccountSetList.setListInternalName (ACCOUNT_SET_LIST );
		
	}
	
	public  void addAccountSet(AccountSet accountSet){
		accountSet.setRetailStore(this);
		getAccountSetList().add(accountSet);
	}
	public  void addAccountSetList(SmartList<AccountSet> accountSetList){
		for( AccountSet accountSet:accountSetList){
			accountSet.setRetailStore(this);
		}
		getAccountSetList().addAll(accountSetList);
	}
	public  void mergeAccountSetList(SmartList<AccountSet> accountSetList){
		if(accountSetList==null){
			return;
		}
		if(accountSetList.isEmpty()){
			return;
		}
		addAccountSetList( accountSetList );
		
	}
	public  AccountSet removeAccountSet(AccountSet accountSetIndex){
		
		int index = getAccountSetList().indexOf(accountSetIndex);
        if(index < 0){
        	String message = "AccountSet("+accountSetIndex.getId()+") with version='"+accountSetIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        AccountSet accountSet = getAccountSetList().get(index);        
        // accountSet.clearRetailStore(); //disconnect with RetailStore
        accountSet.clearFromAll(); //disconnect with RetailStore
		
		boolean result = getAccountSetList().planToRemove(accountSet);
        if(!result){
        	String message = "AccountSet("+accountSetIndex.getId()+") with version='"+accountSetIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return accountSet;
        
	
	}
	//断舍离
	public  void breakWithAccountSet(AccountSet accountSet){
		
		if(accountSet == null){
			return;
		}
		accountSet.setRetailStore(null);
		//getAccountSetList().remove();
	
	}
	
	public  boolean hasAccountSet(AccountSet accountSet){
	
		return getAccountSetList().contains(accountSet);
  
	}
	
	public void copyAccountSetFrom(AccountSet accountSet) {

		AccountSet accountSetInList = findTheAccountSet(accountSet);
		AccountSet newAccountSet = new AccountSet();
		accountSetInList.copyTo(newAccountSet);
		newAccountSet.setVersion(0);//will trigger copy
		getAccountSetList().add(newAccountSet);
		addItemToFlexiableObject(COPIED_CHILD, newAccountSet);
	}
	
	public  AccountSet findTheAccountSet(AccountSet accountSet){
		
		int index =  getAccountSetList().indexOf(accountSet);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "AccountSet("+accountSet.getId()+") with version='"+accountSet.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getAccountSetList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpAccountSetList(){
		getAccountSetList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getRetailStoreCountryCenter(), internalType);
		addToEntityList(this, entityList, getCityServiceCenter(), internalType);
		addToEntityList(this, entityList, getCreation(), internalType);
		addToEntityList(this, entityList, getInvestmentInvitation(), internalType);
		addToEntityList(this, entityList, getFranchising(), internalType);
		addToEntityList(this, entityList, getDecoration(), internalType);
		addToEntityList(this, entityList, getOpening(), internalType);
		addToEntityList(this, entityList, getClosing(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getConsumerOrderList(), internalType);
		collectFromList(this, entityList, getRetailStoreOrderList(), internalType);
		collectFromList(this, entityList, getGoodsList(), internalType);
		collectFromList(this, entityList, getTransportTaskList(), internalType);
		collectFromList(this, entityList, getAccountSetList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getConsumerOrderList());
		listOfList.add( getRetailStoreOrderList());
		listOfList.add( getGoodsList());
		listOfList.add( getTransportTaskList());
		listOfList.add( getAccountSetList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, TELEPHONE_PROPERTY, getTelephone());
		appendKeyValuePair(result, OWNER_PROPERTY, getOwner());
		appendKeyValuePair(result, RETAIL_STORE_COUNTRY_CENTER_PROPERTY, getRetailStoreCountryCenter());
		appendKeyValuePair(result, CITY_SERVICE_CENTER_PROPERTY, getCityServiceCenter());
		appendKeyValuePair(result, CREATION_PROPERTY, getCreation());
		appendKeyValuePair(result, INVESTMENT_INVITATION_PROPERTY, getInvestmentInvitation());
		appendKeyValuePair(result, FRANCHISING_PROPERTY, getFranchising());
		appendKeyValuePair(result, DECORATION_PROPERTY, getDecoration());
		appendKeyValuePair(result, OPENING_PROPERTY, getOpening());
		appendKeyValuePair(result, CLOSING_PROPERTY, getClosing());
		appendKeyValuePair(result, FOUNDED_PROPERTY, getFounded());
		appendKeyValuePair(result, LATITUDE_PROPERTY, getLatitude());
		appendKeyValuePair(result, LONGITUDE_PROPERTY, getLongitude());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, CONSUMER_ORDER_LIST, getConsumerOrderList());
		if(!getConsumerOrderList().isEmpty()){
			appendKeyValuePair(result, "consumerOrderCount", getConsumerOrderList().getTotalCount());
			appendKeyValuePair(result, "consumerOrderCurrentPageNumber", getConsumerOrderList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, RETAIL_STORE_ORDER_LIST, getRetailStoreOrderList());
		if(!getRetailStoreOrderList().isEmpty()){
			appendKeyValuePair(result, "retailStoreOrderCount", getRetailStoreOrderList().getTotalCount());
			appendKeyValuePair(result, "retailStoreOrderCurrentPageNumber", getRetailStoreOrderList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, GOODS_LIST, getGoodsList());
		if(!getGoodsList().isEmpty()){
			appendKeyValuePair(result, "goodsCount", getGoodsList().getTotalCount());
			appendKeyValuePair(result, "goodsCurrentPageNumber", getGoodsList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TRANSPORT_TASK_LIST, getTransportTaskList());
		if(!getTransportTaskList().isEmpty()){
			appendKeyValuePair(result, "transportTaskCount", getTransportTaskList().getTotalCount());
			appendKeyValuePair(result, "transportTaskCurrentPageNumber", getTransportTaskList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, ACCOUNT_SET_LIST, getAccountSetList());
		if(!getAccountSetList().isEmpty()){
			appendKeyValuePair(result, "accountSetCount", getAccountSetList().getTotalCount());
			appendKeyValuePair(result, "accountSetCurrentPageNumber", getAccountSetList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStore){
		
		
			RetailStore dest =(RetailStore)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setTelephone(getTelephone());
			dest.setOwner(getOwner());
			dest.setRetailStoreCountryCenter(getRetailStoreCountryCenter());
			dest.setCityServiceCenter(getCityServiceCenter());
			dest.setCreation(getCreation());
			dest.setInvestmentInvitation(getInvestmentInvitation());
			dest.setFranchising(getFranchising());
			dest.setDecoration(getDecoration());
			dest.setOpening(getOpening());
			dest.setClosing(getClosing());
			dest.setFounded(getFounded());
			dest.setLatitude(getLatitude());
			dest.setLongitude(getLongitude());
			dest.setDescription(getDescription());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setConsumerOrderList(getConsumerOrderList());
			dest.setRetailStoreOrderList(getRetailStoreOrderList());
			dest.setGoodsList(getGoodsList());
			dest.setTransportTaskList(getTransportTaskList());
			dest.setAccountSetList(getAccountSetList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStore){
		
			
			RetailStore dest =(RetailStore)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeTelephone(getTelephone());
			dest.mergeOwner(getOwner());
			dest.mergeRetailStoreCountryCenter(getRetailStoreCountryCenter());
			dest.mergeCityServiceCenter(getCityServiceCenter());
			dest.mergeCreation(getCreation());
			dest.mergeInvestmentInvitation(getInvestmentInvitation());
			dest.mergeFranchising(getFranchising());
			dest.mergeDecoration(getDecoration());
			dest.mergeOpening(getOpening());
			dest.mergeClosing(getClosing());
			dest.mergeFounded(getFounded());
			dest.mergeLatitude(getLatitude());
			dest.mergeLongitude(getLongitude());
			dest.mergeDescription(getDescription());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());
			dest.mergeConsumerOrderList(getConsumerOrderList());
			dest.mergeRetailStoreOrderList(getRetailStoreOrderList());
			dest.mergeGoodsList(getGoodsList());
			dest.mergeTransportTaskList(getTransportTaskList());
			dest.mergeAccountSetList(getAccountSetList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStore){
		
			
			RetailStore dest =(RetailStore)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeTelephone(getTelephone());
			dest.mergeOwner(getOwner());
			dest.mergeFounded(getFounded());
			dest.mergeLatitude(getLatitude());
			dest.mergeLongitude(getLongitude());
			dest.mergeDescription(getDescription());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getTelephone(), getOwner(), getRetailStoreCountryCenter(), getCityServiceCenter(), getCreation(), getInvestmentInvitation(), getFranchising(), getDecoration(), getOpening(), getClosing(), getFounded(), getLatitude(), getLongitude(), getDescription(), getLastUpdateTime(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("RetailStore{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\ttelephone='"+getTelephone()+"';");
		stringBuilder.append("\towner='"+getOwner()+"';");
		if(getRetailStoreCountryCenter() != null ){
 			stringBuilder.append("\tretailStoreCountryCenter='RetailStoreCountryCenter("+getRetailStoreCountryCenter().getId()+")';");
 		}
		if(getCityServiceCenter() != null ){
 			stringBuilder.append("\tcityServiceCenter='RetailStoreCityServiceCenter("+getCityServiceCenter().getId()+")';");
 		}
		if(getCreation() != null ){
 			stringBuilder.append("\tcreation='RetailStoreCreation("+getCreation().getId()+")';");
 		}
		if(getInvestmentInvitation() != null ){
 			stringBuilder.append("\tinvestmentInvitation='RetailStoreInvestmentInvitation("+getInvestmentInvitation().getId()+")';");
 		}
		if(getFranchising() != null ){
 			stringBuilder.append("\tfranchising='RetailStoreFranchising("+getFranchising().getId()+")';");
 		}
		if(getDecoration() != null ){
 			stringBuilder.append("\tdecoration='RetailStoreDecoration("+getDecoration().getId()+")';");
 		}
		if(getOpening() != null ){
 			stringBuilder.append("\topening='RetailStoreOpening("+getOpening().getId()+")';");
 		}
		if(getClosing() != null ){
 			stringBuilder.append("\tclosing='RetailStoreClosing("+getClosing().getId()+")';");
 		}
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		stringBuilder.append("\tlatitude='"+getLatitude()+"';");
		stringBuilder.append("\tlongitude='"+getLongitude()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

