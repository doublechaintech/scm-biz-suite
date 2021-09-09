
package com.doublechaintech.retailscm.employeeleave;

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
import com.doublechaintech.retailscm.leavetype.LeaveType;









@JsonSerialize(using = EmployeeLeaveSerializer.class)
public class EmployeeLeave extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String TYPE_PROPERTY                  = "type"              ;
	public static final String LEAVE_DURATION_HOUR_PROPERTY   = "leaveDurationHour" ;
	public static final String REMARK_PROPERTY                = "remark"            ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="EmployeeLeave";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(WHO_PROPERTY, "employee", "谁")
        .withType("employee", Employee.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(TYPE_PROPERTY, "leave_type", "类型")
        .withType("leave_type", LeaveType.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LEAVE_DURATION_HOUR_PROPERTY, "leave_duration_hour", "请假时长")
        .withType("int", "int"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(REMARK_PROPERTY, "remark", "备注")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,WHO_PROPERTY ,TYPE_PROPERTY ,LEAVE_DURATION_HOUR_PROPERTY ,REMARK_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(WHO_PROPERTY, Employee.class);
parents.put(TYPE_PROPERTY, LeaveType.class);

    return parents;
  }

  public EmployeeLeave want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public EmployeeLeave wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getRemark();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		Employee            	who                 ;
	protected		LeaveType           	type                ;
	protected		int                 	leaveDurationHour   ;
	protected		String              	remark              ;
	protected		int                 	version             ;

	



	public 	EmployeeLeave(){
		// lazy load for all the properties
	}
	public 	static EmployeeLeave withId(String id){
		EmployeeLeave employeeLeave = new EmployeeLeave();
		employeeLeave.setId(id);
		employeeLeave.setVersion(Integer.MAX_VALUE);
		employeeLeave.setChecked(true);
		return employeeLeave;
	}
	public 	static EmployeeLeave refById(String id){
		return withId(id);
	}

  public EmployeeLeave limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public EmployeeLeave limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static EmployeeLeave searchExample(){
    EmployeeLeave employeeLeave = new EmployeeLeave();
    		employeeLeave.setLeaveDurationHour(UNSET_INT);
		employeeLeave.setVersion(UNSET_INT);

    return employeeLeave;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setWho( null );
		setType( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(LEAVE_DURATION_HOUR_PROPERTY.equals(property)){
			changeLeaveDurationHourProperty(newValueExpr);
		}
		if(REMARK_PROPERTY.equals(property)){
			changeRemarkProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeLeaveDurationHourProperty(String newValueExpr){
	
		int oldValue = getLeaveDurationHour();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLeaveDurationHour(newValue);
		this.onChangeProperty(LEAVE_DURATION_HOUR_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeRemarkProperty(String newValueExpr){
	
		String oldValue = getRemark();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateRemark(newValue);
		this.onChangeProperty(REMARK_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {

		if(WHO_PROPERTY.equals(property)){
			return getWho();
		}
		if(TYPE_PROPERTY.equals(property)){
			return getType();
		}
		if(LEAVE_DURATION_HOUR_PROPERTY.equals(property)){
			return getLeaveDurationHour();
		}
		if(REMARK_PROPERTY.equals(property)){
			return getRemark();
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
	public EmployeeLeave updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public EmployeeLeave orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public EmployeeLeave ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public EmployeeLeave addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setWho(Employee who){Employee oldWho = this.who;Employee newWho = who;this.who = newWho;}
	public Employee who(){
doLoad();
return getWho();
}
	public Employee getWho(){
		return this.who;
	}
	public EmployeeLeave updateWho(Employee who){Employee oldWho = this.who;Employee newWho = who;if(!shouldReplaceBy(newWho, oldWho)){return this;}this.who = newWho;addPropertyChange(WHO_PROPERTY, oldWho, newWho);this.changed = true;setChecked(false);return this;}
	public EmployeeLeave orderByWho(boolean asc){
doAddOrderBy(WHO_PROPERTY, asc);
return this;
}
	public SearchCriteria createWhoCriteria(QueryOperator operator, Object... parameters){
return createCriteria(WHO_PROPERTY, operator, parameters);
}
	public EmployeeLeave ignoreWhoCriteria(){super.ignoreSearchProperty(WHO_PROPERTY);
return this;
}
	public EmployeeLeave addWhoCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createWhoCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeWho(Employee who){
		if(who != null) { setWho(who);}
	}

	
	public void clearWho(){
		setWho ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setType(LeaveType type){LeaveType oldType = this.type;LeaveType newType = type;this.type = newType;}
	public LeaveType type(){
doLoad();
return getType();
}
	public LeaveType getType(){
		return this.type;
	}
	public EmployeeLeave updateType(LeaveType type){LeaveType oldType = this.type;LeaveType newType = type;if(!shouldReplaceBy(newType, oldType)){return this;}this.type = newType;addPropertyChange(TYPE_PROPERTY, oldType, newType);this.changed = true;setChecked(false);return this;}
	public EmployeeLeave orderByType(boolean asc){
doAddOrderBy(TYPE_PROPERTY, asc);
return this;
}
	public SearchCriteria createTypeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(TYPE_PROPERTY, operator, parameters);
}
	public EmployeeLeave ignoreTypeCriteria(){super.ignoreSearchProperty(TYPE_PROPERTY);
return this;
}
	public EmployeeLeave addTypeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createTypeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeType(LeaveType type){
		if(type != null) { setType(type);}
	}

	
	public void clearType(){
		setType ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setLeaveDurationHour(int leaveDurationHour){int oldLeaveDurationHour = this.leaveDurationHour;int newLeaveDurationHour = leaveDurationHour;this.leaveDurationHour = newLeaveDurationHour;}
	public int leaveDurationHour(){
doLoad();
return getLeaveDurationHour();
}
	public int getLeaveDurationHour(){
		return this.leaveDurationHour;
	}
	public EmployeeLeave updateLeaveDurationHour(int leaveDurationHour){int oldLeaveDurationHour = this.leaveDurationHour;int newLeaveDurationHour = leaveDurationHour;if(!shouldReplaceBy(newLeaveDurationHour, oldLeaveDurationHour)){return this;}this.leaveDurationHour = newLeaveDurationHour;addPropertyChange(LEAVE_DURATION_HOUR_PROPERTY, oldLeaveDurationHour, newLeaveDurationHour);this.changed = true;setChecked(false);return this;}
	public EmployeeLeave orderByLeaveDurationHour(boolean asc){
doAddOrderBy(LEAVE_DURATION_HOUR_PROPERTY, asc);
return this;
}
	public SearchCriteria createLeaveDurationHourCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LEAVE_DURATION_HOUR_PROPERTY, operator, parameters);
}
	public EmployeeLeave ignoreLeaveDurationHourCriteria(){super.ignoreSearchProperty(LEAVE_DURATION_HOUR_PROPERTY);
return this;
}
	public EmployeeLeave addLeaveDurationHourCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createLeaveDurationHourCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeLeaveDurationHour(int leaveDurationHour){
		setLeaveDurationHour(leaveDurationHour);
	}

	
	public void setRemark(String remark){String oldRemark = this.remark;String newRemark = trimString(remark);this.remark = newRemark;}
	public String remark(){
doLoad();
return getRemark();
}
	public String getRemark(){
		return this.remark;
	}
	public EmployeeLeave updateRemark(String remark){String oldRemark = this.remark;String newRemark = trimString(remark);if(!shouldReplaceBy(newRemark, oldRemark)){return this;}this.remark = newRemark;addPropertyChange(REMARK_PROPERTY, oldRemark, newRemark);this.changed = true;setChecked(false);return this;}
	public EmployeeLeave orderByRemark(boolean asc){
doAddOrderBy(REMARK_PROPERTY, asc);
return this;
}
	public SearchCriteria createRemarkCriteria(QueryOperator operator, Object... parameters){
return createCriteria(REMARK_PROPERTY, operator, parameters);
}
	public EmployeeLeave ignoreRemarkCriteria(){super.ignoreSearchProperty(REMARK_PROPERTY);
return this;
}
	public EmployeeLeave addRemarkCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createRemarkCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeRemark(String remark){
		if(remark != null) { setRemark(remark);}
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public EmployeeLeave updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public EmployeeLeave orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public EmployeeLeave ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public EmployeeLeave addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getWho(), internalType);
		addToEntityList(this, entityList, getType(), internalType);


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
		appendKeyValuePair(result, WHO_PROPERTY, getWho());
		appendKeyValuePair(result, TYPE_PROPERTY, getType());
		appendKeyValuePair(result, LEAVE_DURATION_HOUR_PROPERTY, getLeaveDurationHour());
		appendKeyValuePair(result, REMARK_PROPERTY, getRemark());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof EmployeeLeave){


			EmployeeLeave dest =(EmployeeLeave)baseDest;

			dest.setId(getId());
			dest.setWho(getWho());
			dest.setType(getType());
			dest.setLeaveDurationHour(getLeaveDurationHour());
			dest.setRemark(getRemark());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof EmployeeLeave){


			EmployeeLeave dest =(EmployeeLeave)baseDest;

			dest.mergeId(getId());
			dest.mergeWho(getWho());
			dest.mergeType(getType());
			dest.mergeLeaveDurationHour(getLeaveDurationHour());
			dest.mergeRemark(getRemark());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof EmployeeLeave){


			EmployeeLeave dest =(EmployeeLeave)baseDest;

			dest.mergeId(getId());
			dest.mergeLeaveDurationHour(getLeaveDurationHour());
			dest.mergeRemark(getRemark());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getWho(), getType(), getLeaveDurationHour(), getRemark(), getVersion()};
	}


	public static EmployeeLeave createWith(RetailscmUserContext userContext, ThrowingFunction<EmployeeLeave,EmployeeLeave,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<EmployeeLeave> customCreator = mapper.findCustomCreator(EmployeeLeave.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    EmployeeLeave result = new EmployeeLeave();
    result.setWho(mapper.tryToGet(EmployeeLeave.class, WHO_PROPERTY, Employee.class,
        0, true, result.getWho(), params));
    result.setType(mapper.tryToGet(EmployeeLeave.class, TYPE_PROPERTY, LeaveType.class,
        0, true, result.getType(), params));
    result.setLeaveDurationHour(mapper.tryToGet(EmployeeLeave.class, LEAVE_DURATION_HOUR_PROPERTY, int.class,
        0, true, result.getLeaveDurationHour(), params));
    result.setRemark(mapper.tryToGet(EmployeeLeave.class, REMARK_PROPERTY, String.class,
        0, true, result.getRemark(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixEmployeeLeave(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      EmployeeLeaveTokens tokens = mapper.findParamByClass(params, EmployeeLeaveTokens.class);
      if (tokens == null) {
        tokens = EmployeeLeaveTokens.start();
      }
      result = userContext.getManagerGroup().getEmployeeLeaveManager().internalSaveEmployeeLeave(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("EmployeeLeave{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getWho() != null ){
 			stringBuilder.append("\twho='Employee("+getWho().getId()+")';");
 		}
		if(getType() != null ){
 			stringBuilder.append("\ttype='LeaveType("+getType().getId()+")';");
 		}
		stringBuilder.append("\tleaveDurationHour='"+getLeaveDurationHour()+"';");
		stringBuilder.append("\tremark='"+getRemark()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	
	public void increaseLeaveDurationHour(int incLeaveDurationHour){
		updateLeaveDurationHour(this.leaveDurationHour +  incLeaveDurationHour);
	}
	public void decreaseLeaveDurationHour(int decLeaveDurationHour){
		updateLeaveDurationHour(this.leaveDurationHour - decLeaveDurationHour);
	}
	

}

