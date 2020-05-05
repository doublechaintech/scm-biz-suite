
package com.doublechaintech.retailscm.quicklink;

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
import com.doublechaintech.retailscm.userapp.UserApp;

@JsonSerialize(using = QuickLinkSerializer.class)
public class QuickLink extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String ICON_PROPERTY                  = "icon"              ;
	public static final String IMAGE_PATH_PROPERTY            = "imagePath"         ;
	public static final String LINK_TARGET_PROPERTY           = "linkTarget"        ;
	public static final String CREATE_TIME_PROPERTY           = "createTime"        ;
	public static final String APP_PROPERTY                   = "app"               ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="QuickLink";
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
	protected		String              	mIcon               ;
	protected		String              	mImagePath          ;
	protected		String              	mLinkTarget         ;
	protected		DateTime            	mCreateTime         ;
	protected		UserApp             	mApp                ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	QuickLink(){
		// lazy load for all the properties
	}
	public 	static QuickLink withId(String id){
		QuickLink quickLink = new QuickLink();
		quickLink.setId(id);
		quickLink.setVersion(Integer.MAX_VALUE);
		return quickLink;
	}
	public 	static QuickLink refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setApp( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(ICON_PROPERTY.equals(property)){
			changeIconProperty(newValueExpr);
		}
		if(IMAGE_PATH_PROPERTY.equals(property)){
			changeImagePathProperty(newValueExpr);
		}
		if(LINK_TARGET_PROPERTY.equals(property)){
			changeLinkTargetProperty(newValueExpr);
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			changeCreateTimeProperty(newValueExpr);
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
			
			
			
	protected void changeIconProperty(String newValueExpr){
	
		String oldValue = getIcon();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateIcon(newValue);
		this.onChangeProperty(ICON_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeImagePathProperty(String newValueExpr){
	
		String oldValue = getImagePath();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateImagePath(newValue);
		this.onChangeProperty(IMAGE_PATH_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeLinkTargetProperty(String newValueExpr){
	
		String oldValue = getLinkTarget();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLinkTarget(newValue);
		this.onChangeProperty(LINK_TARGET_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeCreateTimeProperty(String newValueExpr){
	
		DateTime oldValue = getCreateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCreateTime(newValue);
		this.onChangeProperty(CREATE_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(ICON_PROPERTY.equals(property)){
			return getIcon();
		}
		if(IMAGE_PATH_PROPERTY.equals(property)){
			return getImagePath();
		}
		if(LINK_TARGET_PROPERTY.equals(property)){
			return getLinkTarget();
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			return getCreateTime();
		}
		if(APP_PROPERTY.equals(property)){
			return getApp();
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
	public QuickLink updateId(String id){
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
	public QuickLink updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setIcon(String icon){
		this.mIcon = trimString(icon);;
	}
	public String getIcon(){
		return this.mIcon;
	}
	public QuickLink updateIcon(String icon){
		this.mIcon = trimString(icon);;
		this.changed = true;
		return this;
	}
	public void mergeIcon(String icon){
		if(icon != null) { setIcon(icon);}
	}
	
	
	public void setImagePath(String imagePath){
		this.mImagePath = trimString(encodeUrl(imagePath));;
	}
	public String getImagePath(){
		return this.mImagePath;
	}
	public QuickLink updateImagePath(String imagePath){
		this.mImagePath = trimString(encodeUrl(imagePath));;
		this.changed = true;
		return this;
	}
	public void mergeImagePath(String imagePath){
		if(imagePath != null) { setImagePath(imagePath);}
	}
	
	
	public void setLinkTarget(String linkTarget){
		this.mLinkTarget = trimString(linkTarget);;
	}
	public String getLinkTarget(){
		return this.mLinkTarget;
	}
	public QuickLink updateLinkTarget(String linkTarget){
		this.mLinkTarget = trimString(linkTarget);;
		this.changed = true;
		return this;
	}
	public void mergeLinkTarget(String linkTarget){
		if(linkTarget != null) { setLinkTarget(linkTarget);}
	}
	
	
	public void setCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
	}
	public DateTime getCreateTime(){
		return this.mCreateTime;
	}
	public QuickLink updateCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
		this.changed = true;
		return this;
	}
	public void mergeCreateTime(DateTime createTime){
		setCreateTime(createTime);
	}
	
	
	public void setApp(UserApp app){
		this.mApp = app;;
	}
	public UserApp getApp(){
		return this.mApp;
	}
	public QuickLink updateApp(UserApp app){
		this.mApp = app;;
		this.changed = true;
		return this;
	}
	public void mergeApp(UserApp app){
		if(app != null) { setApp(app);}
	}
	
	
	public void clearApp(){
		setApp ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public QuickLink updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
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
		appendKeyValuePair(result, ICON_PROPERTY, getIcon());
		appendKeyValuePair(result, IMAGE_PATH_PROPERTY, getImagePath());
		appendKeyValuePair(result, LINK_TARGET_PROPERTY, getLinkTarget());
		appendKeyValuePair(result, CREATE_TIME_PROPERTY, getCreateTime());
		appendKeyValuePair(result, APP_PROPERTY, getApp());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof QuickLink){
		
		
			QuickLink dest =(QuickLink)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setIcon(getIcon());
			dest.setImagePath(getImagePath());
			dest.setLinkTarget(getLinkTarget());
			dest.setCreateTime(getCreateTime());
			dest.setApp(getApp());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof QuickLink){
		
			
			QuickLink dest =(QuickLink)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeIcon(getIcon());
			dest.mergeImagePath(getImagePath());
			dest.mergeLinkTarget(getLinkTarget());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeApp(getApp());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof QuickLink){
		
			
			QuickLink dest =(QuickLink)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeIcon(getIcon());
			dest.mergeImagePath(getImagePath());
			dest.mergeLinkTarget(getLinkTarget());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getIcon(), getImagePath(), getLinkTarget(), getCreateTime(), getApp(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("QuickLink{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\ticon='"+getIcon()+"';");
		stringBuilder.append("\timagePath='"+getImagePath()+"';");
		stringBuilder.append("\tlinkTarget='"+getLinkTarget()+"';");
		stringBuilder.append("\tcreateTime='"+getCreateTime()+"';");
		if(getApp() != null ){
 			stringBuilder.append("\tapp='UserApp("+getApp().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

