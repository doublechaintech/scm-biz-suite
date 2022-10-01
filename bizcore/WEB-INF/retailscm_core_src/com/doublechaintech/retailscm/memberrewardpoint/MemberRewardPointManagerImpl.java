package com.doublechaintech.retailscm.memberrewardpoint;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
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

public class MemberRewardPointManagerImpl extends CustomRetailscmCheckerManager
    implements MemberRewardPointManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "MemberRewardPoint";

  @Override
  public MemberRewardPointDAO daoOf(RetailscmUserContext userContext) {
    return memberRewardPointDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws MemberRewardPointManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new MemberRewardPointManagerException(message);
  }

  protected MemberRewardPoint saveMemberRewardPoint(
      RetailscmUserContext userContext, MemberRewardPoint memberRewardPoint, String[] tokensExpr)
      throws Exception {
    // return getMemberRewardPointDAO().save(memberRewardPoint, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveMemberRewardPoint(userContext, memberRewardPoint, tokens);
  }

  protected MemberRewardPoint saveMemberRewardPointDetail(
      RetailscmUserContext userContext, MemberRewardPoint memberRewardPoint) throws Exception {

    return saveMemberRewardPoint(userContext, memberRewardPoint, allTokens());
  }

  public MemberRewardPoint loadMemberRewardPoint(
      RetailscmUserContext userContext, String memberRewardPointId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMemberRewardPoint(memberRewardPointId);

    checkerOf(userContext).throwExceptionIfHasErrors(MemberRewardPointManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    MemberRewardPoint memberRewardPoint =
        loadMemberRewardPoint(userContext, memberRewardPointId, tokens);
    // do some calc before sent to customer?
    return present(userContext, memberRewardPoint, tokens);
  }

  public MemberRewardPoint searchMemberRewardPoint(
      RetailscmUserContext userContext,
      String memberRewardPointId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMemberRewardPoint(memberRewardPointId);

    checkerOf(userContext).throwExceptionIfHasErrors(MemberRewardPointManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    MemberRewardPoint memberRewardPoint =
        loadMemberRewardPoint(userContext, memberRewardPointId, tokens);
    // do some calc before sent to customer?
    return present(userContext, memberRewardPoint, tokens);
  }

  protected MemberRewardPoint present(
      RetailscmUserContext userContext,
      MemberRewardPoint memberRewardPoint,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, memberRewardPoint, tokens);

    MemberRewardPoint memberRewardPointToPresent =
        memberRewardPointDaoOf(userContext).present(memberRewardPoint, tokens);

    List<BaseEntity> entityListToNaming = memberRewardPointToPresent.collectReferencesFromLists();
    memberRewardPointDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, memberRewardPoint, tokens);

    return memberRewardPointToPresent;
  }

  public MemberRewardPoint loadMemberRewardPointDetail(
      RetailscmUserContext userContext, String memberRewardPointId) throws Exception {
    MemberRewardPoint memberRewardPoint =
        loadMemberRewardPoint(userContext, memberRewardPointId, allTokens());
    return present(userContext, memberRewardPoint, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String memberRewardPointId)
      throws Exception {
    MemberRewardPoint memberRewardPoint =
        loadMemberRewardPoint(userContext, memberRewardPointId, viewTokens());
    markVisited(userContext, memberRewardPoint);
    return present(userContext, memberRewardPoint, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String memberRewardPointId)
      throws Exception {
    MemberRewardPoint memberRewardPoint =
        loadMemberRewardPoint(userContext, memberRewardPointId, viewTokens());
    memberRewardPoint.summarySuffix();
    markVisited(userContext, memberRewardPoint);
    return present(userContext, memberRewardPoint, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String memberRewardPointId)
      throws Exception {
    MemberRewardPoint memberRewardPoint =
        loadMemberRewardPoint(userContext, memberRewardPointId, analyzeTokens());
    markVisited(userContext, memberRewardPoint);
    return present(userContext, memberRewardPoint, analyzeTokens());
  }

  protected MemberRewardPoint saveMemberRewardPoint(
      RetailscmUserContext userContext,
      MemberRewardPoint memberRewardPoint,
      Map<String, Object> tokens)
      throws Exception {

    return memberRewardPointDaoOf(userContext).save(memberRewardPoint, tokens);
  }

  protected MemberRewardPoint loadMemberRewardPoint(
      RetailscmUserContext userContext, String memberRewardPointId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfMemberRewardPoint(memberRewardPointId);

    checkerOf(userContext).throwExceptionIfHasErrors(MemberRewardPointManagerException.class);

    return memberRewardPointDaoOf(userContext).load(memberRewardPointId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      MemberRewardPoint memberRewardPoint,
      Map<String, Object> tokens) {
    super.addActions(userContext, memberRewardPoint, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, MemberRewardPoint memberRewardPoint, Map<String, Object> tokens){

  @Override
  public List<MemberRewardPoint> searchMemberRewardPointList(
      RetailscmUserContext ctx, MemberRewardPointRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<MemberRewardPoint> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public MemberRewardPoint searchMemberRewardPoint(
      RetailscmUserContext ctx, MemberRewardPointRequest pRequest) {
    pRequest.limit(0, 1);
    List<MemberRewardPoint> list = searchMemberRewardPointList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public MemberRewardPoint createMemberRewardPoint(
      RetailscmUserContext userContext, String name, int point, String ownerId) throws Exception {

    checkerOf(userContext).checkNameOfMemberRewardPoint(name);
    checkerOf(userContext).checkPointOfMemberRewardPoint(point);

    checkerOf(userContext).throwExceptionIfHasErrors(MemberRewardPointManagerException.class);

    MemberRewardPoint memberRewardPoint = createNewMemberRewardPoint();

    memberRewardPoint.setName(name);
    memberRewardPoint.setPoint(point);

    RetailStoreMember owner = loadRetailStoreMember(userContext, ownerId, emptyOptions());
    memberRewardPoint.setOwner(owner);

    memberRewardPoint = saveMemberRewardPoint(userContext, memberRewardPoint, emptyOptions());

    onNewInstanceCreated(userContext, memberRewardPoint);
    return memberRewardPoint;
  }

  protected MemberRewardPoint createNewMemberRewardPoint() {

    return new MemberRewardPoint();
  }

  protected void checkParamsForUpdatingMemberRewardPoint(
      RetailscmUserContext userContext,
      String memberRewardPointId,
      int memberRewardPointVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfMemberRewardPoint(memberRewardPointId);
    checkerOf(userContext).checkVersionOfMemberRewardPoint(memberRewardPointVersion);

    if (MemberRewardPoint.NAME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNameOfMemberRewardPoint(parseString(newValueExpr));
    }
    if (MemberRewardPoint.POINT_PROPERTY.equals(property)) {

      checkerOf(userContext).checkPointOfMemberRewardPoint(parseInt(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(MemberRewardPointManagerException.class);
  }

  public MemberRewardPoint clone(RetailscmUserContext userContext, String fromMemberRewardPointId)
      throws Exception {

    return memberRewardPointDaoOf(userContext).clone(fromMemberRewardPointId, this.allTokens());
  }

  public MemberRewardPoint internalSaveMemberRewardPoint(
      RetailscmUserContext userContext, MemberRewardPoint memberRewardPoint) throws Exception {
    return internalSaveMemberRewardPoint(userContext, memberRewardPoint, allTokens());
  }

  public MemberRewardPoint internalSaveMemberRewardPoint(
      RetailscmUserContext userContext,
      MemberRewardPoint memberRewardPoint,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingMemberRewardPoint(userContext, memberRewardPointId,
    // memberRewardPointVersion, property, newValueExpr, tokensExpr);

    synchronized (memberRewardPoint) {
      // will be good when the memberRewardPoint loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to MemberRewardPoint.
      if (memberRewardPoint.isChanged()) {}

      // checkerOf(userContext).checkAndFixMemberRewardPoint(memberRewardPoint);
      memberRewardPoint = saveMemberRewardPoint(userContext, memberRewardPoint, options);
      return memberRewardPoint;
    }
  }

  public MemberRewardPoint updateMemberRewardPoint(
      RetailscmUserContext userContext,
      String memberRewardPointId,
      int memberRewardPointVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingMemberRewardPoint(
        userContext,
        memberRewardPointId,
        memberRewardPointVersion,
        property,
        newValueExpr,
        tokensExpr);

    MemberRewardPoint memberRewardPoint =
        loadMemberRewardPoint(userContext, memberRewardPointId, allTokens());
    if (memberRewardPoint.getVersion() != memberRewardPointVersion) {
      String message =
          "The target version("
              + memberRewardPoint.getVersion()
              + ") is not equals to version("
              + memberRewardPointVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (memberRewardPoint) {
      // will be good when the memberRewardPoint loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to MemberRewardPoint.

      memberRewardPoint.changeProperty(property, newValueExpr);
      memberRewardPoint = saveMemberRewardPoint(userContext, memberRewardPoint, tokens().done());
      return present(userContext, memberRewardPoint, mergedAllTokens(tokensExpr));
      // return saveMemberRewardPoint(userContext, memberRewardPoint, tokens().done());
    }
  }

  public MemberRewardPoint updateMemberRewardPointProperty(
      RetailscmUserContext userContext,
      String memberRewardPointId,
      int memberRewardPointVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingMemberRewardPoint(
        userContext,
        memberRewardPointId,
        memberRewardPointVersion,
        property,
        newValueExpr,
        tokensExpr);

    MemberRewardPoint memberRewardPoint =
        loadMemberRewardPoint(userContext, memberRewardPointId, allTokens());
    if (memberRewardPoint.getVersion() != memberRewardPointVersion) {
      String message =
          "The target version("
              + memberRewardPoint.getVersion()
              + ") is not equals to version("
              + memberRewardPointVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (memberRewardPoint) {
      // will be good when the memberRewardPoint loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to MemberRewardPoint.

      memberRewardPoint.changeProperty(property, newValueExpr);

      memberRewardPoint = saveMemberRewardPoint(userContext, memberRewardPoint, tokens().done());
      return present(userContext, memberRewardPoint, mergedAllTokens(tokensExpr));
      // return saveMemberRewardPoint(userContext, memberRewardPoint, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected MemberRewardPointTokens tokens() {
    return MemberRewardPointTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return MemberRewardPointTokens.all();
  }

  protected Map<String, Object> analyzeTokens() {
    return tokens().allTokens().analyzeAllLists().done();
  }

  protected Map<String, Object> summaryTokens() {
    return tokens().allTokens().done();
  }

  protected Map<String, Object> viewTokens() {
    return tokens().allTokens().done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return MemberRewardPointTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherOwner(
      RetailscmUserContext userContext, String memberRewardPointId, String anotherOwnerId)
      throws Exception {

    checkerOf(userContext).checkIdOfMemberRewardPoint(memberRewardPointId);
    checkerOf(userContext)
        .checkIdOfRetailStoreMember(anotherOwnerId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(MemberRewardPointManagerException.class);
  }

  public MemberRewardPoint transferToAnotherOwner(
      RetailscmUserContext userContext, String memberRewardPointId, String anotherOwnerId)
      throws Exception {
    checkParamsForTransferingAnotherOwner(userContext, memberRewardPointId, anotherOwnerId);

    MemberRewardPoint memberRewardPoint =
        loadMemberRewardPoint(userContext, memberRewardPointId, allTokens());
    synchronized (memberRewardPoint) {
      // will be good when the memberRewardPoint loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      RetailStoreMember owner = loadRetailStoreMember(userContext, anotherOwnerId, emptyOptions());
      memberRewardPoint.updateOwner(owner);

      memberRewardPoint = saveMemberRewardPoint(userContext, memberRewardPoint, emptyOptions());

      return present(userContext, memberRewardPoint, allTokens());
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
            .requestCandidateRetailStoreMemberForMemberRewardPoint(
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

  public MemberRewardPoint forgetByAll(
      RetailscmUserContext userContext, String memberRewardPointId, int memberRewardPointVersion)
      throws Exception {
    return forgetByAllInternal(userContext, memberRewardPointId, memberRewardPointVersion);
  }

  protected MemberRewardPoint forgetByAllInternal(
      RetailscmUserContext userContext, String memberRewardPointId, int memberRewardPointVersion)
      throws Exception {

    return memberRewardPointDaoOf(userContext)
        .disconnectFromAll(memberRewardPointId, memberRewardPointVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new MemberRewardPointManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(RetailscmUserContext userContext, MemberRewardPoint newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    memberRewardPointDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   MemberRewardPoint newMemberRewardPoint = this.createMemberRewardPoint(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newMemberRewardPoint
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
    key.put(UserApp.APP_TYPE_PROPERTY, MemberRewardPoint.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<MemberRewardPoint> list) throws Exception {
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
    SmartList<MemberRewardPoint> list =
        memberRewardPointDaoOf(userContext)
            .findMemberRewardPointByOwner(ownerId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(MemberRewardPoint.class);
    page.setContainerObject(RetailStoreMember.withId(ownerId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("会员奖励点列表");
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
  public Object wxappview(RetailscmUserContext userContext, String memberRewardPointId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    MemberRewardPoint merchantObj = (MemberRewardPoint) this.view(userContext, memberRewardPointId);
    String merchantObjId = memberRewardPointId;
    String linkToUrl = "memberRewardPointManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "会员奖励点" + "详情";
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
        MapUtil.put("id", "3-point")
            .put("fieldName", "point")
            .put("label", "点")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("point", merchantObj.getPoint());

    propList.add(
        MapUtil.put("id", "4-owner")
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
