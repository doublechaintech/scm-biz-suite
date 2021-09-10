import NavigationService from '@/nice-router/navigation-service';
import EleButton from '@/components/elements/ele-button';

import './login.scss';

export default function WechatLoginForm() {
  const handleSubmit = () => {
    // @ts-ignore
    let loginMethod = wx.qy ? 'wechat_work_app' : 'wechat_app';
    NavigationService.dispatch('app/login', {
      loginMethod: loginMethod,
    });
  };
  return (
    <EleButton className='login-button' onClick={handleSubmit}>
      微信登录
    </EleButton>
  );
}
