
package com.doublechaintech.retailscm.interviewtype;

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
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterview;









@JsonSerialize(using = InterviewTypeSerializer.class)
public class InterviewType extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String DETAIL_DESCRIPTION_PROPERTY    = "detailDescription" ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_INTERVIEW_LIST                  = "employeeInterviewList";

	public static final String INTERNAL_TYPE="InterviewType";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getCode();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mCode               ;
	protected		RetailStoreCountryCenter	mCompany            ;
	protected		String              	mDescription        ;
	protected		String              	mDetailDescription  ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<EmployeeInterview>	mEmployeeInterviewList;

	
		
	public 	InterviewType(){
		// lazy load for all the properties
	}
	public 	static InterviewType withId(String id){
		InterviewType interviewType = new InterviewType();
		interviewType.setId(id);
		interviewType.setVersion(Integer.MAX_VALUE);
		return interviewType;
	}
	public 	static InterviewType refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setCompany( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(CODE_PROPERTY.equals(property)){
			changeCodeProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}
		if(DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			changeDetailDescriptionProperty(newValueExpr);
		}

      
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
			
			
			
	protected void changeDetailDescriptionProperty(String newValueExpr){
	
		String oldValue = getDetailDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDetailDescription(newValue);
		this.onChangeProperty(DETAIL_DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(CODE_PROPERTY.equals(property)){
			return getCode();
		}
		if(COMPANY_PROPERTY.equals(property)){
			return getCompany();
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			return getDescription();
		}
		if(DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			return getDetailDescription();
		}
		if(EMPLOYEE_INTERVIEW_LIST.equals(property)){
			List<BaseEntity> list = getEmployeeInterviewList().stream().map(item->item).collect(Collectors.toList());
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
	public InterviewType updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setCode(String code){
		this.mCode = trimString(code);;
	}
	public String getCode(){
		return this.mCode;
	}
	public InterviewType updateCode(String code){
		this.mCode = trimString(code);;
		this.changed = true;
		return this;
	}
	public void mergeCode(String code){
		if(code != null) { setCode(code);}
	}
	
	
	public void setCompany(RetailStoreCountryCenter company){
		this.mCompany = company;;
	}
	public RetailStoreCountryCenter getCompany(){
		return this.mCompany;
	}
	public InterviewType updateCompany(RetailStoreCountryCenter company){
		this.mCompany = company;;
		this.changed = true;
		return this;
	}
	public void mergeCompany(RetailStoreCountryCenter company){
		if(company != null) { setCompany(company);}
	}
	
	
	public void clearCompany(){
		setCompany ( null );
		this.changed = true;
	}
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public InterviewType updateDescription(String description){
		this.mDescription = trimString(description);;
		this.changed = true;
		return this;
	}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}
	
	
	public void setDetailDescription(String detailDescription){
		this.mDetailDescription = trimString(detailDescription);;
	}
	public String getDetailDescription(){
		return this.mDetailDescription;
	}
	public InterviewType updateDetailDescription(String detailDescription){
		this.mDetailDescription = trimString(detailDescription);;
		this.changed = true;
		return this;
	}
	public void mergeDetailDescription(String detailDescription){
		if(detailDescription != null) { setDetailDescription(detailDescription);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public InterviewType updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<EmployeeInterview> getEmployeeInterviewList(){
		if(this.mEmployeeInterviewList == null){
			this.mEmployeeInterviewList = new SmartList<EmployeeInterview>();
			this.mEmployeeInterviewList.setListInternalName (EMPLOYEE_INTERVIEW_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mEmployeeInterviewList;	
	}
	public  void setEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList){
		for( EmployeeInterview employeeInterview:employeeInterviewList){
			employeeInterview.setInterviewType(this);
		}

		this.mEmployeeInterviewList = employeeInterviewList;
		this.mEmployeeInterviewList.setListInternalName (EMPLOYEE_INTERVIEW_LIST );
		
	}
	
	public  void addEmployeeInterview(EmployeeInterview employeeInterview){
		employeeInterview.setInterviewType(this);
		getEmployeeInterviewList().add(employeeInterview);
	}
	public  void addEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList){
		for( EmployeeInterview employeeInterview:employeeInterviewList){
			employeeInterview.setInterviewType(this);
		}
		getEmployeeInterviewList().addAll(employeeInterviewList);
	}
	public  void mergeEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList){
		if(employeeInterviewList==null){
			return;
		}
		if(employeeInterviewList.isEmpty()){
			return;
		}
		addEmployeeInterviewList( employeeInterviewList );
		
	}
	public  EmployeeInterview removeEmployeeInterview(EmployeeInterview employeeInterviewIndex){
		
		int index = getEmployeeInterviewList().indexOf(employeeInterviewIndex);
        if(index < 0){
        	String message = "EmployeeInterview("+employeeInterviewIndex.getId()+") with version='"+employeeInterviewIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EmployeeInterview employeeInterview = getEmployeeInterviewList().get(index);        
        // employeeInterview.clearInterviewType(); //disconnect with InterviewType
        employeeInterview.clearFromAll(); //disconnect with InterviewType
		
		boolean result = getEmployeeInterviewList().planToRemove(employeeInterview);
        if(!result){
        	String message = "EmployeeInterview("+employeeInterviewIndex.getId()+") with version='"+employeeInterviewIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return employeeInterview;
        
	
	}
	//断舍离
	public  void breakWithEmployeeInterview(EmployeeInterview employeeInterview){
		
		if(employeeInterview == null){
			return;
		}
		employeeInterview.setInterviewType(null);
		//getEmployeeInterviewList().remove();
	
	}
	
	public  boolean hasEmployeeInterview(EmployeeInterview employeeInterview){
	
		return getEmployeeInterviewList().contains(employeeInterview);
  
	}
	
	public void copyEmployeeInterviewFrom(EmployeeInterview employeeInterview) {

		EmployeeInterview employeeInterviewInList = findTheEmployeeInterview(employeeInterview);
		EmployeeInterview newEmployeeInterview = new EmployeeInterview();
		employeeInterviewInList.copyTo(newEmployeeInterview);
		newEmployeeInterview.setVersion(0);//will trigger copy
		getEmployeeInterviewList().add(newEmployeeInterview);
		addItemToFlexiableObject(COPIED_CHILD, newEmployeeInterview);
	}
	
	public  EmployeeInterview findTheEmployeeInterview(EmployeeInterview employeeInterview){
		
		int index =  getEmployeeInterviewList().indexOf(employeeInterview);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "EmployeeInterview("+employeeInterview.getId()+") with version='"+employeeInterview.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getEmployeeInterviewList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeInterviewList(){
		getEmployeeInterviewList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getCompany(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getEmployeeInterviewList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getEmployeeInterviewList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, CODE_PROPERTY, getCode());
		appendKeyValuePair(result, COMPANY_PROPERTY, getCompany());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, DETAIL_DESCRIPTION_PROPERTY, getDetailDescription());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, EMPLOYEE_INTERVIEW_LIST, getEmployeeInterviewList());
		if(!getEmployeeInterviewList().isEmpty()){
			appendKeyValuePair(result, "employeeInterviewCount", getEmployeeInterviewList().getTotalCount());
			appendKeyValuePair(result, "employeeInterviewCurrentPageNumber", getEmployeeInterviewList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof InterviewType){
		
		
			InterviewType dest =(InterviewType)baseDest;
		
			dest.setId(getId());
			dest.setCode(getCode());
			dest.setCompany(getCompany());
			dest.setDescription(getDescription());
			dest.setDetailDescription(getDetailDescription());
			dest.setVersion(getVersion());
			dest.setEmployeeInterviewList(getEmployeeInterviewList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof InterviewType){
		
			
			InterviewType dest =(InterviewType)baseDest;
		
			dest.mergeId(getId());
			dest.mergeCode(getCode());
			dest.mergeCompany(getCompany());
			dest.mergeDescription(getDescription());
			dest.mergeDetailDescription(getDetailDescription());
			dest.mergeVersion(getVersion());
			dest.mergeEmployeeInterviewList(getEmployeeInterviewList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof InterviewType){
		
			
			InterviewType dest =(InterviewType)baseDest;
		
			dest.mergeId(getId());
			dest.mergeCode(getCode());
			dest.mergeDescription(getDescription());
			dest.mergeDetailDescription(getDetailDescription());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getCode(), getCompany(), getDescription(), getDetailDescription(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("InterviewType{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		if(getCompany() != null ){
 			stringBuilder.append("\tcompany='RetailStoreCountryCenter("+getCompany().getId()+")';");
 		}
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tdetailDescription='"+getDetailDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

