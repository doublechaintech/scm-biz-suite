package com.doublechaintech.retailscm;

import com.terapico.caf.baseelement.CandidateQuery;

import com.terapico.caf.Password;

public interface BaseManager {

  Object queryCandidates(RetailscmUserContext userContext, CandidateQuery query) throws Exception;

  Object queryCandidatesForAssign(RetailscmUserContext userContext, CandidateQuery query)
      throws Exception;

  Object queryCandidatesForSearch(RetailscmUserContext userContext, CandidateQuery query)
      throws Exception;

  public Object view(RetailscmUserContext userContext, String id) throws Exception;
  // -----------------------------------//  登录部分处理 \\-----------------------------------
  // 手机号+短信验证码 登录
  public Object loginByMobile(RetailscmUserContext userContext, String mobile, String verifyCode)
      throws Exception;
  // 账号+密码登录
  public Object loginByPassword(RetailscmUserContext userContext, String loginId, Password password)
      throws Exception;
  // 微信小程序登录
  public Object loginByWechatMiniProgram(RetailscmUserContext userContext, String code)
      throws Exception;
  // 微信小程序获取手机号快速登录
  public Object loginByWechatMobile(
      RetailscmUserContext userContext, String code, String encryptedData, String iv)
      throws Exception;
  // 企业微信小程序登录
  public Object loginByWechatWorkMiniProgram(RetailscmUserContext userContext, String code)
      throws Exception;
  // -----------------------------------\\  登录部分处理 //-----------------------------------

}
