
package com.doublechaintech.retailscm.keypairidentify;

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
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;

@JsonSerialize(using = KeypairIdentifySerializer.class)
public class KeypairIdentify extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String PUBLIC_KEY_PROPERTY            = "publicKey"         ;
	public static final String KEY_TYPE_PROPERTY              = "keyType"           ;
	public static final String SEC_USER_PROPERTY              = "secUser"           ;
	public static final String CREATE_TIME_PROPERTY           = "createTime"        ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="KeypairIdentify";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getPublicKey();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mPublicKey          ;
	protected		PublicKeyType       	mKeyType            ;
	protected		SecUser             	mSecUser            ;
	protected		DateTime            	mCreateTime         ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	KeypairIdentify(){
		// lazy load for all the properties
	}
	public 	static KeypairIdentify withId(String id){
		KeypairIdentify keypairIdentify = new KeypairIdentify();
		keypairIdentify.setId(id);
		keypairIdentify.setVersion(Integer.MAX_VALUE);
		return keypairIdentify;
	}
	public 	static KeypairIdentify refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setKeyType( null );
		setSecUser( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(PUBLIC_KEY_PROPERTY.equals(property)){
			changePublicKeyProperty(newValueExpr);
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			changeCreateTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changePublicKeyProperty(String newValueExpr){
	
		String oldValue = getPublicKey();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePublicKey(newValue);
		this.onChangeProperty(PUBLIC_KEY_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeCreateTimeProperty(String newValueExpr){
	
		DateTime oldValue = getCreateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCreateTime(newValue);
		this.onChangeProperty(CREATE_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(PUBLIC_KEY_PROPERTY.equals(property)){
			return getPublicKey();
		}
		if(KEY_TYPE_PROPERTY.equals(property)){
			return getKeyType();
		}
		if(SEC_USER_PROPERTY.equals(property)){
			return getSecUser();
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			return getCreateTime();
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
	public KeypairIdentify updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setPublicKey(String publicKey){
		this.mPublicKey = publicKey;;
	}
	public String getPublicKey(){
		return this.mPublicKey;
	}
	public KeypairIdentify updatePublicKey(String publicKey){
		this.mPublicKey = publicKey;;
		this.changed = true;
		return this;
	}
	public void mergePublicKey(String publicKey){
		if(publicKey != null) { setPublicKey(publicKey);}
	}
	
	
	public void setKeyType(PublicKeyType keyType){
		this.mKeyType = keyType;;
	}
	public PublicKeyType getKeyType(){
		return this.mKeyType;
	}
	public KeypairIdentify updateKeyType(PublicKeyType keyType){
		this.mKeyType = keyType;;
		this.changed = true;
		return this;
	}
	public void mergeKeyType(PublicKeyType keyType){
		if(keyType != null) { setKeyType(keyType);}
	}
	
	
	public void clearKeyType(){
		setKeyType ( null );
		this.changed = true;
	}
	
	public void setSecUser(SecUser secUser){
		this.mSecUser = secUser;;
	}
	public SecUser getSecUser(){
		return this.mSecUser;
	}
	public KeypairIdentify updateSecUser(SecUser secUser){
		this.mSecUser = secUser;;
		this.changed = true;
		return this;
	}
	public void mergeSecUser(SecUser secUser){
		if(secUser != null) { setSecUser(secUser);}
	}
	
	
	public void clearSecUser(){
		setSecUser ( null );
		this.changed = true;
	}
	
	public void setCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
	}
	public DateTime getCreateTime(){
		return this.mCreateTime;
	}
	public KeypairIdentify updateCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
		this.changed = true;
		return this;
	}
	public void mergeCreateTime(DateTime createTime){
		setCreateTime(createTime);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public KeypairIdentify updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getKeyType(), internalType);
		addToEntityList(this, entityList, getSecUser(), internalType);

		
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
		appendKeyValuePair(result, PUBLIC_KEY_PROPERTY, getPublicKey());
		appendKeyValuePair(result, KEY_TYPE_PROPERTY, getKeyType());
		appendKeyValuePair(result, SEC_USER_PROPERTY, getSecUser());
		appendKeyValuePair(result, CREATE_TIME_PROPERTY, getCreateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof KeypairIdentify){
		
		
			KeypairIdentify dest =(KeypairIdentify)baseDest;
		
			dest.setId(getId());
			dest.setPublicKey(getPublicKey());
			dest.setKeyType(getKeyType());
			dest.setSecUser(getSecUser());
			dest.setCreateTime(getCreateTime());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof KeypairIdentify){
		
			
			KeypairIdentify dest =(KeypairIdentify)baseDest;
		
			dest.mergeId(getId());
			dest.mergePublicKey(getPublicKey());
			dest.mergeKeyType(getKeyType());
			dest.mergeSecUser(getSecUser());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof KeypairIdentify){
		
			
			KeypairIdentify dest =(KeypairIdentify)baseDest;
		
			dest.mergeId(getId());
			dest.mergePublicKey(getPublicKey());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getPublicKey(), getKeyType(), getSecUser(), getCreateTime(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("KeypairIdentify{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tpublicKey='"+getPublicKey()+"';");
		if(getKeyType() != null ){
 			stringBuilder.append("\tkeyType='PublicKeyType("+getKeyType().getId()+")';");
 		}
		if(getSecUser() != null ){
 			stringBuilder.append("\tsecUser='SecUser("+getSecUser().getId()+")';");
 		}
		stringBuilder.append("\tcreateTime='"+getCreateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

