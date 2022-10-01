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
public class ListAccess extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(ListAccess target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String NAME_PROPERTY = "name";
  public static final String INTERNAL_NAME_PROPERTY = "internalName";
  public static final String READ_PERMISSION_PROPERTY = "readPermission";
  public static final String CREATE_PERMISSION_PROPERTY = "createPermission";
  public static final String DELETE_PERMISSION_PROPERTY = "deletePermission";
  public static final String UPDATE_PERMISSION_PROPERTY = "updatePermission";
  public static final String EXECUTION_PERMISSION_PROPERTY = "executionPermission";
  public static final String APP_PROPERTY = "app";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "ListAccess";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(INTERNAL_NAME_PROPERTY, "internal_name", "内部名称")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(READ_PERMISSION_PROPERTY, "read_permission", "读权限")
            .withType("bool", "boolean"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(CREATE_PERMISSION_PROPERTY, "create_permission", "创建权限")
            .withType("bool", "boolean"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DELETE_PERMISSION_PROPERTY, "delete_permission", "删除权限")
            .withType("bool", "boolean"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(UPDATE_PERMISSION_PROPERTY, "update_permission", "更新权限")
            .withType("bool", "boolean"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(EXECUTION_PERMISSION_PROPERTY, "execution_permission", "执行权限")
            .withType("bool", "boolean"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(APP_PROPERTY, "user_app", "应用程序")
            .withType("user_app", UserApp.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      NAME_PROPERTY,
      INTERNAL_NAME_PROPERTY,
      READ_PERMISSION_PROPERTY,
      CREATE_PERMISSION_PROPERTY,
      DELETE_PERMISSION_PROPERTY,
      UPDATE_PERMISSION_PROPERTY,
      EXECUTION_PERMISSION_PROPERTY,
      APP_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(APP_PROPERTY, UserApp.class);

    return parents;
  }
  /*
  public ListAccess want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public ListAccess wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getName();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String name;
  protected String internalName;
  protected boolean readPermission;
  protected boolean createPermission;
  protected boolean deletePermission;
  protected boolean updatePermission;
  protected boolean executionPermission;
  protected UserApp app;
  protected int version;

  public ListAccess() {
    // lazy load for all the properties
  }

  public static ListAccess withId(String id) {
    ListAccess listAccess = new ListAccess();
    listAccess.setId(id);
    listAccess.setVersion(Integer.MAX_VALUE);
    listAccess.setChecked(true);
    return listAccess;
  }

  public static ListAccess refById(String id) {
    return withId(id);
  }

  public ListAccess limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public ListAccess limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static ListAccess searchExample() {
    ListAccess listAccess = new ListAccess();
    listAccess.setVersion(UNSET_INT);

    return listAccess;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setApp( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (NAME_PROPERTY.equals(property)) {
      changeNameProperty(newValueExpr);
    }
    if (INTERNAL_NAME_PROPERTY.equals(property)) {
      changeInternalNameProperty(newValueExpr);
    }
    if (READ_PERMISSION_PROPERTY.equals(property)) {
      changeReadPermissionProperty(newValueExpr);
    }
    if (CREATE_PERMISSION_PROPERTY.equals(property)) {
      changeCreatePermissionProperty(newValueExpr);
    }
    if (DELETE_PERMISSION_PROPERTY.equals(property)) {
      changeDeletePermissionProperty(newValueExpr);
    }
    if (UPDATE_PERMISSION_PROPERTY.equals(property)) {
      changeUpdatePermissionProperty(newValueExpr);
    }
    if (EXECUTION_PERMISSION_PROPERTY.equals(property)) {
      changeExecutionPermissionProperty(newValueExpr);
    }
  }

  protected void changeNameProperty(String newValueExpr) {

    String oldValue = getName();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateName(newValue);
    this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeInternalNameProperty(String newValueExpr) {

    String oldValue = getInternalName();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateInternalName(newValue);
    this.onChangeProperty(INTERNAL_NAME_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeReadPermissionProperty(String newValueExpr) {

    boolean oldValue = getReadPermission();
    boolean newValue = parseBoolean(newValueExpr);
    if (equalsBoolean(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateReadPermission(newValue);
    this.onChangeProperty(READ_PERMISSION_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeCreatePermissionProperty(String newValueExpr) {

    boolean oldValue = getCreatePermission();
    boolean newValue = parseBoolean(newValueExpr);
    if (equalsBoolean(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateCreatePermission(newValue);
    this.onChangeProperty(CREATE_PERMISSION_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeDeletePermissionProperty(String newValueExpr) {

    boolean oldValue = getDeletePermission();
    boolean newValue = parseBoolean(newValueExpr);
    if (equalsBoolean(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateDeletePermission(newValue);
    this.onChangeProperty(DELETE_PERMISSION_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeUpdatePermissionProperty(String newValueExpr) {

    boolean oldValue = getUpdatePermission();
    boolean newValue = parseBoolean(newValueExpr);
    if (equalsBoolean(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateUpdatePermission(newValue);
    this.onChangeProperty(UPDATE_PERMISSION_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeExecutionPermissionProperty(String newValueExpr) {

    boolean oldValue = getExecutionPermission();
    boolean newValue = parseBoolean(newValueExpr);
    if (equalsBoolean(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateExecutionPermission(newValue);
    this.onChangeProperty(EXECUTION_PERMISSION_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (NAME_PROPERTY.equals(property)) {
      return getName();
    }
    if (INTERNAL_NAME_PROPERTY.equals(property)) {
      return getInternalName();
    }
    if (READ_PERMISSION_PROPERTY.equals(property)) {
      return getReadPermission();
    }
    if (CREATE_PERMISSION_PROPERTY.equals(property)) {
      return getCreatePermission();
    }
    if (DELETE_PERMISSION_PROPERTY.equals(property)) {
      return getDeletePermission();
    }
    if (UPDATE_PERMISSION_PROPERTY.equals(property)) {
      return getUpdatePermission();
    }
    if (EXECUTION_PERMISSION_PROPERTY.equals(property)) {
      return getExecutionPermission();
    }
    if (APP_PROPERTY.equals(property)) {
      return getApp();
    }

    // other property not include here
    return super.propertyOf(property);
  }

  public void setId(String id) {
    String oldId = this.id;
    String newId = trimString(id);
    this.id = newId;
  }

  public String id() {
    doLoad();
    return getId();
  }

  public String getId() {
    return this.id;
  }

  public ListAccess updateId(String id) {
    String oldId = this.id;
    String newId = trimString(id);
    if (!shouldReplaceBy(newId, oldId)) {
      return this;
    }
    this.id = newId;
    if (cn.hutool.core.util.ObjectUtil.equals(newId, oldId)) {
      return this;
    }
    addPropertyChange(ID_PROPERTY, oldId, newId);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public ListAccess orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public ListAccess ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public ListAccess addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setName(String name) {
    String oldName = this.name;
    String newName = trimString(name);
    this.name = newName;
  }

  public String name() {
    doLoad();
    return getName();
  }

  public String getName() {
    return this.name;
  }

  public ListAccess updateName(String name) {
    String oldName = this.name;
    String newName = trimString(name);
    if (!shouldReplaceBy(newName, oldName)) {
      return this;
    }
    this.name = newName;
    if (cn.hutool.core.util.ObjectUtil.equals(newName, oldName)) {
      return this;
    }
    addPropertyChange(NAME_PROPERTY, oldName, newName);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public ListAccess orderByName(boolean asc) {
    doAddOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(NAME_PROPERTY, operator, parameters);
  }

  public ListAccess ignoreNameCriteria() {
    super.ignoreSearchProperty(NAME_PROPERTY);
    return this;
  }

  public ListAccess addNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeName(String name) {
    if (name != null) {
      updateName(name);
    }
  }

  public void setInternalName(String internalName) {
    String oldInternalName = this.internalName;
    String newInternalName = trimString(internalName);
    this.internalName = newInternalName;
  }

  public String internalName() {
    doLoad();
    return getInternalName();
  }

  public String getInternalName() {
    return this.internalName;
  }

  public ListAccess updateInternalName(String internalName) {
    String oldInternalName = this.internalName;
    String newInternalName = trimString(internalName);
    if (!shouldReplaceBy(newInternalName, oldInternalName)) {
      return this;
    }
    this.internalName = newInternalName;
    if (cn.hutool.core.util.ObjectUtil.equals(newInternalName, oldInternalName)) {
      return this;
    }
    addPropertyChange(INTERNAL_NAME_PROPERTY, oldInternalName, newInternalName);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public ListAccess orderByInternalName(boolean asc) {
    doAddOrderBy(INTERNAL_NAME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createInternalNameCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(INTERNAL_NAME_PROPERTY, operator, parameters);
  }

  public ListAccess ignoreInternalNameCriteria() {
    super.ignoreSearchProperty(INTERNAL_NAME_PROPERTY);
    return this;
  }

  public ListAccess addInternalNameCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createInternalNameCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeInternalName(String internalName) {
    if (internalName != null) {
      updateInternalName(internalName);
    }
  }

  public void setReadPermission(boolean readPermission) {
    boolean oldReadPermission = this.readPermission;
    boolean newReadPermission = readPermission;
    this.readPermission = newReadPermission;
  }

  public boolean readPermission() {
    doLoad();
    return getReadPermission();
  }

  public boolean getReadPermission() {
    return this.readPermission;
  }

  public ListAccess updateReadPermission(boolean readPermission) {
    boolean oldReadPermission = this.readPermission;
    boolean newReadPermission = readPermission;
    if (!shouldReplaceBy(newReadPermission, oldReadPermission)) {
      return this;
    }
    this.readPermission = newReadPermission;
    if (cn.hutool.core.util.ObjectUtil.equals(newReadPermission, oldReadPermission)) {
      return this;
    }
    addPropertyChange(READ_PERMISSION_PROPERTY, oldReadPermission, newReadPermission);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public ListAccess orderByReadPermission(boolean asc) {
    doAddOrderBy(READ_PERMISSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createReadPermissionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(READ_PERMISSION_PROPERTY, operator, parameters);
  }

  public ListAccess ignoreReadPermissionCriteria() {
    super.ignoreSearchProperty(READ_PERMISSION_PROPERTY);
    return this;
  }

  public ListAccess addReadPermissionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createReadPermissionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeReadPermission(boolean readPermission) {
    updateReadPermission(readPermission);
  }

  public void setCreatePermission(boolean createPermission) {
    boolean oldCreatePermission = this.createPermission;
    boolean newCreatePermission = createPermission;
    this.createPermission = newCreatePermission;
  }

  public boolean createPermission() {
    doLoad();
    return getCreatePermission();
  }

  public boolean getCreatePermission() {
    return this.createPermission;
  }

  public ListAccess updateCreatePermission(boolean createPermission) {
    boolean oldCreatePermission = this.createPermission;
    boolean newCreatePermission = createPermission;
    if (!shouldReplaceBy(newCreatePermission, oldCreatePermission)) {
      return this;
    }
    this.createPermission = newCreatePermission;
    if (cn.hutool.core.util.ObjectUtil.equals(newCreatePermission, oldCreatePermission)) {
      return this;
    }
    addPropertyChange(CREATE_PERMISSION_PROPERTY, oldCreatePermission, newCreatePermission);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public ListAccess orderByCreatePermission(boolean asc) {
    doAddOrderBy(CREATE_PERMISSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCreatePermissionCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(CREATE_PERMISSION_PROPERTY, operator, parameters);
  }

  public ListAccess ignoreCreatePermissionCriteria() {
    super.ignoreSearchProperty(CREATE_PERMISSION_PROPERTY);
    return this;
  }

  public ListAccess addCreatePermissionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCreatePermissionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCreatePermission(boolean createPermission) {
    updateCreatePermission(createPermission);
  }

  public void setDeletePermission(boolean deletePermission) {
    boolean oldDeletePermission = this.deletePermission;
    boolean newDeletePermission = deletePermission;
    this.deletePermission = newDeletePermission;
  }

  public boolean deletePermission() {
    doLoad();
    return getDeletePermission();
  }

  public boolean getDeletePermission() {
    return this.deletePermission;
  }

  public ListAccess updateDeletePermission(boolean deletePermission) {
    boolean oldDeletePermission = this.deletePermission;
    boolean newDeletePermission = deletePermission;
    if (!shouldReplaceBy(newDeletePermission, oldDeletePermission)) {
      return this;
    }
    this.deletePermission = newDeletePermission;
    if (cn.hutool.core.util.ObjectUtil.equals(newDeletePermission, oldDeletePermission)) {
      return this;
    }
    addPropertyChange(DELETE_PERMISSION_PROPERTY, oldDeletePermission, newDeletePermission);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public ListAccess orderByDeletePermission(boolean asc) {
    doAddOrderBy(DELETE_PERMISSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDeletePermissionCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(DELETE_PERMISSION_PROPERTY, operator, parameters);
  }

  public ListAccess ignoreDeletePermissionCriteria() {
    super.ignoreSearchProperty(DELETE_PERMISSION_PROPERTY);
    return this;
  }

  public ListAccess addDeletePermissionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDeletePermissionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDeletePermission(boolean deletePermission) {
    updateDeletePermission(deletePermission);
  }

  public void setUpdatePermission(boolean updatePermission) {
    boolean oldUpdatePermission = this.updatePermission;
    boolean newUpdatePermission = updatePermission;
    this.updatePermission = newUpdatePermission;
  }

  public boolean updatePermission() {
    doLoad();
    return getUpdatePermission();
  }

  public boolean getUpdatePermission() {
    return this.updatePermission;
  }

  public ListAccess updateUpdatePermission(boolean updatePermission) {
    boolean oldUpdatePermission = this.updatePermission;
    boolean newUpdatePermission = updatePermission;
    if (!shouldReplaceBy(newUpdatePermission, oldUpdatePermission)) {
      return this;
    }
    this.updatePermission = newUpdatePermission;
    if (cn.hutool.core.util.ObjectUtil.equals(newUpdatePermission, oldUpdatePermission)) {
      return this;
    }
    addPropertyChange(UPDATE_PERMISSION_PROPERTY, oldUpdatePermission, newUpdatePermission);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public ListAccess orderByUpdatePermission(boolean asc) {
    doAddOrderBy(UPDATE_PERMISSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createUpdatePermissionCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(UPDATE_PERMISSION_PROPERTY, operator, parameters);
  }

  public ListAccess ignoreUpdatePermissionCriteria() {
    super.ignoreSearchProperty(UPDATE_PERMISSION_PROPERTY);
    return this;
  }

  public ListAccess addUpdatePermissionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createUpdatePermissionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeUpdatePermission(boolean updatePermission) {
    updateUpdatePermission(updatePermission);
  }

  public void setExecutionPermission(boolean executionPermission) {
    boolean oldExecutionPermission = this.executionPermission;
    boolean newExecutionPermission = executionPermission;
    this.executionPermission = newExecutionPermission;
  }

  public boolean executionPermission() {
    doLoad();
    return getExecutionPermission();
  }

  public boolean getExecutionPermission() {
    return this.executionPermission;
  }

  public ListAccess updateExecutionPermission(boolean executionPermission) {
    boolean oldExecutionPermission = this.executionPermission;
    boolean newExecutionPermission = executionPermission;
    if (!shouldReplaceBy(newExecutionPermission, oldExecutionPermission)) {
      return this;
    }
    this.executionPermission = newExecutionPermission;
    if (cn.hutool.core.util.ObjectUtil.equals(newExecutionPermission, oldExecutionPermission)) {
      return this;
    }
    addPropertyChange(
        EXECUTION_PERMISSION_PROPERTY, oldExecutionPermission, newExecutionPermission);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public ListAccess orderByExecutionPermission(boolean asc) {
    doAddOrderBy(EXECUTION_PERMISSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createExecutionPermissionCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(EXECUTION_PERMISSION_PROPERTY, operator, parameters);
  }

  public ListAccess ignoreExecutionPermissionCriteria() {
    super.ignoreSearchProperty(EXECUTION_PERMISSION_PROPERTY);
    return this;
  }

  public ListAccess addExecutionPermissionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createExecutionPermissionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeExecutionPermission(boolean executionPermission) {
    updateExecutionPermission(executionPermission);
  }

  public void setApp(UserApp app) {
    UserApp oldApp = this.app;
    UserApp newApp = app;
    this.app = newApp;
  }

  public UserApp app() {
    doLoad();
    return getApp();
  }

  public UserApp getApp() {
    return this.app;
  }

  public ListAccess updateApp(UserApp app) {
    UserApp oldApp = this.app;
    UserApp newApp = app;
    if (!shouldReplaceBy(newApp, oldApp)) {
      return this;
    }
    this.app = newApp;
    if (cn.hutool.core.util.ObjectUtil.equals(newApp, oldApp)) {
      return this;
    }
    addPropertyChange(APP_PROPERTY, oldApp, newApp);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public ListAccess orderByApp(boolean asc) {
    doAddOrderBy(APP_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createAppCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(APP_PROPERTY, operator, parameters);
  }

  public ListAccess ignoreAppCriteria() {
    super.ignoreSearchProperty(APP_PROPERTY);
    return this;
  }

  public ListAccess addAppCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createAppCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeApp(UserApp app) {
    if (app != null) {
      updateApp(app);
    }
  }

  public ListAccess updateAppByReferenceId(String appId) {
    updateApp(UserApp.refById(appId));
    return this;
  }

  public void clearApp() {
    setApp(null);
    this.changed = true;
    setChecked(false);
  }

  public void setVersion(int version) {
    int oldVersion = this.version;
    int newVersion = version;
    this.version = newVersion;
  }

  public int version() {
    doLoad();
    return getVersion();
  }

  public int getVersion() {
    return this.version;
  }

  public ListAccess updateVersion(int version) {
    int oldVersion = this.version;
    int newVersion = version;
    if (!shouldReplaceBy(newVersion, oldVersion)) {
      return this;
    }
    this.version = newVersion;
    if (cn.hutool.core.util.ObjectUtil.equals(newVersion, oldVersion)) {
      return this;
    }
    addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public ListAccess orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public ListAccess ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public ListAccess addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getApp(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

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

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof ListAccess) {

      ListAccess dest = (ListAccess) baseDest;

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

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof ListAccess) {

      ListAccess source = (ListAccess) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeInternalName(source.getInternalName());
      mergeReadPermission(source.getReadPermission());
      mergeCreatePermission(source.getCreatePermission());
      mergeDeletePermission(source.getDeletePermission());
      mergeUpdatePermission(source.getUpdatePermission());
      mergeExecutionPermission(source.getExecutionPermission());
      mergeApp(source.getApp());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof ListAccess) {

      ListAccess source = (ListAccess) sourceEntity;

      mergeId(source.getId());
      mergeName(source.getName());
      mergeInternalName(source.getInternalName());
      mergeReadPermission(source.getReadPermission());
      mergeCreatePermission(source.getCreatePermission());
      mergeDeletePermission(source.getDeletePermission());
      mergeUpdatePermission(source.getUpdatePermission());
      mergeExecutionPermission(source.getExecutionPermission());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getName(),
      getInternalName(),
      getReadPermission(),
      getCreatePermission(),
      getDeletePermission(),
      getUpdatePermission(),
      getExecutionPermission(),
      getApp(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    ListAccess checkListAccess = Q.listAccessWithIdField().filterById(id).execute(ctx);

    return checkListAccess != null
        && !checkListAccess.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public ListAccess save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("ListAccess{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tname='" + getName() + "';");
    stringBuilder.append("\tinternalName='" + getInternalName() + "';");
    stringBuilder.append("\treadPermission='" + getReadPermission() + "';");
    stringBuilder.append("\tcreatePermission='" + getCreatePermission() + "';");
    stringBuilder.append("\tdeletePermission='" + getDeletePermission() + "';");
    stringBuilder.append("\tupdatePermission='" + getUpdatePermission() + "';");
    stringBuilder.append("\texecutionPermission='" + getExecutionPermission() + "';");
    if (getApp() != null) {
      stringBuilder.append("\tapp='UserApp(" + getApp().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
