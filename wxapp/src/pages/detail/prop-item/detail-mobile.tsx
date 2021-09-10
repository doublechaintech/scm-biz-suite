import { View } from '@tarojs/components';
import Taro from '@tarojs/taro';
import './styles.scss';

function DetailMobile({ value = '' }) {
  const onClick = () => {
    Taro.makePhoneCall({ phoneNumber: value });
  };
  return (
    <View className='detail-mobile' onClick={onClick}>
      {value}
    </View>
  );
}

export default DetailMobile;
