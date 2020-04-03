import { get, postForm, PREFIX, joinParameters, joinPostParameters } from '../axios/tools';

const login = (username, password) => {
  const url = `${PREFIX }secUserManager/login/username/password/`
  const requestParameters={username,password}
  return postForm({ url,requestParameters})
};

const home = () => {
  const url = `${PREFIX }secUserManager/home/`
  return get({ url})
};

const ChangePassword = ({ currentPassword, newPassword }) => {
 

  const url = `${PREFIX }secUserManager/changeCurUserPassword/currentPassword/newPassword/`
  const requestParameters={currentPassword,newPassword}
  return postForm({ url,requestParameters})

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

const LauncherService = { login, home,gotoApp, logout, checkOtherLogin, ChangePassword };
export default LauncherService;
