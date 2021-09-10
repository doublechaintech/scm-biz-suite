import { formatTime } from '@/utils/index';
import { View } from '@tarojs/components';

import './styles.scss';

type DetailDatetimeProps = {
  value?: any;
  format?: string;
};

function DetailDatetime({ value, format }: DetailDatetimeProps) {
  const displayValue = formatTime(value, format);

  return <View className='detail-datetime'>{displayValue}</View>;
}

export default DetailDatetime;
