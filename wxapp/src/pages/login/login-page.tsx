import { useEffect, useState } from 'react';
import ServerImage from '@/server-image/server-image';
import { ApiConfig } from '@/utils/config';
import { Text, View } from '@tarojs/components';
import Taro from '@tarojs/taro';
import NavigationService from '@/nice-router/navigation-service';
import Config from '@/nice-router/nice-router.config';
import { isWeapp } from '@/utils/index';

import loginLogo from '../../assets/login-logo.png';
import VCodeLoginForm from './vcode-login-from';
import PasswordLoginForm from './password-login-from';
import WechatLoginForm from './wechat-login-form';
import './login.scss';

export default function LoginPage() {
  const [wxLoginSuccess, setWxLoginSuccess] = useState(false);

  useEffect(() => {
    if (isWeapp()) {
      Taro.login({
        success: (res) => {
          console.log('doooooologin');
          NavigationService.ajax(
            ApiConfig.WxLogin,
            { code: res.code },
            {
              onSuccess: () => setWxLoginSuccess(true),
            }
          );
        },
      });
    }
  }, []);

  return (
    <View className='login-page'>
      <View className='login-page-header'>
        <View className='login-page-header-txt'>
          <Text>{Config.name}</Text>
        </View>
        <ServerImage className='login-page-header-logo' src={loginLogo} />
      </View>

      <View className='login-page-body'>
        <View className='login-form-brief'>WELCOME TO LOGIN</View>
        <View className='form-form-title'>欢迎登录</View>

        {Config.loginMode === 'wechat' && <WechatLoginForm />}
        {Config.loginMode === 'vcode' && <VCodeLoginForm disabled={!wxLoginSuccess} />}
        {Config.loginMode === 'password' && <PasswordLoginForm />}
      </View>
    </View>
  );
}
