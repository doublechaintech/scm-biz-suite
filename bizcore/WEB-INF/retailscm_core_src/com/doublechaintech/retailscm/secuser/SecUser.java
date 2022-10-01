package com.doublechaintech.retailscm.secuser;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentity;
import com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentity;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentity;
import com.doublechaintech.retailscm.userdomain.UserDomain;
import com.doublechaintech.retailscm.loginhistory.LoginHistory;

@JsonSerialize(using = SecUserSerializer.class)
public class SecUser extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(SecUser target) {
    if (target == null) {
      return;
    }
    target.addUserAppList(this.getUserAppList());
    target.addLoginHistoryList(this.getLoginHistoryList());
    target.addWechatWorkappIdentityList(this.getWechatWorkappIdentityList());
    target.addWechatMiniappIdentityList(this.getWechatMiniappIdentityList());
    target.addKeyPairIdentityList(this.getKeyPairIdentityList());
  }

  public static final String ID_PROPERTY = "id";
  public static final String LOGIN_PROPERTY = "login";
  public static final String MOBILE_PROPERTY = "mobile";
  public static final String EMAIL_PROPERTY = "email";
  public static final String PWD_PROPERTY = "pwd";
  public static final String WEIXIN_OPENID_PROPERTY = "weixinOpenid";
  public static final String WEIXIN_APPID_PROPERTY = "weixinAppid";
  public static final String ACCESS_TOKEN_PROPERTY = "accessToken";
  public static final String VERIFICATION_CODE_PROPERTY = "verificationCode";
  public static final String VERIFICATION_CODE_EXPIRE_PROPERTY = "verificationCodeExpire";
  public static final String LAST_LOGIN_TIME_PROPERTY = "lastLoginTime";
  public static final String DOMAIN_PROPERTY = "domain";
  public static final String VERSION_PROPERTY = "version";

  public static final String USER_APP_LIST = "userAppList";
  public static final String LOGIN_HISTORY_LIST = "loginHistoryList";
  public static final String WECHAT_WORKAPP_IDENTITY_LIST = "wechatWorkappIdentityList";
  public static final String WECHAT_MINIAPP_IDENTITY_LIST = "wechatMiniappIdentityList";
  public static final String KEY_PAIR_IDENTITY_LIST = "keyPairIdentityList";

  public static final String INTERNAL_TYPE = "SecUser";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LOGIN_PROPERTY, "login", "登录").withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(MOBILE_PROPERTY, "mobile", "手机")
            .withType("string_china_mobile_phone", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(EMAIL_PROPERTY, "email", "电子邮件")
            .withType("string_email", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(PWD_PROPERTY, "pwd", "PWD")
            .withType("string_password", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(WEIXIN_OPENID_PROPERTY, "weixin_openid", "微信openid")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(WEIXIN_APPID_PROPERTY, "weixin_appid", "微信Appid")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ACCESS_TOKEN_PROPERTY, "access_token", "访问令牌")
            .withType("string", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERIFICATION_CODE_PROPERTY, "verification_code", "验证码")
            .withType("int", "int"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(
                VERIFICATION_CODE_EXPIRE_PROPERTY, "verification_code_expire", "验证码过期")
            .withType("date_time", DateTime.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(LAST_LOGIN_TIME_PROPERTY, "last_login_time", "最后登录时间")
            .withType("date_time", DateTime.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(DOMAIN_PROPERTY, "user_domain", "域")
            .withType("user_domain", UserDomain.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(USER_APP_LIST, "secUser", "用户应用程序列表")
            .withType("user_app", UserApp.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(LOGIN_HISTORY_LIST, "secUser", "登录历史列表")
            .withType("login_history", LoginHistory.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(WECHAT_WORKAPP_IDENTITY_LIST, "secUser", "微信企业号认证列表")
            .withType("wechat_workapp_identity", WechatWorkappIdentity.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(WECHAT_MINIAPP_IDENTITY_LIST, "secUser", "微信小程序认证列表")
            .withType("wechat_miniapp_identity", WechatMiniappIdentity.class));

    memberMetaInfoList.add(
        MemberMetaInfo.referBy(KEY_PAIR_IDENTITY_LIST, "secUser", "密钥对身份列表")
            .withType("key_pair_identity", KeyPairIdentity.class));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
      ID_PROPERTY,
      LOGIN_PROPERTY,
      MOBILE_PROPERTY,
      EMAIL_PROPERTY,
      PWD_PROPERTY,
      WEIXIN_OPENID_PROPERTY,
      WEIXIN_APPID_PROPERTY,
      ACCESS_TOKEN_PROPERTY,
      VERIFICATION_CODE_PROPERTY,
      VERIFICATION_CODE_EXPIRE_PROPERTY,
      LAST_LOGIN_TIME_PROPERTY,
      DOMAIN_PROPERTY,
      VERSION_PROPERTY
    };
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    refers.put(USER_APP_LIST, "secUser");

    refers.put(LOGIN_HISTORY_LIST, "secUser");

    refers.put(WECHAT_WORKAPP_IDENTITY_LIST, "secUser");

    refers.put(WECHAT_MINIAPP_IDENTITY_LIST, "secUser");

    refers.put(KEY_PAIR_IDENTITY_LIST, "secUser");

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    refers.put(USER_APP_LIST, UserApp.class);

    refers.put(LOGIN_HISTORY_LIST, LoginHistory.class);

    refers.put(WECHAT_WORKAPP_IDENTITY_LIST, WechatWorkappIdentity.class);

    refers.put(WECHAT_MINIAPP_IDENTITY_LIST, WechatMiniappIdentity.class);

    refers.put(KEY_PAIR_IDENTITY_LIST, KeyPairIdentity.class);

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(DOMAIN_PROPERTY, UserDomain.class);

    return parents;
  }
  /*
  public SecUser want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public SecUser wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getLogin();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected String login;
  protected String mobile;
  protected String email;
  protected String pwd;
  protected String weixinOpenid;
  protected String weixinAppid;
  protected String accessToken;
  protected int verificationCode;
  protected DateTime verificationCodeExpire;
  protected DateTime lastLoginTime;
  protected UserDomain domain;
  protected int version;

  protected SmartList<UserApp> mUserAppList;
  protected SmartList<LoginHistory> mLoginHistoryList;
  protected SmartList<WechatWorkappIdentity> mWechatWorkappIdentityList;
  protected SmartList<WechatMiniappIdentity> mWechatMiniappIdentityList;
  protected SmartList<KeyPairIdentity> mKeyPairIdentityList;

  public SecUser() {
    // lazy load for all the properties
  }

  public static SecUser withId(String id) {
    SecUser secUser = new SecUser();
    secUser.setId(id);
    secUser.setVersion(Integer.MAX_VALUE);
    secUser.setChecked(true);
    return secUser;
  }

  public static SecUser refById(String id) {
    return withId(id);
  }

  public SecUser limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public SecUser limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static SecUser searchExample() {
    SecUser secUser = new SecUser();
    secUser.setVerificationCode(UNSET_INT);
    secUser.setVersion(UNSET_INT);

    return secUser;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setDomain( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (LOGIN_PROPERTY.equals(property)) {
      changeLoginProperty(newValueExpr);
    }
    if (MOBILE_PROPERTY.equals(property)) {
      changeMobileProperty(newValueExpr);
    }
    if (EMAIL_PROPERTY.equals(property)) {
      changeEmailProperty(newValueExpr);
    }
    if (PWD_PROPERTY.equals(property)) {
      changePwdProperty(newValueExpr);
    }
    if (WEIXIN_OPENID_PROPERTY.equals(property)) {
      changeWeixinOpenidProperty(newValueExpr);
    }
    if (WEIXIN_APPID_PROPERTY.equals(property)) {
      changeWeixinAppidProperty(newValueExpr);
    }
    if (ACCESS_TOKEN_PROPERTY.equals(property)) {
      changeAccessTokenProperty(newValueExpr);
    }
    if (VERIFICATION_CODE_PROPERTY.equals(property)) {
      changeVerificationCodeProperty(newValueExpr);
    }
    if (VERIFICATION_CODE_EXPIRE_PROPERTY.equals(property)) {
      changeVerificationCodeExpireProperty(newValueExpr);
    }
    if (LAST_LOGIN_TIME_PROPERTY.equals(property)) {
      changeLastLoginTimeProperty(newValueExpr);
    }
  }

  protected void changeLoginProperty(String newValueExpr) {

    String oldValue = getLogin();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLogin(newValue);
    this.onChangeProperty(LOGIN_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeMobileProperty(String newValueExpr) {

    String oldValue = getMobile();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateMobile(newValue);
    this.onChangeProperty(MOBILE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeEmailProperty(String newValueExpr) {

    String oldValue = getEmail();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateEmail(newValue);
    this.onChangeProperty(EMAIL_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changePwdProperty(String newValueExpr) {

    String oldValue = getPwd();
    String newValue = parseString(hashStringWithSHA256(newValueExpr));
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updatePwd(newValueExpr);
    this.onChangeProperty(PWD_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeWeixinOpenidProperty(String newValueExpr) {

    String oldValue = getWeixinOpenid();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateWeixinOpenid(newValue);
    this.onChangeProperty(WEIXIN_OPENID_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeWeixinAppidProperty(String newValueExpr) {

    String oldValue = getWeixinAppid();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateWeixinAppid(newValue);
    this.onChangeProperty(WEIXIN_APPID_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeAccessTokenProperty(String newValueExpr) {

    String oldValue = getAccessToken();
    String newValue = parseString(newValueExpr);
    if (equalsString(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateAccessToken(newValue);
    this.onChangeProperty(ACCESS_TOKEN_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeVerificationCodeProperty(String newValueExpr) {

    int oldValue = getVerificationCode();
    int newValue = parseInt(newValueExpr);
    if (equalsInt(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateVerificationCode(newValue);
    this.onChangeProperty(VERIFICATION_CODE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeVerificationCodeExpireProperty(String newValueExpr) {

    DateTime oldValue = getVerificationCodeExpire();
    DateTime newValue = parseTimestamp(newValueExpr);
    if (equalsTimestamp(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateVerificationCodeExpire(newValue);
    this.onChangeProperty(VERIFICATION_CODE_EXPIRE_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeLastLoginTimeProperty(String newValueExpr) {

    DateTime oldValue = getLastLoginTime();
    DateTime newValue = parseTimestamp(newValueExpr);
    if (equalsTimestamp(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateLastLoginTime(newValue);
    this.onChangeProperty(LAST_LOGIN_TIME_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (LOGIN_PROPERTY.equals(property)) {
      return getLogin();
    }
    if (MOBILE_PROPERTY.equals(property)) {
      return getMobile();
    }
    if (EMAIL_PROPERTY.equals(property)) {
      return getEmail();
    }
    if (PWD_PROPERTY.equals(property)) {
      return getPwd();
    }
    if (WEIXIN_OPENID_PROPERTY.equals(property)) {
      return getWeixinOpenid();
    }
    if (WEIXIN_APPID_PROPERTY.equals(property)) {
      return getWeixinAppid();
    }
    if (ACCESS_TOKEN_PROPERTY.equals(property)) {
      return getAccessToken();
    }
    if (VERIFICATION_CODE_PROPERTY.equals(property)) {
      return getVerificationCode();
    }
    if (VERIFICATION_CODE_EXPIRE_PROPERTY.equals(property)) {
      return getVerificationCodeExpire();
    }
    if (LAST_LOGIN_TIME_PROPERTY.equals(property)) {
      return getLastLoginTime();
    }
    if (DOMAIN_PROPERTY.equals(property)) {
      return getDomain();
    }
    if (USER_APP_LIST.equals(property)) {
      List<BaseEntity> list =
          getUserAppList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (LOGIN_HISTORY_LIST.equals(property)) {
      List<BaseEntity> list =
          getLoginHistoryList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (WECHAT_WORKAPP_IDENTITY_LIST.equals(property)) {
      List<BaseEntity> list =
          getWechatWorkappIdentityList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (WECHAT_MINIAPP_IDENTITY_LIST.equals(property)) {
      List<BaseEntity> list =
          getWechatMiniappIdentityList().stream().map(item -> item).collect(Collectors.toList());
      return list;
    }
    if (KEY_PAIR_IDENTITY_LIST.equals(property)) {
      List<BaseEntity> list =
          getKeyPairIdentityList().stream().map(item -> item).collect(Collectors.toList());
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

  public SecUser updateId(String id) {
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

  public SecUser orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public SecUser ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public SecUser addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setLogin(String login) {
    String oldLogin = this.login;
    String newLogin = trimString(login);
    this.login = newLogin;
  }

  public String login() {
    doLoad();
    return getLogin();
  }

  public String getLogin() {
    return this.login;
  }

  public SecUser updateLogin(String login) {
    String oldLogin = this.login;
    String newLogin = trimString(login);
    if (!shouldReplaceBy(newLogin, oldLogin)) {
      return this;
    }
    this.login = newLogin;
    if (cn.hutool.core.util.ObjectUtil.equals(newLogin, oldLogin)) {
      return this;
    }
    addPropertyChange(LOGIN_PROPERTY, oldLogin, newLogin);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SecUser orderByLogin(boolean asc) {
    doAddOrderBy(LOGIN_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLoginCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LOGIN_PROPERTY, operator, parameters);
  }

  public SecUser ignoreLoginCriteria() {
    super.ignoreSearchProperty(LOGIN_PROPERTY);
    return this;
  }

  public SecUser addLoginCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLoginCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLogin(String login) {
    if (login != null) {
      updateLogin(login);
    }
  }

  public void setMobile(String mobile) {
    String oldMobile = this.mobile;
    String newMobile = trimString(mobile);
    this.mobile = newMobile;
  }

  public String mobile() {
    doLoad();
    return getMobile();
  }

  public String getMobile() {
    return this.mobile;
  }

  public SecUser updateMobile(String mobile) {
    String oldMobile = this.mobile;
    String newMobile = trimString(mobile);
    if (!shouldReplaceBy(newMobile, oldMobile)) {
      return this;
    }
    this.mobile = newMobile;
    if (cn.hutool.core.util.ObjectUtil.equals(newMobile, oldMobile)) {
      return this;
    }
    addPropertyChange(MOBILE_PROPERTY, oldMobile, newMobile);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SecUser orderByMobile(boolean asc) {
    doAddOrderBy(MOBILE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createMobileCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(MOBILE_PROPERTY, operator, parameters);
  }

  public SecUser ignoreMobileCriteria() {
    super.ignoreSearchProperty(MOBILE_PROPERTY);
    return this;
  }

  public SecUser addMobileCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createMobileCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeMobile(String mobile) {
    if (mobile != null) {
      updateMobile(mobile);
    }
  }

  public String getMaskedMobile() {
    String mobilePhoneNumber = getMobile();
    return maskChinaMobileNumber(mobilePhoneNumber);
  }

  public void setEmail(String email) {
    String oldEmail = this.email;
    String newEmail = trimString(email);
    this.email = newEmail;
  }

  public String email() {
    doLoad();
    return getEmail();
  }

  public String getEmail() {
    return this.email;
  }

  public SecUser updateEmail(String email) {
    String oldEmail = this.email;
    String newEmail = trimString(email);
    if (!shouldReplaceBy(newEmail, oldEmail)) {
      return this;
    }
    this.email = newEmail;
    if (cn.hutool.core.util.ObjectUtil.equals(newEmail, oldEmail)) {
      return this;
    }
    addPropertyChange(EMAIL_PROPERTY, oldEmail, newEmail);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SecUser orderByEmail(boolean asc) {
    doAddOrderBy(EMAIL_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createEmailCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(EMAIL_PROPERTY, operator, parameters);
  }

  public SecUser ignoreEmailCriteria() {
    super.ignoreSearchProperty(EMAIL_PROPERTY);
    return this;
  }

  public SecUser addEmailCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createEmailCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeEmail(String email) {
    if (email != null) {
      updateEmail(email);
    }
  }

  public void setPwd(String pwd) {
    String oldPwd = this.pwd;
    String newPwd = trimString(pwd);
    this.pwd = newPwd;
  }

  public String pwd() {
    doLoad();
    return getPwd();
  }

  public String getPwd() {
    return this.pwd;
  }

  public SecUser updatePwd(String pwd) {
    String oldPwd = this.pwd;
    String newPwd = hashStringWithSHA256(trimString(pwd));
    if (Objects.equals(newPwd, oldPwd)) {
      return this;
    }
    this.pwd = newPwd;
    addPropertyChange(PWD_PROPERTY, oldPwd, newPwd);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SecUser orderByPwd(boolean asc) {
    doAddOrderBy(PWD_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createPwdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(PWD_PROPERTY, operator, parameters);
  }

  public SecUser ignorePwdCriteria() {
    super.ignoreSearchProperty(PWD_PROPERTY);
    return this;
  }

  public SecUser addPwdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createPwdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergePwd(String pwd) {
    if (pwd != null) {
      updatePwd(pwd);
    }
  }

  public void setClearTextOfPwd(String clearTextOfPwd) {

    String hashedPwd = hashStringWithSHA256(clearTextOfPwd);
    setPwd(hashedPwd);
  }

  public String getMaskedPwd() {

    return "**********";
  }

  public void setWeixinOpenid(String weixinOpenid) {
    String oldWeixinOpenid = this.weixinOpenid;
    String newWeixinOpenid = trimString(weixinOpenid);
    this.weixinOpenid = newWeixinOpenid;
  }

  public String weixinOpenid() {
    doLoad();
    return getWeixinOpenid();
  }

  public String getWeixinOpenid() {
    return this.weixinOpenid;
  }

  public SecUser updateWeixinOpenid(String weixinOpenid) {
    String oldWeixinOpenid = this.weixinOpenid;
    String newWeixinOpenid = trimString(weixinOpenid);
    if (!shouldReplaceBy(newWeixinOpenid, oldWeixinOpenid)) {
      return this;
    }
    this.weixinOpenid = newWeixinOpenid;
    if (cn.hutool.core.util.ObjectUtil.equals(newWeixinOpenid, oldWeixinOpenid)) {
      return this;
    }
    addPropertyChange(WEIXIN_OPENID_PROPERTY, oldWeixinOpenid, newWeixinOpenid);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SecUser orderByWeixinOpenid(boolean asc) {
    doAddOrderBy(WEIXIN_OPENID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createWeixinOpenidCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(WEIXIN_OPENID_PROPERTY, operator, parameters);
  }

  public SecUser ignoreWeixinOpenidCriteria() {
    super.ignoreSearchProperty(WEIXIN_OPENID_PROPERTY);
    return this;
  }

  public SecUser addWeixinOpenidCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createWeixinOpenidCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeWeixinOpenid(String weixinOpenid) {
    if (weixinOpenid != null) {
      updateWeixinOpenid(weixinOpenid);
    }
  }

  public void setWeixinAppid(String weixinAppid) {
    String oldWeixinAppid = this.weixinAppid;
    String newWeixinAppid = trimString(weixinAppid);
    this.weixinAppid = newWeixinAppid;
  }

  public String weixinAppid() {
    doLoad();
    return getWeixinAppid();
  }

  public String getWeixinAppid() {
    return this.weixinAppid;
  }

  public SecUser updateWeixinAppid(String weixinAppid) {
    String oldWeixinAppid = this.weixinAppid;
    String newWeixinAppid = trimString(weixinAppid);
    if (!shouldReplaceBy(newWeixinAppid, oldWeixinAppid)) {
      return this;
    }
    this.weixinAppid = newWeixinAppid;
    if (cn.hutool.core.util.ObjectUtil.equals(newWeixinAppid, oldWeixinAppid)) {
      return this;
    }
    addPropertyChange(WEIXIN_APPID_PROPERTY, oldWeixinAppid, newWeixinAppid);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SecUser orderByWeixinAppid(boolean asc) {
    doAddOrderBy(WEIXIN_APPID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createWeixinAppidCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(WEIXIN_APPID_PROPERTY, operator, parameters);
  }

  public SecUser ignoreWeixinAppidCriteria() {
    super.ignoreSearchProperty(WEIXIN_APPID_PROPERTY);
    return this;
  }

  public SecUser addWeixinAppidCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createWeixinAppidCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeWeixinAppid(String weixinAppid) {
    if (weixinAppid != null) {
      updateWeixinAppid(weixinAppid);
    }
  }

  public void setAccessToken(String accessToken) {
    String oldAccessToken = this.accessToken;
    String newAccessToken = trimString(accessToken);
    this.accessToken = newAccessToken;
  }

  public String accessToken() {
    doLoad();
    return getAccessToken();
  }

  public String getAccessToken() {
    return this.accessToken;
  }

  public SecUser updateAccessToken(String accessToken) {
    String oldAccessToken = this.accessToken;
    String newAccessToken = trimString(accessToken);
    if (!shouldReplaceBy(newAccessToken, oldAccessToken)) {
      return this;
    }
    this.accessToken = newAccessToken;
    if (cn.hutool.core.util.ObjectUtil.equals(newAccessToken, oldAccessToken)) {
      return this;
    }
    addPropertyChange(ACCESS_TOKEN_PROPERTY, oldAccessToken, newAccessToken);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SecUser orderByAccessToken(boolean asc) {
    doAddOrderBy(ACCESS_TOKEN_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createAccessTokenCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ACCESS_TOKEN_PROPERTY, operator, parameters);
  }

  public SecUser ignoreAccessTokenCriteria() {
    super.ignoreSearchProperty(ACCESS_TOKEN_PROPERTY);
    return this;
  }

  public SecUser addAccessTokenCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createAccessTokenCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeAccessToken(String accessToken) {
    if (accessToken != null) {
      updateAccessToken(accessToken);
    }
  }

  public void setVerificationCode(int verificationCode) {
    int oldVerificationCode = this.verificationCode;
    int newVerificationCode = verificationCode;
    this.verificationCode = newVerificationCode;
  }

  public int verificationCode() {
    doLoad();
    return getVerificationCode();
  }

  public int getVerificationCode() {
    return this.verificationCode;
  }

  public SecUser updateVerificationCode(int verificationCode) {
    int oldVerificationCode = this.verificationCode;
    int newVerificationCode = verificationCode;
    if (!shouldReplaceBy(newVerificationCode, oldVerificationCode)) {
      return this;
    }
    this.verificationCode = newVerificationCode;
    if (cn.hutool.core.util.ObjectUtil.equals(newVerificationCode, oldVerificationCode)) {
      return this;
    }
    addPropertyChange(VERIFICATION_CODE_PROPERTY, oldVerificationCode, newVerificationCode);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SecUser orderByVerificationCode(boolean asc) {
    doAddOrderBy(VERIFICATION_CODE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVerificationCodeCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(VERIFICATION_CODE_PROPERTY, operator, parameters);
  }

  public SecUser ignoreVerificationCodeCriteria() {
    super.ignoreSearchProperty(VERIFICATION_CODE_PROPERTY);
    return this;
  }

  public SecUser addVerificationCodeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVerificationCodeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVerificationCode(int verificationCode) {
    updateVerificationCode(verificationCode);
  }

  public void setVerificationCodeExpire(DateTime verificationCodeExpire) {
    DateTime oldVerificationCodeExpire = this.verificationCodeExpire;
    DateTime newVerificationCodeExpire = verificationCodeExpire;
    this.verificationCodeExpire = newVerificationCodeExpire;
  }

  public DateTime verificationCodeExpire() {
    doLoad();
    return getVerificationCodeExpire();
  }

  public DateTime getVerificationCodeExpire() {
    return this.verificationCodeExpire;
  }

  public SecUser updateVerificationCodeExpire(DateTime verificationCodeExpire) {
    DateTime oldVerificationCodeExpire = this.verificationCodeExpire;
    DateTime newVerificationCodeExpire = verificationCodeExpire;
    if (!shouldReplaceBy(newVerificationCodeExpire, oldVerificationCodeExpire)) {
      return this;
    }
    this.verificationCodeExpire = newVerificationCodeExpire;
    if (cn.hutool.core.util.ObjectUtil.equals(
        newVerificationCodeExpire, oldVerificationCodeExpire)) {
      return this;
    }
    addPropertyChange(
        VERIFICATION_CODE_EXPIRE_PROPERTY, oldVerificationCodeExpire, newVerificationCodeExpire);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SecUser orderByVerificationCodeExpire(boolean asc) {
    doAddOrderBy(VERIFICATION_CODE_EXPIRE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVerificationCodeExpireCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(VERIFICATION_CODE_EXPIRE_PROPERTY, operator, parameters);
  }

  public SecUser ignoreVerificationCodeExpireCriteria() {
    super.ignoreSearchProperty(VERIFICATION_CODE_EXPIRE_PROPERTY);
    return this;
  }

  public SecUser addVerificationCodeExpireCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVerificationCodeExpireCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVerificationCodeExpire(DateTime verificationCodeExpire) {
    updateVerificationCodeExpire(verificationCodeExpire);
  }

  public void setLastLoginTime(DateTime lastLoginTime) {
    DateTime oldLastLoginTime = this.lastLoginTime;
    DateTime newLastLoginTime = lastLoginTime;
    this.lastLoginTime = newLastLoginTime;
  }

  public DateTime lastLoginTime() {
    doLoad();
    return getLastLoginTime();
  }

  public DateTime getLastLoginTime() {
    return this.lastLoginTime;
  }

  public SecUser updateLastLoginTime(DateTime lastLoginTime) {
    DateTime oldLastLoginTime = this.lastLoginTime;
    DateTime newLastLoginTime = lastLoginTime;
    if (!shouldReplaceBy(newLastLoginTime, oldLastLoginTime)) {
      return this;
    }
    this.lastLoginTime = newLastLoginTime;
    if (cn.hutool.core.util.ObjectUtil.equals(newLastLoginTime, oldLastLoginTime)) {
      return this;
    }
    addPropertyChange(LAST_LOGIN_TIME_PROPERTY, oldLastLoginTime, newLastLoginTime);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SecUser orderByLastLoginTime(boolean asc) {
    doAddOrderBy(LAST_LOGIN_TIME_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createLastLoginTimeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(LAST_LOGIN_TIME_PROPERTY, operator, parameters);
  }

  public SecUser ignoreLastLoginTimeCriteria() {
    super.ignoreSearchProperty(LAST_LOGIN_TIME_PROPERTY);
    return this;
  }

  public SecUser addLastLoginTimeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createLastLoginTimeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeLastLoginTime(DateTime lastLoginTime) {
    updateLastLoginTime(lastLoginTime);
  }

  public void setDomain(UserDomain domain) {
    UserDomain oldDomain = this.domain;
    UserDomain newDomain = domain;
    this.domain = newDomain;
  }

  public UserDomain domain() {
    doLoad();
    return getDomain();
  }

  public UserDomain getDomain() {
    return this.domain;
  }

  public SecUser updateDomain(UserDomain domain) {
    UserDomain oldDomain = this.domain;
    UserDomain newDomain = domain;
    if (!shouldReplaceBy(newDomain, oldDomain)) {
      return this;
    }
    this.domain = newDomain;
    if (cn.hutool.core.util.ObjectUtil.equals(newDomain, oldDomain)) {
      return this;
    }
    addPropertyChange(DOMAIN_PROPERTY, oldDomain, newDomain);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public SecUser orderByDomain(boolean asc) {
    doAddOrderBy(DOMAIN_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createDomainCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(DOMAIN_PROPERTY, operator, parameters);
  }

  public SecUser ignoreDomainCriteria() {
    super.ignoreSearchProperty(DOMAIN_PROPERTY);
    return this;
  }

  public SecUser addDomainCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createDomainCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeDomain(UserDomain domain) {
    if (domain != null) {
      updateDomain(domain);
    }
  }

  public SecUser updateDomainByReferenceId(String domainId) {
    updateDomain(UserDomain.refById(domainId));
    return this;
  }

  public void clearDomain() {
    setDomain(null);
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

  public SecUser updateVersion(int version) {
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

  public SecUser orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public SecUser ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public SecUser addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public SmartList<UserApp> getUserAppList() {
    if (this.mUserAppList == null) {
      this.mUserAppList = new SmartList<UserApp>();
      this.mUserAppList.setListInternalName(USER_APP_LIST);
      // 有名字，便于做权限控制
    }

    return this.mUserAppList;
  }

  public SmartList<UserApp> userAppList() {

    doLoadChild(USER_APP_LIST);

    return getUserAppList();
  }

  public void setUserAppList(SmartList<UserApp> userAppList) {
    for (UserApp userApp : userAppList) {
      userApp.setSecUser(this);
    }

    this.mUserAppList = userAppList;
    this.mUserAppList.setListInternalName(USER_APP_LIST);
  }

  public SecUser addUserApp(UserApp userApp) {
    userApp.updateSecUser(this);
    getUserAppList().add(userApp);
    return this;
  }

  public SecUser addUserAppList(SmartList<UserApp> userAppList) {
    for (UserApp userApp : userAppList) {
      userApp.updateSecUser(this);
    }

    Map<String, UserApp> mapById = userAppList.mapWithId();
    getUserAppList().removeIf(item -> mapById.get(item.getId()) != null);
    getUserAppList().addAll(userAppList);
    return this;
  }

  public void mergeUserAppList(SmartList<UserApp> userAppList) {
    if (userAppList == null) {
      return;
    }
    if (userAppList.isEmpty()) {
      return;
    }
    addUserAppList(userAppList);
  }

  public UserApp removeUserApp(UserApp userAppIndex) {

    int index = getUserAppList().indexOf(userAppIndex);
    if (index < 0) {
      String message =
          "UserApp("
              + userAppIndex.getId()
              + ") with version='"
              + userAppIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    UserApp userApp = getUserAppList().get(index);
    // userApp.clearSecUser(); //disconnect with SecUser
    userApp.clearFromAll(); // disconnect with SecUser

    boolean result = getUserAppList().planToRemove(userApp);
    if (!result) {
      String message =
          "UserApp("
              + userAppIndex.getId()
              + ") with version='"
              + userAppIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return userApp;
  }
  // 断舍离
  public void breakWithUserApp(UserApp userApp) {

    if (userApp == null) {
      return;
    }
    userApp.setSecUser(null);
    // getUserAppList().remove();

  }

  public boolean hasUserApp(UserApp userApp) {

    return getUserAppList().contains(userApp);
  }

  public void copyUserAppFrom(UserApp userApp) {

    UserApp userAppInList = findTheUserApp(userApp);
    UserApp newUserApp = new UserApp();
    userAppInList.copyTo(newUserApp);
    newUserApp.setVersion(0); // will trigger copy
    getUserAppList().add(newUserApp);
    addItemToFlexiableObject(COPIED_CHILD, newUserApp);
  }

  public UserApp findTheUserApp(UserApp userApp) {

    int index = getUserAppList().indexOf(userApp);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "UserApp(" + userApp.getId() + ") with version='" + userApp.getVersion() + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getUserAppList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpUserAppList() {
    getUserAppList().clear();
  }

  public SmartList<LoginHistory> getLoginHistoryList() {
    if (this.mLoginHistoryList == null) {
      this.mLoginHistoryList = new SmartList<LoginHistory>();
      this.mLoginHistoryList.setListInternalName(LOGIN_HISTORY_LIST);
      // 有名字，便于做权限控制
    }

    return this.mLoginHistoryList;
  }

  public SmartList<LoginHistory> loginHistoryList() {

    doLoadChild(LOGIN_HISTORY_LIST);

    return getLoginHistoryList();
  }

  public void setLoginHistoryList(SmartList<LoginHistory> loginHistoryList) {
    for (LoginHistory loginHistory : loginHistoryList) {
      loginHistory.setSecUser(this);
    }

    this.mLoginHistoryList = loginHistoryList;
    this.mLoginHistoryList.setListInternalName(LOGIN_HISTORY_LIST);
  }

  public SecUser addLoginHistory(LoginHistory loginHistory) {
    loginHistory.updateSecUser(this);
    getLoginHistoryList().add(loginHistory);
    return this;
  }

  public SecUser addLoginHistoryList(SmartList<LoginHistory> loginHistoryList) {
    for (LoginHistory loginHistory : loginHistoryList) {
      loginHistory.updateSecUser(this);
    }

    Map<String, LoginHistory> mapById = loginHistoryList.mapWithId();
    getLoginHistoryList().removeIf(item -> mapById.get(item.getId()) != null);
    getLoginHistoryList().addAll(loginHistoryList);
    return this;
  }

  public void mergeLoginHistoryList(SmartList<LoginHistory> loginHistoryList) {
    if (loginHistoryList == null) {
      return;
    }
    if (loginHistoryList.isEmpty()) {
      return;
    }
    addLoginHistoryList(loginHistoryList);
  }

  public LoginHistory removeLoginHistory(LoginHistory loginHistoryIndex) {

    int index = getLoginHistoryList().indexOf(loginHistoryIndex);
    if (index < 0) {
      String message =
          "LoginHistory("
              + loginHistoryIndex.getId()
              + ") with version='"
              + loginHistoryIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    LoginHistory loginHistory = getLoginHistoryList().get(index);
    // loginHistory.clearSecUser(); //disconnect with SecUser
    loginHistory.clearFromAll(); // disconnect with SecUser

    boolean result = getLoginHistoryList().planToRemove(loginHistory);
    if (!result) {
      String message =
          "LoginHistory("
              + loginHistoryIndex.getId()
              + ") with version='"
              + loginHistoryIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return loginHistory;
  }
  // 断舍离
  public void breakWithLoginHistory(LoginHistory loginHistory) {

    if (loginHistory == null) {
      return;
    }
    loginHistory.setSecUser(null);
    // getLoginHistoryList().remove();

  }

  public boolean hasLoginHistory(LoginHistory loginHistory) {

    return getLoginHistoryList().contains(loginHistory);
  }

  public void copyLoginHistoryFrom(LoginHistory loginHistory) {

    LoginHistory loginHistoryInList = findTheLoginHistory(loginHistory);
    LoginHistory newLoginHistory = new LoginHistory();
    loginHistoryInList.copyTo(newLoginHistory);
    newLoginHistory.setVersion(0); // will trigger copy
    getLoginHistoryList().add(newLoginHistory);
    addItemToFlexiableObject(COPIED_CHILD, newLoginHistory);
  }

  public LoginHistory findTheLoginHistory(LoginHistory loginHistory) {

    int index = getLoginHistoryList().indexOf(loginHistory);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "LoginHistory("
              + loginHistory.getId()
              + ") with version='"
              + loginHistory.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getLoginHistoryList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpLoginHistoryList() {
    getLoginHistoryList().clear();
  }

  public SmartList<WechatWorkappIdentity> getWechatWorkappIdentityList() {
    if (this.mWechatWorkappIdentityList == null) {
      this.mWechatWorkappIdentityList = new SmartList<WechatWorkappIdentity>();
      this.mWechatWorkappIdentityList.setListInternalName(WECHAT_WORKAPP_IDENTITY_LIST);
      // 有名字，便于做权限控制
    }

    return this.mWechatWorkappIdentityList;
  }

  public SmartList<WechatWorkappIdentity> wechatWorkappIdentityList() {

    doLoadChild(WECHAT_WORKAPP_IDENTITY_LIST);

    return getWechatWorkappIdentityList();
  }

  public void setWechatWorkappIdentityList(
      SmartList<WechatWorkappIdentity> wechatWorkappIdentityList) {
    for (WechatWorkappIdentity wechatWorkappIdentity : wechatWorkappIdentityList) {
      wechatWorkappIdentity.setSecUser(this);
    }

    this.mWechatWorkappIdentityList = wechatWorkappIdentityList;
    this.mWechatWorkappIdentityList.setListInternalName(WECHAT_WORKAPP_IDENTITY_LIST);
  }

  public SecUser addWechatWorkappIdentity(WechatWorkappIdentity wechatWorkappIdentity) {
    wechatWorkappIdentity.updateSecUser(this);
    getWechatWorkappIdentityList().add(wechatWorkappIdentity);
    return this;
  }

  public SecUser addWechatWorkappIdentityList(
      SmartList<WechatWorkappIdentity> wechatWorkappIdentityList) {
    for (WechatWorkappIdentity wechatWorkappIdentity : wechatWorkappIdentityList) {
      wechatWorkappIdentity.updateSecUser(this);
    }

    Map<String, WechatWorkappIdentity> mapById = wechatWorkappIdentityList.mapWithId();
    getWechatWorkappIdentityList().removeIf(item -> mapById.get(item.getId()) != null);
    getWechatWorkappIdentityList().addAll(wechatWorkappIdentityList);
    return this;
  }

  public void mergeWechatWorkappIdentityList(
      SmartList<WechatWorkappIdentity> wechatWorkappIdentityList) {
    if (wechatWorkappIdentityList == null) {
      return;
    }
    if (wechatWorkappIdentityList.isEmpty()) {
      return;
    }
    addWechatWorkappIdentityList(wechatWorkappIdentityList);
  }

  public WechatWorkappIdentity removeWechatWorkappIdentity(
      WechatWorkappIdentity wechatWorkappIdentityIndex) {

    int index = getWechatWorkappIdentityList().indexOf(wechatWorkappIdentityIndex);
    if (index < 0) {
      String message =
          "WechatWorkappIdentity("
              + wechatWorkappIdentityIndex.getId()
              + ") with version='"
              + wechatWorkappIdentityIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    WechatWorkappIdentity wechatWorkappIdentity = getWechatWorkappIdentityList().get(index);
    // wechatWorkappIdentity.clearSecUser(); //disconnect with SecUser
    wechatWorkappIdentity.clearFromAll(); // disconnect with SecUser

    boolean result = getWechatWorkappIdentityList().planToRemove(wechatWorkappIdentity);
    if (!result) {
      String message =
          "WechatWorkappIdentity("
              + wechatWorkappIdentityIndex.getId()
              + ") with version='"
              + wechatWorkappIdentityIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return wechatWorkappIdentity;
  }
  // 断舍离
  public void breakWithWechatWorkappIdentity(WechatWorkappIdentity wechatWorkappIdentity) {

    if (wechatWorkappIdentity == null) {
      return;
    }
    wechatWorkappIdentity.setSecUser(null);
    // getWechatWorkappIdentityList().remove();

  }

  public boolean hasWechatWorkappIdentity(WechatWorkappIdentity wechatWorkappIdentity) {

    return getWechatWorkappIdentityList().contains(wechatWorkappIdentity);
  }

  public void copyWechatWorkappIdentityFrom(WechatWorkappIdentity wechatWorkappIdentity) {

    WechatWorkappIdentity wechatWorkappIdentityInList =
        findTheWechatWorkappIdentity(wechatWorkappIdentity);
    WechatWorkappIdentity newWechatWorkappIdentity = new WechatWorkappIdentity();
    wechatWorkappIdentityInList.copyTo(newWechatWorkappIdentity);
    newWechatWorkappIdentity.setVersion(0); // will trigger copy
    getWechatWorkappIdentityList().add(newWechatWorkappIdentity);
    addItemToFlexiableObject(COPIED_CHILD, newWechatWorkappIdentity);
  }

  public WechatWorkappIdentity findTheWechatWorkappIdentity(
      WechatWorkappIdentity wechatWorkappIdentity) {

    int index = getWechatWorkappIdentityList().indexOf(wechatWorkappIdentity);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "WechatWorkappIdentity("
              + wechatWorkappIdentity.getId()
              + ") with version='"
              + wechatWorkappIdentity.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getWechatWorkappIdentityList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpWechatWorkappIdentityList() {
    getWechatWorkappIdentityList().clear();
  }

  public SmartList<WechatMiniappIdentity> getWechatMiniappIdentityList() {
    if (this.mWechatMiniappIdentityList == null) {
      this.mWechatMiniappIdentityList = new SmartList<WechatMiniappIdentity>();
      this.mWechatMiniappIdentityList.setListInternalName(WECHAT_MINIAPP_IDENTITY_LIST);
      // 有名字，便于做权限控制
    }

    return this.mWechatMiniappIdentityList;
  }

  public SmartList<WechatMiniappIdentity> wechatMiniappIdentityList() {

    doLoadChild(WECHAT_MINIAPP_IDENTITY_LIST);

    return getWechatMiniappIdentityList();
  }

  public void setWechatMiniappIdentityList(
      SmartList<WechatMiniappIdentity> wechatMiniappIdentityList) {
    for (WechatMiniappIdentity wechatMiniappIdentity : wechatMiniappIdentityList) {
      wechatMiniappIdentity.setSecUser(this);
    }

    this.mWechatMiniappIdentityList = wechatMiniappIdentityList;
    this.mWechatMiniappIdentityList.setListInternalName(WECHAT_MINIAPP_IDENTITY_LIST);
  }

  public SecUser addWechatMiniappIdentity(WechatMiniappIdentity wechatMiniappIdentity) {
    wechatMiniappIdentity.updateSecUser(this);
    getWechatMiniappIdentityList().add(wechatMiniappIdentity);
    return this;
  }

  public SecUser addWechatMiniappIdentityList(
      SmartList<WechatMiniappIdentity> wechatMiniappIdentityList) {
    for (WechatMiniappIdentity wechatMiniappIdentity : wechatMiniappIdentityList) {
      wechatMiniappIdentity.updateSecUser(this);
    }

    Map<String, WechatMiniappIdentity> mapById = wechatMiniappIdentityList.mapWithId();
    getWechatMiniappIdentityList().removeIf(item -> mapById.get(item.getId()) != null);
    getWechatMiniappIdentityList().addAll(wechatMiniappIdentityList);
    return this;
  }

  public void mergeWechatMiniappIdentityList(
      SmartList<WechatMiniappIdentity> wechatMiniappIdentityList) {
    if (wechatMiniappIdentityList == null) {
      return;
    }
    if (wechatMiniappIdentityList.isEmpty()) {
      return;
    }
    addWechatMiniappIdentityList(wechatMiniappIdentityList);
  }

  public WechatMiniappIdentity removeWechatMiniappIdentity(
      WechatMiniappIdentity wechatMiniappIdentityIndex) {

    int index = getWechatMiniappIdentityList().indexOf(wechatMiniappIdentityIndex);
    if (index < 0) {
      String message =
          "WechatMiniappIdentity("
              + wechatMiniappIdentityIndex.getId()
              + ") with version='"
              + wechatMiniappIdentityIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    WechatMiniappIdentity wechatMiniappIdentity = getWechatMiniappIdentityList().get(index);
    // wechatMiniappIdentity.clearSecUser(); //disconnect with SecUser
    wechatMiniappIdentity.clearFromAll(); // disconnect with SecUser

    boolean result = getWechatMiniappIdentityList().planToRemove(wechatMiniappIdentity);
    if (!result) {
      String message =
          "WechatMiniappIdentity("
              + wechatMiniappIdentityIndex.getId()
              + ") with version='"
              + wechatMiniappIdentityIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return wechatMiniappIdentity;
  }
  // 断舍离
  public void breakWithWechatMiniappIdentity(WechatMiniappIdentity wechatMiniappIdentity) {

    if (wechatMiniappIdentity == null) {
      return;
    }
    wechatMiniappIdentity.setSecUser(null);
    // getWechatMiniappIdentityList().remove();

  }

  public boolean hasWechatMiniappIdentity(WechatMiniappIdentity wechatMiniappIdentity) {

    return getWechatMiniappIdentityList().contains(wechatMiniappIdentity);
  }

  public void copyWechatMiniappIdentityFrom(WechatMiniappIdentity wechatMiniappIdentity) {

    WechatMiniappIdentity wechatMiniappIdentityInList =
        findTheWechatMiniappIdentity(wechatMiniappIdentity);
    WechatMiniappIdentity newWechatMiniappIdentity = new WechatMiniappIdentity();
    wechatMiniappIdentityInList.copyTo(newWechatMiniappIdentity);
    newWechatMiniappIdentity.setVersion(0); // will trigger copy
    getWechatMiniappIdentityList().add(newWechatMiniappIdentity);
    addItemToFlexiableObject(COPIED_CHILD, newWechatMiniappIdentity);
  }

  public WechatMiniappIdentity findTheWechatMiniappIdentity(
      WechatMiniappIdentity wechatMiniappIdentity) {

    int index = getWechatMiniappIdentityList().indexOf(wechatMiniappIdentity);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "WechatMiniappIdentity("
              + wechatMiniappIdentity.getId()
              + ") with version='"
              + wechatMiniappIdentity.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getWechatMiniappIdentityList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpWechatMiniappIdentityList() {
    getWechatMiniappIdentityList().clear();
  }

  public SmartList<KeyPairIdentity> getKeyPairIdentityList() {
    if (this.mKeyPairIdentityList == null) {
      this.mKeyPairIdentityList = new SmartList<KeyPairIdentity>();
      this.mKeyPairIdentityList.setListInternalName(KEY_PAIR_IDENTITY_LIST);
      // 有名字，便于做权限控制
    }

    return this.mKeyPairIdentityList;
  }

  public SmartList<KeyPairIdentity> keyPairIdentityList() {

    doLoadChild(KEY_PAIR_IDENTITY_LIST);

    return getKeyPairIdentityList();
  }

  public void setKeyPairIdentityList(SmartList<KeyPairIdentity> keyPairIdentityList) {
    for (KeyPairIdentity keyPairIdentity : keyPairIdentityList) {
      keyPairIdentity.setSecUser(this);
    }

    this.mKeyPairIdentityList = keyPairIdentityList;
    this.mKeyPairIdentityList.setListInternalName(KEY_PAIR_IDENTITY_LIST);
  }

  public SecUser addKeyPairIdentity(KeyPairIdentity keyPairIdentity) {
    keyPairIdentity.updateSecUser(this);
    getKeyPairIdentityList().add(keyPairIdentity);
    return this;
  }

  public SecUser addKeyPairIdentityList(SmartList<KeyPairIdentity> keyPairIdentityList) {
    for (KeyPairIdentity keyPairIdentity : keyPairIdentityList) {
      keyPairIdentity.updateSecUser(this);
    }

    Map<String, KeyPairIdentity> mapById = keyPairIdentityList.mapWithId();
    getKeyPairIdentityList().removeIf(item -> mapById.get(item.getId()) != null);
    getKeyPairIdentityList().addAll(keyPairIdentityList);
    return this;
  }

  public void mergeKeyPairIdentityList(SmartList<KeyPairIdentity> keyPairIdentityList) {
    if (keyPairIdentityList == null) {
      return;
    }
    if (keyPairIdentityList.isEmpty()) {
      return;
    }
    addKeyPairIdentityList(keyPairIdentityList);
  }

  public KeyPairIdentity removeKeyPairIdentity(KeyPairIdentity keyPairIdentityIndex) {

    int index = getKeyPairIdentityList().indexOf(keyPairIdentityIndex);
    if (index < 0) {
      String message =
          "KeyPairIdentity("
              + keyPairIdentityIndex.getId()
              + ") with version='"
              + keyPairIdentityIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    KeyPairIdentity keyPairIdentity = getKeyPairIdentityList().get(index);
    // keyPairIdentity.clearSecUser(); //disconnect with SecUser
    keyPairIdentity.clearFromAll(); // disconnect with SecUser

    boolean result = getKeyPairIdentityList().planToRemove(keyPairIdentity);
    if (!result) {
      String message =
          "KeyPairIdentity("
              + keyPairIdentityIndex.getId()
              + ") with version='"
              + keyPairIdentityIndex.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }
    return keyPairIdentity;
  }
  // 断舍离
  public void breakWithKeyPairIdentity(KeyPairIdentity keyPairIdentity) {

    if (keyPairIdentity == null) {
      return;
    }
    keyPairIdentity.setSecUser(null);
    // getKeyPairIdentityList().remove();

  }

  public boolean hasKeyPairIdentity(KeyPairIdentity keyPairIdentity) {

    return getKeyPairIdentityList().contains(keyPairIdentity);
  }

  public void copyKeyPairIdentityFrom(KeyPairIdentity keyPairIdentity) {

    KeyPairIdentity keyPairIdentityInList = findTheKeyPairIdentity(keyPairIdentity);
    KeyPairIdentity newKeyPairIdentity = new KeyPairIdentity();
    keyPairIdentityInList.copyTo(newKeyPairIdentity);
    newKeyPairIdentity.setVersion(0); // will trigger copy
    getKeyPairIdentityList().add(newKeyPairIdentity);
    addItemToFlexiableObject(COPIED_CHILD, newKeyPairIdentity);
  }

  public KeyPairIdentity findTheKeyPairIdentity(KeyPairIdentity keyPairIdentity) {

    int index = getKeyPairIdentityList().indexOf(keyPairIdentity);
    // The input parameter must have the same id and version number.
    if (index < 0) {
      String message =
          "KeyPairIdentity("
              + keyPairIdentity.getId()
              + ") with version='"
              + keyPairIdentity.getVersion()
              + "' NOT found!";
      throw new IllegalStateException(message);
    }

    return getKeyPairIdentityList().get(index);
    // Performance issue when using LinkedList, but it is almost an ArrayList for sure!
  }

  public void cleanUpKeyPairIdentityList() {
    getKeyPairIdentityList().clear();
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getDomain(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();
    collectFromList(this, entityList, getUserAppList(), internalType);
    collectFromList(this, entityList, getLoginHistoryList(), internalType);
    collectFromList(this, entityList, getWechatWorkappIdentityList(), internalType);
    collectFromList(this, entityList, getWechatMiniappIdentityList(), internalType);
    collectFromList(this, entityList, getKeyPairIdentityList(), internalType);

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    listOfList.add(getUserAppList());
    listOfList.add(getLoginHistoryList());
    listOfList.add(getWechatWorkappIdentityList());
    listOfList.add(getWechatMiniappIdentityList());
    listOfList.add(getKeyPairIdentityList());

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, LOGIN_PROPERTY, getLogin());
    appendKeyValuePair(result, MOBILE_PROPERTY, getMaskedMobile());
    appendKeyValuePair(result, EMAIL_PROPERTY, getEmail());
    appendKeyValuePair(result, PWD_PROPERTY, getMaskedPwd());
    appendKeyValuePair(result, WEIXIN_OPENID_PROPERTY, getWeixinOpenid());
    appendKeyValuePair(result, WEIXIN_APPID_PROPERTY, getWeixinAppid());
    appendKeyValuePair(result, ACCESS_TOKEN_PROPERTY, getAccessToken());
    appendKeyValuePair(result, VERIFICATION_CODE_PROPERTY, getVerificationCode());
    appendKeyValuePair(result, VERIFICATION_CODE_EXPIRE_PROPERTY, getVerificationCodeExpire());
    appendKeyValuePair(result, LAST_LOGIN_TIME_PROPERTY, getLastLoginTime());
    appendKeyValuePair(result, DOMAIN_PROPERTY, getDomain());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
    appendKeyValuePair(result, USER_APP_LIST, getUserAppList());
    if (!getUserAppList().isEmpty()) {
      appendKeyValuePair(result, "userAppCount", getUserAppList().getTotalCount());
      appendKeyValuePair(
          result, "userAppCurrentPageNumber", getUserAppList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, LOGIN_HISTORY_LIST, getLoginHistoryList());
    if (!getLoginHistoryList().isEmpty()) {
      appendKeyValuePair(result, "loginHistoryCount", getLoginHistoryList().getTotalCount());
      appendKeyValuePair(
          result, "loginHistoryCurrentPageNumber", getLoginHistoryList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, WECHAT_WORKAPP_IDENTITY_LIST, getWechatWorkappIdentityList());
    if (!getWechatWorkappIdentityList().isEmpty()) {
      appendKeyValuePair(
          result, "wechatWorkappIdentityCount", getWechatWorkappIdentityList().getTotalCount());
      appendKeyValuePair(
          result,
          "wechatWorkappIdentityCurrentPageNumber",
          getWechatWorkappIdentityList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, WECHAT_MINIAPP_IDENTITY_LIST, getWechatMiniappIdentityList());
    if (!getWechatMiniappIdentityList().isEmpty()) {
      appendKeyValuePair(
          result, "wechatMiniappIdentityCount", getWechatMiniappIdentityList().getTotalCount());
      appendKeyValuePair(
          result,
          "wechatMiniappIdentityCurrentPageNumber",
          getWechatMiniappIdentityList().getCurrentPageNumber());
    }
    appendKeyValuePair(result, KEY_PAIR_IDENTITY_LIST, getKeyPairIdentityList());
    if (!getKeyPairIdentityList().isEmpty()) {
      appendKeyValuePair(result, "keyPairIdentityCount", getKeyPairIdentityList().getTotalCount());
      appendKeyValuePair(
          result,
          "keyPairIdentityCurrentPageNumber",
          getKeyPairIdentityList().getCurrentPageNumber());
    }

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof SecUser) {

      SecUser dest = (SecUser) baseDest;

      dest.setId(getId());
      dest.setLogin(getLogin());
      dest.setMobile(getMobile());
      dest.setEmail(getEmail());
      dest.setPwd(getPwd());
      dest.setWeixinOpenid(getWeixinOpenid());
      dest.setWeixinAppid(getWeixinAppid());
      dest.setAccessToken(getAccessToken());
      dest.setVerificationCode(getVerificationCode());
      dest.setVerificationCodeExpire(getVerificationCodeExpire());
      dest.setLastLoginTime(getLastLoginTime());
      dest.setDomain(getDomain());
      dest.setVersion(getVersion());
      dest.setUserAppList(getUserAppList());
      dest.setLoginHistoryList(getLoginHistoryList());
      dest.setWechatWorkappIdentityList(getWechatWorkappIdentityList());
      dest.setWechatMiniappIdentityList(getWechatMiniappIdentityList());
      dest.setKeyPairIdentityList(getKeyPairIdentityList());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof SecUser) {

      SecUser source = (SecUser) sourceEntity;

      mergeId(source.getId());
      mergeLogin(source.getLogin());
      mergeMobile(source.getMobile());
      mergeEmail(source.getEmail());
      mergePwd(source.getPwd());
      mergeWeixinOpenid(source.getWeixinOpenid());
      mergeWeixinAppid(source.getWeixinAppid());
      mergeAccessToken(source.getAccessToken());
      mergeVerificationCode(source.getVerificationCode());
      mergeVerificationCodeExpire(source.getVerificationCodeExpire());
      mergeLastLoginTime(source.getLastLoginTime());
      mergeDomain(source.getDomain());
      mergeVersion(source.getVersion());
      mergeUserAppList(source.getUserAppList());
      mergeLoginHistoryList(source.getLoginHistoryList());
      mergeWechatWorkappIdentityList(source.getWechatWorkappIdentityList());
      mergeWechatMiniappIdentityList(source.getWechatMiniappIdentityList());
      mergeKeyPairIdentityList(source.getKeyPairIdentityList());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof SecUser) {

      SecUser source = (SecUser) sourceEntity;

      mergeId(source.getId());
      mergeLogin(source.getLogin());
      mergeMobile(source.getMobile());
      mergeEmail(source.getEmail());
      mergePwd(source.getPwd());
      mergeWeixinOpenid(source.getWeixinOpenid());
      mergeWeixinAppid(source.getWeixinAppid());
      mergeAccessToken(source.getAccessToken());
      mergeVerificationCode(source.getVerificationCode());
      mergeVerificationCodeExpire(source.getVerificationCodeExpire());
      mergeLastLoginTime(source.getLastLoginTime());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getLogin(),
      getMobile(),
      getEmail(),
      getPwd(),
      getWeixinOpenid(),
      getWeixinAppid(),
      getAccessToken(),
      getVerificationCode(),
      getVerificationCodeExpire(),
      getLastLoginTime(),
      getDomain(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    SecUser checkSecUser =
        Q.secUserWithIdField()
            .filterById(id)
            .selectUserAppList(Q.userAppWithIdField().limit(0, 1))
            .selectLoginHistoryList(Q.loginHistoryWithIdField().limit(0, 1))
            .selectWechatWorkappIdentityList(Q.wechatWorkappIdentityWithIdField().limit(0, 1))
            .selectWechatMiniappIdentityList(Q.wechatMiniappIdentityWithIdField().limit(0, 1))
            .selectKeyPairIdentityList(Q.keyPairIdentityWithIdField().limit(0, 1))
            .execute(ctx);

    return checkSecUser != null
        && !checkSecUser.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public SecUser save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("SecUser{");
    stringBuilder.append("\tid='" + getId() + "';");
    stringBuilder.append("\tlogin='" + getLogin() + "';");
    stringBuilder.append("\tmobile='" + getMobile() + "';");
    stringBuilder.append("\temail='" + getEmail() + "';");
    stringBuilder.append("\tpwd='" + getPwd() + "';");
    stringBuilder.append("\tweixinOpenid='" + getWeixinOpenid() + "';");
    stringBuilder.append("\tweixinAppid='" + getWeixinAppid() + "';");
    stringBuilder.append("\taccessToken='" + getAccessToken() + "';");
    stringBuilder.append("\tverificationCode='" + getVerificationCode() + "';");
    stringBuilder.append("\tverificationCodeExpire='" + getVerificationCodeExpire() + "';");
    stringBuilder.append("\tlastLoginTime='" + getLastLoginTime() + "';");
    if (getDomain() != null) {
      stringBuilder.append("\tdomain='UserDomain(" + getDomain().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

  public void increaseVerificationCode(int incVerificationCode) {
    updateVerificationCode(this.verificationCode + incVerificationCode);
  }

  public void decreaseVerificationCode(int decVerificationCode) {
    updateVerificationCode(this.verificationCode - decVerificationCode);
  }
}
