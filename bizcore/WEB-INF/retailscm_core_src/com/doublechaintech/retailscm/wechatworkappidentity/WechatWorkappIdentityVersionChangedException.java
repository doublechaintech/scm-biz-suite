package com.doublechaintech.retailscm.wechatworkappidentity;

import com.doublechaintech.retailscm.EntityNotFoundException;

public class WechatWorkappIdentityVersionChangedException
    extends WechatWorkappIdentityManagerException {
  private static final long serialVersionUID = 1L;

  public WechatWorkappIdentityVersionChangedException(String string) {
    super(string);
  }
}
