import EleInput from '@/components/form/field/ele-input';
import { View } from '@tarojs/components';
import { useState } from 'react';

import NavigationService from '@/nice-router/navigation-service';
import EleButton from '@/components/elements/ele-button';

import './login.scss';

export default function PasswordForm() {
  const [login, setLogin] = useState<any>();
  const [password, setPassword] = useState<any>();

  const handleSubmit = () => {
    NavigationService.dispatch('app/login', {
      loginMethod: 'account_password',
      login,
      password,
    });
  };

  return (
    <>
      <View className='login-form-fields'>
        <EleInput
          className='login-form-fields-input'
          placeholder='请输入用户名'
          name='login'
          value={login}
          onChange={setLogin}
        />
        <EleInput
          className='login-form-fields-input'
          placeholder='请输入密码'
          name='password'
          type='password'
          value={password}
          onChange={setPassword}
        />
      </View>
      <EleButton className='login-button' onClick={handleSubmit}>
        登录
      </EleButton>
    </>
  );
}
