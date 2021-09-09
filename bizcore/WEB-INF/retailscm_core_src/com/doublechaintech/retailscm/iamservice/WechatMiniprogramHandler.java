package com.doublechaintech.retailscm.iamservice;

import java.util.Map;

import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentity;
import com.terapico.utils.*;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.terapico.caf.baseelement.LoginParam;

@SuppressWarnings("unchecked")
public class WechatMiniprogramHandler extends BaseIdentificationHandler {

	protected WxMaService wxService;

	public WxMaService getWxService() {
		return wxService;
	}
	public void setWxService(WxMaService wxService) {
		this.wxService = wxService;
	}

	@Override
	public LoginResult authenticate(RetailscmUserContext userContext, LoginContext loginContext) {
		LoginResult result = new LoginResult();
		result.setLoginContext(loginContext);
		// 校验输入
		String code = loginContext.getLoginData().getCode();
		if (TextUtil.isBlank(code)) {
			return result.withError("请先通过微信小程序获取用户code,再进行登录");
		}
		// 进行认证
		try {
			if(!authenticateWithCode(userContext, code, result)) {
				return result.withError(result.getMessage());
			}
			Map<String, String> additionalInfo = (Map<String, String>) result.getLoginContext().getLoginTarget().getAdditionalInfo();
			String openId = additionalInfo.get("openId");
			SmartList<WechatMiniappIdentity> rcdList = getIdentifyRecords(userContext, result.getLoginContext());
			if (rcdList == null || rcdList.isEmpty()) {
				result.setAuthenticated(true);
				result.setSuccess(false);
				result.setMessage("微信用户"+openId+"未注册");
				return result;
			}

			if (rcdList.size() > 1) {
				result.setAuthenticated(false);	// 虽然知道你是个微信用户,但是我还是不知道你是哪位
				result.setSuccess(false);
				result.setMessage("微信用户"+openId+"关联了多个用户,无法确定唯一身份,请用其他方式登录或联系管理员处理账号.");
				return result;
			}

			SecUser secUser = userContext.getDAOGroup().getSecUserDAO().load(rcdList.first().getSecUser().getId(), EO);
			result.getLoginContext().getLoginTarget().setSecUser(secUser);
			result.setAuthenticated(true);
			result.setSuccess(true);
			return result.authenticated("微信用户验证成功");

		} catch (Exception e) {
			e.printStackTrace();
			return result.withError("微信认证失败:"+e.getMessage());
		}
	}

	protected boolean authenticateWithCode(RetailscmUserContext userContext, String code, LoginResult result) throws Exception{
		    String openId = null;
		    String unionId = null;
        String userSessionKey = null;
        boolean runSimLogin = false;
        if (!userContext.isProductEnvironment()){
          LoginParam loginParam = ((RetailscmBizUserContextImpl) userContext).getLoginParam();
          if (loginParam!=null && loginParam.isSimulation()){
            openId = String.valueOf(loginParam.getForceAuthenResult());
            userSessionKey = "simlogin_session_" +openId;
            runSimLogin = true;
          }
        }

        if (!runSimLogin) {
          WxMaJscode2SessionResult sessionInfo = wxService.jsCode2SessionInfo(code);
          openId = sessionInfo.getOpenid();
          unionId = sessionInfo.getUnionid();
          userSessionKey = sessionInfo.getSessionKey();
        }
        String appId = wxService.getWxMaConfig().getAppid();

        String cacheKey = this.getWehatSessionKeyCacheKey(userContext, appId, openId);
		userContext.putToCache(cacheKey, userSessionKey, (int) (1*DateTimeUtil.HOUR_IN_MS/DateTimeUtil.SECOND_IN_MS));

		Map<String, String> additionalInfo = MapUtil.put("openId", openId).put("sessionKey", userSessionKey)
				.put("appId", appId).put("unionId", unionId).into_map(String.class);
		result.getLoginContext().getLoginTarget().setAdditionalInfo(additionalInfo);
		result.setAuthenticated(true);
		if (runSimLogin){
          LoginParam loginParam = ((RetailscmBizUserContextImpl) userContext).getLoginParam();
          result.setAuthenticated(loginParam.isForceAuthenSuccess());
        }
        return result.isAuthenticated();
	}


	@Override
	public void bindWithSecUser(RetailscmUserContext userContext, LoginContext loginContext) throws Exception {
		SecUser secUser = loginContext.getLoginTarget().getSecUser();
		if (secUser == null) {
			throw new Exception("please call this only after secUser was found");
		}
		Map<String, String> additionalInfo = (Map<String, String>) loginContext.getLoginTarget().getAdditionalInfo();
		String openId = additionalInfo.get("openId");
		String unionId = additionalInfo.get("unionId");
		// String userSessionKey = additionalInfo.get("sessionKey");
		String appId = additionalInfo.get("appId");
		SmartList<WechatMiniappIdentity> rcdList = getIdentifyRecords(userContext, loginContext);
		if (rcdList != null && rcdList.stream().anyMatch(it -> it.getSecUser().getId().equals(secUser.getId()))) {
			// 要提防有重复的
			return;
		}
		WechatMiniappIdentity data =
            new WechatMiniappIdentity()
                .updateSecUser(secUser)
                .updateOpenId(openId)
                .updateAppId(appId)
                .updateLastLoginTime(userContext.now())
                .updateCreateTime(userContext.now())
                .updateUnionId(unionId);
        userContext
            .getManagerGroup()
            .getWechatMiniappIdentityManager()
            .internalSaveWechatMiniappIdentity(userContext, data, EO);
	}

	protected SmartList<WechatMiniappIdentity> getIdentifyRecords(RetailscmUserContext userContext,
			LoginContext loginContext) {
		Map<String, String> additionalInfo = (Map<String, String>) loginContext.getLoginTarget().getAdditionalInfo();
		String openId = additionalInfo.get("openId");
		// String userSessionKey = additionalInfo.get("sessionKey");
		String appId = additionalInfo.get("appId");
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatMiniappIdentity.APP_ID_PROPERTY, appId);
		key.put(WechatMiniappIdentity.OPEN_ID_PROPERTY, openId);
		SmartList<WechatMiniappIdentity> rcdList = userContext.getDAOGroup().getWechatMiniappIdentityDAO()
				.findWechatMiniappIdentityWithKey(key, EO);
		return rcdList;
	}

}
















