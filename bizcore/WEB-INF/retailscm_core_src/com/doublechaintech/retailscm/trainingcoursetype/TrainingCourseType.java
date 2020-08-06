
package com.doublechaintech.retailscm.trainingcoursetype;

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
import com.doublechaintech.retailscm.companytraining.CompanyTraining;









@JsonSerialize(using = TrainingCourseTypeSerializer.class)
public class TrainingCourseType extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String COMPANY_TRAINING_LIST                    = "companyTrainingList";

	public static final String INTERNAL_TYPE="TrainingCourseType";
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
	protected		String              	mName               ;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<CompanyTraining>	mCompanyTrainingList;

	
		
	public 	TrainingCourseType(){
		// lazy load for all the properties
	}
	public 	static TrainingCourseType withId(String id){
		TrainingCourseType trainingCourseType = new TrainingCourseType();
		trainingCourseType.setId(id);
		trainingCourseType.setVersion(Integer.MAX_VALUE);
		return trainingCourseType;
	}
	public 	static TrainingCourseType refById(String id){
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
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
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
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			return getDescription();
		}
		if(COMPANY_TRAINING_LIST.equals(property)){
			List<BaseEntity> list = getCompanyTrainingList().stream().map(item->item).collect(Collectors.toList());
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
	public TrainingCourseType updateId(String id){
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
	public TrainingCourseType updateCode(String code){
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
	public TrainingCourseType updateCompany(RetailStoreCountryCenter company){
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
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public TrainingCourseType updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public TrainingCourseType updateDescription(String description){
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
	public TrainingCourseType updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<CompanyTraining> getCompanyTrainingList(){
		if(this.mCompanyTrainingList == null){
			this.mCompanyTrainingList = new SmartList<CompanyTraining>();
			this.mCompanyTrainingList.setListInternalName (COMPANY_TRAINING_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mCompanyTrainingList;	
	}
	public  void setCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList){
		for( CompanyTraining companyTraining:companyTrainingList){
			companyTraining.setTrainingCourseType(this);
		}

		this.mCompanyTrainingList = companyTrainingList;
		this.mCompanyTrainingList.setListInternalName (COMPANY_TRAINING_LIST );
		
	}
	
	public  void addCompanyTraining(CompanyTraining companyTraining){
		companyTraining.setTrainingCourseType(this);
		getCompanyTrainingList().add(companyTraining);
	}
	public  void addCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList){
		for( CompanyTraining companyTraining:companyTrainingList){
			companyTraining.setTrainingCourseType(this);
		}
		getCompanyTrainingList().addAll(companyTrainingList);
	}
	public  void mergeCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList){
		if(companyTrainingList==null){
			return;
		}
		if(companyTrainingList.isEmpty()){
			return;
		}
		addCompanyTrainingList( companyTrainingList );
		
	}
	public  CompanyTraining removeCompanyTraining(CompanyTraining companyTrainingIndex){
		
		int index = getCompanyTrainingList().indexOf(companyTrainingIndex);
        if(index < 0){
        	String message = "CompanyTraining("+companyTrainingIndex.getId()+") with version='"+companyTrainingIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        CompanyTraining companyTraining = getCompanyTrainingList().get(index);        
        // companyTraining.clearTrainingCourseType(); //disconnect with TrainingCourseType
        companyTraining.clearFromAll(); //disconnect with TrainingCourseType
		
		boolean result = getCompanyTrainingList().planToRemove(companyTraining);
        if(!result){
        	String message = "CompanyTraining("+companyTrainingIndex.getId()+") with version='"+companyTrainingIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return companyTraining;
        
	
	}
	//断舍离
	public  void breakWithCompanyTraining(CompanyTraining companyTraining){
		
		if(companyTraining == null){
			return;
		}
		companyTraining.setTrainingCourseType(null);
		//getCompanyTrainingList().remove();
	
	}
	
	public  boolean hasCompanyTraining(CompanyTraining companyTraining){
	
		return getCompanyTrainingList().contains(companyTraining);
  
	}
	
	public void copyCompanyTrainingFrom(CompanyTraining companyTraining) {

		CompanyTraining companyTrainingInList = findTheCompanyTraining(companyTraining);
		CompanyTraining newCompanyTraining = new CompanyTraining();
		companyTrainingInList.copyTo(newCompanyTraining);
		newCompanyTraining.setVersion(0);//will trigger copy
		getCompanyTrainingList().add(newCompanyTraining);
		addItemToFlexiableObject(COPIED_CHILD, newCompanyTraining);
	}
	
	public  CompanyTraining findTheCompanyTraining(CompanyTraining companyTraining){
		
		int index =  getCompanyTrainingList().indexOf(companyTraining);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "CompanyTraining("+companyTraining.getId()+") with version='"+companyTraining.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getCompanyTrainingList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpCompanyTrainingList(){
		getCompanyTrainingList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getCompany(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getCompanyTrainingList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getCompanyTrainingList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, CODE_PROPERTY, getCode());
		appendKeyValuePair(result, COMPANY_PROPERTY, getCompany());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, COMPANY_TRAINING_LIST, getCompanyTrainingList());
		if(!getCompanyTrainingList().isEmpty()){
			appendKeyValuePair(result, "companyTrainingCount", getCompanyTrainingList().getTotalCount());
			appendKeyValuePair(result, "companyTrainingCurrentPageNumber", getCompanyTrainingList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TrainingCourseType){
		
		
			TrainingCourseType dest =(TrainingCourseType)baseDest;
		
			dest.setId(getId());
			dest.setCode(getCode());
			dest.setCompany(getCompany());
			dest.setName(getName());
			dest.setDescription(getDescription());
			dest.setVersion(getVersion());
			dest.setCompanyTrainingList(getCompanyTrainingList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TrainingCourseType){
		
			
			TrainingCourseType dest =(TrainingCourseType)baseDest;
		
			dest.mergeId(getId());
			dest.mergeCode(getCode());
			dest.mergeCompany(getCompany());
			dest.mergeName(getName());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());
			dest.mergeCompanyTrainingList(getCompanyTrainingList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof TrainingCourseType){
		
			
			TrainingCourseType dest =(TrainingCourseType)baseDest;
		
			dest.mergeId(getId());
			dest.mergeCode(getCode());
			dest.mergeName(getName());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getCode(), getCompany(), getName(), getDescription(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("TrainingCourseType{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		if(getCompany() != null ){
 			stringBuilder.append("\tcompany='RetailStoreCountryCenter("+getCompany().getId()+")';");
 		}
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

