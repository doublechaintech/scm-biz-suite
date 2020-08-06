
package com.doublechaintech.retailscm.salarygrade;

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
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;









@JsonSerialize(using = SalaryGradeSerializer.class)
public class SalaryGrade extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String DETAIL_DESCRIPTION_PROPERTY    = "detailDescription" ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_LIST                            = "employeeList"      ;
	public static final String EMPLOYEE_SALARY_SHEET_LIST               = "employeeSalarySheetList";

	public static final String INTERNAL_TYPE="SalaryGrade";
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
	protected		String              	mDetailDescription  ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Employee> 	mEmployeeList       ;
	protected		SmartList<EmployeeSalarySheet>	mEmployeeSalarySheetList;

	
		
	public 	SalaryGrade(){
		// lazy load for all the properties
	}
	public 	static SalaryGrade withId(String id){
		SalaryGrade salaryGrade = new SalaryGrade();
		salaryGrade.setId(id);
		salaryGrade.setVersion(Integer.MAX_VALUE);
		return salaryGrade;
	}
	public 	static SalaryGrade refById(String id){
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
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			return getDetailDescription();
		}
		if(EMPLOYEE_LIST.equals(property)){
			List<BaseEntity> list = getEmployeeList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(EMPLOYEE_SALARY_SHEET_LIST.equals(property)){
			List<BaseEntity> list = getEmployeeSalarySheetList().stream().map(item->item).collect(Collectors.toList());
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
	public SalaryGrade updateId(String id){
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
	public SalaryGrade updateCode(String code){
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
	public SalaryGrade updateCompany(RetailStoreCountryCenter company){
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
	public SalaryGrade updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setDetailDescription(String detailDescription){
		this.mDetailDescription = trimString(detailDescription);;
	}
	public String getDetailDescription(){
		return this.mDetailDescription;
	}
	public SalaryGrade updateDetailDescription(String detailDescription){
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
	public SalaryGrade updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
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
			employee.setCurrentSalaryGrade(this);
		}

		this.mEmployeeList = employeeList;
		this.mEmployeeList.setListInternalName (EMPLOYEE_LIST );
		
	}
	
	public  void addEmployee(Employee employee){
		employee.setCurrentSalaryGrade(this);
		getEmployeeList().add(employee);
	}
	public  void addEmployeeList(SmartList<Employee> employeeList){
		for( Employee employee:employeeList){
			employee.setCurrentSalaryGrade(this);
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
        // employee.clearCurrentSalaryGrade(); //disconnect with CurrentSalaryGrade
        employee.clearFromAll(); //disconnect with CurrentSalaryGrade
		
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
		employee.setCurrentSalaryGrade(null);
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
	
	
	


	public  SmartList<EmployeeSalarySheet> getEmployeeSalarySheetList(){
		if(this.mEmployeeSalarySheetList == null){
			this.mEmployeeSalarySheetList = new SmartList<EmployeeSalarySheet>();
			this.mEmployeeSalarySheetList.setListInternalName (EMPLOYEE_SALARY_SHEET_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mEmployeeSalarySheetList;	
	}
	public  void setEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList){
		for( EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList){
			employeeSalarySheet.setCurrentSalaryGrade(this);
		}

		this.mEmployeeSalarySheetList = employeeSalarySheetList;
		this.mEmployeeSalarySheetList.setListInternalName (EMPLOYEE_SALARY_SHEET_LIST );
		
	}
	
	public  void addEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet){
		employeeSalarySheet.setCurrentSalaryGrade(this);
		getEmployeeSalarySheetList().add(employeeSalarySheet);
	}
	public  void addEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList){
		for( EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList){
			employeeSalarySheet.setCurrentSalaryGrade(this);
		}
		getEmployeeSalarySheetList().addAll(employeeSalarySheetList);
	}
	public  void mergeEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList){
		if(employeeSalarySheetList==null){
			return;
		}
		if(employeeSalarySheetList.isEmpty()){
			return;
		}
		addEmployeeSalarySheetList( employeeSalarySheetList );
		
	}
	public  EmployeeSalarySheet removeEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheetIndex){
		
		int index = getEmployeeSalarySheetList().indexOf(employeeSalarySheetIndex);
        if(index < 0){
        	String message = "EmployeeSalarySheet("+employeeSalarySheetIndex.getId()+") with version='"+employeeSalarySheetIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EmployeeSalarySheet employeeSalarySheet = getEmployeeSalarySheetList().get(index);        
        // employeeSalarySheet.clearCurrentSalaryGrade(); //disconnect with CurrentSalaryGrade
        employeeSalarySheet.clearFromAll(); //disconnect with CurrentSalaryGrade
		
		boolean result = getEmployeeSalarySheetList().planToRemove(employeeSalarySheet);
        if(!result){
        	String message = "EmployeeSalarySheet("+employeeSalarySheetIndex.getId()+") with version='"+employeeSalarySheetIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return employeeSalarySheet;
        
	
	}
	//断舍离
	public  void breakWithEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet){
		
		if(employeeSalarySheet == null){
			return;
		}
		employeeSalarySheet.setCurrentSalaryGrade(null);
		//getEmployeeSalarySheetList().remove();
	
	}
	
	public  boolean hasEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet){
	
		return getEmployeeSalarySheetList().contains(employeeSalarySheet);
  
	}
	
	public void copyEmployeeSalarySheetFrom(EmployeeSalarySheet employeeSalarySheet) {

		EmployeeSalarySheet employeeSalarySheetInList = findTheEmployeeSalarySheet(employeeSalarySheet);
		EmployeeSalarySheet newEmployeeSalarySheet = new EmployeeSalarySheet();
		employeeSalarySheetInList.copyTo(newEmployeeSalarySheet);
		newEmployeeSalarySheet.setVersion(0);//will trigger copy
		getEmployeeSalarySheetList().add(newEmployeeSalarySheet);
		addItemToFlexiableObject(COPIED_CHILD, newEmployeeSalarySheet);
	}
	
	public  EmployeeSalarySheet findTheEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet){
		
		int index =  getEmployeeSalarySheetList().indexOf(employeeSalarySheet);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "EmployeeSalarySheet("+employeeSalarySheet.getId()+") with version='"+employeeSalarySheet.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getEmployeeSalarySheetList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeSalarySheetList(){
		getEmployeeSalarySheetList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getCompany(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getEmployeeList(), internalType);
		collectFromList(this, entityList, getEmployeeSalarySheetList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getEmployeeList());
		listOfList.add( getEmployeeSalarySheetList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, CODE_PROPERTY, getCode());
		appendKeyValuePair(result, COMPANY_PROPERTY, getCompany());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, DETAIL_DESCRIPTION_PROPERTY, getDetailDescription());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, EMPLOYEE_LIST, getEmployeeList());
		if(!getEmployeeList().isEmpty()){
			appendKeyValuePair(result, "employeeCount", getEmployeeList().getTotalCount());
			appendKeyValuePair(result, "employeeCurrentPageNumber", getEmployeeList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, EMPLOYEE_SALARY_SHEET_LIST, getEmployeeSalarySheetList());
		if(!getEmployeeSalarySheetList().isEmpty()){
			appendKeyValuePair(result, "employeeSalarySheetCount", getEmployeeSalarySheetList().getTotalCount());
			appendKeyValuePair(result, "employeeSalarySheetCurrentPageNumber", getEmployeeSalarySheetList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SalaryGrade){
		
		
			SalaryGrade dest =(SalaryGrade)baseDest;
		
			dest.setId(getId());
			dest.setCode(getCode());
			dest.setCompany(getCompany());
			dest.setName(getName());
			dest.setDetailDescription(getDetailDescription());
			dest.setVersion(getVersion());
			dest.setEmployeeList(getEmployeeList());
			dest.setEmployeeSalarySheetList(getEmployeeSalarySheetList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SalaryGrade){
		
			
			SalaryGrade dest =(SalaryGrade)baseDest;
		
			dest.mergeId(getId());
			dest.mergeCode(getCode());
			dest.mergeCompany(getCompany());
			dest.mergeName(getName());
			dest.mergeDetailDescription(getDetailDescription());
			dest.mergeVersion(getVersion());
			dest.mergeEmployeeList(getEmployeeList());
			dest.mergeEmployeeSalarySheetList(getEmployeeSalarySheetList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SalaryGrade){
		
			
			SalaryGrade dest =(SalaryGrade)baseDest;
		
			dest.mergeId(getId());
			dest.mergeCode(getCode());
			dest.mergeName(getName());
			dest.mergeDetailDescription(getDetailDescription());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getCode(), getCompany(), getName(), getDetailDescription(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("SalaryGrade{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		if(getCompany() != null ){
 			stringBuilder.append("\tcompany='RetailStoreCountryCenter("+getCompany().getId()+")';");
 		}
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tdetailDescription='"+getDetailDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

