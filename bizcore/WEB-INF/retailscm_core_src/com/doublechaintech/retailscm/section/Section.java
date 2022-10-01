package com.doublechaintech.retailscm.section;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.page.Page;

@JsonSerialize(using = SectionSerializer.class)
public class Section extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(Section target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String TITLE_PROPERTY = "title";
  public static final String BRIEF_PROPERTY = "brief";
  public static final String ICON_PROPERTY = "icon";
  public static final String DISPLAY_ORDER_PROPERTY = "displayOrder";
  public static final String VIEW_GROUP_PROPERTY = "viewGroup";
  public static final String LINK_TO_URL_PROPERTY = "linkToUrl";
  public static final String PAGE_PROPERTY = "page";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "Section";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(TITLE_PROPERTY, "title", "头衔").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(BRIEF_PROPERTY, "brief", "短暂的").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ICON_PROPERTY, "icon", "图标")
            .withType("string_image", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DISPLAY_ORDER_PROPERTY, "display_order", "顺序")
            .withType("int", "int"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VIEW_GROUP_PROPERTY, "view_group", "视图组")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LINK_TO_URL_PROPERTY, "link_to_url", "链接网址")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(PAGE_PROPERTY, "page", "页面").withType("page", Page.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      TITLE_PROPERTY,
      BRIEF_PROPERTY,
      ICON_PROPERTY,
      DISPLAY_ORDER_PROPERTY,
      VIEW_GROUP_PROPERTY,
      LINK_TO_URL_PROPERTY,
      PAGE_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(PAGE_PROPERTY, Page.class);

    return parents;
  }
  /*
  public Section want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public Section wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getTitle();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String title;
  protected String brief;
  protected String icon;
  protected int displayOrder;
  protected String viewGroup;
  protected String linkToUrl;
  protected Page page;
  protected int version;

  public Section() {
    // lazy load for all the properties
  }

  public static Section withId(String id) {
    Section section = new Section();
    section.setId(id);
    section.setVersion(Integer.MAX_VALUE);
    section.setChecked(true);
    return section;
  }

  public static Section refById(String id) {
    return withId(id);
  }

  public Section limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public Section limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static Section searchExample() {
    Section section = new Section();
    section.setDisplayOrder(UNSET_INT);
    section.setVersion(UNSET_INT);

    return section;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setPage( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (TITLE_PROPERTY.equals(property)) {
      changeTitleProperty(newValueExpr);
    }
    if (BRIEF_PROPERTY.equals(property)) {
      changeBriefProperty(newValueExpr);
    }
    if (ICON_PROPERTY.equals(property)) {
      changeIconProperty(newValueExpr);
    }
    if (DISPLAY_ORDER_PROPERTY.equals(property)) {
      changeDisplayOrderProperty(newValueExpr);
    }
    if (VIEW_GROUP_PROPERTY.equals(property)) {
      changeViewGroupProperty(newValueExpr);
    }
    if (LINK_TO_URL_PROPERTY.equals(property)) {
      changeLinkToUrlProperty(newValueExpr);
    }
  }

  protected void changeTitleProperty(String newValueExpr) {

    String oldValue = getTitle();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateTitle(newValue);
    this.onChangeProperty(TITLE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeBriefProperty(String newValueExpr) {

    String oldValue = getBrief();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateBrief(newValue);
    this.onChangeProperty(BRIEF_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeIconProperty(String newValueExpr) {

    String oldValue = getIcon();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateIcon(newValue);
    this.onChangeProperty(ICON_PROPERTY, oldValue, newValue);
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

  protected void changeViewGroupProperty(String newValueExpr) {

    String oldValue = getViewGroup();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateViewGroup(newValue);
    this.onChangeProperty(VIEW_GROUP_PROPERTY, oldValue, newValue);
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

  public Object propertyOf(String property) {

    if (TITLE_PROPERTY.equals(property)) {
      return getTitle();
    }
    if (BRIEF_PROPERTY.equals(property)) {
      return getBrief();
    }
    if (ICON_PROPERTY.equals(property)) {
      return getIcon();
    }
    if (DISPLAY_ORDER_PROPERTY.equals(property)) {
      return getDisplayOrder();
    }
    if (VIEW_GROUP_PROPERTY.equals(property)) {
      return getViewGroup();
    }
    if (LINK_TO_URL_PROPERTY.equals(property)) {
      return getLinkToUrl();
    }
    if (PAGE_PROPERTY.equals(property)) {
      return getPage();
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

  public Section updateId(String id) {
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

  public Section orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public Section ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public Section addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setTitle(String title) {
    String oldTitle = this.title;
    String newTitle = trimString(title);
    this.title = newTitle;
  }

  public String title() {
    doLoad();
    return getTitle();
  }

  public String getTitle() {
    return this.title;
  }

  public Section updateTitle(String title) {
    String oldTitle = this.title;
    String newTitle = trimString(title);
    if (!shouldReplaceBy(newTitle, oldTitle)) {
      return this;
    }
    this.title = newTitle;
    if (cn.hutool.core.util.ObjectUtil.equals(newTitle, oldTitle)) {
      return this;
    }
    addPropertyChange(TITLE_PROPERTY, oldTitle, newTitle);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Section orderByTitle(boolean asc) {
    doAddOrderBy(TITLE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createTitleCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(TITLE_PROPERTY, operator, parameters);
  }

  public Section ignoreTitleCriteria() {
    super.ignoreSearchProperty(TITLE_PROPERTY);
    return this;
  }

  public Section addTitleCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createTitleCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeTitle(String title) {
    if (title != null) {
      updateTitle(title);
    }
  }

  public void setBrief(String brief) {
    String oldBrief = this.brief;
    String newBrief = trimString(brief);
    this.brief = newBrief;
  }

  public String brief() {
    doLoad();
    return getBrief();
  }

  public String getBrief() {
    return this.brief;
  }

  public Section updateBrief(String brief) {
    String oldBrief = this.brief;
    String newBrief = trimString(brief);
    if (!shouldReplaceBy(newBrief, oldBrief)) {
      return this;
    }
    this.brief = newBrief;
    if (cn.hutool.core.util.ObjectUtil.equals(newBrief, oldBrief)) {
      return this;
    }
    addPropertyChange(BRIEF_PROPERTY, oldBrief, newBrief);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Section orderByBrief(boolean asc) {
    doAddOrderBy(BRIEF_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createBriefCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(BRIEF_PROPERTY, operator, parameters);
  }

  public Section ignoreBriefCriteria() {
    super.ignoreSearchProperty(BRIEF_PROPERTY);
    return this;
  }

  public Section addBriefCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createBriefCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeBrief(String brief) {
    if (brief != null) {
      updateBrief(brief);
    }
  }

  public void setIcon(String icon) {
    String oldIcon = this.icon;
    String newIcon = trimString(encodeUrl(icon));
    ;
    this.icon = newIcon;
  }

  public String icon() {
    doLoad();
    return getIcon();
  }

  public String getIcon() {
    return this.icon;
  }

  public Section updateIcon(String icon) {
    String oldIcon = this.icon;
    String newIcon = trimString(encodeUrl(icon));
    ;
    if (!shouldReplaceBy(newIcon, oldIcon)) {
      return this;
    }
    this.icon = newIcon;
    if (cn.hutool.core.util.ObjectUtil.equals(newIcon, oldIcon)) {
      return this;
    }
    addPropertyChange(ICON_PROPERTY, oldIcon, newIcon);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Section orderByIcon(boolean asc) {
    doAddOrderBy(ICON_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIconCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ICON_PROPERTY, operator, parameters);
  }

  public Section ignoreIconCriteria() {
    super.ignoreSearchProperty(ICON_PROPERTY);
    return this;
  }

  public Section addIconCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIconCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeIcon(String icon) {
    if (icon != null) {
      updateIcon(icon);
    }
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

  public Section updateDisplayOrder(int displayOrder) {
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

  public Section orderByDisplayOrder(boolean asc) {
    doAddOrderBy(DISPLAY_ORDER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDisplayOrderCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DISPLAY_ORDER_PROPERTY, operator, parameters);
  }

  public Section ignoreDisplayOrderCriteria() {
    super.ignoreSearchProperty(DISPLAY_ORDER_PROPERTY);
    return this;
  }

  public Section addDisplayOrderCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDisplayOrderCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDisplayOrder(int displayOrder) {
    updateDisplayOrder(displayOrder);
  }

  public void setViewGroup(String viewGroup) {
    String oldViewGroup = this.viewGroup;
    String newViewGroup = trimString(viewGroup);
    this.viewGroup = newViewGroup;
  }

  public String viewGroup() {
    doLoad();
    return getViewGroup();
  }

  public String getViewGroup() {
    return this.viewGroup;
  }

  public Section updateViewGroup(String viewGroup) {
    String oldViewGroup = this.viewGroup;
    String newViewGroup = trimString(viewGroup);
    if (!shouldReplaceBy(newViewGroup, oldViewGroup)) {
      return this;
    }
    this.viewGroup = newViewGroup;
    if (cn.hutool.core.util.ObjectUtil.equals(newViewGroup, oldViewGroup)) {
      return this;
    }
    addPropertyChange(VIEW_GROUP_PROPERTY, oldViewGroup, newViewGroup);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Section orderByViewGroup(boolean asc) {
    doAddOrderBy(VIEW_GROUP_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createViewGroupCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VIEW_GROUP_PROPERTY, operator, parameters);
  }

  public Section ignoreViewGroupCriteria() {
    super.ignoreSearchProperty(VIEW_GROUP_PROPERTY);
    return this;
  }

  public Section addViewGroupCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createViewGroupCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeViewGroup(String viewGroup) {
    if (viewGroup != null) {
      updateViewGroup(viewGroup);
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

  public Section updateLinkToUrl(String linkToUrl) {
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

  public Section orderByLinkToUrl(boolean asc) {
    doAddOrderBy(LINK_TO_URL_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLinkToUrlCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LINK_TO_URL_PROPERTY, operator, parameters);
  }

  public Section ignoreLinkToUrlCriteria() {
    super.ignoreSearchProperty(LINK_TO_URL_PROPERTY);
    return this;
  }

  public Section addLinkToUrlCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLinkToUrlCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLinkToUrl(String linkToUrl) {
    if (linkToUrl != null) {
      updateLinkToUrl(linkToUrl);
    }
  }

  public void setPage(Page page) {
    Page oldPage = this.page;
    Page newPage = page;
    this.page = newPage;
  }

  public Page page() {
    doLoad();
    return getPage();
  }

  public Page getPage() {
    return this.page;
  }

  public Section updatePage(Page page) {
    Page oldPage = this.page;
    Page newPage = page;
    if (!shouldReplaceBy(newPage, oldPage)) {
      return this;
    }
    this.page = newPage;
    if (cn.hutool.core.util.ObjectUtil.equals(newPage, oldPage)) {
      return this;
    }
    addPropertyChange(PAGE_PROPERTY, oldPage, newPage);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public Section orderByPage(boolean asc) {
    doAddOrderBy(PAGE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createPageCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(PAGE_PROPERTY, operator, parameters);
  }

  public Section ignorePageCriteria() {
    super.ignoreSearchProperty(PAGE_PROPERTY);
    return this;
  }

  public Section addPageCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createPageCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergePage(Page page) {
    if (page != null) {
      updatePage(page);
    }
  }

  public Section updatePageByReferenceId(String pageId) {
    updatePage(Page.refById(pageId));
    return this;
  }

  public void clearPage() {
    setPage(null);
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

  public Section updateVersion(int version) {
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

  public Section orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public Section ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public Section addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getPage(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

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

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof Section) {

      Section dest = (Section) baseDest;

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

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof Section) {

      Section source = (Section) sourceEntity;

      mergeId(source.getId());
      mergeTitle(source.getTitle());
      mergeBrief(source.getBrief());
      mergeIcon(source.getIcon());
      mergeDisplayOrder(source.getDisplayOrder());
      mergeViewGroup(source.getViewGroup());
      mergeLinkToUrl(source.getLinkToUrl());
      mergePage(source.getPage());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof Section) {

      Section source = (Section) sourceEntity;

      mergeId(source.getId());
      mergeTitle(source.getTitle());
      mergeBrief(source.getBrief());
      mergeIcon(source.getIcon());
      mergeDisplayOrder(source.getDisplayOrder());
      mergeViewGroup(source.getViewGroup());
      mergeLinkToUrl(source.getLinkToUrl());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getTitle(),
      getBrief(),
      getIcon(),
      getDisplayOrder(),
      getViewGroup(),
      getLinkToUrl(),
      getPage(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    Section checkSection = Q.sectionWithIdField().filterById(id).execute(ctx);

    return checkSection != null
        && !checkSection.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public Section save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("Section{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\ttitle='" + getTitle() + "';");
    stringBuilder.append("\tbrief='" + getBrief() + "';");
    stringBuilder.append("\ticon='" + getIcon() + "';");
    stringBuilder.append("\tdisplayOrder='" + getDisplayOrder() + "';");
    stringBuilder.append("\tviewGroup='" + getViewGroup() + "';");
    stringBuilder.append("\tlinkToUrl='" + getLinkToUrl() + "';");
    if (getPage() != null) {
      stringBuilder.append("\tpage='Page(" + getPage().getId() + ")';");
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
