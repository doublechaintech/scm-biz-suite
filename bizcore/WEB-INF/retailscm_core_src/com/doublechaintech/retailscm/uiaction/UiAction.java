package com.doublechaintech.retailscm.uiaction;

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

@JsonSerialize(using = UiActionSerializer.class)
public class UiAction extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(UiAction target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String CODE_PROPERTY = "code";
  public static final String ICON_PROPERTY = "icon";
  public static final String TITLE_PROPERTY = "title";
  public static final String DISPLAY_ORDER_PROPERTY = "displayOrder";
  public static final String BRIEF_PROPERTY = "brief";
  public static final String IMAGE_URL_PROPERTY = "imageUrl";
  public static final String LINK_TO_URL_PROPERTY = "linkToUrl";
  public static final String EXTRA_DATA_PROPERTY = "extraData";
  public static final String PAGE_PROPERTY = "page";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "UiAction";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(CODE_PROPERTY, "code", "代码").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ICON_PROPERTY, "icon", "图标").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(TITLE_PROPERTY, "title", "头衔").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DISPLAY_ORDER_PROPERTY, "display_order", "顺序")
            .withType("int", "int"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(BRIEF_PROPERTY, "brief", "短暂的").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(IMAGE_URL_PROPERTY, "image_url", "图片链接")
            .withType("string_image", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LINK_TO_URL_PROPERTY, "link_to_url", "链接网址")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(EXTRA_DATA_PROPERTY, "extra_data", "额外的数据")
            .withType("text", String.class));
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
      CODE_PROPERTY,
      ICON_PROPERTY,
      TITLE_PROPERTY,
      DISPLAY_ORDER_PROPERTY,
      BRIEF_PROPERTY,
      IMAGE_URL_PROPERTY,
      LINK_TO_URL_PROPERTY,
      EXTRA_DATA_PROPERTY,
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
  public UiAction want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public UiAction wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getCode();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String code;
  protected String icon;
  protected String title;
  protected int displayOrder;
  protected String brief;
  protected String imageUrl;
  protected String linkToUrl;
  protected String extraData;
  protected Page page;
  protected int version;

  public UiAction() {
    // lazy load for all the properties
  }

  public static UiAction withId(String id) {
    UiAction uiAction = new UiAction();
    uiAction.setId(id);
    uiAction.setVersion(Integer.MAX_VALUE);
    uiAction.setChecked(true);
    return uiAction;
  }

  public static UiAction refById(String id) {
    return withId(id);
  }

  public UiAction limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public UiAction limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static UiAction searchExample() {
    UiAction uiAction = new UiAction();
    uiAction.setDisplayOrder(UNSET_INT);
    uiAction.setVersion(UNSET_INT);

    return uiAction;
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

    if (CODE_PROPERTY.equals(property)) {
      changeCodeProperty(newValueExpr);
    }
    if (ICON_PROPERTY.equals(property)) {
      changeIconProperty(newValueExpr);
    }
    if (TITLE_PROPERTY.equals(property)) {
      changeTitleProperty(newValueExpr);
    }
    if (DISPLAY_ORDER_PROPERTY.equals(property)) {
      changeDisplayOrderProperty(newValueExpr);
    }
    if (BRIEF_PROPERTY.equals(property)) {
      changeBriefProperty(newValueExpr);
    }
    if (IMAGE_URL_PROPERTY.equals(property)) {
      changeImageUrlProperty(newValueExpr);
    }
    if (LINK_TO_URL_PROPERTY.equals(property)) {
      changeLinkToUrlProperty(newValueExpr);
    }
    if (EXTRA_DATA_PROPERTY.equals(property)) {
      changeExtraDataProperty(newValueExpr);
    }
  }

  protected void changeCodeProperty(String newValueExpr) {

    String oldValue = getCode();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateCode(newValue);
    this.onChangeProperty(CODE_PROPERTY, oldValue, newValue);
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

  protected void changeImageUrlProperty(String newValueExpr) {

    String oldValue = getImageUrl();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateImageUrl(newValue);
    this.onChangeProperty(IMAGE_URL_PROPERTY, oldValue, newValue);
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

  protected void changeExtraDataProperty(String newValueExpr) {

    String oldValue = getExtraData();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateExtraData(newValue);
    this.onChangeProperty(EXTRA_DATA_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (CODE_PROPERTY.equals(property)) {
      return getCode();
    }
    if (ICON_PROPERTY.equals(property)) {
      return getIcon();
    }
    if (TITLE_PROPERTY.equals(property)) {
      return getTitle();
    }
    if (DISPLAY_ORDER_PROPERTY.equals(property)) {
      return getDisplayOrder();
    }
    if (BRIEF_PROPERTY.equals(property)) {
      return getBrief();
    }
    if (IMAGE_URL_PROPERTY.equals(property)) {
      return getImageUrl();
    }
    if (LINK_TO_URL_PROPERTY.equals(property)) {
      return getLinkToUrl();
    }
    if (EXTRA_DATA_PROPERTY.equals(property)) {
      return getExtraData();
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

  public UiAction updateId(String id) {
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

  public UiAction orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public UiAction ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public UiAction addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setCode(String code) {
    String oldCode = this.code;
    String newCode = trimString(code);
    this.code = newCode;
  }

  public String code() {
    doLoad();
    return getCode();
  }

  public String getCode() {
    return this.code;
  }

  public UiAction updateCode(String code) {
    String oldCode = this.code;
    String newCode = trimString(code);
    if (!shouldReplaceBy(newCode, oldCode)) {
      return this;
    }
    this.code = newCode;
    if (cn.hutool.core.util.ObjectUtil.equals(newCode, oldCode)) {
      return this;
    }
    addPropertyChange(CODE_PROPERTY, oldCode, newCode);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public UiAction orderByCode(boolean asc) {
    doAddOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCodeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(CODE_PROPERTY, operator, parameters);
  }

  public UiAction ignoreCodeCriteria() {
    super.ignoreSearchProperty(CODE_PROPERTY);
    return this;
  }

  public UiAction addCodeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCodeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCode(String code) {
    if (code != null) {
      updateCode(code);
    }
  }

  public void setIcon(String icon) {
    String oldIcon = this.icon;
    String newIcon = trimString(icon);
    this.icon = newIcon;
  }

  public String icon() {
    doLoad();
    return getIcon();
  }

  public String getIcon() {
    return this.icon;
  }

  public UiAction updateIcon(String icon) {
    String oldIcon = this.icon;
    String newIcon = trimString(icon);
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

  public UiAction orderByIcon(boolean asc) {
    doAddOrderBy(ICON_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIconCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ICON_PROPERTY, operator, parameters);
  }

  public UiAction ignoreIconCriteria() {
    super.ignoreSearchProperty(ICON_PROPERTY);
    return this;
  }

  public UiAction addIconCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIconCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeIcon(String icon) {
    if (icon != null) {
      updateIcon(icon);
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

  public UiAction updateTitle(String title) {
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

  public UiAction orderByTitle(boolean asc) {
    doAddOrderBy(TITLE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createTitleCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(TITLE_PROPERTY, operator, parameters);
  }

  public UiAction ignoreTitleCriteria() {
    super.ignoreSearchProperty(TITLE_PROPERTY);
    return this;
  }

  public UiAction addTitleCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createTitleCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeTitle(String title) {
    if (title != null) {
      updateTitle(title);
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

  public UiAction updateDisplayOrder(int displayOrder) {
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

  public UiAction orderByDisplayOrder(boolean asc) {
    doAddOrderBy(DISPLAY_ORDER_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDisplayOrderCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DISPLAY_ORDER_PROPERTY, operator, parameters);
  }

  public UiAction ignoreDisplayOrderCriteria() {
    super.ignoreSearchProperty(DISPLAY_ORDER_PROPERTY);
    return this;
  }

  public UiAction addDisplayOrderCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDisplayOrderCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDisplayOrder(int displayOrder) {
    updateDisplayOrder(displayOrder);
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

  public UiAction updateBrief(String brief) {
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

  public UiAction orderByBrief(boolean asc) {
    doAddOrderBy(BRIEF_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createBriefCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(BRIEF_PROPERTY, operator, parameters);
  }

  public UiAction ignoreBriefCriteria() {
    super.ignoreSearchProperty(BRIEF_PROPERTY);
    return this;
  }

  public UiAction addBriefCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createBriefCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeBrief(String brief) {
    if (brief != null) {
      updateBrief(brief);
    }
  }

  public void setImageUrl(String imageUrl) {
    String oldImageUrl = this.imageUrl;
    String newImageUrl = trimString(encodeUrl(imageUrl));
    ;
    this.imageUrl = newImageUrl;
  }

  public String imageUrl() {
    doLoad();
    return getImageUrl();
  }

  public String getImageUrl() {
    return this.imageUrl;
  }

  public UiAction updateImageUrl(String imageUrl) {
    String oldImageUrl = this.imageUrl;
    String newImageUrl = trimString(encodeUrl(imageUrl));
    ;
    if (!shouldReplaceBy(newImageUrl, oldImageUrl)) {
      return this;
    }
    this.imageUrl = newImageUrl;
    if (cn.hutool.core.util.ObjectUtil.equals(newImageUrl, oldImageUrl)) {
      return this;
    }
    addPropertyChange(IMAGE_URL_PROPERTY, oldImageUrl, newImageUrl);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public UiAction orderByImageUrl(boolean asc) {
    doAddOrderBy(IMAGE_URL_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createImageUrlCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(IMAGE_URL_PROPERTY, operator, parameters);
  }

  public UiAction ignoreImageUrlCriteria() {
    super.ignoreSearchProperty(IMAGE_URL_PROPERTY);
    return this;
  }

  public UiAction addImageUrlCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createImageUrlCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeImageUrl(String imageUrl) {
    if (imageUrl != null) {
      updateImageUrl(imageUrl);
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

  public UiAction updateLinkToUrl(String linkToUrl) {
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

  public UiAction orderByLinkToUrl(boolean asc) {
    doAddOrderBy(LINK_TO_URL_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLinkToUrlCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LINK_TO_URL_PROPERTY, operator, parameters);
  }

  public UiAction ignoreLinkToUrlCriteria() {
    super.ignoreSearchProperty(LINK_TO_URL_PROPERTY);
    return this;
  }

  public UiAction addLinkToUrlCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLinkToUrlCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLinkToUrl(String linkToUrl) {
    if (linkToUrl != null) {
      updateLinkToUrl(linkToUrl);
    }
  }

  public void setExtraData(String extraData) {
    String oldExtraData = this.extraData;
    String newExtraData = extraData;
    this.extraData = newExtraData;
  }

  public String extraData() {
    doLoad();
    return getExtraData();
  }

  public String getExtraData() {
    return this.extraData;
  }

  public UiAction updateExtraData(String extraData) {
    String oldExtraData = this.extraData;
    String newExtraData = extraData;
    if (!shouldReplaceBy(newExtraData, oldExtraData)) {
      return this;
    }
    this.extraData = newExtraData;
    if (cn.hutool.core.util.ObjectUtil.equals(newExtraData, oldExtraData)) {
      return this;
    }
    addPropertyChange(EXTRA_DATA_PROPERTY, oldExtraData, newExtraData);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public UiAction orderByExtraData(boolean asc) {
    doAddOrderBy(EXTRA_DATA_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createExtraDataCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(EXTRA_DATA_PROPERTY, operator, parameters);
  }

  public UiAction ignoreExtraDataCriteria() {
    super.ignoreSearchProperty(EXTRA_DATA_PROPERTY);
    return this;
  }

  public UiAction addExtraDataCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createExtraDataCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeExtraData(String extraData) {
    if (extraData != null) {
      updateExtraData(extraData);
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

  public UiAction updatePage(Page page) {
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

  public UiAction orderByPage(boolean asc) {
    doAddOrderBy(PAGE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createPageCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(PAGE_PROPERTY, operator, parameters);
  }

  public UiAction ignorePageCriteria() {
    super.ignoreSearchProperty(PAGE_PROPERTY);
    return this;
  }

  public UiAction addPageCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createPageCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergePage(Page page) {
    if (page != null) {
      updatePage(page);
    }
  }

  public UiAction updatePageByReferenceId(String pageId) {
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

  public UiAction updateVersion(int version) {
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

  public UiAction orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public UiAction ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public UiAction addVersionCriteria(QueryOperator operator, Object... parameters) {
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

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof UiAction) {

      UiAction dest = (UiAction) baseDest;

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

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof UiAction) {

      UiAction source = (UiAction) sourceEntity;

      mergeId(source.getId());
      mergeCode(source.getCode());
      mergeIcon(source.getIcon());
      mergeTitle(source.getTitle());
      mergeDisplayOrder(source.getDisplayOrder());
      mergeBrief(source.getBrief());
      mergeImageUrl(source.getImageUrl());
      mergeLinkToUrl(source.getLinkToUrl());
      mergeExtraData(source.getExtraData());
      mergePage(source.getPage());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof UiAction) {

      UiAction source = (UiAction) sourceEntity;

      mergeId(source.getId());
      mergeCode(source.getCode());
      mergeIcon(source.getIcon());
      mergeTitle(source.getTitle());
      mergeDisplayOrder(source.getDisplayOrder());
      mergeBrief(source.getBrief());
      mergeImageUrl(source.getImageUrl());
      mergeLinkToUrl(source.getLinkToUrl());
      mergeExtraData(source.getExtraData());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getCode(),
      getIcon(),
      getTitle(),
      getDisplayOrder(),
      getBrief(),
      getImageUrl(),
      getLinkToUrl(),
      getExtraData(),
      getPage(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    UiAction checkUiAction = Q.uiActionWithIdField().filterById(id).execute(ctx);

    return checkUiAction != null
        && !checkUiAction.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public UiAction save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("UiAction{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tcode='" + getCode() + "';");
    stringBuilder.append("\ticon='" + getIcon() + "';");
    stringBuilder.append("\ttitle='" + getTitle() + "';");
    stringBuilder.append("\tdisplayOrder='" + getDisplayOrder() + "';");
    stringBuilder.append("\tbrief='" + getBrief() + "';");
    stringBuilder.append("\timageUrl='" + getImageUrl() + "';");
    stringBuilder.append("\tlinkToUrl='" + getLinkToUrl() + "';");
    stringBuilder.append("\textraData='" + getExtraData() + "';");
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
