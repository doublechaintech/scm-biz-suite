
package com.doublechaintech.retailscm.publickeytype;

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
import com.doublechaintech.retailscm.userdomain.UserDomain;
import com.doublechaintech.retailscm.keypairidentify.KeypairIdentify;

@JsonSerialize(using = PublicKeyTypeSerializer.class)
public class PublicKeyType extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String DOMAIN_PROPERTY                = "domain"            ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String KEYPAIR_IDENTIFY_LIST                    = "keypairIdentifyList";

	public static final String INTERNAL_TYPE="PublicKeyType";
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
	protected		String              	mCode               ;
	protected		UserDomain          	mDomain             ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<KeypairIdentify>	mKeypairIdentifyList;

	
		
	public 	PublicKeyType(){
		// lazy load for all the properties
	}
	public 	static PublicKeyType withId(String id){
		PublicKeyType publicKeyType = new PublicKeyType();
		publicKeyType.setId(id);
		publicKeyType.setVersion(Integer.MAX_VALUE);
		return publicKeyType;
	}
	public 	static PublicKeyType refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setDomain( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(CODE_PROPERTY.equals(property)){
			changeCodeProperty(newValueExpr);
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
			
			
			
	protected void changeCodeProperty(String newValueExpr){
	
		String oldValue = getCode();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCode(newValue);
		this.onChangeProperty(CODE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(CODE_PROPERTY.equals(property)){
			return getCode();
		}
		if(DOMAIN_PROPERTY.equals(property)){
			return getDomain();
		}
		if(KEYPAIR_IDENTIFY_LIST.equals(property)){
			List<BaseEntity> list = getKeypairIdentifyList().stream().map(item->item).collect(Collectors.toList());
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
	public PublicKeyType updateId(String id){
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
	public PublicKeyType updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setCode(String code){
		this.mCode = trimString(code);;
	}
	public String getCode(){
		return this.mCode;
	}
	public PublicKeyType updateCode(String code){
		this.mCode = trimString(code);;
		this.changed = true;
		return this;
	}
	public void mergeCode(String code){
		if(code != null) { setCode(code);}
	}
	
	
	public void setDomain(UserDomain domain){
		this.mDomain = domain;;
	}
	public UserDomain getDomain(){
		return this.mDomain;
	}
	public PublicKeyType updateDomain(UserDomain domain){
		this.mDomain = domain;;
		this.changed = true;
		return this;
	}
	public void mergeDomain(UserDomain domain){
		if(domain != null) { setDomain(domain);}
	}
	
	
	public void clearDomain(){
		setDomain ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public PublicKeyType updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<KeypairIdentify> getKeypairIdentifyList(){
		if(this.mKeypairIdentifyList == null){
			this.mKeypairIdentifyList = new SmartList<KeypairIdentify>();
			this.mKeypairIdentifyList.setListInternalName (KEYPAIR_IDENTIFY_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mKeypairIdentifyList;	
	}
	public  void setKeypairIdentifyList(SmartList<KeypairIdentify> keypairIdentifyList){
		for( KeypairIdentify keypairIdentify:keypairIdentifyList){
			keypairIdentify.setKeyType(this);
		}

		this.mKeypairIdentifyList = keypairIdentifyList;
		this.mKeypairIdentifyList.setListInternalName (KEYPAIR_IDENTIFY_LIST );
		
	}
	
	public  void addKeypairIdentify(KeypairIdentify keypairIdentify){
		keypairIdentify.setKeyType(this);
		getKeypairIdentifyList().add(keypairIdentify);
	}
	public  void addKeypairIdentifyList(SmartList<KeypairIdentify> keypairIdentifyList){
		for( KeypairIdentify keypairIdentify:keypairIdentifyList){
			keypairIdentify.setKeyType(this);
		}
		getKeypairIdentifyList().addAll(keypairIdentifyList);
	}
	public  void mergeKeypairIdentifyList(SmartList<KeypairIdentify> keypairIdentifyList){
		if(keypairIdentifyList==null){
			return;
		}
		if(keypairIdentifyList.isEmpty()){
			return;
		}
		addKeypairIdentifyList( keypairIdentifyList );
		
	}
	public  KeypairIdentify removeKeypairIdentify(KeypairIdentify keypairIdentifyIndex){
		
		int index = getKeypairIdentifyList().indexOf(keypairIdentifyIndex);
        if(index < 0){
        	String message = "KeypairIdentify("+keypairIdentifyIndex.getId()+") with version='"+keypairIdentifyIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        KeypairIdentify keypairIdentify = getKeypairIdentifyList().get(index);        
        // keypairIdentify.clearKeyType(); //disconnect with KeyType
        keypairIdentify.clearFromAll(); //disconnect with KeyType
		
		boolean result = getKeypairIdentifyList().planToRemove(keypairIdentify);
        if(!result){
        	String message = "KeypairIdentify("+keypairIdentifyIndex.getId()+") with version='"+keypairIdentifyIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return keypairIdentify;
        
	
	}
	//断舍离
	public  void breakWithKeypairIdentify(KeypairIdentify keypairIdentify){
		
		if(keypairIdentify == null){
			return;
		}
		keypairIdentify.setKeyType(null);
		//getKeypairIdentifyList().remove();
	
	}
	
	public  boolean hasKeypairIdentify(KeypairIdentify keypairIdentify){
	
		return getKeypairIdentifyList().contains(keypairIdentify);
  
	}
	
	public void copyKeypairIdentifyFrom(KeypairIdentify keypairIdentify) {

		KeypairIdentify keypairIdentifyInList = findTheKeypairIdentify(keypairIdentify);
		KeypairIdentify newKeypairIdentify = new KeypairIdentify();
		keypairIdentifyInList.copyTo(newKeypairIdentify);
		newKeypairIdentify.setVersion(0);//will trigger copy
		getKeypairIdentifyList().add(newKeypairIdentify);
		addItemToFlexiableObject(COPIED_CHILD, newKeypairIdentify);
	}
	
	public  KeypairIdentify findTheKeypairIdentify(KeypairIdentify keypairIdentify){
		
		int index =  getKeypairIdentifyList().indexOf(keypairIdentify);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "KeypairIdentify("+keypairIdentify.getId()+") with version='"+keypairIdentify.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getKeypairIdentifyList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpKeypairIdentifyList(){
		getKeypairIdentifyList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getDomain(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getKeypairIdentifyList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getKeypairIdentifyList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, CODE_PROPERTY, getCode());
		appendKeyValuePair(result, DOMAIN_PROPERTY, getDomain());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, KEYPAIR_IDENTIFY_LIST, getKeypairIdentifyList());
		if(!getKeypairIdentifyList().isEmpty()){
			appendKeyValuePair(result, "keypairIdentifyCount", getKeypairIdentifyList().getTotalCount());
			appendKeyValuePair(result, "keypairIdentifyCurrentPageNumber", getKeypairIdentifyList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof PublicKeyType){
		
		
			PublicKeyType dest =(PublicKeyType)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setCode(getCode());
			dest.setDomain(getDomain());
			dest.setVersion(getVersion());
			dest.setKeypairIdentifyList(getKeypairIdentifyList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof PublicKeyType){
		
			
			PublicKeyType dest =(PublicKeyType)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCode(getCode());
			dest.mergeDomain(getDomain());
			dest.mergeVersion(getVersion());
			dest.mergeKeypairIdentifyList(getKeypairIdentifyList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof PublicKeyType){
		
			
			PublicKeyType dest =(PublicKeyType)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCode(getCode());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getCode(), getDomain(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("PublicKeyType{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		if(getDomain() != null ){
 			stringBuilder.append("\tdomain='UserDomain("+getDomain().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

