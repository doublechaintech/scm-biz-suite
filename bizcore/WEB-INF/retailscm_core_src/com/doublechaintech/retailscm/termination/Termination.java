
package com.doublechaintech.retailscm.termination;

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
import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;

@JsonSerialize(using = TerminationSerializer.class)
public class Termination extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String REASON_PROPERTY                = "reason"            ;
	public static final String TYPE_PROPERTY                  = "type"              ;
	public static final String COMMENT_PROPERTY               = "comment"           ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="Termination";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getComment();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		TerminationReason   	mReason             ;
	protected		TerminationType     	mType               ;
	protected		String              	mComment            ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	Termination(){
		// lazy load for all the properties
	}
	public 	static Termination withId(String id){
		Termination termination = new Termination();
		termination.setId(id);
		termination.setVersion(Integer.MAX_VALUE);
		return termination;
	}
	public 	static Termination refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setReason( null );
		setType( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(COMMENT_PROPERTY.equals(property)){
			changeCommentProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeCommentProperty(String newValueExpr){
	
		String oldValue = getComment();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateComment(newValue);
		this.onChangeProperty(COMMENT_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(REASON_PROPERTY.equals(property)){
			return getReason();
		}
		if(TYPE_PROPERTY.equals(property)){
			return getType();
		}
		if(COMMENT_PROPERTY.equals(property)){
			return getComment();
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
	public Termination updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setReason(TerminationReason reason){
		this.mReason = reason;;
	}
	public TerminationReason getReason(){
		return this.mReason;
	}
	public Termination updateReason(TerminationReason reason){
		this.mReason = reason;;
		this.changed = true;
		return this;
	}
	public void mergeReason(TerminationReason reason){
		if(reason != null) { setReason(reason);}
	}
	
	
	public void clearReason(){
		setReason ( null );
		this.changed = true;
	}
	
	public void setType(TerminationType type){
		this.mType = type;;
	}
	public TerminationType getType(){
		return this.mType;
	}
	public Termination updateType(TerminationType type){
		this.mType = type;;
		this.changed = true;
		return this;
	}
	public void mergeType(TerminationType type){
		if(type != null) { setType(type);}
	}
	
	
	public void clearType(){
		setType ( null );
		this.changed = true;
	}
	
	public void setComment(String comment){
		this.mComment = trimString(comment);;
	}
	public String getComment(){
		return this.mComment;
	}
	public Termination updateComment(String comment){
		this.mComment = trimString(comment);;
		this.changed = true;
		return this;
	}
	public void mergeComment(String comment){
		if(comment != null) { setComment(comment);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Termination updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getReason(), internalType);
		addToEntityList(this, entityList, getType(), internalType);

		
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
		appendKeyValuePair(result, REASON_PROPERTY, getReason());
		appendKeyValuePair(result, TYPE_PROPERTY, getType());
		appendKeyValuePair(result, COMMENT_PROPERTY, getComment());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Termination){
		
		
			Termination dest =(Termination)baseDest;
		
			dest.setId(getId());
			dest.setReason(getReason());
			dest.setType(getType());
			dest.setComment(getComment());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Termination){
		
			
			Termination dest =(Termination)baseDest;
		
			dest.mergeId(getId());
			dest.mergeReason(getReason());
			dest.mergeType(getType());
			dest.mergeComment(getComment());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Termination){
		
			
			Termination dest =(Termination)baseDest;
		
			dest.mergeId(getId());
			dest.mergeComment(getComment());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getReason(), getType(), getComment(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Termination{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getReason() != null ){
 			stringBuilder.append("\treason='TerminationReason("+getReason().getId()+")';");
 		}
		if(getType() != null ){
 			stringBuilder.append("\ttype='TerminationType("+getType().getId()+")';");
 		}
		stringBuilder.append("\tcomment='"+getComment()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

