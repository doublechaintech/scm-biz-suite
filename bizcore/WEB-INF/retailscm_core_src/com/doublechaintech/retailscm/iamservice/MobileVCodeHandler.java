package com.doublechaintech.retailscm.iamservice;

import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.terapico.utils.*;

public class MobileVCodeHandler extends BaseIdentificationHandler {

  @Override
  public LoginResult authenticate(RetailscmUserContext userContext, LoginContext loginContext) {
    LoginResult result = new LoginResult();
    result.setLoginContext(loginContext);
    // 校验输入
    String inputVCode = loginContext.getLoginData().getVerifyCode();
    if (TextUtil.isBlank(inputVCode)) {
      return result.withError("请输入验证码");
    }
    String mobile = loginContext.getLoginData().getMobile();
    String cleanMobile = TextUtil.formatChinaMobile(mobile);
    if (cleanMobile == null) {
      return result.withError(
          "您输入的手机号"
              + (mobile == null
                  ? "(空)"
                  : (mobile + "(" + mobile.length() + "位)") + "不是有效的中国大陆手机号码"));
    }
    String cachedVCode = getCachedVCode(userContext, cleanMobile);
    if (TextUtil.isBlank(cachedVCode)) {
      return result.withError("请先获取验证码");
    }

    // 校验VCode
    if (!cachedVCode.equals(inputVCode)) {
      return result.withError("验证码错误,请重新输入");
    }

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
    return result.authenticated("手机号" + cleanMobile + "验证成功");
  }

  protected String getCachedVCode(RetailscmUserContext userContext, String cleanMobile) {
    String key = getVeriyCodeCacheKey(userContext, cleanMobile);
    return userContext.getCachedObject(key, String.class);
  }

  @Override
  public void bindWithSecUser(RetailscmUserContext userContext, LoginContext loginContext)
      throws Exception {
    SecUser secUser = loginContext.getLoginTarget().getSecUser();
    if (secUser == null) {
      throw new Exception("please call this only after secUser was found");
    }
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
}
