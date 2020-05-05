
package com.doublechaintech.retailscm.slide;

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

@JsonSerialize(using = SlideSerializer.class)
public class Slide extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String DISPLAY_ORDER_PROPERTY         = "displayOrder"      ;
	public static final String IMAGE_URL_PROPERTY             = "imageUrl"          ;
	public static final String VIDEO_URL_PROPERTY             = "videoUrl"          ;
	public static final String LINK_TO_URL_PROPERTY           = "linkToUrl"         ;
	public static final String PAGE_PROPERTY                  = "page"              ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="Slide";
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
	protected		int                 	mDisplayOrder       ;
	protected		String              	mImageUrl           ;
	protected		String              	mVideoUrl           ;
	protected		String              	mLinkToUrl          ;
	protected		Page                	mPage               ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	Slide(){
		// lazy load for all the properties
	}
	public 	static Slide withId(String id){
		Slide slide = new Slide();
		slide.setId(id);
		slide.setVersion(Integer.MAX_VALUE);
		return slide;
	}
	public 	static Slide refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPage( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(DISPLAY_ORDER_PROPERTY.equals(property)){
			changeDisplayOrderProperty(newValueExpr);
		}
		if(IMAGE_URL_PROPERTY.equals(property)){
			changeImageUrlProperty(newValueExpr);
		}
		if(VIDEO_URL_PROPERTY.equals(property)){
			changeVideoUrlProperty(newValueExpr);
		}
		if(LINK_TO_URL_PROPERTY.equals(property)){
			changeLinkToUrlProperty(newValueExpr);
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
			
			
			
	protected void changeVideoUrlProperty(String newValueExpr){
	
		String oldValue = getVideoUrl();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateVideoUrl(newValue);
		this.onChangeProperty(VIDEO_URL_PROPERTY, oldValue, newValue);
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
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(DISPLAY_ORDER_PROPERTY.equals(property)){
			return getDisplayOrder();
		}
		if(IMAGE_URL_PROPERTY.equals(property)){
			return getImageUrl();
		}
		if(VIDEO_URL_PROPERTY.equals(property)){
			return getVideoUrl();
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
	public Slide updateId(String id){
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
	public Slide updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setDisplayOrder(int displayOrder){
		this.mDisplayOrder = displayOrder;;
	}
	public int getDisplayOrder(){
		return this.mDisplayOrder;
	}
	public Slide updateDisplayOrder(int displayOrder){
		this.mDisplayOrder = displayOrder;;
		this.changed = true;
		return this;
	}
	public void mergeDisplayOrder(int displayOrder){
		setDisplayOrder(displayOrder);
	}
	
	
	public void setImageUrl(String imageUrl){
		this.mImageUrl = trimString(encodeUrl(imageUrl));;
	}
	public String getImageUrl(){
		return this.mImageUrl;
	}
	public Slide updateImageUrl(String imageUrl){
		this.mImageUrl = trimString(encodeUrl(imageUrl));;
		this.changed = true;
		return this;
	}
	public void mergeImageUrl(String imageUrl){
		if(imageUrl != null) { setImageUrl(imageUrl);}
	}
	
	
	public void setVideoUrl(String videoUrl){
		this.mVideoUrl = trimString(encodeUrl(videoUrl));;
	}
	public String getVideoUrl(){
		return this.mVideoUrl;
	}
	public Slide updateVideoUrl(String videoUrl){
		this.mVideoUrl = trimString(encodeUrl(videoUrl));;
		this.changed = true;
		return this;
	}
	public void mergeVideoUrl(String videoUrl){
		if(videoUrl != null) { setVideoUrl(videoUrl);}
	}
	
	
	public void setLinkToUrl(String linkToUrl){
		this.mLinkToUrl = trimString(linkToUrl);;
	}
	public String getLinkToUrl(){
		return this.mLinkToUrl;
	}
	public Slide updateLinkToUrl(String linkToUrl){
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
	public Slide updatePage(Page page){
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
	public Slide updateVersion(int version){
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
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, DISPLAY_ORDER_PROPERTY, getDisplayOrder());
		appendKeyValuePair(result, IMAGE_URL_PROPERTY, getImageUrl());
		appendKeyValuePair(result, VIDEO_URL_PROPERTY, getVideoUrl());
		appendKeyValuePair(result, LINK_TO_URL_PROPERTY, getLinkToUrl());
		appendKeyValuePair(result, PAGE_PROPERTY, getPage());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Slide){
		
		
			Slide dest =(Slide)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setDisplayOrder(getDisplayOrder());
			dest.setImageUrl(getImageUrl());
			dest.setVideoUrl(getVideoUrl());
			dest.setLinkToUrl(getLinkToUrl());
			dest.setPage(getPage());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Slide){
		
			
			Slide dest =(Slide)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeDisplayOrder(getDisplayOrder());
			dest.mergeImageUrl(getImageUrl());
			dest.mergeVideoUrl(getVideoUrl());
			dest.mergeLinkToUrl(getLinkToUrl());
			dest.mergePage(getPage());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Slide){
		
			
			Slide dest =(Slide)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeDisplayOrder(getDisplayOrder());
			dest.mergeImageUrl(getImageUrl());
			dest.mergeVideoUrl(getVideoUrl());
			dest.mergeLinkToUrl(getLinkToUrl());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getDisplayOrder(), getImageUrl(), getVideoUrl(), getLinkToUrl(), getPage(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Slide{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tdisplayOrder='"+getDisplayOrder()+"';");
		stringBuilder.append("\timageUrl='"+getImageUrl()+"';");
		stringBuilder.append("\tvideoUrl='"+getVideoUrl()+"';");
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

