
package com.doublechaintech.retailscm.uiaction;

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
import com.doublechaintech.retailscm.page.Page;

@JsonSerialize(using = UiActionSerializer.class)
public class UiAction extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String ICON_PROPERTY                  = "icon"              ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String DISPLAY_ORDER_PROPERTY         = "displayOrder"      ;
	public static final String BRIEF_PROPERTY                 = "brief"             ;
	public static final String IMAGE_URL_PROPERTY             = "imageUrl"          ;
	public static final String LINK_TO_URL_PROPERTY           = "linkToUrl"         ;
	public static final String EXTRA_DATA_PROPERTY            = "extraData"         ;
	public static final String PAGE_PROPERTY                  = "page"              ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="UiAction";
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
	protected		String              	mIcon               ;
	protected		String              	mTitle              ;
	protected		int                 	mDisplayOrder       ;
	protected		String              	mBrief              ;
	protected		String              	mImageUrl           ;
	protected		String              	mLinkToUrl          ;
	protected		String              	mExtraData          ;
	protected		Page                	mPage               ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	UiAction(){
		// lazy load for all the properties
	}
	public 	static UiAction withId(String id){
		UiAction uiAction = new UiAction();
		uiAction.setId(id);
		uiAction.setVersion(Integer.MAX_VALUE);
		return uiAction;
	}
	public 	static UiAction refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPage( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(CODE_PROPERTY.equals(property)){
			changeCodeProperty(newValueExpr);
		}
		if(ICON_PROPERTY.equals(property)){
			changeIconProperty(newValueExpr);
		}
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(DISPLAY_ORDER_PROPERTY.equals(property)){
			changeDisplayOrderProperty(newValueExpr);
		}
		if(BRIEF_PROPERTY.equals(property)){
			changeBriefProperty(newValueExpr);
		}
		if(IMAGE_URL_PROPERTY.equals(property)){
			changeImageUrlProperty(newValueExpr);
		}
		if(LINK_TO_URL_PROPERTY.equals(property)){
			changeLinkToUrlProperty(newValueExpr);
		}
		if(EXTRA_DATA_PROPERTY.equals(property)){
			changeExtraDataProperty(newValueExpr);
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
			
			
			
	protected void changeImageUrlProperty(String newValueExpr){
	
		String oldValue = getImageUrl();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateImageUrl(newValue);
		this.onChangeProperty(IMAGE_URL_PROPERTY, oldValue, newValue);
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
			
			
			
	protected void changeExtraDataProperty(String newValueExpr){
	
		String oldValue = getExtraData();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateExtraData(newValue);
		this.onChangeProperty(EXTRA_DATA_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(CODE_PROPERTY.equals(property)){
			return getCode();
		}
		if(ICON_PROPERTY.equals(property)){
			return getIcon();
		}
		if(TITLE_PROPERTY.equals(property)){
			return getTitle();
		}
		if(DISPLAY_ORDER_PROPERTY.equals(property)){
			return getDisplayOrder();
		}
		if(BRIEF_PROPERTY.equals(property)){
			return getBrief();
		}
		if(IMAGE_URL_PROPERTY.equals(property)){
			return getImageUrl();
		}
		if(LINK_TO_URL_PROPERTY.equals(property)){
			return getLinkToUrl();
		}
		if(EXTRA_DATA_PROPERTY.equals(property)){
			return getExtraData();
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
	public UiAction updateId(String id){
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
	public UiAction updateCode(String code){
		this.mCode = trimString(code);;
		this.changed = true;
		return this;
	}
	public void mergeCode(String code){
		if(code != null) { setCode(code);}
	}
	
	
	public void setIcon(String icon){
		this.mIcon = trimString(icon);;
	}
	public String getIcon(){
		return this.mIcon;
	}
	public UiAction updateIcon(String icon){
		this.mIcon = trimString(icon);;
		this.changed = true;
		return this;
	}
	public void mergeIcon(String icon){
		if(icon != null) { setIcon(icon);}
	}
	
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	public UiAction updateTitle(String title){
		this.mTitle = trimString(title);;
		this.changed = true;
		return this;
	}
	public void mergeTitle(String title){
		if(title != null) { setTitle(title);}
	}
	
	
	public void setDisplayOrder(int displayOrder){
		this.mDisplayOrder = displayOrder;;
	}
	public int getDisplayOrder(){
		return this.mDisplayOrder;
	}
	public UiAction updateDisplayOrder(int displayOrder){
		this.mDisplayOrder = displayOrder;;
		this.changed = true;
		return this;
	}
	public void mergeDisplayOrder(int displayOrder){
		setDisplayOrder(displayOrder);
	}
	
	
	public void setBrief(String brief){
		this.mBrief = trimString(brief);;
	}
	public String getBrief(){
		return this.mBrief;
	}
	public UiAction updateBrief(String brief){
		this.mBrief = trimString(brief);;
		this.changed = true;
		return this;
	}
	public void mergeBrief(String brief){
		if(brief != null) { setBrief(brief);}
	}
	
	
	public void setImageUrl(String imageUrl){
		this.mImageUrl = trimString(encodeUrl(imageUrl));;
	}
	public String getImageUrl(){
		return this.mImageUrl;
	}
	public UiAction updateImageUrl(String imageUrl){
		this.mImageUrl = trimString(encodeUrl(imageUrl));;
		this.changed = true;
		return this;
	}
	public void mergeImageUrl(String imageUrl){
		if(imageUrl != null) { setImageUrl(imageUrl);}
	}
	
	
	public void setLinkToUrl(String linkToUrl){
		this.mLinkToUrl = trimString(linkToUrl);;
	}
	public String getLinkToUrl(){
		return this.mLinkToUrl;
	}
	public UiAction updateLinkToUrl(String linkToUrl){
		this.mLinkToUrl = trimString(linkToUrl);;
		this.changed = true;
		return this;
	}
	public void mergeLinkToUrl(String linkToUrl){
		if(linkToUrl != null) { setLinkToUrl(linkToUrl);}
	}
	
	
	public void setExtraData(String extraData){
		this.mExtraData = extraData;;
	}
	public String getExtraData(){
		return this.mExtraData;
	}
	public UiAction updateExtraData(String extraData){
		this.mExtraData = extraData;;
		this.changed = true;
		return this;
	}
	public void mergeExtraData(String extraData){
		if(extraData != null) { setExtraData(extraData);}
	}
	
	
	public void setPage(Page page){
		this.mPage = page;;
	}
	public Page getPage(){
		return this.mPage;
	}
	public UiAction updatePage(Page page){
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
	public UiAction updateVersion(int version){
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
		appendKeyValuePair(result, CODE_PROPERTY, getCode());
		appendKeyValuePair(result, ICON_PROPERTY, getIcon());
		appendKeyValuePair(result, TITLE_PROPERTY, getTitle());
		appendKeyValuePair(result, DISPLAY_ORDER_PROPERTY, getDisplayOrder());
		appendKeyValuePair(result, BRIEF_PROPERTY, getBrief());
		appendKeyValuePair(result, IMAGE_URL_PROPERTY, getImageUrl());
		appendKeyValuePair(result, LINK_TO_URL_PROPERTY, getLinkToUrl());
		appendKeyValuePair(result, EXTRA_DATA_PROPERTY, getExtraData());
		appendKeyValuePair(result, PAGE_PROPERTY, getPage());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof UiAction){
		
		
			UiAction dest =(UiAction)baseDest;
		
			dest.setId(getId());
			dest.setCode(getCode());
			dest.setIcon(getIcon());
			dest.setTitle(getTitle());
			dest.setDisplayOrder(getDisplayOrder());
			dest.setBrief(getBrief());
			dest.setImageUrl(getImageUrl());
			dest.setLinkToUrl(getLinkToUrl());
			dest.setExtraData(getExtraData());
			dest.setPage(getPage());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof UiAction){
		
			
			UiAction dest =(UiAction)baseDest;
		
			dest.mergeId(getId());
			dest.mergeCode(getCode());
			dest.mergeIcon(getIcon());
			dest.mergeTitle(getTitle());
			dest.mergeDisplayOrder(getDisplayOrder());
			dest.mergeBrief(getBrief());
			dest.mergeImageUrl(getImageUrl());
			dest.mergeLinkToUrl(getLinkToUrl());
			dest.mergeExtraData(getExtraData());
			dest.mergePage(getPage());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof UiAction){
		
			
			UiAction dest =(UiAction)baseDest;
		
			dest.mergeId(getId());
			dest.mergeCode(getCode());
			dest.mergeIcon(getIcon());
			dest.mergeTitle(getTitle());
			dest.mergeDisplayOrder(getDisplayOrder());
			dest.mergeBrief(getBrief());
			dest.mergeImageUrl(getImageUrl());
			dest.mergeLinkToUrl(getLinkToUrl());
			dest.mergeExtraData(getExtraData());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getCode(), getIcon(), getTitle(), getDisplayOrder(), getBrief(), getImageUrl(), getLinkToUrl(), getExtraData(), getPage(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("UiAction{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		stringBuilder.append("\ticon='"+getIcon()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		stringBuilder.append("\tdisplayOrder='"+getDisplayOrder()+"';");
		stringBuilder.append("\tbrief='"+getBrief()+"';");
		stringBuilder.append("\timageUrl='"+getImageUrl()+"';");
		stringBuilder.append("\tlinkToUrl='"+getLinkToUrl()+"';");
		stringBuilder.append("\textraData='"+getExtraData()+"';");
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

