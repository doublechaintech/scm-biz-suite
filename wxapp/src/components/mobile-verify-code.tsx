import NavigationService from '@/nice-router/navigation-service';
import { noop } from '@/nice-router/nice-router-util';
import { useCountdown } from '@/service/use-service';
import { View } from '@tarojs/components';
import Taro from '@tarojs/taro';
import classNames from 'classnames';
import { AtInput } from 'taro-ui';

import './form/field/styles.scss';
import { ApiConfig } from '@/utils/config';

type MobileVerifyCodeProps = {
  onChange?: any;
  name: string;
  value?: string;
  placeholder?: string;
  className?: string;
  onSendCodeSuccess?: Function;
  maxCount?: number;
};

function MobileVerifyCode(props: MobileVerifyCodeProps) {
  const { second, counting, startCount } = useCountdown(props.maxCount);

  const { onChange, name, value = '', placeholder, className, onSendCodeSuccess = noop } = props;

  const sendCode = async () => {
    if (counting) {
      return;
    }
    if (!/^1\d{10}$/.test(value)) {
      await Taro.showToast({ title: '请输入正确的手机号', icon: 'none' });
      return;
    }
    startCount();
    NavigationService.ajax(ApiConfig.VerifyCode, { mobile: value }, { onSuccess: (resp) => onSendCodeSuccess(resp) });
  };

  const tips = counting ? `${second}秒...` : '验证码';
  const rootClass = classNames('ele-vcode', className);
  const txtClass = classNames('ele-vcode-txt', { 'ele-vcode-txt-disabled': counting });
  return (
    <AtInput
      name={name}
      border={false}
      type='phone'
      placeholder={placeholder}
      value={value}
      onChange={onChange}
      className={rootClass}
    >
      <View className={txtClass} onClick={sendCode}>
        {tips}
      </View>
    </AtInput>
  );
}

MobileVerifyCode.defaultProps = {
  name: '',
  placeholder: '请输入手机号码',
  onChange: noop,
  maxCount: 60,
};
export default MobileVerifyCode;
