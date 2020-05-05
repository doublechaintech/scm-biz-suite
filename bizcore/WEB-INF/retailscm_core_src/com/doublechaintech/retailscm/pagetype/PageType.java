
package com.doublechaintech.retailscm.pagetype;

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
import com.doublechaintech.retailscm.mobileapp.MobileApp;
import com.doublechaintech.retailscm.page.Page;

@JsonSerialize(using = PageTypeSerializer.class)
public class PageType extends BaseEntity implements  java.io.Serializable{

	public static final String HOME = "home";	// 首页
	public static final String ME = "me";	// 我的
	public static final String GENERIC_PAGE = "generic-page";	// Generic Page
	public static final String LISTOF_PAGE = "listof-page";	// Listof Page
	public static final String SERVICE_CENTER = "service-center";	// 功能大厅
	public static final String SIMPLE = "simple";	// 普通
	public static List<KeyValuePair> CODE_NAME_LIST;
	static {
		CODE_NAME_LIST = new ArrayList<>();

		CODE_NAME_LIST.add(new KeyValuePair(HOME, "首页"));
		CODE_NAME_LIST.add(new KeyValuePair(ME, "我的"));
		CODE_NAME_LIST.add(new KeyValuePair(GENERIC_PAGE, "Generic Page"));
		CODE_NAME_LIST.add(new KeyValuePair(LISTOF_PAGE, "Listof Page"));
		CODE_NAME_LIST.add(new KeyValuePair(SERVICE_CENTER, "功能大厅"));
		CODE_NAME_LIST.add(new KeyValuePair(SIMPLE, "普通"));
	}
	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String MOBILE_APP_PROPERTY            = "mobileApp"         ;
	public static final String FOOTER_TAB_PROPERTY            = "footerTab"         ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String PAGE_LIST                                = "pageList"          ;

	public static final String INTERNAL_TYPE="PageType";
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
	protected		String              	mCode               ;
	protected		MobileApp           	mMobileApp          ;
	protected		boolean             	mFooterTab          ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Page>     	mPageList           ;

	
		
	public 	PageType(){
		// lazy load for all the properties
	}
	public 	static PageType withId(String id){
		PageType pageType = new PageType();
		pageType.setId(id);
		pageType.setVersion(Integer.MAX_VALUE);
		return pageType;
	}
	public 	static PageType refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setMobileApp( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(CODE_PROPERTY.equals(property)){
			changeCodeProperty(newValueExpr);
		}
		if(FOOTER_TAB_PROPERTY.equals(property)){
			changeFooterTabProperty(newValueExpr);
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
			
			
			
	protected void changeFooterTabProperty(String newValueExpr){
	
		boolean oldValue = getFooterTab();
		boolean newValue = parseBoolean(newValueExpr);
		if(equalsBoolean(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateFooterTab(newValue);
		this.onChangeProperty(FOOTER_TAB_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(CODE_PROPERTY.equals(property)){
			return getCode();
		}
		if(MOBILE_APP_PROPERTY.equals(property)){
			return getMobileApp();
		}
		if(FOOTER_TAB_PROPERTY.equals(property)){
			return getFooterTab();
		}
		if(PAGE_LIST.equals(property)){
			List<BaseEntity> list = getPageList().stream().map(item->item).collect(Collectors.toList());
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
	public PageType updateId(String id){
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
	public PageType updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setCode(String code){
		this.mCode = trimString(code);;
	}
	public String getCode(){
		return this.mCode;
	}
	public PageType updateCode(String code){
		this.mCode = trimString(code);;
		this.changed = true;
		return this;
	}
	public void mergeCode(String code){
		if(code != null) { setCode(code);}
	}
	
	
	public void setMobileApp(MobileApp mobileApp){
		this.mMobileApp = mobileApp;;
	}
	public MobileApp getMobileApp(){
		return this.mMobileApp;
	}
	public PageType updateMobileApp(MobileApp mobileApp){
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
	
	public void setFooterTab(boolean footerTab){
		this.mFooterTab = footerTab;;
	}
	public boolean getFooterTab(){
		return this.mFooterTab;
	}
	public PageType updateFooterTab(boolean footerTab){
		this.mFooterTab = footerTab;;
		this.changed = true;
		return this;
	}
	public void mergeFooterTab(boolean footerTab){
		setFooterTab(footerTab);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public PageType updateVersion(int version){
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
			page.setPageType(this);
		}

		this.mPageList = pageList;
		this.mPageList.setListInternalName (PAGE_LIST );
		
	}
	
	public  void addPage(Page page){
		page.setPageType(this);
		getPageList().add(page);
	}
	public  void addPageList(SmartList<Page> pageList){
		for( Page page:pageList){
			page.setPageType(this);
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
        // page.clearPageType(); //disconnect with PageType
        page.clearFromAll(); //disconnect with PageType
		
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
		page.setPageType(null);
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
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getMobileApp(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getPageList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getPageList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, CODE_PROPERTY, getCode());
		appendKeyValuePair(result, MOBILE_APP_PROPERTY, getMobileApp());
		appendKeyValuePair(result, FOOTER_TAB_PROPERTY, getFooterTab());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, PAGE_LIST, getPageList());
		if(!getPageList().isEmpty()){
			appendKeyValuePair(result, "pageCount", getPageList().getTotalCount());
			appendKeyValuePair(result, "pageCurrentPageNumber", getPageList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof PageType){
		
		
			PageType dest =(PageType)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setCode(getCode());
			dest.setMobileApp(getMobileApp());
			dest.setFooterTab(getFooterTab());
			dest.setVersion(getVersion());
			dest.setPageList(getPageList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof PageType){
		
			
			PageType dest =(PageType)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCode(getCode());
			dest.mergeMobileApp(getMobileApp());
			dest.mergeFooterTab(getFooterTab());
			dest.mergeVersion(getVersion());
			dest.mergePageList(getPageList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof PageType){
		
			
			PageType dest =(PageType)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCode(getCode());
			dest.mergeFooterTab(getFooterTab());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getCode(), getMobileApp(), getFooterTab(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("PageType{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		if(getMobileApp() != null ){
 			stringBuilder.append("\tmobileApp='MobileApp("+getMobileApp().getId()+")';");
 		}
		stringBuilder.append("\tfooterTab='"+getFooterTab()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

