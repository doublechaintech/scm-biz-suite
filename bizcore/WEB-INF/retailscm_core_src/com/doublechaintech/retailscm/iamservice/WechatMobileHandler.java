package com.doublechaintech.retailscm.iamservice;

import java.util.Map;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentity;
import com.terapico.utils.*;
import com.terapico.caf.DateTime;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import com.terapico.caf.baseelement.LoginParam;
import me.chanjar.weixin.common.error.WxErrorException;

@SuppressWarnings("unchecked")
public class WechatMobileHandler extends BaseIdentificationHandler {
  protected WxMaService wxService;
  protected static String currentSessionKey;

  public WxMaService getWxService() {
    return wxService;
  }

  public void setWxService(WxMaService wxService) {
    this.wxService = wxService;
  }

  public static String getSessionKeyCacheKey(RetailscmUserContext ctx) {
    return ctx.tokenId() + "_session_key";
  }

  public Object wxlogin(RetailscmUserContext ctx, String code) throws Exception {
    WxMaJscode2SessionResult sessionInfo = wxService.jsCode2SessionInfo(code);
    String openId = sessionInfo.getOpenid();
    String userSessionKey = sessionInfo.getSessionKey();
    String unionId = sessionInfo.getUnionid();
    String cacheKey = getSessionKeyCacheKey(ctx);
    ctx.putToCache(
        cacheKey,
        MapUtil.put("openId", openId).put("unionId", unionId).put("sessionKey", userSessionKey).into_map(),
        360 * 24 * 60 * 60);
    return MapUtil.put("openid", openId).put("sessionKey", userSessionKey).into_map();
  }

  @Override
  public LoginResult authenticate(RetailscmUserContext userContext, LoginContext loginContext) {
    LoginResult result = new LoginResult();
        result.setLoginContext(loginContext);
        // 校验输入
        String code = loginContext.getLoginData().getCode();
        String encData = loginContext.getLoginData().getEncryptedData();
        String iv = loginContext.getLoginData().getIv();
        if (TextUtil.isBlank(encData) || TextUtil.isBlank(iv)) {
          result.setMessage("不能获取您的手机号");
          result.setAuthenticated(false);
          result.setNewUser(false);
          return result;
        }
        Map<String, Object> sessionInfoMap =
            userContext.getCachedObject(getSessionKeyCacheKey(userContext), Map.class);
        String openId;
        String userSessionKey;
        String unionId;
        if (sessionInfoMap != null) {
          openId = (String) sessionInfoMap.get("openId");
          userSessionKey = (String) sessionInfoMap.get("sessionKey");
           unionId = (String) sessionInfoMap.get("unionId");
        } else {
          WxMaJscode2SessionResult sessionInfo = null;
          try {
            sessionInfo = wxService.jsCode2SessionInfo(code);
          } catch (WxErrorException e) {
            e.printStackTrace();
            return result.withError("获取session失败:" + e.getMessage());
          }
          openId = sessionInfo.getOpenid();
          unionId = sessionInfo.getUnionid();
          userSessionKey = sessionInfo.getSessionKey();
        }

        WxMaPhoneNumberInfo phoneNoInfo = takeWxMaPhoneNumberInfo(encData, iv, userSessionKey);
        if (phoneNoInfo == null || phoneNoInfo.getPurePhoneNumber() == null) {
          return result.withError("获取电话号码失败");
        }

    String cleanMobile = TextUtil.formatChinaMobile(phoneNoInfo.getPurePhoneNumber());

    // 获取sec user
    MultipleAccessKey key = new MultipleAccessKey();
    key.put(SecUser.MOBILE_PROPERTY, cleanMobile);
    SmartList<SecUser> sUsers =
        userContext.getDAOGroup().getSecUserDAO().findSecUserWithKey(key, EO);
    if (sUsers == null) {
      result.setAuthenticated(true);
      result.setSuccess(false);
      result.setMessage("手机号" + cleanMobile + "未注册");
      return result;
    }

    if (sUsers.size() > 1) {
      result.setAuthenticated(false); // 虽然码对了,但是我还是不知道你是哪位
      result.setSuccess(false);
      result.setMessage("手机号" + cleanMobile + "关联了多个用户,无法确定唯一身份,请用其他方式登录或联系管理员处理账号.");
      return result;
    }

    result.getLoginContext().getLoginTarget().setSecUser(sUsers.first());
    result.setAuthenticated(true);
    result.setSuccess(true);
    loginContext.getLoginData().setMobile(cleanMobile);
    loginContext.getLoginData().setOpenId(openId);
    loginContext.getLoginData().setUnionId(unionId);
    return result.authenticated("手机号" + cleanMobile + "验证成功");
  }

  protected WxMaPhoneNumberInfo takeWxMaPhoneNumberInfo(
        String encData, String iv, String userSessionKey) {
      try {
        WxMaPhoneNumberInfo phoneNoInfo =
            wxService.getUserService().getPhoneNoInfo(userSessionKey, encData, iv);
        return phoneNoInfo;
      } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("解密用户信息失败:" + e.getMessage(), e);
      }
    }

  @Override
  public void bindWithSecUser(RetailscmUserContext userContext, LoginContext loginContext)
      throws Exception {
    SecUser secUser = loginContext.getLoginTarget().getSecUser();
    if (secUser == null) {
      throw new Exception("please call this only after secUser was found");
    }

    autoCreateWechatMiniAppIfNeeded(userContext, secUser, loginContext);

    SecUser secUserInDB = userContext.getDAOGroup().getSecUserDAO().load(secUser.getId(), EO);
    String mobile = loginContext.getLoginData().getMobile();
    String cleanMobile = TextUtil.formatChinaMobile(mobile);
    if (secUserInDB.getMobile() != null && secUserInDB.getMobile().equals(cleanMobile)) {
      return;
    }
    secUserInDB.updateMobile(cleanMobile);
    userContext
        .getManagerGroup()
        .getSecUserManager()
        .internalSaveSecUser(userContext, secUserInDB, EO);
  }

  private void autoCreateWechatMiniAppIfNeeded(RetailscmUserContext userContext, SecUser secUser, LoginContext loginContext) {
    if (secUser == null){
      return;
    }
    String openId = loginContext.getLoginData().getOpenId();
    String appId = wxService.getWxMaConfig().getAppid();
    String unionId = loginContext.getLoginData().getUnionId();
    String secUserId = secUser.getId();

    MultipleAccessKey key = new MultipleAccessKey();
    key.put(WechatMiniappIdentity.APP_ID_PROPERTY, appId);
    key.put(WechatMiniappIdentity.OPEN_ID_PROPERTY, openId);
    key.put(WechatMiniappIdentity.SEC_USER_PROPERTY,secUserId);
    SmartList<WechatMiniappIdentity> list = userContext.getDAOGroup().getWechatMiniappIdentityDAO().findWechatMiniappIdentityWithKey(key, EO);
    if (list != null && list.size() > 0){
      return;
    }
    DateTime lastLoginTime = userContext.now();
    try {
       WechatMiniappIdentity data =
                new WechatMiniappIdentity()
                    .updateAppId(appId)
                    .updateOpenId(openId)
                    .updateUnionId(unionId)
                    .updateSecUser(SecUser.refById(secUserId))
                    .updateLastLoginTime(lastLoginTime);
            userContext
                .getManagerGroup()
                .getWechatMiniappIdentityManager()
                .internalSaveWechatMiniappIdentity(userContext, data, EO);
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
}
















