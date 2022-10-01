package com.doublechaintech.retailscm.mobileapp;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.mobileapp.MobileApp;
import com.doublechaintech.retailscm.page.Page;
import com.doublechaintech.retailscm.pagetype.PageType;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.utils.ModelAssurance;
import com.terapico.caf.BlobObject;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.terapico.caf.Password;
import com.terapico.caf.baseelement.PlainText;
import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.uccaf.BaseUserContext;
import com.terapico.utils.*;
import java.math.BigDecimal;
import java.util.*;
import com.doublechaintech.retailscm.search.Searcher;

public class MobileAppManagerImpl extends CustomRetailscmCheckerManager
    implements MobileAppManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens = MobileAppTokens.start().withTokenFromListName(listName).done();
    MobileApp mobileApp = (MobileApp) this.loadMobileApp(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = mobileApp.collectReferencesFromLists();
    mobileAppDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, mobileApp, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new MobileAppGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "MobileApp";

  @Override
  public MobileAppDAO daoOf(RetailscmUserContext userContext) {
    return mobileAppDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws MobileAppManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new MobileAppManagerException(message);
  }

  protected MobileApp saveMobileApp(
      RetailscmUserContext userContext, MobileApp mobileApp, String[] tokensExpr) throws Exception {
    // return getMobileAppDAO().save(mobileApp, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveMobileApp(userContext, mobileApp, tokens);
  }

  protected MobileApp saveMobileAppDetail(RetailscmUserContext userContext, MobileApp mobileApp)
      throws Exception {

    return saveMobileApp(userContext, mobileApp, allTokens());
  }

  public MobileApp loadMobileApp(
      RetailscmUserContext userContext, String mobileAppId, String[] tokensExpr) throws Exception {

    checkerOf(userContext).checkIdOfMobileApp(mobileAppId);

    checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, tokens);
    // do some calc before sent to customer?
    return present(userContext, mobileApp, tokens);
  }

  public MobileApp searchMobileApp(
      RetailscmUserContext userContext,
      String mobileAppId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMobileApp(mobileAppId);

    checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, tokens);
    // do some calc before sent to customer?
    return present(userContext, mobileApp, tokens);
  }

  protected MobileApp present(
      RetailscmUserContext userContext, MobileApp mobileApp, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, mobileApp, tokens);

    MobileApp mobileAppToPresent = mobileAppDaoOf(userContext).present(mobileApp, tokens);

    List<BaseEntity> entityListToNaming = mobileAppToPresent.collectReferencesFromLists();
    mobileAppDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, mobileApp, tokens);

    return mobileAppToPresent;
  }

  public MobileApp loadMobileAppDetail(RetailscmUserContext userContext, String mobileAppId)
      throws Exception {
    MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, allTokens());
    return present(userContext, mobileApp, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String mobileAppId) throws Exception {
    MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, viewTokens());
    markVisited(userContext, mobileApp);
    return present(userContext, mobileApp, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String mobileAppId) throws Exception {
    MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, viewTokens());
    mobileApp.summarySuffix();
    markVisited(userContext, mobileApp);
    return present(userContext, mobileApp, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String mobileAppId) throws Exception {
    MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, analyzeTokens());
    markVisited(userContext, mobileApp);
    return present(userContext, mobileApp, analyzeTokens());
  }

  protected MobileApp saveMobileApp(
      RetailscmUserContext userContext, MobileApp mobileApp, Map<String, Object> tokens)
      throws Exception {

    return mobileAppDaoOf(userContext).save(mobileApp, tokens);
  }

  protected MobileApp loadMobileApp(
      RetailscmUserContext userContext, String mobileAppId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfMobileApp(mobileAppId);

    checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);

    return mobileAppDaoOf(userContext).load(mobileAppId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, MobileApp mobileApp, Map<String, Object> tokens) {
    super.addActions(userContext, mobileApp, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, MobileApp mobileApp, Map<String, Object> tokens){

  @Override
  public List<MobileApp> searchMobileAppList(RetailscmUserContext ctx, MobileAppRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<MobileApp> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public MobileApp searchMobileApp(RetailscmUserContext ctx, MobileAppRequest pRequest) {
    pRequest.limit(0, 1);
    List<MobileApp> list = searchMobileAppList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public MobileApp createMobileApp(RetailscmUserContext userContext, String name) throws Exception {

    checkerOf(userContext).checkNameOfMobileApp(name);

    checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);

    MobileApp mobileApp = createNewMobileApp();

    mobileApp.setName(name);

    mobileApp = saveMobileApp(userContext, mobileApp, emptyOptions());

    onNewInstanceCreated(userContext, mobileApp);
    return mobileApp;
  }

  protected MobileApp createNewMobileApp() {

    return new MobileApp();
  }

  protected void checkParamsForUpdatingMobileApp(
      RetailscmUserContext userContext,
      String mobileAppId,
      int mobileAppVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
    checkerOf(userContext).checkVersionOfMobileApp(mobileAppVersion);

    if (MobileApp.NAME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNameOfMobileApp(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);
  }

  public MobileApp clone(RetailscmUserContext userContext, String fromMobileAppId)
      throws Exception {

    return mobileAppDaoOf(userContext).clone(fromMobileAppId, this.allTokens());
  }

  public MobileApp internalSaveMobileApp(RetailscmUserContext userContext, MobileApp mobileApp)
      throws Exception {
    return internalSaveMobileApp(userContext, mobileApp, allTokens());
  }

  public MobileApp internalSaveMobileApp(
      RetailscmUserContext userContext, MobileApp mobileApp, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingMobileApp(userContext, mobileAppId, mobileAppVersion, property,
    // newValueExpr, tokensExpr);

    synchronized (mobileApp) {
      // will be good when the mobileApp loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to MobileApp.
      if (mobileApp.isChanged()) {}

      // checkerOf(userContext).checkAndFixMobileApp(mobileApp);
      mobileApp = saveMobileApp(userContext, mobileApp, options);
      return mobileApp;
    }
  }

  public MobileApp updateMobileApp(
      RetailscmUserContext userContext,
      String mobileAppId,
      int mobileAppVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingMobileApp(
        userContext, mobileAppId, mobileAppVersion, property, newValueExpr, tokensExpr);

    MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, allTokens());
    if (mobileApp.getVersion() != mobileAppVersion) {
      String message =
          "The target version("
              + mobileApp.getVersion()
              + ") is not equals to version("
              + mobileAppVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (mobileApp) {
      // will be good when the mobileApp loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to MobileApp.

      mobileApp.changeProperty(property, newValueExpr);
      mobileApp = saveMobileApp(userContext, mobileApp, tokens().done());
      return present(userContext, mobileApp, mergedAllTokens(tokensExpr));
      // return saveMobileApp(userContext, mobileApp, tokens().done());
    }
  }

  public MobileApp updateMobileAppProperty(
      RetailscmUserContext userContext,
      String mobileAppId,
      int mobileAppVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingMobileApp(
        userContext, mobileAppId, mobileAppVersion, property, newValueExpr, tokensExpr);

    MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, allTokens());
    if (mobileApp.getVersion() != mobileAppVersion) {
      String message =
          "The target version("
              + mobileApp.getVersion()
              + ") is not equals to version("
              + mobileAppVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (mobileApp) {
      // will be good when the mobileApp loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to MobileApp.

      mobileApp.changeProperty(property, newValueExpr);

      mobileApp = saveMobileApp(userContext, mobileApp, tokens().done());
      return present(userContext, mobileApp, mergedAllTokens(tokensExpr));
      // return saveMobileApp(userContext, mobileApp, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected MobileAppTokens tokens() {
    return MobileAppTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return MobileAppTokens.all();
  }

  protected Map<String, Object> analyzeTokens() {
    return tokens().allTokens().analyzeAllLists().done();
  }

  protected Map<String, Object> summaryTokens() {
    return tokens().allTokens().done();
  }

  protected Map<String, Object> viewTokens() {
    return tokens()
        .allTokens()
        .sortPageListWith(Page.ID_PROPERTY, sortDesc())
        .sortPageTypeListWith(PageType.ID_PROPERTY, sortDesc())
        .done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return MobileAppTokens.mergeAll(tokens).done();
  }

  // --------------------------------------------------------------

  // --------------------------------------------------------------

  public MobileApp forgetByAll(
      RetailscmUserContext userContext, String mobileAppId, int mobileAppVersion) throws Exception {
    return forgetByAllInternal(userContext, mobileAppId, mobileAppVersion);
  }

  protected MobileApp forgetByAllInternal(
      RetailscmUserContext userContext, String mobileAppId, int mobileAppVersion) throws Exception {

    return mobileAppDaoOf(userContext).disconnectFromAll(mobileAppId, mobileAppVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new MobileAppManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingPage(
      RetailscmUserContext userContext,
      String mobileAppId,
      String pageTitle,
      String linkToUrl,
      String pageTypeId,
      int displayOrder,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMobileApp(mobileAppId);

    checkerOf(userContext).checkPageTitleOfPage(pageTitle);

    checkerOf(userContext).checkLinkToUrlOfPage(linkToUrl);

    checkerOf(userContext).checkPageTypeIdOfPage(pageTypeId);

    checkerOf(userContext).checkDisplayOrderOfPage(displayOrder);

    checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);
  }

  public MobileApp addPage(
      RetailscmUserContext userContext,
      String mobileAppId,
      String pageTitle,
      String linkToUrl,
      String pageTypeId,
      int displayOrder,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingPage(
        userContext, mobileAppId, pageTitle, linkToUrl, pageTypeId, displayOrder, tokensExpr);

    Page page = createPage(userContext, pageTitle, linkToUrl, pageTypeId, displayOrder);

    MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, emptyOptions());
    synchronized (mobileApp) {
      // Will be good when the mobileApp loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      mobileApp.addPage(page);
      mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageList().done());

      pageManagerOf(userContext).onNewInstanceCreated(userContext, page);
      return present(userContext, mobileApp, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingPageProperties(
      RetailscmUserContext userContext,
      String mobileAppId,
      String id,
      String pageTitle,
      String linkToUrl,
      int displayOrder,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
    checkerOf(userContext).checkIdOfPage(id);

    checkerOf(userContext).checkPageTitleOfPage(pageTitle);
    checkerOf(userContext).checkLinkToUrlOfPage(linkToUrl);
    checkerOf(userContext).checkDisplayOrderOfPage(displayOrder);

    checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);
  }

  public MobileApp updatePageProperties(
      RetailscmUserContext userContext,
      String mobileAppId,
      String id,
      String pageTitle,
      String linkToUrl,
      int displayOrder,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingPageProperties(
        userContext, mobileAppId, id, pageTitle, linkToUrl, displayOrder, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withPageListList()
            .searchPageListWith(Page.ID_PROPERTY, tokens().is(), id)
            .done();

    MobileApp mobileAppToUpdate = loadMobileApp(userContext, mobileAppId, options);

    if (mobileAppToUpdate.getPageList().isEmpty()) {
      throw new MobileAppManagerException("Page is NOT FOUND with id: '" + id + "'");
    }

    Page item = mobileAppToUpdate.getPageList().first();
    beforeUpdatePageProperties(
        userContext, item, mobileAppId, id, pageTitle, linkToUrl, displayOrder, tokensExpr);
    item.updatePageTitle(pageTitle);
    item.updateLinkToUrl(linkToUrl);
    item.updateDisplayOrder(displayOrder);

    // checkParamsForAddingPage(userContext,mobileAppId,name, code, used,tokensExpr);
    MobileApp mobileApp =
        saveMobileApp(userContext, mobileAppToUpdate, tokens().withPageList().done());
    synchronized (mobileApp) {
      return present(userContext, mobileApp, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdatePageProperties(
      RetailscmUserContext userContext,
      Page item,
      String mobileAppId,
      String id,
      String pageTitle,
      String linkToUrl,
      int displayOrder,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected Page createPage(
      RetailscmUserContext userContext,
      String pageTitle,
      String linkToUrl,
      String pageTypeId,
      int displayOrder)
      throws Exception {

    Page page = new Page();

    page.setPageTitle(pageTitle);
    page.setLinkToUrl(linkToUrl);
    PageType pageType = new PageType();
    pageType.setId(pageTypeId);
    page.setPageType(pageType);
    page.setDisplayOrder(displayOrder);

    return page;
  }

  protected Page createIndexedPage(String id, int version) {

    Page page = new Page();
    page.setId(id);
    page.setVersion(version);
    return page;
  }

  protected void checkParamsForRemovingPageList(
      RetailscmUserContext userContext, String mobileAppId, String pageIds[], String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
    for (String pageIdItem : pageIds) {
      checkerOf(userContext).checkIdOfPage(pageIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);
  }

  public MobileApp removePageList(
      RetailscmUserContext userContext, String mobileAppId, String pageIds[], String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingPageList(userContext, mobileAppId, pageIds, tokensExpr);

    MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, allTokens());
    synchronized (mobileApp) {
      // Will be good when the mobileApp loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      mobileAppDaoOf(userContext).planToRemovePageList(mobileApp, pageIds, allTokens());
      mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageList().done());
      deleteRelationListInGraph(userContext, mobileApp.getPageList());
      return present(userContext, mobileApp, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingPage(
      RetailscmUserContext userContext,
      String mobileAppId,
      String pageId,
      int pageVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
    checkerOf(userContext).checkIdOfPage(pageId);
    checkerOf(userContext).checkVersionOfPage(pageVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);
  }

  public MobileApp removePage(
      RetailscmUserContext userContext,
      String mobileAppId,
      String pageId,
      int pageVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingPage(userContext, mobileAppId, pageId, pageVersion, tokensExpr);

    Page page = createIndexedPage(pageId, pageVersion);
    MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, allTokens());
    synchronized (mobileApp) {
      // Will be good when the mobileApp loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      mobileApp.removePage(page);
      mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageList().done());
      deleteRelationInGraph(userContext, page);
      return present(userContext, mobileApp, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingPage(
      RetailscmUserContext userContext,
      String mobileAppId,
      String pageId,
      int pageVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
    checkerOf(userContext).checkIdOfPage(pageId);
    checkerOf(userContext).checkVersionOfPage(pageVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);
  }

  public MobileApp copyPageFrom(
      RetailscmUserContext userContext,
      String mobileAppId,
      String pageId,
      int pageVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingPage(userContext, mobileAppId, pageId, pageVersion, tokensExpr);

    Page page = createIndexedPage(pageId, pageVersion);
    MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, allTokens());
    synchronized (mobileApp) {
      // Will be good when the mobileApp loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      mobileApp.copyPageFrom(page);
      mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageList().done());

      pageManagerOf(userContext)
          .onNewInstanceCreated(
              userContext, (Page) mobileApp.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, mobileApp, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingPage(
      RetailscmUserContext userContext,
      String mobileAppId,
      String pageId,
      int pageVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
    checkerOf(userContext).checkIdOfPage(pageId);
    checkerOf(userContext).checkVersionOfPage(pageVersion);

    if (Page.PAGE_TITLE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkPageTitleOfPage(parseString(newValueExpr));
    }

    if (Page.LINK_TO_URL_PROPERTY.equals(property)) {
      checkerOf(userContext).checkLinkToUrlOfPage(parseString(newValueExpr));
    }

    if (Page.DISPLAY_ORDER_PROPERTY.equals(property)) {
      checkerOf(userContext).checkDisplayOrderOfPage(parseInt(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);
  }

  public MobileApp updatePage(
      RetailscmUserContext userContext,
      String mobileAppId,
      String pageId,
      int pageVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingPage(
        userContext, mobileAppId, pageId, pageVersion, property, newValueExpr, tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withPageList()
            .searchPageListWith(Page.ID_PROPERTY, tokens().equals(), pageId)
            .done();

    MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, loadTokens);

    synchronized (mobileApp) {
      // Will be good when the mobileApp loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // mobileApp.removePage( page );
      // make changes to AcceleraterAccount.
      Page pageIdVersionKey = createIndexedPage(pageId, pageVersion);

      Page page = mobileApp.findThePage(pageIdVersionKey);
      if (page == null) {
        throw new MobileAppManagerException(pageId + " is NOT FOUND");
      }

      beforeUpdatePage(
          userContext, page, mobileAppId, pageId, pageVersion, property, newValueExpr, tokensExpr);
      page.changeProperty(property, newValueExpr);

      mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageList().done());
      pageManagerOf(userContext).onUpdated(userContext, page, this, "updatePage");
      return present(userContext, mobileApp, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdatePage(
      RetailscmUserContext userContext,
      Page existed,
      String mobileAppId,
      String pageId,
      int pageVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  protected void checkParamsForAddingPageType(
      RetailscmUserContext userContext,
      String mobileAppId,
      String name,
      String code,
      boolean footerTab,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMobileApp(mobileAppId);

    checkerOf(userContext).checkNameOfPageType(name);

    checkerOf(userContext).checkCodeOfPageType(code);

    checkerOf(userContext).checkFooterTabOfPageType(footerTab);

    checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);
  }

  public MobileApp addPageType(
      RetailscmUserContext userContext,
      String mobileAppId,
      String name,
      String code,
      boolean footerTab,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingPageType(userContext, mobileAppId, name, code, footerTab, tokensExpr);

    PageType pageType = createPageType(userContext, name, code, footerTab);

    MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, emptyOptions());
    synchronized (mobileApp) {
      // Will be good when the mobileApp loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      mobileApp.addPageType(pageType);
      mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageTypeList().done());

      pageTypeManagerOf(userContext).onNewInstanceCreated(userContext, pageType);
      return present(userContext, mobileApp, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingPageTypeProperties(
      RetailscmUserContext userContext,
      String mobileAppId,
      String id,
      String name,
      String code,
      boolean footerTab,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
    checkerOf(userContext).checkIdOfPageType(id);

    checkerOf(userContext).checkNameOfPageType(name);
    checkerOf(userContext).checkCodeOfPageType(code);
    checkerOf(userContext).checkFooterTabOfPageType(footerTab);

    checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);
  }

  public MobileApp updatePageTypeProperties(
      RetailscmUserContext userContext,
      String mobileAppId,
      String id,
      String name,
      String code,
      boolean footerTab,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingPageTypeProperties(
        userContext, mobileAppId, id, name, code, footerTab, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withPageTypeListList()
            .searchPageTypeListWith(PageType.ID_PROPERTY, tokens().is(), id)
            .done();

    MobileApp mobileAppToUpdate = loadMobileApp(userContext, mobileAppId, options);

    if (mobileAppToUpdate.getPageTypeList().isEmpty()) {
      throw new MobileAppManagerException("PageType is NOT FOUND with id: '" + id + "'");
    }

    PageType item = mobileAppToUpdate.getPageTypeList().first();
    beforeUpdatePageTypeProperties(
        userContext, item, mobileAppId, id, name, code, footerTab, tokensExpr);
    item.updateName(name);
    item.updateCode(code);
    item.updateFooterTab(footerTab);

    // checkParamsForAddingPageType(userContext,mobileAppId,name, code, used,tokensExpr);
    MobileApp mobileApp =
        saveMobileApp(userContext, mobileAppToUpdate, tokens().withPageTypeList().done());
    synchronized (mobileApp) {
      return present(userContext, mobileApp, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdatePageTypeProperties(
      RetailscmUserContext userContext,
      PageType item,
      String mobileAppId,
      String id,
      String name,
      String code,
      boolean footerTab,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected PageType createPageType(
      RetailscmUserContext userContext, String name, String code, boolean footerTab)
      throws Exception {

    PageType pageType = new PageType();

    pageType.setName(name);
    pageType.setCode(code);
    pageType.setFooterTab(footerTab);

    return pageType;
  }

  protected PageType createIndexedPageType(String id, int version) {

    PageType pageType = new PageType();
    pageType.setId(id);
    pageType.setVersion(version);
    return pageType;
  }

  protected void checkParamsForRemovingPageTypeList(
      RetailscmUserContext userContext,
      String mobileAppId,
      String pageTypeIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
    for (String pageTypeIdItem : pageTypeIds) {
      checkerOf(userContext).checkIdOfPageType(pageTypeIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);
  }

  public MobileApp removePageTypeList(
      RetailscmUserContext userContext,
      String mobileAppId,
      String pageTypeIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingPageTypeList(userContext, mobileAppId, pageTypeIds, tokensExpr);

    MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, allTokens());
    synchronized (mobileApp) {
      // Will be good when the mobileApp loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      mobileAppDaoOf(userContext).planToRemovePageTypeList(mobileApp, pageTypeIds, allTokens());
      mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageTypeList().done());
      deleteRelationListInGraph(userContext, mobileApp.getPageTypeList());
      return present(userContext, mobileApp, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingPageType(
      RetailscmUserContext userContext,
      String mobileAppId,
      String pageTypeId,
      int pageTypeVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
    checkerOf(userContext).checkIdOfPageType(pageTypeId);
    checkerOf(userContext).checkVersionOfPageType(pageTypeVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);
  }

  public MobileApp removePageType(
      RetailscmUserContext userContext,
      String mobileAppId,
      String pageTypeId,
      int pageTypeVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingPageType(
        userContext, mobileAppId, pageTypeId, pageTypeVersion, tokensExpr);

    PageType pageType = createIndexedPageType(pageTypeId, pageTypeVersion);
    MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, allTokens());
    synchronized (mobileApp) {
      // Will be good when the mobileApp loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      mobileApp.removePageType(pageType);
      mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageTypeList().done());
      deleteRelationInGraph(userContext, pageType);
      return present(userContext, mobileApp, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingPageType(
      RetailscmUserContext userContext,
      String mobileAppId,
      String pageTypeId,
      int pageTypeVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
    checkerOf(userContext).checkIdOfPageType(pageTypeId);
    checkerOf(userContext).checkVersionOfPageType(pageTypeVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);
  }

  public MobileApp copyPageTypeFrom(
      RetailscmUserContext userContext,
      String mobileAppId,
      String pageTypeId,
      int pageTypeVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingPageType(
        userContext, mobileAppId, pageTypeId, pageTypeVersion, tokensExpr);

    PageType pageType = createIndexedPageType(pageTypeId, pageTypeVersion);
    MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, allTokens());
    synchronized (mobileApp) {
      // Will be good when the mobileApp loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      mobileApp.copyPageTypeFrom(pageType);
      mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageTypeList().done());

      pageTypeManagerOf(userContext)
          .onNewInstanceCreated(
              userContext, (PageType) mobileApp.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, mobileApp, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingPageType(
      RetailscmUserContext userContext,
      String mobileAppId,
      String pageTypeId,
      int pageTypeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMobileApp(mobileAppId);
    checkerOf(userContext).checkIdOfPageType(pageTypeId);
    checkerOf(userContext).checkVersionOfPageType(pageTypeVersion);

    if (PageType.NAME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkNameOfPageType(parseString(newValueExpr));
    }

    if (PageType.CODE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkCodeOfPageType(parseString(newValueExpr));
    }

    if (PageType.FOOTER_TAB_PROPERTY.equals(property)) {
      checkerOf(userContext).checkFooterTabOfPageType(parseBoolean(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(MobileAppManagerException.class);
  }

  public MobileApp updatePageType(
      RetailscmUserContext userContext,
      String mobileAppId,
      String pageTypeId,
      int pageTypeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingPageType(
        userContext, mobileAppId, pageTypeId, pageTypeVersion, property, newValueExpr, tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withPageTypeList()
            .searchPageTypeListWith(PageType.ID_PROPERTY, tokens().equals(), pageTypeId)
            .done();

    MobileApp mobileApp = loadMobileApp(userContext, mobileAppId, loadTokens);

    synchronized (mobileApp) {
      // Will be good when the mobileApp loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // mobileApp.removePageType( pageType );
      // make changes to AcceleraterAccount.
      PageType pageTypeIdVersionKey = createIndexedPageType(pageTypeId, pageTypeVersion);

      PageType pageType = mobileApp.findThePageType(pageTypeIdVersionKey);
      if (pageType == null) {
        throw new MobileAppManagerException(pageTypeId + " is NOT FOUND");
      }

      beforeUpdatePageType(
          userContext,
          pageType,
          mobileAppId,
          pageTypeId,
          pageTypeVersion,
          property,
          newValueExpr,
          tokensExpr);
      pageType.changeProperty(property, newValueExpr);

      mobileApp = saveMobileApp(userContext, mobileApp, tokens().withPageTypeList().done());
      pageTypeManagerOf(userContext).onUpdated(userContext, pageType, this, "updatePageType");
      return present(userContext, mobileApp, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdatePageType(
      RetailscmUserContext userContext,
      PageType existed,
      String mobileAppId,
      String pageTypeId,
      int pageTypeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(RetailscmUserContext userContext, MobileApp newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    mobileAppDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
  }

  // -----------------------------------//  登录部分处理 \\-----------------------------------
  @Override
  protected BusinessHandler getLoginProcessBizHandler(RetailscmUserContextImpl userContext) {
    return this;
  }

  public void onAuthenticationFailed(
      RetailscmUserContext userContext,
      LoginContext loginContext,
      LoginResult loginResult,
      IdentificationHandler idHandler,
      BusinessHandler bizHandler)
      throws Exception {
    // by default, failed is failed, nothing can do
  }
  // when user authenticated success, but no sec_user related, this maybe a new user login from 3-rd
  // party service.
  public void onAuthenticateNewUserLogged(
      RetailscmUserContext userContext,
      LoginContext loginContext,
      LoginResult loginResult,
      IdentificationHandler idHandler,
      BusinessHandler bizHandler)
      throws Exception {
    // Generally speaking, when authenticated user logined, we will create a new account for
    // him/her.
    // you need do it like :
    // First, you should create new data such as:
    //   MobileApp newMobileApp = this.createMobileApp(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newMobileApp
    //   UserApp uerApp = userAppManagerOf(userContext).createUserApp(userContext, secUser.getId(),
    // ...
    // Also, set it into loginContext:
    //   loginContext.getLoginTarget().setUserApp(userApp);
    // and in most case, this should be considered as "login success"
    //   loginResult.setSuccess(true);
    //
    // Since many of detailed info were depending business requirement, So,
    throw new Exception("请重载函数onAuthenticateNewUserLogged()以处理新用户登录");
  }

  protected SmartList<UserApp> getRelatedUserAppList(
      RetailscmUserContext userContext, SecUser secUser) {
    MultipleAccessKey key = new MultipleAccessKey();
    key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
    key.put(UserApp.APP_TYPE_PROPERTY, MobileApp.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(RetailscmUserContext userContext, SmartList<MobileApp> list)
      throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String mobileAppId) throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    MobileApp merchantObj = (MobileApp) this.view(userContext, mobileAppId);
    String merchantObjId = mobileAppId;
    String linkToUrl = "mobileAppManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "手机应用程序" + "详情";
    Map result = new HashMap();
    List propList = new ArrayList();
    List sections = new ArrayList();

    propList.add(
        MapUtil.put("id", "1-id")
            .put("fieldName", "id")
            .put("label", "ID")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("id", merchantObj.getId());

    propList.add(
        MapUtil.put("id", "2-name")
            .put("fieldName", "name")
            .put("label", "名称")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("name", merchantObj.getName());

    // 处理 sectionList

    // 处理Section：pageListSection
    Map pageListSection =
        ListofUtils.buildSection(
            "pageListSection",
            "页面列表",
            null,
            "",
            "页面管理",
            "pageManager/listByMobileApp/" + merchantObjId + "/",
            "auto");
    sections.add(pageListSection);

    result.put("pageListSection", ListofUtils.toShortList(merchantObj.getPageList(), "page"));

    result.put("propList", propList);
    result.put("sectionList", sections);
    result.put("pageTitle", pageTitle);
    result.put("linkToUrl", linkToUrl);

    vscope
        .field("propList", SerializeScope.EXCLUDE())
        .field("sectionList", SerializeScope.EXCLUDE())
        .field("pageTitle", SerializeScope.EXCLUDE())
        .field("linkToUrl", SerializeScope.EXCLUDE());
    userContext.forceResponseXClassHeader("com.terapico.appview.DetailPage");
    return BaseViewPage.serialize(result, vscope);
  }
}
