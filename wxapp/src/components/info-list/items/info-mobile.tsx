import { View } from '@tarojs/components';
import Taro from '@tarojs/taro';
import { getExtMode } from '@/nice-router/nice-router-util';
import './styles.scss';

type InfoMobileProps = {
  value: string;
  className?: string;
};

function InfoMobile({ value = '', className }: InfoMobileProps) {
  const onClick = () => {
    Taro.makePhoneCall({ phoneNumber: value });
  };
  const rootClass = getExtMode().classNames('info-mobile', className);
  return (
    <View className={rootClass} onClick={onClick}>
      {value}
    </View>
  );
}

export default InfoMobile;
