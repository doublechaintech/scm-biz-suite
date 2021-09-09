
package com.doublechaintech.retailscm.mobileapp;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
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


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(PAGE_LIST, "mobileApp", "页面列表")
        .withType("page", Page.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(PAGE_TYPE_LIST, "mobileApp", "页面类型列表")
        .withType("page_type", PageType.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(PAGE_LIST, "mobileApp");
    	
    	    refers.put(PAGE_TYPE_LIST, "mobileApp");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(PAGE_LIST, Page.class);
        	
        	    refers.put(PAGE_TYPE_LIST, PageType.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    
    return parents;
  }

  public MobileApp want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public MobileApp wants(Class<? extends BaseEntity>... classes) {
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
	protected		int                 	version             ;

	
	protected		SmartList<Page>     	mPageList           ;
	protected		SmartList<PageType> 	mPageTypeList       ;



	public 	MobileApp(){
		// lazy load for all the properties
	}
	public 	static MobileApp withId(String id){
		MobileApp mobileApp = new MobileApp();
		mobileApp.setId(id);
		mobileApp.setVersion(Integer.MAX_VALUE);
		mobileApp.setChecked(true);
		return mobileApp;
	}
	public 	static MobileApp refById(String id){
		return withId(id);
	}

  public MobileApp limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public MobileApp limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static MobileApp searchExample(){
    MobileApp mobileApp = new MobileApp();
    		mobileApp.setVersion(UNSET_INT);

    return mobileApp;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
		setChecked(false);
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

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public MobileApp updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public MobileApp orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public MobileApp ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public MobileApp addIdCriteria(QueryOperator operator, Object... parameters){
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
	public MobileApp updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public MobileApp orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public MobileApp ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public MobileApp addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public MobileApp updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public MobileApp orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public MobileApp ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public MobileApp addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
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

  public  SmartList<Page> pageList(){
    
    doLoadChild(PAGE_LIST);
    
    return getPageList();
  }


	public  void setPageList(SmartList<Page> pageList){
		for( Page page:pageList){
			page.setMobileApp(this);
		}

		this.mPageList = pageList;
		this.mPageList.setListInternalName (PAGE_LIST );

	}

	public  MobileApp addPage(Page page){
		page.setMobileApp(this);
		getPageList().add(page);
		return this;
	}
	public  MobileApp addPageList(SmartList<Page> pageList){
		for( Page page:pageList){
			page.setMobileApp(this);
		}
		getPageList().addAll(pageList);
		return this;
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

  public  SmartList<PageType> pageTypeList(){
    
    doLoadChild(PAGE_TYPE_LIST);
    
    return getPageTypeList();
  }


	public  void setPageTypeList(SmartList<PageType> pageTypeList){
		for( PageType pageType:pageTypeList){
			pageType.setMobileApp(this);
		}

		this.mPageTypeList = pageTypeList;
		this.mPageTypeList.setListInternalName (PAGE_TYPE_LIST );

	}

	public  MobileApp addPageType(PageType pageType){
		pageType.setMobileApp(this);
		getPageTypeList().add(pageType);
		return this;
	}
	public  MobileApp addPageTypeList(SmartList<PageType> pageTypeList){
		for( PageType pageType:pageTypeList){
			pageType.setMobileApp(this);
		}
		getPageTypeList().addAll(pageTypeList);
		return this;
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


	public static MobileApp createWith(RetailscmUserContext userContext, ThrowingFunction<MobileApp,MobileApp,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<MobileApp> customCreator = mapper.findCustomCreator(MobileApp.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    MobileApp result = new MobileApp();
    result.setName(mapper.tryToGet(MobileApp.class, NAME_PROPERTY, String.class,
        0, true, result.getName(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixMobileApp(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      MobileAppTokens tokens = mapper.findParamByClass(params, MobileAppTokens.class);
      if (tokens == null) {
        tokens = MobileAppTokens.start();
      }
      result = userContext.getManagerGroup().getMobileAppManager().internalSaveMobileApp(userContext, result, tokens.done());
      
    }
    return result;
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

