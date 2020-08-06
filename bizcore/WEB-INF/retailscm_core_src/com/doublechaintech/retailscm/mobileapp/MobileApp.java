
package com.doublechaintech.retailscm.mobileapp;

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
import com.doublechaintech.retailscm.pagetype.PageType;
import com.doublechaintech.retailscm.page.Page;









@JsonSerialize(using = MobileAppSerializer.class)
public class MobileApp extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String PAGE_LIST                                = "pageList"          ;
	public static final String PAGE_TYPE_LIST                           = "pageTypeList"      ;

	public static final String INTERNAL_TYPE="MobileApp";
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
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Page>     	mPageList           ;
	protected		SmartList<PageType> 	mPageTypeList       ;

	
		
	public 	MobileApp(){
		// lazy load for all the properties
	}
	public 	static MobileApp withId(String id){
		MobileApp mobileApp = new MobileApp();
		mobileApp.setId(id);
		mobileApp.setVersion(Integer.MAX_VALUE);
		return mobileApp;
	}
	public 	static MobileApp refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
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
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(PAGE_LIST.equals(property)){
			List<BaseEntity> list = getPageList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(PAGE_TYPE_LIST.equals(property)){
			List<BaseEntity> list = getPageTypeList().stream().map(item->item).collect(Collectors.toList());
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
	public MobileApp updateId(String id){
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
	public MobileApp updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public MobileApp updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<Page> getPageList(){
		if(this.mPageList == null){
			this.mPageList = new SmartList<Page>();
			this.mPageList.setListInternalName (PAGE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mPageList;	
	}
	public  void setPageList(SmartList<Page> pageList){
		for( Page page:pageList){
			page.setMobileApp(this);
		}

		this.mPageList = pageList;
		this.mPageList.setListInternalName (PAGE_LIST );
		
	}
	
	public  void addPage(Page page){
		page.setMobileApp(this);
		getPageList().add(page);
	}
	public  void addPageList(SmartList<Page> pageList){
		for( Page page:pageList){
			page.setMobileApp(this);
		}
		getPageList().addAll(pageList);
	}
	public  void mergePageList(SmartList<Page> pageList){
		if(pageList==null){
			return;
		}
		if(pageList.isEmpty()){
			return;
		}
		addPageList( pageList );
		
	}
	public  Page removePage(Page pageIndex){
		
		int index = getPageList().indexOf(pageIndex);
        if(index < 0){
        	String message = "Page("+pageIndex.getId()+") with version='"+pageIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Page page = getPageList().get(index);        
        // page.clearMobileApp(); //disconnect with MobileApp
        page.clearFromAll(); //disconnect with MobileApp
		
		boolean result = getPageList().planToRemove(page);
        if(!result){
        	String message = "Page("+pageIndex.getId()+") with version='"+pageIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return page;
        
	
	}
	//断舍离
	public  void breakWithPage(Page page){
		
		if(page == null){
			return;
		}
		page.setMobileApp(null);
		//getPageList().remove();
	
	}
	
	public  boolean hasPage(Page page){
	
		return getPageList().contains(page);
  
	}
	
	public void copyPageFrom(Page page) {

		Page pageInList = findThePage(page);
		Page newPage = new Page();
		pageInList.copyTo(newPage);
		newPage.setVersion(0);//will trigger copy
		getPageList().add(newPage);
		addItemToFlexiableObject(COPIED_CHILD, newPage);
	}
	
	public  Page findThePage(Page page){
		
		int index =  getPageList().indexOf(page);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Page("+page.getId()+") with version='"+page.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getPageList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpPageList(){
		getPageList().clear();
	}
	
	
	


	public  SmartList<PageType> getPageTypeList(){
		if(this.mPageTypeList == null){
			this.mPageTypeList = new SmartList<PageType>();
			this.mPageTypeList.setListInternalName (PAGE_TYPE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mPageTypeList;	
	}
	public  void setPageTypeList(SmartList<PageType> pageTypeList){
		for( PageType pageType:pageTypeList){
			pageType.setMobileApp(this);
		}

		this.mPageTypeList = pageTypeList;
		this.mPageTypeList.setListInternalName (PAGE_TYPE_LIST );
		
	}
	
	public  void addPageType(PageType pageType){
		pageType.setMobileApp(this);
		getPageTypeList().add(pageType);
	}
	public  void addPageTypeList(SmartList<PageType> pageTypeList){
		for( PageType pageType:pageTypeList){
			pageType.setMobileApp(this);
		}
		getPageTypeList().addAll(pageTypeList);
	}
	public  void mergePageTypeList(SmartList<PageType> pageTypeList){
		if(pageTypeList==null){
			return;
		}
		if(pageTypeList.isEmpty()){
			return;
		}
		addPageTypeList( pageTypeList );
		
	}
	public  PageType removePageType(PageType pageTypeIndex){
		
		int index = getPageTypeList().indexOf(pageTypeIndex);
        if(index < 0){
        	String message = "PageType("+pageTypeIndex.getId()+") with version='"+pageTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        PageType pageType = getPageTypeList().get(index);        
        // pageType.clearMobileApp(); //disconnect with MobileApp
        pageType.clearFromAll(); //disconnect with MobileApp
		
		boolean result = getPageTypeList().planToRemove(pageType);
        if(!result){
        	String message = "PageType("+pageTypeIndex.getId()+") with version='"+pageTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return pageType;
        
	
	}
	//断舍离
	public  void breakWithPageType(PageType pageType){
		
		if(pageType == null){
			return;
		}
		pageType.setMobileApp(null);
		//getPageTypeList().remove();
	
	}
	
	public  boolean hasPageType(PageType pageType){
	
		return getPageTypeList().contains(pageType);
  
	}
	
	public void copyPageTypeFrom(PageType pageType) {

		PageType pageTypeInList = findThePageType(pageType);
		PageType newPageType = new PageType();
		pageTypeInList.copyTo(newPageType);
		newPageType.setVersion(0);//will trigger copy
		getPageTypeList().add(newPageType);
		addItemToFlexiableObject(COPIED_CHILD, newPageType);
	}
	
	public  PageType findThePageType(PageType pageType){
		
		int index =  getPageTypeList().indexOf(pageType);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "PageType("+pageType.getId()+") with version='"+pageType.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getPageTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpPageTypeList(){
		getPageTypeList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getPageList(), internalType);
		collectFromList(this, entityList, getPageTypeList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getPageList());
		listOfList.add( getPageTypeList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, PAGE_LIST, getPageList());
		if(!getPageList().isEmpty()){
			appendKeyValuePair(result, "pageCount", getPageList().getTotalCount());
			appendKeyValuePair(result, "pageCurrentPageNumber", getPageList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, PAGE_TYPE_LIST, getPageTypeList());
		if(!getPageTypeList().isEmpty()){
			appendKeyValuePair(result, "pageTypeCount", getPageTypeList().getTotalCount());
			appendKeyValuePair(result, "pageTypeCurrentPageNumber", getPageTypeList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof MobileApp){
		
		
			MobileApp dest =(MobileApp)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setVersion(getVersion());
			dest.setPageList(getPageList());
			dest.setPageTypeList(getPageTypeList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof MobileApp){
		
			
			MobileApp dest =(MobileApp)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeVersion(getVersion());
			dest.mergePageList(getPageList());
			dest.mergePageTypeList(getPageTypeList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof MobileApp){
		
			
			MobileApp dest =(MobileApp)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("MobileApp{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

