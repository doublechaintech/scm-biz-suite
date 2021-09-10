import NavigationService from '@/nice-router/navigation-service';
import { isNotEmpty } from '@/nice-router/nice-router-util';
import { useCountdown } from '@/service/use-service';
import { View } from '@tarojs/components';
import classNames from 'classnames';
import { AtInput } from 'taro-ui';
import GlobalToast from '@/nice-router/global-toast';
import { AtInputProps } from 'taro-ui/types/input';
import './styles.scss';

type EleMobileVerifyCodeProps = {
  maxCount?: number;
  className?: string;
  linkToUrl?: string;
  value?: string;
  onChange: Function;
  name: string;
} & Partial<AtInputProps>;

function EleMobileVerifyCode(props: EleMobileVerifyCodeProps) {
  const { maxCount = 60, value = '', className, linkToUrl = '', ...others } = props;

  const { second, counting, startCount } = useCountdown(maxCount);

  const sendCode = async () => {
    if (!/^1\d{10}$/.test(value)) {
      GlobalToast.show({
        text: '手机号码有误！',
      });
      return;
    }
    if (isNotEmpty(linkToUrl)) {
      startCount();
      console.log('props...', props);
      NavigationService.ajax(linkToUrl, { mobile: props.value });
    }
  };

  const tips = counting ? `${second}秒...` : '获取验证码';
  const rootClass = classNames('ele-vcode', className);
  const txtClass = classNames('ele-vcode-txt', { 'ele-vcode-txt-disabled': counting });
  return (
    <AtInput type='text' maxlength={6} {...others} className={rootClass}>
      <View className={txtClass} onClick={sendCode}>
        {tips}
      </View>
    </AtInput>
  );
}

export default EleMobileVerifyCode;
