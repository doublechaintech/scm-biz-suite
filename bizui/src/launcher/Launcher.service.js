import { get, postForm, PREFIX, joinParameters, joinPostParameters } from '../axios/tools';

const login = (username, password) => {
  return get({
    url: PREFIX + `secUserManager/login/${username}/${password}/`,
  });
};

const ChangePassword = ({ currentPassword, newPassword }) => {
  return get({
    url: PREFIX + `secUserManager/changeCurUserPassword/${currentPassword}/${newPassword}/`,
  });
};

const checkOtherLogin = () => {
  return get({
    url: PREFIX + `secUserManager/checkOtherLogin/`,
  });
};

const logout = (username, password) => {
  return get({
    url: PREFIX + `secUserManager/showlogin/`,
  });
};

const gotoApp = appId => {
  return get({
    url: PREFIX + `secUserManager/selectApp/${appId}/`,
  });
};

const LauncherService = { login, gotoApp, logout, checkOtherLogin, ChangePassword };
export default LauncherService;
