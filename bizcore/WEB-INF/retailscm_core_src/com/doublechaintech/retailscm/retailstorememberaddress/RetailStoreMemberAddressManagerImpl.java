package com.doublechaintech.retailscm.retailstorememberaddress;

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

public class RetailStoreMemberAddressManagerImpl extends CustomRetailscmCheckerManager
    implements RetailStoreMemberAddressManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "RetailStoreMemberAddress";

  @Override
  public RetailStoreMemberAddressDAO daoOf(RetailscmUserContext userContext) {
    return retailStoreMemberAddressDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value)
      throws RetailStoreMemberAddressManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new RetailStoreMemberAddressManagerException(message);
  }

  protected RetailStoreMemberAddress saveRetailStoreMemberAddress(
      RetailscmUserContext userContext,
      RetailStoreMemberAddress retailStoreMemberAddress,
      String[] tokensExpr)
      throws Exception {
    // return getRetailStoreMemberAddressDAO().save(retailStoreMemberAddress, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveRetailStoreMemberAddress(userContext, retailStoreMemberAddress, tokens);
  }

  protected RetailStoreMemberAddress saveRetailStoreMemberAddressDetail(
      RetailscmUserContext userContext, RetailStoreMemberAddress retailStoreMemberAddress)
      throws Exception {

    return saveRetailStoreMemberAddress(userContext, retailStoreMemberAddress, allTokens());
  }

  public RetailStoreMemberAddress loadRetailStoreMemberAddress(
      RetailscmUserContext userContext, String retailStoreMemberAddressId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreMemberAddress(retailStoreMemberAddressId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreMemberAddressManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    RetailStoreMemberAddress retailStoreMemberAddress =
        loadRetailStoreMemberAddress(userContext, retailStoreMemberAddressId, tokens);
    // do some calc before sent to customer?
    return present(userContext, retailStoreMemberAddress, tokens);
  }

  public RetailStoreMemberAddress searchRetailStoreMemberAddress(
      RetailscmUserContext userContext,
      String retailStoreMemberAddressId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreMemberAddress(retailStoreMemberAddressId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreMemberAddressManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    RetailStoreMemberAddress retailStoreMemberAddress =
        loadRetailStoreMemberAddress(userContext, retailStoreMemberAddressId, tokens);
    // do some calc before sent to customer?
    return present(userContext, retailStoreMemberAddress, tokens);
  }

  protected RetailStoreMemberAddress present(
      RetailscmUserContext userContext,
      RetailStoreMemberAddress retailStoreMemberAddress,
      Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, retailStoreMemberAddress, tokens);

    RetailStoreMemberAddress retailStoreMemberAddressToPresent =
        retailStoreMemberAddressDaoOf(userContext).present(retailStoreMemberAddress, tokens);

    List<BaseEntity> entityListToNaming =
        retailStoreMemberAddressToPresent.collectReferencesFromLists();
    retailStoreMemberAddressDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, retailStoreMemberAddress, tokens);

    return retailStoreMemberAddressToPresent;
  }

  public RetailStoreMemberAddress loadRetailStoreMemberAddressDetail(
      RetailscmUserContext userContext, String retailStoreMemberAddressId) throws Exception {
    RetailStoreMemberAddress retailStoreMemberAddress =
        loadRetailStoreMemberAddress(userContext, retailStoreMemberAddressId, allTokens());
    return present(userContext, retailStoreMemberAddress, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String retailStoreMemberAddressId)
      throws Exception {
    RetailStoreMemberAddress retailStoreMemberAddress =
        loadRetailStoreMemberAddress(userContext, retailStoreMemberAddressId, viewTokens());
    markVisited(userContext, retailStoreMemberAddress);
    return present(userContext, retailStoreMemberAddress, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String retailStoreMemberAddressId)
      throws Exception {
    RetailStoreMemberAddress retailStoreMemberAddress =
        loadRetailStoreMemberAddress(userContext, retailStoreMemberAddressId, viewTokens());
    retailStoreMemberAddress.summarySuffix();
    markVisited(userContext, retailStoreMemberAddress);
    return present(userContext, retailStoreMemberAddress, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String retailStoreMemberAddressId)
      throws Exception {
    RetailStoreMemberAddress retailStoreMemberAddress =
        loadRetailStoreMemberAddress(userContext, retailStoreMemberAddressId, analyzeTokens());
    markVisited(userContext, retailStoreMemberAddress);
    return present(userContext, retailStoreMemberAddress, analyzeTokens());
  }

  protected RetailStoreMemberAddress saveRetailStoreMemberAddress(
      RetailscmUserContext userContext,
      RetailStoreMemberAddress retailStoreMemberAddress,
      Map<String, Object> tokens)
      throws Exception {

    return retailStoreMemberAddressDaoOf(userContext).save(retailStoreMemberAddress, tokens);
  }

  protected RetailStoreMemberAddress loadRetailStoreMemberAddress(
      RetailscmUserContext userContext,
      String retailStoreMemberAddressId,
      Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfRetailStoreMemberAddress(retailStoreMemberAddressId);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreMemberAddressManagerException.class);

    return retailStoreMemberAddressDaoOf(userContext).load(retailStoreMemberAddressId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext,
      RetailStoreMemberAddress retailStoreMemberAddress,
      Map<String, Object> tokens) {
    super.addActions(userContext, retailStoreMemberAddress, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, RetailStoreMemberAddress retailStoreMemberAddress, Map<String, Object> tokens){

  @Override
  public List<RetailStoreMemberAddress> searchRetailStoreMemberAddressList(
      RetailscmUserContext ctx, RetailStoreMemberAddressRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<RetailStoreMemberAddress> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public RetailStoreMemberAddress searchRetailStoreMemberAddress(
      RetailscmUserContext ctx, RetailStoreMemberAddressRequest pRequest) {
    pRequest.limit(0, 1);
    List<RetailStoreMemberAddress> list = searchRetailStoreMemberAddressList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public RetailStoreMemberAddress createRetailStoreMemberAddress(
      RetailscmUserContext userContext,
      String name,
      String ownerId,
      String mobilePhone,
      String address)
      throws Exception {

    checkerOf(userContext).checkNameOfRetailStoreMemberAddress(name);
    checkerOf(userContext).checkMobilePhoneOfRetailStoreMemberAddress(mobilePhone);
    checkerOf(userContext).checkAddressOfRetailStoreMemberAddress(address);

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreMemberAddressManagerException.class);

    RetailStoreMemberAddress retailStoreMemberAddress = createNewRetailStoreMemberAddress();

    retailStoreMemberAddress.setName(name);

    RetailStoreMember owner = loadRetailStoreMember(userContext, ownerId, emptyOptions());
    retailStoreMemberAddress.setOwner(owner);

    retailStoreMemberAddress.setMobilePhone(mobilePhone);
    retailStoreMemberAddress.setAddress(address);

    retailStoreMemberAddress =
        saveRetailStoreMemberAddress(userContext, retailStoreMemberAddress, emptyOptions());

    onNewInstanceCreated(userContext, retailStoreMemberAddress);
    return retailStoreMemberAddress;
  }

  protected RetailStoreMemberAddress createNewRetailStoreMemberAddress() {

    return new RetailStoreMemberAddress();
  }

  protected void checkParamsForUpdatingRetailStoreMemberAddress(
      RetailscmUserContext userContext,
      String retailStoreMemberAddressId,
      int retailStoreMemberAddressVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreMemberAddress(retailStoreMemberAddressId);
    checkerOf(userContext).checkVersionOfRetailStoreMemberAddress(retailStoreMemberAddressVersion);

    if (RetailStoreMemberAddress.NAME_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNameOfRetailStoreMemberAddress(parseString(newValueExpr));
    }

    if (RetailStoreMemberAddress.MOBILE_PHONE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkMobilePhoneOfRetailStoreMemberAddress(parseString(newValueExpr));
    }
    if (RetailStoreMemberAddress.ADDRESS_PROPERTY.equals(property)) {

      checkerOf(userContext).checkAddressOfRetailStoreMemberAddress(parseString(newValueExpr));
    }

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreMemberAddressManagerException.class);
  }

  public RetailStoreMemberAddress clone(
      RetailscmUserContext userContext, String fromRetailStoreMemberAddressId) throws Exception {

    return retailStoreMemberAddressDaoOf(userContext)
        .clone(fromRetailStoreMemberAddressId, this.allTokens());
  }

  public RetailStoreMemberAddress internalSaveRetailStoreMemberAddress(
      RetailscmUserContext userContext, RetailStoreMemberAddress retailStoreMemberAddress)
      throws Exception {
    return internalSaveRetailStoreMemberAddress(userContext, retailStoreMemberAddress, allTokens());
  }

  public RetailStoreMemberAddress internalSaveRetailStoreMemberAddress(
      RetailscmUserContext userContext,
      RetailStoreMemberAddress retailStoreMemberAddress,
      Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingRetailStoreMemberAddress(userContext, retailStoreMemberAddressId,
    // retailStoreMemberAddressVersion, property, newValueExpr, tokensExpr);

    synchronized (retailStoreMemberAddress) {
      // will be good when the retailStoreMemberAddress loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreMemberAddress.
      if (retailStoreMemberAddress.isChanged()) {}

      // checkerOf(userContext).checkAndFixRetailStoreMemberAddress(retailStoreMemberAddress);
      retailStoreMemberAddress =
          saveRetailStoreMemberAddress(userContext, retailStoreMemberAddress, options);
      return retailStoreMemberAddress;
    }
  }

  public RetailStoreMemberAddress updateRetailStoreMemberAddress(
      RetailscmUserContext userContext,
      String retailStoreMemberAddressId,
      int retailStoreMemberAddressVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingRetailStoreMemberAddress(
        userContext,
        retailStoreMemberAddressId,
        retailStoreMemberAddressVersion,
        property,
        newValueExpr,
        tokensExpr);

    RetailStoreMemberAddress retailStoreMemberAddress =
        loadRetailStoreMemberAddress(userContext, retailStoreMemberAddressId, allTokens());
    if (retailStoreMemberAddress.getVersion() != retailStoreMemberAddressVersion) {
      String message =
          "The target version("
              + retailStoreMemberAddress.getVersion()
              + ") is not equals to version("
              + retailStoreMemberAddressVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (retailStoreMemberAddress) {
      // will be good when the retailStoreMemberAddress loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreMemberAddress.

      retailStoreMemberAddress.changeProperty(property, newValueExpr);
      retailStoreMemberAddress =
          saveRetailStoreMemberAddress(userContext, retailStoreMemberAddress, tokens().done());
      return present(userContext, retailStoreMemberAddress, mergedAllTokens(tokensExpr));
      // return saveRetailStoreMemberAddress(userContext, retailStoreMemberAddress,
      // tokens().done());
    }
  }

  public RetailStoreMemberAddress updateRetailStoreMemberAddressProperty(
      RetailscmUserContext userContext,
      String retailStoreMemberAddressId,
      int retailStoreMemberAddressVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingRetailStoreMemberAddress(
        userContext,
        retailStoreMemberAddressId,
        retailStoreMemberAddressVersion,
        property,
        newValueExpr,
        tokensExpr);

    RetailStoreMemberAddress retailStoreMemberAddress =
        loadRetailStoreMemberAddress(userContext, retailStoreMemberAddressId, allTokens());
    if (retailStoreMemberAddress.getVersion() != retailStoreMemberAddressVersion) {
      String message =
          "The target version("
              + retailStoreMemberAddress.getVersion()
              + ") is not equals to version("
              + retailStoreMemberAddressVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (retailStoreMemberAddress) {
      // will be good when the retailStoreMemberAddress loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to RetailStoreMemberAddress.

      retailStoreMemberAddress.changeProperty(property, newValueExpr);

      retailStoreMemberAddress =
          saveRetailStoreMemberAddress(userContext, retailStoreMemberAddress, tokens().done());
      return present(userContext, retailStoreMemberAddress, mergedAllTokens(tokensExpr));
      // return saveRetailStoreMemberAddress(userContext, retailStoreMemberAddress,
      // tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected RetailStoreMemberAddressTokens tokens() {
    return RetailStoreMemberAddressTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return RetailStoreMemberAddressTokens.all();
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
    return RetailStoreMemberAddressTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherOwner(
      RetailscmUserContext userContext, String retailStoreMemberAddressId, String anotherOwnerId)
      throws Exception {

    checkerOf(userContext).checkIdOfRetailStoreMemberAddress(retailStoreMemberAddressId);
    checkerOf(userContext)
        .checkIdOfRetailStoreMember(anotherOwnerId); // check for optional reference

    checkerOf(userContext)
        .throwExceptionIfHasErrors(RetailStoreMemberAddressManagerException.class);
  }

  public RetailStoreMemberAddress transferToAnotherOwner(
      RetailscmUserContext userContext, String retailStoreMemberAddressId, String anotherOwnerId)
      throws Exception {
    checkParamsForTransferingAnotherOwner(userContext, retailStoreMemberAddressId, anotherOwnerId);

    RetailStoreMemberAddress retailStoreMemberAddress =
        loadRetailStoreMemberAddress(userContext, retailStoreMemberAddressId, allTokens());
    synchronized (retailStoreMemberAddress) {
      // will be good when the retailStoreMemberAddress loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      RetailStoreMember owner = loadRetailStoreMember(userContext, anotherOwnerId, emptyOptions());
      retailStoreMemberAddress.updateOwner(owner);

      retailStoreMemberAddress =
          saveRetailStoreMemberAddress(userContext, retailStoreMemberAddress, emptyOptions());

      return present(userContext, retailStoreMemberAddress, allTokens());
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
            .requestCandidateRetailStoreMemberForRetailStoreMemberAddress(
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

  public RetailStoreMemberAddress forgetByAll(
      RetailscmUserContext userContext,
      String retailStoreMemberAddressId,
      int retailStoreMemberAddressVersion)
      throws Exception {
    return forgetByAllInternal(
        userContext, retailStoreMemberAddressId, retailStoreMemberAddressVersion);
  }

  protected RetailStoreMemberAddress forgetByAllInternal(
      RetailscmUserContext userContext,
      String retailStoreMemberAddressId,
      int retailStoreMemberAddressVersion)
      throws Exception {

    return retailStoreMemberAddressDaoOf(userContext)
        .disconnectFromAll(retailStoreMemberAddressId, retailStoreMemberAddressVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new RetailStoreMemberAddressManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, RetailStoreMemberAddress newCreated) throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    retailStoreMemberAddressDaoOf(ctx)
        .loadAllAsStream()
        .forEach(event -> sendInitEvent(ctx, event));
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
    //   RetailStoreMemberAddress newRetailStoreMemberAddress =
    // this.createRetailStoreMemberAddress(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newRetailStoreMemberAddress
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
    key.put(UserApp.APP_TYPE_PROPERTY, RetailStoreMemberAddress.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<RetailStoreMemberAddress> list) throws Exception {
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
    SmartList<RetailStoreMemberAddress> list =
        retailStoreMemberAddressDaoOf(userContext)
            .findRetailStoreMemberAddressByOwner(ownerId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(RetailStoreMemberAddress.class);
    page.setContainerObject(RetailStoreMember.withId(ownerId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("零售店会员地址列表");
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
  public Object wxappview(RetailscmUserContext userContext, String retailStoreMemberAddressId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    RetailStoreMemberAddress merchantObj =
        (RetailStoreMemberAddress) this.view(userContext, retailStoreMemberAddressId);
    String merchantObjId = retailStoreMemberAddressId;
    String linkToUrl = "retailStoreMemberAddressManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "零售店会员地址" + "详情";
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

    propList.add(
        MapUtil.put("id", "4-mobilePhone")
            .put("fieldName", "mobilePhone")
            .put("label", "移动电话")
            .put("type", "mobile")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("mobilePhone", merchantObj.getMobilePhone());

    propList.add(
        MapUtil.put("id", "5-address")
            .put("fieldName", "address")
            .put("label", "地址")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("address", merchantObj.getAddress());

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
