package com.doublechaintech.retailscm.wechatminiappidentity;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class WechatMiniappIdentityVersionChangedException
    extends WechatMiniappIdentityManagerException {
  private static final long serialVersionUID = 1L;

  public WechatMiniappIdentityVersionChangedException(String string) {
    super(string);
  }
}
