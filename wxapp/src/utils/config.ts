import { AppConfiguration } from '@/nice-router/nice-router.config';
import ViewMappingConfig from '@/utils/viewmapping.config';

const baseURL = 'https://demo.doublechaintech.com/yrzx/'; //后端服务地址

const ApiConfig: any = {
  FooterHome: 'wxappService/viewHomePage/',
  // FooterHome: 'pocService/startCRTaskDailyReport/',
  FooterMe: 'wxappService/viewMePage/',
  FooterServiceCenter: 'wxappService/viewServiceCenterPage/',
  UpdateProfileInfo: 'wxappService/updateProfileInfo/:name/:avatar/',
  UpdatePhoneNumber: 'wxappService/updatePhoneNumber/:encryptedData/:iv/',

  Login: 'wxappService/clientLogin/',
  WxLogin: 'wxappService/wxlogin/:code/',
  VerifyCode: 'wxappService/sendVerifyCode/:mobile/',
  OSSToken: 'wxappService/customGetOssToken/',
  Logout: 'wxappService/logout/',
};

const TheCustomizedProjectConfigurationDontUseItDirectly: Omit<AppConfiguration, 'start'> = {
  name: 'NiceRouter App Start',
  baseURL,
  version: 1,
  appType: 'mini-program',
  api: ApiConfig,
  backendRouterPageKeyBlackList: ['goBack/', 'goPrevious/'],
  backendRouterPageBlackList: ['NetworkException'],
  viewConfig: ViewMappingConfig,
  // loginMode: 'wechat',
  // loginMode: 'vcode', //包含绑定的微信登录
  loginMode: 'password',
};

console.log('***********   current env  ***********   ');
console.log('config.js is', TheCustomizedProjectConfigurationDontUseItDirectly);

export { ApiConfig, TheCustomizedProjectConfigurationDontUseItDirectly };
