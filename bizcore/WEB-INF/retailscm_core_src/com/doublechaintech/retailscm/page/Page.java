
package com.doublechaintech.retailscm.page;

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
import com.doublechaintech.retailscm.slide.Slide;
import com.doublechaintech.retailscm.section.Section;
import com.doublechaintech.retailscm.uiaction.UiAction;
import com.doublechaintech.retailscm.mobileapp.MobileApp;
import com.doublechaintech.retailscm.pagetype.PageType;









@JsonSerialize(using = PageSerializer.class)
public class Page extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String PAGE_TITLE_PROPERTY            = "pageTitle"         ;
	public static final String LINK_TO_URL_PROPERTY           = "linkToUrl"         ;
	public static final String PAGE_TYPE_PROPERTY             = "pageType"          ;
	public static final String DISPLAY_ORDER_PROPERTY         = "displayOrder"      ;
	public static final String MOBILE_APP_PROPERTY            = "mobileApp"         ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String SLIDE_LIST                               = "slideList"         ;
	public static final String UI_ACTION_LIST                           = "uiActionList"      ;
	public static final String SECTION_LIST                             = "sectionList"       ;

	public static final String INTERNAL_TYPE="Page";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getPageTitle();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mPageTitle          ;
	protected		String              	mLinkToUrl          ;
	protected		PageType            	mPageType           ;
	protected		int                 	mDisplayOrder       ;
	protected		MobileApp           	mMobileApp          ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Slide>    	mSlideList          ;
	protected		SmartList<UiAction> 	mUiActionList       ;
	protected		SmartList<Section>  	mSectionList        ;

	
		
	public 	Page(){
		// lazy load for all the properties
	}
	public 	static Page withId(String id){
		Page page = new Page();
		page.setId(id);
		page.setVersion(Integer.MAX_VALUE);
		return page;
	}
	public 	static Page refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPageType( null );
		setMobileApp( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(PAGE_TITLE_PROPERTY.equals(property)){
			changePageTitleProperty(newValueExpr);
		}
		if(LINK_TO_URL_PROPERTY.equals(property)){
			changeLinkToUrlProperty(newValueExpr);
		}
		if(DISPLAY_ORDER_PROPERTY.equals(property)){
			changeDisplayOrderProperty(newValueExpr);
		}

      
	}
    
    
	protected void changePageTitleProperty(String newValueExpr){
	
		String oldValue = getPageTitle();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePageTitle(newValue);
		this.onChangeProperty(PAGE_TITLE_PROPERTY, oldValue, newValue);
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
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(PAGE_TITLE_PROPERTY.equals(property)){
			return getPageTitle();
		}
		if(LINK_TO_URL_PROPERTY.equals(property)){
			return getLinkToUrl();
		}
		if(PAGE_TYPE_PROPERTY.equals(property)){
			return getPageType();
		}
		if(DISPLAY_ORDER_PROPERTY.equals(property)){
			return getDisplayOrder();
		}
		if(MOBILE_APP_PROPERTY.equals(property)){
			return getMobileApp();
		}
		if(SLIDE_LIST.equals(property)){
			List<BaseEntity> list = getSlideList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(UI_ACTION_LIST.equals(property)){
			List<BaseEntity> list = getUiActionList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(SECTION_LIST.equals(property)){
			List<BaseEntity> list = getSectionList().stream().map(item->item).collect(Collectors.toList());
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
	public Page updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setPageTitle(String pageTitle){
		this.mPageTitle = trimString(pageTitle);;
	}
	public String getPageTitle(){
		return this.mPageTitle;
	}
	public Page updatePageTitle(String pageTitle){
		this.mPageTitle = trimString(pageTitle);;
		this.changed = true;
		return this;
	}
	public void mergePageTitle(String pageTitle){
		if(pageTitle != null) { setPageTitle(pageTitle);}
	}
	
	
	public void setLinkToUrl(String linkToUrl){
		this.mLinkToUrl = trimString(linkToUrl);;
	}
	public String getLinkToUrl(){
		return this.mLinkToUrl;
	}
	public Page updateLinkToUrl(String linkToUrl){
		this.mLinkToUrl = trimString(linkToUrl);;
		this.changed = true;
		return this;
	}
	public void mergeLinkToUrl(String linkToUrl){
		if(linkToUrl != null) { setLinkToUrl(linkToUrl);}
	}
	
	
	public void setPageType(PageType pageType){
		this.mPageType = pageType;;
	}
	public PageType getPageType(){
		return this.mPageType;
	}
	public Page updatePageType(PageType pageType){
		this.mPageType = pageType;;
		this.changed = true;
		return this;
	}
	public void mergePageType(PageType pageType){
		if(pageType != null) { setPageType(pageType);}
	}
	
	
	public void clearPageType(){
		setPageType ( null );
		this.changed = true;
	}
	
	public void setDisplayOrder(int displayOrder){
		this.mDisplayOrder = displayOrder;;
	}
	public int getDisplayOrder(){
		return this.mDisplayOrder;
	}
	public Page updateDisplayOrder(int displayOrder){
		this.mDisplayOrder = displayOrder;;
		this.changed = true;
		return this;
	}
	public void mergeDisplayOrder(int displayOrder){
		setDisplayOrder(displayOrder);
	}
	
	
	public void setMobileApp(MobileApp mobileApp){
		this.mMobileApp = mobileApp;;
	}
	public MobileApp getMobileApp(){
		return this.mMobileApp;
	}
	public Page updateMobileApp(MobileApp mobileApp){
		this.mMobileApp = mobileApp;;
		this.changed = true;
		return this;
	}
	public void mergeMobileApp(MobileApp mobileApp){
		if(mobileApp != null) { setMobileApp(mobileApp);}
	}
	
	
	public void clearMobileApp(){
		setMobileApp ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Page updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<Slide> getSlideList(){
		if(this.mSlideList == null){
			this.mSlideList = new SmartList<Slide>();
			this.mSlideList.setListInternalName (SLIDE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mSlideList;	
	}
	public  void setSlideList(SmartList<Slide> slideList){
		for( Slide slide:slideList){
			slide.setPage(this);
		}

		this.mSlideList = slideList;
		this.mSlideList.setListInternalName (SLIDE_LIST );
		
	}
	
	public  void addSlide(Slide slide){
		slide.setPage(this);
		getSlideList().add(slide);
	}
	public  void addSlideList(SmartList<Slide> slideList){
		for( Slide slide:slideList){
			slide.setPage(this);
		}
		getSlideList().addAll(slideList);
	}
	public  void mergeSlideList(SmartList<Slide> slideList){
		if(slideList==null){
			return;
		}
		if(slideList.isEmpty()){
			return;
		}
		addSlideList( slideList );
		
	}
	public  Slide removeSlide(Slide slideIndex){
		
		int index = getSlideList().indexOf(slideIndex);
        if(index < 0){
        	String message = "Slide("+slideIndex.getId()+") with version='"+slideIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Slide slide = getSlideList().get(index);        
        // slide.clearPage(); //disconnect with Page
        slide.clearFromAll(); //disconnect with Page
		
		boolean result = getSlideList().planToRemove(slide);
        if(!result){
        	String message = "Slide("+slideIndex.getId()+") with version='"+slideIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return slide;
        
	
	}
	//断舍离
	public  void breakWithSlide(Slide slide){
		
		if(slide == null){
			return;
		}
		slide.setPage(null);
		//getSlideList().remove();
	
	}
	
	public  boolean hasSlide(Slide slide){
	
		return getSlideList().contains(slide);
  
	}
	
	public void copySlideFrom(Slide slide) {

		Slide slideInList = findTheSlide(slide);
		Slide newSlide = new Slide();
		slideInList.copyTo(newSlide);
		newSlide.setVersion(0);//will trigger copy
		getSlideList().add(newSlide);
		addItemToFlexiableObject(COPIED_CHILD, newSlide);
	}
	
	public  Slide findTheSlide(Slide slide){
		
		int index =  getSlideList().indexOf(slide);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Slide("+slide.getId()+") with version='"+slide.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getSlideList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSlideList(){
		getSlideList().clear();
	}
	
	
	


	public  SmartList<UiAction> getUiActionList(){
		if(this.mUiActionList == null){
			this.mUiActionList = new SmartList<UiAction>();
			this.mUiActionList.setListInternalName (UI_ACTION_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mUiActionList;	
	}
	public  void setUiActionList(SmartList<UiAction> uiActionList){
		for( UiAction uiAction:uiActionList){
			uiAction.setPage(this);
		}

		this.mUiActionList = uiActionList;
		this.mUiActionList.setListInternalName (UI_ACTION_LIST );
		
	}
	
	public  void addUiAction(UiAction uiAction){
		uiAction.setPage(this);
		getUiActionList().add(uiAction);
	}
	public  void addUiActionList(SmartList<UiAction> uiActionList){
		for( UiAction uiAction:uiActionList){
			uiAction.setPage(this);
		}
		getUiActionList().addAll(uiActionList);
	}
	public  void mergeUiActionList(SmartList<UiAction> uiActionList){
		if(uiActionList==null){
			return;
		}
		if(uiActionList.isEmpty()){
			return;
		}
		addUiActionList( uiActionList );
		
	}
	public  UiAction removeUiAction(UiAction uiActionIndex){
		
		int index = getUiActionList().indexOf(uiActionIndex);
        if(index < 0){
        	String message = "UiAction("+uiActionIndex.getId()+") with version='"+uiActionIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        UiAction uiAction = getUiActionList().get(index);        
        // uiAction.clearPage(); //disconnect with Page
        uiAction.clearFromAll(); //disconnect with Page
		
		boolean result = getUiActionList().planToRemove(uiAction);
        if(!result){
        	String message = "UiAction("+uiActionIndex.getId()+") with version='"+uiActionIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return uiAction;
        
	
	}
	//断舍离
	public  void breakWithUiAction(UiAction uiAction){
		
		if(uiAction == null){
			return;
		}
		uiAction.setPage(null);
		//getUiActionList().remove();
	
	}
	
	public  boolean hasUiAction(UiAction uiAction){
	
		return getUiActionList().contains(uiAction);
  
	}
	
	public void copyUiActionFrom(UiAction uiAction) {

		UiAction uiActionInList = findTheUiAction(uiAction);
		UiAction newUiAction = new UiAction();
		uiActionInList.copyTo(newUiAction);
		newUiAction.setVersion(0);//will trigger copy
		getUiActionList().add(newUiAction);
		addItemToFlexiableObject(COPIED_CHILD, newUiAction);
	}
	
	public  UiAction findTheUiAction(UiAction uiAction){
		
		int index =  getUiActionList().indexOf(uiAction);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "UiAction("+uiAction.getId()+") with version='"+uiAction.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getUiActionList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpUiActionList(){
		getUiActionList().clear();
	}
	
	
	


	public  SmartList<Section> getSectionList(){
		if(this.mSectionList == null){
			this.mSectionList = new SmartList<Section>();
			this.mSectionList.setListInternalName (SECTION_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mSectionList;	
	}
	public  void setSectionList(SmartList<Section> sectionList){
		for( Section section:sectionList){
			section.setPage(this);
		}

		this.mSectionList = sectionList;
		this.mSectionList.setListInternalName (SECTION_LIST );
		
	}
	
	public  void addSection(Section section){
		section.setPage(this);
		getSectionList().add(section);
	}
	public  void addSectionList(SmartList<Section> sectionList){
		for( Section section:sectionList){
			section.setPage(this);
		}
		getSectionList().addAll(sectionList);
	}
	public  void mergeSectionList(SmartList<Section> sectionList){
		if(sectionList==null){
			return;
		}
		if(sectionList.isEmpty()){
			return;
		}
		addSectionList( sectionList );
		
	}
	public  Section removeSection(Section sectionIndex){
		
		int index = getSectionList().indexOf(sectionIndex);
        if(index < 0){
        	String message = "Section("+sectionIndex.getId()+") with version='"+sectionIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Section section = getSectionList().get(index);        
        // section.clearPage(); //disconnect with Page
        section.clearFromAll(); //disconnect with Page
		
		boolean result = getSectionList().planToRemove(section);
        if(!result){
        	String message = "Section("+sectionIndex.getId()+") with version='"+sectionIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return section;
        
	
	}
	//断舍离
	public  void breakWithSection(Section section){
		
		if(section == null){
			return;
		}
		section.setPage(null);
		//getSectionList().remove();
	
	}
	
	public  boolean hasSection(Section section){
	
		return getSectionList().contains(section);
  
	}
	
	public void copySectionFrom(Section section) {

		Section sectionInList = findTheSection(section);
		Section newSection = new Section();
		sectionInList.copyTo(newSection);
		newSection.setVersion(0);//will trigger copy
		getSectionList().add(newSection);
		addItemToFlexiableObject(COPIED_CHILD, newSection);
	}
	
	public  Section findTheSection(Section section){
		
		int index =  getSectionList().indexOf(section);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Section("+section.getId()+") with version='"+section.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getSectionList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSectionList(){
		getSectionList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getPageType(), internalType);
		addToEntityList(this, entityList, getMobileApp(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getSlideList(), internalType);
		collectFromList(this, entityList, getUiActionList(), internalType);
		collectFromList(this, entityList, getSectionList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getSlideList());
		listOfList.add( getUiActionList());
		listOfList.add( getSectionList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, PAGE_TITLE_PROPERTY, getPageTitle());
		appendKeyValuePair(result, LINK_TO_URL_PROPERTY, getLinkToUrl());
		appendKeyValuePair(result, PAGE_TYPE_PROPERTY, getPageType());
		appendKeyValuePair(result, DISPLAY_ORDER_PROPERTY, getDisplayOrder());
		appendKeyValuePair(result, MOBILE_APP_PROPERTY, getMobileApp());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, SLIDE_LIST, getSlideList());
		if(!getSlideList().isEmpty()){
			appendKeyValuePair(result, "slideCount", getSlideList().getTotalCount());
			appendKeyValuePair(result, "slideCurrentPageNumber", getSlideList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, UI_ACTION_LIST, getUiActionList());
		if(!getUiActionList().isEmpty()){
			appendKeyValuePair(result, "uiActionCount", getUiActionList().getTotalCount());
			appendKeyValuePair(result, "uiActionCurrentPageNumber", getUiActionList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, SECTION_LIST, getSectionList());
		if(!getSectionList().isEmpty()){
			appendKeyValuePair(result, "sectionCount", getSectionList().getTotalCount());
			appendKeyValuePair(result, "sectionCurrentPageNumber", getSectionList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Page){
		
		
			Page dest =(Page)baseDest;
		
			dest.setId(getId());
			dest.setPageTitle(getPageTitle());
			dest.setLinkToUrl(getLinkToUrl());
			dest.setPageType(getPageType());
			dest.setDisplayOrder(getDisplayOrder());
			dest.setMobileApp(getMobileApp());
			dest.setVersion(getVersion());
			dest.setSlideList(getSlideList());
			dest.setUiActionList(getUiActionList());
			dest.setSectionList(getSectionList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Page){
		
			
			Page dest =(Page)baseDest;
		
			dest.mergeId(getId());
			dest.mergePageTitle(getPageTitle());
			dest.mergeLinkToUrl(getLinkToUrl());
			dest.mergePageType(getPageType());
			dest.mergeDisplayOrder(getDisplayOrder());
			dest.mergeMobileApp(getMobileApp());
			dest.mergeVersion(getVersion());
			dest.mergeSlideList(getSlideList());
			dest.mergeUiActionList(getUiActionList());
			dest.mergeSectionList(getSectionList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Page){
		
			
			Page dest =(Page)baseDest;
		
			dest.mergeId(getId());
			dest.mergePageTitle(getPageTitle());
			dest.mergeLinkToUrl(getLinkToUrl());
			dest.mergeDisplayOrder(getDisplayOrder());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getPageTitle(), getLinkToUrl(), getPageType(), getDisplayOrder(), getMobileApp(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Page{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tpageTitle='"+getPageTitle()+"';");
		stringBuilder.append("\tlinkToUrl='"+getLinkToUrl()+"';");
		if(getPageType() != null ){
 			stringBuilder.append("\tpageType='PageType("+getPageType().getId()+")';");
 		}
		stringBuilder.append("\tdisplayOrder='"+getDisplayOrder()+"';");
		if(getMobileApp() != null ){
 			stringBuilder.append("\tmobileApp='MobileApp("+getMobileApp().getId()+")';");
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

