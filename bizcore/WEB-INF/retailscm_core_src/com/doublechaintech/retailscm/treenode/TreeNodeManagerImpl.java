package com.doublechaintech.retailscm.treenode;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
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

public class TreeNodeManagerImpl extends CustomRetailscmCheckerManager
    implements TreeNodeManager, BusinessHandler {

  // Only some of ods have such function

  private static final String SERVICE_TYPE = "TreeNode";

  @Override
  public TreeNodeDAO daoOf(RetailscmUserContext userContext) {
    return treeNodeDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws TreeNodeManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new TreeNodeManagerException(message);
  }

  protected TreeNode saveTreeNode(
      RetailscmUserContext userContext, TreeNode treeNode, String[] tokensExpr) throws Exception {
    // return getTreeNodeDAO().save(treeNode, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return saveTreeNode(userContext, treeNode, tokens);
  }

  protected TreeNode saveTreeNodeDetail(RetailscmUserContext userContext, TreeNode treeNode)
      throws Exception {

    return saveTreeNode(userContext, treeNode, allTokens());
  }

  public TreeNode loadTreeNode(
      RetailscmUserContext userContext, String treeNodeId, String[] tokensExpr) throws Exception {

    checkerOf(userContext).checkIdOfTreeNode(treeNodeId);

    checkerOf(userContext).throwExceptionIfHasErrors(TreeNodeManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    TreeNode treeNode = loadTreeNode(userContext, treeNodeId, tokens);
    // do some calc before sent to customer?
    return present(userContext, treeNode, tokens);
  }

  public TreeNode searchTreeNode(
      RetailscmUserContext userContext, String treeNodeId, String textToSearch, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfTreeNode(treeNodeId);

    checkerOf(userContext).throwExceptionIfHasErrors(TreeNodeManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    TreeNode treeNode = loadTreeNode(userContext, treeNodeId, tokens);
    // do some calc before sent to customer?
    return present(userContext, treeNode, tokens);
  }

  protected TreeNode present(
      RetailscmUserContext userContext, TreeNode treeNode, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, treeNode, tokens);

    TreeNode treeNodeToPresent = treeNodeDaoOf(userContext).present(treeNode, tokens);

    List<BaseEntity> entityListToNaming = treeNodeToPresent.collectReferencesFromLists();
    treeNodeDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, treeNode, tokens);

    return treeNodeToPresent;
  }

  public TreeNode loadTreeNodeDetail(RetailscmUserContext userContext, String treeNodeId)
      throws Exception {
    TreeNode treeNode = loadTreeNode(userContext, treeNodeId, allTokens());
    return present(userContext, treeNode, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String treeNodeId) throws Exception {
    TreeNode treeNode = loadTreeNode(userContext, treeNodeId, viewTokens());
    markVisited(userContext, treeNode);
    return present(userContext, treeNode, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String treeNodeId) throws Exception {
    TreeNode treeNode = loadTreeNode(userContext, treeNodeId, viewTokens());
    treeNode.summarySuffix();
    markVisited(userContext, treeNode);
    return present(userContext, treeNode, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String treeNodeId) throws Exception {
    TreeNode treeNode = loadTreeNode(userContext, treeNodeId, analyzeTokens());
    markVisited(userContext, treeNode);
    return present(userContext, treeNode, analyzeTokens());
  }

  protected TreeNode saveTreeNode(
      RetailscmUserContext userContext, TreeNode treeNode, Map<String, Object> tokens)
      throws Exception {

    return treeNodeDaoOf(userContext).save(treeNode, tokens);
  }

  protected TreeNode loadTreeNode(
      RetailscmUserContext userContext, String treeNodeId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfTreeNode(treeNodeId);

    checkerOf(userContext).throwExceptionIfHasErrors(TreeNodeManagerException.class);

    return treeNodeDaoOf(userContext).load(treeNodeId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, TreeNode treeNode, Map<String, Object> tokens) {
    super.addActions(userContext, treeNode, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, TreeNode treeNode, Map<String, Object> tokens){

  @Override
  public List<TreeNode> searchTreeNodeList(RetailscmUserContext ctx, TreeNodeRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<TreeNode> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public TreeNode searchTreeNode(RetailscmUserContext ctx, TreeNodeRequest pRequest) {
    pRequest.limit(0, 1);
    List<TreeNode> list = searchTreeNodeList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public TreeNode createTreeNode(
      RetailscmUserContext userContext,
      String nodeId,
      String nodeType,
      int leftValue,
      int rightValue)
      throws Exception {

    checkerOf(userContext).checkNodeIdOfTreeNode(nodeId);
    checkerOf(userContext).checkNodeTypeOfTreeNode(nodeType);
    checkerOf(userContext).checkLeftValueOfTreeNode(leftValue);
    checkerOf(userContext).checkRightValueOfTreeNode(rightValue);

    checkerOf(userContext).throwExceptionIfHasErrors(TreeNodeManagerException.class);

    TreeNode treeNode = createNewTreeNode();

    treeNode.setNodeId(nodeId);
    treeNode.setNodeType(nodeType);
    treeNode.setLeftValue(leftValue);
    treeNode.setRightValue(rightValue);

    treeNode = saveTreeNode(userContext, treeNode, emptyOptions());

    onNewInstanceCreated(userContext, treeNode);
    return treeNode;
  }

  protected TreeNode createNewTreeNode() {

    return new TreeNode();
  }

  protected void checkParamsForUpdatingTreeNode(
      RetailscmUserContext userContext,
      String treeNodeId,
      int treeNodeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfTreeNode(treeNodeId);
    checkerOf(userContext).checkVersionOfTreeNode(treeNodeVersion);

    if (TreeNode.NODE_ID_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNodeIdOfTreeNode(parseString(newValueExpr));
    }
    if (TreeNode.NODE_TYPE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkNodeTypeOfTreeNode(parseString(newValueExpr));
    }
    if (TreeNode.LEFT_VALUE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkLeftValueOfTreeNode(parseInt(newValueExpr));
    }
    if (TreeNode.RIGHT_VALUE_PROPERTY.equals(property)) {

      checkerOf(userContext).checkRightValueOfTreeNode(parseInt(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(TreeNodeManagerException.class);
  }

  public TreeNode clone(RetailscmUserContext userContext, String fromTreeNodeId) throws Exception {

    return treeNodeDaoOf(userContext).clone(fromTreeNodeId, this.allTokens());
  }

  public TreeNode internalSaveTreeNode(RetailscmUserContext userContext, TreeNode treeNode)
      throws Exception {
    return internalSaveTreeNode(userContext, treeNode, allTokens());
  }

  public TreeNode internalSaveTreeNode(
      RetailscmUserContext userContext, TreeNode treeNode, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingTreeNode(userContext, treeNodeId, treeNodeVersion, property,
    // newValueExpr, tokensExpr);

    synchronized (treeNode) {
      // will be good when the treeNode loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to TreeNode.
      if (treeNode.isChanged()) {}

      // checkerOf(userContext).checkAndFixTreeNode(treeNode);
      treeNode = saveTreeNode(userContext, treeNode, options);
      return treeNode;
    }
  }

  public TreeNode updateTreeNode(
      RetailscmUserContext userContext,
      String treeNodeId,
      int treeNodeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingTreeNode(
        userContext, treeNodeId, treeNodeVersion, property, newValueExpr, tokensExpr);

    TreeNode treeNode = loadTreeNode(userContext, treeNodeId, allTokens());
    if (treeNode.getVersion() != treeNodeVersion) {
      String message =
          "The target version("
              + treeNode.getVersion()
              + ") is not equals to version("
              + treeNodeVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (treeNode) {
      // will be good when the treeNode loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to TreeNode.

      treeNode.changeProperty(property, newValueExpr);
      treeNode = saveTreeNode(userContext, treeNode, tokens().done());
      return present(userContext, treeNode, mergedAllTokens(tokensExpr));
      // return saveTreeNode(userContext, treeNode, tokens().done());
    }
  }

  public TreeNode updateTreeNodeProperty(
      RetailscmUserContext userContext,
      String treeNodeId,
      int treeNodeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingTreeNode(
        userContext, treeNodeId, treeNodeVersion, property, newValueExpr, tokensExpr);

    TreeNode treeNode = loadTreeNode(userContext, treeNodeId, allTokens());
    if (treeNode.getVersion() != treeNodeVersion) {
      String message =
          "The target version("
              + treeNode.getVersion()
              + ") is not equals to version("
              + treeNodeVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (treeNode) {
      // will be good when the treeNode loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to TreeNode.

      treeNode.changeProperty(property, newValueExpr);

      treeNode = saveTreeNode(userContext, treeNode, tokens().done());
      return present(userContext, treeNode, mergedAllTokens(tokensExpr));
      // return saveTreeNode(userContext, treeNode, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected TreeNodeTokens tokens() {
    return TreeNodeTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return TreeNodeTokens.all();
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
    return TreeNodeTokens.mergeAll(tokens).done();
  }

  // --------------------------------------------------------------

  // --------------------------------------------------------------

  public TreeNode forgetByAll(
      RetailscmUserContext userContext, String treeNodeId, int treeNodeVersion) throws Exception {
    return forgetByAllInternal(userContext, treeNodeId, treeNodeVersion);
  }

  protected TreeNode forgetByAllInternal(
      RetailscmUserContext userContext, String treeNodeId, int treeNodeVersion) throws Exception {

    return treeNodeDaoOf(userContext).disconnectFromAll(treeNodeId, treeNodeVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new TreeNodeManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  public void onNewInstanceCreated(RetailscmUserContext userContext, TreeNode newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    treeNodeDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   TreeNode newTreeNode = this.createTreeNode(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newTreeNode
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
    key.put(UserApp.APP_TYPE_PROPERTY, TreeNode.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(RetailscmUserContext userContext, SmartList<TreeNode> list)
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
  public Object wxappview(RetailscmUserContext userContext, String treeNodeId) throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    TreeNode merchantObj = (TreeNode) this.view(userContext, treeNodeId);
    String merchantObjId = treeNodeId;
    String linkToUrl = "treeNodeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "节点" + "详情";
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
        MapUtil.put("id", "2-nodeId")
            .put("fieldName", "nodeId")
            .put("label", "节点Id")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("nodeId", merchantObj.getNodeId());

    propList.add(
        MapUtil.put("id", "3-nodeType")
            .put("fieldName", "nodeType")
            .put("label", "节点类型")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("nodeType", merchantObj.getNodeType());

    propList.add(
        MapUtil.put("id", "4-leftValue")
            .put("fieldName", "leftValue")
            .put("label", "左值")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("leftValue", merchantObj.getLeftValue());

    propList.add(
        MapUtil.put("id", "5-rightValue")
            .put("fieldName", "rightValue")
            .put("label", "正确的价值")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("rightValue", merchantObj.getRightValue());

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
