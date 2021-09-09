
package com.doublechaintech.retailscm.payingoff;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
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


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(WHO_PROPERTY, "who", "谁")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(PAID_FOR_PROPERTY, "employee", "支付")
        .withType("employee", Employee.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(PAID_TIME_PROPERTY, "paid_time", "支付时间")
        .withType("date", Date.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(AMOUNT_PROPERTY, "amount", "金额")
        .withType("money", "BigDecimal"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(EMPLOYEE_SALARY_SHEET_LIST, "payingOff", "员工工资表")
        .withType("employee_salary_sheet", EmployeeSalarySheet.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,WHO_PROPERTY ,PAID_FOR_PROPERTY ,PAID_TIME_PROPERTY ,AMOUNT_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(EMPLOYEE_SALARY_SHEET_LIST, "payingOff");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(EMPLOYEE_SALARY_SHEET_LIST, EmployeeSalarySheet.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(PAID_FOR_PROPERTY, Employee.class);

    return parents;
  }

  public PayingOff want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public PayingOff wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getWho();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		String              	who                 ;
	protected		Employee            	paidFor             ;
	protected		Date                	paidTime            ;
	protected		BigDecimal          	amount              ;
	protected		int                 	version             ;

	
	protected		SmartList<EmployeeSalarySheet>	mEmployeeSalarySheetList;



	public 	PayingOff(){
		// lazy load for all the properties
	}
	public 	static PayingOff withId(String id){
		PayingOff payingOff = new PayingOff();
		payingOff.setId(id);
		payingOff.setVersion(Integer.MAX_VALUE);
		payingOff.setChecked(true);
		return payingOff;
	}
	public 	static PayingOff refById(String id){
		return withId(id);
	}

  public PayingOff limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public PayingOff limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static PayingOff searchExample(){
    PayingOff payingOff = new PayingOff();
    		payingOff.setVersion(UNSET_INT);

    return payingOff;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPaidFor( null );

		this.changed = true;
		setChecked(false);
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

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public PayingOff updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public PayingOff orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public PayingOff ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public PayingOff addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setWho(String who){String oldWho = this.who;String newWho = trimString(who);this.who = newWho;}
	public String who(){
doLoad();
return getWho();
}
	public String getWho(){
		return this.who;
	}
	public PayingOff updateWho(String who){String oldWho = this.who;String newWho = trimString(who);if(!shouldReplaceBy(newWho, oldWho)){return this;}this.who = newWho;addPropertyChange(WHO_PROPERTY, oldWho, newWho);this.changed = true;setChecked(false);return this;}
	public PayingOff orderByWho(boolean asc){
doAddOrderBy(WHO_PROPERTY, asc);
return this;
}
	public SearchCriteria createWhoCriteria(QueryOperator operator, Object... parameters){
return createCriteria(WHO_PROPERTY, operator, parameters);
}
	public PayingOff ignoreWhoCriteria(){super.ignoreSearchProperty(WHO_PROPERTY);
return this;
}
	public PayingOff addWhoCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createWhoCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeWho(String who){
		if(who != null) { setWho(who);}
	}

	
	public void setPaidFor(Employee paidFor){Employee oldPaidFor = this.paidFor;Employee newPaidFor = paidFor;this.paidFor = newPaidFor;}
	public Employee paidFor(){
doLoad();
return getPaidFor();
}
	public Employee getPaidFor(){
		return this.paidFor;
	}
	public PayingOff updatePaidFor(Employee paidFor){Employee oldPaidFor = this.paidFor;Employee newPaidFor = paidFor;if(!shouldReplaceBy(newPaidFor, oldPaidFor)){return this;}this.paidFor = newPaidFor;addPropertyChange(PAID_FOR_PROPERTY, oldPaidFor, newPaidFor);this.changed = true;setChecked(false);return this;}
	public PayingOff orderByPaidFor(boolean asc){
doAddOrderBy(PAID_FOR_PROPERTY, asc);
return this;
}
	public SearchCriteria createPaidForCriteria(QueryOperator operator, Object... parameters){
return createCriteria(PAID_FOR_PROPERTY, operator, parameters);
}
	public PayingOff ignorePaidForCriteria(){super.ignoreSearchProperty(PAID_FOR_PROPERTY);
return this;
}
	public PayingOff addPaidForCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createPaidForCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergePaidFor(Employee paidFor){
		if(paidFor != null) { setPaidFor(paidFor);}
	}

	
	public void clearPaidFor(){
		setPaidFor ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setPaidTime(Date paidTime){Date oldPaidTime = this.paidTime;Date newPaidTime = paidTime;this.paidTime = newPaidTime;}
	public Date paidTime(){
doLoad();
return getPaidTime();
}
	public Date getPaidTime(){
		return this.paidTime;
	}
	public PayingOff updatePaidTime(Date paidTime){Date oldPaidTime = this.paidTime;Date newPaidTime = paidTime;if(!shouldReplaceBy(newPaidTime, oldPaidTime)){return this;}this.paidTime = newPaidTime;addPropertyChange(PAID_TIME_PROPERTY, oldPaidTime, newPaidTime);this.changed = true;setChecked(false);return this;}
	public PayingOff orderByPaidTime(boolean asc){
doAddOrderBy(PAID_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createPaidTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(PAID_TIME_PROPERTY, operator, parameters);
}
	public PayingOff ignorePaidTimeCriteria(){super.ignoreSearchProperty(PAID_TIME_PROPERTY);
return this;
}
	public PayingOff addPaidTimeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createPaidTimeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergePaidTime(Date paidTime){
		setPaidTime(paidTime);
	}

	
	public void setAmount(BigDecimal amount){BigDecimal oldAmount = this.amount;BigDecimal newAmount = amount;this.amount = newAmount;}
	public BigDecimal amount(){
doLoad();
return getAmount();
}
	public BigDecimal getAmount(){
		return this.amount;
	}
	public PayingOff updateAmount(BigDecimal amount){BigDecimal oldAmount = this.amount;BigDecimal newAmount = amount;if(!shouldReplaceBy(newAmount, oldAmount)){return this;}this.amount = newAmount;addPropertyChange(AMOUNT_PROPERTY, oldAmount, newAmount);this.changed = true;setChecked(false);return this;}
	public PayingOff orderByAmount(boolean asc){
doAddOrderBy(AMOUNT_PROPERTY, asc);
return this;
}
	public SearchCriteria createAmountCriteria(QueryOperator operator, Object... parameters){
return createCriteria(AMOUNT_PROPERTY, operator, parameters);
}
	public PayingOff ignoreAmountCriteria(){super.ignoreSearchProperty(AMOUNT_PROPERTY);
return this;
}
	public PayingOff addAmountCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createAmountCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeAmount(BigDecimal amount){
		setAmount(amount);
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public PayingOff updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public PayingOff orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public PayingOff ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public PayingOff addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
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

  public  SmartList<EmployeeSalarySheet> employeeSalarySheetList(){
    
    doLoadChild(EMPLOYEE_SALARY_SHEET_LIST);
    
    return getEmployeeSalarySheetList();
  }


	public  void setEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList){
		for( EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList){
			employeeSalarySheet.setPayingOff(this);
		}

		this.mEmployeeSalarySheetList = employeeSalarySheetList;
		this.mEmployeeSalarySheetList.setListInternalName (EMPLOYEE_SALARY_SHEET_LIST );

	}

	public  PayingOff addEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet){
		employeeSalarySheet.setPayingOff(this);
		getEmployeeSalarySheetList().add(employeeSalarySheet);
		return this;
	}
	public  PayingOff addEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList){
		for( EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList){
			employeeSalarySheet.setPayingOff(this);
		}
		getEmployeeSalarySheetList().addAll(employeeSalarySheetList);
		return this;
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


	public static PayingOff createWith(RetailscmUserContext userContext, ThrowingFunction<PayingOff,PayingOff,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<PayingOff> customCreator = mapper.findCustomCreator(PayingOff.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    PayingOff result = new PayingOff();
    result.setWho(mapper.tryToGet(PayingOff.class, WHO_PROPERTY, String.class,
        0, true, result.getWho(), params));
    result.setPaidFor(mapper.tryToGet(PayingOff.class, PAID_FOR_PROPERTY, Employee.class,
        0, true, result.getPaidFor(), params));
    result.setPaidTime(mapper.tryToGet(PayingOff.class, PAID_TIME_PROPERTY, Date.class,
        0, true, result.getPaidTime(), params));
    result.setAmount(mapper.tryToGet(PayingOff.class, AMOUNT_PROPERTY, BigDecimal.class,
        0, true, result.getAmount(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixPayingOff(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      PayingOffTokens tokens = mapper.findParamByClass(params, PayingOffTokens.class);
      if (tokens == null) {
        tokens = PayingOffTokens.start();
      }
      result = userContext.getManagerGroup().getPayingOffManager().internalSavePayingOff(userContext, result, tokens.done());
      
    }
    return result;
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

