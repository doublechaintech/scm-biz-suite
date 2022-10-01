package com.doublechaintech.retailscm.goodsshelfstockcount;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.goodsshelf.CandidateGoodsShelf;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrack;
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

public class GoodsShelfStockCountManagerImpl extends CustomRetailscmCheckerManager
    implements GoodsShelfStockCountManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens =
        GoodsShelfStockCountTokens.start().withTokenFromListName(listName).done();
    GoodsShelfStockCount goodsShelfStockCount =
        (GoodsShelfStockCount) this.loadGoodsShelfStockCount(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = goodsShelfStockCount.collectReferencesFromLists();
    goodsShelfStockCountDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, goodsShelfStockCount, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new GoodsShelfStockCountGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "GoodsShelfStockCount";

  @Override
  public GoodsShelfStockCountDAO daoOf(RetailscmUserContext userContext) {
    return goodsShelfStockCountDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value)
      throws GoodsShelfStockCountManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new GoodsShelfStockCountManagerException(message);
  }

  protected GoodsShelfStockCount saveGoodsShelfStockCount(
      RetailscmUserContext userContext,
      GoodsShelfStockCount goodsShelfStockCount,
      String[] tokensExpr)
      throws Exception {
    // return getGoodsShelfStockCountDAO().save(goodsShelfStockCount, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens);
  }

  protected GoodsShelfStockCount saveGoodsShelfStockCountDetail(
      RetailscmUserContext userContext, GoodsShelfStockCount goodsShelfStockCount)
      throws Exception {

    return saveGoodsShelfStockCount(userContext, goodsShelfStockCount, allTokens());
  }

  public GoodsShelfStockCount loadGoodsShelfStockCount(
      RetailscmUserContext userContext, String goodsShelfStockCountId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    GoodsShelfStockCount goodsShelfStockCount =
        loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, tokens);
    // do some calc before sent to customer?
    return present(userContext, goodsShelfStockCount, tokens);
  }

  public GoodsShelfStockCount searchGoodsShelfStockCount(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    GoodsShelfStockCount goodsShelfStockCount =
        loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, tokens);
    // do some calc before sent to customer?
    return present(userContext, goodsShelfStockCount, tokens);
  }

  protected GoodsShelfStockCount present(
      RetailscmUserContext userContext,
      GoodsShelfStockCount goodsShelfStockCount,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, goodsShelfStockCount, tokens);

    GoodsShelfStockCount goodsShelfStockCountToPresent =
        goodsShelfStockCountDaoOf(userContext).present(goodsShelfStockCount, tokens);

    List<BaseEntity> entityListToNaming =
        goodsShelfStockCountToPresent.collectReferencesFromLists();
    goodsShelfStockCountDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, goodsShelfStockCount, tokens);

    return goodsShelfStockCountToPresent;
  }

  public GoodsShelfStockCount loadGoodsShelfStockCountDetail(
      RetailscmUserContext userContext, String goodsShelfStockCountId) throws Exception {
    GoodsShelfStockCount goodsShelfStockCount =
        loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());
    return present(userContext, goodsShelfStockCount, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String goodsShelfStockCountId)
      throws Exception {
    GoodsShelfStockCount goodsShelfStockCount =
        loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, viewTokens());
    markVisited(userContext, goodsShelfStockCount);
    return present(userContext, goodsShelfStockCount, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String goodsShelfStockCountId)
      throws Exception {
    GoodsShelfStockCount goodsShelfStockCount =
        loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, viewTokens());
    goodsShelfStockCount.summarySuffix();
    markVisited(userContext, goodsShelfStockCount);
    return present(userContext, goodsShelfStockCount, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String goodsShelfStockCountId)
      throws Exception {
    GoodsShelfStockCount goodsShelfStockCount =
        loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, analyzeTokens());
    markVisited(userContext, goodsShelfStockCount);
    return present(userContext, goodsShelfStockCount, analyzeTokens());
  }

  protected GoodsShelfStockCount saveGoodsShelfStockCount(
      RetailscmUserContext userContext,
      GoodsShelfStockCount goodsShelfStockCount,
      Map<String, Object> tokens)
      throws Exception {

    return goodsShelfStockCountDaoOf(userContext).save(goodsShelfStockCount, tokens);
  }

  protected GoodsShelfStockCount loadGoodsShelfStockCount(
      RetailscmUserContext userContext, String goodsShelfStockCountId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);

    return goodsShelfStockCountDaoOf(userContext).load(goodsShelfStockCountId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      GoodsShelfStockCount goodsShelfStockCount,
      Map<String, Object> tokens) {
    super.addActions(userContext, goodsShelfStockCount, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, GoodsShelfStockCount goodsShelfStockCount, Map<String, Object> tokens){

  @Override
  public List<GoodsShelfStockCount> searchGoodsShelfStockCountList(
      RetailscmUserContext ctx, GoodsShelfStockCountRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<GoodsShelfStockCount> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public GoodsShelfStockCount searchGoodsShelfStockCount(
      RetailscmUserContext ctx, GoodsShelfStockCountRequest pRequest) {
    pRequest.limit(0, 1);
    List<GoodsShelfStockCount> list = searchGoodsShelfStockCountList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public GoodsShelfStockCount createGoodsShelfStockCount(
      RetailscmUserContext userContext,
      String title,
      Date countTime,
      String summary,
      String shelfId)
      throws Exception {

    checkerOf(userContext).checkTitleOfGoodsShelfStockCount(title);
    checkerOf(userContext).checkCountTimeOfGoodsShelfStockCount(countTime);
    checkerOf(userContext).checkSummaryOfGoodsShelfStockCount(summary);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);

    GoodsShelfStockCount goodsShelfStockCount = createNewGoodsShelfStockCount();

    goodsShelfStockCount.setTitle(title);
    goodsShelfStockCount.setCountTime(countTime);
    goodsShelfStockCount.setSummary(summary);

    GoodsShelf shelf = loadGoodsShelf(userContext, shelfId, emptyOptions());
    goodsShelfStockCount.setShelf(shelf);

    goodsShelfStockCount =
        saveGoodsShelfStockCount(userContext, goodsShelfStockCount, emptyOptions());

    onNewInstanceCreated(userContext, goodsShelfStockCount);
    return goodsShelfStockCount;
  }

  protected GoodsShelfStockCount createNewGoodsShelfStockCount() {

    return new GoodsShelfStockCount();
  }

  protected void checkParamsForUpdatingGoodsShelfStockCount(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      int goodsShelfStockCountVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
    checkerOf(userContext).checkVersionOfGoodsShelfStockCount(goodsShelfStockCountVersion);

    if (GoodsShelfStockCount.TITLE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkTitleOfGoodsShelfStockCount(parseString(newValueExpr));
    }
    if (GoodsShelfStockCount.COUNT_TIME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkCountTimeOfGoodsShelfStockCount(parseDate(newValueExpr));
    }
    if (GoodsShelfStockCount.SUMMARY_PROPERTY.equals(property)) {

      checkerOf(userContext).checkSummaryOfGoodsShelfStockCount(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);
  }

  public GoodsShelfStockCount clone(
      RetailscmUserContext userContext, String fromGoodsShelfStockCountId) throws Exception {

    return goodsShelfStockCountDaoOf(userContext)
        .clone(fromGoodsShelfStockCountId, this.allTokens());
  }

  public GoodsShelfStockCount internalSaveGoodsShelfStockCount(
      RetailscmUserContext userContext, GoodsShelfStockCount goodsShelfStockCount)
      throws Exception {
    return internalSaveGoodsShelfStockCount(userContext, goodsShelfStockCount, allTokens());
  }

  public GoodsShelfStockCount internalSaveGoodsShelfStockCount(
      RetailscmUserContext userContext,
      GoodsShelfStockCount goodsShelfStockCount,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingGoodsShelfStockCount(userContext, goodsShelfStockCountId,
    // goodsShelfStockCountVersion, property, newValueExpr, tokensExpr);

    synchronized (goodsShelfStockCount) {
      // will be good when the goodsShelfStockCount loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to GoodsShelfStockCount.
      if (goodsShelfStockCount.isChanged()) {}

      // checkerOf(userContext).checkAndFixGoodsShelfStockCount(goodsShelfStockCount);
      goodsShelfStockCount = saveGoodsShelfStockCount(userContext, goodsShelfStockCount, options);
      return goodsShelfStockCount;
    }
  }

  public GoodsShelfStockCount updateGoodsShelfStockCount(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      int goodsShelfStockCountVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingGoodsShelfStockCount(
        userContext,
        goodsShelfStockCountId,
        goodsShelfStockCountVersion,
        property,
        newValueExpr,
        tokensExpr);

    GoodsShelfStockCount goodsShelfStockCount =
        loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());
    if (goodsShelfStockCount.getVersion() != goodsShelfStockCountVersion) {
      String message =
          "The target version("
              + goodsShelfStockCount.getVersion()
              + ") is not equals to version("
              + goodsShelfStockCountVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (goodsShelfStockCount) {
      // will be good when the goodsShelfStockCount loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to GoodsShelfStockCount.

      goodsShelfStockCount.changeProperty(property, newValueExpr);
      goodsShelfStockCount =
          saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens().done());
      return present(userContext, goodsShelfStockCount, mergedAllTokens(tokensExpr));
      // return saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens().done());
    }
  }

  public GoodsShelfStockCount updateGoodsShelfStockCountProperty(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      int goodsShelfStockCountVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingGoodsShelfStockCount(
        userContext,
        goodsShelfStockCountId,
        goodsShelfStockCountVersion,
        property,
        newValueExpr,
        tokensExpr);

    GoodsShelfStockCount goodsShelfStockCount =
        loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());
    if (goodsShelfStockCount.getVersion() != goodsShelfStockCountVersion) {
      String message =
          "The target version("
              + goodsShelfStockCount.getVersion()
              + ") is not equals to version("
              + goodsShelfStockCountVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (goodsShelfStockCount) {
      // will be good when the goodsShelfStockCount loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to GoodsShelfStockCount.

      goodsShelfStockCount.changeProperty(property, newValueExpr);

      goodsShelfStockCount =
          saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens().done());
      return present(userContext, goodsShelfStockCount, mergedAllTokens(tokensExpr));
      // return saveGoodsShelfStockCount(userContext, goodsShelfStockCount, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected GoodsShelfStockCountTokens tokens() {
    return GoodsShelfStockCountTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return GoodsShelfStockCountTokens.all();
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
        .sortStockCountIssueTrackListWith(StockCountIssueTrack.ID_PROPERTY, sortDesc())
        .done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return GoodsShelfStockCountTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherShelf(
      RetailscmUserContext userContext, String goodsShelfStockCountId, String anotherShelfId)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
    checkerOf(userContext).checkIdOfGoodsShelf(anotherShelfId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);
  }

  public GoodsShelfStockCount transferToAnotherShelf(
      RetailscmUserContext userContext, String goodsShelfStockCountId, String anotherShelfId)
      throws Exception {
    checkParamsForTransferingAnotherShelf(userContext, goodsShelfStockCountId, anotherShelfId);

    GoodsShelfStockCount goodsShelfStockCount =
        loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());
    synchronized (goodsShelfStockCount) {
      // will be good when the goodsShelfStockCount loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      GoodsShelf shelf = loadGoodsShelf(userContext, anotherShelfId, emptyOptions());
      goodsShelfStockCount.updateShelf(shelf);

      goodsShelfStockCount =
          saveGoodsShelfStockCount(userContext, goodsShelfStockCount, emptyOptions());

      return present(userContext, goodsShelfStockCount, allTokens());
    }
  }

  public CandidateGoodsShelf requestCandidateShelf(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateGoodsShelf result = new CandidateGoodsShelf();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("location");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<GoodsShelf> candidateList =
        goodsShelfDaoOf(userContext)
            .requestCandidateGoodsShelfForGoodsShelfStockCount(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected GoodsShelf loadGoodsShelf(
      RetailscmUserContext userContext, String newShelfId, Map<String, Object> options)
      throws Exception {

    return goodsShelfDaoOf(userContext).load(newShelfId, options);
  }

  // --------------------------------------------------------------

  public GoodsShelfStockCount forgetByAll(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      int goodsShelfStockCountVersion)
      throws Exception {
    return forgetByAllInternal(userContext, goodsShelfStockCountId, goodsShelfStockCountVersion);
  }

  protected GoodsShelfStockCount forgetByAllInternal(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      int goodsShelfStockCountVersion)
      throws Exception {

    return goodsShelfStockCountDaoOf(userContext)
        .disconnectFromAll(goodsShelfStockCountId, goodsShelfStockCountVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new GoodsShelfStockCountManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingStockCountIssueTrack(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      String title,
      Date countTime,
      String summary,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);

    checkerOf(userContext).checkTitleOfStockCountIssueTrack(title);

    checkerOf(userContext).checkCountTimeOfStockCountIssueTrack(countTime);

    checkerOf(userContext).checkSummaryOfStockCountIssueTrack(summary);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);
  }

  public GoodsShelfStockCount addStockCountIssueTrack(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      String title,
      Date countTime,
      String summary,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingStockCountIssueTrack(
        userContext, goodsShelfStockCountId, title, countTime, summary, tokensExpr);

    StockCountIssueTrack stockCountIssueTrack =
        createStockCountIssueTrack(userContext, title, countTime, summary);

    GoodsShelfStockCount goodsShelfStockCount =
        loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, emptyOptions());
    synchronized (goodsShelfStockCount) {
      // Will be good when the goodsShelfStockCount loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      goodsShelfStockCount.addStockCountIssueTrack(stockCountIssueTrack);
      goodsShelfStockCount =
          saveGoodsShelfStockCount(
              userContext, goodsShelfStockCount, tokens().withStockCountIssueTrackList().done());

      stockCountIssueTrackManagerOf(userContext)
          .onNewInstanceCreated(userContext, stockCountIssueTrack);
      return present(userContext, goodsShelfStockCount, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingStockCountIssueTrackProperties(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      String id,
      String title,
      Date countTime,
      String summary,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
    checkerOf(userContext).checkIdOfStockCountIssueTrack(id);

    checkerOf(userContext).checkTitleOfStockCountIssueTrack(title);
    checkerOf(userContext).checkCountTimeOfStockCountIssueTrack(countTime);
    checkerOf(userContext).checkSummaryOfStockCountIssueTrack(summary);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);
  }

  public GoodsShelfStockCount updateStockCountIssueTrackProperties(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      String id,
      String title,
      Date countTime,
      String summary,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingStockCountIssueTrackProperties(
        userContext, goodsShelfStockCountId, id, title, countTime, summary, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withStockCountIssueTrackListList()
            .searchStockCountIssueTrackListWith(StockCountIssueTrack.ID_PROPERTY, tokens().is(), id)
            .done();

    GoodsShelfStockCount goodsShelfStockCountToUpdate =
        loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, options);

    if (goodsShelfStockCountToUpdate.getStockCountIssueTrackList().isEmpty()) {
      throw new GoodsShelfStockCountManagerException(
          "StockCountIssueTrack is NOT FOUND with id: '" + id + "'");
    }

    StockCountIssueTrack item = goodsShelfStockCountToUpdate.getStockCountIssueTrackList().first();
    beforeUpdateStockCountIssueTrackProperties(
        userContext, item, goodsShelfStockCountId, id, title, countTime, summary, tokensExpr);
    item.updateTitle(title);
    item.updateCountTime(countTime);
    item.updateSummary(summary);

    // checkParamsForAddingStockCountIssueTrack(userContext,goodsShelfStockCountId,name, code,
    // used,tokensExpr);
    GoodsShelfStockCount goodsShelfStockCount =
        saveGoodsShelfStockCount(
            userContext,
            goodsShelfStockCountToUpdate,
            tokens().withStockCountIssueTrackList().done());
    synchronized (goodsShelfStockCount) {
      return present(userContext, goodsShelfStockCount, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateStockCountIssueTrackProperties(
      RetailscmUserContext userContext,
      StockCountIssueTrack item,
      String goodsShelfStockCountId,
      String id,
      String title,
      Date countTime,
      String summary,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected StockCountIssueTrack createStockCountIssueTrack(
      RetailscmUserContext userContext, String title, Date countTime, String summary)
      throws Exception {

    StockCountIssueTrack stockCountIssueTrack = new StockCountIssueTrack();

    stockCountIssueTrack.setTitle(title);
    stockCountIssueTrack.setCountTime(countTime);
    stockCountIssueTrack.setSummary(summary);

    return stockCountIssueTrack;
  }

  protected StockCountIssueTrack createIndexedStockCountIssueTrack(String id, int version) {

    StockCountIssueTrack stockCountIssueTrack = new StockCountIssueTrack();
    stockCountIssueTrack.setId(id);
    stockCountIssueTrack.setVersion(version);
    return stockCountIssueTrack;
  }

  protected void checkParamsForRemovingStockCountIssueTrackList(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      String stockCountIssueTrackIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
    for (String stockCountIssueTrackIdItem : stockCountIssueTrackIds) {
      checkerOf(userContext).checkIdOfStockCountIssueTrack(stockCountIssueTrackIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);
  }

  public GoodsShelfStockCount removeStockCountIssueTrackList(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      String stockCountIssueTrackIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingStockCountIssueTrackList(
        userContext, goodsShelfStockCountId, stockCountIssueTrackIds, tokensExpr);

    GoodsShelfStockCount goodsShelfStockCount =
        loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());
    synchronized (goodsShelfStockCount) {
      // Will be good when the goodsShelfStockCount loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      goodsShelfStockCountDaoOf(userContext)
          .planToRemoveStockCountIssueTrackList(
              goodsShelfStockCount, stockCountIssueTrackIds, allTokens());
      goodsShelfStockCount =
          saveGoodsShelfStockCount(
              userContext, goodsShelfStockCount, tokens().withStockCountIssueTrackList().done());
      deleteRelationListInGraph(userContext, goodsShelfStockCount.getStockCountIssueTrackList());
      return present(userContext, goodsShelfStockCount, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingStockCountIssueTrack(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      String stockCountIssueTrackId,
      int stockCountIssueTrackVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
    checkerOf(userContext).checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
    checkerOf(userContext).checkVersionOfStockCountIssueTrack(stockCountIssueTrackVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);
  }

  public GoodsShelfStockCount removeStockCountIssueTrack(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      String stockCountIssueTrackId,
      int stockCountIssueTrackVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingStockCountIssueTrack(
        userContext,
        goodsShelfStockCountId,
        stockCountIssueTrackId,
        stockCountIssueTrackVersion,
        tokensExpr);

    StockCountIssueTrack stockCountIssueTrack =
        createIndexedStockCountIssueTrack(stockCountIssueTrackId, stockCountIssueTrackVersion);
    GoodsShelfStockCount goodsShelfStockCount =
        loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());
    synchronized (goodsShelfStockCount) {
      // Will be good when the goodsShelfStockCount loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      goodsShelfStockCount.removeStockCountIssueTrack(stockCountIssueTrack);
      goodsShelfStockCount =
          saveGoodsShelfStockCount(
              userContext, goodsShelfStockCount, tokens().withStockCountIssueTrackList().done());
      deleteRelationInGraph(userContext, stockCountIssueTrack);
      return present(userContext, goodsShelfStockCount, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingStockCountIssueTrack(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      String stockCountIssueTrackId,
      int stockCountIssueTrackVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
    checkerOf(userContext).checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
    checkerOf(userContext).checkVersionOfStockCountIssueTrack(stockCountIssueTrackVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);
  }

  public GoodsShelfStockCount copyStockCountIssueTrackFrom(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      String stockCountIssueTrackId,
      int stockCountIssueTrackVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingStockCountIssueTrack(
        userContext,
        goodsShelfStockCountId,
        stockCountIssueTrackId,
        stockCountIssueTrackVersion,
        tokensExpr);

    StockCountIssueTrack stockCountIssueTrack =
        createIndexedStockCountIssueTrack(stockCountIssueTrackId, stockCountIssueTrackVersion);
    GoodsShelfStockCount goodsShelfStockCount =
        loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, allTokens());
    synchronized (goodsShelfStockCount) {
      // Will be good when the goodsShelfStockCount loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      goodsShelfStockCount.copyStockCountIssueTrackFrom(stockCountIssueTrack);
      goodsShelfStockCount =
          saveGoodsShelfStockCount(
              userContext, goodsShelfStockCount, tokens().withStockCountIssueTrackList().done());

      stockCountIssueTrackManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (StockCountIssueTrack)
                  goodsShelfStockCount.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, goodsShelfStockCount, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingStockCountIssueTrack(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      String stockCountIssueTrackId,
      int stockCountIssueTrackVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfGoodsShelfStockCount(goodsShelfStockCountId);
    checkerOf(userContext).checkIdOfStockCountIssueTrack(stockCountIssueTrackId);
    checkerOf(userContext).checkVersionOfStockCountIssueTrack(stockCountIssueTrackVersion);

    if (StockCountIssueTrack.TITLE_PROPERTY.equals(property)) {
      checkerOf(userContext).checkTitleOfStockCountIssueTrack(parseString(newValueExpr));
    }

    if (StockCountIssueTrack.COUNT_TIME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkCountTimeOfStockCountIssueTrack(parseDate(newValueExpr));
    }

    if (StockCountIssueTrack.SUMMARY_PROPERTY.equals(property)) {
      checkerOf(userContext).checkSummaryOfStockCountIssueTrack(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(GoodsShelfStockCountManagerException.class);
  }

  public GoodsShelfStockCount updateStockCountIssueTrack(
      RetailscmUserContext userContext,
      String goodsShelfStockCountId,
      String stockCountIssueTrackId,
      int stockCountIssueTrackVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingStockCountIssueTrack(
        userContext,
        goodsShelfStockCountId,
        stockCountIssueTrackId,
        stockCountIssueTrackVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withStockCountIssueTrackList()
            .searchStockCountIssueTrackListWith(
                StockCountIssueTrack.ID_PROPERTY, tokens().equals(), stockCountIssueTrackId)
            .done();

    GoodsShelfStockCount goodsShelfStockCount =
        loadGoodsShelfStockCount(userContext, goodsShelfStockCountId, loadTokens);

    synchronized (goodsShelfStockCount) {
      // Will be good when the goodsShelfStockCount loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // goodsShelfStockCount.removeStockCountIssueTrack( stockCountIssueTrack );
      // make changes to AcceleraterAccount.
      StockCountIssueTrack stockCountIssueTrackIdVersionKey =
          createIndexedStockCountIssueTrack(stockCountIssueTrackId, stockCountIssueTrackVersion);

      StockCountIssueTrack stockCountIssueTrack =
          goodsShelfStockCount.findTheStockCountIssueTrack(stockCountIssueTrackIdVersionKey);
      if (stockCountIssueTrack == null) {
        throw new GoodsShelfStockCountManagerException(stockCountIssueTrackId + " is NOT FOUND");
      }

      beforeUpdateStockCountIssueTrack(
          userContext,
          stockCountIssueTrack,
          goodsShelfStockCountId,
          stockCountIssueTrackId,
          stockCountIssueTrackVersion,
          property,
          newValueExpr,
          tokensExpr);
      stockCountIssueTrack.changeProperty(property, newValueExpr);

      goodsShelfStockCount =
          saveGoodsShelfStockCount(
              userContext, goodsShelfStockCount, tokens().withStockCountIssueTrackList().done());
      stockCountIssueTrackManagerOf(userContext)
          .onUpdated(userContext, stockCountIssueTrack, this, "updateStockCountIssueTrack");
      return present(userContext, goodsShelfStockCount, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateStockCountIssueTrack(
      RetailscmUserContext userContext,
      StockCountIssueTrack existed,
      String goodsShelfStockCountId,
      String stockCountIssueTrackId,
      int stockCountIssueTrackVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, GoodsShelfStockCount newCreated) throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    goodsShelfStockCountDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   GoodsShelfStockCount newGoodsShelfStockCount = this.createGoodsShelfStockCount(userContext,
    // ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newGoodsShelfStockCount
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
    key.put(UserApp.APP_TYPE_PROPERTY, GoodsShelfStockCount.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<GoodsShelfStockCount> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<GoodsShelf> shelfList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, GoodsShelf.class);
    userContext.getDAOGroup().enhanceList(shelfList, GoodsShelf.class);
  }

  public Object listByShelf(RetailscmUserContext userContext, String shelfId) throws Exception {
    return listPageByShelf(userContext, shelfId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByShelf(
      RetailscmUserContext userContext, String shelfId, int start, int count) throws Exception {
    SmartList<GoodsShelfStockCount> list =
        goodsShelfStockCountDaoOf(userContext)
            .findGoodsShelfStockCountByShelf(shelfId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(GoodsShelfStockCount.class);
    page.setContainerObject(GoodsShelf.withId(shelfId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("货架库存盘点列表");
    page.setRequestName("listByShelf");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByShelf/%s/", getBeanName(), shelfId)));

    page.assemblerContent(userContext, "listByShelf");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String goodsShelfStockCountId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    GoodsShelfStockCount merchantObj =
        (GoodsShelfStockCount) this.view(userContext, goodsShelfStockCountId);
    String merchantObjId = goodsShelfStockCountId;
    String linkToUrl = "goodsShelfStockCountManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "货架库存盘点" + "详情";
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
        MapUtil.put("id", "2-title")
            .put("fieldName", "title")
            .put("label", "头衔")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("title", merchantObj.getTitle());

    propList.add(
        MapUtil.put("id", "3-countTime")
            .put("fieldName", "countTime")
            .put("label", "计数时间")
            .put("type", "date")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("countTime", merchantObj.getCountTime());

    propList.add(
        MapUtil.put("id", "4-summary")
            .put("fieldName", "summary")
            .put("label", "概览")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("summary", merchantObj.getSummary());

    propList.add(
        MapUtil.put("id", "5-shelf")
            .put("fieldName", "shelf")
            .put("label", "架")
            .put("type", "auto")
            .put("linkToUrl", "goodsShelfManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"location\",\"imageList\":\"\"}")
            .into_map());
    result.put("shelf", merchantObj.getShelf());

    // 处理 sectionList

    // 处理Section：stockCountIssueTrackListSection
    Map stockCountIssueTrackListSection =
        ListofUtils.buildSection(
            "stockCountIssueTrackListSection",
            "盘点发行跟踪清单",
            null,
            "",
            "__no_group",
            "stockCountIssueTrackManager/listByStockCount/" + merchantObjId + "/",
            "auto");
    sections.add(stockCountIssueTrackListSection);

    result.put(
        "stockCountIssueTrackListSection",
        ListofUtils.toShortList(merchantObj.getStockCountIssueTrackList(), "stockCountIssueTrack"));

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
