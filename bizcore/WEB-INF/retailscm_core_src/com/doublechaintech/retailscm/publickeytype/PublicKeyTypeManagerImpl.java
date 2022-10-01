package com.doublechaintech.retailscm.publickeytype;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.BaseViewPage;
import com.doublechaintech.retailscm.RetailscmUserContextImpl;
import com.doublechaintech.retailscm.iamservice.*;
import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentity;
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.services.IamService;
import com.doublechaintech.retailscm.tree.*;
import com.doublechaintech.retailscm.treenode.*;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.userdomain.CandidateUserDomain;
import com.doublechaintech.retailscm.userdomain.UserDomain;
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

public class PublicKeyTypeManagerImpl extends CustomRetailscmCheckerManager
    implements PublicKeyTypeManager, BusinessHandler {

  // Only some of ods have such function

  // To test
  public BlobObject exportExcelFromList(
      RetailscmUserContext userContext, String id, String listName) throws Exception {

    Map<String, Object> tokens = PublicKeyTypeTokens.start().withTokenFromListName(listName).done();
    PublicKeyType publicKeyType = (PublicKeyType) this.loadPublicKeyType(userContext, id, tokens);
    // to enrich reference object to let it show display name
    List<BaseEntity> entityListToNaming = publicKeyType.collectReferencesFromLists();
    publicKeyTypeDaoOf(userContext).alias(entityListToNaming);

    return exportListToExcel(userContext, publicKeyType, listName);
  }

  @Override
  public BaseGridViewGenerator gridViewGenerator() {
    return new PublicKeyTypeGridViewGenerator();
  }

  private static final String SERVICE_TYPE = "PublicKeyType";

  @Override
  public PublicKeyTypeDAO daoOf(RetailscmUserContext userContext) {
    return publicKeyTypeDaoOf(userContext);
  }

  @Override
  public String serviceFor() {
    return SERVICE_TYPE;
  }

  protected void throwExceptionWithMessage(String value) throws PublicKeyTypeManagerException {

    Message message = new Message();
    message.setBody(value);
    throw new PublicKeyTypeManagerException(message);
  }

  protected PublicKeyType savePublicKeyType(
      RetailscmUserContext userContext, PublicKeyType publicKeyType, String[] tokensExpr)
      throws Exception {
    // return getPublicKeyTypeDAO().save(publicKeyType, tokens);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    return savePublicKeyType(userContext, publicKeyType, tokens);
  }

  protected PublicKeyType savePublicKeyTypeDetail(
      RetailscmUserContext userContext, PublicKeyType publicKeyType) throws Exception {

    return savePublicKeyType(userContext, publicKeyType, allTokens());
  }

  public PublicKeyType loadPublicKeyType(
      RetailscmUserContext userContext, String publicKeyTypeId, String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);

    checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);

    Map<String, Object> tokens = parseTokens(tokensExpr);

    PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, tokens);
    // do some calc before sent to customer?
    return present(userContext, publicKeyType, tokens);
  }

  public PublicKeyType searchPublicKeyType(
      RetailscmUserContext userContext,
      String publicKeyTypeId,
      String textToSearch,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);

    checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);

    Map<String, Object> tokens =
        tokens()
            .allTokens()
            .searchEntireObjectText(tokens().startsWith(), textToSearch)
            .initWithArray(tokensExpr);

    PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, tokens);
    // do some calc before sent to customer?
    return present(userContext, publicKeyType, tokens);
  }

  protected PublicKeyType present(
      RetailscmUserContext userContext, PublicKeyType publicKeyType, Map<String, Object> tokens)
      throws Exception {

    addActions(userContext, publicKeyType, tokens);

    PublicKeyType publicKeyTypeToPresent =
        publicKeyTypeDaoOf(userContext).present(publicKeyType, tokens);

    List<BaseEntity> entityListToNaming = publicKeyTypeToPresent.collectReferencesFromLists();
    publicKeyTypeDaoOf(userContext).alias(entityListToNaming);

    renderActionForList(userContext, publicKeyType, tokens);

    return publicKeyTypeToPresent;
  }

  public PublicKeyType loadPublicKeyTypeDetail(
      RetailscmUserContext userContext, String publicKeyTypeId) throws Exception {
    PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, allTokens());
    return present(userContext, publicKeyType, allTokens());
  }

  public Object prepareContextForUserApp(BaseUserContext userContext, Object targetUserApp)
      throws Exception {

    UserApp userApp = (UserApp) targetUserApp;
    return this.view((RetailscmUserContext) userContext, userApp.getAppId());
  }

  public Object view(RetailscmUserContext userContext, String publicKeyTypeId) throws Exception {
    PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, viewTokens());
    markVisited(userContext, publicKeyType);
    return present(userContext, publicKeyType, viewTokens());
  }

  public Object summaryView(RetailscmUserContext userContext, String publicKeyTypeId)
      throws Exception {
    PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, viewTokens());
    publicKeyType.summarySuffix();
    markVisited(userContext, publicKeyType);
    return present(userContext, publicKeyType, summaryTokens());
  }

  public Object analyze(RetailscmUserContext userContext, String publicKeyTypeId) throws Exception {
    PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, analyzeTokens());
    markVisited(userContext, publicKeyType);
    return present(userContext, publicKeyType, analyzeTokens());
  }

  protected PublicKeyType savePublicKeyType(
      RetailscmUserContext userContext, PublicKeyType publicKeyType, Map<String, Object> tokens)
      throws Exception {

    return publicKeyTypeDaoOf(userContext).save(publicKeyType, tokens);
  }

  protected PublicKeyType loadPublicKeyType(
      RetailscmUserContext userContext, String publicKeyTypeId, Map<String, Object> tokens)
      throws Exception {
    checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);

    checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);

    return publicKeyTypeDaoOf(userContext).load(publicKeyTypeId, tokens);
  }

  protected <T extends BaseEntity> void addActions(
      RetailscmUserContext userContext, PublicKeyType publicKeyType, Map<String, Object> tokens) {
    super.addActions(userContext, publicKeyType, tokens);
  } // end method of protected<T extends BaseEntity> void addActions(RetailscmUserContext
    // userContext, PublicKeyType publicKeyType, Map<String, Object> tokens){

  @Override
  public List<PublicKeyType> searchPublicKeyTypeList(
      RetailscmUserContext ctx, PublicKeyTypeRequest pRequest) {
    pRequest.setUserContext(ctx);
    List<PublicKeyType> list = daoOf(ctx).search(pRequest);
    Searcher.enhance(list, pRequest);
    return list;
  }

  @Override
  public PublicKeyType searchPublicKeyType(
      RetailscmUserContext ctx, PublicKeyTypeRequest pRequest) {
    pRequest.limit(0, 1);
    List<PublicKeyType> list = searchPublicKeyTypeList(ctx, pRequest);
    if (list == null || list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  public PublicKeyType createPublicKeyType(
      RetailscmUserContext userContext, String keyAlg, String signAlg, String domainId)
      throws Exception {

    checkerOf(userContext).checkKeyAlgOfPublicKeyType(keyAlg);
    checkerOf(userContext).checkSignAlgOfPublicKeyType(signAlg);

    checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);

    PublicKeyType publicKeyType = createNewPublicKeyType();

    publicKeyType.setKeyAlg(keyAlg);
    publicKeyType.setSignAlg(signAlg);

    UserDomain domain = loadUserDomain(userContext, domainId, emptyOptions());
    publicKeyType.setDomain(domain);

    publicKeyType = savePublicKeyType(userContext, publicKeyType, emptyOptions());

    onNewInstanceCreated(userContext, publicKeyType);
    return publicKeyType;
  }

  protected PublicKeyType createNewPublicKeyType() {

    return new PublicKeyType();
  }

  protected void checkParamsForUpdatingPublicKeyType(
      RetailscmUserContext userContext,
      String publicKeyTypeId,
      int publicKeyTypeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);
    checkerOf(userContext).checkVersionOfPublicKeyType(publicKeyTypeVersion);

    if (PublicKeyType.KEY_ALG_PROPERTY.equals(property)) {

      checkerOf(userContext).checkKeyAlgOfPublicKeyType(parseString(newValueExpr));
    }
    if (PublicKeyType.SIGN_ALG_PROPERTY.equals(property)) {

      checkerOf(userContext).checkSignAlgOfPublicKeyType(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);
  }

  public PublicKeyType clone(RetailscmUserContext userContext, String fromPublicKeyTypeId)
      throws Exception {

    return publicKeyTypeDaoOf(userContext).clone(fromPublicKeyTypeId, this.allTokens());
  }

  public PublicKeyType internalSavePublicKeyType(
      RetailscmUserContext userContext, PublicKeyType publicKeyType) throws Exception {
    return internalSavePublicKeyType(userContext, publicKeyType, allTokens());
  }

  public PublicKeyType internalSavePublicKeyType(
      RetailscmUserContext userContext, PublicKeyType publicKeyType, Map<String, Object> options)
      throws Exception {
    // checkParamsForUpdatingPublicKeyType(userContext, publicKeyTypeId, publicKeyTypeVersion,
    // property, newValueExpr, tokensExpr);

    synchronized (publicKeyType) {
      // will be good when the publicKeyType loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to PublicKeyType.
      if (publicKeyType.isChanged()) {}

      // checkerOf(userContext).checkAndFixPublicKeyType(publicKeyType);
      publicKeyType = savePublicKeyType(userContext, publicKeyType, options);
      return publicKeyType;
    }
  }

  public PublicKeyType updatePublicKeyType(
      RetailscmUserContext userContext,
      String publicKeyTypeId,
      int publicKeyTypeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingPublicKeyType(
        userContext, publicKeyTypeId, publicKeyTypeVersion, property, newValueExpr, tokensExpr);

    PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, allTokens());
    if (publicKeyType.getVersion() != publicKeyTypeVersion) {
      String message =
          "The target version("
              + publicKeyType.getVersion()
              + ") is not equals to version("
              + publicKeyTypeVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (publicKeyType) {
      // will be good when the publicKeyType loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to PublicKeyType.

      publicKeyType.changeProperty(property, newValueExpr);
      publicKeyType = savePublicKeyType(userContext, publicKeyType, tokens().done());
      return present(userContext, publicKeyType, mergedAllTokens(tokensExpr));
      // return savePublicKeyType(userContext, publicKeyType, tokens().done());
    }
  }

  public PublicKeyType updatePublicKeyTypeProperty(
      RetailscmUserContext userContext,
      String publicKeyTypeId,
      int publicKeyTypeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingPublicKeyType(
        userContext, publicKeyTypeId, publicKeyTypeVersion, property, newValueExpr, tokensExpr);

    PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, allTokens());
    if (publicKeyType.getVersion() != publicKeyTypeVersion) {
      String message =
          "The target version("
              + publicKeyType.getVersion()
              + ") is not equals to version("
              + publicKeyTypeVersion
              + ") provided";
      throwExceptionWithMessage(message);
    }
    synchronized (publicKeyType) {
      // will be good when the publicKeyType loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      // make changes to PublicKeyType.

      publicKeyType.changeProperty(property, newValueExpr);

      publicKeyType = savePublicKeyType(userContext, publicKeyType, tokens().done());
      return present(userContext, publicKeyType, mergedAllTokens(tokensExpr));
      // return savePublicKeyType(userContext, publicKeyType, tokens().done());
    }
  }

  protected Map<String, Object> emptyOptions() {
    return tokens().done();
  }

  protected PublicKeyTypeTokens tokens() {
    return PublicKeyTypeTokens.start();
  }

  protected Map<String, Object> parseTokens(String[] tokensExpr) {
    return tokens().initWithArray(tokensExpr);
  }

  protected Map<String, Object> allTokens() {
    return PublicKeyTypeTokens.all();
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
        .sortKeyPairIdentityListWith(KeyPairIdentity.ID_PROPERTY, sortDesc())
        .done();
  }

  protected Map<String, Object> mergedAllTokens(String[] tokens) {
    return PublicKeyTypeTokens.mergeAll(tokens).done();
  }

  protected void checkParamsForTransferingAnotherDomain(
      RetailscmUserContext userContext, String publicKeyTypeId, String anotherDomainId)
      throws Exception {

    checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);
    checkerOf(userContext).checkIdOfUserDomain(anotherDomainId); // check for optional reference

    checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);
  }

  public PublicKeyType transferToAnotherDomain(
      RetailscmUserContext userContext, String publicKeyTypeId, String anotherDomainId)
      throws Exception {
    checkParamsForTransferingAnotherDomain(userContext, publicKeyTypeId, anotherDomainId);

    PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, allTokens());
    synchronized (publicKeyType) {
      // will be good when the publicKeyType loaded from this JVM process cache.
      // also good when there is a ram based DAO implementation
      UserDomain domain = loadUserDomain(userContext, anotherDomainId, emptyOptions());
      publicKeyType.updateDomain(domain);

      publicKeyType = savePublicKeyType(userContext, publicKeyType, emptyOptions());

      return present(userContext, publicKeyType, allTokens());
    }
  }

  public CandidateUserDomain requestCandidateDomain(
      RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo)
      throws Exception {

    CandidateUserDomain result = new CandidateUserDomain();
    result.setOwnerClass(ownerClass);
    result.setOwnerId(id);
    result.setFilterKey(filterKey == null ? "" : filterKey.trim());
    result.setPageNo(pageNo);
    result.setValueFieldName("id");
    result.setDisplayFieldName("name");

    pageNo = Math.max(1, pageNo);
    int pageSize = 20;
    // requestCandidateProductForSkuAsOwner
    SmartList<UserDomain> candidateList =
        userDomainDaoOf(userContext)
            .requestCandidateUserDomainForPublicKeyType(
                userContext, ownerClass, id, filterKey, pageNo, pageSize);
    result.setCandidates(candidateList);
    int totalCount = candidateList.getTotalCount();
    result.setTotalPage(Math.max(1, (totalCount + pageSize - 1) / pageSize));
    return result;
  }

  // --------------------------------------------------------------

  protected UserDomain loadUserDomain(
      RetailscmUserContext userContext, String newDomainId, Map<String, Object> options)
      throws Exception {

    return userDomainDaoOf(userContext).load(newDomainId, options);
  }

  // --------------------------------------------------------------

  public PublicKeyType forgetByAll(
      RetailscmUserContext userContext, String publicKeyTypeId, int publicKeyTypeVersion)
      throws Exception {
    return forgetByAllInternal(userContext, publicKeyTypeId, publicKeyTypeVersion);
  }

  protected PublicKeyType forgetByAllInternal(
      RetailscmUserContext userContext, String publicKeyTypeId, int publicKeyTypeVersion)
      throws Exception {

    return publicKeyTypeDaoOf(userContext).disconnectFromAll(publicKeyTypeId, publicKeyTypeVersion);
  }

  public int deleteAll(RetailscmUserContext userContext, String secureCode) throws Exception {
    /*
    if(!("dElEtEaLl".equals(secureCode))){
    	throw new PublicKeyTypeManagerException("Your secure code is not right, please guess again");
    }
    return deleteAllInternal(userContext);
    */
    return 0;
  }

  protected void checkParamsForAddingKeyPairIdentity(
      RetailscmUserContext userContext,
      String publicKeyTypeId,
      String publicKey,
      String secUserId,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);

    checkerOf(userContext).checkPublicKeyOfKeyPairIdentity(publicKey);

    checkerOf(userContext).checkSecUserIdOfKeyPairIdentity(secUserId);

    checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);
  }

  public PublicKeyType addKeyPairIdentity(
      RetailscmUserContext userContext,
      String publicKeyTypeId,
      String publicKey,
      String secUserId,
      String[] tokensExpr)
      throws Exception {
    checkParamsForAddingKeyPairIdentity(
        userContext, publicKeyTypeId, publicKey, secUserId, tokensExpr);

    KeyPairIdentity keyPairIdentity = createKeyPairIdentity(userContext, publicKey, secUserId);

    PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, emptyOptions());
    synchronized (publicKeyType) {
      // Will be good when the publicKeyType loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      publicKeyType.addKeyPairIdentity(keyPairIdentity);
      publicKeyType =
          savePublicKeyType(userContext, publicKeyType, tokens().withKeyPairIdentityList().done());

      keyPairIdentityManagerOf(userContext).onNewInstanceCreated(userContext, keyPairIdentity);
      return present(userContext, publicKeyType, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingKeyPairIdentityProperties(
      RetailscmUserContext userContext,
      String publicKeyTypeId,
      String id,
      String publicKey,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);
    checkerOf(userContext).checkIdOfKeyPairIdentity(id);

    checkerOf(userContext).checkPublicKeyOfKeyPairIdentity(publicKey);

    checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);
  }

  public PublicKeyType updateKeyPairIdentityProperties(
      RetailscmUserContext userContext,
      String publicKeyTypeId,
      String id,
      String publicKey,
      String[] tokensExpr)
      throws Exception {
    checkParamsForUpdatingKeyPairIdentityProperties(
        userContext, publicKeyTypeId, id, publicKey, tokensExpr);

    Map<String, Object> options =
        tokens()
            .allTokens()
            // .withKeyPairIdentityListList()
            .searchKeyPairIdentityListWith(KeyPairIdentity.ID_PROPERTY, tokens().is(), id)
            .done();

    PublicKeyType publicKeyTypeToUpdate = loadPublicKeyType(userContext, publicKeyTypeId, options);

    if (publicKeyTypeToUpdate.getKeyPairIdentityList().isEmpty()) {
      throw new PublicKeyTypeManagerException("KeyPairIdentity is NOT FOUND with id: '" + id + "'");
    }

    KeyPairIdentity item = publicKeyTypeToUpdate.getKeyPairIdentityList().first();
    beforeUpdateKeyPairIdentityProperties(
        userContext, item, publicKeyTypeId, id, publicKey, tokensExpr);
    item.updatePublicKey(publicKey);

    // checkParamsForAddingKeyPairIdentity(userContext,publicKeyTypeId,name, code, used,tokensExpr);
    PublicKeyType publicKeyType =
        savePublicKeyType(
            userContext, publicKeyTypeToUpdate, tokens().withKeyPairIdentityList().done());
    synchronized (publicKeyType) {
      return present(userContext, publicKeyType, mergedAllTokens(tokensExpr));
    }
  }

  protected void beforeUpdateKeyPairIdentityProperties(
      RetailscmUserContext userContext,
      KeyPairIdentity item,
      String publicKeyTypeId,
      String id,
      String publicKey,
      String[] tokensExpr)
      throws Exception {
    // by default, nothing to do
  }

  protected KeyPairIdentity createKeyPairIdentity(
      RetailscmUserContext userContext, String publicKey, String secUserId) throws Exception {

    KeyPairIdentity keyPairIdentity = new KeyPairIdentity();

    keyPairIdentity.setPublicKey(publicKey);
    SecUser secUser = new SecUser();
    secUser.setId(secUserId);
    keyPairIdentity.setSecUser(secUser);
    keyPairIdentity.setCreateTime(userContext.now());

    return keyPairIdentity;
  }

  protected KeyPairIdentity createIndexedKeyPairIdentity(String id, int version) {

    KeyPairIdentity keyPairIdentity = new KeyPairIdentity();
    keyPairIdentity.setId(id);
    keyPairIdentity.setVersion(version);
    return keyPairIdentity;
  }

  protected void checkParamsForRemovingKeyPairIdentityList(
      RetailscmUserContext userContext,
      String publicKeyTypeId,
      String keyPairIdentityIds[],
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);
    for (String keyPairIdentityIdItem : keyPairIdentityIds) {
      checkerOf(userContext).checkIdOfKeyPairIdentity(keyPairIdentityIdItem);
    }

    checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);
  }

  public PublicKeyType removeKeyPairIdentityList(
      RetailscmUserContext userContext,
      String publicKeyTypeId,
      String keyPairIdentityIds[],
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingKeyPairIdentityList(
        userContext, publicKeyTypeId, keyPairIdentityIds, tokensExpr);

    PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, allTokens());
    synchronized (publicKeyType) {
      // Will be good when the publicKeyType loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      publicKeyTypeDaoOf(userContext)
          .planToRemoveKeyPairIdentityList(publicKeyType, keyPairIdentityIds, allTokens());
      publicKeyType =
          savePublicKeyType(userContext, publicKeyType, tokens().withKeyPairIdentityList().done());
      deleteRelationListInGraph(userContext, publicKeyType.getKeyPairIdentityList());
      return present(userContext, publicKeyType, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForRemovingKeyPairIdentity(
      RetailscmUserContext userContext,
      String publicKeyTypeId,
      String keyPairIdentityId,
      int keyPairIdentityVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);
    checkerOf(userContext).checkIdOfKeyPairIdentity(keyPairIdentityId);
    checkerOf(userContext).checkVersionOfKeyPairIdentity(keyPairIdentityVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);
  }

  public PublicKeyType removeKeyPairIdentity(
      RetailscmUserContext userContext,
      String publicKeyTypeId,
      String keyPairIdentityId,
      int keyPairIdentityVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForRemovingKeyPairIdentity(
        userContext, publicKeyTypeId, keyPairIdentityId, keyPairIdentityVersion, tokensExpr);

    KeyPairIdentity keyPairIdentity =
        createIndexedKeyPairIdentity(keyPairIdentityId, keyPairIdentityVersion);
    PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, allTokens());
    synchronized (publicKeyType) {
      // Will be good when the publicKeyType loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      publicKeyType.removeKeyPairIdentity(keyPairIdentity);
      publicKeyType =
          savePublicKeyType(userContext, publicKeyType, tokens().withKeyPairIdentityList().done());
      deleteRelationInGraph(userContext, keyPairIdentity);
      return present(userContext, publicKeyType, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForCopyingKeyPairIdentity(
      RetailscmUserContext userContext,
      String publicKeyTypeId,
      String keyPairIdentityId,
      int keyPairIdentityVersion,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);
    checkerOf(userContext).checkIdOfKeyPairIdentity(keyPairIdentityId);
    checkerOf(userContext).checkVersionOfKeyPairIdentity(keyPairIdentityVersion);

    checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);
  }

  public PublicKeyType copyKeyPairIdentityFrom(
      RetailscmUserContext userContext,
      String publicKeyTypeId,
      String keyPairIdentityId,
      int keyPairIdentityVersion,
      String[] tokensExpr)
      throws Exception {

    checkParamsForCopyingKeyPairIdentity(
        userContext, publicKeyTypeId, keyPairIdentityId, keyPairIdentityVersion, tokensExpr);

    KeyPairIdentity keyPairIdentity =
        createIndexedKeyPairIdentity(keyPairIdentityId, keyPairIdentityVersion);
    PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, allTokens());
    synchronized (publicKeyType) {
      // Will be good when the publicKeyType loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation

      publicKeyType.copyKeyPairIdentityFrom(keyPairIdentity);
      publicKeyType =
          savePublicKeyType(userContext, publicKeyType, tokens().withKeyPairIdentityList().done());

      keyPairIdentityManagerOf(userContext)
          .onNewInstanceCreated(
              userContext,
              (KeyPairIdentity) publicKeyType.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
      return present(userContext, publicKeyType, mergedAllTokens(tokensExpr));
    }
  }

  protected void checkParamsForUpdatingKeyPairIdentity(
      RetailscmUserContext userContext,
      String publicKeyTypeId,
      String keyPairIdentityId,
      int keyPairIdentityVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkerOf(userContext).checkIdOfPublicKeyType(publicKeyTypeId);
    checkerOf(userContext).checkIdOfKeyPairIdentity(keyPairIdentityId);
    checkerOf(userContext).checkVersionOfKeyPairIdentity(keyPairIdentityVersion);

    if (KeyPairIdentity.PUBLIC_KEY_PROPERTY.equals(property)) {
      checkerOf(userContext).checkPublicKeyOfKeyPairIdentity(parseString(newValueExpr));
    }

    checkerOf(userContext).throwExceptionIfHasErrors(PublicKeyTypeManagerException.class);
  }

  public PublicKeyType updateKeyPairIdentity(
      RetailscmUserContext userContext,
      String publicKeyTypeId,
      String keyPairIdentityId,
      int keyPairIdentityVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {

    checkParamsForUpdatingKeyPairIdentity(
        userContext,
        publicKeyTypeId,
        keyPairIdentityId,
        keyPairIdentityVersion,
        property,
        newValueExpr,
        tokensExpr);

    Map<String, Object> loadTokens =
        this.tokens()
            .withKeyPairIdentityList()
            .searchKeyPairIdentityListWith(
                KeyPairIdentity.ID_PROPERTY, tokens().equals(), keyPairIdentityId)
            .done();

    PublicKeyType publicKeyType = loadPublicKeyType(userContext, publicKeyTypeId, loadTokens);

    synchronized (publicKeyType) {
      // Will be good when the publicKeyType loaded from this JVM process cache.
      // Also good when there is a RAM based DAO implementation
      // publicKeyType.removeKeyPairIdentity( keyPairIdentity );
      // make changes to AcceleraterAccount.
      KeyPairIdentity keyPairIdentityIdVersionKey =
          createIndexedKeyPairIdentity(keyPairIdentityId, keyPairIdentityVersion);

      KeyPairIdentity keyPairIdentity =
          publicKeyType.findTheKeyPairIdentity(keyPairIdentityIdVersionKey);
      if (keyPairIdentity == null) {
        throw new PublicKeyTypeManagerException(keyPairIdentityId + " is NOT FOUND");
      }

      beforeUpdateKeyPairIdentity(
          userContext,
          keyPairIdentity,
          publicKeyTypeId,
          keyPairIdentityId,
          keyPairIdentityVersion,
          property,
          newValueExpr,
          tokensExpr);
      keyPairIdentity.changeProperty(property, newValueExpr);

      publicKeyType =
          savePublicKeyType(userContext, publicKeyType, tokens().withKeyPairIdentityList().done());
      keyPairIdentityManagerOf(userContext)
          .onUpdated(userContext, keyPairIdentity, this, "updateKeyPairIdentity");
      return present(userContext, publicKeyType, mergedAllTokens(tokensExpr));
    }
  }

  /** if you has something need to do before update data from DB, override this */
  protected void beforeUpdateKeyPairIdentity(
      RetailscmUserContext userContext,
      KeyPairIdentity existed,
      String publicKeyTypeId,
      String keyPairIdentityId,
      int keyPairIdentityVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception {}
  /*

  */

  public void onNewInstanceCreated(RetailscmUserContext userContext, PublicKeyType newCreated)
      throws Exception {
    ensureRelationInGraph(userContext, newCreated);
    sendCreationEvent(userContext, newCreated);
  }

  public void sendAllItems(RetailscmUserContext ctx) throws Exception {
    publicKeyTypeDaoOf(ctx).loadAllAsStream().forEach(event -> sendInitEvent(ctx, event));
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
    //   PublicKeyType newPublicKeyType = this.createPublicKeyType(userContext, ...
    // Next, create a sec-user in your business way:
    //   SecUser secUser = secUserManagerOf(userContext).createSecUser(userContext, login, mobile
    // ...
    // And set it into loginContext:
    //   loginContext.getLoginTarget().setSecUser(secUser);
    // Next, create an user-app to connect secUser and newPublicKeyType
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
    key.put(UserApp.APP_TYPE_PROPERTY, PublicKeyType.INTERNAL_TYPE);
    SmartList<UserApp> userApps =
        userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, EO);
    return userApps;
  }
  // -----------------------------------\\  登录部分处理 //-----------------------------------

  // -----------------------------------// list-of-view 处理 \\-----------------------------------
  protected void enhanceForListOfView(
      RetailscmUserContext userContext, SmartList<PublicKeyType> list) throws Exception {
    if (list == null || list.isEmpty()) {
      return;
    }
    List<UserDomain> domainList =
        RetailscmBaseUtils.collectReferencedObjectWithType(userContext, list, UserDomain.class);
    userContext.getDAOGroup().enhanceList(domainList, UserDomain.class);
  }

  public Object listByDomain(RetailscmUserContext userContext, String domainId) throws Exception {
    return listPageByDomain(userContext, domainId, 0, 20);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  public Object listPageByDomain(
      RetailscmUserContext userContext, String domainId, int start, int count) throws Exception {
    SmartList<PublicKeyType> list =
        publicKeyTypeDaoOf(userContext)
            .findPublicKeyTypeByDomain(domainId, start, count, new HashMap<>());
    enhanceForListOfView(userContext, list);
    RetailscmCommonListOfViewPage page = new RetailscmCommonListOfViewPage();
    page.setClassOfList(PublicKeyType.class);
    page.setContainerObject(UserDomain.withId(domainId));
    page.setRequestBeanName(this.getBeanName());
    page.setDataList((SmartList) list);
    page.setPageTitle("公钥类型列表");
    page.setRequestName("listByDomain");
    page.setRequestOffset(start);
    page.setRequestLimit(count);
    page.setDisplayMode("auto");
    page.setLinkToUrl(
        TextUtil.encodeUrl(String.format("%s/listByDomain/%s/", getBeanName(), domainId)));

    page.assemblerContent(userContext, "listByDomain");
    return page.doRender(userContext);
  }

  // -----------------------------------\\ list-of-view 处理 //-----------------------------------v

  /**
   * miniprogram调用返回固定的detail class
   *
   * @return
   * @throws Exception
   */
  public Object wxappview(RetailscmUserContext userContext, String publicKeyTypeId)
      throws Exception {
    SerializeScope vscope = SerializeScope.EXCLUDE().nothing();
    PublicKeyType merchantObj = (PublicKeyType) this.view(userContext, publicKeyTypeId);
    String merchantObjId = publicKeyTypeId;
    String linkToUrl = "publicKeyTypeManager/wxappview/" + merchantObjId + "/";
    String pageTitle = "公钥类型" + "详情";
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
        MapUtil.put("id", "2-keyAlg")
            .put("fieldName", "keyAlg")
            .put("label", "键 ALG")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("keyAlg", merchantObj.getKeyAlg());

    propList.add(
        MapUtil.put("id", "3-signAlg")
            .put("fieldName", "signAlg")
            .put("label", "Alg迹象")
            .put("type", "text")
            .put("linkToUrl", "")
            .put("displayMode", "{}")
            .into_map());
    result.put("signAlg", merchantObj.getSignAlg());

    propList.add(
        MapUtil.put("id", "4-domain")
            .put("fieldName", "domain")
            .put("label", "域")
            .put("type", "auto")
            .put("linkToUrl", "userDomainManager/wxappview/:id/")
            .put(
                "displayMode",
                "{\"brief\":\"\",\"imageUrl\":\"\",\"name\":\"auto\",\"title\":\"name\",\"imageList\":\"\"}")
            .into_map());
    result.put("domain", merchantObj.getDomain());

    // 处理 sectionList

    // 处理Section：keyPairIdentityListSection
    Map keyPairIdentityListSection =
        ListofUtils.buildSection(
            "keyPairIdentityListSection",
            "密钥对身份列表",
            null,
            "",
            "__no_group",
            "keyPairIdentityManager/listByKeyType/" + merchantObjId + "/",
            "auto");
    sections.add(keyPairIdentityListSection);

    result.put(
        "keyPairIdentityListSection",
        ListofUtils.toShortList(merchantObj.getKeyPairIdentityList(), "keyPairIdentity"));

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
