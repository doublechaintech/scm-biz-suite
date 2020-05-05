
package com.doublechaintech.retailscm.candidateelement;

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
import com.doublechaintech.retailscm.candidatecontainer.CandidateContainer;

@JsonSerialize(using = CandidateElementSerializer.class)
public class CandidateElement extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String TYPE_PROPERTY                  = "type"              ;
	public static final String IMAGE_PROPERTY                 = "image"             ;
	public static final String CONTAINER_PROPERTY             = "container"         ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="CandidateElement";
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
	protected		String              	mType               ;
	protected		String              	mImage              ;
	protected		CandidateContainer  	mContainer          ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	CandidateElement(){
		// lazy load for all the properties
	}
	public 	static CandidateElement withId(String id){
		CandidateElement candidateElement = new CandidateElement();
		candidateElement.setId(id);
		candidateElement.setVersion(Integer.MAX_VALUE);
		return candidateElement;
	}
	public 	static CandidateElement refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setContainer( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(TYPE_PROPERTY.equals(property)){
			changeTypeProperty(newValueExpr);
		}
		if(IMAGE_PROPERTY.equals(property)){
			changeImageProperty(newValueExpr);
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
			
			
			
	protected void changeTypeProperty(String newValueExpr){
	
		String oldValue = getType();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateType(newValue);
		this.onChangeProperty(TYPE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeImageProperty(String newValueExpr){
	
		String oldValue = getImage();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateImage(newValue);
		this.onChangeProperty(IMAGE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(TYPE_PROPERTY.equals(property)){
			return getType();
		}
		if(IMAGE_PROPERTY.equals(property)){
			return getImage();
		}
		if(CONTAINER_PROPERTY.equals(property)){
			return getContainer();
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
	public CandidateElement updateId(String id){
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
	public CandidateElement updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setType(String type){
		this.mType = trimString(type);;
	}
	public String getType(){
		return this.mType;
	}
	public CandidateElement updateType(String type){
		this.mType = trimString(type);;
		this.changed = true;
		return this;
	}
	public void mergeType(String type){
		if(type != null) { setType(type);}
	}
	
	
	public void setImage(String image){
		this.mImage = trimString(encodeUrl(image));;
	}
	public String getImage(){
		return this.mImage;
	}
	public CandidateElement updateImage(String image){
		this.mImage = trimString(encodeUrl(image));;
		this.changed = true;
		return this;
	}
	public void mergeImage(String image){
		if(image != null) { setImage(image);}
	}
	
	
	public void setContainer(CandidateContainer container){
		this.mContainer = container;;
	}
	public CandidateContainer getContainer(){
		return this.mContainer;
	}
	public CandidateElement updateContainer(CandidateContainer container){
		this.mContainer = container;;
		this.changed = true;
		return this;
	}
	public void mergeContainer(CandidateContainer container){
		if(container != null) { setContainer(container);}
	}
	
	
	public void clearContainer(){
		setContainer ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public CandidateElement updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getContainer(), internalType);

		
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
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, TYPE_PROPERTY, getType());
		appendKeyValuePair(result, IMAGE_PROPERTY, getImage());
		appendKeyValuePair(result, CONTAINER_PROPERTY, getContainer());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof CandidateElement){
		
		
			CandidateElement dest =(CandidateElement)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setType(getType());
			dest.setImage(getImage());
			dest.setContainer(getContainer());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof CandidateElement){
		
			
			CandidateElement dest =(CandidateElement)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeType(getType());
			dest.mergeImage(getImage());
			dest.mergeContainer(getContainer());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof CandidateElement){
		
			
			CandidateElement dest =(CandidateElement)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeType(getType());
			dest.mergeImage(getImage());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getType(), getImage(), getContainer(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("CandidateElement{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\ttype='"+getType()+"';");
		stringBuilder.append("\timage='"+getImage()+"';");
		if(getContainer() != null ){
 			stringBuilder.append("\tcontainer='CandidateContainer("+getContainer().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

