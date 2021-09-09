
package com.doublechaintech.retailscm.userapp;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.quicklink.QuickLink;
import com.doublechaintech.retailscm.listaccess.ListAccess;
import com.doublechaintech.retailscm.secuser.SecUser;









@JsonSerialize(using = UserAppSerializer.class)
public class UserApp extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String SEC_USER_PROPERTY              = "secUser"           ;
	public static final String APP_ICON_PROPERTY              = "appIcon"           ;
	public static final String FULL_ACCESS_PROPERTY           = "fullAccess"        ;
	public static final String PERMISSION_PROPERTY            = "permission"        ;
	public static final String APP_TYPE_PROPERTY              = "appType"           ;
	public static final String APP_ID_PROPERTY                = "appId"             ;
	public static final String CTX_TYPE_PROPERTY              = "ctxType"           ;
	public static final String CTX_ID_PROPERTY                = "ctxId"             ;
	public static final String LOCATION_PROPERTY              = "location"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String QUICK_LINK_LIST                          = "quickLinkList"     ;
	public static final String LIST_ACCESS_LIST                         = "listAccessList"    ;

	public static final String INTERNAL_TYPE="UserApp";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(TITLE_PROPERTY, "title", "标题")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(SEC_USER_PROPERTY, "sec_user", "系统用户")
        .withType("sec_user", SecUser.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(APP_ICON_PROPERTY, "app_icon", "图标")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(FULL_ACCESS_PROPERTY, "full_access", "完全访问")
        .withType("bool", "boolean"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(PERMISSION_PROPERTY, "permission", "权限")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(APP_TYPE_PROPERTY, "app_type", "对象类型")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(APP_ID_PROPERTY, "app_id", "对象ID")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CTX_TYPE_PROPERTY, "ctx_type", "上下文类型")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CTX_ID_PROPERTY, "ctx_id", "上下文类型")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LOCATION_PROPERTY, "location", "位置")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(QUICK_LINK_LIST, "app", "快速链接列表")
        .withType("quick_link", QuickLink.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(LIST_ACCESS_LIST, "app", "访问列表")
        .withType("list_access", ListAccess.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,TITLE_PROPERTY ,SEC_USER_PROPERTY ,APP_ICON_PROPERTY ,FULL_ACCESS_PROPERTY ,PERMISSION_PROPERTY ,APP_TYPE_PROPERTY ,APP_ID_PROPERTY ,CTX_TYPE_PROPERTY ,CTX_ID_PROPERTY ,LOCATION_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(QUICK_LINK_LIST, "app");
    	
    	    refers.put(LIST_ACCESS_LIST, "app");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(QUICK_LINK_LIST, QuickLink.class);
        	
        	    refers.put(LIST_ACCESS_LIST, ListAccess.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(SEC_USER_PROPERTY, SecUser.class);

    return parents;
  }

  public UserApp want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public UserApp wants(Class<? extends BaseEntity>... classes) {
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
	protected		SecUser             	secUser             ;
	protected		String              	appIcon             ;
	protected		boolean             	fullAccess          ;
	protected		String              	permission          ;
	protected		String              	appType             ;
	protected		String              	appId               ;
	protected		String              	ctxType             ;
	protected		String              	ctxId               ;
	protected		String              	location            ;
	protected		int                 	version             ;

	
	protected		SmartList<QuickLink>	mQuickLinkList      ;
	protected		SmartList<ListAccess>	mListAccessList     ;



	public 	UserApp(){
		// lazy load for all the properties
	}
	public 	static UserApp withId(String id){
		UserApp userApp = new UserApp();
		userApp.setId(id);
		userApp.setVersion(Integer.MAX_VALUE);
		userApp.setChecked(true);
		return userApp;
	}
	public 	static UserApp refById(String id){
		return withId(id);
	}

  public UserApp limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public UserApp limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static UserApp searchExample(){
    UserApp userApp = new UserApp();
    		userApp.setVersion(UNSET_INT);

    return userApp;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setSecUser( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(APP_ICON_PROPERTY.equals(property)){
			changeAppIconProperty(newValueExpr);
		}
		if(FULL_ACCESS_PROPERTY.equals(property)){
			changeFullAccessProperty(newValueExpr);
		}
		if(PERMISSION_PROPERTY.equals(property)){
			changePermissionProperty(newValueExpr);
		}
		if(APP_TYPE_PROPERTY.equals(property)){
			changeAppTypeProperty(newValueExpr);
		}
		if(APP_ID_PROPERTY.equals(property)){
			changeAppIdProperty(newValueExpr);
		}
		if(CTX_TYPE_PROPERTY.equals(property)){
			changeCtxTypeProperty(newValueExpr);
		}
		if(CTX_ID_PROPERTY.equals(property)){
			changeCtxIdProperty(newValueExpr);
		}
		if(LOCATION_PROPERTY.equals(property)){
			changeLocationProperty(newValueExpr);
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
			
			
			
	protected void changeAppIconProperty(String newValueExpr){
	
		String oldValue = getAppIcon();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAppIcon(newValue);
		this.onChangeProperty(APP_ICON_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeFullAccessProperty(String newValueExpr){
	
		boolean oldValue = getFullAccess();
		boolean newValue = parseBoolean(newValueExpr);
		if(equalsBoolean(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateFullAccess(newValue);
		this.onChangeProperty(FULL_ACCESS_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changePermissionProperty(String newValueExpr){
	
		String oldValue = getPermission();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePermission(newValue);
		this.onChangeProperty(PERMISSION_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeAppTypeProperty(String newValueExpr){
	
		String oldValue = getAppType();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAppType(newValue);
		this.onChangeProperty(APP_TYPE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeAppIdProperty(String newValueExpr){
	
		String oldValue = getAppId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAppId(newValue);
		this.onChangeProperty(APP_ID_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeCtxTypeProperty(String newValueExpr){
	
		String oldValue = getCtxType();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCtxType(newValue);
		this.onChangeProperty(CTX_TYPE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeCtxIdProperty(String newValueExpr){
	
		String oldValue = getCtxId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCtxId(newValue);
		this.onChangeProperty(CTX_ID_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeLocationProperty(String newValueExpr){
	
		String oldValue = getLocation();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLocation(newValue);
		this.onChangeProperty(LOCATION_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {

		if(TITLE_PROPERTY.equals(property)){
			return getTitle();
		}
		if(SEC_USER_PROPERTY.equals(property)){
			return getSecUser();
		}
		if(APP_ICON_PROPERTY.equals(property)){
			return getAppIcon();
		}
		if(FULL_ACCESS_PROPERTY.equals(property)){
			return getFullAccess();
		}
		if(PERMISSION_PROPERTY.equals(property)){
			return getPermission();
		}
		if(APP_TYPE_PROPERTY.equals(property)){
			return getAppType();
		}
		if(APP_ID_PROPERTY.equals(property)){
			return getAppId();
		}
		if(CTX_TYPE_PROPERTY.equals(property)){
			return getCtxType();
		}
		if(CTX_ID_PROPERTY.equals(property)){
			return getCtxId();
		}
		if(LOCATION_PROPERTY.equals(property)){
			return getLocation();
		}
		if(QUICK_LINK_LIST.equals(property)){
			List<BaseEntity> list = getQuickLinkList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(LIST_ACCESS_LIST.equals(property)){
			List<BaseEntity> list = getListAccessList().stream().map(item->item).collect(Collectors.toList());
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
	public UserApp updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public UserApp orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public UserApp ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public UserApp addIdCriteria(QueryOperator operator, Object... parameters){
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
	public UserApp updateTitle(String title){String oldTitle = this.title;String newTitle = trimString(title);if(!shouldReplaceBy(newTitle, oldTitle)){return this;}this.title = newTitle;addPropertyChange(TITLE_PROPERTY, oldTitle, newTitle);this.changed = true;setChecked(false);return this;}
	public UserApp orderByTitle(boolean asc){
doAddOrderBy(TITLE_PROPERTY, asc);
return this;
}
	public SearchCriteria createTitleCriteria(QueryOperator operator, Object... parameters){
return createCriteria(TITLE_PROPERTY, operator, parameters);
}
	public UserApp ignoreTitleCriteria(){super.ignoreSearchProperty(TITLE_PROPERTY);
return this;
}
	public UserApp addTitleCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createTitleCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeTitle(String title){
		if(title != null) { setTitle(title);}
	}

	
	public void setSecUser(SecUser secUser){SecUser oldSecUser = this.secUser;SecUser newSecUser = secUser;this.secUser = newSecUser;}
	public SecUser secUser(){
doLoad();
return getSecUser();
}
	public SecUser getSecUser(){
		return this.secUser;
	}
	public UserApp updateSecUser(SecUser secUser){SecUser oldSecUser = this.secUser;SecUser newSecUser = secUser;if(!shouldReplaceBy(newSecUser, oldSecUser)){return this;}this.secUser = newSecUser;addPropertyChange(SEC_USER_PROPERTY, oldSecUser, newSecUser);this.changed = true;setChecked(false);return this;}
	public UserApp orderBySecUser(boolean asc){
doAddOrderBy(SEC_USER_PROPERTY, asc);
return this;
}
	public SearchCriteria createSecUserCriteria(QueryOperator operator, Object... parameters){
return createCriteria(SEC_USER_PROPERTY, operator, parameters);
}
	public UserApp ignoreSecUserCriteria(){super.ignoreSearchProperty(SEC_USER_PROPERTY);
return this;
}
	public UserApp addSecUserCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createSecUserCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeSecUser(SecUser secUser){
		if(secUser != null) { setSecUser(secUser);}
	}

	
	public void clearSecUser(){
		setSecUser ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setAppIcon(String appIcon){String oldAppIcon = this.appIcon;String newAppIcon = trimString(appIcon);this.appIcon = newAppIcon;}
	public String appIcon(){
doLoad();
return getAppIcon();
}
	public String getAppIcon(){
		return this.appIcon;
	}
	public UserApp updateAppIcon(String appIcon){String oldAppIcon = this.appIcon;String newAppIcon = trimString(appIcon);if(!shouldReplaceBy(newAppIcon, oldAppIcon)){return this;}this.appIcon = newAppIcon;addPropertyChange(APP_ICON_PROPERTY, oldAppIcon, newAppIcon);this.changed = true;setChecked(false);return this;}
	public UserApp orderByAppIcon(boolean asc){
doAddOrderBy(APP_ICON_PROPERTY, asc);
return this;
}
	public SearchCriteria createAppIconCriteria(QueryOperator operator, Object... parameters){
return createCriteria(APP_ICON_PROPERTY, operator, parameters);
}
	public UserApp ignoreAppIconCriteria(){super.ignoreSearchProperty(APP_ICON_PROPERTY);
return this;
}
	public UserApp addAppIconCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createAppIconCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeAppIcon(String appIcon){
		if(appIcon != null) { setAppIcon(appIcon);}
	}

	
	public void setFullAccess(boolean fullAccess){boolean oldFullAccess = this.fullAccess;boolean newFullAccess = fullAccess;this.fullAccess = newFullAccess;}
	public boolean fullAccess(){
doLoad();
return getFullAccess();
}
	public boolean getFullAccess(){
		return this.fullAccess;
	}
	public UserApp updateFullAccess(boolean fullAccess){boolean oldFullAccess = this.fullAccess;boolean newFullAccess = fullAccess;if(!shouldReplaceBy(newFullAccess, oldFullAccess)){return this;}this.fullAccess = newFullAccess;addPropertyChange(FULL_ACCESS_PROPERTY, oldFullAccess, newFullAccess);this.changed = true;setChecked(false);return this;}
	public UserApp orderByFullAccess(boolean asc){
doAddOrderBy(FULL_ACCESS_PROPERTY, asc);
return this;
}
	public SearchCriteria createFullAccessCriteria(QueryOperator operator, Object... parameters){
return createCriteria(FULL_ACCESS_PROPERTY, operator, parameters);
}
	public UserApp ignoreFullAccessCriteria(){super.ignoreSearchProperty(FULL_ACCESS_PROPERTY);
return this;
}
	public UserApp addFullAccessCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createFullAccessCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeFullAccess(boolean fullAccess){
		setFullAccess(fullAccess);
	}

	
	public void setPermission(String permission){String oldPermission = this.permission;String newPermission = trimString(permission);this.permission = newPermission;}
	public String permission(){
doLoad();
return getPermission();
}
	public String getPermission(){
		return this.permission;
	}
	public UserApp updatePermission(String permission){String oldPermission = this.permission;String newPermission = trimString(permission);if(!shouldReplaceBy(newPermission, oldPermission)){return this;}this.permission = newPermission;addPropertyChange(PERMISSION_PROPERTY, oldPermission, newPermission);this.changed = true;setChecked(false);return this;}
	public UserApp orderByPermission(boolean asc){
doAddOrderBy(PERMISSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createPermissionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(PERMISSION_PROPERTY, operator, parameters);
}
	public UserApp ignorePermissionCriteria(){super.ignoreSearchProperty(PERMISSION_PROPERTY);
return this;
}
	public UserApp addPermissionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createPermissionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergePermission(String permission){
		if(permission != null) { setPermission(permission);}
	}

	
	public void setAppType(String appType){String oldAppType = this.appType;String newAppType = trimString(appType);this.appType = newAppType;}
	public String appType(){
doLoad();
return getAppType();
}
	public String getAppType(){
		return this.appType;
	}
	public UserApp updateAppType(String appType){String oldAppType = this.appType;String newAppType = trimString(appType);if(!shouldReplaceBy(newAppType, oldAppType)){return this;}this.appType = newAppType;addPropertyChange(APP_TYPE_PROPERTY, oldAppType, newAppType);this.changed = true;setChecked(false);return this;}
	public UserApp orderByAppType(boolean asc){
doAddOrderBy(APP_TYPE_PROPERTY, asc);
return this;
}
	public SearchCriteria createAppTypeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(APP_TYPE_PROPERTY, operator, parameters);
}
	public UserApp ignoreAppTypeCriteria(){super.ignoreSearchProperty(APP_TYPE_PROPERTY);
return this;
}
	public UserApp addAppTypeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createAppTypeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeAppType(String appType){
		if(appType != null) { setAppType(appType);}
	}

	
	public void setAppId(String appId){String oldAppId = this.appId;String newAppId = trimString(appId);this.appId = newAppId;}
	public String appId(){
doLoad();
return getAppId();
}
	public String getAppId(){
		return this.appId;
	}
	public UserApp updateAppId(String appId){String oldAppId = this.appId;String newAppId = trimString(appId);if(!shouldReplaceBy(newAppId, oldAppId)){return this;}this.appId = newAppId;addPropertyChange(APP_ID_PROPERTY, oldAppId, newAppId);this.changed = true;setChecked(false);return this;}
	public UserApp orderByAppId(boolean asc){
doAddOrderBy(APP_ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createAppIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(APP_ID_PROPERTY, operator, parameters);
}
	public UserApp ignoreAppIdCriteria(){super.ignoreSearchProperty(APP_ID_PROPERTY);
return this;
}
	public UserApp addAppIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createAppIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeAppId(String appId){
		if(appId != null) { setAppId(appId);}
	}

	
	public void setCtxType(String ctxType){String oldCtxType = this.ctxType;String newCtxType = trimString(ctxType);this.ctxType = newCtxType;}
	public String ctxType(){
doLoad();
return getCtxType();
}
	public String getCtxType(){
		return this.ctxType;
	}
	public UserApp updateCtxType(String ctxType){String oldCtxType = this.ctxType;String newCtxType = trimString(ctxType);if(!shouldReplaceBy(newCtxType, oldCtxType)){return this;}this.ctxType = newCtxType;addPropertyChange(CTX_TYPE_PROPERTY, oldCtxType, newCtxType);this.changed = true;setChecked(false);return this;}
	public UserApp orderByCtxType(boolean asc){
doAddOrderBy(CTX_TYPE_PROPERTY, asc);
return this;
}
	public SearchCriteria createCtxTypeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CTX_TYPE_PROPERTY, operator, parameters);
}
	public UserApp ignoreCtxTypeCriteria(){super.ignoreSearchProperty(CTX_TYPE_PROPERTY);
return this;
}
	public UserApp addCtxTypeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCtxTypeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCtxType(String ctxType){
		if(ctxType != null) { setCtxType(ctxType);}
	}

	
	public void setCtxId(String ctxId){String oldCtxId = this.ctxId;String newCtxId = trimString(ctxId);this.ctxId = newCtxId;}
	public String ctxId(){
doLoad();
return getCtxId();
}
	public String getCtxId(){
		return this.ctxId;
	}
	public UserApp updateCtxId(String ctxId){String oldCtxId = this.ctxId;String newCtxId = trimString(ctxId);if(!shouldReplaceBy(newCtxId, oldCtxId)){return this;}this.ctxId = newCtxId;addPropertyChange(CTX_ID_PROPERTY, oldCtxId, newCtxId);this.changed = true;setChecked(false);return this;}
	public UserApp orderByCtxId(boolean asc){
doAddOrderBy(CTX_ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createCtxIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CTX_ID_PROPERTY, operator, parameters);
}
	public UserApp ignoreCtxIdCriteria(){super.ignoreSearchProperty(CTX_ID_PROPERTY);
return this;
}
	public UserApp addCtxIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCtxIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCtxId(String ctxId){
		if(ctxId != null) { setCtxId(ctxId);}
	}

	
	public void setLocation(String location){String oldLocation = this.location;String newLocation = trimString(location);this.location = newLocation;}
	public String location(){
doLoad();
return getLocation();
}
	public String getLocation(){
		return this.location;
	}
	public UserApp updateLocation(String location){String oldLocation = this.location;String newLocation = trimString(location);if(!shouldReplaceBy(newLocation, oldLocation)){return this;}this.location = newLocation;addPropertyChange(LOCATION_PROPERTY, oldLocation, newLocation);this.changed = true;setChecked(false);return this;}
	public UserApp orderByLocation(boolean asc){
doAddOrderBy(LOCATION_PROPERTY, asc);
return this;
}
	public SearchCriteria createLocationCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LOCATION_PROPERTY, operator, parameters);
}
	public UserApp ignoreLocationCriteria(){super.ignoreSearchProperty(LOCATION_PROPERTY);
return this;
}
	public UserApp addLocationCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createLocationCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeLocation(String location){
		if(location != null) { setLocation(location);}
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public UserApp updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public UserApp orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public UserApp ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public UserApp addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public  SmartList<QuickLink> getQuickLinkList(){
		if(this.mQuickLinkList == null){
			this.mQuickLinkList = new SmartList<QuickLink>();
			this.mQuickLinkList.setListInternalName (QUICK_LINK_LIST );
			//有名字，便于做权限控制
		}

		return this.mQuickLinkList;
	}

  public  SmartList<QuickLink> quickLinkList(){
    
    doLoadChild(QUICK_LINK_LIST);
    
    return getQuickLinkList();
  }


	public  void setQuickLinkList(SmartList<QuickLink> quickLinkList){
		for( QuickLink quickLink:quickLinkList){
			quickLink.setApp(this);
		}

		this.mQuickLinkList = quickLinkList;
		this.mQuickLinkList.setListInternalName (QUICK_LINK_LIST );

	}

	public  UserApp addQuickLink(QuickLink quickLink){
		quickLink.setApp(this);
		getQuickLinkList().add(quickLink);
		return this;
	}
	public  UserApp addQuickLinkList(SmartList<QuickLink> quickLinkList){
		for( QuickLink quickLink:quickLinkList){
			quickLink.setApp(this);
		}
		getQuickLinkList().addAll(quickLinkList);
		return this;
	}
	public  void mergeQuickLinkList(SmartList<QuickLink> quickLinkList){
		if(quickLinkList==null){
			return;
		}
		if(quickLinkList.isEmpty()){
			return;
		}
		addQuickLinkList( quickLinkList );

	}
	public  QuickLink removeQuickLink(QuickLink quickLinkIndex){

		int index = getQuickLinkList().indexOf(quickLinkIndex);
        if(index < 0){
        	String message = "QuickLink("+quickLinkIndex.getId()+") with version='"+quickLinkIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        QuickLink quickLink = getQuickLinkList().get(index);
        // quickLink.clearApp(); //disconnect with App
        quickLink.clearFromAll(); //disconnect with App

		boolean result = getQuickLinkList().planToRemove(quickLink);
        if(!result){
        	String message = "QuickLink("+quickLinkIndex.getId()+") with version='"+quickLinkIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return quickLink;


	}
	//断舍离
	public  void breakWithQuickLink(QuickLink quickLink){

		if(quickLink == null){
			return;
		}
		quickLink.setApp(null);
		//getQuickLinkList().remove();

	}

	public  boolean hasQuickLink(QuickLink quickLink){

		return getQuickLinkList().contains(quickLink);

	}

	public void copyQuickLinkFrom(QuickLink quickLink) {

		QuickLink quickLinkInList = findTheQuickLink(quickLink);
		QuickLink newQuickLink = new QuickLink();
		quickLinkInList.copyTo(newQuickLink);
		newQuickLink.setVersion(0);//will trigger copy
		getQuickLinkList().add(newQuickLink);
		addItemToFlexiableObject(COPIED_CHILD, newQuickLink);
	}

	public  QuickLink findTheQuickLink(QuickLink quickLink){

		int index =  getQuickLinkList().indexOf(quickLink);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "QuickLink("+quickLink.getId()+") with version='"+quickLink.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getQuickLinkList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpQuickLinkList(){
		getQuickLinkList().clear();
	}





	public  SmartList<ListAccess> getListAccessList(){
		if(this.mListAccessList == null){
			this.mListAccessList = new SmartList<ListAccess>();
			this.mListAccessList.setListInternalName (LIST_ACCESS_LIST );
			//有名字，便于做权限控制
		}

		return this.mListAccessList;
	}

  public  SmartList<ListAccess> listAccessList(){
    
    doLoadChild(LIST_ACCESS_LIST);
    
    return getListAccessList();
  }


	public  void setListAccessList(SmartList<ListAccess> listAccessList){
		for( ListAccess listAccess:listAccessList){
			listAccess.setApp(this);
		}

		this.mListAccessList = listAccessList;
		this.mListAccessList.setListInternalName (LIST_ACCESS_LIST );

	}

	public  UserApp addListAccess(ListAccess listAccess){
		listAccess.setApp(this);
		getListAccessList().add(listAccess);
		return this;
	}
	public  UserApp addListAccessList(SmartList<ListAccess> listAccessList){
		for( ListAccess listAccess:listAccessList){
			listAccess.setApp(this);
		}
		getListAccessList().addAll(listAccessList);
		return this;
	}
	public  void mergeListAccessList(SmartList<ListAccess> listAccessList){
		if(listAccessList==null){
			return;
		}
		if(listAccessList.isEmpty()){
			return;
		}
		addListAccessList( listAccessList );

	}
	public  ListAccess removeListAccess(ListAccess listAccessIndex){

		int index = getListAccessList().indexOf(listAccessIndex);
        if(index < 0){
        	String message = "ListAccess("+listAccessIndex.getId()+") with version='"+listAccessIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ListAccess listAccess = getListAccessList().get(index);
        // listAccess.clearApp(); //disconnect with App
        listAccess.clearFromAll(); //disconnect with App

		boolean result = getListAccessList().planToRemove(listAccess);
        if(!result){
        	String message = "ListAccess("+listAccessIndex.getId()+") with version='"+listAccessIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return listAccess;


	}
	//断舍离
	public  void breakWithListAccess(ListAccess listAccess){

		if(listAccess == null){
			return;
		}
		listAccess.setApp(null);
		//getListAccessList().remove();

	}

	public  boolean hasListAccess(ListAccess listAccess){

		return getListAccessList().contains(listAccess);

	}

	public void copyListAccessFrom(ListAccess listAccess) {

		ListAccess listAccessInList = findTheListAccess(listAccess);
		ListAccess newListAccess = new ListAccess();
		listAccessInList.copyTo(newListAccess);
		newListAccess.setVersion(0);//will trigger copy
		getListAccessList().add(newListAccess);
		addItemToFlexiableObject(COPIED_CHILD, newListAccess);
	}

	public  ListAccess findTheListAccess(ListAccess listAccess){

		int index =  getListAccessList().indexOf(listAccess);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ListAccess("+listAccess.getId()+") with version='"+listAccess.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getListAccessList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpListAccessList(){
		getListAccessList().clear();
	}





	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getSecUser(), internalType);


	}

	public List<BaseEntity>  collectRefercencesFromLists(String internalType){

		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getQuickLinkList(), internalType);
		collectFromList(this, entityList, getListAccessList(), internalType);

		return entityList;
	}

	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

		listOfList.add( getQuickLinkList());
		listOfList.add( getListAccessList());


		return listOfList;
	}


	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, TITLE_PROPERTY, getTitle());
		appendKeyValuePair(result, SEC_USER_PROPERTY, getSecUser());
		appendKeyValuePair(result, APP_ICON_PROPERTY, getAppIcon());
		appendKeyValuePair(result, FULL_ACCESS_PROPERTY, getFullAccess());
		appendKeyValuePair(result, PERMISSION_PROPERTY, getPermission());
		appendKeyValuePair(result, APP_TYPE_PROPERTY, getAppType());
		appendKeyValuePair(result, APP_ID_PROPERTY, getAppId());
		appendKeyValuePair(result, CTX_TYPE_PROPERTY, getCtxType());
		appendKeyValuePair(result, CTX_ID_PROPERTY, getCtxId());
		appendKeyValuePair(result, LOCATION_PROPERTY, getLocation());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, QUICK_LINK_LIST, getQuickLinkList());
		if(!getQuickLinkList().isEmpty()){
			appendKeyValuePair(result, "quickLinkCount", getQuickLinkList().getTotalCount());
			appendKeyValuePair(result, "quickLinkCurrentPageNumber", getQuickLinkList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, LIST_ACCESS_LIST, getListAccessList());
		if(!getListAccessList().isEmpty()){
			appendKeyValuePair(result, "listAccessCount", getListAccessList().getTotalCount());
			appendKeyValuePair(result, "listAccessCurrentPageNumber", getListAccessList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof UserApp){


			UserApp dest =(UserApp)baseDest;

			dest.setId(getId());
			dest.setTitle(getTitle());
			dest.setSecUser(getSecUser());
			dest.setAppIcon(getAppIcon());
			dest.setFullAccess(getFullAccess());
			dest.setPermission(getPermission());
			dest.setAppType(getAppType());
			dest.setAppId(getAppId());
			dest.setCtxType(getCtxType());
			dest.setCtxId(getCtxId());
			dest.setLocation(getLocation());
			dest.setVersion(getVersion());
			dest.setQuickLinkList(getQuickLinkList());
			dest.setListAccessList(getListAccessList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof UserApp){


			UserApp dest =(UserApp)baseDest;

			dest.mergeId(getId());
			dest.mergeTitle(getTitle());
			dest.mergeSecUser(getSecUser());
			dest.mergeAppIcon(getAppIcon());
			dest.mergeFullAccess(getFullAccess());
			dest.mergePermission(getPermission());
			dest.mergeAppType(getAppType());
			dest.mergeAppId(getAppId());
			dest.mergeCtxType(getCtxType());
			dest.mergeCtxId(getCtxId());
			dest.mergeLocation(getLocation());
			dest.mergeVersion(getVersion());
			dest.mergeQuickLinkList(getQuickLinkList());
			dest.mergeListAccessList(getListAccessList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof UserApp){


			UserApp dest =(UserApp)baseDest;

			dest.mergeId(getId());
			dest.mergeTitle(getTitle());
			dest.mergeAppIcon(getAppIcon());
			dest.mergeFullAccess(getFullAccess());
			dest.mergePermission(getPermission());
			dest.mergeAppType(getAppType());
			dest.mergeAppId(getAppId());
			dest.mergeCtxType(getCtxType());
			dest.mergeCtxId(getCtxId());
			dest.mergeLocation(getLocation());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getTitle(), getSecUser(), getAppIcon(), getFullAccess(), getPermission(), getAppType(), getAppId(), getCtxType(), getCtxId(), getLocation(), getVersion()};
	}


	public static UserApp createWith(RetailscmUserContext userContext, ThrowingFunction<UserApp,UserApp,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<UserApp> customCreator = mapper.findCustomCreator(UserApp.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    UserApp result = new UserApp();
    result.setTitle(mapper.tryToGet(UserApp.class, TITLE_PROPERTY, String.class,
        0, false, result.getTitle(), params));
    result.setSecUser(mapper.tryToGet(UserApp.class, SEC_USER_PROPERTY, SecUser.class,
        0, true, result.getSecUser(), params));
    result.setAppIcon(mapper.tryToGet(UserApp.class, APP_ICON_PROPERTY, String.class,
        1, false, result.getAppIcon(), params));
    result.setFullAccess(mapper.tryToGet(UserApp.class, FULL_ACCESS_PROPERTY, boolean.class,
        0, true, result.getFullAccess(), params));
    result.setPermission(mapper.tryToGet(UserApp.class, PERMISSION_PROPERTY, String.class,
        2, false, result.getPermission(), params));
    result.setAppType(mapper.tryToGet(UserApp.class, APP_TYPE_PROPERTY, String.class,
        3, false, result.getAppType(), params));
    result.setAppId(mapper.tryToGet(UserApp.class, APP_ID_PROPERTY, String.class,
        4, false, result.getAppId(), params));
    result.setCtxType(mapper.tryToGet(UserApp.class, CTX_TYPE_PROPERTY, String.class,
        5, false, result.getCtxType(), params));
    result.setCtxId(mapper.tryToGet(UserApp.class, CTX_ID_PROPERTY, String.class,
        6, false, result.getCtxId(), params));
    result.setLocation(mapper.tryToGet(UserApp.class, LOCATION_PROPERTY, String.class,
        7, false, result.getLocation(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixUserApp(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      UserAppTokens tokens = mapper.findParamByClass(params, UserAppTokens.class);
      if (tokens == null) {
        tokens = UserAppTokens.start();
      }
      result = userContext.getManagerGroup().getUserAppManager().internalSaveUserApp(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("UserApp{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		if(getSecUser() != null ){
 			stringBuilder.append("\tsecUser='SecUser("+getSecUser().getId()+")';");
 		}
		stringBuilder.append("\tappIcon='"+getAppIcon()+"';");
		stringBuilder.append("\tfullAccess='"+getFullAccess()+"';");
		stringBuilder.append("\tpermission='"+getPermission()+"';");
		stringBuilder.append("\tappType='"+getAppType()+"';");
		stringBuilder.append("\tappId='"+getAppId()+"';");
		stringBuilder.append("\tctxType='"+getCtxType()+"';");
		stringBuilder.append("\tctxId='"+getCtxId()+"';");
		stringBuilder.append("\tlocation='"+getLocation()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

