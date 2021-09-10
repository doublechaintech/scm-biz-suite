import { isH5 } from '@/utils/index';
import _ from 'lodash';

import Taro, { Current } from '@tarojs/taro';
import ActionUtil from './action-util';

import localCacheService from './local-cache-service';
import { ActionLike } from './nice-router-types';
import { isEmpty, isNotEmpty, LoadingType, log, noop } from './nice-router-util';
import { Store } from 'redux';
import { RouterPayload } from '@/nice-router/nice-router.model';
import { H5PageProps } from '@/nice-router/h5-page';

//  push='navigateTo'
//  replace='redirectTo'
//  back='navigateBack'
//  switchType='switchTab'
//  reLaunch='reLaunch';
export type NavigationMethodType = 'push' | 'replace' | 'back' | 'reLaunch' | 'switchTab';
const NavigationMethodMap = {
  push: 'navigateTo',
  replace: 'redirectTo',
  back: 'navigateBack',
  switchType: 'switchTab',
  reLaunch: 'reLaunch',
};

// 约定：pagePath 就是定义在app.config中的页面名称或者路径, 不再使用pageName, 沿用Taro叫法
// 约定：uri或者url就是：协议 + pathPath + 参数，不再使用path之类

type NavigationOptionType = {
  delayCallBack?: boolean;
} & RouterPayload;

type PageHistoryType = {
  pagePath: string;
  callback?: (data: Record<string, any>) => void; //后退时候传递参数的函数
};

type RouteFunction = (
  action: string | ActionLike | object,
  params?: Record<string, any>,
  options?: NavigationOptionType
) => Promise<any> | null;

// Local page
const NICE_ROUTER_LOCAL_PROTOCOL = 'page://';
const PAGE_LEVEL_LIMIT = 10;

//判断是否是本地页面跳转协议，例如 page:///pages/biz/listof-test-page
const isLocalPage = (uri = '') => uri.trim().startsWith(NICE_ROUTER_LOCAL_PROTOCOL);
//移除首尾空格和自定义协议page://
const trimUri = _.memoize((uri = '') => _.replace(_.trim(uri), NICE_ROUTER_LOCAL_PROTOCOL, ''));
const isH5Page = _.memoize((uri = '') =>
  uri
    .trim()
    .toLowerCase()
    .startsWith('http')
);

/**
 * 将uri转换为taro页面和参数
 * @param uri string
 * @return pathname: page在config中的名字，以/开头
 *         params: 参数map
 */
const parseUri = (uri: string): { pagePath: string; params: Record<string, string> } => {
  const url = trimUri(uri);
  const urlData = url.split('?');
  let params = {};
  if (isNotEmpty(urlData)) {
    const strAry = _.split(urlData[1], '&').map((i) => i.split('='));
    params = _.fromPairs(strAry);
  }
  const page = urlData[0];
  const pagePath = !page.startsWith('/') ? `/${page}` : page;
  return { pagePath, params };
};

/**
 * 将页面和参数转化Taro的本地页面跳转URI
 *
 * @param uri 可能带有协议和？参数
 * @param params
 *
 * @return 带有？参数
 */
function toTaroUrl(uri: string, params: Record<string, any>): string {
  const url = trimUri(uri);
  if (isEmpty(url)) {
    return '';
  }
  const postFix = _.keys(params)
    .map((key) => key + '=' + params[key])
    .join('&');
  const connectChart = uri.includes('?') ? '&' : '?';
  return url + connectChart + postFix;
}

const isFooterTabPage = _.memoize((pagePath = '') => {
  if (isEmpty(pagePath)) {
    return false;
  }
  // @ts-ignore
  const taroAppConfig: Taro.AppConfig = window?.__taroAppConfig;
  const list = taroAppConfig?.tabBar?.list || [];
  return list.some((it) => pagePath?.startsWith(it.pagePath));
});

/**
 * 转换 method 到Taro的方法
 * @param method Taro.XXX方法，默认是navigateTo
 *  @param pagePath 页面名称，config中配置的
 */
const _getNavigationMethod = (method: NavigationMethodType = 'push', pagePath?: string): Function => {
  if (isFooterTabPage(pagePath)) {
    return Taro.switchTab;
  }
  const theName = _.get(NavigationMethodMap, method, 'navigateTo');
  let theFunction = Taro[theName] || Taro.navigateTo;
  if (theFunction === Taro.navigateTo && Taro.getCurrentPages().length === PAGE_LEVEL_LIMIT) {
    console.warn('currentPages method is navigateTo，but the page stack is full, change it to redirect');
    return Taro.redirectTo;
  }
  return theFunction;
};

class NavigationServiceClass {
  _container: Store = {} as Store; // eslint-disable-line
  pageHistory: Record<string, PageHistoryType>; // 记得清空这个玩意，小心内存泄露

  get container() {
    return this._container || {};
  }

  set container(container: Store) {
    if (!container) {
      return;
    }
    this._container = container;
    this.clearHistory();
  }

  private clearHistory() {
    this.pageHistory = {};
  }

  /**
   * redux dispatch
   * @param actionType redux action name
   * @param params the parameters key-value map
   */
  dispatch(actionType: string, params?: Record<string, any>): void {
    const { dispatch = noop } = this.container || {};
    dispatch({ type: actionType, payload: params });
  }

  /**
   *
   *回退信息，
   *
   * @param data 后退时候，回传的数据对象
   * @param delta 后退步数，默认为1
   */
  back(data: Record<string, any> = {}, delta: number = 1) {
    if (Taro.getCurrentPages().length === 1) {
      console.log('页面栈只剩一个了，不能后退');
      return;
    }
    const key: string = Current?.router?.path || '';
    return new Promise((resolve, reject) => {
      Taro.navigateBack({ delta })
        .then(() => {
          const { callback } = this.pageHistory[key] || {};
          if (callback) {
            callback(data);
            _.omit(this.pageHistory, key);
          }
          resolve(null);
        })
        .catch((err) => reject(err));
    });
  }

  /**
   *
   * @param routeName
   * @param params
   * @param options
   * @returns {Promise<any>}
   */
  navigate(routeName: string, params: Record<string, any> = {}, options?: NavigationOptionType): Promise<any> {
    return new Promise((resolve, reject) => {
      if (isEmpty(routeName)) {
        resolve && resolve(null);
        return;
      }
      const url = toTaroUrl(routeName, params);
      const { pagePath } = parseUri(url);
      const navigationMethod = _getNavigationMethod(options?.navigationMethod, pagePath);
      navigationMethod({ url })
        .then(() => {
          // 把resolve存起来，主动调用 back的时候再调用
          const resolveShouldCallWhenPageGoBack = _.get(options, 'delayCallBack', false);
          if (!resolveShouldCallWhenPageGoBack) {
            resolve && resolve(null);
            return;
          }
          //call back delay
          this.pageHistory[pagePath] = {
            pagePath,
            callback: resolve,
          };
        })
        .catch((err) => {
          const { errMsg = '' } = err;
          if (errMsg.indexOf('a tabbar page')) {
            Taro.switchTab({ url }).then(() => {
              this.clearHistory();
              if (resolve) {
                resolve(null);
              }
            });
            return;
          }
          log(`Taro navigation get failed`, err);
          reject(err);
        });
    });
  }

  put: RouteFunction = (action, params, options) => {
    return this.routeTo(action, params, {
      ...options,
      method: 'put',
    });
  };

  view: RouteFunction = (action, params, options) => {
    return this.routeTo(action, params, options);
  };

  // refreshPage: RouteFunction = (action, params, options) => {
  //   return this.routeTo(action, params, {
  //     loading: LoadingType.None,
  //     statInPage: true,
  //     dataRefresh: true,
  //     ...(options || {}),
  //   });
  // };

  ajax: RouteFunction = (action, params, options) => {
    return this.routeTo(action, params, {
      loading: LoadingType.None,
      statInPage: true,
      ...(options || {}),
    });
  };

  post: RouteFunction = (action, params, options) => {
    return this.routeTo(action, params, {
      ...(options || {}),
      method: 'post',
    });
  };

  routeTo: RouteFunction = async (theAction, theParams, theOptions) => {
    const action = ActionUtil.trans2Action({
      action: theAction,
      params: theParams,
      ...theOptions,
    });
    const { linkToUrl = '', cache = false, params, statInPage } = action;
    if (isEmpty(linkToUrl)) {
      console.log('THE ACTION linkToUrl IS EMPTY');
      return;
    }

    // action上带有属性，confirmContent, 触发先confirm再执行相关动作
    const confirmContent = ActionUtil.getConfirmContent(action);
    if (isNotEmpty(confirmContent)) {
      const confirmResp = await Taro.showModal({
        title: action.title,
        content: confirmContent,
      });
      if (!confirmResp.confirm) {
        return;
      }
    }

    // 1, 前端页面跳转, page:///pages/home/home-page?type=qa 或跳转到HomePage的screen
    if (!statInPage && isLocalPage(linkToUrl)) {
      const { params: queryParams, pagePath } = parseUri(linkToUrl);
      return this.navigate(pagePath, { ...params, ...queryParams });
    }

    // 2, H5跳转：目标页面是Http页面，小程序中需要跳转到webview
    if (!statInPage && isH5Page(linkToUrl)) {
      let h5PageTarget = linkToUrl;
      const h5Param: H5PageProps = {} as H5PageProps;
      if (isH5()) {
        console.warn(
          '兼容在H5中使用了带schema的linkToUrl，不推荐，H5代码应该只关心自己，不应该带Schema, 除非是不同业务域名的跳转'
        );
        // @ts-ignore
        window.location = linkToUrl;
        return;
      }
      h5PageTarget = '/nice-router/h5-page';
      h5Param.uri = linkToUrl;
      return this.navigate(h5PageTarget, h5Param);
    }

    // 3, 后端路由, 获取后端路由缓存
    const cachedPage = localCacheService.getCachedPage(linkToUrl || '');
    log('go to cached page first', cachedPage);
    // 如果缓存存在，做页面跳转
    if (cachedPage) {
      // this.navigate(cachedPage)
      // TODO
      log('need CACHE the DATA', cache);
      // if (cache) {
      //   return
      // }
    }
    // 发送请求
    this.dispatch('niceRouter/route', action);
  };

  // async reset(routeName, params) {
  //   await Taro.navigateBack({
  //     delta: 20
  //   });
  //   await this.navigate(routeName, params);
  // }
}

const NavigationService = new NavigationServiceClass();

export default NavigationService;
