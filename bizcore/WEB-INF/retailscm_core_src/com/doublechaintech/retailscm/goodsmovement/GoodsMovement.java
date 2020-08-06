
package com.doublechaintech.retailscm.goodsmovement;

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
import com.doublechaintech.retailscm.goods.Goods;









@JsonSerialize(using = GoodsMovementSerializer.class)
public class GoodsMovement extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String MOVE_TIME_PROPERTY             = "moveTime"          ;
	public static final String FACILITY_PROPERTY              = "facility"          ;
	public static final String FACILITY_ID_PROPERTY           = "facilityId"        ;
	public static final String FROM_IP_PROPERTY               = "fromIp"            ;
	public static final String USER_AGENT_PROPERTY            = "userAgent"         ;
	public static final String SESSION_ID_PROPERTY            = "sessionId"         ;
	public static final String LATITUDE_PROPERTY              = "latitude"          ;
	public static final String LONGITUDE_PROPERTY             = "longitude"         ;
	public static final String GOODS_PROPERTY                 = "goods"             ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="GoodsMovement";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getFacility();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		DateTime            	mMoveTime           ;
	protected		String              	mFacility           ;
	protected		String              	mFacilityId         ;
	protected		String              	mFromIp             ;
	protected		String              	mUserAgent          ;
	protected		String              	mSessionId          ;
	protected		BigDecimal          	mLatitude           ;
	protected		BigDecimal          	mLongitude          ;
	protected		Goods               	mGoods              ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	GoodsMovement(){
		// lazy load for all the properties
	}
	public 	static GoodsMovement withId(String id){
		GoodsMovement goodsMovement = new GoodsMovement();
		goodsMovement.setId(id);
		goodsMovement.setVersion(Integer.MAX_VALUE);
		return goodsMovement;
	}
	public 	static GoodsMovement refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setGoods( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(MOVE_TIME_PROPERTY.equals(property)){
			changeMoveTimeProperty(newValueExpr);
		}
		if(FACILITY_PROPERTY.equals(property)){
			changeFacilityProperty(newValueExpr);
		}
		if(FACILITY_ID_PROPERTY.equals(property)){
			changeFacilityIdProperty(newValueExpr);
		}
		if(FROM_IP_PROPERTY.equals(property)){
			changeFromIpProperty(newValueExpr);
		}
		if(USER_AGENT_PROPERTY.equals(property)){
			changeUserAgentProperty(newValueExpr);
		}
		if(SESSION_ID_PROPERTY.equals(property)){
			changeSessionIdProperty(newValueExpr);
		}
		if(LATITUDE_PROPERTY.equals(property)){
			changeLatitudeProperty(newValueExpr);
		}
		if(LONGITUDE_PROPERTY.equals(property)){
			changeLongitudeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeMoveTimeProperty(String newValueExpr){
	
		DateTime oldValue = getMoveTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateMoveTime(newValue);
		this.onChangeProperty(MOVE_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeFacilityProperty(String newValueExpr){
	
		String oldValue = getFacility();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateFacility(newValue);
		this.onChangeProperty(FACILITY_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeFacilityIdProperty(String newValueExpr){
	
		String oldValue = getFacilityId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateFacilityId(newValue);
		this.onChangeProperty(FACILITY_ID_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeFromIpProperty(String newValueExpr){
	
		String oldValue = getFromIp();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateFromIp(newValue);
		this.onChangeProperty(FROM_IP_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeUserAgentProperty(String newValueExpr){
	
		String oldValue = getUserAgent();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateUserAgent(newValue);
		this.onChangeProperty(USER_AGENT_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeSessionIdProperty(String newValueExpr){
	
		String oldValue = getSessionId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateSessionId(newValue);
		this.onChangeProperty(SESSION_ID_PROPERTY, oldValue, newValue);
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
     	
		if(MOVE_TIME_PROPERTY.equals(property)){
			return getMoveTime();
		}
		if(FACILITY_PROPERTY.equals(property)){
			return getFacility();
		}
		if(FACILITY_ID_PROPERTY.equals(property)){
			return getFacilityId();
		}
		if(FROM_IP_PROPERTY.equals(property)){
			return getFromIp();
		}
		if(USER_AGENT_PROPERTY.equals(property)){
			return getUserAgent();
		}
		if(SESSION_ID_PROPERTY.equals(property)){
			return getSessionId();
		}
		if(LATITUDE_PROPERTY.equals(property)){
			return getLatitude();
		}
		if(LONGITUDE_PROPERTY.equals(property)){
			return getLongitude();
		}
		if(GOODS_PROPERTY.equals(property)){
			return getGoods();
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
	public GoodsMovement updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setMoveTime(DateTime moveTime){
		this.mMoveTime = moveTime;;
	}
	public DateTime getMoveTime(){
		return this.mMoveTime;
	}
	public GoodsMovement updateMoveTime(DateTime moveTime){
		this.mMoveTime = moveTime;;
		this.changed = true;
		return this;
	}
	public void mergeMoveTime(DateTime moveTime){
		setMoveTime(moveTime);
	}
	
	
	public void setFacility(String facility){
		this.mFacility = trimString(facility);;
	}
	public String getFacility(){
		return this.mFacility;
	}
	public GoodsMovement updateFacility(String facility){
		this.mFacility = trimString(facility);;
		this.changed = true;
		return this;
	}
	public void mergeFacility(String facility){
		if(facility != null) { setFacility(facility);}
	}
	
	
	public void setFacilityId(String facilityId){
		this.mFacilityId = trimString(facilityId);;
	}
	public String getFacilityId(){
		return this.mFacilityId;
	}
	public GoodsMovement updateFacilityId(String facilityId){
		this.mFacilityId = trimString(facilityId);;
		this.changed = true;
		return this;
	}
	public void mergeFacilityId(String facilityId){
		if(facilityId != null) { setFacilityId(facilityId);}
	}
	
	
	public void setFromIp(String fromIp){
		this.mFromIp = trimString(fromIp);;
	}
	public String getFromIp(){
		return this.mFromIp;
	}
	public GoodsMovement updateFromIp(String fromIp){
		this.mFromIp = trimString(fromIp);;
		this.changed = true;
		return this;
	}
	public void mergeFromIp(String fromIp){
		if(fromIp != null) { setFromIp(fromIp);}
	}
	
	
	public void setUserAgent(String userAgent){
		this.mUserAgent = trimString(userAgent);;
	}
	public String getUserAgent(){
		return this.mUserAgent;
	}
	public GoodsMovement updateUserAgent(String userAgent){
		this.mUserAgent = trimString(userAgent);;
		this.changed = true;
		return this;
	}
	public void mergeUserAgent(String userAgent){
		if(userAgent != null) { setUserAgent(userAgent);}
	}
	
	
	public void setSessionId(String sessionId){
		this.mSessionId = trimString(sessionId);;
	}
	public String getSessionId(){
		return this.mSessionId;
	}
	public GoodsMovement updateSessionId(String sessionId){
		this.mSessionId = trimString(sessionId);;
		this.changed = true;
		return this;
	}
	public void mergeSessionId(String sessionId){
		if(sessionId != null) { setSessionId(sessionId);}
	}
	
	
	public void setLatitude(BigDecimal latitude){
		this.mLatitude = latitude;;
	}
	public BigDecimal getLatitude(){
		return this.mLatitude;
	}
	public GoodsMovement updateLatitude(BigDecimal latitude){
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
	public GoodsMovement updateLongitude(BigDecimal longitude){
		this.mLongitude = longitude;;
		this.changed = true;
		return this;
	}
	public void mergeLongitude(BigDecimal longitude){
		setLongitude(longitude);
	}
	
	
	public void setGoods(Goods goods){
		this.mGoods = goods;;
	}
	public Goods getGoods(){
		return this.mGoods;
	}
	public GoodsMovement updateGoods(Goods goods){
		this.mGoods = goods;;
		this.changed = true;
		return this;
	}
	public void mergeGoods(Goods goods){
		if(goods != null) { setGoods(goods);}
	}
	
	
	public void clearGoods(){
		setGoods ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public GoodsMovement updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getGoods(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, MOVE_TIME_PROPERTY, getMoveTime());
		appendKeyValuePair(result, FACILITY_PROPERTY, getFacility());
		appendKeyValuePair(result, FACILITY_ID_PROPERTY, getFacilityId());
		appendKeyValuePair(result, FROM_IP_PROPERTY, getFromIp());
		appendKeyValuePair(result, USER_AGENT_PROPERTY, getUserAgent());
		appendKeyValuePair(result, SESSION_ID_PROPERTY, getSessionId());
		appendKeyValuePair(result, LATITUDE_PROPERTY, getLatitude());
		appendKeyValuePair(result, LONGITUDE_PROPERTY, getLongitude());
		appendKeyValuePair(result, GOODS_PROPERTY, getGoods());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof GoodsMovement){
		
		
			GoodsMovement dest =(GoodsMovement)baseDest;
		
			dest.setId(getId());
			dest.setMoveTime(getMoveTime());
			dest.setFacility(getFacility());
			dest.setFacilityId(getFacilityId());
			dest.setFromIp(getFromIp());
			dest.setUserAgent(getUserAgent());
			dest.setSessionId(getSessionId());
			dest.setLatitude(getLatitude());
			dest.setLongitude(getLongitude());
			dest.setGoods(getGoods());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof GoodsMovement){
		
			
			GoodsMovement dest =(GoodsMovement)baseDest;
		
			dest.mergeId(getId());
			dest.mergeMoveTime(getMoveTime());
			dest.mergeFacility(getFacility());
			dest.mergeFacilityId(getFacilityId());
			dest.mergeFromIp(getFromIp());
			dest.mergeUserAgent(getUserAgent());
			dest.mergeSessionId(getSessionId());
			dest.mergeLatitude(getLatitude());
			dest.mergeLongitude(getLongitude());
			dest.mergeGoods(getGoods());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof GoodsMovement){
		
			
			GoodsMovement dest =(GoodsMovement)baseDest;
		
			dest.mergeId(getId());
			dest.mergeMoveTime(getMoveTime());
			dest.mergeFacility(getFacility());
			dest.mergeFacilityId(getFacilityId());
			dest.mergeFromIp(getFromIp());
			dest.mergeUserAgent(getUserAgent());
			dest.mergeSessionId(getSessionId());
			dest.mergeLatitude(getLatitude());
			dest.mergeLongitude(getLongitude());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getMoveTime(), getFacility(), getFacilityId(), getFromIp(), getUserAgent(), getSessionId(), getLatitude(), getLongitude(), getGoods(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("GoodsMovement{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tmoveTime='"+getMoveTime()+"';");
		stringBuilder.append("\tfacility='"+getFacility()+"';");
		stringBuilder.append("\tfacilityId='"+getFacilityId()+"';");
		stringBuilder.append("\tfromIp='"+getFromIp()+"';");
		stringBuilder.append("\tuserAgent='"+getUserAgent()+"';");
		stringBuilder.append("\tsessionId='"+getSessionId()+"';");
		stringBuilder.append("\tlatitude='"+getLatitude()+"';");
		stringBuilder.append("\tlongitude='"+getLongitude()+"';");
		if(getGoods() != null ){
 			stringBuilder.append("\tgoods='Goods("+getGoods().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

