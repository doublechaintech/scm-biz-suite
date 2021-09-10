import _ from 'lodash';
import { isEmpty, isNotEmpty, LoadingType, log } from '../nice-router-util';
import StorageTools from '../storage-tools';
import HttpRequest, { HttpResponseProps } from './http-request';
import MockService from './mock-service';
// import TestData from '../../pages/mock-data/test-data';
import { BackendServiceSendProps } from '@/nice-router/request/reqeust';

// TestData.initial();
const EMPTY_PARAMETER_TOKEN = '+';

const isCacheable = (resp: HttpResponseProps) => {
  if (!_.isObject(resp)) {
    return false;
  }
  const { headers = {} } = resp;
  const xClass = headers['x-class'] || '';
  const xNavigationMethod = headers['x-navigation-method'] || '';
  if (xNavigationMethod === 'replace' || xClass.indexOf('LoginForm') > -1) {
    log(
      'the response will not cached, bc the xNavigationMethod is replace or xClass is LoginForm',
      xNavigationMethod,
      xClass
    );
    return false;
  }
  return true;
};

const replaceUrlPlaceholder = (
  uri: string = '',
  params: Record<string, any>
): {
  uri: string;
  params: Record<string, any>;
} => {
  let theParams = _.cloneDeep(params);
  let theUri = _.trim(uri);
  theUri = theUri.replace(/:[^:/ ]+/g, (token) => {
    const key = _.trim(token, ':');
    let value = _.get(params, key);
    if (isEmpty(value)) {
      value = EMPTY_PARAMETER_TOKEN;
    }
    _.unset(theParams, key);
    return value;
  });
  return { uri: theUri, params: theParams };
};

const removeEmptyValues = (params: Record<string, any> = {}) => {
  const result = {};
  _.forIn(params, (value, key) => {
    if (!_.isNil(value)) {
      result[key] = value;
    }
  });
  return result;
};

class BackendServiceClass {
  async send(action: BackendServiceSendProps) {
    const {
      method = 'get', // get,post,put 等http方法
      uri, // uri或者url
      params = {}, // 请求的参数
      headers = {}, // 请求header
      loading = LoadingType.None, //loading的处理方式
      asForm, // 请后台约定，如果是form提交的话，把body包装成一个json字符串放到body里面
      cache = 0,
    } = action || {};

    // 将url中的替代变量替换掉
    const { uri: actionUri, params: lastParams } = replaceUrlPlaceholder(uri, params);
    // 移除undefined，null的数据，不然daas接受处理有点小问题
    let data = removeEmptyValues(lastParams);
    if (asForm) {
      data = { formData: JSON.stringify(data) };
    }
    const options = {
      uri: actionUri,
      method,
      params: data,
      headers,
    };
    // // mock 数据处理
    const mockData = MockService.getMockResp(actionUri);
    if (mockData) {
      return mockData;
    }

    console.log('do request, then cache it', cache);
    if (cache > 0) {
      const resp = StorageTools.get(actionUri, '');
      if (isNotEmpty(resp)) {
        return resp;
      }
    }

    const resp = await HttpRequest.send(options, loading);
    if (cache > 0 && isCacheable(resp)) {
      console.log('success resp and then cache it', cache, 'seconds', resp);
      StorageTools.set(actionUri, resp, cache);
    }
    return resp;
  }
}

const BackendService = new BackendServiceClass();
export default BackendService;
