import MobileVerifyCode from '@/components/mobile-verify-code';
import EleInput from '@/components/form/field/ele-input';
import { View } from '@tarojs/components';
import { useState } from 'react';
import _ from 'lodash';
import NavigationService from '@/nice-router/navigation-service';
import { isNotEmpty } from '@/nice-router/nice-router-util';
import { useVisible } from '@/service/use-service';
import EleButton from '@/components/elements/ele-button';
import './login.scss';

export default function VCodeLoginForm(props) {
  const [mobile, setMobile] = useState();
  const [verifyCode, setVerifyCode] = useState<any>();
  const { visible, toggle } = useVisible(true);

  const { disabled } = props;

  const handleSubmit = () => {
    NavigationService.dispatch('app/login', {
      loginMethod: 'mobile_vcode',
      mobile,
      verifyCode,
    });
  };

  const handleSendCodeSuccess = (resp) => {
    const txt = _.get(resp, 'toast.text', '');
    const theCode = _.get(txt.match(/验证码(\d{6})/), 1);
    console.log('text', txt, theCode);
    if (isNotEmpty(theCode)) {
      setVerifyCode(theCode);
    }
  };

  const handleBindingWechatMobile = (e) => {
    if (disabled) {
      return;
    }
    const { encryptedData } = e.detail;
    console.log('e.detail', e.detail);
    if (isNotEmpty(encryptedData)) {
      NavigationService.dispatch('app/login', {
        ...e.detail,
        loginMethod: 'wechat_mobile',
      });
    }
  };

  if (visible) {
    return (
      <>
        <EleButton openType='getPhoneNumber' className='login-button' onGetPhoneNumber={handleBindingWechatMobile}>
          使用微信绑定的手机号
        </EleButton>
        <View className='login-form-fields-switch'>
          <EleButton mode='ghost' onClick={toggle}>
            其他手机号码
          </EleButton>
        </View>
      </>
    );
  }

  return (
    <>
      <View className='login-form-fields'>
        <MobileVerifyCode
          name='mobile'
          className='login-form-fields-input'
          placeholder='请输入手机号'
          value={mobile}
          onChange={setMobile}
          onSendCodeSuccess={handleSendCodeSuccess}
        />
        <EleInput
          name='verifyCode'
          className='login-form-fields-input,login-form-fields-vcode'
          placeholder='请输入验证码'
          type='number'
          value={verifyCode}
          onChange={setVerifyCode}
        />
      </View>
      <View className='login-form-fields-switch'>
        <EleButton mode='ghost' onClick={toggle}>
          使用微信绑定手机号
        </EleButton>
      </View>

      <EleButton className='login-button' onClick={handleSubmit}>
        登录
      </EleButton>
    </>
  );
}
