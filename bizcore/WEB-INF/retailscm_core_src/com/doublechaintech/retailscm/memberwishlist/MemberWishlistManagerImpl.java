package com.doublechaintech.retailscm.memberwishlist;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.memberwishlist.MemberWishlist;
import com.doublechaintech.retailscm.memberwishlistproduct.MemberWishlistProduct;
import com.doublechaintech.retailscm.retailstoremember.CandidateRetailStoreMember;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
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

public class MemberWishlistManagerImpl extends CustomRetailscmCheckerManager
    implements MemberWishlistManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens =
        MemberWishlistTokens.start().withTokenFromListName(listName).done();
    MemberWishlist memberWishlist =
        (MemberWishlist) this.loadMemberWishlist(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = memberWishlist.collectReferencesFromLists();
    memberWishlistDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, memberWishlist, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new MemberWishlistGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "MemberWishlist";

  @Override
  public MemberWishlistDAO daoOf(RetailscmUserContext userContext) {
    return memberWishlistDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws MemberWishlistManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new MemberWishlistManagerException(message);
  }

  protected MemberWishlist saveMemberWishlist(
      RetailscmUserContext userContext, MemberWishlist memberWishlist, String[] tokensExpr)
      throws Exception {
    // return getMemberWishlistDAO().save(memberWishlist, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveMemberWishlist(userContext, memberWishlist, tokens);
  }

  protected MemberWishlist saveMemberWishlistDetail(
      RetailscmUserContext userContext, MemberWishlist memberWishlist) throws Exception {

    return saveMemberWishlist(userContext, memberWishlist, allTokens());
  }

  public MemberWishlist loadMemberWishlist(
      RetailscmUserContext userContext, String memberWishlistId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMemberWishlist(memberWishlistId);

    checkerOf(userContext).throwExceptionIfHasErrors(MemberWishlistManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, tokens);
    // do some calc before sent to customer?
    return present(userContext, memberWishlist, tokens);
  }

  public MemberWishlist searchMemberWishlist(
      RetailscmUserContext userContext,
      String memberWishlistId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMemberWishlist(memberWishlistId);

    checkerOf(userContext).throwExceptionIfHasErrors(MemberWishlistManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, tokens);
    // do some calc before sent to customer?
    return present(userContext, memberWishlist, tokens);
  }

  protected MemberWishlist present(
      RetailscmUserContext userContext, MemberWishlist memberWishlist, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, memberWishlist, tokens);

    MemberWishlist memberWishlistToPresent =
        memberWishlistDaoOf(userContext).present(memberWishlist, tokens);

    List<BaseEntity> entityListToNaming = memberWishlistToPresent.collectReferencesFromLists();
    memberWishlistDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, memberWishlist, tokens);

    return memberWishlistToPresent;
  }

  public MemberWishlist loadMemberWishlistDetail(
      RetailscmUserContext userContext, String memberWishlistId) throws Exception {
    MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, allTokens());
    return present(userContext, memberWishlist, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String memberWishlistId) throws Exception {
    MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, viewTokens());
    markVisited(userContext, memberWishlist);
    return present(userContext, memberWishlist, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String memberWishlistId)
      throws Exception {
    MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, viewTokens());
    memberWishlist.summarySuffix();
    markVisited(userContext, memberWishlist);
    return present(userContext, memberWishlist, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String memberWishlistId)
      throws Exception {
    MemberWishlist memberWishlist =
        loadMemberWishlist(userContext, memberWishlistId, analyzeTokens());
    markVisited(userContext, memberWishlist);
    return present(userContext, memberWishlist, analyzeTokens());
  }

  protected MemberWishlist saveMemberWishlist(
      RetailscmUserContext userContext, MemberWishlist memberWishlist, Map<String, Object> tokens)
      throws Exception {

    return memberWishlistDaoOf(userContext).save(memberWishlist, tokens);
  }

  protected MemberWishlist loadMemberWishlist(
      RetailscmUserContext userContext, String memberWishlistId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfMemberWishlist(memberWishlistId);

    checkerOf(userContext).throwExceptionIfHasErrors(MemberWishlistManagerException.class);

    return memberWishlistDaoOf(userContext).load(memberWishlistId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, MemberWishlist memberWishlist, Map<String, Object> tokens) {
    super.addActions(userContext, memberWishlist, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, MemberWishlist memberWishlist, Map<String, Object> tokens){

  @Override
  public List<MemberWishlist> searchMemberWishlistList(
      RetailscmUserContext ctx, MemberWishlistRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<MemberWishlist> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public MemberWishlist searchMemberWishlist(
      RetailscmUserContext ctx, MemberWishlistRequest pRequest) {
    pRequest.limit(0, 1);
    List<MemberWishlist> list = searchMemberWishlistList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public MemberWishlist createMemberWishlist(
      RetailscmUserContext userContext, String name, String ownerId) throws Exception {

    checkerOf(userContext).checkNameOfMemberWishlist(name);

    checkerOf(userContext).throwExceptionIfHasErrors(MemberWishlistManagerException.class);

    MemberWishlist memberWishlist = createNewMemberWishlist();

    memberWishlist.setName(name);

    RetailStoreMember owner = loadRetailStoreMember(userContext, ownerId, emptyOptions());
    memberWishlist.setOwner(owner);

    memberWishlist = saveMemberWishlist(userContext, memberWishlist, emptyOptions());

    onNewInstanceCreated(userContext, memberWishlist);
    return memberWishlist;
  }

  protected MemberWishlist createNewMemberWishlist() {

    return new MemberWishlist();
  }

  protected void checkParamsForUpdatingMemberWishlist(
      RetailscmUserContext userContext,
      String memberWishlistId,
      int memberWishlistVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMemberWishlist(memberWishlistId);
    checkerOf(userContext).checkVersionOfMemberWishlist(memberWishlistVersion);

    if (MemberWishlist.NAME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNameOfMemberWishlist(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(MemberWishlistManagerException.class);
  }

  public MemberWishlist clone(RetailscmUserContext userContext, String fromMemberWishlistId)
      throws Exception {

    return memberWishlistDaoOf(userContext).clone(fromMemberWishlistId, this.allTokens());
  }

  public MemberWishlist internalSaveMemberWishlist(
      RetailscmUserContext userContext, MemberWishlist memberWishlist) throws Exception {
    return internalSaveMemberWishlist(userContext, memberWishlist, allTokens());
  }

  public MemberWishlist internalSaveMemberWishlist(
      RetailscmUserContext userContext, MemberWishlist memberWishlist, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingMemberWishlist(userContext, memberWishlistId, memberWishlistVersion,
    // property, newValueExpr, tokensExpr);

    synchronized (memberWishlist) {
      // will be good when the memberWishlist loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to MemberWishlist.
      if (memberWishlist.isChanged()) {}

      // checkerOf(userContext).checkAndFixMemberWishlist(memberWishlist);
      memberWishlist = saveMemberWishlist(userContext, memberWishlist, options);
      return memberWishlist;
    }
  }

  public MemberWishlist updateMemberWishlist(
      RetailscmUserContext userContext,
      String memberWishlistId,
      int memberWishlistVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingMemberWishlist(
        userContext, memberWishlistId, memberWishlistVersion, property, newValueExpr, tokensExpr);

    MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, allTokens());
    if (memberWishlist.getVersion() != memberWishlistVersion) {
      String message =
          "The target version("
              + memberWishlist.getVersion()
              + ") is not equals to version("
              + memberWishlistVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (memberWishlist) {
      // will be good when the memberWishlist loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to MemberWishlist.

      memberWishlist.changeProperty(property, newValueExpr);
      memberWishlist = saveMemberWishlist(userContext, memberWishlist, tokens().done());
      return present(userContext, memberWishlist, mergedAllTokens(tokensExpr));
      // return saveMemberWishlist(userContext, memberWishlist, tokens().done());
    }
  }

  public MemberWishlist updateMemberWishlistProperty(
      RetailscmUserContext userContext,
      String memberWishlistId,
      int memberWishlistVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingMemberWishlist(
        userContext, memberWishlistId, memberWishlistVersion, property, newValueExpr, tokensExpr);

    MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, allTokens());
    if (memberWishlist.getVersion() != memberWishlistVersion) {
      String message =
          "The target version("
              + memberWishlist.getVersion()
              + ") is not equals to version("
              + memberWishlistVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (memberWishlist) {
      // will be good when the memberWishlist loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to MemberWishlist.

      memberWishlist.changeProperty(property, newValueExpr);

      memberWishlist = saveMemberWishlist(userContext, memberWishlist, tokens().done());
      return present(userContext, memberWishlist, mergedAllTokens(tokensExpr));
      // return saveMemberWishlist(userContext, memberWishlist, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected MemberWishlistTokens tokens() {
    return MemberWishlistTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return MemberWishlistTokens.all();
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
        .sortMemberWishlistProductListWith(MemberWishlistProduct.ID_PROPERTY, sortDesc())
        .done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return MemberWishlistTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherOwner(
      RetailscmUserContext userContext, String memberWishlistId, String anotherOwnerId)
      throws Exception {

    checkerOf(userContext).checkIdOfMemberWishlist(memberWishlistId);
    checkerOf(userContext)
        .checkIdOfRetailStoreMember(anotherOwnerId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(MemberWishlistManagerException.class);
  }

  public MemberWishlist transferToAnotherOwner(
      RetailscmUserContext userContext, String memberWishlistId, String anotherOwnerId)
      throws Exception {
    checkParamsForTransferingAnotherOwner(userContext, memberWishlistId, anotherOwnerId);

    MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, allTokens());
    synchronized (memberWishlist) {
      // will be good when the memberWishlist loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      RetailStoreMember owner = loadRetailStoreMember(userContext, anotherOwnerId, emptyOptions());
      memberWishlist.updateOwner(owner);

      memberWishlist = saveMemberWishlist(userContext, memberWishlist, emptyOptions());

      return present(userContext, memberWishlist, allTokens());
    }
  }

  public CandidateRetailStoreMember requestCandidateOwner(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateRetailStoreMember result = new CandidateRetailStoreMember();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<RetailStoreMember> candidateList =
        retailStoreMemberDaoOf(userContext)
            .requestCandidateRetailStoreMemberForMemberWishlist(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected RetailStoreMember loadRetailStoreMember(
      RetailscmUserContext userContext, String newOwnerId, Map<String, Object> options)
      throws Exception {

    return retailStoreMemberDaoOf(userContext).load(newOwnerId, options);
  }

  // --------------------------------------------------------------

  public MemberWishlist forgetByAll(
      RetailscmUserContext userContext, String memberWishlistId, int memberWishlistVersion)
      throws Exception {
    return forgetByAllInternal(userContext, memberWishlistId, memberWishlistVersion);
  }

  protected MemberWishlist forgetByAllInternal(
      RetailscmUserContext userContext, String memberWishlistId, int memberWishlistVersion)
      throws Exception {

    return memberWishlistDaoOf(userContext)
        .disconnectFromAll(memberWishlistId, memberWishlistVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new MemberWishlistManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingMemberWishlistProduct(
      RetailscmUserContext userContext, String memberWishlistId, String name, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMemberWishlist(memberWishlistId);

    checkerOf(userContext).checkNameOfMemberWishlistProduct(name);

    checkerOf(userContext).throwExceptionIfHasErrors(MemberWishlistManagerException.class);
  }

  public MemberWishlist addMemberWishlistProduct(
      RetailscmUserContext userContext, String memberWishlistId, String name, String[] tokensExpr)
      throws Exception {
    checkParamsForAddingMemberWishlistProduct(userContext, memberWishlistId, name, tokensExpr);

    MemberWishlistProduct memberWishlistProduct = createMemberWishlistProduct(userContext, name);

    MemberWishlist memberWishlist =
        loadMemberWishlist(userContext, memberWishlistId, emptyOptions());
    synchronized (memberWishlist) {
      // Will be good when the memberWishlist loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      memberWishlist.addMemberWishlistProduct(memberWishlistProduct);
      memberWishlist =
          saveMemberWishlist(
              userContext, memberWishlist, tokens().withMemberWishlistProductList().done());

      memberWishlistProductManagerOf(userContext)
          .onNewInstanceCreated(userContext, memberWishlistProduct);
      return present(userContext, memberWishlist, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingMemberWishlistProductProperties(
      RetailscmUserContext userContext,
      String memberWishlistId,
      String id,
      String name,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMemberWishlist(memberWishlistId);
    checkerOf(userContext).checkIdOfMemberWishlistProduct(id);

    checkerOf(userContext).checkNameOfMemberWishlistProduct(name);

    checkerOf(userContext).throwExceptionIfHasErrors(MemberWishlistManagerException.class);
  }

  public MemberWishlist updateMemberWishlistProductProperties(
      RetailscmUserContext userContext,
      String memberWishlistId,
      String id,
      String name,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingMemberWishlistProductProperties(
        userContext, memberWishlistId, id, name, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withMemberWishlistProductListList()
            .searchMemberWishlistProductListWith(
                MemberWishlistProduct.ID_PROPERTY, tokens().is(), id)
            .done();

    MemberWishlist memberWishlistToUpdate =
        loadMemberWishlist(userContext, memberWishlistId, options);

    if (memberWishlistToUpdate.getMemberWishlistProductList().isEmpty()) {
      throw new MemberWishlistManagerException(
          "MemberWishlistProduct is NOT FOUND with id: '" + id + "'");
    }

    MemberWishlistProduct item = memberWishlistToUpdate.getMemberWishlistProductList().first();
    beforeUpdateMemberWishlistProductProperties(
        userContext, item, memberWishlistId, id, name, tokensExpr);
    item.updateName(name);

    // checkParamsForAddingMemberWishlistProduct(userContext,memberWishlistId,name, code,
    // used,tokensExpr);
    MemberWishlist memberWishlist =
        saveMemberWishlist(
            userContext, memberWishlistToUpdate, tokens().withMemberWishlistProductList().done());
    synchronized (memberWishlist) {
      return present(userContext, memberWishlist, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateMemberWishlistProductProperties(
      RetailscmUserContext userContext,
      MemberWishlistProduct item,
      String memberWishlistId,
      String id,
      String name,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected MemberWishlistProduct createMemberWishlistProduct(
      RetailscmUserContext userContext, String name) throws Exception {

    MemberWishlistProduct memberWishlistProduct = new MemberWishlistProduct();

    memberWishlistProduct.setName(name);

    return memberWishlistProduct;
  }

  protected MemberWishlistProduct createIndexedMemberWishlistProduct(String id, int version) {

    MemberWishlistProduct memberWishlistProduct = new MemberWishlistProduct();
    memberWishlistProduct.setId(id);
    memberWishlistProduct.setVersion(version);
    return memberWishlistProduct;
  }

  protected void checkParamsForRemovingMemberWishlistProductList(
      RetailscmUserContext userContext,
      String memberWishlistId,
      String memberWishlistProductIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMemberWishlist(memberWishlistId);
    for (String memberWishlistProductIdItem : memberWishlistProductIds) {
      checkerOf(userContext).checkIdOfMemberWishlistProduct(memberWishlistProductIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(MemberWishlistManagerException.class);
  }

  public MemberWishlist removeMemberWishlistProductList(
      RetailscmUserContext userContext,
      String memberWishlistId,
      String memberWishlistProductIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingMemberWishlistProductList(
        userContext, memberWishlistId, memberWishlistProductIds, tokensExpr);

    MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, allTokens());
    synchronized (memberWishlist) {
      // Will be good when the memberWishlist loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      memberWishlistDaoOf(userContext)
          .planToRemoveMemberWishlistProductList(
              memberWishlist, memberWishlistProductIds, allTokens());
      memberWishlist =
          saveMemberWishlist(
              userContext, memberWishlist, tokens().withMemberWishlistProductList().done());
      deleteRelationListInGraph(userContext, memberWishlist.getMemberWishlistProductList());
      return present(userContext, memberWishlist, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingMemberWishlistProduct(
      RetailscmUserContext userContext,
      String memberWishlistId,
      String memberWishlistProductId,
      int memberWishlistProductVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMemberWishlist(memberWishlistId);
    checkerOf(userContext).checkIdOfMemberWishlistProduct(memberWishlistProductId);
    checkerOf(userContext).checkVersionOfMemberWishlistProduct(memberWishlistProductVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(MemberWishlistManagerException.class);
  }

  public MemberWishlist removeMemberWishlistProduct(
      RetailscmUserContext userContext,
      String memberWishlistId,
      String memberWishlistProductId,
      int memberWishlistProductVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingMemberWishlistProduct(
        userContext,
        memberWishlistId,
        memberWishlistProductId,
        memberWishlistProductVersion,
        tokensExpr);

    MemberWishlistProduct memberWishlistProduct =
        createIndexedMemberWishlistProduct(memberWishlistProductId, memberWishlistProductVersion);
    MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, allTokens());
    synchronized (memberWishlist) {
      // Will be good when the memberWishlist loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      memberWishlist.removeMemberWishlistProduct(memberWishlistProduct);
      memberWishlist =
          saveMemberWishlist(
              userContext, memberWishlist, tokens().withMemberWishlistProductList().done());
      deleteRelationInGraph(userContext, memberWishlistProduct);
      return present(userContext, memberWishlist, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingMemberWishlistProduct(
      RetailscmUserContext userContext,
      String memberWishlistId,
      String memberWishlistProductId,
      int memberWishlistProductVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMemberWishlist(memberWishlistId);
    checkerOf(userContext).checkIdOfMemberWishlistProduct(memberWishlistProductId);
    checkerOf(userContext).checkVersionOfMemberWishlistProduct(memberWishlistProductVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(MemberWishlistManagerException.class);
  }

  public MemberWishlist copyMemberWishlistProductFrom(
      RetailscmUserContext userContext,
      String memberWishlistId,
      String memberWishlistProductId,
      int memberWishlistProductVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingMemberWishlistProduct(
        userContext,
        memberWishlistId,
        memberWishlistProductId,
        memberWishlistProductVersion,
        tokensExpr);

    MemberWishlistProduct memberWishlistProduct =
        createIndexedMemberWishlistProduct(memberWishlistProductId, memberWishlistProductVersion);
    MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, allTokens());
    synchronized (memberWishlist) {
      // Will be good when the memberWishlist loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      memberWishlist.copyMemberWishlistProductFrom(memberWishlistProduct);
      memberWishlist =
          saveMemberWishlist(
              userContext, memberWishlist, tokens().withMemberWishlistProductList().done());

      memberWishlistProductManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (MemberWishlistProduct)
                  memberWishlist.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, memberWishlist, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingMemberWishlistProduct(
      RetailscmUserContext userContext,
      String memberWishlistId,
      String memberWishlistProductId,
      int memberWishlistProductVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMemberWishlist(memberWishlistId);
    checkerOf(userContext).checkIdOfMemberWishlistProduct(memberWishlistProductId);
    checkerOf(userContext).checkVersionOfMemberWishlistProduct(memberWishlistProductVersion);

    if (MemberWishlistProduct.NAME_PROPERTY.equals(property)) {
      checkerOf(userContext).checkNameOfMemberWishlistProduct(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(MemberWishlistManagerException.class);
  }

  public MemberWishlist updateMemberWishlistProduct(
      RetailscmUserContext userContext,
      String memberWishlistId,
      String memberWishlistProductId,
      int memberWishlistProductVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingMemberWishlistProduct(
        userContext,
        memberWishlistId,
        memberWishlistProductId,
        memberWishlistProductVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withMemberWishlistProductList()
            .searchMemberWishlistProductListWith(
                MemberWishlistProduct.ID_PROPERTY, tokens().equals(), memberWishlistProductId)
            .done();

    MemberWishlist memberWishlist = loadMemberWishlist(userContext, memberWishlistId, loadTokens);

    synchronized (memberWishlist) {
      // Will be good when the memberWishlist loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // memberWishlist.removeMemberWishlistProduct( memberWishlistProduct );
      // make changes to AcceleraterAccount.
      MemberWishlistProduct memberWishlistProductIdVersionKey =
          createIndexedMemberWishlistProduct(memberWishlistProductId, memberWishlistProductVersion);

      MemberWishlistProduct memberWishlistProduct =
          memberWishlist.findTheMemberWishlistProduct(memberWishlistProductIdVersionKey);
      if (memberWishlistProduct == null) {
        throw new MemberWishlistManagerException(memberWishlistProductId + " is NOT FOUND");
      }

      beforeUpdateMemberWishlistProduct(
          userContext,
          memberWishlistProduct,
          memberWishlistId,
          memberWishlistProductId,
          memberWishlistProductVersion,
          property,
          newValueExpr,
          tokensExpr);
      memberWishlistProduct.changeProperty(property, newValueExpr);

      memberWishlist =
          saveMemberWishlist(
              userContext, memberWishlist, tokens().withMemberWishlistProductList().done());
      memberWishlistProductManagerOf(userContext)
          .onUpdated(userContext, memberWishlistProduct, this, "updateMemberWishlistProduct");
      return present(userContext, memberWishlist, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateMemberWishlistProduct(
      RetailscmUserContext userContext,
      MemberWishlistProduct existed,
      String memberWishlistId,
      String memberWishlistProductId,
      int memberWishlistProductVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(RetailscmUserContext userContext, MemberWishlist newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    memberWishlistDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   MemberWishlist newMemberWishlist = this.createMemberWishlist(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newMemberWishlist
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
    key.put(UserApp.APP_TYPE_PROPERTY, MemberWishlist.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<MemberWishlist> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<RetailStoreMember> ownerList =
        RetailscmBaseUtils.collectReferencedObjectWithType(
            userContext, list, RetailStoreMember.class);
    userContext.getDAOGroup().enhanceList(ownerList, RetailStoreMember.class);
  }

  public Object listByOwner(RetailscmUserContext userContext, String ownerId) throws Exception {
    return listPageByOwner(userContext, ownerId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByOwner(
      RetailscmUserContext userContext, String ownerId, int start, int count) throws Exception {
    SmartList<MemberWishlist> list =
        memberWishlistDaoOf(userContext)
            .findMemberWishlistByOwner(ownerId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(MemberWishlist.class);
    page.setContainerObject(RetailStoreMember.withId(ownerId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("会员收藏列表");
    page.setRequestName("listByOwner");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByOwner/%s/", getBeanName(), ownerId)));

    page.assemblerContent(userContext, "listByOwner");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String memberWishlistId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    MemberWishlist merchantObj = (MemberWishlist) this.view(userContext, memberWishlistId);
    String merchantObjId = memberWishlistId;
    String linkToUrl = "memberWishlistManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "会员收藏" + "详情";
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

    propList.add(
        MapUtil.put("id", "3-owner")
            .put("fieldName", "owner")
            .put("label", "业主")
            .put("type", "auto")
            .put("linkToUrl", "retailStoreMemberManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"mobile_phone\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("owner", merchantObj.getOwner());

    // 处理 sectionList

    // 处理Section：memberWishlistProductListSection
    Map memberWishlistProductListSection =
        ListofUtils.buildSection(
            "memberWishlistProductListSection",
            "会员愿望列表产品列表",
            null,
            "",
            "__no_group",
            "memberWishlistProductManager/listByOwner/" + merchantObjId + "/",
            "auto");
    sections.add(memberWishlistProductListSection);

    result.put(
        "memberWishlistProductListSection",
        ListofUtils.toShortList(
            merchantObj.getMemberWishlistProductList(), "memberWishlistProduct"));

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
