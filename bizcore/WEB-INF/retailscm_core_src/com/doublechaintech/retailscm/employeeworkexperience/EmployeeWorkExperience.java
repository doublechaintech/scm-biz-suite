
package com.doublechaintech.retailscm.employeeworkexperience;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.employee.Employee;

@JsonSerialize(using = EmployeeWorkExperienceSerializer.class)
public class EmployeeWorkExperience extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String EMPLOYEE_PROPERTY              = "employee"          ;
	public static final String START_PROPERTY                 = "start"             ;
	public static final String END_PROPERTY                   = "end"               ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="EmployeeWorkExperience";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getCompany();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Employee            	mEmployee           ;
	protected		Date                	mStart              ;
	protected		Date                	mEnd                ;
	protected		String              	mCompany            ;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	EmployeeWorkExperience(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setEmployee( null );

		this.changed = true;
	}
	
	public 	EmployeeWorkExperience(Employee employee, Date start, Date end, String company, String description)
	{
		setEmployee(employee);
		setStart(start);
		setEnd(end);
		setCompany(company);
		setDescription(description);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(START_PROPERTY.equals(property)){
			changeStartProperty(newValueExpr);
		}
		if(END_PROPERTY.equals(property)){
			changeEndProperty(newValueExpr);
		}
		if(COMPANY_PROPERTY.equals(property)){
			changeCompanyProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeStartProperty(String newValueExpr){
		Date oldValue = getStart();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateStart(newValue);
		this.onChangeProperty(START_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeEndProperty(String newValueExpr){
		Date oldValue = getEnd();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateEnd(newValue);
		this.onChangeProperty(END_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCompanyProperty(String newValueExpr){
		String oldValue = getCompany();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCompany(newValue);
		this.onChangeProperty(COMPANY_PROPERTY, oldValue, newValue);
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
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public EmployeeWorkExperience updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setEmployee(Employee employee){
		this.mEmployee = employee;;
	}
	public Employee getEmployee(){
		return this.mEmployee;
	}
	public EmployeeWorkExperience updateEmployee(Employee employee){
		this.mEmployee = employee;;
		this.changed = true;
		return this;
	}
	
	
	public void clearEmployee(){
		setEmployee ( null );
		this.changed = true;
	}
	
	public void setStart(Date start){
		this.mStart = start;;
	}
	public Date getStart(){
		return this.mStart;
	}
	public EmployeeWorkExperience updateStart(Date start){
		this.mStart = start;;
		this.changed = true;
		return this;
	}
	
	
	public void setEnd(Date end){
		this.mEnd = end;;
	}
	public Date getEnd(){
		return this.mEnd;
	}
	public EmployeeWorkExperience updateEnd(Date end){
		this.mEnd = end;;
		this.changed = true;
		return this;
	}
	
	
	public void setCompany(String company){
		this.mCompany = trimString(company);;
	}
	public String getCompany(){
		return this.mCompany;
	}
	public EmployeeWorkExperience updateCompany(String company){
		this.mCompany = trimString(company);;
		this.changed = true;
		return this;
	}
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public EmployeeWorkExperience updateDescription(String description){
		this.mDescription = trimString(description);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public EmployeeWorkExperience updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getEmployee(), internalType);

		
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
		appendKeyValuePair(result, EMPLOYEE_PROPERTY, getEmployee());
		appendKeyValuePair(result, START_PROPERTY, getStart());
		appendKeyValuePair(result, END_PROPERTY, getEnd());
		appendKeyValuePair(result, COMPANY_PROPERTY, getCompany());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeeWorkExperience){
		
		
			EmployeeWorkExperience dest =(EmployeeWorkExperience)baseDest;
		
			dest.setId(getId());
			dest.setEmployee(getEmployee());
			dest.setStart(getStart());
			dest.setEnd(getEnd());
			dest.setCompany(getCompany());
			dest.setDescription(getDescription());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("EmployeeWorkExperience{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getEmployee() != null ){
 			stringBuilder.append("\temployee='Employee("+getEmployee().getId()+")';");
 		}
		stringBuilder.append("\tstart='"+getStart()+"';");
		stringBuilder.append("\tend='"+getEnd()+"';");
		stringBuilder.append("\tcompany='"+getCompany()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

