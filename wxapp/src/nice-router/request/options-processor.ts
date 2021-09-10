import Config from '@/nice-router/nice-router.config';
import _ from 'lodash';
import pathToRegexp from 'path-to-regexp';
import { isEmpty } from '../nice-router-util';

function getUrlAndParam({ uri, params }) {
  const processedParams = _.cloneDeep(params);
  let url = uri;

  let domain = '';
  if (url.match(/[a-zA-z]+:\/\/[^/]*/)) {
    [domain] = uri.match(/[a-zA-z]+:\/\/[^/]*/);
    url = url.slice(domain.length);
  }

  const toPath = pathToRegexp.compile(url);
  try {
    url = toPath(params);
  } catch (e) {
    console.warn('解析uri错误, 多半是带":"的替代变量为空了，请尽量避免在url中使用":"', e);
  }

  const match = pathToRegexp.parse(url);
  match.forEach((item) => {
    // @ts-ignore TODO 重构时发现没有 name属性，需要测试
    const { name: key } = item;
    if (item instanceof Object && key in processedParams) {
      delete processedParams[key];
    }
  });

  return {
    url: (isEmpty(domain) ? Config.baseURL : domain) + url,
    params: processedParams,
  };
}

const OptionsProcessor = (chain) => {
  const { requestParams } = chain;
  const { method = 'GET' } = requestParams;
  const { url, params } = getUrlAndParam(requestParams);
  const requestHeader = {
    ...requestParams.headers,
  };
  if (method.toLocaleLowerCase() === 'post') {
    requestHeader['Content-Type'] = 'application/x-www-form-urlencoded';
  }
  const nextParams = {
    ...requestParams,
    url,
    method: method.toLocaleLowerCase(),
    headers: requestHeader,
    data: params,
  };
  return chain.proceed(nextParams);
};

export default OptionsProcessor;
