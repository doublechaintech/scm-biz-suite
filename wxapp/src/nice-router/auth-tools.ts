import { isH5 } from '@/utils/index';
import jwtDecode from './jwt-decode';
import _ from 'lodash';
import { isNotEmpty, log } from './nice-router-util';
import StorageTools from './storage-tools';

const TOKEN = 'TOKEN';
const AUTH_INFO = 'AUTH_INFO';

const SAFETY_TIME = 1800; //预留半个小时过期（单位秒）

export enum AuthInfoSecurityStatus {
  ANONYMOUS,
  CERTIFICATE,
}

export type AuthInfoType = {
  envType?: string; //颁发token的环境
  exp: number; //过期时间
  securityStatus: AuthInfoSecurityStatus; // token的安全类型
  userId: string; //当前用户Id
  tags: string[]; //这个token的标签
};

const toAuthInfo = _.memoize((token: string): AuthInfoType => (isNotEmpty(token) ? jwtDecode(token) : {}));

async function saveTokenAsync(token: string) {
  StorageTools.set(TOKEN, token);
  log('saveToken', token);
  const authInfo: AuthInfoType = toAuthInfo(token);
  StorageTools.set(AUTH_INFO, authInfo);
  log('saveAuthInfo', authInfo);
  return authInfo;
}

/**
 * 是否是一个有效的登录token
 */
async function isLoginToken() {
  const authInfo = await getAuthInfoAsync();
  if (authInfo.securityStatus === AuthInfoSecurityStatus.CERTIFICATE && authInfo.exp > 0) {
    log('the token expTime is', authInfo.exp, 'will exp ', authInfo.exp - Date.now() / 1000, 'latter');
    return authInfo.exp - Date.now() / 1000 > SAFETY_TIME;
  }
  return false;
}

async function getAuthInfoAsync(): Promise<AuthInfoType> {
  const authInfo = StorageTools.get(AUTH_INFO, {});
  return authInfo as AuthInfoType;
}

async function getTokenAsync() {
  return StorageTools.get(TOKEN, '');
}

async function logout() {
  StorageTools.remove(TOKEN);
  StorageTools.remove(AUTH_INFO);
  // StorageTools.remove(COOKIES)
}

const AuthTools = {
  getTokenAsync,
  getAuthInfoAsync,
  saveTokenAsync,
  logout,
  // syncToken,
  isLoginToken,
  toAuthInfo,
};

//兼容RN里嵌入H5时候的localStorage同步
// @ts-ignore
isH5() && (window.saveTokenAsync = saveTokenAsync);

export default AuthTools;
