import _ from 'lodash';
import { View } from '@tarojs/components';
import { AtInputProps } from 'taro-ui/types/input';

import NumberInput from './ele-number-input';
import './styles.scss';

function EleMoney(props: AtInputProps) {
  const { value } = props;
  const theValue: any = _.isString(value) ? _.toNumber(value) : value;
  return (
    <View className='ele-money'>
      <View className='ele-money-icon'>￥</View>
      <NumberInput {...props} value={theValue} />
    </View>
  );
}

export default EleMoney;
