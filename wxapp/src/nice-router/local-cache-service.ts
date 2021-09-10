import Config from './nice-router.config';
import { isEmpty, isNotEmpty, log } from './nice-router-util';
import StorageTools from './storage-tools';

function getPageKeyByUri(uri = '') {
  let key = uri;
  //TODO 小程序上，应该有点问题，暂时没有测试
  key = `${StorageTools.PageCachePrefix}${key}`;
  return key;
}

function inBlackList(key, page) {
  const result = Config.backendRouterPageBlackList.includes(page) || Config.backendRouterPageKeyBlackList.includes(key);
  log('key and page is in black list?', result);
  return result;
}

// 后端路由缓存
const saveBackendRouter = async (uri: string, page: string) => {
  const key = getPageKeyByUri(uri);
  log('start save backend router to cache, uri:', uri, ', page:', page);
  if (!inBlackList(key, page)) {
    // 缓存前端路由3天
    if (key.length > 0) {
      StorageTools.set(key, page, 3600 * 24 * 3);
    }
  }
};

// 后端路由缓存
const getCachedPage = (uri: string) => {
  const key = getPageKeyByUri(uri);
  return StorageTools.get(key, null);
};

// 查看 Form是否被提交成功
const isCachedForm = async (url: string, params: Record<string, any> = {}) => {
  if (isEmpty(params)) {
    return false;
  }
  const content = JSON.stringify(params);
  const key = `${url}_${content}`;
  return !StorageTools.isExpired(key);
};
// form 提交内容 缓存 2 秒
const cacheForm = async (url: string, params: Record<string, any> = {}) => {
  if (isNotEmpty(params)) {
    const content = JSON.stringify(params);
    const key = `${url}_${content}`;
    StorageTools.set(key, params, 2);
  }
};
const LocalCacheService = {
  saveBackendRouter,
  cacheForm,
  isCachedForm,
  getCachedPage,
  ...StorageTools,
};

export default LocalCacheService;
