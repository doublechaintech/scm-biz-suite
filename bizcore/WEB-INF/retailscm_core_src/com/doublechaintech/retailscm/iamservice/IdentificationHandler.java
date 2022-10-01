package com.doublechaintech.retailscm.iamservice;

import com.doublechaintech.retailscm.RetailscmUserContext;

public interface IdentificationHandler {

  /** 完成认证 */
  LoginResult authenticate(RetailscmUserContext userContext, LoginContext loginContext);
  /** 绑定用户 */
  void bindWithSecUser(RetailscmUserContext userContext, LoginContext loginContext)
      throws Exception;
}
