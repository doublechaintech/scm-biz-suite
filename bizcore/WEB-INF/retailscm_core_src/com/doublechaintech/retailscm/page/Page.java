package com.doublechaintech.retailscm.page;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.slide.Slide;
import com.doublechaintech.retailscm.section.Section;
import com.doublechaintech.retailscm.uiaction.UiAction;
import com.doublechaintech.retailscm.mobileapp.MobileApp;
import com.doublechaintech.retailscm.pagetype.PageType;

@JsonSerialize(using = PageSerializer.class)
public class Page extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(Page target) {
    if (target == null) {
      return;
    }
    target.addSlideList(this.getSlideList());
    target.addUiActionList(this.getUiActionList());
    target.addSectionList(this.getSectionList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String PAGE_TITLE_PROPERTY = "pageTitle";
  public static final String LINK_TO_URL_PROPERTY = "linkToUrl";
  public static final String PAGE_TYPE_PROPERTY = "pageType";
  public static final String DISPLAY_ORDER_PROPERTY = "displayOrder";
  public static final String MOBILE_APP_PROPERTY = "mobileApp";
  public static final String VERSION_PROPERTY = "version";

  public static final String SLIDE_LIST = "slideList";
  public static final String UI_ACTION_LIST = "uiActionList";
  public static final String SECTION_LIST = "sectionList";

  public static final String INTERNAL_TYPE = "Page";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(PAGE_TITLE_PROPERTY, "page_title", "页面标题")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LINK_TO_URL_PROPERTY, "link_to_url", "链接网址")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(PAGE_TYPE_PROPERTY, "page_type", "页面类型")
            .withType("page_type", PageType.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DISPLAY_ORDER_PROPERTY, "display_order", "顺序")
            .withType("int", "int"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(MOBILE_APP_PROPERTY, "mobile_app", "手机应用程序")
            .withType("mobile_app", MobileApp.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(SLIDE_LIST, "page", "幻灯片列表").withType("slide", Slide.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(UI_ACTION_LIST, "page", "Ui动作列表")
            .withType("ui_action", UiAction.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(SECTION_LIST, "page", "部分列表").withType("section", Section.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      PAGE_TITLE_PROPERTY,
      LINK_TO_URL_PROPERTY,
      PAGE_TYPE_PROPERTY,
      DISPLAY_ORDER_PROPERTY,
      MOBILE_APP_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(SLIDE_LIST, "page");

    refers.put(UI_ACTION_LIST, "page");

    refers.put(SECTION_LIST, "page");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(SLIDE_LIST, Slide.class);

    refers.put(UI_ACTION_LIST, UiAction.class);

    refers.put(SECTION_LIST, Section.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(PAGE_TYPE_PROPERTY, PageType.class);
    parents.put(MOBILE_APP_PROPERTY, MobileApp.class);

    return parents;
  }
  /*
  public Page want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public Page wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getPageTitle();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String pageTitle;
  protected String linkToUrl;
  protected PageType pageType;
  protected int displayOrder;
  protected MobileApp mobileApp;
  protected int version;

  protected SmartList<Slide> mSlideList;
  protected SmartList<UiAction> mUiActionList;
  protected SmartList<Section> mSectionList;

  public Page() {
    // lazy load for all the properties
  }

  public static Page withId(String id) {
    Page page = new Page();
    page.setId(id);
    page.setVersion(Integer.MAX_VALUE);
    page.setChecked(true);
    return page;
  }

  public static Page refById(String id) {
    return withId(id);
  }

  public Page limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public Page limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static Page searchExample() {
    Page page = new Page();
    page.setDisplayOrder(UNSET_INT);
    page.setVersion(UNSET_INT);

    return page;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setPageType( null );
  	setMobileApp( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (PAGE_TITLE_PROPERTY.equals(property)) {
      changePageTitleProperty(newValueExpr);
    }
    if (LINK_TO_URL_PROPERTY.equals(property)) {
      changeLinkToUrlProperty(newValueExpr);
    }
    if (DISPLAY_ORDER_PROPERTY.equals(property)) {
      changeDisplayOrderProperty(newValueExpr);
    }
  }

  protected void changePageTitleProperty(String newValueExpr) {

    String oldValue = getPageTitle();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updatePageTitle(newValue);
    this.onChangeProperty(PAGE_TITLE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeLinkToUrlProperty(String newValueExpr) {

    String oldValue = getLinkToUrl();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLinkToUrl(newValue);
    this.onChangeProperty(LINK_TO_URL_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeDisplayOrderProperty(String newValueExpr) {

    int oldValue = getDisplayOrder();
    int newValue = parseInt(newValueExpr);
    if (equalsInt(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateDisplayOrder(newValue);
    this.onChangeProperty(DISPLAY_ORDER_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (PAGE_TITLE_PROPERTY.equals(property)) {
      return getPageTitle();
    }
    if (LINK_TO_URL_PROPERTY.equals(property)) {
      return getLinkToUrl();
    }
    if (PAGE_TYPE_PROPERTY.equals(property)) {
      return getPageType();
    }
    if (DISPLAY_ORDER_PROPERTY.equals(property)) {
      return getDisplayOrder();
    }
    if (MOBILE_APP_PROPERTY.equals(property)) {
      return getMobileApp();
    }
    if (SLIDE_LIST.equals(property)) {
      List<BaseEntity> list =
          getSlideList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (UI_ACTION_LIST.equals(property)) {
      List<BaseEntity> list =
          getUiActionList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (SECTION_LIST.equals(property)) {
      List<BaseEntity> list =
          getSectionList().stream().map(item -> item).collect(Collectors.toList());
      return list;
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

  public Page updateId(String id) {
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

  public Page orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public Page ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public Page addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setPageTitle(String pageTitle) {
    String oldPageTitle = this.pageTitle;
    String newPageTitle = trimString(pageTitle);
    this.pageTitle = newPageTitle;
  }

  public String pageTitle() {
    doLoad();
    return getPageTitle();
  }

  public String getPageTitle() {
    return this.pageTitle;
  }

  public Page updatePageTitle(String pageTitle) {
    String oldPageTitle = this.pageTitle;
    String newPageTitle = trimString(pageTitle);
    if (!shouldReplaceBy(newPageTitle, oldPageTitle)) {
      return this;
    }
    this.pageTitle = newPageTitle;
    if (cn.hutool.core.util.ObjectUtil.equals(newPageTitle, oldPageTitle)) {
      return this;
    }
    addPropertyChange(PAGE_TITLE_PROPERTY, oldPageTitle, newPageTitle);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Page orderByPageTitle(boolean asc) {
    doAddOrderBy(PAGE_TITLE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createPageTitleCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(PAGE_TITLE_PROPERTY, operator, parameters);
  }

  public Page ignorePageTitleCriteria() {
    super.ignoreSearchProperty(PAGE_TITLE_PROPERTY);
    return this;
  }

  public Page addPageTitleCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createPageTitleCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergePageTitle(String pageTitle) {
    if (pageTitle != null) {
      updatePageTitle(pageTitle);
    }
  }

  public void setLinkToUrl(String linkToUrl) {
    String oldLinkToUrl = this.linkToUrl;
    String newLinkToUrl = trimString(linkToUrl);
    this.linkToUrl = newLinkToUrl;
  }

  public String linkToUrl() {
    doLoad();
    return getLinkToUrl();
  }

  public String getLinkToUrl() {
    return this.linkToUrl;
  }

  public Page updateLinkToUrl(String linkToUrl) {
    String oldLinkToUrl = this.linkToUrl;
    String newLinkToUrl = trimString(linkToUrl);
    if (!shouldReplaceBy(newLinkToUrl, oldLinkToUrl)) {
      return this;
    }
    this.linkToUrl = newLinkToUrl;
    if (cn.hutool.core.util.ObjectUtil.equals(newLinkToUrl, oldLinkToUrl)) {
      return this;
    }
    addPropertyChange(LINK_TO_URL_PROPERTY, oldLinkToUrl, newLinkToUrl);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Page orderByLinkToUrl(boolean asc) {
    doAddOrderBy(LINK_TO_URL_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLinkToUrlCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LINK_TO_URL_PROPERTY, operator, parameters);
  }

  public Page ignoreLinkToUrlCriteria() {
    super.ignoreSearchProperty(LINK_TO_URL_PROPERTY);
    return this;
  }

  public Page addLinkToUrlCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLinkToUrlCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLinkToUrl(String linkToUrl) {
    if (linkToUrl != null) {
      updateLinkToUrl(linkToUrl);
    }
  }

  public void setPageType(PageType pageType) {
    PageType oldPageType = this.pageType;
    PageType newPageType = pageType;
    this.pageType = newPageType;
  }

  public PageType pageType() {
    doLoad();
    return getPageType();
  }

  public PageType getPageType() {
    return this.pageType;
  }

  public Page updatePageType(PageType pageType) {
    PageType oldPageType = this.pageType;
    PageType newPageType = pageType;
    if (!shouldReplaceBy(newPageType, oldPageType)) {
      return this;
    }
    this.pageType = newPageType;
    if (cn.hutool.core.util.ObjectUtil.equals(newPageType, oldPageType)) {
      return this;
    }
    addPropertyChange(PAGE_TYPE_PROPERTY, oldPageType, newPageType);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Page orderByPageType(boolean asc) {
    doAddOrderBy(PAGE_TYPE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createPageTypeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(PAGE_TYPE_PROPERTY, operator, parameters);
  }

  public Page ignorePageTypeCriteria() {
    super.ignoreSearchProperty(PAGE_TYPE_PROPERTY);
    return this;
  }

  public Page addPageTypeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createPageTypeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergePageType(PageType pageType) {
    if (pageType != null) {
      updatePageType(pageType);
    }
  }

  public Page updatePageTypeByReferenceId(String pageTypeId) {
    updatePageType(PageType.refById(pageTypeId));
    return this;
  }

  public void clearPageType() {
    setPageType(null);
    this.changed = true;
    setChecked(false);
  }

  public Page updatePageTypeToHome() {
    return updatePageTypeByReferenceId(PageType.HOME);
  }

  public Page updatePageTypeToMe() {
    return updatePageTypeByReferenceId(PageType.ME);
  }

  public Page updatePageTypeToGenericPage() {
    return updatePageTypeByReferenceId(PageType.GENERIC_PAGE);
  }

  public Page updatePageTypeToListofPage() {
    return updatePageTypeByReferenceId(PageType.LISTOF_PAGE);
  }

  public Page updatePageTypeToServiceCenter() {
    return updatePageTypeByReferenceId(PageType.SERVICE_CENTER);
  }

  public Page updatePageTypeToSimple() {
    return updatePageTypeByReferenceId(PageType.SIMPLE);
  }

  public boolean isPageTypeHome() {
    return baseEntityIdEquals(getPageType(), PageType.HOME);
  }

  public boolean isPageTypeMe() {
    return baseEntityIdEquals(getPageType(), PageType.ME);
  }

  public boolean isPageTypeGenericPage() {
    return baseEntityIdEquals(getPageType(), PageType.GENERIC_PAGE);
  }

  public boolean isPageTypeListofPage() {
    return baseEntityIdEquals(getPageType(), PageType.LISTOF_PAGE);
  }

  public boolean isPageTypeServiceCenter() {
    return baseEntityIdEquals(getPageType(), PageType.SERVICE_CENTER);
  }

  public boolean isPageTypeSimple() {
    return baseEntityIdEquals(getPageType(), PageType.SIMPLE);
  }

  public Page whenPageTypeIsHome(Runnable function) {
    assetPropertyIdNotNull(getPageType(), PAGE_TYPE_PROPERTY);
    if (isPageTypeHome() && function != null) {
      function.run();
    }
    return this;
  }

  public Page whenPageTypeIsMe(Runnable function) {
    assetPropertyIdNotNull(getPageType(), PAGE_TYPE_PROPERTY);
    if (isPageTypeMe() && function != null) {
      function.run();
    }
    return this;
  }

  public Page whenPageTypeIsGenericPage(Runnable function) {
    assetPropertyIdNotNull(getPageType(), PAGE_TYPE_PROPERTY);
    if (isPageTypeGenericPage() && function != null) {
      function.run();
    }
    return this;
  }

  public Page whenPageTypeIsListofPage(Runnable function) {
    assetPropertyIdNotNull(getPageType(), PAGE_TYPE_PROPERTY);
    if (isPageTypeListofPage() && function != null) {
      function.run();
    }
    return this;
  }

  public Page whenPageTypeIsServiceCenter(Runnable function) {
    assetPropertyIdNotNull(getPageType(), PAGE_TYPE_PROPERTY);
    if (isPageTypeServiceCenter() && function != null) {
      function.run();
    }
    return this;
  }

  public Page whenPageTypeIsSimple(Runnable function) {
    assetPropertyIdNotNull(getPageType(), PAGE_TYPE_PROPERTY);
    if (isPageTypeSimple() && function != null) {
      function.run();
    }
    return this;
  }

  public Page whenPageTypeIsNotHome(Runnable function) {
    assetPropertyIdNotNull(getPageType(), PAGE_TYPE_PROPERTY);
    if (!(isPageTypeHome()) && function != null) {
      function.run();
    }
    return this;
  }

  public Page whenPageTypeIsNotMe(Runnable function) {
    assetPropertyIdNotNull(getPageType(), PAGE_TYPE_PROPERTY);
    if (!(isPageTypeMe()) && function != null) {
      function.run();
    }
    return this;
  }

  public Page whenPageTypeIsNotGenericPage(Runnable function) {
    assetPropertyIdNotNull(getPageType(), PAGE_TYPE_PROPERTY);
    if (!(isPageTypeGenericPage()) && function != null) {
      function.run();
    }
    return this;
  }

  public Page whenPageTypeIsNotListofPage(Runnable function) {
    assetPropertyIdNotNull(getPageType(), PAGE_TYPE_PROPERTY);
    if (!(isPageTypeListofPage()) && function != null) {
      function.run();
    }
    return this;
  }

  public Page whenPageTypeIsNotServiceCenter(Runnable function) {
    assetPropertyIdNotNull(getPageType(), PAGE_TYPE_PROPERTY);
    if (!(isPageTypeServiceCenter()) && function != null) {
      function.run();
    }
    return this;
  }

  public Page whenPageTypeIsNotSimple(Runnable function) {
    assetPropertyIdNotNull(getPageType(), PAGE_TYPE_PROPERTY);
    if (!(isPageTypeSimple()) && function != null) {
      function.run();
    }
    return this;
  }

  public void setDisplayOrder(int displayOrder) {
    int oldDisplayOrder = this.displayOrder;
    int newDisplayOrder = displayOrder;
    this.displayOrder = newDisplayOrder;
  }

  public int displayOrder() {
    doLoad();
    return getDisplayOrder();
  }

  public int getDisplayOrder() {
    return this.displayOrder;
  }

  public Page updateDisplayOrder(int displayOrder) {
    int oldDisplayOrder = this.displayOrder;
    int newDisplayOrder = displayOrder;
    if (!shouldReplaceBy(newDisplayOrder, oldDisplayOrder)) {
      return this;
    }
    this.displayOrder = newDisplayOrder;
    if (cn.hutool.core.util.ObjectUtil.equals(newDisplayOrder, oldDisplayOrder)) {
      return this;
    }
    addPropertyChange(DISPLAY_ORDER_PROPERTY, oldDisplayOrder, newDisplayOrder);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Page orderByDisplayOrder(boolean asc) {
    doAddOrderBy(DISPLAY_ORDER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDisplayOrderCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DISPLAY_ORDER_PROPERTY, operator, parameters);
  }

  public Page ignoreDisplayOrderCriteria() {
    super.ignoreSearchProperty(DISPLAY_ORDER_PROPERTY);
    return this;
  }

  public Page addDisplayOrderCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDisplayOrderCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDisplayOrder(int displayOrder) {
    updateDisplayOrder(displayOrder);
  }

  public void setMobileApp(MobileApp mobileApp) {
    MobileApp oldMobileApp = this.mobileApp;
    MobileApp newMobileApp = mobileApp;
    this.mobileApp = newMobileApp;
  }

  public MobileApp mobileApp() {
    doLoad();
    return getMobileApp();
  }

  public MobileApp getMobileApp() {
    return this.mobileApp;
  }

  public Page updateMobileApp(MobileApp mobileApp) {
    MobileApp oldMobileApp = this.mobileApp;
    MobileApp newMobileApp = mobileApp;
    if (!shouldReplaceBy(newMobileApp, oldMobileApp)) {
      return this;
    }
    this.mobileApp = newMobileApp;
    if (cn.hutool.core.util.ObjectUtil.equals(newMobileApp, oldMobileApp)) {
      return this;
    }
    addPropertyChange(MOBILE_APP_PROPERTY, oldMobileApp, newMobileApp);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Page orderByMobileApp(boolean asc) {
    doAddOrderBy(MOBILE_APP_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createMobileAppCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(MOBILE_APP_PROPERTY, operator, parameters);
  }

  public Page ignoreMobileAppCriteria() {
    super.ignoreSearchProperty(MOBILE_APP_PROPERTY);
    return this;
  }

  public Page addMobileAppCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createMobileAppCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeMobileApp(MobileApp mobileApp) {
    if (mobileApp != null) {
      updateMobileApp(mobileApp);
    }
  }

  public Page updateMobileAppByReferenceId(String mobileAppId) {
    updateMobileApp(MobileApp.refById(mobileAppId));
    return this;
  }

  public void clearMobileApp() {
    setMobileApp(null);
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

  public Page updateVersion(int version) {
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

  public Page orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public Page ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public Page addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<Slide> getSlideList() {
    if (this.mSlideList == null) {
      this.mSlideList = new SmartList<Slide>();
      this.mSlideList.setListInternalName(SLIDE_LIST);
      // 有名字，便于做权限控制
    }

    return this.mSlideList;
  }

  public SmartList<Slide> slideList() {

    doLoadChild(SLIDE_LIST);

    return getSlideList();
  }

  public void setSlideList(SmartList<Slide> slideList) {
    for (Slide slide : slideList) {
      slide.setPage(this);
    }

    this.mSlideList = slideList;
    this.mSlideList.setListInternalName(SLIDE_LIST);
  }

  public Page addSlide(Slide slide) {
    slide.updatePage(this);
    getSlideList().add(slide);
    return this;
  }

  public Page addSlideList(SmartList<Slide> slideList) {
    for (Slide slide : slideList) {
      slide.updatePage(this);
    }

    Map<String, Slide> mapById = slideList.mapWithId();
    getSlideList().removeIf(item -> mapById.get(item.getId()) != null);
    getSlideList().addAll(slideList);
    return this;
  }

  public void mergeSlideList(SmartList<Slide> slideList) {
    if (slideList == null) {
      return;
    }
    if (slideList.isEmpty()) {
      return;
    }
    addSlideList(slideList);
  }

  public Slide removeSlide(Slide slideIndex) {

    int index = getSlideList().indexOf(slideIndex);
    if (index < 0) {
      String message =
          "Slide("
              + slideIndex.getId()
              + ") with version='"
              + slideIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    Slide slide = getSlideList().get(index);
    // slide.clearPage(); //disconnect with Page
    slide.clearFromAll(); // disconnect with Page

    boolean result = getSlideList().planToRemove(slide);
    if (!result) {
      String message =
          "Slide("
              + slideIndex.getId()
              + ") with version='"
              + slideIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return slide;
  }
  // 断舍离
  public void breakWithSlide(Slide slide) {

    if (slide == null) {
      return;
    }
    slide.setPage(null);
    // getSlideList().remove();

  }

  public boolean hasSlide(Slide slide) {

    return getSlideList().contains(slide);
  }

  public void copySlideFrom(Slide slide) {

    Slide slideInList = findTheSlide(slide);
    Slide newSlide = new Slide();
    slideInList.copyTo(newSlide);
    newSlide.setVersion(0); // will trigger copy
    getSlideList().add(newSlide);
    addItemToFlexiableObject(COPIED_CHILD, newSlide);
  }

  public Slide findTheSlide(Slide slide) {

    int index = getSlideList().indexOf(slide);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "Slide(" + slide.getId() + ") with version='" + slide.getVersion() + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getSlideList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpSlideList() {
    getSlideList().clear();
  }

  public SmartList<UiAction> getUiActionList() {
    if (this.mUiActionList == null) {
      this.mUiActionList = new SmartList<UiAction>();
      this.mUiActionList.setListInternalName(UI_ACTION_LIST);
      // 有名字，便于做权限控制
    }

    return this.mUiActionList;
  }

  public SmartList<UiAction> uiActionList() {

    doLoadChild(UI_ACTION_LIST);

    return getUiActionList();
  }

  public void setUiActionList(SmartList<UiAction> uiActionList) {
    for (UiAction uiAction : uiActionList) {
      uiAction.setPage(this);
    }

    this.mUiActionList = uiActionList;
    this.mUiActionList.setListInternalName(UI_ACTION_LIST);
  }

  public Page addUiAction(UiAction uiAction) {
    uiAction.updatePage(this);
    getUiActionList().add(uiAction);
    return this;
  }

  public Page addUiActionList(SmartList<UiAction> uiActionList) {
    for (UiAction uiAction : uiActionList) {
      uiAction.updatePage(this);
    }

    Map<String, UiAction> mapById = uiActionList.mapWithId();
    getUiActionList().removeIf(item -> mapById.get(item.getId()) != null);
    getUiActionList().addAll(uiActionList);
    return this;
  }

  public void mergeUiActionList(SmartList<UiAction> uiActionList) {
    if (uiActionList == null) {
      return;
    }
    if (uiActionList.isEmpty()) {
      return;
    }
    addUiActionList(uiActionList);
  }

  public UiAction removeUiAction(UiAction uiActionIndex) {

    int index = getUiActionList().indexOf(uiActionIndex);
    if (index < 0) {
      String message =
          "UiAction("
              + uiActionIndex.getId()
              + ") with version='"
              + uiActionIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    UiAction uiAction = getUiActionList().get(index);
    // uiAction.clearPage(); //disconnect with Page
    uiAction.clearFromAll(); // disconnect with Page

    boolean result = getUiActionList().planToRemove(uiAction);
    if (!result) {
      String message =
          "UiAction("
              + uiActionIndex.getId()
              + ") with version='"
              + uiActionIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return uiAction;
  }
  // 断舍离
  public void breakWithUiAction(UiAction uiAction) {

    if (uiAction == null) {
      return;
    }
    uiAction.setPage(null);
    // getUiActionList().remove();

  }

  public boolean hasUiAction(UiAction uiAction) {

    return getUiActionList().contains(uiAction);
  }

  public void copyUiActionFrom(UiAction uiAction) {

    UiAction uiActionInList = findTheUiAction(uiAction);
    UiAction newUiAction = new UiAction();
    uiActionInList.copyTo(newUiAction);
    newUiAction.setVersion(0); // will trigger copy
    getUiActionList().add(newUiAction);
    addItemToFlexiableObject(COPIED_CHILD, newUiAction);
  }

  public UiAction findTheUiAction(UiAction uiAction) {

    int index = getUiActionList().indexOf(uiAction);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "UiAction("
              + uiAction.getId()
              + ") with version='"
              + uiAction.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getUiActionList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpUiActionList() {
    getUiActionList().clear();
  }

  public SmartList<Section> getSectionList() {
    if (this.mSectionList == null) {
      this.mSectionList = new SmartList<Section>();
      this.mSectionList.setListInternalName(SECTION_LIST);
      // 有名字，便于做权限控制
    }

    return this.mSectionList;
  }

  public SmartList<Section> sectionList() {

    doLoadChild(SECTION_LIST);

    return getSectionList();
  }

  public void setSectionList(SmartList<Section> sectionList) {
    for (Section section : sectionList) {
      section.setPage(this);
    }

    this.mSectionList = sectionList;
    this.mSectionList.setListInternalName(SECTION_LIST);
  }

  public Page addSection(Section section) {
    section.updatePage(this);
    getSectionList().add(section);
    return this;
  }

  public Page addSectionList(SmartList<Section> sectionList) {
    for (Section section : sectionList) {
      section.updatePage(this);
    }

    Map<String, Section> mapById = sectionList.mapWithId();
    getSectionList().removeIf(item -> mapById.get(item.getId()) != null);
    getSectionList().addAll(sectionList);
    return this;
  }

  public void mergeSectionList(SmartList<Section> sectionList) {
    if (sectionList == null) {
      return;
    }
    if (sectionList.isEmpty()) {
      return;
    }
    addSectionList(sectionList);
  }

  public Section removeSection(Section sectionIndex) {

    int index = getSectionList().indexOf(sectionIndex);
    if (index < 0) {
      String message =
          "Section("
              + sectionIndex.getId()
              + ") with version='"
              + sectionIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    Section section = getSectionList().get(index);
    // section.clearPage(); //disconnect with Page
    section.clearFromAll(); // disconnect with Page

    boolean result = getSectionList().planToRemove(section);
    if (!result) {
      String message =
          "Section("
              + sectionIndex.getId()
              + ") with version='"
              + sectionIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return section;
  }
  // 断舍离
  public void breakWithSection(Section section) {

    if (section == null) {
      return;
    }
    section.setPage(null);
    // getSectionList().remove();

  }

  public boolean hasSection(Section section) {

    return getSectionList().contains(section);
  }

  public void copySectionFrom(Section section) {

    Section sectionInList = findTheSection(section);
    Section newSection = new Section();
    sectionInList.copyTo(newSection);
    newSection.setVersion(0); // will trigger copy
    getSectionList().add(newSection);
    addItemToFlexiableObject(COPIED_CHILD, newSection);
  }

  public Section findTheSection(Section section) {

    int index = getSectionList().indexOf(section);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "Section(" + section.getId() + ") with version='" + section.getVersion() + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getSectionList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpSectionList() {
    getSectionList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getPageType(), internalType);
    addToEntityList(this, entityList, getMobileApp(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getSlideList(), internalType);
    collectFromList(this, entityList, getUiActionList(), internalType);
    collectFromList(this, entityList, getSectionList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getSlideList());
    listOfList.add(getUiActionList());
    listOfList.add(getSectionList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, PAGE_TITLE_PROPERTY, getPageTitle());
    appendKeyValuePair(result, LINK_TO_URL_PROPERTY, getLinkToUrl());
    appendKeyValuePair(result, PAGE_TYPE_PROPERTY, getPageType());
    appendKeyValuePair(result, DISPLAY_ORDER_PROPERTY, getDisplayOrder());
    appendKeyValuePair(result, MOBILE_APP_PROPERTY, getMobileApp());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, SLIDE_LIST, getSlideList());
    if (!getSlideList().isEmpty()) {
      appendKeyValuePair(result, "slideCount", getSlideList().getTotalCount());
      appendKeyValuePair(result, "slideCurrentPageNumber", getSlideList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, UI_ACTION_LIST, getUiActionList());
    if (!getUiActionList().isEmpty()) {
      appendKeyValuePair(result, "uiActionCount", getUiActionList().getTotalCount());
      appendKeyValuePair(
          result, "uiActionCurrentPageNumber", getUiActionList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, SECTION_LIST, getSectionList());
    if (!getSectionList().isEmpty()) {
      appendKeyValuePair(result, "sectionCount", getSectionList().getTotalCount());
      appendKeyValuePair(
          result, "sectionCurrentPageNumber", getSectionList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof Page) {

      Page dest = (Page) baseDest;

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

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof Page) {

      Page source = (Page) sourceEntity;

      mergeId(source.getId());
      mergePageTitle(source.getPageTitle());
      mergeLinkToUrl(source.getLinkToUrl());
      mergePageType(source.getPageType());
      mergeDisplayOrder(source.getDisplayOrder());
      mergeMobileApp(source.getMobileApp());
      mergeVersion(source.getVersion());
      mergeSlideList(source.getSlideList());
      mergeUiActionList(source.getUiActionList());
      mergeSectionList(source.getSectionList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof Page) {

      Page source = (Page) sourceEntity;

      mergeId(source.getId());
      mergePageTitle(source.getPageTitle());
      mergeLinkToUrl(source.getLinkToUrl());
      mergeDisplayOrder(source.getDisplayOrder());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getPageTitle(),
      getLinkToUrl(),
      getPageType(),
      getDisplayOrder(),
      getMobileApp(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    Page checkPage =
        Q.pageWithIdField()
            .filterById(id)
            .selectSlideList(Q.slideWithIdField().limit(0, 1))
            .selectUiActionList(Q.uiActionWithIdField().limit(0, 1))
            .selectSectionList(Q.sectionWithIdField().limit(0, 1))
            .execute(ctx);

    return checkPage != null
        && !checkPage.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public Page save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("Page{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tpageTitle='" + getPageTitle() + "';");
    stringBuilder.append("\tlinkToUrl='" + getLinkToUrl() + "';");
    if (getPageType() != null) {
      stringBuilder.append("\tpageType='PageType(" + getPageType().getId() + ")';");
    }
    stringBuilder.append("\tdisplayOrder='" + getDisplayOrder() + "';");
    if (getMobileApp() != null) {
      stringBuilder.append("\tmobileApp='MobileApp(" + getMobileApp().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

  public void increaseDisplayOrder(int incDisplayOrder) {
    updateDisplayOrder(this.displayOrder + incDisplayOrder);
  }

  public void decreaseDisplayOrder(int decDisplayOrder) {
    updateDisplayOrder(this.displayOrder - decDisplayOrder);
  }
}
