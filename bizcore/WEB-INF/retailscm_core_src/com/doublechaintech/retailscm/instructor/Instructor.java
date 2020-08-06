
package com.doublechaintech.retailscm.instructor;

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









@JsonSerialize(using = InstructorSerializer.class)
public class Instructor extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String FAMILY_NAME_PROPERTY           = "familyName"        ;
	public static final String GIVEN_NAME_PROPERTY            = "givenName"         ;
	public static final String CELL_PHONE_PROPERTY            = "cellPhone"         ;
	public static final String EMAIL_PROPERTY                 = "email"             ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String INTRODUCTION_PROPERTY          = "introduction"      ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String COMPANY_TRAINING_LIST                    = "companyTrainingList";

	public static final String INTERNAL_TYPE="Instructor";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getTitle();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mTitle              ;
	protected		String              	mFamilyName         ;
	protected		String              	mGivenName          ;
	protected		String              	mCellPhone          ;
	protected		String              	mEmail              ;
	protected		RetailStoreCountryCenter	mCompany            ;
	protected		String              	mIntroduction       ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<CompanyTraining>	mCompanyTrainingList;

	
		
	public 	Instructor(){
		// lazy load for all the properties
	}
	public 	static Instructor withId(String id){
		Instructor instructor = new Instructor();
		instructor.setId(id);
		instructor.setVersion(Integer.MAX_VALUE);
		return instructor;
	}
	public 	static Instructor refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setCompany( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(FAMILY_NAME_PROPERTY.equals(property)){
			changeFamilyNameProperty(newValueExpr);
		}
		if(GIVEN_NAME_PROPERTY.equals(property)){
			changeGivenNameProperty(newValueExpr);
		}
		if(CELL_PHONE_PROPERTY.equals(property)){
			changeCellPhoneProperty(newValueExpr);
		}
		if(EMAIL_PROPERTY.equals(property)){
			changeEmailProperty(newValueExpr);
		}
		if(INTRODUCTION_PROPERTY.equals(property)){
			changeIntroductionProperty(newValueExpr);
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			changeLastUpdateTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeTitleProperty(String newValueExpr){
	
		String oldValue = getTitle();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTitle(newValue);
		this.onChangeProperty(TITLE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeFamilyNameProperty(String newValueExpr){
	
		String oldValue = getFamilyName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateFamilyName(newValue);
		this.onChangeProperty(FAMILY_NAME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeGivenNameProperty(String newValueExpr){
	
		String oldValue = getGivenName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateGivenName(newValue);
		this.onChangeProperty(GIVEN_NAME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeCellPhoneProperty(String newValueExpr){
	
		String oldValue = getCellPhone();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCellPhone(newValue);
		this.onChangeProperty(CELL_PHONE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeEmailProperty(String newValueExpr){
	
		String oldValue = getEmail();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateEmail(newValue);
		this.onChangeProperty(EMAIL_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeIntroductionProperty(String newValueExpr){
	
		String oldValue = getIntroduction();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateIntroduction(newValue);
		this.onChangeProperty(INTRODUCTION_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeLastUpdateTimeProperty(String newValueExpr){
	
		DateTime oldValue = getLastUpdateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLastUpdateTime(newValue);
		this.onChangeProperty(LAST_UPDATE_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(TITLE_PROPERTY.equals(property)){
			return getTitle();
		}
		if(FAMILY_NAME_PROPERTY.equals(property)){
			return getFamilyName();
		}
		if(GIVEN_NAME_PROPERTY.equals(property)){
			return getGivenName();
		}
		if(CELL_PHONE_PROPERTY.equals(property)){
			return getCellPhone();
		}
		if(EMAIL_PROPERTY.equals(property)){
			return getEmail();
		}
		if(COMPANY_PROPERTY.equals(property)){
			return getCompany();
		}
		if(INTRODUCTION_PROPERTY.equals(property)){
			return getIntroduction();
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			return getLastUpdateTime();
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
	public Instructor updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	public Instructor updateTitle(String title){
		this.mTitle = trimString(title);;
		this.changed = true;
		return this;
	}
	public void mergeTitle(String title){
		if(title != null) { setTitle(title);}
	}
	
	
	public void setFamilyName(String familyName){
		this.mFamilyName = trimString(familyName);;
	}
	public String getFamilyName(){
		return this.mFamilyName;
	}
	public Instructor updateFamilyName(String familyName){
		this.mFamilyName = trimString(familyName);;
		this.changed = true;
		return this;
	}
	public void mergeFamilyName(String familyName){
		if(familyName != null) { setFamilyName(familyName);}
	}
	
	
	public void setGivenName(String givenName){
		this.mGivenName = trimString(givenName);;
	}
	public String getGivenName(){
		return this.mGivenName;
	}
	public Instructor updateGivenName(String givenName){
		this.mGivenName = trimString(givenName);;
		this.changed = true;
		return this;
	}
	public void mergeGivenName(String givenName){
		if(givenName != null) { setGivenName(givenName);}
	}
	
	
	public void setCellPhone(String cellPhone){
		this.mCellPhone = trimString(cellPhone);;
	}
	public String getCellPhone(){
		return this.mCellPhone;
	}
	public Instructor updateCellPhone(String cellPhone){
		this.mCellPhone = trimString(cellPhone);;
		this.changed = true;
		return this;
	}
	public void mergeCellPhone(String cellPhone){
		if(cellPhone != null) { setCellPhone(cellPhone);}
	}
	
	
	
	public String getMaskedCellPhone(){
		String mobilePhoneNumber = getCellPhone();
		return maskChinaMobileNumber(mobilePhoneNumber);
	}
	
		
	public void setEmail(String email){
		this.mEmail = trimString(email);;
	}
	public String getEmail(){
		return this.mEmail;
	}
	public Instructor updateEmail(String email){
		this.mEmail = trimString(email);;
		this.changed = true;
		return this;
	}
	public void mergeEmail(String email){
		if(email != null) { setEmail(email);}
	}
	
	
	public void setCompany(RetailStoreCountryCenter company){
		this.mCompany = company;;
	}
	public RetailStoreCountryCenter getCompany(){
		return this.mCompany;
	}
	public Instructor updateCompany(RetailStoreCountryCenter company){
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
	
	public void setIntroduction(String introduction){
		this.mIntroduction = trimString(introduction);;
	}
	public String getIntroduction(){
		return this.mIntroduction;
	}
	public Instructor updateIntroduction(String introduction){
		this.mIntroduction = trimString(introduction);;
		this.changed = true;
		return this;
	}
	public void mergeIntroduction(String introduction){
		if(introduction != null) { setIntroduction(introduction);}
	}
	
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public Instructor updateLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
		this.changed = true;
		return this;
	}
	public void mergeLastUpdateTime(DateTime lastUpdateTime){
		setLastUpdateTime(lastUpdateTime);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Instructor updateVersion(int version){
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
			companyTraining.setInstructor(this);
		}

		this.mCompanyTrainingList = companyTrainingList;
		this.mCompanyTrainingList.setListInternalName (COMPANY_TRAINING_LIST );
		
	}
	
	public  void addCompanyTraining(CompanyTraining companyTraining){
		companyTraining.setInstructor(this);
		getCompanyTrainingList().add(companyTraining);
	}
	public  void addCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList){
		for( CompanyTraining companyTraining:companyTrainingList){
			companyTraining.setInstructor(this);
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
        // companyTraining.clearInstructor(); //disconnect with Instructor
        companyTraining.clearFromAll(); //disconnect with Instructor
		
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
		companyTraining.setInstructor(null);
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
		appendKeyValuePair(result, TITLE_PROPERTY, getTitle());
		appendKeyValuePair(result, FAMILY_NAME_PROPERTY, getFamilyName());
		appendKeyValuePair(result, GIVEN_NAME_PROPERTY, getGivenName());
		appendKeyValuePair(result, CELL_PHONE_PROPERTY, getMaskedCellPhone());
		appendKeyValuePair(result, EMAIL_PROPERTY, getEmail());
		appendKeyValuePair(result, COMPANY_PROPERTY, getCompany());
		appendKeyValuePair(result, INTRODUCTION_PROPERTY, getIntroduction());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
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
		
		
		if(baseDest instanceof Instructor){
		
		
			Instructor dest =(Instructor)baseDest;
		
			dest.setId(getId());
			dest.setTitle(getTitle());
			dest.setFamilyName(getFamilyName());
			dest.setGivenName(getGivenName());
			dest.setCellPhone(getCellPhone());
			dest.setEmail(getEmail());
			dest.setCompany(getCompany());
			dest.setIntroduction(getIntroduction());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setCompanyTrainingList(getCompanyTrainingList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Instructor){
		
			
			Instructor dest =(Instructor)baseDest;
		
			dest.mergeId(getId());
			dest.mergeTitle(getTitle());
			dest.mergeFamilyName(getFamilyName());
			dest.mergeGivenName(getGivenName());
			dest.mergeCellPhone(getCellPhone());
			dest.mergeEmail(getEmail());
			dest.mergeCompany(getCompany());
			dest.mergeIntroduction(getIntroduction());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());
			dest.mergeCompanyTrainingList(getCompanyTrainingList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Instructor){
		
			
			Instructor dest =(Instructor)baseDest;
		
			dest.mergeId(getId());
			dest.mergeTitle(getTitle());
			dest.mergeFamilyName(getFamilyName());
			dest.mergeGivenName(getGivenName());
			dest.mergeCellPhone(getCellPhone());
			dest.mergeEmail(getEmail());
			dest.mergeIntroduction(getIntroduction());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getTitle(), getFamilyName(), getGivenName(), getCellPhone(), getEmail(), getCompany(), getIntroduction(), getLastUpdateTime(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Instructor{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		stringBuilder.append("\tfamilyName='"+getFamilyName()+"';");
		stringBuilder.append("\tgivenName='"+getGivenName()+"';");
		stringBuilder.append("\tcellPhone='"+getCellPhone()+"';");
		stringBuilder.append("\temail='"+getEmail()+"';");
		if(getCompany() != null ){
 			stringBuilder.append("\tcompany='RetailStoreCountryCenter("+getCompany().getId()+")';");
 		}
		stringBuilder.append("\tintroduction='"+getIntroduction()+"';");
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

