
package com.doublechaintech.retailscm.listaccess;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.userapp.UserApp;









@JsonSerialize(using = ListAccessSerializer.class)
public class ListAccess extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String INTERNAL_NAME_PROPERTY         = "internalName"      ;
	public static final String READ_PERMISSION_PROPERTY       = "readPermission"    ;
	public static final String CREATE_PERMISSION_PROPERTY     = "createPermission"  ;
	public static final String DELETE_PERMISSION_PROPERTY     = "deletePermission"  ;
	public static final String UPDATE_PERMISSION_PROPERTY     = "updatePermission"  ;
	public static final String EXECUTION_PERMISSION_PROPERTY  = "executionPermission";
	public static final String APP_PROPERTY                   = "app"               ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="ListAccess";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(INTERNAL_NAME_PROPERTY, "internal_name", "内部名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(READ_PERMISSION_PROPERTY, "read_permission", "可读")
        .withType("bool", "boolean"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CREATE_PERMISSION_PROPERTY, "create_permission", "可创建")
        .withType("bool", "boolean"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(DELETE_PERMISSION_PROPERTY, "delete_permission", "可删除")
        .withType("bool", "boolean"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(UPDATE_PERMISSION_PROPERTY, "update_permission", "可更新")
        .withType("bool", "boolean"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(EXECUTION_PERMISSION_PROPERTY, "execution_permission", "可执行")
        .withType("bool", "boolean"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(APP_PROPERTY, "user_app", "应用")
        .withType("user_app", UserApp.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,INTERNAL_NAME_PROPERTY ,READ_PERMISSION_PROPERTY ,CREATE_PERMISSION_PROPERTY ,DELETE_PERMISSION_PROPERTY ,UPDATE_PERMISSION_PROPERTY ,EXECUTION_PERMISSION_PROPERTY ,APP_PROPERTY ,VERSION_PROPERTY};
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
    parents.put(APP_PROPERTY, UserApp.class);

    return parents;
  }

  public ListAccess want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public ListAccess wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		String              	name                ;
	protected		String              	internalName        ;
	protected		boolean             	readPermission      ;
	protected		boolean             	createPermission    ;
	protected		boolean             	deletePermission    ;
	protected		boolean             	updatePermission    ;
	protected		boolean             	executionPermission ;
	protected		UserApp             	app                 ;
	protected		int                 	version             ;

	



	public 	ListAccess(){
		// lazy load for all the properties
	}
	public 	static ListAccess withId(String id){
		ListAccess listAccess = new ListAccess();
		listAccess.setId(id);
		listAccess.setVersion(Integer.MAX_VALUE);
		listAccess.setChecked(true);
		return listAccess;
	}
	public 	static ListAccess refById(String id){
		return withId(id);
	}

  public ListAccess limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public ListAccess limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static ListAccess searchExample(){
    ListAccess listAccess = new ListAccess();
    		listAccess.setVersion(UNSET_INT);

    return listAccess;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setApp( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(INTERNAL_NAME_PROPERTY.equals(property)){
			changeInternalNameProperty(newValueExpr);
		}
		if(READ_PERMISSION_PROPERTY.equals(property)){
			changeReadPermissionProperty(newValueExpr);
		}
		if(CREATE_PERMISSION_PROPERTY.equals(property)){
			changeCreatePermissionProperty(newValueExpr);
		}
		if(DELETE_PERMISSION_PROPERTY.equals(property)){
			changeDeletePermissionProperty(newValueExpr);
		}
		if(UPDATE_PERMISSION_PROPERTY.equals(property)){
			changeUpdatePermissionProperty(newValueExpr);
		}
		if(EXECUTION_PERMISSION_PROPERTY.equals(property)){
			changeExecutionPermissionProperty(newValueExpr);
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
			
			
			
	protected void changeInternalNameProperty(String newValueExpr){
	
		String oldValue = getInternalName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateInternalName(newValue);
		this.onChangeProperty(INTERNAL_NAME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeReadPermissionProperty(String newValueExpr){
	
		boolean oldValue = getReadPermission();
		boolean newValue = parseBoolean(newValueExpr);
		if(equalsBoolean(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateReadPermission(newValue);
		this.onChangeProperty(READ_PERMISSION_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeCreatePermissionProperty(String newValueExpr){
	
		boolean oldValue = getCreatePermission();
		boolean newValue = parseBoolean(newValueExpr);
		if(equalsBoolean(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCreatePermission(newValue);
		this.onChangeProperty(CREATE_PERMISSION_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeDeletePermissionProperty(String newValueExpr){
	
		boolean oldValue = getDeletePermission();
		boolean newValue = parseBoolean(newValueExpr);
		if(equalsBoolean(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDeletePermission(newValue);
		this.onChangeProperty(DELETE_PERMISSION_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeUpdatePermissionProperty(String newValueExpr){
	
		boolean oldValue = getUpdatePermission();
		boolean newValue = parseBoolean(newValueExpr);
		if(equalsBoolean(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateUpdatePermission(newValue);
		this.onChangeProperty(UPDATE_PERMISSION_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeExecutionPermissionProperty(String newValueExpr){
	
		boolean oldValue = getExecutionPermission();
		boolean newValue = parseBoolean(newValueExpr);
		if(equalsBoolean(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateExecutionPermission(newValue);
		this.onChangeProperty(EXECUTION_PERMISSION_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {

		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(INTERNAL_NAME_PROPERTY.equals(property)){
			return getInternalName();
		}
		if(READ_PERMISSION_PROPERTY.equals(property)){
			return getReadPermission();
		}
		if(CREATE_PERMISSION_PROPERTY.equals(property)){
			return getCreatePermission();
		}
		if(DELETE_PERMISSION_PROPERTY.equals(property)){
			return getDeletePermission();
		}
		if(UPDATE_PERMISSION_PROPERTY.equals(property)){
			return getUpdatePermission();
		}
		if(EXECUTION_PERMISSION_PROPERTY.equals(property)){
			return getExecutionPermission();
		}
		if(APP_PROPERTY.equals(property)){
			return getApp();
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
	public ListAccess updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public ListAccess orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public ListAccess ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public ListAccess addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setName(String name){String oldName = this.name;String newName = trimString(name);this.name = newName;}
	public String name(){
doLoad();
return getName();
}
	public String getName(){
		return this.name;
	}
	public ListAccess updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public ListAccess orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public ListAccess ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public ListAccess addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setInternalName(String internalName){String oldInternalName = this.internalName;String newInternalName = trimString(internalName);this.internalName = newInternalName;}
	public String internalName(){
doLoad();
return getInternalName();
}
	public String getInternalName(){
		return this.internalName;
	}
	public ListAccess updateInternalName(String internalName){String oldInternalName = this.internalName;String newInternalName = trimString(internalName);if(!shouldReplaceBy(newInternalName, oldInternalName)){return this;}this.internalName = newInternalName;addPropertyChange(INTERNAL_NAME_PROPERTY, oldInternalName, newInternalName);this.changed = true;setChecked(false);return this;}
	public ListAccess orderByInternalName(boolean asc){
doAddOrderBy(INTERNAL_NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createInternalNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(INTERNAL_NAME_PROPERTY, operator, parameters);
}
	public ListAccess ignoreInternalNameCriteria(){super.ignoreSearchProperty(INTERNAL_NAME_PROPERTY);
return this;
}
	public ListAccess addInternalNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createInternalNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeInternalName(String internalName){
		if(internalName != null) { setInternalName(internalName);}
	}

	
	public void setReadPermission(boolean readPermission){boolean oldReadPermission = this.readPermission;boolean newReadPermission = readPermission;this.readPermission = newReadPermission;}
	public boolean readPermission(){
doLoad();
return getReadPermission();
}
	public boolean getReadPermission(){
		return this.readPermission;
	}
	public ListAccess updateReadPermission(boolean readPermission){boolean oldReadPermission = this.readPermission;boolean newReadPermission = readPermission;if(!shouldReplaceBy(newReadPermission, oldReadPermission)){return this;}this.readPermission = newReadPermission;addPropertyChange(READ_PERMISSION_PROPERTY, oldReadPermission, newReadPermission);this.changed = true;setChecked(false);return this;}
	public ListAccess orderByReadPermission(boolean asc){
doAddOrderBy(READ_PERMISSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createReadPermissionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(READ_PERMISSION_PROPERTY, operator, parameters);
}
	public ListAccess ignoreReadPermissionCriteria(){super.ignoreSearchProperty(READ_PERMISSION_PROPERTY);
return this;
}
	public ListAccess addReadPermissionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createReadPermissionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeReadPermission(boolean readPermission){
		setReadPermission(readPermission);
	}

	
	public void setCreatePermission(boolean createPermission){boolean oldCreatePermission = this.createPermission;boolean newCreatePermission = createPermission;this.createPermission = newCreatePermission;}
	public boolean createPermission(){
doLoad();
return getCreatePermission();
}
	public boolean getCreatePermission(){
		return this.createPermission;
	}
	public ListAccess updateCreatePermission(boolean createPermission){boolean oldCreatePermission = this.createPermission;boolean newCreatePermission = createPermission;if(!shouldReplaceBy(newCreatePermission, oldCreatePermission)){return this;}this.createPermission = newCreatePermission;addPropertyChange(CREATE_PERMISSION_PROPERTY, oldCreatePermission, newCreatePermission);this.changed = true;setChecked(false);return this;}
	public ListAccess orderByCreatePermission(boolean asc){
doAddOrderBy(CREATE_PERMISSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createCreatePermissionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CREATE_PERMISSION_PROPERTY, operator, parameters);
}
	public ListAccess ignoreCreatePermissionCriteria(){super.ignoreSearchProperty(CREATE_PERMISSION_PROPERTY);
return this;
}
	public ListAccess addCreatePermissionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCreatePermissionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCreatePermission(boolean createPermission){
		setCreatePermission(createPermission);
	}

	
	public void setDeletePermission(boolean deletePermission){boolean oldDeletePermission = this.deletePermission;boolean newDeletePermission = deletePermission;this.deletePermission = newDeletePermission;}
	public boolean deletePermission(){
doLoad();
return getDeletePermission();
}
	public boolean getDeletePermission(){
		return this.deletePermission;
	}
	public ListAccess updateDeletePermission(boolean deletePermission){boolean oldDeletePermission = this.deletePermission;boolean newDeletePermission = deletePermission;if(!shouldReplaceBy(newDeletePermission, oldDeletePermission)){return this;}this.deletePermission = newDeletePermission;addPropertyChange(DELETE_PERMISSION_PROPERTY, oldDeletePermission, newDeletePermission);this.changed = true;setChecked(false);return this;}
	public ListAccess orderByDeletePermission(boolean asc){
doAddOrderBy(DELETE_PERMISSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createDeletePermissionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(DELETE_PERMISSION_PROPERTY, operator, parameters);
}
	public ListAccess ignoreDeletePermissionCriteria(){super.ignoreSearchProperty(DELETE_PERMISSION_PROPERTY);
return this;
}
	public ListAccess addDeletePermissionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createDeletePermissionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeDeletePermission(boolean deletePermission){
		setDeletePermission(deletePermission);
	}

	
	public void setUpdatePermission(boolean updatePermission){boolean oldUpdatePermission = this.updatePermission;boolean newUpdatePermission = updatePermission;this.updatePermission = newUpdatePermission;}
	public boolean updatePermission(){
doLoad();
return getUpdatePermission();
}
	public boolean getUpdatePermission(){
		return this.updatePermission;
	}
	public ListAccess updateUpdatePermission(boolean updatePermission){boolean oldUpdatePermission = this.updatePermission;boolean newUpdatePermission = updatePermission;if(!shouldReplaceBy(newUpdatePermission, oldUpdatePermission)){return this;}this.updatePermission = newUpdatePermission;addPropertyChange(UPDATE_PERMISSION_PROPERTY, oldUpdatePermission, newUpdatePermission);this.changed = true;setChecked(false);return this;}
	public ListAccess orderByUpdatePermission(boolean asc){
doAddOrderBy(UPDATE_PERMISSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createUpdatePermissionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(UPDATE_PERMISSION_PROPERTY, operator, parameters);
}
	public ListAccess ignoreUpdatePermissionCriteria(){super.ignoreSearchProperty(UPDATE_PERMISSION_PROPERTY);
return this;
}
	public ListAccess addUpdatePermissionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createUpdatePermissionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeUpdatePermission(boolean updatePermission){
		setUpdatePermission(updatePermission);
	}

	
	public void setExecutionPermission(boolean executionPermission){boolean oldExecutionPermission = this.executionPermission;boolean newExecutionPermission = executionPermission;this.executionPermission = newExecutionPermission;}
	public boolean executionPermission(){
doLoad();
return getExecutionPermission();
}
	public boolean getExecutionPermission(){
		return this.executionPermission;
	}
	public ListAccess updateExecutionPermission(boolean executionPermission){boolean oldExecutionPermission = this.executionPermission;boolean newExecutionPermission = executionPermission;if(!shouldReplaceBy(newExecutionPermission, oldExecutionPermission)){return this;}this.executionPermission = newExecutionPermission;addPropertyChange(EXECUTION_PERMISSION_PROPERTY, oldExecutionPermission, newExecutionPermission);this.changed = true;setChecked(false);return this;}
	public ListAccess orderByExecutionPermission(boolean asc){
doAddOrderBy(EXECUTION_PERMISSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createExecutionPermissionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(EXECUTION_PERMISSION_PROPERTY, operator, parameters);
}
	public ListAccess ignoreExecutionPermissionCriteria(){super.ignoreSearchProperty(EXECUTION_PERMISSION_PROPERTY);
return this;
}
	public ListAccess addExecutionPermissionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createExecutionPermissionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeExecutionPermission(boolean executionPermission){
		setExecutionPermission(executionPermission);
	}

	
	public void setApp(UserApp app){UserApp oldApp = this.app;UserApp newApp = app;this.app = newApp;}
	public UserApp app(){
doLoad();
return getApp();
}
	public UserApp getApp(){
		return this.app;
	}
	public ListAccess updateApp(UserApp app){UserApp oldApp = this.app;UserApp newApp = app;if(!shouldReplaceBy(newApp, oldApp)){return this;}this.app = newApp;addPropertyChange(APP_PROPERTY, oldApp, newApp);this.changed = true;setChecked(false);return this;}
	public ListAccess orderByApp(boolean asc){
doAddOrderBy(APP_PROPERTY, asc);
return this;
}
	public SearchCriteria createAppCriteria(QueryOperator operator, Object... parameters){
return createCriteria(APP_PROPERTY, operator, parameters);
}
	public ListAccess ignoreAppCriteria(){super.ignoreSearchProperty(APP_PROPERTY);
return this;
}
	public ListAccess addAppCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createAppCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeApp(UserApp app){
		if(app != null) { setApp(app);}
	}

	
	public void clearApp(){
		setApp ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public ListAccess updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public ListAccess orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public ListAccess ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public ListAccess addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getApp(), internalType);


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
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, INTERNAL_NAME_PROPERTY, getInternalName());
		appendKeyValuePair(result, READ_PERMISSION_PROPERTY, getReadPermission());
		appendKeyValuePair(result, CREATE_PERMISSION_PROPERTY, getCreatePermission());
		appendKeyValuePair(result, DELETE_PERMISSION_PROPERTY, getDeletePermission());
		appendKeyValuePair(result, UPDATE_PERMISSION_PROPERTY, getUpdatePermission());
		appendKeyValuePair(result, EXECUTION_PERMISSION_PROPERTY, getExecutionPermission());
		appendKeyValuePair(result, APP_PROPERTY, getApp());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof ListAccess){


			ListAccess dest =(ListAccess)baseDest;

			dest.setId(getId());
			dest.setName(getName());
			dest.setInternalName(getInternalName());
			dest.setReadPermission(getReadPermission());
			dest.setCreatePermission(getCreatePermission());
			dest.setDeletePermission(getDeletePermission());
			dest.setUpdatePermission(getUpdatePermission());
			dest.setExecutionPermission(getExecutionPermission());
			dest.setApp(getApp());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof ListAccess){


			ListAccess dest =(ListAccess)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeInternalName(getInternalName());
			dest.mergeReadPermission(getReadPermission());
			dest.mergeCreatePermission(getCreatePermission());
			dest.mergeDeletePermission(getDeletePermission());
			dest.mergeUpdatePermission(getUpdatePermission());
			dest.mergeExecutionPermission(getExecutionPermission());
			dest.mergeApp(getApp());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof ListAccess){


			ListAccess dest =(ListAccess)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeInternalName(getInternalName());
			dest.mergeReadPermission(getReadPermission());
			dest.mergeCreatePermission(getCreatePermission());
			dest.mergeDeletePermission(getDeletePermission());
			dest.mergeUpdatePermission(getUpdatePermission());
			dest.mergeExecutionPermission(getExecutionPermission());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getInternalName(), getReadPermission(), getCreatePermission(), getDeletePermission(), getUpdatePermission(), getExecutionPermission(), getApp(), getVersion()};
	}


	public static ListAccess createWith(RetailscmUserContext userContext, ThrowingFunction<ListAccess,ListAccess,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<ListAccess> customCreator = mapper.findCustomCreator(ListAccess.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    ListAccess result = new ListAccess();
    result.setName(mapper.tryToGet(ListAccess.class, NAME_PROPERTY, String.class,
        0, false, result.getName(), params));
    result.setInternalName(mapper.tryToGet(ListAccess.class, INTERNAL_NAME_PROPERTY, String.class,
        1, false, result.getInternalName(), params));
    result.setReadPermission(mapper.tryToGet(ListAccess.class, READ_PERMISSION_PROPERTY, boolean.class,
        0, false, result.getReadPermission(), params));
    result.setCreatePermission(mapper.tryToGet(ListAccess.class, CREATE_PERMISSION_PROPERTY, boolean.class,
        1, false, result.getCreatePermission(), params));
    result.setDeletePermission(mapper.tryToGet(ListAccess.class, DELETE_PERMISSION_PROPERTY, boolean.class,
        2, false, result.getDeletePermission(), params));
    result.setUpdatePermission(mapper.tryToGet(ListAccess.class, UPDATE_PERMISSION_PROPERTY, boolean.class,
        3, false, result.getUpdatePermission(), params));
    result.setExecutionPermission(mapper.tryToGet(ListAccess.class, EXECUTION_PERMISSION_PROPERTY, boolean.class,
        4, false, result.getExecutionPermission(), params));
    result.setApp(mapper.tryToGet(ListAccess.class, APP_PROPERTY, UserApp.class,
        0, true, result.getApp(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixListAccess(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      ListAccessTokens tokens = mapper.findParamByClass(params, ListAccessTokens.class);
      if (tokens == null) {
        tokens = ListAccessTokens.start();
      }
      result = userContext.getManagerGroup().getListAccessManager().internalSaveListAccess(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ListAccess{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tinternalName='"+getInternalName()+"';");
		stringBuilder.append("\treadPermission='"+getReadPermission()+"';");
		stringBuilder.append("\tcreatePermission='"+getCreatePermission()+"';");
		stringBuilder.append("\tdeletePermission='"+getDeletePermission()+"';");
		stringBuilder.append("\tupdatePermission='"+getUpdatePermission()+"';");
		stringBuilder.append("\texecutionPermission='"+getExecutionPermission()+"';");
		if(getApp() != null ){
 			stringBuilder.append("\tapp='UserApp("+getApp().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

