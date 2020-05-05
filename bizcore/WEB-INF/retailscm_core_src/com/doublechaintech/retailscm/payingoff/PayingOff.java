
package com.doublechaintech.retailscm.payingoff;

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
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;

@JsonSerialize(using = PayingOffSerializer.class)
public class PayingOff extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String PAID_FOR_PROPERTY              = "paidFor"           ;
	public static final String PAID_TIME_PROPERTY             = "paidTime"          ;
	public static final String AMOUNT_PROPERTY                = "amount"            ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_SALARY_SHEET_LIST               = "employeeSalarySheetList";

	public static final String INTERNAL_TYPE="PayingOff";
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
	protected		Employee            	mPaidFor            ;
	protected		Date                	mPaidTime           ;
	protected		BigDecimal          	mAmount             ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<EmployeeSalarySheet>	mEmployeeSalarySheetList;

	
		
	public 	PayingOff(){
		// lazy load for all the properties
	}
	public 	static PayingOff withId(String id){
		PayingOff payingOff = new PayingOff();
		payingOff.setId(id);
		payingOff.setVersion(Integer.MAX_VALUE);
		return payingOff;
	}
	public 	static PayingOff refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPaidFor( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(WHO_PROPERTY.equals(property)){
			changeWhoProperty(newValueExpr);
		}
		if(PAID_TIME_PROPERTY.equals(property)){
			changePaidTimeProperty(newValueExpr);
		}
		if(AMOUNT_PROPERTY.equals(property)){
			changeAmountProperty(newValueExpr);
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
			
			
			
	protected void changePaidTimeProperty(String newValueExpr){
	
		Date oldValue = getPaidTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePaidTime(newValue);
		this.onChangeProperty(PAID_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeAmountProperty(String newValueExpr){
	
		BigDecimal oldValue = getAmount();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAmount(newValue);
		this.onChangeProperty(AMOUNT_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(WHO_PROPERTY.equals(property)){
			return getWho();
		}
		if(PAID_FOR_PROPERTY.equals(property)){
			return getPaidFor();
		}
		if(PAID_TIME_PROPERTY.equals(property)){
			return getPaidTime();
		}
		if(AMOUNT_PROPERTY.equals(property)){
			return getAmount();
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
	public PayingOff updateId(String id){
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
	public PayingOff updateWho(String who){
		this.mWho = trimString(who);;
		this.changed = true;
		return this;
	}
	public void mergeWho(String who){
		if(who != null) { setWho(who);}
	}
	
	
	public void setPaidFor(Employee paidFor){
		this.mPaidFor = paidFor;;
	}
	public Employee getPaidFor(){
		return this.mPaidFor;
	}
	public PayingOff updatePaidFor(Employee paidFor){
		this.mPaidFor = paidFor;;
		this.changed = true;
		return this;
	}
	public void mergePaidFor(Employee paidFor){
		if(paidFor != null) { setPaidFor(paidFor);}
	}
	
	
	public void clearPaidFor(){
		setPaidFor ( null );
		this.changed = true;
	}
	
	public void setPaidTime(Date paidTime){
		this.mPaidTime = paidTime;;
	}
	public Date getPaidTime(){
		return this.mPaidTime;
	}
	public PayingOff updatePaidTime(Date paidTime){
		this.mPaidTime = paidTime;;
		this.changed = true;
		return this;
	}
	public void mergePaidTime(Date paidTime){
		setPaidTime(paidTime);
	}
	
	
	public void setAmount(BigDecimal amount){
		this.mAmount = amount;;
	}
	public BigDecimal getAmount(){
		return this.mAmount;
	}
	public PayingOff updateAmount(BigDecimal amount){
		this.mAmount = amount;;
		this.changed = true;
		return this;
	}
	public void mergeAmount(BigDecimal amount){
		setAmount(amount);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public PayingOff updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
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
			employeeSalarySheet.setPayingOff(this);
		}

		this.mEmployeeSalarySheetList = employeeSalarySheetList;
		this.mEmployeeSalarySheetList.setListInternalName (EMPLOYEE_SALARY_SHEET_LIST );
		
	}
	
	public  void addEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet){
		employeeSalarySheet.setPayingOff(this);
		getEmployeeSalarySheetList().add(employeeSalarySheet);
	}
	public  void addEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList){
		for( EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList){
			employeeSalarySheet.setPayingOff(this);
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
        // employeeSalarySheet.clearPayingOff(); //disconnect with PayingOff
        employeeSalarySheet.clearFromAll(); //disconnect with PayingOff
		
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
		employeeSalarySheet.setPayingOff(null);
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

		addToEntityList(this, entityList, getPaidFor(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getEmployeeSalarySheetList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getEmployeeSalarySheetList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, WHO_PROPERTY, getWho());
		appendKeyValuePair(result, PAID_FOR_PROPERTY, getPaidFor());
		appendKeyValuePair(result, PAID_TIME_PROPERTY, getPaidTime());
		appendKeyValuePair(result, AMOUNT_PROPERTY, getAmount());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
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
		
		
		if(baseDest instanceof PayingOff){
		
		
			PayingOff dest =(PayingOff)baseDest;
		
			dest.setId(getId());
			dest.setWho(getWho());
			dest.setPaidFor(getPaidFor());
			dest.setPaidTime(getPaidTime());
			dest.setAmount(getAmount());
			dest.setVersion(getVersion());
			dest.setEmployeeSalarySheetList(getEmployeeSalarySheetList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof PayingOff){
		
			
			PayingOff dest =(PayingOff)baseDest;
		
			dest.mergeId(getId());
			dest.mergeWho(getWho());
			dest.mergePaidFor(getPaidFor());
			dest.mergePaidTime(getPaidTime());
			dest.mergeAmount(getAmount());
			dest.mergeVersion(getVersion());
			dest.mergeEmployeeSalarySheetList(getEmployeeSalarySheetList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof PayingOff){
		
			
			PayingOff dest =(PayingOff)baseDest;
		
			dest.mergeId(getId());
			dest.mergeWho(getWho());
			dest.mergePaidTime(getPaidTime());
			dest.mergeAmount(getAmount());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getWho(), getPaidFor(), getPaidTime(), getAmount(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("PayingOff{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		if(getPaidFor() != null ){
 			stringBuilder.append("\tpaidFor='Employee("+getPaidFor().getId()+")';");
 		}
		stringBuilder.append("\tpaidTime='"+getPaidTime()+"';");
		stringBuilder.append("\tamount='"+getAmount()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

