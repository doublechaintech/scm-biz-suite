
package com.doublechaintech.retailscm.section;

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
import com.doublechaintech.retailscm.page.Page;









@JsonSerialize(using = SectionSerializer.class)
public class Section extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String BRIEF_PROPERTY                 = "brief"             ;
	public static final String ICON_PROPERTY                  = "icon"              ;
	public static final String DISPLAY_ORDER_PROPERTY         = "displayOrder"      ;
	public static final String VIEW_GROUP_PROPERTY            = "viewGroup"         ;
	public static final String LINK_TO_URL_PROPERTY           = "linkToUrl"         ;
	public static final String PAGE_PROPERTY                  = "page"              ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="Section";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getTitle();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mTitle              ;
	protected		String              	mBrief              ;
	protected		String              	mIcon               ;
	protected		int                 	mDisplayOrder       ;
	protected		String              	mViewGroup          ;
	protected		String              	mLinkToUrl          ;
	protected		Page                	mPage               ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	Section(){
		// lazy load for all the properties
	}
	public 	static Section withId(String id){
		Section section = new Section();
		section.setId(id);
		section.setVersion(Integer.MAX_VALUE);
		return section;
	}
	public 	static Section refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPage( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(BRIEF_PROPERTY.equals(property)){
			changeBriefProperty(newValueExpr);
		}
		if(ICON_PROPERTY.equals(property)){
			changeIconProperty(newValueExpr);
		}
		if(DISPLAY_ORDER_PROPERTY.equals(property)){
			changeDisplayOrderProperty(newValueExpr);
		}
		if(VIEW_GROUP_PROPERTY.equals(property)){
			changeViewGroupProperty(newValueExpr);
		}
		if(LINK_TO_URL_PROPERTY.equals(property)){
			changeLinkToUrlProperty(newValueExpr);
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
			
			
			
	protected void changeBriefProperty(String newValueExpr){
	
		String oldValue = getBrief();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateBrief(newValue);
		this.onChangeProperty(BRIEF_PROPERTY, oldValue, newValue);
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
			
			
			
	protected void changeDisplayOrderProperty(String newValueExpr){
	
		int oldValue = getDisplayOrder();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDisplayOrder(newValue);
		this.onChangeProperty(DISPLAY_ORDER_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeViewGroupProperty(String newValueExpr){
	
		String oldValue = getViewGroup();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateViewGroup(newValue);
		this.onChangeProperty(VIEW_GROUP_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeLinkToUrlProperty(String newValueExpr){
	
		String oldValue = getLinkToUrl();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLinkToUrl(newValue);
		this.onChangeProperty(LINK_TO_URL_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(TITLE_PROPERTY.equals(property)){
			return getTitle();
		}
		if(BRIEF_PROPERTY.equals(property)){
			return getBrief();
		}
		if(ICON_PROPERTY.equals(property)){
			return getIcon();
		}
		if(DISPLAY_ORDER_PROPERTY.equals(property)){
			return getDisplayOrder();
		}
		if(VIEW_GROUP_PROPERTY.equals(property)){
			return getViewGroup();
		}
		if(LINK_TO_URL_PROPERTY.equals(property)){
			return getLinkToUrl();
		}
		if(PAGE_PROPERTY.equals(property)){
			return getPage();
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
	public Section updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	public Section updateTitle(String title){
		this.mTitle = trimString(title);;
		this.changed = true;
		return this;
	}
	public void mergeTitle(String title){
		if(title != null) { setTitle(title);}
	}
	
	
	public void setBrief(String brief){
		this.mBrief = trimString(brief);;
	}
	public String getBrief(){
		return this.mBrief;
	}
	public Section updateBrief(String brief){
		this.mBrief = trimString(brief);;
		this.changed = true;
		return this;
	}
	public void mergeBrief(String brief){
		if(brief != null) { setBrief(brief);}
	}
	
	
	public void setIcon(String icon){
		this.mIcon = trimString(encodeUrl(icon));;
	}
	public String getIcon(){
		return this.mIcon;
	}
	public Section updateIcon(String icon){
		this.mIcon = trimString(encodeUrl(icon));;
		this.changed = true;
		return this;
	}
	public void mergeIcon(String icon){
		if(icon != null) { setIcon(icon);}
	}
	
	
	public void setDisplayOrder(int displayOrder){
		this.mDisplayOrder = displayOrder;;
	}
	public int getDisplayOrder(){
		return this.mDisplayOrder;
	}
	public Section updateDisplayOrder(int displayOrder){
		this.mDisplayOrder = displayOrder;;
		this.changed = true;
		return this;
	}
	public void mergeDisplayOrder(int displayOrder){
		setDisplayOrder(displayOrder);
	}
	
	
	public void setViewGroup(String viewGroup){
		this.mViewGroup = trimString(viewGroup);;
	}
	public String getViewGroup(){
		return this.mViewGroup;
	}
	public Section updateViewGroup(String viewGroup){
		this.mViewGroup = trimString(viewGroup);;
		this.changed = true;
		return this;
	}
	public void mergeViewGroup(String viewGroup){
		if(viewGroup != null) { setViewGroup(viewGroup);}
	}
	
	
	public void setLinkToUrl(String linkToUrl){
		this.mLinkToUrl = trimString(linkToUrl);;
	}
	public String getLinkToUrl(){
		return this.mLinkToUrl;
	}
	public Section updateLinkToUrl(String linkToUrl){
		this.mLinkToUrl = trimString(linkToUrl);;
		this.changed = true;
		return this;
	}
	public void mergeLinkToUrl(String linkToUrl){
		if(linkToUrl != null) { setLinkToUrl(linkToUrl);}
	}
	
	
	public void setPage(Page page){
		this.mPage = page;;
	}
	public Page getPage(){
		return this.mPage;
	}
	public Section updatePage(Page page){
		this.mPage = page;;
		this.changed = true;
		return this;
	}
	public void mergePage(Page page){
		if(page != null) { setPage(page);}
	}
	
	
	public void clearPage(){
		setPage ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Section updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getPage(), internalType);

		
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
		appendKeyValuePair(result, TITLE_PROPERTY, getTitle());
		appendKeyValuePair(result, BRIEF_PROPERTY, getBrief());
		appendKeyValuePair(result, ICON_PROPERTY, getIcon());
		appendKeyValuePair(result, DISPLAY_ORDER_PROPERTY, getDisplayOrder());
		appendKeyValuePair(result, VIEW_GROUP_PROPERTY, getViewGroup());
		appendKeyValuePair(result, LINK_TO_URL_PROPERTY, getLinkToUrl());
		appendKeyValuePair(result, PAGE_PROPERTY, getPage());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Section){
		
		
			Section dest =(Section)baseDest;
		
			dest.setId(getId());
			dest.setTitle(getTitle());
			dest.setBrief(getBrief());
			dest.setIcon(getIcon());
			dest.setDisplayOrder(getDisplayOrder());
			dest.setViewGroup(getViewGroup());
			dest.setLinkToUrl(getLinkToUrl());
			dest.setPage(getPage());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Section){
		
			
			Section dest =(Section)baseDest;
		
			dest.mergeId(getId());
			dest.mergeTitle(getTitle());
			dest.mergeBrief(getBrief());
			dest.mergeIcon(getIcon());
			dest.mergeDisplayOrder(getDisplayOrder());
			dest.mergeViewGroup(getViewGroup());
			dest.mergeLinkToUrl(getLinkToUrl());
			dest.mergePage(getPage());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Section){
		
			
			Section dest =(Section)baseDest;
		
			dest.mergeId(getId());
			dest.mergeTitle(getTitle());
			dest.mergeBrief(getBrief());
			dest.mergeIcon(getIcon());
			dest.mergeDisplayOrder(getDisplayOrder());
			dest.mergeViewGroup(getViewGroup());
			dest.mergeLinkToUrl(getLinkToUrl());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getTitle(), getBrief(), getIcon(), getDisplayOrder(), getViewGroup(), getLinkToUrl(), getPage(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Section{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		stringBuilder.append("\tbrief='"+getBrief()+"';");
		stringBuilder.append("\ticon='"+getIcon()+"';");
		stringBuilder.append("\tdisplayOrder='"+getDisplayOrder()+"';");
		stringBuilder.append("\tviewGroup='"+getViewGroup()+"';");
		stringBuilder.append("\tlinkToUrl='"+getLinkToUrl()+"';");
		if(getPage() != null ){
 			stringBuilder.append("\tpage='Page("+getPage().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseDisplayOrder(int incDisplayOrder){
		updateDisplayOrder(this.mDisplayOrder +  incDisplayOrder);
	}
	public void decreaseDisplayOrder(int decDisplayOrder){
		updateDisplayOrder(this.mDisplayOrder - decDisplayOrder);
	}
	

}

