
package com.doublechaintech.retailscm.view;

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

@JsonSerialize(using = ViewSerializer.class)
public class View extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String ASSESSMENT_PROPERTY            = "assessment"        ;
	public static final String INTERVIEW_TIME_PROPERTY        = "interviewTime"     ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="View";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getWho();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mWho                ;
	protected		String              	mAssessment         ;
	protected		Date                	mInterviewTime      ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	View(){
		// lazy load for all the properties
	}
	public 	static View withId(String id){
		View view = new View();
		view.setId(id);
		view.setVersion(Integer.MAX_VALUE);
		return view;
	}
	public 	static View refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(WHO_PROPERTY.equals(property)){
			changeWhoProperty(newValueExpr);
		}
		if(ASSESSMENT_PROPERTY.equals(property)){
			changeAssessmentProperty(newValueExpr);
		}
		if(INTERVIEW_TIME_PROPERTY.equals(property)){
			changeInterviewTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeWhoProperty(String newValueExpr){
	
		String oldValue = getWho();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateWho(newValue);
		this.onChangeProperty(WHO_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeAssessmentProperty(String newValueExpr){
	
		String oldValue = getAssessment();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAssessment(newValue);
		this.onChangeProperty(ASSESSMENT_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeInterviewTimeProperty(String newValueExpr){
	
		Date oldValue = getInterviewTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateInterviewTime(newValue);
		this.onChangeProperty(INTERVIEW_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(WHO_PROPERTY.equals(property)){
			return getWho();
		}
		if(ASSESSMENT_PROPERTY.equals(property)){
			return getAssessment();
		}
		if(INTERVIEW_TIME_PROPERTY.equals(property)){
			return getInterviewTime();
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
	public View updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setWho(String who){
		this.mWho = trimString(who);;
	}
	public String getWho(){
		return this.mWho;
	}
	public View updateWho(String who){
		this.mWho = trimString(who);;
		this.changed = true;
		return this;
	}
	public void mergeWho(String who){
		if(who != null) { setWho(who);}
	}
	
	
	public void setAssessment(String assessment){
		this.mAssessment = trimString(assessment);;
	}
	public String getAssessment(){
		return this.mAssessment;
	}
	public View updateAssessment(String assessment){
		this.mAssessment = trimString(assessment);;
		this.changed = true;
		return this;
	}
	public void mergeAssessment(String assessment){
		if(assessment != null) { setAssessment(assessment);}
	}
	
	
	public void setInterviewTime(Date interviewTime){
		this.mInterviewTime = interviewTime;;
	}
	public Date getInterviewTime(){
		return this.mInterviewTime;
	}
	public View updateInterviewTime(Date interviewTime){
		this.mInterviewTime = interviewTime;;
		this.changed = true;
		return this;
	}
	public void mergeInterviewTime(Date interviewTime){
		setInterviewTime(interviewTime);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public View updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
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
		appendKeyValuePair(result, WHO_PROPERTY, getWho());
		appendKeyValuePair(result, ASSESSMENT_PROPERTY, getAssessment());
		appendKeyValuePair(result, INTERVIEW_TIME_PROPERTY, getInterviewTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof View){
		
		
			View dest =(View)baseDest;
		
			dest.setId(getId());
			dest.setWho(getWho());
			dest.setAssessment(getAssessment());
			dest.setInterviewTime(getInterviewTime());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof View){
		
			
			View dest =(View)baseDest;
		
			dest.mergeId(getId());
			dest.mergeWho(getWho());
			dest.mergeAssessment(getAssessment());
			dest.mergeInterviewTime(getInterviewTime());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof View){
		
			
			View dest =(View)baseDest;
		
			dest.mergeId(getId());
			dest.mergeWho(getWho());
			dest.mergeAssessment(getAssessment());
			dest.mergeInterviewTime(getInterviewTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getWho(), getAssessment(), getInterviewTime(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("View{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tassessment='"+getAssessment()+"';");
		stringBuilder.append("\tinterviewTime='"+getInterviewTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

