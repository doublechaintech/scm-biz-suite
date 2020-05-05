
package com.doublechaintech.retailscm.retailstorecountrycenter;

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
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.leavetype.LeaveType;
import com.doublechaintech.retailscm.catalog.Catalog;
import com.doublechaintech.retailscm.publicholiday.PublicHoliday;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.skilltype.SkillType;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;
import com.doublechaintech.retailscm.interviewtype.InterviewType;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.accountset.AccountSet;

@JsonSerialize(using = RetailStoreCountryCenterSerializer.class)
public class RetailStoreCountryCenter extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String SERVICE_NUMBER_PROPERTY        = "serviceNumber"     ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String WEB_SITE_PROPERTY              = "webSite"           ;
	public static final String ADDRESS_PROPERTY               = "address"           ;
	public static final String OPERATED_BY_PROPERTY           = "operatedBy"        ;
	public static final String LEGAL_REPRESENTATIVE_PROPERTY  = "legalRepresentative";
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String CATALOG_LIST                             = "catalogList"       ;
	public static final String RETAIL_STORE_PROVINCE_CENTER_LIST        = "retailStoreProvinceCenterList";
	public static final String RETAIL_STORE_LIST                        = "retailStoreList"   ;
	public static final String RETAIL_STORE_MEMBER_LIST                 = "retailStoreMemberList";
	public static final String GOODS_SUPPLIER_LIST                      = "goodsSupplierList" ;
	public static final String SUPPLY_ORDER_LIST                        = "supplyOrderList"   ;
	public static final String RETAIL_STORE_ORDER_LIST                  = "retailStoreOrderList";
	public static final String WAREHOUSE_LIST                           = "warehouseList"     ;
	public static final String TRANSPORT_FLEET_LIST                     = "transportFleetList";
	public static final String ACCOUNT_SET_LIST                         = "accountSetList"    ;
	public static final String LEVEL_ONE_DEPARTMENT_LIST                = "levelOneDepartmentList";
	public static final String SKILL_TYPE_LIST                          = "skillTypeList"     ;
	public static final String RESPONSIBILITY_TYPE_LIST                 = "responsibilityTypeList";
	public static final String TERMINATION_REASON_LIST                  = "terminationReasonList";
	public static final String TERMINATION_TYPE_LIST                    = "terminationTypeList";
	public static final String OCCUPATION_TYPE_LIST                     = "occupationTypeList";
	public static final String LEAVE_TYPE_LIST                          = "leaveTypeList"     ;
	public static final String SALARY_GRADE_LIST                        = "salaryGradeList"   ;
	public static final String INTERVIEW_TYPE_LIST                      = "interviewTypeList" ;
	public static final String TRAINING_COURSE_TYPE_LIST                = "trainingCourseTypeList";
	public static final String PUBLIC_HOLIDAY_LIST                      = "publicHolidayList" ;
	public static final String EMPLOYEE_LIST                            = "employeeList"      ;
	public static final String INSTRUCTOR_LIST                          = "instructorList"    ;
	public static final String COMPANY_TRAINING_LIST                    = "companyTrainingList";

	public static final String INTERNAL_TYPE="RetailStoreCountryCenter";
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
	protected		String              	mServiceNumber      ;
	protected		Date                	mFounded            ;
	protected		String              	mWebSite            ;
	protected		String              	mAddress            ;
	protected		String              	mOperatedBy         ;
	protected		String              	mLegalRepresentative;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Catalog>  	mCatalogList        ;
	protected		SmartList<RetailStoreProvinceCenter>	mRetailStoreProvinceCenterList;
	protected		SmartList<RetailStore>	mRetailStoreList    ;
	protected		SmartList<RetailStoreMember>	mRetailStoreMemberList;
	protected		SmartList<GoodsSupplier>	mGoodsSupplierList  ;
	protected		SmartList<SupplyOrder>	mSupplyOrderList    ;
	protected		SmartList<RetailStoreOrder>	mRetailStoreOrderList;
	protected		SmartList<Warehouse>	mWarehouseList      ;
	protected		SmartList<TransportFleet>	mTransportFleetList ;
	protected		SmartList<AccountSet>	mAccountSetList     ;
	protected		SmartList<LevelOneDepartment>	mLevelOneDepartmentList;
	protected		SmartList<SkillType>	mSkillTypeList      ;
	protected		SmartList<ResponsibilityType>	mResponsibilityTypeList;
	protected		SmartList<TerminationReason>	mTerminationReasonList;
	protected		SmartList<TerminationType>	mTerminationTypeList;
	protected		SmartList<OccupationType>	mOccupationTypeList ;
	protected		SmartList<LeaveType>	mLeaveTypeList      ;
	protected		SmartList<SalaryGrade>	mSalaryGradeList    ;
	protected		SmartList<InterviewType>	mInterviewTypeList  ;
	protected		SmartList<TrainingCourseType>	mTrainingCourseTypeList;
	protected		SmartList<PublicHoliday>	mPublicHolidayList  ;
	protected		SmartList<Employee> 	mEmployeeList       ;
	protected		SmartList<Instructor>	mInstructorList     ;
	protected		SmartList<CompanyTraining>	mCompanyTrainingList;

	
		
	public 	RetailStoreCountryCenter(){
		// lazy load for all the properties
	}
	public 	static RetailStoreCountryCenter withId(String id){
		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
		retailStoreCountryCenter.setId(id);
		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
		return retailStoreCountryCenter;
	}
	public 	static RetailStoreCountryCenter refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(SERVICE_NUMBER_PROPERTY.equals(property)){
			changeServiceNumberProperty(newValueExpr);
		}
		if(FOUNDED_PROPERTY.equals(property)){
			changeFoundedProperty(newValueExpr);
		}
		if(WEB_SITE_PROPERTY.equals(property)){
			changeWebSiteProperty(newValueExpr);
		}
		if(ADDRESS_PROPERTY.equals(property)){
			changeAddressProperty(newValueExpr);
		}
		if(OPERATED_BY_PROPERTY.equals(property)){
			changeOperatedByProperty(newValueExpr);
		}
		if(LEGAL_REPRESENTATIVE_PROPERTY.equals(property)){
			changeLegalRepresentativeProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
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
			
			
			
	protected void changeServiceNumberProperty(String newValueExpr){
	
		String oldValue = getServiceNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateServiceNumber(newValue);
		this.onChangeProperty(SERVICE_NUMBER_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeFoundedProperty(String newValueExpr){
	
		Date oldValue = getFounded();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateFounded(newValue);
		this.onChangeProperty(FOUNDED_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeWebSiteProperty(String newValueExpr){
	
		String oldValue = getWebSite();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateWebSite(newValue);
		this.onChangeProperty(WEB_SITE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeAddressProperty(String newValueExpr){
	
		String oldValue = getAddress();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAddress(newValue);
		this.onChangeProperty(ADDRESS_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeOperatedByProperty(String newValueExpr){
	
		String oldValue = getOperatedBy();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateOperatedBy(newValue);
		this.onChangeProperty(OPERATED_BY_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeLegalRepresentativeProperty(String newValueExpr){
	
		String oldValue = getLegalRepresentative();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLegalRepresentative(newValue);
		this.onChangeProperty(LEGAL_REPRESENTATIVE_PROPERTY, oldValue, newValue);
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
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(SERVICE_NUMBER_PROPERTY.equals(property)){
			return getServiceNumber();
		}
		if(FOUNDED_PROPERTY.equals(property)){
			return getFounded();
		}
		if(WEB_SITE_PROPERTY.equals(property)){
			return getWebSite();
		}
		if(ADDRESS_PROPERTY.equals(property)){
			return getAddress();
		}
		if(OPERATED_BY_PROPERTY.equals(property)){
			return getOperatedBy();
		}
		if(LEGAL_REPRESENTATIVE_PROPERTY.equals(property)){
			return getLegalRepresentative();
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			return getDescription();
		}
		if(CATALOG_LIST.equals(property)){
			List<BaseEntity> list = getCatalogList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(RETAIL_STORE_PROVINCE_CENTER_LIST.equals(property)){
			List<BaseEntity> list = getRetailStoreProvinceCenterList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(RETAIL_STORE_LIST.equals(property)){
			List<BaseEntity> list = getRetailStoreList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(RETAIL_STORE_MEMBER_LIST.equals(property)){
			List<BaseEntity> list = getRetailStoreMemberList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(GOODS_SUPPLIER_LIST.equals(property)){
			List<BaseEntity> list = getGoodsSupplierList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(SUPPLY_ORDER_LIST.equals(property)){
			List<BaseEntity> list = getSupplyOrderList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(RETAIL_STORE_ORDER_LIST.equals(property)){
			List<BaseEntity> list = getRetailStoreOrderList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(WAREHOUSE_LIST.equals(property)){
			List<BaseEntity> list = getWarehouseList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(TRANSPORT_FLEET_LIST.equals(property)){
			List<BaseEntity> list = getTransportFleetList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(ACCOUNT_SET_LIST.equals(property)){
			List<BaseEntity> list = getAccountSetList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(LEVEL_ONE_DEPARTMENT_LIST.equals(property)){
			List<BaseEntity> list = getLevelOneDepartmentList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(SKILL_TYPE_LIST.equals(property)){
			List<BaseEntity> list = getSkillTypeList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(RESPONSIBILITY_TYPE_LIST.equals(property)){
			List<BaseEntity> list = getResponsibilityTypeList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(TERMINATION_REASON_LIST.equals(property)){
			List<BaseEntity> list = getTerminationReasonList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(TERMINATION_TYPE_LIST.equals(property)){
			List<BaseEntity> list = getTerminationTypeList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(OCCUPATION_TYPE_LIST.equals(property)){
			List<BaseEntity> list = getOccupationTypeList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(LEAVE_TYPE_LIST.equals(property)){
			List<BaseEntity> list = getLeaveTypeList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(SALARY_GRADE_LIST.equals(property)){
			List<BaseEntity> list = getSalaryGradeList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(INTERVIEW_TYPE_LIST.equals(property)){
			List<BaseEntity> list = getInterviewTypeList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(TRAINING_COURSE_TYPE_LIST.equals(property)){
			List<BaseEntity> list = getTrainingCourseTypeList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(PUBLIC_HOLIDAY_LIST.equals(property)){
			List<BaseEntity> list = getPublicHolidayList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(EMPLOYEE_LIST.equals(property)){
			List<BaseEntity> list = getEmployeeList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(INSTRUCTOR_LIST.equals(property)){
			List<BaseEntity> list = getInstructorList().stream().map(item->item).collect(Collectors.toList());
			return list;
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
	public RetailStoreCountryCenter updateId(String id){
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
	public RetailStoreCountryCenter updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setServiceNumber(String serviceNumber){
		this.mServiceNumber = trimString(serviceNumber);;
	}
	public String getServiceNumber(){
		return this.mServiceNumber;
	}
	public RetailStoreCountryCenter updateServiceNumber(String serviceNumber){
		this.mServiceNumber = trimString(serviceNumber);;
		this.changed = true;
		return this;
	}
	public void mergeServiceNumber(String serviceNumber){
		if(serviceNumber != null) { setServiceNumber(serviceNumber);}
	}
	
	
	public void setFounded(Date founded){
		this.mFounded = founded;;
	}
	public Date getFounded(){
		return this.mFounded;
	}
	public RetailStoreCountryCenter updateFounded(Date founded){
		this.mFounded = founded;;
		this.changed = true;
		return this;
	}
	public void mergeFounded(Date founded){
		setFounded(founded);
	}
	
	
	public void setWebSite(String webSite){
		this.mWebSite = trimString(encodeUrl(webSite));;
	}
	public String getWebSite(){
		return this.mWebSite;
	}
	public RetailStoreCountryCenter updateWebSite(String webSite){
		this.mWebSite = trimString(encodeUrl(webSite));;
		this.changed = true;
		return this;
	}
	public void mergeWebSite(String webSite){
		if(webSite != null) { setWebSite(webSite);}
	}
	
	
	public void setAddress(String address){
		this.mAddress = trimString(address);;
	}
	public String getAddress(){
		return this.mAddress;
	}
	public RetailStoreCountryCenter updateAddress(String address){
		this.mAddress = trimString(address);;
		this.changed = true;
		return this;
	}
	public void mergeAddress(String address){
		if(address != null) { setAddress(address);}
	}
	
	
	public void setOperatedBy(String operatedBy){
		this.mOperatedBy = trimString(operatedBy);;
	}
	public String getOperatedBy(){
		return this.mOperatedBy;
	}
	public RetailStoreCountryCenter updateOperatedBy(String operatedBy){
		this.mOperatedBy = trimString(operatedBy);;
		this.changed = true;
		return this;
	}
	public void mergeOperatedBy(String operatedBy){
		if(operatedBy != null) { setOperatedBy(operatedBy);}
	}
	
	
	public void setLegalRepresentative(String legalRepresentative){
		this.mLegalRepresentative = trimString(legalRepresentative);;
	}
	public String getLegalRepresentative(){
		return this.mLegalRepresentative;
	}
	public RetailStoreCountryCenter updateLegalRepresentative(String legalRepresentative){
		this.mLegalRepresentative = trimString(legalRepresentative);;
		this.changed = true;
		return this;
	}
	public void mergeLegalRepresentative(String legalRepresentative){
		if(legalRepresentative != null) { setLegalRepresentative(legalRepresentative);}
	}
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public RetailStoreCountryCenter updateDescription(String description){
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
	public RetailStoreCountryCenter updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<Catalog> getCatalogList(){
		if(this.mCatalogList == null){
			this.mCatalogList = new SmartList<Catalog>();
			this.mCatalogList.setListInternalName (CATALOG_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mCatalogList;	
	}
	public  void setCatalogList(SmartList<Catalog> catalogList){
		for( Catalog catalog:catalogList){
			catalog.setOwner(this);
		}

		this.mCatalogList = catalogList;
		this.mCatalogList.setListInternalName (CATALOG_LIST );
		
	}
	
	public  void addCatalog(Catalog catalog){
		catalog.setOwner(this);
		getCatalogList().add(catalog);
	}
	public  void addCatalogList(SmartList<Catalog> catalogList){
		for( Catalog catalog:catalogList){
			catalog.setOwner(this);
		}
		getCatalogList().addAll(catalogList);
	}
	public  void mergeCatalogList(SmartList<Catalog> catalogList){
		if(catalogList==null){
			return;
		}
		if(catalogList.isEmpty()){
			return;
		}
		addCatalogList( catalogList );
		
	}
	public  Catalog removeCatalog(Catalog catalogIndex){
		
		int index = getCatalogList().indexOf(catalogIndex);
        if(index < 0){
        	String message = "Catalog("+catalogIndex.getId()+") with version='"+catalogIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Catalog catalog = getCatalogList().get(index);        
        // catalog.clearOwner(); //disconnect with Owner
        catalog.clearFromAll(); //disconnect with Owner
		
		boolean result = getCatalogList().planToRemove(catalog);
        if(!result){
        	String message = "Catalog("+catalogIndex.getId()+") with version='"+catalogIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return catalog;
        
	
	}
	//断舍离
	public  void breakWithCatalog(Catalog catalog){
		
		if(catalog == null){
			return;
		}
		catalog.setOwner(null);
		//getCatalogList().remove();
	
	}
	
	public  boolean hasCatalog(Catalog catalog){
	
		return getCatalogList().contains(catalog);
  
	}
	
	public void copyCatalogFrom(Catalog catalog) {

		Catalog catalogInList = findTheCatalog(catalog);
		Catalog newCatalog = new Catalog();
		catalogInList.copyTo(newCatalog);
		newCatalog.setVersion(0);//will trigger copy
		getCatalogList().add(newCatalog);
		addItemToFlexiableObject(COPIED_CHILD, newCatalog);
	}
	
	public  Catalog findTheCatalog(Catalog catalog){
		
		int index =  getCatalogList().indexOf(catalog);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Catalog("+catalog.getId()+") with version='"+catalog.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getCatalogList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpCatalogList(){
		getCatalogList().clear();
	}
	
	
	


	public  SmartList<RetailStoreProvinceCenter> getRetailStoreProvinceCenterList(){
		if(this.mRetailStoreProvinceCenterList == null){
			this.mRetailStoreProvinceCenterList = new SmartList<RetailStoreProvinceCenter>();
			this.mRetailStoreProvinceCenterList.setListInternalName (RETAIL_STORE_PROVINCE_CENTER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mRetailStoreProvinceCenterList;	
	}
	public  void setRetailStoreProvinceCenterList(SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList){
		for( RetailStoreProvinceCenter retailStoreProvinceCenter:retailStoreProvinceCenterList){
			retailStoreProvinceCenter.setCountry(this);
		}

		this.mRetailStoreProvinceCenterList = retailStoreProvinceCenterList;
		this.mRetailStoreProvinceCenterList.setListInternalName (RETAIL_STORE_PROVINCE_CENTER_LIST );
		
	}
	
	public  void addRetailStoreProvinceCenter(RetailStoreProvinceCenter retailStoreProvinceCenter){
		retailStoreProvinceCenter.setCountry(this);
		getRetailStoreProvinceCenterList().add(retailStoreProvinceCenter);
	}
	public  void addRetailStoreProvinceCenterList(SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList){
		for( RetailStoreProvinceCenter retailStoreProvinceCenter:retailStoreProvinceCenterList){
			retailStoreProvinceCenter.setCountry(this);
		}
		getRetailStoreProvinceCenterList().addAll(retailStoreProvinceCenterList);
	}
	public  void mergeRetailStoreProvinceCenterList(SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList){
		if(retailStoreProvinceCenterList==null){
			return;
		}
		if(retailStoreProvinceCenterList.isEmpty()){
			return;
		}
		addRetailStoreProvinceCenterList( retailStoreProvinceCenterList );
		
	}
	public  RetailStoreProvinceCenter removeRetailStoreProvinceCenter(RetailStoreProvinceCenter retailStoreProvinceCenterIndex){
		
		int index = getRetailStoreProvinceCenterList().indexOf(retailStoreProvinceCenterIndex);
        if(index < 0){
        	String message = "RetailStoreProvinceCenter("+retailStoreProvinceCenterIndex.getId()+") with version='"+retailStoreProvinceCenterIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RetailStoreProvinceCenter retailStoreProvinceCenter = getRetailStoreProvinceCenterList().get(index);        
        // retailStoreProvinceCenter.clearCountry(); //disconnect with Country
        retailStoreProvinceCenter.clearFromAll(); //disconnect with Country
		
		boolean result = getRetailStoreProvinceCenterList().planToRemove(retailStoreProvinceCenter);
        if(!result){
        	String message = "RetailStoreProvinceCenter("+retailStoreProvinceCenterIndex.getId()+") with version='"+retailStoreProvinceCenterIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return retailStoreProvinceCenter;
        
	
	}
	//断舍离
	public  void breakWithRetailStoreProvinceCenter(RetailStoreProvinceCenter retailStoreProvinceCenter){
		
		if(retailStoreProvinceCenter == null){
			return;
		}
		retailStoreProvinceCenter.setCountry(null);
		//getRetailStoreProvinceCenterList().remove();
	
	}
	
	public  boolean hasRetailStoreProvinceCenter(RetailStoreProvinceCenter retailStoreProvinceCenter){
	
		return getRetailStoreProvinceCenterList().contains(retailStoreProvinceCenter);
  
	}
	
	public void copyRetailStoreProvinceCenterFrom(RetailStoreProvinceCenter retailStoreProvinceCenter) {

		RetailStoreProvinceCenter retailStoreProvinceCenterInList = findTheRetailStoreProvinceCenter(retailStoreProvinceCenter);
		RetailStoreProvinceCenter newRetailStoreProvinceCenter = new RetailStoreProvinceCenter();
		retailStoreProvinceCenterInList.copyTo(newRetailStoreProvinceCenter);
		newRetailStoreProvinceCenter.setVersion(0);//will trigger copy
		getRetailStoreProvinceCenterList().add(newRetailStoreProvinceCenter);
		addItemToFlexiableObject(COPIED_CHILD, newRetailStoreProvinceCenter);
	}
	
	public  RetailStoreProvinceCenter findTheRetailStoreProvinceCenter(RetailStoreProvinceCenter retailStoreProvinceCenter){
		
		int index =  getRetailStoreProvinceCenterList().indexOf(retailStoreProvinceCenter);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "RetailStoreProvinceCenter("+retailStoreProvinceCenter.getId()+") with version='"+retailStoreProvinceCenter.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRetailStoreProvinceCenterList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreProvinceCenterList(){
		getRetailStoreProvinceCenterList().clear();
	}
	
	
	


	public  SmartList<RetailStore> getRetailStoreList(){
		if(this.mRetailStoreList == null){
			this.mRetailStoreList = new SmartList<RetailStore>();
			this.mRetailStoreList.setListInternalName (RETAIL_STORE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mRetailStoreList;	
	}
	public  void setRetailStoreList(SmartList<RetailStore> retailStoreList){
		for( RetailStore retailStore:retailStoreList){
			retailStore.setRetailStoreCountryCenter(this);
		}

		this.mRetailStoreList = retailStoreList;
		this.mRetailStoreList.setListInternalName (RETAIL_STORE_LIST );
		
	}
	
	public  void addRetailStore(RetailStore retailStore){
		retailStore.setRetailStoreCountryCenter(this);
		getRetailStoreList().add(retailStore);
	}
	public  void addRetailStoreList(SmartList<RetailStore> retailStoreList){
		for( RetailStore retailStore:retailStoreList){
			retailStore.setRetailStoreCountryCenter(this);
		}
		getRetailStoreList().addAll(retailStoreList);
	}
	public  void mergeRetailStoreList(SmartList<RetailStore> retailStoreList){
		if(retailStoreList==null){
			return;
		}
		if(retailStoreList.isEmpty()){
			return;
		}
		addRetailStoreList( retailStoreList );
		
	}
	public  RetailStore removeRetailStore(RetailStore retailStoreIndex){
		
		int index = getRetailStoreList().indexOf(retailStoreIndex);
        if(index < 0){
        	String message = "RetailStore("+retailStoreIndex.getId()+") with version='"+retailStoreIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RetailStore retailStore = getRetailStoreList().get(index);        
        // retailStore.clearRetailStoreCountryCenter(); //disconnect with RetailStoreCountryCenter
        retailStore.clearFromAll(); //disconnect with RetailStoreCountryCenter
		
		boolean result = getRetailStoreList().planToRemove(retailStore);
        if(!result){
        	String message = "RetailStore("+retailStoreIndex.getId()+") with version='"+retailStoreIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return retailStore;
        
	
	}
	//断舍离
	public  void breakWithRetailStore(RetailStore retailStore){
		
		if(retailStore == null){
			return;
		}
		retailStore.setRetailStoreCountryCenter(null);
		//getRetailStoreList().remove();
	
	}
	
	public  boolean hasRetailStore(RetailStore retailStore){
	
		return getRetailStoreList().contains(retailStore);
  
	}
	
	public void copyRetailStoreFrom(RetailStore retailStore) {

		RetailStore retailStoreInList = findTheRetailStore(retailStore);
		RetailStore newRetailStore = new RetailStore();
		retailStoreInList.copyTo(newRetailStore);
		newRetailStore.setVersion(0);//will trigger copy
		getRetailStoreList().add(newRetailStore);
		addItemToFlexiableObject(COPIED_CHILD, newRetailStore);
	}
	
	public  RetailStore findTheRetailStore(RetailStore retailStore){
		
		int index =  getRetailStoreList().indexOf(retailStore);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "RetailStore("+retailStore.getId()+") with version='"+retailStore.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRetailStoreList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreList(){
		getRetailStoreList().clear();
	}
	
	
	


	public  SmartList<RetailStoreMember> getRetailStoreMemberList(){
		if(this.mRetailStoreMemberList == null){
			this.mRetailStoreMemberList = new SmartList<RetailStoreMember>();
			this.mRetailStoreMemberList.setListInternalName (RETAIL_STORE_MEMBER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mRetailStoreMemberList;	
	}
	public  void setRetailStoreMemberList(SmartList<RetailStoreMember> retailStoreMemberList){
		for( RetailStoreMember retailStoreMember:retailStoreMemberList){
			retailStoreMember.setOwner(this);
		}

		this.mRetailStoreMemberList = retailStoreMemberList;
		this.mRetailStoreMemberList.setListInternalName (RETAIL_STORE_MEMBER_LIST );
		
	}
	
	public  void addRetailStoreMember(RetailStoreMember retailStoreMember){
		retailStoreMember.setOwner(this);
		getRetailStoreMemberList().add(retailStoreMember);
	}
	public  void addRetailStoreMemberList(SmartList<RetailStoreMember> retailStoreMemberList){
		for( RetailStoreMember retailStoreMember:retailStoreMemberList){
			retailStoreMember.setOwner(this);
		}
		getRetailStoreMemberList().addAll(retailStoreMemberList);
	}
	public  void mergeRetailStoreMemberList(SmartList<RetailStoreMember> retailStoreMemberList){
		if(retailStoreMemberList==null){
			return;
		}
		if(retailStoreMemberList.isEmpty()){
			return;
		}
		addRetailStoreMemberList( retailStoreMemberList );
		
	}
	public  RetailStoreMember removeRetailStoreMember(RetailStoreMember retailStoreMemberIndex){
		
		int index = getRetailStoreMemberList().indexOf(retailStoreMemberIndex);
        if(index < 0){
        	String message = "RetailStoreMember("+retailStoreMemberIndex.getId()+") with version='"+retailStoreMemberIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RetailStoreMember retailStoreMember = getRetailStoreMemberList().get(index);        
        // retailStoreMember.clearOwner(); //disconnect with Owner
        retailStoreMember.clearFromAll(); //disconnect with Owner
		
		boolean result = getRetailStoreMemberList().planToRemove(retailStoreMember);
        if(!result){
        	String message = "RetailStoreMember("+retailStoreMemberIndex.getId()+") with version='"+retailStoreMemberIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return retailStoreMember;
        
	
	}
	//断舍离
	public  void breakWithRetailStoreMember(RetailStoreMember retailStoreMember){
		
		if(retailStoreMember == null){
			return;
		}
		retailStoreMember.setOwner(null);
		//getRetailStoreMemberList().remove();
	
	}
	
	public  boolean hasRetailStoreMember(RetailStoreMember retailStoreMember){
	
		return getRetailStoreMemberList().contains(retailStoreMember);
  
	}
	
	public void copyRetailStoreMemberFrom(RetailStoreMember retailStoreMember) {

		RetailStoreMember retailStoreMemberInList = findTheRetailStoreMember(retailStoreMember);
		RetailStoreMember newRetailStoreMember = new RetailStoreMember();
		retailStoreMemberInList.copyTo(newRetailStoreMember);
		newRetailStoreMember.setVersion(0);//will trigger copy
		getRetailStoreMemberList().add(newRetailStoreMember);
		addItemToFlexiableObject(COPIED_CHILD, newRetailStoreMember);
	}
	
	public  RetailStoreMember findTheRetailStoreMember(RetailStoreMember retailStoreMember){
		
		int index =  getRetailStoreMemberList().indexOf(retailStoreMember);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "RetailStoreMember("+retailStoreMember.getId()+") with version='"+retailStoreMember.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRetailStoreMemberList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreMemberList(){
		getRetailStoreMemberList().clear();
	}
	
	
	


	public  SmartList<GoodsSupplier> getGoodsSupplierList(){
		if(this.mGoodsSupplierList == null){
			this.mGoodsSupplierList = new SmartList<GoodsSupplier>();
			this.mGoodsSupplierList.setListInternalName (GOODS_SUPPLIER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mGoodsSupplierList;	
	}
	public  void setGoodsSupplierList(SmartList<GoodsSupplier> goodsSupplierList){
		for( GoodsSupplier goodsSupplier:goodsSupplierList){
			goodsSupplier.setBelongTo(this);
		}

		this.mGoodsSupplierList = goodsSupplierList;
		this.mGoodsSupplierList.setListInternalName (GOODS_SUPPLIER_LIST );
		
	}
	
	public  void addGoodsSupplier(GoodsSupplier goodsSupplier){
		goodsSupplier.setBelongTo(this);
		getGoodsSupplierList().add(goodsSupplier);
	}
	public  void addGoodsSupplierList(SmartList<GoodsSupplier> goodsSupplierList){
		for( GoodsSupplier goodsSupplier:goodsSupplierList){
			goodsSupplier.setBelongTo(this);
		}
		getGoodsSupplierList().addAll(goodsSupplierList);
	}
	public  void mergeGoodsSupplierList(SmartList<GoodsSupplier> goodsSupplierList){
		if(goodsSupplierList==null){
			return;
		}
		if(goodsSupplierList.isEmpty()){
			return;
		}
		addGoodsSupplierList( goodsSupplierList );
		
	}
	public  GoodsSupplier removeGoodsSupplier(GoodsSupplier goodsSupplierIndex){
		
		int index = getGoodsSupplierList().indexOf(goodsSupplierIndex);
        if(index < 0){
        	String message = "GoodsSupplier("+goodsSupplierIndex.getId()+") with version='"+goodsSupplierIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        GoodsSupplier goodsSupplier = getGoodsSupplierList().get(index);        
        // goodsSupplier.clearBelongTo(); //disconnect with BelongTo
        goodsSupplier.clearFromAll(); //disconnect with BelongTo
		
		boolean result = getGoodsSupplierList().planToRemove(goodsSupplier);
        if(!result){
        	String message = "GoodsSupplier("+goodsSupplierIndex.getId()+") with version='"+goodsSupplierIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return goodsSupplier;
        
	
	}
	//断舍离
	public  void breakWithGoodsSupplier(GoodsSupplier goodsSupplier){
		
		if(goodsSupplier == null){
			return;
		}
		goodsSupplier.setBelongTo(null);
		//getGoodsSupplierList().remove();
	
	}
	
	public  boolean hasGoodsSupplier(GoodsSupplier goodsSupplier){
	
		return getGoodsSupplierList().contains(goodsSupplier);
  
	}
	
	public void copyGoodsSupplierFrom(GoodsSupplier goodsSupplier) {

		GoodsSupplier goodsSupplierInList = findTheGoodsSupplier(goodsSupplier);
		GoodsSupplier newGoodsSupplier = new GoodsSupplier();
		goodsSupplierInList.copyTo(newGoodsSupplier);
		newGoodsSupplier.setVersion(0);//will trigger copy
		getGoodsSupplierList().add(newGoodsSupplier);
		addItemToFlexiableObject(COPIED_CHILD, newGoodsSupplier);
	}
	
	public  GoodsSupplier findTheGoodsSupplier(GoodsSupplier goodsSupplier){
		
		int index =  getGoodsSupplierList().indexOf(goodsSupplier);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "GoodsSupplier("+goodsSupplier.getId()+") with version='"+goodsSupplier.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getGoodsSupplierList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpGoodsSupplierList(){
		getGoodsSupplierList().clear();
	}
	
	
	


	public  SmartList<SupplyOrder> getSupplyOrderList(){
		if(this.mSupplyOrderList == null){
			this.mSupplyOrderList = new SmartList<SupplyOrder>();
			this.mSupplyOrderList.setListInternalName (SUPPLY_ORDER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mSupplyOrderList;	
	}
	public  void setSupplyOrderList(SmartList<SupplyOrder> supplyOrderList){
		for( SupplyOrder supplyOrder:supplyOrderList){
			supplyOrder.setBuyer(this);
		}

		this.mSupplyOrderList = supplyOrderList;
		this.mSupplyOrderList.setListInternalName (SUPPLY_ORDER_LIST );
		
	}
	
	public  void addSupplyOrder(SupplyOrder supplyOrder){
		supplyOrder.setBuyer(this);
		getSupplyOrderList().add(supplyOrder);
	}
	public  void addSupplyOrderList(SmartList<SupplyOrder> supplyOrderList){
		for( SupplyOrder supplyOrder:supplyOrderList){
			supplyOrder.setBuyer(this);
		}
		getSupplyOrderList().addAll(supplyOrderList);
	}
	public  void mergeSupplyOrderList(SmartList<SupplyOrder> supplyOrderList){
		if(supplyOrderList==null){
			return;
		}
		if(supplyOrderList.isEmpty()){
			return;
		}
		addSupplyOrderList( supplyOrderList );
		
	}
	public  SupplyOrder removeSupplyOrder(SupplyOrder supplyOrderIndex){
		
		int index = getSupplyOrderList().indexOf(supplyOrderIndex);
        if(index < 0){
        	String message = "SupplyOrder("+supplyOrderIndex.getId()+") with version='"+supplyOrderIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        SupplyOrder supplyOrder = getSupplyOrderList().get(index);        
        // supplyOrder.clearBuyer(); //disconnect with Buyer
        supplyOrder.clearFromAll(); //disconnect with Buyer
		
		boolean result = getSupplyOrderList().planToRemove(supplyOrder);
        if(!result){
        	String message = "SupplyOrder("+supplyOrderIndex.getId()+") with version='"+supplyOrderIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return supplyOrder;
        
	
	}
	//断舍离
	public  void breakWithSupplyOrder(SupplyOrder supplyOrder){
		
		if(supplyOrder == null){
			return;
		}
		supplyOrder.setBuyer(null);
		//getSupplyOrderList().remove();
	
	}
	
	public  boolean hasSupplyOrder(SupplyOrder supplyOrder){
	
		return getSupplyOrderList().contains(supplyOrder);
  
	}
	
	public void copySupplyOrderFrom(SupplyOrder supplyOrder) {

		SupplyOrder supplyOrderInList = findTheSupplyOrder(supplyOrder);
		SupplyOrder newSupplyOrder = new SupplyOrder();
		supplyOrderInList.copyTo(newSupplyOrder);
		newSupplyOrder.setVersion(0);//will trigger copy
		getSupplyOrderList().add(newSupplyOrder);
		addItemToFlexiableObject(COPIED_CHILD, newSupplyOrder);
	}
	
	public  SupplyOrder findTheSupplyOrder(SupplyOrder supplyOrder){
		
		int index =  getSupplyOrderList().indexOf(supplyOrder);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "SupplyOrder("+supplyOrder.getId()+") with version='"+supplyOrder.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getSupplyOrderList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSupplyOrderList(){
		getSupplyOrderList().clear();
	}
	
	
	


	public  SmartList<RetailStoreOrder> getRetailStoreOrderList(){
		if(this.mRetailStoreOrderList == null){
			this.mRetailStoreOrderList = new SmartList<RetailStoreOrder>();
			this.mRetailStoreOrderList.setListInternalName (RETAIL_STORE_ORDER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mRetailStoreOrderList;	
	}
	public  void setRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList){
		for( RetailStoreOrder retailStoreOrder:retailStoreOrderList){
			retailStoreOrder.setSeller(this);
		}

		this.mRetailStoreOrderList = retailStoreOrderList;
		this.mRetailStoreOrderList.setListInternalName (RETAIL_STORE_ORDER_LIST );
		
	}
	
	public  void addRetailStoreOrder(RetailStoreOrder retailStoreOrder){
		retailStoreOrder.setSeller(this);
		getRetailStoreOrderList().add(retailStoreOrder);
	}
	public  void addRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList){
		for( RetailStoreOrder retailStoreOrder:retailStoreOrderList){
			retailStoreOrder.setSeller(this);
		}
		getRetailStoreOrderList().addAll(retailStoreOrderList);
	}
	public  void mergeRetailStoreOrderList(SmartList<RetailStoreOrder> retailStoreOrderList){
		if(retailStoreOrderList==null){
			return;
		}
		if(retailStoreOrderList.isEmpty()){
			return;
		}
		addRetailStoreOrderList( retailStoreOrderList );
		
	}
	public  RetailStoreOrder removeRetailStoreOrder(RetailStoreOrder retailStoreOrderIndex){
		
		int index = getRetailStoreOrderList().indexOf(retailStoreOrderIndex);
        if(index < 0){
        	String message = "RetailStoreOrder("+retailStoreOrderIndex.getId()+") with version='"+retailStoreOrderIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RetailStoreOrder retailStoreOrder = getRetailStoreOrderList().get(index);        
        // retailStoreOrder.clearSeller(); //disconnect with Seller
        retailStoreOrder.clearFromAll(); //disconnect with Seller
		
		boolean result = getRetailStoreOrderList().planToRemove(retailStoreOrder);
        if(!result){
        	String message = "RetailStoreOrder("+retailStoreOrderIndex.getId()+") with version='"+retailStoreOrderIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return retailStoreOrder;
        
	
	}
	//断舍离
	public  void breakWithRetailStoreOrder(RetailStoreOrder retailStoreOrder){
		
		if(retailStoreOrder == null){
			return;
		}
		retailStoreOrder.setSeller(null);
		//getRetailStoreOrderList().remove();
	
	}
	
	public  boolean hasRetailStoreOrder(RetailStoreOrder retailStoreOrder){
	
		return getRetailStoreOrderList().contains(retailStoreOrder);
  
	}
	
	public void copyRetailStoreOrderFrom(RetailStoreOrder retailStoreOrder) {

		RetailStoreOrder retailStoreOrderInList = findTheRetailStoreOrder(retailStoreOrder);
		RetailStoreOrder newRetailStoreOrder = new RetailStoreOrder();
		retailStoreOrderInList.copyTo(newRetailStoreOrder);
		newRetailStoreOrder.setVersion(0);//will trigger copy
		getRetailStoreOrderList().add(newRetailStoreOrder);
		addItemToFlexiableObject(COPIED_CHILD, newRetailStoreOrder);
	}
	
	public  RetailStoreOrder findTheRetailStoreOrder(RetailStoreOrder retailStoreOrder){
		
		int index =  getRetailStoreOrderList().indexOf(retailStoreOrder);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "RetailStoreOrder("+retailStoreOrder.getId()+") with version='"+retailStoreOrder.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRetailStoreOrderList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreOrderList(){
		getRetailStoreOrderList().clear();
	}
	
	
	


	public  SmartList<Warehouse> getWarehouseList(){
		if(this.mWarehouseList == null){
			this.mWarehouseList = new SmartList<Warehouse>();
			this.mWarehouseList.setListInternalName (WAREHOUSE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mWarehouseList;	
	}
	public  void setWarehouseList(SmartList<Warehouse> warehouseList){
		for( Warehouse warehouse:warehouseList){
			warehouse.setOwner(this);
		}

		this.mWarehouseList = warehouseList;
		this.mWarehouseList.setListInternalName (WAREHOUSE_LIST );
		
	}
	
	public  void addWarehouse(Warehouse warehouse){
		warehouse.setOwner(this);
		getWarehouseList().add(warehouse);
	}
	public  void addWarehouseList(SmartList<Warehouse> warehouseList){
		for( Warehouse warehouse:warehouseList){
			warehouse.setOwner(this);
		}
		getWarehouseList().addAll(warehouseList);
	}
	public  void mergeWarehouseList(SmartList<Warehouse> warehouseList){
		if(warehouseList==null){
			return;
		}
		if(warehouseList.isEmpty()){
			return;
		}
		addWarehouseList( warehouseList );
		
	}
	public  Warehouse removeWarehouse(Warehouse warehouseIndex){
		
		int index = getWarehouseList().indexOf(warehouseIndex);
        if(index < 0){
        	String message = "Warehouse("+warehouseIndex.getId()+") with version='"+warehouseIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Warehouse warehouse = getWarehouseList().get(index);        
        // warehouse.clearOwner(); //disconnect with Owner
        warehouse.clearFromAll(); //disconnect with Owner
		
		boolean result = getWarehouseList().planToRemove(warehouse);
        if(!result){
        	String message = "Warehouse("+warehouseIndex.getId()+") with version='"+warehouseIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return warehouse;
        
	
	}
	//断舍离
	public  void breakWithWarehouse(Warehouse warehouse){
		
		if(warehouse == null){
			return;
		}
		warehouse.setOwner(null);
		//getWarehouseList().remove();
	
	}
	
	public  boolean hasWarehouse(Warehouse warehouse){
	
		return getWarehouseList().contains(warehouse);
  
	}
	
	public void copyWarehouseFrom(Warehouse warehouse) {

		Warehouse warehouseInList = findTheWarehouse(warehouse);
		Warehouse newWarehouse = new Warehouse();
		warehouseInList.copyTo(newWarehouse);
		newWarehouse.setVersion(0);//will trigger copy
		getWarehouseList().add(newWarehouse);
		addItemToFlexiableObject(COPIED_CHILD, newWarehouse);
	}
	
	public  Warehouse findTheWarehouse(Warehouse warehouse){
		
		int index =  getWarehouseList().indexOf(warehouse);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Warehouse("+warehouse.getId()+") with version='"+warehouse.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getWarehouseList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpWarehouseList(){
		getWarehouseList().clear();
	}
	
	
	


	public  SmartList<TransportFleet> getTransportFleetList(){
		if(this.mTransportFleetList == null){
			this.mTransportFleetList = new SmartList<TransportFleet>();
			this.mTransportFleetList.setListInternalName (TRANSPORT_FLEET_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTransportFleetList;	
	}
	public  void setTransportFleetList(SmartList<TransportFleet> transportFleetList){
		for( TransportFleet transportFleet:transportFleetList){
			transportFleet.setOwner(this);
		}

		this.mTransportFleetList = transportFleetList;
		this.mTransportFleetList.setListInternalName (TRANSPORT_FLEET_LIST );
		
	}
	
	public  void addTransportFleet(TransportFleet transportFleet){
		transportFleet.setOwner(this);
		getTransportFleetList().add(transportFleet);
	}
	public  void addTransportFleetList(SmartList<TransportFleet> transportFleetList){
		for( TransportFleet transportFleet:transportFleetList){
			transportFleet.setOwner(this);
		}
		getTransportFleetList().addAll(transportFleetList);
	}
	public  void mergeTransportFleetList(SmartList<TransportFleet> transportFleetList){
		if(transportFleetList==null){
			return;
		}
		if(transportFleetList.isEmpty()){
			return;
		}
		addTransportFleetList( transportFleetList );
		
	}
	public  TransportFleet removeTransportFleet(TransportFleet transportFleetIndex){
		
		int index = getTransportFleetList().indexOf(transportFleetIndex);
        if(index < 0){
        	String message = "TransportFleet("+transportFleetIndex.getId()+") with version='"+transportFleetIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TransportFleet transportFleet = getTransportFleetList().get(index);        
        // transportFleet.clearOwner(); //disconnect with Owner
        transportFleet.clearFromAll(); //disconnect with Owner
		
		boolean result = getTransportFleetList().planToRemove(transportFleet);
        if(!result){
        	String message = "TransportFleet("+transportFleetIndex.getId()+") with version='"+transportFleetIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return transportFleet;
        
	
	}
	//断舍离
	public  void breakWithTransportFleet(TransportFleet transportFleet){
		
		if(transportFleet == null){
			return;
		}
		transportFleet.setOwner(null);
		//getTransportFleetList().remove();
	
	}
	
	public  boolean hasTransportFleet(TransportFleet transportFleet){
	
		return getTransportFleetList().contains(transportFleet);
  
	}
	
	public void copyTransportFleetFrom(TransportFleet transportFleet) {

		TransportFleet transportFleetInList = findTheTransportFleet(transportFleet);
		TransportFleet newTransportFleet = new TransportFleet();
		transportFleetInList.copyTo(newTransportFleet);
		newTransportFleet.setVersion(0);//will trigger copy
		getTransportFleetList().add(newTransportFleet);
		addItemToFlexiableObject(COPIED_CHILD, newTransportFleet);
	}
	
	public  TransportFleet findTheTransportFleet(TransportFleet transportFleet){
		
		int index =  getTransportFleetList().indexOf(transportFleet);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TransportFleet("+transportFleet.getId()+") with version='"+transportFleet.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTransportFleetList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTransportFleetList(){
		getTransportFleetList().clear();
	}
	
	
	


	public  SmartList<AccountSet> getAccountSetList(){
		if(this.mAccountSetList == null){
			this.mAccountSetList = new SmartList<AccountSet>();
			this.mAccountSetList.setListInternalName (ACCOUNT_SET_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mAccountSetList;	
	}
	public  void setAccountSetList(SmartList<AccountSet> accountSetList){
		for( AccountSet accountSet:accountSetList){
			accountSet.setCountryCenter(this);
		}

		this.mAccountSetList = accountSetList;
		this.mAccountSetList.setListInternalName (ACCOUNT_SET_LIST );
		
	}
	
	public  void addAccountSet(AccountSet accountSet){
		accountSet.setCountryCenter(this);
		getAccountSetList().add(accountSet);
	}
	public  void addAccountSetList(SmartList<AccountSet> accountSetList){
		for( AccountSet accountSet:accountSetList){
			accountSet.setCountryCenter(this);
		}
		getAccountSetList().addAll(accountSetList);
	}
	public  void mergeAccountSetList(SmartList<AccountSet> accountSetList){
		if(accountSetList==null){
			return;
		}
		if(accountSetList.isEmpty()){
			return;
		}
		addAccountSetList( accountSetList );
		
	}
	public  AccountSet removeAccountSet(AccountSet accountSetIndex){
		
		int index = getAccountSetList().indexOf(accountSetIndex);
        if(index < 0){
        	String message = "AccountSet("+accountSetIndex.getId()+") with version='"+accountSetIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        AccountSet accountSet = getAccountSetList().get(index);        
        // accountSet.clearCountryCenter(); //disconnect with CountryCenter
        accountSet.clearFromAll(); //disconnect with CountryCenter
		
		boolean result = getAccountSetList().planToRemove(accountSet);
        if(!result){
        	String message = "AccountSet("+accountSetIndex.getId()+") with version='"+accountSetIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return accountSet;
        
	
	}
	//断舍离
	public  void breakWithAccountSet(AccountSet accountSet){
		
		if(accountSet == null){
			return;
		}
		accountSet.setCountryCenter(null);
		//getAccountSetList().remove();
	
	}
	
	public  boolean hasAccountSet(AccountSet accountSet){
	
		return getAccountSetList().contains(accountSet);
  
	}
	
	public void copyAccountSetFrom(AccountSet accountSet) {

		AccountSet accountSetInList = findTheAccountSet(accountSet);
		AccountSet newAccountSet = new AccountSet();
		accountSetInList.copyTo(newAccountSet);
		newAccountSet.setVersion(0);//will trigger copy
		getAccountSetList().add(newAccountSet);
		addItemToFlexiableObject(COPIED_CHILD, newAccountSet);
	}
	
	public  AccountSet findTheAccountSet(AccountSet accountSet){
		
		int index =  getAccountSetList().indexOf(accountSet);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "AccountSet("+accountSet.getId()+") with version='"+accountSet.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getAccountSetList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpAccountSetList(){
		getAccountSetList().clear();
	}
	
	
	


	public  SmartList<LevelOneDepartment> getLevelOneDepartmentList(){
		if(this.mLevelOneDepartmentList == null){
			this.mLevelOneDepartmentList = new SmartList<LevelOneDepartment>();
			this.mLevelOneDepartmentList.setListInternalName (LEVEL_ONE_DEPARTMENT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mLevelOneDepartmentList;	
	}
	public  void setLevelOneDepartmentList(SmartList<LevelOneDepartment> levelOneDepartmentList){
		for( LevelOneDepartment levelOneDepartment:levelOneDepartmentList){
			levelOneDepartment.setBelongsTo(this);
		}

		this.mLevelOneDepartmentList = levelOneDepartmentList;
		this.mLevelOneDepartmentList.setListInternalName (LEVEL_ONE_DEPARTMENT_LIST );
		
	}
	
	public  void addLevelOneDepartment(LevelOneDepartment levelOneDepartment){
		levelOneDepartment.setBelongsTo(this);
		getLevelOneDepartmentList().add(levelOneDepartment);
	}
	public  void addLevelOneDepartmentList(SmartList<LevelOneDepartment> levelOneDepartmentList){
		for( LevelOneDepartment levelOneDepartment:levelOneDepartmentList){
			levelOneDepartment.setBelongsTo(this);
		}
		getLevelOneDepartmentList().addAll(levelOneDepartmentList);
	}
	public  void mergeLevelOneDepartmentList(SmartList<LevelOneDepartment> levelOneDepartmentList){
		if(levelOneDepartmentList==null){
			return;
		}
		if(levelOneDepartmentList.isEmpty()){
			return;
		}
		addLevelOneDepartmentList( levelOneDepartmentList );
		
	}
	public  LevelOneDepartment removeLevelOneDepartment(LevelOneDepartment levelOneDepartmentIndex){
		
		int index = getLevelOneDepartmentList().indexOf(levelOneDepartmentIndex);
        if(index < 0){
        	String message = "LevelOneDepartment("+levelOneDepartmentIndex.getId()+") with version='"+levelOneDepartmentIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        LevelOneDepartment levelOneDepartment = getLevelOneDepartmentList().get(index);        
        // levelOneDepartment.clearBelongsTo(); //disconnect with BelongsTo
        levelOneDepartment.clearFromAll(); //disconnect with BelongsTo
		
		boolean result = getLevelOneDepartmentList().planToRemove(levelOneDepartment);
        if(!result){
        	String message = "LevelOneDepartment("+levelOneDepartmentIndex.getId()+") with version='"+levelOneDepartmentIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return levelOneDepartment;
        
	
	}
	//断舍离
	public  void breakWithLevelOneDepartment(LevelOneDepartment levelOneDepartment){
		
		if(levelOneDepartment == null){
			return;
		}
		levelOneDepartment.setBelongsTo(null);
		//getLevelOneDepartmentList().remove();
	
	}
	
	public  boolean hasLevelOneDepartment(LevelOneDepartment levelOneDepartment){
	
		return getLevelOneDepartmentList().contains(levelOneDepartment);
  
	}
	
	public void copyLevelOneDepartmentFrom(LevelOneDepartment levelOneDepartment) {

		LevelOneDepartment levelOneDepartmentInList = findTheLevelOneDepartment(levelOneDepartment);
		LevelOneDepartment newLevelOneDepartment = new LevelOneDepartment();
		levelOneDepartmentInList.copyTo(newLevelOneDepartment);
		newLevelOneDepartment.setVersion(0);//will trigger copy
		getLevelOneDepartmentList().add(newLevelOneDepartment);
		addItemToFlexiableObject(COPIED_CHILD, newLevelOneDepartment);
	}
	
	public  LevelOneDepartment findTheLevelOneDepartment(LevelOneDepartment levelOneDepartment){
		
		int index =  getLevelOneDepartmentList().indexOf(levelOneDepartment);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "LevelOneDepartment("+levelOneDepartment.getId()+") with version='"+levelOneDepartment.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getLevelOneDepartmentList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLevelOneDepartmentList(){
		getLevelOneDepartmentList().clear();
	}
	
	
	


	public  SmartList<SkillType> getSkillTypeList(){
		if(this.mSkillTypeList == null){
			this.mSkillTypeList = new SmartList<SkillType>();
			this.mSkillTypeList.setListInternalName (SKILL_TYPE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mSkillTypeList;	
	}
	public  void setSkillTypeList(SmartList<SkillType> skillTypeList){
		for( SkillType skillType:skillTypeList){
			skillType.setCompany(this);
		}

		this.mSkillTypeList = skillTypeList;
		this.mSkillTypeList.setListInternalName (SKILL_TYPE_LIST );
		
	}
	
	public  void addSkillType(SkillType skillType){
		skillType.setCompany(this);
		getSkillTypeList().add(skillType);
	}
	public  void addSkillTypeList(SmartList<SkillType> skillTypeList){
		for( SkillType skillType:skillTypeList){
			skillType.setCompany(this);
		}
		getSkillTypeList().addAll(skillTypeList);
	}
	public  void mergeSkillTypeList(SmartList<SkillType> skillTypeList){
		if(skillTypeList==null){
			return;
		}
		if(skillTypeList.isEmpty()){
			return;
		}
		addSkillTypeList( skillTypeList );
		
	}
	public  SkillType removeSkillType(SkillType skillTypeIndex){
		
		int index = getSkillTypeList().indexOf(skillTypeIndex);
        if(index < 0){
        	String message = "SkillType("+skillTypeIndex.getId()+") with version='"+skillTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        SkillType skillType = getSkillTypeList().get(index);        
        // skillType.clearCompany(); //disconnect with Company
        skillType.clearFromAll(); //disconnect with Company
		
		boolean result = getSkillTypeList().planToRemove(skillType);
        if(!result){
        	String message = "SkillType("+skillTypeIndex.getId()+") with version='"+skillTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return skillType;
        
	
	}
	//断舍离
	public  void breakWithSkillType(SkillType skillType){
		
		if(skillType == null){
			return;
		}
		skillType.setCompany(null);
		//getSkillTypeList().remove();
	
	}
	
	public  boolean hasSkillType(SkillType skillType){
	
		return getSkillTypeList().contains(skillType);
  
	}
	
	public void copySkillTypeFrom(SkillType skillType) {

		SkillType skillTypeInList = findTheSkillType(skillType);
		SkillType newSkillType = new SkillType();
		skillTypeInList.copyTo(newSkillType);
		newSkillType.setVersion(0);//will trigger copy
		getSkillTypeList().add(newSkillType);
		addItemToFlexiableObject(COPIED_CHILD, newSkillType);
	}
	
	public  SkillType findTheSkillType(SkillType skillType){
		
		int index =  getSkillTypeList().indexOf(skillType);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "SkillType("+skillType.getId()+") with version='"+skillType.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getSkillTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSkillTypeList(){
		getSkillTypeList().clear();
	}
	
	
	


	public  SmartList<ResponsibilityType> getResponsibilityTypeList(){
		if(this.mResponsibilityTypeList == null){
			this.mResponsibilityTypeList = new SmartList<ResponsibilityType>();
			this.mResponsibilityTypeList.setListInternalName (RESPONSIBILITY_TYPE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mResponsibilityTypeList;	
	}
	public  void setResponsibilityTypeList(SmartList<ResponsibilityType> responsibilityTypeList){
		for( ResponsibilityType responsibilityType:responsibilityTypeList){
			responsibilityType.setCompany(this);
		}

		this.mResponsibilityTypeList = responsibilityTypeList;
		this.mResponsibilityTypeList.setListInternalName (RESPONSIBILITY_TYPE_LIST );
		
	}
	
	public  void addResponsibilityType(ResponsibilityType responsibilityType){
		responsibilityType.setCompany(this);
		getResponsibilityTypeList().add(responsibilityType);
	}
	public  void addResponsibilityTypeList(SmartList<ResponsibilityType> responsibilityTypeList){
		for( ResponsibilityType responsibilityType:responsibilityTypeList){
			responsibilityType.setCompany(this);
		}
		getResponsibilityTypeList().addAll(responsibilityTypeList);
	}
	public  void mergeResponsibilityTypeList(SmartList<ResponsibilityType> responsibilityTypeList){
		if(responsibilityTypeList==null){
			return;
		}
		if(responsibilityTypeList.isEmpty()){
			return;
		}
		addResponsibilityTypeList( responsibilityTypeList );
		
	}
	public  ResponsibilityType removeResponsibilityType(ResponsibilityType responsibilityTypeIndex){
		
		int index = getResponsibilityTypeList().indexOf(responsibilityTypeIndex);
        if(index < 0){
        	String message = "ResponsibilityType("+responsibilityTypeIndex.getId()+") with version='"+responsibilityTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ResponsibilityType responsibilityType = getResponsibilityTypeList().get(index);        
        // responsibilityType.clearCompany(); //disconnect with Company
        responsibilityType.clearFromAll(); //disconnect with Company
		
		boolean result = getResponsibilityTypeList().planToRemove(responsibilityType);
        if(!result){
        	String message = "ResponsibilityType("+responsibilityTypeIndex.getId()+") with version='"+responsibilityTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return responsibilityType;
        
	
	}
	//断舍离
	public  void breakWithResponsibilityType(ResponsibilityType responsibilityType){
		
		if(responsibilityType == null){
			return;
		}
		responsibilityType.setCompany(null);
		//getResponsibilityTypeList().remove();
	
	}
	
	public  boolean hasResponsibilityType(ResponsibilityType responsibilityType){
	
		return getResponsibilityTypeList().contains(responsibilityType);
  
	}
	
	public void copyResponsibilityTypeFrom(ResponsibilityType responsibilityType) {

		ResponsibilityType responsibilityTypeInList = findTheResponsibilityType(responsibilityType);
		ResponsibilityType newResponsibilityType = new ResponsibilityType();
		responsibilityTypeInList.copyTo(newResponsibilityType);
		newResponsibilityType.setVersion(0);//will trigger copy
		getResponsibilityTypeList().add(newResponsibilityType);
		addItemToFlexiableObject(COPIED_CHILD, newResponsibilityType);
	}
	
	public  ResponsibilityType findTheResponsibilityType(ResponsibilityType responsibilityType){
		
		int index =  getResponsibilityTypeList().indexOf(responsibilityType);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ResponsibilityType("+responsibilityType.getId()+") with version='"+responsibilityType.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getResponsibilityTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpResponsibilityTypeList(){
		getResponsibilityTypeList().clear();
	}
	
	
	


	public  SmartList<TerminationReason> getTerminationReasonList(){
		if(this.mTerminationReasonList == null){
			this.mTerminationReasonList = new SmartList<TerminationReason>();
			this.mTerminationReasonList.setListInternalName (TERMINATION_REASON_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTerminationReasonList;	
	}
	public  void setTerminationReasonList(SmartList<TerminationReason> terminationReasonList){
		for( TerminationReason terminationReason:terminationReasonList){
			terminationReason.setCompany(this);
		}

		this.mTerminationReasonList = terminationReasonList;
		this.mTerminationReasonList.setListInternalName (TERMINATION_REASON_LIST );
		
	}
	
	public  void addTerminationReason(TerminationReason terminationReason){
		terminationReason.setCompany(this);
		getTerminationReasonList().add(terminationReason);
	}
	public  void addTerminationReasonList(SmartList<TerminationReason> terminationReasonList){
		for( TerminationReason terminationReason:terminationReasonList){
			terminationReason.setCompany(this);
		}
		getTerminationReasonList().addAll(terminationReasonList);
	}
	public  void mergeTerminationReasonList(SmartList<TerminationReason> terminationReasonList){
		if(terminationReasonList==null){
			return;
		}
		if(terminationReasonList.isEmpty()){
			return;
		}
		addTerminationReasonList( terminationReasonList );
		
	}
	public  TerminationReason removeTerminationReason(TerminationReason terminationReasonIndex){
		
		int index = getTerminationReasonList().indexOf(terminationReasonIndex);
        if(index < 0){
        	String message = "TerminationReason("+terminationReasonIndex.getId()+") with version='"+terminationReasonIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TerminationReason terminationReason = getTerminationReasonList().get(index);        
        // terminationReason.clearCompany(); //disconnect with Company
        terminationReason.clearFromAll(); //disconnect with Company
		
		boolean result = getTerminationReasonList().planToRemove(terminationReason);
        if(!result){
        	String message = "TerminationReason("+terminationReasonIndex.getId()+") with version='"+terminationReasonIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return terminationReason;
        
	
	}
	//断舍离
	public  void breakWithTerminationReason(TerminationReason terminationReason){
		
		if(terminationReason == null){
			return;
		}
		terminationReason.setCompany(null);
		//getTerminationReasonList().remove();
	
	}
	
	public  boolean hasTerminationReason(TerminationReason terminationReason){
	
		return getTerminationReasonList().contains(terminationReason);
  
	}
	
	public void copyTerminationReasonFrom(TerminationReason terminationReason) {

		TerminationReason terminationReasonInList = findTheTerminationReason(terminationReason);
		TerminationReason newTerminationReason = new TerminationReason();
		terminationReasonInList.copyTo(newTerminationReason);
		newTerminationReason.setVersion(0);//will trigger copy
		getTerminationReasonList().add(newTerminationReason);
		addItemToFlexiableObject(COPIED_CHILD, newTerminationReason);
	}
	
	public  TerminationReason findTheTerminationReason(TerminationReason terminationReason){
		
		int index =  getTerminationReasonList().indexOf(terminationReason);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TerminationReason("+terminationReason.getId()+") with version='"+terminationReason.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTerminationReasonList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTerminationReasonList(){
		getTerminationReasonList().clear();
	}
	
	
	


	public  SmartList<TerminationType> getTerminationTypeList(){
		if(this.mTerminationTypeList == null){
			this.mTerminationTypeList = new SmartList<TerminationType>();
			this.mTerminationTypeList.setListInternalName (TERMINATION_TYPE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTerminationTypeList;	
	}
	public  void setTerminationTypeList(SmartList<TerminationType> terminationTypeList){
		for( TerminationType terminationType:terminationTypeList){
			terminationType.setCompany(this);
		}

		this.mTerminationTypeList = terminationTypeList;
		this.mTerminationTypeList.setListInternalName (TERMINATION_TYPE_LIST );
		
	}
	
	public  void addTerminationType(TerminationType terminationType){
		terminationType.setCompany(this);
		getTerminationTypeList().add(terminationType);
	}
	public  void addTerminationTypeList(SmartList<TerminationType> terminationTypeList){
		for( TerminationType terminationType:terminationTypeList){
			terminationType.setCompany(this);
		}
		getTerminationTypeList().addAll(terminationTypeList);
	}
	public  void mergeTerminationTypeList(SmartList<TerminationType> terminationTypeList){
		if(terminationTypeList==null){
			return;
		}
		if(terminationTypeList.isEmpty()){
			return;
		}
		addTerminationTypeList( terminationTypeList );
		
	}
	public  TerminationType removeTerminationType(TerminationType terminationTypeIndex){
		
		int index = getTerminationTypeList().indexOf(terminationTypeIndex);
        if(index < 0){
        	String message = "TerminationType("+terminationTypeIndex.getId()+") with version='"+terminationTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TerminationType terminationType = getTerminationTypeList().get(index);        
        // terminationType.clearCompany(); //disconnect with Company
        terminationType.clearFromAll(); //disconnect with Company
		
		boolean result = getTerminationTypeList().planToRemove(terminationType);
        if(!result){
        	String message = "TerminationType("+terminationTypeIndex.getId()+") with version='"+terminationTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return terminationType;
        
	
	}
	//断舍离
	public  void breakWithTerminationType(TerminationType terminationType){
		
		if(terminationType == null){
			return;
		}
		terminationType.setCompany(null);
		//getTerminationTypeList().remove();
	
	}
	
	public  boolean hasTerminationType(TerminationType terminationType){
	
		return getTerminationTypeList().contains(terminationType);
  
	}
	
	public void copyTerminationTypeFrom(TerminationType terminationType) {

		TerminationType terminationTypeInList = findTheTerminationType(terminationType);
		TerminationType newTerminationType = new TerminationType();
		terminationTypeInList.copyTo(newTerminationType);
		newTerminationType.setVersion(0);//will trigger copy
		getTerminationTypeList().add(newTerminationType);
		addItemToFlexiableObject(COPIED_CHILD, newTerminationType);
	}
	
	public  TerminationType findTheTerminationType(TerminationType terminationType){
		
		int index =  getTerminationTypeList().indexOf(terminationType);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TerminationType("+terminationType.getId()+") with version='"+terminationType.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTerminationTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTerminationTypeList(){
		getTerminationTypeList().clear();
	}
	
	
	


	public  SmartList<OccupationType> getOccupationTypeList(){
		if(this.mOccupationTypeList == null){
			this.mOccupationTypeList = new SmartList<OccupationType>();
			this.mOccupationTypeList.setListInternalName (OCCUPATION_TYPE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mOccupationTypeList;	
	}
	public  void setOccupationTypeList(SmartList<OccupationType> occupationTypeList){
		for( OccupationType occupationType:occupationTypeList){
			occupationType.setCompany(this);
		}

		this.mOccupationTypeList = occupationTypeList;
		this.mOccupationTypeList.setListInternalName (OCCUPATION_TYPE_LIST );
		
	}
	
	public  void addOccupationType(OccupationType occupationType){
		occupationType.setCompany(this);
		getOccupationTypeList().add(occupationType);
	}
	public  void addOccupationTypeList(SmartList<OccupationType> occupationTypeList){
		for( OccupationType occupationType:occupationTypeList){
			occupationType.setCompany(this);
		}
		getOccupationTypeList().addAll(occupationTypeList);
	}
	public  void mergeOccupationTypeList(SmartList<OccupationType> occupationTypeList){
		if(occupationTypeList==null){
			return;
		}
		if(occupationTypeList.isEmpty()){
			return;
		}
		addOccupationTypeList( occupationTypeList );
		
	}
	public  OccupationType removeOccupationType(OccupationType occupationTypeIndex){
		
		int index = getOccupationTypeList().indexOf(occupationTypeIndex);
        if(index < 0){
        	String message = "OccupationType("+occupationTypeIndex.getId()+") with version='"+occupationTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        OccupationType occupationType = getOccupationTypeList().get(index);        
        // occupationType.clearCompany(); //disconnect with Company
        occupationType.clearFromAll(); //disconnect with Company
		
		boolean result = getOccupationTypeList().planToRemove(occupationType);
        if(!result){
        	String message = "OccupationType("+occupationTypeIndex.getId()+") with version='"+occupationTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return occupationType;
        
	
	}
	//断舍离
	public  void breakWithOccupationType(OccupationType occupationType){
		
		if(occupationType == null){
			return;
		}
		occupationType.setCompany(null);
		//getOccupationTypeList().remove();
	
	}
	
	public  boolean hasOccupationType(OccupationType occupationType){
	
		return getOccupationTypeList().contains(occupationType);
  
	}
	
	public void copyOccupationTypeFrom(OccupationType occupationType) {

		OccupationType occupationTypeInList = findTheOccupationType(occupationType);
		OccupationType newOccupationType = new OccupationType();
		occupationTypeInList.copyTo(newOccupationType);
		newOccupationType.setVersion(0);//will trigger copy
		getOccupationTypeList().add(newOccupationType);
		addItemToFlexiableObject(COPIED_CHILD, newOccupationType);
	}
	
	public  OccupationType findTheOccupationType(OccupationType occupationType){
		
		int index =  getOccupationTypeList().indexOf(occupationType);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "OccupationType("+occupationType.getId()+") with version='"+occupationType.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getOccupationTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpOccupationTypeList(){
		getOccupationTypeList().clear();
	}
	
	
	


	public  SmartList<LeaveType> getLeaveTypeList(){
		if(this.mLeaveTypeList == null){
			this.mLeaveTypeList = new SmartList<LeaveType>();
			this.mLeaveTypeList.setListInternalName (LEAVE_TYPE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mLeaveTypeList;	
	}
	public  void setLeaveTypeList(SmartList<LeaveType> leaveTypeList){
		for( LeaveType leaveType:leaveTypeList){
			leaveType.setCompany(this);
		}

		this.mLeaveTypeList = leaveTypeList;
		this.mLeaveTypeList.setListInternalName (LEAVE_TYPE_LIST );
		
	}
	
	public  void addLeaveType(LeaveType leaveType){
		leaveType.setCompany(this);
		getLeaveTypeList().add(leaveType);
	}
	public  void addLeaveTypeList(SmartList<LeaveType> leaveTypeList){
		for( LeaveType leaveType:leaveTypeList){
			leaveType.setCompany(this);
		}
		getLeaveTypeList().addAll(leaveTypeList);
	}
	public  void mergeLeaveTypeList(SmartList<LeaveType> leaveTypeList){
		if(leaveTypeList==null){
			return;
		}
		if(leaveTypeList.isEmpty()){
			return;
		}
		addLeaveTypeList( leaveTypeList );
		
	}
	public  LeaveType removeLeaveType(LeaveType leaveTypeIndex){
		
		int index = getLeaveTypeList().indexOf(leaveTypeIndex);
        if(index < 0){
        	String message = "LeaveType("+leaveTypeIndex.getId()+") with version='"+leaveTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        LeaveType leaveType = getLeaveTypeList().get(index);        
        // leaveType.clearCompany(); //disconnect with Company
        leaveType.clearFromAll(); //disconnect with Company
		
		boolean result = getLeaveTypeList().planToRemove(leaveType);
        if(!result){
        	String message = "LeaveType("+leaveTypeIndex.getId()+") with version='"+leaveTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return leaveType;
        
	
	}
	//断舍离
	public  void breakWithLeaveType(LeaveType leaveType){
		
		if(leaveType == null){
			return;
		}
		leaveType.setCompany(null);
		//getLeaveTypeList().remove();
	
	}
	
	public  boolean hasLeaveType(LeaveType leaveType){
	
		return getLeaveTypeList().contains(leaveType);
  
	}
	
	public void copyLeaveTypeFrom(LeaveType leaveType) {

		LeaveType leaveTypeInList = findTheLeaveType(leaveType);
		LeaveType newLeaveType = new LeaveType();
		leaveTypeInList.copyTo(newLeaveType);
		newLeaveType.setVersion(0);//will trigger copy
		getLeaveTypeList().add(newLeaveType);
		addItemToFlexiableObject(COPIED_CHILD, newLeaveType);
	}
	
	public  LeaveType findTheLeaveType(LeaveType leaveType){
		
		int index =  getLeaveTypeList().indexOf(leaveType);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "LeaveType("+leaveType.getId()+") with version='"+leaveType.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getLeaveTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLeaveTypeList(){
		getLeaveTypeList().clear();
	}
	
	
	


	public  SmartList<SalaryGrade> getSalaryGradeList(){
		if(this.mSalaryGradeList == null){
			this.mSalaryGradeList = new SmartList<SalaryGrade>();
			this.mSalaryGradeList.setListInternalName (SALARY_GRADE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mSalaryGradeList;	
	}
	public  void setSalaryGradeList(SmartList<SalaryGrade> salaryGradeList){
		for( SalaryGrade salaryGrade:salaryGradeList){
			salaryGrade.setCompany(this);
		}

		this.mSalaryGradeList = salaryGradeList;
		this.mSalaryGradeList.setListInternalName (SALARY_GRADE_LIST );
		
	}
	
	public  void addSalaryGrade(SalaryGrade salaryGrade){
		salaryGrade.setCompany(this);
		getSalaryGradeList().add(salaryGrade);
	}
	public  void addSalaryGradeList(SmartList<SalaryGrade> salaryGradeList){
		for( SalaryGrade salaryGrade:salaryGradeList){
			salaryGrade.setCompany(this);
		}
		getSalaryGradeList().addAll(salaryGradeList);
	}
	public  void mergeSalaryGradeList(SmartList<SalaryGrade> salaryGradeList){
		if(salaryGradeList==null){
			return;
		}
		if(salaryGradeList.isEmpty()){
			return;
		}
		addSalaryGradeList( salaryGradeList );
		
	}
	public  SalaryGrade removeSalaryGrade(SalaryGrade salaryGradeIndex){
		
		int index = getSalaryGradeList().indexOf(salaryGradeIndex);
        if(index < 0){
        	String message = "SalaryGrade("+salaryGradeIndex.getId()+") with version='"+salaryGradeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        SalaryGrade salaryGrade = getSalaryGradeList().get(index);        
        // salaryGrade.clearCompany(); //disconnect with Company
        salaryGrade.clearFromAll(); //disconnect with Company
		
		boolean result = getSalaryGradeList().planToRemove(salaryGrade);
        if(!result){
        	String message = "SalaryGrade("+salaryGradeIndex.getId()+") with version='"+salaryGradeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return salaryGrade;
        
	
	}
	//断舍离
	public  void breakWithSalaryGrade(SalaryGrade salaryGrade){
		
		if(salaryGrade == null){
			return;
		}
		salaryGrade.setCompany(null);
		//getSalaryGradeList().remove();
	
	}
	
	public  boolean hasSalaryGrade(SalaryGrade salaryGrade){
	
		return getSalaryGradeList().contains(salaryGrade);
  
	}
	
	public void copySalaryGradeFrom(SalaryGrade salaryGrade) {

		SalaryGrade salaryGradeInList = findTheSalaryGrade(salaryGrade);
		SalaryGrade newSalaryGrade = new SalaryGrade();
		salaryGradeInList.copyTo(newSalaryGrade);
		newSalaryGrade.setVersion(0);//will trigger copy
		getSalaryGradeList().add(newSalaryGrade);
		addItemToFlexiableObject(COPIED_CHILD, newSalaryGrade);
	}
	
	public  SalaryGrade findTheSalaryGrade(SalaryGrade salaryGrade){
		
		int index =  getSalaryGradeList().indexOf(salaryGrade);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "SalaryGrade("+salaryGrade.getId()+") with version='"+salaryGrade.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getSalaryGradeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSalaryGradeList(){
		getSalaryGradeList().clear();
	}
	
	
	


	public  SmartList<InterviewType> getInterviewTypeList(){
		if(this.mInterviewTypeList == null){
			this.mInterviewTypeList = new SmartList<InterviewType>();
			this.mInterviewTypeList.setListInternalName (INTERVIEW_TYPE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mInterviewTypeList;	
	}
	public  void setInterviewTypeList(SmartList<InterviewType> interviewTypeList){
		for( InterviewType interviewType:interviewTypeList){
			interviewType.setCompany(this);
		}

		this.mInterviewTypeList = interviewTypeList;
		this.mInterviewTypeList.setListInternalName (INTERVIEW_TYPE_LIST );
		
	}
	
	public  void addInterviewType(InterviewType interviewType){
		interviewType.setCompany(this);
		getInterviewTypeList().add(interviewType);
	}
	public  void addInterviewTypeList(SmartList<InterviewType> interviewTypeList){
		for( InterviewType interviewType:interviewTypeList){
			interviewType.setCompany(this);
		}
		getInterviewTypeList().addAll(interviewTypeList);
	}
	public  void mergeInterviewTypeList(SmartList<InterviewType> interviewTypeList){
		if(interviewTypeList==null){
			return;
		}
		if(interviewTypeList.isEmpty()){
			return;
		}
		addInterviewTypeList( interviewTypeList );
		
	}
	public  InterviewType removeInterviewType(InterviewType interviewTypeIndex){
		
		int index = getInterviewTypeList().indexOf(interviewTypeIndex);
        if(index < 0){
        	String message = "InterviewType("+interviewTypeIndex.getId()+") with version='"+interviewTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        InterviewType interviewType = getInterviewTypeList().get(index);        
        // interviewType.clearCompany(); //disconnect with Company
        interviewType.clearFromAll(); //disconnect with Company
		
		boolean result = getInterviewTypeList().planToRemove(interviewType);
        if(!result){
        	String message = "InterviewType("+interviewTypeIndex.getId()+") with version='"+interviewTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return interviewType;
        
	
	}
	//断舍离
	public  void breakWithInterviewType(InterviewType interviewType){
		
		if(interviewType == null){
			return;
		}
		interviewType.setCompany(null);
		//getInterviewTypeList().remove();
	
	}
	
	public  boolean hasInterviewType(InterviewType interviewType){
	
		return getInterviewTypeList().contains(interviewType);
  
	}
	
	public void copyInterviewTypeFrom(InterviewType interviewType) {

		InterviewType interviewTypeInList = findTheInterviewType(interviewType);
		InterviewType newInterviewType = new InterviewType();
		interviewTypeInList.copyTo(newInterviewType);
		newInterviewType.setVersion(0);//will trigger copy
		getInterviewTypeList().add(newInterviewType);
		addItemToFlexiableObject(COPIED_CHILD, newInterviewType);
	}
	
	public  InterviewType findTheInterviewType(InterviewType interviewType){
		
		int index =  getInterviewTypeList().indexOf(interviewType);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "InterviewType("+interviewType.getId()+") with version='"+interviewType.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getInterviewTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpInterviewTypeList(){
		getInterviewTypeList().clear();
	}
	
	
	


	public  SmartList<TrainingCourseType> getTrainingCourseTypeList(){
		if(this.mTrainingCourseTypeList == null){
			this.mTrainingCourseTypeList = new SmartList<TrainingCourseType>();
			this.mTrainingCourseTypeList.setListInternalName (TRAINING_COURSE_TYPE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mTrainingCourseTypeList;	
	}
	public  void setTrainingCourseTypeList(SmartList<TrainingCourseType> trainingCourseTypeList){
		for( TrainingCourseType trainingCourseType:trainingCourseTypeList){
			trainingCourseType.setCompany(this);
		}

		this.mTrainingCourseTypeList = trainingCourseTypeList;
		this.mTrainingCourseTypeList.setListInternalName (TRAINING_COURSE_TYPE_LIST );
		
	}
	
	public  void addTrainingCourseType(TrainingCourseType trainingCourseType){
		trainingCourseType.setCompany(this);
		getTrainingCourseTypeList().add(trainingCourseType);
	}
	public  void addTrainingCourseTypeList(SmartList<TrainingCourseType> trainingCourseTypeList){
		for( TrainingCourseType trainingCourseType:trainingCourseTypeList){
			trainingCourseType.setCompany(this);
		}
		getTrainingCourseTypeList().addAll(trainingCourseTypeList);
	}
	public  void mergeTrainingCourseTypeList(SmartList<TrainingCourseType> trainingCourseTypeList){
		if(trainingCourseTypeList==null){
			return;
		}
		if(trainingCourseTypeList.isEmpty()){
			return;
		}
		addTrainingCourseTypeList( trainingCourseTypeList );
		
	}
	public  TrainingCourseType removeTrainingCourseType(TrainingCourseType trainingCourseTypeIndex){
		
		int index = getTrainingCourseTypeList().indexOf(trainingCourseTypeIndex);
        if(index < 0){
        	String message = "TrainingCourseType("+trainingCourseTypeIndex.getId()+") with version='"+trainingCourseTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        TrainingCourseType trainingCourseType = getTrainingCourseTypeList().get(index);        
        // trainingCourseType.clearCompany(); //disconnect with Company
        trainingCourseType.clearFromAll(); //disconnect with Company
		
		boolean result = getTrainingCourseTypeList().planToRemove(trainingCourseType);
        if(!result){
        	String message = "TrainingCourseType("+trainingCourseTypeIndex.getId()+") with version='"+trainingCourseTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return trainingCourseType;
        
	
	}
	//断舍离
	public  void breakWithTrainingCourseType(TrainingCourseType trainingCourseType){
		
		if(trainingCourseType == null){
			return;
		}
		trainingCourseType.setCompany(null);
		//getTrainingCourseTypeList().remove();
	
	}
	
	public  boolean hasTrainingCourseType(TrainingCourseType trainingCourseType){
	
		return getTrainingCourseTypeList().contains(trainingCourseType);
  
	}
	
	public void copyTrainingCourseTypeFrom(TrainingCourseType trainingCourseType) {

		TrainingCourseType trainingCourseTypeInList = findTheTrainingCourseType(trainingCourseType);
		TrainingCourseType newTrainingCourseType = new TrainingCourseType();
		trainingCourseTypeInList.copyTo(newTrainingCourseType);
		newTrainingCourseType.setVersion(0);//will trigger copy
		getTrainingCourseTypeList().add(newTrainingCourseType);
		addItemToFlexiableObject(COPIED_CHILD, newTrainingCourseType);
	}
	
	public  TrainingCourseType findTheTrainingCourseType(TrainingCourseType trainingCourseType){
		
		int index =  getTrainingCourseTypeList().indexOf(trainingCourseType);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "TrainingCourseType("+trainingCourseType.getId()+") with version='"+trainingCourseType.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getTrainingCourseTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpTrainingCourseTypeList(){
		getTrainingCourseTypeList().clear();
	}
	
	
	


	public  SmartList<PublicHoliday> getPublicHolidayList(){
		if(this.mPublicHolidayList == null){
			this.mPublicHolidayList = new SmartList<PublicHoliday>();
			this.mPublicHolidayList.setListInternalName (PUBLIC_HOLIDAY_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mPublicHolidayList;	
	}
	public  void setPublicHolidayList(SmartList<PublicHoliday> publicHolidayList){
		for( PublicHoliday publicHoliday:publicHolidayList){
			publicHoliday.setCompany(this);
		}

		this.mPublicHolidayList = publicHolidayList;
		this.mPublicHolidayList.setListInternalName (PUBLIC_HOLIDAY_LIST );
		
	}
	
	public  void addPublicHoliday(PublicHoliday publicHoliday){
		publicHoliday.setCompany(this);
		getPublicHolidayList().add(publicHoliday);
	}
	public  void addPublicHolidayList(SmartList<PublicHoliday> publicHolidayList){
		for( PublicHoliday publicHoliday:publicHolidayList){
			publicHoliday.setCompany(this);
		}
		getPublicHolidayList().addAll(publicHolidayList);
	}
	public  void mergePublicHolidayList(SmartList<PublicHoliday> publicHolidayList){
		if(publicHolidayList==null){
			return;
		}
		if(publicHolidayList.isEmpty()){
			return;
		}
		addPublicHolidayList( publicHolidayList );
		
	}
	public  PublicHoliday removePublicHoliday(PublicHoliday publicHolidayIndex){
		
		int index = getPublicHolidayList().indexOf(publicHolidayIndex);
        if(index < 0){
        	String message = "PublicHoliday("+publicHolidayIndex.getId()+") with version='"+publicHolidayIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        PublicHoliday publicHoliday = getPublicHolidayList().get(index);        
        // publicHoliday.clearCompany(); //disconnect with Company
        publicHoliday.clearFromAll(); //disconnect with Company
		
		boolean result = getPublicHolidayList().planToRemove(publicHoliday);
        if(!result){
        	String message = "PublicHoliday("+publicHolidayIndex.getId()+") with version='"+publicHolidayIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return publicHoliday;
        
	
	}
	//断舍离
	public  void breakWithPublicHoliday(PublicHoliday publicHoliday){
		
		if(publicHoliday == null){
			return;
		}
		publicHoliday.setCompany(null);
		//getPublicHolidayList().remove();
	
	}
	
	public  boolean hasPublicHoliday(PublicHoliday publicHoliday){
	
		return getPublicHolidayList().contains(publicHoliday);
  
	}
	
	public void copyPublicHolidayFrom(PublicHoliday publicHoliday) {

		PublicHoliday publicHolidayInList = findThePublicHoliday(publicHoliday);
		PublicHoliday newPublicHoliday = new PublicHoliday();
		publicHolidayInList.copyTo(newPublicHoliday);
		newPublicHoliday.setVersion(0);//will trigger copy
		getPublicHolidayList().add(newPublicHoliday);
		addItemToFlexiableObject(COPIED_CHILD, newPublicHoliday);
	}
	
	public  PublicHoliday findThePublicHoliday(PublicHoliday publicHoliday){
		
		int index =  getPublicHolidayList().indexOf(publicHoliday);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "PublicHoliday("+publicHoliday.getId()+") with version='"+publicHoliday.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getPublicHolidayList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpPublicHolidayList(){
		getPublicHolidayList().clear();
	}
	
	
	


	public  SmartList<Employee> getEmployeeList(){
		if(this.mEmployeeList == null){
			this.mEmployeeList = new SmartList<Employee>();
			this.mEmployeeList.setListInternalName (EMPLOYEE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mEmployeeList;	
	}
	public  void setEmployeeList(SmartList<Employee> employeeList){
		for( Employee employee:employeeList){
			employee.setCompany(this);
		}

		this.mEmployeeList = employeeList;
		this.mEmployeeList.setListInternalName (EMPLOYEE_LIST );
		
	}
	
	public  void addEmployee(Employee employee){
		employee.setCompany(this);
		getEmployeeList().add(employee);
	}
	public  void addEmployeeList(SmartList<Employee> employeeList){
		for( Employee employee:employeeList){
			employee.setCompany(this);
		}
		getEmployeeList().addAll(employeeList);
	}
	public  void mergeEmployeeList(SmartList<Employee> employeeList){
		if(employeeList==null){
			return;
		}
		if(employeeList.isEmpty()){
			return;
		}
		addEmployeeList( employeeList );
		
	}
	public  Employee removeEmployee(Employee employeeIndex){
		
		int index = getEmployeeList().indexOf(employeeIndex);
        if(index < 0){
        	String message = "Employee("+employeeIndex.getId()+") with version='"+employeeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Employee employee = getEmployeeList().get(index);        
        // employee.clearCompany(); //disconnect with Company
        employee.clearFromAll(); //disconnect with Company
		
		boolean result = getEmployeeList().planToRemove(employee);
        if(!result){
        	String message = "Employee("+employeeIndex.getId()+") with version='"+employeeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return employee;
        
	
	}
	//断舍离
	public  void breakWithEmployee(Employee employee){
		
		if(employee == null){
			return;
		}
		employee.setCompany(null);
		//getEmployeeList().remove();
	
	}
	
	public  boolean hasEmployee(Employee employee){
	
		return getEmployeeList().contains(employee);
  
	}
	
	public void copyEmployeeFrom(Employee employee) {

		Employee employeeInList = findTheEmployee(employee);
		Employee newEmployee = new Employee();
		employeeInList.copyTo(newEmployee);
		newEmployee.setVersion(0);//will trigger copy
		getEmployeeList().add(newEmployee);
		addItemToFlexiableObject(COPIED_CHILD, newEmployee);
	}
	
	public  Employee findTheEmployee(Employee employee){
		
		int index =  getEmployeeList().indexOf(employee);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Employee("+employee.getId()+") with version='"+employee.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getEmployeeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeList(){
		getEmployeeList().clear();
	}
	
	
	


	public  SmartList<Instructor> getInstructorList(){
		if(this.mInstructorList == null){
			this.mInstructorList = new SmartList<Instructor>();
			this.mInstructorList.setListInternalName (INSTRUCTOR_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mInstructorList;	
	}
	public  void setInstructorList(SmartList<Instructor> instructorList){
		for( Instructor instructor:instructorList){
			instructor.setCompany(this);
		}

		this.mInstructorList = instructorList;
		this.mInstructorList.setListInternalName (INSTRUCTOR_LIST );
		
	}
	
	public  void addInstructor(Instructor instructor){
		instructor.setCompany(this);
		getInstructorList().add(instructor);
	}
	public  void addInstructorList(SmartList<Instructor> instructorList){
		for( Instructor instructor:instructorList){
			instructor.setCompany(this);
		}
		getInstructorList().addAll(instructorList);
	}
	public  void mergeInstructorList(SmartList<Instructor> instructorList){
		if(instructorList==null){
			return;
		}
		if(instructorList.isEmpty()){
			return;
		}
		addInstructorList( instructorList );
		
	}
	public  Instructor removeInstructor(Instructor instructorIndex){
		
		int index = getInstructorList().indexOf(instructorIndex);
        if(index < 0){
        	String message = "Instructor("+instructorIndex.getId()+") with version='"+instructorIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Instructor instructor = getInstructorList().get(index);        
        // instructor.clearCompany(); //disconnect with Company
        instructor.clearFromAll(); //disconnect with Company
		
		boolean result = getInstructorList().planToRemove(instructor);
        if(!result){
        	String message = "Instructor("+instructorIndex.getId()+") with version='"+instructorIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return instructor;
        
	
	}
	//断舍离
	public  void breakWithInstructor(Instructor instructor){
		
		if(instructor == null){
			return;
		}
		instructor.setCompany(null);
		//getInstructorList().remove();
	
	}
	
	public  boolean hasInstructor(Instructor instructor){
	
		return getInstructorList().contains(instructor);
  
	}
	
	public void copyInstructorFrom(Instructor instructor) {

		Instructor instructorInList = findTheInstructor(instructor);
		Instructor newInstructor = new Instructor();
		instructorInList.copyTo(newInstructor);
		newInstructor.setVersion(0);//will trigger copy
		getInstructorList().add(newInstructor);
		addItemToFlexiableObject(COPIED_CHILD, newInstructor);
	}
	
	public  Instructor findTheInstructor(Instructor instructor){
		
		int index =  getInstructorList().indexOf(instructor);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Instructor("+instructor.getId()+") with version='"+instructor.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getInstructorList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpInstructorList(){
		getInstructorList().clear();
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
			companyTraining.setCompany(this);
		}

		this.mCompanyTrainingList = companyTrainingList;
		this.mCompanyTrainingList.setListInternalName (COMPANY_TRAINING_LIST );
		
	}
	
	public  void addCompanyTraining(CompanyTraining companyTraining){
		companyTraining.setCompany(this);
		getCompanyTrainingList().add(companyTraining);
	}
	public  void addCompanyTrainingList(SmartList<CompanyTraining> companyTrainingList){
		for( CompanyTraining companyTraining:companyTrainingList){
			companyTraining.setCompany(this);
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
        // companyTraining.clearCompany(); //disconnect with Company
        companyTraining.clearFromAll(); //disconnect with Company
		
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
		companyTraining.setCompany(null);
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


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getCatalogList(), internalType);
		collectFromList(this, entityList, getRetailStoreProvinceCenterList(), internalType);
		collectFromList(this, entityList, getRetailStoreList(), internalType);
		collectFromList(this, entityList, getRetailStoreMemberList(), internalType);
		collectFromList(this, entityList, getGoodsSupplierList(), internalType);
		collectFromList(this, entityList, getSupplyOrderList(), internalType);
		collectFromList(this, entityList, getRetailStoreOrderList(), internalType);
		collectFromList(this, entityList, getWarehouseList(), internalType);
		collectFromList(this, entityList, getTransportFleetList(), internalType);
		collectFromList(this, entityList, getAccountSetList(), internalType);
		collectFromList(this, entityList, getLevelOneDepartmentList(), internalType);
		collectFromList(this, entityList, getSkillTypeList(), internalType);
		collectFromList(this, entityList, getResponsibilityTypeList(), internalType);
		collectFromList(this, entityList, getTerminationReasonList(), internalType);
		collectFromList(this, entityList, getTerminationTypeList(), internalType);
		collectFromList(this, entityList, getOccupationTypeList(), internalType);
		collectFromList(this, entityList, getLeaveTypeList(), internalType);
		collectFromList(this, entityList, getSalaryGradeList(), internalType);
		collectFromList(this, entityList, getInterviewTypeList(), internalType);
		collectFromList(this, entityList, getTrainingCourseTypeList(), internalType);
		collectFromList(this, entityList, getPublicHolidayList(), internalType);
		collectFromList(this, entityList, getEmployeeList(), internalType);
		collectFromList(this, entityList, getInstructorList(), internalType);
		collectFromList(this, entityList, getCompanyTrainingList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getCatalogList());
		listOfList.add( getRetailStoreProvinceCenterList());
		listOfList.add( getRetailStoreList());
		listOfList.add( getRetailStoreMemberList());
		listOfList.add( getGoodsSupplierList());
		listOfList.add( getSupplyOrderList());
		listOfList.add( getRetailStoreOrderList());
		listOfList.add( getWarehouseList());
		listOfList.add( getTransportFleetList());
		listOfList.add( getAccountSetList());
		listOfList.add( getLevelOneDepartmentList());
		listOfList.add( getSkillTypeList());
		listOfList.add( getResponsibilityTypeList());
		listOfList.add( getTerminationReasonList());
		listOfList.add( getTerminationTypeList());
		listOfList.add( getOccupationTypeList());
		listOfList.add( getLeaveTypeList());
		listOfList.add( getSalaryGradeList());
		listOfList.add( getInterviewTypeList());
		listOfList.add( getTrainingCourseTypeList());
		listOfList.add( getPublicHolidayList());
		listOfList.add( getEmployeeList());
		listOfList.add( getInstructorList());
		listOfList.add( getCompanyTrainingList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, SERVICE_NUMBER_PROPERTY, getServiceNumber());
		appendKeyValuePair(result, FOUNDED_PROPERTY, getFounded());
		appendKeyValuePair(result, WEB_SITE_PROPERTY, getWebSite());
		appendKeyValuePair(result, ADDRESS_PROPERTY, getAddress());
		appendKeyValuePair(result, OPERATED_BY_PROPERTY, getOperatedBy());
		appendKeyValuePair(result, LEGAL_REPRESENTATIVE_PROPERTY, getLegalRepresentative());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, CATALOG_LIST, getCatalogList());
		if(!getCatalogList().isEmpty()){
			appendKeyValuePair(result, "catalogCount", getCatalogList().getTotalCount());
			appendKeyValuePair(result, "catalogCurrentPageNumber", getCatalogList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, RETAIL_STORE_PROVINCE_CENTER_LIST, getRetailStoreProvinceCenterList());
		if(!getRetailStoreProvinceCenterList().isEmpty()){
			appendKeyValuePair(result, "retailStoreProvinceCenterCount", getRetailStoreProvinceCenterList().getTotalCount());
			appendKeyValuePair(result, "retailStoreProvinceCenterCurrentPageNumber", getRetailStoreProvinceCenterList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, RETAIL_STORE_LIST, getRetailStoreList());
		if(!getRetailStoreList().isEmpty()){
			appendKeyValuePair(result, "retailStoreCount", getRetailStoreList().getTotalCount());
			appendKeyValuePair(result, "retailStoreCurrentPageNumber", getRetailStoreList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, RETAIL_STORE_MEMBER_LIST, getRetailStoreMemberList());
		if(!getRetailStoreMemberList().isEmpty()){
			appendKeyValuePair(result, "retailStoreMemberCount", getRetailStoreMemberList().getTotalCount());
			appendKeyValuePair(result, "retailStoreMemberCurrentPageNumber", getRetailStoreMemberList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, GOODS_SUPPLIER_LIST, getGoodsSupplierList());
		if(!getGoodsSupplierList().isEmpty()){
			appendKeyValuePair(result, "goodsSupplierCount", getGoodsSupplierList().getTotalCount());
			appendKeyValuePair(result, "goodsSupplierCurrentPageNumber", getGoodsSupplierList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, SUPPLY_ORDER_LIST, getSupplyOrderList());
		if(!getSupplyOrderList().isEmpty()){
			appendKeyValuePair(result, "supplyOrderCount", getSupplyOrderList().getTotalCount());
			appendKeyValuePair(result, "supplyOrderCurrentPageNumber", getSupplyOrderList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, RETAIL_STORE_ORDER_LIST, getRetailStoreOrderList());
		if(!getRetailStoreOrderList().isEmpty()){
			appendKeyValuePair(result, "retailStoreOrderCount", getRetailStoreOrderList().getTotalCount());
			appendKeyValuePair(result, "retailStoreOrderCurrentPageNumber", getRetailStoreOrderList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, WAREHOUSE_LIST, getWarehouseList());
		if(!getWarehouseList().isEmpty()){
			appendKeyValuePair(result, "warehouseCount", getWarehouseList().getTotalCount());
			appendKeyValuePair(result, "warehouseCurrentPageNumber", getWarehouseList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TRANSPORT_FLEET_LIST, getTransportFleetList());
		if(!getTransportFleetList().isEmpty()){
			appendKeyValuePair(result, "transportFleetCount", getTransportFleetList().getTotalCount());
			appendKeyValuePair(result, "transportFleetCurrentPageNumber", getTransportFleetList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, ACCOUNT_SET_LIST, getAccountSetList());
		if(!getAccountSetList().isEmpty()){
			appendKeyValuePair(result, "accountSetCount", getAccountSetList().getTotalCount());
			appendKeyValuePair(result, "accountSetCurrentPageNumber", getAccountSetList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, LEVEL_ONE_DEPARTMENT_LIST, getLevelOneDepartmentList());
		if(!getLevelOneDepartmentList().isEmpty()){
			appendKeyValuePair(result, "levelOneDepartmentCount", getLevelOneDepartmentList().getTotalCount());
			appendKeyValuePair(result, "levelOneDepartmentCurrentPageNumber", getLevelOneDepartmentList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, SKILL_TYPE_LIST, getSkillTypeList());
		if(!getSkillTypeList().isEmpty()){
			appendKeyValuePair(result, "skillTypeCount", getSkillTypeList().getTotalCount());
			appendKeyValuePair(result, "skillTypeCurrentPageNumber", getSkillTypeList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, RESPONSIBILITY_TYPE_LIST, getResponsibilityTypeList());
		if(!getResponsibilityTypeList().isEmpty()){
			appendKeyValuePair(result, "responsibilityTypeCount", getResponsibilityTypeList().getTotalCount());
			appendKeyValuePair(result, "responsibilityTypeCurrentPageNumber", getResponsibilityTypeList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TERMINATION_REASON_LIST, getTerminationReasonList());
		if(!getTerminationReasonList().isEmpty()){
			appendKeyValuePair(result, "terminationReasonCount", getTerminationReasonList().getTotalCount());
			appendKeyValuePair(result, "terminationReasonCurrentPageNumber", getTerminationReasonList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TERMINATION_TYPE_LIST, getTerminationTypeList());
		if(!getTerminationTypeList().isEmpty()){
			appendKeyValuePair(result, "terminationTypeCount", getTerminationTypeList().getTotalCount());
			appendKeyValuePair(result, "terminationTypeCurrentPageNumber", getTerminationTypeList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, OCCUPATION_TYPE_LIST, getOccupationTypeList());
		if(!getOccupationTypeList().isEmpty()){
			appendKeyValuePair(result, "occupationTypeCount", getOccupationTypeList().getTotalCount());
			appendKeyValuePair(result, "occupationTypeCurrentPageNumber", getOccupationTypeList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, LEAVE_TYPE_LIST, getLeaveTypeList());
		if(!getLeaveTypeList().isEmpty()){
			appendKeyValuePair(result, "leaveTypeCount", getLeaveTypeList().getTotalCount());
			appendKeyValuePair(result, "leaveTypeCurrentPageNumber", getLeaveTypeList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, SALARY_GRADE_LIST, getSalaryGradeList());
		if(!getSalaryGradeList().isEmpty()){
			appendKeyValuePair(result, "salaryGradeCount", getSalaryGradeList().getTotalCount());
			appendKeyValuePair(result, "salaryGradeCurrentPageNumber", getSalaryGradeList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, INTERVIEW_TYPE_LIST, getInterviewTypeList());
		if(!getInterviewTypeList().isEmpty()){
			appendKeyValuePair(result, "interviewTypeCount", getInterviewTypeList().getTotalCount());
			appendKeyValuePair(result, "interviewTypeCurrentPageNumber", getInterviewTypeList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, TRAINING_COURSE_TYPE_LIST, getTrainingCourseTypeList());
		if(!getTrainingCourseTypeList().isEmpty()){
			appendKeyValuePair(result, "trainingCourseTypeCount", getTrainingCourseTypeList().getTotalCount());
			appendKeyValuePair(result, "trainingCourseTypeCurrentPageNumber", getTrainingCourseTypeList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, PUBLIC_HOLIDAY_LIST, getPublicHolidayList());
		if(!getPublicHolidayList().isEmpty()){
			appendKeyValuePair(result, "publicHolidayCount", getPublicHolidayList().getTotalCount());
			appendKeyValuePair(result, "publicHolidayCurrentPageNumber", getPublicHolidayList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, EMPLOYEE_LIST, getEmployeeList());
		if(!getEmployeeList().isEmpty()){
			appendKeyValuePair(result, "employeeCount", getEmployeeList().getTotalCount());
			appendKeyValuePair(result, "employeeCurrentPageNumber", getEmployeeList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, INSTRUCTOR_LIST, getInstructorList());
		if(!getInstructorList().isEmpty()){
			appendKeyValuePair(result, "instructorCount", getInstructorList().getTotalCount());
			appendKeyValuePair(result, "instructorCurrentPageNumber", getInstructorList().getCurrentPageNumber());
		}
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
		
		
		if(baseDest instanceof RetailStoreCountryCenter){
		
		
			RetailStoreCountryCenter dest =(RetailStoreCountryCenter)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setServiceNumber(getServiceNumber());
			dest.setFounded(getFounded());
			dest.setWebSite(getWebSite());
			dest.setAddress(getAddress());
			dest.setOperatedBy(getOperatedBy());
			dest.setLegalRepresentative(getLegalRepresentative());
			dest.setDescription(getDescription());
			dest.setVersion(getVersion());
			dest.setCatalogList(getCatalogList());
			dest.setRetailStoreProvinceCenterList(getRetailStoreProvinceCenterList());
			dest.setRetailStoreList(getRetailStoreList());
			dest.setRetailStoreMemberList(getRetailStoreMemberList());
			dest.setGoodsSupplierList(getGoodsSupplierList());
			dest.setSupplyOrderList(getSupplyOrderList());
			dest.setRetailStoreOrderList(getRetailStoreOrderList());
			dest.setWarehouseList(getWarehouseList());
			dest.setTransportFleetList(getTransportFleetList());
			dest.setAccountSetList(getAccountSetList());
			dest.setLevelOneDepartmentList(getLevelOneDepartmentList());
			dest.setSkillTypeList(getSkillTypeList());
			dest.setResponsibilityTypeList(getResponsibilityTypeList());
			dest.setTerminationReasonList(getTerminationReasonList());
			dest.setTerminationTypeList(getTerminationTypeList());
			dest.setOccupationTypeList(getOccupationTypeList());
			dest.setLeaveTypeList(getLeaveTypeList());
			dest.setSalaryGradeList(getSalaryGradeList());
			dest.setInterviewTypeList(getInterviewTypeList());
			dest.setTrainingCourseTypeList(getTrainingCourseTypeList());
			dest.setPublicHolidayList(getPublicHolidayList());
			dest.setEmployeeList(getEmployeeList());
			dest.setInstructorList(getInstructorList());
			dest.setCompanyTrainingList(getCompanyTrainingList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreCountryCenter){
		
			
			RetailStoreCountryCenter dest =(RetailStoreCountryCenter)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeServiceNumber(getServiceNumber());
			dest.mergeFounded(getFounded());
			dest.mergeWebSite(getWebSite());
			dest.mergeAddress(getAddress());
			dest.mergeOperatedBy(getOperatedBy());
			dest.mergeLegalRepresentative(getLegalRepresentative());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());
			dest.mergeCatalogList(getCatalogList());
			dest.mergeRetailStoreProvinceCenterList(getRetailStoreProvinceCenterList());
			dest.mergeRetailStoreList(getRetailStoreList());
			dest.mergeRetailStoreMemberList(getRetailStoreMemberList());
			dest.mergeGoodsSupplierList(getGoodsSupplierList());
			dest.mergeSupplyOrderList(getSupplyOrderList());
			dest.mergeRetailStoreOrderList(getRetailStoreOrderList());
			dest.mergeWarehouseList(getWarehouseList());
			dest.mergeTransportFleetList(getTransportFleetList());
			dest.mergeAccountSetList(getAccountSetList());
			dest.mergeLevelOneDepartmentList(getLevelOneDepartmentList());
			dest.mergeSkillTypeList(getSkillTypeList());
			dest.mergeResponsibilityTypeList(getResponsibilityTypeList());
			dest.mergeTerminationReasonList(getTerminationReasonList());
			dest.mergeTerminationTypeList(getTerminationTypeList());
			dest.mergeOccupationTypeList(getOccupationTypeList());
			dest.mergeLeaveTypeList(getLeaveTypeList());
			dest.mergeSalaryGradeList(getSalaryGradeList());
			dest.mergeInterviewTypeList(getInterviewTypeList());
			dest.mergeTrainingCourseTypeList(getTrainingCourseTypeList());
			dest.mergePublicHolidayList(getPublicHolidayList());
			dest.mergeEmployeeList(getEmployeeList());
			dest.mergeInstructorList(getInstructorList());
			dest.mergeCompanyTrainingList(getCompanyTrainingList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreCountryCenter){
		
			
			RetailStoreCountryCenter dest =(RetailStoreCountryCenter)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeServiceNumber(getServiceNumber());
			dest.mergeFounded(getFounded());
			dest.mergeWebSite(getWebSite());
			dest.mergeAddress(getAddress());
			dest.mergeOperatedBy(getOperatedBy());
			dest.mergeLegalRepresentative(getLegalRepresentative());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getServiceNumber(), getFounded(), getWebSite(), getAddress(), getOperatedBy(), getLegalRepresentative(), getDescription(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("RetailStoreCountryCenter{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tserviceNumber='"+getServiceNumber()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		stringBuilder.append("\twebSite='"+getWebSite()+"';");
		stringBuilder.append("\taddress='"+getAddress()+"';");
		stringBuilder.append("\toperatedBy='"+getOperatedBy()+"';");
		stringBuilder.append("\tlegalRepresentative='"+getLegalRepresentative()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

