package com.doublechaintech.retailscm.secuser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;

import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentity;
import com.doublechaintech.retailscm.loginhistory.LoginHistory;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.userdomain.UserDomain;
import com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentity;
import com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentity;
import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentityRequest;
import com.doublechaintech.retailscm.loginhistory.LoginHistoryRequest;
import com.doublechaintech.retailscm.userapp.UserAppRequest;
import com.doublechaintech.retailscm.userdomain.UserDomainRequest;
import com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentityRequest;
import com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentityRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.secuser.SecUser.*;

public class SecUserRequest extends BaseRequest<SecUser> {
  public static SecUserRequest newInstance() {
    return new SecUserRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public SecUserRequest resultByClass(Class<? extends SecUser> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public SecUserRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public SecUserRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "SecUser";
  }

  public SecUserRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public SecUserRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public SecUserRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public SecUserRequest select(String... names) {
    super.select(names);
    return this;
  }

  public SecUserRequest selectAll() {
    return this.selectId()
        .selectLogin()
        .selectMobile()
        .selectEmail()
        .selectPwd()
        .selectWeixinOpenid()
        .selectWeixinAppid()
        .selectAccessToken()
        .selectVerificationCode()
        .selectVerificationCodeExpire()
        .selectLastLoginTime()
        .selectDomain()
        .selectVersion();
  }

  public SecUserRequest selectAny() {
    return selectAll()
        .selectUserAppList(Q.userApp().selectSelf())
        .selectLoginHistoryList(Q.loginHistory().selectSelf())
        .selectWechatWorkappIdentityList(Q.wechatWorkappIdentity().selectSelf())
        .selectWechatMiniappIdentityList(Q.wechatMiniappIdentity().selectSelf())
        .selectKeyPairIdentityList(Q.keyPairIdentity().selectSelf());
  }

  public SecUserRequest selectSelf() {
    select(ID_PROPERTY);
    select(LOGIN_PROPERTY);
    select(MOBILE_PROPERTY);
    select(EMAIL_PROPERTY);
    select(PWD_PROPERTY);
    select(WEIXIN_OPENID_PROPERTY);
    select(WEIXIN_APPID_PROPERTY);
    select(ACCESS_TOKEN_PROPERTY);
    select(VERIFICATION_CODE_PROPERTY);
    select(VERIFICATION_CODE_EXPIRE_PROPERTY);
    select(LAST_LOGIN_TIME_PROPERTY);
    select(DOMAIN_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public SecUserRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public SecUserRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {
    VERIFICATION_CODE_EXPIRE_PROPERTY, LAST_LOGIN_TIME_PROPERTY
  };
  protected static final String[] ALL_SELF_FIELDS = {
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

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public SecUserRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public SecUserRequest comment(String comment) {
    return this;
  }

  public SecUserRequest enhance() {
    return this;
  }

  public SecUserRequest overrideClass(Class<? extends SecUser> clazz) {
    return this;
  }

  public SecUserRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public SecUserRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public SecUserRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public SecUserRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public SecUserRequest count() {
    return countId("count");
  }

  public static SecUserRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public static SecUserRequest withLogin(String... login) {
    return newInstance().filterByLogin(login).selectAll();
  }

  public static SecUserRequest withMobile(String... mobile) {
    return newInstance().filterByMobile(mobile).selectAll();
  }

  public static SecUserRequest withEmail(String... email) {
    return newInstance().filterByEmail(email).selectAll();
  }

  public SecUserRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public SecUserRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest selectId() {
    return select(ID_PROPERTY);
  }

  public SecUserRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SecUserRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SecUserRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public SecUserRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public SecUserRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public SecUserRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public SecUserRequest countId() {
    return countId("countId");
  }

  public SecUserRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public SecUserRequest maxId() {
    return maxId("maxId");
  }

  public SecUserRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public SecUserRequest minId() {
    return minId("minId");
  }

  public SecUserRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public SecUserRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public SecUserRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public SecUserRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public SecUserRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public SecUserRequest filterByLogin(String... login) {
    if (isEmptyParam(login)) {
      throw new IllegalArgumentException("filterByLogin(String... login)参数不能为空!");
    }
    return filterByLogin(QueryOperator.IN, (Object[]) login);
  }

  public SecUserRequest filterByLogin(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLoginSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest selectLogin() {
    return select(LOGIN_PROPERTY);
  }

  public SecUserRequest unselectLogin() {
    return unselect(LOGIN_PROPERTY);
  }

  public SearchCriteria getLoginSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LOGIN_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SecUserRequest orderByLogin(boolean asc) {
    addOrderBy(LOGIN_PROPERTY, asc);
    return this;
  }

  public SecUserRequest orderByLoginAscending() {
    addOrderBy(LOGIN_PROPERTY, true);
    return this;
  }

  public SecUserRequest orderByLoginDescending() {
    addOrderBy(LOGIN_PROPERTY, false);
    return this;
  }

  public SecUserRequest orderByLoginAscendingUsingGBK() {
    addOrderBy("convert(login using gbk)", true);
    return this;
  }

  public SecUserRequest orderByLoginDescendingUsingGBK() {
    addOrderBy("convert(login using gbk)", false);
    return this;
  }

  public SecUserRequest countLogin() {
    return countLogin("countLogin");
  }

  public SecUserRequest countLogin(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LOGIN_PROPERTY);
  }

  public SecUserRequest maxLogin() {
    return maxLogin("maxLogin");
  }

  public SecUserRequest maxLogin(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LOGIN_PROPERTY);
  }

  public SecUserRequest minLogin() {
    return minLogin("minLogin");
  }

  public SecUserRequest minLogin(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LOGIN_PROPERTY);
  }

  public SecUserRequest groupByLogin() {
    return groupByLogin(LOGIN_PROPERTY);
  }

  public SecUserRequest groupByLogin(String ret) {
    return groupBy(ret, LOGIN_PROPERTY);
  }

  public SecUserRequest groupByLogin(SqlFunction func) {
    return groupByLogin(LOGIN_PROPERTY, func);
  }

  public SecUserRequest groupByLogin(String ret, SqlFunction func) {
    super.groupBy(ret, func, LOGIN_PROPERTY);
    return this;
  }

  public SecUserRequest filterByMobile(String... mobile) {
    if (isEmptyParam(mobile)) {
      throw new IllegalArgumentException("filterByMobile(String... mobile)参数不能为空!");
    }
    return filterByMobile(QueryOperator.IN, (Object[]) mobile);
  }

  public SecUserRequest filterByMobile(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getMobileSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest selectMobile() {
    return select(MOBILE_PROPERTY);
  }

  public SecUserRequest unselectMobile() {
    return unselect(MOBILE_PROPERTY);
  }

  public SearchCriteria getMobileSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(MOBILE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SecUserRequest orderByMobile(boolean asc) {
    addOrderBy(MOBILE_PROPERTY, asc);
    return this;
  }

  public SecUserRequest orderByMobileAscending() {
    addOrderBy(MOBILE_PROPERTY, true);
    return this;
  }

  public SecUserRequest orderByMobileDescending() {
    addOrderBy(MOBILE_PROPERTY, false);
    return this;
  }

  public SecUserRequest orderByMobileAscendingUsingGBK() {
    addOrderBy("convert(mobile using gbk)", true);
    return this;
  }

  public SecUserRequest orderByMobileDescendingUsingGBK() {
    addOrderBy("convert(mobile using gbk)", false);
    return this;
  }

  public SecUserRequest countMobile() {
    return countMobile("countMobile");
  }

  public SecUserRequest countMobile(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, MOBILE_PROPERTY);
  }

  public SecUserRequest maxMobile() {
    return maxMobile("maxMobile");
  }

  public SecUserRequest maxMobile(String aggName) {
    return aggregate(aggName, AggFunc.MAX, MOBILE_PROPERTY);
  }

  public SecUserRequest minMobile() {
    return minMobile("minMobile");
  }

  public SecUserRequest minMobile(String aggName) {
    return aggregate(aggName, AggFunc.MIN, MOBILE_PROPERTY);
  }

  public SecUserRequest groupByMobile() {
    return groupByMobile(MOBILE_PROPERTY);
  }

  public SecUserRequest groupByMobile(String ret) {
    return groupBy(ret, MOBILE_PROPERTY);
  }

  public SecUserRequest groupByMobile(SqlFunction func) {
    return groupByMobile(MOBILE_PROPERTY, func);
  }

  public SecUserRequest groupByMobile(String ret, SqlFunction func) {
    super.groupBy(ret, func, MOBILE_PROPERTY);
    return this;
  }

  public SecUserRequest filterByEmail(String... email) {
    if (isEmptyParam(email)) {
      throw new IllegalArgumentException("filterByEmail(String... email)参数不能为空!");
    }
    return filterByEmail(QueryOperator.IN, (Object[]) email);
  }

  public SecUserRequest filterByEmail(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getEmailSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest selectEmail() {
    return select(EMAIL_PROPERTY);
  }

  public SecUserRequest unselectEmail() {
    return unselect(EMAIL_PROPERTY);
  }

  public SearchCriteria getEmailSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(EMAIL_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SecUserRequest orderByEmail(boolean asc) {
    addOrderBy(EMAIL_PROPERTY, asc);
    return this;
  }

  public SecUserRequest orderByEmailAscending() {
    addOrderBy(EMAIL_PROPERTY, true);
    return this;
  }

  public SecUserRequest orderByEmailDescending() {
    addOrderBy(EMAIL_PROPERTY, false);
    return this;
  }

  public SecUserRequest orderByEmailAscendingUsingGBK() {
    addOrderBy("convert(email using gbk)", true);
    return this;
  }

  public SecUserRequest orderByEmailDescendingUsingGBK() {
    addOrderBy("convert(email using gbk)", false);
    return this;
  }

  public SecUserRequest countEmail() {
    return countEmail("countEmail");
  }

  public SecUserRequest countEmail(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, EMAIL_PROPERTY);
  }

  public SecUserRequest maxEmail() {
    return maxEmail("maxEmail");
  }

  public SecUserRequest maxEmail(String aggName) {
    return aggregate(aggName, AggFunc.MAX, EMAIL_PROPERTY);
  }

  public SecUserRequest minEmail() {
    return minEmail("minEmail");
  }

  public SecUserRequest minEmail(String aggName) {
    return aggregate(aggName, AggFunc.MIN, EMAIL_PROPERTY);
  }

  public SecUserRequest groupByEmail() {
    return groupByEmail(EMAIL_PROPERTY);
  }

  public SecUserRequest groupByEmail(String ret) {
    return groupBy(ret, EMAIL_PROPERTY);
  }

  public SecUserRequest groupByEmail(SqlFunction func) {
    return groupByEmail(EMAIL_PROPERTY, func);
  }

  public SecUserRequest groupByEmail(String ret, SqlFunction func) {
    super.groupBy(ret, func, EMAIL_PROPERTY);
    return this;
  }

  public SecUserRequest filterByPwd(String pwd) {

    if (pwd == null) {
      return this;
    }

    return filterByPwd(QueryOperator.EQUAL, pwd);
  }

  public SecUserRequest wherePwdIsNull() {
    return where(PWD_PROPERTY, QueryOperator.IS_NULL);
  }

  public SecUserRequest wherePwdIsNotNull() {
    return where(PWD_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SecUserRequest filterByPwd(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getPwdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest selectPwd() {
    return select(PWD_PROPERTY);
  }

  public SecUserRequest unselectPwd() {
    return unselect(PWD_PROPERTY);
  }

  public SearchCriteria getPwdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(PWD_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SecUserRequest orderByPwd(boolean asc) {
    addOrderBy(PWD_PROPERTY, asc);
    return this;
  }

  public SecUserRequest orderByPwdAscending() {
    addOrderBy(PWD_PROPERTY, true);
    return this;
  }

  public SecUserRequest orderByPwdDescending() {
    addOrderBy(PWD_PROPERTY, false);
    return this;
  }

  public SecUserRequest orderByPwdAscendingUsingGBK() {
    addOrderBy("convert(pwd using gbk)", true);
    return this;
  }

  public SecUserRequest orderByPwdDescendingUsingGBK() {
    addOrderBy("convert(pwd using gbk)", false);
    return this;
  }

  public SecUserRequest countPwd() {
    return countPwd("countPwd");
  }

  public SecUserRequest countPwd(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PWD_PROPERTY);
  }

  public SecUserRequest maxPwd() {
    return maxPwd("maxPwd");
  }

  public SecUserRequest maxPwd(String aggName) {
    return aggregate(aggName, AggFunc.MAX, PWD_PROPERTY);
  }

  public SecUserRequest minPwd() {
    return minPwd("minPwd");
  }

  public SecUserRequest minPwd(String aggName) {
    return aggregate(aggName, AggFunc.MIN, PWD_PROPERTY);
  }

  public SecUserRequest groupByPwd() {
    return groupByPwd(PWD_PROPERTY);
  }

  public SecUserRequest groupByPwd(String ret) {
    return groupBy(ret, PWD_PROPERTY);
  }

  public SecUserRequest groupByPwd(SqlFunction func) {
    return groupByPwd(PWD_PROPERTY, func);
  }

  public SecUserRequest groupByPwd(String ret, SqlFunction func) {
    super.groupBy(ret, func, PWD_PROPERTY);
    return this;
  }

  public SecUserRequest filterByWeixinOpenid(String weixinOpenid) {

    if (weixinOpenid == null) {
      return this;
    }

    return filterByWeixinOpenid(QueryOperator.EQUAL, weixinOpenid);
  }

  public SecUserRequest whereWeixinOpenidIsNull() {
    return where(WEIXIN_OPENID_PROPERTY, QueryOperator.IS_NULL);
  }

  public SecUserRequest whereWeixinOpenidIsNotNull() {
    return where(WEIXIN_OPENID_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SecUserRequest filterByWeixinOpenid(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getWeixinOpenidSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest selectWeixinOpenid() {
    return select(WEIXIN_OPENID_PROPERTY);
  }

  public SecUserRequest unselectWeixinOpenid() {
    return unselect(WEIXIN_OPENID_PROPERTY);
  }

  public SearchCriteria getWeixinOpenidSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(WEIXIN_OPENID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SecUserRequest orderByWeixinOpenid(boolean asc) {
    addOrderBy(WEIXIN_OPENID_PROPERTY, asc);
    return this;
  }

  public SecUserRequest orderByWeixinOpenidAscending() {
    addOrderBy(WEIXIN_OPENID_PROPERTY, true);
    return this;
  }

  public SecUserRequest orderByWeixinOpenidDescending() {
    addOrderBy(WEIXIN_OPENID_PROPERTY, false);
    return this;
  }

  public SecUserRequest orderByWeixinOpenidAscendingUsingGBK() {
    addOrderBy("convert(weixinOpenid using gbk)", true);
    return this;
  }

  public SecUserRequest orderByWeixinOpenidDescendingUsingGBK() {
    addOrderBy("convert(weixinOpenid using gbk)", false);
    return this;
  }

  public SecUserRequest countWeixinOpenid() {
    return countWeixinOpenid("countWeixinOpenid");
  }

  public SecUserRequest countWeixinOpenid(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, WEIXIN_OPENID_PROPERTY);
  }

  public SecUserRequest maxWeixinOpenid() {
    return maxWeixinOpenid("maxWeixinOpenid");
  }

  public SecUserRequest maxWeixinOpenid(String aggName) {
    return aggregate(aggName, AggFunc.MAX, WEIXIN_OPENID_PROPERTY);
  }

  public SecUserRequest minWeixinOpenid() {
    return minWeixinOpenid("minWeixinOpenid");
  }

  public SecUserRequest minWeixinOpenid(String aggName) {
    return aggregate(aggName, AggFunc.MIN, WEIXIN_OPENID_PROPERTY);
  }

  public SecUserRequest groupByWeixinOpenid() {
    return groupByWeixinOpenid(WEIXIN_OPENID_PROPERTY);
  }

  public SecUserRequest groupByWeixinOpenid(String ret) {
    return groupBy(ret, WEIXIN_OPENID_PROPERTY);
  }

  public SecUserRequest groupByWeixinOpenid(SqlFunction func) {
    return groupByWeixinOpenid(WEIXIN_OPENID_PROPERTY, func);
  }

  public SecUserRequest groupByWeixinOpenid(String ret, SqlFunction func) {
    super.groupBy(ret, func, WEIXIN_OPENID_PROPERTY);
    return this;
  }

  public SecUserRequest filterByWeixinAppid(String weixinAppid) {

    if (weixinAppid == null) {
      return this;
    }

    return filterByWeixinAppid(QueryOperator.EQUAL, weixinAppid);
  }

  public SecUserRequest whereWeixinAppidIsNull() {
    return where(WEIXIN_APPID_PROPERTY, QueryOperator.IS_NULL);
  }

  public SecUserRequest whereWeixinAppidIsNotNull() {
    return where(WEIXIN_APPID_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SecUserRequest filterByWeixinAppid(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getWeixinAppidSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest selectWeixinAppid() {
    return select(WEIXIN_APPID_PROPERTY);
  }

  public SecUserRequest unselectWeixinAppid() {
    return unselect(WEIXIN_APPID_PROPERTY);
  }

  public SearchCriteria getWeixinAppidSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(WEIXIN_APPID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SecUserRequest orderByWeixinAppid(boolean asc) {
    addOrderBy(WEIXIN_APPID_PROPERTY, asc);
    return this;
  }

  public SecUserRequest orderByWeixinAppidAscending() {
    addOrderBy(WEIXIN_APPID_PROPERTY, true);
    return this;
  }

  public SecUserRequest orderByWeixinAppidDescending() {
    addOrderBy(WEIXIN_APPID_PROPERTY, false);
    return this;
  }

  public SecUserRequest orderByWeixinAppidAscendingUsingGBK() {
    addOrderBy("convert(weixinAppid using gbk)", true);
    return this;
  }

  public SecUserRequest orderByWeixinAppidDescendingUsingGBK() {
    addOrderBy("convert(weixinAppid using gbk)", false);
    return this;
  }

  public SecUserRequest countWeixinAppid() {
    return countWeixinAppid("countWeixinAppid");
  }

  public SecUserRequest countWeixinAppid(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, WEIXIN_APPID_PROPERTY);
  }

  public SecUserRequest maxWeixinAppid() {
    return maxWeixinAppid("maxWeixinAppid");
  }

  public SecUserRequest maxWeixinAppid(String aggName) {
    return aggregate(aggName, AggFunc.MAX, WEIXIN_APPID_PROPERTY);
  }

  public SecUserRequest minWeixinAppid() {
    return minWeixinAppid("minWeixinAppid");
  }

  public SecUserRequest minWeixinAppid(String aggName) {
    return aggregate(aggName, AggFunc.MIN, WEIXIN_APPID_PROPERTY);
  }

  public SecUserRequest groupByWeixinAppid() {
    return groupByWeixinAppid(WEIXIN_APPID_PROPERTY);
  }

  public SecUserRequest groupByWeixinAppid(String ret) {
    return groupBy(ret, WEIXIN_APPID_PROPERTY);
  }

  public SecUserRequest groupByWeixinAppid(SqlFunction func) {
    return groupByWeixinAppid(WEIXIN_APPID_PROPERTY, func);
  }

  public SecUserRequest groupByWeixinAppid(String ret, SqlFunction func) {
    super.groupBy(ret, func, WEIXIN_APPID_PROPERTY);
    return this;
  }

  public SecUserRequest filterByAccessToken(String accessToken) {

    if (accessToken == null) {
      return this;
    }

    return filterByAccessToken(QueryOperator.EQUAL, accessToken);
  }

  public SecUserRequest whereAccessTokenIsNull() {
    return where(ACCESS_TOKEN_PROPERTY, QueryOperator.IS_NULL);
  }

  public SecUserRequest whereAccessTokenIsNotNull() {
    return where(ACCESS_TOKEN_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SecUserRequest filterByAccessToken(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAccessTokenSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest selectAccessToken() {
    return select(ACCESS_TOKEN_PROPERTY);
  }

  public SecUserRequest unselectAccessToken() {
    return unselect(ACCESS_TOKEN_PROPERTY);
  }

  public SearchCriteria getAccessTokenSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ACCESS_TOKEN_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SecUserRequest orderByAccessToken(boolean asc) {
    addOrderBy(ACCESS_TOKEN_PROPERTY, asc);
    return this;
  }

  public SecUserRequest orderByAccessTokenAscending() {
    addOrderBy(ACCESS_TOKEN_PROPERTY, true);
    return this;
  }

  public SecUserRequest orderByAccessTokenDescending() {
    addOrderBy(ACCESS_TOKEN_PROPERTY, false);
    return this;
  }

  public SecUserRequest orderByAccessTokenAscendingUsingGBK() {
    addOrderBy("convert(accessToken using gbk)", true);
    return this;
  }

  public SecUserRequest orderByAccessTokenDescendingUsingGBK() {
    addOrderBy("convert(accessToken using gbk)", false);
    return this;
  }

  public SecUserRequest countAccessToken() {
    return countAccessToken("countAccessToken");
  }

  public SecUserRequest countAccessToken(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ACCESS_TOKEN_PROPERTY);
  }

  public SecUserRequest maxAccessToken() {
    return maxAccessToken("maxAccessToken");
  }

  public SecUserRequest maxAccessToken(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ACCESS_TOKEN_PROPERTY);
  }

  public SecUserRequest minAccessToken() {
    return minAccessToken("minAccessToken");
  }

  public SecUserRequest minAccessToken(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ACCESS_TOKEN_PROPERTY);
  }

  public SecUserRequest groupByAccessToken() {
    return groupByAccessToken(ACCESS_TOKEN_PROPERTY);
  }

  public SecUserRequest groupByAccessToken(String ret) {
    return groupBy(ret, ACCESS_TOKEN_PROPERTY);
  }

  public SecUserRequest groupByAccessToken(SqlFunction func) {
    return groupByAccessToken(ACCESS_TOKEN_PROPERTY, func);
  }

  public SecUserRequest groupByAccessToken(String ret, SqlFunction func) {
    super.groupBy(ret, func, ACCESS_TOKEN_PROPERTY);
    return this;
  }

  public SecUserRequest filterByVerificationCode(int verificationCode) {

    return filterByVerificationCode(QueryOperator.EQUAL, verificationCode);
  }

  public SecUserRequest whereVerificationCodeIsNull() {
    return where(VERIFICATION_CODE_PROPERTY, QueryOperator.IS_NULL);
  }

  public SecUserRequest whereVerificationCodeIsNotNull() {
    return where(VERIFICATION_CODE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SecUserRequest whereVerificationCodeBetween(
      Integer verificationCodeStart, Integer verificationCodeEnd) {
    if (ObjectUtil.isEmpty(verificationCodeStart)) {
      throw new IllegalArgumentException(
          "Method whereVerificationCodeBetween, the parameter verificationCodeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(verificationCodeEnd)) {
      throw new IllegalArgumentException(
          "Method whereVerificationCodeBetween, the parameter verificationCodeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getVerificationCodeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {verificationCodeStart, verificationCodeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest whereVerificationCodeLessThan(Integer verificationCode) {
    if (ObjectUtil.isEmpty(verificationCode)) {
      throw new IllegalArgumentException(
          "Method whereVerificationCodeLessThan, the parameter verificationCode is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getVerificationCodeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {verificationCode});
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest whereVerificationCodeGreaterThan(int verificationCode) {
    if (ObjectUtil.isEmpty(verificationCode)) {
      throw new IllegalArgumentException(
          "Method whereVerificationCodeGreaterThan, the parameter verificationCode is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getVerificationCodeSearchCriteria(
            QueryOperator.GREATER_THAN, new Object[] {verificationCode});
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest filterByVerificationCode(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVerificationCodeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest selectVerificationCode() {
    return select(VERIFICATION_CODE_PROPERTY);
  }

  public SecUserRequest unselectVerificationCode() {
    return unselect(VERIFICATION_CODE_PROPERTY);
  }

  public SearchCriteria getVerificationCodeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERIFICATION_CODE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SecUserRequest orderByVerificationCode(boolean asc) {
    addOrderBy(VERIFICATION_CODE_PROPERTY, asc);
    return this;
  }

  public SecUserRequest orderByVerificationCodeAscending() {
    addOrderBy(VERIFICATION_CODE_PROPERTY, true);
    return this;
  }

  public SecUserRequest orderByVerificationCodeDescending() {
    addOrderBy(VERIFICATION_CODE_PROPERTY, false);
    return this;
  }

  public SecUserRequest countVerificationCode() {
    return countVerificationCode("countVerificationCode");
  }

  public SecUserRequest countVerificationCode(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERIFICATION_CODE_PROPERTY);
  }

  public SecUserRequest maxVerificationCode() {
    return maxVerificationCode("maxVerificationCode");
  }

  public SecUserRequest maxVerificationCode(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERIFICATION_CODE_PROPERTY);
  }

  public SecUserRequest minVerificationCode() {
    return minVerificationCode("minVerificationCode");
  }

  public SecUserRequest minVerificationCode(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERIFICATION_CODE_PROPERTY);
  }

  public SecUserRequest sumVerificationCode() {
    return sumVerificationCode("sumVerificationCode");
  }

  public SecUserRequest sumVerificationCode(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERIFICATION_CODE_PROPERTY);
  }

  public SecUserRequest groupByVerificationCode() {
    return groupByVerificationCode(VERIFICATION_CODE_PROPERTY);
  }

  public SecUserRequest groupByVerificationCode(String ret) {
    return groupBy(ret, VERIFICATION_CODE_PROPERTY);
  }

  public SecUserRequest groupByVerificationCode(SqlFunction func) {
    return groupByVerificationCode(VERIFICATION_CODE_PROPERTY, func);
  }

  public SecUserRequest groupByVerificationCode(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERIFICATION_CODE_PROPERTY);
    return this;
  }

  public SecUserRequest filterByVerificationCodeExpire(DateTime verificationCodeExpire) {

    if (verificationCodeExpire == null) {
      return this;
    }

    return filterByVerificationCodeExpire(QueryOperator.EQUAL, verificationCodeExpire);
  }

  public SecUserRequest whereVerificationCodeExpireIsNull() {
    return where(VERIFICATION_CODE_EXPIRE_PROPERTY, QueryOperator.IS_NULL);
  }

  public SecUserRequest whereVerificationCodeExpireIsNotNull() {
    return where(VERIFICATION_CODE_EXPIRE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SecUserRequest whereVerificationCodeExpireBetween(
      Date verificationCodeExpireStart, Date verificationCodeExpireEnd) {
    if (ObjectUtil.isEmpty(verificationCodeExpireStart)) {
      throw new IllegalArgumentException(
          "Method whereVerificationCodeExpireBetween, the parameter verificationCodeExpireStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(verificationCodeExpireEnd)) {
      throw new IllegalArgumentException(
          "Method whereVerificationCodeExpireBetween, the parameter verificationCodeExpireEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getVerificationCodeExpireSearchCriteria(
            QueryOperator.BETWEEN,
            new Object[] {verificationCodeExpireStart, verificationCodeExpireEnd});
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest whereVerificationCodeExpireBefore(Date verificationCodeExpire) {

    if (ObjectUtil.isEmpty(verificationCodeExpire)) {
      throw new IllegalArgumentException(
          "Method whereVerificationCodeExpireBefore, the parameter verificationCodeExpire is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getVerificationCodeExpireSearchCriteria(
            QueryOperator.LESS_THAN, new Object[] {verificationCodeExpire});
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest whereVerificationCodeExpireAfter(DateTime verificationCodeExpire) {
    if (ObjectUtil.isEmpty(verificationCodeExpire)) {
      throw new IllegalArgumentException(
          "Method whereVerificationCodeExpireAfter, the parameter verificationCodeExpire is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getVerificationCodeExpireSearchCriteria(
            QueryOperator.GREATER_THAN, new Object[] {verificationCodeExpire});
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest filterByVerificationCodeExpire(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria =
        getVerificationCodeExpireSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest selectVerificationCodeExpire() {
    return select(VERIFICATION_CODE_EXPIRE_PROPERTY);
  }

  public SecUserRequest unselectVerificationCodeExpire() {
    return unselect(VERIFICATION_CODE_EXPIRE_PROPERTY);
  }

  public SearchCriteria getVerificationCodeExpireSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(
        VERIFICATION_CODE_EXPIRE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SecUserRequest orderByVerificationCodeExpire(boolean asc) {
    addOrderBy(VERIFICATION_CODE_EXPIRE_PROPERTY, asc);
    return this;
  }

  public SecUserRequest orderByVerificationCodeExpireAscending() {
    addOrderBy(VERIFICATION_CODE_EXPIRE_PROPERTY, true);
    return this;
  }

  public SecUserRequest orderByVerificationCodeExpireDescending() {
    addOrderBy(VERIFICATION_CODE_EXPIRE_PROPERTY, false);
    return this;
  }

  public SecUserRequest countVerificationCodeExpire() {
    return countVerificationCodeExpire("countVerificationCodeExpire");
  }

  public SecUserRequest countVerificationCodeExpire(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERIFICATION_CODE_EXPIRE_PROPERTY);
  }

  public SecUserRequest maxVerificationCodeExpire() {
    return maxVerificationCodeExpire("maxVerificationCodeExpire");
  }

  public SecUserRequest maxVerificationCodeExpire(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERIFICATION_CODE_EXPIRE_PROPERTY);
  }

  public SecUserRequest minVerificationCodeExpire() {
    return minVerificationCodeExpire("minVerificationCodeExpire");
  }

  public SecUserRequest minVerificationCodeExpire(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERIFICATION_CODE_EXPIRE_PROPERTY);
  }

  public SecUserRequest groupByVerificationCodeExpire() {
    return groupByVerificationCodeExpire(VERIFICATION_CODE_EXPIRE_PROPERTY);
  }

  public SecUserRequest groupByVerificationCodeExpire(String ret) {
    return groupBy(ret, VERIFICATION_CODE_EXPIRE_PROPERTY);
  }

  public SecUserRequest groupByVerificationCodeExpire(SqlFunction func) {
    return groupByVerificationCodeExpire(VERIFICATION_CODE_EXPIRE_PROPERTY, func);
  }

  public SecUserRequest groupByVerificationCodeExpire(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERIFICATION_CODE_EXPIRE_PROPERTY);
    return this;
  }

  public SecUserRequest filterByLastLoginTime(DateTime lastLoginTime) {

    if (lastLoginTime == null) {
      return this;
    }

    return filterByLastLoginTime(QueryOperator.EQUAL, lastLoginTime);
  }

  public SecUserRequest whereLastLoginTimeIsNull() {
    return where(LAST_LOGIN_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public SecUserRequest whereLastLoginTimeIsNotNull() {
    return where(LAST_LOGIN_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SecUserRequest whereLastLoginTimeBetween(Date lastLoginTimeStart, Date lastLoginTimeEnd) {
    if (ObjectUtil.isEmpty(lastLoginTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereLastLoginTimeBetween, the parameter lastLoginTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(lastLoginTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereLastLoginTimeBetween, the parameter lastLoginTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastLoginTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {lastLoginTimeStart, lastLoginTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest whereLastLoginTimeBefore(Date lastLoginTime) {

    if (ObjectUtil.isEmpty(lastLoginTime)) {
      throw new IllegalArgumentException(
          "Method whereLastLoginTimeBefore, the parameter lastLoginTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastLoginTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastLoginTime});
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest whereLastLoginTimeAfter(DateTime lastLoginTime) {
    if (ObjectUtil.isEmpty(lastLoginTime)) {
      throw new IllegalArgumentException(
          "Method whereLastLoginTimeAfter, the parameter lastLoginTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastLoginTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastLoginTime});
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest filterByLastLoginTime(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastLoginTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest selectLastLoginTime() {
    return select(LAST_LOGIN_TIME_PROPERTY);
  }

  public SecUserRequest unselectLastLoginTime() {
    return unselect(LAST_LOGIN_TIME_PROPERTY);
  }

  public SearchCriteria getLastLoginTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_LOGIN_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SecUserRequest orderByLastLoginTime(boolean asc) {
    addOrderBy(LAST_LOGIN_TIME_PROPERTY, asc);
    return this;
  }

  public SecUserRequest orderByLastLoginTimeAscending() {
    addOrderBy(LAST_LOGIN_TIME_PROPERTY, true);
    return this;
  }

  public SecUserRequest orderByLastLoginTimeDescending() {
    addOrderBy(LAST_LOGIN_TIME_PROPERTY, false);
    return this;
  }

  public SecUserRequest countLastLoginTime() {
    return countLastLoginTime("countLastLoginTime");
  }

  public SecUserRequest countLastLoginTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_LOGIN_TIME_PROPERTY);
  }

  public SecUserRequest maxLastLoginTime() {
    return maxLastLoginTime("maxLastLoginTime");
  }

  public SecUserRequest maxLastLoginTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_LOGIN_TIME_PROPERTY);
  }

  public SecUserRequest minLastLoginTime() {
    return minLastLoginTime("minLastLoginTime");
  }

  public SecUserRequest minLastLoginTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_LOGIN_TIME_PROPERTY);
  }

  public SecUserRequest groupByLastLoginTime() {
    return groupByLastLoginTime(LAST_LOGIN_TIME_PROPERTY);
  }

  public SecUserRequest groupByLastLoginTime(String ret) {
    return groupBy(ret, LAST_LOGIN_TIME_PROPERTY);
  }

  public SecUserRequest groupByLastLoginTime(SqlFunction func) {
    return groupByLastLoginTime(LAST_LOGIN_TIME_PROPERTY, func);
  }

  public SecUserRequest groupByLastLoginTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_LOGIN_TIME_PROPERTY);
    return this;
  }

  public SecUserRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public SecUserRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public SecUserRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SecUserRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SecUserRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public SecUserRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SecUserRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SecUserRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public SecUserRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public SecUserRequest countVersion() {
    return countVersion("countVersion");
  }

  public SecUserRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public SecUserRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public SecUserRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public SecUserRequest minVersion() {
    return minVersion("minVersion");
  }

  public SecUserRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public SecUserRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public SecUserRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public SecUserRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public SecUserRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public SecUserRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public SecUserRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public SecUserRequest filterByDomain(UserDomainRequest domain) {
    return filterByDomain(domain, UserDomain::getId);
  }

  public SecUserRequest filterByDomain(UserDomain... domain) {
    if (isEmptyParam(domain)) {
      throw new IllegalArgumentException("filterByDomain(UserDomain... domain)参数不能为空!");
    }
    return where(DOMAIN_PROPERTY, QueryOperator.IN, (Object[]) domain);
  }

  public SecUserRequest selectDomainId() {
    select(DOMAIN_PROPERTY);
    return this;
  }

  public UserDomainRequest upToDomain() {
    return upToDomain(UserDomainRequest.newInstance());
  }

  public UserDomainRequest upToDomain(UserDomainRequest domain) {
    domain.aggregateChild(DOMAIN_PROPERTY, this);
    this.groupByDomain(domain);
    return domain;
  }

  public UserDomainRequest endAtDomain(String retName) {
    return endAtDomain(retName, UserDomainRequest.newInstance());
  }

  public UserDomainRequest endAtDomain(String retName, UserDomainRequest domain) {
    domain.addDynamicProperty(retName, this, DOMAIN_PROPERTY);
    return domain;
  }

  public SecUserRequest filterByDomain(String... domain) {
    if (isEmptyParam(domain)) {
      throw new IllegalArgumentException("filterByDomain(String... domain)参数不能为空!");
    }
    return where(DOMAIN_PROPERTY, QueryOperator.IN, (Object[]) domain);
  }

  public SecUserRequest filterByDomain(UserDomainRequest domain, IDRefine<UserDomain> idRefine) {
    domain.unlimited();
    return addSearchCriteria(createDomainCriteria(domain, idRefine));
  }

  public SearchCriteria createDomainCriteria(
      UserDomainRequest domain, IDRefine<UserDomain> idRefine) {
    return new RefinedIdInCriteria(domain, DOMAIN_PROPERTY, idRefine, UserDomain.ID_PROPERTY);
  }

  public SecUserRequest selectDomain() {
    return selectDomain(UserDomainRequest.newInstance().selectSelf());
  }

  public SecUserRequest selectDomain(UserDomainRequest domain) {
    selectParent(DOMAIN_PROPERTY, domain);
    return this;
  }

  public SecUserRequest unselectDomain() {
    unselectParent(DOMAIN_PROPERTY);
    return this;
  }

  public SecUserRequest groupByDomain(UserDomainRequest domain) {
    groupBy(DOMAIN_PROPERTY, domain);
    return this;
  }

  public SecUserRequest aggregateDomain(UserDomainRequest domain) {
    aggregateParent(DOMAIN_PROPERTY, domain);
    return this;
  }

  public SecUserRequest countDomain() {
    return countDomain("countDomain");
  }

  public SecUserRequest countDomain(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DOMAIN_PROPERTY);
  }

  public SecUserRequest groupByDomain() {
    return groupByDomain(DOMAIN_PROPERTY);
  }

  public SecUserRequest groupByDomain(String ret) {
    return groupBy(ret, DOMAIN_PROPERTY);
  }

  public SecUserRequest whereDomainIsNull() {
    return where(DOMAIN_PROPERTY, QueryOperator.IS_NULL);
  }

  public SecUserRequest whereDomainIsNotNull() {
    return where(DOMAIN_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SecUserRequest hasUserApp() {
    return hasUserApp(UserAppRequest.newInstance());
  }

  public SecUserRequest hasUserApp(UserApp... userApp) {
    if (isEmptyParam(userApp)) {
      throw new IllegalArgumentException("hasUserApp(UserApp... userApp)参数不能为空!");
    }
    return hasUserApp(
        Q.userApp()
            .select(UserApp.SEC_USER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) userApp));
  }

  public SecUserRequest hasUserApp(String... userApp) {
    return hasUserApp(Q.userApp().select(UserApp.SEC_USER_PROPERTY).filterById(userApp));
  }

  public SecUserRequest hasUserApp(UserAppRequest userApp) {
    return hasUserApp(
        userApp,
        $userApp ->
            java.util.Optional.of($userApp)
                .map(UserApp::getSecUser)
                .map(SecUser::getId)
                .orElse(null));
  }

  public SecUserRequest hasUserApp(UserAppRequest userApp, IDRefine<UserApp> idRefine) {
    userApp.select(UserApp.SEC_USER_PROPERTY);
    userApp.unlimited();
    return addSearchCriteria(createUserAppCriteria(userApp, idRefine));
  }

  public SecUserRequest hasUserApp(
      UserAppRequest userApp, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(userApp, UserApp.SEC_USER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createUserAppCriteria(UserAppRequest userApp, IDRefine<UserApp> idRefine) {
    return new RefinedIdInCriteria(userApp, ID_PROPERTY, idRefine, UserApp.SEC_USER_PROPERTY);
  }

  public SecUserRequest selectUserAppList(UserAppRequest userApp) {
    selectChild(UserApp.SEC_USER_PROPERTY, userApp);
    return this;
  }

  public SecUserRequest selectUserAppList() {
    return selectUserAppList(UserAppRequest.newInstance().selectAll());
  }

  public SecUserRequest unselectUserAppList() {
    unselectChild(UserApp.SEC_USER_PROPERTY, UserApp.class);
    return this;
  }

  public SecUserRequest hasLoginHistory() {
    return hasLoginHistory(LoginHistoryRequest.newInstance());
  }

  public SecUserRequest hasLoginHistory(LoginHistory... loginHistory) {
    if (isEmptyParam(loginHistory)) {
      throw new IllegalArgumentException("hasLoginHistory(LoginHistory... loginHistory)参数不能为空!");
    }
    return hasLoginHistory(
        Q.loginHistory()
            .select(LoginHistory.SEC_USER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) loginHistory));
  }

  public SecUserRequest hasLoginHistory(String... loginHistory) {
    return hasLoginHistory(
        Q.loginHistory().select(LoginHistory.SEC_USER_PROPERTY).filterById(loginHistory));
  }

  public SecUserRequest hasLoginHistory(LoginHistoryRequest loginHistory) {
    return hasLoginHistory(
        loginHistory,
        $loginHistory ->
            java.util.Optional.of($loginHistory)
                .map(LoginHistory::getSecUser)
                .map(SecUser::getId)
                .orElse(null));
  }

  public SecUserRequest hasLoginHistory(
      LoginHistoryRequest loginHistory, IDRefine<LoginHistory> idRefine) {
    loginHistory.select(LoginHistory.SEC_USER_PROPERTY);
    loginHistory.unlimited();
    return addSearchCriteria(createLoginHistoryCriteria(loginHistory, idRefine));
  }

  public SecUserRequest hasLoginHistory(
      LoginHistoryRequest loginHistory, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            loginHistory, LoginHistory.SEC_USER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createLoginHistoryCriteria(
      LoginHistoryRequest loginHistory, IDRefine<LoginHistory> idRefine) {
    return new RefinedIdInCriteria(
        loginHistory, ID_PROPERTY, idRefine, LoginHistory.SEC_USER_PROPERTY);
  }

  public SecUserRequest selectLoginHistoryList(LoginHistoryRequest loginHistory) {
    selectChild(LoginHistory.SEC_USER_PROPERTY, loginHistory);
    return this;
  }

  public SecUserRequest selectLoginHistoryList() {
    return selectLoginHistoryList(LoginHistoryRequest.newInstance().selectAll());
  }

  public SecUserRequest unselectLoginHistoryList() {
    unselectChild(LoginHistory.SEC_USER_PROPERTY, LoginHistory.class);
    return this;
  }

  public SecUserRequest hasWechatWorkappIdentity() {
    return hasWechatWorkappIdentity(WechatWorkappIdentityRequest.newInstance());
  }

  public SecUserRequest hasWechatWorkappIdentity(WechatWorkappIdentity... wechatWorkappIdentity) {
    if (isEmptyParam(wechatWorkappIdentity)) {
      throw new IllegalArgumentException(
          "hasWechatWorkappIdentity(WechatWorkappIdentity... wechatWorkappIdentity)参数不能为空!");
    }
    return hasWechatWorkappIdentity(
        Q.wechatWorkappIdentity()
            .select(WechatWorkappIdentity.SEC_USER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) wechatWorkappIdentity));
  }

  public SecUserRequest hasWechatWorkappIdentity(String... wechatWorkappIdentity) {
    return hasWechatWorkappIdentity(
        Q.wechatWorkappIdentity()
            .select(WechatWorkappIdentity.SEC_USER_PROPERTY)
            .filterById(wechatWorkappIdentity));
  }

  public SecUserRequest hasWechatWorkappIdentity(
      WechatWorkappIdentityRequest wechatWorkappIdentity) {
    return hasWechatWorkappIdentity(
        wechatWorkappIdentity,
        $wechatWorkappIdentity ->
            java.util.Optional.of($wechatWorkappIdentity)
                .map(WechatWorkappIdentity::getSecUser)
                .map(SecUser::getId)
                .orElse(null));
  }

  public SecUserRequest hasWechatWorkappIdentity(
      WechatWorkappIdentityRequest wechatWorkappIdentity,
      IDRefine<WechatWorkappIdentity> idRefine) {
    wechatWorkappIdentity.select(WechatWorkappIdentity.SEC_USER_PROPERTY);
    wechatWorkappIdentity.unlimited();
    return addSearchCriteria(createWechatWorkappIdentityCriteria(wechatWorkappIdentity, idRefine));
  }

  public SecUserRequest hasWechatWorkappIdentity(
      WechatWorkappIdentityRequest wechatWorkappIdentity,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            wechatWorkappIdentity, WechatWorkappIdentity.SEC_USER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createWechatWorkappIdentityCriteria(
      WechatWorkappIdentityRequest wechatWorkappIdentity,
      IDRefine<WechatWorkappIdentity> idRefine) {
    return new RefinedIdInCriteria(
        wechatWorkappIdentity, ID_PROPERTY, idRefine, WechatWorkappIdentity.SEC_USER_PROPERTY);
  }

  public SecUserRequest selectWechatWorkappIdentityList(
      WechatWorkappIdentityRequest wechatWorkappIdentity) {
    selectChild(WechatWorkappIdentity.SEC_USER_PROPERTY, wechatWorkappIdentity);
    return this;
  }

  public SecUserRequest selectWechatWorkappIdentityList() {
    return selectWechatWorkappIdentityList(WechatWorkappIdentityRequest.newInstance().selectAll());
  }

  public SecUserRequest unselectWechatWorkappIdentityList() {
    unselectChild(WechatWorkappIdentity.SEC_USER_PROPERTY, WechatWorkappIdentity.class);
    return this;
  }

  public SecUserRequest hasWechatMiniappIdentity() {
    return hasWechatMiniappIdentity(WechatMiniappIdentityRequest.newInstance());
  }

  public SecUserRequest hasWechatMiniappIdentity(WechatMiniappIdentity... wechatMiniappIdentity) {
    if (isEmptyParam(wechatMiniappIdentity)) {
      throw new IllegalArgumentException(
          "hasWechatMiniappIdentity(WechatMiniappIdentity... wechatMiniappIdentity)参数不能为空!");
    }
    return hasWechatMiniappIdentity(
        Q.wechatMiniappIdentity()
            .select(WechatMiniappIdentity.SEC_USER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) wechatMiniappIdentity));
  }

  public SecUserRequest hasWechatMiniappIdentity(String... wechatMiniappIdentity) {
    return hasWechatMiniappIdentity(
        Q.wechatMiniappIdentity()
            .select(WechatMiniappIdentity.SEC_USER_PROPERTY)
            .filterById(wechatMiniappIdentity));
  }

  public SecUserRequest hasWechatMiniappIdentity(
      WechatMiniappIdentityRequest wechatMiniappIdentity) {
    return hasWechatMiniappIdentity(
        wechatMiniappIdentity,
        $wechatMiniappIdentity ->
            java.util.Optional.of($wechatMiniappIdentity)
                .map(WechatMiniappIdentity::getSecUser)
                .map(SecUser::getId)
                .orElse(null));
  }

  public SecUserRequest hasWechatMiniappIdentity(
      WechatMiniappIdentityRequest wechatMiniappIdentity,
      IDRefine<WechatMiniappIdentity> idRefine) {
    wechatMiniappIdentity.select(WechatMiniappIdentity.SEC_USER_PROPERTY);
    wechatMiniappIdentity.unlimited();
    return addSearchCriteria(createWechatMiniappIdentityCriteria(wechatMiniappIdentity, idRefine));
  }

  public SecUserRequest hasWechatMiniappIdentity(
      WechatMiniappIdentityRequest wechatMiniappIdentity,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            wechatMiniappIdentity, WechatMiniappIdentity.SEC_USER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createWechatMiniappIdentityCriteria(
      WechatMiniappIdentityRequest wechatMiniappIdentity,
      IDRefine<WechatMiniappIdentity> idRefine) {
    return new RefinedIdInCriteria(
        wechatMiniappIdentity, ID_PROPERTY, idRefine, WechatMiniappIdentity.SEC_USER_PROPERTY);
  }

  public SecUserRequest selectWechatMiniappIdentityList(
      WechatMiniappIdentityRequest wechatMiniappIdentity) {
    selectChild(WechatMiniappIdentity.SEC_USER_PROPERTY, wechatMiniappIdentity);
    return this;
  }

  public SecUserRequest selectWechatMiniappIdentityList() {
    return selectWechatMiniappIdentityList(WechatMiniappIdentityRequest.newInstance().selectAll());
  }

  public SecUserRequest unselectWechatMiniappIdentityList() {
    unselectChild(WechatMiniappIdentity.SEC_USER_PROPERTY, WechatMiniappIdentity.class);
    return this;
  }

  public SecUserRequest hasKeyPairIdentity() {
    return hasKeyPairIdentity(KeyPairIdentityRequest.newInstance());
  }

  public SecUserRequest hasKeyPairIdentity(KeyPairIdentity... keyPairIdentity) {
    if (isEmptyParam(keyPairIdentity)) {
      throw new IllegalArgumentException(
          "hasKeyPairIdentity(KeyPairIdentity... keyPairIdentity)参数不能为空!");
    }
    return hasKeyPairIdentity(
        Q.keyPairIdentity()
            .select(KeyPairIdentity.SEC_USER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) keyPairIdentity));
  }

  public SecUserRequest hasKeyPairIdentity(String... keyPairIdentity) {
    return hasKeyPairIdentity(
        Q.keyPairIdentity().select(KeyPairIdentity.SEC_USER_PROPERTY).filterById(keyPairIdentity));
  }

  public SecUserRequest hasKeyPairIdentity(KeyPairIdentityRequest keyPairIdentity) {
    return hasKeyPairIdentity(
        keyPairIdentity,
        $keyPairIdentity ->
            java.util.Optional.of($keyPairIdentity)
                .map(KeyPairIdentity::getSecUser)
                .map(SecUser::getId)
                .orElse(null));
  }

  public SecUserRequest hasKeyPairIdentity(
      KeyPairIdentityRequest keyPairIdentity, IDRefine<KeyPairIdentity> idRefine) {
    keyPairIdentity.select(KeyPairIdentity.SEC_USER_PROPERTY);
    keyPairIdentity.unlimited();
    return addSearchCriteria(createKeyPairIdentityCriteria(keyPairIdentity, idRefine));
  }

  public SecUserRequest hasKeyPairIdentity(
      KeyPairIdentityRequest keyPairIdentity, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            keyPairIdentity, KeyPairIdentity.SEC_USER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createKeyPairIdentityCriteria(
      KeyPairIdentityRequest keyPairIdentity, IDRefine<KeyPairIdentity> idRefine) {
    return new RefinedIdInCriteria(
        keyPairIdentity, ID_PROPERTY, idRefine, KeyPairIdentity.SEC_USER_PROPERTY);
  }

  public SecUserRequest selectKeyPairIdentityList(KeyPairIdentityRequest keyPairIdentity) {
    selectChild(KeyPairIdentity.SEC_USER_PROPERTY, keyPairIdentity);
    return this;
  }

  public SecUserRequest selectKeyPairIdentityList() {
    return selectKeyPairIdentityList(KeyPairIdentityRequest.newInstance().selectAll());
  }

  public SecUserRequest unselectKeyPairIdentityList() {
    unselectChild(KeyPairIdentity.SEC_USER_PROPERTY, KeyPairIdentity.class);
    return this;
  }

  public SecUserRequest aggregateUserAppList(UserAppRequest userApp) {
    aggregateChild(UserApp.SEC_USER_PROPERTY, userApp);
    return this;
  }

  public SecUserRequest countUserApp() {
    return countUserApp("userAppCount");
  }

  public SecUserRequest countUserApp(String retName) {
    return countUserApp(retName, UserAppRequest.newInstance());
  }

  public SecUserRequest countUserApp(UserAppRequest userApp) {
    return countUserApp("userAppCount", userApp);
  }

  public SecUserRequest countUserApp(String retName, UserAppRequest userApp) {
    userApp.count();
    return statsFromUserApp(retName, userApp);
  }

  public SecUserRequest statsFromUserApp(String retName, UserAppRequest userApp) {
    return addDynamicProperty(retName, userApp, UserApp.SEC_USER_PROPERTY);
  }

  public SecUserRequest aggregateLoginHistoryList(LoginHistoryRequest loginHistory) {
    aggregateChild(LoginHistory.SEC_USER_PROPERTY, loginHistory);
    return this;
  }

  public SecUserRequest countLoginHistory() {
    return countLoginHistory("loginHistoryCount");
  }

  public SecUserRequest countLoginHistory(String retName) {
    return countLoginHistory(retName, LoginHistoryRequest.newInstance());
  }

  public SecUserRequest countLoginHistory(LoginHistoryRequest loginHistory) {
    return countLoginHistory("loginHistoryCount", loginHistory);
  }

  public SecUserRequest countLoginHistory(String retName, LoginHistoryRequest loginHistory) {
    loginHistory.count();
    return statsFromLoginHistory(retName, loginHistory);
  }

  public SecUserRequest statsFromLoginHistory(String retName, LoginHistoryRequest loginHistory) {
    return addDynamicProperty(retName, loginHistory, LoginHistory.SEC_USER_PROPERTY);
  }

  public SecUserRequest aggregateWechatWorkappIdentityList(
      WechatWorkappIdentityRequest wechatWorkappIdentity) {
    aggregateChild(WechatWorkappIdentity.SEC_USER_PROPERTY, wechatWorkappIdentity);
    return this;
  }

  public SecUserRequest countWechatWorkappIdentity() {
    return countWechatWorkappIdentity("wechatWorkappIdentityCount");
  }

  public SecUserRequest countWechatWorkappIdentity(String retName) {
    return countWechatWorkappIdentity(retName, WechatWorkappIdentityRequest.newInstance());
  }

  public SecUserRequest countWechatWorkappIdentity(
      WechatWorkappIdentityRequest wechatWorkappIdentity) {
    return countWechatWorkappIdentity("wechatWorkappIdentityCount", wechatWorkappIdentity);
  }

  public SecUserRequest countWechatWorkappIdentity(
      String retName, WechatWorkappIdentityRequest wechatWorkappIdentity) {
    wechatWorkappIdentity.count();
    return statsFromWechatWorkappIdentity(retName, wechatWorkappIdentity);
  }

  public SecUserRequest statsFromWechatWorkappIdentity(
      String retName, WechatWorkappIdentityRequest wechatWorkappIdentity) {
    return addDynamicProperty(
        retName, wechatWorkappIdentity, WechatWorkappIdentity.SEC_USER_PROPERTY);
  }

  public SecUserRequest aggregateWechatMiniappIdentityList(
      WechatMiniappIdentityRequest wechatMiniappIdentity) {
    aggregateChild(WechatMiniappIdentity.SEC_USER_PROPERTY, wechatMiniappIdentity);
    return this;
  }

  public SecUserRequest countWechatMiniappIdentity() {
    return countWechatMiniappIdentity("wechatMiniappIdentityCount");
  }

  public SecUserRequest countWechatMiniappIdentity(String retName) {
    return countWechatMiniappIdentity(retName, WechatMiniappIdentityRequest.newInstance());
  }

  public SecUserRequest countWechatMiniappIdentity(
      WechatMiniappIdentityRequest wechatMiniappIdentity) {
    return countWechatMiniappIdentity("wechatMiniappIdentityCount", wechatMiniappIdentity);
  }

  public SecUserRequest countWechatMiniappIdentity(
      String retName, WechatMiniappIdentityRequest wechatMiniappIdentity) {
    wechatMiniappIdentity.count();
    return statsFromWechatMiniappIdentity(retName, wechatMiniappIdentity);
  }

  public SecUserRequest statsFromWechatMiniappIdentity(
      String retName, WechatMiniappIdentityRequest wechatMiniappIdentity) {
    return addDynamicProperty(
        retName, wechatMiniappIdentity, WechatMiniappIdentity.SEC_USER_PROPERTY);
  }

  public SecUserRequest aggregateKeyPairIdentityList(KeyPairIdentityRequest keyPairIdentity) {
    aggregateChild(KeyPairIdentity.SEC_USER_PROPERTY, keyPairIdentity);
    return this;
  }

  public SecUserRequest countKeyPairIdentity() {
    return countKeyPairIdentity("keyPairIdentityCount");
  }

  public SecUserRequest countKeyPairIdentity(String retName) {
    return countKeyPairIdentity(retName, KeyPairIdentityRequest.newInstance());
  }

  public SecUserRequest countKeyPairIdentity(KeyPairIdentityRequest keyPairIdentity) {
    return countKeyPairIdentity("keyPairIdentityCount", keyPairIdentity);
  }

  public SecUserRequest countKeyPairIdentity(
      String retName, KeyPairIdentityRequest keyPairIdentity) {
    keyPairIdentity.count();
    return statsFromKeyPairIdentity(retName, keyPairIdentity);
  }

  public SecUserRequest statsFromKeyPairIdentity(
      String retName, KeyPairIdentityRequest keyPairIdentity) {
    return addDynamicProperty(retName, keyPairIdentity, KeyPairIdentity.SEC_USER_PROPERTY);
  }

  public SecUserRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public SecUserRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public SecUserRequest unlimited() {
    super.unlimited();
    return this;
  }

  public SecUserRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
