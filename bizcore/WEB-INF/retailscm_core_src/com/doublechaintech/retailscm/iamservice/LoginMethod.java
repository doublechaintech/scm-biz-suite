package com.doublechaintech.retailscm.iamservice;

public enum LoginMethod {
  ID_4_DEBUG, // 调试环境下才提供的 ID 直接登录
  MOBILE, // 手机号+验证码
  PASSWORD, // ID/email/手机号 + 密码
  WECHAT_MINIPROGRAM, // 微信小程序认证
  WECHAT_MOBILE, // 微信小程序获取手机号快速认证
  WECHAT_WORK_MINIPROGRAM, // 企业微信小程序认证
  WECHAT_WEB, // 微信网页认证
  WECHAT_QR_CODE, // 微信扫一扫认证
}
