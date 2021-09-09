
package com.doublechaintech.retailscm.instructor;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
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


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(TITLE_PROPERTY, "title", "头衔")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(FAMILY_NAME_PROPERTY, "family_name", "姓")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(GIVEN_NAME_PROPERTY, "given_name", "名")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CELL_PHONE_PROPERTY, "cell_phone", "手机")
        .withType("string_china_mobile_phone", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(EMAIL_PROPERTY, "email", "电子邮件")
        .withType("string_email", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(COMPANY_PROPERTY, "retail_store_country_center", "公司")
        .withType("retail_store_country_center", RetailStoreCountryCenter.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(INTRODUCTION_PROPERTY, "introduction", "介绍")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
        .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(COMPANY_TRAINING_LIST, "instructor", "公司培训名单")
        .withType("company_training", CompanyTraining.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,TITLE_PROPERTY ,FAMILY_NAME_PROPERTY ,GIVEN_NAME_PROPERTY ,CELL_PHONE_PROPERTY ,EMAIL_PROPERTY ,COMPANY_PROPERTY ,INTRODUCTION_PROPERTY ,LAST_UPDATE_TIME_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(COMPANY_TRAINING_LIST, "instructor");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(COMPANY_TRAINING_LIST, CompanyTraining.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(COMPANY_PROPERTY, RetailStoreCountryCenter.class);

    return parents;
  }

  public Instructor want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public Instructor wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getTitle();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		String              	title               ;
	protected		String              	familyName          ;
	protected		String              	givenName           ;
	protected		String              	cellPhone           ;
	protected		String              	email               ;
	protected		RetailStoreCountryCenter	company             ;
	protected		String              	introduction        ;
	protected		DateTime            	lastUpdateTime      ;
	protected		int                 	version             ;

	
	protected		SmartList<CompanyTraining>	mCompanyTrainingList;



	public 	Instructor(){
		// lazy load for all the properties
	}
	public 	static Instructor withId(String id){
		Instructor instructor = new Instructor();
		instructor.setId(id);
		instructor.setVersion(Integer.MAX_VALUE);
		instructor.setChecked(true);
		return instructor;
	}
	public 	static Instructor refById(String id){
		return withId(id);
	}

  public Instructor limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public Instructor limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static Instructor searchExample(){
    Instructor instructor = new Instructor();
    		instructor.setVersion(UNSET_INT);

    return instructor;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setCompany( null );

		this.changed = true;
		setChecked(false);
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

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public Instructor updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public Instructor orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public Instructor ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public Instructor addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setTitle(String title){String oldTitle = this.title;String newTitle = trimString(title);this.title = newTitle;}
	public String title(){
doLoad();
return getTitle();
}
	public String getTitle(){
		return this.title;
	}
	public Instructor updateTitle(String title){String oldTitle = this.title;String newTitle = trimString(title);if(!shouldReplaceBy(newTitle, oldTitle)){return this;}this.title = newTitle;addPropertyChange(TITLE_PROPERTY, oldTitle, newTitle);this.changed = true;setChecked(false);return this;}
	public Instructor orderByTitle(boolean asc){
doAddOrderBy(TITLE_PROPERTY, asc);
return this;
}
	public SearchCriteria createTitleCriteria(QueryOperator operator, Object... parameters){
return createCriteria(TITLE_PROPERTY, operator, parameters);
}
	public Instructor ignoreTitleCriteria(){super.ignoreSearchProperty(TITLE_PROPERTY);
return this;
}
	public Instructor addTitleCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createTitleCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeTitle(String title){
		if(title != null) { setTitle(title);}
	}

	
	public void setFamilyName(String familyName){String oldFamilyName = this.familyName;String newFamilyName = trimString(familyName);this.familyName = newFamilyName;}
	public String familyName(){
doLoad();
return getFamilyName();
}
	public String getFamilyName(){
		return this.familyName;
	}
	public Instructor updateFamilyName(String familyName){String oldFamilyName = this.familyName;String newFamilyName = trimString(familyName);if(!shouldReplaceBy(newFamilyName, oldFamilyName)){return this;}this.familyName = newFamilyName;addPropertyChange(FAMILY_NAME_PROPERTY, oldFamilyName, newFamilyName);this.changed = true;setChecked(false);return this;}
	public Instructor orderByFamilyName(boolean asc){
doAddOrderBy(FAMILY_NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createFamilyNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(FAMILY_NAME_PROPERTY, operator, parameters);
}
	public Instructor ignoreFamilyNameCriteria(){super.ignoreSearchProperty(FAMILY_NAME_PROPERTY);
return this;
}
	public Instructor addFamilyNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createFamilyNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeFamilyName(String familyName){
		if(familyName != null) { setFamilyName(familyName);}
	}

	
	public void setGivenName(String givenName){String oldGivenName = this.givenName;String newGivenName = trimString(givenName);this.givenName = newGivenName;}
	public String givenName(){
doLoad();
return getGivenName();
}
	public String getGivenName(){
		return this.givenName;
	}
	public Instructor updateGivenName(String givenName){String oldGivenName = this.givenName;String newGivenName = trimString(givenName);if(!shouldReplaceBy(newGivenName, oldGivenName)){return this;}this.givenName = newGivenName;addPropertyChange(GIVEN_NAME_PROPERTY, oldGivenName, newGivenName);this.changed = true;setChecked(false);return this;}
	public Instructor orderByGivenName(boolean asc){
doAddOrderBy(GIVEN_NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createGivenNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(GIVEN_NAME_PROPERTY, operator, parameters);
}
	public Instructor ignoreGivenNameCriteria(){super.ignoreSearchProperty(GIVEN_NAME_PROPERTY);
return this;
}
	public Instructor addGivenNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createGivenNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeGivenName(String givenName){
		if(givenName != null) { setGivenName(givenName);}
	}

	
	public void setCellPhone(String cellPhone){String oldCellPhone = this.cellPhone;String newCellPhone = trimString(cellPhone);this.cellPhone = newCellPhone;}
	public String cellPhone(){
doLoad();
return getCellPhone();
}
	public String getCellPhone(){
		return this.cellPhone;
	}
	public Instructor updateCellPhone(String cellPhone){String oldCellPhone = this.cellPhone;String newCellPhone = trimString(cellPhone);if(!shouldReplaceBy(newCellPhone, oldCellPhone)){return this;}this.cellPhone = newCellPhone;addPropertyChange(CELL_PHONE_PROPERTY, oldCellPhone, newCellPhone);this.changed = true;setChecked(false);return this;}
	public Instructor orderByCellPhone(boolean asc){
doAddOrderBy(CELL_PHONE_PROPERTY, asc);
return this;
}
	public SearchCriteria createCellPhoneCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CELL_PHONE_PROPERTY, operator, parameters);
}
	public Instructor ignoreCellPhoneCriteria(){super.ignoreSearchProperty(CELL_PHONE_PROPERTY);
return this;
}
	public Instructor addCellPhoneCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCellPhoneCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCellPhone(String cellPhone){
		if(cellPhone != null) { setCellPhone(cellPhone);}
	}

	

	public String getMaskedCellPhone(){
		String mobilePhoneNumber = getCellPhone();
		return maskChinaMobileNumber(mobilePhoneNumber);
	}

		
	public void setEmail(String email){String oldEmail = this.email;String newEmail = trimString(email);this.email = newEmail;}
	public String email(){
doLoad();
return getEmail();
}
	public String getEmail(){
		return this.email;
	}
	public Instructor updateEmail(String email){String oldEmail = this.email;String newEmail = trimString(email);if(!shouldReplaceBy(newEmail, oldEmail)){return this;}this.email = newEmail;addPropertyChange(EMAIL_PROPERTY, oldEmail, newEmail);this.changed = true;setChecked(false);return this;}
	public Instructor orderByEmail(boolean asc){
doAddOrderBy(EMAIL_PROPERTY, asc);
return this;
}
	public SearchCriteria createEmailCriteria(QueryOperator operator, Object... parameters){
return createCriteria(EMAIL_PROPERTY, operator, parameters);
}
	public Instructor ignoreEmailCriteria(){super.ignoreSearchProperty(EMAIL_PROPERTY);
return this;
}
	public Instructor addEmailCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createEmailCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeEmail(String email){
		if(email != null) { setEmail(email);}
	}

	
	public void setCompany(RetailStoreCountryCenter company){RetailStoreCountryCenter oldCompany = this.company;RetailStoreCountryCenter newCompany = company;this.company = newCompany;}
	public RetailStoreCountryCenter company(){
doLoad();
return getCompany();
}
	public RetailStoreCountryCenter getCompany(){
		return this.company;
	}
	public Instructor updateCompany(RetailStoreCountryCenter company){RetailStoreCountryCenter oldCompany = this.company;RetailStoreCountryCenter newCompany = company;if(!shouldReplaceBy(newCompany, oldCompany)){return this;}this.company = newCompany;addPropertyChange(COMPANY_PROPERTY, oldCompany, newCompany);this.changed = true;setChecked(false);return this;}
	public Instructor orderByCompany(boolean asc){
doAddOrderBy(COMPANY_PROPERTY, asc);
return this;
}
	public SearchCriteria createCompanyCriteria(QueryOperator operator, Object... parameters){
return createCriteria(COMPANY_PROPERTY, operator, parameters);
}
	public Instructor ignoreCompanyCriteria(){super.ignoreSearchProperty(COMPANY_PROPERTY);
return this;
}
	public Instructor addCompanyCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCompanyCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCompany(RetailStoreCountryCenter company){
		if(company != null) { setCompany(company);}
	}

	
	public void clearCompany(){
		setCompany ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setIntroduction(String introduction){String oldIntroduction = this.introduction;String newIntroduction = trimString(introduction);this.introduction = newIntroduction;}
	public String introduction(){
doLoad();
return getIntroduction();
}
	public String getIntroduction(){
		return this.introduction;
	}
	public Instructor updateIntroduction(String introduction){String oldIntroduction = this.introduction;String newIntroduction = trimString(introduction);if(!shouldReplaceBy(newIntroduction, oldIntroduction)){return this;}this.introduction = newIntroduction;addPropertyChange(INTRODUCTION_PROPERTY, oldIntroduction, newIntroduction);this.changed = true;setChecked(false);return this;}
	public Instructor orderByIntroduction(boolean asc){
doAddOrderBy(INTRODUCTION_PROPERTY, asc);
return this;
}
	public SearchCriteria createIntroductionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(INTRODUCTION_PROPERTY, operator, parameters);
}
	public Instructor ignoreIntroductionCriteria(){super.ignoreSearchProperty(INTRODUCTION_PROPERTY);
return this;
}
	public Instructor addIntroductionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIntroductionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeIntroduction(String introduction){
		if(introduction != null) { setIntroduction(introduction);}
	}

	
	public void setLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;this.lastUpdateTime = newLastUpdateTime;}
	public DateTime lastUpdateTime(){
doLoad();
return getLastUpdateTime();
}
	public DateTime getLastUpdateTime(){
		return this.lastUpdateTime;
	}
	public Instructor updateLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;if(!shouldReplaceBy(newLastUpdateTime, oldLastUpdateTime)){return this;}this.lastUpdateTime = newLastUpdateTime;addPropertyChange(LAST_UPDATE_TIME_PROPERTY, oldLastUpdateTime, newLastUpdateTime);this.changed = true;setChecked(false);return this;}
	public Instructor orderByLastUpdateTime(boolean asc){
doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
}
	public Instructor ignoreLastUpdateTimeCriteria(){super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
return this;
}
	public Instructor addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createLastUpdateTimeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeLastUpdateTime(DateTime lastUpdateTime){
		setLastUpdateTime(lastUpdateTime);
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public Instructor updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public Instructor orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public Instructor ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public Instructor addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
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

  public  SmartList<CompanyTraining> companyTrainingList(){
    
    doLoadChild(COMPANY_TRAINING_LIST);
    
    return getCompanyTrainingList();
  }


	public  void setCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList){
		for( CompanyTraining companyTraining:companyTrainingList){
			companyTraining.setInstructor(this);
		}

		this.mCompanyTrainingList = companyTrainingList;
		this.mCompanyTrainingList.setListInternalName (COMPANY_TRAINING_LIST );

	}

	public  Instructor addCompanyTraining(CompanyTraining companyTraining){
		companyTraining.setInstructor(this);
		getCompanyTrainingList().add(companyTraining);
		return this;
	}
	public  Instructor addCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList){
		for( CompanyTraining companyTraining:companyTrainingList){
			companyTraining.setInstructor(this);
		}
		getCompanyTrainingList().addAll(companyTrainingList);
		return this;
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


	public static Instructor createWith(RetailscmUserContext userContext, ThrowingFunction<Instructor,Instructor,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<Instructor> customCreator = mapper.findCustomCreator(Instructor.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    Instructor result = new Instructor();
    result.setTitle(mapper.tryToGet(Instructor.class, TITLE_PROPERTY, String.class,
        0, false, result.getTitle(), params));
    result.setFamilyName(mapper.tryToGet(Instructor.class, FAMILY_NAME_PROPERTY, String.class,
        1, false, result.getFamilyName(), params));
    result.setGivenName(mapper.tryToGet(Instructor.class, GIVEN_NAME_PROPERTY, String.class,
        2, false, result.getGivenName(), params));
    result.setCellPhone(mapper.tryToGet(Instructor.class, CELL_PHONE_PROPERTY, String.class,
        3, false, result.getCellPhone(), params));
    result.setEmail(mapper.tryToGet(Instructor.class, EMAIL_PROPERTY, String.class,
        4, false, result.getEmail(), params));
    result.setCompany(mapper.tryToGet(Instructor.class, COMPANY_PROPERTY, RetailStoreCountryCenter.class,
        0, true, result.getCompany(), params));
    result.setIntroduction(mapper.tryToGet(Instructor.class, INTRODUCTION_PROPERTY, String.class,
        5, false, result.getIntroduction(), params));
     result.setLastUpdateTime(userContext.now());

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixInstructor(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      InstructorTokens tokens = mapper.findParamByClass(params, InstructorTokens.class);
      if (tokens == null) {
        tokens = InstructorTokens.start();
      }
      result = userContext.getManagerGroup().getInstructorManager().internalSaveInstructor(userContext, result, tokens.done());
      
    }
    return result;
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

