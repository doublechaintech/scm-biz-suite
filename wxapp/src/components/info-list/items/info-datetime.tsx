import { formatTime } from '@/utils/index';
import { View } from '@tarojs/components';

import './styles.scss';

type InfoDatetimeProps = {
  value: any;
  format: string;
};

export default function InfoDatetime({ value, format }: InfoDatetimeProps) {
  const displayValue = formatTime(value, format);

  return <View className='info-datetime'>{displayValue}</View>;
}
