
package com.doublechaintech.retailscm.skilltype;

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
import com.doublechaintech.retailscm.employeeskill.EmployeeSkill;









@JsonSerialize(using = SkillTypeSerializer.class)
public class SkillType extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_SKILL_LIST                      = "employeeSkillList" ;

	public static final String INTERNAL_TYPE="SkillType";
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
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<EmployeeSkill>	mEmployeeSkillList  ;

	
		
	public 	SkillType(){
		// lazy load for all the properties
	}
	public 	static SkillType withId(String id){
		SkillType skillType = new SkillType();
		skillType.setId(id);
		skillType.setVersion(Integer.MAX_VALUE);
		return skillType;
	}
	public 	static SkillType refById(String id){
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
		if(EMPLOYEE_SKILL_LIST.equals(property)){
			List<BaseEntity> list = getEmployeeSkillList().stream().map(item->item).collect(Collectors.toList());
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
	public SkillType updateId(String id){
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
	public SkillType updateCode(String code){
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
	public SkillType updateCompany(RetailStoreCountryCenter company){
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
	public SkillType updateDescription(String description){
		this.mDescription = trimString(description);;
		this.changed = true;
		return this;
	}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public SkillType updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<EmployeeSkill> getEmployeeSkillList(){
		if(this.mEmployeeSkillList == null){
			this.mEmployeeSkillList = new SmartList<EmployeeSkill>();
			this.mEmployeeSkillList.setListInternalName (EMPLOYEE_SKILL_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mEmployeeSkillList;	
	}
	public  void setEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList){
		for( EmployeeSkill employeeSkill:employeeSkillList){
			employeeSkill.setSkillType(this);
		}

		this.mEmployeeSkillList = employeeSkillList;
		this.mEmployeeSkillList.setListInternalName (EMPLOYEE_SKILL_LIST );
		
	}
	
	public  void addEmployeeSkill(EmployeeSkill employeeSkill){
		employeeSkill.setSkillType(this);
		getEmployeeSkillList().add(employeeSkill);
	}
	public  void addEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList){
		for( EmployeeSkill employeeSkill:employeeSkillList){
			employeeSkill.setSkillType(this);
		}
		getEmployeeSkillList().addAll(employeeSkillList);
	}
	public  void mergeEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList){
		if(employeeSkillList==null){
			return;
		}
		if(employeeSkillList.isEmpty()){
			return;
		}
		addEmployeeSkillList( employeeSkillList );
		
	}
	public  EmployeeSkill removeEmployeeSkill(EmployeeSkill employeeSkillIndex){
		
		int index = getEmployeeSkillList().indexOf(employeeSkillIndex);
        if(index < 0){
        	String message = "EmployeeSkill("+employeeSkillIndex.getId()+") with version='"+employeeSkillIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EmployeeSkill employeeSkill = getEmployeeSkillList().get(index);        
        // employeeSkill.clearSkillType(); //disconnect with SkillType
        employeeSkill.clearFromAll(); //disconnect with SkillType
		
		boolean result = getEmployeeSkillList().planToRemove(employeeSkill);
        if(!result){
        	String message = "EmployeeSkill("+employeeSkillIndex.getId()+") with version='"+employeeSkillIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return employeeSkill;
        
	
	}
	//断舍离
	public  void breakWithEmployeeSkill(EmployeeSkill employeeSkill){
		
		if(employeeSkill == null){
			return;
		}
		employeeSkill.setSkillType(null);
		//getEmployeeSkillList().remove();
	
	}
	
	public  boolean hasEmployeeSkill(EmployeeSkill employeeSkill){
	
		return getEmployeeSkillList().contains(employeeSkill);
  
	}
	
	public void copyEmployeeSkillFrom(EmployeeSkill employeeSkill) {

		EmployeeSkill employeeSkillInList = findTheEmployeeSkill(employeeSkill);
		EmployeeSkill newEmployeeSkill = new EmployeeSkill();
		employeeSkillInList.copyTo(newEmployeeSkill);
		newEmployeeSkill.setVersion(0);//will trigger copy
		getEmployeeSkillList().add(newEmployeeSkill);
		addItemToFlexiableObject(COPIED_CHILD, newEmployeeSkill);
	}
	
	public  EmployeeSkill findTheEmployeeSkill(EmployeeSkill employeeSkill){
		
		int index =  getEmployeeSkillList().indexOf(employeeSkill);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "EmployeeSkill("+employeeSkill.getId()+") with version='"+employeeSkill.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getEmployeeSkillList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeSkillList(){
		getEmployeeSkillList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getCompany(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getEmployeeSkillList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getEmployeeSkillList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, CODE_PROPERTY, getCode());
		appendKeyValuePair(result, COMPANY_PROPERTY, getCompany());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, EMPLOYEE_SKILL_LIST, getEmployeeSkillList());
		if(!getEmployeeSkillList().isEmpty()){
			appendKeyValuePair(result, "employeeSkillCount", getEmployeeSkillList().getTotalCount());
			appendKeyValuePair(result, "employeeSkillCurrentPageNumber", getEmployeeSkillList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SkillType){
		
		
			SkillType dest =(SkillType)baseDest;
		
			dest.setId(getId());
			dest.setCode(getCode());
			dest.setCompany(getCompany());
			dest.setDescription(getDescription());
			dest.setVersion(getVersion());
			dest.setEmployeeSkillList(getEmployeeSkillList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SkillType){
		
			
			SkillType dest =(SkillType)baseDest;
		
			dest.mergeId(getId());
			dest.mergeCode(getCode());
			dest.mergeCompany(getCompany());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());
			dest.mergeEmployeeSkillList(getEmployeeSkillList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SkillType){
		
			
			SkillType dest =(SkillType)baseDest;
		
			dest.mergeId(getId());
			dest.mergeCode(getCode());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getCode(), getCompany(), getDescription(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("SkillType{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		if(getCompany() != null ){
 			stringBuilder.append("\tcompany='RetailStoreCountryCenter("+getCompany().getId()+")';");
 		}
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

