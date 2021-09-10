/* eslint-disable */
import AuthTools, { AuthInfoSecurityStatus, AuthInfoType } from '@/nice-router/auth-tools';
import NavigationService from '@/nice-router/navigation-service';
import { ApiConfig } from '@/utils/config';
import Taro from '@tarojs/taro';
import ActionUtil from '@/nice-router/action-util';

export type DoLoginProps = {
  loginMethod: 'wechat_work_app' | 'wechat_app' | 'mobile_vcode' | 'wechat_mobile' | 'account_password';
};

function wechatLogin(payload: DoLoginProps) {
  const { loginMethod } = payload || {};
  // @ts-ignore
  const wxObj = loginMethod === 'wechat_work_app' ? wx.qy : Taro;

  const doLogin = () => {
    wxObj.login({
      success: async (response) => {
        console.log('进行wx login, code is', response.code, payload);
        doRemoteLogin({ ...payload, code: response.code });
      },
    });
  };

  // noinspection JSIgnoredPromiseFromCall
  wxObj.checkSession({
    success: async () => {
      const isLoginToken = await AuthTools.isLoginToken();
      console.log('Is an validate login token??', isLoginToken);
      if (!isLoginToken) {
        doLogin();
      }
    },
    fail: () => {
      console.log('session失效，重新登录');
      doLogin();
    },
  });
}

function doRemoteLogin(payload) {
  const { options = {}, ...params } = payload;
  NavigationService.put(ApiConfig.Login, params, {
    statInPage: true,
    onSuccess: async (data, resp) => {
      if (options.onSuccess) {
        options.onSuccess(data);
      }

      const { authorization } = resp.headers;
      let authInfo: AuthInfoType = {} as AuthInfoType;
      console.log('wx login response, headers', resp.headers);
      if (authorization) {
        // noinspection JSIgnoredPromiseFromCall
        await AuthTools.saveTokenAsync(authorization);
        authInfo = AuthTools.toAuthInfo(authorization);
      }

      // 登录成功
      if (authInfo.securityStatus === AuthInfoSecurityStatus.CERTIFICATE || data.loginSuccess) {
        const callbackAction = { linkToUrl: data.callbackUrl, ...data };
        // 如果resp 不是Action或者不包含callbackUrl，则直接后退,
        if (!ActionUtil.isActionLike(callbackAction)) {
          await NavigationService.back();
          return;
        }

        // do login success callback
        await NavigationService.view(
          callbackAction,
          {},
          {
            navigationMethod: 'replace',
            ...options,
            onSuccess: (cbData, cbResp) => {
              console.log('success login an success do callback', cbData);
              if (cbResp.success) {
                NavigationService.back();
              }
            },
          },
        );
      }
    },
  });
}

export default {
  namespace: 'app',
  state: {
    callbackUrl: '',
    loginSuccess: false,
  },
  reducers: {},
  effects: {
    * login({ payload }: { payload: DoLoginProps }) {
      const { loginMethod } = payload || {};
      if (loginMethod === 'wechat_work_app' || loginMethod === 'wechat_app') {
        wechatLogin(payload);
        return;
      }
      console.log('登录。。。非微信登录');
      doRemoteLogin(payload);
    },

    * logout() {
      console.log('logout from app');
      yield AuthTools.logout();
    },
  },
  subscriptions: {},
};
