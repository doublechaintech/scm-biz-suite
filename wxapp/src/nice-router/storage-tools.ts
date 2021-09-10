/* eslint-disable prefer-promise-reject-errors */
import Taro from '@tarojs/taro';
import _ from 'lodash';
import { SHA1 } from 'crypto-es/lib/sha1.js';
import { log, parseJSON } from './nice-router-util';

const CACHE_PREFIX = '';
const CACHE_EXPIRATION_PREFIX = 'exp-';
const EXPIRY_UNITS = 1000; // seconds

const getKeys = _.memoize((key = '') => {
  const short = SHA1(key).toString();
  console.log('SHA1(key).toString()', short);
  const theKey = CACHE_PREFIX + short;
  const exprKey = CACHE_EXPIRATION_PREFIX + short;
  return { theKey, exprKey };
});

const currentTime = () => Math.floor(new Date().getTime() / EXPIRY_UNITS);

const StorageTools = {
  PageCachePrefix: 'page-cache-',

  get(key: string, defaultValue: any) {
    const { exprKey, theKey } = getKeys(key);
    const expiry = Taro.getStorageSync(exprKey);
    if (expiry && currentTime() >= parseInt(expiry, 10)) {
      Taro.removeStorageSync(exprKey);
      Taro.removeStorageSync(theKey);
      return;
    }
    const value = Taro.getStorageSync(theKey);
    return value ? parseJSON(value) : defaultValue;
  },

  /**
   *
   * Taro存储localStorage存的是对象 => {data:''}
   *
   * 所有H5中使用localStorage和Taro交互时候注意存取
   *
   * @param key
   * @param value
   * @param time unit: second
   *
   */
  set(key: string, value: any = '', time?: number) {
    const { exprKey, theKey } = getKeys(key);
    if (time) {
      const strTime = (currentTime() + time).toString();
      Taro.setStorageSync(exprKey, strTime);
      Taro.setStorageSync(theKey, JSON.stringify(value));
      return;
    }
    Taro.removeStorageSync(exprKey);
    Taro.setStorageSync(theKey, JSON.stringify(value));
  },

  remove(key: string) {
    const { exprKey, theKey } = getKeys(key);
    Taro.removeStorageSync(exprKey);
    Taro.removeStorageSync(theKey);
  },

  isExpired(key: string) {
    const { exprKey } = getKeys(key);
    const expiry = Taro.getStorageSync(exprKey);
    if (expiry > 0) {
      const expired = expiry && currentTime() >= parseInt(expiry, 10);
      log('是否过期？', 1, expired, currentTime());
      return expired;
    }
    return true;
  },
  flush() {
    const { keys } = Taro.getStorageInfoSync();
    keys.map((key) => {
      const remove = key.indexOf(CACHE_PREFIX) === 0 || key.indexOf(CACHE_EXPIRATION_PREFIX) === 0;
      if (remove) {
        // noinspection JSIgnoredPromiseFromCall
        Taro.removeStorage({ key });
      }
    });
  },

  // flushWithPrefix(prefix) {
  //   const { keys } = Taro.getStorageInfoSync()
  //   keys.map((key) => {
  //     const remove =
  //       key.indexOf(`${CACHE_PREFIX}${prefix}`) === 0 || key.indexOf(`${CACHE_EXPIRATION_PREFIX}${prefix}`) === 0
  //     if (remove) {
  //       // noinspection JSIgnoredPromiseFromCall
  //       Taro.removeStorage({ key })
  //     }
  //   })
  // },

  flushExpired() {
    const { keys } = Taro.getStorageInfoSync();
    keys.map((key) => {
      if (key.indexOf(CACHE_EXPIRATION_PREFIX) === 0) {
        const exprKey = key;
        const expiry = Taro.getStorageSync(exprKey);
        if (expiry && currentTime() >= parseInt(expiry, 10)) {
          const theKey = CACHE_PREFIX + key.replace(CACHE_EXPIRATION_PREFIX, '');
          Taro.removeStorageSync(exprKey);
          Taro.removeStorageSync(theKey);
        }
      }
    });
  },
};

// Always flush expired items on start time
StorageTools.flushExpired();

export default StorageTools;
